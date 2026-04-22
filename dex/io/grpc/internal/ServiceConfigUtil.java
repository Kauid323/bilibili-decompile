package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.yalantis.ucrop.view.CropImageView;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.RetriableStream;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ServiceConfigUtil {
    private ServiceConfigUtil() {
    }

    @Nullable
    public static Map<String, ?> getHealthCheckedService(@Nullable Map<String, ?> serviceConfig) {
        if (serviceConfig == null) {
            return null;
        }
        return JsonUtil.getObject(serviceConfig, "healthCheckConfig");
    }

    @Nullable
    public static String getHealthCheckedServiceName(@Nullable Map<String, ?> healthCheckedServiceConfig) {
        if (healthCheckedServiceConfig == null) {
            return null;
        }
        return JsonUtil.getString(healthCheckedServiceConfig, "serviceName");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static RetriableStream.Throttle getThrottlePolicy(@Nullable Map<String, ?> serviceConfig) {
        Map<String, ?> throttling;
        if (serviceConfig == null || (throttling = JsonUtil.getObject(serviceConfig, "retryThrottling")) == null) {
            return null;
        }
        float maxTokens = JsonUtil.getNumber(throttling, "maxTokens").floatValue();
        float tokenRatio = JsonUtil.getNumber(throttling, "tokenRatio").floatValue();
        Preconditions.checkState(maxTokens > CropImageView.DEFAULT_ASPECT_RATIO, "maxToken should be greater than zero");
        Preconditions.checkState(tokenRatio > CropImageView.DEFAULT_ASPECT_RATIO, "tokenRatio should be greater than zero");
        return new RetriableStream.Throttle(maxTokens, tokenRatio);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer getMaxAttemptsFromRetryPolicy(Map<String, ?> retryPolicy) {
        return JsonUtil.getNumberAsInteger(retryPolicy, "maxAttempts");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long getInitialBackoffNanosFromRetryPolicy(Map<String, ?> retryPolicy) {
        return JsonUtil.getStringAsDuration(retryPolicy, "initialBackoff");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long getMaxBackoffNanosFromRetryPolicy(Map<String, ?> retryPolicy) {
        return JsonUtil.getStringAsDuration(retryPolicy, "maxBackoff");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Double getBackoffMultiplierFromRetryPolicy(Map<String, ?> retryPolicy) {
        return JsonUtil.getNumber(retryPolicy, "backoffMultiplier");
    }

    private static Set<Status.Code> getListOfStatusCodesAsSet(Map<String, ?> obj, String key) {
        List<?> statuses = JsonUtil.getList(obj, key);
        if (statuses == null) {
            return null;
        }
        return getStatusCodesFromList(statuses);
    }

    private static Set<Status.Code> getStatusCodesFromList(List<?> statuses) {
        Status.Code code;
        EnumSet<Status.Code> codes = EnumSet.noneOf(Status.Code.class);
        for (Object status : statuses) {
            if (status instanceof Double) {
                Double statusD = (Double) status;
                int codeValue = statusD.intValue();
                Verify.verify(((double) codeValue) == statusD.doubleValue(), "Status code %s is not integral", status);
                code = Status.fromCodeValue(codeValue).getCode();
                Verify.verify(code.value() == statusD.intValue(), "Status code %s is not valid", status);
            } else if (status instanceof String) {
                try {
                    code = Status.Code.valueOf((String) status);
                } catch (IllegalArgumentException iae) {
                    throw new VerifyException("Status code " + status + " is not valid", iae);
                }
            } else {
                throw new VerifyException("Can not convert status code " + status + " to Status.Code, because its type is " + status.getClass());
            }
            codes.add(code);
        }
        return Collections.unmodifiableSet(codes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<Status.Code> getRetryableStatusCodesFromRetryPolicy(Map<String, ?> retryPolicy) {
        Set<Status.Code> codes = getListOfStatusCodesAsSet(retryPolicy, "retryableStatusCodes");
        Verify.verify(codes != null, "%s is required in retry policy", "retryableStatusCodes");
        Verify.verify(!codes.isEmpty(), "%s must not be empty", "retryableStatusCodes");
        Verify.verify(true ^ codes.contains(Status.Code.OK), "%s must not contain OK", "retryableStatusCodes");
        return codes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer getMaxAttemptsFromHedgingPolicy(Map<String, ?> hedgingPolicy) {
        return JsonUtil.getNumberAsInteger(hedgingPolicy, "maxAttempts");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long getHedgingDelayNanosFromHedgingPolicy(Map<String, ?> hedgingPolicy) {
        return JsonUtil.getStringAsDuration(hedgingPolicy, "hedgingDelay");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<Status.Code> getNonFatalStatusCodesFromHedgingPolicy(Map<String, ?> hedgingPolicy) {
        Set<Status.Code> codes = getListOfStatusCodesAsSet(hedgingPolicy, "nonFatalStatusCodes");
        if (codes != null) {
            Verify.verify(!codes.contains(Status.Code.OK), "%s must not contain OK", "nonFatalStatusCodes");
            return codes;
        }
        return Collections.unmodifiableSet(EnumSet.noneOf(Status.Code.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String getServiceFromName(Map<String, ?> name) {
        return JsonUtil.getString(name, "service");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String getMethodFromName(Map<String, ?> name) {
        return JsonUtil.getString(name, "method");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Map<String, ?> getRetryPolicyFromMethodConfig(Map<String, ?> methodConfig) {
        return JsonUtil.getObject(methodConfig, "retryPolicy");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Map<String, ?> getHedgingPolicyFromMethodConfig(Map<String, ?> methodConfig) {
        return JsonUtil.getObject(methodConfig, "hedgingPolicy");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<Map<String, ?>> getNameListFromMethodConfig(Map<String, ?> methodConfig) {
        return JsonUtil.getListOfObjects(methodConfig, ContentDisposition.Parameters.Name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long getTimeoutFromMethodConfig(Map<String, ?> methodConfig) {
        return JsonUtil.getStringAsDuration(methodConfig, "timeout");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Boolean getWaitForReadyFromMethodConfig(Map<String, ?> methodConfig) {
        return JsonUtil.getBoolean(methodConfig, "waitForReady");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer getMaxRequestMessageBytesFromMethodConfig(Map<String, ?> methodConfig) {
        return JsonUtil.getNumberAsInteger(methodConfig, "maxRequestMessageBytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer getMaxResponseMessageBytesFromMethodConfig(Map<String, ?> methodConfig) {
        return JsonUtil.getNumberAsInteger(methodConfig, "maxResponseMessageBytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<Map<String, ?>> getMethodConfigFromServiceConfig(Map<String, ?> serviceConfig) {
        return JsonUtil.getListOfObjects(serviceConfig, "methodConfig");
    }

    public static List<Map<String, ?>> getLoadBalancingConfigsFromServiceConfig(Map<String, ?> serviceConfig) {
        String policy;
        List<Map<String, ?>> lbConfigs = new ArrayList<>();
        if (serviceConfig.containsKey("loadBalancingConfig")) {
            lbConfigs.addAll(JsonUtil.getListOfObjects(serviceConfig, "loadBalancingConfig"));
        }
        if (lbConfigs.isEmpty() && (policy = JsonUtil.getString(serviceConfig, "loadBalancingPolicy")) != null) {
            Map<String, ?> fakeConfig = Collections.singletonMap(policy.toLowerCase(Locale.ROOT), Collections.emptyMap());
            lbConfigs.add(fakeConfig);
        }
        return Collections.unmodifiableList(lbConfigs);
    }

    public static LbConfig unwrapLoadBalancingConfig(Map<String, ?> lbConfig) {
        if (lbConfig.size() != 1) {
            throw new RuntimeException("There are " + lbConfig.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + lbConfig);
        }
        String key = lbConfig.entrySet().iterator().next().getKey();
        return new LbConfig(key, JsonUtil.getObject(lbConfig, key));
    }

    public static List<LbConfig> unwrapLoadBalancingConfigList(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList<LbConfig> result = new ArrayList<>();
        for (Map<String, ?> rawChildPolicy : list) {
            result.add(unwrapLoadBalancingConfig(rawChildPolicy));
        }
        return Collections.unmodifiableList(result);
    }

    public static NameResolver.ConfigOrError selectLbPolicyFromList(List<LbConfig> lbConfigs, LoadBalancerRegistry lbRegistry) {
        List<String> policiesTried = new ArrayList<>();
        for (LbConfig lbConfig : lbConfigs) {
            String policy = lbConfig.getPolicyName();
            LoadBalancerProvider provider = lbRegistry.getProvider(policy);
            if (provider == null) {
                policiesTried.add(policy);
            } else {
                if (!policiesTried.isEmpty()) {
                    Logger.getLogger(ServiceConfigUtil.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", policiesTried);
                }
                NameResolver.ConfigOrError parsedLbPolicyConfig = provider.parseLoadBalancingPolicyConfig(lbConfig.getRawConfigValue());
                if (parsedLbPolicyConfig.getError() != null) {
                    return parsedLbPolicyConfig;
                }
                return NameResolver.ConfigOrError.fromConfig(new PolicySelection(provider, parsedLbPolicyConfig.getConfig()));
            }
        }
        return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("None of " + policiesTried + " specified by Service Config are available."));
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LbConfig {
        private final String policyName;
        private final Map<String, ?> rawConfigValue;

        public LbConfig(String policyName, Map<String, ?> rawConfigValue) {
            this.policyName = (String) Preconditions.checkNotNull(policyName, "policyName");
            this.rawConfigValue = (Map) Preconditions.checkNotNull(rawConfigValue, "rawConfigValue");
        }

        public String getPolicyName() {
            return this.policyName;
        }

        public Map<String, ?> getRawConfigValue() {
            return this.rawConfigValue;
        }

        public boolean equals(Object o) {
            if (o instanceof LbConfig) {
                LbConfig other = (LbConfig) o;
                return this.policyName.equals(other.policyName) && this.rawConfigValue.equals(other.rawConfigValue);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.policyName, this.rawConfigValue});
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("policyName", this.policyName).add("rawConfigValue", this.rawConfigValue).toString();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class PolicySelection {
        @Nullable
        final Object config;
        final LoadBalancerProvider provider;

        public PolicySelection(LoadBalancerProvider provider, @Nullable Object config) {
            this.provider = (LoadBalancerProvider) Preconditions.checkNotNull(provider, "provider");
            this.config = config;
        }

        public LoadBalancerProvider getProvider() {
            return this.provider;
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PolicySelection that = (PolicySelection) o;
            if (Objects.equal(this.provider, that.provider) && Objects.equal(this.config, that.config)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.provider, this.config});
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("provider", this.provider).add("config", this.config).toString();
        }
    }
}