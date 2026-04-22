package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

public final class ServerCalls {
    static final String MISSING_REQUEST = "Half-closed without a request";
    static final String TOO_MANY_REQUESTS = "Too many requests";

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface BidiStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.StreamingRequestMethod
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ClientStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.StreamingRequestMethod
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ServerStreamingMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.UnaryRequestMethod
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private interface StreamingRequestMethod<ReqT, RespT> {
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface UnaryMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.UnaryRequestMethod
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private interface UnaryRequestMethod<ReqT, RespT> {
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    private ServerCalls() {
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryCall(UnaryMethod<ReqT, RespT> method) {
        return new UnaryServerCallHandler(method, false);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncServerStreamingCall(ServerStreamingMethod<ReqT, RespT> method) {
        return new UnaryServerCallHandler(method, true);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncClientStreamingCall(ClientStreamingMethod<ReqT, RespT> method) {
        return new StreamingServerCallHandler(method, false);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncBidiStreamingCall(BidiStreamingMethod<ReqT, RespT> method) {
        return new StreamingServerCallHandler(method, true);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class UnaryServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final UnaryRequestMethod<ReqT, RespT> method;
        private final boolean serverStreaming;

        UnaryServerCallHandler(UnaryRequestMethod<ReqT, RespT> method, boolean serverStreaming) {
            this.method = method;
            this.serverStreaming = serverStreaming;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> call, Metadata headers) {
            Preconditions.checkArgument(call.getMethodDescriptor().getType().clientSendsOneMessage(), "asyncUnaryRequestCall is only for clientSendsOneMessage methods");
            ServerCallStreamObserverImpl<ReqT, RespT> responseObserver = new ServerCallStreamObserverImpl<>(call, this.serverStreaming);
            call.request(2);
            return new UnaryServerCallListener(responseObserver, call);
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        private final class UnaryServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean canInvoke = true;
            private ReqT request;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;
            private boolean wasReady;

            UnaryServerCallListener(ServerCallStreamObserverImpl<ReqT, RespT> responseObserver, ServerCall<ReqT, RespT> call) {
                this.call = call;
                this.responseObserver = responseObserver;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT request) {
                if (this.request != null) {
                    this.call.close(Status.INTERNAL.withDescription(ServerCalls.TOO_MANY_REQUESTS), new Metadata());
                    this.canInvoke = false;
                    return;
                }
                this.request = request;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                if (!this.canInvoke) {
                    return;
                }
                if (this.request != null) {
                    UnaryServerCallHandler.this.method.invoke(this.request, this.responseObserver);
                    this.request = null;
                    this.responseObserver.freeze();
                    if (this.wasReady) {
                        onReady();
                        return;
                    }
                    return;
                }
                this.call.close(Status.INTERNAL.withDescription(ServerCalls.MISSING_REQUEST), new Metadata());
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler == null) {
                    this.responseObserver.cancelled = true;
                } else {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                this.wasReady = true;
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler == null) {
                    return;
                }
                ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class StreamingServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final boolean bidi;
        private final StreamingRequestMethod<ReqT, RespT> method;

        StreamingServerCallHandler(StreamingRequestMethod<ReqT, RespT> method, boolean bidi) {
            this.method = method;
            this.bidi = bidi;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> call, Metadata headers) {
            ServerCallStreamObserverImpl<ReqT, RespT> responseObserver = new ServerCallStreamObserverImpl<>(call, this.bidi);
            StreamObserver<ReqT> requestObserver = this.method.invoke(responseObserver);
            responseObserver.freeze();
            if (((ServerCallStreamObserverImpl) responseObserver).autoRequestEnabled) {
                call.request(1);
            }
            return new StreamingServerCallListener(requestObserver, responseObserver, call);
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        private final class StreamingServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean halfClosed = false;
            private final StreamObserver<ReqT> requestObserver;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;

            StreamingServerCallListener(StreamObserver<ReqT> requestObserver, ServerCallStreamObserverImpl<ReqT, RespT> responseObserver, ServerCall<ReqT, RespT> call) {
                this.requestObserver = requestObserver;
                this.responseObserver = responseObserver;
                this.call = call;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT request) {
                this.requestObserver.onNext(request);
                if (((ServerCallStreamObserverImpl) this.responseObserver).autoRequestEnabled) {
                    this.call.request(1);
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                this.halfClosed = true;
                this.requestObserver.onCompleted();
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler == null) {
                    this.responseObserver.cancelled = true;
                } else {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                }
                if (!this.halfClosed) {
                    this.requestObserver.onError(Status.CANCELLED.withDescription("client cancelled").asRuntimeException());
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler == null) {
                    return;
                }
                ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ServerCallStreamObserverImpl<ReqT, RespT> extends ServerCallStreamObserver<RespT> {
        final ServerCall<ReqT, RespT> call;
        volatile boolean cancelled;
        private boolean frozen;
        private Runnable onCancelHandler;
        private Runnable onReadyHandler;
        private boolean sentHeaders;
        private final boolean serverStreamingOrBidi;
        private boolean autoRequestEnabled = true;
        private boolean aborted = false;
        private boolean completed = false;

        ServerCallStreamObserverImpl(ServerCall<ReqT, RespT> call, boolean serverStreamingOrBidi) {
            this.call = call;
            this.serverStreamingOrBidi = serverStreamingOrBidi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean enable) {
            this.call.setMessageCompression(enable);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setCompression(String compression) {
            this.call.setCompression(compression);
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(RespT response) {
            if (this.cancelled && this.serverStreamingOrBidi) {
                throw Status.CANCELLED.withDescription("call already cancelled. Use ServerCallStreamObserver.setOnCancelHandler() to disable this exception").asRuntimeException();
            }
            Preconditions.checkState(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.completed, "Stream is already completed, no further calls are allowed");
            if (!this.sentHeaders) {
                this.call.sendHeaders(new Metadata());
                this.sentHeaders = true;
            }
            this.call.sendMessage(response);
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable t) {
            Metadata metadata = Status.trailersFromThrowable(t);
            if (metadata == null) {
                metadata = new Metadata();
            }
            this.call.close(Status.fromThrowable(t), metadata);
            this.aborted = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            this.call.close(Status.OK, new Metadata());
            this.completed = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable r) {
            Preconditions.checkState(!this.frozen, "Cannot alter onReadyHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.onReadyHandler = r;
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public boolean isCancelled() {
            return this.call.isCancelled();
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setOnCancelHandler(Runnable onCancelHandler) {
            Preconditions.checkState(!this.frozen, "Cannot alter onCancelHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.onCancelHandler = onCancelHandler;
        }

        @Override // io.grpc.stub.CallStreamObserver
        @Deprecated
        public void disableAutoInboundFlowControl() {
            disableAutoRequest();
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void disableAutoRequest() {
            Preconditions.checkState(!this.frozen, "Cannot disable auto flow control after initialization");
            this.autoRequestEnabled = false;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void request(int count) {
            this.call.request(count);
        }
    }

    public static void asyncUnimplementedUnaryCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> responseObserver) {
        Preconditions.checkNotNull(methodDescriptor, "methodDescriptor");
        Preconditions.checkNotNull(responseObserver, "responseObserver");
        responseObserver.onError(Status.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented", methodDescriptor.getFullMethodName())).asRuntimeException());
    }

    public static <T> StreamObserver<T> asyncUnimplementedStreamingCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> responseObserver) {
        asyncUnimplementedUnaryCall(methodDescriptor, responseObserver);
        return new NoopStreamObserver();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static class NoopStreamObserver<V> implements StreamObserver<V> {
        NoopStreamObserver() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(V value) {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable t) {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
        }
    }
}