package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public final class OnSubscribeTakeLastOne<T> implements Observable.OnSubscribe<T> {
    final Observable<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeTakeLastOne(Observable<T> source) {
        this.source = source;
    }

    public void call(Subscriber<? super T> t) {
        new TakeLastOneSubscriber(t).subscribeTo(this.source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscriber<T, T> {
        static final Object EMPTY = new Object();

        /* JADX WARN: Type inference failed for: r0v0, types: [R, java.lang.Object] */
        public TakeLastOneSubscriber(Subscriber<? super T> actual) {
            super(actual);
            this.value = EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(T t) {
            this.value = t;
        }

        @Override // rx.internal.operators.DeferredScalarSubscriber
        public void onCompleted() {
            Object o = this.value;
            if (o == EMPTY) {
                complete();
            } else {
                complete(o);
            }
        }
    }
}