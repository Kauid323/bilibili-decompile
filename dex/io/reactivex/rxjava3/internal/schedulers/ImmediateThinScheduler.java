package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler INSTANCE = new ImmediateThinScheduler();
    static final Scheduler.Worker WORKER = new ImmediateThinWorker();
    static final Disposable DISPOSED = Disposable.CC.empty();

    static {
        DISPOSED.dispose();
    }

    private ImmediateThinScheduler() {
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable run) {
        run.run();
        return DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable run, long initialDelay, long period, TimeUnit unit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return WORKER;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ImmediateThinWorker extends Scheduler.Worker {
        ImmediateThinWorker() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable run) {
            run.run();
            return ImmediateThinScheduler.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable run, long delay, TimeUnit unit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedulePeriodically(Runnable run, long initialDelay, long period, TimeUnit unit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }
}