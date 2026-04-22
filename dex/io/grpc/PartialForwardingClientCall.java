package io.grpc;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class PartialForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    protected abstract ClientCall<?, ?> delegate();

    @Override // io.grpc.ClientCall
    public void request(int numMessages) {
        delegate().request(numMessages);
    }

    @Override // io.grpc.ClientCall
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
        delegate().cancel(message, cause);
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean enabled) {
        delegate().setMessageCompression(enabled);
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ClientCall
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}