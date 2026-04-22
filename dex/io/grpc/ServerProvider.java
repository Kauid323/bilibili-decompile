package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ManagedChannelProvider;

public abstract class ServerProvider {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ServerBuilder<?> builderForPort(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isAvailable();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int priority();

    public static ServerProvider provider() {
        ServerProvider provider = ServerRegistry.getDefaultRegistry().provider();
        if (provider == null) {
            throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
        }
        return provider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NewServerBuilderResult newServerBuilderForPort(int port, ServerCredentials creds) {
        return NewServerBuilderResult.error("ServerCredentials are unsupported");
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class NewServerBuilderResult {
        private final String error;
        private final ServerBuilder<?> serverBuilder;

        private NewServerBuilderResult(ServerBuilder<?> serverBuilder, String error) {
            this.serverBuilder = serverBuilder;
            this.error = error;
        }

        public static NewServerBuilderResult serverBuilder(ServerBuilder<?> builder) {
            return new NewServerBuilderResult((ServerBuilder) Preconditions.checkNotNull(builder), null);
        }

        public static NewServerBuilderResult error(String error) {
            return new NewServerBuilderResult(null, (String) Preconditions.checkNotNull(error));
        }

        public ServerBuilder<?> getServerBuilder() {
            return this.serverBuilder;
        }

        public String getError() {
            return this.error;
        }
    }
}