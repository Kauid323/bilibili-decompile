package io.grpc.internal;

public interface BackoffPolicy {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Provider {
        BackoffPolicy get();
    }

    long nextBackoffNanos();
}