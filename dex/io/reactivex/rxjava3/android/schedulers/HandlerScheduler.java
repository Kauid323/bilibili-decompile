package io.reactivex.rxjava3.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
public final class HandlerScheduler extends Scheduler {
    private final boolean async;
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduler(Handler handler, boolean async) {
        this.handler = handler;
        this.async = async;
    }

    public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
        if (run == null) {
            throw new NullPointerException("run == null");
        }
        if (unit == null) {
            throw new NullPointerException("unit == null");
        }
        ScheduledRunnable scheduled = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(run));
        Message message = Message.obtain(this.handler, scheduled);
        if (this.async) {
            message.setAsynchronous(true);
        }
        this.handler.sendMessageDelayed(message, unit.toMillis(delay));
        return scheduled;
    }

    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }

    /* loaded from: /data/np/file-convert/20260223060940f7e941c2-05a4-41f3-b15b-150477b09f88/20260223060940f7e941c2-05a4-41f3-b15b-150477b09f88.dex */
    private static final class HandlerWorker extends Scheduler.Worker {
        private final boolean async;
        private volatile boolean disposed;
        private final Handler handler;

        HandlerWorker(Handler handler, boolean async) {
            this.handler = handler;
            this.async = async;
        }

        public Disposable schedule(Runnable run, long delay, TimeUnit unit) {
            if (run == null) {
                throw new NullPointerException("run == null");
            }
            if (unit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.disposed) {
                return Disposable.-CC.disposed();
            }
            ScheduledRunnable scheduled = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(run));
            Message message = Message.obtain(this.handler, scheduled);
            message.obj = this;
            if (this.async) {
                message.setAsynchronous(true);
            }
            this.handler.sendMessageDelayed(message, unit.toMillis(delay));
            if (this.disposed) {
                this.handler.removeCallbacks(scheduled);
                return Disposable.-CC.disposed();
            }
            return scheduled;
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* loaded from: /data/np/file-convert/20260223060940f7e941c2-05a4-41f3-b15b-150477b09f88/20260223060940f7e941c2-05a4-41f3-b15b-150477b09f88.dex */
    private static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        ScheduledRunnable(Handler handler, Runnable delegate) {
            this.handler = handler;
            this.delegate = delegate;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable t) {
                RxJavaPlugins.onError(t);
            }
        }

        public void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }
}