package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeCreate;
import rx.internal.producers.SingleDelayedProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorAll<T> implements Observable.Operator<Boolean, T> {
    final Func1<? super T, Boolean> predicate;

    public OperatorAll(Func1<? super T, Boolean> predicate) {
        this.predicate = predicate;
    }

    public Subscriber<? super T> call(final Subscriber<? super Boolean> child) {
        final SingleDelayedProducer<Boolean> producer = new SingleDelayedProducer<>(child);
        OnSubscribeCreate.NoneEmitter noneEmitter = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorAll.1
            boolean done;

            public void onNext(T t) {
                if (this.done) {
                    return;
                }
                try {
                    Boolean result = (Boolean) OperatorAll.this.predicate.call(t);
                    if (!result.booleanValue()) {
                        this.done = true;
                        producer.setValue(false);
                        unsubscribe();
                    }
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, this, t);
                }
            }

            public void onError(Throwable e) {
                if (!this.done) {
                    this.done = true;
                    child.onError(e);
                    return;
                }
                RxJavaHooks.onError(e);
            }

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    producer.setValue(true);
                }
            }
        };
        child.add(noneEmitter);
        child.setProducer(producer);
        return noneEmitter;
    }
}