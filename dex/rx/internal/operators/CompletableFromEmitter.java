package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.CompletableEmitter;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
import rx.plugins.RxJavaHooks;

public final class CompletableFromEmitter implements Completable.OnSubscribe {
    final Action1<CompletableEmitter> producer;

    public CompletableFromEmitter(Action1<CompletableEmitter> producer) {
        this.producer = producer;
    }

    public void call(CompletableSubscriber t) {
        FromEmitter emitter = new FromEmitter(t);
        t.onSubscribe(emitter);
        try {
            this.producer.call(emitter);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            emitter.onError(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class FromEmitter extends AtomicBoolean implements CompletableEmitter, Subscription {
        private static final long serialVersionUID = 5539301318568668881L;
        final CompletableSubscriber actual;
        final SequentialSubscription resource = new SequentialSubscription();

        public FromEmitter(CompletableSubscriber actual) {
            this.actual = actual;
        }

        public void onCompleted() {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        public void onError(Throwable t) {
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

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.resource.unsubscribe();
            }
        }

        public boolean isUnsubscribed() {
            return get();
        }
    }
}