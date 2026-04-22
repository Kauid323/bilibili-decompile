package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.Optional;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapOptional<T, R> extends ParallelFlowable<R> {
    final Function<? super T, Optional<? extends R>> mapper;
    final ParallelFlowable<T> source;

    public ParallelMapOptional(ParallelFlowable<T> source, Function<? super T, Optional<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscribers) {
        if (!validate(subscribers)) {
            return;
        }
        int n = subscribers.length;
        Subscriber<? super T>[] parents = new Subscriber[n];
        for (int i = 0; i < n; i++) {
            Subscriber<? super R> a = subscribers[i];
            if (a instanceof ConditionalSubscriber) {
                parents[i] = new ParallelMapConditionalSubscriber((ConditionalSubscriber) a, this.mapper);
            } else {
                parents[i] = new ParallelMapSubscriber(a, this.mapper);
            }
        }
        this.source.subscribe(parents);
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ParallelMapSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final Function<? super T, Optional<? extends R>> mapper;
        Subscription upstream;

        ParallelMapSubscriber(Subscriber<? super R> actual, Function<? super T, Optional<? extends R>> mapper) {
            this.downstream = actual;
            this.mapper = mapper;
        }

        public void request(long n) {
            this.upstream.request(n);
        }

        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1L);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<? extends R> */
        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return true;
            }
            try {
                Optional optional = (Optional) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Optional");
                if (optional.isPresent()) {
                    this.downstream.onNext(optional.get());
                    return true;
                }
                return false;
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                cancel();
                onError(ex);
                return true;
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
            this.downstream.onComplete();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super R> downstream;
        final Function<? super T, Optional<? extends R>> mapper;
        Subscription upstream;

        ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> actual, Function<? super T, Optional<? extends R>> mapper) {
            this.downstream = actual;
            this.mapper = mapper;
        }

        public void request(long n) {
            this.upstream.request(n);
        }

        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1L);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<? extends R> */
        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                Optional optional = (Optional) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null value");
                return optional.isPresent() && this.downstream.tryOnNext((Object) optional.get());
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                cancel();
                onError(ex);
                return false;
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
            this.downstream.onComplete();
        }
    }
}