package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

final class SubjectSubscriptionManager<T> extends AtomicReference<State<T>> implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active;
    volatile Object latest;
    Action1<SubjectObserver<T>> onAdded;
    Action1<SubjectObserver<T>> onStart;
    Action1<SubjectObserver<T>> onTerminated;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public SubjectSubscriptionManager() {
        super(State.EMPTY);
        this.active = true;
        this.onStart = Actions.empty();
        this.onAdded = Actions.empty();
        this.onTerminated = Actions.empty();
    }

    public void call(Subscriber<? super T> child) {
        SubjectObserver<T> bo = new SubjectObserver<>(child);
        addUnsubscriber(child, bo);
        this.onStart.call(bo);
        if (!child.isUnsubscribed() && add(bo) && child.isUnsubscribed()) {
            remove(bo);
        }
    }

    void addUnsubscriber(Subscriber<? super T> child, final SubjectObserver<T> bo) {
        child.add(Subscriptions.create(new Action0() { // from class: rx.subjects.SubjectSubscriptionManager.1
            public void call() {
                SubjectSubscriptionManager.this.remove(bo);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLatest(Object value) {
        this.latest = value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getLatest() {
        return this.latest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubjectObserver<T>[] observers() {
        return get().observers;
    }

    boolean add(SubjectObserver<T> o) {
        State oldState;
        State newState;
        do {
            oldState = get();
            if (oldState.terminated) {
                this.onTerminated.call(o);
                return false;
            }
            newState = oldState.add(o);
        } while (!compareAndSet(oldState, newState));
        this.onAdded.call(o);
        return true;
    }

    void remove(SubjectObserver<T> o) {
        State oldState;
        State newState;
        do {
            oldState = get();
            if (oldState.terminated || (newState = oldState.remove(o)) == oldState) {
                return;
            }
        } while (!compareAndSet(oldState, newState));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubjectObserver<T>[] next(Object n) {
        setLatest(n);
        return get().observers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubjectObserver<T>[] terminate(Object n) {
        setLatest(n);
        this.active = false;
        State<T> oldState = get();
        if (oldState.terminated) {
            return State.NO_OBSERVERS;
        }
        return getAndSet(State.TERMINATED).observers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class State<T> {
        final SubjectObserver[] observers;
        final boolean terminated;
        static final SubjectObserver[] NO_OBSERVERS = new SubjectObserver[0];
        static final State TERMINATED = new State(true, NO_OBSERVERS);
        static final State EMPTY = new State(false, NO_OBSERVERS);

        public State(boolean terminated, SubjectObserver[] observers) {
            this.terminated = terminated;
            this.observers = observers;
        }

        public State add(SubjectObserver o) {
            SubjectObserver[] a = this.observers;
            int n = a.length;
            SubjectObserver[] b = new SubjectObserver[n + 1];
            System.arraycopy(this.observers, 0, b, 0, n);
            b[n] = o;
            return new State(this.terminated, b);
        }

        public State remove(SubjectObserver o) {
            SubjectObserver[] a = this.observers;
            int n = a.length;
            if (n == 1 && a[0] == o) {
                return EMPTY;
            }
            if (n == 0) {
                return this;
            }
            SubjectObserver[] b = new SubjectObserver[n - 1];
            int j = 0;
            for (SubjectObserver ai : a) {
                if (ai != o) {
                    if (j == n - 1) {
                        return this;
                    }
                    b[j] = ai;
                    j++;
                }
            }
            if (j == 0) {
                return EMPTY;
            }
            if (j < n - 1) {
                SubjectObserver[] c = new SubjectObserver[j];
                System.arraycopy(b, 0, c, 0, j);
                b = c;
            }
            return new State(this.terminated, b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SubjectObserver<T> implements Observer<T> {
        final Subscriber<? super T> actual;
        volatile boolean caughtUp;
        boolean emitting;
        boolean fastPath;
        boolean first = true;
        private volatile Object index;
        List<Object> queue;

        public SubjectObserver(Subscriber<? super T> actual) {
            this.actual = actual;
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable e) {
            this.actual.onError(e);
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void emitNext(Object n) {
            if (!this.fastPath) {
                synchronized (this) {
                    this.first = false;
                    if (this.emitting) {
                        if (this.queue == null) {
                            this.queue = new ArrayList();
                        }
                        this.queue.add(n);
                        return;
                    }
                    this.fastPath = true;
                }
            }
            NotificationLite.accept(this.actual, n);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void emitFirst(Object n) {
            synchronized (this) {
                if (this.first && !this.emitting) {
                    this.first = false;
                    this.emitting = n != null;
                    if (n != null) {
                        emitLoop(null, n);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0036 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emitLoop(List<Object> localQueue, Object current) {
            boolean once = true;
            boolean skipFinal = false;
            while (true) {
                if (localQueue != null) {
                    try {
                        for (Object n : localQueue) {
                            accept(n);
                        }
                    } catch (Throwable th) {
                        if (!skipFinal) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                }
                if (once) {
                    once = false;
                    accept(current);
                }
                synchronized (this) {
                    localQueue = this.queue;
                    this.queue = null;
                    if (localQueue == null) {
                        break;
                    }
                }
                if (1 != 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                    return;
                }
                return;
            }
            this.emitting = false;
            skipFinal = true;
            if (1 != 0) {
            }
        }

        void accept(Object n) {
            if (n != null) {
                NotificationLite.accept(this.actual, n);
            }
        }

        Observer<? super T> getActual() {
            return this.actual;
        }

        public <I> I index() {
            return (I) this.index;
        }

        public void index(Object newIndex) {
            this.index = newIndex;
        }
    }
}