package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayError;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Holder {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);

        Holder() {
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class HolderDelayError {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);

        HolderDelayError() {
        }
    }

    public static <T> OperatorSwitch<T> instance(boolean delayError) {
        if (delayError) {
            return (OperatorSwitch<T>) HolderDelayError.INSTANCE;
        }
        return (OperatorSwitch<T>) Holder.INSTANCE;
    }

    OperatorSwitch(boolean delayError) {
        this.delayError = delayError;
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> child) {
        SwitchSubscriber<T> sws = new SwitchSubscriber<>(child, this.delayError);
        child.add(sws);
        sws.init();
        return sws;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        final Subscriber<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        boolean innerActive;
        volatile boolean mainDone;
        boolean missed;
        Producer producer;
        long requested;
        final SerialSubscription serial = new SerialSubscription();
        final AtomicLong index = new AtomicLong();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);

        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        SwitchSubscriber(Subscriber<? super T> child, boolean delayError) {
            this.child = child;
            this.delayError = delayError;
        }

        void init() {
            this.child.add(this.serial);
            this.child.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorSwitch.SwitchSubscriber.1
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorSwitch.SwitchSubscriber.2
                public void request(long n) {
                    if (n > 0) {
                        SwitchSubscriber.this.childRequested(n);
                    } else if (n < 0) {
                        throw new IllegalArgumentException("n >= 0 expected but it was " + n);
                    }
                }
            });
        }

        void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public void onNext(Observable<? extends T> t) {
            long id = this.index.incrementAndGet();
            Subscription s = this.serial.get();
            if (s != null) {
                s.unsubscribe();
            }
            synchronized (this) {
                try {
                    try {
                        InnerSubscriber<T> inner = new InnerSubscriber<>(id, this);
                        this.innerActive = true;
                        this.producer = null;
                        this.serial.set(inner);
                        t.unsafeSubscribe(inner);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public void onError(Throwable e) {
            synchronized (this) {
                try {
                    try {
                        boolean success = updateError(e);
                        if (success) {
                            this.mainDone = true;
                            drain();
                            return;
                        }
                        pluginError(e);
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

        boolean updateError(Throwable next) {
            CompositeException compositeException = this.error;
            if (compositeException == TERMINAL_ERROR) {
                return false;
            }
            if (compositeException == null) {
                this.error = next;
            } else if (compositeException instanceof CompositeException) {
                List<Throwable> list = new ArrayList<>(compositeException.getExceptions());
                list.add(next);
                this.error = new CompositeException(list);
            } else {
                this.error = new CompositeException(new Throwable[]{compositeException, next});
            }
            return true;
        }

        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        void emit(T value, InnerSubscriber<T> inner) {
            synchronized (this) {
                if (this.index.get() != ((InnerSubscriber) inner).id) {
                    return;
                }
                this.queue.offer(inner, NotificationLite.next(value));
                drain();
            }
        }

        void error(Throwable e, long id) {
            boolean success;
            synchronized (this) {
                try {
                    try {
                        if (this.index.get() == id) {
                            success = updateError(e);
                            this.innerActive = false;
                            this.producer = null;
                        } else {
                            success = true;
                        }
                        if (success) {
                            drain();
                        } else {
                            pluginError(e);
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

        void complete(long id) {
            synchronized (this) {
                if (this.index.get() != id) {
                    return;
                }
                this.innerActive = false;
                this.producer = null;
                drain();
            }
        }

        void pluginError(Throwable e) {
            RxJavaHooks.onError(e);
        }

        void innerProducer(Producer p, long id) {
            synchronized (this) {
                try {
                    try {
                        if (this.index.get() != id) {
                            return;
                        }
                        long n = this.requested;
                        this.producer = p;
                        p.request(n);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        void childRequested(long n) {
            synchronized (this) {
                try {
                    try {
                        Producer p = this.producer;
                        this.requested = BackpressureUtils.addCap(this.requested, n);
                        if (p != null) {
                            p.request(n);
                        }
                        drain();
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

        void drain() {
            synchronized (this) {
                try {
                    try {
                        if (this.emitting) {
                            this.missed = true;
                            return;
                        }
                        this.emitting = true;
                        boolean localInnerActive = this.innerActive;
                        try {
                            long localRequested = this.requested;
                            try {
                                Throwable localError = this.error;
                                if (localError != null && localError != TERMINAL_ERROR && !this.delayError) {
                                    this.error = TERMINAL_ERROR;
                                }
                                SpscLinkedArrayQueue<Object> localQueue = this.queue;
                                AtomicLong localIndex = this.index;
                                Subscriber<? super T> localChild = this.child;
                                boolean localMainDone = this.mainDone;
                                long localRequested2 = localRequested;
                                Throwable localError2 = localError;
                                boolean localInnerActive2 = localInnerActive;
                                while (true) {
                                    long localEmission = 0;
                                    while (localEmission != localRequested2) {
                                        if (localChild.isUnsubscribed()) {
                                            return;
                                        }
                                        boolean empty = localQueue.isEmpty();
                                        if (checkTerminated(localMainDone, localInnerActive2, localError2, localQueue, localChild, empty)) {
                                            return;
                                        }
                                        if (empty) {
                                            break;
                                        }
                                        InnerSubscriber<T> inner = (InnerSubscriber) localQueue.poll();
                                        Object value = NotificationLite.getValue(localQueue.poll());
                                        if (localIndex.get() == ((InnerSubscriber) inner).id) {
                                            localChild.onNext(value);
                                            localEmission++;
                                        }
                                    }
                                    if (localEmission == localRequested2) {
                                        if (localChild.isUnsubscribed()) {
                                            return;
                                        }
                                        if (checkTerminated(this.mainDone, localInnerActive2, localError2, localQueue, localChild, localQueue.isEmpty())) {
                                            return;
                                        }
                                    }
                                    synchronized (this) {
                                        long localRequested3 = this.requested;
                                        if (localRequested3 == Long.MAX_VALUE) {
                                            localRequested2 = localRequested3;
                                        } else {
                                            localRequested2 = localRequested3 - localEmission;
                                            this.requested = localRequested2;
                                        }
                                        if (!this.missed) {
                                            this.emitting = false;
                                            return;
                                        }
                                        this.missed = false;
                                        localMainDone = this.mainDone;
                                        localInnerActive2 = this.innerActive;
                                        localError2 = this.error;
                                        if (localError2 != null && localError2 != TERMINAL_ERROR && !this.delayError) {
                                            this.error = TERMINAL_ERROR;
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }

        protected boolean checkTerminated(boolean localMainDone, boolean localInnerActive, Throwable localError, SpscLinkedArrayQueue<Object> localQueue, Subscriber<? super T> localChild, boolean empty) {
            if (this.delayError) {
                if (localMainDone && !localInnerActive && empty) {
                    if (localError != null) {
                        localChild.onError(localError);
                    } else {
                        localChild.onCompleted();
                    }
                    return true;
                }
                return false;
            } else if (localError != null) {
                localQueue.clear();
                localChild.onError(localError);
                return true;
            } else if (localMainDone && !localInnerActive && empty) {
                localChild.onCompleted();
                return true;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerSubscriber<T> extends Subscriber<T> {
        private final long id;
        private final SwitchSubscriber<T> parent;

        InnerSubscriber(long id, SwitchSubscriber<T> parent) {
            this.id = id;
            this.parent = parent;
        }

        public void setProducer(Producer p) {
            this.parent.innerProducer(p, this.id);
        }

        public void onNext(T t) {
            this.parent.emit(t, this);
        }

        public void onError(Throwable e) {
            this.parent.error(e, this.id);
        }

        public void onCompleted() {
            this.parent.complete(this.id);
        }
    }
}