package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import j$.util.Objects;

public final class ObservableDefer<T> extends Observable<T> {
    final Supplier<? extends ObservableSource<? extends T>> supplier;

    public ObservableDefer(Supplier<? extends ObservableSource<? extends T>> supplier) {
        this.supplier = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            ObservableSource<? extends T> pub = (ObservableSource) Objects.requireNonNull(this.supplier.get(), "The supplier returned a null ObservableSource");
            pub.subscribe(observer);
        } catch (Throwable t) {
            Exceptions.throwIfFatal(t);
            EmptyDisposable.error(t, observer);
        }
    }
}