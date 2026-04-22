package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.vivo.vturbo.VturboNetworkConstantsProxy;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckReturnValue;

/* JADX INFO: Access modifiers changed from: package-private */
public class DelayedStream implements ClientStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private DelayedStreamListener delayedListener;
    private Status error;
    private ClientStreamListener listener;
    private volatile boolean passThrough;
    private List<Runnable> pendingCalls = new ArrayList();
    private List<Runnable> preStartPendingCalls = new ArrayList();
    private ClientStream realStream;
    private long startTimeNanos;
    private long streamSetTimeNanos;

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(final int maxSize) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.1
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setMaxInboundMessageSize(maxSize);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(final int maxSize) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.2
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setMaxOutboundMessageSize(maxSize);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(final Deadline deadline) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.3
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insight) {
        synchronized (this) {
            if (this.listener == null) {
                return;
            }
            if (this.realStream != null) {
                insight.appendKeyValue("buffered_nanos", Long.valueOf(this.streamSetTimeNanos - this.startTimeNanos));
                this.realStream.appendTimeoutInsight(insight);
            } else {
                insight.appendKeyValue("buffered_nanos", Long.valueOf(System.nanoTime() - this.startTimeNanos));
                insight.append("waiting_for_connection");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckReturnValue
    public final Runnable setStream(ClientStream stream) {
        synchronized (this) {
            if (this.realStream != null) {
                return null;
            }
            setRealStream((ClientStream) Preconditions.checkNotNull(stream, "stream"));
            ClientStreamListener savedListener = this.listener;
            if (savedListener == null) {
                if (!this.pendingCalls.isEmpty()) {
                    throw new AssertionError();
                }
                this.pendingCalls = null;
                this.passThrough = true;
            }
            if (savedListener == null) {
                return null;
            }
            internalStart(savedListener);
            return new Runnable() { // from class: io.grpc.internal.DelayedStream.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.drainPendingCalls();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
        r2 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        if (r2.hasNext() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        r3 = r2.next();
        r3.run();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainPendingCalls() {
        DelayedStreamListener delayedListener;
        if (this.realStream == null) {
            throw new AssertionError();
        }
        if (this.passThrough) {
            throw new AssertionError();
        }
        List<Runnable> toRun = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (this.pendingCalls.isEmpty()) {
                    break;
                }
                List<Runnable> tmp = toRun;
                toRun = this.pendingCalls;
                this.pendingCalls = tmp;
            }
            if (delayedListener == null) {
                delayedListener.drainPendingCallbacks();
                return;
            }
            return;
            toRun.clear();
        }
        this.pendingCalls = null;
        this.passThrough = true;
        delayedListener = this.delayedListener;
        if (delayedListener == null) {
        }
    }

    private void delayOrExecute(Runnable runnable) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        synchronized (this) {
            if (!this.passThrough) {
                this.pendingCalls.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(final String authority) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(authority, "authority");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.5
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setAuthority(authority);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener listener) {
        Status savedError;
        boolean savedPassThrough;
        Preconditions.checkNotNull(listener, "listener");
        Preconditions.checkState(this.listener == null, "already started");
        synchronized (this) {
            savedError = this.error;
            savedPassThrough = this.passThrough;
            if (!savedPassThrough) {
                DelayedStreamListener delayedStreamListener = new DelayedStreamListener(listener);
                this.delayedListener = delayedStreamListener;
                listener = delayedStreamListener;
            }
            this.listener = listener;
            this.startTimeNanos = System.nanoTime();
        }
        if (savedError != null) {
            listener.closed(savedError, new Metadata());
        } else if (savedPassThrough) {
            internalStart(listener);
        }
    }

    private void internalStart(ClientStreamListener listener) {
        for (Runnable runnable : this.preStartPendingCalls) {
            runnable.run();
        }
        this.preStartPendingCalls = null;
        this.realStream.start(listener);
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        ClientStream savedRealStream;
        synchronized (this) {
            savedRealStream = this.realStream;
        }
        if (savedRealStream != null) {
            return savedRealStream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(final InputStream message) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        Preconditions.checkNotNull(message, "message");
        if (this.passThrough) {
            this.realStream.writeMessage(message);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.6
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.writeMessage(message);
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.flush();
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.7
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(final Status reason) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        Preconditions.checkNotNull(reason, VturboNetworkConstantsProxy.NETWORK_BLOCK_REASON_KEY);
        boolean delegateToRealStream = true;
        synchronized (this) {
            if (this.realStream == null) {
                setRealStream(NoopClientStream.INSTANCE);
                delegateToRealStream = false;
                this.error = reason;
            }
        }
        if (delegateToRealStream) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.8
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.cancel(reason);
                }
            });
            return;
        }
        drainPendingCalls();
        this.listener.closed(reason, new Metadata());
    }

    private void setRealStream(ClientStream realStream) {
        Preconditions.checkState(this.realStream == null, "realStream already set to %s", this.realStream);
        this.realStream = realStream;
        this.streamSetTimeNanos = System.nanoTime();
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.9
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void request(final int numMessages) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.request(numMessages);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.10
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.request(numMessages);
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.11
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.optimizeForDirectExecutor();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(final Compressor compressor) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(compressor, "compressor");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.12
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(final boolean fullStreamDecompression) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.13
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setFullStreamDecompression(fullStreamDecompression);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(decompressorRegistry, "decompressorRegistry");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.14
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        if (this.passThrough) {
            return this.realStream.isReady();
        }
        return false;
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(final boolean enable) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.setMessageCompression(enable);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.15
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.setMessageCompression(enable);
                }
            });
        }
    }

    ClientStream getRealStream() {
        return this.realStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class DelayedStreamListener implements ClientStreamListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientStreamListener realListener;

        public DelayedStreamListener(ClientStreamListener listener) {
            this.realListener = listener;
        }

        private void delayOrExecute(Runnable runnable) {
            synchronized (this) {
                if (!this.passThrough) {
                    this.pendingCallbacks.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer producer) {
            if (this.passThrough) {
                this.realListener.messagesAvailable(producer);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.messagesAvailable(producer);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.onReady();
                    }
                });
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata headers) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.headersRead(headers);
                }
            });
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final Metadata trailers) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, trailers);
                }
            });
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata trailers) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, rpcProgress, trailers);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainPendingCallbacks() {
            if (this.passThrough) {
                throw new AssertionError();
            }
            List<Runnable> toRun = new ArrayList<>();
            while (true) {
                synchronized (this) {
                    if (this.pendingCallbacks.isEmpty()) {
                        this.pendingCallbacks = null;
                        this.passThrough = true;
                        return;
                    }
                    List<Runnable> tmp = toRun;
                    toRun = this.pendingCallbacks;
                    this.pendingCallbacks = tmp;
                }
                for (Runnable runnable : toRun) {
                    runnable.run();
                }
                toRun.clear();
            }
        }
    }
}