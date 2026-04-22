package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T> extends Single<T> {
    final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super T> observer) {
        Disposable d = Disposable.CC.empty();
        observer.onSubscribe(d);
        if (d.isDisposed()) {
            return;
        }
        try {
            Object obj = (Object) Objects.requireNonNull(this.callable.call(), "The callable returned a null value");
            if (!d.isDisposed()) {
                observer.onSuccess(obj);
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