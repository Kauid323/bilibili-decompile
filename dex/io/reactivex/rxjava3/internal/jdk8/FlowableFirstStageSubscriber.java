package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableFirstStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final T defaultItem;
    final boolean hasDefault;

    public FlowableFirstStageSubscriber(boolean hasDefault, T defaultItem) {
        this.hasDefault = hasDefault;
        this.defaultItem = defaultItem;
    }

    public void onNext(T t) {
        complete(t);
    }

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

    @Override // io.reactivex.rxjava3.internal.jdk8.FlowableStageSubscriber
    protected void afterSubscribe(Subscription s) {
        s.request(1L);
    }
}