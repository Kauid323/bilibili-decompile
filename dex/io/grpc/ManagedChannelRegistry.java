package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ManagedChannelProvider;
import io.grpc.ServiceProviders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ManagedChannelRegistry {
    private static ManagedChannelRegistry instance;
    private static final Logger logger = Logger.getLogger(ManagedChannelRegistry.class.getName());
    private final LinkedHashSet<ManagedChannelProvider> allProviders = new LinkedHashSet<>();
    private List<ManagedChannelProvider> effectiveProviders = Collections.emptyList();

    public synchronized void register(ManagedChannelProvider provider) {
        addProvider(provider);
        refreshProviders();
    }

    private synchronized void addProvider(ManagedChannelProvider provider) {
        Preconditions.checkArgument(provider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(provider);
    }

    public synchronized void deregister(ManagedChannelProvider provider) {
        this.allProviders.remove(provider);
        refreshProviders();
    }

    private synchronized void refreshProviders() {
        List<ManagedChannelProvider> providers = new ArrayList<>(this.allProviders);
        Collections.sort(providers, Collections.reverseOrder(new Comparator<ManagedChannelProvider>() { // from class: io.grpc.ManagedChannelRegistry.1
            @Override // java.util.Comparator
            public int compare(ManagedChannelProvider o1, ManagedChannelProvider o2) {
                return o1.priority() - o2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(providers);
    }

    public static synchronized ManagedChannelRegistry getDefaultRegistry() {
        ManagedChannelRegistry managedChannelRegistry;
        synchronized (ManagedChannelRegistry.class) {
            if (instance == null) {
                List<ManagedChannelProvider> providerList = ServiceProviders.loadAll(ManagedChannelProvider.class, getHardCodedClasses(), ManagedChannelProvider.class.getClassLoader(), new ManagedChannelPriorityAccessor());
                instance = new ManagedChannelRegistry();
                for (ManagedChannelProvider provider : providerList) {
                    logger.fine("Service loader found " + provider);
                    if (provider.isAvailable()) {
                        instance.addProvider(provider);
                    }
                }
                instance.refreshProviders();
            }
            managedChannelRegistry = instance;
        }
        return managedChannelRegistry;
    }

    synchronized List<ManagedChannelProvider> providers() {
        return this.effectiveProviders;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelProvider provider() {
        List<ManagedChannelProvider> providers = providers();
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    static List<Class<?>> getHardCodedClasses() {
        List<Class<?>> list = new ArrayList<>();
        try {
            list.add(Class.forName("io.grpc.okhttp.OkHttpChannelProvider"));
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e2);
        }
        try {
            list.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e3) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e3);
        }
        return Collections.unmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelBuilder<?> newChannelBuilder(String target, ChannelCredentials creds) {
        List<ManagedChannelProvider> providers = providers();
        if (providers.isEmpty()) {
            throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
        }
        StringBuilder error = new StringBuilder();
        for (ManagedChannelProvider provider : providers()) {
            ManagedChannelProvider.NewChannelBuilderResult result = provider.newChannelBuilder(target, creds);
            if (result.getChannelBuilder() != null) {
                return result.getChannelBuilder();
            }
            error.append("; ");
            error.append(provider.getClass().getName());
            error.append(": ");
            error.append(result.getError());
        }
        throw new ProviderNotFoundException(error.substring(2));
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class ManagedChannelPriorityAccessor implements ServiceProviders.PriorityAccessor<ManagedChannelProvider> {
        private ManagedChannelPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ManagedChannelProvider provider) {
            return provider.isAvailable();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ManagedChannelProvider provider) {
            return provider.priority();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String msg) {
            super(msg);
        }
    }
}