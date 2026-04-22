package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;

    public FlowableOnErrorNext(Flowable<T> source, Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier) {
        super(source);
        this.nextSupplier = nextSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        OnErrorNextSubscriber<T> parent = new OnErrorNextSubscriber<>(s, this.nextSupplier);
        s.onSubscribe(parent);
        this.source.subscribe((FlowableSubscriber) parent);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        boolean done;
        final Subscriber<? super T> downstream;
        final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
        boolean once;
        long produced;

        OnErrorNextSubscriber(Subscriber<? super T> actual, Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier) {
            super(false);
            this.downstream = actual;
            this.nextSupplier = nextSupplier;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            setSubscription(s);
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (!this.once) {
                this.produced++;
            }
            this.downstream.onNext(t);
        }

        public void onError(Throwable t) {
            if (this.once) {
                if (this.done) {
                    RxJavaPlugins.onError(t);
                    return;
                } else {
                    this.downstream.onError(t);
                    return;
                }
            }
            this.once = true;
            try {
                Publisher<? extends T> p = (Publisher) Objects.requireNonNull(this.nextSupplier.apply(t), "The nextSupplier returned a null Publisher");
                long mainProduced = this.produced;
                if (mainProduced != 0) {
                    produced(mainProduced);
                }
                p.subscribe(this);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
            }
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }
    }
}