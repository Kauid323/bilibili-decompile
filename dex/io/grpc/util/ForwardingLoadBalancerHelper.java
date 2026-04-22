package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.SynchronizationContext;
import java.util.concurrent.ScheduledExecutorService;

public abstract class ForwardingLoadBalancerHelper extends LoadBalancer.Helper {
    protected abstract LoadBalancer.Helper delegate();

    @Override // io.grpc.LoadBalancer.Helper
    public LoadBalancer.Subchannel createSubchannel(LoadBalancer.CreateSubchannelArgs args) {
        return delegate().createSubchannel(args);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannel createOobChannel(EquivalentAddressGroup eag, String authority) {
        return delegate().createOobChannel(eag, authority);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void updateOobChannelAddresses(ManagedChannel channel, EquivalentAddressGroup eag) {
        delegate().updateOobChannelAddresses(channel, eag);
    }

    @Override // io.grpc.LoadBalancer.Helper
    @Deprecated
    public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String target) {
        return delegate().createResolvingOobChannelBuilder(target);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String target, ChannelCredentials creds) {
        return delegate().createResolvingOobChannelBuilder(target, creds);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannel createResolvingOobChannel(String target) {
        return delegate().createResolvingOobChannel(target);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void updateBalancingState(ConnectivityState newState, LoadBalancer.SubchannelPicker newPicker) {
        delegate().updateBalancingState(newState, newPicker);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void refreshNameResolution() {
        delegate().refreshNameResolution();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public String getAuthority() {
        return delegate().getAuthority();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ChannelCredentials getChannelCredentials() {
        return delegate().getChannelCredentials();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ChannelCredentials getUnsafeChannelCredentials() {
        return delegate().getUnsafeChannelCredentials();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public SynchronizationContext getSynchronizationContext() {
        return delegate().getSynchronizationContext();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ScheduledExecutorService getScheduledExecutorService() {
        return delegate().getScheduledExecutorService();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ChannelLogger getChannelLogger() {
        return delegate().getChannelLogger();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public NameResolver.Args getNameResolverArgs() {
        return delegate().getNameResolverArgs();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public NameResolverRegistry getNameResolverRegistry() {
        return delegate().getNameResolverRegistry();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}