package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long timeout, TimeUnit unit) {
        this.future = future;
        this.timeout = timeout;
        this.unit = unit;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        T v;
        Disposable d = Disposable.CC.empty();
        observer.onSubscribe(d);
        if (!d.isDisposed()) {
            try {
                if (this.timeout <= 0) {
                    v = this.future.get();
                } else {
                    v = this.future.get(this.timeout, this.unit);
                }
                if (!d.isDisposed()) {
                    if (v == null) {
                        observer.onComplete();
                    } else {
                        observer.onSuccess(v);
                    }
                }
            } catch (Throwable th) {
                ex = th;
                Exceptions.throwIfFatal(ex);
                if (ex instanceof ExecutionException) {
                    ex = ex.getCause();
                }
                Exceptions.throwIfFatal(ex);
                if (!d.isDisposed()) {
                    observer.onError(ex);
                }
            }
        }
    }
}