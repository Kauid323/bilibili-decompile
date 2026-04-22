package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;

public final class SingleFromCallable<T> implements Single.OnSubscribe<T> {
    final Callable<? extends T> callable;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public void call(SingleSubscriber<? super T> t) {
        try {
            T v = this.callable.call();
            t.onSuccess(v);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            t.onError(ex);
        }
    }
}