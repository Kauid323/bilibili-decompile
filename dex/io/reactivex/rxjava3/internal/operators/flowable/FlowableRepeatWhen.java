package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Object>, ? extends Publisher<?>> handler;

    public FlowableRepeatWhen(Flowable<T> source, Function<? super Flowable<Object>, ? extends Publisher<?>> handler) {
        super(source);
        this.handler = handler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        SerializedSubscriber<T> z = new SerializedSubscriber<>(s);
        FlowableProcessor<Object> processor = UnicastProcessor.create(8).toSerialized();
        try {
            Publisher<?> when = (Publisher) Objects.requireNonNull(this.handler.apply(processor), "handler returned a null Publisher");
            WhenReceiver<T, Object> receiver = new WhenReceiver<>(this.source);
            RepeatWhenSubscriber<T> subscriber = new RepeatWhenSubscriber<>(z, processor, receiver);
            receiver.subscriber = subscriber;
            s.onSubscribe(subscriber);
            when.subscribe(receiver);
            receiver.onNext(0);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptySubscription.error(ex, s);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;
        final Publisher<T> source;
        WhenSourceSubscriber<T, U> subscriber;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        public WhenReceiver(Publisher<T> source) {
            this.source = source;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, s);
        }

        public void onNext(Object t) {
            if (getAndIncrement() == 0) {
                while (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void onError(Throwable t) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(t);
        }

        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        public void request(long n) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, n);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final Subscriber<? super T> downstream;
        protected final FlowableProcessor<U> processor;
        private long produced;
        protected final Subscription receiver;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WhenSourceSubscriber(Subscriber<? super T> actual, FlowableProcessor<U> processor, Subscription receiver) {
            super(false);
            this.downstream = actual;
            this.processor = processor;
            this.receiver = receiver;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public final void onSubscribe(Subscription s) {
            setSubscription(s);
        }

        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void again(U signal) {
            setSubscription(EmptySubscription.INSTANCE);
            long p = this.produced;
            if (p != 0) {
                this.produced = 0L;
                produced(p);
            }
            this.receiver.request(1L);
            this.processor.onNext(signal);
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        RepeatWhenSubscriber(Subscriber<? super T> actual, FlowableProcessor<Object> processor, Subscription receiver) {
            super(actual, processor, receiver);
        }

        public void onError(Throwable t) {
            this.receiver.cancel();
            this.downstream.onError(t);
        }

        public void onComplete() {
            again(0);
        }
    }
}