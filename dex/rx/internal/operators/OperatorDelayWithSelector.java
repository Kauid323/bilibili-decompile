package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;
import rx.subjects.PublishSubject;

public final class OperatorDelayWithSelector<T, V> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<V>> itemDelay;
    final Observable<? extends T> source;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDelayWithSelector(Observable<? extends T> source, Func1<? super T, ? extends Observable<V>> itemDelay) {
        this.source = source;
        this.itemDelay = itemDelay;
    }

    public Subscriber<? super T> call(Subscriber<? super T> _child) {
        final SerializedSubscriber<T> child = new SerializedSubscriber<>(_child);
        final PublishSubject<Observable<T>> delayedEmissions = PublishSubject.create();
        _child.add(Observable.merge(delayedEmissions).unsafeSubscribe(Subscribers.from(child)));
        return (Subscriber<T>) new Subscriber<T>(_child) { // from class: rx.internal.operators.OperatorDelayWithSelector.1
            public void onCompleted() {
                delayedEmissions.onCompleted();
            }

            public void onError(Throwable e) {
                child.onError(e);
            }

            public void onNext(final T t) {
                try {
                    delayedEmissions.onNext(((Observable) OperatorDelayWithSelector.this.itemDelay.call(t)).take(1).defaultIfEmpty((Object) null).map(new Func1<V, T>() { // from class: rx.internal.operators.OperatorDelayWithSelector.1.1
                        public T call(V v) {
                            return (T) t;
                        }
                    }));
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, this);
                }
            }
        };
    }
}