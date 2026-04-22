package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.internal.ExponentialBackoffPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ManagedChannelImplBuilder extends ManagedChannelBuilder<ManagedChannelImplBuilder> {
    private static final long DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES = 1048576;
    private static final long DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES = 16777216;
    private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
    private boolean authorityCheckerDisabled;
    @Nullable
    String authorityOverride;
    @Nullable
    BinaryLog binlog;
    @Nullable
    final CallCredentials callCredentials;
    private final ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider;
    @Nullable
    final ChannelCredentials channelCredentials;
    InternalChannelz channelz;
    private final ClientTransportFactoryBuilder clientTransportFactoryBuilder;
    CompressorRegistry compressorRegistry;
    DecompressorRegistry decompressorRegistry;
    String defaultLbPolicy;
    @Nullable
    Map<String, ?> defaultServiceConfig;
    @Nullable
    private final SocketAddress directServerAddress;
    ObjectPool<? extends Executor> executorPool;
    boolean fullStreamDecompression;
    long idleTimeoutMillis;
    private final List<ClientInterceptor> interceptors;
    boolean lookUpServiceConfig;
    int maxHedgedAttempts;
    int maxRetryAttempts;
    int maxTraceEvents;
    NameResolver.Factory nameResolverFactory;
    final NameResolverRegistry nameResolverRegistry;
    ObjectPool<? extends Executor> offloadExecutorPool;
    long perRpcBufferLimit;
    @Nullable
    ProxyDetector proxyDetector;
    private boolean recordFinishedRpcs;
    private boolean recordRealTimeMetrics;
    private boolean recordStartedRpcs;
    long retryBufferSize;
    boolean retryEnabled;
    private boolean statsEnabled;
    final String target;
    boolean temporarilyDisableRetry;
    private boolean tracingEnabled;
    @Nullable
    String userAgent;
    private static final Logger log = Logger.getLogger(ManagedChannelImplBuilder.class.getName());
    static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30;
    static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(IDLE_MODE_MAX_TIMEOUT_DAYS);
    static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1);
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ChannelBuilderDefaultPortProvider {
        int getDefaultPort();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ClientTransportFactoryBuilder {
        ClientTransportFactory buildClientTransportFactory();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelImplBuilder defaultServiceConfig(@Nullable Map map) {
        return defaultServiceConfig2((Map<String, ?>) map);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelImplBuilder intercept(List list) {
        return intercept2((List<ClientInterceptor>) list);
    }

    public static ManagedChannelBuilder<?> forAddress(String name, int port) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    public static ManagedChannelBuilder<?> forTarget(String target) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class UnsupportedClientTransportFactoryBuilder implements ClientTransportFactoryBuilder {
        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
        public ClientTransportFactory buildClientTransportFactory() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class FixedPortProvider implements ChannelBuilderDefaultPortProvider {
        private final int port;

        public FixedPortProvider(int port) {
            this.port = port;
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return this.port;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class ManagedChannelDefaultPortProvider implements ChannelBuilderDefaultPortProvider {
        private ManagedChannelDefaultPortProvider() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
    }

    public ManagedChannelImplBuilder(String target, ClientTransportFactoryBuilder clientTransportFactoryBuilder, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        this(target, null, null, clientTransportFactoryBuilder, channelBuilderDefaultPortProvider);
    }

    public ManagedChannelImplBuilder(String target, @Nullable ChannelCredentials channelCreds, @Nullable CallCredentials callCreds, ClientTransportFactoryBuilder clientTransportFactoryBuilder, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        this.executorPool = DEFAULT_EXECUTOR_POOL;
        this.offloadExecutorPool = DEFAULT_EXECUTOR_POOL;
        this.interceptors = new ArrayList();
        this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        this.nameResolverFactory = this.nameResolverRegistry.asFactory();
        this.defaultLbPolicy = GrpcUtil.DEFAULT_LB_POLICY;
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        this.idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.maxRetryAttempts = 5;
        this.maxHedgedAttempts = 5;
        this.retryBufferSize = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.perRpcBufferLimit = 1048576L;
        this.retryEnabled = false;
        this.channelz = InternalChannelz.instance();
        this.lookUpServiceConfig = true;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.tracingEnabled = true;
        this.target = (String) Preconditions.checkNotNull(target, "target");
        this.channelCredentials = channelCreds;
        this.callCredentials = callCreds;
        this.clientTransportFactoryBuilder = (ClientTransportFactoryBuilder) Preconditions.checkNotNull(clientTransportFactoryBuilder, "clientTransportFactoryBuilder");
        this.directServerAddress = null;
        if (channelBuilderDefaultPortProvider != null) {
            this.channelBuilderDefaultPortProvider = channelBuilderDefaultPortProvider;
        } else {
            this.channelBuilderDefaultPortProvider = new ManagedChannelDefaultPortProvider();
        }
    }

    static String makeTargetStringForDirectAddress(SocketAddress address) {
        try {
            return new URI(DIRECT_ADDRESS_SCHEME, "", "/" + address, null).toString();
        } catch (URISyntaxException e2) {
            throw new RuntimeException(e2);
        }
    }

    public ManagedChannelImplBuilder(SocketAddress directServerAddress, String authority, ClientTransportFactoryBuilder clientTransportFactoryBuilder, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        this.executorPool = DEFAULT_EXECUTOR_POOL;
        this.offloadExecutorPool = DEFAULT_EXECUTOR_POOL;
        this.interceptors = new ArrayList();
        this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        this.nameResolverFactory = this.nameResolverRegistry.asFactory();
        this.defaultLbPolicy = GrpcUtil.DEFAULT_LB_POLICY;
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        this.idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.maxRetryAttempts = 5;
        this.maxHedgedAttempts = 5;
        this.retryBufferSize = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.perRpcBufferLimit = 1048576L;
        this.retryEnabled = false;
        this.channelz = InternalChannelz.instance();
        this.lookUpServiceConfig = true;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.tracingEnabled = true;
        this.target = makeTargetStringForDirectAddress(directServerAddress);
        this.channelCredentials = null;
        this.callCredentials = null;
        this.clientTransportFactoryBuilder = (ClientTransportFactoryBuilder) Preconditions.checkNotNull(clientTransportFactoryBuilder, "clientTransportFactoryBuilder");
        this.directServerAddress = directServerAddress;
        this.nameResolverFactory = new DirectAddressNameResolverFactory(directServerAddress, authority);
        if (channelBuilderDefaultPortProvider != null) {
            this.channelBuilderDefaultPortProvider = channelBuilderDefaultPortProvider;
        } else {
            this.channelBuilderDefaultPortProvider = new ManagedChannelDefaultPortProvider();
        }
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder executor(Executor executor) {
        if (executor != null) {
            this.executorPool = new FixedObjectPool(executor);
        } else {
            this.executorPool = DEFAULT_EXECUTOR_POOL;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder offloadExecutor(Executor executor) {
        if (executor != null) {
            this.offloadExecutorPool = new FixedObjectPool(executor);
        } else {
            this.offloadExecutorPool = DEFAULT_EXECUTOR_POOL;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    /* renamed from: intercept  reason: avoid collision after fix types in other method */
    public ManagedChannelImplBuilder intercept2(List<ClientInterceptor> interceptors) {
        this.interceptors.addAll(interceptors);
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder intercept(ClientInterceptor... interceptors) {
        return intercept2(Arrays.asList(interceptors));
    }

    @Override // io.grpc.ManagedChannelBuilder
    @Deprecated
    public ManagedChannelImplBuilder nameResolverFactory(NameResolver.Factory resolverFactory) {
        Preconditions.checkState(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", this.directServerAddress);
        if (resolverFactory != null) {
            this.nameResolverFactory = resolverFactory;
        } else {
            this.nameResolverFactory = this.nameResolverRegistry.asFactory();
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder defaultLoadBalancingPolicy(String policy) {
        Preconditions.checkState(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of load-balancing policy", this.directServerAddress);
        Preconditions.checkArgument(policy != null, "policy cannot be null");
        this.defaultLbPolicy = policy;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder enableFullStreamDecompression() {
        this.fullStreamDecompression = true;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder decompressorRegistry(DecompressorRegistry registry) {
        if (registry != null) {
            this.decompressorRegistry = registry;
        } else {
            this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder compressorRegistry(CompressorRegistry registry) {
        if (registry != null) {
            this.compressorRegistry = registry;
        } else {
            this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder userAgent(@Nullable String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder overrideAuthority(String authority) {
        this.authorityOverride = checkAuthority(authority);
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder idleTimeout(long value, TimeUnit unit) {
        Preconditions.checkArgument(value > 0, "idle timeout is %s, but must be positive", value);
        if (unit.toDays(value) >= IDLE_MODE_MAX_TIMEOUT_DAYS) {
            this.idleTimeoutMillis = -1L;
        } else {
            this.idleTimeoutMillis = Math.max(unit.toMillis(value), IDLE_MODE_MIN_TIMEOUT_MILLIS);
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder maxRetryAttempts(int maxRetryAttempts) {
        this.maxRetryAttempts = maxRetryAttempts;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder maxHedgedAttempts(int maxHedgedAttempts) {
        this.maxHedgedAttempts = maxHedgedAttempts;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder retryBufferSize(long bytes) {
        Preconditions.checkArgument(bytes > 0, "retry buffer size must be positive");
        this.retryBufferSize = bytes;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder perRpcBufferLimit(long bytes) {
        Preconditions.checkArgument(bytes > 0, "per RPC buffer limit must be positive");
        this.perRpcBufferLimit = bytes;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder disableRetry() {
        this.retryEnabled = false;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder enableRetry() {
        this.retryEnabled = true;
        this.statsEnabled = false;
        this.tracingEnabled = false;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder setBinaryLog(BinaryLog binlog) {
        this.binlog = binlog;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder maxTraceEvents(int maxTraceEvents) {
        Preconditions.checkArgument(maxTraceEvents >= 0, "maxTraceEvents must be non-negative");
        this.maxTraceEvents = maxTraceEvents;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder proxyDetector(@Nullable ProxyDetector proxyDetector) {
        this.proxyDetector = proxyDetector;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    /* renamed from: defaultServiceConfig  reason: avoid collision after fix types in other method */
    public ManagedChannelImplBuilder defaultServiceConfig2(@Nullable Map<String, ?> serviceConfig) {
        this.defaultServiceConfig = checkMapEntryTypes(serviceConfig);
        return this;
    }

    @Nullable
    private static Map<String, ?> checkMapEntryTypes(@Nullable Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        Map<String, Object> parsedMap = new LinkedHashMap<>();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Preconditions.checkArgument(entry.getKey() instanceof String, "The key of the entry '%s' is not of String type", entry);
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                parsedMap.put(key, null);
            } else if (value instanceof Map) {
                parsedMap.put(key, checkMapEntryTypes((Map) value));
            } else if (value instanceof List) {
                parsedMap.put(key, checkListEntryTypes((List) value));
            } else if (value instanceof String) {
                parsedMap.put(key, value);
            } else if (value instanceof Double) {
                parsedMap.put(key, value);
            } else if (value instanceof Boolean) {
                parsedMap.put(key, value);
            } else {
                throw new IllegalArgumentException("The value of the map entry '" + entry + "' is of type '" + value.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableMap(parsedMap);
    }

    private static List<?> checkListEntryTypes(List<?> list) {
        List<Object> parsedList = new ArrayList<>(list.size());
        for (Object value : list) {
            if (value == null) {
                parsedList.add(null);
            } else if (value instanceof Map) {
                parsedList.add(checkMapEntryTypes((Map) value));
            } else if (value instanceof List) {
                parsedList.add(checkListEntryTypes((List) value));
            } else if (value instanceof String) {
                parsedList.add(value);
            } else if (value instanceof Double) {
                parsedList.add(value);
            } else if (value instanceof Boolean) {
                parsedList.add(value);
            } else {
                throw new IllegalArgumentException("The entry '" + value + "' is of type '" + value.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableList(parsedList);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder disableServiceConfigLookUp() {
        this.lookUpServiceConfig = false;
        return this;
    }

    public void setStatsEnabled(boolean value) {
        this.statsEnabled = value;
    }

    public void setStatsRecordStartedRpcs(boolean value) {
        this.recordStartedRpcs = value;
    }

    public void setStatsRecordFinishedRpcs(boolean value) {
        this.recordFinishedRpcs = value;
    }

    public void setStatsRecordRealTimeMetrics(boolean value) {
        this.recordRealTimeMetrics = value;
    }

    public void setTracingEnabled(boolean value) {
        this.tracingEnabled = value;
    }

    String checkAuthority(String authority) {
        if (this.authorityCheckerDisabled) {
            return authority;
        }
        return GrpcUtil.checkAuthority(authority);
    }

    public ManagedChannelImplBuilder disableCheckAuthority() {
        this.authorityCheckerDisabled = true;
        return this;
    }

    public ManagedChannelImplBuilder enableCheckAuthority() {
        this.authorityCheckerDisabled = false;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, this.clientTransportFactoryBuilder.buildClientTransportFactory(), new ExponentialBackoffPolicy.Provider(), SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, getEffectiveInterceptors(), TimeProvider.SYSTEM_TIME_PROVIDER));
    }

    List<ClientInterceptor> getEffectiveInterceptors() {
        List<ClientInterceptor> effectiveInterceptors = new ArrayList<>(this.interceptors);
        this.temporarilyDisableRetry = false;
        if (this.statsEnabled) {
            this.temporarilyDisableRetry = true;
            ClientInterceptor statsInterceptor = null;
            try {
                Class<?> censusStatsAccessor = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
                Class<?> cls = Boolean.TYPE;
                Method getClientInterceptorMethod = censusStatsAccessor.getDeclaredMethod("getClientInterceptor", cls, cls, cls);
                statsInterceptor = (ClientInterceptor) getClientInterceptorMethod.invoke(null, Boolean.valueOf(this.recordStartedRpcs), Boolean.valueOf(this.recordFinishedRpcs), Boolean.valueOf(this.recordRealTimeMetrics));
            } catch (ClassNotFoundException e2) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e2);
            } catch (IllegalAccessException e3) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e3);
            } catch (NoSuchMethodException e4) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            } catch (InvocationTargetException e5) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e5);
            }
            if (statsInterceptor != null) {
                effectiveInterceptors.add(0, statsInterceptor);
            }
        }
        if (this.tracingEnabled) {
            this.temporarilyDisableRetry = true;
            ClientInterceptor tracingInterceptor = null;
            try {
                Class<?> censusTracingAccessor = Class.forName("io.grpc.census.InternalCensusTracingAccessor");
                Method getClientInterceptroMethod = censusTracingAccessor.getDeclaredMethod("getClientInterceptor", new Class[0]);
                tracingInterceptor = (ClientInterceptor) getClientInterceptroMethod.invoke(null, new Object[0]);
            } catch (ClassNotFoundException e6) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e6);
            } catch (IllegalAccessException e7) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e7);
            } catch (NoSuchMethodException e8) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e8);
            } catch (InvocationTargetException e9) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e9);
            }
            if (tracingInterceptor != null) {
                effectiveInterceptors.add(0, tracingInterceptor);
            }
        }
        return effectiveInterceptors;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDefaultPort() {
        return this.channelBuilderDefaultPortProvider.getDefaultPort();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static class DirectAddressNameResolverFactory extends NameResolver.Factory {
        final SocketAddress address;
        final String authority;

        DirectAddressNameResolverFactory(SocketAddress address, String authority) {
            this.address = address;
            this.authority = authority;
        }

        @Override // io.grpc.NameResolver.Factory
        public NameResolver newNameResolver(URI notUsedUri, NameResolver.Args args) {
            return new NameResolver() { // from class: io.grpc.internal.ManagedChannelImplBuilder.DirectAddressNameResolverFactory.1
                @Override // io.grpc.NameResolver
                public String getServiceAuthority() {
                    return DirectAddressNameResolverFactory.this.authority;
                }

                @Override // io.grpc.NameResolver
                public void start(NameResolver.Listener2 listener) {
                    listener.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(Collections.singletonList(new EquivalentAddressGroup(DirectAddressNameResolverFactory.this.address))).setAttributes(Attributes.EMPTY).build());
                }

                @Override // io.grpc.NameResolver
                public void shutdown() {
                }
            };
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            return ManagedChannelImplBuilder.DIRECT_ADDRESS_SCHEME;
        }
    }

    public ObjectPool<? extends Executor> getOffloadExecutorPool() {
        return this.offloadExecutorPool;
    }
}