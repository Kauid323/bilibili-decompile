package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    protected OnSubscribeFlattenIterable(Observable<? extends T> source, Func1<? super T, ? extends Iterable<? extends R>> mapper, int prefetch) {
        this.source = source;
        this.mapper = mapper;
        this.prefetch = prefetch;
    }

    public void call(Subscriber<? super R> t) {
        final FlattenIterableSubscriber<T, R> parent = new FlattenIterableSubscriber<>(t, this.mapper, this.prefetch);
        t.add(parent);
        t.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeFlattenIterable.1
            public void request(long n) {
                parent.requestMore(n);
            }
        });
        this.source.unsafeSubscribe(parent);
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> source, Func1<? super T, ? extends Iterable<? extends R>> mapper, int prefetch) {
        if (source instanceof ScalarSynchronousObservable) {
            return Observable.unsafeCreate(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) source).get(), mapper));
        }
        return Observable.unsafeCreate(new OnSubscribeFlattenIterable(source, mapper, prefetch));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        Iterator<? extends R> active;
        final Subscriber<? super R> actual;
        volatile boolean done;
        final long limit;
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        long produced;
        final Queue<Object> queue;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();

        public FlattenIterableSubscriber(Subscriber<? super R> actual, Func1<? super T, ? extends Iterable<? extends R>> mapper, int prefetch) {
            this.actual = actual;
            this.mapper = mapper;
            if (prefetch == Integer.MAX_VALUE) {
                this.limit = Long.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = prefetch - (prefetch >> 2);
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(prefetch);
                } else {
                    this.queue = new SpscAtomicArrayQueue(prefetch);
                }
            }
            request(prefetch);
        }

        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        public void onError(Throwable e) {
            if (ExceptionsUtils.addThrowable(this.error, e)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaHooks.onError(e);
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        void requestMore(long n) {
            if (n > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                drain();
            } else if (n < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + n);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:78:0x00e5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0010 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            Subscriber<? super R> subscriber;
            Queue<?> queue;
            int i;
            Iterator<? extends R> it;
            boolean z;
            int i2;
            long j2;
            long j3;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            subscriber = this.actual;
            queue = this.queue;
            i = 1;
            while (true) {
                it = this.active;
                z = false;
                if (it != null) {
                    i2 = i;
                } else {
                    boolean z2 = this.done;
                    Object poll = queue.poll();
                    boolean z3 = poll == null;
                    if (checkTerminated(z2, z3, subscriber, queue)) {
                        return;
                    }
                    if (!z3) {
                        long j4 = this.produced + 1;
                        i2 = i;
                        if (j4 == this.limit) {
                            this.produced = 0L;
                            request(j4);
                        } else {
                            this.produced = j4;
                        }
                        try {
                            it = ((Iterable) this.mapper.call(NotificationLite.getValue(poll))).iterator();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            onError(th);
                        }
                        if (!it.hasNext()) {
                            i = i2;
                        } else {
                            this.active = it;
                        }
                    } else {
                        i2 = i;
                    }
                }
                if (it != null) {
                    j2 = this.requested.get();
                    j3 = 0;
                    while (true) {
                        if (j3 == j2) {
                            break;
                        } else if (checkTerminated(this.done, false, subscriber, queue)) {
                            return;
                        } else {
                            try {
                                subscriber.onNext(it.next());
                                if (checkTerminated(this.done, false, subscriber, queue)) {
                                    return;
                                }
                                j3++;
                                try {
                                    if (!it.hasNext()) {
                                        this.active = null;
                                        it = null;
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.active = null;
                                    onError(th2);
                                    it = null;
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.active = null;
                                onError(th3);
                                it = null;
                            }
                        }
                    }
                }
                i = this.wip.addAndGet(-i2);
                if (i != 0) {
                    return;
                }
            }
            if (j3 == j2) {
                boolean z4 = this.done;
                if (queue.isEmpty() && it == null) {
                    z = true;
                }
                if (checkTerminated(z4, z, subscriber, queue)) {
                    return;
                }
            }
            if (j3 != 0) {
                BackpressureUtils.produced(this.requested, j3);
            }
            if (it == null) {
                i = i2;
            } else {
                i = this.wip.addAndGet(-i2);
                if (i != 0) {
                }
            }
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<?> a, Queue<?> q) {
            if (a.isUnsubscribed()) {
                q.clear();
                this.active = null;
                return true;
            } else if (d) {
                Throwable ex = this.error.get();
                if (ex != null) {
                    Throwable ex2 = ExceptionsUtils.terminate(this.error);
                    unsubscribe();
                    q.clear();
                    this.active = null;
                    a.onError(ex2);
                    return true;
                } else if (empty) {
                    a.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final T value;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public OnSubscribeScalarFlattenIterable(T value, Func1<? super T, ? extends Iterable<? extends R>> mapper) {
            this.value = value;
            this.mapper = mapper;
        }

        public void call(Subscriber<? super R> t) {
            try {
                Iterable<? extends R> it = (Iterable) this.mapper.call(this.value);
                Iterator<? extends R> iterator = it.iterator();
                try {
                    boolean b = iterator.hasNext();
                    if (!b) {
                        t.onCompleted();
                    } else {
                        t.setProducer(new OnSubscribeFromIterable.IterableProducer(t, iterator));
                    }
                } catch (Throwable th) {
                    ex = th;
                    Exceptions.throwOrReport(ex, t, this.value);
                }
            } catch (Throwable th2) {
                ex = th2;
            }
        }
    }
}