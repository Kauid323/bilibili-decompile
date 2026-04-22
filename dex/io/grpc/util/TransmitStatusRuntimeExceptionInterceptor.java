package io.grpc.util;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.SerializingExecutor;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

public final class TransmitStatusRuntimeExceptionInterceptor implements ServerInterceptor {
    private TransmitStatusRuntimeExceptionInterceptor() {
    }

    public static ServerInterceptor instance() {
        return new TransmitStatusRuntimeExceptionInterceptor();
    }

    @Override // io.grpc.ServerInterceptor
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        final ServerCall<ReqT, RespT> serverCall = new SerializingServerCall<>(call);
        ServerCall.Listener<ReqT> listener = next.startCall(serverCall, headers);
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(listener) { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.1
            @Override // io.grpc.ForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onMessage(ReqT message) {
                try {
                    super.onMessage(message);
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onHalfClose() {
                try {
                    super.onHalfClose();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onCancel() {
                try {
                    super.onCancel();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onComplete() {
                try {
                    super.onComplete();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onReady() {
                try {
                    super.onReady();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            private void closeWithException(StatusRuntimeException t) {
                Metadata metadata = t.getTrailers();
                if (metadata == null) {
                    metadata = new Metadata();
                }
                serverCall.close(t.getStatus(), metadata);
            }
        };
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static class SerializingServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT> {
        private static final String ERROR_MSG = "Encountered error during serialized access";
        private boolean closeCalled;
        private final SerializingExecutor serializingExecutor;

        SerializingServerCall(ServerCall<ReqT, RespT> delegate) {
            super(delegate);
            this.serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
            this.closeCalled = false;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.ServerCall
        public void sendMessage(final RespT message) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.1
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.sendMessage(message);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void request(final int numMessages) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.2
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.request(numMessages);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void sendHeaders(final Metadata headers) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.3
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.sendHeaders(headers);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void close(final Status status, final Metadata trailers) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!SerializingServerCall.this.closeCalled) {
                        SerializingServerCall.this.closeCalled = true;
                        SerializingServerCall.super.close(status, trailers);
                    }
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isReady() {
            final SettableFuture<Boolean> retVal = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.5
                @Override // java.lang.Runnable
                public void run() {
                    retVal.set(Boolean.valueOf(SerializingServerCall.super.isReady()));
                }
            });
            try {
                return ((Boolean) retVal.get()).booleanValue();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(ERROR_MSG, e3);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isCancelled() {
            final SettableFuture<Boolean> retVal = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.6
                @Override // java.lang.Runnable
                public void run() {
                    retVal.set(Boolean.valueOf(SerializingServerCall.super.isCancelled()));
                }
            });
            try {
                return ((Boolean) retVal.get()).booleanValue();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(ERROR_MSG, e3);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void setMessageCompression(final boolean enabled) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.7
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.setMessageCompression(enabled);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void setCompression(final String compressor) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.8
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.setCompression(compressor);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public Attributes getAttributes() {
            final SettableFuture<Attributes> retVal = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.9
                @Override // java.lang.Runnable
                public void run() {
                    retVal.set(SerializingServerCall.super.getAttributes());
                }
            });
            try {
                return (Attributes) retVal.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(ERROR_MSG, e3);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @Nullable
        public String getAuthority() {
            final SettableFuture<String> retVal = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.10
                @Override // java.lang.Runnable
                public void run() {
                    retVal.set(SerializingServerCall.super.getAuthority());
                }
            });
            try {
                return (String) retVal.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(ERROR_MSG, e3);
            }
        }
    }
}