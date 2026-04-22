package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeLift<T, R> implements Observable.OnSubscribe<R> {
    final Observable.Operator<? extends R, ? super T> operator;
    final Observable.OnSubscribe<T> parent;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeLift(Observable.OnSubscribe<T> parent, Observable.Operator<? extends R, ? super T> operator) {
        this.parent = parent;
        this.operator = operator;
    }

    public void call(Subscriber<? super R> o) {
        try {
            Subscriber<? super T> st = (Subscriber) RxJavaHooks.onObservableLift(this.operator).call(o);
            st.onStart();
            this.parent.call(st);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            o.onError(e);
        }
    }
}