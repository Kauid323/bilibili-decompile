package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;

abstract class ForwardingClientStreamListener implements ClientStreamListener {
    protected abstract ClientStreamListener delegate();

    @Override // io.grpc.internal.ClientStreamListener
    public void headersRead(Metadata headers) {
        delegate().headersRead(headers);
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, Metadata trailers) {
        delegate().closed(status, trailers);
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
        delegate().closed(status, rpcProgress, trailers);
    }

    @Override // io.grpc.internal.StreamListener
    public void messagesAvailable(StreamListener.MessageProducer producer) {
        delegate().messagesAvailable(producer);
    }

    @Override // io.grpc.internal.StreamListener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}