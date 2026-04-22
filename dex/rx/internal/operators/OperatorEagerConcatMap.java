package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

public final class OperatorEagerConcatMap<T, R> implements Observable.Operator<R, T> {
    final int bufferSize;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    private final int maxConcurrent;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> mapper, int bufferSize, int maxConcurrent) {
        this.mapper = mapper;
        this.bufferSize = bufferSize;
        this.maxConcurrent = maxConcurrent;
    }

    public Subscriber<? super T> call(Subscriber<? super R> t) {
        EagerOuterSubscriber<T, R> outer = new EagerOuterSubscriber<>(this.mapper, this.bufferSize, this.maxConcurrent, t);
        outer.init();
        return outer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class EagerOuterProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;
        final EagerOuterSubscriber<?, ?> parent;

        public EagerOuterProducer(EagerOuterSubscriber<?, ?> parent) {
            this.parent = parent;
        }

        public void request(long n) {
            if (n < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + n);
            }
            if (n > 0) {
                BackpressureUtils.getAndAddRequest(this, n);
                this.parent.drain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class EagerOuterSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Func1<? super T, ? extends Observable<? extends R>> mapper;
        private EagerOuterProducer sharedProducer;
        final Queue<EagerInnerSubscriber<R>> subscribers = new LinkedList();
        final AtomicInteger wip = new AtomicInteger();

        public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> mapper, int bufferSize, int maxConcurrent, Subscriber<? super R> actual) {
            this.mapper = mapper;
            this.bufferSize = bufferSize;
            this.actual = actual;
            request(maxConcurrent == Integer.MAX_VALUE ? Long.MAX_VALUE : maxConcurrent);
        }

        void init() {
            this.sharedProducer = new EagerOuterProducer(this);
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.1
                public void call() {
                    EagerOuterSubscriber.this.cancelled = true;
                    if (EagerOuterSubscriber.this.wip.getAndIncrement() == 0) {
                        EagerOuterSubscriber.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.sharedProducer);
        }

        void cleanup() {
            synchronized (this.subscribers) {
                try {
                    try {
                        List<Subscription> list = new ArrayList<>(this.subscribers);
                        this.subscribers.clear();
                        for (Subscription s : list) {
                            s.unsubscribe();
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public void onNext(T t) {
            try {
                Observable<? extends R> observable = (Observable) this.mapper.call(t);
                if (this.cancelled) {
                    return;
                }
                EagerInnerSubscriber<R> inner = new EagerInnerSubscriber<>(this, this.bufferSize);
                synchronized (this.subscribers) {
                    if (this.cancelled) {
                        return;
                    }
                    this.subscribers.add(inner);
                    if (this.cancelled) {
                        return;
                    }
                    observable.unsafeSubscribe(inner);
                    drain();
                }
            } catch (Throwable e) {
                Exceptions.throwOrReport(e, this.actual, t);
            }
        }

        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:? -> B:79:0x00e1). Please submit an issue!!! */
        void drain() {
            boolean outerDone;
            EagerOuterSubscriber<T, R> eagerOuterSubscriber = this;
            if (eagerOuterSubscriber.wip.getAndIncrement() != 0) {
                return;
            }
            AtomicLong requested = eagerOuterSubscriber.sharedProducer;
            Subscriber<? super R> actualSubscriber = eagerOuterSubscriber.actual;
            int missed = 1;
            while (!eagerOuterSubscriber.cancelled) {
                boolean outerDone2 = eagerOuterSubscriber.done;
                synchronized (eagerOuterSubscriber.subscribers) {
                    try {
                        EagerInnerSubscriber<R> innerSubscriber = eagerOuterSubscriber.subscribers.peek();
                        try {
                            boolean empty = innerSubscriber == null;
                            if (outerDone2) {
                                Throwable error = eagerOuterSubscriber.error;
                                if (error != null) {
                                    cleanup();
                                    actualSubscriber.onError(error);
                                    return;
                                } else if (empty) {
                                    actualSubscriber.onCompleted();
                                    return;
                                }
                            }
                            if (!empty) {
                                long requestedAmount = requested.get();
                                long emittedAmount = 0;
                                Queue<Object> innerQueue = innerSubscriber.queue;
                                boolean innerDone = false;
                                while (true) {
                                    boolean outerDone3 = innerSubscriber.done;
                                    Object v = innerQueue.peek();
                                    boolean empty2 = v == null;
                                    if (!outerDone3) {
                                        eagerOuterSubscriber = this;
                                        outerDone = outerDone3;
                                    } else {
                                        Throwable innerError = innerSubscriber.error;
                                        if (innerError != null) {
                                            cleanup();
                                            actualSubscriber.onError(innerError);
                                            return;
                                        } else if (!empty2) {
                                            eagerOuterSubscriber = this;
                                            outerDone = outerDone3;
                                        } else {
                                            eagerOuterSubscriber = this;
                                            outerDone = outerDone3;
                                            synchronized (eagerOuterSubscriber.subscribers) {
                                                try {
                                                    eagerOuterSubscriber.subscribers.poll();
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
                                            innerSubscriber.unsubscribe();
                                            innerDone = true;
                                            eagerOuterSubscriber.request(1L);
                                            break;
                                        }
                                    }
                                    if (empty2 || requestedAmount == emittedAmount) {
                                        break;
                                    }
                                    innerQueue.poll();
                                    try {
                                        actualSubscriber.onNext(NotificationLite.getValue(v));
                                        emittedAmount++;
                                    } catch (Throwable ex) {
                                        Exceptions.throwOrReport(ex, actualSubscriber, v);
                                        return;
                                    }
                                }
                                if (emittedAmount != 0) {
                                    if (requestedAmount != Long.MAX_VALUE) {
                                        BackpressureUtils.produced(requested, emittedAmount);
                                    }
                                    if (!innerDone) {
                                        innerSubscriber.requestMore(emittedAmount);
                                    }
                                }
                                if (innerDone) {
                                    continue;
                                }
                            }
                            missed = eagerOuterSubscriber.wip.addAndGet(-missed);
                            if (missed == 0) {
                                return;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                }
            }
            cleanup();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class EagerInnerSubscriber<T> extends Subscriber<T> {
        volatile boolean done;
        Throwable error;
        final EagerOuterSubscriber<?, T> parent;
        final Queue<Object> queue;

        public EagerInnerSubscriber(EagerOuterSubscriber<?, T> parent, int bufferSize) {
            SpscArrayQueue spscAtomicArrayQueue;
            this.parent = parent;
            if (UnsafeAccess.isUnsafeAvailable()) {
                spscAtomicArrayQueue = new SpscArrayQueue(bufferSize);
            } else {
                spscAtomicArrayQueue = new SpscAtomicArrayQueue(bufferSize);
            }
            this.queue = spscAtomicArrayQueue;
            request(bufferSize);
        }

        public void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            this.parent.drain();
        }

        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            this.parent.drain();
        }

        public void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        void requestMore(long n) {
            request(n);
        }
    }
}