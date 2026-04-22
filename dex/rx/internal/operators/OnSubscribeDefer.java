package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.Subscribers;

public final class OnSubscribeDefer<T> implements Observable.OnSubscribe<T> {
    final Func0<? extends Observable<? extends T>> observableFactory;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeDefer(Func0<? extends Observable<? extends T>> observableFactory) {
        this.observableFactory = observableFactory;
    }

    public void call(Subscriber<? super T> s) {
        try {
            Observable<? extends T> o = (Observable) this.observableFactory.call();
            o.unsafeSubscribe(Subscribers.wrap(s));
        } catch (Throwable t) {
            Exceptions.throwOrReport(t, s);
        }
    }
}