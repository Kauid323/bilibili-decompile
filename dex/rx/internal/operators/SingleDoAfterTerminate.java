package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

public final class SingleDoAfterTerminate<T> implements Single.OnSubscribe<T> {
    final Action0 action;
    final Single<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleDoAfterTerminate(Single<T> source, Action0 action) {
        this.source = source;
        this.action = action;
    }

    public void call(SingleSubscriber<? super T> t) {
        SingleDoAfterTerminateSubscriber<T> parent = new SingleDoAfterTerminateSubscriber<>(t, this.action);
        t.add(parent);
        this.source.subscribe(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SingleDoAfterTerminateSubscriber<T> extends SingleSubscriber<T> {
        final Action0 action;
        final SingleSubscriber<? super T> actual;

        public SingleDoAfterTerminateSubscriber(SingleSubscriber<? super T> actual, Action0 action) {
            this.actual = actual;
            this.action = action;
        }

        public void onSuccess(T value) {
            try {
                this.actual.onSuccess(value);
            } finally {
                doAction();
            }
        }

        public void onError(Throwable error) {
            try {
                this.actual.onError(error);
            } finally {
                doAction();
            }
        }

        void doAction() {
            try {
                this.action.call();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                RxJavaHooks.onError(ex);
            }
        }
    }
}