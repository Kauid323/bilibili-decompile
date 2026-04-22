package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.SingleFromObservable;
import rx.internal.producers.SingleProducer;
import rx.plugins.RxJavaHooks;

public final class SingleLiftObservableOperator<T, R> implements Single.OnSubscribe<R> {
    final Observable.Operator<? extends R, ? super T> lift;
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleLiftObservableOperator(Single.OnSubscribe<T> source, Observable.Operator<? extends R, ? super T> lift) {
        this.source = source;
        this.lift = lift;
    }

    public void call(SingleSubscriber<? super R> t) {
        Subscriber<R> outputAsSubscriber = new SingleFromObservable.WrapSingleIntoSubscriber<>(t);
        t.add(outputAsSubscriber);
        try {
            Subscriber<? super T> inputAsSubscriber = (Subscriber) RxJavaHooks.onSingleLift(this.lift).call(outputAsSubscriber);
            SingleSubscriber<? super T> input = wrap(inputAsSubscriber);
            inputAsSubscriber.onStart();
            this.source.call(input);
        } catch (Throwable ex) {
            Exceptions.throwOrReport(ex, t);
        }
    }

    public static <T> SingleSubscriber<T> wrap(Subscriber<T> subscriber) {
        WrapSubscriberIntoSingle<T> parent = new WrapSubscriberIntoSingle<>(subscriber);
        subscriber.add(parent);
        return parent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class WrapSubscriberIntoSingle<T> extends SingleSubscriber<T> {
        final Subscriber<? super T> actual;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WrapSubscriberIntoSingle(Subscriber<? super T> actual) {
            this.actual = actual;
        }

        public void onSuccess(T value) {
            this.actual.setProducer(new SingleProducer(this.actual, value));
        }

        public void onError(Throwable error) {
            this.actual.onError(error);
        }
    }
}