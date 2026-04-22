package io.grpc.internal;

import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
public final class Rescheduler {
    private boolean enabled;
    private long runAtNanos;
    private final Runnable runnable;
    private final ScheduledExecutorService scheduler;
    private final Executor serializingExecutor;
    private final Stopwatch stopwatch;
    private ScheduledFuture<?> wakeUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rescheduler(Runnable r, Executor serializingExecutor, ScheduledExecutorService scheduler, Stopwatch stopwatch) {
        this.runnable = r;
        this.serializingExecutor = serializingExecutor;
        this.scheduler = scheduler;
        this.stopwatch = stopwatch;
        stopwatch.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reschedule(long delay, TimeUnit timeUnit) {
        long delayNanos = timeUnit.toNanos(delay);
        long newRunAtNanos = nanoTime() + delayNanos;
        this.enabled = true;
        if (newRunAtNanos - this.runAtNanos < 0 || this.wakeUp == null) {
            if (this.wakeUp != null) {
                this.wakeUp.cancel(false);
            }
            this.wakeUp = this.scheduler.schedule(new FutureRunnable(), delayNanos, TimeUnit.NANOSECONDS);
        }
        this.runAtNanos = newRunAtNanos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel(boolean permanent) {
        this.enabled = false;
        if (permanent && this.wakeUp != null) {
            this.wakeUp.cancel(false);
            this.wakeUp = null;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class FutureRunnable implements Runnable {
        private FutureRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Rescheduler.this.serializingExecutor.execute(new ChannelFutureRunnable());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isEnabled() {
            return Rescheduler.this.enabled;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private final class ChannelFutureRunnable implements Runnable {
        private ChannelFutureRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!Rescheduler.this.enabled) {
                Rescheduler.this.wakeUp = null;
                return;
            }
            long now = Rescheduler.this.nanoTime();
            if (Rescheduler.this.runAtNanos - now <= 0) {
                Rescheduler.this.enabled = false;
                Rescheduler.this.wakeUp = null;
                Rescheduler.this.runnable.run();
                return;
            }
            Rescheduler.this.wakeUp = Rescheduler.this.scheduler.schedule(new FutureRunnable(), Rescheduler.this.runAtNanos - now, TimeUnit.NANOSECONDS);
        }
    }

    static boolean isEnabled(Runnable r) {
        return ((FutureRunnable) r).isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long nanoTime() {
        return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }
}