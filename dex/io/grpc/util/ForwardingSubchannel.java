package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Channel;
import io.grpc.ChannelLogger;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import java.util.List;

public abstract class ForwardingSubchannel extends LoadBalancer.Subchannel {
    protected abstract LoadBalancer.Subchannel delegate();

    @Override // io.grpc.LoadBalancer.Subchannel
    public void start(LoadBalancer.SubchannelStateListener listener) {
        delegate().start(listener);
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public void shutdown() {
        delegate().shutdown();
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public void requestConnection() {
        delegate().requestConnection();
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public List<EquivalentAddressGroup> getAllAddresses() {
        return delegate().getAllAddresses();
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public Channel asChannel() {
        return delegate().asChannel();
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public ChannelLogger getChannelLogger() {
        return delegate().getChannelLogger();
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public Object getInternalSubchannel() {
        return delegate().getInternalSubchannel();
    }

    @Override // io.grpc.LoadBalancer.Subchannel
    public void updateAddresses(List<EquivalentAddressGroup> addrs) {
        delegate().updateAddresses(addrs);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}