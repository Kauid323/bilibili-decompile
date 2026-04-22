package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.MessageFramer;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public abstract class AbstractClientStream extends AbstractStream implements ClientStream, MessageFramer.Sink {
    private static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());
    private volatile boolean cancelled;
    private final Framer framer;
    private Metadata headers;
    private boolean shouldBeCountedForInUse;
    private final TransportTracer transportTracer;
    private boolean useGet;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    protected interface Sink {
        void cancel(Status status);

        void writeFrame(@Nullable WritableBuffer writableBuffer, boolean z, boolean z2, int i2);

        void writeHeaders(Metadata metadata, @Nullable byte[] bArr);
    }

    protected abstract Sink abstractClientStreamSink();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractStream
    public abstract TransportState transportState();

    protected AbstractClientStream(WritableBufferAllocator bufferAllocator, StatsTraceContext statsTraceCtx, TransportTracer transportTracer, Metadata headers, CallOptions callOptions, boolean useGet) {
        Preconditions.checkNotNull(headers, "headers");
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
        this.shouldBeCountedForInUse = GrpcUtil.shouldBeCountedForInUse(callOptions);
        this.useGet = useGet;
        if (!useGet) {
            this.framer = new MessageFramer(this, bufferAllocator, statsTraceCtx);
            this.headers = headers;
            return;
        }
        this.framer = new GetFramer(headers, statsTraceCtx);
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(Deadline deadline) {
        this.headers.discardAll(GrpcUtil.TIMEOUT_KEY);
        long effectiveTimeout = Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS));
        this.headers.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(effectiveTimeout));
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(int maxSize) {
        this.framer.setMaxOutboundMessageSize(maxSize);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(int maxSize) {
        transportState().setMaxInboundMessageSize(maxSize);
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(boolean fullStreamDecompression) {
        transportState().setFullStreamDecompression(fullStreamDecompression);
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        transportState().setDecompressorRegistry(decompressorRegistry);
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener listener) {
        transportState().setListener(listener);
        if (!this.useGet) {
            abstractClientStreamSink().writeHeaders(this.headers, null);
            this.headers = null;
        }
    }

    @Override // io.grpc.internal.AbstractStream
    protected final Framer framer() {
        return this.framer;
    }

    public final boolean shouldBeCountedForInUse() {
        return this.shouldBeCountedForInUse;
    }

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer frame, boolean endOfStream, boolean flush, int numMessages) {
        Preconditions.checkArgument(frame != null || endOfStream, "null frame before EOS");
        abstractClientStreamSink().writeFrame(frame, endOfStream, flush, numMessages);
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        if (transportState().isOutboundClosed()) {
            return;
        }
        transportState().setOutboundClosed();
        endOfMessages();
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status reason) {
        Preconditions.checkArgument(!reason.isOk(), "Should not cancel with OK status");
        this.cancelled = true;
        abstractClientStreamSink().cancel(reason);
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return super.isReady() && !this.cancelled;
    }

    @Override // io.grpc.internal.ClientStream
    public final void appendTimeoutInsight(InsightBuilder insight) {
        Attributes attrs = getAttributes();
        insight.appendKeyValue("remote_addr", attrs.get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR));
    }

    protected TransportTracer getTransportTracer() {
        return this.transportTracer;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    protected static abstract class TransportState extends AbstractStream.TransportState {
        private DecompressorRegistry decompressorRegistry;
        private boolean deframerClosed;
        private Runnable deframerClosedTask;
        private boolean fullStreamDecompression;
        private ClientStreamListener listener;
        private boolean listenerClosed;
        private volatile boolean outboundClosed;
        private final StatsTraceContext statsTraceCtx;
        private boolean statusReported;
        private boolean statusReportedIsOk;

        /* JADX INFO: Access modifiers changed from: protected */
        public TransportState(int maxMessageSize, StatsTraceContext statsTraceCtx, TransportTracer transportTracer) {
            super(maxMessageSize, statsTraceCtx, transportTracer);
            this.decompressorRegistry = DecompressorRegistry.getDefaultInstance();
            this.deframerClosed = false;
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceCtx, "statsTraceCtx");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFullStreamDecompression(boolean fullStreamDecompression) {
            this.fullStreamDecompression = fullStreamDecompression;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
            Preconditions.checkState(this.listener == null, "Already called start");
            this.decompressorRegistry = (DecompressorRegistry) Preconditions.checkNotNull(decompressorRegistry, "decompressorRegistry");
        }

        public final void setListener(ClientStreamListener listener) {
            Preconditions.checkState(this.listener == null, "Already called setListener");
            this.listener = (ClientStreamListener) Preconditions.checkNotNull(listener, "listener");
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean hasPartialMessage) {
            Preconditions.checkState(this.statusReported, "status should have been reported on deframer closed");
            this.deframerClosed = true;
            if (this.statusReportedIsOk && hasPartialMessage) {
                transportReportStatus(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame"), true, new Metadata());
            }
            if (this.deframerClosedTask != null) {
                this.deframerClosedTask.run();
                this.deframerClosedTask = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.AbstractStream.TransportState
        public final ClientStreamListener listener() {
            return this.listener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setOutboundClosed() {
            this.outboundClosed = true;
        }

        protected final boolean isOutboundClosed() {
            return this.outboundClosed;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void inboundHeadersReceived(Metadata headers) {
            Preconditions.checkState(!this.statusReported, "Received headers on closed stream");
            this.statsTraceCtx.clientInboundHeaders();
            boolean compressedStream = false;
            String streamEncoding = (String) headers.get(GrpcUtil.CONTENT_ENCODING_KEY);
            if (this.fullStreamDecompression && streamEncoding != null) {
                if (streamEncoding.equalsIgnoreCase("gzip")) {
                    setFullStreamDecompressor(new GzipInflatingBuffer());
                    compressedStream = true;
                } else if (!streamEncoding.equalsIgnoreCase("identity")) {
                    deframeFailed(Status.INTERNAL.withDescription(String.format("Can't find full stream decompressor for %s", streamEncoding)).asRuntimeException());
                    return;
                }
            }
            String messageEncoding = (String) headers.get(GrpcUtil.MESSAGE_ENCODING_KEY);
            if (messageEncoding != null) {
                Decompressor decompressor = this.decompressorRegistry.lookupDecompressor(messageEncoding);
                if (decompressor == null) {
                    deframeFailed(Status.INTERNAL.withDescription(String.format("Can't find decompressor for %s", messageEncoding)).asRuntimeException());
                    return;
                } else if (decompressor != Codec.Identity.NONE) {
                    if (compressedStream) {
                        deframeFailed(Status.INTERNAL.withDescription(String.format("Full stream and gRPC message encoding cannot both be set", new Object[0])).asRuntimeException());
                        return;
                    }
                    setDecompressor(decompressor);
                }
            }
            listener().headersRead(headers);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void inboundDataReceived(ReadableBuffer frame) {
            Preconditions.checkNotNull(frame, "frame");
            try {
                if (this.statusReported) {
                    AbstractClientStream.log.log(Level.INFO, "Received data on closed stream");
                    if (needToCloseFrame) {
                        return;
                    }
                    return;
                }
                deframe(frame);
                if (0 != 0) {
                    frame.close();
                }
            } finally {
                if (1 != 0) {
                    frame.close();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void inboundTrailersReceived(Metadata trailers, Status status) {
            Preconditions.checkNotNull(status, "status");
            Preconditions.checkNotNull(trailers, GrpcUtil.TE_TRAILERS);
            if (this.statusReported) {
                AbstractClientStream.log.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{status, trailers});
                return;
            }
            this.statsTraceCtx.clientInboundTrailers(trailers);
            transportReportStatus(status, false, trailers);
        }

        public final void transportReportStatus(Status status, boolean stopDelivery, Metadata trailers) {
            transportReportStatus(status, ClientStreamListener.RpcProgress.PROCESSED, stopDelivery, trailers);
        }

        public final void transportReportStatus(final Status status, final ClientStreamListener.RpcProgress rpcProgress, boolean stopDelivery, final Metadata trailers) {
            Preconditions.checkNotNull(status, "status");
            Preconditions.checkNotNull(trailers, GrpcUtil.TE_TRAILERS);
            if (this.statusReported && !stopDelivery) {
                return;
            }
            this.statusReported = true;
            this.statusReportedIsOk = status.isOk();
            onStreamDeallocated();
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(status, rpcProgress, trailers);
                return;
            }
            this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractClientStream.TransportState.1
                @Override // java.lang.Runnable
                public void run() {
                    TransportState.this.closeListener(status, rpcProgress, trailers);
                }
            };
            closeDeframer(stopDelivery);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeListener(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
            if (!this.listenerClosed) {
                this.listenerClosed = true;
                this.statsTraceCtx.streamClosed(status);
                listener().closed(status, rpcProgress, trailers);
                if (getTransportTracer() != null) {
                    getTransportTracer().reportStreamClosed(status.isOk());
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private class GetFramer implements Framer {
        private boolean closed;
        private Metadata headers;
        private byte[] payload;
        private final StatsTraceContext statsTraceCtx;

        public GetFramer(Metadata headers, StatsTraceContext statsTraceCtx) {
            this.headers = (Metadata) Preconditions.checkNotNull(headers, "headers");
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceCtx, "statsTraceCtx");
        }

        @Override // io.grpc.internal.Framer
        public void writePayload(InputStream message) {
            Preconditions.checkState(this.payload == null, "writePayload should not be called multiple times");
            try {
                this.payload = ByteStreams.toByteArray(message);
                this.statsTraceCtx.outboundMessage(0);
                this.statsTraceCtx.outboundMessageSent(0, this.payload.length, this.payload.length);
                this.statsTraceCtx.outboundUncompressedSize(this.payload.length);
                this.statsTraceCtx.outboundWireSize(this.payload.length);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override // io.grpc.internal.Framer
        public void flush() {
        }

        @Override // io.grpc.internal.Framer
        public boolean isClosed() {
            return this.closed;
        }

        @Override // io.grpc.internal.Framer
        public void close() {
            this.closed = true;
            Preconditions.checkState(this.payload != null, "Lack of request message. GET request is only supported for unary requests");
            AbstractClientStream.this.abstractClientStreamSink().writeHeaders(this.headers, this.payload);
            this.payload = null;
            this.headers = null;
        }

        @Override // io.grpc.internal.Framer
        public void dispose() {
            this.closed = true;
            this.payload = null;
            this.headers = null;
        }

        @Override // io.grpc.internal.Framer
        public Framer setMessageCompression(boolean enable) {
            return this;
        }

        @Override // io.grpc.internal.Framer
        public Framer setCompressor(Compressor compressor) {
            return this;
        }

        @Override // io.grpc.internal.Framer
        public void setMaxOutboundMessageSize(int maxSize) {
        }
    }
}