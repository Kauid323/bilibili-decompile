package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import faceverify.q;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.NameResolver;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class LoadBalancer {
    public static final Attributes.Key<Map<String, ?>> ATTR_HEALTH_CHECKING_CONFIG = Attributes.Key.create("health-checking-config");
    private int recursionCount;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Factory {
        public abstract LoadBalancer newLoadBalancer(Helper helper);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class PickSubchannelArgs {
        public abstract CallOptions getCallOptions();

        public abstract Metadata getHeaders();

        public abstract MethodDescriptor<?, ?> getMethodDescriptor();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface SubchannelStateListener {
        void onSubchannelState(ConnectivityStateInfo connectivityStateInfo);
    }

    public abstract void handleNameResolutionError(Status status);

    public abstract void shutdown();

    @Deprecated
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> servers, Attributes attributes) {
        int i2 = this.recursionCount;
        this.recursionCount = i2 + 1;
        if (i2 == 0) {
            handleResolvedAddresses(ResolvedAddresses.newBuilder().setAddresses(servers).setAttributes(attributes).build());
        }
        this.recursionCount = 0;
    }

    public void handleResolvedAddresses(ResolvedAddresses resolvedAddresses) {
        int i2 = this.recursionCount;
        this.recursionCount = i2 + 1;
        if (i2 == 0) {
            handleResolvedAddressGroups(resolvedAddresses.getAddresses(), resolvedAddresses.getAttributes());
        }
        this.recursionCount = 0;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ResolvedAddresses {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        @Nullable
        private final Object loadBalancingPolicyConfig;

        private ResolvedAddresses(List<EquivalentAddressGroup> addresses, Attributes attributes, Object loadBalancingPolicyConfig) {
            this.addresses = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.checkNotNull(addresses, "addresses")));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "attributes");
            this.loadBalancingPolicyConfig = loadBalancingPolicyConfig;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setLoadBalancingPolicyConfig(this.loadBalancingPolicyConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public Object getLoadBalancingPolicyConfig() {
            return this.loadBalancingPolicyConfig;
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses;
            private Attributes attributes = Attributes.EMPTY;
            @Nullable
            private Object loadBalancingPolicyConfig;

            Builder() {
            }

            public Builder setAddresses(List<EquivalentAddressGroup> addresses) {
                this.addresses = addresses;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setLoadBalancingPolicyConfig(@Nullable Object loadBalancingPolicyConfig) {
                this.loadBalancingPolicyConfig = loadBalancingPolicyConfig;
                return this;
            }

            public ResolvedAddresses build() {
                return new ResolvedAddresses(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.addresses).add("attributes", this.attributes).add("loadBalancingPolicyConfig", this.loadBalancingPolicyConfig).toString();
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.addresses, this.attributes, this.loadBalancingPolicyConfig});
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResolvedAddresses) {
                ResolvedAddresses that = (ResolvedAddresses) obj;
                return Objects.equal(this.addresses, that.addresses) && Objects.equal(this.attributes, that.attributes) && Objects.equal(this.loadBalancingPolicyConfig, that.loadBalancingPolicyConfig);
            }
            return false;
        }
    }

    @Deprecated
    public void handleSubchannelState(Subchannel subchannel, ConnectivityStateInfo stateInfo) {
    }

    public boolean canHandleEmptyAddressListFromNameResolution() {
        return false;
    }

    public void requestConnection() {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class SubchannelPicker {
        public abstract PickResult pickSubchannel(PickSubchannelArgs pickSubchannelArgs);

        @Deprecated
        public void requestConnection() {
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class PickResult {
        private static final PickResult NO_RESULT = new PickResult(null, null, Status.OK, false);
        private final boolean drop;
        private final Status status;
        @Nullable
        private final ClientStreamTracer.Factory streamTracerFactory;
        @Nullable
        private final Subchannel subchannel;

        private PickResult(@Nullable Subchannel subchannel, @Nullable ClientStreamTracer.Factory streamTracerFactory, Status status, boolean drop) {
            this.subchannel = subchannel;
            this.streamTracerFactory = streamTracerFactory;
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            this.drop = drop;
        }

        public static PickResult withSubchannel(Subchannel subchannel, @Nullable ClientStreamTracer.Factory streamTracerFactory) {
            return new PickResult((Subchannel) Preconditions.checkNotNull(subchannel, "subchannel"), streamTracerFactory, Status.OK, false);
        }

        public static PickResult withSubchannel(Subchannel subchannel) {
            return withSubchannel(subchannel, null);
        }

        public static PickResult withError(Status error) {
            Preconditions.checkArgument(!error.isOk(), "error status shouldn't be OK");
            return new PickResult(null, null, error, false);
        }

        public static PickResult withDrop(Status status) {
            Preconditions.checkArgument(!status.isOk(), "drop status shouldn't be OK");
            return new PickResult(null, null, status, true);
        }

        public static PickResult withNoResult() {
            return NO_RESULT;
        }

        @Nullable
        public Subchannel getSubchannel() {
            return this.subchannel;
        }

        @Nullable
        public ClientStreamTracer.Factory getStreamTracerFactory() {
            return this.streamTracerFactory;
        }

        public Status getStatus() {
            return this.status;
        }

        public boolean isDrop() {
            return this.drop;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("subchannel", this.subchannel).add("streamTracerFactory", this.streamTracerFactory).add("status", this.status).add("drop", this.drop).toString();
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.subchannel, this.status, this.streamTracerFactory, Boolean.valueOf(this.drop)});
        }

        public boolean equals(Object other) {
            if (other instanceof PickResult) {
                PickResult that = (PickResult) other;
                return Objects.equal(this.subchannel, that.subchannel) && Objects.equal(this.status, that.status) && Objects.equal(this.streamTracerFactory, that.streamTracerFactory) && this.drop == that.drop;
            }
            return false;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CreateSubchannelArgs {
        private final List<EquivalentAddressGroup> addrs;
        private final Attributes attrs;
        private final Object[][] customOptions;

        private CreateSubchannelArgs(List<EquivalentAddressGroup> addrs, Attributes attrs, Object[][] customOptions) {
            this.addrs = (List) Preconditions.checkNotNull(addrs, "addresses are not set");
            this.attrs = (Attributes) Preconditions.checkNotNull(attrs, "attrs");
            this.customOptions = (Object[][]) Preconditions.checkNotNull(customOptions, "customOptions");
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addrs;
        }

        public Attributes getAttributes() {
            return this.attrs;
        }

        public <T> T getOption(Key<T> key) {
            Preconditions.checkNotNull(key, q.KEY_RES_9_KEY);
            for (int i2 = 0; i2 < this.customOptions.length; i2++) {
                if (key.equals(this.customOptions[i2][0])) {
                    return (T) this.customOptions[i2][1];
                }
            }
            return (T) ((Key) key).defaultValue;
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addrs).setAttributes(this.attrs).copyCustomOptions(this.customOptions);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addrs", this.addrs).add("attrs", this.attrs).add("customOptions", Arrays.deepToString(this.customOptions)).toString();
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addrs;
            private Attributes attrs = Attributes.EMPTY;
            private Object[][] customOptions = (Object[][]) Array.newInstance(Object.class, 0, 2);

            Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public <T> Builder copyCustomOptions(Object[][] options) {
                this.customOptions = (Object[][]) Array.newInstance(Object.class, options.length, 2);
                System.arraycopy(options, 0, this.customOptions, 0, options.length);
                return this;
            }

            public <T> Builder addOption(Key<T> key, T value) {
                Preconditions.checkNotNull(key, q.KEY_RES_9_KEY);
                Preconditions.checkNotNull(value, "value");
                int existingIdx = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.customOptions.length) {
                        break;
                    } else if (!key.equals(this.customOptions[i2][0])) {
                        i2++;
                    } else {
                        existingIdx = i2;
                        break;
                    }
                }
                if (existingIdx == -1) {
                    Object[][] newCustomOptions = (Object[][]) Array.newInstance(Object.class, this.customOptions.length + 1, 2);
                    System.arraycopy(this.customOptions, 0, newCustomOptions, 0, this.customOptions.length);
                    this.customOptions = newCustomOptions;
                    existingIdx = this.customOptions.length - 1;
                }
                Object[][] newCustomOptions2 = this.customOptions;
                Object[] objArr = new Object[2];
                objArr[0] = key;
                objArr[1] = value;
                newCustomOptions2[existingIdx] = objArr;
                return this;
            }

            public Builder setAddresses(EquivalentAddressGroup addrs) {
                this.addrs = Collections.singletonList(addrs);
                return this;
            }

            public Builder setAddresses(List<EquivalentAddressGroup> addrs) {
                Preconditions.checkArgument(!addrs.isEmpty(), "addrs is empty");
                this.addrs = Collections.unmodifiableList(new ArrayList(addrs));
                return this;
            }

            public Builder setAttributes(Attributes attrs) {
                this.attrs = (Attributes) Preconditions.checkNotNull(attrs, "attrs");
                return this;
            }

            public CreateSubchannelArgs build() {
                return new CreateSubchannelArgs(this.addrs, this.attrs, this.customOptions);
            }
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Key<T> {
            private final String debugString;
            private final T defaultValue;

            private Key(String debugString, T defaultValue) {
                this.debugString = debugString;
                this.defaultValue = defaultValue;
            }

            public static <T> Key<T> create(String debugString) {
                Preconditions.checkNotNull(debugString, "debugString");
                return new Key<>(debugString, null);
            }

            public static <T> Key<T> createWithDefault(String debugString, T defaultValue) {
                Preconditions.checkNotNull(debugString, "debugString");
                return new Key<>(debugString, defaultValue);
            }

            public T getDefault() {
                return this.defaultValue;
            }

            public String toString() {
                return this.debugString;
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Helper {
        public abstract ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str);

        public abstract String getAuthority();

        public abstract void updateBalancingState(@Nonnull ConnectivityState connectivityState, @Nonnull SubchannelPicker subchannelPicker);

        public Subchannel createSubchannel(CreateSubchannelArgs args) {
            throw new UnsupportedOperationException();
        }

        public void updateOobChannelAddresses(ManagedChannel channel, EquivalentAddressGroup eag) {
            throw new UnsupportedOperationException();
        }

        public ManagedChannel createResolvingOobChannel(String target) {
            return createResolvingOobChannelBuilder(target).build();
        }

        @Deprecated
        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String target) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String target, ChannelCredentials creds) {
            throw new UnsupportedOperationException();
        }

        public void refreshNameResolution() {
            throw new UnsupportedOperationException();
        }

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            throw new UnsupportedOperationException();
        }

        public ChannelCredentials getChannelCredentials() {
            return getUnsafeChannelCredentials().withoutBearerTokens();
        }

        public ChannelCredentials getUnsafeChannelCredentials() {
            throw new UnsupportedOperationException();
        }

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        public NameResolver.Args getNameResolverArgs() {
            throw new UnsupportedOperationException();
        }

        public NameResolverRegistry getNameResolverRegistry() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Subchannel {
        public abstract Attributes getAttributes();

        public abstract void requestConnection();

        public abstract void shutdown();

        public void start(SubchannelStateListener listener) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public final EquivalentAddressGroup getAddresses() {
            List<EquivalentAddressGroup> groups = getAllAddresses();
            Preconditions.checkState(groups.size() == 1, "%s does not have exactly one group", groups);
            return groups.get(0);
        }

        public List<EquivalentAddressGroup> getAllAddresses() {
            throw new UnsupportedOperationException();
        }

        public Channel asChannel() {
            throw new UnsupportedOperationException();
        }

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        public void updateAddresses(List<EquivalentAddressGroup> addrs) {
            throw new UnsupportedOperationException();
        }

        public Object getInternalSubchannel() {
            throw new UnsupportedOperationException();
        }
    }
}