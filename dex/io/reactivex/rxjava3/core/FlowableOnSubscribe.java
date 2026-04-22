package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface FlowableOnSubscribe<T> {
    void subscribe(FlowableEmitter<T> emitter) throws Throwable;
}