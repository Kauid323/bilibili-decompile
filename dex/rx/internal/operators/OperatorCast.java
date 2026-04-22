package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.plugins.RxJavaHooks;

public class OperatorCast<T, R> implements Observable.Operator<R, T> {
    final Class<R> castClass;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorCast(Class<R> castClass) {
        this.castClass = castClass;
    }

    public Subscriber<? super T> call(Subscriber<? super R> o) {
        CastSubscriber<T, R> parent = new CastSubscriber<>(o, this.castClass);
        o.add(parent);
        return parent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CastSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final Class<R> castClass;
        boolean done;

        public CastSubscriber(Subscriber<? super R> actual, Class<R> castClass) {
            this.actual = actual;
            this.castClass = castClass;
        }

        public void onNext(T t) {
            try {
                R result = this.castClass.cast(t);
                this.actual.onNext(result);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(ex, t));
            }
        }

        public void onError(Throwable e) {
            if (this.done) {
                RxJavaHooks.onError(e);
                return;
            }
            this.done = true;
            this.actual.onError(e);
        }

        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.actual.onCompleted();
        }

        public void setProducer(Producer p) {
            this.actual.setProducer(p);
        }
    }
}