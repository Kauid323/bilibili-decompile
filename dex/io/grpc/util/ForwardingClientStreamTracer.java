package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;

public abstract class ForwardingClientStreamTracer extends ClientStreamTracer {
    protected abstract ClientStreamTracer delegate();

    @Override // io.grpc.ClientStreamTracer
    public void outboundHeaders() {
        delegate().outboundHeaders();
    }

    @Override // io.grpc.ClientStreamTracer
    public void inboundHeaders() {
        delegate().inboundHeaders();
    }

    @Override // io.grpc.ClientStreamTracer
    public void inboundTrailers(Metadata trailers) {
        delegate().inboundTrailers(trailers);
    }

    @Override // io.grpc.StreamTracer
    public void streamClosed(Status status) {
        delegate().streamClosed(status);
    }

    @Override // io.grpc.StreamTracer
    public void outboundMessage(int seqNo) {
        delegate().outboundMessage(seqNo);
    }

    @Override // io.grpc.StreamTracer
    public void inboundMessage(int seqNo) {
        delegate().inboundMessage(seqNo);
    }

    @Override // io.grpc.StreamTracer
    public void outboundMessageSent(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        delegate().outboundMessageSent(seqNo, optionalWireSize, optionalUncompressedSize);
    }

    @Override // io.grpc.StreamTracer
    public void inboundMessageRead(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        delegate().inboundMessageRead(seqNo, optionalWireSize, optionalUncompressedSize);
    }

    @Override // io.grpc.StreamTracer
    public void outboundWireSize(long bytes) {
        delegate().outboundWireSize(bytes);
    }

    @Override // io.grpc.StreamTracer
    public void outboundUncompressedSize(long bytes) {
        delegate().outboundUncompressedSize(bytes);
    }

    @Override // io.grpc.StreamTracer
    public void inboundWireSize(long bytes) {
        delegate().inboundWireSize(bytes);
    }

    @Override // io.grpc.StreamTracer
    public void inboundUncompressedSize(long bytes) {
        delegate().inboundUncompressedSize(bytes);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}