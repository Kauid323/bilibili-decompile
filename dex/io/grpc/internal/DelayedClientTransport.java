package io.grpc.internal;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ManagedClientTransport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
public final class DelayedClientTransport implements ManagedClientTransport {
    private final Executor defaultAppExecutor;
    @Nullable
    private LoadBalancer.SubchannelPicker lastPicker;
    private long lastPickerVersion;
    private ManagedClientTransport.Listener listener;
    private Runnable reportTransportInUse;
    private Runnable reportTransportNotInUse;
    private Runnable reportTransportTerminated;
    private Status shutdownStatus;
    private final SynchronizationContext syncContext;
    private final InternalLogId logId = InternalLogId.allocate(DelayedClientTransport.class, (String) null);
    private final Object lock = new Object();
    @Nonnull
    private Collection<PendingStream> pendingStreams = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelayedClientTransport(Executor defaultAppExecutor, SynchronizationContext syncContext) {
        this.defaultAppExecutor = defaultAppExecutor;
        this.syncContext = syncContext;
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public final Runnable start(final ManagedClientTransport.Listener listener) {
        this.listener = listener;
        this.reportTransportInUse = new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.1
            @Override // java.lang.Runnable
            public void run() {
                listener.transportInUse(true);
            }
        };
        this.reportTransportNotInUse = new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.2
            @Override // java.lang.Runnable
            public void run() {
                listener.transportInUse(false);
            }
        };
        this.reportTransportTerminated = new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.3
            @Override // java.lang.Runnable
            public void run() {
                listener.transportTerminated();
            }
        };
        return null;
    }

    @Override // io.grpc.internal.ClientTransport
    public final ClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions) {
        ClientTransport transport;
        try {
            LoadBalancer.PickSubchannelArgs args = new PickSubchannelArgsImpl(method, headers, callOptions);
            LoadBalancer.SubchannelPicker picker = null;
            long pickerVersion = -1;
            do {
                synchronized (this.lock) {
                    if (this.shutdownStatus != null) {
                        return new FailingClientStream(this.shutdownStatus);
                    } else if (this.lastPicker == null) {
                        return createPendingStream(args);
                    } else if (picker != null && pickerVersion == this.lastPickerVersion) {
                        return createPendingStream(args);
                    } else {
                        picker = this.lastPicker;
                        pickerVersion = this.lastPickerVersion;
                        LoadBalancer.PickResult pickResult = picker.pickSubchannel(args);
                        transport = GrpcUtil.getTransportFromPickResult(pickResult, callOptions.isWaitForReady());
                    }
                }
            } while (transport == null);
            return transport.newStream(args.getMethodDescriptor(), args.getHeaders(), args.getCallOptions());
        } finally {
            this.syncContext.drain();
        }
    }

    private PendingStream createPendingStream(LoadBalancer.PickSubchannelArgs args) {
        PendingStream pendingStream = new PendingStream(args);
        this.pendingStreams.add(pendingStream);
        if (getPendingStreamsCount() == 1) {
            this.syncContext.executeLater(this.reportTransportInUse);
        }
        return pendingStream;
    }

    @Override // io.grpc.internal.ClientTransport
    public final void ping(ClientTransport.PingCallback callback, Executor executor) {
        throw new UnsupportedOperationException("This method is not expected to be called");
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture<InternalChannelz.SocketStats> ret = SettableFuture.create();
        ret.set((Object) null);
        return ret;
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public final void shutdown(final Status status) {
        synchronized (this.lock) {
            if (this.shutdownStatus != null) {
                return;
            }
            this.shutdownStatus = status;
            this.syncContext.executeLater(new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientTransport.this.listener.transportShutdown(status);
                }
            });
            if (!hasPendingStreams() && this.reportTransportTerminated != null) {
                this.syncContext.executeLater(this.reportTransportTerminated);
                this.reportTransportTerminated = null;
            }
            this.syncContext.drain();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public final void shutdownNow(Status status) {
        Collection<PendingStream> savedPendingStreams;
        Runnable savedReportTransportTerminated;
        shutdown(status);
        synchronized (this.lock) {
            savedPendingStreams = this.pendingStreams;
            savedReportTransportTerminated = this.reportTransportTerminated;
            this.reportTransportTerminated = null;
            if (!this.pendingStreams.isEmpty()) {
                this.pendingStreams = Collections.emptyList();
            }
        }
        if (savedReportTransportTerminated != null) {
            for (PendingStream stream : savedPendingStreams) {
                Runnable runnable = stream.setStream(new FailingClientStream(status, ClientStreamListener.RpcProgress.REFUSED));
                if (runnable != null) {
                    runnable.run();
                }
            }
            this.syncContext.execute(savedReportTransportTerminated);
        }
    }

    public final boolean hasPendingStreams() {
        boolean z;
        synchronized (this.lock) {
            z = !this.pendingStreams.isEmpty();
        }
        return z;
    }

    final int getPendingStreamsCount() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams.size();
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void reprocess(@Nullable LoadBalancer.SubchannelPicker picker) {
        synchronized (this.lock) {
            this.lastPicker = picker;
            this.lastPickerVersion++;
            if (picker != null && hasPendingStreams()) {
                ArrayList<PendingStream> toProcess = new ArrayList<>(this.pendingStreams);
                ArrayList<PendingStream> toRemove = new ArrayList<>();
                Iterator<PendingStream> it = toProcess.iterator();
                while (it.hasNext()) {
                    PendingStream stream = it.next();
                    LoadBalancer.PickResult pickResult = picker.pickSubchannel(stream.args);
                    CallOptions callOptions = stream.args.getCallOptions();
                    ClientTransport transport = GrpcUtil.getTransportFromPickResult(pickResult, callOptions.isWaitForReady());
                    if (transport != null) {
                        Executor executor = this.defaultAppExecutor;
                        if (callOptions.getExecutor() != null) {
                            executor = callOptions.getExecutor();
                        }
                        Runnable runnable = stream.createRealStream(transport);
                        if (runnable != null) {
                            executor.execute(runnable);
                        }
                        toRemove.add(stream);
                    }
                }
                synchronized (this.lock) {
                    if (hasPendingStreams()) {
                        this.pendingStreams.removeAll(toRemove);
                        if (this.pendingStreams.isEmpty()) {
                            this.pendingStreams = new LinkedHashSet();
                        }
                        if (!hasPendingStreams()) {
                            this.syncContext.executeLater(this.reportTransportNotInUse);
                            if (this.shutdownStatus != null && this.reportTransportTerminated != null) {
                                this.syncContext.executeLater(this.reportTransportTerminated);
                                this.reportTransportTerminated = null;
                            }
                        }
                        this.syncContext.drain();
                    }
                }
            }
        }
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class PendingStream extends DelayedStream {
        private final LoadBalancer.PickSubchannelArgs args;
        private final Context context;

        private PendingStream(LoadBalancer.PickSubchannelArgs args) {
            this.context = Context.current();
            this.args = args;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Runnable createRealStream(ClientTransport transport) {
            Context origContext = this.context.attach();
            try {
                ClientStream realStream = transport.newStream(this.args.getMethodDescriptor(), this.args.getHeaders(), this.args.getCallOptions());
                this.context.detach(origContext);
                return setStream(realStream);
            } catch (Throwable th) {
                this.context.detach(origContext);
                throw th;
            }
        }

        @Override // io.grpc.internal.DelayedStream, io.grpc.internal.ClientStream
        public void cancel(Status reason) {
            super.cancel(reason);
            synchronized (DelayedClientTransport.this.lock) {
                if (DelayedClientTransport.this.reportTransportTerminated != null) {
                    boolean justRemovedAnElement = DelayedClientTransport.this.pendingStreams.remove(this);
                    if (!DelayedClientTransport.this.hasPendingStreams() && justRemovedAnElement) {
                        DelayedClientTransport.this.syncContext.executeLater(DelayedClientTransport.this.reportTransportNotInUse);
                        if (DelayedClientTransport.this.shutdownStatus != null) {
                            DelayedClientTransport.this.syncContext.executeLater(DelayedClientTransport.this.reportTransportTerminated);
                            DelayedClientTransport.this.reportTransportTerminated = null;
                        }
                    }
                }
            }
            DelayedClientTransport.this.syncContext.drain();
        }

        @Override // io.grpc.internal.DelayedStream, io.grpc.internal.ClientStream
        public void appendTimeoutInsight(InsightBuilder insight) {
            if (this.args.getCallOptions().isWaitForReady()) {
                insight.append("wait_for_ready");
            }
            super.appendTimeoutInsight(insight);
        }
    }
}