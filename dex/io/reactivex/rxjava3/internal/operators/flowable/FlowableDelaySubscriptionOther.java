package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
    final Publisher<? extends T> main;
    final Publisher<U> other;

    public FlowableDelaySubscriptionOther(Publisher<? extends T> main, Publisher<U> other) {
        this.main = main;
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(final Subscriber<? super T> child) {
        MainSubscriber<T> parent = new MainSubscriber<>(child, this.main);
        child.onSubscribe(parent);
        this.other.subscribe(parent.other);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2259811067697317255L;
        final Subscriber<? super T> downstream;
        final Publisher<? extends T> main;
        final MainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        MainSubscriber(Subscriber<? super T> downstream, Publisher<? extends T> main) {
            this.downstream = downstream;
            this.main = main;
        }

        void next() {
            this.main.subscribe(this);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable t) {
            this.downstream.onError(t);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                SubscriptionHelper.deferredRequest(this.upstream, this, n);
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this, s);
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3892798459447644106L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber
            public void onSubscribe(Subscription s) {
                if (SubscriptionHelper.setOnce(this, s)) {
                    s.request(Long.MAX_VALUE);
                }
            }

            public void onNext(Object t) {
                Subscription s = get();
                if (s != SubscriptionHelper.CANCELLED) {
                    lazySet(SubscriptionHelper.CANCELLED);
                    s.cancel();
                    MainSubscriber.this.next();
                }
            }

            public void onError(Throwable t) {
                Subscription s = get();
                if (s != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.downstream.onError(t);
                } else {
                    RxJavaPlugins.onError(t);
                }
            }

            public void onComplete() {
                Subscription s = get();
                if (s != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.next();
                }
            }
        }
    }
}