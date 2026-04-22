package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {
    static final FutureTask<Void> CANCELLED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    final ExecutorService executor;
    final AtomicReference<Future<?>> first = new AtomicReference<>();
    final AtomicReference<Future<?>> rest = new AtomicReference<>();
    Thread runner;
    final Runnable task;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstantPeriodicTask(Runnable task, ExecutorService executor) {
        this.task = task;
        this.executor = executor;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.runner = Thread.currentThread();
        try {
            this.task.run();
            this.runner = null;
            setRest(this.executor.submit(this));
            return null;
        } catch (Throwable ex) {
            this.runner = null;
            RxJavaPlugins.onError(ex);
            throw ex;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        Future<?> current = this.first.getAndSet(CANCELLED);
        if (current != null && current != CANCELLED) {
            current.cancel(this.runner != Thread.currentThread());
        }
        Future<?> current2 = this.rest.getAndSet(CANCELLED);
        if (current2 != null && current2 != CANCELLED) {
            current2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.first.get() == CANCELLED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFirst(Future<?> f) {
        Future<?> current;
        do {
            current = this.first.get();
            if (current == CANCELLED) {
                f.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.first, current, f));
    }

    void setRest(Future<?> f) {
        Future<?> current;
        do {
            current = this.rest.get();
            if (current == CANCELLED) {
                f.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.rest, current, f));
    }
}