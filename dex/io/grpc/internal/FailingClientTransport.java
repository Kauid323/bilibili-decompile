package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.CallOptions;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
public class FailingClientTransport implements ClientTransport {
    final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FailingClientTransport(Status error, ClientStreamListener.RpcProgress rpcProgress) {
        Preconditions.checkArgument(!error.isOk(), "error must not be OK");
        this.error = error;
        this.rpcProgress = rpcProgress;
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions) {
        return new FailingClientStream(this.error, this.rpcProgress);
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(final ClientTransport.PingCallback callback, Executor executor) {
        executor.execute(new Runnable() { // from class: io.grpc.internal.FailingClientTransport.1
            @Override // java.lang.Runnable
            public void run() {
                callback.onFailure(FailingClientTransport.this.error.asException());
            }
        });
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture<InternalChannelz.SocketStats> ret = SettableFuture.create();
        ret.set((Object) null);
        return ret;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}