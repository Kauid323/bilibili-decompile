package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import j$.util.Objects;

public final class CompletableDefer extends Completable {
    final Supplier<? extends CompletableSource> completableSupplier;

    public CompletableDefer(Supplier<? extends CompletableSource> completableSupplier) {
        this.completableSupplier = completableSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        try {
            CompletableSource c = (CompletableSource) Objects.requireNonNull(this.completableSupplier.get(), "The completableSupplier returned a null CompletableSource");
            c.subscribe(observer);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            EmptyDisposable.error(e, observer);
        }
    }
}