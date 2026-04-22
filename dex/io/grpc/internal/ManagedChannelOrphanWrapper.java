package io.grpc.internal;

import io.grpc.ManagedChannel;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ManagedChannelOrphanWrapper extends ForwardingManagedChannel {
    private final ManagedChannelReference phantom;
    private static final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue = new ReferenceQueue<>();
    private static final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs = new ConcurrentHashMap();
    private static final Logger logger = Logger.getLogger(ManagedChannelOrphanWrapper.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelOrphanWrapper(ManagedChannel delegate) {
        this(delegate, refqueue, refs);
    }

    ManagedChannelOrphanWrapper(ManagedChannel delegate, ReferenceQueue<ManagedChannelOrphanWrapper> refqueue2, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs2) {
        super(delegate);
        this.phantom = new ManagedChannelReference(this, delegate, refqueue2, refs2);
    }

    @Override // io.grpc.internal.ForwardingManagedChannel, io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        this.phantom.clearSafely();
        return super.shutdown();
    }

    @Override // io.grpc.internal.ForwardingManagedChannel, io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        this.phantom.clearSafely();
        return super.shutdownNow();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class ManagedChannelReference extends WeakReference<ManagedChannelOrphanWrapper> {
        private static final String ALLOCATION_SITE_PROPERTY_NAME = "io.grpc.ManagedChannel.enableAllocationTracking";
        private static final boolean ENABLE_ALLOCATION_TRACKING = Boolean.parseBoolean(System.getProperty(ALLOCATION_SITE_PROPERTY_NAME, "true"));
        private static final RuntimeException missingCallSite = missingCallSite();
        private final Reference<RuntimeException> allocationSite;
        private final String channelStr;
        private final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue;
        private final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs;
        private final AtomicBoolean shutdown;

        ManagedChannelReference(ManagedChannelOrphanWrapper orphanable, ManagedChannel channel, ReferenceQueue<ManagedChannelOrphanWrapper> refqueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs) {
            super(orphanable, refqueue);
            RuntimeException runtimeException;
            this.shutdown = new AtomicBoolean();
            if (ENABLE_ALLOCATION_TRACKING) {
                runtimeException = new RuntimeException("ManagedChannel allocation site");
            } else {
                runtimeException = missingCallSite;
            }
            this.allocationSite = new SoftReference(runtimeException);
            this.channelStr = channel.toString();
            this.refqueue = refqueue;
            this.refs = refs;
            this.refs.put(this, this);
            cleanQueue(refqueue);
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            clearInternal();
            cleanQueue(this.refqueue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSafely() {
            if (!this.shutdown.getAndSet(true)) {
                clear();
            }
        }

        private void clearInternal() {
            super.clear();
            this.refs.remove(this);
            this.allocationSite.clear();
        }

        private static RuntimeException missingCallSite() {
            RuntimeException e2 = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            e2.setStackTrace(new StackTraceElement[0]);
            return e2;
        }

        static int cleanQueue(ReferenceQueue<ManagedChannelOrphanWrapper> refqueue) {
            int orphanedChannels = 0;
            while (true) {
                ManagedChannelReference ref = (ManagedChannelReference) refqueue.poll();
                if (ref != null) {
                    RuntimeException maybeAllocationSite = ref.allocationSite.get();
                    ref.clearInternal();
                    if (!ref.shutdown.get()) {
                        orphanedChannels++;
                        Level level = Level.SEVERE;
                        if (ManagedChannelOrphanWrapper.logger.isLoggable(level)) {
                            String fmt = "*~*~*~ Channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.";
                            LogRecord lr = new LogRecord(level, fmt);
                            lr.setLoggerName(ManagedChannelOrphanWrapper.logger.getName());
                            lr.setParameters(new Object[]{ref.channelStr});
                            lr.setThrown(maybeAllocationSite);
                            ManagedChannelOrphanWrapper.logger.log(lr);
                        }
                    }
                } else {
                    return orphanedChannels;
                }
            }
        }
    }
}