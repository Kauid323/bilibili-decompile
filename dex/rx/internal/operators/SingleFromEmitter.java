package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.SingleEmitter;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
import rx.plugins.RxJavaHooks;

public final class SingleFromEmitter<T> implements Single.OnSubscribe<T> {
    final Action1<SingleEmitter<T>> producer;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleFromEmitter(Action1<SingleEmitter<T>> producer) {
        this.producer = producer;
    }

    public void call(SingleSubscriber<? super T> t) {
        SingleEmitterImpl<T> parent = new SingleEmitterImpl<>(t);
        t.add(parent);
        try {
            this.producer.call(parent);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            parent.onError(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SingleEmitterImpl<T> extends AtomicBoolean implements SingleEmitter<T>, Subscription {
        private static final long serialVersionUID = 8082834163465882809L;
        final SingleSubscriber<? super T> actual;
        final SequentialSubscription resource = new SequentialSubscription();

        SingleEmitterImpl(SingleSubscriber<? super T> actual) {
            this.actual = actual;
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.resource.unsubscribe();
            }
        }

        public boolean isUnsubscribed() {
            return get();
        }

        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onSuccess(t);
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        public void onError(Throwable t) {
            if (t == null) {
                t = new NullPointerException();
            }
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onError(t);
                    return;
                } finally {
                    this.resource.unsubscribe();
                }
            }
            RxJavaHooks.onError(t);
        }

        public void setSubscription(Subscription s) {
            this.resource.update(s);
        }

        public void setCancellation(Cancellable c) {
            setSubscription(new CancellableSubscription(c));
        }
    }
}