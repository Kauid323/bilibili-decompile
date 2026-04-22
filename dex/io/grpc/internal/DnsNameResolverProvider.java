package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import io.grpc.InternalServiceProviders;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import java.net.URI;

public final class DnsNameResolverProvider extends NameResolverProvider {
    private static final String SCHEME = "dns";

    @Override // io.grpc.NameResolver.Factory
    public DnsNameResolver newNameResolver(URI targetUri, NameResolver.Args args) {
        if (SCHEME.equals(targetUri.getScheme())) {
            String targetPath = (String) Preconditions.checkNotNull(targetUri.getPath(), "targetPath");
            Preconditions.checkArgument(targetPath.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", targetPath, targetUri);
            String name = targetPath.substring(1);
            return new DnsNameResolver(targetUri.getAuthority(), name, args, GrpcUtil.SHARED_CHANNEL_EXECUTOR, Stopwatch.createUnstarted(), InternalServiceProviders.isAndroid(getClass().getClassLoader()));
        }
        return null;
    }

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return SCHEME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.NameResolverProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.NameResolverProvider
    public int priority() {
        return 5;
    }
}