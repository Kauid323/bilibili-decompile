package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Cancellable;
import rx.plugins.RxJavaHooks;

public final class CancellableSubscription extends AtomicReference<Cancellable> implements Subscription {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(Cancellable cancellable) {
        super(cancellable);
    }

    public boolean isUnsubscribed() {
        return get() == null;
    }

    public void unsubscribe() {
        Cancellable c;
        if (get() != null && (c = getAndSet(null)) != null) {
            try {
                c.cancel();
            } catch (Exception ex) {
                Exceptions.throwIfFatal(ex);
                RxJavaHooks.onError(ex);
            }
        }
    }
}