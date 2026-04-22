package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.internal.operators.SingleLiftObservableOperator;

public final class SingleToObservable<T> implements Observable.OnSubscribe<T> {
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public SingleToObservable(Single.OnSubscribe<T> source) {
        this.source = source;
    }

    public void call(Subscriber<? super T> t) {
        SingleLiftObservableOperator.WrapSubscriberIntoSingle<T> parent = new SingleLiftObservableOperator.WrapSubscriberIntoSingle<>(t);
        t.add(parent);
        this.source.call(parent);
    }
}