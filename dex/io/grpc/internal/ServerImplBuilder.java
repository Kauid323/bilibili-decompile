package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.BinaryLog;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerStreamTracer;
import io.grpc.ServerTransportFilter;
import io.grpc.internal.CallTracer;
import io.grpc.internal.InternalHandlerRegistry;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ServerImplBuilder extends ServerBuilder<ServerImplBuilder> {
    @Nullable
    BinaryLog binlog;
    private final ClientTransportServersBuilder clientTransportServersBuilder;
    private static final Logger log = Logger.getLogger(ServerImplBuilder.class.getName());
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final HandlerRegistry DEFAULT_FALLBACK_REGISTRY = new DefaultFallbackRegistry();
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(120);
    final InternalHandlerRegistry.Builder registryBuilder = new InternalHandlerRegistry.Builder();
    final List<ServerTransportFilter> transportFilters = new ArrayList();
    final List<ServerInterceptor> interceptors = new ArrayList();
    private final List<ServerStreamTracer.Factory> streamTracerFactories = new ArrayList();
    HandlerRegistry fallbackRegistry = DEFAULT_FALLBACK_REGISTRY;
    ObjectPool<? extends Executor> executorPool = DEFAULT_EXECUTOR_POOL;
    DecompressorRegistry decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
    CompressorRegistry compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
    long handshakeTimeoutMillis = DEFAULT_HANDSHAKE_TIMEOUT_MILLIS;
    Deadline.Ticker ticker = Deadline.getSystemTicker();
    private boolean statsEnabled = true;
    private boolean recordStartedRpcs = true;
    private boolean recordFinishedRpcs = true;
    private boolean recordRealTimeMetrics = false;
    private boolean tracingEnabled = true;
    InternalChannelz channelz = InternalChannelz.instance();
    CallTracer.Factory callTracerFactory = CallTracer.getDefaultFactory();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ClientTransportServersBuilder {
        InternalServer buildClientTransportServers(List<? extends ServerStreamTracer.Factory> list);
    }

    public static ServerBuilder<?> forPort(int port) {
        throw new UnsupportedOperationException("ClientTransportServersBuilder is required, use a constructor");
    }

    public ServerImplBuilder(ClientTransportServersBuilder clientTransportServersBuilder) {
        this.clientTransportServersBuilder = (ClientTransportServersBuilder) Preconditions.checkNotNull(clientTransportServersBuilder, "clientTransportServersBuilder");
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder executor(@Nullable Executor executor) {
        this.executorPool = executor != null ? new FixedObjectPool<>(executor) : DEFAULT_EXECUTOR_POOL;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addService(ServerServiceDefinition service) {
        this.registryBuilder.addService((ServerServiceDefinition) Preconditions.checkNotNull(service, "service"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addService(BindableService bindableService) {
        return addService(((BindableService) Preconditions.checkNotNull(bindableService, "bindableService")).bindService());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addTransportFilter(ServerTransportFilter filter) {
        this.transportFilters.add(Preconditions.checkNotNull(filter, "filter"));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder intercept(ServerInterceptor interceptor) {
        this.interceptors.add(Preconditions.checkNotNull(interceptor, "interceptor"));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        this.streamTracerFactories.add(Preconditions.checkNotNull(factory, "factory"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder fallbackHandlerRegistry(@Nullable HandlerRegistry registry) {
        this.fallbackRegistry = registry != null ? registry : DEFAULT_FALLBACK_REGISTRY;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder decompressorRegistry(@Nullable DecompressorRegistry registry) {
        this.decompressorRegistry = registry != null ? registry : DEFAULT_DECOMPRESSOR_REGISTRY;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder compressorRegistry(@Nullable CompressorRegistry registry) {
        this.compressorRegistry = registry != null ? registry : DEFAULT_COMPRESSOR_REGISTRY;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder handshakeTimeout(long timeout, TimeUnit unit) {
        Preconditions.checkArgument(timeout > 0, "handshake timeout is %s, but must be positive", timeout);
        this.handshakeTimeoutMillis = ((TimeUnit) Preconditions.checkNotNull(unit, "unit")).toMillis(timeout);
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder setBinaryLog(@Nullable BinaryLog binaryLog) {
        this.binlog = binaryLog;
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

    public void setDeadlineTicker(Deadline.Ticker ticker) {
        this.ticker = (Deadline.Ticker) Preconditions.checkNotNull(ticker, "ticker");
    }

    @Override // io.grpc.ServerBuilder
    public Server build() {
        return new ServerImpl(this, this.clientTransportServersBuilder.buildClientTransportServers(getTracerFactories()), Context.ROOT);
    }

    List<? extends ServerStreamTracer.Factory> getTracerFactories() {
        ArrayList<ServerStreamTracer.Factory> tracerFactories = new ArrayList<>();
        if (this.statsEnabled) {
            ServerStreamTracer.Factory censusStatsTracerFactory = null;
            try {
                Class<?> censusStatsAccessor = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
                Class<?> cls = Boolean.TYPE;
                Method getServerStreamTracerFactoryMethod = censusStatsAccessor.getDeclaredMethod("getServerStreamTracerFactory", cls, cls, cls);
                censusStatsTracerFactory = (ServerStreamTracer.Factory) getServerStreamTracerFactoryMethod.invoke(null, Boolean.valueOf(this.recordStartedRpcs), Boolean.valueOf(this.recordFinishedRpcs), Boolean.valueOf(this.recordRealTimeMetrics));
            } catch (ClassNotFoundException e2) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e2);
            } catch (IllegalAccessException e3) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e3);
            } catch (NoSuchMethodException e4) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            } catch (InvocationTargetException e5) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e5);
            }
            if (censusStatsTracerFactory != null) {
                tracerFactories.add(censusStatsTracerFactory);
            }
        }
        if (this.tracingEnabled) {
            ServerStreamTracer.Factory tracingStreamTracerFactory = null;
            try {
                Class<?> censusTracingAccessor = Class.forName("io.grpc.census.InternalCensusTracingAccessor");
                Method getServerStreamTracerFactoryMethod2 = censusTracingAccessor.getDeclaredMethod("getServerStreamTracerFactory", new Class[0]);
                tracingStreamTracerFactory = (ServerStreamTracer.Factory) getServerStreamTracerFactoryMethod2.invoke(null, new Object[0]);
            } catch (ClassNotFoundException e6) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e6);
            } catch (IllegalAccessException e7) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e7);
            } catch (NoSuchMethodException e8) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e8);
            } catch (InvocationTargetException e9) {
                log.log(Level.FINE, "Unable to apply census stats", (Throwable) e9);
            }
            if (tracingStreamTracerFactory != null) {
                tracerFactories.add(tracingStreamTracerFactory);
            }
        }
        tracerFactories.addAll(this.streamTracerFactories);
        tracerFactories.trimToSize();
        return Collections.unmodifiableList(tracerFactories);
    }

    public InternalChannelz getChannelz() {
        return this.channelz;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class DefaultFallbackRegistry extends HandlerRegistry {
        private DefaultFallbackRegistry() {
        }

        @Override // io.grpc.HandlerRegistry
        public List<ServerServiceDefinition> getServices() {
            return Collections.emptyList();
        }

        @Override // io.grpc.HandlerRegistry
        @Nullable
        public ServerMethodDefinition<?, ?> lookupMethod(String methodName, @Nullable String authority) {
            return null;
        }
    }

    public ObjectPool<? extends Executor> getExecutorPool() {
        return this.executorPool;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder useTransportSecurity(File certChain, File privateKey) {
        throw new UnsupportedOperationException("TLS not supported in ServerImplBuilder");
    }
}