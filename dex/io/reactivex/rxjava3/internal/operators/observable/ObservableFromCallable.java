package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Supplier<T> {
    final Callable<? extends T> callable;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.complete(ExceptionHelper.nullCheck(this.callable.call(), "Callable returned a null value."));
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            if (!deferredScalarDisposable.isDisposed()) {
                observer.onError(e);
            } else {
                RxJavaPlugins.onError(e);
            }
        }
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        return (T) ExceptionHelper.nullCheck(this.callable.call(), "The Callable returned a null value.");
    }
}