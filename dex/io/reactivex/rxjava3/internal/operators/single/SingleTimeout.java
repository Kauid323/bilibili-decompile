package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout<T> extends Single<T> {
    final SingleSource<? extends T> other;
    final Scheduler scheduler;
    final SingleSource<T> source;
    final long timeout;
    final TimeUnit unit;

    public SingleTimeout(SingleSource<T> source, long timeout, TimeUnit unit, Scheduler scheduler, SingleSource<? extends T> other) {
        this.source = source;
        this.timeout = timeout;
        this.unit = unit;
        this.scheduler = scheduler;
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super T> observer) {
        TimeoutMainObserver<T> parent = new TimeoutMainObserver<>(observer, this.other, this.timeout, this.unit);
        observer.onSubscribe(parent);
        DisposableHelper.replace(parent.task, this.scheduler.scheduleDirect(parent, this.timeout, this.unit));
        this.source.subscribe(parent);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long serialVersionUID = 37497744973048446L;
        final SingleObserver<? super T> downstream;
        final TimeoutFallbackObserver<T> fallback;
        SingleSource<? extends T> other;
        final AtomicReference<Disposable> task = new AtomicReference<>();
        final long timeout;
        final TimeUnit unit;

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final SingleObserver<? super T> downstream;

            TimeoutFallbackObserver(SingleObserver<? super T> downstream) {
                this.downstream = downstream;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(T t) {
                this.downstream.onSuccess(t);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                this.downstream.onError(e);
            }
        }

        TimeoutMainObserver(SingleObserver<? super T> actual, SingleSource<? extends T> other, long timeout, TimeUnit unit) {
            this.downstream = actual;
            this.other = other;
            this.timeout = timeout;
            this.unit = unit;
            if (other != null) {
                this.fallback = new TimeoutFallbackObserver<>(actual);
            } else {
                this.fallback = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable d = get();
            if (d != DisposableHelper.DISPOSED && compareAndSet(d, DisposableHelper.DISPOSED)) {
                if (d != null) {
                    d.dispose();
                }
                SingleSource<? extends T> other = this.other;
                if (other == null) {
                    this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.timeout, this.unit)));
                    return;
                }
                this.other = null;
                other.subscribe(this.fallback);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this, d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            Disposable d = get();
            if (d != DisposableHelper.DISPOSED && compareAndSet(d, DisposableHelper.DISPOSED)) {
                DisposableHelper.dispose(this.task);
                this.downstream.onSuccess(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            Disposable d = get();
            if (d != DisposableHelper.DISPOSED && compareAndSet(d, DisposableHelper.DISPOSED)) {
                DisposableHelper.dispose(this.task);
                this.downstream.onError(e);
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            if (this.fallback != null) {
                DisposableHelper.dispose(this.fallback);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}