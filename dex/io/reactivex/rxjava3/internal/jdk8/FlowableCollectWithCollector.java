package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Collector;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollectWithCollector<T, A, R> extends Flowable<R> {
    final Collector<T, A, R> collector;
    final Flowable<T> source;

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<T, A, R> */
    public FlowableCollectWithCollector(Flowable<T> source, Collector<T, A, R> collector) {
        this.source = source;
        this.collector = collector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        try {
            Object obj = this.collector.supplier().get();
            BiConsumer<A, T> accumulator = this.collector.accumulator();
            Function<A, R> finisher = this.collector.finisher();
            this.source.subscribe((FlowableSubscriber) new CollectorSubscriber(s, obj, accumulator, finisher));
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptySubscription.error(ex, s);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class CollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -229544830565448758L;
        final BiConsumer<A, T> accumulator;
        A container;
        boolean done;
        final Function<A, R> finisher;
        Subscription upstream;

        CollectorSubscriber(Subscriber<? super R> downstream, A container, BiConsumer<A, T> accumulator, Function<A, R> finisher) {
            super(downstream);
            this.container = container;
            this.accumulator = accumulator;
            this.finisher = finisher;
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
            if (this.done) {
                return;
            }
            try {
                this.accumulator.accept(this.container, t);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.cancel();
                onError(ex);
            }
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.container = null;
            this.downstream.onError(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            A container = this.container;
            this.container = null;
            try {
                complete(Objects.requireNonNull(this.finisher.apply(container), "The finisher returned a null value"));
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}