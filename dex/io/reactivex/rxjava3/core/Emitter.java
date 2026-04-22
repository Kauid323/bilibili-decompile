package io.reactivex.rxjava3.core;

public interface Emitter<T> {
    void onComplete();

    void onError(Throwable error);

    void onNext(T value);
}