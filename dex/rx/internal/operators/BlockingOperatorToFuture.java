package rx.internal.operators;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public final class BlockingOperatorToFuture {
    private BlockingOperatorToFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> toFuture(Observable<? extends T> that) {
        final CountDownLatch finished = new CountDownLatch(1);
        final AtomicReference<T> value = new AtomicReference<>();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final Subscription s = that.single().subscribe(new Subscriber<T>() { // from class: rx.internal.operators.BlockingOperatorToFuture.1
            public void onCompleted() {
                finished.countDown();
            }

            public void onError(Throwable e) {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(error, (Object) null, e);
                finished.countDown();
            }

            public void onNext(T v) {
                value.set(v);
            }
        });
        return new Future<T>() { // from class: rx.internal.operators.BlockingOperatorToFuture.2
            private volatile boolean cancelled;

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean mayInterruptIfRunning) {
                if (finished.getCount() > 0) {
                    this.cancelled = true;
                    s.unsubscribe();
                    finished.countDown();
                    return true;
                }
                return false;
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return this.cancelled;
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return finished.getCount() == 0;
            }

            @Override // java.util.concurrent.Future
            public T get() throws InterruptedException, ExecutionException {
                finished.await();
                return getValue();
            }

            @Override // java.util.concurrent.Future
            public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                if (finished.await(timeout, unit)) {
                    return getValue();
                }
                throw new TimeoutException("Timed out after " + unit.toMillis(timeout) + "ms waiting for underlying Observable.");
            }

            private T getValue() throws ExecutionException {
                Throwable throwable = (Throwable) error.get();
                if (throwable != null) {
                    throw new ExecutionException("Observable onError", throwable);
                }
                if (this.cancelled) {
                    throw new CancellationException("Subscription unsubscribed");
                }
                return (T) value.get();
            }
        };
    }
}