package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface MaybeOnSubscribe<T> {
    void subscribe(MaybeEmitter<T> emitter) throws Throwable;
}