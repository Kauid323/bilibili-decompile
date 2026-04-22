package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.InternalServerInterceptors;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ServerImpl extends Server implements InternalInstrumented<InternalChannelz.ServerStats> {
    private final BinaryLog binlog;
    private final InternalChannelz channelz;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    private Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final HandlerRegistry fallbackRegistry;
    private final long handshakeTimeoutMillis;
    private final ServerInterceptor[] interceptors;
    private final HandlerRegistry registry;
    private final Context rootContext;
    private final CallTracer serverCallTracer;
    private boolean serverShutdownCallbackInvoked;
    private boolean shutdown;
    private Status shutdownNowStatus;
    private boolean started;
    private boolean terminated;
    private final Deadline.Ticker ticker;
    private final List<ServerTransportFilter> transportFilters;
    private final InternalServer transportServer;
    private boolean transportServersTerminated;
    private static final Logger log = Logger.getLogger(ServerImpl.class.getName());
    private static final ServerStreamListener NOOP_LISTENER = new NoopListener();
    private final Object lock = new Object();
    private final Set<ServerTransport> transports = new HashSet();
    private final InternalLogId logId = InternalLogId.allocate("Server", String.valueOf(getListenSocketsIgnoringLifecycle()));

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerImpl(ServerImplBuilder builder, InternalServer transportServer, Context rootContext) {
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(builder.executorPool, "executorPool");
        this.registry = (HandlerRegistry) Preconditions.checkNotNull(builder.registryBuilder.build(), "registryBuilder");
        this.fallbackRegistry = (HandlerRegistry) Preconditions.checkNotNull(builder.fallbackRegistry, "fallbackRegistry");
        this.transportServer = (InternalServer) Preconditions.checkNotNull(transportServer, "transportServer");
        this.rootContext = ((Context) Preconditions.checkNotNull(rootContext, "rootContext")).fork();
        this.decompressorRegistry = builder.decompressorRegistry;
        this.compressorRegistry = builder.compressorRegistry;
        this.transportFilters = Collections.unmodifiableList(new ArrayList(builder.transportFilters));
        this.interceptors = (ServerInterceptor[]) builder.interceptors.toArray(new ServerInterceptor[builder.interceptors.size()]);
        this.handshakeTimeoutMillis = builder.handshakeTimeoutMillis;
        this.binlog = builder.binlog;
        this.channelz = builder.channelz;
        this.serverCallTracer = builder.callTracerFactory.create();
        this.ticker = (Deadline.Ticker) Preconditions.checkNotNull(builder.ticker, "ticker");
        this.channelz.addServer(this);
    }

    @Override // io.grpc.Server
    public ServerImpl start() throws IOException {
        synchronized (this.lock) {
            Preconditions.checkState(!this.started, "Already started");
            Preconditions.checkState(this.shutdown ? false : true, "Shutting down");
            ServerListenerImpl listener = new ServerListenerImpl();
            this.transportServer.start(listener);
            this.executor = (Executor) Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
            this.started = true;
        }
        return this;
    }

    @Override // io.grpc.Server
    public int getPort() {
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            for (SocketAddress addr : this.transportServer.getListenSocketAddresses()) {
                if (addr instanceof InetSocketAddress) {
                    return ((InetSocketAddress) addr).getPort();
                }
            }
            return -1;
        }
    }

    @Override // io.grpc.Server
    public List<SocketAddress> getListenSockets() {
        List<SocketAddress> listenSocketsIgnoringLifecycle;
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            listenSocketsIgnoringLifecycle = getListenSocketsIgnoringLifecycle();
        }
        return listenSocketsIgnoringLifecycle;
    }

    private List<SocketAddress> getListenSocketsIgnoringLifecycle() {
        List<SocketAddress> unmodifiableList;
        synchronized (this.lock) {
            unmodifiableList = Collections.unmodifiableList(this.transportServer.getListenSocketAddresses());
        }
        return unmodifiableList;
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getServices() {
        List<ServerServiceDefinition> fallbackServices = this.fallbackRegistry.getServices();
        if (fallbackServices.isEmpty()) {
            return this.registry.getServices();
        }
        List<ServerServiceDefinition> registryServices = this.registry.getServices();
        int servicesCount = registryServices.size() + fallbackServices.size();
        List<ServerServiceDefinition> services = new ArrayList<>(servicesCount);
        services.addAll(registryServices);
        services.addAll(fallbackServices);
        return Collections.unmodifiableList(services);
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getImmutableServices() {
        return this.registry.getServices();
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.unmodifiableList(this.fallbackRegistry.getServices());
    }

    @Override // io.grpc.Server
    public ServerImpl shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return this;
            }
            this.shutdown = true;
            boolean shutdownTransportServers = this.started;
            if (!shutdownTransportServers) {
                this.transportServersTerminated = true;
                checkForTermination();
            }
            if (shutdownTransportServers) {
                this.transportServer.shutdown();
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public ServerImpl shutdownNow() {
        shutdown();
        Status nowStatus = Status.UNAVAILABLE.withDescription("Server shutdownNow invoked");
        synchronized (this.lock) {
            if (this.shutdownNowStatus != null) {
                return this;
            }
            this.shutdownNowStatus = nowStatus;
            Collection<ServerTransport> transportsCopy = new ArrayList<>(this.transports);
            boolean savedServerShutdownCallbackInvoked = this.serverShutdownCallbackInvoked;
            if (savedServerShutdownCallbackInvoked) {
                for (ServerTransport transport : transportsCopy) {
                    transport.shutdownNow(nowStatus);
                }
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public boolean isShutdown() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown;
        }
        return z;
    }

    @Override // io.grpc.Server
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        boolean z;
        synchronized (this.lock) {
            long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
            while (!this.terminated) {
                long timeoutNanos = endTimeNanos - System.nanoTime();
                if (timeoutNanos <= 0) {
                    break;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, timeoutNanos);
            }
            z = this.terminated;
        }
        return z;
    }

    @Override // io.grpc.Server
    public void awaitTermination() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.terminated) {
                this.lock.wait();
            }
        }
    }

    @Override // io.grpc.Server
    public boolean isTerminated() {
        boolean z;
        synchronized (this.lock) {
            z = this.terminated;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transportClosed(ServerTransport transport) {
        synchronized (this.lock) {
            if (!this.transports.remove(transport)) {
                throw new AssertionError("Transport already removed");
            }
            this.channelz.removeServerSocket(this, transport);
            checkForTermination();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForTermination() {
        synchronized (this.lock) {
            if (this.shutdown && this.transports.isEmpty() && this.transportServersTerminated) {
                if (this.terminated) {
                    throw new AssertionError("Server already terminated");
                }
                this.terminated = true;
                this.channelz.removeServer(this);
                if (this.executor != null) {
                    this.executor = this.executorPool.returnObject(this.executor);
                }
                this.lock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class ServerListenerImpl implements ServerListener {
        private ServerListenerImpl() {
        }

        @Override // io.grpc.internal.ServerListener
        public ServerTransportListener transportCreated(ServerTransport transport) {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.this.transports.add(transport);
            }
            ServerTransportListenerImpl stli = new ServerTransportListenerImpl(transport);
            stli.init();
            return stli;
        }

        @Override // io.grpc.internal.ServerListener
        public void serverShutdown() {
            synchronized (ServerImpl.this.lock) {
                if (ServerImpl.this.serverShutdownCallbackInvoked) {
                    return;
                }
                ArrayList<ServerTransport> copiedTransports = new ArrayList<>(ServerImpl.this.transports);
                Status shutdownNowStatusCopy = ServerImpl.this.shutdownNowStatus;
                ServerImpl.this.serverShutdownCallbackInvoked = true;
                Iterator<ServerTransport> it = copiedTransports.iterator();
                while (it.hasNext()) {
                    ServerTransport transport = it.next();
                    if (shutdownNowStatusCopy == null) {
                        transport.shutdown();
                    } else {
                        transport.shutdownNow(shutdownNowStatusCopy);
                    }
                }
                synchronized (ServerImpl.this.lock) {
                    ServerImpl.this.transportServersTerminated = true;
                    ServerImpl.this.checkForTermination();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class ServerTransportListenerImpl implements ServerTransportListener {
        private Attributes attributes;
        private Future<?> handshakeTimeoutFuture;
        private final ServerTransport transport;

        ServerTransportListenerImpl(ServerTransport transport) {
            this.transport = transport;
        }

        public void init() {
            if (ServerImpl.this.handshakeTimeoutMillis != Long.MAX_VALUE) {
                this.handshakeTimeoutFuture = this.transport.getScheduledExecutorService().schedule(new Runnable() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1TransportShutdownNow
                    @Override // java.lang.Runnable
                    public void run() {
                        ServerTransportListenerImpl.this.transport.shutdownNow(Status.CANCELLED.withDescription("Handshake timeout exceeded"));
                    }
                }, ServerImpl.this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
            } else {
                this.handshakeTimeoutFuture = new FutureTask(new Runnable() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                }, null);
            }
            ServerImpl.this.channelz.addServerSocket(ServerImpl.this, this.transport);
        }

        @Override // io.grpc.internal.ServerTransportListener
        public Attributes transportReady(Attributes attributes) {
            this.handshakeTimeoutFuture.cancel(false);
            this.handshakeTimeoutFuture = null;
            for (ServerTransportFilter filter : ServerImpl.this.transportFilters) {
                attributes = (Attributes) Preconditions.checkNotNull(filter.transportReady(attributes), "Filter %s returned null", filter);
            }
            this.attributes = attributes;
            return attributes;
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void transportTerminated() {
            if (this.handshakeTimeoutFuture != null) {
                this.handshakeTimeoutFuture.cancel(false);
                this.handshakeTimeoutFuture = null;
            }
            for (ServerTransportFilter filter : ServerImpl.this.transportFilters) {
                filter.transportTerminated(this.attributes);
            }
            ServerImpl.this.transportClosed(this.transport);
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void streamCreated(ServerStream stream, String methodName, Metadata headers) {
            Tag tag = PerfMark.createTag(methodName, stream.streamId());
            PerfMark.startTask("ServerTransportListener.streamCreated", tag);
            try {
                streamCreatedInternal(stream, methodName, headers, tag);
            } finally {
                PerfMark.stopTask("ServerTransportListener.streamCreated", tag);
            }
        }

        private void streamCreatedInternal(ServerStream stream, String methodName, Metadata headers, Tag tag) {
            Executor wrappedExecutor;
            if (ServerImpl.this.executor == MoreExecutors.directExecutor()) {
                Executor wrappedExecutor2 = new SerializeReentrantCallsDirectExecutor();
                stream.optimizeForDirectExecutor();
                wrappedExecutor = wrappedExecutor2;
            } else {
                wrappedExecutor = new SerializingExecutor(ServerImpl.this.executor);
            }
            if (headers.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY)) {
                String encoding = (String) headers.get(GrpcUtil.MESSAGE_ENCODING_KEY);
                Decompressor decompressor = ServerImpl.this.decompressorRegistry.lookupDecompressor(encoding);
                if (decompressor == null) {
                    stream.setListener(ServerImpl.NOOP_LISTENER);
                    stream.close(Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", encoding)), new Metadata());
                    return;
                }
                stream.setDecompressor(decompressor);
            }
            StatsTraceContext statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(stream.statsTraceContext(), "statsTraceCtx not present from stream");
            Context.CancellableContext context = createContext(headers, statsTraceCtx);
            Link link = PerfMark.linkOut();
            JumpToApplicationThreadServerStreamListener jumpListener = new JumpToApplicationThreadServerStreamListener(wrappedExecutor, ServerImpl.this.executor, stream, context, tag);
            stream.setListener(jumpListener);
            wrappedExecutor.execute(new ContextRunnable(context, tag, link, methodName, stream, headers, statsTraceCtx, jumpListener) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1StreamCreated
                final /* synthetic */ Context.CancellableContext val$context;
                final /* synthetic */ Metadata val$headers;
                final /* synthetic */ JumpToApplicationThreadServerStreamListener val$jumpListener;
                final /* synthetic */ Link val$link;
                final /* synthetic */ String val$methodName;
                final /* synthetic */ StatsTraceContext val$statsTraceCtx;
                final /* synthetic */ ServerStream val$stream;
                final /* synthetic */ Tag val$tag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context);
                    this.val$context = context;
                    this.val$tag = tag;
                    this.val$link = link;
                    this.val$methodName = methodName;
                    this.val$stream = stream;
                    this.val$headers = headers;
                    this.val$statsTraceCtx = statsTraceCtx;
                    this.val$jumpListener = jumpListener;
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ServerTransportListener$StreamCreated.startCall", this.val$tag);
                    PerfMark.linkIn(this.val$link);
                    try {
                        runInternal();
                    } finally {
                        PerfMark.stopTask("ServerTransportListener$StreamCreated.startCall", this.val$tag);
                    }
                }

                private void runInternal() {
                    ServerStreamListener listener = ServerImpl.NOOP_LISTENER;
                    try {
                        ServerMethodDefinition<?, ?> method = ServerImpl.this.registry.lookupMethod(this.val$methodName);
                        if (method == null) {
                            method = ServerImpl.this.fallbackRegistry.lookupMethod(this.val$methodName, this.val$stream.getAuthority());
                        }
                        if (method != null) {
                            this.val$jumpListener.setListener(ServerTransportListenerImpl.this.startCall(this.val$stream, this.val$methodName, method, this.val$headers, this.val$context, this.val$statsTraceCtx, this.val$tag));
                            this.val$context.addListener(new Context.CancellationListener() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1StreamCreated.1ServerStreamCancellationListener
                                @Override // io.grpc.Context.CancellationListener
                                public void cancelled(Context context2) {
                                    Status status = Contexts.statusFromCancelled(context2);
                                    if (Status.DEADLINE_EXCEEDED.getCode().equals(status.getCode())) {
                                        C1StreamCreated.this.val$stream.cancel(status);
                                    }
                                }
                            }, MoreExecutors.directExecutor());
                            return;
                        }
                        Status status = Status.UNIMPLEMENTED.withDescription("Method not found: " + this.val$methodName);
                        this.val$stream.close(status, new Metadata());
                        this.val$context.cancel(null);
                    } catch (Throwable t) {
                        try {
                            this.val$stream.close(Status.fromThrowable(t), new Metadata());
                            this.val$context.cancel(null);
                            throw t;
                        } finally {
                            this.val$jumpListener.setListener(listener);
                        }
                    }
                }
            });
        }

        private Context.CancellableContext createContext(Metadata headers, StatsTraceContext statsTraceCtx) {
            Long timeoutNanos = (Long) headers.get(GrpcUtil.TIMEOUT_KEY);
            Context baseContext = statsTraceCtx.serverFilterContext(ServerImpl.this.rootContext).withValue(io.grpc.InternalServer.SERVER_CONTEXT_KEY, ServerImpl.this);
            if (timeoutNanos == null) {
                return baseContext.withCancellation();
            }
            Context.CancellableContext context = baseContext.withDeadline(Deadline.after(timeoutNanos.longValue(), TimeUnit.NANOSECONDS, ServerImpl.this.ticker), this.transport.getScheduledExecutorService());
            return context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> ServerStreamListener startCall(ServerStream stream, String fullMethodName, ServerMethodDefinition<ReqT, RespT> methodDef, Metadata headers, Context.CancellableContext context, StatsTraceContext statsTraceCtx, Tag tag) {
            ServerInterceptor[] serverInterceptorArr;
            ServerMethodDefinition<ReqT, RespT> wrapMethodDefinition;
            statsTraceCtx.serverCallStarted(new ServerCallInfoImpl(methodDef.getMethodDescriptor(), stream.getAttributes(), stream.getAuthority()));
            ServerCallHandler<ReqT, RespT> handler = methodDef.getServerCallHandler();
            ServerCallHandler<ReqT, RespT> handler2 = handler;
            for (ServerInterceptor interceptor : ServerImpl.this.interceptors) {
                handler2 = InternalServerInterceptors.interceptCallHandler(interceptor, handler2);
            }
            ServerMethodDefinition<ReqT, RespT> interceptedDef = methodDef.withServerCallHandler(handler2);
            if (ServerImpl.this.binlog != null) {
                wrapMethodDefinition = ServerImpl.this.binlog.wrapMethodDefinition(interceptedDef);
            } else {
                wrapMethodDefinition = interceptedDef;
            }
            return startWrappedCall(fullMethodName, wrapMethodDefinition, stream, headers, context, tag);
        }

        private <WReqT, WRespT> ServerStreamListener startWrappedCall(String fullMethodName, ServerMethodDefinition<WReqT, WRespT> methodDef, ServerStream stream, Metadata headers, Context.CancellableContext context, Tag tag) {
            ServerCallImpl<WReqT, WRespT> call = new ServerCallImpl<>(stream, methodDef.getMethodDescriptor(), headers, context, ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry, ServerImpl.this.serverCallTracer, tag);
            ServerCall.Listener<WReqT> listener = methodDef.getServerCallHandler().startCall(call, headers);
            if (listener == null) {
                throw new NullPointerException("startCall() returned a null listener for method " + fullMethodName);
            }
            return call.newServerStreamListener(listener);
        }
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ServerStats> getStats() {
        InternalChannelz.ServerStats.Builder builder = new InternalChannelz.ServerStats.Builder();
        List<InternalInstrumented<InternalChannelz.SocketStats>> stats = this.transportServer.getListenSocketStatsList();
        if (stats != null) {
            builder.addListenSockets(stats);
        }
        this.serverCallTracer.updateBuilder(builder);
        SettableFuture<InternalChannelz.ServerStats> ret = SettableFuture.create();
        ret.set(builder.build());
        return ret;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("transportServer", this.transportServer).toString();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class NoopListener implements ServerStreamListener {
        private NoopListener() {
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer producer) {
            while (true) {
                InputStream message = producer.next();
                if (message != null) {
                    try {
                        message.close();
                    } catch (IOException e2) {
                        while (true) {
                            InputStream message2 = producer.next();
                            if (message2 == null) {
                                break;
                            }
                            try {
                                message2.close();
                            } catch (IOException ioException) {
                                ServerImpl.log.log(Level.WARNING, "Exception closing stream", (Throwable) ioException);
                            }
                        }
                        throw new RuntimeException(e2);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class JumpToApplicationThreadServerStreamListener implements ServerStreamListener {
        private final Executor callExecutor;
        private final Executor cancelExecutor;
        private final Context.CancellableContext context;
        private ServerStreamListener listener;
        private final ServerStream stream;
        private final Tag tag;

        public JumpToApplicationThreadServerStreamListener(Executor executor, Executor cancelExecutor, ServerStream stream, Context.CancellableContext context, Tag tag) {
            this.callExecutor = executor;
            this.cancelExecutor = cancelExecutor;
            this.stream = stream;
            this.context = context;
            this.tag = tag;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ServerStreamListener getListener() {
            if (this.listener == null) {
                throw new IllegalStateException("listener unset");
            }
            return this.listener;
        }

        void setListener(ServerStreamListener listener) {
            Preconditions.checkNotNull(listener, "listener must not be null");
            Preconditions.checkState(this.listener == null, "Listener already set");
            this.listener = listener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void internalClose(Throwable t) {
            this.stream.close(Status.UNKNOWN.withCause(t), new Metadata());
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer producer) {
            PerfMark.startTask("ServerStreamListener.messagesAvailable", this.tag);
            final Link link = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1MessagesAvailable
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).messagesAvailable", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(link);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().messagesAvailable(producer);
                        } finally {
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ServerStreamListener.messagesAvailable", this.tag);
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            PerfMark.startTask("ServerStreamListener.halfClosed", this.tag);
            final Link link = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1HalfClosed
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).halfClosed", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(link);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
                        } finally {
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ServerStreamListener.halfClosed", this.tag);
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
            PerfMark.startTask("ServerStreamListener.closed", this.tag);
            try {
                closedInternal(status);
            } finally {
                PerfMark.stopTask("ServerStreamListener.closed", this.tag);
            }
        }

        private void closedInternal(final Status status) {
            if (!status.isOk()) {
                this.cancelExecutor.execute(new ContextCloser(this.context, status.getCause()));
            }
            final Link link = PerfMark.linkOut();
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1Closed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(JumpToApplicationThreadServerStreamListener.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ServerCallListener(app).closed", JumpToApplicationThreadServerStreamListener.this.tag);
                    PerfMark.linkIn(link);
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().closed(status);
                    } finally {
                        PerfMark.stopTask("ServerCallListener(app).closed", JumpToApplicationThreadServerStreamListener.this.tag);
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            PerfMark.startTask("ServerStreamListener.onReady", this.tag);
            final Link link = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1OnReady
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).onReady", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(link);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
                        } finally {
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ServerStreamListener.onReady", this.tag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ContextCloser implements Runnable {
        private final Throwable cause;
        private final Context.CancellableContext context;

        ContextCloser(Context.CancellableContext context, Throwable cause) {
            this.context = context;
            this.cause = cause;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.context.cancel(this.cause);
        }
    }
}