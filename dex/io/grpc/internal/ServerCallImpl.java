package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ServerCallImpl<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    static final String MISSING_RESPONSE = "Completed without a response";
    static final String TOO_MANY_RESPONSES = "Too many responses";
    private static final Logger log = Logger.getLogger(ServerCallImpl.class.getName());
    private volatile boolean cancelled;
    private boolean closeCalled;
    private Compressor compressor;
    private final CompressorRegistry compressorRegistry;
    private final Context.CancellableContext context;
    private final DecompressorRegistry decompressorRegistry;
    private final byte[] messageAcceptEncoding;
    private boolean messageSent;
    private final MethodDescriptor<ReqT, RespT> method;
    private boolean sendHeadersCalled;
    private CallTracer serverCallTracer;
    private final ServerStream stream;
    private final Tag tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerCallImpl(ServerStream stream, MethodDescriptor<ReqT, RespT> method, Metadata inboundHeaders, Context.CancellableContext context, DecompressorRegistry decompressorRegistry, CompressorRegistry compressorRegistry, CallTracer serverCallTracer, Tag tag) {
        this.stream = stream;
        this.method = method;
        this.context = context;
        this.messageAcceptEncoding = (byte[]) inboundHeaders.get(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        this.decompressorRegistry = decompressorRegistry;
        this.compressorRegistry = compressorRegistry;
        this.serverCallTracer = serverCallTracer;
        this.serverCallTracer.reportCallStarted();
        this.tag = tag;
    }

    @Override // io.grpc.ServerCall
    public void request(int numMessages) {
        PerfMark.startTask("ServerCall.request", this.tag);
        try {
            this.stream.request(numMessages);
        } finally {
            PerfMark.stopTask("ServerCall.request", this.tag);
        }
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata headers) {
        PerfMark.startTask("ServerCall.sendHeaders", this.tag);
        try {
            sendHeadersInternal(headers);
        } finally {
            PerfMark.stopTask("ServerCall.sendHeaders", this.tag);
        }
    }

    private void sendHeadersInternal(Metadata headers) {
        Preconditions.checkState(!this.sendHeadersCalled, "sendHeaders has already been called");
        Preconditions.checkState(!this.closeCalled, "call is closed");
        headers.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (this.compressor == null) {
            this.compressor = Codec.Identity.NONE;
        } else if (this.messageAcceptEncoding != null) {
            if (!GrpcUtil.iterableContains(GrpcUtil.ACCEPT_ENCODING_SPLITTER.split(new String(this.messageAcceptEncoding, GrpcUtil.US_ASCII)), this.compressor.getMessageEncoding())) {
                this.compressor = Codec.Identity.NONE;
            }
        } else {
            this.compressor = Codec.Identity.NONE;
        }
        headers.put(GrpcUtil.MESSAGE_ENCODING_KEY, this.compressor.getMessageEncoding());
        this.stream.setCompressor(this.compressor);
        headers.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] advertisedEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(this.decompressorRegistry);
        if (advertisedEncodings.length != 0) {
            headers.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, advertisedEncodings);
        }
        this.sendHeadersCalled = true;
        this.stream.writeHeaders(headers);
    }

    @Override // io.grpc.ServerCall
    public void sendMessage(RespT message) {
        PerfMark.startTask("ServerCall.sendMessage", this.tag);
        try {
            sendMessageInternal(message);
        } finally {
            PerfMark.stopTask("ServerCall.sendMessage", this.tag);
        }
    }

    private void sendMessageInternal(RespT message) {
        Preconditions.checkState(this.sendHeadersCalled, "sendHeaders has not been called");
        Preconditions.checkState(!this.closeCalled, "call is closed");
        if (this.method.getType().serverSendsOneMessage() && this.messageSent) {
            internalClose(Status.INTERNAL.withDescription(TOO_MANY_RESPONSES));
            return;
        }
        this.messageSent = true;
        try {
            InputStream resp = this.method.streamResponse(message);
            this.stream.writeMessage(resp);
            this.stream.flush();
        } catch (Error e2) {
            close(Status.CANCELLED.withDescription("Server sendMessage() failed with Error"), new Metadata());
            throw e2;
        } catch (RuntimeException e3) {
            close(Status.fromThrowable(e3), new Metadata());
        }
    }

    @Override // io.grpc.ServerCall
    public void setMessageCompression(boolean enable) {
        this.stream.setMessageCompression(enable);
    }

    @Override // io.grpc.ServerCall
    public void setCompression(String compressorName) {
        Preconditions.checkState(!this.sendHeadersCalled, "sendHeaders has been called");
        this.compressor = this.compressorRegistry.lookupCompressor(compressorName);
        Preconditions.checkArgument(this.compressor != null, "Unable to find compressor by name %s", compressorName);
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return this.stream.isReady();
    }

    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata trailers) {
        PerfMark.startTask("ServerCall.close", this.tag);
        try {
            closeInternal(status, trailers);
        } finally {
            PerfMark.stopTask("ServerCall.close", this.tag);
        }
    }

    private void closeInternal(Status status, Metadata trailers) {
        Preconditions.checkState(!this.closeCalled, "call already closed");
        try {
            this.closeCalled = true;
            if (status.isOk() && this.method.getType().serverSendsOneMessage() && !this.messageSent) {
                internalClose(Status.INTERNAL.withDescription(MISSING_RESPONSE));
            } else {
                this.stream.close(status, trailers);
            }
        } finally {
            this.serverCallTracer.reportCallEnded(status.isOk());
        }
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return this.cancelled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerStreamListener newServerStreamListener(ServerCall.Listener<ReqT> listener) {
        return new ServerStreamListenerImpl(this, listener, this.context);
    }

    @Override // io.grpc.ServerCall
    public Attributes getAttributes() {
        return this.stream.getAttributes();
    }

    @Override // io.grpc.ServerCall
    public String getAuthority() {
        return this.stream.getAuthority();
    }

    @Override // io.grpc.ServerCall
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.method;
    }

    private void internalClose(Status internalError) {
        log.log(Level.WARNING, "Cancelling the stream with status {0}", new Object[]{internalError});
        this.stream.cancel(internalError);
        this.serverCallTracer.reportCallEnded(internalError.isOk());
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class ServerStreamListenerImpl<ReqT> implements ServerStreamListener {
        private final ServerCallImpl<ReqT, ?> call;
        private final Context.CancellableContext context;
        private final ServerCall.Listener<ReqT> listener;

        public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> call, ServerCall.Listener<ReqT> listener, Context.CancellableContext context) {
            this.call = (ServerCallImpl) Preconditions.checkNotNull(call, "call");
            this.listener = (ServerCall.Listener) Preconditions.checkNotNull(listener, "listener must not be null");
            this.context = (Context.CancellableContext) Preconditions.checkNotNull(context, "context");
            this.context.addListener(new Context.CancellationListener() { // from class: io.grpc.internal.ServerCallImpl.ServerStreamListenerImpl.1
                @Override // io.grpc.Context.CancellationListener
                public void cancelled(Context context2) {
                    ServerStreamListenerImpl.this.call.cancelled = true;
                }
            }, MoreExecutors.directExecutor());
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer producer) {
            PerfMark.startTask("ServerStreamListener.messagesAvailable", ((ServerCallImpl) this.call).tag);
            try {
                messagesAvailableInternal(producer);
            } finally {
                PerfMark.stopTask("ServerStreamListener.messagesAvailable", ((ServerCallImpl) this.call).tag);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void messagesAvailableInternal(StreamListener.MessageProducer producer) {
            if (((ServerCallImpl) this.call).cancelled) {
                GrpcUtil.closeQuietly(producer);
                return;
            }
            while (true) {
                try {
                    InputStream message = producer.next();
                    if (message != null) {
                        this.listener.onMessage(((ServerCallImpl) this.call).method.parseRequest(message));
                        message.close();
                    } else {
                        return;
                    }
                } catch (Throwable t) {
                    GrpcUtil.closeQuietly(producer);
                    Throwables.throwIfUnchecked(t);
                    throw new RuntimeException(t);
                }
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            PerfMark.startTask("ServerStreamListener.halfClosed", ((ServerCallImpl) this.call).tag);
            try {
                if (((ServerCallImpl) this.call).cancelled) {
                    return;
                }
                this.listener.onHalfClose();
            } finally {
                PerfMark.stopTask("ServerStreamListener.halfClosed", ((ServerCallImpl) this.call).tag);
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
            PerfMark.startTask("ServerStreamListener.closed", ((ServerCallImpl) this.call).tag);
            try {
                closedInternal(status);
            } finally {
                PerfMark.stopTask("ServerStreamListener.closed", ((ServerCallImpl) this.call).tag);
            }
        }

        private void closedInternal(Status status) {
            try {
                if (!status.isOk()) {
                    ((ServerCallImpl) this.call).cancelled = true;
                    this.listener.onCancel();
                } else {
                    this.listener.onComplete();
                }
            } finally {
                this.context.cancel(null);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            PerfMark.startTask("ServerStreamListener.onReady", ((ServerCallImpl) this.call).tag);
            try {
                if (((ServerCallImpl) this.call).cancelled) {
                    return;
                }
                this.listener.onReady();
            } finally {
                PerfMark.stopTask("ServerCall.closed", ((ServerCallImpl) this.call).tag);
            }
        }
    }
}