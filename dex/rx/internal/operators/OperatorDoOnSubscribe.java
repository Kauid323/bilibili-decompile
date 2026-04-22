package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

public class OperatorDoOnSubscribe<T> implements Observable.Operator<T, T> {
    private final Action0 subscribe;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDoOnSubscribe(Action0 subscribe) {
        this.subscribe = subscribe;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        this.subscribe.call();
        return Subscribers.wrap(child);
    }
}