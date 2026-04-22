package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;

    public FlowableFlatMap(Flowable<T> source, Function<? super T, ? extends Publisher<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        super(source);
        this.mapper = mapper;
        this.delayErrors = delayErrors;
        this.maxConcurrency = maxConcurrency;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super U> s) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, s, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber) subscribe(s, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> s, Function<? super T, ? extends Publisher<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        return new MergeSubscriber(s, mapper, delayErrors, maxConcurrency, bufferSize);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super U> downstream;
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends Publisher<? extends U>> mapper;
        final int maxConcurrency;
        volatile SimplePlainQueue<U> queue;
        int scalarEmitted;
        final int scalarLimit;
        long uniqueId;
        Subscription upstream;
        static final InnerSubscriber<?, ?>[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] CANCELLED = new InnerSubscriber[0];
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        MergeSubscriber(Subscriber<? super U> actual, Function<? super T, ? extends Publisher<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
            this.downstream = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
            this.maxConcurrency = maxConcurrency;
            this.bufferSize = bufferSize;
            this.scalarLimit = Math.max(1, maxConcurrency >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    if (this.maxConcurrency == Integer.MAX_VALUE) {
                        s.request(Long.MAX_VALUE);
                    } else {
                        s.request(this.maxConcurrency);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                Supplier supplier = (Publisher) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (supplier instanceof Supplier) {
                    try {
                        Object obj = supplier.get();
                        if (obj != null) {
                            tryEmitScalar(obj);
                            return;
                        } else if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                            return;
                        } else {
                            int i = this.scalarEmitted + 1;
                            this.scalarEmitted = i;
                            if (i == this.scalarLimit) {
                                this.scalarEmitted = 0;
                                this.upstream.request(this.scalarLimit);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        this.errors.tryAddThrowableOrReport(ex);
                        drain();
                        return;
                    }
                }
                int i2 = this.bufferSize;
                long j2 = this.uniqueId;
                this.uniqueId = 1 + j2;
                InnerSubscriber<T, U> inner = new InnerSubscriber<>(this, i2, j2);
                if (addInner(inner)) {
                    supplier.subscribe(inner);
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.upstream.cancel();
                onError(e);
            }
        }

        boolean addInner(InnerSubscriber<T, U> inner) {
            InnerSubscriber<?, ?>[] a;
            InnerSubscriber[] innerSubscriberArr;
            do {
                a = this.subscribers.get();
                if (a == CANCELLED) {
                    inner.dispose();
                    return false;
                }
                int n = a.length;
                innerSubscriberArr = new InnerSubscriber[n + 1];
                System.arraycopy(a, 0, innerSubscriberArr, 0, n);
                innerSubscriberArr[n] = inner;
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, innerSubscriberArr));
            return true;
        }

        void removeInner(InnerSubscriber<T, U> inner) {
            InnerSubscriber<?, ?>[] a;
            InnerSubscriber<?, ?>[] b;
            do {
                a = this.subscribers.get();
                int n = a.length;
                if (n == 0) {
                    return;
                }
                int j2 = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (a[i] != inner) {
                        i++;
                    } else {
                        j2 = i;
                        break;
                    }
                }
                if (j2 < 0) {
                    return;
                }
                if (n == 1) {
                    b = EMPTY;
                } else {
                    InnerSubscriber<?, ?>[] b2 = new InnerSubscriber[n - 1];
                    System.arraycopy(a, 0, b2, 0, j2);
                    System.arraycopy(a, j2 + 1, b2, j2, (n - j2) - 1);
                    b = b2;
                }
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
        }

        SimpleQueue<U> getMainQueue() {
            SimplePlainQueue<U> q = this.queue;
            if (q == null) {
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    q = new SpscLinkedArrayQueue(this.bufferSize);
                } else {
                    q = new SpscArrayQueue<>(this.maxConcurrency);
                }
                this.queue = q;
            }
            return q;
        }

        void tryEmitScalar(U value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long r = this.requested.get();
                SimpleQueue<U> q = this.queue;
                if (r != 0 && (q == null || q.isEmpty())) {
                    this.downstream.onNext(value);
                    if (r != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        if (i == this.scalarLimit) {
                            this.scalarEmitted = 0;
                            this.upstream.request(this.scalarLimit);
                        }
                    }
                } else {
                    if (q == null) {
                        q = getMainQueue();
                    }
                    if (!q.offer(value)) {
                        onError(new MissingBackpressureException("Scalar queue full?!"));
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(value)) {
                onError(new MissingBackpressureException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        void tryEmit(U value, InnerSubscriber<T, U> inner) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long r = this.requested.get();
                SimpleQueue<U> q = inner.queue;
                if (r != 0 && (q == null || q.isEmpty())) {
                    this.downstream.onNext(value);
                    if (r != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.requestMore(1L);
                } else {
                    if (q == null) {
                        q = new SpscArrayQueue(this.bufferSize);
                        inner.queue = q;
                    }
                    if (!q.offer(value)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue<U> q2 = inner.queue;
                if (q2 == null) {
                    q2 = new SpscArrayQueue(this.bufferSize);
                    inner.queue = q2;
                }
                if (!q2.offer(value)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public void onError(Throwable t) {
            InnerSubscriber<?, ?>[] andSet;
            if (this.done) {
                RxJavaPlugins.onError(t);
            } else if (this.errors.tryAddThrowableOrReport(t)) {
                this.done = true;
                if (!this.delayErrors) {
                    for (InnerSubscriber<?, ?> a : this.subscribers.getAndSet(CANCELLED)) {
                        a.dispose();
                    }
                }
                drain();
            }
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            SimpleQueue<U> q;
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeAll();
                if (getAndIncrement() == 0 && (q = this.queue) != null) {
                    q.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0192, code lost:
            if (r7.isEmpty() == false) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0198, code lost:
            removeInner(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x019f, code lost:
            if (checkTerminate() == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x01a1, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x01a2, code lost:
            r25 = r25 + 1;
            r22 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x01af, code lost:
            if (r23 != 0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x01b1, code lost:
            r0 = r22;
            r8 = r25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x01b6, code lost:
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x01b8, code lost:
            if (r5 != r14) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x01ba, code lost:
            r5 = 0;
            r7 = r31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x01be, code lost:
            r7 = r31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x01d6, code lost:
            r32.lastIndex = r5;
            r32.lastId = r11[r5].id;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x014e, code lost:
            if (r9 == 0) goto L110;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0150, code lost:
            if (r6 != false) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0152, code lost:
            r21 = r6;
            r31 = r7;
            r6 = r32.requested.addAndGet(-r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x015e, code lost:
            r21 = r6;
            r31 = r7;
            r6 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0167, code lost:
            r8.requestMore(r9);
            r23 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x016d, code lost:
            r21 = r6;
            r31 = r7;
            r23 = r27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0177, code lost:
            if (r23 == 0) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0179, code lost:
            if (r0 != null) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0186, code lost:
            r6 = r8.done;
            r7 = r8.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x018a, code lost:
            if (r6 == false) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x018c, code lost:
            if (r7 == null) goto L102;
         */
        /* JADX WARN: Removed duplicated region for block: B:147:0x01ca A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00cf  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            boolean innerCompleted;
            long r;
            long replenishMain;
            boolean d;
            int index;
            int i;
            boolean unbounded;
            int i2;
            boolean d2;
            SimplePlainQueue<U> svq;
            int i3;
            Subscriber<? super U> child = this.downstream;
            int missed = 1;
            while (!checkTerminate()) {
                SimplePlainQueue<U> svq2 = this.queue;
                long r2 = this.requested.get();
                boolean unbounded2 = r2 == Long.MAX_VALUE;
                long replenishMain2 = 0;
                if (svq2 != null) {
                    long scalarEmission = 0;
                    while (r2 != 0) {
                        U o = svq2.poll();
                        if (checkTerminate()) {
                            return;
                        }
                        if (o == null) {
                            break;
                        }
                        child.onNext(o);
                        replenishMain2++;
                        scalarEmission++;
                        r2--;
                    }
                    if (scalarEmission != 0) {
                        if (unbounded2) {
                            r2 = Long.MAX_VALUE;
                        } else {
                            r2 = this.requested.addAndGet(-scalarEmission);
                        }
                    }
                }
                boolean d3 = this.done;
                SimplePlainQueue<U> svq3 = this.queue;
                InnerSubscriber<?, ?>[] inner = this.subscribers.get();
                int n = inner.length;
                if (d3 && ((svq3 == null || svq3.isEmpty()) && n == 0)) {
                    this.errors.tryTerminateConsumer(this.downstream);
                    return;
                }
                boolean innerCompleted2 = false;
                if (n != 0) {
                    long startId = this.lastId;
                    int index2 = this.lastIndex;
                    if (n > index2) {
                        innerCompleted = false;
                        r = r2;
                        if (inner[index2].id == startId) {
                            replenishMain = replenishMain2;
                            index = index2;
                            d = d3;
                            int j2 = index;
                            i = 0;
                            int j3 = j2;
                            while (true) {
                                if (i < n) {
                                    innerCompleted2 = innerCompleted;
                                    replenishMain2 = replenishMain;
                                    break;
                                } else if (checkTerminate()) {
                                    return;
                                } else {
                                    InnerSubscriber<T, U> is = inner[j3];
                                    U o2 = null;
                                    while (true) {
                                        SimpleQueue<U> q = is.queue;
                                        if (q == null) {
                                            unbounded = unbounded2;
                                            i2 = i;
                                            d2 = d;
                                            svq = svq3;
                                            break;
                                        }
                                        d2 = d;
                                        svq = svq3;
                                        long produced = 0;
                                        long r3 = r;
                                        U o3 = o2;
                                        while (true) {
                                            SimpleQueue<U> q2 = q;
                                            if (r3 == 0) {
                                                o2 = o3;
                                                break;
                                            } else if (checkTerminate()) {
                                                return;
                                            } else {
                                                try {
                                                    o2 = q2.poll();
                                                    if (o2 == null) {
                                                        break;
                                                    }
                                                    child.onNext(o2);
                                                    r3--;
                                                    produced++;
                                                    o3 = o2;
                                                    q = q2;
                                                } catch (Throwable ex) {
                                                    Exceptions.throwIfFatal(ex);
                                                    is.dispose();
                                                    this.errors.tryAddThrowableOrReport(ex);
                                                    if (!this.delayErrors) {
                                                        this.upstream.cancel();
                                                    }
                                                    if (checkTerminate()) {
                                                        return;
                                                    }
                                                    removeInner(is);
                                                    i3 = i + 1;
                                                    unbounded = unbounded2;
                                                    innerCompleted = true;
                                                    r = r3;
                                                }
                                            }
                                        }
                                        unbounded2 = unbounded;
                                        svq3 = svq;
                                        d = d2;
                                        i = i2;
                                    }
                                }
                                i = i3 + 1;
                                unbounded2 = unbounded;
                                svq3 = svq;
                                d = d2;
                            }
                        }
                    } else {
                        innerCompleted = false;
                        r = r2;
                    }
                    if (n <= index2) {
                        index2 = 0;
                    }
                    int j4 = index2;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= n) {
                            replenishMain = replenishMain2;
                            d = d3;
                            break;
                        }
                        replenishMain = replenishMain2;
                        d = d3;
                        if (inner[j4].id == startId) {
                            break;
                        }
                        j4++;
                        if (j4 == n) {
                            j4 = 0;
                        }
                        i4++;
                        d3 = d;
                        replenishMain2 = replenishMain;
                    }
                    this.lastIndex = j4;
                    this.lastId = inner[j4].id;
                    index = j4;
                    int j22 = index;
                    i = 0;
                    int j32 = j22;
                    while (true) {
                        if (i < n) {
                        }
                        i = i3 + 1;
                        unbounded2 = unbounded;
                        svq3 = svq;
                        d = d2;
                    }
                }
                if (replenishMain2 != 0 && !this.cancelled) {
                    this.upstream.request(replenishMain2);
                }
                if (!innerCompleted2 && (missed = addAndGet(-missed)) == 0) {
                    return;
                }
            }
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            } else if (!this.delayErrors && this.errors.get() != null) {
                clearScalarQueue();
                this.errors.tryTerminateConsumer(this.downstream);
                return true;
            } else {
                return false;
            }
        }

        void clearScalarQueue() {
            SimpleQueue<U> q = this.queue;
            if (q != null) {
                q.clear();
            }
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] a = this.subscribers.getAndSet(CANCELLED);
            if (a != CANCELLED) {
                for (InnerSubscriber<?, ?> inner : a) {
                    inner.dispose();
                }
                this.errors.tryTerminateAndReport();
            }
        }

        void innerError(InnerSubscriber<T, U> inner, Throwable t) {
            InnerSubscriber<?, ?>[] andSet;
            if (this.errors.tryAddThrowableOrReport(t)) {
                inner.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (InnerSubscriber<?, ?> a : this.subscribers.getAndSet(CANCELLED)) {
                        a.dispose();
                    }
                }
                drain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile SimpleQueue<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> parent, int bufferSize, long id) {
            this.id = id;
            this.parent = parent;
            this.bufferSize = bufferSize;
            this.limit = bufferSize >> 2;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription<U> qs = (QueueSubscription) s;
                    int m = qs.requestFusion(7);
                    if (m == 1) {
                        this.fusionMode = m;
                        this.queue = qs;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (m == 2) {
                        this.fusionMode = m;
                        this.queue = qs;
                    }
                }
                s.request(this.bufferSize);
            }
        }

        public void onNext(U t) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(t, this);
            } else {
                this.parent.drain();
            }
        }

        public void onError(Throwable t) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, t);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        void requestMore(long n) {
            if (this.fusionMode != 1) {
                long p = this.produced + n;
                if (p >= this.limit) {
                    this.produced = 0L;
                    get().request(p);
                    return;
                }
                this.produced = p;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}