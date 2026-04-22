package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

public final class OnSubscribeReduceSeed<T, R> implements Observable.OnSubscribe<R> {
    final R initialValue;
    final Func2<R, ? super T, R> reducer;
    final Observable<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeReduceSeed(Observable<T> source, R initialValue, Func2<R, ? super T, R> reducer) {
        this.source = source;
        this.initialValue = initialValue;
        this.reducer = reducer;
    }

    public void call(Subscriber<? super R> t) {
        new ReduceSeedSubscriber(t, this.initialValue, this.reducer).subscribeTo(this.source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReduceSeedSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        final Func2<R, ? super T, R> reducer;

        public ReduceSeedSubscriber(Subscriber<? super R> actual, R initialValue, Func2<R, ? super T, R> reducer) {
            super(actual);
            this.value = initialValue;
            this.hasValue = true;
            this.reducer = reducer;
        }

        public void onNext(T t) {
            try {
                this.value = (R) this.reducer.call(this.value, t);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                unsubscribe();
                this.actual.onError(ex);
            }
        }
    }
}