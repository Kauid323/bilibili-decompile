package io.grpc;

import com.google.common.base.Preconditions;

public abstract class ManagedChannelProvider {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ManagedChannelBuilder<?> builderForAddress(String str, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ManagedChannelBuilder<?> builderForTarget(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isAvailable();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int priority();

    public static ManagedChannelProvider provider() {
        ManagedChannelProvider provider = ManagedChannelRegistry.getDefaultRegistry().provider();
        if (provider == null) {
            throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
        }
        return provider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NewChannelBuilderResult newChannelBuilder(String target, ChannelCredentials creds) {
        return NewChannelBuilderResult.error("ChannelCredentials are unsupported");
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class NewChannelBuilderResult {
        private final ManagedChannelBuilder<?> channelBuilder;
        private final String error;

        private NewChannelBuilderResult(ManagedChannelBuilder<?> channelBuilder, String error) {
            this.channelBuilder = channelBuilder;
            this.error = error;
        }

        public static NewChannelBuilderResult channelBuilder(ManagedChannelBuilder<?> builder) {
            return new NewChannelBuilderResult((ManagedChannelBuilder) Preconditions.checkNotNull(builder), null);
        }

        public static NewChannelBuilderResult error(String error) {
            return new NewChannelBuilderResult(null, (String) Preconditions.checkNotNull(error));
        }

        public ManagedChannelBuilder<?> getChannelBuilder() {
            return this.channelBuilder;
        }

        public String getError() {
            return this.error;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String msg) {
            super(msg);
        }
    }
}