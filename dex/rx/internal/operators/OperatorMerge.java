package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        HolderNoDelay() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        HolderDelayErrors() {
        }
    }

    public static <T> OperatorMerge<T> instance(boolean delayErrors) {
        if (delayErrors) {
            return (OperatorMerge<T>) HolderDelayErrors.INSTANCE;
        }
        return (OperatorMerge<T>) HolderNoDelay.INSTANCE;
    }

    public static <T> OperatorMerge<T> instance(boolean delayErrors, int maxConcurrent) {
        if (maxConcurrent <= 0) {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + maxConcurrent);
        }
        if (maxConcurrent == Integer.MAX_VALUE) {
            return instance(delayErrors);
        }
        return new OperatorMerge<>(delayErrors, maxConcurrent);
    }

    OperatorMerge(boolean delayErrors, int maxConcurrent) {
        this.delayErrors = delayErrors;
        this.maxConcurrent = maxConcurrent;
    }

    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> child) {
        MergeSubscriber<T> subscriber = new MergeSubscriber<>(child, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> producer = new MergeProducer<>(subscriber);
        subscriber.producer = producer;
        child.add(subscriber);
        child.setProducer(producer);
        return subscriber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> subscriber) {
            this.subscriber = subscriber;
        }

        public void request(long n) {
            if (n > 0) {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                BackpressureUtils.getAndAddRequest(this, n);
                this.subscriber.emit();
            } else if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        public long produced(int n) {
            return addAndGet(-n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        public MergeSubscriber(Subscriber<? super T> child, boolean delayErrors, int maxConcurrent) {
            this.child = child;
            this.delayErrors = delayErrors;
            this.maxConcurrent = maxConcurrent;
            if (maxConcurrent == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.scalarEmissionLimit = Math.max(1, maxConcurrent >> 1);
            request(maxConcurrent);
        }

        Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> q = this.errors;
            if (q == null) {
                synchronized (this) {
                    q = this.errors;
                    if (q == null) {
                        q = new ConcurrentLinkedQueue<>();
                        this.errors = q;
                    }
                }
            }
            return q;
        }

        CompositeSubscription getOrCreateComposite() {
            CompositeSubscription c = this.subscriptions;
            if (c == null) {
                boolean shouldAdd = false;
                synchronized (this) {
                    c = this.subscriptions;
                    if (c == null) {
                        c = new CompositeSubscription();
                        this.subscriptions = c;
                        shouldAdd = true;
                    }
                }
                if (shouldAdd) {
                    add(c);
                }
            }
            return c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(Observable<? extends T> t) {
            if (t == null) {
                return;
            }
            if (t == Observable.empty()) {
                emitEmpty();
            } else if (t instanceof ScalarSynchronousObservable) {
                tryEmit(((ScalarSynchronousObservable) t).get());
            } else {
                long j2 = this.uniqueId;
                this.uniqueId = 1 + j2;
                InnerSubscriber<T> inner = new InnerSubscriber<>(this, j2);
                addInner(inner);
                t.unsafeSubscribe(inner);
                emit();
            }
        }

        void emitEmpty() {
            int produced = this.scalarEmissionCount + 1;
            if (produced == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore(produced);
                return;
            }
            this.scalarEmissionCount = produced;
        }

        private void reportError() {
            List<Throwable> list = new ArrayList<>(this.errors);
            if (list.size() == 1) {
                this.child.onError(list.get(0));
            } else {
                this.child.onError(new CompositeException(list));
            }
        }

        public void onError(Throwable e) {
            getOrCreateErrorQueue().offer(e);
            this.done = true;
            emit();
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void addInner(InnerSubscriber<T> inner) {
            getOrCreateComposite().add(inner);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] a = this.innerSubscribers;
                int n = a.length;
                InnerSubscriber<?>[] b = new InnerSubscriber[n + 1];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = inner;
                this.innerSubscribers = b;
            }
        }

        void removeInner(InnerSubscriber<T> inner) {
            RxRingBuffer q = inner.queue;
            if (q != null) {
                q.release();
            }
            this.subscriptions.remove(inner);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] a = this.innerSubscribers;
                int n = a.length;
                int j2 = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (!inner.equals(a[i])) {
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
                    this.innerSubscribers = EMPTY;
                    return;
                }
                InnerSubscriber<?>[] b = new InnerSubscriber[n - 1];
                System.arraycopy(a, 0, b, 0, j2);
                System.arraycopy(a, j2 + 1, b, j2, (n - j2) - 1);
                this.innerSubscribers = b;
            }
        }

        void tryEmit(InnerSubscriber<T> subscriber, T value) {
            boolean success = false;
            long r = this.producer.get();
            if (r != 0) {
                synchronized (this) {
                    r = this.producer.get();
                    if (!this.emitting && r != 0) {
                        this.emitting = true;
                        success = true;
                    }
                }
            }
            if (success) {
                RxRingBuffer subscriberQueue = subscriber.queue;
                if (subscriberQueue == null || subscriberQueue.isEmpty()) {
                    emitScalar(subscriber, value, r);
                    return;
                }
                queueScalar(subscriber, value);
                emitLoop();
                return;
            }
            queueScalar(subscriber, value);
            emit();
        }

        protected void queueScalar(InnerSubscriber<T> subscriber, T value) {
            RxRingBuffer q = subscriber.queue;
            if (q == null) {
                q = RxRingBuffer.getSpscInstance();
                subscriber.add(q);
                subscriber.queue = q;
            }
            try {
                q.onNext(NotificationLite.next(value));
            } catch (MissingBackpressureException ex) {
                subscriber.unsubscribe();
                subscriber.onError(ex);
            } catch (IllegalStateException ex2) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.unsubscribe();
                    subscriber.onError(ex2);
                }
            }
        }

        protected void emitScalar(InnerSubscriber<T> subscriber, T value, long r) {
            try {
                this.child.onNext(value);
                if (r != Long.MAX_VALUE) {
                    this.producer.produced(1);
                }
                subscriber.requestMore(1L);
                synchronized (this) {
                    try {
                        boolean skipFinal = this.missed;
                        if (skipFinal) {
                            this.missed = false;
                            if (1 == 0) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            emitLoop();
                            return;
                        }
                        this.emitting = false;
                        if (1 == 0) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (1 == 0) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th2;
                        }
                    }
                }
            }
        }

        public void requestMore(long n) {
            request(n);
        }

        void tryEmit(T value) {
            boolean success = false;
            long r = this.producer.get();
            if (r != 0) {
                synchronized (this) {
                    r = this.producer.get();
                    if (!this.emitting && r != 0) {
                        this.emitting = true;
                        success = true;
                    }
                }
            }
            if (success) {
                Queue<Object> mainQueue = this.queue;
                if (mainQueue == null || mainQueue.isEmpty()) {
                    emitScalar(value, r);
                    return;
                }
                queueScalar(value);
                emitLoop();
                return;
            }
            queueScalar(value);
            emit();
        }

        protected void queueScalar(T value) {
            Queue<Object> q = this.queue;
            if (q == null) {
                int mc = this.maxConcurrent;
                if (mc == Integer.MAX_VALUE) {
                    q = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else if (Pow2.isPowerOfTwo(mc)) {
                    if (UnsafeAccess.isUnsafeAvailable()) {
                        q = new SpscArrayQueue<>(mc);
                    } else {
                        q = new SpscAtomicArrayQueue<>(mc);
                    }
                } else {
                    q = new SpscExactAtomicArrayQueue<>(mc);
                }
                this.queue = q;
            }
            if (!q.offer(NotificationLite.next(value))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), value));
            }
        }

        protected void emitScalar(T value, long r) {
            try {
                this.child.onNext(value);
                if (r != Long.MAX_VALUE) {
                    this.producer.produced(1);
                }
                int produced = this.scalarEmissionCount + 1;
                if (produced == this.scalarEmissionLimit) {
                    this.scalarEmissionCount = 0;
                    requestMore(produced);
                } else {
                    this.scalarEmissionCount = produced;
                }
                synchronized (this) {
                    try {
                        boolean skipFinal = this.missed;
                        if (skipFinal) {
                            this.missed = false;
                            if (1 == 0) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            emitLoop();
                            return;
                        }
                        this.emitting = false;
                        if (1 == 0) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (1 == 0) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th2;
                        }
                    }
                }
            }
        }

        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                emitLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:202:0x021d, code lost:
            r0 = r0.done;
            r0 = r0.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x0223, code lost:
            if (r0 == false) goto L233;
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x0225, code lost:
            if (r0 == null) goto L214;
         */
        /* JADX WARN: Code restructure failed: missing block: B:206:0x022b, code lost:
            if (r0.isEmpty() == false) goto L162;
         */
        /* JADX WARN: Code restructure failed: missing block: B:208:0x022e, code lost:
            r28 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:0x0231, code lost:
            removeInner(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:210:0x0238, code lost:
            if (checkTerminate() == false) goto L216;
         */
        /* JADX WARN: Code restructure failed: missing block: B:212:0x023b, code lost:
            if (1 != 0) goto L231;
         */
        /* JADX WARN: Code restructure failed: missing block: B:213:0x023d, code lost:
            monitor-enter(r34);
         */
        /* JADX WARN: Code restructure failed: missing block: B:215:0x0241, code lost:
            r34.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:216:0x0243, code lost:
            monitor-exit(r34);
         */
        /* JADX WARN: Code restructure failed: missing block: B:222:0x024a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:223:0x024b, code lost:
            r28 = r4;
            r6 = r6 + 1;
            r22 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:224:0x0253, code lost:
            r28 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:226:0x0259, code lost:
            if (r25 != 0) goto L165;
         */
        /* JADX WARN: Code restructure failed: missing block: B:227:0x025b, code lost:
            r0 = r22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:228:0x0260, code lost:
            r2 = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:229:0x0262, code lost:
            if (r2 != r0) goto L170;
         */
        /* JADX WARN: Code restructure failed: missing block: B:230:0x0264, code lost:
            r2 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:233:0x027a, code lost:
            r34.lastIndex = r2;
            r34.lastId = r0[r2].id;
            r22 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:260:0x02c1, code lost:
            r2 = r21;
            r4 = r29;
            r3 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:343:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0097, code lost:
            if (r7 <= 0) goto L285;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0099, code lost:
            if (r8 == false) goto L284;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x009b, code lost:
            r11 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00a1, code lost:
            r11 = r34.producer.produced(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00a8, code lost:
            r11 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00ad, code lost:
            if (r11 == 0) goto L283;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00af, code lost:
            if (r0 != null) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0149 A[Catch: all -> 0x029a, TRY_LEAVE, TryCatch #17 {all -> 0x029a, blocks: (B:104:0x00fd, B:113:0x0114, B:121:0x0138, B:124:0x0149, B:138:0x0160, B:142:0x0171, B:157:0x018b, B:193:0x01f5, B:195:0x0203, B:202:0x021d, B:205:0x0227, B:233:0x027a, B:236:0x0295, B:241:0x02a7, B:209:0x0231, B:160:0x0195, B:163:0x01a1, B:116:0x0123, B:119:0x0129), top: B:305:0x00fd }] */
        /* JADX WARN: Removed duplicated region for block: B:270:0x02d4  */
        /* JADX WARN: Removed duplicated region for block: B:328:0x0272 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x00ef A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emitLoop() {
            long r;
            int replenishMain;
            boolean innerCompleted;
            boolean skipFinal;
            Subscriber<? super T> child;
            int replenishMain2;
            boolean innerCompleted2;
            int i;
            long r2;
            boolean d;
            boolean unbounded;
            boolean unbounded2;
            boolean skipFinal2 = false;
            boolean z = false;
            try {
                Subscriber<? super T> child2 = this.child;
                while (!checkTerminate()) {
                    Queue<Object> svq = this.queue;
                    long r3 = this.producer.get();
                    boolean unbounded3 = r3 == Long.MAX_VALUE ? true : z;
                    int replenishMain3 = 0;
                    long r4 = 0;
                    if (svq != null) {
                        while (true) {
                            long j2 = r3;
                            replenishMain = replenishMain3;
                            int scalarEmission = 0;
                            Object o = null;
                            long r5 = j2;
                            while (true) {
                                if (r5 <= r4) {
                                    break;
                                }
                                try {
                                    Object o2 = svq.poll();
                                    if (checkTerminate()) {
                                        if (1 == 0) {
                                            synchronized (this) {
                                                this.emitting = z;
                                            }
                                            return;
                                        }
                                        return;
                                    } else if (o2 == null) {
                                        o = o2;
                                        break;
                                    } else {
                                        child2.onNext(NotificationLite.getValue(o2));
                                        replenishMain++;
                                        scalarEmission++;
                                        r5--;
                                        o = o2;
                                        r4 = 0;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (!skipFinal2) {
                                    }
                                    throw th;
                                }
                            }
                            replenishMain3 = replenishMain;
                            r3 = r;
                            r4 = 0;
                        }
                    } else {
                        r = r3;
                        replenishMain = 0;
                    }
                    boolean d2 = this.done;
                    Queue<Object> svq2 = this.queue;
                    InnerSubscriber<?>[] inner = this.innerSubscribers;
                    int n = inner.length;
                    if (d2 && ((svq2 == null || svq2.isEmpty()) && n == 0)) {
                        Queue<Throwable> e = this.errors;
                        if (e != null && !e.isEmpty()) {
                            reportError();
                            if (1 != 0) {
                                synchronized (this) {
                                    this.emitting = z;
                                }
                                return;
                            }
                            return;
                        }
                        child2.onCompleted();
                        if (1 != 0) {
                        }
                    } else {
                        boolean innerCompleted3 = false;
                        if (n > 0) {
                            long startId = this.lastId;
                            int index = this.lastIndex;
                            if (n > index) {
                                skipFinal = skipFinal2;
                                try {
                                    if (inner[index].id == startId) {
                                        innerCompleted2 = false;
                                        replenishMain2 = replenishMain;
                                        int j3 = index;
                                        i = 0;
                                        replenishMain = replenishMain2;
                                        int j4 = j3;
                                        while (true) {
                                            if (i < n) {
                                                child = child2;
                                                boolean innerCompleted4 = innerCompleted2;
                                                break;
                                            } else if (!checkTerminate()) {
                                                InnerSubscriber<?> innerSubscriber = inner[j4];
                                                Object o3 = null;
                                                while (true) {
                                                    r2 = r;
                                                    int produced = 0;
                                                    Object o4 = o3;
                                                    while (true) {
                                                        if (r2 <= 0) {
                                                            child = child2;
                                                            d = d2;
                                                            break;
                                                        } else if (checkTerminate()) {
                                                            if (1 == 0) {
                                                                synchronized (this) {
                                                                    this.emitting = false;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else {
                                                            d = d2;
                                                            RxRingBuffer q = innerSubscriber.queue;
                                                            if (q == null) {
                                                                child = child2;
                                                                break;
                                                            }
                                                            o4 = q.poll();
                                                            if (o4 == null) {
                                                                child = child2;
                                                                break;
                                                            }
                                                            try {
                                                                child2.onNext(NotificationLite.getValue(o4));
                                                                r2--;
                                                                produced++;
                                                                d2 = d;
                                                            } catch (Throwable t) {
                                                                try {
                                                                    Exceptions.throwIfFatal(t);
                                                                    child2.onError(t);
                                                                    unsubscribe();
                                                                    if (1 == 0) {
                                                                        synchronized (this) {
                                                                            this.emitting = false;
                                                                            return;
                                                                        }
                                                                    }
                                                                    return;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    skipFinal2 = true;
                                                                    if (!skipFinal2) {
                                                                        synchronized (this) {
                                                                            this.emitting = false;
                                                                        }
                                                                    }
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (produced > 0) {
                                                        r2 = !unbounded3 ? this.producer.produced(produced) : Long.MAX_VALUE;
                                                        unbounded = unbounded3;
                                                        innerSubscriber.requestMore(produced);
                                                    } else {
                                                        unbounded = unbounded3;
                                                    }
                                                    if (r2 == 0 || o4 == null) {
                                                        break;
                                                    }
                                                    unbounded3 = unbounded;
                                                    o3 = o4;
                                                    r = r2;
                                                    d2 = d;
                                                    child2 = child;
                                                }
                                            } else if (1 == 0) {
                                                synchronized (this) {
                                                    this.emitting = false;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                            i++;
                                            r = r2;
                                            d2 = d;
                                            unbounded3 = unbounded2;
                                            child2 = child;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    skipFinal2 = skipFinal;
                                    if (!skipFinal2) {
                                    }
                                    throw th;
                                }
                            } else {
                                skipFinal = skipFinal2;
                            }
                            if (n <= index) {
                                index = 0;
                            }
                            int j5 = index;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= n) {
                                    innerCompleted2 = innerCompleted3;
                                    replenishMain2 = replenishMain;
                                    break;
                                }
                                innerCompleted2 = innerCompleted3;
                                Queue<Object> svq3 = svq2;
                                replenishMain2 = replenishMain;
                                if (inner[j5].id == startId) {
                                    break;
                                }
                                j5++;
                                if (j5 == n) {
                                    j5 = 0;
                                }
                                i2++;
                                innerCompleted3 = innerCompleted2;
                                replenishMain = replenishMain2;
                                svq2 = svq3;
                            }
                            index = j5;
                            this.lastIndex = j5;
                            this.lastId = inner[j5].id;
                            int j32 = index;
                            i = 0;
                            replenishMain = replenishMain2;
                            int j42 = j32;
                            while (true) {
                                if (i < n) {
                                }
                                i++;
                                r = r2;
                                d2 = d;
                                unbounded3 = unbounded2;
                                child2 = child;
                            }
                        } else {
                            innerCompleted = false;
                            skipFinal = skipFinal2;
                            child = child2;
                        }
                        if (replenishMain > 0) {
                            request(replenishMain);
                        }
                        if (innerCompleted) {
                            skipFinal2 = skipFinal;
                            child2 = child;
                            z = false;
                        } else {
                            try {
                                synchronized (this) {
                                    try {
                                        if (this.missed) {
                                            this.missed = false;
                                        } else {
                                            this.emitting = false;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        throw th;
                                    }
                                }
                                if (1 == 0) {
                                    synchronized (this) {
                                        this.emitting = false;
                                    }
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                    }
                }
                if (1 == 0) {
                    synchronized (this) {
                        this.emitting = z;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }

        boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            Queue<Throwable> e = this.errors;
            if (!this.delayErrors && e != null && !e.isEmpty()) {
                try {
                    reportError();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = RxRingBuffer.SIZE / 4;
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> parent, long id) {
            this.parent = parent;
            this.id = id;
        }

        public void onStart() {
            this.outstanding = RxRingBuffer.SIZE;
            request(RxRingBuffer.SIZE);
        }

        public void onNext(T t) {
            this.parent.tryEmit(this, t);
        }

        public void onError(Throwable e) {
            this.done = true;
            this.parent.getOrCreateErrorQueue().offer(e);
            this.parent.emit();
        }

        public void onCompleted() {
            this.done = true;
            this.parent.emit();
        }

        public void requestMore(long n) {
            int r = this.outstanding - ((int) n);
            if (r > LIMIT) {
                this.outstanding = r;
                return;
            }
            this.outstanding = RxRingBuffer.SIZE;
            int k = RxRingBuffer.SIZE - r;
            if (k > 0) {
                request(k);
            }
        }
    }
}