package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapScheduler<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    final Scheduler scheduler;

    public FlowableConcatMapScheduler(Flowable<T> source, Function<? super T, ? extends Publisher<? extends R>> mapper, int prefetch, ErrorMode errorMode, Scheduler scheduler) {
        super(source);
        this.mapper = mapper;
        this.prefetch = prefetch;
        this.errorMode = errorMode;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        switch (this.errorMode) {
            case BOUNDARY:
                this.source.subscribe((FlowableSubscriber) new ConcatMapDelayed(s, this.mapper, this.prefetch, false, this.scheduler.createWorker()));
                return;
            case END:
                this.source.subscribe((FlowableSubscriber) new ConcatMapDelayed(s, this.mapper, this.prefetch, true, this.scheduler.createWorker()));
                return;
            default:
                this.source.subscribe((FlowableSubscriber) new ConcatMapImmediate(s, this.mapper, this.prefetch, this.scheduler.createWorker()));
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, FlowableConcatMap.ConcatMapSupport<R>, Subscription, Runnable {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final int limit;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        int sourceMode;
        Subscription upstream;
        final Scheduler.Worker worker;
        final FlowableConcatMap.ConcatMapInner<R> inner = new FlowableConcatMap.ConcatMapInner<>(this);
        final AtomicThrowable errors = new AtomicThrowable();

        abstract void schedule();

        abstract void subscribeActual();

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> mapper, int prefetch, Scheduler.Worker worker) {
            this.mapper = mapper;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
            this.worker = worker;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public final void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                if (s instanceof QueueSubscription) {
                    QueueSubscription<T> f = (QueueSubscription) s;
                    int m = f.requestFusion(7);
                    if (m == 1) {
                        this.sourceMode = m;
                        this.queue = f;
                        this.done = true;
                        subscribeActual();
                        schedule();
                        return;
                    } else if (m == 2) {
                        this.sourceMode = m;
                        this.queue = f;
                        subscribeActual();
                        s.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscribeActual();
                s.request(this.prefetch);
            }
        }

        public final void onNext(T t) {
            if (this.sourceMode != 2 && !this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new IllegalStateException("Queue full?!"));
                return;
            }
            schedule();
        }

        public final void onComplete() {
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public final void innerComplete() {
            this.active = false;
            schedule();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final Subscriber<? super R> downstream;
        final AtomicInteger wip;

        ConcatMapImmediate(Subscriber<? super R> actual, Function<? super T, ? extends Publisher<? extends R>> mapper, int prefetch, Scheduler.Worker worker) {
            super(mapper, prefetch, worker);
            this.downstream = actual;
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }

        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                this.inner.cancel();
                if (getAndIncrement() == 0) {
                    this.errors.tryTerminateConsumer(this.downstream);
                    this.worker.dispose();
                }
            }
        }

        boolean tryEnter() {
            return get() == 0 && compareAndSet(0, 1);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R value) {
            if (tryEnter()) {
                this.downstream.onNext(value);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.errors.tryTerminateConsumer(this.downstream);
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.errors.tryTerminateConsumer(this.downstream);
                    this.worker.dispose();
                }
            }
        }

        public void request(long n) {
            this.inner.request(n);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.inner.cancel();
                this.upstream.cancel();
                this.worker.dispose();
                this.errors.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.BaseConcatMapSubscriber
        void schedule() {
            if (this.wip.getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.cancelled) {
                if (!this.active) {
                    boolean d = this.done;
                    try {
                        T v = this.queue.poll();
                        boolean empty = v == null;
                        if (d && empty) {
                            this.downstream.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (!empty) {
                            try {
                                Supplier<R> supplier = (Publisher) Objects.requireNonNull(this.mapper.apply(v), "The mapper returned a null Publisher");
                                if (this.sourceMode != 1) {
                                    int c = this.consumed + 1;
                                    if (c == this.limit) {
                                        this.consumed = 0;
                                        this.upstream.request(c);
                                    } else {
                                        this.consumed = c;
                                    }
                                }
                                if (supplier instanceof Supplier) {
                                    Supplier<R> supplier2 = supplier;
                                    try {
                                        R vr = supplier2.get();
                                        if (vr != null && !this.cancelled) {
                                            if (this.inner.isUnbounded()) {
                                                if (tryEnter()) {
                                                    this.downstream.onNext(vr);
                                                    if (!compareAndSet(1, 0)) {
                                                        this.errors.tryTerminateConsumer(this.downstream);
                                                        this.worker.dispose();
                                                        return;
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                this.active = true;
                                                this.inner.setSubscription(new FlowableConcatMap.WeakScalarSubscription(vr, this.inner));
                                            }
                                        }
                                    } catch (Throwable e) {
                                        Exceptions.throwIfFatal(e);
                                        this.upstream.cancel();
                                        this.errors.tryAddThrowableOrReport(e);
                                        this.errors.tryTerminateConsumer(this.downstream);
                                        this.worker.dispose();
                                        return;
                                    }
                                } else {
                                    this.active = true;
                                    supplier.subscribe(this.inner);
                                }
                            } catch (Throwable e2) {
                                Exceptions.throwIfFatal(e2);
                                this.upstream.cancel();
                                this.errors.tryAddThrowableOrReport(e2);
                                this.errors.tryTerminateConsumer(this.downstream);
                                this.worker.dispose();
                                return;
                            }
                        }
                    } catch (Throwable e3) {
                        Exceptions.throwIfFatal(e3);
                        this.upstream.cancel();
                        this.errors.tryAddThrowableOrReport(e3);
                        this.errors.tryTerminateConsumer(this.downstream);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final Subscriber<? super R> downstream;
        final boolean veryEnd;

        ConcatMapDelayed(Subscriber<? super R> actual, Function<? super T, ? extends Publisher<? extends R>> mapper, int prefetch, boolean veryEnd, Scheduler.Worker worker) {
            super(mapper, prefetch, worker);
            this.downstream = actual;
            this.veryEnd = veryEnd;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }

        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                this.done = true;
                schedule();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R value) {
            this.downstream.onNext(value);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                if (!this.veryEnd) {
                    this.upstream.cancel();
                    this.done = true;
                }
                this.active = false;
                schedule();
            }
        }

        public void request(long n) {
            this.inner.request(n);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.inner.cancel();
                this.upstream.cancel();
                this.worker.dispose();
                this.errors.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.BaseConcatMapSubscriber
        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            R vr;
            while (!this.cancelled) {
                if (!this.active) {
                    boolean d = this.done;
                    if (d && !this.veryEnd) {
                        Throwable ex = this.errors.get();
                        if (ex != null) {
                            this.errors.tryTerminateConsumer(this.downstream);
                            this.worker.dispose();
                            return;
                        }
                    }
                    try {
                        T v = this.queue.poll();
                        boolean empty = v == null;
                        if (d && empty) {
                            this.errors.tryTerminateConsumer(this.downstream);
                            this.worker.dispose();
                            return;
                        } else if (!empty) {
                            try {
                                Supplier<R> supplier = (Publisher) Objects.requireNonNull(this.mapper.apply(v), "The mapper returned a null Publisher");
                                if (this.sourceMode != 1) {
                                    int c = this.consumed + 1;
                                    if (c == this.limit) {
                                        this.consumed = 0;
                                        this.upstream.request(c);
                                    } else {
                                        this.consumed = c;
                                    }
                                }
                                if (supplier instanceof Supplier) {
                                    Supplier<R> supplier2 = supplier;
                                    try {
                                        vr = supplier2.get();
                                    } catch (Throwable e) {
                                        Exceptions.throwIfFatal(e);
                                        this.errors.tryAddThrowableOrReport(e);
                                        if (!this.veryEnd) {
                                            this.upstream.cancel();
                                            this.errors.tryTerminateConsumer(this.downstream);
                                            this.worker.dispose();
                                            return;
                                        }
                                        vr = null;
                                    }
                                    if (vr != null && !this.cancelled) {
                                        if (this.inner.isUnbounded()) {
                                            this.downstream.onNext(vr);
                                        } else {
                                            this.active = true;
                                            this.inner.setSubscription(new FlowableConcatMap.WeakScalarSubscription(vr, this.inner));
                                        }
                                    }
                                } else {
                                    this.active = true;
                                    supplier.subscribe(this.inner);
                                }
                            } catch (Throwable e2) {
                                Exceptions.throwIfFatal(e2);
                                this.upstream.cancel();
                                this.errors.tryAddThrowableOrReport(e2);
                                this.errors.tryTerminateConsumer(this.downstream);
                                this.worker.dispose();
                                return;
                            }
                        }
                    } catch (Throwable e3) {
                        Exceptions.throwIfFatal(e3);
                        this.upstream.cancel();
                        this.errors.tryAddThrowableOrReport(e3);
                        this.errors.tryTerminateConsumer(this.downstream);
                        this.worker.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}