package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.List;

public abstract class ForwardingLoadBalancer extends LoadBalancer {
    protected abstract LoadBalancer delegate();

    @Override // io.grpc.LoadBalancer
    @Deprecated
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> servers, Attributes attributes) {
        delegate().handleResolvedAddressGroups(servers, attributes);
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        delegate().handleResolvedAddresses(resolvedAddresses);
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status error) {
        delegate().handleNameResolutionError(error);
    }

    @Override // io.grpc.LoadBalancer
    @Deprecated
    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
        delegate().handleSubchannelState(subchannel, stateInfo);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        delegate().shutdown();
    }

    @Override // io.grpc.LoadBalancer
    public boolean canHandleEmptyAddressListFromNameResolution() {
        return delegate().canHandleEmptyAddressListFromNameResolution();
    }

    @Override // io.grpc.LoadBalancer
    public void requestConnection() {
        delegate().requestConnection();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}