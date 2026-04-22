package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;

abstract class ForwardingClientStream implements ClientStream {
    protected abstract ClientStream delegate();

    @Override // io.grpc.internal.Stream
    public void request(int numMessages) {
        delegate().request(numMessages);
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(InputStream message) {
        delegate().writeMessage(message);
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
        delegate().flush();
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delegate().optimizeForDirectExecutor();
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(Compressor compressor) {
        delegate().setCompressor(compressor);
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(boolean enable) {
        delegate().setMessageCompression(enable);
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(Status reason) {
        delegate().cancel(reason);
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String authority) {
        delegate().setAuthority(authority);
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(boolean fullStreamDecompression) {
        delegate().setFullStreamDecompression(fullStreamDecompression);
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().setDecompressorRegistry(decompressorRegistry);
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener listener) {
        delegate().start(listener);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(int maxSize) {
        delegate().setMaxInboundMessageSize(maxSize);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(int maxSize) {
        delegate().setMaxOutboundMessageSize(maxSize);
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(Deadline deadline) {
        delegate().setDeadline(deadline);
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insight) {
        delegate().appendTimeoutInsight(insight);
    }
}