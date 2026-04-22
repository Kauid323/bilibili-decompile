package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableFirstStageObserver<T> extends ObservableStageObserver<T> {
    final T defaultItem;
    final boolean hasDefault;

    public ObservableFirstStageObserver(boolean hasDefault, T defaultItem) {
        this.hasDefault = hasDefault;
        this.defaultItem = defaultItem;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        complete(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (!isDone()) {
            clear();
            if (this.hasDefault) {
                complete(this.defaultItem);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }
}