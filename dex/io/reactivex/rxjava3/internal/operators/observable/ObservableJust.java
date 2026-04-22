package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;

public final class ObservableJust<T> extends Observable<T> implements ScalarSupplier<T> {
    private final T value;

    public ObservableJust(final T value) {
        this.value = value;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable<T> sd = new ObservableScalarXMap.ScalarDisposable<>(observer, this.value);
        observer.onSubscribe(sd);
        sd.run();
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return this.value;
    }
}