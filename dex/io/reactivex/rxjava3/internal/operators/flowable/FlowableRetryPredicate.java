package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final long count;
    final Predicate<? super Throwable> predicate;

    public FlowableRetryPredicate(Flowable<T> source, long count, Predicate<? super Throwable> predicate) {
        super(source);
        this.predicate = predicate;
        this.count = count;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        SubscriptionArbiter sa = new SubscriptionArbiter(false);
        s.onSubscribe(sa);
        RetrySubscriber<T> rs = new RetrySubscriber<>(s, this.count, this.predicate, sa, this.source);
        rs.subscribeNext();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> downstream;
        final Predicate<? super Throwable> predicate;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final Publisher<? extends T> source;

        RetrySubscriber(Subscriber<? super T> actual, long count, Predicate<? super Throwable> predicate, SubscriptionArbiter sa, Publisher<? extends T> source) {
            this.downstream = actual;
            this.sa = sa;
            this.source = source;
            this.predicate = predicate;
            this.remaining = count;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            this.sa.setSubscription(s);
        }

        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        public void onError(Throwable t) {
            long r = this.remaining;
            if (r != Long.MAX_VALUE) {
                this.remaining = r - 1;
            }
            if (r == 0) {
                this.downstream.onError(t);
                return;
            }
            try {
                boolean b = this.predicate.test(t);
                if (!b) {
                    this.downstream.onError(t);
                } else {
                    subscribeNext();
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
            }
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                while (!this.sa.isCancelled()) {
                    long p = this.produced;
                    if (p != 0) {
                        this.produced = 0L;
                        this.sa.produced(p);
                    }
                    this.source.subscribe(this);
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }
}