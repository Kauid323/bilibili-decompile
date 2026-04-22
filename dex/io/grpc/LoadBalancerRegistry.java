package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ServiceProviders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class LoadBalancerRegistry {
    private static LoadBalancerRegistry instance;
    private final LinkedHashSet<LoadBalancerProvider> allProviders = new LinkedHashSet<>();
    private final LinkedHashMap<String, LoadBalancerProvider> effectiveProviders = new LinkedHashMap<>();
    private static final Logger logger = Logger.getLogger(LoadBalancerRegistry.class.getName());
    private static final Iterable<Class<?>> HARDCODED_CLASSES = getHardCodedClasses();

    public synchronized void register(LoadBalancerProvider provider) {
        addProvider(provider);
        refreshProviderMap();
    }

    private synchronized void addProvider(LoadBalancerProvider provider) {
        Preconditions.checkArgument(provider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(provider);
    }

    public synchronized void deregister(LoadBalancerProvider provider) {
        this.allProviders.remove(provider);
        refreshProviderMap();
    }

    private synchronized void refreshProviderMap() {
        this.effectiveProviders.clear();
        Iterator<LoadBalancerProvider> it = this.allProviders.iterator();
        while (it.hasNext()) {
            LoadBalancerProvider provider = it.next();
            String policy = provider.getPolicyName();
            LoadBalancerProvider existing = this.effectiveProviders.get(policy);
            if (existing == null || existing.getPriority() < provider.getPriority()) {
                this.effectiveProviders.put(policy, provider);
            }
        }
    }

    public static synchronized LoadBalancerRegistry getDefaultRegistry() {
        LoadBalancerRegistry loadBalancerRegistry;
        synchronized (LoadBalancerRegistry.class) {
            if (instance == null) {
                List<LoadBalancerProvider> providerList = ServiceProviders.loadAll(LoadBalancerProvider.class, HARDCODED_CLASSES, LoadBalancerProvider.class.getClassLoader(), new LoadBalancerPriorityAccessor());
                instance = new LoadBalancerRegistry();
                for (LoadBalancerProvider provider : providerList) {
                    logger.fine("Service loader found " + provider);
                    if (provider.isAvailable()) {
                        instance.addProvider(provider);
                    }
                }
                instance.refreshProviderMap();
            }
            loadBalancerRegistry = instance;
        }
        return loadBalancerRegistry;
    }

    @Nullable
    public synchronized LoadBalancerProvider getProvider(String policy) {
        return this.effectiveProviders.get(Preconditions.checkNotNull(policy, "policy"));
    }

    synchronized Map<String, LoadBalancerProvider> providers() {
        return new LinkedHashMap(this.effectiveProviders);
    }

    static List<Class<?>> getHardCodedClasses() {
        ArrayList<Class<?>> list = new ArrayList<>();
        try {
            list.add(Class.forName("io.grpc.internal.PickFirstLoadBalancerProvider"));
        } catch (ClassNotFoundException e2) {
            logger.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e2);
        }
        try {
            list.add(Class.forName("io.grpc.util.SecretRoundRobinLoadBalancerProvider$Provider"));
        } catch (ClassNotFoundException e3) {
            logger.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e3);
        }
        return Collections.unmodifiableList(list);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class LoadBalancerPriorityAccessor implements ServiceProviders.PriorityAccessor<LoadBalancerProvider> {
        LoadBalancerPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(LoadBalancerProvider provider) {
            return provider.isAvailable();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(LoadBalancerProvider provider) {
            return provider.getPriority();
        }
    }
}