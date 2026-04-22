package io.grpc;

import androidx.compose.animation.core.MutatorMutex$;
import com.google.common.base.Preconditions;
import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SynchronizationContext implements Executor {
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final Queue<Runnable> queue = new ConcurrentLinkedQueue();
    private final AtomicReference<Thread> drainingThread = new AtomicReference<>();

    public SynchronizationContext(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void drain() {
        while (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.drainingThread, (Object) null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = this.queue.poll();
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        this.drainingThread.set(null);
                        if (this.queue.isEmpty()) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    this.drainingThread.set(null);
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void executeLater(Runnable runnable) {
        this.queue.add(Preconditions.checkNotNull(runnable, "runnable is null"));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable task) {
        executeLater(task);
        drain();
    }

    public void throwIfNotInThisSynchronizationContext() {
        Preconditions.checkState(Thread.currentThread() == this.drainingThread.get(), "Not called from the SynchronizationContext");
    }

    public final ScheduledHandle schedule(final Runnable task, long delay, TimeUnit unit, ScheduledExecutorService timerService) {
        final ManagedRunnable runnable = new ManagedRunnable(task);
        ScheduledFuture<?> future = timerService.schedule(new Runnable() { // from class: io.grpc.SynchronizationContext.1
            @Override // java.lang.Runnable
            public void run() {
                SynchronizationContext.this.execute(runnable);
            }

            public String toString() {
                return task.toString() + "(scheduled in SynchronizationContext)";
            }
        }, delay, unit);
        return new ScheduledHandle(runnable, future);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class ManagedRunnable implements Runnable {
        boolean hasStarted;
        boolean isCancelled;
        final Runnable task;

        ManagedRunnable(Runnable task) {
            this.task = (Runnable) Preconditions.checkNotNull(task, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.isCancelled) {
                this.hasStarted = true;
                this.task.run();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ScheduledHandle {
        private final ScheduledFuture<?> future;
        private final ManagedRunnable runnable;

        private ScheduledHandle(ManagedRunnable runnable, ScheduledFuture<?> future) {
            this.runnable = (ManagedRunnable) Preconditions.checkNotNull(runnable, "runnable");
            this.future = (ScheduledFuture) Preconditions.checkNotNull(future, "future");
        }

        public void cancel() {
            this.runnable.isCancelled = true;
            this.future.cancel(false);
        }

        public boolean isPending() {
            return (this.runnable.hasStarted || this.runnable.isCancelled) ? false : true;
        }
    }
}