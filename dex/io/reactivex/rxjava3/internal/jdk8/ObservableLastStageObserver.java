package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableLastStageObserver<T> extends ObservableStageObserver<T> {
    final T defaultItem;
    final boolean hasDefault;

    public ObservableLastStageObserver(boolean hasDefault, T defaultItem) {
        this.hasDefault = hasDefault;
        this.defaultItem = defaultItem;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.value = t;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (!isDone()) {
            T v = this.value;
            clear();
            if (v != null) {
                complete(v);
            } else if (this.hasDefault) {
                complete(this.defaultItem);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }
}