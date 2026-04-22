package io.grpc;

import javax.annotation.Nullable;

public abstract class ServerCall<ReqT, RespT> {
    public abstract void close(Status status, Metadata metadata);

    public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();

    public abstract boolean isCancelled();

    public abstract void request(int i2);

    public abstract void sendHeaders(Metadata metadata);

    public abstract void sendMessage(RespT respt);

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Listener<ReqT> {
        public void onMessage(ReqT message) {
        }

        public void onHalfClose() {
        }

        public void onCancel() {
        }

        public void onComplete() {
        }

        public void onReady() {
        }
    }

    public boolean isReady() {
        return true;
    }

    public void setMessageCompression(boolean enabled) {
    }

    public void setCompression(String compressor) {
    }

    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @Nullable
    public String getAuthority() {
        return null;
    }
}