package rx.observers;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.atomic.AtomicReference;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public abstract class AsyncCompletableSubscriber implements CompletableSubscriber, Subscription {
    static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();
    private final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public final void onSubscribe(Subscription d) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, (Object) null, d)) {
            d.unsubscribe();
            if (this.upstream.get() != UNSUBSCRIBED) {
                RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
                return;
            }
            return;
        }
        onStart();
    }

    protected void onStart() {
    }

    public final boolean isUnsubscribed() {
        return this.upstream.get() == UNSUBSCRIBED;
    }

    protected final void clear() {
        this.upstream.set(UNSUBSCRIBED);
    }

    public final void unsubscribe() {
        Subscription current = this.upstream.get();
        if (current != UNSUBSCRIBED) {
            Subscription current2 = this.upstream.getAndSet(UNSUBSCRIBED);
            Subscription current3 = current2;
            if (current3 != null && current3 != UNSUBSCRIBED) {
                current3.unsubscribe();
            }
        }
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class Unsubscribed implements Subscription {
        Unsubscribed() {
        }

        public void unsubscribe() {
        }

        public boolean isUnsubscribed() {
            return true;
        }
    }
}