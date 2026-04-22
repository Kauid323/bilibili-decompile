package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class PickFirstLoadBalancer extends LoadBalancer {
    private final LoadBalancer.Helper helper;
    private LoadBalancer.Subchannel subchannel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PickFirstLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
        if (this.subchannel == null) {
            final LoadBalancer.Subchannel subchannel = this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(servers).build());
            subchannel.start(new LoadBalancer.SubchannelStateListener() { // from class: io.grpc.internal.PickFirstLoadBalancer.1
                @Override // io.grpc.LoadBalancer.SubchannelStateListener
                public void onSubchannelState(ConnectivityStateInfo stateInfo) {
                    PickFirstLoadBalancer.this.processSubchannelState(subchannel, stateInfo);
                }
            });
            this.subchannel = subchannel;
            this.helper.updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withSubchannel(subchannel)));
            subchannel.requestConnection();
            return;
        }
        this.subchannel.updateAddresses(servers);
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status error) {
        if (this.subchannel != null) {
            this.subchannel.shutdown();
            this.subchannel = null;
        }
        this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(error)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
        LoadBalancer.SubchannelPicker picker;
        ConnectivityState currentState = stateInfo.getState();
        if (currentState == ConnectivityState.SHUTDOWN) {
            return;
        }
        switch (currentState) {
            case IDLE:
                picker = new RequestConnectionPicker(subchannel);
                break;
            case CONNECTING:
                picker = new Picker(LoadBalancer.PickResult.withNoResult());
                break;
            case READY:
                picker = new Picker(LoadBalancer.PickResult.withSubchannel(subchannel));
                break;
            case TRANSIENT_FAILURE:
                picker = new Picker(LoadBalancer.PickResult.withError(stateInfo.getStatus()));
                break;
            default:
                throw new IllegalArgumentException("Unsupported state:" + currentState);
        }
        this.helper.updateBalancingState(currentState, picker);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        if (this.subchannel != null) {
            this.subchannel.shutdown();
        }
    }

    @Override // io.grpc.LoadBalancer
    public void requestConnection() {
        if (this.subchannel != null) {
            this.subchannel.requestConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Picker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.PickResult result;

        Picker(LoadBalancer.PickResult result) {
            this.result = (LoadBalancer.PickResult) Preconditions.checkNotNull(result, "result");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return this.result;
        }

        public String toString() {
            return MoreObjects.toStringHelper(Picker.class).add("result", this.result).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class RequestConnectionPicker extends LoadBalancer.SubchannelPicker {
        private final AtomicBoolean connectionRequested = new AtomicBoolean(false);
        private final LoadBalancer.Subchannel subchannel;

        RequestConnectionPicker(LoadBalancer.Subchannel subchannel) {
            this.subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(subchannel, "subchannel");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            if (this.connectionRequested.compareAndSet(false, true)) {
                PickFirstLoadBalancer.this.helper.getSynchronizationContext().execute(new Runnable() { // from class: io.grpc.internal.PickFirstLoadBalancer.RequestConnectionPicker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RequestConnectionPicker.this.subchannel.requestConnection();
                    }
                });
            }
            return LoadBalancer.PickResult.withNoResult();
        }
    }
}