package io.grpc;

import javax.annotation.Nullable;

public abstract class ClientCall<ReqT, RespT> {
    public abstract void cancel(@Nullable String str, @Nullable Throwable th);

    public abstract void halfClose();

    public abstract void request(int i2);

    public abstract void sendMessage(ReqT reqt);

    public abstract void start(Listener<RespT> listener, Metadata metadata);

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Listener<T> {
        public void onHeaders(Metadata headers) {
        }

        public void onMessage(T message) {
        }

        public void onClose(Status status, Metadata trailers) {
        }

        public void onReady() {
        }
    }

    public boolean isReady() {
        return true;
    }

    public void setMessageCompression(boolean enabled) {
    }

    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }
}