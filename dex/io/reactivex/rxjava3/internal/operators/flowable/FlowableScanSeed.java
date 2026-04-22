package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Supplier<R> seedSupplier;

    public FlowableScanSeed(Flowable<T> source, Supplier<R> seedSupplier, BiFunction<R, ? super T, R> accumulator) {
        super(source);
        this.accumulator = accumulator;
        this.seedSupplier = seedSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        try {
            this.source.subscribe((FlowableSubscriber) new ScanSeedSubscriber(s, this.accumulator, Objects.requireNonNull(this.seedSupplier.get(), "The seed supplied is null"), bufferSize()));
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            EmptySubscription.error(e, s);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;
        final BiFunction<R, ? super T, R> accumulator;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        Throwable error;
        final int limit;
        final int prefetch;
        final SimplePlainQueue<R> queue;
        final AtomicLong requested;
        Subscription upstream;
        R value;

        ScanSeedSubscriber(Subscriber<? super R> actual, BiFunction<R, ? super T, R> accumulator, R value, int prefetch) {
            this.downstream = actual;
            this.accumulator = accumulator;
            this.value = value;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
            this.queue = new SpscArrayQueue(prefetch);
            this.queue.offer(value);
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(this.prefetch - 1);
            }
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                R v = (R) Objects.requireNonNull(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = v;
                this.queue.offer(v);
                drain();
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
            this.error = t;
            this.done = true;
            drain();
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        void drain() {
            Throwable ex;
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super R> a = this.downstream;
            SimplePlainQueue<R> q = this.queue;
            int lim = this.limit;
            int c = this.consumed;
            do {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    if (this.cancelled) {
                        q.clear();
                        return;
                    }
                    boolean d = this.done;
                    if (d && (ex = this.error) != null) {
                        q.clear();
                        a.onError(ex);
                        return;
                    }
                    R v = q.poll();
                    boolean empty = v == null;
                    if (d && empty) {
                        a.onComplete();
                        return;
                    } else if (empty) {
                        break;
                    } else {
                        a.onNext(v);
                        e++;
                        c++;
                        if (c == lim) {
                            c = 0;
                            this.upstream.request(lim);
                        }
                    }
                }
                if (e == r && this.done) {
                    Throwable ex2 = this.error;
                    if (ex2 != null) {
                        q.clear();
                        a.onError(ex2);
                        return;
                    } else if (q.isEmpty()) {
                        a.onComplete();
                        return;
                    }
                }
                if (e != 0) {
                    BackpressureHelper.produced(this.requested, e);
                }
                this.consumed = c;
                missed = addAndGet(-missed);
            } while (missed != 0);
        }
    }
}