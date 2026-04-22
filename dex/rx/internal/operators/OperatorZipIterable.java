package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.Subscribers;

public final class OperatorZipIterable<T1, T2, R> implements Observable.Operator<R, T1> {
    final Iterable<? extends T2> iterable;
    final Func2<? super T1, ? super T2, ? extends R> zipFunction;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorZipIterable(Iterable<? extends T2> iterable, Func2<? super T1, ? super T2, ? extends R> zipFunction) {
        this.iterable = iterable;
        this.zipFunction = zipFunction;
    }

    public Subscriber<? super T1> call(final Subscriber<? super R> subscriber) {
        final Iterator<? extends T2> iterator = this.iterable.iterator();
        try {
            if (!iterator.hasNext()) {
                subscriber.onCompleted();
                return Subscribers.empty();
            }
            return (Subscriber<T1>) new Subscriber<T1>(subscriber) { // from class: rx.internal.operators.OperatorZipIterable.1
                boolean done;

                public void onCompleted() {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    subscriber.onCompleted();
                }

                public void onError(Throwable e) {
                    if (this.done) {
                        Exceptions.throwIfFatal(e);
                        return;
                    }
                    this.done = true;
                    subscriber.onError(e);
                }

                public void onNext(T1 t) {
                    if (this.done) {
                        return;
                    }
                    try {
                        subscriber.onNext(OperatorZipIterable.this.zipFunction.call(t, iterator.next()));
                        if (!iterator.hasNext()) {
                            onCompleted();
                        }
                    } catch (Throwable e) {
                        Exceptions.throwOrReport(e, this);
                    }
                }
            };
        } catch (Throwable e) {
            Exceptions.throwOrReport(e, subscriber);
            return Subscribers.empty();
        }
    }
}