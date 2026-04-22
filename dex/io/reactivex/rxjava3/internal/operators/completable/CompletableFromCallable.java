package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class CompletableFromCallable extends Completable {
    final Callable<?> callable;

    public CompletableFromCallable(Callable<?> callable) {
        this.callable = callable;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        Disposable d = Disposable.CC.empty();
        observer.onSubscribe(d);
        try {
            this.callable.call();
            if (!d.isDisposed()) {
                observer.onComplete();
            }
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            if (!d.isDisposed()) {
                observer.onError(e);
            } else {
                RxJavaPlugins.onError(e);
            }
        }
    }
}