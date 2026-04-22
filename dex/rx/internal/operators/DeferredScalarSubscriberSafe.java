package rx.internal.operators;

import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public abstract class DeferredScalarSubscriberSafe<T, R> extends DeferredScalarSubscriber<T, R> {
    protected boolean done;

    public DeferredScalarSubscriberSafe(Subscriber<? super R> actual) {
        super(actual);
    }

    @Override // rx.internal.operators.DeferredScalarSubscriber
    public void onError(Throwable ex) {
        if (!this.done) {
            this.done = true;
            super.onError(ex);
            return;
        }
        RxJavaHooks.onError(ex);
    }

    @Override // rx.internal.operators.DeferredScalarSubscriber
    public void onCompleted() {
        if (this.done) {
            return;
        }
        this.done = true;
        super.onCompleted();
    }
}