package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;

public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> a, T v);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int m);
}