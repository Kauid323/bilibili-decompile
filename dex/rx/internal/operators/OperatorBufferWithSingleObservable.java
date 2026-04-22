package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing> implements Observable.Operator<List<T>, T> {
    final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
    final int initialCapacity;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> bufferClosingSelector, int initialCapacity) {
        this.bufferClosingSelector = bufferClosingSelector;
        this.initialCapacity = initialCapacity;
    }

    public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> bufferClosing, int initialCapacity) {
        this.bufferClosingSelector = new Func0<Observable<? extends TClosing>>() { // from class: rx.internal.operators.OperatorBufferWithSingleObservable.1
            public Observable<? extends TClosing> call() {
                return bufferClosing;
            }
        };
        this.initialCapacity = initialCapacity;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> child) {
        try {
            Observable<? extends TClosing> closing = (Observable) this.bufferClosingSelector.call();
            final OperatorBufferWithSingleObservable<T, TClosing>.BufferingSubscriber s = new BufferingSubscriber(new SerializedSubscriber(child));
            Subscriber<TClosing> closingSubscriber = new Subscriber<TClosing>() { // from class: rx.internal.operators.OperatorBufferWithSingleObservable.2
                public void onNext(TClosing t) {
                    s.emit();
                }

                public void onError(Throwable e) {
                    s.onError(e);
                }

                public void onCompleted() {
                    s.onCompleted();
                }
            };
            child.add(closingSubscriber);
            child.add(s);
            closing.unsafeSubscribe(closingSubscriber);
            return s;
        } catch (Throwable t) {
            Exceptions.throwOrReport(t, child);
            return Subscribers.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> child) {
            this.child = child;
            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        }

        public void onNext(T t) {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.chunk.add(t);
            }
        }

        public void onError(Throwable e) {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                this.chunk = null;
                this.child.onError(e);
                unsubscribe();
            }
        }

        public void onCompleted() {
            try {
                synchronized (this) {
                    try {
                        try {
                            if (this.done) {
                                return;
                            }
                            this.done = true;
                            List<T> toEmit = this.chunk;
                            this.chunk = null;
                            this.child.onNext(toEmit);
                            this.child.onCompleted();
                            unsubscribe();
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable t) {
                Exceptions.throwOrReport(t, this.child);
            }
        }

        void emit() {
            synchronized (this) {
                try {
                    try {
                        if (this.done) {
                            return;
                        }
                        List<T> toEmit = this.chunk;
                        this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
                        try {
                            this.child.onNext(toEmit);
                        } catch (Throwable t) {
                            unsubscribe();
                            synchronized (this) {
                                if (this.done) {
                                    return;
                                }
                                this.done = true;
                                Exceptions.throwOrReport(t, this.child);
                            }
                        }
                    } catch (Throwable th) {
                        t = th;
                        throw t;
                    }
                } catch (Throwable th2) {
                    t = th2;
                }
            }
        }
    }
}