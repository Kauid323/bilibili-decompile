package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableSingleStageObserver<T> extends ObservableStageObserver<T> {
    final T defaultItem;
    final boolean hasDefault;

    public ObservableSingleStageObserver(boolean hasDefault, T defaultItem) {
        this.hasDefault = hasDefault;
        this.defaultItem = defaultItem;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.value != null) {
            this.value = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
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