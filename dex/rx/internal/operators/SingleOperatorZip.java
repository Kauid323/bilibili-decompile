package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class SingleOperatorZip {
    private SingleOperatorZip() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> Single<R> zip(final Single<? extends T>[] singles, final FuncN<? extends R> zipper) {
        return Single.create(new Single.OnSubscribe<R>() { // from class: rx.internal.operators.SingleOperatorZip.1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(final SingleSubscriber<? super R> subscriber) {
                if (singles.length == 0) {
                    subscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
                    return;
                }
                final AtomicInteger wip = new AtomicInteger(singles.length);
                final AtomicBoolean once = new AtomicBoolean();
                final Object[] values = new Object[singles.length];
                CompositeSubscription compositeSubscription = new CompositeSubscription();
                subscriber.add(compositeSubscription);
                for (int i = 0; i < singles.length && !compositeSubscription.isUnsubscribed() && !once.get(); i++) {
                    final int j2 = i;
                    SingleSubscriber<T> singleSubscriber = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOperatorZip.1.1
                        public void onSuccess(T value) {
                            values[j2] = value;
                            if (wip.decrementAndGet() == 0) {
                                try {
                                    subscriber.onSuccess(zipper.call(values));
                                } catch (Throwable e) {
                                    Exceptions.throwIfFatal(e);
                                    onError(e);
                                }
                            }
                        }

                        public void onError(Throwable error) {
                            if (once.compareAndSet(false, true)) {
                                subscriber.onError(error);
                            } else {
                                RxJavaHooks.onError(error);
                            }
                        }
                    };
                    compositeSubscription.add(singleSubscriber);
                    if (!compositeSubscription.isUnsubscribed() && !once.get()) {
                        singles[i].subscribe(singleSubscriber);
                    } else {
                        return;
                    }
                }
            }
        });
    }
}