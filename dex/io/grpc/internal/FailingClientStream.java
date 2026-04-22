package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

public final class FailingClientStream extends NoopClientStream {
    private final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;
    private boolean started;

    public FailingClientStream(Status error) {
        this(error, ClientStreamListener.RpcProgress.PROCESSED);
    }

    public FailingClientStream(Status error, ClientStreamListener.RpcProgress rpcProgress) {
        Preconditions.checkArgument(!error.isOk(), "error must not be OK");
        this.error = error;
        this.rpcProgress = rpcProgress;
    }

    @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
    public void start(ClientStreamListener listener) {
        Preconditions.checkState(!this.started, "already started");
        this.started = true;
        listener.closed(this.error, this.rpcProgress, new Metadata());
    }

    Status getError() {
        return this.error;
    }

    @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insight) {
        insight.appendKeyValue("error", this.error).appendKeyValue("progress", this.rpcProgress);
    }
}