package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.OnSubscribeCreate;

public final class OperatorTakeWhile<T> implements Observable.Operator<T, T> {
    final Func2<? super T, ? super Integer, Boolean> predicate;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTakeWhile(final Func1<? super T, Boolean> underlying) {
        this(new Func2<T, Integer, Boolean>() { // from class: rx.internal.operators.OperatorTakeWhile.1
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1) {
                return call((AnonymousClass1) x0, (Integer) x1);
            }

            public Boolean call(T input, Integer index) {
                return (Boolean) underlying.call(input);
            }
        });
    }

    public OperatorTakeWhile(Func2<? super T, ? super Integer, Boolean> predicate) {
        this.predicate = predicate;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        OnSubscribeCreate.NoneEmitter noneEmitter = (Subscriber<T>) new Subscriber<T>(subscriber, false) { // from class: rx.internal.operators.OperatorTakeWhile.2
            private int counter;
            private boolean done;

            public void onNext(T t) {
                try {
                    Func2<? super T, ? super Integer, Boolean> func2 = OperatorTakeWhile.this.predicate;
                    int i = this.counter;
                    this.counter = i + 1;
                    boolean isSelected = ((Boolean) func2.call(t, Integer.valueOf(i))).booleanValue();
                    if (isSelected) {
                        subscriber.onNext(t);
                        return;
                    }
                    this.done = true;
                    subscriber.onCompleted();
                    unsubscribe();
                } catch (Throwable e) {
                    this.done = true;
                    Exceptions.throwOrReport(e, subscriber, t);
                    unsubscribe();
                }
            }

            public void onCompleted() {
                if (!this.done) {
                    subscriber.onCompleted();
                }
            }

            public void onError(Throwable e) {
                if (!this.done) {
                    subscriber.onError(e);
                }
            }
        };
        subscriber.add(noneEmitter);
        return noneEmitter;
    }
}