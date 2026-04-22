package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.NameResolver;
import io.grpc.ServiceProviders;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class NameResolverRegistry {
    private static NameResolverRegistry instance;
    private static final Logger logger = Logger.getLogger(NameResolverRegistry.class.getName());
    private final NameResolver.Factory factory = new NameResolverFactory();
    private final LinkedHashSet<NameResolverProvider> allProviders = new LinkedHashSet<>();
    private List<NameResolverProvider> effectiveProviders = Collections.emptyList();

    public synchronized void register(NameResolverProvider provider) {
        addProvider(provider);
        refreshProviders();
    }

    private synchronized void addProvider(NameResolverProvider provider) {
        Preconditions.checkArgument(provider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(provider);
    }

    public synchronized void deregister(NameResolverProvider provider) {
        this.allProviders.remove(provider);
        refreshProviders();
    }

    private synchronized void refreshProviders() {
        List<NameResolverProvider> providers = new ArrayList<>(this.allProviders);
        Collections.sort(providers, Collections.reverseOrder(new Comparator<NameResolverProvider>() { // from class: io.grpc.NameResolverRegistry.1
            @Override // java.util.Comparator
            public int compare(NameResolverProvider o1, NameResolverProvider o2) {
                return o1.priority() - o2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(providers);
    }

    public static synchronized NameResolverRegistry getDefaultRegistry() {
        NameResolverRegistry nameResolverRegistry;
        synchronized (NameResolverRegistry.class) {
            if (instance == null) {
                List<NameResolverProvider> providerList = ServiceProviders.loadAll(NameResolverProvider.class, getHardCodedClasses(), NameResolverProvider.class.getClassLoader(), new NameResolverPriorityAccessor());
                if (providerList.isEmpty()) {
                    logger.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                instance = new NameResolverRegistry();
                for (NameResolverProvider provider : providerList) {
                    logger.fine("Service loader found " + provider);
                    if (provider.isAvailable()) {
                        instance.addProvider(provider);
                    }
                }
                instance.refreshProviders();
            }
            nameResolverRegistry = instance;
        }
        return nameResolverRegistry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<NameResolverProvider> providers() {
        return this.effectiveProviders;
    }

    public NameResolver.Factory asFactory() {
        return this.factory;
    }

    static List<Class<?>> getHardCodedClasses() {
        ArrayList<Class<?>> list = new ArrayList<>();
        try {
            list.add(Class.forName("io.grpc.internal.DnsNameResolverProvider"));
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e2);
        }
        return Collections.unmodifiableList(list);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class NameResolverFactory extends NameResolver.Factory {
        private NameResolverFactory() {
        }

        @Override // io.grpc.NameResolver.Factory
        @Nullable
        public NameResolver newNameResolver(URI targetUri, NameResolver.Args args) {
            List<NameResolverProvider> providers = NameResolverRegistry.this.providers();
            for (NameResolverProvider provider : providers) {
                NameResolver resolver = provider.newNameResolver(targetUri, args);
                if (resolver != null) {
                    return resolver;
                }
            }
            return null;
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            List<NameResolverProvider> providers = NameResolverRegistry.this.providers();
            if (providers.isEmpty()) {
                return "unknown";
            }
            return providers.get(0).getDefaultScheme();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class NameResolverPriorityAccessor implements ServiceProviders.PriorityAccessor<NameResolverProvider> {
        private NameResolverPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(NameResolverProvider provider) {
            return provider.isAvailable();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(NameResolverProvider provider) {
            return provider.priority();
        }
    }
}