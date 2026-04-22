package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public final class OnSubscribeThrow<T> implements Observable.OnSubscribe<T> {
    private final Throwable exception;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeThrow(Throwable exception) {
        this.exception = exception;
    }

    public void call(Subscriber<? super T> observer) {
        observer.onError(this.exception);
    }
}