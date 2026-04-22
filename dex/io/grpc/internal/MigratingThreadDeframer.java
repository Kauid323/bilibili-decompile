package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframerListener;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

final class MigratingThreadDeframer implements ThreadOptimizedDeframer {
    private final ApplicationThreadDeframerListener appListener;
    private final MessageDeframer deframer;
    private boolean deframerOnTransportThread;
    private boolean messageProducerEnqueued;
    private final MigratingDeframerListener migratingListener;
    private final ApplicationThreadDeframerListener.TransportExecutor transportExecutor;
    private final MessageDeframer.Listener transportListener;
    private final DeframeMessageProducer messageProducer = new DeframeMessageProducer();
    private final Object lock = new Object();
    private final Queue<Op> opQueue = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Op {
        void run(boolean z);
    }

    static /* synthetic */ ApplicationThreadDeframerListener access$500(MigratingThreadDeframer x0) {
        return x0.appListener;
    }

    public MigratingThreadDeframer(MessageDeframer.Listener listener, ApplicationThreadDeframerListener.TransportExecutor transportExecutor, MessageDeframer deframer) {
        this.transportListener = new SquelchLateMessagesAvailableDeframerListener((MessageDeframer.Listener) Preconditions.checkNotNull(listener, "listener"));
        this.transportExecutor = (ApplicationThreadDeframerListener.TransportExecutor) Preconditions.checkNotNull(transportExecutor, "transportExecutor");
        this.appListener = new ApplicationThreadDeframerListener(this.transportListener, transportExecutor);
        this.migratingListener = new MigratingDeframerListener(this.appListener);
        deframer.setListener(this.migratingListener);
        this.deframer = deframer;
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int messageSize) {
        this.deframer.setMaxInboundMessageSize(messageSize);
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer fullStreamDecompressor) {
        this.deframer.setFullStreamDecompressor(fullStreamDecompressor);
    }

    private boolean runWhereAppropriate(Op op) {
        return runWhereAppropriate(op, true);
    }

