package rx.internal.operators;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Holder {
        static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return (OperatorOnBackpressureLatest<T>) Holder.INSTANCE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        LatestEmitter<T> producer = new LatestEmitter<>(child);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(producer);
        producer.parent = latestSubscriber;
        child.add(latestSubscriber);
        child.add(producer);
        child.setProducer(producer);
        return latestSubscriber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final Subscriber<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        LatestSubscriber<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> child) {
            this.child = child;
            lazySet(NOT_REQUESTED);
        }

        public void request(long n) {
            long r;
            long u;
            if (n >= 0) {
                do {
                    r = get();
                    if (r == Long.MIN_VALUE) {
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
                if (r == NOT_REQUESTED) {
                    this.parent.requestMore(Long.MAX_VALUE);
                }
                emit();
            }
        }

        long produced(long n) {
            long r;
            long u;
            do {
                r = get();
                if (r < 0) {
                    return r;
                }
                u = r - n;
            } while (!compareAndSet(r, u));
            return u;
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        public void onError(Throwable e) {
            this.terminal = e;
            this.done = true;
            emit();
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
            r8.emitting = false;
            r1 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                boolean skipFinal = false;
                while (true) {
                    try {
                        long r = get();
                        if (r == Long.MIN_VALUE) {
                            skipFinal = true;
                            break;
                        }
                        Object v = this.value.get();
                        if (r > 0 && v != EMPTY) {
                            this.child.onNext(v);
                            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.value, v, EMPTY);
                            produced(1L);
                            v = EMPTY;
                        }
                        if (v == EMPTY && this.done) {
                            Throwable e = this.terminal;
                            if (e != null) {
                                this.child.onError(e);
                            } else {
                                this.child.onCompleted();
                            }
                        }
                        synchronized (this) {
                            if (!this.missed) {
                                break;
                            }
                            this.missed = false;
                        }
                        break;
                    } catch (Throwable th) {
                        if (!skipFinal) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                }
                if (!skipFinal) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        LatestSubscriber(LatestEmitter<T> producer) {
            this.producer = producer;
        }

        public void onStart() {
            request(0L);
        }

        public void onNext(T t) {
            this.producer.onNext(t);
        }

        public void onError(Throwable e) {
            this.producer.onError(e);
        }

        public void onCompleted() {
            this.producer.onCompleted();
        }

        void requestMore(long n) {
            request(n);
        }
    }
}