package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.OnSubscribeCreate;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableList<T> implements Observable.Operator<List<T>, T> {
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Holder {
        static final OperatorToObservableList<Object> INSTANCE = new OperatorToObservableList<>();

        Holder() {
        }
    }

    public static <T> OperatorToObservableList<T> instance() {
        return (OperatorToObservableList<T>) Holder.INSTANCE;
    }

    OperatorToObservableList() {
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> o) {
        final SingleDelayedProducer<List<T>> producer = new SingleDelayedProducer<>(o);
        OnSubscribeCreate.NoneEmitter noneEmitter = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorToObservableList.1
            boolean completed;
            List<T> list = new LinkedList();

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    try {
                        ArrayList arrayList = new ArrayList(this.list);
                        this.list = null;
                        producer.setValue(arrayList);
                    } catch (Throwable t) {
                        Exceptions.throwOrReport(t, this);
                    }
                }
            }

            public void onError(Throwable e) {
                o.onError(e);
            }

            public void onNext(T value) {
                if (!this.completed) {
                    this.list.add(value);
                }
            }
        };
        o.add(noneEmitter);
        o.setProducer(producer);
        return noneEmitter;
    }
}