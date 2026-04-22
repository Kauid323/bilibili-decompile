package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer extends Maybe<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public MaybeTimer(long delay, TimeUnit unit, Scheduler scheduler) {
        this.delay = delay;
        this.unit = unit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(final MaybeObserver<? super Long> observer) {
        TimerDisposable parent = new TimerDisposable(observer);
        observer.onSubscribe(parent);
        parent.setFuture(this.scheduler.scheduleDirect(parent, this.delay, this.unit));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final MaybeObserver<? super Long> downstream;

        TimerDisposable(final MaybeObserver<? super Long> downstream) {
            this.downstream = downstream;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onSuccess(0L);
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