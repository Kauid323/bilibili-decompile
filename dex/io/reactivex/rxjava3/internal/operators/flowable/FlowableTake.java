package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
    final long n;

    public FlowableTake(Flowable<T> source, long n) {
        super(source);
        this.n = n;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new TakeSubscriber(s, this.n));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TakeSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;
        final Subscriber<? super T> downstream;
        long remaining;
        Subscription upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TakeSubscriber(Subscriber<? super T> actual, long remaining) {
            this.downstream = actual;
            this.remaining = remaining;
            lazySet(remaining);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                if (this.remaining == 0) {
                    s.cancel();
                    EmptySubscription.complete(this.downstream);
                    return;
                }
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            long r = this.remaining;
            if (r > 0) {
                long r2 = r - 1;
                this.remaining = r2;
                this.downstream.onNext(t);
                if (r2 == 0) {
                    this.upstream.cancel();
                    this.downstream.onComplete();
                }
            }
        }

        public void onError(Throwable t) {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.downstream.onError(t);
                return;
            }
            RxJavaPlugins.onError(t);
        }

        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.downstream.onComplete();
            }
        }

        public void request(long n) {
            long r;
            long toRequest;
            long u;
            if (SubscriptionHelper.validate(n)) {
                do {
                    r = get();
                    if (r != 0) {
                        toRequest = Math.min(r, n);
                        u = r - toRequest;
                    } else {
                        return;
                    }
                } while (!compareAndSet(r, u));
                this.upstream.request(toRequest);
            }
        }

        public void cancel() {
            this.upstream.cancel();
        }
    }
}