package io.grpc;

import com.google.common.base.MoreObjects;

abstract class PartialForwardingServerCall<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    protected abstract ServerCall<?, ?> delegate();

    @Override // io.grpc.ServerCall
    public void request(int numMessages) {
        delegate().request(numMessages);
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata headers) {
        delegate().sendHeaders(headers);
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata trailers) {
        delegate().close(status, trailers);
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // io.grpc.ServerCall
    public void setMessageCompression(boolean enabled) {
        delegate().setMessageCompression(enabled);
    }

    @Override // io.grpc.ServerCall
    public void setCompression(String compressor) {
        delegate().setCompression(compressor);
    }

    @Override // io.grpc.ServerCall
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.ServerCall
    public String getAuthority() {
        return delegate().getAuthority();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}