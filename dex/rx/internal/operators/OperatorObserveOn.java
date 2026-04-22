package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.TrampolineScheduler;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class OperatorObserveOn<T> implements Observable.Operator<T, T> {
    private final int bufferSize;
    private final boolean delayError;
    private final Scheduler scheduler;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorObserveOn(Scheduler scheduler, boolean delayError) {
        this(scheduler, delayError, RxRingBuffer.SIZE);
    }

    public OperatorObserveOn(Scheduler scheduler, boolean delayError, int bufferSize) {
        this.scheduler = scheduler;
        this.delayError = delayError;
        this.bufferSize = bufferSize > 0 ? bufferSize : RxRingBuffer.SIZE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        if (this.scheduler instanceof ImmediateScheduler) {
            return child;
        }
        if (this.scheduler instanceof TrampolineScheduler) {
            return child;
        }
        ObserveOnSubscriber<T> parent = new ObserveOnSubscriber<>(this.scheduler, child, this.delayError, this.bufferSize);
        parent.init();
        return parent;
    }

    public static <T> Observable.Operator<T, T> rebatch(final int n) {
        return new Observable.Operator<T, T>() { // from class: rx.internal.operators.OperatorObserveOn.1
            public /* bridge */ /* synthetic */ Object call(Object x0) {
                return call((Subscriber) ((Subscriber) x0));
            }

            public Subscriber<? super T> call(Subscriber<? super T> child) {
                ObserveOnSubscriber<T> parent = new ObserveOnSubscriber<>(Schedulers.immediate(), child, false, n);
                parent.init();
                return parent;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ObserveOnSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;
        final boolean delayError;
        long emitted;
        Throwable error;
        volatile boolean finished;
        final int limit;
        final Queue<Object> queue;
        final Scheduler.Worker recursiveScheduler;
        final AtomicLong requested = new AtomicLong();
        final AtomicLong counter = new AtomicLong();

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> child, boolean delayError, int bufferSize) {
            this.child = child;
            this.recursiveScheduler = scheduler.createWorker();
            this.delayError = delayError;
            int calculatedSize = bufferSize > 0 ? bufferSize : RxRingBuffer.SIZE;
            this.limit = calculatedSize - (calculatedSize >> 2);
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(calculatedSize);
            } else {
                this.queue = new SpscAtomicArrayQueue(calculatedSize);
            }
            request(calculatedSize);
        }

        void init() {
            Subscriber<? super T> localChild = this.child;
            localChild.setProducer(new Producer() { // from class: rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.1
                public void request(long n) {
                    if (n > 0) {
                        BackpressureUtils.getAndAddRequest(ObserveOnSubscriber.this.requested, n);
                        ObserveOnSubscriber.this.schedule();
                    }
                }
            });
            localChild.add(this.recursiveScheduler);
            localChild.add(this);
        }

        public void onNext(T t) {
            if (isUnsubscribed() || this.finished) {
                return;
            }
            if (!this.queue.offer(NotificationLite.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                schedule();
            }
        }

        public void onCompleted() {
            if (isUnsubscribed() || this.finished) {
                return;
            }
            this.finished = true;
            schedule();
        }

        public void onError(Throwable e) {
            if (isUnsubscribed() || this.finished) {
                RxJavaHooks.onError(e);
                return;
            }
            this.error = e;
            this.finished = true;
            schedule();
        }

        protected void schedule() {
            if (this.counter.getAndIncrement() == 0) {
                this.recursiveScheduler.schedule(this);
            }
        }

        public void call() {
            long missed = 1;
            long currentEmission = this.emitted;
            Queue<Object> q = this.queue;
            Subscriber<? super T> localChild = this.child;
            do {
                long requestAmount = this.requested.get();
                while (requestAmount != currentEmission) {
                    boolean done = this.finished;
                    Object v = q.poll();
                    boolean empty = v == null;
                    if (checkTerminated(done, empty, localChild, q)) {
                        return;
                    }
                    if (empty) {
                        break;
                    }
                    localChild.onNext(NotificationLite.getValue(v));
                    currentEmission++;
                    if (currentEmission == this.limit) {
                        requestAmount = BackpressureUtils.produced(this.requested, currentEmission);
                        request(currentEmission);
                        currentEmission = 0;
                    }
                }
                if (requestAmount == currentEmission && checkTerminated(this.finished, q.isEmpty(), localChild, q)) {
                    return;
                }
                this.emitted = currentEmission;
                missed = this.counter.addAndGet(-missed);
            } while (missed != 0);
        }

        boolean checkTerminated(boolean done, boolean isEmpty, Subscriber<? super T> a, Queue<Object> q) {
            if (a.isUnsubscribed()) {
                q.clear();
                return true;
            } else if (done) {
                if (this.delayError) {
                    if (isEmpty) {
                        Throwable e = this.error;
                        try {
                            if (e != null) {
                                a.onError(e);
                            } else {
                                a.onCompleted();
                            }
                            return false;
                        } finally {
                        }
                    }
                    return false;
                }
                Throwable e2 = this.error;
                if (e2 != null) {
                    q.clear();
                    try {
                        a.onError(e2);
                        return true;
                    } finally {
                    }
                } else if (isEmpty) {
                    try {
                        a.onCompleted();
                        return true;
                    } finally {
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}