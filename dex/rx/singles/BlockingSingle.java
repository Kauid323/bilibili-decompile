package rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.util.BlockingUtils;

public final class BlockingSingle<T> {
    private final Single<? extends T> single;

    private BlockingSingle(Single<? extends T> single) {
        this.single = single;
    }

    public static <T> BlockingSingle<T> from(Single<? extends T> single) {
        return new BlockingSingle<>(single);
    }

    public T value() {
        final AtomicReference<T> returnItem = new AtomicReference<>();
        final AtomicReference<Throwable> returnException = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);
        Subscription subscription = this.single.subscribe(new SingleSubscriber<T>() { // from class: rx.singles.BlockingSingle.1
            public void onSuccess(T value) {
                returnItem.set(value);
                latch.countDown();
            }

            public void onError(Throwable error) {
                returnException.set(error);
                latch.countDown();
            }
        });
        BlockingUtils.awaitForComplete(latch, subscription);
        Throwable throwable = returnException.get();
        if (throwable != null) {
            throw Exceptions.propagate(throwable);
        }
        return returnItem.get();
    }

    public Future<T> toFuture() {
        return BlockingOperatorToFuture.toFuture(this.single.toObservable());
    }
}