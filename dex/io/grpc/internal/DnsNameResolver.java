package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.SharedResourceHolder;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class DnsNameResolver extends NameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long DEFAULT_NETWORK_CACHE_TTL_SECONDS = 30;
    static final String NETWORKADDRESS_CACHE_TTL_PROPERTY = "networkaddress.cache.ttl";
    private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
    static final String SERVICE_CONFIG_PREFIX = "grpc_config=";
    private static String localHostname;
    private final String authority;
    private final long cacheTtlNanos;
    private Executor executor;
    private final SharedResourceHolder.Resource<Executor> executorResource;

    /* renamed from: host  reason: collision with root package name */
    private final String f1974host;
    private NameResolver.Listener2 listener;
    private final int port;
    final ProxyDetector proxyDetector;
    protected boolean resolved;
    private boolean resolving;
    private final NameResolver.ServiceConfigParser serviceConfigParser;
    private boolean shutdown;
    private final Stopwatch stopwatch;
    private final SynchronizationContext syncContext;
    private final boolean usingExecutorResource;
    private static final Logger logger = Logger.getLogger(DnsNameResolver.class.getName());
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
    private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
    private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
    private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList(SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY)));
    private static final String JNDI_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
    private static final String JNDI_LOCALHOST_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
    private static final String JNDI_TXT_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
    static boolean enableJndi = Boolean.parseBoolean(JNDI_PROPERTY);
    static boolean enableJndiLocalhost = Boolean.parseBoolean(JNDI_LOCALHOST_PROPERTY);
    protected static boolean enableTxt = Boolean.parseBoolean(JNDI_TXT_PROPERTY);
    private static final ResourceResolverFactory resourceResolverFactory = getResourceResolverFactory(DnsNameResolver.class.getClassLoader());
    private final Random random = new Random();
    protected volatile AddressResolver addressResolver = JdkAddressResolver.INSTANCE;
    private final AtomicReference<ResourceResolver> resourceResolver = new AtomicReference<>();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface AddressResolver {
        List<InetAddress> resolveAddress(String str) throws Exception;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ResourceResolver {
        List<SrvRecord> resolveSrv(String str) throws Exception;

        List<String> resolveTxt(String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ResourceResolverFactory {
        @Nullable
        ResourceResolver newResourceResolver();

        @Nullable
        Throwable unavailabilityCause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DnsNameResolver(@Nullable String nsAuthority, String name, NameResolver.Args args, SharedResourceHolder.Resource<Executor> executorResource, Stopwatch stopwatch, boolean isAndroid) {
        Preconditions.checkNotNull(args, "args");
        this.executorResource = executorResource;
        URI nameUri = URI.create("//" + ((String) Preconditions.checkNotNull(name, ContentDisposition.Parameters.Name)));
        Preconditions.checkArgument(nameUri.getHost() != null, "Invalid DNS name: %s", name);
        this.authority = (String) Preconditions.checkNotNull(nameUri.getAuthority(), "nameUri (%s) doesn't have an authority", nameUri);
        this.f1974host = nameUri.getHost();
        if (nameUri.getPort() == -1) {
            this.port = args.getDefaultPort();
        } else {
            this.port = nameUri.getPort();
        }
        this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(args.getProxyDetector(), "proxyDetector");
        this.cacheTtlNanos = getNetworkAddressCacheTtlNanos(isAndroid);
        this.stopwatch = (Stopwatch) Preconditions.checkNotNull(stopwatch, "stopwatch");
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(args.getSynchronizationContext(), "syncContext");
        this.executor = args.getOffloadExecutor();
        this.usingExecutorResource = this.executor == null;
        this.serviceConfigParser = (NameResolver.ServiceConfigParser) Preconditions.checkNotNull(args.getServiceConfigParser(), "serviceConfigParser");
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.authority;
    }

    protected String getHost() {
        return this.f1974host;
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener) {
        Preconditions.checkState(this.listener == null, "already started");
        if (this.usingExecutorResource) {
            this.executor = (Executor) SharedResourceHolder.get(this.executorResource);
        }
        this.listener = (NameResolver.Listener2) Preconditions.checkNotNull(listener, "listener");
        resolve();
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        Preconditions.checkState(this.listener != null, "not started");
        resolve();
    }

    private List<EquivalentAddressGroup> resolveAddresses() {
        try {
            try {
                List<? extends InetAddress> addresses = this.addressResolver.resolveAddress(this.f1974host);
                List<EquivalentAddressGroup> servers = new ArrayList<>(addresses.size());
                for (InetAddress inetAddr : addresses) {
                    servers.add(new EquivalentAddressGroup(new InetSocketAddress(inetAddr, this.port)));
                }
                return Collections.unmodifiableList(servers);
            } catch (Exception e2) {
                Throwables.throwIfUnchecked(e2);
                throw new RuntimeException(e2);
            }
        } finally {
            if (0 != 0) {
                logger.log(Level.FINE, "Address resolution failure", (Throwable) null);
            }
        }
    }

    @Nullable
    private NameResolver.ConfigOrError resolveServiceConfig() {
        List<String> txtRecords = Collections.emptyList();
        ResourceResolver resourceResolver = getResourceResolver();
        if (resourceResolver != null) {
            try {
                txtRecords = resourceResolver.resolveTxt(SERVICE_CONFIG_NAME_PREFIX + this.f1974host);
            } catch (Exception e2) {
                logger.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e2);
            }
        }
        if (!txtRecords.isEmpty()) {
            NameResolver.ConfigOrError rawServiceConfig = parseServiceConfig(txtRecords, this.random, getLocalHostname());
            if (rawServiceConfig != null) {
                if (rawServiceConfig.getError() != null) {
                    return NameResolver.ConfigOrError.fromError(rawServiceConfig.getError());
                }
                Map<String, ?> verifiedRawServiceConfig = (Map) rawServiceConfig.getConfig();
                return this.serviceConfigParser.parseServiceConfig(verifiedRawServiceConfig);
            }
            return null;
        }
        logger.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f1974host});
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public EquivalentAddressGroup detectProxy() throws IOException {
        InetSocketAddress destination = InetSocketAddress.createUnresolved(this.f1974host, this.port);
        ProxiedSocketAddress proxiedAddr = this.proxyDetector.proxyFor(destination);
        if (proxiedAddr != null) {
            return new EquivalentAddressGroup(proxiedAddr);
        }
        return null;
    }

    protected InternalResolutionResult doResolve(boolean forceTxt) {
        InternalResolutionResult result = new InternalResolutionResult();
        try {
            result.addresses = resolveAddresses();
        } catch (Exception e2) {
            if (!forceTxt) {
                result.error = Status.UNAVAILABLE.withDescription("Unable to resolve host " + this.f1974host).withCause(e2);
                return result;
            }
        }
        if (enableTxt) {
            result.config = resolveServiceConfig();
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class Resolve implements Runnable {
        private final NameResolver.Listener2 savedListener;

        Resolve(NameResolver.Listener2 savedListener) {
            this.savedListener = (NameResolver.Listener2) Preconditions.checkNotNull(savedListener, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            SynchronizationContext synchronizationContext;
            Runnable runnable;
            if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                DnsNameResolver.logger.finer("Attempting DNS resolution of " + DnsNameResolver.this.f1974host);
            }
            InternalResolutionResult result = null;
            final boolean succeed = true;
            try {
                try {
                    EquivalentAddressGroup proxiedAddr = DnsNameResolver.this.detectProxy();
                    NameResolver.ResolutionResult.Builder resolutionResultBuilder = NameResolver.ResolutionResult.newBuilder();
                    if (proxiedAddr != null) {
                        if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                            DnsNameResolver.logger.finer("Using proxy address " + proxiedAddr);
                        }
                        resolutionResultBuilder.setAddresses(Collections.singletonList(proxiedAddr));
                    } else {
                        result = DnsNameResolver.this.doResolve(false);
                        if (result.error != null) {
                            this.savedListener.onError(result.error);
                            return;
                        }
                        if (result.addresses != null) {
                            resolutionResultBuilder.setAddresses(result.addresses);
                        }
                        if (result.config != null) {
                            resolutionResultBuilder.setServiceConfig(result.config);
                        }
                        if (result.attributes != null) {
                            resolutionResultBuilder.setAttributes(result.attributes);
                        }
                    }
                    this.savedListener.onResult(resolutionResultBuilder.build());
                    if (result == null || result.error != null) {
                        succeed = false;
                    }
                    synchronizationContext = DnsNameResolver.this.syncContext;
                    runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (succeed) {
                                DnsNameResolver.this.resolved = true;
                                if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.reset().start();
                                }
                            }
                            DnsNameResolver.this.resolving = false;
                        }
                    };
                } catch (IOException e2) {
                    this.savedListener.onError(Status.UNAVAILABLE.withDescription("Unable to resolve host " + DnsNameResolver.this.f1974host).withCause(e2));
                    if (0 == 0 || null.error != null) {
                        succeed = false;
                    }
                    synchronizationContext = DnsNameResolver.this.syncContext;
                    runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (succeed) {
                                DnsNameResolver.this.resolved = true;
                                if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.reset().start();
                                }
                            }
                            DnsNameResolver.this.resolving = false;
                        }
                    };
                }
                synchronizationContext.execute(runnable);
            } finally {
                if (0 == 0 || null.error != null) {
                    succeed = false;
                }
                DnsNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (succeed) {
                            DnsNameResolver.this.resolved = true;
                            if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                        DnsNameResolver.this.resolving = false;
                    }
                });
            }
        }
    }

    @Nullable
    static NameResolver.ConfigOrError parseServiceConfig(List<String> rawTxtRecords, Random random, String localHostname2) {
        try {
            List<Map<String, ?>> possibleServiceConfigChoices = parseTxtResults(rawTxtRecords);
            Map<String, ?> possibleServiceConfig = null;
            for (Map<String, ?> possibleServiceConfigChoice : possibleServiceConfigChoices) {
                try {
                    possibleServiceConfig = maybeChooseServiceConfig(possibleServiceConfigChoice, random, localHostname2);
                    if (possibleServiceConfig != null) {
                        break;
                    }
                } catch (RuntimeException e2) {
                    return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to pick service config choice").withCause(e2));
                }
            }
            if (possibleServiceConfig == null) {
                return null;
            }
            return NameResolver.ConfigOrError.fromConfig(possibleServiceConfig);
        } catch (IOException | RuntimeException e3) {
            return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse TXT records").withCause(e3));
        }
    }

    private void resolve() {
        if (this.resolving || this.shutdown || !cacheRefreshRequired()) {
            return;
        }
        this.resolving = true;
        this.executor.execute(new Resolve(this.listener));
    }

    private boolean cacheRefreshRequired() {
        return !this.resolved || this.cacheTtlNanos == 0 || (this.cacheTtlNanos > 0 && this.stopwatch.elapsed(TimeUnit.NANOSECONDS) > this.cacheTtlNanos);
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        if (this.executor != null && this.usingExecutorResource) {
            this.executor = (Executor) SharedResourceHolder.release(this.executorResource, this.executor);
        }
    }

    final int getPort() {
        return this.port;
    }

    static List<Map<String, ?>> parseTxtResults(List<String> txtRecords) throws IOException {
        List<Map<String, ?>> possibleServiceConfigChoices = new ArrayList<>();
        for (String txtRecord : txtRecords) {
            if (!txtRecord.startsWith(SERVICE_CONFIG_PREFIX)) {
                logger.log(Level.FINE, "Ignoring non service config {0}", new Object[]{txtRecord});
            } else {
                Object rawChoices = JsonParser.parse(txtRecord.substring(SERVICE_CONFIG_PREFIX.length()));
                if (!(rawChoices instanceof List)) {
                    throw new ClassCastException("wrong type " + rawChoices);
                }
                List<?> listChoices = (List) rawChoices;
                possibleServiceConfigChoices.addAll(JsonUtil.checkObjectList(listChoices));
            }
        }
        return possibleServiceConfigChoices;
    }

    @Nullable
    private static final Double getPercentageFromChoice(Map<String, ?> serviceConfigChoice) {
        return JsonUtil.getNumber(serviceConfigChoice, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY);
    }

    @Nullable
    private static final List<String> getClientLanguagesFromChoice(Map<String, ?> serviceConfigChoice) {
        return JsonUtil.getListOfStrings(serviceConfigChoice, SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY);
    }

    @Nullable
    private static final List<String> getHostnamesFromChoice(Map<String, ?> serviceConfigChoice) {
        return JsonUtil.getListOfStrings(serviceConfigChoice, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY);
    }

    private static long getNetworkAddressCacheTtlNanos(boolean isAndroid) {
        if (isAndroid) {
            return 0L;
        }
        String cacheTtlPropertyValue = System.getProperty(NETWORKADDRESS_CACHE_TTL_PROPERTY);
        long cacheTtl = DEFAULT_NETWORK_CACHE_TTL_SECONDS;
        if (cacheTtlPropertyValue != null) {
            try {
                cacheTtl = Long.parseLong(cacheTtlPropertyValue);
            } catch (NumberFormatException e2) {
                logger.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{NETWORKADDRESS_CACHE_TTL_PROPERTY, cacheTtlPropertyValue, Long.valueOf((long) DEFAULT_NETWORK_CACHE_TTL_SECONDS)});
            }
        }
        return cacheTtl > 0 ? TimeUnit.SECONDS.toNanos(cacheTtl) : cacheTtl;
    }

    @Nullable
    static Map<String, ?> maybeChooseServiceConfig(Map<String, ?> choice, Random random, String hostname) {
        for (Map.Entry<String, ?> entry : choice.entrySet()) {
            Verify.verify(SERVICE_CONFIG_CHOICE_KEYS.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> clientLanguages = getClientLanguagesFromChoice(choice);
        if (clientLanguages != null && !clientLanguages.isEmpty()) {
            boolean javaPresent = false;
            Iterator<String> it = clientLanguages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String lang = it.next();
                if ("java".equalsIgnoreCase(lang)) {
                    javaPresent = true;
                    break;
                }
            }
            if (!javaPresent) {
                return null;
            }
        }
        Double percentage = getPercentageFromChoice(choice);
        if (percentage != null) {
            int pct = percentage.intValue();
            Verify.verify(pct >= 0 && pct <= 100, "Bad percentage: %s", percentage);
            if (random.nextInt(100) >= pct) {
                return null;
            }
        }
        List<String> clientHostnames = getHostnamesFromChoice(choice);
        if (clientHostnames != null && !clientHostnames.isEmpty()) {
            boolean hostnamePresent = false;
            Iterator<String> it2 = clientHostnames.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String clientHostname = it2.next();
                if (clientHostname.equals(hostname)) {
                    hostnamePresent = true;
                    break;
                }
            }
            if (!hostnamePresent) {
                return null;
            }
        }
        Map<String, ?> sc = JsonUtil.getObject(choice, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY);
        if (sc == null) {
            throw new VerifyException(String.format("key '%s' missing in '%s'", choice, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY));
        }
        return sc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class InternalResolutionResult {
        private List<EquivalentAddressGroup> addresses;
        public Attributes attributes;
        private NameResolver.ConfigOrError config;
        private Status error;

        private InternalResolutionResult() {
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SrvRecord {

        /* renamed from: host  reason: collision with root package name */
        public final String f1975host;
        public final int port;

        public SrvRecord(String host2, int port) {
            this.f1975host = host2;
            this.port = port;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f1975host, Integer.valueOf(this.port)});
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SrvRecord that = (SrvRecord) obj;
            if (this.port == that.port && this.f1975host.equals(that.f1975host)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("host", this.f1975host).add("port", this.port).toString();
        }
    }

    protected void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
    }

    protected void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver.set(resourceResolver);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        @Override // io.grpc.internal.DnsNameResolver.AddressResolver
        public List<InetAddress> resolveAddress(String host2) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(host2)));
        }
    }

    @Nullable
    protected ResourceResolver getResourceResolver() {
        if (!shouldUseJndi(enableJndi, enableJndiLocalhost, this.f1974host)) {
            return null;
        }
        ResourceResolver rr = this.resourceResolver.get();
        if (rr != null || resourceResolverFactory == null) {
            return rr;
        }
        if (resourceResolverFactory.unavailabilityCause() != null) {
            throw new AssertionError();
        }
        return resourceResolverFactory.newResourceResolver();
    }

    @Nullable
    static ResourceResolverFactory getResourceResolverFactory(ClassLoader loader) {
        try {
            try {
                try {
                    ResourceResolverFactory rrf = (ResourceResolverFactory) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, loader).asSubclass(ResourceResolverFactory.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (rrf.unavailabilityCause() != null) {
                        logger.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", rrf.unavailabilityCause());
                        return null;
                    }
                    return rrf;
                } catch (Exception e2) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e2);
                    return null;
                }
            } catch (Exception e3) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e3);
                return null;
            }
        } catch (ClassCastException e4) {
            logger.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e4);
            return null;
        } catch (ClassNotFoundException e5) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e5);
            return null;
        }
    }

    private static String getLocalHostname() {
        if (localHostname == null) {
            try {
                localHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e2) {
                throw new RuntimeException(e2);
            }
        }
        return localHostname;
    }

    protected static boolean shouldUseJndi(boolean jndiEnabled, boolean jndiLocalhostEnabled, String target) {
        if (!jndiEnabled) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(target)) {
            return jndiLocalhostEnabled;
        }
        if (target.contains(":")) {
            return false;
        }
        boolean alldigits = true;
        for (int i2 = 0; i2 < target.length(); i2++) {
            char c = target.charAt(i2);
            if (c != '.') {
                alldigits &= c >= '0' && c <= '9';
            }
        }
        return !alldigits;
    }
}