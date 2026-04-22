package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableLastStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final T defaultItem;
    final boolean hasDefault;

    public FlowableLastStageSubscriber(boolean hasDefault, T defaultItem) {
        this.hasDefault = hasDefault;
        this.defaultItem = defaultItem;
    }

    public void onNext(T t) {
        this.value = t;
    }

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

    @Override // io.reactivex.rxjava3.internal.jdk8.FlowableStageSubscriber
    protected void afterSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }
}