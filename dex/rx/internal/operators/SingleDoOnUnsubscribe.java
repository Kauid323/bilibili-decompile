package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class SingleDoOnUnsubscribe<T> implements Single.OnSubscribe<T> {
    final Action0 onUnsubscribe;
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleDoOnUnsubscribe(Single.OnSubscribe<T> source, Action0 onUnsubscribe) {
        this.source = source;
        this.onUnsubscribe = onUnsubscribe;
    }

    public void call(SingleSubscriber<? super T> t) {
        t.add(Subscriptions.create(this.onUnsubscribe));
        this.source.call(t);
    }
}