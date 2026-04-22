package io.grpc;

import io.grpc.CallCredentials;
import java.util.concurrent.Executor;

@Deprecated
public abstract class CallCredentials2 extends CallCredentials {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class MetadataApplier extends CallCredentials.MetadataApplier {
    }

    public abstract void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier);

    @Override // io.grpc.CallCredentials
    public final void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor appExecutor, final CallCredentials.MetadataApplier applier) {
        applyRequestMetadata(requestInfo, appExecutor, new MetadataApplier() { // from class: io.grpc.CallCredentials2.1
            @Override // io.grpc.CallCredentials.MetadataApplier
            public void apply(Metadata headers) {
                applier.apply(headers);
            }

            @Override // io.grpc.CallCredentials.MetadataApplier
            public void fail(Status status) {
                applier.fail(status);
            }
        });
    }
}