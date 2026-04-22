package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ManagedClientTransport;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
public final class OobChannel extends ManagedChannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    private static final Logger log = Logger.getLogger(OobChannel.class.getName());
    private final String authority;
    private final CallTracer channelCallsTracer;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final DelayedClientTransport delayedTransport;
    private final Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final InternalLogId logId;
    private volatile boolean shutdown;
    private InternalSubchannel subchannel;
    private AbstractSubchannel subchannelImpl;
    private LoadBalancer.SubchannelPicker subchannelPicker;
    private final TimeProvider timeProvider;
    private final CountDownLatch terminatedLatch = new CountDownLatch(1);
    private final ClientCallImpl.ClientStreamProvider transportProvider = new ClientCallImpl.ClientStreamProvider() { // from class: io.grpc.internal.OobChannel.1
        @Override // io.grpc.internal.ClientCallImpl.ClientStreamProvider
        public ClientStream newStream(MethodDescriptor<?, ?> method, CallOptions callOptions, Metadata headers, Context context) {
            Context origContext = context.attach();
            try {
                return OobChannel.this.delayedTransport.newStream(method, headers, callOptions);
            } finally {
                context.detach(origContext);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public OobChannel(String authority, ObjectPool<? extends Executor> executorPool, ScheduledExecutorService deadlineCancellationExecutor, SynchronizationContext syncContext, CallTracer callsTracer, ChannelTracer channelTracer, InternalChannelz channelz, TimeProvider timeProvider) {
        this.authority = (String) Preconditions.checkNotNull(authority, "authority");
        this.logId = InternalLogId.allocate(getClass(), authority);
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(executorPool, "executorPool");
        this.executor = (Executor) Preconditions.checkNotNull(executorPool.getObject(), "executor");
        this.deadlineCancellationExecutor = (ScheduledExecutorService) Preconditions.checkNotNull(deadlineCancellationExecutor, "deadlineCancellationExecutor");
        this.delayedTransport = new DelayedClientTransport(this.executor, syncContext);
        this.channelz = (InternalChannelz) Preconditions.checkNotNull(channelz);
        this.delayedTransport.start(new ManagedClientTransport.Listener() { // from class: io.grpc.internal.OobChannel.2
            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportShutdown(Status s) {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportTerminated() {
                OobChannel.this.subchannelImpl.shutdown();
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportReady() {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportInUse(boolean inUse) {
            }
        });
        this.channelCallsTracer = callsTracer;
        this.channelTracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer, "channelTracer");
        this.timeProvider = (TimeProvider) Preconditions.checkNotNull(timeProvider, "timeProvider");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSubchannel(final InternalSubchannel subchannel) {
        log.log(Level.FINE, "[{0}] Created with [{1}]", new Object[]{this, subchannel});
        this.subchannel = subchannel;
        this.subchannelImpl = new AbstractSubchannel() { // from class: io.grpc.internal.OobChannel.3
            @Override // io.grpc.LoadBalancer.Subchannel
            public void shutdown() {
                subchannel.shutdown(Status.UNAVAILABLE.withDescription("OobChannel is shutdown"));
            }

            @Override // io.grpc.internal.AbstractSubchannel
            InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel() {
                return subchannel;
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public void requestConnection() {
                subchannel.obtainActiveTransport();
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public List<EquivalentAddressGroup> getAllAddresses() {
                return subchannel.getAddressGroups();
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public Attributes getAttributes() {
                return Attributes.EMPTY;
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public Object getInternalSubchannel() {
                return subchannel;
            }
        };
        this.subchannelPicker = new LoadBalancer.SubchannelPicker() { // from class: io.grpc.internal.OobChannel.1OobSubchannelPicker
            final LoadBalancer.PickResult result;

            {
                this.result = LoadBalancer.PickResult.withSubchannel(OobChannel.this.subchannelImpl);
            }

            @Override // io.grpc.LoadBalancer.SubchannelPicker
            public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
                return this.result;
            }

            public String toString() {
                return MoreObjects.toStringHelper(C1OobSubchannelPicker.class).add("result", this.result).toString();
            }
        };
        this.delayedTransport.reprocess(this.subchannelPicker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateAddresses(EquivalentAddressGroup eag) {
        this.subchannel.updateAddresses(Collections.singletonList(eag));
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return new ClientCallImpl(methodDescriptor, callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor(), callOptions, this.transportProvider, this.deadlineCancellationExecutor, this.channelCallsTracer, null);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.authority;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.terminatedLatch.getCount() == 0;
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long time, TimeUnit unit) throws InterruptedException {
        return this.terminatedLatch.await(time, unit);
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean requestConnectionIgnored) {
        if (this.subchannel == null) {
            return ConnectivityState.IDLE;
        }
        return this.subchannel.getState();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        this.shutdown = true;
        this.delayedTransport.shutdown(Status.UNAVAILABLE.withDescription("OobChannel.shutdown() called"));
        return this;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        this.shutdown = true;
        this.delayedTransport.shutdownNow(Status.UNAVAILABLE.withDescription("OobChannel.shutdownNow() called"));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleSubchannelStateChange(final ConnectivityStateInfo newState) {
        this.channelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Entering " + newState.getState() + " state").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(this.timeProvider.currentTimeNanos()).build());
        switch (newState.getState()) {
            case READY:
            case IDLE:
                this.delayedTransport.reprocess(this.subchannelPicker);
                return;
            case TRANSIENT_FAILURE:
                this.delayedTransport.reprocess(new LoadBalancer.SubchannelPicker() { // from class: io.grpc.internal.OobChannel.1OobErrorPicker
                    final LoadBalancer.PickResult errorResult;

                    {
                        this.errorResult = LoadBalancer.PickResult.withError(newState.getStatus());
                    }

                    @Override // io.grpc.LoadBalancer.SubchannelPicker
                    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
                        return this.errorResult;
                    }

                    public String toString() {
                        return MoreObjects.toStringHelper(C1OobErrorPicker.class).add("errorResult", this.errorResult).toString();
                    }
                });
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleSubchannelTerminated() {
        this.channelz.removeSubchannel(this);
        this.executorPool.returnObject(this.executor);
        this.terminatedLatch.countDown();
    }

    LoadBalancer.Subchannel getSubchannel() {
        return this.subchannelImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalSubchannel getInternalSubchannel() {
        return this.subchannel;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        SettableFuture<InternalChannelz.ChannelStats> ret = SettableFuture.create();
        InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
        this.channelCallsTracer.updateBuilder(builder);
        this.channelTracer.updateBuilder(builder);
        builder.setTarget(this.authority).setState(this.subchannel.getState()).setSubchannels(Collections.singletonList(this.subchannel));
        ret.set(builder.build());
        return ret;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("authority", this.authority).toString();
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.subchannel.resetConnectBackoff();
    }
}