package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public enum NeverObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    static final Observable<Object> NEVER = Observable.unsafeCreate(INSTANCE);

    public static <T> Observable<T> instance() {
        return (Observable<T>) NEVER;
    }

    public void call(Subscriber<? super Object> child) {
    }
}