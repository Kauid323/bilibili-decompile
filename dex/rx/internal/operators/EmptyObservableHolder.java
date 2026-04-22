package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public enum EmptyObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    static final Observable<Object> EMPTY = Observable.unsafeCreate(INSTANCE);

    public static <T> Observable<T> instance() {
        return (Observable<T>) EMPTY;
    }

    public void call(Subscriber<? super Object> child) {
        child.onCompleted();
    }
}