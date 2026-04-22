package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler scheduler;

    public FlowableUnsubscribeOn(Flowable<T> source, Scheduler scheduler) {
        super(source);
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new UnsubscribeSubscriber(s, this.scheduler));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;
        final Subscriber<? super T> downstream;
        final Scheduler scheduler;
        Subscription upstream;

        UnsubscribeSubscriber(Subscriber<? super T> actual, Scheduler scheduler) {
            this.downstream = actual;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        public void onError(Throwable t) {
            if (get()) {
                RxJavaPlugins.onError(t);
            } else {
                this.downstream.onError(t);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void request(long n) {
            this.upstream.request(n);
        }

        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.scheduleDirect(new Cancellation());
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class Cancellation implements Runnable {
            Cancellation() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeSubscriber.this.upstream.cancel();
            }
        }
    }
}