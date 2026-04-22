package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends Single<T> {
    final Scheduler scheduler;
    final SingleSource<T> source;

    public SingleObserveOn(SingleSource<T> source, Scheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super T> observer) {
        this.source.subscribe(new ObserveOnSingleObserver(observer, this.scheduler));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final SingleObserver<? super T> downstream;
        Throwable error;
        final Scheduler scheduler;
        T value;

        ObserveOnSingleObserver(SingleObserver<? super T> actual, Scheduler scheduler) {
            this.downstream = actual;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            this.value = value;
            Disposable d = this.scheduler.scheduleDirect(this);
            DisposableHelper.replace(this, d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.error = e;
            Disposable d = this.scheduler.scheduleDirect(this);
            DisposableHelper.replace(this, d);
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable ex = this.error;
            if (ex != null) {
                this.downstream.onError(ex);
            } else {
                this.downstream.onSuccess((T) this.value);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}