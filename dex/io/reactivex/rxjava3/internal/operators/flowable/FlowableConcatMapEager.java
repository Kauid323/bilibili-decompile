package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    public FlowableConcatMapEager(Flowable<T> source, Function<? super T, ? extends Publisher<? extends R>> mapper, int maxConcurrency, int prefetch, ErrorMode errorMode) {
        super(source);
        this.mapper = mapper;
        this.maxConcurrency = maxConcurrency;
        this.prefetch = prefetch;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapEagerDelayErrorSubscriber(s, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends Publisher<? extends R>> mapper, int maxConcurrency, int prefetch, ErrorMode errorMode) {
            this.downstream = actual;
            this.mapper = mapper;
            this.maxConcurrency = maxConcurrency;
            this.prefetch = prefetch;
            this.errorMode = errorMode;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(prefetch, maxConcurrency));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(this.maxConcurrency == Integer.MAX_VALUE ? Long.MAX_VALUE : this.maxConcurrency);
            }
        }

        public void onNext(T t) {
            try {
                Publisher<? extends R> p = (Publisher) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> inner = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(inner);
                p.subscribe(inner);
                if (this.cancelled) {
                    inner.cancel();
                    drainAndCancel();
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.cancel();
                onError(ex);
            }
        }

        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                this.done = true;
                drain();
            }
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.errors.tryTerminateAndReport();
            drainAndCancel();
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        void cancelAll() {
            InnerQueuedSubscriber<R> inner = this.current;
            this.current = null;
            if (inner != null) {
                inner.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> inner2 = this.subscribers.poll();
                if (inner2 != null) {
                    inner2.cancel();
                } else {
                    return;
                }
            }
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> inner, R value) {
            if (inner.queue().offer(value)) {
                drain();
                return;
            }
            inner.cancel();
            innerError(inner, new MissingBackpressureException());
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> inner, Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                inner.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> inner) {
            inner.setDone();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void drain() {
            InnerQueuedSubscriber<R> inner;
            SimpleQueue<R> q;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber<R> inner2 = this.current;
            Subscriber<? super R> a = this.downstream;
            ErrorMode em = this.errorMode;
            int missed = 1;
            InnerQueuedSubscriber<R> inner3 = inner2;
            while (true) {
                long r = this.requested.get();
                long e = 0;
                if (inner3 != null) {
                    inner = inner3;
                } else {
                    if (em != ErrorMode.END) {
                        if (this.errors.get() != null) {
                            cancelAll();
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                    }
                    boolean outerDone = this.done;
                    InnerQueuedSubscriber<R> inner4 = this.subscribers.poll();
                    InnerQueuedSubscriber<R> inner5 = inner4;
                    if (outerDone && inner5 == null) {
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    if (inner5 != null) {
                        this.current = inner5;
                    }
                    inner = inner5;
                }
                boolean continueNextSource = false;
                if (inner != null && (q = inner.queue()) != null) {
                    while (true) {
                        if (e == r) {
                            break;
                        } else if (this.cancelled) {
                            cancelAll();
                            return;
                        } else {
                            if (em == ErrorMode.IMMEDIATE) {
                                if (this.errors.get() != null) {
                                    this.current = null;
                                    inner.cancel();
                                    cancelAll();
                                    this.errors.tryTerminateConsumer(this.downstream);
                                    return;
                                }
                            }
                            boolean d = inner.isDone();
                            try {
                                R v = q.poll();
                                boolean empty = v == null;
                                if (d && empty) {
                                    inner = null;
                                    this.current = null;
                                    this.upstream.request(1L);
                                    continueNextSource = true;
                                    break;
                                } else if (empty) {
                                    break;
                                } else {
                                    a.onNext(v);
                                    e++;
                                    inner.request(1L);
                                }
                            } catch (Throwable ex) {
                                Exceptions.throwIfFatal(ex);
                                this.current = null;
                                inner.cancel();
                                cancelAll();
                                a.onError(ex);
                                return;
                            }
                        }
                    }
                    if (e == r) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (em == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            inner.cancel();
                            cancelAll();
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        } else {
                            boolean d2 = inner.isDone();
                            boolean empty2 = q.isEmpty();
                            if (d2 && empty2) {
                                this.current = null;
                                this.upstream.request(1L);
                                continueNextSource = true;
                                inner3 = null;
                                if (e != 0 && r != Long.MAX_VALUE) {
                                    this.requested.addAndGet(-e);
                                }
                                if (!continueNextSource && (missed = addAndGet(-missed)) == 0) {
                                    return;
                                }
                            }
                        }
                    }
                }
                inner3 = inner;
                if (e != 0) {
                    this.requested.addAndGet(-e);
                }
                if (!continueNextSource) {
                    return;
                }
            }
        }
    }
}