package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class BufferUntilSubscriber<T> extends Subject<T, T> {
    static final Observer EMPTY_OBSERVER = new Observer() { // from class: rx.internal.operators.BufferUntilSubscriber.1
        public void onCompleted() {
        }

        public void onError(Throwable e) {
        }

        public void onNext(Object t) {
        }
    };
    private boolean forward;
    final State<T> state;

    public static <T> BufferUntilSubscriber<T> create() {
        State<T> state = new State<>();
        return new BufferUntilSubscriber<>(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class State<T> extends AtomicReference<Observer<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        boolean emitting;
        final Object guard = new Object();
        final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        State() {
        }

        boolean casObserverRef(Observer<? super T> expected, Observer<? super T> next) {
            return compareAndSet(expected, next);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class OnSubscribeAction<T> implements Observable.OnSubscribe<T> {
        final State<T> state;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public OnSubscribeAction(State<T> state) {
            this.state = state;
        }

        public void call(Subscriber<? super T> s) {
            if (this.state.casObserverRef(null, s)) {
                s.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction.1
                    public void call() {
                        OnSubscribeAction.this.state.set(BufferUntilSubscriber.EMPTY_OBSERVER);
                    }
                }));
                boolean win = false;
                synchronized (this.state.guard) {
                    if (!this.state.emitting) {
                        this.state.emitting = true;
                        win = true;
                    }
                }
                if (!win) {
                    return;
                }
                while (true) {
                    Object o = this.state.buffer.poll();
                    if (o != null) {
                        NotificationLite.accept(this.state.get(), o);
                    } else {
                        synchronized (this.state.guard) {
                            if (this.state.buffer.isEmpty()) {
                                this.state.emitting = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                s.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    private BufferUntilSubscriber(State<T> state) {
        super(new OnSubscribeAction(state));
        this.state = state;
    }

    private void emit(Object v) {
        synchronized (this.state.guard) {
            this.state.buffer.add(v);
            if (this.state.get() != null && !this.state.emitting) {
                this.forward = true;
                this.state.emitting = true;
            }
        }
        if (!this.forward) {
            return;
        }
        while (true) {
            Object o = this.state.buffer.poll();
            if (o != null) {
                NotificationLite.accept(this.state.get(), o);
            } else {
                return;
            }
        }
    }

    public void onCompleted() {
        if (this.forward) {
            this.state.get().onCompleted();
        } else {
            emit(NotificationLite.completed());
        }
    }

    public void onError(Throwable e) {
        if (this.forward) {
            this.state.get().onError(e);
        } else {
            emit(NotificationLite.error(e));
        }
    }

    public void onNext(T t) {
        if (this.forward) {
            this.state.get().onNext(t);
        } else {
            emit(NotificationLite.next(t));
        }
    }

    public boolean hasObservers() {
        boolean z;
        synchronized (this.state.guard) {
            z = this.state.get() != null;
        }
        return z;
    }
}