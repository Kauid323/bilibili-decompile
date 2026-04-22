package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import j$.util.Objects;

public final class SingleDefer<T> extends Single<T> {
    final Supplier<? extends SingleSource<? extends T>> singleSupplier;

    public SingleDefer(Supplier<? extends SingleSource<? extends T>> singleSupplier) {
        this.singleSupplier = singleSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super T> observer) {
        try {
            SingleSource<? extends T> next = (SingleSource) Objects.requireNonNull(this.singleSupplier.get(), "The singleSupplier returned a null SingleSource");
            next.subscribe(observer);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            EmptyDisposable.error(e, observer);
        }
    }
}