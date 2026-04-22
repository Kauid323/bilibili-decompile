package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.InternalWithLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ManagedClientTransport;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public final class InternalSubchannel implements InternalInstrumented<InternalChannelz.ChannelStats>, TransportProvider {
    @Nullable
    private volatile ManagedClientTransport activeTransport;
    private volatile List<EquivalentAddressGroup> addressGroups;
    private final Index addressIndex;
    private final String authority;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final Callback callback;
    private final CallTracer callsTracer;
    private final ChannelLogger channelLogger;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final Stopwatch connectingTimer;
    private final InternalLogId logId;
    @Nullable
    private ConnectionClientTransport pendingTransport;
    private BackoffPolicy reconnectPolicy;
    @Nullable
    private SynchronizationContext.ScheduledHandle reconnectTask;
    private final ScheduledExecutorService scheduledExecutor;
    @Nullable
    private SynchronizationContext.ScheduledHandle shutdownDueToUpdateTask;
    @Nullable
    private ManagedClientTransport shutdownDueToUpdateTransport;
    private Status shutdownReason;
    private final SynchronizationContext syncContext;
    private final ClientTransportFactory transportFactory;
    private final String userAgent;
    private final Collection<ConnectionClientTransport> transports = new ArrayList();
    private final InUseStateAggregator<ConnectionClientTransport> inUseStateAggregator = new InUseStateAggregator<ConnectionClientTransport>() { // from class: io.grpc.internal.InternalSubchannel.1
        @Override // io.grpc.internal.InUseStateAggregator
        protected void handleInUse() {
            InternalSubchannel.this.callback.onInUse(InternalSubchannel.this);
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void handleNotInUse() {
            InternalSubchannel.this.callback.onNotInUse(InternalSubchannel.this);
        }
    };
    private volatile ConnectivityStateInfo state = ConnectivityStateInfo.forNonError(ConnectivityState.IDLE);

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalSubchannel(List<EquivalentAddressGroup> addressGroups, String authority, String userAgent, BackoffPolicy.Provider backoffPolicyProvider, ClientTransportFactory transportFactory, ScheduledExecutorService scheduledExecutor, Supplier<Stopwatch> stopwatchSupplier, SynchronizationContext syncContext, Callback callback, InternalChannelz channelz, CallTracer callsTracer, ChannelTracer channelTracer, InternalLogId logId, ChannelLogger channelLogger) {
        Preconditions.checkNotNull(addressGroups, "addressGroups");
        Preconditions.checkArgument(!addressGroups.isEmpty(), "addressGroups is empty");
        checkListHasNoNulls(addressGroups, "addressGroups contains null entry");
        List<EquivalentAddressGroup> unmodifiableAddressGroups = Collections.unmodifiableList(new ArrayList(addressGroups));
        this.addressGroups = unmodifiableAddressGroups;
        this.addressIndex = new Index(unmodifiableAddressGroups);
        this.authority = authority;
        this.userAgent = userAgent;
        this.backoffPolicyProvider = backoffPolicyProvider;
        this.transportFactory = transportFactory;
        this.scheduledExecutor = scheduledExecutor;
        this.connectingTimer = (Stopwatch) stopwatchSupplier.get();
        this.syncContext = syncContext;
        this.callback = callback;
        this.channelz = channelz;
        this.callsTracer = callsTracer;
        this.channelTracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer, "channelTracer");
        this.logId = (InternalLogId) Preconditions.checkNotNull(logId, "logId");
        this.channelLogger = (ChannelLogger) Preconditions.checkNotNull(channelLogger, "channelLogger");
    }

    ChannelLogger getChannelLogger() {
        return this.channelLogger;
    }

    @Override // io.grpc.internal.TransportProvider
    public ClientTransport obtainActiveTransport() {
        ClientTransport savedTransport = this.activeTransport;
        if (savedTransport != null) {
            return savedTransport;
        }
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.2
            @Override // java.lang.Runnable
            public void run() {
                if (InternalSubchannel.this.state.getState() == ConnectivityState.IDLE) {
                    InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING as requested");
                    InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                    InternalSubchannel.this.startNewTransport();
                }
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ClientTransport getTransport() {
        return this.activeTransport;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAuthority() {
        return this.authority;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNewTransport() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        Preconditions.checkState(this.reconnectTask == null, "Should have no reconnectTask scheduled");
        if (this.addressIndex.isAtBeginning()) {
            this.connectingTimer.reset().start();
        }
        SocketAddress address = this.addressIndex.getCurrentAddress();
        HttpConnectProxiedSocketAddress proxiedAddr = null;
        if (address instanceof HttpConnectProxiedSocketAddress) {
            proxiedAddr = (HttpConnectProxiedSocketAddress) address;
            address = proxiedAddr.getTargetAddress();
        }
        Attributes currentEagAttributes = this.addressIndex.getCurrentEagAttributes();
        String eagChannelAuthority = (String) currentEagAttributes.get(EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE);
        ClientTransportFactory.ClientTransportOptions options = new ClientTransportFactory.ClientTransportOptions().setAuthority(eagChannelAuthority != null ? eagChannelAuthority : this.authority).setEagAttributes(currentEagAttributes).setUserAgent(this.userAgent).setHttpConnectProxiedSocketAddress(proxiedAddr);
        TransportLogger transportLogger = new TransportLogger();
        transportLogger.logId = getLogId();
        ConnectionClientTransport transport = new CallTracingTransport(this.transportFactory.newClientTransport(address, options, transportLogger), this.callsTracer);
        transportLogger.logId = transport.getLogId();
        this.channelz.addClientSocket(transport);
        this.pendingTransport = transport;
        this.transports.add(transport);
        Runnable runnable = transport.start(new TransportListener(transport, address));
        if (runnable != null) {
            this.syncContext.executeLater(runnable);
        }
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Started transport {0}", transportLogger.logId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleBackoff(Status status) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        gotoState(ConnectivityStateInfo.forTransientFailure(status));
        if (this.reconnectPolicy == null) {
            this.reconnectPolicy = this.backoffPolicyProvider.get();
        }
        long delayNanos = this.reconnectPolicy.nextBackoffNanos() - this.connectingTimer.elapsed(TimeUnit.NANOSECONDS);
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", printShortStatus(status), Long.valueOf(delayNanos));
        Preconditions.checkState(this.reconnectTask == null, "previous reconnectTask is not done");
        this.reconnectTask = this.syncContext.schedule(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.1EndOfCurrentBackoff
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.reconnectTask = null;
                InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING after backoff");
                InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                InternalSubchannel.this.startNewTransport();
            }
        }, delayNanos, TimeUnit.NANOSECONDS, this.scheduledExecutor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetConnectBackoff() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.3
            @Override // java.lang.Runnable
            public void run() {
                if (InternalSubchannel.this.state.getState() == ConnectivityState.TRANSIENT_FAILURE) {
                    InternalSubchannel.this.cancelReconnectTask();
                    InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING; backoff interrupted");
                    InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                    InternalSubchannel.this.startNewTransport();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoNonErrorState(ConnectivityState newState) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        gotoState(ConnectivityStateInfo.forNonError(newState));
    }

    private void gotoState(ConnectivityStateInfo newState) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.state.getState() != newState.getState()) {
            Preconditions.checkState(this.state.getState() != ConnectivityState.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + newState);
            this.state = newState;
            this.callback.onStateChange(this, newState);
        }
    }

    public void updateAddresses(final List<EquivalentAddressGroup> newAddressGroups) {
        Preconditions.checkNotNull(newAddressGroups, "newAddressGroups");
        checkListHasNoNulls(newAddressGroups, "newAddressGroups contains null entry");
        Preconditions.checkArgument(!newAddressGroups.isEmpty(), "newAddressGroups is empty");
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.4
            @Override // java.lang.Runnable
            public void run() {
                List<EquivalentAddressGroup> newImmutableAddressGroups = Collections.unmodifiableList(new ArrayList(newAddressGroups));
                ManagedClientTransport savedTransport = null;
                SocketAddress previousAddress = InternalSubchannel.this.addressIndex.getCurrentAddress();
                InternalSubchannel.this.addressIndex.updateGroups(newImmutableAddressGroups);
                InternalSubchannel.this.addressGroups = newImmutableAddressGroups;
                if ((InternalSubchannel.this.state.getState() == ConnectivityState.READY || InternalSubchannel.this.state.getState() == ConnectivityState.CONNECTING) && !InternalSubchannel.this.addressIndex.seekTo(previousAddress)) {
                    if (InternalSubchannel.this.state.getState() == ConnectivityState.READY) {
                        savedTransport = InternalSubchannel.this.activeTransport;
                        InternalSubchannel.this.activeTransport = null;
                        InternalSubchannel.this.addressIndex.reset();
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.IDLE);
                    } else {
                        InternalSubchannel.this.pendingTransport.shutdown(Status.UNAVAILABLE.withDescription("InternalSubchannel closed pending transport due to address change"));
                        InternalSubchannel.this.pendingTransport = null;
                        InternalSubchannel.this.addressIndex.reset();
                        InternalSubchannel.this.startNewTransport();
                    }
                }
                if (savedTransport != null) {
                    if (InternalSubchannel.this.shutdownDueToUpdateTask != null) {
                        InternalSubchannel.this.shutdownDueToUpdateTransport.shutdown(Status.UNAVAILABLE.withDescription("InternalSubchannel closed transport early due to address change"));
                        InternalSubchannel.this.shutdownDueToUpdateTask.cancel();
                        InternalSubchannel.this.shutdownDueToUpdateTask = null;
                        InternalSubchannel.this.shutdownDueToUpdateTransport = null;
                    }
                    InternalSubchannel.this.shutdownDueToUpdateTransport = savedTransport;
                    InternalSubchannel.this.shutdownDueToUpdateTask = InternalSubchannel.this.syncContext.schedule(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ManagedClientTransport transport = InternalSubchannel.this.shutdownDueToUpdateTransport;
                            InternalSubchannel.this.shutdownDueToUpdateTask = null;
                            InternalSubchannel.this.shutdownDueToUpdateTransport = null;
                            transport.shutdown(Status.UNAVAILABLE.withDescription("InternalSubchannel closed transport due to address change"));
                        }
                    }, 5L, TimeUnit.SECONDS, InternalSubchannel.this.scheduledExecutor);
                }
            }
        });
    }

    public void shutdown(final Status reason) {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.5
            @Override // java.lang.Runnable
            public void run() {
                if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN) {
                    return;
                }
                InternalSubchannel.this.shutdownReason = reason;
                ManagedClientTransport savedActiveTransport = InternalSubchannel.this.activeTransport;
                ConnectionClientTransport savedPendingTransport = InternalSubchannel.this.pendingTransport;
                InternalSubchannel.this.activeTransport = null;
                InternalSubchannel.this.pendingTransport = null;
                InternalSubchannel.this.gotoNonErrorState(ConnectivityState.SHUTDOWN);
                InternalSubchannel.this.addressIndex.reset();
                if (InternalSubchannel.this.transports.isEmpty()) {
                    InternalSubchannel.this.handleTermination();
                }
                InternalSubchannel.this.cancelReconnectTask();
                if (InternalSubchannel.this.shutdownDueToUpdateTask != null) {
                    InternalSubchannel.this.shutdownDueToUpdateTask.cancel();
                    InternalSubchannel.this.shutdownDueToUpdateTransport.shutdown(reason);
                    InternalSubchannel.this.shutdownDueToUpdateTask = null;
                    InternalSubchannel.this.shutdownDueToUpdateTransport = null;
                }
                if (savedActiveTransport != null) {
                    savedActiveTransport.shutdown(reason);
                }
                if (savedPendingTransport != null) {
                    savedPendingTransport.shutdown(reason);
                }
            }
        });
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("addressGroups", this.addressGroups).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTermination() {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.6
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
                InternalSubchannel.this.callback.onTerminated(InternalSubchannel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransportInUseState(final ConnectionClientTransport transport, final boolean inUse) {
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.7
            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.inUseStateAggregator.updateObjectInUse(transport, inUse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shutdownNow(final Status reason) {
        shutdown(reason);
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.8
            @Override // java.lang.Runnable
            public void run() {
                Collection<ManagedClientTransport> transportsCopy = new ArrayList<>(InternalSubchannel.this.transports);
                for (ManagedClientTransport transport : transportsCopy) {
                    transport.shutdownNow(reason);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<EquivalentAddressGroup> getAddressGroups() {
        return this.addressGroups;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelReconnectTask() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.reconnectTask != null) {
            this.reconnectTask.cancel();
            this.reconnectTask = null;
            this.reconnectPolicy = null;
        }
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        final SettableFuture<InternalChannelz.ChannelStats> channelStatsFuture = SettableFuture.create();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.9
            @Override // java.lang.Runnable
            public void run() {
                InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
                List<EquivalentAddressGroup> addressGroupsSnapshot = InternalSubchannel.this.addressIndex.getGroups();
                List<InternalWithLogId> transportsSnapshot = new ArrayList<>(InternalSubchannel.this.transports);
                builder.setTarget(addressGroupsSnapshot.toString()).setState(InternalSubchannel.this.getState());
                builder.setSockets(transportsSnapshot);
                InternalSubchannel.this.callsTracer.updateBuilder(builder);
                InternalSubchannel.this.channelTracer.updateBuilder(builder);
                channelStatsFuture.set(builder.build());
            }
        });
        return channelStatsFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectivityState getState() {
        return this.state.getState();
    }

    private static void checkListHasNoNulls(List<?> list, String msg) {
        for (Object item : list) {
            Preconditions.checkNotNull(item, msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class TransportListener implements ManagedClientTransport.Listener {
        final SocketAddress address;
        boolean shutdownInitiated = false;
        final ConnectionClientTransport transport;

        TransportListener(ConnectionClientTransport transport, SocketAddress address) {
            this.transport = transport;
            this.address = address;
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "READY");
            InternalSubchannel.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.TransportListener.1
                @Override // java.lang.Runnable
                public void run() {
                    InternalSubchannel.this.reconnectPolicy = null;
                    if (InternalSubchannel.this.shutdownReason != null) {
                        Preconditions.checkState(InternalSubchannel.this.activeTransport == null, "Unexpected non-null activeTransport");
                        TransportListener.this.transport.shutdown(InternalSubchannel.this.shutdownReason);
                    } else if (InternalSubchannel.this.pendingTransport == TransportListener.this.transport) {
                        InternalSubchannel.this.activeTransport = TransportListener.this.transport;
                        InternalSubchannel.this.pendingTransport = null;
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.READY);
                    }
                }
            });
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportInUse(boolean inUse) {
            InternalSubchannel.this.handleTransportInUseState(this.transport, inUse);
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(final Status s) {
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} SHUTDOWN with {1}", this.transport.getLogId(), InternalSubchannel.this.printShortStatus(s));
            this.shutdownInitiated = true;
            InternalSubchannel.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.TransportListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (InternalSubchannel.this.state.getState() != ConnectivityState.SHUTDOWN) {
                        if (InternalSubchannel.this.activeTransport == TransportListener.this.transport) {
                            InternalSubchannel.this.activeTransport = null;
                            InternalSubchannel.this.addressIndex.reset();
                            InternalSubchannel.this.gotoNonErrorState(ConnectivityState.IDLE);
                        } else if (InternalSubchannel.this.pendingTransport == TransportListener.this.transport) {
                            Preconditions.checkState(InternalSubchannel.this.state.getState() == ConnectivityState.CONNECTING, "Expected state is CONNECTING, actual state is %s", InternalSubchannel.this.state.getState());
                            InternalSubchannel.this.addressIndex.increment();
                            if (!InternalSubchannel.this.addressIndex.isValid()) {
                                InternalSubchannel.this.pendingTransport = null;
                                InternalSubchannel.this.addressIndex.reset();
                                InternalSubchannel.this.scheduleBackoff(s);
                                return;
                            }
                            InternalSubchannel.this.startNewTransport();
                        }
                    }
                }
            });
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            Preconditions.checkState(this.shutdownInitiated, "transportShutdown() must be called before transportTerminated().");
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} Terminated", this.transport.getLogId());
            InternalSubchannel.this.channelz.removeClientSocket(this.transport);
            InternalSubchannel.this.handleTransportInUseState(this.transport, false);
            InternalSubchannel.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.InternalSubchannel.TransportListener.3
                @Override // java.lang.Runnable
                public void run() {
                    InternalSubchannel.this.transports.remove(TransportListener.this.transport);
                    if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN && InternalSubchannel.this.transports.isEmpty()) {
                        InternalSubchannel.this.handleTermination();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Callback {
        void onTerminated(InternalSubchannel is) {
        }

        void onStateChange(InternalSubchannel is, ConnectivityStateInfo newState) {
        }

        void onInUse(InternalSubchannel is) {
        }

        void onNotInUse(InternalSubchannel is) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CallTracingTransport extends ForwardingConnectionClientTransport {
        private final CallTracer callTracer;
        private final ConnectionClientTransport delegate;

        private CallTracingTransport(ConnectionClientTransport delegate, CallTracer callTracer) {
            this.delegate = delegate;
            this.callTracer = callTracer;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport
        protected ConnectionClientTransport delegate() {
            return this.delegate;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ClientTransport
        public ClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions) {
            final ClientStream streamDelegate = super.newStream(method, headers, callOptions);
            return new ForwardingClientStream() { // from class: io.grpc.internal.InternalSubchannel.CallTracingTransport.1
                @Override // io.grpc.internal.ForwardingClientStream
                protected ClientStream delegate() {
                    return streamDelegate;
                }

                @Override // io.grpc.internal.ForwardingClientStream, io.grpc.internal.ClientStream
                public void start(final ClientStreamListener listener) {
                    CallTracingTransport.this.callTracer.reportCallStarted();
                    super.start(new ForwardingClientStreamListener() { // from class: io.grpc.internal.InternalSubchannel.CallTracingTransport.1.1
                        @Override // io.grpc.internal.ForwardingClientStreamListener
                        protected ClientStreamListener delegate() {
                            return listener;
                        }

                        @Override // io.grpc.internal.ForwardingClientStreamListener, io.grpc.internal.ClientStreamListener
                        public void closed(Status status, Metadata trailers) {
                            CallTracingTransport.this.callTracer.reportCallEnded(status.isOk());
                            super.closed(status, trailers);
                        }

                        @Override // io.grpc.internal.ForwardingClientStreamListener, io.grpc.internal.ClientStreamListener
                        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
                            CallTracingTransport.this.callTracer.reportCallEnded(status.isOk());
                            super.closed(status, rpcProgress, trailers);
                        }
                    });
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Index {
        private List<EquivalentAddressGroup> addressGroups;
        private int addressIndex;
        private int groupIndex;

        public Index(List<EquivalentAddressGroup> groups) {
            this.addressGroups = groups;
        }

        public boolean isValid() {
            return this.groupIndex < this.addressGroups.size();
        }

        public boolean isAtBeginning() {
            return this.groupIndex == 0 && this.addressIndex == 0;
        }

        public void increment() {
            EquivalentAddressGroup group = this.addressGroups.get(this.groupIndex);
            this.addressIndex++;
            if (this.addressIndex >= group.getAddresses().size()) {
                this.groupIndex++;
                this.addressIndex = 0;
            }
        }

        public void reset() {
            this.groupIndex = 0;
            this.addressIndex = 0;
        }

        public SocketAddress getCurrentAddress() {
            return this.addressGroups.get(this.groupIndex).getAddresses().get(this.addressIndex);
        }

        public Attributes getCurrentEagAttributes() {
            return this.addressGroups.get(this.groupIndex).getAttributes();
        }

        public List<EquivalentAddressGroup> getGroups() {
            return this.addressGroups;
        }

        public void updateGroups(List<EquivalentAddressGroup> newGroups) {
            this.addressGroups = newGroups;
            reset();
        }

        public boolean seekTo(SocketAddress needle) {
            for (int i2 = 0; i2 < this.addressGroups.size(); i2++) {
                EquivalentAddressGroup group = this.addressGroups.get(i2);
                int j = group.getAddresses().indexOf(needle);
                if (j != -1) {
                    this.groupIndex = i2;
                    this.addressIndex = j;
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printShortStatus(Status status) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(status.getCode());
        if (status.getDescription() != null) {
            buffer.append("(").append(status.getDescription()).append(")");
        }
        return buffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class TransportLogger extends ChannelLogger {
        InternalLogId logId;

        TransportLogger() {
        }

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel level, String message) {
            ChannelLoggerImpl.logOnly(this.logId, level, message);
        }

        @Override // io.grpc.ChannelLogger
        public void log(ChannelLogger.ChannelLogLevel level, String messageFormat, Object... args) {
            ChannelLoggerImpl.logOnly(this.logId, level, messageFormat, args);
        }
    }
}