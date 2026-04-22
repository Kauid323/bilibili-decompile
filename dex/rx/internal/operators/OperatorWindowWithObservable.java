package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;

public final class OperatorWindowWithObservable<T, U> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Observable<U> other;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorWindowWithObservable(Observable<U> other) {
        this.other = other;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> child) {
        SourceSubscriber<T> sub = new SourceSubscriber<>(child);
        BoundarySubscriber<T, U> bs = new BoundarySubscriber<>(sub);
        child.add(sub);
        child.add(bs);
        sub.replaceWindow();
        this.other.unsafeSubscribe(bs);
        return sub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SourceSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        Observer<T> consumer;
        boolean emitting;
        final Object guard = new Object();
        Observable<T> producer;
        List<Object> queue;

        public SourceSubscriber(Subscriber<? super Observable<T>> child) {
            this.child = new SerializedSubscriber(child);
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void onNext(T t) {
            synchronized (this.guard) {
                try {
                    try {
                        if (this.emitting) {
                            if (this.queue == null) {
                                this.queue = new ArrayList();
                            }
                            this.queue.add(t);
                            return;
                        }
                        List<Object> localQueue = this.queue;
                        this.queue = null;
                        this.emitting = true;
                        boolean once = true;
                        boolean skipFinal = false;
                        do {
                            try {
                                drain(localQueue);
                                if (once) {
                                    once = false;
                                    emitValue(t);
                                }
                                synchronized (this.guard) {
                                    localQueue = this.queue;
                                    this.queue = null;
                                    if (localQueue == null) {
                                        this.emitting = false;
                                        skipFinal = true;
                                        if (1 == 0) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                if (!skipFinal) {
                                    synchronized (this.guard) {
                                        this.emitting = false;
                                    }
                                }
                                throw th;
                            }
                        } while (!this.child.isUnsubscribed());
                        if (0 == 0) {
                            synchronized (this.guard) {
                                this.emitting = false;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drain(List<Object> queue) {
            if (queue == null) {
                return;
            }
            for (Object o : queue) {
                if (o == OperatorWindowWithObservable.NEXT_SUBJECT) {
                    replaceSubject();
                } else if (NotificationLite.isError(o)) {
                    error(NotificationLite.getError(o));
                    return;
                } else if (NotificationLite.isCompleted(o)) {
                    complete();
                    return;
                } else {
                    emitValue(o);
                }
            }
        }

        void replaceSubject() {
            Observer<T> s = this.consumer;
            if (s != null) {
                s.onCompleted();
            }
            createNewWindow();
            this.child.onNext(this.producer);
        }

        void createNewWindow() {
            UnicastSubject<T> bus = UnicastSubject.create();
            this.consumer = bus;
            this.producer = bus;
        }

        void emitValue(T t) {
            Observer<T> s = this.consumer;
            if (s != null) {
                s.onNext(t);
            }
        }

        public void onError(Throwable e) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(NotificationLite.error(e));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(e);
            }
        }

        public void onCompleted() {
            synchronized (this.guard) {
                try {
                    try {
                        if (this.emitting) {
                            if (this.queue == null) {
                                this.queue = new ArrayList();
                            }
                            this.queue.add(NotificationLite.completed());
                            return;
                        }
                        List<Object> localQueue = this.queue;
                        this.queue = null;
                        this.emitting = true;
                        try {
                            drain(localQueue);
                            complete();
                        } catch (Throwable e) {
                            error(e);
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

        void replaceWindow() {
            synchronized (this.guard) {
                try {
                    try {
                        if (this.emitting) {
                            if (this.queue == null) {
                                this.queue = new ArrayList();
                            }
                            this.queue.add(OperatorWindowWithObservable.NEXT_SUBJECT);
                            return;
                        }
                        List<Object> localQueue = this.queue;
                        this.queue = null;
                        this.emitting = true;
                        boolean once = true;
                        boolean skipFinal = false;
                        do {
                            try {
                                drain(localQueue);
                                if (once) {
                                    once = false;
                                    replaceSubject();
                                }
                                synchronized (this.guard) {
                                    localQueue = this.queue;
                                    this.queue = null;
                                    if (localQueue == null) {
                                        this.emitting = false;
                                        skipFinal = true;
                                        if (1 == 0) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                if (!skipFinal) {
                                    synchronized (this.guard) {
                                        this.emitting = false;
                                    }
                                }
                                throw th;
                            }
                        } while (!this.child.isUnsubscribed());
                        if (0 == 0) {
                            synchronized (this.guard) {
                                this.emitting = false;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }

        void complete() {
            Observer<T> s = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (s != null) {
                s.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        void error(Throwable e) {
            Observer<T> s = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (s != null) {
                s.onError(e);
            }
            this.child.onError(e);
            unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BoundarySubscriber<T, U> extends Subscriber<U> {
        final SourceSubscriber<T> sub;

        public BoundarySubscriber(SourceSubscriber<T> sub) {
            this.sub = sub;
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void onNext(U t) {
            this.sub.replaceWindow();
        }

        public void onError(Throwable e) {
            this.sub.onError(e);
        }

        public void onCompleted() {
            this.sub.onCompleted();
        }
    }
}