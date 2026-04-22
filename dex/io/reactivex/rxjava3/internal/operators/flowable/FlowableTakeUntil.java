package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends U> other;

    public FlowableTakeUntil(Flowable<T> source, Publisher<? extends U> other) {
        super(source);
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> child) {
        TakeUntilMainSubscriber<T> parent = new TakeUntilMainSubscriber<>(child);
        child.onSubscribe(parent);
        this.other.subscribe(parent.other);
        this.source.subscribe((FlowableSubscriber) parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4945480365982832967L;
        final Subscriber<? super T> downstream;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicThrowable error = new AtomicThrowable();

        TakeUntilMainSubscriber(Subscriber<? super T> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, s);
        }

        public void onNext(T t) {
            HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        public void onError(Throwable t) {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onError(this.downstream, t, this, this.error);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        public void request(long n) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, n);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber
            public void onSubscribe(Subscription s) {
                SubscriptionHelper.setOnce(this, s, Long.MAX_VALUE);
            }

            public void onNext(Object t) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            public void onError(Throwable t) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                HalfSerializer.onError(TakeUntilMainSubscriber.this.downstream, t, TakeUntilMainSubscriber.this, TakeUntilMainSubscriber.this.error);
            }

            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                HalfSerializer.onComplete(TakeUntilMainSubscriber.this.downstream, TakeUntilMainSubscriber.this, TakeUntilMainSubscriber.this.error);
            }
        }
    }
}