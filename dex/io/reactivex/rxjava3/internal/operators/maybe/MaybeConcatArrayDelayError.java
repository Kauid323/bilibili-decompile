package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        ConcatMaybeObserver<T> parent = new ConcatMaybeObserver<>(s, this.sources);
        s.onSubscribe(parent);
        parent.drain();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final Subscriber<? super T> downstream;
        int index;
        long produced;
        final MaybeSource<? extends T>[] sources;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable disposables = new SequentialDisposable();
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);
        final AtomicThrowable errors = new AtomicThrowable();

        ConcatMaybeObserver(Subscriber<? super T> actual, MaybeSource<? extends T>[] sources) {
            this.downstream = actual;
            this.sources = sources;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            this.disposables.dispose();
            this.errors.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.disposables.replace(d);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            this.current.lazySet(value);
            drain();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.current.lazySet(NotificationLite.COMPLETE);
            if (this.errors.tryAddThrowableOrReport(e)) {
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        void drain() {
            boolean goNextSource;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> c = this.current;
            Subscriber<? super T> a = this.downstream;
            Disposable cancelled = this.disposables;
            while (!cancelled.isDisposed()) {
                Object o = c.get();
                if (o != null) {
                    if (o != NotificationLite.COMPLETE) {
                        long p = this.produced;
                        if (p != this.requested.get()) {
                            this.produced = 1 + p;
                            c.lazySet(null);
                            goNextSource = true;
                            a.onNext(o);
                        } else {
                            goNextSource = false;
                        }
                    } else {
                        c.lazySet(null);
                        goNextSource = true;
                    }
                    if (goNextSource && !cancelled.isDisposed()) {
                        int i = this.index;
                        if (i == this.sources.length) {
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        } else {
                            this.index = i + 1;
                            this.sources[i].subscribe(this);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            c.lazySet(null);
        }
    }
}