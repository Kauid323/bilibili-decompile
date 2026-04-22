package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilter<T> extends ParallelFlowable<T> {
    final Predicate<? super T> predicate;
    final ParallelFlowable<T> source;

    public ParallelFilter(ParallelFlowable<T> source, Predicate<? super T> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscribers) {
        if (!validate(subscribers)) {
            return;
        }
        int n = subscribers.length;
        Subscriber<? super T>[] parents = new Subscriber[n];
        for (int i = 0; i < n; i++) {
            Subscriber<? super T> a = subscribers[i];
            if (a instanceof ConditionalSubscriber) {
                parents[i] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) a, this.predicate);
            } else {
                parents[i] = new ParallelFilterSubscriber(a, this.predicate);
            }
        }
        this.source.subscribe(parents);
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Predicate<? super T> predicate;
        Subscription upstream;

        BaseFilterSubscriber(Predicate<? super T> predicate) {
            this.predicate = predicate;
        }

        public final void request(long n) {
            this.upstream.request(n);
        }

        public final void cancel() {
            this.upstream.cancel();
        }

        public final void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.upstream.request(1L);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final Subscriber<? super T> downstream;

        ParallelFilterSubscriber(Subscriber<? super T> actual, Predicate<? super T> predicate) {
            super(predicate);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (!this.done) {
                try {
                    boolean b = this.predicate.test(t);
                    if (b) {
                        this.downstream.onNext(t);
                        return true;
                    }
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    cancel();
                    onError(ex);
                    return false;
                }
            }
            return false;
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
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> downstream;

        ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> actual, Predicate<? super T> predicate) {
            super(predicate);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (!this.done) {
                try {
                    boolean b = this.predicate.test(t);
                    if (b) {
                        return this.downstream.tryOnNext(t);
                    }
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    cancel();
                    onError(ex);
                    return false;
                }
            }
            return false;
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
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }
    }
}