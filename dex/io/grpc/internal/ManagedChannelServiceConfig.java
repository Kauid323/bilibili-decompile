package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.grpc.CallOptions;
import io.grpc.InternalConfigSelector;
import io.grpc.LoadBalancer;
import io.grpc.MethodDescriptor;
import io.grpc.internal.RetriableStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ManagedChannelServiceConfig {
    @Nullable
    private final MethodInfo defaultMethodConfig;
    @Nullable
    private final Map<String, ?> healthCheckingConfig;
    @Nullable
    private final Object loadBalancingConfig;
    @Nullable
    private final RetriableStream.Throttle retryThrottling;
    private final Map<String, MethodInfo> serviceMap;
    private final Map<String, MethodInfo> serviceMethodMap;

    ManagedChannelServiceConfig(@Nullable MethodInfo defaultMethodConfig, Map<String, MethodInfo> serviceMethodMap, Map<String, MethodInfo> serviceMap, @Nullable RetriableStream.Throttle retryThrottling, @Nullable Object loadBalancingConfig, @Nullable Map<String, ?> healthCheckingConfig) {
        Map<String, ?> map;
        this.defaultMethodConfig = defaultMethodConfig;
        this.serviceMethodMap = Collections.unmodifiableMap(new HashMap(serviceMethodMap));
        this.serviceMap = Collections.unmodifiableMap(new HashMap(serviceMap));
        this.retryThrottling = retryThrottling;
        this.loadBalancingConfig = loadBalancingConfig;
        if (healthCheckingConfig != null) {
            map = Collections.unmodifiableMap(new HashMap(healthCheckingConfig));
        } else {
            map = null;
        }
        this.healthCheckingConfig = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ManagedChannelServiceConfig empty() {
        return new ManagedChannelServiceConfig(null, new HashMap(), new HashMap(), null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ManagedChannelServiceConfig fromServiceConfig(Map<String, ?> serviceConfig, boolean retryEnabled, int maxRetryAttemptsLimit, int maxHedgedAttemptsLimit, @Nullable Object loadBalancingConfig) {
        Map<String, ?> methodConfig;
        Iterator<Map<String, ?>> it;
        List<Map<String, ?>> methodConfigs;
        boolean z = retryEnabled;
        RetriableStream.Throttle retryThrottling = z ? ServiceConfigUtil.getThrottlePolicy(serviceConfig) : null;
        Map<String, MethodInfo> serviceMethodMap = new HashMap<>();
        Map<String, MethodInfo> serviceMap = new HashMap<>();
        Map<String, ?> healthCheckingConfig = ServiceConfigUtil.getHealthCheckedService(serviceConfig);
        List<Map<String, ?>> methodConfigs2 = ServiceConfigUtil.getMethodConfigFromServiceConfig(serviceConfig);
        if (methodConfigs2 == null) {
            return new ManagedChannelServiceConfig(null, serviceMethodMap, serviceMap, retryThrottling, loadBalancingConfig, healthCheckingConfig);
        }
        Iterator<Map<String, ?>> it2 = methodConfigs2.iterator();
        MethodInfo defaultMethodConfig = null;
        while (it2.hasNext()) {
            Map<String, ?> methodConfig2 = it2.next();
            MethodInfo info = new MethodInfo(methodConfig2, z, maxRetryAttemptsLimit, maxHedgedAttemptsLimit);
            List<Map<String, ?>> nameList = ServiceConfigUtil.getNameListFromMethodConfig(methodConfig2);
            if (nameList != null && !nameList.isEmpty()) {
                for (Map<String, ?> name : nameList) {
                    String serviceName = ServiceConfigUtil.getServiceFromName(name);
                    String methodName = ServiceConfigUtil.getMethodFromName(name);
                    if (Strings.isNullOrEmpty(serviceName)) {
                        methodConfig = methodConfig2;
                        it = it2;
                        Preconditions.checkArgument(Strings.isNullOrEmpty(methodName), "missing service name for method %s", methodName);
                        methodConfigs = methodConfigs2;
                        Preconditions.checkArgument(defaultMethodConfig == null, "Duplicate default method config in service config %s", serviceConfig);
                        defaultMethodConfig = info;
                    } else {
                        methodConfig = methodConfig2;
                        it = it2;
                        methodConfigs = methodConfigs2;
                        if (Strings.isNullOrEmpty(methodName)) {
                            Preconditions.checkArgument(!serviceMap.containsKey(serviceName), "Duplicate service %s", serviceName);
                            serviceMap.put(serviceName, info);
                        } else {
                            String fullMethodName = MethodDescriptor.generateFullMethodName(serviceName, methodName);
                            Preconditions.checkArgument(!serviceMethodMap.containsKey(fullMethodName), "Duplicate method name %s", fullMethodName);
                            serviceMethodMap.put(fullMethodName, info);
                        }
                    }
                    methodConfig2 = methodConfig;
                    it2 = it;
                    methodConfigs2 = methodConfigs;
                }
                z = retryEnabled;
                methodConfigs2 = methodConfigs2;
            }
            z = retryEnabled;
            it2 = it2;
            methodConfigs2 = methodConfigs2;
        }
        return new ManagedChannelServiceConfig(defaultMethodConfig, serviceMethodMap, serviceMap, retryThrottling, loadBalancingConfig, healthCheckingConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Map<String, ?> getHealthCheckingConfig() {
        return this.healthCheckingConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public InternalConfigSelector getDefaultConfigSelector() {
        if (this.serviceMap.isEmpty() && this.serviceMethodMap.isEmpty() && this.defaultMethodConfig == null) {
            return null;
        }
        return new ServiceConfigConvertedSelector();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object getLoadBalancingConfig() {
        return this.loadBalancingConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public RetriableStream.Throttle getRetryThrottling() {
        return this.retryThrottling;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public MethodInfo getMethodConfig(MethodDescriptor<?, ?> method) {
        MethodInfo methodInfo = this.serviceMethodMap.get(method.getFullMethodName());
        if (methodInfo == null) {
            String serviceName = method.getServiceName();
            methodInfo = this.serviceMap.get(serviceName);
        }
        if (methodInfo == null) {
            return this.defaultMethodConfig;
        }
        return methodInfo;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ManagedChannelServiceConfig that = (ManagedChannelServiceConfig) o;
        if (Objects.equal(this.serviceMethodMap, that.serviceMethodMap) && Objects.equal(this.serviceMap, that.serviceMap) && Objects.equal(this.retryThrottling, that.retryThrottling) && Objects.equal(this.loadBalancingConfig, that.loadBalancingConfig)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.serviceMethodMap, this.serviceMap, this.retryThrottling, this.loadBalancingConfig});
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("serviceMethodMap", this.serviceMethodMap).add("serviceMap", this.serviceMap).add("retryThrottling", this.retryThrottling).add("loadBalancingConfig", this.loadBalancingConfig).toString();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class MethodInfo {
        static final CallOptions.Key<MethodInfo> KEY = CallOptions.Key.create("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");
        final HedgingPolicy hedgingPolicy;
        final Integer maxInboundMessageSize;
        final Integer maxOutboundMessageSize;
        final RetryPolicy retryPolicy;
        final Long timeoutNanos;
        final Boolean waitForReady;

        MethodInfo(Map<String, ?> methodConfig, boolean retryEnabled, int maxRetryAttemptsLimit, int maxHedgedAttemptsLimit) {
            this.timeoutNanos = ServiceConfigUtil.getTimeoutFromMethodConfig(methodConfig);
            this.waitForReady = ServiceConfigUtil.getWaitForReadyFromMethodConfig(methodConfig);
            this.maxInboundMessageSize = ServiceConfigUtil.getMaxResponseMessageBytesFromMethodConfig(methodConfig);
            if (this.maxInboundMessageSize != null) {
                Preconditions.checkArgument(this.maxInboundMessageSize.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", this.maxInboundMessageSize);
            }
            this.maxOutboundMessageSize = ServiceConfigUtil.getMaxRequestMessageBytesFromMethodConfig(methodConfig);
            if (this.maxOutboundMessageSize != null) {
                Preconditions.checkArgument(this.maxOutboundMessageSize.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", this.maxOutboundMessageSize);
            }
            Map<String, ?> retryPolicyMap = retryEnabled ? ServiceConfigUtil.getRetryPolicyFromMethodConfig(methodConfig) : null;
            this.retryPolicy = retryPolicyMap == null ? null : retryPolicy(retryPolicyMap, maxRetryAttemptsLimit);
            Map<String, ?> hedgingPolicyMap = retryEnabled ? ServiceConfigUtil.getHedgingPolicyFromMethodConfig(methodConfig) : null;
            this.hedgingPolicy = hedgingPolicyMap != null ? hedgingPolicy(hedgingPolicyMap, maxHedgedAttemptsLimit) : null;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.timeoutNanos, this.waitForReady, this.maxInboundMessageSize, this.maxOutboundMessageSize, this.retryPolicy, this.hedgingPolicy});
        }

        public boolean equals(Object other) {
            if (other instanceof MethodInfo) {
                MethodInfo that = (MethodInfo) other;
                return Objects.equal(this.timeoutNanos, that.timeoutNanos) && Objects.equal(this.waitForReady, that.waitForReady) && Objects.equal(this.maxInboundMessageSize, that.maxInboundMessageSize) && Objects.equal(this.maxOutboundMessageSize, that.maxOutboundMessageSize) && Objects.equal(this.retryPolicy, that.retryPolicy) && Objects.equal(this.hedgingPolicy, that.hedgingPolicy);
            }
            return false;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("timeoutNanos", this.timeoutNanos).add("waitForReady", this.waitForReady).add("maxInboundMessageSize", this.maxInboundMessageSize).add("maxOutboundMessageSize", this.maxOutboundMessageSize).add("retryPolicy", this.retryPolicy).add("hedgingPolicy", this.hedgingPolicy).toString();
        }

        private static RetryPolicy retryPolicy(Map<String, ?> retryPolicy, int maxAttemptsLimit) {
            int maxAttempts = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.getMaxAttemptsFromRetryPolicy(retryPolicy), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(maxAttempts >= 2, "maxAttempts must be greater than 1: %s", maxAttempts);
            int maxAttempts2 = Math.min(maxAttempts, maxAttemptsLimit);
            long initialBackoffNanos = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getInitialBackoffNanosFromRetryPolicy(retryPolicy), "initialBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(initialBackoffNanos > 0, "initialBackoffNanos must be greater than 0: %s", initialBackoffNanos);
            long maxBackoffNanos = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getMaxBackoffNanosFromRetryPolicy(retryPolicy), "maxBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(maxBackoffNanos > 0, "maxBackoff must be greater than 0: %s", maxBackoffNanos);
            double backoffMultiplier = ((Double) Preconditions.checkNotNull(ServiceConfigUtil.getBackoffMultiplierFromRetryPolicy(retryPolicy), "backoffMultiplier cannot be empty")).doubleValue();
            Preconditions.checkArgument(backoffMultiplier > 0.0d, "backoffMultiplier must be greater than 0: %s", Double.valueOf(backoffMultiplier));
            return new RetryPolicy(maxAttempts2, initialBackoffNanos, maxBackoffNanos, backoffMultiplier, ServiceConfigUtil.getRetryableStatusCodesFromRetryPolicy(retryPolicy));
        }

        private static HedgingPolicy hedgingPolicy(Map<String, ?> hedgingPolicy, int maxAttemptsLimit) {
            int maxAttempts = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.getMaxAttemptsFromHedgingPolicy(hedgingPolicy), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(maxAttempts >= 2, "maxAttempts must be greater than 1: %s", maxAttempts);
            int maxAttempts2 = Math.min(maxAttempts, maxAttemptsLimit);
            long hedgingDelayNanos = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getHedgingDelayNanosFromHedgingPolicy(hedgingPolicy), "hedgingDelay cannot be empty")).longValue();
            Preconditions.checkArgument(hedgingDelayNanos >= 0, "hedgingDelay must not be negative: %s", hedgingDelayNanos);
            return new HedgingPolicy(maxAttempts2, hedgingDelayNanos, ServiceConfigUtil.getNonFatalStatusCodesFromHedgingPolicy(hedgingPolicy));
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class ServiceConfigConvertedSelector extends InternalConfigSelector {
        final ManagedChannelServiceConfig config;

        private ServiceConfigConvertedSelector(ManagedChannelServiceConfig config) {
            this.config = config;
        }

        @Override // io.grpc.InternalConfigSelector
        public InternalConfigSelector.Result selectConfig(LoadBalancer.PickSubchannelArgs args) {
            return InternalConfigSelector.Result.newBuilder().setConfig(this.config).build();
        }
    }
}