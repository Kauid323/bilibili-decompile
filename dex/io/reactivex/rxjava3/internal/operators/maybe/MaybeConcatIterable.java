package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import j$.util.Objects;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatIterable<T> extends Flowable<T> {
    final Iterable<? extends MaybeSource<? extends T>> sources;

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        try {
            Iterator<? extends MaybeSource<? extends T>> it = (Iterator) Objects.requireNonNull(this.sources.iterator(), "The sources Iterable returned a null Iterator");
            ConcatMaybeObserver<T> parent = new ConcatMaybeObserver<>(s, it);
            s.onSubscribe(parent);
            parent.drain();
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptySubscription.error(ex, s);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final Subscriber<? super T> downstream;
        long produced;
        final Iterator<? extends MaybeSource<? extends T>> sources;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable disposables = new SequentialDisposable();
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

        ConcatMaybeObserver(Subscriber<? super T> actual, Iterator<? extends MaybeSource<? extends T>> sources) {
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
            this.downstream.onError(e);
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
                        try {
                            boolean b = this.sources.hasNext();
                            if (b) {
                                try {
                                    MaybeSource<? extends T> source = (MaybeSource) Objects.requireNonNull(this.sources.next(), "The source Iterator returned a null MaybeSource");
                                    source.subscribe(this);
                                } catch (Throwable ex) {
                                    Exceptions.throwIfFatal(ex);
                                    a.onError(ex);
                                    return;
                                }
                            } else {
                                a.onComplete();
                            }
                        } catch (Throwable ex2) {
                            Exceptions.throwIfFatal(ex2);
                            a.onError(ex2);
                            return;
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