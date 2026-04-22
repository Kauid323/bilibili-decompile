package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssemblySingle<T> implements Single.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    final Single.OnSubscribe<T> source;
    final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public OnSubscribeOnAssemblySingle(Single.OnSubscribe<T> source) {
        this.source = source;
    }

    public void call(SingleSubscriber<? super T> t) {
        this.source.call(new OnAssemblySingleSubscriber(t, this.stacktrace));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OnAssemblySingleSubscriber<T> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final String stacktrace;

        public OnAssemblySingleSubscriber(SingleSubscriber<? super T> actual, String stacktrace) {
            this.actual = actual;
            this.stacktrace = stacktrace;
            actual.add(this);
        }

        public void onError(Throwable e) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(e);
            this.actual.onError(e);
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }
}