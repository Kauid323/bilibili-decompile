package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import javax.annotation.Nullable;

final class MetadataApplierImpl extends CallCredentials.MetadataApplier {
    private final CallOptions callOptions;
    DelayedStream delayedStream;
    boolean finalized;
    private final MetadataApplierListener listener;
    private final MethodDescriptor<?, ?> method;
    private final Metadata origHeaders;
    @Nullable
    private ClientStream returnedStream;
    private final ClientTransport transport;
    private final Object lock = new Object();
    private final Context ctx = Context.current();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface MetadataApplierListener {
        void onComplete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MetadataApplierImpl(ClientTransport transport, MethodDescriptor<?, ?> method, Metadata origHeaders, CallOptions callOptions, MetadataApplierListener listener) {
        this.transport = transport;
        this.method = method;
        this.origHeaders = origHeaders;
        this.callOptions = callOptions;
        this.listener = listener;
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void apply(Metadata headers) {
        Preconditions.checkState(!this.finalized, "apply() or fail() already called");
        Preconditions.checkNotNull(headers, "headers");
        this.origHeaders.merge(headers);
        Context origCtx = this.ctx.attach();
        try {
            ClientStream realStream = this.transport.newStream(this.method, this.origHeaders, this.callOptions);
            this.ctx.detach(origCtx);
            finalizeWith(realStream);
        } catch (Throwable th) {
            this.ctx.detach(origCtx);
            throw th;
        }
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void fail(Status status) {
        Preconditions.checkArgument(!status.isOk(), "Cannot fail with OK status");
        Preconditions.checkState(!this.finalized, "apply() or fail() already called");
        finalizeWith(new FailingClientStream(status));
    }

    private void finalizeWith(ClientStream stream) {
        Preconditions.checkState(!this.finalized, "already finalized");
        this.finalized = true;
        boolean directStream = false;
        synchronized (this.lock) {
            if (this.returnedStream == null) {
                this.returnedStream = stream;
                directStream = true;
            }
        }
        if (directStream) {
            this.listener.onComplete();
            return;
        }
        Preconditions.checkState(this.delayedStream != null, "delayedStream is null");
        Runnable slow = this.delayedStream.setStream(stream);
        if (slow != null) {
            slow.run();
        }
        this.listener.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientStream returnStream() {
        synchronized (this.lock) {
            if (this.returnedStream == null) {
                this.delayedStream = new DelayedStream();
                DelayedStream delayedStream = this.delayedStream;
                this.returnedStream = delayedStream;
                return delayedStream;
            }
            return this.returnedStream;
        }
    }
}