package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssembly<T> implements Observable.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    final Observable.OnSubscribe<T> source;
    final String stacktrace = createStacktrace();

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeOnAssembly(Observable.OnSubscribe<T> source) {
        this.source = source;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String createStacktrace() {
        StackTraceElement[] stacktraceElements = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("Assembly trace:");
        for (StackTraceElement e : stacktraceElements) {
            String row = e.toString();
            if (fullStackTrace || (e.getLineNumber() > 1 && !row.contains("RxJavaHooks.") && !row.contains("OnSubscribeOnAssembly") && !row.contains(".junit.runner") && !row.contains(".junit4.runner") && !row.contains(".junit.internal") && !row.contains("sun.reflect") && !row.contains("java.lang.Thread.") && !row.contains("ThreadPoolExecutor") && !row.contains("org.apache.catalina.") && !row.contains("org.apache.tomcat."))) {
                sb.append("\n at ").append(row);
            }
        }
        return sb.append("\nOriginal exception:").toString();
    }

    public void call(Subscriber<? super T> t) {
        this.source.call(new OnAssemblySubscriber(t, this.stacktrace));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OnAssemblySubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;
        final String stacktrace;

        public OnAssemblySubscriber(Subscriber<? super T> actual, String stacktrace) {
            super(actual);
            this.actual = actual;
            this.stacktrace = stacktrace;
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        public void onError(Throwable e) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(e);
            this.actual.onError(e);
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }
    }
}