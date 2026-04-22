package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

public final class OperatorDoAfterTerminate<T> implements Observable.Operator<T, T> {
    final Action0 action;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDoAfterTerminate(Action0 action) {
        if (action == null) {
            throw new NullPointerException("Action can not be null");
        }
        this.action = action;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        return (Subscriber<T>) new Subscriber<T>(child) { // from class: rx.internal.operators.OperatorDoAfterTerminate.1
            public void onNext(T t) {
                child.onNext(t);
            }

            public void onError(Throwable e) {
                try {
                    child.onError(e);
                } finally {
                    callAction();
                }
            }

            public void onCompleted() {
                try {
                    child.onCompleted();
                } finally {
                    callAction();
                }
            }

            void callAction() {
                try {
                    OperatorDoAfterTerminate.this.action.call();
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    RxJavaHooks.onError(ex);
                }
            }
        };
    }
}