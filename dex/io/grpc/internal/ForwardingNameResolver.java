package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;

abstract class ForwardingNameResolver extends NameResolver {
    private final NameResolver delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForwardingNameResolver(NameResolver delegate) {
        Preconditions.checkNotNull(delegate, "delegate can not be null");
        this.delegate = delegate;
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.delegate.getServiceAuthority();
    }

    @Override // io.grpc.NameResolver
    @Deprecated
    public void start(NameResolver.Listener listener) {
        this.delegate.start(listener);
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener) {
        this.delegate.start(listener);
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        this.delegate.refresh();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
    }
}