package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

public final class OperatorTimestamp<T> implements Observable.Operator<Timestamped<T>, T> {
    final Scheduler scheduler;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTimestamp(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Subscriber<? super T> call(final Subscriber<? super Timestamped<T>> o) {
        return (Subscriber<T>) new Subscriber<T>(o) { // from class: rx.internal.operators.OperatorTimestamp.1
            public void onCompleted() {
                o.onCompleted();
            }

            public void onError(Throwable e) {
                o.onError(e);
            }

            public void onNext(T t) {
                o.onNext(new Timestamped(OperatorTimestamp.this.scheduler.now(), t));
            }
        };
    }
}