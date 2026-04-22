package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableDetach(Flowable<T> source) {
        super(source);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new DetachSubscriber(s));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscriber<? super T> downstream;
        Subscription upstream;

        DetachSubscriber(Subscriber<? super T> downstream) {
            this.downstream = downstream;
        }

        public void request(long n) {
            this.upstream.request(n);
        }

        public void cancel() {
            Subscription s = this.upstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asSubscriber();
            s.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable t) {
            Subscriber<? super T> a = this.downstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asSubscriber();
            a.onError(t);
        }

        public void onComplete() {
            Subscriber<? super T> a = this.downstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asSubscriber();
            a.onComplete();
        }
    }
}