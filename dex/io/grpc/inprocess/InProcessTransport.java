package io.grpc.inprocess;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.vivo.vturbo.VturboNetworkConstantsProxy;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Grpc;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.InsightBuilder;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.NoopClientStream;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import io.grpc.internal.ServerStream;
import io.grpc.internal.ServerStreamListener;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.StreamListener;
import io.ktor.http.ContentDisposition;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public final class InProcessTransport implements ServerTransport, ConnectionClientTransport {
    private static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
    private final Attributes attributes;
    private final String authority;
    private final int clientMaxInboundMetadataSize;
    private ManagedClientTransport.Listener clientTransportListener;
    private final InUseStateAggregator<InProcessStream> inUseState;
    private final boolean includeCauseWithStatus;
    private final InternalLogId logId;
    private final String name;
    private final Optional<ServerListener> optionalServerListener;
    private int serverMaxInboundMetadataSize;
    private ScheduledExecutorService serverScheduler;
    private ObjectPool<ScheduledExecutorService> serverSchedulerPool;
    private Attributes serverStreamAttributes;
    private List<ServerStreamTracer.Factory> serverStreamTracerFactories;
    private ServerTransportListener serverTransportListener;
    private boolean shutdown;
    private Status shutdownStatus;
    private final Set<InProcessStream> streams;
    private boolean terminated;
    private final String userAgent;

    static /* synthetic */ Logger access$2100() {
        return log;
    }

    private InProcessTransport(String name, int maxInboundMetadataSize, String authority, String userAgent, Attributes eagAttrs, Optional<ServerListener> optionalServerListener, boolean includeCauseWithStatus) {
        this.streams = Collections.newSetFromMap(new IdentityHashMap());
        this.inUseState = new InUseStateAggregator<InProcessStream>() { // from class: io.grpc.inprocess.InProcessTransport.1
            @Override // io.grpc.internal.InUseStateAggregator
            protected void handleInUse() {
                InProcessTransport.this.clientTransportListener.transportInUse(true);
            }

            @Override // io.grpc.internal.InUseStateAggregator
            protected void handleNotInUse() {
                InProcessTransport.this.clientTransportListener.transportInUse(false);
            }
        };
        this.name = name;
        this.clientMaxInboundMetadataSize = maxInboundMetadataSize;
        this.authority = authority;
        this.userAgent = GrpcUtil.getGrpcUserAgent("inprocess", userAgent);
        Preconditions.checkNotNull(eagAttrs, "eagAttrs");
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, eagAttrs).set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, new InProcessSocketAddress(name)).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, new InProcessSocketAddress(name)).build();
        this.optionalServerListener = optionalServerListener;
        this.logId = InternalLogId.allocate(getClass(), name);
        this.includeCauseWithStatus = includeCauseWithStatus;
    }

    public InProcessTransport(String name, int maxInboundMetadataSize, String authority, String userAgent, Attributes eagAttrs, boolean includeCauseWithStatus) {
        this(name, maxInboundMetadataSize, authority, userAgent, eagAttrs, Optional.absent(), includeCauseWithStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InProcessTransport(String name, int maxInboundMetadataSize, String authority, String userAgent, Attributes eagAttrs, ObjectPool<ScheduledExecutorService> serverSchedulerPool, List<ServerStreamTracer.Factory> serverStreamTracerFactories, ServerListener serverListener) {
        this(name, maxInboundMetadataSize, authority, userAgent, eagAttrs, Optional.of(serverListener), false);
        this.serverMaxInboundMetadataSize = maxInboundMetadataSize;
        this.serverSchedulerPool = serverSchedulerPool;
        this.serverStreamTracerFactories = serverStreamTracerFactories;
    }

    @Override // io.grpc.internal.ManagedClientTransport
    @CheckReturnValue
    public synchronized Runnable start(ManagedClientTransport.Listener listener) {
        this.clientTransportListener = listener;
        if (this.optionalServerListener.isPresent()) {
            this.serverScheduler = this.serverSchedulerPool.getObject();
            this.serverTransportListener = ((ServerListener) this.optionalServerListener.get()).transportCreated(this);
        } else {
            InProcessServer server = InProcessServer.findServer(this.name);
            if (server != null) {
                this.serverMaxInboundMetadataSize = server.getMaxInboundMetadataSize();
                this.serverSchedulerPool = server.getScheduledExecutorServicePool();
                this.serverScheduler = this.serverSchedulerPool.getObject();
                this.serverStreamTracerFactories = server.getStreamTracerFactories();
                this.serverTransportListener = server.register(this);
            }
        }
        if (this.serverTransportListener == null) {
            this.shutdownStatus = Status.UNAVAILABLE.withDescription("Could not find server: " + this.name);
            final Status localShutdownStatus = this.shutdownStatus;
            return new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (InProcessTransport.this) {
                        InProcessTransport.this.notifyShutdown(localShutdownStatus);
                        InProcessTransport.this.notifyTerminated();
                    }
                }
            };
        }
        return new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (InProcessTransport.this) {
                    Attributes serverTransportAttrs = Attributes.newBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, new InProcessSocketAddress(InProcessTransport.this.name)).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, new InProcessSocketAddress(InProcessTransport.this.name)).build();
                    InProcessTransport.this.serverStreamAttributes = InProcessTransport.this.serverTransportListener.transportReady(serverTransportAttrs);
                    InProcessTransport.this.clientTransportListener.transportReady();
                }
            }
        };
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized ClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions) {
        int metadataSize;
        if (this.shutdownStatus != null) {
            return failedClientStream(StatsTraceContext.newClientContext(callOptions, this.attributes, headers), this.shutdownStatus);
        }
        headers.put(GrpcUtil.USER_AGENT_KEY, this.userAgent);
        if (this.serverMaxInboundMetadataSize != Integer.MAX_VALUE && (metadataSize = metadataSize(headers)) > this.serverMaxInboundMetadataSize) {
            Status status = Status.RESOURCE_EXHAUSTED.withDescription(String.format("Request metadata larger than %d: %d", Integer.valueOf(this.serverMaxInboundMetadataSize), Integer.valueOf(metadataSize)));
            return failedClientStream(StatsTraceContext.newClientContext(callOptions, this.attributes, headers), status);
        }
        return new InProcessStream(method, headers, callOptions, this.authority).clientStream;
    }

    private ClientStream failedClientStream(final StatsTraceContext statsTraceCtx, final Status status) {
        return new NoopClientStream() { // from class: io.grpc.inprocess.InProcessTransport.4
            @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
            public void start(ClientStreamListener listener) {
                statsTraceCtx.clientOutboundHeaders();
                statsTraceCtx.streamClosed(status);
                listener.closed(status, new Metadata());
            }
        };
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized void ping(final ClientTransport.PingCallback callback, Executor executor) {
        if (this.terminated) {
            final Status shutdownStatus = this.shutdownStatus;
            executor.execute(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.5
                @Override // java.lang.Runnable
                public void run() {
                    callback.onFailure(shutdownStatus.asRuntimeException());
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.6
                @Override // java.lang.Runnable
                public void run() {
                    callback.onSuccess(0L);
                }
            });
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public synchronized void shutdown(Status reason) {
        if (this.shutdown) {
            return;
        }
        this.shutdownStatus = reason;
        notifyShutdown(reason);
        if (this.streams.isEmpty()) {
            notifyTerminated();
        }
    }

    @Override // io.grpc.internal.ServerTransport
    public synchronized void shutdown() {
        shutdown(Status.UNAVAILABLE.withDescription("InProcessTransport shutdown by the server-side"));
    }

    @Override // io.grpc.internal.ServerTransport, io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status reason) {
        Preconditions.checkNotNull(reason, VturboNetworkConstantsProxy.NETWORK_BLOCK_REASON_KEY);
        synchronized (this) {
            shutdown(reason);
            if (this.terminated) {
                return;
            }
            List<InProcessStream> streamsCopy = new ArrayList<>(this.streams);
            for (InProcessStream stream : streamsCopy) {
                stream.clientStream.cancel(reason);
            }
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add(ContentDisposition.Parameters.Name, this.name).toString();
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.internal.ServerTransport
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.serverScheduler;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture<InternalChannelz.SocketStats> ret = SettableFuture.create();
        ret.set((Object) null);
        return ret;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyShutdown(Status s) {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        this.clientTransportListener.transportShutdown(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyTerminated() {
        if (this.terminated) {
            return;
        }
        this.terminated = true;
        if (this.serverScheduler != null) {
            this.serverScheduler = this.serverSchedulerPool.returnObject(this.serverScheduler);
        }
        this.clientTransportListener.transportTerminated();
        if (this.serverTransportListener != null) {
            this.serverTransportListener.transportTerminated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int metadataSize(Metadata metadata) {
        byte[][] serialized = InternalMetadata.serialize(metadata);
        if (serialized == null) {
            return 0;
        }
        long size = 0;
        for (int i2 = 0; i2 < serialized.length; i2 += 2) {
            size += serialized[i2].length + 32 + serialized[i2 + 1].length;
        }
        return (int) Math.min(size, 2147483647L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class InProcessStream {
        private volatile String authority;
        private final CallOptions callOptions;
        private final InProcessClientStream clientStream;
        private final Metadata headers;
        private final MethodDescriptor<?, ?> method;
        private final InProcessServerStream serverStream;

        private InProcessStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions, String authority) {
            this.method = (MethodDescriptor) Preconditions.checkNotNull(method, "method");
            this.headers = (Metadata) Preconditions.checkNotNull(headers, "headers");
            this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
            this.authority = authority;
            this.clientStream = new InProcessClientStream(callOptions, headers);
            this.serverStream = new InProcessServerStream(method, headers);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void streamClosed() {
            synchronized (InProcessTransport.this) {
                boolean justRemovedAnElement = InProcessTransport.this.streams.remove(this);
                if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                    InProcessTransport.this.inUseState.updateObjectInUse(this, false);
                }
                if (InProcessTransport.this.streams.isEmpty() && justRemovedAnElement && InProcessTransport.this.shutdown) {
                    InProcessTransport.this.notifyTerminated();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public class InProcessServerStream implements ServerStream {
            private Status clientNotifyStatus;
            private Metadata clientNotifyTrailers;
            private ArrayDeque<StreamListener.MessageProducer> clientReceiveQueue = new ArrayDeque<>();
            private int clientRequested;
            private ClientStreamListener clientStreamListener;
            private boolean closed;
            private int outboundSeqNo;
            final StatsTraceContext statsTraceCtx;

            InProcessServerStream(MethodDescriptor<?, ?> method, Metadata headers) {
                this.statsTraceCtx = StatsTraceContext.newServerContext(InProcessTransport.this.serverStreamTracerFactories, method.getFullMethodName(), headers);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void setListener(ClientStreamListener listener) {
                this.clientStreamListener = listener;
            }

            @Override // io.grpc.internal.ServerStream
            public void setListener(ServerStreamListener serverStreamListener) {
                InProcessStream.this.clientStream.setListener(serverStreamListener);
            }

            @Override // io.grpc.internal.Stream
            public void request(int numMessages) {
                boolean onReady = InProcessStream.this.clientStream.serverRequested(numMessages);
                if (onReady) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.clientStreamListener.onReady();
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized boolean clientRequested(int numMessages) {
                boolean z = false;
                if (this.closed) {
                    return false;
                }
                boolean previouslyReady = this.clientRequested > 0;
                this.clientRequested += numMessages;
                while (this.clientRequested > 0 && !this.clientReceiveQueue.isEmpty()) {
                    this.clientRequested--;
                    this.clientStreamListener.messagesAvailable(this.clientReceiveQueue.poll());
                }
                if (this.closed) {
                    return false;
                }
                if (this.clientReceiveQueue.isEmpty() && this.clientNotifyStatus != null) {
                    this.closed = true;
                    InProcessStream.this.clientStream.statsTraceCtx.clientInboundTrailers(this.clientNotifyTrailers);
                    InProcessStream.this.clientStream.statsTraceCtx.streamClosed(this.clientNotifyStatus);
                    this.clientStreamListener.closed(this.clientNotifyStatus, this.clientNotifyTrailers);
                }
                boolean nowReady = this.clientRequested > 0;
                if (!previouslyReady && nowReady) {
                    z = true;
                }
                return z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clientCancelled(Status status) {
                internalCancel(status);
            }

            @Override // io.grpc.internal.Stream
            public synchronized void writeMessage(InputStream message) {
                if (this.closed) {
                    return;
                }
                this.statsTraceCtx.outboundMessage(this.outboundSeqNo);
                this.statsTraceCtx.outboundMessageSent(this.outboundSeqNo, -1L, -1L);
                InProcessStream.this.clientStream.statsTraceCtx.inboundMessage(this.outboundSeqNo);
                InProcessStream.this.clientStream.statsTraceCtx.inboundMessageRead(this.outboundSeqNo, -1L, -1L);
                this.outboundSeqNo++;
                StreamListener.MessageProducer producer = new SingleMessageProducer(message);
                if (this.clientRequested > 0) {
                    this.clientRequested--;
                    this.clientStreamListener.messagesAvailable(producer);
                } else {
                    this.clientReceiveQueue.add(producer);
                }
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.clientRequested > 0;
            }

            @Override // io.grpc.internal.ServerStream
            public void writeHeaders(Metadata headers) {
                int metadataSize;
                if (InProcessTransport.this.clientMaxInboundMetadataSize != Integer.MAX_VALUE && (metadataSize = InProcessTransport.metadataSize(headers)) > InProcessTransport.this.clientMaxInboundMetadataSize) {
                    Status serverStatus = Status.CANCELLED.withDescription("Client cancelled the RPC");
                    InProcessStream.this.clientStream.serverClosed(serverStatus, serverStatus);
                    Status failedStatus = Status.RESOURCE_EXHAUSTED.withDescription(String.format("Response header metadata larger than %d: %d", Integer.valueOf(InProcessTransport.this.clientMaxInboundMetadataSize), Integer.valueOf(metadataSize)));
                    notifyClientClose(failedStatus, new Metadata());
                    return;
                }
                synchronized (this) {
                    if (this.closed) {
                        return;
                    }
                    InProcessStream.this.clientStream.statsTraceCtx.clientInboundHeaders();
                    this.clientStreamListener.headersRead(headers);
                }
            }

            @Override // io.grpc.internal.ServerStream
            public void close(Status status, Metadata trailers) {
                InProcessStream.this.clientStream.serverClosed(Status.OK, status);
                if (InProcessTransport.this.clientMaxInboundMetadataSize != Integer.MAX_VALUE) {
                    int statusSize = status.getDescription() == null ? 0 : status.getDescription().length();
                    int metadataSize = InProcessTransport.metadataSize(trailers) + statusSize;
                    if (metadataSize > InProcessTransport.this.clientMaxInboundMetadataSize) {
                        status = Status.RESOURCE_EXHAUSTED.withDescription(String.format("Response header metadata larger than %d: %d", Integer.valueOf(InProcessTransport.this.clientMaxInboundMetadataSize), Integer.valueOf(metadataSize)));
                        trailers = new Metadata();
                    }
                }
                notifyClientClose(status, trailers);
            }

            private void notifyClientClose(Status status, Metadata trailers) {
                Status clientStatus = InProcessTransport.cleanStatus(status, InProcessTransport.this.includeCauseWithStatus);
                synchronized (this) {
                    if (this.closed) {
                        return;
                    }
                    if (this.clientReceiveQueue.isEmpty()) {
                        this.closed = true;
                        InProcessStream.this.clientStream.statsTraceCtx.clientInboundTrailers(trailers);
                        InProcessStream.this.clientStream.statsTraceCtx.streamClosed(clientStatus);
                        this.clientStreamListener.closed(clientStatus, trailers);
                    } else {
                        this.clientNotifyStatus = clientStatus;
                        this.clientNotifyTrailers = trailers;
                    }
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.ServerStream
            public void cancel(Status status) {
                if (!internalCancel(Status.CANCELLED.withDescription("server cancelled stream"))) {
                    return;
                }
                InProcessStream.this.clientStream.serverClosed(status, status);
                InProcessStream.this.streamClosed();
            }

            private synchronized boolean internalCancel(Status clientStatus) {
                if (this.closed) {
                    return false;
                }
                this.closed = true;
                while (true) {
                    StreamListener.MessageProducer producer = this.clientReceiveQueue.poll();
                    if (producer == null) {
                        InProcessStream.this.clientStream.statsTraceCtx.streamClosed(clientStatus);
                        this.clientStreamListener.closed(clientStatus, new Metadata());
                        return true;
                    }
                    while (true) {
                        InputStream message = producer.next();
                        if (message != null) {
                            message.close();
                        }
                    }
                }
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean enable) {
            }

            @Override // io.grpc.internal.Stream
            public void optimizeForDirectExecutor() {
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.ServerStream
            public void setDecompressor(Decompressor decompressor) {
            }

            @Override // io.grpc.internal.ServerStream
            public Attributes getAttributes() {
                return InProcessTransport.this.serverStreamAttributes;
            }

            @Override // io.grpc.internal.ServerStream
            public String getAuthority() {
                return InProcessStream.this.authority;
            }

            @Override // io.grpc.internal.ServerStream
            public StatsTraceContext statsTraceContext() {
                return this.statsTraceCtx;
            }

            @Override // io.grpc.internal.ServerStream
            public int streamId() {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public class InProcessClientStream implements ClientStream {
            final CallOptions callOptions;
            private boolean closed;
            private int outboundSeqNo;
            private boolean serverNotifyHalfClose;
            private ArrayDeque<StreamListener.MessageProducer> serverReceiveQueue = new ArrayDeque<>();
            private int serverRequested;
            private ServerStreamListener serverStreamListener;
            final StatsTraceContext statsTraceCtx;

            InProcessClientStream(CallOptions callOptions, Metadata headers) {
                this.callOptions = callOptions;
                this.statsTraceCtx = StatsTraceContext.newClientContext(callOptions, InProcessTransport.this.attributes, headers);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void setListener(ServerStreamListener listener) {
                this.serverStreamListener = listener;
            }

            @Override // io.grpc.internal.Stream
            public void request(int numMessages) {
                boolean onReady = InProcessStream.this.serverStream.clientRequested(numMessages);
                if (onReady) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.serverStreamListener.onReady();
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized boolean serverRequested(int numMessages) {
                boolean z = false;
                if (this.closed) {
                    return false;
                }
                boolean previouslyReady = this.serverRequested > 0;
                this.serverRequested += numMessages;
                while (this.serverRequested > 0 && !this.serverReceiveQueue.isEmpty()) {
                    this.serverRequested--;
                    this.serverStreamListener.messagesAvailable(this.serverReceiveQueue.poll());
                }
                if (this.serverReceiveQueue.isEmpty() && this.serverNotifyHalfClose) {
                    this.serverNotifyHalfClose = false;
                    this.serverStreamListener.halfClosed();
                }
                boolean nowReady = this.serverRequested > 0;
                if (!previouslyReady && nowReady) {
                    z = true;
                }
                return z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void serverClosed(Status serverListenerStatus, Status serverTracerStatus) {
                internalCancel(serverListenerStatus, serverTracerStatus);
            }

            @Override // io.grpc.internal.Stream
            public synchronized void writeMessage(InputStream message) {
                if (this.closed) {
                    return;
                }
                this.statsTraceCtx.outboundMessage(this.outboundSeqNo);
                this.statsTraceCtx.outboundMessageSent(this.outboundSeqNo, -1L, -1L);
                InProcessStream.this.serverStream.statsTraceCtx.inboundMessage(this.outboundSeqNo);
                InProcessStream.this.serverStream.statsTraceCtx.inboundMessageRead(this.outboundSeqNo, -1L, -1L);
                this.outboundSeqNo++;
                StreamListener.MessageProducer producer = new SingleMessageProducer(message);
                if (this.serverRequested > 0) {
                    this.serverRequested--;
                    this.serverStreamListener.messagesAvailable(producer);
                } else {
                    this.serverReceiveQueue.add(producer);
                }
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.serverRequested > 0;
            }

            @Override // io.grpc.internal.ClientStream
            public void cancel(Status reason) {
                Status serverStatus = InProcessTransport.cleanStatus(reason, InProcessTransport.this.includeCauseWithStatus);
                if (internalCancel(serverStatus, serverStatus)) {
                    InProcessStream.this.serverStream.clientCancelled(reason);
                    InProcessStream.this.streamClosed();
                }
            }

            private synchronized boolean internalCancel(Status serverListenerStatus, Status serverTracerStatus) {
                if (this.closed) {
                    return false;
                }
                this.closed = true;
                while (true) {
                    StreamListener.MessageProducer producer = this.serverReceiveQueue.poll();
                    if (producer == null) {
                        InProcessStream.this.serverStream.statsTraceCtx.streamClosed(serverTracerStatus);
                        this.serverStreamListener.closed(serverListenerStatus);
                        return true;
                    }
                    while (true) {
                        InputStream message = producer.next();
                        if (message != null) {
                            message.close();
                        }
                    }
                }
            }

            @Override // io.grpc.internal.ClientStream
            public synchronized void halfClose() {
                if (this.closed) {
                    return;
                }
                if (this.serverReceiveQueue.isEmpty()) {
                    this.serverStreamListener.halfClosed();
                } else {
                    this.serverNotifyHalfClose = true;
                }
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean enable) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setAuthority(String string) {
                InProcessStream.this.authority = string;
            }

            @Override // io.grpc.internal.ClientStream
            public void start(ClientStreamListener listener) {
                InProcessStream.this.serverStream.setListener(listener);
                synchronized (InProcessTransport.this) {
                    this.statsTraceCtx.clientOutboundHeaders();
                    InProcessTransport.this.streams.add(InProcessStream.this);
                    if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                        InProcessTransport.this.inUseState.updateObjectInUse(InProcessStream.this, true);
                    }
                    InProcessTransport.this.serverTransportListener.streamCreated(InProcessStream.this.serverStream, InProcessStream.this.method.getFullMethodName(), InProcessStream.this.headers);
                }
            }

            @Override // io.grpc.internal.ClientStream
            public Attributes getAttributes() {
                return InProcessTransport.this.attributes;
            }

            @Override // io.grpc.internal.Stream
            public void optimizeForDirectExecutor() {
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setFullStreamDecompression(boolean fullStreamDecompression) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setMaxInboundMessageSize(int maxSize) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setMaxOutboundMessageSize(int maxSize) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setDeadline(Deadline deadline) {
                InProcessStream.this.headers.discardAll(GrpcUtil.TIMEOUT_KEY);
                long effectiveTimeout = Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS));
                InProcessStream.this.headers.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(effectiveTimeout));
            }

            @Override // io.grpc.internal.ClientStream
            public void appendTimeoutInsight(InsightBuilder insight) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status cleanStatus(Status status, boolean includeCauseWithStatus) {
        if (status == null) {
            return null;
        }
        Status clientStatus = Status.fromCodeValue(status.getCode().value()).withDescription(status.getDescription());
        if (includeCauseWithStatus) {
            return clientStatus.withCause(status.getCause());
        }
        return clientStatus;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static class SingleMessageProducer implements StreamListener.MessageProducer {
        private InputStream message;

        private SingleMessageProducer(InputStream message) {
            this.message = message;
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        @Nullable
        public InputStream next() {
            InputStream messageToReturn = this.message;
            this.message = null;
            return messageToReturn;
        }
    }
}