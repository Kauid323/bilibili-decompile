package io.reactivex.rxjava3.internal.fuseable;

public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    T poll();
}