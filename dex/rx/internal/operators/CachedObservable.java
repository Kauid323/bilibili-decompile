package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    public static <T> CachedObservable<T> from(Observable<? extends T> source) {
        return from(source, 16);
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> source, int capacityHint) {
        if (capacityHint < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required");
        }
        CacheState<T> state = new CacheState<>(source, capacityHint);
        CachedSubscribe<T> onSubscribe = new CachedSubscribe<>(state);
        return new CachedObservable<>(onSubscribe, state);
    }

    private CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> state) {
        super(onSubscribe);
        this.state = state;
    }

    boolean isConnected() {
        return this.state.isConnected;
    }

    boolean hasObservers() {
        return this.state.producers.length != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        final SerialSubscription connection;
        volatile boolean isConnected;
        volatile ReplayProducer<?>[] producers;
        final Observable<? extends T> source;
        boolean sourceDone;

        public CacheState(Observable<? extends T> source, int capacityHint) {
            super(capacityHint);
            this.source = source;
            this.producers = EMPTY;
            this.connection = new SerialSubscription();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void addProducer(ReplayProducer<T> p) {
            synchronized (this.connection) {
                ReplayProducer<?>[] a = this.producers;
                int n = a.length;
                ReplayProducer<?>[] b = new ReplayProducer[n + 1];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = p;
                this.producers = b;
            }
        }

        public void removeProducer(ReplayProducer<T> p) {
            synchronized (this.connection) {
                ReplayProducer<?>[] a = this.producers;
                int n = a.length;
                int j2 = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (!a[i].equals(p)) {
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
                    this.producers = EMPTY;
                    return;
                }
                ReplayProducer<?>[] b = new ReplayProducer[n - 1];
                System.arraycopy(a, 0, b, 0, j2);
                System.arraycopy(a, j2 + 1, b, j2, (n - j2) - 1);
                this.producers = b;
            }
        }

        public void connect() {
            Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.CachedObservable.CacheState.1
                public void onNext(T t) {
                    CacheState.this.onNext(t);
                }

                public void onError(Throwable e) {
                    CacheState.this.onError(e);
                }

                public void onCompleted() {
                    CacheState.this.onCompleted();
                }
            };
            this.connection.set(subscriber);
            this.source.unsafeSubscribe(subscriber);
            this.isConnected = true;
        }

        public void onNext(T t) {
            if (!this.sourceDone) {
                Object o = NotificationLite.next(t);
                add(o);
                dispatch();
            }
        }

        public void onError(Throwable e) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                Object o = NotificationLite.error(e);
                add(o);
                this.connection.unsubscribe();
                dispatch();
            }
        }

        public void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                Object o = NotificationLite.completed();
                add(o);
                this.connection.unsubscribe();
                dispatch();
            }
        }

        void dispatch() {
            ReplayProducer<?>[] a = this.producers;
            for (ReplayProducer<?> rp : a) {
                rp.replay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final CacheState<T> state;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public CachedSubscribe(CacheState<T> state) {
            this.state = state;
        }

        public void call(Subscriber<? super T> t) {
            ReplayProducer<T> rp = new ReplayProducer<>(t, this.state);
            this.state.addProducer(rp);
            t.add(rp);
            t.setProducer(rp);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> child, CacheState<T> state) {
            this.child = child;
            this.state = state;
        }

        public void request(long n) {
            long r;
            long u;
            do {
                r = get();
                if (r < 0) {
                    return;
                }
                u = r + n;
                if (u < 0) {
                    u = Long.MAX_VALUE;
                }
            } while (!compareAndSet(r, u));
            replay();
        }

        public long produced(long n) {
            return addAndGet(-n);
        }

        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public void unsubscribe() {
            long r = get();
            if (r >= 0) {
                long r2 = getAndSet(-1L);
                if (r2 >= 0) {
                    this.state.removeProducer(this);
                }
            }
        }

        public void replay() {
            Object[] b;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                try {
                    Subscriber<? super T> child = this.child;
                    while (true) {
                        long r = get();
                        if (r < 0) {
                            if (1 == 0) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                                return;
                            }
                            return;
                        }
                        int s = this.state.size();
                        if (s != 0) {
                            Object[] b2 = this.currentBuffer;
                            if (b2 == null) {
                                Object[] b3 = this.state.head();
                                this.currentBuffer = b3;
                                b = b3;
                            } else {
                                b = b2;
                            }
                            int n = b.length - 1;
                            int j2 = this.index;
                            int k = this.currentIndexInBuffer;
                            if (r == 0) {
                                Object o = b[k];
                                if (NotificationLite.isCompleted(o)) {
                                    child.onCompleted();
                                    unsubscribe();
                                    if (1 == 0) {
                                        synchronized (this) {
                                            this.emitting = false;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (NotificationLite.isError(o)) {
                                    child.onError(NotificationLite.getError(o));
                                    unsubscribe();
                                    if (1 == 0) {
                                        synchronized (this) {
                                            this.emitting = false;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            } else if (r > 0) {
                                int k2 = k;
                                int valuesProduced = 0;
                                int j3 = j2;
                                long r2 = r;
                                while (j3 < s && r2 > 0) {
                                    if (child.isUnsubscribed()) {
                                        if (1 == 0) {
                                            synchronized (this) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    if (k2 == n) {
                                        k2 = 0;
                                        b = (Object[]) b[n];
                                    }
                                    if (NotificationLite.accept(child, b[k2])) {
                                        unsubscribe();
                                        if (1 == 0) {
                                            synchronized (this) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    k2++;
                                    j3++;
                                    r2--;
                                    valuesProduced++;
                                }
                                if (child.isUnsubscribed()) {
                                    if (1 == 0) {
                                        synchronized (this) {
                                            this.emitting = false;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                this.index = j3;
                                this.currentIndexInBuffer = k2;
                                this.currentBuffer = b;
                                produced(valuesProduced);
                            }
                        }
                        synchronized (this) {
                            if (this.missed) {
                                this.missed = false;
                            } else {
                                this.emitting = false;
                            }
                        }
                        if (1 == 0) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    if (0 == 0) {
                        synchronized (this) {
                            this.emitting = false;
                        }
                    }
                    throw th;
                }
            }
        }
    }
}