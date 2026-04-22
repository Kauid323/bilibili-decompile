package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSkipUntil<T, U> implements Observable.Operator<T, T> {
    final Observable<U> other;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorSkipUntil(Observable<U> other) {
        this.other = other;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final SerializedSubscriber<T> s = new SerializedSubscriber<>(child);
        final AtomicBoolean gate = new AtomicBoolean();
        Subscriber<U> u = new Subscriber<U>() { // from class: rx.internal.operators.OperatorSkipUntil.1
            public void onNext(U t) {
                gate.set(true);
                unsubscribe();
            }

            public void onError(Throwable e) {
                s.onError(e);
                s.unsubscribe();
            }

            public void onCompleted() {
                unsubscribe();
            }
        };
        child.add(u);
        this.other.unsafeSubscribe(u);
        return (Subscriber<T>) new Subscriber<T>(child) { // from class: rx.internal.operators.OperatorSkipUntil.2
            public void onNext(T t) {
                if (gate.get()) {
                    s.onNext(t);
                } else {
                    request(1L);
                }
            }

            public void onError(Throwable e) {
                s.onError(e);
                unsubscribe();
            }

            public void onCompleted() {
                s.onCompleted();
                unsubscribe();
            }
        };
    }
}