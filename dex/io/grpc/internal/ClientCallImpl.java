package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalConfigSelector;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ManagedChannelServiceConfig;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private final Executor callExecutor;
    private final boolean callExecutorIsDirect;
    private CallOptions callOptions;
    private boolean cancelCalled;
    private volatile boolean cancelListenersShouldBeRemoved;
    private final CallTracer channelCallsTracer;
    private final ClientStreamProvider clientStreamProvider;
    private final Context context;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private volatile ScheduledFuture<?> deadlineCancellationFuture;
    private boolean fullStreamDecompression;
    private boolean halfCloseCalled;
    private final MethodDescriptor<ReqT, RespT> method;
    private ClientStream stream;
    private final Tag tag;
    private final boolean unaryRequest;
    private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
    private static final byte[] FULL_STREAM_DECOMPRESSION_ENCODINGS = "gzip".getBytes(Charset.forName("US-ASCII"));
    private final ClientCallImpl<ReqT, RespT>.ContextCancellationListener cancellationListener = new ContextCancellationListener();
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    private CompressorRegistry compressorRegistry = CompressorRegistry.getDefaultInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ClientStreamProvider {
        ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl(MethodDescriptor<ReqT, RespT> method, Executor executor, CallOptions callOptions, ClientStreamProvider clientStreamProvider, ScheduledExecutorService deadlineCancellationExecutor, CallTracer channelCallsTracer, @Nullable InternalConfigSelector configSelector) {
        this.method = method;
        this.tag = PerfMark.createTag(method.getFullMethodName(), System.identityHashCode(this));
        boolean z = true;
        if (executor == MoreExecutors.directExecutor()) {
            this.callExecutor = new SerializeReentrantCallsDirectExecutor();
            this.callExecutorIsDirect = true;
        } else {
            this.callExecutor = new SerializingExecutor(executor);
            this.callExecutorIsDirect = false;
        }
        this.channelCallsTracer = channelCallsTracer;
        this.context = Context.current();
        if (method.getType() != MethodDescriptor.MethodType.UNARY && method.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) {
            z = false;
        }
        this.unaryRequest = z;
        this.callOptions = callOptions;
        this.clientStreamProvider = clientStreamProvider;
        this.deadlineCancellationExecutor = deadlineCancellationExecutor;
        PerfMark.event("ClientCall.<init>", this.tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class ContextCancellationListener implements Context.CancellationListener {
        private ContextCancellationListener() {
        }

        @Override // io.grpc.Context.CancellationListener
        public void cancelled(Context context) {
            ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setFullStreamDecompression(boolean fullStreamDecompression) {
        this.fullStreamDecompression = fullStreamDecompression;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        this.decompressorRegistry = decompressorRegistry;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setCompressorRegistry(CompressorRegistry compressorRegistry) {
        this.compressorRegistry = compressorRegistry;
        return this;
    }

    static void prepareHeaders(Metadata headers, DecompressorRegistry decompressorRegistry, Compressor compressor, boolean fullStreamDecompression) {
        headers.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (compressor != Codec.Identity.NONE) {
            headers.put(GrpcUtil.MESSAGE_ENCODING_KEY, compressor.getMessageEncoding());
        }
        headers.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] advertisedEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(decompressorRegistry);
        if (advertisedEncodings.length != 0) {
            headers.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, advertisedEncodings);
        }
        headers.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
        headers.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
        if (fullStreamDecompression) {
            headers.put(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY, FULL_STREAM_DECOMPRESSION_ENCODINGS);
        }
    }

    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> observer, Metadata headers) {
        PerfMark.startTask("ClientCall.start", this.tag);
        try {
            startInternal(observer, headers);
        } finally {
            PerfMark.stopTask("ClientCall.start", this.tag);
        }
    }

    private void startInternal(final ClientCall.Listener<RespT> observer, Metadata headers) {
        Compressor compressor;
        boolean deadlineExceeded = false;
        Preconditions.checkState(this.stream == null, "Already started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkNotNull(observer, "observer");
        Preconditions.checkNotNull(headers, "headers");
        if (this.context.isCancelled()) {
            this.stream = NoopClientStream.INSTANCE;
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.1ClosedByContext
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    ClientCallImpl.this.closeObserver(observer, Contexts.statusFromCancelled(ClientCallImpl.this.context), new Metadata());
                }
            });
            return;
        }
        applyMethodConfig();
        final String compressorName = this.callOptions.getCompressor();
        if (compressorName != null) {
            compressor = this.compressorRegistry.lookupCompressor(compressorName);
            if (compressor == null) {
                this.stream = NoopClientStream.INSTANCE;
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.1ClosedByNotFoundCompressor
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(ClientCallImpl.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        ClientCallImpl.this.closeObserver(observer, Status.INTERNAL.withDescription(String.format("Unable to find compressor by name %s", compressorName)), new Metadata());
                    }
                });
                return;
            }
        } else {
            compressor = Codec.Identity.NONE;
        }
        prepareHeaders(headers, this.decompressorRegistry, compressor, this.fullStreamDecompression);
        Deadline effectiveDeadline = effectiveDeadline();
        if (effectiveDeadline != null && effectiveDeadline.isExpired()) {
            deadlineExceeded = true;
        }
        if (!deadlineExceeded) {
            logIfContextNarrowedTimeout(effectiveDeadline, this.context.getDeadline(), this.callOptions.getDeadline());
            this.stream = this.clientStreamProvider.newStream(this.method, this.callOptions, headers, this.context);
        } else {
            this.stream = new FailingClientStream(Status.DEADLINE_EXCEEDED.withDescription("ClientCall started after deadline exceeded: " + effectiveDeadline));
        }
        if (this.callExecutorIsDirect) {
            this.stream.optimizeForDirectExecutor();
        }
        if (this.callOptions.getAuthority() != null) {
            this.stream.setAuthority(this.callOptions.getAuthority());
        }
        if (this.callOptions.getMaxInboundMessageSize() != null) {
            this.stream.setMaxInboundMessageSize(this.callOptions.getMaxInboundMessageSize().intValue());
        }
        if (this.callOptions.getMaxOutboundMessageSize() != null) {
            this.stream.setMaxOutboundMessageSize(this.callOptions.getMaxOutboundMessageSize().intValue());
        }
        if (effectiveDeadline != null) {
            this.stream.setDeadline(effectiveDeadline);
        }
        this.stream.setCompressor(compressor);
        if (this.fullStreamDecompression) {
            this.stream.setFullStreamDecompression(this.fullStreamDecompression);
        }
        this.stream.setDecompressorRegistry(this.decompressorRegistry);
        this.channelCallsTracer.reportCallStarted();
        this.stream.start(new ClientStreamListenerImpl(observer));
        this.context.addListener(this.cancellationListener, MoreExecutors.directExecutor());
        if (effectiveDeadline != null && !effectiveDeadline.equals(this.context.getDeadline()) && this.deadlineCancellationExecutor != null) {
            this.deadlineCancellationFuture = startDeadlineTimer(effectiveDeadline);
        }
        if (this.cancelListenersShouldBeRemoved) {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    private void applyMethodConfig() {
        ManagedChannelServiceConfig.MethodInfo info = (ManagedChannelServiceConfig.MethodInfo) this.callOptions.getOption(ManagedChannelServiceConfig.MethodInfo.KEY);
        if (info == null) {
            return;
        }
        if (info.timeoutNanos != null) {
            Deadline newDeadline = Deadline.after(info.timeoutNanos.longValue(), TimeUnit.NANOSECONDS);
            Deadline existingDeadline = this.callOptions.getDeadline();
            if (existingDeadline == null || newDeadline.compareTo(existingDeadline) < 0) {
                this.callOptions = this.callOptions.withDeadline(newDeadline);
            }
        }
        if (info.waitForReady != null) {
            this.callOptions = info.waitForReady.booleanValue() ? this.callOptions.withWaitForReady() : this.callOptions.withoutWaitForReady();
        }
        if (info.maxInboundMessageSize != null) {
            Integer existingLimit = this.callOptions.getMaxInboundMessageSize();
            if (existingLimit != null) {
                this.callOptions = this.callOptions.withMaxInboundMessageSize(Math.min(existingLimit.intValue(), info.maxInboundMessageSize.intValue()));
            } else {
                this.callOptions = this.callOptions.withMaxInboundMessageSize(info.maxInboundMessageSize.intValue());
            }
        }
        if (info.maxOutboundMessageSize != null) {
            Integer existingLimit2 = this.callOptions.getMaxOutboundMessageSize();
            if (existingLimit2 != null) {
                this.callOptions = this.callOptions.withMaxOutboundMessageSize(Math.min(existingLimit2.intValue(), info.maxOutboundMessageSize.intValue()));
            } else {
                this.callOptions = this.callOptions.withMaxOutboundMessageSize(info.maxOutboundMessageSize.intValue());
            }
        }
    }

    private static void logIfContextNarrowedTimeout(Deadline effectiveDeadline, @Nullable Deadline outerCallDeadline, @Nullable Deadline callDeadline) {
        if (!log.isLoggable(Level.FINE) || effectiveDeadline == null || !effectiveDeadline.equals(outerCallDeadline)) {
            return;
        }
        long effectiveTimeout = Math.max(0L, effectiveDeadline.timeRemaining(TimeUnit.NANOSECONDS));
        StringBuilder builder = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(effectiveTimeout)));
        if (callDeadline == null) {
            builder.append(" Explicit call timeout was not set.");
        } else {
            long callTimeout = callDeadline.timeRemaining(TimeUnit.NANOSECONDS);
            builder.append(String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(callTimeout)));
        }
        log.fine(builder.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeContextListenerAndCancelDeadlineFuture() {
        this.context.removeListener(this.cancellationListener);
        ScheduledFuture<?> f2 = this.deadlineCancellationFuture;
        if (f2 != null) {
            f2.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class DeadlineTimer implements Runnable {
        private final long remainingNanos;

        DeadlineTimer(long remainingNanos) {
            this.remainingNanos = remainingNanos;
        }

        @Override // java.lang.Runnable
        public void run() {
            InsightBuilder insight = new InsightBuilder();
            ClientCallImpl.this.stream.appendTimeoutInsight(insight);
            long seconds = Math.abs(this.remainingNanos) / TimeUnit.SECONDS.toNanos(1L);
            long nanos = Math.abs(this.remainingNanos) % TimeUnit.SECONDS.toNanos(1L);
            StringBuilder buf = new StringBuilder();
            buf.append("deadline exceeded after ");
            if (this.remainingNanos < 0) {
                buf.append('-');
            }
            buf.append(seconds);
            buf.append(String.format(Locale.US, ".%09d", Long.valueOf(nanos)));
            buf.append("s. ");
            buf.append(insight);
            ClientCallImpl.this.stream.cancel(Status.DEADLINE_EXCEEDED.augmentDescription(buf.toString()));
        }
    }

    private ScheduledFuture<?> startDeadlineTimer(Deadline deadline) {
        long remainingNanos = deadline.timeRemaining(TimeUnit.NANOSECONDS);
        return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new DeadlineTimer(remainingNanos)), remainingNanos, TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Deadline effectiveDeadline() {
        return min(this.callOptions.getDeadline(), this.context.getDeadline());
    }

    @Nullable
    private static Deadline min(@Nullable Deadline deadline0, @Nullable Deadline deadline1) {
        if (deadline0 == null) {
            return deadline1;
        }
        if (deadline1 == null) {
            return deadline0;
        }
        return deadline0.minimum(deadline1);
    }

    @Override // io.grpc.ClientCall
    public void request(int numMessages) {
        PerfMark.startTask("ClientCall.request", this.tag);
        try {
            boolean z = true;
            Preconditions.checkState(this.stream != null, "Not started");
            if (numMessages < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "Number requested must be non-negative");
            this.stream.request(numMessages);
        } finally {
            PerfMark.stopTask("ClientCall.request", this.tag);
        }
    }

    @Override // io.grpc.ClientCall
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
        PerfMark.startTask("ClientCall.cancel", this.tag);
        try {
            cancelInternal(message, cause);
        } finally {
            PerfMark.stopTask("ClientCall.cancel", this.tag);
        }
    }

    private void cancelInternal(@Nullable String message, @Nullable Throwable cause) {
        Status status;
        if (message == null && cause == null) {
            cause = new CancellationException("Cancelled without a message or cause");
            log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", cause);
        }
        if (this.cancelCalled) {
            return;
        }
        this.cancelCalled = true;
        try {
            if (this.stream != null) {
                Status status2 = Status.CANCELLED;
                if (message != null) {
                    status = status2.withDescription(message);
                } else {
                    status = status2.withDescription("Call cancelled without message");
                }
                if (cause != null) {
                    status = status.withCause(cause);
                }
                this.stream.cancel(status);
            }
        } finally {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        PerfMark.startTask("ClientCall.halfClose", this.tag);
        try {
            halfCloseInternal();
        } finally {
            PerfMark.stopTask("ClientCall.halfClose", this.tag);
        }
    }

    private void halfCloseInternal() {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call already half-closed");
        this.halfCloseCalled = true;
        this.stream.halfClose();
    }

    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT message) {
        PerfMark.startTask("ClientCall.sendMessage", this.tag);
        try {
            sendMessageInternal(message);
        } finally {
            PerfMark.stopTask("ClientCall.sendMessage", this.tag);
        }
    }

    private void sendMessageInternal(ReqT message) {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call was half-closed");
        try {
            if (this.stream instanceof RetriableStream) {
                RetriableStream<ReqT> retriableStream = (RetriableStream) this.stream;
                retriableStream.sendMessage(message);
            } else {
                this.stream.writeMessage(this.method.streamRequest(message));
            }
            if (!this.unaryRequest) {
                this.stream.flush();
            }
        } catch (Error e2) {
            this.stream.cancel(Status.CANCELLED.withDescription("Client sendMessage() failed with Error"));
            throw e2;
        } catch (RuntimeException e3) {
            this.stream.cancel(Status.CANCELLED.withCause(e3).withDescription("Failed to stream message"));
        }
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean enabled) {
        Preconditions.checkState(this.stream != null, "Not started");
        this.stream.setMessageCompression(enabled);
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return this.stream.isReady();
    }

    @Override // io.grpc.ClientCall
    public Attributes getAttributes() {
        if (this.stream != null) {
            return this.stream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeObserver(ClientCall.Listener<RespT> observer, Status status, Metadata trailers) {
        observer.onClose(status, trailers);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("method", this.method).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class ClientStreamListenerImpl implements ClientStreamListener {
        private Status exceptionStatus;
        private final ClientCall.Listener<RespT> observer;

        public ClientStreamListenerImpl(ClientCall.Listener<RespT> observer) {
            this.observer = (ClientCall.Listener) Preconditions.checkNotNull(observer, "observer");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exceptionThrown(Status status) {
            this.exceptionStatus = status;
            ClientCallImpl.this.stream.cancel(status);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata headers) {
            PerfMark.startTask("ClientStreamListener.headersRead", ClientCallImpl.this.tag);
            final Link link = PerfMark.linkOut();
            try {
                ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1HeadersRead
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(ClientCallImpl.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ClientCall$Listener.headersRead", ClientCallImpl.this.tag);
                        PerfMark.linkIn(link);
                        try {
                            runInternal();
                        } finally {
                            PerfMark.stopTask("ClientCall$Listener.headersRead", ClientCallImpl.this.tag);
                        }
                    }

                    private void runInternal() {
                        if (ClientStreamListenerImpl.this.exceptionStatus == null) {
                            try {
                                ClientStreamListenerImpl.this.observer.onHeaders(headers);
                            } catch (Throwable t) {
                                ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(t).withDescription("Failed to read headers"));
                            }
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ClientStreamListener.headersRead", ClientCallImpl.this.tag);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer producer) {
            PerfMark.startTask("ClientStreamListener.messagesAvailable", ClientCallImpl.this.tag);
            final Link link = PerfMark.linkOut();
            try {
                ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1MessagesAvailable
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(ClientCallImpl.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ClientCall$Listener.messagesAvailable", ClientCallImpl.this.tag);
                        PerfMark.linkIn(link);
                        try {
                            runInternal();
                        } finally {
                            PerfMark.stopTask("ClientCall$Listener.messagesAvailable", ClientCallImpl.this.tag);
                        }
                    }

                    private void runInternal() {
                        if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                            GrpcUtil.closeQuietly(producer);
                            return;
                        }
                        while (true) {
                            try {
                                InputStream message = producer.next();
                                if (message != null) {
                                    ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(message));
                                    message.close();
                                } else {
                                    return;
                                }
                            } catch (Throwable t) {
                                GrpcUtil.closeQuietly(producer);
                                ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(t).withDescription("Failed to read message."));
                                return;
                            }
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ClientStreamListener.messagesAvailable", ClientCallImpl.this.tag);
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, Metadata trailers) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, trailers);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
            PerfMark.startTask("ClientStreamListener.closed", ClientCallImpl.this.tag);
            try {
                closedInternal(status, rpcProgress, trailers);
            } finally {
                PerfMark.stopTask("ClientStreamListener.closed", ClientCallImpl.this.tag);
            }
        }

        private void closedInternal(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
            Deadline deadline = ClientCallImpl.this.effectiveDeadline();
            if (status.getCode() == Status.Code.CANCELLED && deadline != null && deadline.isExpired()) {
                InsightBuilder insight = new InsightBuilder();
                ClientCallImpl.this.stream.appendTimeoutInsight(insight);
                status = Status.DEADLINE_EXCEEDED.augmentDescription("ClientCall was cancelled at or after deadline. " + insight);
                trailers = new Metadata();
            }
            final Status savedStatus = status;
            final Metadata savedTrailers = trailers;
            final Link link = PerfMark.linkOut();
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamClosed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ClientCall$Listener.onClose", ClientCallImpl.this.tag);
                    PerfMark.linkIn(link);
                    try {
                        runInternal();
                    } finally {
                        PerfMark.stopTask("ClientCall$Listener.onClose", ClientCallImpl.this.tag);
                    }
                }

                private void runInternal() {
                    Status status2 = savedStatus;
                    Metadata trailers2 = savedTrailers;
                    if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                        status2 = ClientStreamListenerImpl.this.exceptionStatus;
                        trailers2 = new Metadata();
                    }
                    ClientCallImpl.this.cancelListenersShouldBeRemoved = true;
                    try {
                        ClientCallImpl.this.closeObserver(ClientStreamListenerImpl.this.observer, status2, trailers2);
                    } finally {
                        ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
                        ClientCallImpl.this.channelCallsTracer.reportCallEnded(status2.isOk());
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (!ClientCallImpl.this.method.getType().clientSendsOneMessage()) {
                PerfMark.startTask("ClientStreamListener.onReady", ClientCallImpl.this.tag);
                final Link link = PerfMark.linkOut();
                try {
                    ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamOnReady
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(ClientCallImpl.this.context);
                        }

                        @Override // io.grpc.internal.ContextRunnable
                        public void runInContext() {
                            PerfMark.startTask("ClientCall$Listener.onReady", ClientCallImpl.this.tag);
                            PerfMark.linkIn(link);
                            try {
                                runInternal();
                            } finally {
                                PerfMark.stopTask("ClientCall$Listener.onReady", ClientCallImpl.this.tag);
                            }
                        }

                        private void runInternal() {
                            if (ClientStreamListenerImpl.this.exceptionStatus == null) {
                                try {
                                    ClientStreamListenerImpl.this.observer.onReady();
                                } catch (Throwable t) {
                                    ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(t).withDescription("Failed to call onReady."));
                                }
                            }
                        }
                    });
                } finally {
                    PerfMark.stopTask("ClientStreamListener.onReady", ClientCallImpl.this.tag);
                }
            }
        }
    }
}