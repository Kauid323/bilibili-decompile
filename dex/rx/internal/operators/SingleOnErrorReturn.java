package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class SingleOnErrorReturn<T> implements Single.OnSubscribe<T> {
    final Func1<Throwable, ? extends T> resumeFunction;
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleOnErrorReturn(Single.OnSubscribe<T> source, Func1<Throwable, ? extends T> resumeFunction) {
        this.source = source;
        this.resumeFunction = resumeFunction;
    }

    public void call(SingleSubscriber<? super T> t) {
        OnErrorReturnsSingleSubscriber<T> parent = new OnErrorReturnsSingleSubscriber<>(t, this.resumeFunction);
        t.add(parent);
        this.source.call(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OnErrorReturnsSingleSubscriber<T> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final Func1<Throwable, ? extends T> resumeFunction;

        public OnErrorReturnsSingleSubscriber(SingleSubscriber<? super T> actual, Func1<Throwable, ? extends T> resumeFunction) {
            this.actual = actual;
            this.resumeFunction = resumeFunction;
        }

        public void onSuccess(T value) {
            this.actual.onSuccess(value);
        }

        public void onError(Throwable error) {
            try {
                this.actual.onSuccess(this.resumeFunction.call(error));
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.actual.onError(ex);
            }
        }
    }
}