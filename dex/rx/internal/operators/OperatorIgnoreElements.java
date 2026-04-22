package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.internal.operators.OnSubscribeCreate;

public class OperatorIgnoreElements<T> implements Observable.Operator<T, T> {
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Holder {
        static final OperatorIgnoreElements<?> INSTANCE = new OperatorIgnoreElements<>();

        Holder() {
        }
    }

    public static <T> OperatorIgnoreElements<T> instance() {
        return (OperatorIgnoreElements<T>) Holder.INSTANCE;
    }

    OperatorIgnoreElements() {
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        OnSubscribeCreate.NoneEmitter noneEmitter = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorIgnoreElements.1
            public void onCompleted() {
                child.onCompleted();
            }

            public void onError(Throwable e) {
                child.onError(e);
            }

            public void onNext(T t) {
            }
        };
        child.add(noneEmitter);
        return noneEmitter;
    }
}