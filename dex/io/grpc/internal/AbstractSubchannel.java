package io.grpc.internal;

import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.LoadBalancer;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class AbstractSubchannel extends LoadBalancer.Subchannel {
    abstract InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel();
}