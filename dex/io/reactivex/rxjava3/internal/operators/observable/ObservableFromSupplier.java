package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableFromSupplier<T> extends Observable<T> implements Supplier<T> {
    final Supplier<? extends T> supplier;

    public ObservableFromSupplier(Supplier<? extends T> supplier) {
        this.supplier = supplier;
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
            deferredScalarDisposable.complete(ExceptionHelper.nullCheck(this.supplier.get(), "Supplier returned a null value."));
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
        return (T) ExceptionHelper.nullCheck(this.supplier.get(), "The supplier returned a null value.");
    }
}