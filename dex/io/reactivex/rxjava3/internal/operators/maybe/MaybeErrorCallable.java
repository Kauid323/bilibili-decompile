package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class MaybeErrorCallable<T> extends Maybe<T> {
    final Supplier<? extends Throwable> errorSupplier;

    public MaybeErrorCallable(Supplier<? extends Throwable> errorSupplier) {
        this.errorSupplier = errorSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        observer.onSubscribe(Disposable.CC.disposed());
        try {
            ex1 = (Throwable) ExceptionHelper.nullCheck(this.errorSupplier.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            ex1 = th;
            Exceptions.throwIfFatal(ex1);
        }
        observer.onError(ex1);
    }
}