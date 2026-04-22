package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeUntil<T, E> implements Observable.Operator<T, T> {
    private final Observable<? extends E> other;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTakeUntil(Observable<? extends E> other) {
        this.other = other;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(child, false);
        final Subscription subscription = (Subscriber<T>) new Subscriber<T>(serializedSubscriber, false) { // from class: rx.internal.operators.OperatorTakeUntil.1
            public void onNext(T t) {
                serializedSubscriber.onNext(t);
            }

            public void onError(Throwable e) {
                try {
                    serializedSubscriber.onError(e);
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }

            public void onCompleted() {
                try {
                    serializedSubscriber.onCompleted();
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }
        };
        Subscriber<E> so = new Subscriber<E>() { // from class: rx.internal.operators.OperatorTakeUntil.2
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onCompleted() {
                subscription.onCompleted();
            }

            public void onError(Throwable e) {
                subscription.onError(e);
            }

            public void onNext(E t) {
                onCompleted();
            }
        };
        serializedSubscriber.add(subscription);
        serializedSubscriber.add(so);
        child.add(serializedSubscriber);
        this.other.unsafeSubscribe(so);
        return subscription;
    }
}