package rx.internal.operators;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    final int bufferSize;
    final FuncN<? extends R> combiner;
    final boolean delayError;
    final Observable<? extends T>[] sources;
    final Iterable<? extends Observable<? extends T>> sourcesIterable;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> sourcesIterable, FuncN<? extends R> combiner) {
        this(null, sourcesIterable, combiner, RxRingBuffer.SIZE, false);
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] sources, Iterable<? extends Observable<? extends T>> sourcesIterable, FuncN<? extends R> combiner, int bufferSize, boolean delayError) {
        this.sources = sources;
        this.sourcesIterable = sourcesIterable;
        this.combiner = combiner;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
    }

    public void call(Subscriber<? super R> s) {
        int count;
        Observable<? extends T>[] sources = this.sources;
        int count2 = 0;
        if (sources == null) {
            if (this.sourcesIterable instanceof List) {
                List list = (List) this.sourcesIterable;
                sources = (Observable[]) list.toArray(new Observable[list.size()]);
                int count3 = sources.length;
                count = count3;
            } else {
                sources = new Observable[8];
                for (Observable<? extends T> p : this.sourcesIterable) {
                    if (count2 == sources.length) {
                        Observable<? extends T>[] b = new Observable[(count2 >> 2) + count2];
                        System.arraycopy(sources, 0, b, 0, count2);
                        sources = b;
                    }
                    sources[count2] = p;
                    count2++;
                }
                count = count2;
            }
        } else {
            int count4 = sources.length;
            count = count4;
        }
        if (count == 0) {
            s.onCompleted();
            return;
        }
        LatestCoordinator<T, R> lc = new LatestCoordinator<>(s, this.combiner, count, this.bufferSize, this.delayError);
        lc.subscribe(sources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
        static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final FuncN<? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombinerSubscriber<T, R>[] subscribers;

        public LatestCoordinator(Subscriber<? super R> actual, FuncN<? extends R> combiner, int count, int bufferSize, boolean delayError) {
            this.actual = actual;
            this.combiner = combiner;
            this.bufferSize = bufferSize;
            this.delayError = delayError;
            this.latest = new Object[count];
            Arrays.fill(this.latest, MISSING);
            this.subscribers = new CombinerSubscriber[count];
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void subscribe(Observable<? extends T>[] sources) {
            Subscriber<T>[] as = this.subscribers;
            int len = as.length;
            for (int i = 0; i < len; i++) {
                as[i] = new CombinerSubscriber<>(this, i);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i2 = 0; i2 < len && !this.cancelled; i2++) {
                sources[i2].subscribe(as[i2]);
            }
        }

        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= required but it was " + n);
            }
            if (n != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                drain();
            }
        }

        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        void cancel(Queue<?> q) {
            q.clear();
            CombinerSubscriber<T, R>[] arr$ = this.subscribers;
            for (CombinerSubscriber<T, R> s : arr$) {
                s.unsubscribe();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
            if (r3 == rx.internal.operators.OnSubscribeCombineLatest.LatestCoordinator.MISSING) goto L61;
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0065 A[Catch: all -> 0x0076, TryCatch #3 {all -> 0x0076, blocks: (B:30:0x0044, B:40:0x0067, B:32:0x0052, B:34:0x005a, B:36:0x005e, B:38:0x0062, B:39:0x0065), top: B:69:0x003e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void combine(Object value, int index) {
            CombinerSubscriber<T, R> combinerSubscriber = this.subscribers[index];
            synchronized (this) {
                try {
                    int sourceCount = this.latest.length;
                    try {
                        Object o = this.latest[index];
                        int activeCount = this.active;
                        try {
                            if (o == MISSING) {
                                activeCount++;
                                this.active = activeCount;
                            }
                            int completedCount = this.complete;
                            try {
                                if (value == null) {
                                    completedCount++;
                                    this.complete = completedCount;
                                } else {
                                    this.latest[index] = NotificationLite.getValue(value);
                                }
                                boolean empty = false;
                                boolean allSourcesFinished = activeCount == sourceCount;
                                try {
                                    if (completedCount != sourceCount) {
                                        if (value == null) {
                                            try {
                                            } catch (Throwable th) {
                                                th = th;
                                                while (true) {
                                                    try {
                                                        break;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                        if (empty) {
                                            if (value != null && allSourcesFinished) {
                                                this.queue.offer(combinerSubscriber, this.latest.clone());
                                            } else if (value == null && this.error.get() != null && (o == MISSING || !this.delayError)) {
                                                this.done = true;
                                            }
                                        } else {
                                            this.done = true;
                                        }
                                        if (allSourcesFinished && value != null) {
                                            combinerSubscriber.requestMore(1L);
                                            return;
                                        } else {
                                            drain();
                                            return;
                                        }
                                    }
                                    if (empty) {
                                    }
                                    if (allSourcesFinished) {
                                    }
                                    drain();
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    while (true) {
                                        break;
                                        break;
                                    }
                                    throw th;
                                }
                                empty = true;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            while (true) {
                                break;
                                break;
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        while (true) {
                            break;
                            break;
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        }

        void drain() {
            int missed;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Subscriber<? super R> a = this.actual;
            boolean delayError = this.delayError;
            AtomicLong localRequested = this.requested;
            int missed2 = 1;
            Object obj = null;
            while (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), a, spscLinkedArrayQueue, delayError)) {
                long requestAmount = localRequested.get();
                Object obj2 = obj;
                long emitted = 0;
                while (true) {
                    if (emitted == requestAmount) {
                        missed = missed2;
                        break;
                    }
                    boolean d = this.done;
                    CombinerSubscriber<T, R> cs = (CombinerSubscriber) spscLinkedArrayQueue.peek();
                    boolean empty = cs == null;
                    missed = missed2;
                    long emitted2 = emitted;
                    if (checkTerminated(d, empty, a, spscLinkedArrayQueue, delayError)) {
                        return;
                    }
                    if (empty) {
                        emitted = emitted2;
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    Object[] array = (Object[]) spscLinkedArrayQueue.poll();
                    if (array == null) {
                        this.cancelled = true;
                        cancel(spscLinkedArrayQueue);
                        a.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        obj2 = this.combiner.call(array);
                        a.onNext(obj2);
                        cs.requestMore(1L);
                        emitted = emitted2 + 1;
                        missed2 = missed;
                    } catch (Throwable ex) {
                        this.cancelled = true;
                        cancel(spscLinkedArrayQueue);
                        a.onError(ex);
                        return;
                    }
                }
                if (emitted != 0 && requestAmount != Long.MAX_VALUE) {
                    BackpressureUtils.produced(localRequested, emitted);
                }
                missed2 = addAndGet(-missed);
                if (missed2 != 0) {
                    obj = obj2;
                } else {
                    return;
                }
            }
        }

        boolean checkTerminated(boolean mainDone, boolean queueEmpty, Subscriber<?> childSubscriber, Queue<?> q, boolean delayError) {
            if (this.cancelled) {
                cancel(q);
                return true;
            } else if (mainDone) {
                if (delayError) {
                    if (queueEmpty) {
                        Throwable e = this.error.get();
                        if (e != null) {
                            childSubscriber.onError(e);
                        } else {
                            childSubscriber.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable e2 = this.error.get();
                if (e2 != null) {
                    cancel(q);
                    childSubscriber.onError(e2);
                    return true;
                } else if (queueEmpty) {
                    childSubscriber.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void onError(Throwable e) {
            CompositeException compositeException;
            Throwable next;
            AtomicReference<Throwable> localError = this.error;
            do {
                compositeException = (Throwable) localError.get();
                if (compositeException != null) {
                    if (compositeException instanceof CompositeException) {
                        CompositeException ce = compositeException;
                        List<Throwable> es = new ArrayList<>(ce.getExceptions());
                        es.add(e);
                        next = new CompositeException(es);
                    } else {
                        next = new CompositeException(Arrays.asList(compositeException, e));
                    }
                } else {
                    next = e;
                }
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(localError, compositeException, next));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CombinerSubscriber<T, R> extends Subscriber<T> {
        boolean done;
        final int index;
        final LatestCoordinator<T, R> parent;

        public CombinerSubscriber(LatestCoordinator<T, R> parent, int index) {
            this.parent = parent;
            this.index = index;
            request(parent.bufferSize);
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.parent.combine(NotificationLite.next(t), this.index);
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaHooks.onError(t);
                return;
            }
            this.parent.onError(t);
            this.done = true;
            this.parent.combine(null, this.index);
        }

        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.combine(null, this.index);
        }

        public void requestMore(long n) {
            request(n);
        }
    }
}