package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import j$.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Throwable>, ? extends Publisher<?>> handler;

    public FlowableRetryWhen(Flowable<T> source, Function<? super Flowable<Throwable>, ? extends Publisher<?>> handler) {
        super(source);
        this.handler = handler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        SerializedSubscriber<T> z = new SerializedSubscriber<>(s);
        FlowableProcessor<T> serialized = UnicastProcessor.create(8).toSerialized();
        try {
            Publisher<?> when = (Publisher) Objects.requireNonNull(this.handler.apply(serialized), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver<T, Throwable> receiver = new FlowableRepeatWhen.WhenReceiver<>(this.source);
            RetryWhenSubscriber<T> subscriber = new RetryWhenSubscriber<>(z, serialized, receiver);
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
    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(Subscriber<? super T> actual, FlowableProcessor<Throwable> processor, Subscription receiver) {
            super(actual, processor, receiver);
        }

        public void onError(Throwable t) {
            again(t);
        }

        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }
    }
}