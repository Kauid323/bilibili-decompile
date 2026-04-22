package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class OperatorUnsubscribeOn<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorUnsubscribeOn(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final Subscriber subscriber2 = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorUnsubscribeOn.1
            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable e) {
                subscriber.onError(e);
            }

            public void onNext(T t) {
                subscriber.onNext(t);
            }
        };
        subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorUnsubscribeOn.2
            public void call() {
                final Scheduler.Worker inner = OperatorUnsubscribeOn.this.scheduler.createWorker();
                inner.schedule(new Action0() { // from class: rx.internal.operators.OperatorUnsubscribeOn.2.1
                    public void call() {
                        subscriber2.unsubscribe();
                        inner.unsubscribe();
                    }
                });
            }
        }));
        return subscriber2;
    }
}