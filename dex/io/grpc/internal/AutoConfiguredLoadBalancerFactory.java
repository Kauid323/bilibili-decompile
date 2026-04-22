package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.ServiceConfigUtil;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public final class AutoConfiguredLoadBalancerFactory {
    private final String defaultPolicy;
    private final LoadBalancerRegistry registry;

    public AutoConfiguredLoadBalancerFactory(String defaultPolicy) {
        this(LoadBalancerRegistry.getDefaultRegistry(), defaultPolicy);
    }

    AutoConfiguredLoadBalancerFactory(LoadBalancerRegistry registry, String defaultPolicy) {
        this.registry = (LoadBalancerRegistry) Preconditions.checkNotNull(registry, "registry");
        this.defaultPolicy = (String) Preconditions.checkNotNull(defaultPolicy, "defaultPolicy");
    }

    public AutoConfiguredLoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new AutoConfiguredLoadBalancer(helper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class NoopLoadBalancer extends LoadBalancer {
        private NoopLoadBalancer() {
        }

        @Override // io.grpc.LoadBalancer
        @Deprecated
        public void handleResolvedAddressGroups(List<EquivalentAddressGroup> s, Attributes a) {
        }

        @Override // io.grpc.LoadBalancer
        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        }

        @Override // io.grpc.LoadBalancer
        public void handleNameResolutionError(Status error) {
        }

        @Override // io.grpc.LoadBalancer
        public void shutdown() {
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class AutoConfiguredLoadBalancer {
        private LoadBalancer delegate;
        private LoadBalancerProvider delegateProvider;
        private final LoadBalancer.Helper helper;

        AutoConfiguredLoadBalancer(LoadBalancer.Helper helper) {
            this.helper = helper;
            this.delegateProvider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.this.defaultPolicy);
            if (this.delegateProvider == null) {
                throw new IllegalStateException("Could not find policy '" + AutoConfiguredLoadBalancerFactory.this.defaultPolicy + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
            }
            this.delegate = this.delegateProvider.newLoadBalancer(helper);
        }

        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            tryHandleResolvedAddresses(resolvedAddresses);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Status tryHandleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
            Attributes attributes = resolvedAddresses.getAttributes();
            ServiceConfigUtil.PolicySelection policySelection = (ServiceConfigUtil.PolicySelection) resolvedAddresses.getLoadBalancingPolicyConfig();
            if (policySelection == null) {
                try {
                    LoadBalancerProvider defaultProvider = AutoConfiguredLoadBalancerFactory.this.getProviderOrThrow(AutoConfiguredLoadBalancerFactory.this.defaultPolicy, "using default policy");
                    policySelection = new ServiceConfigUtil.PolicySelection(defaultProvider, null);
                } catch (PolicyException e2) {
                    Status s = Status.INTERNAL.withDescription(e2.getMessage());
                    this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new FailingPicker(s));
                    this.delegate.shutdown();
                    this.delegateProvider = null;
                    this.delegate = new NoopLoadBalancer();
                    return Status.OK;
                }
            }
            if (this.delegateProvider == null || !policySelection.provider.getPolicyName().equals(this.delegateProvider.getPolicyName())) {
                this.helper.updateBalancingState(ConnectivityState.CONNECTING, new EmptyPicker());
                this.delegate.shutdown();
                this.delegateProvider = policySelection.provider;
                LoadBalancer old = this.delegate;
                this.delegate = this.delegateProvider.newLoadBalancer(this.helper);
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.INFO, "Load balancer changed from {0} to {1}", old.getClass().getSimpleName(), this.delegate.getClass().getSimpleName());
            }
            Object lbConfig = policySelection.config;
            if (lbConfig != null) {
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "Load-balancing config: {0}", policySelection.config);
            }
            LoadBalancer delegate = getDelegate();
            if (resolvedAddresses.getAddresses().isEmpty() && !delegate.canHandleEmptyAddressListFromNameResolution()) {
                return Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + servers + ", attrs=" + attributes);
            }
            delegate.handleResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(resolvedAddresses.getAddresses()).setAttributes(attributes).setLoadBalancingPolicyConfig(lbConfig).build());
            return Status.OK;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void handleNameResolutionError(Status error) {
            getDelegate().handleNameResolutionError(error);
        }

        @Deprecated
        void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
            getDelegate().handleSubchannelState(subchannel, stateInfo);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void requestConnection() {
            getDelegate().requestConnection();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void shutdown() {
            this.delegate.shutdown();
            this.delegate = null;
        }

        public LoadBalancer getDelegate() {
            return this.delegate;
        }

        void setDelegate(LoadBalancer lb) {
            this.delegate = lb;
        }

        LoadBalancerProvider getDelegateProvider() {
            return this.delegateProvider;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoadBalancerProvider getProviderOrThrow(String policy, String choiceReason) throws PolicyException {
        LoadBalancerProvider provider = this.registry.getProvider(policy);
        if (provider == null) {
            throw new PolicyException("Trying to load '" + policy + "' because " + choiceReason + ", but it's unavailable");
        }
        return provider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public NameResolver.ConfigOrError parseLoadBalancerPolicy(Map<String, ?> serviceConfig) {
        List<ServiceConfigUtil.LbConfig> loadBalancerConfigs = null;
        if (serviceConfig != null) {
            try {
                List<Map<String, ?>> rawLbConfigs = ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(serviceConfig);
                loadBalancerConfigs = ServiceConfigUtil.unwrapLoadBalancingConfigList(rawLbConfigs);
            } catch (RuntimeException e2) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("can't parse load balancer configuration").withCause(e2));
            }
        }
        if (loadBalancerConfigs != null && !loadBalancerConfigs.isEmpty()) {
            return ServiceConfigUtil.selectLbPolicyFromList(loadBalancerConfigs, this.registry);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class PolicyException extends Exception {
        private static final long serialVersionUID = 1;

        private PolicyException(String msg) {
            super(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class EmptyPicker extends LoadBalancer.SubchannelPicker {
        private EmptyPicker() {
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withNoResult();
        }

        public String toString() {
            return MoreObjects.toStringHelper(EmptyPicker.class).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class FailingPicker extends LoadBalancer.SubchannelPicker {
        private final Status failure;

        FailingPicker(Status failure) {
            this.failure = failure;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withError(this.failure);
        }
    }
}