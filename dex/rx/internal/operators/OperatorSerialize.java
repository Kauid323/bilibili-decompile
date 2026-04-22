package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSerialize<T> implements Observable.Operator<T, T> {
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Holder {
        static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize<>();

        Holder() {
        }
    }

    public static <T> OperatorSerialize<T> instance() {
        return (OperatorSerialize<T>) Holder.INSTANCE;
    }

    OperatorSerialize() {
    }

    public Subscriber<? super T> call(final Subscriber<? super T> s) {
        return new SerializedSubscriber(new Subscriber<T>(s) { // from class: rx.internal.operators.OperatorSerialize.1
            public void onCompleted() {
                s.onCompleted();
            }

            public void onError(Throwable e) {
                s.onError(e);
            }

            public void onNext(T t) {
                s.onNext(t);
            }
        });
    }
}