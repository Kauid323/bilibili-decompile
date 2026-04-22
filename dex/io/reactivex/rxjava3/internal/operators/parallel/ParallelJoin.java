package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    public ParallelJoin(ParallelFlowable<? extends T> source, int prefetch, boolean delayErrors) {
        this.source = source;
        this.prefetch = prefetch;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        JoinSubscriptionBase<T> parent;
        if (this.delayErrors) {
            parent = new JoinSubscriptionDelayError<>(s, this.source.parallelism(), this.prefetch);
        } else {
            parent = new JoinSubscription<>(s, this.source.parallelism(), this.prefetch);
        }
        s.onSubscribe(parent);
        this.source.subscribe(parent.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        final JoinInnerSubscriber<T>[] subscribers;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable e);

        abstract void onNext(JoinInnerSubscriber<T> inner, T value);

        JoinSubscriptionBase(Subscriber<? super T> actual, int n, int prefetch) {
            this.downstream = actual;
            JoinInnerSubscriber<T>[] a = new JoinInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                a[i] = new JoinInnerSubscriber<>(this, prefetch);
            }
            this.subscribers = a;
            this.done.lazySet(n);
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
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        void cancelAll() {
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr;
            for (JoinInnerSubscriber<T> s : this.subscribers) {
                s.cancel();
            }
        }

        void cleanup() {
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr;
            for (JoinInnerSubscriber<T> s : this.subscribers) {
                s.queue = null;
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> actual, int n, int prefetch) {
            super(actual, n, prefetch);
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> inner, T value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(value);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.request(1L);
                } else {
                    SimplePlainQueue<T> q = inner.getQueue();
                    if (!q.offer(value)) {
                        cancelAll();
                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                        if (this.errors.compareAndSet(null, missingBackpressureException)) {
                            this.downstream.onError(missingBackpressureException);
                            return;
                        } else {
                            RxJavaPlugins.onError(missingBackpressureException);
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> q2 = inner.getQueue();
                if (!q2.offer(value)) {
                    cancelAll();
                    onError(new MissingBackpressureException("Queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable e) {
            if (this.errors.compareAndSet(null, e)) {
                cancelAll();
                drain();
            } else if (e != this.errors.get()) {
                RxJavaPlugins.onError(e);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
            if (r12 == false) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
            if (r13 == false) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
            r4.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
            if (r13 == false) goto L3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            T v;
            int missed = 1;
            JoinInnerSubscriber<T>[] s = this.subscribers;
            int n = s.length;
            Subscriber<? super T> a = this.downstream;
            do {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable ex = this.errors.get();
                    if (ex != null) {
                        cleanup();
                        a.onError(ex);
                        return;
                    }
                    boolean d = this.done.get() == 0;
                    boolean empty = true;
                    int i = 0;
                    while (true) {
                        if (i >= s.length) {
                            break;
                        }
                        JoinInnerSubscriber<T> inner = s[i];
                        SimplePlainQueue<T> q = inner.queue;
                        if (q != null && (v = q.poll()) != null) {
                            empty = false;
                            a.onNext(v);
                            inner.requestOne();
                            long j2 = e + 1;
                            e = j2;
                            if (j2 == r) {
                                break;
                            }
                        }
                        i++;
                    }
                }
                if (e == r) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable ex2 = this.errors.get();
                    if (ex2 != null) {
                        cleanup();
                        a.onError(ex2);
                        return;
                    }
                    boolean d2 = this.done.get() == 0;
                    boolean empty2 = true;
                    int i2 = 0;
                    while (true) {
                        if (i2 < n) {
                            SimpleQueue<T> q2 = s[i2].queue;
                            if (q2 == null || q2.isEmpty()) {
                                i2++;
                            } else {
                                empty2 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (d2 && empty2) {
                        a.onComplete();
                        return;
                    }
                }
                if (e != 0) {
                    BackpressureHelper.produced(this.requested, e);
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> actual, int n, int prefetch) {
            super(actual, n, prefetch);
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onNext(JoinInnerSubscriber<T> inner, T value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(value);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.request(1L);
                } else {
                    SimplePlainQueue<T> q = inner.getQueue();
                    if (!q.offer(value)) {
                        inner.cancel();
                        this.errors.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                        this.done.decrementAndGet();
                        drainLoop();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> q2 = inner.getQueue();
                if (!q2.offer(value)) {
                    inner.cancel();
                    this.errors.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onError(Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                this.done.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
            if (r9 == false) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
            if (r12 == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
            r18.errors.tryTerminateConsumer(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
            if (r12 == false) goto L3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            T v;
            int missed = 1;
            JoinInnerSubscriber<T>[] s = this.subscribers;
            int n = s.length;
            Subscriber<? super T> a = this.downstream;
            do {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean d = this.done.get() == 0;
                    boolean empty = true;
                    int i = 0;
                    while (true) {
                        if (i >= n) {
                            break;
                        }
                        JoinInnerSubscriber<T> inner = s[i];
                        SimplePlainQueue<T> q = inner.queue;
                        if (q != null && (v = q.poll()) != null) {
                            empty = false;
                            a.onNext(v);
                            inner.requestOne();
                            long j2 = e + 1;
                            e = j2;
                            if (j2 == r) {
                                break;
                            }
                        }
                        i++;
                    }
                }
                if (e == r) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean d2 = this.done.get() == 0;
                    boolean empty2 = true;
                    int i2 = 0;
                    while (true) {
                        if (i2 < n) {
                            SimpleQueue<T> q2 = s[i2].queue;
                            if (q2 == null || q2.isEmpty()) {
                                i2++;
                            } else {
                                empty2 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (d2 && empty2) {
                        this.errors.tryTerminateConsumer(a);
                        return;
                    }
                }
                if (e != 0) {
                    BackpressureHelper.produced(this.requested, e);
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> parent, int prefetch) {
            this.parent = parent;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, this.prefetch);
        }

        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        public void onError(Throwable t) {
            this.parent.onError(t);
        }

        public void onComplete() {
            this.parent.onComplete();
        }

        public void requestOne() {
            long p = this.produced + 1;
            if (p == this.limit) {
                this.produced = 0L;
                get().request(p);
                return;
            }
            this.produced = p;
        }

        public void request(long n) {
            long p = this.produced + n;
            if (p >= this.limit) {
                this.produced = 0L;
                get().request(p);
                return;
            }
            this.produced = p;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> q = this.queue;
            if (q == null) {
                SimplePlainQueue<T> q2 = new SpscArrayQueue<>(this.prefetch);
                this.queue = q2;
                return q2;
            }
            return q;
        }
    }
}