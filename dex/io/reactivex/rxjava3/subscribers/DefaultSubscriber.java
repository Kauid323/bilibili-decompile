package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    Subscription upstream;

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public final void onSubscribe(Subscription s) {
        if (EndConsumerHelper.validate(this.upstream, s, getClass())) {
            this.upstream = s;
            onStart();
        }
    }

    protected final void request(long n) {
        Subscription s = this.upstream;
        if (s != null) {
            s.request(n);
        }
    }

    protected final void cancel() {
        Subscription s = this.upstream;
        this.upstream = SubscriptionHelper.CANCELLED;
        s.cancel();
    }

    protected void onStart() {
        request(Long.MAX_VALUE);
    }
}