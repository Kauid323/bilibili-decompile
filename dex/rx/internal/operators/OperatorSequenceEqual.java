package rx.internal.operators;

import rx.Observable;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

public final class OperatorSequenceEqual {
    static final Object LOCAL_ON_COMPLETED = new Object();

    private OperatorSequenceEqual() {
        throw new IllegalStateException("No instances!");
    }

    static <T> Observable<Object> materializeLite(Observable<T> source) {
        return Observable.concat(source, Observable.just(LOCAL_ON_COMPLETED));
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> first, Observable<? extends T> second, final Func2<? super T, ? super T, Boolean> equality) {
        Observable<Object> firstObservable = materializeLite(first);
        Observable<Object> secondObservable = materializeLite(second);
        return Observable.zip(firstObservable, secondObservable, new Func2<Object, Object, Boolean>() { // from class: rx.internal.operators.OperatorSequenceEqual.1
            /* renamed from: call */
            public Boolean m2089call(Object t1, Object t2) {
                boolean c1 = t1 == OperatorSequenceEqual.LOCAL_ON_COMPLETED;
                boolean c2 = t2 == OperatorSequenceEqual.LOCAL_ON_COMPLETED;
                if (c1 && c2) {
                    return true;
                }
                if (c1 || c2) {
                    return false;
                }
                return (Boolean) equality.call(t1, t2);
            }
        }).all(UtilityFunctions.identity());
    }
}