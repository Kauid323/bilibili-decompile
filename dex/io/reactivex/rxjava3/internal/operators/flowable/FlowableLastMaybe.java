package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastMaybe<T> extends Maybe<T> {
    final Publisher<T> source;

    public FlowableLastMaybe(Publisher<T> source) {
        this.source = source;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new LastSubscriber(observer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        T item;
        Subscription upstream;

        LastSubscriber(MaybeObserver<? super T> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
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
            this.item = t;
        }

        public void onError(Throwable t) {
            this.upstream = SubscriptionHelper.CANCELLED;
            this.item = null;
            this.downstream.onError(t);
        }

        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            T v = this.item;
            if (v != null) {
                this.item = null;
                this.downstream.onSuccess(v);
                return;
            }
            this.downstream.onComplete();
        }
    }
}