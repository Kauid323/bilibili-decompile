package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import java.util.concurrent.Executor;

public final class CompositeCallCredentials extends CallCredentials {
    private final CallCredentials credentials1;
    private final CallCredentials credentials2;

    public CompositeCallCredentials(CallCredentials creds1, CallCredentials creds2) {
        this.credentials1 = (CallCredentials) Preconditions.checkNotNull(creds1, "creds1");
        this.credentials2 = (CallCredentials) Preconditions.checkNotNull(creds2, "creds2");
    }

    @Override // io.grpc.CallCredentials
    public void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor appExecutor, CallCredentials.MetadataApplier applier) {
        this.credentials1.applyRequestMetadata(requestInfo, appExecutor, new WrappingMetadataApplier(requestInfo, appExecutor, applier, Context.current()));
    }

    @Override // io.grpc.CallCredentials
    public void thisUsesUnstableApi() {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class WrappingMetadataApplier extends CallCredentials.MetadataApplier {
        private final Executor appExecutor;
        private final Context context;
        private final CallCredentials.MetadataApplier delegate;
        private final CallCredentials.RequestInfo requestInfo;

        public WrappingMetadataApplier(CallCredentials.RequestInfo requestInfo, Executor appExecutor, CallCredentials.MetadataApplier delegate, Context context) {
            this.requestInfo = requestInfo;
            this.appExecutor = appExecutor;
            this.delegate = (CallCredentials.MetadataApplier) Preconditions.checkNotNull(delegate, "delegate");
            this.context = (Context) Preconditions.checkNotNull(context, "context");
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void apply(Metadata headers) {
            Preconditions.checkNotNull(headers, "headers");
            Context previous = this.context.attach();
            try {
                CompositeCallCredentials.this.credentials2.applyRequestMetadata(this.requestInfo, this.appExecutor, new CombiningMetadataApplier(this.delegate, headers));
            } finally {
                this.context.detach(previous);
            }
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void fail(Status status) {
            this.delegate.fail(status);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class CombiningMetadataApplier extends CallCredentials.MetadataApplier {
        private final CallCredentials.MetadataApplier delegate;
        private final Metadata firstHeaders;

        public CombiningMetadataApplier(CallCredentials.MetadataApplier delegate, Metadata firstHeaders) {
            this.delegate = delegate;
            this.firstHeaders = firstHeaders;
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void apply(Metadata headers) {
            Preconditions.checkNotNull(headers, "headers");
            Metadata combined = new Metadata();
            combined.merge(this.firstHeaders);
            combined.merge(headers);
            this.delegate.apply(combined);
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void fail(Status status) {
            this.delegate.fail(status);
        }
    }
}