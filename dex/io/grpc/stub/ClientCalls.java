package io.grpc.stub;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ClientCalls {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger logger = Logger.getLogger(ClientCalls.class.getName());
    static final CallOptions.Key<StubType> STUB_TYPE_OPTION = CallOptions.Key.create("internal-stub-type");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum StubType {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    private ClientCalls() {
    }

    public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver) {
        asyncUnaryRequestCall(call, req, responseObserver, false);
    }

    public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver) {
        asyncUnaryRequestCall(call, req, responseObserver, true);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver) {
        return asyncStreamingRequestCall(call, responseObserver, false);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver) {
        return asyncStreamingRequestCall(call, responseObserver, true);
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> call, ReqT req) {
        try {
            return (RespT) getUnchecked(futureUnaryCall(call, req));
        } catch (Error e2) {
            throw cancelThrow(call, e2);
        } catch (RuntimeException e3) {
            throw cancelThrow(call, e3);
        }
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(Channel channel, MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, ReqT req) {
        ThreadlessExecutor executor = new ThreadlessExecutor();
        boolean interrupt = false;
        ClientCall<ReqT, RespT> call = channel.newCall(method, callOptions.withOption(STUB_TYPE_OPTION, StubType.BLOCKING).withExecutor(executor));
        try {
            try {
                ListenableFuture<RespT> responseFuture = futureUnaryCall(call, req);
                while (!responseFuture.isDone()) {
                    try {
                        executor.waitAndDrain();
                    } catch (InterruptedException e2) {
                        interrupt = true;
                        call.cancel("Thread interrupted", e2);
                    }
                }
                return (RespT) getUnchecked(responseFuture);
            } catch (Error e3) {
                throw cancelThrow(call, e3);
            } catch (RuntimeException e4) {
                throw cancelThrow(call, e4);
            }
        } finally {
            if (interrupt) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> call, ReqT req) {
        BlockingResponseStream<RespT> result = new BlockingResponseStream<>(call);
        asyncUnaryRequestCall(call, req, result.listener());
        return result;
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel channel, MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, ReqT req) {
        ThreadlessExecutor executor = new ThreadlessExecutor();
        ClientCall<ReqT, RespT> call = channel.newCall(method, callOptions.withOption(STUB_TYPE_OPTION, StubType.BLOCKING).withExecutor(executor));
        BlockingResponseStream<RespT> result = new BlockingResponseStream<>(call, executor);
        asyncUnaryRequestCall(call, req, result.listener());
        return result;
    }

    public static <ReqT, RespT> ListenableFuture<RespT> futureUnaryCall(ClientCall<ReqT, RespT> call, ReqT req) {
        GrpcFuture<RespT> responseFuture = new GrpcFuture<>(call);
        asyncUnaryRequestCall(call, req, new UnaryStreamToFuture(responseFuture));
        return responseFuture;
    }

    private static <V> V getUnchecked(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withDescription("Thread interrupted").withCause(e2).asRuntimeException();
        } catch (ExecutionException e3) {
            throw toStatusRuntimeException(e3.getCause());
        }
    }

    private static StatusRuntimeException toStatusRuntimeException(Throwable t) {
        for (Throwable cause = (Throwable) Preconditions.checkNotNull(t, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                StatusException se = (StatusException) cause;
                return new StatusRuntimeException(se.getStatus(), se.getTrailers());
            } else if (cause instanceof StatusRuntimeException) {
                StatusRuntimeException se2 = (StatusRuntimeException) cause;
                return new StatusRuntimeException(se2.getStatus(), se2.getTrailers());
            }
        }
        return Status.UNKNOWN.withDescription("unexpected exception").withCause(t).asRuntimeException();
    }

    private static RuntimeException cancelThrow(ClientCall<?, ?> call, Throwable t) {
        try {
            call.cancel(null, t);
        } catch (Throwable e2) {
            if (!(e2 instanceof RuntimeException) && !(e2 instanceof Error)) {
                throw new AssertionError();
            }
            logger.log(Level.SEVERE, "RuntimeException encountered while closing call", e2);
        }
        if (t instanceof RuntimeException) {
            throw ((RuntimeException) t);
        }
        if (t instanceof Error) {
            throw ((Error) t);
        }
        throw new AssertionError(t);
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver, boolean streamingResponse) {
        asyncUnaryRequestCall(call, req, new StreamObserverToCallListenerAdapter(responseObserver, new CallToStreamObserverAdapter(call, streamingResponse)));
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> call, ReqT req, StartableListener<RespT> responseListener) {
        startCall(call, responseListener);
        try {
            call.sendMessage(req);
            call.halfClose();
        } catch (Error e2) {
            throw cancelThrow(call, e2);
        } catch (RuntimeException e3) {
            throw cancelThrow(call, e3);
        }
    }

    private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver, boolean streamingResponse) {
        CallToStreamObserverAdapter<ReqT> adapter = new CallToStreamObserverAdapter<>(call, streamingResponse);
        startCall(call, new StreamObserverToCallListenerAdapter(responseObserver, adapter));
        return adapter;
    }

    private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> call, StartableListener<RespT> responseListener) {
        call.start(responseListener, new Metadata());
        responseListener.onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class StartableListener<T> extends ClientCall.Listener<T> {
        abstract void onStart();

        private StartableListener() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CallToStreamObserverAdapter<T> extends ClientCallStreamObserver<T> {
        private final ClientCall<T, ?> call;
        private boolean frozen;
        private Runnable onReadyHandler;
        private final boolean streamingResponse;
        private int initialRequest = 1;
        private boolean autoRequestEnabled = true;
        private boolean aborted = false;
        private boolean completed = false;

        CallToStreamObserverAdapter(ClientCall<T, ?> call, boolean streamingResponse) {
            this.call = call;
            this.streamingResponse = streamingResponse;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(T value) {
            Preconditions.checkState(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.completed, "Stream is already completed, no further calls are allowed");
            this.call.sendMessage(value);
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable t) {
            this.call.cancel("Cancelled by client with StreamObserver.onError()", t);
            this.aborted = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            this.call.halfClose();
            this.completed = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable onReadyHandler) {
            if (this.frozen) {
                throw new IllegalStateException("Cannot alter onReadyHandler after call started. Use ClientResponseObserver");
            }
            this.onReadyHandler = onReadyHandler;
        }

        @Override // io.grpc.stub.CallStreamObserver
        @Deprecated
        public void disableAutoInboundFlowControl() {
            disableAutoRequestWithInitial(1);
        }

        @Override // io.grpc.stub.ClientCallStreamObserver
        public void disableAutoRequestWithInitial(int request) {
            if (this.frozen) {
                throw new IllegalStateException("Cannot disable auto flow control after call started. Use ClientResponseObserver");
            }
            Preconditions.checkArgument(request >= 0, "Initial requests must be non-negative");
            this.initialRequest = request;
            this.autoRequestEnabled = false;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void request(int count) {
            if (!this.streamingResponse && count == 1) {
                this.call.request(2);
            } else {
                this.call.request(count);
            }
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean enable) {
            this.call.setMessageCompression(enable);
        }

        @Override // io.grpc.stub.ClientCallStreamObserver
        public void cancel(@Nullable String message, @Nullable Throwable cause) {
            this.call.cancel(message, cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class StreamObserverToCallListenerAdapter<ReqT, RespT> extends StartableListener<RespT> {
        private final CallToStreamObserverAdapter<ReqT> adapter;
        private boolean firstResponseReceived;
        private final StreamObserver<RespT> observer;

        StreamObserverToCallListenerAdapter(StreamObserver<RespT> observer, CallToStreamObserverAdapter<ReqT> adapter) {
            super();
            this.observer = observer;
            this.adapter = adapter;
            if (observer instanceof ClientResponseObserver) {
                ClientResponseObserver<ReqT, RespT> clientResponseObserver = (ClientResponseObserver) observer;
                clientResponseObserver.beforeStart(adapter);
            }
            adapter.freeze();
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata headers) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT message) {
            if (this.firstResponseReceived && !((CallToStreamObserverAdapter) this.adapter).streamingResponse) {
                throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
            }
            this.firstResponseReceived = true;
            this.observer.onNext(message);
            if (((CallToStreamObserverAdapter) this.adapter).streamingResponse && ((CallToStreamObserverAdapter) this.adapter).autoRequestEnabled) {
                this.adapter.request(1);
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata trailers) {
            if (status.isOk()) {
                this.observer.onCompleted();
            } else {
                this.observer.onError(status.asRuntimeException(trailers));
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (((CallToStreamObserverAdapter) this.adapter).onReadyHandler != null) {
                ((CallToStreamObserverAdapter) this.adapter).onReadyHandler.run();
            }
        }

        @Override // io.grpc.stub.ClientCalls.StartableListener
        void onStart() {
            if (((CallToStreamObserverAdapter) this.adapter).initialRequest > 0) {
                this.adapter.request(((CallToStreamObserverAdapter) this.adapter).initialRequest);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class UnaryStreamToFuture<RespT> extends StartableListener<RespT> {
        private final GrpcFuture<RespT> responseFuture;
        private RespT value;

        UnaryStreamToFuture(GrpcFuture<RespT> responseFuture) {
            super();
            this.responseFuture = responseFuture;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata headers) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT value) {
            if (this.value != null) {
                throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
            }
            this.value = value;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata trailers) {
            if (status.isOk()) {
                if (this.value == null) {
                    this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(trailers));
                }
                this.responseFuture.set(this.value);
                return;
            }
            this.responseFuture.setException(status.asRuntimeException(trailers));
        }

        @Override // io.grpc.stub.ClientCalls.StartableListener
        void onStart() {
            ((GrpcFuture) this.responseFuture).call.request(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class GrpcFuture<RespT> extends AbstractFuture<RespT> {
        private final ClientCall<?, RespT> call;

        GrpcFuture(ClientCall<?, RespT> call) {
            this.call = call;
        }

        protected void interruptTask() {
            this.call.cancel("GrpcFuture was cancelled", null);
        }

        protected boolean set(@Nullable RespT resp) {
            return super.set(resp);
        }

        protected boolean setException(Throwable throwable) {
            return super.setException(throwable);
        }

        protected String pendingToString() {
            return MoreObjects.toStringHelper(this).add("clientCall", this.call).toString();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class BlockingResponseStream<T> implements Iterator<T> {
        private final BlockingQueue<Object> buffer;
        private final ClientCall<?, T> call;
        private Object last;
        private final StartableListener<T> listener;
        private final ThreadlessExecutor threadless;

        BlockingResponseStream(ClientCall<?, T> call) {
            this(call, null);
        }

        BlockingResponseStream(ClientCall<?, T> call, ThreadlessExecutor threadless) {
            this.buffer = new ArrayBlockingQueue(3);
            this.listener = new QueuingListener();
            this.call = call;
            this.threadless = threadless;
        }

        StartableListener<T> listener() {
            return this.listener;
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0044 A[FINALLY_INSNS] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Object waitForNext() {
            Object next;
            boolean interrupt = false;
            try {
                if (this.threadless == null) {
                    while (true) {
                        try {
                            break;
                        } catch (InterruptedException ie) {
                            interrupt = true;
                            this.call.cancel("Thread interrupted", ie);
                        }
                    }
                    return this.buffer.take();
                }
                while (true) {
                    next = this.buffer.poll();
                    if (next != null) {
                        break;
                    }
                    try {
                        this.threadless.waitAndDrain();
                    } catch (InterruptedException ie2) {
                        interrupt = true;
                        this.call.cancel("Thread interrupted", ie2);
                    }
                }
                if (interrupt) {
                    Thread.currentThread().interrupt();
                }
                return next;
            } finally {
                if (interrupt) {
                }
            }
            if (interrupt) {
                Thread.currentThread().interrupt();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.last == null) {
                this.last = waitForNext();
            }
            if (!(this.last instanceof StatusRuntimeException)) {
                return this.last != this;
            }
            StatusRuntimeException e2 = (StatusRuntimeException) this.last;
            throw e2.getStatus().asRuntimeException(e2.getTrailers());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!(this.last instanceof StatusRuntimeException) && this.last != this) {
                this.call.request(1);
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tmp = (T) this.last;
            this.last = null;
            return tmp;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        private final class QueuingListener extends StartableListener<T> {
            private boolean done;

            QueuingListener() {
                super();
                this.done = false;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onHeaders(Metadata headers) {
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(T value) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                BlockingResponseStream.this.buffer.add(value);
            }

            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata trailers) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                if (status.isOk()) {
                    BlockingResponseStream.this.buffer.add(BlockingResponseStream.this);
                } else {
                    BlockingResponseStream.this.buffer.add(status.asRuntimeException(trailers));
                }
                this.done = true;
            }

            @Override // io.grpc.stub.ClientCalls.StartableListener
            void onStart() {
                BlockingResponseStream.this.call.request(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ThreadlessExecutor extends ConcurrentLinkedQueue<Runnable> implements Executor {
        private static final Logger log = Logger.getLogger(ThreadlessExecutor.class.getName());
        private volatile Thread waiter;

        ThreadlessExecutor() {
        }

        public void waitAndDrain() throws InterruptedException {
            Runnable poll;
            throwIfInterrupted();
            Runnable runnable = poll();
            if (runnable == null) {
                this.waiter = Thread.currentThread();
                while (true) {
                    try {
                        Runnable poll2 = poll();
                        runnable = poll2;
                        if (poll2 != null) {
                            break;
                        }
                        LockSupport.park(this);
                        throwIfInterrupted();
                    } finally {
                        this.waiter = null;
                    }
                }
            }
            do {
                try {
                    runnable.run();
                } catch (Throwable t) {
                    log.log(Level.WARNING, "Runnable threw exception", t);
                }
                poll = poll();
                runnable = poll;
            } while (poll != null);
        }

        private static void throwIfInterrupted() throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            add(runnable);
            LockSupport.unpark(this.waiter);
        }
    }
}