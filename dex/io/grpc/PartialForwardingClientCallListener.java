package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.ClientCall;

abstract class PartialForwardingClientCallListener<RespT> extends ClientCall.Listener<RespT> {
    protected abstract ClientCall.Listener<?> delegate();

    @Override // io.grpc.ClientCall.Listener
    public void onHeaders(Metadata headers) {
        delegate().onHeaders(headers);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onClose(Status status, Metadata trailers) {
        delegate().onClose(status, trailers);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}