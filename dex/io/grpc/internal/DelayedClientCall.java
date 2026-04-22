package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class DelayedClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Executor callExecutor;
    private final Context context;
    private DelayedListener<RespT> delayedListener;
    private Status error;
    @Nullable
    private final ScheduledFuture<?> initialDeadlineMonitor;
    private ClientCall.Listener<RespT> listener;
    private volatile boolean passThrough;
    private List<Runnable> pendingRunnables = new ArrayList();
    private ClientCall<ReqT, RespT> realCall;
    private static final Logger logger = Logger.getLogger(DelayedClientCall.class.getName());
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.internal.DelayedClientCall.7
        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> responseListener, Metadata headers) {
        }

        @Override // io.grpc.ClientCall
        public void request(int numMessages) {
        }

        @Override // io.grpc.ClientCall
        public void cancel(String message, Throwable cause) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object message) {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelayedClientCall(Executor callExecutor, ScheduledExecutorService scheduler, @Nullable Deadline deadline) {
        this.callExecutor = (Executor) Preconditions.checkNotNull(callExecutor, "callExecutor");
        Preconditions.checkNotNull(scheduler, "scheduler");
        this.context = Context.current();
        this.initialDeadlineMonitor = scheduleDeadlineIfNeeded(scheduler, deadline);
    }

    @Nullable
    private ScheduledFuture<?> scheduleDeadlineIfNeeded(ScheduledExecutorService scheduler, @Nullable Deadline deadline) {
        Deadline contextDeadline = this.context.getDeadline();
        if (deadline == null && contextDeadline == null) {
            return null;
        }
        long remainingNanos = deadline != null ? Math.min(Long.MAX_VALUE, deadline.timeRemaining(TimeUnit.NANOSECONDS)) : Long.MAX_VALUE;
        if (contextDeadline != null && contextDeadline.timeRemaining(TimeUnit.NANOSECONDS) < remainingNanos) {
            remainingNanos = contextDeadline.timeRemaining(TimeUnit.NANOSECONDS);
            if (logger.isLoggable(Level.FINE)) {
                StringBuilder builder = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(remainingNanos)));
                if (deadline == null) {
                    builder.append(" Explicit call timeout was not set.");
                } else {
                    long callTimeout = deadline.timeRemaining(TimeUnit.NANOSECONDS);
                    builder.append(String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(callTimeout)));
                }
                logger.fine(builder.toString());
            }
        }
        long seconds = Math.abs(remainingNanos) / TimeUnit.SECONDS.toNanos(1L);
        long nanos = Math.abs(remainingNanos) % TimeUnit.SECONDS.toNanos(1L);
        final StringBuilder buf = new StringBuilder();
        if (remainingNanos < 0) {
            buf.append("ClientCall started after deadline exceeded. Deadline exceeded after -");
        } else {
            buf.append("Deadline exceeded after ");
        }
        buf.append(seconds);
        buf.append(String.format(Locale.US, ".%09d", Long.valueOf(nanos)));
        buf.append("s. ");
        return scheduler.schedule(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.1DeadlineExceededRunnable
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.cancel(Status.DEADLINE_EXCEEDED.withDescription(buf.toString()), true);
            }
        }, remainingNanos, TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setCall(ClientCall<ReqT, RespT> call) {
        synchronized (this) {
            if (this.realCall != null) {
                return;
            }
            setRealCall((ClientCall) Preconditions.checkNotNull(call, "call"));
            drainPendingCalls();
        }
    }

    @Override // io.grpc.ClientCall
    public final void start(ClientCall.Listener<RespT> listener, final Metadata headers) {
        Status savedError;
        boolean savedPassThrough;
        Preconditions.checkState(this.listener == null, "already started");
        synchronized (this) {
            this.listener = (ClientCall.Listener) Preconditions.checkNotNull(listener, "listener");
            savedError = this.error;
            savedPassThrough = this.passThrough;
            if (!savedPassThrough) {
                DelayedListener<RespT> delayedListener = new DelayedListener<>(listener);
                this.delayedListener = delayedListener;
                listener = delayedListener;
            }
        }
        if (savedError != null) {
            this.callExecutor.execute(new CloseListenerRunnable(listener, savedError));
        } else if (savedPassThrough) {
            this.realCall.start(listener, headers);
        } else {
            final ClientCall.Listener<RespT> finalListener = listener;
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.1
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.start(finalListener, headers);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void cancel(@Nullable String message, @Nullable Throwable cause) {
        Status status;
        Status status2 = Status.CANCELLED;
        if (message != null) {
            status = status2.withDescription(message);
        } else {
            status = status2.withDescription("Call cancelled without message");
        }
        if (cause != null) {
            status = status.withCause(cause);
        }
        cancel(status, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cancel(final Status status, boolean onlyCancelPendingCall) {
        boolean delegateToRealCall = true;
        ClientCall.Listener<RespT> listenerToClose = null;
        synchronized (this) {
            if (this.realCall == null) {
                setRealCall(NOOP_CALL);
                delegateToRealCall = false;
                listenerToClose = this.listener;
                this.error = status;
            } else if (onlyCancelPendingCall) {
                return;
            }
            if (delegateToRealCall) {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedClientCall.this.realCall.cancel(status.getDescription(), status.getCause());
                    }
                });
            } else {
                if (listenerToClose != null) {
                    this.callExecutor.execute(new CloseListenerRunnable(listenerToClose, status));
                }
                drainPendingCalls();
            }
            callCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callCancelled() {
    }

    private void delayOrExecute(Runnable runnable) {
        synchronized (this) {
            if (!this.passThrough) {
                this.pendingRunnables.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        r1 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r1.hasNext() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        r2 = r1.next();
        r2.run();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drainPendingCalls() {
        final DelayedListener<RespT> delayedListener;
        if (this.realCall == null) {
            throw new AssertionError();
        }
        if (this.passThrough) {
            throw new AssertionError();
        }
        List<Runnable> toRun = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (this.pendingRunnables.isEmpty()) {
                    break;
                }
                List<Runnable> tmp = toRun;
                toRun = this.pendingRunnables;
                this.pendingRunnables = tmp;
            }
            if (delayedListener == null) {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.DelayedClientCall.1DrainListenerRunnable
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(DelayedClientCall.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        delayedListener.drainPendingCallbacks();
                    }
                });
                return;
            }
            return;
            toRun.clear();
        }
        this.pendingRunnables = null;
        this.passThrough = true;
        delayedListener = this.delayedListener;
        if (delayedListener == null) {
        }
    }

    private void setRealCall(ClientCall<ReqT, RespT> realCall) {
        Preconditions.checkState(this.realCall == null, "realCall already set to %s", this.realCall);
        if (this.initialDeadlineMonitor != null) {
            this.initialDeadlineMonitor.cancel(false);
        }
        this.realCall = realCall;
    }

    final ClientCall<ReqT, RespT> getRealCall() {
        return this.realCall;
    }

    @Override // io.grpc.ClientCall
    public final void sendMessage(final ReqT message) {
        if (this.passThrough) {
            this.realCall.sendMessage(message);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.sendMessage(message);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void setMessageCompression(final boolean enable) {
        if (this.passThrough) {
            this.realCall.setMessageCompression(enable);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.setMessageCompression(enable);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void request(final int numMessages) {
        if (this.passThrough) {
            this.realCall.request(numMessages);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.request(numMessages);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void halfClose() {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.6
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.realCall.halfClose();
            }
        });
    }

    @Override // io.grpc.ClientCall
    public final boolean isReady() {
        if (this.passThrough) {
            return this.realCall.isReady();
        }
        return false;
    }

    @Override // io.grpc.ClientCall
    public final Attributes getAttributes() {
        ClientCall<ReqT, RespT> savedRealCall;
        synchronized (this) {
            savedRealCall = this.realCall;
        }
        if (savedRealCall != null) {
            return savedRealCall.getAttributes();
        }
        return Attributes.EMPTY;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("realCall", this.realCall).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class CloseListenerRunnable extends ContextRunnable {
        final ClientCall.Listener<RespT> listener;
        final Status status;

        CloseListenerRunnable(ClientCall.Listener<RespT> listener, Status status) {
            super(DelayedClientCall.this.context);
            this.listener = listener;
            this.status = status;
        }

        @Override // io.grpc.internal.ContextRunnable
        public void runInContext() {
            this.listener.onClose(this.status, new Metadata());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DelayedListener<RespT> extends ClientCall.Listener<RespT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientCall.Listener<RespT> realListener;

        public DelayedListener(ClientCall.Listener<RespT> listener) {
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

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(final Metadata headers) {
            if (this.passThrough) {
                this.realListener.onHeaders(headers);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onHeaders(headers);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(final RespT message) {
            if (this.passThrough) {
                this.realListener.onMessage(message);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onMessage(message);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(final Status status, final Metadata trailers) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedListener.this.realListener.onClose(status, trailers);
                }
            });
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onReady();
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainPendingCallbacks() {
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