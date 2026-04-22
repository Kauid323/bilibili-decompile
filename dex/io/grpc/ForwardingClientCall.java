package io.grpc;

import io.grpc.ClientCall;
import javax.annotation.Nullable;

public abstract class ForwardingClientCall<ReqT, RespT> extends PartialForwardingClientCall<ReqT, RespT> {
    @Override // io.grpc.PartialForwardingClientCall
    protected abstract ClientCall<ReqT, RespT> delegate();

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void cancel(@Nullable String str, @Nullable Throwable th) {
        super.cancel(str, th);
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ Attributes getAttributes() {
        return super.getAttributes();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void halfClose() {
        super.halfClose();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void request(int i2) {
        super.request(i2);
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
        super.setMessageCompression(z);
    }

    @Override // io.grpc.PartialForwardingClientCall
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> responseListener, Metadata headers) {
        delegate().start(responseListener, headers);
    }

    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT message) {
        delegate().sendMessage(message);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class SimpleForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private final ClientCall<ReqT, RespT> delegate;

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void cancel(@Nullable String str, @Nullable Throwable th) {
            super.cancel(str, th);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ Attributes getAttributes() {
            return super.getAttributes();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void halfClose() {
            super.halfClose();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ boolean isReady() {
            return super.isReady();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void request(int i2) {
            super.request(i2);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
            super.setMessageCompression(z);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SimpleForwardingClientCall(ClientCall<ReqT, RespT> delegate) {
            this.delegate = delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        protected ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }
    }
}