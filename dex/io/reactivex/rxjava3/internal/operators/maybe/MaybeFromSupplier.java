package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeFromSupplier<T> extends Maybe<T> implements Supplier<T> {
    final Supplier<? extends T> supplier;

    public MaybeFromSupplier(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        Disposable d = Disposable.CC.empty();
        observer.onSubscribe(d);
        if (!d.isDisposed()) {
            try {
                Object obj = (T) this.supplier.get();
                if (!d.isDisposed()) {
                    if (obj == null) {
                        observer.onComplete();
                    } else {
                        observer.onSuccess(obj);
                    }
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                if (!d.isDisposed()) {
                    observer.onError(ex);
                } else {
                    RxJavaPlugins.onError(ex);
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        return this.supplier.get();
    }
}