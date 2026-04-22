package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableTakeLastOne(Flowable<T> source) {
        super(source);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new TakeLastOneSubscriber(s));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5467847744262967226L;
        Subscription upstream;

        TakeLastOneSubscriber(Subscriber<? super T> downstream) {
            super(downstream);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            this.value = t;
        }

        public void onError(Throwable t) {
            this.value = null;
            this.downstream.onError(t);
        }

        public void onComplete() {
            T v = this.value;
            if (v != null) {
                complete(v);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}