package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ServerProvider;
import io.grpc.ServiceProviders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Logger;

public final class ServerRegistry {
    private static ServerRegistry instance;
    private static final Logger logger = Logger.getLogger(ServerRegistry.class.getName());
    private final LinkedHashSet<ServerProvider> allProviders = new LinkedHashSet<>();
    private List<ServerProvider> effectiveProviders = Collections.emptyList();

    public synchronized void register(ServerProvider provider) {
        addProvider(provider);
        refreshProviders();
    }

    private synchronized void addProvider(ServerProvider provider) {
        Preconditions.checkArgument(provider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(provider);
    }

    public synchronized void deregister(ServerProvider provider) {
        this.allProviders.remove(provider);
        refreshProviders();
    }

    private synchronized void refreshProviders() {
        List<ServerProvider> providers = new ArrayList<>(this.allProviders);
        Collections.sort(providers, Collections.reverseOrder(new Comparator<ServerProvider>() { // from class: io.grpc.ServerRegistry.1
            @Override // java.util.Comparator
            public int compare(ServerProvider o1, ServerProvider o2) {
                return o1.priority() - o2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(providers);
    }

    public static synchronized ServerRegistry getDefaultRegistry() {
        ServerRegistry serverRegistry;
        synchronized (ServerRegistry.class) {
            if (instance == null) {
                List<ServerProvider> providerList = ServiceProviders.loadAll(ServerProvider.class, Collections.emptyList(), ServerProvider.class.getClassLoader(), new ServerPriorityAccessor());
                instance = new ServerRegistry();
                for (ServerProvider provider : providerList) {
                    logger.fine("Service loader found " + provider);
                    if (provider.isAvailable()) {
                        instance.addProvider(provider);
                    }
                }
                instance.refreshProviders();
            }
            serverRegistry = instance;
        }
        return serverRegistry;
    }

    synchronized List<ServerProvider> providers() {
        return this.effectiveProviders;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerProvider provider() {
        List<ServerProvider> providers = providers();
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerBuilder<?> newServerBuilderForPort(int port, ServerCredentials creds) {
        List<ServerProvider> providers = providers();
        if (providers.isEmpty()) {
            throw new ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
        }
        StringBuilder error = new StringBuilder();
        for (ServerProvider provider : providers()) {
            ServerProvider.NewServerBuilderResult result = provider.newServerBuilderForPort(port, creds);
            if (result.getServerBuilder() != null) {
                return result.getServerBuilder();
            }
            error.append("; ");
            error.append(provider.getClass().getName());
            error.append(": ");
            error.append(result.getError());
        }
        throw new ProviderNotFoundException(error.substring(2));
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class ServerPriorityAccessor implements ServiceProviders.PriorityAccessor<ServerProvider> {
        private ServerPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ServerProvider provider) {
            return provider.isAvailable();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ServerProvider provider) {
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