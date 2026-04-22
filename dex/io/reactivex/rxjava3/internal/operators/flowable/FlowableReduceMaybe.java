package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {
    final BiFunction<T, T, T> reducer;
    final Flowable<T> source;

    public FlowableReduceMaybe(Flowable<T> source, BiFunction<T, T, T> reducer) {
        this.source = source;
        this.reducer = reducer;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableReduce(this.source, this.reducer));
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe((FlowableSubscriber) new ReduceSubscriber(observer, this.reducer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        boolean done;
        final MaybeObserver<? super T> downstream;
        final BiFunction<T, T, T> reducer;
        Subscription upstream;
        T value;

        ReduceSubscriber(MaybeObserver<? super T> actual, BiFunction<T, T, T> reducer) {
            this.downstream = actual;
            this.reducer = reducer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.done;
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
            T v = this.value;
            if (v == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) Objects.requireNonNull(this.reducer.apply(v, t), "The reducer returned a null value");
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
            this.downstream.onError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T v = this.value;
            if (v != null) {
                this.downstream.onSuccess(v);
            } else {
                this.downstream.onComplete();
            }
        }
    }
}