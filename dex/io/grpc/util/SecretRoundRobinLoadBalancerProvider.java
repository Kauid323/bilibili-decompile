package io.grpc.util;

import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.NameResolver;
import java.util.Map;

final class SecretRoundRobinLoadBalancerProvider {
    private SecretRoundRobinLoadBalancerProvider() {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Provider extends LoadBalancerProvider {
        private static final String NO_CONFIG = "no service config";

        @Override // io.grpc.LoadBalancerProvider
        public boolean isAvailable() {
            return true;
        }

        @Override // io.grpc.LoadBalancerProvider
        public int getPriority() {
            return 5;
        }

        @Override // io.grpc.LoadBalancerProvider
        public String getPolicyName() {
            return "round_robin";
        }

        @Override // io.grpc.LoadBalancer.Factory
        public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
            return new RoundRobinLoadBalancer(helper);
        }

        @Override // io.grpc.LoadBalancerProvider
        public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> rawLoadBalancingPolicyConfig) {
            return NameResolver.ConfigOrError.fromConfig(NO_CONFIG);
        }
    }
}