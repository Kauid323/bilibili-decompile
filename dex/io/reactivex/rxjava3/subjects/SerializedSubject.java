package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* JADX INFO: Access modifiers changed from: package-private */
public final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    final Subject<T> actual;
    volatile boolean done;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SerializedSubject(final Subject<T> actual) {
        this.actual = actual;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.actual.subscribe(observer);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable d) {
        boolean cancel;
        if (!this.done) {
            synchronized (this) {
                if (this.done) {
                    cancel = true;
                } else {
                    boolean cancel2 = this.emitting;
                    if (cancel2) {
                        AppendOnlyLinkedArrayList<Object> q = this.queue;
                        if (q == null) {
                            q = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = q;
                        }
                        q.add(NotificationLite.disposable(d));
                        return;
                    }
                    this.emitting = true;
                    cancel = false;
                }
            }
        } else {
            cancel = true;
        }
        if (cancel) {
            d.dispose();
            return;
        }
        this.actual.onSubscribe(d);
        emitLoop();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> q = this.queue;
                if (q == null) {
                    q = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = q;
                }
                q.add(NotificationLite.next(t));
                return;
            }
            this.emitting = true;
            this.actual.onNext(t);
            emitLoop();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        boolean reportError;
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        synchronized (this) {
            if (this.done) {
                reportError = true;
            } else {
                this.done = true;
                if (this.emitting) {
                    AppendOnlyLinkedArrayList<Object> q = this.queue;
                    if (q == null) {
                        q = new AppendOnlyLinkedArrayList<>(4);
                        this.queue = q;
                    }
                    q.setFirst(NotificationLite.error(t));
                    return;
                }
                this.emitting = true;
                reportError = false;
            }
            if (reportError) {
                RxJavaPlugins.onError(t);
            } else {
                this.actual.onError(t);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.done) {
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> q = this.queue;
                if (q == null) {
                    q = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = q;
                }
                q.add(NotificationLite.complete());
                return;
            }
            this.emitting = true;
            this.actual.onComplete();
        }
    }

    void emitLoop() {
        AppendOnlyLinkedArrayList<Object> q;
        while (true) {
            synchronized (this) {
                q = this.queue;
                if (q == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            q.forEachWhile(this);
        }
    }

    @Override // io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.rxjava3.functions.Predicate
    public boolean test(Object o) {
        return NotificationLite.acceptFull(o, this.actual);
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasObservers() {
        return this.actual.hasObservers();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasThrowable() {
        return this.actual.hasThrowable();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public Throwable getThrowable() {
        return this.actual.getThrowable();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasComplete() {
        return this.actual.hasComplete();
    }
}