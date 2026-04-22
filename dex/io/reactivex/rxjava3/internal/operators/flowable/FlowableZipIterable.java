package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
    final Iterable<U> other;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public FlowableZipIterable(Flowable<T> source, Iterable<U> other, BiFunction<? super T, ? super U, ? extends V> zipper) {
        super(source);
        this.other = other;
        this.zipper = zipper;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super V> t) {
        try {
            Iterator<U> it = (Iterator) Objects.requireNonNull(this.other.iterator(), "The iterator returned by other is null");
            try {
                boolean b = it.hasNext();
                if (!b) {
                    EmptySubscription.complete(t);
                } else {
                    this.source.subscribe((FlowableSubscriber) new ZipIterableSubscriber(t, it, this.zipper));
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                EmptySubscription.error(e, t);
            }
        } catch (Throwable e2) {
            Exceptions.throwIfFatal(e2);
            EmptySubscription.error(e2, t);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super V> downstream;
        final Iterator<U> iterator;
        Subscription upstream;
        final BiFunction<? super T, ? super U, ? extends V> zipper;

        ZipIterableSubscriber(Subscriber<? super V> actual, Iterator<U> iterator, BiFunction<? super T, ? super U, ? extends V> zipper) {
            this.downstream = actual;
            this.iterator = iterator;
            this.zipper = zipper;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                try {
                    this.downstream.onNext(Objects.requireNonNull(this.zipper.apply(t, Objects.requireNonNull(this.iterator.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        boolean b = this.iterator.hasNext();
                        if (!b) {
                            this.done = true;
                            this.upstream.cancel();
                            this.downstream.onComplete();
                        }
                    } catch (Throwable e) {
                        fail(e);
                    }
                } catch (Throwable e2) {
                    fail(e2);
                }
            } catch (Throwable e3) {
                fail(e3);
            }
        }

        void fail(Throwable e) {
            Exceptions.throwIfFatal(e);
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(e);
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.downstream.onError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        public void request(long n) {
            this.upstream.request(n);
        }

        public void cancel() {
            this.upstream.cancel();
        }
    }
}