    private boolean runWhereAppropriate(Op op, boolean currentThreadIsTransportThread) {
        boolean deframerOnTransportThreadCopy;
        boolean alreadyEnqueued;
        synchronized (this.lock) {
            deframerOnTransportThreadCopy = this.deframerOnTransportThread;
            alreadyEnqueued = this.messageProducerEnqueued;
            if (!deframerOnTransportThreadCopy) {
                this.opQueue.offer(op);
                this.messageProducerEnqueued = true;
            }
        }
        if (deframerOnTransportThreadCopy) {
            op.run(true);
            return true;
        } else if (!alreadyEnqueued) {
            if (currentThreadIsTransportThread) {
                PerfMark.startTask("MigratingThreadDeframer.messageAvailable");
                try {
                    this.transportListener.messagesAvailable(this.messageProducer);
                    return false;
                } finally {
                    PerfMark.stopTask("MigratingThreadDeframer.messageAvailable");
                }
            }
            final Link link = PerfMark.linkOut();
            this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1
                @Override // java.lang.Runnable
                public void run() {
                    PerfMark.startTask("MigratingThreadDeframer.messageAvailable");
                    PerfMark.linkIn(link);
                    try {
                        MigratingThreadDeframer.this.transportListener.messagesAvailable(MigratingThreadDeframer.this.messageProducer);
                    } finally {
                        PerfMark.stopTask("MigratingThreadDeframer.messageAvailable");
                    }
                }
            });
            return false;
        } else {
            return false;
        }
    }

    @Override // io.grpc.internal.ThreadOptimizedDeframer, io.grpc.internal.Deframer
    public void request(final int numMessages) {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean isDeframerOnTransportThread) {
                if (isDeframerOnTransportThread) {
                    final Link link = PerfMark.linkOut();
                    MigratingThreadDeframer.this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PerfMark.startTask("MigratingThreadDeframer.request");
                            PerfMark.linkIn(link);
                            try {
                                MigratingThreadDeframer.this.requestFromTransportThread(numMessages);
                            } finally {
                                PerfMark.stopTask("MigratingThreadDeframer.request");
                            }
                        }
                    });
                    return;
                }
                PerfMark.startTask("MigratingThreadDeframer.request");
                try {
                    MigratingThreadDeframer.this.deframer.request(numMessages);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFromTransportThread(final int numMessages) {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestAgainOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean isDeframerOnTransportThread) {
                if (isDeframerOnTransportThread) {
                    try {
                        MigratingThreadDeframer.this.deframer.request(numMessages);
                    } catch (Throwable t) {
                        MigratingThreadDeframer.this.appListener.deframeFailed(t);
                        MigratingThreadDeframer.this.deframer.close();
                    }
                    if (!MigratingThreadDeframer.this.deframer.hasPendingDeliveries()) {
                        synchronized (MigratingThreadDeframer.this.lock) {
                            PerfMark.event("MigratingThreadDeframer.deframerOnApplicationThread");
                            MigratingThreadDeframer.this.migratingListener.setDelegate(MigratingThreadDeframer.this.appListener);
                            MigratingThreadDeframer.this.deframerOnTransportThread = false;
                        }
                        return;
                    }
                    return;
                }
                MigratingThreadDeframer.this.request(numMessages);
            }
        });
    }

    /* renamed from: io.grpc.internal.MigratingThreadDeframer$1DeframeOp  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    class C1DeframeOp implements Op, Closeable {
        final /* synthetic */ ReadableBuffer val$data;

        C1DeframeOp(ReadableBuffer readableBuffer) {
            this.val$data = readableBuffer;
        }

        @Override // io.grpc.internal.MigratingThreadDeframer.Op
        public void run(boolean isDeframerOnTransportThread) {
            PerfMark.startTask("MigratingThreadDeframer.deframe");
            try {
                if (isDeframerOnTransportThread) {
                    MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                } else {
                    MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                }
            } finally {
                PerfMark.stopTask("MigratingThreadDeframer.deframe");
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.val$data.close();
        }
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(ReadableBuffer data) {
        runWhereAppropriate(new C1DeframeOp(data));
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseWhenCompleteOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean isDeframerOnTransportThread) {
                MigratingThreadDeframer.this.deframer.closeWhenComplete();
            }
        });
    }

    @Override // io.grpc.internal.Deframer
    public void close() {
        if (!runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean isDeframerOnTransportThread) {
                MigratingThreadDeframer.this.deframer.close();
            }
        })) {
            this.deframer.stopDelivery();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class DeframeMessageProducer implements StreamListener.MessageProducer, Closeable {
        DeframeMessageProducer() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (r6.this$0.deframer.hasPendingDeliveries() == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
            io.perfmark.PerfMark.event("MigratingThreadDeframer.deframerOnTransportThread");
            r6.this$0.migratingListener.setDelegate(r6.this$0.transportListener);
            r6.this$0.deframerOnTransportThread = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
            r6.this$0.messageProducerEnqueued = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
            return null;
         */
        @Override // io.grpc.internal.StreamListener.MessageProducer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InputStream next() {
            Op op;
            while (true) {
                InputStream is = MigratingThreadDeframer.this.appListener.messageReadQueuePoll();
                if (is == null) {
                    synchronized (MigratingThreadDeframer.this.lock) {
                        op = (Op) MigratingThreadDeframer.this.opQueue.poll();
                        if (op == null) {
                            break;
                        }
                    }
                    op.run(false);
                } else {
                    return is;
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Op op;
            while (true) {
                synchronized (MigratingThreadDeframer.this.lock) {
                    do {
                        op = (Op) MigratingThreadDeframer.this.opQueue.poll();
                        if (op == null) {
                            break;
                        }
                    } while (!(op instanceof Closeable));
                    if (op == null) {
                        MigratingThreadDeframer.this.messageProducerEnqueued = false;
                        return;
                    }
                }
                GrpcUtil.closeQuietly((Closeable) op);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static class MigratingDeframerListener extends ForwardingDeframerListener {
        private MessageDeframer.Listener delegate;

        public MigratingDeframerListener(MessageDeframer.Listener delegate) {
            setDelegate(delegate);
        }

        @Override // io.grpc.internal.ForwardingDeframerListener
        protected MessageDeframer.Listener delegate() {
            return this.delegate;
        }

        public void setDelegate(MessageDeframer.Listener delegate) {
            this.delegate = (MessageDeframer.Listener) Preconditions.checkNotNull(delegate, "delegate");
        }
    }
}