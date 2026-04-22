package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.Collection;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Supplier<? extends Collection<? super K>> collectionSupplier;
    final Function<? super T, K> keySelector;

    public FlowableDistinct(Flowable<T> source, Function<? super T, K> keySelector, Supplier<? extends Collection<? super K>> collectionSupplier) {
        super(source);
        this.keySelector = keySelector;
        this.collectionSupplier = collectionSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Collection<? super K> collection = (Collection) ExceptionHelper.nullCheck(this.collectionSupplier.get(), "The collectionSupplier returned a null Collection.");
            this.source.subscribe((FlowableSubscriber) new DistinctSubscriber(subscriber, this.keySelector, collection));
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptySubscription.error(ex, subscriber);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {
        final Collection<? super K> collection;
        final Function<? super T, K> keySelector;

        DistinctSubscriber(Subscriber<? super T> actual, Function<? super T, K> keySelector, Collection<? super K> collection) {
            super(actual);
            this.keySelector = keySelector;
            this.collection = collection;
        }

        public void onNext(T value) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 0) {
                try {
                    boolean b = this.collection.add(Objects.requireNonNull(this.keySelector.apply(value), "The keySelector returned a null key"));
                    if (b) {
                        this.downstream.onNext(value);
                        return;
                    } else {
                        this.upstream.request(1L);
                        return;
                    }
                } catch (Throwable ex) {
                    fail(ex);
                    return;
                }
            }
            this.downstream.onNext((Object) null);
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaPlugins.onError(e);
                return;
            }
            this.done = true;
            this.collection.clear();
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.collection.clear();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            T v;
            while (true) {
                v = this.qs.poll();
                if (v == null || this.collection.add((Object) Objects.requireNonNull(this.keySelector.apply(v), "The keySelector returned a null key"))) {
                    break;
                } else if (this.sourceMode == 2) {
                    this.upstream.request(1L);
                }
            }
            return v;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.collection.clear();
            super.clear();
        }
    }
}