package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Decompressor;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.MessageFramer;
import javax.annotation.Nullable;

public abstract class AbstractServerStream extends AbstractStream implements ServerStream, MessageFramer.Sink {
    private final MessageFramer framer;
    private boolean headersSent;
    private boolean outboundClosed;
    private final StatsTraceContext statsTraceCtx;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    protected interface Sink {
        void cancel(Status status);

        void writeFrame(@Nullable WritableBuffer writableBuffer, boolean z, int i2);

        void writeHeaders(Metadata metadata);

        void writeTrailers(Metadata metadata, boolean z, Status status);
    }

    protected abstract Sink abstractServerStreamSink();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractStream
    public abstract TransportState transportState();

    protected AbstractServerStream(WritableBufferAllocator bufferAllocator, StatsTraceContext statsTraceCtx) {
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceCtx, "statsTraceCtx");
        this.framer = new MessageFramer(this, bufferAllocator, statsTraceCtx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractStream
    public final MessageFramer framer() {
        return this.framer;
    }

    @Override // io.grpc.internal.ServerStream
    public final void writeHeaders(Metadata headers) {
        Preconditions.checkNotNull(headers, "headers");
        this.headersSent = true;
        abstractServerStreamSink().writeHeaders(headers);
    }

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer frame, boolean endOfStream, boolean flush, int numMessages) {
        abstractServerStreamSink().writeFrame(frame, endOfStream ? false : flush, numMessages);
    }

    @Override // io.grpc.internal.ServerStream
    public final void close(Status status, Metadata trailers) {
        Preconditions.checkNotNull(status, "status");
        Preconditions.checkNotNull(trailers, GrpcUtil.TE_TRAILERS);
        if (!this.outboundClosed) {
            this.outboundClosed = true;
            endOfMessages();
            addStatusToTrailers(trailers, status);
            transportState().setClosedStatus(status);
            abstractServerStreamSink().writeTrailers(trailers, this.headersSent, status);
        }
    }

    private void addStatusToTrailers(Metadata trailers, Status status) {
        trailers.discardAll(InternalStatus.CODE_KEY);
        trailers.discardAll(InternalStatus.MESSAGE_KEY);
        trailers.put(InternalStatus.CODE_KEY, status);
        if (status.getDescription() != null) {
            trailers.put(InternalStatus.MESSAGE_KEY, status.getDescription());
        }
    }

    @Override // io.grpc.internal.ServerStream
    public final void cancel(Status status) {
        abstractServerStreamSink().cancel(status);
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.internal.ServerStream
    public final void setDecompressor(Decompressor decompressor) {
        transportState().setDecompressor((Decompressor) Preconditions.checkNotNull(decompressor, "decompressor"));
    }

    @Override // io.grpc.internal.ServerStream
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ServerStream
    public String getAuthority() {
        return null;
    }

    @Override // io.grpc.internal.ServerStream
    public final void setListener(ServerStreamListener serverStreamListener) {
        transportState().setListener(serverStreamListener);
    }

    @Override // io.grpc.internal.ServerStream
    public StatsTraceContext statsTraceContext() {
        return this.statsTraceCtx;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    protected static abstract class TransportState extends AbstractStream.TransportState {
        @Nullable
        private Status closedStatus;
        private boolean deframerClosed;
        private Runnable deframerClosedTask;
        private boolean endOfStream;
        private boolean immediateCloseRequested;
        private ServerStreamListener listener;
        private boolean listenerClosed;
        private final StatsTraceContext statsTraceCtx;

        protected TransportState(int maxMessageSize, StatsTraceContext statsTraceCtx, TransportTracer transportTracer) {
            super(maxMessageSize, statsTraceCtx, (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer"));
            this.endOfStream = false;
            this.deframerClosed = false;
            this.immediateCloseRequested = false;
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceCtx, "statsTraceCtx");
        }

        public final void setListener(ServerStreamListener listener) {
            Preconditions.checkState(this.listener == null, "setListener should be called only once");
            this.listener = (ServerStreamListener) Preconditions.checkNotNull(listener, "listener");
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public final void onStreamAllocated() {
            super.onStreamAllocated();
            getTransportTracer().reportRemoteStreamStarted();
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean hasPartialMessage) {
            this.deframerClosed = true;
            if (this.endOfStream) {
                if (!this.immediateCloseRequested && hasPartialMessage) {
                    deframeFailed(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame").asRuntimeException());
                    this.deframerClosedTask = null;
                    return;
                }
                this.listener.halfClosed();
            }
            if (this.deframerClosedTask != null) {
                this.deframerClosedTask.run();
                this.deframerClosedTask = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.AbstractStream.TransportState
        public ServerStreamListener listener() {
            return this.listener;
        }

        public void inboundDataReceived(ReadableBuffer frame, boolean endOfStream) {
            Preconditions.checkState(!this.endOfStream, "Past end of stream");
            deframe(frame);
            if (endOfStream) {
                this.endOfStream = true;
                closeDeframer(false);
            }
        }

        public final void transportReportStatus(final Status status) {
            Preconditions.checkArgument(!status.isOk(), "status must not be OK");
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(status);
                return;
            }
            this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.1
                @Override // java.lang.Runnable
                public void run() {
                    TransportState.this.closeListener(status);
                }
            };
            this.immediateCloseRequested = true;
            closeDeframer(true);
        }

        public void complete() {
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(Status.OK);
                return;
            }
            this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.2
                @Override // java.lang.Runnable
                public void run() {
                    TransportState.this.closeListener(Status.OK);
                }
            };
            this.immediateCloseRequested = true;
            closeDeframer(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeListener(Status newStatus) {
            Preconditions.checkState((newStatus.isOk() && this.closedStatus == null) ? false : true);
            if (!this.listenerClosed) {
                if (!newStatus.isOk()) {
                    this.statsTraceCtx.streamClosed(newStatus);
                    getTransportTracer().reportStreamClosed(false);
                } else {
                    this.statsTraceCtx.streamClosed(this.closedStatus);
                    getTransportTracer().reportStreamClosed(this.closedStatus.isOk());
                }
                this.listenerClosed = true;
                onStreamDeallocated();
                listener().closed(newStatus);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClosedStatus(Status closeStatus) {
            Preconditions.checkState(this.closedStatus == null, "closedStatus can only be set once");
            this.closedStatus = closeStatus;
        }
    }
}