package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;
    protected static final FutureTask<Void> FINISHED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    protected static final FutureTask<Void> DISPOSED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        Future<?> f = get();
        if (f != FINISHED && f != DISPOSED && compareAndSet(f, DISPOSED) && f != null) {
            f.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        Future<?> f = get();
        return f == FINISHED || f == DISPOSED;
    }

    public final void setFuture(Future<?> future) {
        Future<?> f;
        do {
            f = get();
            if (f != FINISHED) {
                if (f == DISPOSED) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(f, future));
    }

    @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
    public Runnable getWrappedRunnable() {
        return this.runnable;
    }
}