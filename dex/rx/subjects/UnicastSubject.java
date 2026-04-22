package rx.subjects;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.internal.operators.BackpressureUtils;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class UnicastSubject<T> extends Subject<T, T> {
    final State<T> state;

    public static <T> UnicastSubject<T> create() {
        return create(16);
    }

    public static <T> UnicastSubject<T> create(int capacityHint) {
        State<T> state = new State<>(capacityHint, false, null);
        return new UnicastSubject<>(state);
    }

    public static <T> UnicastSubject<T> create(boolean delayError) {
        State<T> state = new State<>(16, delayError, null);
        return new UnicastSubject<>(state);
    }

    public static <T> UnicastSubject<T> create(int capacityHint, Action0 onTerminated) {
        State<T> state = new State<>(capacityHint, false, onTerminated);
        return new UnicastSubject<>(state);
    }

    public static <T> UnicastSubject<T> create(int capacityHint, Action0 onTerminated, boolean delayError) {
        State<T> state = new State<>(capacityHint, delayError, onTerminated);
        return new UnicastSubject<>(state);
    }

    private UnicastSubject(State<T> state) {
        super(state);
        this.state = state;
    }

    public void onNext(T t) {
        this.state.onNext(t);
    }

    public void onError(Throwable e) {
        this.state.onError(e);
    }

    public void onCompleted() {
        this.state.onCompleted();
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.subscriber.get() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class State<T> extends AtomicLong implements Producer, Observer<T>, Observable.OnSubscribe<T>, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        final boolean delayError;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final Queue<Object> queue;
        final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();
        final AtomicReference<Action0> terminateOnce;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public State(int capacityHint, boolean delayError, Action0 onTerminated) {
            Queue<Object> q;
            this.terminateOnce = onTerminated != null ? new AtomicReference<>(onTerminated) : null;
            this.delayError = delayError;
            if (capacityHint > 1) {
                q = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(capacityHint) : new SpscUnboundedAtomicArrayQueue<>(capacityHint);
            } else {
                q = UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            }
            this.queue = q;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean stillReplay = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.next(t));
                            stillReplay = true;
                        }
                    }
                    if (stillReplay) {
                        replay();
                        return;
                    }
                }
                Subscriber<? super T> s = this.subscriber.get();
                try {
                    s.onNext(t);
                } catch (Throwable ex) {
                    Exceptions.throwOrReport(ex, s, t);
                }
            }
        }

        public void onError(Throwable e) {
            if (!this.done) {
                doTerminate();
                this.error = e;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        try {
                            try {
                                boolean stillReplay = this.caughtUp ? false : true;
                                if (stillReplay) {
                                    replay();
                                    return;
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                }
                this.subscriber.get().onError(e);
            }
        }

        public void onCompleted() {
            if (!this.done) {
                doTerminate();
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        try {
                            try {
                                boolean stillReplay = this.caughtUp ? false : true;
                                if (stillReplay) {
                                    replay();
                                    return;
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (n > 0) {
                BackpressureUtils.getAndAddRequest(this, n);
                replay();
            } else if (this.done) {
                replay();
            }
        }

        public void call(Subscriber<? super T> subscriber) {
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscriber, (Object) null, subscriber)) {
                subscriber.add(this);
                subscriber.setProducer(this);
                return;
            }
            subscriber.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
            if (r11 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
            if (r3.isEmpty() == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
            r19.caughtUp = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0096, code lost:
            r19.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void replay() {
            boolean unlimited;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                Queue<Object> q = this.queue;
                boolean delayError = this.delayError;
                while (true) {
                    Subscriber<? super T> s = this.subscriber.get();
                    if (s == null) {
                        unlimited = false;
                    } else {
                        boolean d = this.done;
                        if (checkTerminated(d, q.isEmpty(), delayError, s)) {
                            return;
                        }
                        long r = get();
                        unlimited = r == Long.MAX_VALUE;
                        long e = 0;
                        while (r != 0) {
                            boolean d2 = this.done;
                            Object v = q.poll();
                            boolean empty = v == null;
                            if (checkTerminated(d2, empty, delayError, s)) {
                                return;
                            }
                            if (empty) {
                                break;
                            }
                            Object value = NotificationLite.getValue(v);
                            try {
                                s.onNext(value);
                                r--;
                                e++;
                            } catch (Throwable ex) {
                                q.clear();
                                Exceptions.throwIfFatal(ex);
                                s.onError(OnErrorThrowable.addValueAsLastCause(ex, value));
                                return;
                            }
                        }
                        if (!unlimited && e != 0) {
                            addAndGet(-e);
                        }
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            break;
                        }
                        this.missed = false;
                    }
                }
            }
        }

        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (this.emitting) {
                    return;
                }
                this.emitting = true;
                this.queue.clear();
            }
        }

        public boolean isUnsubscribed() {
            return this.done;
        }

        boolean checkTerminated(boolean done, boolean empty, boolean delayError, Subscriber<? super T> s) {
            if (s.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (done) {
                Throwable e = this.error;
                if (e != null && !delayError) {
                    this.queue.clear();
                    s.onError(e);
                    return true;
                } else if (empty) {
                    if (e != null) {
                        s.onError(e);
                    } else {
                        s.onCompleted();
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void doTerminate() {
            Action0 a;
            AtomicReference<Action0> ref = this.terminateOnce;
            if (ref != null && (a = ref.get()) != null && MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(ref, a, (Object) null)) {
                a.call();
            }
        }
    }
}