package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;
import rx.subscriptions.Subscriptions;

public class OperatorDoOnUnsubscribe<T> implements Observable.Operator<T, T> {
    private final Action0 unsubscribe;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDoOnUnsubscribe(Action0 unsubscribe) {
        this.unsubscribe = unsubscribe;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        child.add(Subscriptions.create(this.unsubscribe));
        return Subscribers.wrap(child);
    }
}