package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer extends Completable {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public CompletableTimer(long delay, TimeUnit unit, Scheduler scheduler) {
        this.delay = delay;
        this.unit = unit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(final CompletableObserver observer) {
        TimerDisposable parent = new TimerDisposable(observer);
        observer.onSubscribe(parent);
        parent.setFuture(this.scheduler.scheduleDirect(parent, this.delay, this.unit));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final CompletableObserver downstream;

        TimerDisposable(final CompletableObserver downstream) {
            this.downstream = downstream;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        void setFuture(Disposable d) {
            DisposableHelper.replace(this, d);
        }
    }
}