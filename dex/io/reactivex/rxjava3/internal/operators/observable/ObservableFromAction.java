package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableFromAction<T> extends Observable<T> implements Supplier<T> {
    final Action action;

    public ObservableFromAction(Action action) {
        this.action = action;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        CancellableQueueFuseable<T> qs = new CancellableQueueFuseable<>();
        observer.onSubscribe(qs);
        if (!qs.isDisposed()) {
            try {
                this.action.run();
                if (!qs.isDisposed()) {
                    observer.onComplete();
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                if (!qs.isDisposed()) {
                    observer.onError(ex);
                } else {
                    RxJavaPlugins.onError(ex);
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        this.action.run();
        return null;
    }
}