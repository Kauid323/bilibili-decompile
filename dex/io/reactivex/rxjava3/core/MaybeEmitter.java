package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;

public interface MaybeEmitter<T> {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable t);

    void onSuccess(T t);

    void setCancellable(Cancellable c);

    void setDisposable(Disposable d);

    boolean tryOnError(Throwable t);
}