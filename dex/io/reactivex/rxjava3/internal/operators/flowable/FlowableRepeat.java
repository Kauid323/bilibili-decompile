package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {
    final long count;

    public FlowableRepeat(Flowable<T> source, long count) {
        super(source);
        this.count = count;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        SubscriptionArbiter sa = new SubscriptionArbiter(false);
        s.onSubscribe(sa);
        RepeatSubscriber<T> rs = new RepeatSubscriber<>(s, this.count != Long.MAX_VALUE ? this.count - 1 : Long.MAX_VALUE, sa, this.source);
        rs.subscribeNext();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> downstream;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final Publisher<? extends T> source;

        RepeatSubscriber(Subscriber<? super T> actual, long count, SubscriptionArbiter sa, Publisher<? extends T> source) {
            this.downstream = actual;
            this.sa = sa;
            this.source = source;
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
            this.downstream.onError(t);
        }

        public void onComplete() {
            long r = this.remaining;
            if (r != Long.MAX_VALUE) {
                this.remaining = r - 1;
            }
            if (r != 0) {
                subscribeNext();
            } else {
                this.downstream.onComplete();
            }
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