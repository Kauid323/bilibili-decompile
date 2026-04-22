package rx.internal.operators;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

public final class OperatorPublish<T> extends ConnectableObservable<T> {
    final AtomicReference<PublishSubscriber<T>> current;
    final Observable<? extends T> source;

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source) {
        final AtomicReference<PublishSubscriber<T>> curr = new AtomicReference<>();
        Observable.OnSubscribe<T> onSubscribe = new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorPublish.1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super T> child) {
                while (true) {
                    PublishSubscriber<T> r = (PublishSubscriber) curr.get();
                    if (r == null || r.isUnsubscribed()) {
                        PublishSubscriber<T> u = new PublishSubscriber<>(curr);
                        u.init();
                        if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(curr, r, u)) {
                            r = u;
                        } else {
                            continue;
                        }
                    }
                    InnerProducer<T> inner = new InnerProducer<>(r, child);
                    if (r.add(inner)) {
                        child.add(inner);
                        child.setProducer(inner);
                        return;
                    }
                }
            }
        };
        return new OperatorPublish(onSubscribe, source, curr);
    }

    public static <T, R> Observable<R> create(Observable<? extends T> source, Func1<? super Observable<T>, ? extends Observable<R>> selector) {
        return create(source, selector, false);
    }

    public static <T, R> Observable<R> create(final Observable<? extends T> source, final Func1<? super Observable<T>, ? extends Observable<R>> selector, final boolean delayError) {
        return unsafeCreate(new Observable.OnSubscribe<R>() { // from class: rx.internal.operators.OperatorPublish.2
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(final Subscriber<? super R> child) {
                final OnSubscribePublishMulticast<T> op = new OnSubscribePublishMulticast<>(RxRingBuffer.SIZE, delayError);
                Subscriber<R> subscriber = new Subscriber<R>() { // from class: rx.internal.operators.OperatorPublish.2.1
                    public void onNext(R t) {
                        child.onNext(t);
                    }

                    public void onError(Throwable e) {
                        op.unsubscribe();
                        child.onError(e);
                    }

                    public void onCompleted() {
                        op.unsubscribe();
                        child.onCompleted();
                    }

                    public void setProducer(Producer p) {
                        child.setProducer(p);
                    }
                };
                child.add(op);
                child.add(subscriber);
                ((Observable) selector.call(Observable.unsafeCreate(op))).unsafeSubscribe(subscriber);
                source.unsafeSubscribe(op.subscriber());
            }
        });
    }

    private OperatorPublish(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> source, AtomicReference<PublishSubscriber<T>> current) {
        super(onSubscribe);
        this.source = source;
        this.current = current;
    }

    public void connect(Action1<? super Subscription> connection) {
        PublishSubscriber<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isUnsubscribed()) {
                break;
            }
            PublishSubscriber<T> u = new PublishSubscriber<>(this.current);
            u.init();
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, ps, u)) {
                ps = u;
                break;
            }
        }
        boolean z = false;
        if (!ps.shouldConnect.get() && ps.shouldConnect.compareAndSet(false, true)) {
            z = true;
        }
        boolean doConnect = z;
        connection.call(ps);
        if (doConnect) {
            this.source.unsafeSubscribe(ps);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PublishSubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final AtomicReference<PublishSubscriber<T>> current;
        boolean emitting;
        boolean missed;
        final AtomicReference<InnerProducer[]> producers;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> current) {
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscArrayQueue(RxRingBuffer.SIZE) : new SpscAtomicArrayQueue(RxRingBuffer.SIZE);
            this.producers = new AtomicReference<>(EMPTY);
            this.current = current;
            this.shouldConnect = new AtomicBoolean();
        }

        void init() {
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorPublish.PublishSubscriber.1
                public void call() {
                    PublishSubscriber.this.producers.getAndSet(PublishSubscriber.TERMINATED);
                    MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(PublishSubscriber.this.current, PublishSubscriber.this, (Object) null);
                }
            }));
        }

        public void onStart() {
            request(RxRingBuffer.SIZE);
        }

        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        public void onError(Throwable e) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(e);
                dispatch();
            }
        }

        public void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.completed();
                dispatch();
            }
        }

        boolean add(InnerProducer<T> producer) {
            InnerProducer[] c;
            InnerProducer[] u;
            if (producer == null) {
                throw new NullPointerException();
            }
            do {
                c = this.producers.get();
                if (c == TERMINATED) {
                    return false;
                }
                int len = c.length;
                u = new InnerProducer[len + 1];
                System.arraycopy(c, 0, u, 0, len);
                u[len] = producer;
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.producers, c, u));
            return true;
        }

        void remove(InnerProducer<T> producer) {
            InnerProducer[] c;
            InnerProducer[] u;
            do {
                c = this.producers.get();
                if (c == EMPTY || c == TERMINATED) {
                    return;
                }
                int j2 = -1;
                int len = c.length;
                int i = 0;
                while (true) {
                    if (i >= len) {
                        break;
                    } else if (!c[i].equals(producer)) {
                        i++;
                    } else {
                        j2 = i;
                        break;
                    }
                }
                if (j2 < 0) {
                    return;
                }
                if (len == 1) {
                    u = EMPTY;
                } else {
                    InnerProducer[] u2 = new InnerProducer[len - 1];
                    System.arraycopy(c, 0, u2, 0, j2);
                    System.arraycopy(c, j2 + 1, u2, j2, (len - j2) - 1);
                    u = u2;
                }
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.producers, c, u));
        }

        boolean checkTerminated(Object term, boolean empty) {
            if (term != null) {
                if (NotificationLite.isCompleted(term)) {
                    if (empty) {
                        MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, this, (Object) null);
                        try {
                            InnerProducer<?>[] arr$ = this.producers.getAndSet(TERMINATED);
                            for (InnerProducer<?> ip : arr$) {
                                ip.child.onCompleted();
                            }
                            return true;
                        } finally {
                        }
                    }
                    return false;
                }
                Throwable t = NotificationLite.getError(term);
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, this, (Object) null);
                try {
                    InnerProducer<?>[] arr$2 = this.producers.getAndSet(TERMINATED);
                    for (InnerProducer<?> ip2 : arr$2) {
                        ip2.child.onError(t);
                    }
                    return true;
                } finally {
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:105:0x0152, code lost:
            r27.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x0157, code lost:
            if (1 != 0) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0159, code lost:
            monitor-enter(r27);
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x015b, code lost:
            r27.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x015d, code lost:
            monitor-exit(r27);
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0162, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x0163, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x0164, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x016a, code lost:
            r4 = r16;
            r3 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x0177, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x0179, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x017a, code lost:
            r4 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:200:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0135, code lost:
            if (r5 <= 0) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0137, code lost:
            request(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x013f, code lost:
            if (r13 == 0) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0141, code lost:
            if (r6 != false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0143, code lost:
            r4 = r16;
            r3 = false;
         */
        /* JADX WARN: Removed duplicated region for block: B:137:0x0182  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void dispatch() {
            boolean skipFinal;
            InnerProducer[] arr$;
            int len$;
            boolean skipFinal2;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                boolean z = false;
                this.missed = false;
                boolean skipFinal3 = false;
                while (true) {
                    try {
                        Object term = this.terminalEvent;
                        boolean empty = this.queue.isEmpty();
                        if (checkTerminated(term, empty)) {
                            if (1 == 0) {
                                synchronized (this) {
                                    this.emitting = z;
                                }
                                return;
                            }
                            return;
                        }
                        if (!empty) {
                            InnerProducer[] ps = this.producers.get();
                            int len = ps.length;
                            int unsubscribed = 0;
                            long maxRequested = Long.MAX_VALUE;
                            for (InnerProducer<T> ip : ps) {
                                try {
                                    long r = ip.get();
                                    if (r >= 0) {
                                        maxRequested = Math.min(maxRequested, r);
                                    } else if (r == Long.MIN_VALUE) {
                                        unsubscribed++;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (!skipFinal3) {
                                        synchronized (this) {
                                            this.emitting = false;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (len != unsubscribed) {
                                int d = 0;
                                Object term2 = term;
                                while (true) {
                                    if (d >= maxRequested) {
                                        skipFinal = skipFinal3;
                                        break;
                                    }
                                    Object term3 = this.terminalEvent;
                                    Object v = this.queue.poll();
                                    empty = v == null;
                                    if (checkTerminated(term3, empty)) {
                                        if (1 == 0) {
                                            synchronized (this) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        return;
                                    } else if (empty) {
                                        skipFinal = skipFinal3;
                                        term2 = term3;
                                        break;
                                    } else {
                                        Object value = NotificationLite.getValue(v);
                                        InnerProducer[] arr$2 = ps;
                                        int len$2 = arr$2.length;
                                        int i$ = 0;
                                        while (i$ < len$2) {
                                            InnerProducer ip2 = arr$2[i$];
                                            if (ip2.get() > 0) {
                                                arr$ = arr$2;
                                                ip2.child.onNext(value);
                                                len$ = len$2;
                                                skipFinal2 = skipFinal3;
                                                ip2.produced(1L);
                                            } else {
                                                arr$ = arr$2;
                                                len$ = len$2;
                                                skipFinal2 = skipFinal3;
                                            }
                                            i$++;
                                            skipFinal3 = skipFinal2;
                                            arr$2 = arr$;
                                            len$2 = len$;
                                        }
                                        d++;
                                        term2 = term3;
                                    }
                                }
                            } else {
                                if (checkTerminated(this.terminalEvent, this.queue.poll() == null)) {
                                    if (1 == 0) {
                                        synchronized (this) {
                                            this.emitting = false;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                request(1L);
                                z = false;
                            }
                        } else {
                            skipFinal = skipFinal3;
                        }
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    break;
                                }
                                this.missed = false;
                            } catch (Throwable th2) {
                                th = th2;
                                skipFinal3 = skipFinal;
                            }
                        }
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        final PublishSubscriber<T> parent;

        public InnerProducer(PublishSubscriber<T> parent, Subscriber<? super T> child) {
            this.parent = parent;
            this.child = child;
            lazySet(NOT_REQUESTED);
        }

        public void request(long n) {
            long r;
            long u;
            if (n < 0) {
                return;
            }
            do {
                r = get();
                if (r == UNSUBSCRIBED) {
                    return;
                }
                if (r >= 0 && n == 0) {
                    return;
                }
                if (r == NOT_REQUESTED) {
                    u = n;
                } else {
                    u = r + n;
                    if (u < 0) {
                        u = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(r, u));
            this.parent.dispatch();
        }

        public long produced(long n) {
            long r;
            long u;
            if (n <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                r = get();
                if (r == NOT_REQUESTED) {
                    throw new IllegalStateException("Produced without request");
                }
                if (r == UNSUBSCRIBED) {
                    return UNSUBSCRIBED;
                }
                u = r - n;
                if (u < 0) {
                    throw new IllegalStateException("More produced (" + n + ") than requested (" + r + ")");
                }
            } while (!compareAndSet(r, u));
            return u;
        }

        public boolean isUnsubscribed() {
            return get() == UNSUBSCRIBED;
        }

        public void unsubscribe() {
            long r = get();
            if (r != UNSUBSCRIBED) {
                long r2 = getAndSet(UNSUBSCRIBED);
                if (r2 != UNSUBSCRIBED) {
                    this.parent.remove(this);
                    this.parent.dispatch();
                }
            }
        }
    }
}