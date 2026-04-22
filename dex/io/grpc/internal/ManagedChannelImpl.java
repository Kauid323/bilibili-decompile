package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ClientStreamTracer;
import io.grpc.CompressorRegistry;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.ForwardingClientCall;
import io.grpc.Grpc;
import io.grpc.InternalChannelz;
import io.grpc.InternalConfigSelector;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.InternalWithLogId;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.AutoConfiguredLoadBalancerFactory;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.CallTracer;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.InternalSubchannel;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.ManagedChannelServiceConfig;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.RetriableStream;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ManagedChannelImpl extends ManagedChannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    static final long IDLE_TIMEOUT_MILLIS_DISABLE = -1;
    static final long SUBCHANNEL_SHUTDOWN_DELAY_SECONDS = 5;
    @Nullable
    private final String authorityOverride;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final ExecutorHolder balancerRpcExecutorHolder;
    private final ObjectPool<? extends Executor> balancerRpcExecutorPool;
    private final CallTracer.Factory callTracerFactory;
    private final long channelBufferLimit;
    private final CallTracer channelCallTracer;
    private final ChannelLogger channelLogger;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    @Nullable
    private final ManagedChannelServiceConfig defaultServiceConfig;
    private final DelayedClientTransport delayedTransport;
    private final Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private boolean fullStreamDecompression;
    private final long idleTimeoutMillis;
    private final Rescheduler idleTimer;
    private final Channel interceptorChannel;
    private ManagedChannelServiceConfig lastServiceConfig;
    @Nullable
    private LbHelperImpl lbHelper;
    private final AutoConfiguredLoadBalancerFactory loadBalancerFactory;
    private final InternalLogId logId;
    private final boolean lookUpServiceConfig;
    private final int maxTraceEvents;
    private NameResolver nameResolver;
    private final NameResolver.Args nameResolverArgs;
    @Nullable
    private BackoffPolicy nameResolverBackoffPolicy;
    private final NameResolver.Factory nameResolverFactory;
    private final NameResolverRegistry nameResolverRegistry;
    private boolean nameResolverStarted;
    private final ExecutorHolder offloadExecutorHolder;
    private final ClientTransportFactory oobTransportFactory;
    @Nullable
    private final ChannelCredentials originalChannelCreds;
    private final ClientTransportFactory originalTransportFactory;
    private boolean panicMode;
    @Nullable
    private Collection<RealChannel.PendingCall<?, ?>> pendingCalls;
    private final long perRpcBufferLimit;
    private final RealChannel realChannel;
    private final boolean retryEnabled;
    private final RestrictedScheduledExecutor scheduledExecutor;
    @Nullable
    private SynchronizationContext.ScheduledHandle scheduledNameResolverRefresh;
    private boolean serviceConfigUpdated;
    private boolean shutdownNowed;
    private final Supplier<Stopwatch> stopwatchSupplier;
    @Nullable
    private volatile LoadBalancer.SubchannelPicker subchannelPicker;
    private final String target;
    private volatile boolean terminated;
    private boolean terminating;
    private final TimeProvider timeProvider;
    private final ClientTransportFactory transportFactory;
    @Nullable
    private final String userAgent;
    static final Logger logger = Logger.getLogger(ManagedChannelImpl.class.getName());
    static final Pattern URI_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
    static final Status SHUTDOWN_NOW_STATUS = Status.UNAVAILABLE.withDescription("Channel shutdownNow invoked");
    static final Status SHUTDOWN_STATUS = Status.UNAVAILABLE.withDescription("Channel shutdown invoked");
    static final Status SUBCHANNEL_SHUTDOWN_STATUS = Status.UNAVAILABLE.withDescription("Subchannel shutdown invoked");
    private static final ManagedChannelServiceConfig EMPTY_SERVICE_CONFIG = ManagedChannelServiceConfig.empty();
    private static final InternalConfigSelector INITIAL_PENDING_SELECTOR = new InternalConfigSelector() { // from class: io.grpc.internal.ManagedChannelImpl.1
        @Override // io.grpc.InternalConfigSelector
        public InternalConfigSelector.Result selectConfig(LoadBalancer.PickSubchannelArgs args) {
            throw new IllegalStateException("Resolution is pending");
        }
    };
    final SynchronizationContext syncContext = new SynchronizationContext(new Thread.UncaughtExceptionHandler() { // from class: io.grpc.internal.ManagedChannelImpl.2
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread t, Throwable e2) {
            ManagedChannelImpl.logger.log(Level.SEVERE, "[" + ManagedChannelImpl.this.getLogId() + "] Uncaught exception in the SynchronizationContext. Panic!", e2);
            ManagedChannelImpl.this.panic(e2);
        }
    });
    private final ConnectivityStateManager channelStateManager = new ConnectivityStateManager();
    private final Set<InternalSubchannel> subchannels = new HashSet(16, 0.75f);
    private final Object pendingCallsInUseObject = new Object();
    private final Set<OobChannel> oobChannels = new HashSet(1, 0.75f);
    private final UncommittedRetriableStreamsRegistry uncommittedRetriableStreamsRegistry = new UncommittedRetriableStreamsRegistry();
    private final AtomicBoolean shutdown = new AtomicBoolean(false);
    private final CountDownLatch terminatedLatch = new CountDownLatch(1);
    private ResolutionState lastResolutionState = ResolutionState.NO_RESOLUTION;
    private final RetriableStream.ChannelBufferMeter channelBufferUsed = new RetriableStream.ChannelBufferMeter();
    private final ManagedClientTransport.Listener delayedTransportListener = new DelayedTransportListener();
    final InUseStateAggregator<Object> inUseStateAggregator = new IdleModeStateAggregator();
    private final ClientCallImpl.ClientStreamProvider transportProvider = new ChannelStreamProvider();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum ResolutionState {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShutdownNowSubchannels() {
        if (this.shutdownNowed) {
            for (InternalSubchannel subchannel : this.subchannels) {
                subchannel.shutdownNow(SHUTDOWN_NOW_STATUS);
            }
            for (OobChannel oobChannel : this.oobChannels) {
                oobChannel.getInternalSubchannel().shutdownNow(SHUTDOWN_NOW_STATUS);
            }
        }
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        final SettableFuture<InternalChannelz.ChannelStats> ret = SettableFuture.create();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1StatsFetcher
            @Override // java.lang.Runnable
            public void run() {
                InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
                ManagedChannelImpl.this.channelCallTracer.updateBuilder(builder);
                ManagedChannelImpl.this.channelTracer.updateBuilder(builder);
                builder.setTarget(ManagedChannelImpl.this.target).setState(ManagedChannelImpl.this.channelStateManager.getState());
                List<InternalWithLogId> children = new ArrayList<>();
                children.addAll(ManagedChannelImpl.this.subchannels);
                children.addAll(ManagedChannelImpl.this.oobChannels);
                builder.setSubchannels(children);
                ret.set(builder.build());
            }
        });
        return ret;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private class IdleModeTimer implements Runnable {
        private IdleModeTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ManagedChannelImpl.this.enterIdleMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownNameResolverAndLoadBalancer(boolean channelIsActive) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (channelIsActive) {
            Preconditions.checkState(this.nameResolverStarted, "nameResolver is not started");
            Preconditions.checkState(this.lbHelper != null, "lbHelper is null");
        }
        if (this.nameResolver != null) {
            cancelNameResolverBackoff();
            this.nameResolver.shutdown();
            this.nameResolverStarted = false;
            if (channelIsActive) {
                this.nameResolver = getNameResolver(this.target, this.authorityOverride, this.nameResolverFactory, this.nameResolverArgs);
            } else {
                this.nameResolver = null;
            }
        }
        if (this.lbHelper != null) {
            this.lbHelper.lb.shutdown();
            this.lbHelper = null;
        }
        this.subchannelPicker = null;
    }

    void exitIdleMode() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.shutdown.get() || this.panicMode) {
            return;
        }
        if (this.inUseStateAggregator.isInUse()) {
            cancelIdleTimer(false);
        } else {
            rescheduleIdleTimer();
        }
        if (this.lbHelper != null) {
            return;
        }
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Exiting idle mode");
        LbHelperImpl lbHelper = new LbHelperImpl();
        lbHelper.lb = this.loadBalancerFactory.newLoadBalancer(lbHelper);
        this.lbHelper = lbHelper;
        NameResolverListener listener = new NameResolverListener(lbHelper, this.nameResolver);
        this.nameResolver.start((NameResolver.Listener2) listener);
        this.nameResolverStarted = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterIdleMode() {
        shutdownNameResolverAndLoadBalancer(true);
        this.delayedTransport.reprocess(null);
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering IDLE state");
        this.channelStateManager.gotoState(ConnectivityState.IDLE);
        if (this.inUseStateAggregator.isInUse()) {
            exitIdleMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelIdleTimer(boolean permanent) {
        this.idleTimer.cancel(permanent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rescheduleIdleTimer() {
        if (this.idleTimeoutMillis == IDLE_TIMEOUT_MILLIS_DISABLE) {
            return;
        }
        this.idleTimer.reschedule(this.idleTimeoutMillis, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class DelayedNameResolverRefresh implements Runnable {
        DelayedNameResolverRefresh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ManagedChannelImpl.this.scheduledNameResolverRefresh = null;
            ManagedChannelImpl.this.refreshNameResolution();
        }
    }

    private void cancelNameResolverBackoff() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.scheduledNameResolverRefresh != null) {
            this.scheduledNameResolverRefresh.cancel();
            this.scheduledNameResolverRefresh = null;
            this.nameResolverBackoffPolicy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAndResetNameResolution() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        cancelNameResolverBackoff();
        refreshNameResolution();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshNameResolution() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.nameResolverStarted) {
            this.nameResolver.refresh();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class ChannelStreamProvider implements ClientCallImpl.ClientStreamProvider {
        private ChannelStreamProvider() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ClientTransport getTransport(LoadBalancer.PickSubchannelArgs args) {
            LoadBalancer.SubchannelPicker pickerCopy = ManagedChannelImpl.this.subchannelPicker;
            if (ManagedChannelImpl.this.shutdown.get()) {
                return ManagedChannelImpl.this.delayedTransport;
            }
            if (pickerCopy == null) {
                ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.ChannelStreamProvider.1ExitIdleModeForTransport
                    @Override // java.lang.Runnable
                    public void run() {
                        ManagedChannelImpl.this.exitIdleMode();
                    }
                });
                return ManagedChannelImpl.this.delayedTransport;
            }
            LoadBalancer.PickResult pickResult = pickerCopy.pickSubchannel(args);
            ClientTransport transport = GrpcUtil.getTransportFromPickResult(pickResult, args.getCallOptions().isWaitForReady());
            if (transport == null) {
                return ManagedChannelImpl.this.delayedTransport;
            }
            return transport;
        }

        @Override // io.grpc.internal.ClientCallImpl.ClientStreamProvider
        public ClientStream newStream(MethodDescriptor<?, ?> method, CallOptions callOptions, Metadata headers, Context context) {
            if (ManagedChannelImpl.this.retryEnabled) {
                RetriableStream.Throttle throttle = ManagedChannelImpl.this.lastServiceConfig.getRetryThrottling();
                ManagedChannelServiceConfig.MethodInfo methodInfo = (ManagedChannelServiceConfig.MethodInfo) callOptions.getOption(ManagedChannelServiceConfig.MethodInfo.KEY);
                RetryPolicy retryPolicy = methodInfo == null ? null : methodInfo.retryPolicy;
                HedgingPolicy hedgingPolicy = methodInfo != null ? methodInfo.hedgingPolicy : null;
                return new RetriableStream<ReqT>(method, headers, callOptions, retryPolicy, hedgingPolicy, throttle, context) { // from class: io.grpc.internal.ManagedChannelImpl.ChannelStreamProvider.1RetryStream
                    final /* synthetic */ CallOptions val$callOptions;
                    final /* synthetic */ Context val$context;
                    final /* synthetic */ Metadata val$headers;
                    final /* synthetic */ HedgingPolicy val$hedgingPolicy;
                    final /* synthetic */ MethodDescriptor val$method;
                    final /* synthetic */ RetryPolicy val$retryPolicy;
                    final /* synthetic */ RetriableStream.Throttle val$throttle;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(method, headers, ManagedChannelImpl.this.channelBufferUsed, ManagedChannelImpl.this.perRpcBufferLimit, ManagedChannelImpl.this.channelBufferLimit, ManagedChannelImpl.this.getCallExecutor(callOptions), ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), retryPolicy, hedgingPolicy, throttle);
                        this.val$method = method;
                        this.val$headers = headers;
                        this.val$callOptions = callOptions;
                        this.val$retryPolicy = retryPolicy;
                        this.val$hedgingPolicy = hedgingPolicy;
                        this.val$throttle = throttle;
                        this.val$context = context;
                    }

                    @Override // io.grpc.internal.RetriableStream
                    Status prestart() {
                        return ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.add(this);
                    }

                    @Override // io.grpc.internal.RetriableStream
                    void postCommit() {
                        ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.remove(this);
                    }

                    @Override // io.grpc.internal.RetriableStream
                    ClientStream newSubstream(ClientStreamTracer.Factory tracerFactory, Metadata newHeaders) {
                        CallOptions newOptions = this.val$callOptions.withStreamTracerFactory(tracerFactory);
                        ClientTransport transport = ChannelStreamProvider.this.getTransport(new PickSubchannelArgsImpl(this.val$method, newHeaders, newOptions));
                        Context origContext = this.val$context.attach();
                        try {
                            return transport.newStream(this.val$method, newHeaders, newOptions);
                        } finally {
                            this.val$context.detach(origContext);
                        }
                    }
                };
            }
            ClientTransport transport = getTransport(new PickSubchannelArgsImpl(method, headers, callOptions));
            Context origContext = context.attach();
            try {
                return transport.newStream(method, headers, callOptions);
            } finally {
                context.detach(origContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelImpl(ManagedChannelImplBuilder builder, ClientTransportFactory clientTransportFactory, BackoffPolicy.Provider backoffPolicyProvider, ObjectPool<? extends Executor> balancerRpcExecutorPool, Supplier<Stopwatch> stopwatchSupplier, List<ClientInterceptor> interceptors, final TimeProvider timeProvider) {
        this.lastServiceConfig = EMPTY_SERVICE_CONFIG;
        this.serviceConfigUpdated = false;
        this.target = (String) Preconditions.checkNotNull(builder.target, "target");
        this.logId = InternalLogId.allocate("Channel", this.target);
        this.timeProvider = (TimeProvider) Preconditions.checkNotNull(timeProvider, "timeProvider");
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(builder.executorPool, "executorPool");
        this.executor = (Executor) Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
        this.originalChannelCreds = builder.channelCredentials;
        this.originalTransportFactory = clientTransportFactory;
        this.transportFactory = new CallCredentialsApplyingTransportFactory(clientTransportFactory, builder.callCredentials, this.executor);
        this.oobTransportFactory = new CallCredentialsApplyingTransportFactory(clientTransportFactory, null, this.executor);
        this.scheduledExecutor = new RestrictedScheduledExecutor(this.transportFactory.getScheduledExecutorService());
        this.maxTraceEvents = builder.maxTraceEvents;
        this.channelTracer = new ChannelTracer(this.logId, builder.maxTraceEvents, timeProvider.currentTimeNanos(), "Channel for '" + this.target + "'");
        this.channelLogger = new ChannelLoggerImpl(this.channelTracer, timeProvider);
        ProxyDetector proxyDetector = builder.proxyDetector != null ? builder.proxyDetector : GrpcUtil.DEFAULT_PROXY_DETECTOR;
        this.retryEnabled = builder.retryEnabled && !builder.temporarilyDisableRetry;
        this.loadBalancerFactory = new AutoConfiguredLoadBalancerFactory(builder.defaultLbPolicy);
        this.offloadExecutorHolder = new ExecutorHolder((ObjectPool) Preconditions.checkNotNull(builder.offloadExecutorPool, "offloadExecutorPool"));
        this.nameResolverRegistry = builder.nameResolverRegistry;
        ScParser serviceConfigParser = new ScParser(this.retryEnabled, builder.maxRetryAttempts, builder.maxHedgedAttempts, this.loadBalancerFactory);
        this.nameResolverArgs = NameResolver.Args.newBuilder().setDefaultPort(builder.getDefaultPort()).setProxyDetector(proxyDetector).setSynchronizationContext(this.syncContext).setScheduledExecutorService(this.scheduledExecutor).setServiceConfigParser(serviceConfigParser).setChannelLogger(this.channelLogger).setOffloadExecutor(new Executor() { // from class: io.grpc.internal.ManagedChannelImpl.3
            @Override // java.util.concurrent.Executor
            public void execute(Runnable command) {
                ManagedChannelImpl.this.offloadExecutorHolder.getExecutor().execute(command);
            }
        }).build();
        this.authorityOverride = builder.authorityOverride;
        this.nameResolverFactory = builder.nameResolverFactory;
        this.nameResolver = getNameResolver(this.target, this.authorityOverride, this.nameResolverFactory, this.nameResolverArgs);
        this.balancerRpcExecutorPool = (ObjectPool) Preconditions.checkNotNull(balancerRpcExecutorPool, "balancerRpcExecutorPool");
        this.balancerRpcExecutorHolder = new ExecutorHolder(balancerRpcExecutorPool);
        this.delayedTransport = new DelayedClientTransport(this.executor, this.syncContext);
        this.delayedTransport.start(this.delayedTransportListener);
        this.backoffPolicyProvider = backoffPolicyProvider;
        if (builder.defaultServiceConfig != null) {
            NameResolver.ConfigOrError parsedDefaultServiceConfig = serviceConfigParser.parseServiceConfig(builder.defaultServiceConfig);
            Preconditions.checkState(parsedDefaultServiceConfig.getError() == null, "Default config is invalid: %s", parsedDefaultServiceConfig.getError());
            this.defaultServiceConfig = (ManagedChannelServiceConfig) parsedDefaultServiceConfig.getConfig();
            this.lastServiceConfig = this.defaultServiceConfig;
        } else {
            this.defaultServiceConfig = null;
        }
        this.lookUpServiceConfig = builder.lookUpServiceConfig;
        this.realChannel = new RealChannel(this.nameResolver.getServiceAuthority());
        Channel channel = this.realChannel;
        this.interceptorChannel = ClientInterceptors.intercept(builder.binlog != null ? builder.binlog.wrapChannel(channel) : channel, interceptors);
        this.stopwatchSupplier = (Supplier) Preconditions.checkNotNull(stopwatchSupplier, "stopwatchSupplier");
        if (builder.idleTimeoutMillis == IDLE_TIMEOUT_MILLIS_DISABLE) {
            this.idleTimeoutMillis = builder.idleTimeoutMillis;
        } else {
            Preconditions.checkArgument(builder.idleTimeoutMillis >= ManagedChannelImplBuilder.IDLE_MODE_MIN_TIMEOUT_MILLIS, "invalid idleTimeoutMillis %s", builder.idleTimeoutMillis);
            this.idleTimeoutMillis = builder.idleTimeoutMillis;
        }
        this.idleTimer = new Rescheduler(new IdleModeTimer(), this.syncContext, this.transportFactory.getScheduledExecutorService(), (Stopwatch) stopwatchSupplier.get());
        this.fullStreamDecompression = builder.fullStreamDecompression;
        this.decompressorRegistry = (DecompressorRegistry) Preconditions.checkNotNull(builder.decompressorRegistry, "decompressorRegistry");
        this.compressorRegistry = (CompressorRegistry) Preconditions.checkNotNull(builder.compressorRegistry, "compressorRegistry");
        this.userAgent = builder.userAgent;
        this.channelBufferLimit = builder.retryBufferSize;
        this.perRpcBufferLimit = builder.perRpcBufferLimit;
        this.callTracerFactory = new CallTracer.Factory() { // from class: io.grpc.internal.ManagedChannelImpl.1ChannelCallTracerFactory
            @Override // io.grpc.internal.CallTracer.Factory
            public CallTracer create() {
                return new CallTracer(timeProvider);
            }
        };
        this.channelCallTracer = this.callTracerFactory.create();
        this.channelz = (InternalChannelz) Preconditions.checkNotNull(builder.channelz);
        this.channelz.addRootChannel(this);
        if (!this.lookUpServiceConfig) {
            if (this.defaultServiceConfig != null) {
                this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Service config look-up disabled, using default service config");
            }
            this.serviceConfigUpdated = true;
        }
    }

    private static NameResolver getNameResolver(String target, NameResolver.Factory nameResolverFactory, NameResolver.Args nameResolverArgs) {
        NameResolver resolver;
        URI targetUri = null;
        StringBuilder uriSyntaxErrors = new StringBuilder();
        try {
            targetUri = new URI(target);
        } catch (URISyntaxException e2) {
            uriSyntaxErrors.append(e2.getMessage());
        }
        if (targetUri != null && (resolver = nameResolverFactory.newNameResolver(targetUri, nameResolverArgs)) != null) {
            return resolver;
        }
        if (!URI_PATTERN.matcher(target).matches()) {
            try {
                URI targetUri2 = new URI(nameResolverFactory.getDefaultScheme(), "", "/" + target, null);
                NameResolver resolver2 = nameResolverFactory.newNameResolver(targetUri2, nameResolverArgs);
                if (resolver2 != null) {
                    return resolver2;
                }
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", target, uriSyntaxErrors.length() > 0 ? " (" + ((Object) uriSyntaxErrors) + ")" : ""));
    }

    static NameResolver getNameResolver(String target, @Nullable final String overrideAuthority, NameResolver.Factory nameResolverFactory, NameResolver.Args nameResolverArgs) {
        NameResolver resolver = getNameResolver(target, nameResolverFactory, nameResolverArgs);
        if (overrideAuthority == null) {
            return resolver;
        }
        return new ForwardingNameResolver(resolver) { // from class: io.grpc.internal.ManagedChannelImpl.4
            @Override // io.grpc.internal.ForwardingNameResolver, io.grpc.NameResolver
            public String getServiceAuthority() {
                return overrideAuthority;
            }
        };
    }

    InternalConfigSelector getConfigSelector() {
        return (InternalConfigSelector) this.realChannel.configSelector.get();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdown() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "shutdown() called");
        if (!this.shutdown.compareAndSet(false, true)) {
            return this;
        }
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1Shutdown
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering SHUTDOWN state");
                ManagedChannelImpl.this.channelStateManager.gotoState(ConnectivityState.SHUTDOWN);
            }
        });
        this.realChannel.shutdown();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1CancelIdleTimer
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.cancelIdleTimer(true);
            }
        });
        return this;
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdownNow() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "shutdownNow() called");
        shutdown();
        this.realChannel.shutdownNow();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1ShutdownNow
            @Override // java.lang.Runnable
            public void run() {
                if (!ManagedChannelImpl.this.shutdownNowed) {
                    ManagedChannelImpl.this.shutdownNowed = true;
                    ManagedChannelImpl.this.maybeShutdownNowSubchannels();
                }
            }
        });
        return this;
    }

    void panic(final Throwable t) {
        if (this.panicMode) {
            return;
        }
        this.panicMode = true;
        cancelIdleTimer(true);
        shutdownNameResolverAndLoadBalancer(false);
        updateSubchannelPicker(new LoadBalancer.SubchannelPicker() { // from class: io.grpc.internal.ManagedChannelImpl.1PanicSubchannelPicker
            private final LoadBalancer.PickResult panicPickResult;

            {
                this.panicPickResult = LoadBalancer.PickResult.withDrop(Status.INTERNAL.withDescription("Panic! This is a bug!").withCause(t));
            }

            @Override // io.grpc.LoadBalancer.SubchannelPicker
            public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
                return this.panicPickResult;
            }

            public String toString() {
                return MoreObjects.toStringHelper(C1PanicSubchannelPicker.class).add("panicPickResult", this.panicPickResult).toString();
            }
        });
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.channelStateManager.gotoState(ConnectivityState.TRANSIENT_FAILURE);
    }

    boolean isInPanicMode() {
        return this.panicMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubchannelPicker(LoadBalancer.SubchannelPicker newPicker) {
        this.subchannelPicker = newPicker;
        this.delayedTransport.reprocess(newPicker);
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.shutdown.get();
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.terminatedLatch.await(timeout, unit);
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // io.grpc.Channel
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
        return this.interceptorChannel.newCall(method, callOptions);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.interceptorChannel.authority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Executor getCallExecutor(CallOptions callOptions) {
        Executor executor = callOptions.getExecutor();
        if (executor == null) {
            return this.executor;
        }
        return executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class RealChannel extends Channel {
        private final String authority;
        private final Channel clientCallImplChannel;
        private final AtomicReference<InternalConfigSelector> configSelector;

        private RealChannel(String authority) {
            this.configSelector = new AtomicReference<>(ManagedChannelImpl.INITIAL_PENDING_SELECTOR);
            this.clientCallImplChannel = new Channel() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.1
                @Override // io.grpc.Channel
                public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> method, CallOptions callOptions) {
                    return new ClientCallImpl(method, ManagedChannelImpl.this.getCallExecutor(callOptions), callOptions, ManagedChannelImpl.this.transportProvider, ManagedChannelImpl.this.terminated ? null : ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.channelCallTracer, null).setFullStreamDecompression(ManagedChannelImpl.this.fullStreamDecompression).setDecompressorRegistry(ManagedChannelImpl.this.decompressorRegistry).setCompressorRegistry(ManagedChannelImpl.this.compressorRegistry);
                }

                @Override // io.grpc.Channel
                public String authority() {
                    return RealChannel.this.authority;
                }
            };
            this.authority = (String) Preconditions.checkNotNull(authority, "authority");
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
            if (this.configSelector.get() != ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                return newClientCall(method, callOptions);
            }
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.exitIdleMode();
                }
            });
            if (this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                if (ManagedChannelImpl.this.shutdown.get()) {
                    return new ClientCall<ReqT, RespT>() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.3
                        @Override // io.grpc.ClientCall
                        public void start(ClientCall.Listener<RespT> responseListener, Metadata headers) {
                            responseListener.onClose(ManagedChannelImpl.SHUTDOWN_STATUS, new Metadata());
                        }

                        @Override // io.grpc.ClientCall
                        public void request(int numMessages) {
                        }

                        @Override // io.grpc.ClientCall
                        public void cancel(@Nullable String message, @Nullable Throwable cause) {
                        }

                        @Override // io.grpc.ClientCall
                        public void halfClose() {
                        }

                        @Override // io.grpc.ClientCall
                        public void sendMessage(ReqT message) {
                        }
                    };
                }
                Context context = Context.current();
                final PendingCall<ReqT, RespT> pendingCall = new PendingCall<>(context, method, callOptions);
                ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RealChannel.this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                            if (ManagedChannelImpl.this.pendingCalls == null) {
                                ManagedChannelImpl.this.pendingCalls = new LinkedHashSet();
                                ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(ManagedChannelImpl.this.pendingCallsInUseObject, true);
                            }
                            ManagedChannelImpl.this.pendingCalls.add(pendingCall);
                            return;
                        }
                        pendingCall.reprocess();
                    }
                });
                return pendingCall;
            }
            return newClientCall(method, callOptions);
        }

        void updateConfigSelector(@Nullable InternalConfigSelector config) {
            InternalConfigSelector prevConfig = this.configSelector.get();
            this.configSelector.set(config);
            if (prevConfig == ManagedChannelImpl.INITIAL_PENDING_SELECTOR && ManagedChannelImpl.this.pendingCalls != null) {
                for (PendingCall<?, ?> pendingCall : ManagedChannelImpl.this.pendingCalls) {
                    pendingCall.reprocess();
                }
            }
        }

        void onConfigError() {
            if (this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                updateConfigSelector(null);
            }
        }

        void shutdown() {
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.1RealChannelShutdown
                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.pendingCalls == null) {
                        if (RealChannel.this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                            RealChannel.this.configSelector.set(null);
                        }
                        ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.onShutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
                    }
                }
            });
        }

        void shutdownNow() {
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.1RealChannelShutdownNow
                @Override // java.lang.Runnable
                public void run() {
                    if (RealChannel.this.configSelector.get() == ManagedChannelImpl.INITIAL_PENDING_SELECTOR) {
                        RealChannel.this.configSelector.set(null);
                    }
                    if (ManagedChannelImpl.this.pendingCalls != null) {
                        for (PendingCall<?, ?> pendingCall : ManagedChannelImpl.this.pendingCalls) {
                            pendingCall.cancel("Channel is forcefully shutdown", (Throwable) null);
                        }
                    }
                    ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.onShutdownNow(ManagedChannelImpl.SHUTDOWN_NOW_STATUS);
                }
            });
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.authority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public final class PendingCall<ReqT, RespT> extends DelayedClientCall<ReqT, RespT> {
            final CallOptions callOptions;
            final Context context;
            final MethodDescriptor<ReqT, RespT> method;

            PendingCall(Context context, MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
                super(ManagedChannelImpl.this.getCallExecutor(callOptions), ManagedChannelImpl.this.scheduledExecutor, callOptions.getDeadline());
                this.context = context;
                this.method = method;
                this.callOptions = callOptions;
            }

            void reprocess() {
                ManagedChannelImpl.this.getCallExecutor(this.callOptions).execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.RealChannel.PendingCall.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context previous = PendingCall.this.context.attach();
                        try {
                            ClientCall<ReqT, RespT> realCall = RealChannel.this.newClientCall(PendingCall.this.method, PendingCall.this.callOptions);
                            PendingCall.this.context.detach(previous);
                            PendingCall.this.setCall(realCall);
                            ManagedChannelImpl.this.syncContext.execute(new PendingCallRemoval());
                        } catch (Throwable th) {
                            PendingCall.this.context.detach(previous);
                            throw th;
                        }
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.grpc.internal.DelayedClientCall
            public void callCancelled() {
                super.callCancelled();
                ManagedChannelImpl.this.syncContext.execute(new PendingCallRemoval());
            }

            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            final class PendingCallRemoval implements Runnable {
                PendingCallRemoval() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.pendingCalls != null) {
                        ManagedChannelImpl.this.pendingCalls.remove(PendingCall.this);
                        if (ManagedChannelImpl.this.pendingCalls.isEmpty()) {
                            ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(ManagedChannelImpl.this.pendingCallsInUseObject, false);
                            ManagedChannelImpl.this.pendingCalls = null;
                            if (ManagedChannelImpl.this.shutdown.get()) {
                                ManagedChannelImpl.this.uncommittedRetriableStreamsRegistry.onShutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> ClientCall<ReqT, RespT> newClientCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
            InternalConfigSelector selector = this.configSelector.get();
            if (selector == null) {
                return this.clientCallImplChannel.newCall(method, callOptions);
            }
            if (selector instanceof ManagedChannelServiceConfig.ServiceConfigConvertedSelector) {
                ManagedChannelServiceConfig.MethodInfo methodInfo = ((ManagedChannelServiceConfig.ServiceConfigConvertedSelector) selector).config.getMethodConfig(method);
                if (methodInfo != null) {
                    callOptions = callOptions.withOption(ManagedChannelServiceConfig.MethodInfo.KEY, methodInfo);
                }
                return this.clientCallImplChannel.newCall(method, callOptions);
            }
            return new ConfigSelectingClientCall(selector, this.clientCallImplChannel, ManagedChannelImpl.this.executor, method, callOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ConfigSelectingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private final Executor callExecutor;
        private CallOptions callOptions;
        private final Channel channel;
        private final InternalConfigSelector configSelector;
        private final Context context;
        private ClientCall<ReqT, RespT> delegate;
        private final MethodDescriptor<ReqT, RespT> method;

        ConfigSelectingClientCall(InternalConfigSelector configSelector, Channel channel, Executor channelExecutor, MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
            this.configSelector = configSelector;
            this.channel = channel;
            this.method = method;
            this.callOptions = callOptions;
            this.callExecutor = callOptions.getExecutor() == null ? channelExecutor : callOptions.getExecutor();
            this.context = Context.current();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        protected ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public void start(ClientCall.Listener<RespT> observer, Metadata headers) {
            LoadBalancer.PickSubchannelArgs args = new PickSubchannelArgsImpl(this.method, headers, this.callOptions);
            InternalConfigSelector.Result result = this.configSelector.selectConfig(args);
            Status status = result.getStatus();
            if (!status.isOk()) {
                executeCloseObserverInContext(observer, status);
                return;
            }
            ClientInterceptor interceptor = result.getInterceptor();
            ManagedChannelServiceConfig config = (ManagedChannelServiceConfig) result.getConfig();
            ManagedChannelServiceConfig.MethodInfo methodInfo = config.getMethodConfig(this.method);
            if (methodInfo != null) {
                this.callOptions = this.callOptions.withOption(ManagedChannelServiceConfig.MethodInfo.KEY, methodInfo);
            }
            if (interceptor != null) {
                this.delegate = interceptor.interceptCall(this.method, this.callOptions, this.channel);
            } else {
                this.delegate = this.channel.newCall(this.method, this.callOptions);
            }
            this.delegate.start(observer, headers);
        }

        private void executeCloseObserverInContext(final ClientCall.Listener<RespT> observer, final Status status) {
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ManagedChannelImpl.ConfigSelectingClientCall.1CloseInContext
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ConfigSelectingClientCall.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    observer.onClose(status, new Metadata());
                }
            });
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public void cancel(@Nullable String message, @Nullable Throwable cause) {
            if (this.delegate != null) {
                this.delegate.cancel(message, cause);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeTerminateChannel() {
        if (!this.terminated && this.shutdown.get() && this.subchannels.isEmpty() && this.oobChannels.isEmpty()) {
            this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
            this.channelz.removeRootChannel(this);
            this.executorPool.returnObject(this.executor);
            this.balancerRpcExecutorHolder.release();
            this.offloadExecutorHolder.release();
            this.transportFactory.close();
            this.terminated = true;
            this.terminatedLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInternalSubchannelState(ConnectivityStateInfo newState) {
        if (newState.getState() == ConnectivityState.TRANSIENT_FAILURE || newState.getState() == ConnectivityState.IDLE) {
            refreshAndResetNameResolution();
        }
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean requestConnection) {
        ConnectivityState savedChannelState = this.channelStateManager.getState();
        if (requestConnection && savedChannelState == ConnectivityState.IDLE) {
            this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1RequestConnection
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.exitIdleMode();
                    if (ManagedChannelImpl.this.subchannelPicker != null) {
                        ManagedChannelImpl.this.subchannelPicker.requestConnection();
                    }
                    if (ManagedChannelImpl.this.lbHelper != null) {
                        ManagedChannelImpl.this.lbHelper.lb.requestConnection();
                    }
                }
            });
        }
        return savedChannelState;
    }

    @Override // io.grpc.ManagedChannel
    public void notifyWhenStateChanged(final ConnectivityState source, final Runnable callback) {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1NotifyStateChanged
            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.channelStateManager.notifyWhenStateChanged(callback, ManagedChannelImpl.this.executor, source);
            }
        });
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1ResetConnectBackoff
            @Override // java.lang.Runnable
            public void run() {
                if (!ManagedChannelImpl.this.shutdown.get()) {
                    if (ManagedChannelImpl.this.scheduledNameResolverRefresh != null && ManagedChannelImpl.this.scheduledNameResolverRefresh.isPending()) {
                        Preconditions.checkState(ManagedChannelImpl.this.nameResolverStarted, "name resolver must be started");
                        ManagedChannelImpl.this.refreshAndResetNameResolution();
                    }
                    for (InternalSubchannel subchannel : ManagedChannelImpl.this.subchannels) {
                        subchannel.resetConnectBackoff();
                    }
                    for (OobChannel oobChannel : ManagedChannelImpl.this.oobChannels) {
                        oobChannel.resetConnectBackoff();
                    }
                }
            }
        });
    }

    @Override // io.grpc.ManagedChannel
    public void enterIdle() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1PrepareToLoseNetworkRunnable
            @Override // java.lang.Runnable
            public void run() {
                if (!ManagedChannelImpl.this.shutdown.get() && ManagedChannelImpl.this.lbHelper != null) {
                    ManagedChannelImpl.this.cancelIdleTimer(false);
                    ManagedChannelImpl.this.enterIdleMode();
                }
            }
        });
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class UncommittedRetriableStreamsRegistry {
        final Object lock;
        Status shutdownStatus;
        Collection<ClientStream> uncommittedRetriableStreams;

        private UncommittedRetriableStreamsRegistry() {
            this.lock = new Object();
            this.uncommittedRetriableStreams = new HashSet();
        }

        void onShutdown(Status reason) {
            boolean shouldShutdownDelayedTransport = false;
            synchronized (this.lock) {
                if (this.shutdownStatus != null) {
                    return;
                }
                this.shutdownStatus = reason;
                if (this.uncommittedRetriableStreams.isEmpty()) {
                    shouldShutdownDelayedTransport = true;
                }
                if (shouldShutdownDelayedTransport) {
                    ManagedChannelImpl.this.delayedTransport.shutdown(reason);
                }
            }
        }

        void onShutdownNow(Status reason) {
            Collection<ClientStream> streams;
            onShutdown(reason);
            synchronized (this.lock) {
                streams = new ArrayList<>(this.uncommittedRetriableStreams);
            }
            for (ClientStream stream : streams) {
                stream.cancel(reason);
            }
            ManagedChannelImpl.this.delayedTransport.shutdownNow(reason);
        }

        @Nullable
        Status add(RetriableStream<?> retriableStream) {
            synchronized (this.lock) {
                if (this.shutdownStatus != null) {
                    return this.shutdownStatus;
                }
                this.uncommittedRetriableStreams.add(retriableStream);
                return null;
            }
        }

        void remove(RetriableStream<?> retriableStream) {
            Status shutdownStatusCopy = null;
            synchronized (this.lock) {
                this.uncommittedRetriableStreams.remove(retriableStream);
                if (this.uncommittedRetriableStreams.isEmpty()) {
                    shutdownStatusCopy = this.shutdownStatus;
                    this.uncommittedRetriableStreams = new HashSet();
                }
            }
            if (shutdownStatusCopy != null) {
                ManagedChannelImpl.this.delayedTransport.shutdown(shutdownStatusCopy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class LbHelperImpl extends LoadBalancer.Helper {
        AutoConfiguredLoadBalancerFactory.AutoConfiguredLoadBalancer lb;

        private LbHelperImpl() {
        }

        @Override // io.grpc.LoadBalancer.Helper
        public AbstractSubchannel createSubchannel(LoadBalancer.CreateSubchannelArgs args) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            Preconditions.checkState(!ManagedChannelImpl.this.terminating, "Channel is being terminated");
            return new SubchannelImpl(args, this);
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateBalancingState(final ConnectivityState newState, final LoadBalancer.SubchannelPicker newPicker) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            Preconditions.checkNotNull(newState, "newState");
            Preconditions.checkNotNull(newPicker, "newPicker");
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1UpdateBalancingState
                @Override // java.lang.Runnable
                public void run() {
                    if (LbHelperImpl.this == ManagedChannelImpl.this.lbHelper) {
                        ManagedChannelImpl.this.updateSubchannelPicker(newPicker);
                        if (newState != ConnectivityState.SHUTDOWN) {
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Entering {0} state with picker: {1}", newState, newPicker);
                            ManagedChannelImpl.this.channelStateManager.gotoState(newState);
                        }
                    }
                }
            });
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void refreshNameResolution() {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1LoadBalancerRefreshNameResolution
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelImpl.this.refreshAndResetNameResolution();
                }
            });
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ManagedChannel createOobChannel(EquivalentAddressGroup addressGroup, String authority) {
            Preconditions.checkState(!ManagedChannelImpl.this.terminated, "Channel is terminated");
            long oobChannelCreationTime = ManagedChannelImpl.this.timeProvider.currentTimeNanos();
            InternalLogId oobLogId = InternalLogId.allocate("OobChannel", (String) null);
            InternalLogId subchannelLogId = InternalLogId.allocate("Subchannel-OOB", authority);
            ChannelTracer oobChannelTracer = new ChannelTracer(oobLogId, ManagedChannelImpl.this.maxTraceEvents, oobChannelCreationTime, "OobChannel for " + addressGroup);
            final OobChannel oobChannel = new OobChannel(authority, ManagedChannelImpl.this.balancerRpcExecutorPool, ManagedChannelImpl.this.oobTransportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.syncContext, ManagedChannelImpl.this.callTracerFactory.create(), oobChannelTracer, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.timeProvider);
            ManagedChannelImpl.this.channelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child OobChannel created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(oobChannelCreationTime).setChannelRef(oobChannel).build());
            ChannelTracer subchannelTracer = new ChannelTracer(subchannelLogId, ManagedChannelImpl.this.maxTraceEvents, oobChannelCreationTime, "Subchannel for " + addressGroup);
            ChannelLogger subchannelLogger = new ChannelLoggerImpl(subchannelTracer, ManagedChannelImpl.this.timeProvider);
            InternalSubchannel internalSubchannel = new InternalSubchannel(Collections.singletonList(addressGroup), authority, ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.oobTransportFactory, ManagedChannelImpl.this.oobTransportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.syncContext, new InternalSubchannel.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ManagedOobChannelCallback
                @Override // io.grpc.internal.InternalSubchannel.Callback
                void onTerminated(InternalSubchannel is) {
                    ManagedChannelImpl.this.oobChannels.remove(oobChannel);
                    ManagedChannelImpl.this.channelz.removeSubchannel(is);
                    oobChannel.handleSubchannelTerminated();
                    ManagedChannelImpl.this.maybeTerminateChannel();
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void onStateChange(InternalSubchannel is, ConnectivityStateInfo newState) {
                    ManagedChannelImpl.this.handleInternalSubchannelState(newState);
                    oobChannel.handleSubchannelStateChange(newState);
                }
            }, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create(), subchannelTracer, subchannelLogId, subchannelLogger);
            oobChannelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child Subchannel created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(oobChannelCreationTime).setSubchannelRef(internalSubchannel).build());
            ManagedChannelImpl.this.channelz.addSubchannel(oobChannel);
            ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
            oobChannel.setSubchannel(internalSubchannel);
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1AddOobChannel
                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.terminating) {
                        oobChannel.shutdown();
                    }
                    if (!ManagedChannelImpl.this.terminated) {
                        ManagedChannelImpl.this.oobChannels.add(oobChannel);
                    }
                }
            });
            return oobChannel;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [io.grpc.ManagedChannelBuilder, io.grpc.ManagedChannelBuilder<?>] */
        @Override // io.grpc.LoadBalancer.Helper
        @Deprecated
        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String target) {
            return createResolvingOobChannelBuilder(target, new DefaultChannelCreds()).overrideAuthority(getAuthority());
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(final String target, final ChannelCredentials channelCreds) {
            Preconditions.checkNotNull(channelCreds, "channelCreds");
            Preconditions.checkState(!ManagedChannelImpl.this.terminated, "Channel is terminated");
            C1ResolvingOobChannelBuilder builder = new ForwardingChannelBuilder<C1ResolvingOobChannelBuilder>() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ResolvingOobChannelBuilder
                final ManagedChannelBuilder<?> delegate;

                {
                    final ClientTransportFactory transportFactory;
                    CallCredentials callCredentials;
                    if (channelCreds instanceof DefaultChannelCreds) {
                        transportFactory = ManagedChannelImpl.this.originalTransportFactory;
                        callCredentials = null;
                    } else {
                        ClientTransportFactory.SwapChannelCredentialsResult swapResult = ManagedChannelImpl.this.originalTransportFactory.swapChannelCredentials(channelCreds);
                        if (swapResult == null) {
                            this.delegate = Grpc.newChannelBuilder(target, channelCreds);
                            return;
                        }
                        ClientTransportFactory transportFactory2 = swapResult.transportFactory;
                        CallCredentials callCredentials2 = swapResult.callCredentials;
                        transportFactory = transportFactory2;
                        callCredentials = callCredentials2;
                    }
                    ManagedChannelImplBuilder.ClientTransportFactoryBuilder transportFactoryBuilder = new ManagedChannelImplBuilder.ClientTransportFactoryBuilder() { // from class: io.grpc.internal.ManagedChannelImpl.LbHelperImpl.1ResolvingOobChannelBuilder.1
                        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
                        public ClientTransportFactory buildClientTransportFactory() {
                            return transportFactory;
                        }
                    };
                    this.delegate = new ManagedChannelImplBuilder(target, channelCreds, callCredentials, transportFactoryBuilder, new ManagedChannelImplBuilder.FixedPortProvider(ManagedChannelImpl.this.nameResolverArgs.getDefaultPort()));
                }

                @Override // io.grpc.ForwardingChannelBuilder
                protected ManagedChannelBuilder<?> delegate() {
                    return this.delegate;
                }
            }.nameResolverFactory(ManagedChannelImpl.this.nameResolverFactory);
            return builder.executor(ManagedChannelImpl.this.executor).offloadExecutor(ManagedChannelImpl.this.offloadExecutorHolder.getExecutor()).maxTraceEvents(ManagedChannelImpl.this.maxTraceEvents).proxyDetector(ManagedChannelImpl.this.nameResolverArgs.getProxyDetector()).userAgent(ManagedChannelImpl.this.userAgent);
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ChannelCredentials getUnsafeChannelCredentials() {
            if (ManagedChannelImpl.this.originalChannelCreds != null) {
                return ManagedChannelImpl.this.originalChannelCreds;
            }
            return new DefaultChannelCreds();
        }

        @Override // io.grpc.LoadBalancer.Helper
        public void updateOobChannelAddresses(ManagedChannel channel, EquivalentAddressGroup eag) {
            Preconditions.checkArgument(channel instanceof OobChannel, "channel must have been returned from createOobChannel");
            ((OobChannel) channel).updateAddresses(eag);
        }

        @Override // io.grpc.LoadBalancer.Helper
        public String getAuthority() {
            return ManagedChannelImpl.this.authority();
        }

        @Override // io.grpc.LoadBalancer.Helper
        public SynchronizationContext getSynchronizationContext() {
            return ManagedChannelImpl.this.syncContext;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ScheduledExecutorService getScheduledExecutorService() {
            return ManagedChannelImpl.this.scheduledExecutor;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public ChannelLogger getChannelLogger() {
            return ManagedChannelImpl.this.channelLogger;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public NameResolver.Args getNameResolverArgs() {
            return ManagedChannelImpl.this.nameResolverArgs;
        }

        @Override // io.grpc.LoadBalancer.Helper
        public NameResolverRegistry getNameResolverRegistry() {
            return ManagedChannelImpl.this.nameResolverRegistry;
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        final class DefaultChannelCreds extends ChannelCredentials {
            DefaultChannelCreds() {
            }

            @Override // io.grpc.ChannelCredentials
            public ChannelCredentials withoutBearerTokens() {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class NameResolverListener extends NameResolver.Listener2 {
        final LbHelperImpl helper;
        final NameResolver resolver;

        NameResolverListener(LbHelperImpl helperImpl, NameResolver resolver) {
            this.helper = (LbHelperImpl) Preconditions.checkNotNull(helperImpl, "helperImpl");
            this.resolver = (NameResolver) Preconditions.checkNotNull(resolver, "resolver");
        }

        @Override // io.grpc.NameResolver.Listener2
        public void onResult(final NameResolver.ResolutionResult resolutionResult) {
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.NameResolverListener.1NamesResolved
                @Override // java.lang.Runnable
                public void run() {
                    ManagedChannelServiceConfig validServiceConfig;
                    ManagedChannelServiceConfig effectiveServiceConfig;
                    List<EquivalentAddressGroup> servers = resolutionResult.getAddresses();
                    ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Resolved address: {0}, config={1}", servers, resolutionResult.getAttributes());
                    if (ManagedChannelImpl.this.lastResolutionState != ResolutionState.SUCCESS) {
                        ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Address resolved: {0}", servers);
                        ManagedChannelImpl.this.lastResolutionState = ResolutionState.SUCCESS;
                    }
                    ManagedChannelImpl.this.nameResolverBackoffPolicy = null;
                    NameResolver.ConfigOrError configOrError = resolutionResult.getServiceConfig();
                    InternalConfigSelector resolvedConfigSelector = (InternalConfigSelector) resolutionResult.getAttributes().get(InternalConfigSelector.KEY);
                    if (configOrError != null && configOrError.getConfig() != null) {
                        validServiceConfig = (ManagedChannelServiceConfig) configOrError.getConfig();
                    } else {
                        validServiceConfig = null;
                    }
                    Status serviceConfigError = configOrError != null ? configOrError.getError() : null;
                    if (!ManagedChannelImpl.this.lookUpServiceConfig) {
                        if (validServiceConfig != null) {
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Service config from name resolver discarded by channel settings");
                        }
                        effectiveServiceConfig = ManagedChannelImpl.this.defaultServiceConfig == null ? ManagedChannelImpl.EMPTY_SERVICE_CONFIG : ManagedChannelImpl.this.defaultServiceConfig;
                        if (resolvedConfigSelector != null) {
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Config selector from name resolver discarded by channel settings");
                        }
                        ManagedChannelImpl.this.realChannel.updateConfigSelector(effectiveServiceConfig.getDefaultConfigSelector());
                    } else {
                        if (validServiceConfig == null) {
                            if (ManagedChannelImpl.this.defaultServiceConfig != null) {
                                effectiveServiceConfig = ManagedChannelImpl.this.defaultServiceConfig;
                                ManagedChannelImpl.this.realChannel.updateConfigSelector(effectiveServiceConfig.getDefaultConfigSelector());
                                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Received no service config, using default service config");
                            } else if (serviceConfigError != null) {
                                if (!ManagedChannelImpl.this.serviceConfigUpdated) {
                                    ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Fallback to error due to invalid first service config without default config");
                                    NameResolverListener.this.onError(configOrError.getError());
                                    return;
                                }
                                effectiveServiceConfig = ManagedChannelImpl.this.lastServiceConfig;
                            } else {
                                ManagedChannelServiceConfig effectiveServiceConfig2 = ManagedChannelImpl.EMPTY_SERVICE_CONFIG;
                                ManagedChannelImpl.this.realChannel.updateConfigSelector(null);
                                effectiveServiceConfig = effectiveServiceConfig2;
                            }
                        } else {
                            effectiveServiceConfig = validServiceConfig;
                            if (resolvedConfigSelector != null) {
                                ManagedChannelImpl.this.realChannel.updateConfigSelector(resolvedConfigSelector);
                                if (effectiveServiceConfig.getDefaultConfigSelector() != null) {
                                    ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Method configs in service config will be discarded due to presence ofconfig-selector");
                                }
                            } else {
                                ManagedChannelImpl.this.realChannel.updateConfigSelector(effectiveServiceConfig.getDefaultConfigSelector());
                            }
                        }
                        if (!effectiveServiceConfig.equals(ManagedChannelImpl.this.lastServiceConfig)) {
                            ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Service config changed{0}", effectiveServiceConfig == ManagedChannelImpl.EMPTY_SERVICE_CONFIG ? " to empty" : "");
                            ManagedChannelImpl.this.lastServiceConfig = effectiveServiceConfig;
                        }
                        try {
                            ManagedChannelImpl.this.serviceConfigUpdated = true;
                        } catch (RuntimeException re) {
                            ManagedChannelImpl.logger.log(Level.WARNING, "[" + ManagedChannelImpl.this.getLogId() + "] Unexpected exception from parsing service config", (Throwable) re);
                        }
                    }
                    Attributes effectiveAttrs = resolutionResult.getAttributes();
                    if (NameResolverListener.this.helper == ManagedChannelImpl.this.lbHelper) {
                        Attributes.Builder attrBuilder = effectiveAttrs.toBuilder().discard(InternalConfigSelector.KEY);
                        Map<String, ?> healthCheckingConfig = effectiveServiceConfig.getHealthCheckingConfig();
                        if (healthCheckingConfig != null) {
                            attrBuilder.set(LoadBalancer.ATTR_HEALTH_CHECKING_CONFIG, healthCheckingConfig).build();
                        }
                        Status handleResult = NameResolverListener.this.helper.lb.tryHandleResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(servers).setAttributes(attrBuilder.build()).setLoadBalancingPolicyConfig(effectiveServiceConfig.getLoadBalancingConfig()).build());
                        if (!handleResult.isOk()) {
                            NameResolverListener.this.handleErrorInSyncContext(handleResult.augmentDescription(NameResolverListener.this.resolver + " was used"));
                        }
                    }
                }
            });
        }

        @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
        public void onError(final Status error) {
            Preconditions.checkArgument(!error.isOk(), "the error status must not be OK");
            ManagedChannelImpl.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.NameResolverListener.1NameResolverErrorHandler
                @Override // java.lang.Runnable
                public void run() {
                    NameResolverListener.this.handleErrorInSyncContext(error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleErrorInSyncContext(Status error) {
            ManagedChannelImpl.logger.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{ManagedChannelImpl.this.getLogId(), error});
            ManagedChannelImpl.this.realChannel.onConfigError();
            if (ManagedChannelImpl.this.lastResolutionState != ResolutionState.ERROR) {
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.WARNING, "Failed to resolve name: {0}", error);
                ManagedChannelImpl.this.lastResolutionState = ResolutionState.ERROR;
            }
            if (this.helper != ManagedChannelImpl.this.lbHelper) {
                return;
            }
            this.helper.lb.handleNameResolutionError(error);
            scheduleExponentialBackOffInSyncContext();
        }

        private void scheduleExponentialBackOffInSyncContext() {
            if (ManagedChannelImpl.this.scheduledNameResolverRefresh == null || !ManagedChannelImpl.this.scheduledNameResolverRefresh.isPending()) {
                if (ManagedChannelImpl.this.nameResolverBackoffPolicy == null) {
                    ManagedChannelImpl.this.nameResolverBackoffPolicy = ManagedChannelImpl.this.backoffPolicyProvider.get();
                }
                long delayNanos = ManagedChannelImpl.this.nameResolverBackoffPolicy.nextBackoffNanos();
                ManagedChannelImpl.this.channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Scheduling DNS resolution backoff for {0} ns", Long.valueOf(delayNanos));
                ManagedChannelImpl.this.scheduledNameResolverRefresh = ManagedChannelImpl.this.syncContext.schedule(new DelayedNameResolverRefresh(), delayNanos, TimeUnit.NANOSECONDS, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class SubchannelImpl extends AbstractSubchannel {
        List<EquivalentAddressGroup> addressGroups;
        final LoadBalancer.CreateSubchannelArgs args;
        SynchronizationContext.ScheduledHandle delayedShutdownTask;
        final LbHelperImpl helper;
        boolean shutdown;
        boolean started;
        InternalSubchannel subchannel;
        final InternalLogId subchannelLogId;
        final ChannelLoggerImpl subchannelLogger;
        final ChannelTracer subchannelTracer;

        SubchannelImpl(LoadBalancer.CreateSubchannelArgs args, LbHelperImpl helper) {
            this.addressGroups = args.getAddresses();
            if (ManagedChannelImpl.this.authorityOverride != null) {
                List<EquivalentAddressGroup> eagsWithoutOverrideAttr = stripOverrideAuthorityAttributes(args.getAddresses());
                args = args.toBuilder().setAddresses(eagsWithoutOverrideAttr).build();
            }
            this.args = (LoadBalancer.CreateSubchannelArgs) Preconditions.checkNotNull(args, "args");
            this.helper = (LbHelperImpl) Preconditions.checkNotNull(helper, "helper");
            this.subchannelLogId = InternalLogId.allocate("Subchannel", ManagedChannelImpl.this.authority());
            this.subchannelTracer = new ChannelTracer(this.subchannelLogId, ManagedChannelImpl.this.maxTraceEvents, ManagedChannelImpl.this.timeProvider.currentTimeNanos(), "Subchannel for " + args.getAddresses());
            this.subchannelLogger = new ChannelLoggerImpl(this.subchannelTracer, ManagedChannelImpl.this.timeProvider);
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void start(final LoadBalancer.SubchannelStateListener listener) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            Preconditions.checkState(!this.started, "already started");
            Preconditions.checkState(!this.shutdown, "already shutdown");
            Preconditions.checkState(!ManagedChannelImpl.this.terminating, "Channel is being terminated");
            this.started = true;
            InternalSubchannel internalSubchannel = new InternalSubchannel(this.args.getAddresses(), ManagedChannelImpl.this.authority(), ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.syncContext, new InternalSubchannel.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.SubchannelImpl.1ManagedInternalSubchannelCallback
                @Override // io.grpc.internal.InternalSubchannel.Callback
                void onTerminated(InternalSubchannel is) {
                    ManagedChannelImpl.this.subchannels.remove(is);
                    ManagedChannelImpl.this.channelz.removeSubchannel(is);
                    ManagedChannelImpl.this.maybeTerminateChannel();
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void onStateChange(InternalSubchannel is, ConnectivityStateInfo newState) {
                    ManagedChannelImpl.this.handleInternalSubchannelState(newState);
                    Preconditions.checkState(listener != null, "listener is null");
                    listener.onSubchannelState(newState);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void onInUse(InternalSubchannel is) {
                    ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(is, true);
                }

                @Override // io.grpc.internal.InternalSubchannel.Callback
                void onNotInUse(InternalSubchannel is) {
                    ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(is, false);
                }
            }, ManagedChannelImpl.this.channelz, ManagedChannelImpl.this.callTracerFactory.create(), this.subchannelTracer, this.subchannelLogId, this.subchannelLogger);
            ManagedChannelImpl.this.channelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Child Subchannel started").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(ManagedChannelImpl.this.timeProvider.currentTimeNanos()).setSubchannelRef(internalSubchannel).build());
            this.subchannel = internalSubchannel;
            ManagedChannelImpl.this.channelz.addSubchannel(internalSubchannel);
            ManagedChannelImpl.this.subchannels.add(internalSubchannel);
        }

        @Override // io.grpc.internal.AbstractSubchannel
        InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel() {
            Preconditions.checkState(this.started, "not started");
            return this.subchannel;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void shutdown() {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            if (this.subchannel == null) {
                this.shutdown = true;
                return;
            }
            if (this.shutdown) {
                if (ManagedChannelImpl.this.terminating && this.delayedShutdownTask != null) {
                    this.delayedShutdownTask.cancel();
                    this.delayedShutdownTask = null;
                } else {
                    return;
                }
            } else {
                this.shutdown = true;
            }
            if (!ManagedChannelImpl.this.terminating) {
                this.delayedShutdownTask = ManagedChannelImpl.this.syncContext.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.SubchannelImpl.1ShutdownSubchannel
                    @Override // java.lang.Runnable
                    public void run() {
                        SubchannelImpl.this.subchannel.shutdown(ManagedChannelImpl.SUBCHANNEL_SHUTDOWN_STATUS);
                    }
                }), ManagedChannelImpl.SUBCHANNEL_SHUTDOWN_DELAY_SECONDS, TimeUnit.SECONDS, ManagedChannelImpl.this.transportFactory.getScheduledExecutorService());
            } else {
                this.subchannel.shutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
            }
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void requestConnection() {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            Preconditions.checkState(this.started, "not started");
            this.subchannel.obtainActiveTransport();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public List<EquivalentAddressGroup> getAllAddresses() {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            Preconditions.checkState(this.started, "not started");
            return this.addressGroups;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Attributes getAttributes() {
            return this.args.getAttributes();
        }

        public String toString() {
            return this.subchannelLogId.toString();
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Channel asChannel() {
            Preconditions.checkState(this.started, "not started");
            return new SubchannelChannel(this.subchannel, ManagedChannelImpl.this.balancerRpcExecutorHolder.getExecutor(), ManagedChannelImpl.this.transportFactory.getScheduledExecutorService(), ManagedChannelImpl.this.callTracerFactory.create(), new AtomicReference(null));
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public Object getInternalSubchannel() {
            Preconditions.checkState(this.started, "Subchannel is not started");
            return this.subchannel;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public ChannelLogger getChannelLogger() {
            return this.subchannelLogger;
        }

        @Override // io.grpc.LoadBalancer.Subchannel
        public void updateAddresses(List<EquivalentAddressGroup> addrs) {
            ManagedChannelImpl.this.syncContext.throwIfNotInThisSynchronizationContext();
            this.addressGroups = addrs;
            if (ManagedChannelImpl.this.authorityOverride != null) {
                addrs = stripOverrideAuthorityAttributes(addrs);
            }
            this.subchannel.updateAddresses(addrs);
        }

        private List<EquivalentAddressGroup> stripOverrideAuthorityAttributes(List<EquivalentAddressGroup> eags) {
            List<EquivalentAddressGroup> eagsWithoutOverrideAttr = new ArrayList<>();
            for (EquivalentAddressGroup eag : eags) {
                EquivalentAddressGroup eagWithoutOverrideAttr = new EquivalentAddressGroup(eag.getAddresses(), eag.getAttributes().toBuilder().discard(EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE).build());
                eagsWithoutOverrideAttr.add(eagWithoutOverrideAttr);
            }
            return Collections.unmodifiableList(eagsWithoutOverrideAttr);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("target", this.target).toString();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class DelayedTransportListener implements ManagedClientTransport.Listener {
        private DelayedTransportListener() {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(Status s) {
            Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportInUse(boolean inUse) {
            ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(ManagedChannelImpl.this.delayedTransport, inUse);
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
            ManagedChannelImpl.this.terminating = true;
            ManagedChannelImpl.this.shutdownNameResolverAndLoadBalancer(false);
            ManagedChannelImpl.this.maybeShutdownNowSubchannels();
            ManagedChannelImpl.this.maybeTerminateChannel();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class IdleModeStateAggregator extends InUseStateAggregator<Object> {
        private IdleModeStateAggregator() {
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void handleInUse() {
            ManagedChannelImpl.this.exitIdleMode();
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void handleNotInUse() {
            if (!ManagedChannelImpl.this.shutdown.get()) {
                ManagedChannelImpl.this.rescheduleIdleTimer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ExecutorHolder {
        private Executor executor;
        private final ObjectPool<? extends Executor> pool;

        ExecutorHolder(ObjectPool<? extends Executor> executorPool) {
            this.pool = (ObjectPool) Preconditions.checkNotNull(executorPool, "executorPool");
        }

        synchronized Executor getExecutor() {
            if (this.executor == null) {
                this.executor = (Executor) Preconditions.checkNotNull(this.pool.getObject(), "%s.getObject()", this.executor);
            }
            return this.executor;
        }

        synchronized void release() {
            if (this.executor != null) {
                this.executor = this.pool.returnObject(this.executor);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class RestrictedScheduledExecutor implements ScheduledExecutorService {
        final ScheduledExecutorService delegate;

        private RestrictedScheduledExecutor(ScheduledExecutorService delegate) {
            this.delegate = (ScheduledExecutorService) Preconditions.checkNotNull(delegate, "delegate");
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            return this.delegate.schedule(callable, delay, unit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable cmd, long delay, TimeUnit unit) {
            return this.delegate.schedule(cmd, delay, unit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            return this.delegate.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            return this.delegate.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return this.delegate.awaitTermination(timeout, unit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            return this.delegate.invokeAll(tasks);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
            return this.delegate.invokeAll(tasks, timeout, unit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            return (T) this.delegate.invokeAny(tasks);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.delegate.invokeAny(tasks, timeout, unit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> task) {
            return this.delegate.submit(task);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable task) {
            return this.delegate.submit(task);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable task, T result) {
            return this.delegate.submit(task, result);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            this.delegate.execute(command);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class ScParser extends NameResolver.ServiceConfigParser {
        private final AutoConfiguredLoadBalancerFactory autoLoadBalancerFactory;
        private final int maxHedgedAttemptsLimit;
        private final int maxRetryAttemptsLimit;
        private final boolean retryEnabled;

        ScParser(boolean retryEnabled, int maxRetryAttemptsLimit, int maxHedgedAttemptsLimit, AutoConfiguredLoadBalancerFactory autoLoadBalancerFactory) {
            this.retryEnabled = retryEnabled;
            this.maxRetryAttemptsLimit = maxRetryAttemptsLimit;
            this.maxHedgedAttemptsLimit = maxHedgedAttemptsLimit;
            this.autoLoadBalancerFactory = (AutoConfiguredLoadBalancerFactory) Preconditions.checkNotNull(autoLoadBalancerFactory, "autoLoadBalancerFactory");
        }

        @Override // io.grpc.NameResolver.ServiceConfigParser
        public NameResolver.ConfigOrError parseServiceConfig(Map<String, ?> rawServiceConfig) {
            Object loadBalancingPolicySelection;
            try {
                NameResolver.ConfigOrError choiceFromLoadBalancer = this.autoLoadBalancerFactory.parseLoadBalancerPolicy(rawServiceConfig);
                if (choiceFromLoadBalancer == null) {
                    loadBalancingPolicySelection = null;
                } else {
                    Object loadBalancingPolicySelection2 = choiceFromLoadBalancer.getError();
                    if (loadBalancingPolicySelection2 != null) {
                        return NameResolver.ConfigOrError.fromError(choiceFromLoadBalancer.getError());
                    }
                    loadBalancingPolicySelection = choiceFromLoadBalancer.getConfig();
                }
                return NameResolver.ConfigOrError.fromConfig(ManagedChannelServiceConfig.fromServiceConfig(rawServiceConfig, this.retryEnabled, this.maxRetryAttemptsLimit, this.maxHedgedAttemptsLimit, loadBalancingPolicySelection));
            } catch (RuntimeException e2) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse service config").withCause(e2));
            }
        }
    }
}