package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ForwardingServerCallListener;
import io.grpc.ServerCall;
import io.grpc.Status;
import java.util.concurrent.TimeoutException;

public final class Contexts {
    private Contexts() {
    }

    public static <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(Context context, ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        Context previous = context.attach();
        try {
            return new ContextualizedServerCallListener(next.startCall(call, headers), context);
        } finally {
            context.detach(previous);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static class ContextualizedServerCallListener<ReqT> extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {
        private final Context context;

        public ContextualizedServerCallListener(ServerCall.Listener<ReqT> delegate, Context context) {
            super(delegate);
            this.context = context;
        }

        @Override // io.grpc.ForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onMessage(ReqT message) {
            Context previous = this.context.attach();
            try {
                super.onMessage(message);
            } finally {
                this.context.detach(previous);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onHalfClose() {
            Context previous = this.context.attach();
            try {
                super.onHalfClose();
            } finally {
                this.context.detach(previous);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onCancel() {
            Context previous = this.context.attach();
            try {
                super.onCancel();
            } finally {
                this.context.detach(previous);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onComplete() {
            Context previous = this.context.attach();
            try {
                super.onComplete();
            } finally {
                this.context.detach(previous);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onReady() {
            Context previous = this.context.attach();
            try {
                super.onReady();
            } finally {
                this.context.detach(previous);
            }
        }
    }

    public static Status statusFromCancelled(Context context) {
        Preconditions.checkNotNull(context, "context must not be null");
        if (!context.isCancelled()) {
            return null;
        }
        Throwable cancellationCause = context.cancellationCause();
        if (cancellationCause == null) {
            return Status.CANCELLED.withDescription("io.grpc.Context was cancelled without error");
        }
        if (cancellationCause instanceof TimeoutException) {
            return Status.DEADLINE_EXCEEDED.withDescription(cancellationCause.getMessage()).withCause(cancellationCause);
        }
        Status status = Status.fromThrowable(cancellationCause);
        if (Status.Code.UNKNOWN.equals(status.getCode()) && status.getCause() == cancellationCause) {
            return Status.CANCELLED.withDescription("Context cancelled").withCause(cancellationCause);
        }
        return status.withCause(cancellationCause);
    }
}