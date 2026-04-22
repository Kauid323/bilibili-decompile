package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUsing<T, D> extends Flowable<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Supplier<? extends D> resourceSupplier;
    final Function<? super D, ? extends Publisher<? extends T>> sourceSupplier;

    public FlowableUsing(Supplier<? extends D> resourceSupplier, Function<? super D, ? extends Publisher<? extends T>> sourceSupplier, Consumer<? super D> disposer, boolean eager) {
        this.resourceSupplier = resourceSupplier;
        this.sourceSupplier = sourceSupplier;
        this.disposer = disposer;
        this.eager = eager;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        try {
            D resource = this.resourceSupplier.get();
            try {
                Publisher<? extends T> source = (Publisher) Objects.requireNonNull(this.sourceSupplier.apply(resource), "The sourceSupplier returned a null Publisher");
                UsingSubscriber<T, D> us = new UsingSubscriber<>(s, resource, this.disposer, this.eager);
                source.subscribe(us);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                try {
                    this.disposer.accept(resource);
                    EmptySubscription.error(e, s);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    EmptySubscription.error(new CompositeException(e, ex), s);
                }
            }
        } catch (Throwable e2) {
            Exceptions.throwIfFatal(e2);
            EmptySubscription.error(e2, s);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;
        final Consumer<? super D> disposer;
        final Subscriber<? super T> downstream;
        final boolean eager;
        final D resource;
        Subscription upstream;

        UsingSubscriber(Subscriber<? super T> actual, D resource, Consumer<? super D> disposer, boolean eager) {
            this.downstream = actual;
            this.resource = resource;
            this.disposer = disposer;
            this.eager = eager;
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
            if (this.eager) {
                Throwable innerError = null;
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable e) {
                        Exceptions.throwIfFatal(e);
                        innerError = e;
                    }
                }
                this.upstream.cancel();
                if (innerError != null) {
                    this.downstream.onError(new CompositeException(t, innerError));
                    return;
                } else {
                    this.downstream.onError(t);
                    return;
                }
            }
            this.downstream.onError(t);
            this.upstream.cancel();
            disposeResource();
        }

        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable e) {
                        Exceptions.throwIfFatal(e);
                        this.downstream.onError(e);
                        return;
                    }
                }
                this.upstream.cancel();
                this.downstream.onComplete();
                return;
            }
            this.downstream.onComplete();
            this.upstream.cancel();
            disposeResource();
        }

        public void request(long n) {
            this.upstream.request(n);
        }

        public void cancel() {
            if (this.eager) {
                disposeResource();
                this.upstream.cancel();
                this.upstream = SubscriptionHelper.CANCELLED;
                return;
            }
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            disposeResource();
        }

        void disposeResource() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    RxJavaPlugins.onError(e);
                }
            }
        }
    }
}