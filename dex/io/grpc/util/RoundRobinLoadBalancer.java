package io.grpc.util;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nonnull;

final class RoundRobinLoadBalancer extends LoadBalancer {
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;
    static final Attributes.Key<Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.create("state-info");
    private static final Status EMPTY_OK = Status.OK.withDescription("no subchannels ready");
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();
    private RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private final Random random = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundRobinLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
        Set<EquivalentAddressGroup> currentAddrs = this.subchannels.keySet();
        Map<EquivalentAddressGroup, EquivalentAddressGroup> latestAddrs = stripAttrs(servers);
        Set<EquivalentAddressGroup> removedAddrs = setsDifference(currentAddrs, latestAddrs.keySet());
        for (Map.Entry<EquivalentAddressGroup, EquivalentAddressGroup> latestEntry : latestAddrs.entrySet()) {
            EquivalentAddressGroup strippedAddressGroup = latestEntry.getKey();
            EquivalentAddressGroup originalAddressGroup = latestEntry.getValue();
            LoadBalancer.Subchannel existingSubchannel = this.subchannels.get(strippedAddressGroup);
            if (existingSubchannel != null) {
                existingSubchannel.updateAddresses(Collections.singletonList(originalAddressGroup));
            } else {
                Attributes.Builder subchannelAttrs = Attributes.newBuilder().set(STATE_INFO, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE)));
                final LoadBalancer.Subchannel subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(originalAddressGroup).setAttributes(subchannelAttrs.build()).build()), "subchannel");
                subchannel.start(new LoadBalancer.SubchannelStateListener() { // from class: io.grpc.util.RoundRobinLoadBalancer.1
                    @Override // io.grpc.LoadBalancer.SubchannelStateListener
                    public void onSubchannelState(ConnectivityStateInfo state) {
                        RoundRobinLoadBalancer.this.processSubchannelState(subchannel, state);
                    }
                });
                this.subchannels.put(strippedAddressGroup, subchannel);
                subchannel.requestConnection();
            }
        }
        ArrayList<LoadBalancer.Subchannel> removedSubchannels = new ArrayList<>();
        for (EquivalentAddressGroup addressGroup : removedAddrs) {
            removedSubchannels.add(this.subchannels.remove(addressGroup));
        }
        updateBalancingState();
        Iterator<LoadBalancer.Subchannel> it = removedSubchannels.iterator();
        while (it.hasNext()) {
            LoadBalancer.Subchannel removedSubchannel = it.next();
            shutdownSubchannel(removedSubchannel);
        }
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status error) {
        if (this.currentState != ConnectivityState.READY) {
            updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
        if (this.subchannels.get(stripAttrs(subchannel.getAddresses())) != subchannel) {
            return;
        }
        if (stateInfo.getState() == ConnectivityState.IDLE) {
            subchannel.requestConnection();
        }
        Ref<ConnectivityStateInfo> subchannelStateRef = getSubchannelStateInfoRef(subchannel);
        if (subchannelStateRef.value.getState().equals(ConnectivityState.TRANSIENT_FAILURE) && (stateInfo.getState().equals(ConnectivityState.CONNECTING) || stateInfo.getState().equals(ConnectivityState.IDLE))) {
            return;
        }
        subchannelStateRef.value = stateInfo;
        updateBalancingState();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, io.grpc.ConnectivityStateInfo] */
    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).value = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        for (LoadBalancer.Subchannel subchannel : getSubchannels()) {
            shutdownSubchannel(subchannel);
        }
    }

    private void updateBalancingState() {
        List<LoadBalancer.Subchannel> activeList = filterNonFailingSubchannels(getSubchannels());
        if (activeList.isEmpty()) {
            boolean isConnecting = false;
            Status aggStatus = EMPTY_OK;
            for (LoadBalancer.Subchannel subchannel : getSubchannels()) {
                ConnectivityStateInfo stateInfo = getSubchannelStateInfoRef(subchannel).value;
                isConnecting = (stateInfo.getState() == ConnectivityState.CONNECTING || stateInfo.getState() == ConnectivityState.IDLE) ? true : true;
                if (aggStatus == EMPTY_OK || !aggStatus.isOk()) {
                    aggStatus = stateInfo.getStatus();
                }
            }
            updateBalancingState(isConnecting ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(aggStatus));
            return;
        }
        int startIndex = this.random.nextInt(activeList.size());
        updateBalancingState(ConnectivityState.READY, new ReadyPicker(activeList, startIndex));
    }

    private void updateBalancingState(ConnectivityState state, RoundRobinPicker picker) {
        if (state != this.currentState || !picker.isEquivalentTo(this.currentPicker)) {
            this.helper.updateBalancingState(state, picker);
            this.currentState = state;
            this.currentPicker = picker;
        }
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> subchannels) {
        List<LoadBalancer.Subchannel> readySubchannels = new ArrayList<>(subchannels.size());
        for (LoadBalancer.Subchannel subchannel : subchannels) {
            if (isReady(subchannel)) {
                readySubchannels.add(subchannel);
            }
        }
        return readySubchannels;
    }

    private static Map<EquivalentAddressGroup, EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> groupList) {
        Map<EquivalentAddressGroup, EquivalentAddressGroup> addrs = new HashMap<>(groupList.size() * 2);
        for (EquivalentAddressGroup group : groupList) {
            addrs.put(stripAttrs(group), group);
        }
        return addrs;
    }

    private static EquivalentAddressGroup stripAttrs(EquivalentAddressGroup eag) {
        return new EquivalentAddressGroup(eag.getAddresses());
    }

    Collection<LoadBalancer.Subchannel> getSubchannels() {
        return this.subchannels.values();
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) Preconditions.checkNotNull(subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }

    static boolean isReady(LoadBalancer.Subchannel subchannel) {
        return getSubchannelStateInfoRef(subchannel).value.getState() == ConnectivityState.READY;
    }

    private static <T> Set<T> setsDifference(Set<T> a, Set<T> b) {
        Set<T> aCopy = new HashSet<>(a);
        aCopy.removeAll(b);
        return aCopy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        abstract boolean isEquivalentTo(RoundRobinPicker roundRobinPicker);

        private RoundRobinPicker() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, "index");
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;

        ReadyPicker(List<LoadBalancer.Subchannel> list, int startIndex) {
            super();
            Preconditions.checkArgument(!list.isEmpty(), "empty list");
            this.list = list;
            this.index = startIndex - 1;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withSubchannel(nextSubchannel());
        }

        public String toString() {
            return MoreObjects.toStringHelper(ReadyPicker.class).add("list", this.list).toString();
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int size = this.list.size();
            int i2 = indexUpdater.incrementAndGet(this);
            if (i2 >= size) {
                i2 %= size;
                indexUpdater.compareAndSet(this, i2, i2);
            }
            return this.list.get(i2);
        }

        List<LoadBalancer.Subchannel> getList() {
            return this.list;
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        boolean isEquivalentTo(RoundRobinPicker picker) {
            if (picker instanceof ReadyPicker) {
                ReadyPicker other = (ReadyPicker) picker;
                return other == this || (this.list.size() == other.list.size() && new HashSet(this.list).containsAll(other.list));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        EmptyPicker(@Nonnull Status status) {
            super();
            this.status = (Status) Preconditions.checkNotNull(status, "status");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        boolean isEquivalentTo(RoundRobinPicker picker) {
            return (picker instanceof EmptyPicker) && (Objects.equal(this.status, ((EmptyPicker) picker).status) || (this.status.isOk() && ((EmptyPicker) picker).status.isOk()));
        }

        public String toString() {
            return MoreObjects.toStringHelper(EmptyPicker.class).add("status", this.status).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Ref<T> {
        T value;

        Ref(T value) {
            this.value = value;
        }
    }
}