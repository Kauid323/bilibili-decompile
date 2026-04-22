package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import j$.util.Objects;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    public FlowableZip(Publisher<? extends T>[] sources, Iterable<? extends Publisher<? extends T>> sourcesIterable, Function<? super Object[], ? extends R> zipper, int bufferSize, boolean delayError) {
        this.sources = sources;
        this.sourcesIterable = sourcesIterable;
        this.zipper = zipper;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> s) {
        int count;
        Publisher<? extends T>[] sources = this.sources;
        int count2 = 0;
        if (sources == null) {
            sources = new Publisher[8];
            for (Publisher<? extends T> p : this.sourcesIterable) {
                if (count2 == sources.length) {
                    Publisher<? extends T>[] b = new Publisher[(count2 >> 2) + count2];
                    System.arraycopy(sources, 0, b, 0, count2);
                    sources = b;
                }
                sources[count2] = p;
                count2++;
            }
            count = count2;
        } else {
            int count3 = sources.length;
            count = count3;
        }
        if (count == 0) {
            EmptySubscription.complete(s);
            return;
        }
        ZipCoordinator<T, R> coordinator = new ZipCoordinator<>(s, this.zipper, count, this.bufferSize, this.delayError);
        s.onSubscribe(coordinator);
        coordinator.subscribe(sources, count);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(Subscriber<? super R> actual, Function<? super Object[], ? extends R> zipper, int n, int prefetch, boolean delayErrors) {
            this.downstream = actual;
            this.zipper = zipper;
            this.delayErrors = delayErrors;
            ZipSubscriber<T, R>[] a = new ZipSubscriber[n];
            for (int i = 0; i < n; i++) {
                a[i] = new ZipSubscriber<>(this, prefetch);
            }
            this.current = new Object[n];
            this.subscribers = a;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        void subscribe(Publisher<? extends T>[] sources, int n) {
            ZipSubscriber<T, R>[] a = this.subscribers;
            for (int i = 0; i < n && !this.cancelled; i++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                sources[i].subscribe(a[i]);
            }
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
            }
        }

        void error(ZipSubscriber<T, R> inner, Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                inner.done = true;
                drain();
            }
        }

        void cancelAll() {
            ZipSubscriber<T, R>[] zipSubscriberArr;
            for (ZipSubscriber<T, R> s : this.subscribers) {
                s.cancel();
            }
        }

        void drain() {
            T poll;
            T poll2;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> a = this.downstream;
            ZipSubscriber<T, R>[] qs = this.subscribers;
            int n = qs.length;
            Object[] values = this.current;
            int missed = 1;
            do {
                long r = this.requested.get();
                long e = 0;
                while (r != e) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        this.errors.tryTerminateConsumer(a);
                        return;
                    }
                    boolean empty = false;
                    for (int j2 = 0; j2 < n; j2++) {
                        ZipSubscriber<T, R> inner = qs[j2];
                        if (values[j2] == null) {
                            boolean d = inner.done;
                            SimpleQueue<T> q = inner.queue;
                            T v = null;
                            if (q != null) {
                                try {
                                    poll2 = q.poll();
                                } catch (Throwable ex) {
                                    Exceptions.throwIfFatal(ex);
                                    this.errors.tryAddThrowableOrReport(ex);
                                    if (!this.delayErrors) {
                                        cancelAll();
                                        this.errors.tryTerminateConsumer(a);
                                        return;
                                    }
                                    d = true;
                                }
                            } else {
                                poll2 = null;
                            }
                            v = poll2;
                            boolean sourceEmpty = v == null;
                            if (d && sourceEmpty) {
                                cancelAll();
                                this.errors.tryTerminateConsumer(a);
                                return;
                            } else if (!sourceEmpty) {
                                values[j2] = v;
                            } else {
                                empty = true;
                            }
                        }
                    }
                    if (empty) {
                        break;
                    }
                    try {
                        a.onNext(Objects.requireNonNull(this.zipper.apply(values.clone()), "The zipper returned a null value"));
                        e++;
                        Arrays.fill(values, (Object) null);
                    } catch (Throwable ex2) {
                        Exceptions.throwIfFatal(ex2);
                        cancelAll();
                        this.errors.tryAddThrowableOrReport(ex2);
                        this.errors.tryTerminateConsumer(a);
                        return;
                    }
                }
                if (r == e) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        this.errors.tryTerminateConsumer(a);
                        return;
                    }
                    for (int j3 = 0; j3 < n; j3++) {
                        ZipSubscriber<T, R> inner2 = qs[j3];
                        if (values[j3] == null) {
                            boolean d2 = inner2.done;
                            SimpleQueue<T> q2 = inner2.queue;
                            T v2 = null;
                            if (q2 == null) {
                                poll = null;
                            } else {
                                try {
                                    poll = q2.poll();
                                } catch (Throwable ex3) {
                                    Exceptions.throwIfFatal(ex3);
                                    this.errors.tryAddThrowableOrReport(ex3);
                                    if (!this.delayErrors) {
                                        cancelAll();
                                        this.errors.tryTerminateConsumer(a);
                                        return;
                                    }
                                    d2 = true;
                                }
                            }
                            v2 = poll;
                            boolean empty2 = v2 == null;
                            if (d2 && empty2) {
                                cancelAll();
                                this.errors.tryTerminateConsumer(a);
                                return;
                            } else if (!empty2) {
                                values[j3] = v2;
                            }
                        }
                    }
                }
                if (e != 0) {
                    for (ZipSubscriber<T, R> inner3 : qs) {
                        inner3.request(e);
                    }
                    if (r != Long.MAX_VALUE) {
                        this.requested.addAndGet(-e);
                    }
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> parent, int prefetch) {
            this.parent = parent;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription<T> f = (QueueSubscription) s;
                    int m = f.requestFusion(7);
                    if (m == 1) {
                        this.sourceMode = m;
                        this.queue = f;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (m == 2) {
                        this.sourceMode = m;
                        this.queue = f;
                        s.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                s.request(this.prefetch);
            }
        }

        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        public void onError(Throwable t) {
            this.parent.error(this, t);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void request(long n) {
            if (this.sourceMode != 1) {
                long p = this.produced + n;
                if (p >= this.limit) {
                    this.produced = 0L;
                    get().request(p);
                    return;
                }
                this.produced = p;
            }
        }
    }
}