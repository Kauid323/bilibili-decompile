package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface ObservableOnSubscribe<T> {
    void subscribe(ObservableEmitter<T> emitter) throws Throwable;
}