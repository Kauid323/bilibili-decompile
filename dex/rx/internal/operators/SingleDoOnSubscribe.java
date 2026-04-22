package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

public final class SingleDoOnSubscribe<T> implements Single.OnSubscribe<T> {
    final Action0 onSubscribe;
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleDoOnSubscribe(Single.OnSubscribe<T> source, Action0 onSubscribe) {
        this.source = source;
        this.onSubscribe = onSubscribe;
    }

    public void call(SingleSubscriber<? super T> t) {
        try {
            this.onSubscribe.call();
            this.source.call(t);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            t.onError(ex);
        }
    }
}