package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorSkipWhile<T> implements Observable.Operator<T, T> {
    final Func2<? super T, Integer, Boolean> predicate;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorSkipWhile(Func2<? super T, Integer, Boolean> predicate) {
        this.predicate = predicate;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        return (Subscriber<T>) new Subscriber<T>(child) { // from class: rx.internal.operators.OperatorSkipWhile.1
            int index;
            boolean skipping = true;

            public void onNext(T t) {
                if (!this.skipping) {
                    child.onNext(t);
                    return;
                }
                try {
                    Func2<? super T, Integer, Boolean> func2 = OperatorSkipWhile.this.predicate;
                    int i = this.index;
                    this.index = i + 1;
                    boolean skip = ((Boolean) func2.call(t, Integer.valueOf(i))).booleanValue();
                    if (!skip) {
                        this.skipping = false;
                        child.onNext(t);
                        return;
                    }
                    request(1L);
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, child, t);
                }
            }

            public void onError(Throwable e) {
                child.onError(e);
            }

            public void onCompleted() {
                child.onCompleted();
            }
        };
    }

    public static <T> Func2<T, Integer, Boolean> toPredicate2(final Func1<? super T, Boolean> predicate) {
        return new Func2<T, Integer, Boolean>() { // from class: rx.internal.operators.OperatorSkipWhile.2
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1) {
                return call((AnonymousClass2) x0, (Integer) x1);
            }

            public Boolean call(T t1, Integer t2) {
                return (Boolean) predicate.call(t1);
            }
        };
    }
}