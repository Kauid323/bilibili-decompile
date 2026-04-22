package io.grpc.internal;

import io.grpc.Metadata;
import io.grpc.Status;

public interface ClientStreamListener extends StreamListener {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum RpcProgress {
        PROCESSED,
        REFUSED,
        DROPPED
    }

    void closed(Status status, Metadata metadata);

    void closed(Status status, RpcProgress rpcProgress, Metadata metadata);

    void headersRead(Metadata metadata);
}