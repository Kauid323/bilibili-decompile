package rx.subscriptions;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class RefCountSubscription implements Subscription {
    static final State EMPTY_STATE = new State(false, 0);
    private final Subscription actual;
    final AtomicReference<State> state = new AtomicReference<>(EMPTY_STATE);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class State {
        final int children;
        final boolean isUnsubscribed;

        State(boolean u, int c) {
            this.isUnsubscribed = u;
            this.children = c;
        }

        State addChild() {
            return new State(this.isUnsubscribed, this.children + 1);
        }

        State removeChild() {
            return new State(this.isUnsubscribed, this.children - 1);
        }

        State unsubscribe() {
            return new State(true, this.children);
        }
    }

    public RefCountSubscription(Subscription s) {
        if (s == null) {
            throw new IllegalArgumentException("s");
        }
        this.actual = s;
    }

    public Subscription get() {
        State oldState;
        State newState;
        AtomicReference<State> localState = this.state;
        do {
            oldState = localState.get();
            if (oldState.isUnsubscribed) {
                return Subscriptions.unsubscribed();
            }
            newState = oldState.addChild();
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(localState, oldState, newState));
        return new InnerSubscription(this);
    }

    public boolean isUnsubscribed() {
        return this.state.get().isUnsubscribed;
    }

    public void unsubscribe() {
        State oldState;
        State newState;
        AtomicReference<State> localState = this.state;
        do {
            oldState = localState.get();
            if (oldState.isUnsubscribed) {
                return;
            }
            newState = oldState.unsubscribe();
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(localState, oldState, newState));
        unsubscribeActualIfApplicable(newState);
    }

    private void unsubscribeActualIfApplicable(State state) {
        if (state.isUnsubscribed && state.children == 0) {
            this.actual.unsubscribe();
        }
    }

    void unsubscribeAChild() {
        State oldState;
        State newState;
        AtomicReference<State> localState = this.state;
        do {
            oldState = localState.get();
            newState = oldState.removeChild();
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(localState, oldState, newState));
        unsubscribeActualIfApplicable(newState);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class InnerSubscription extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription parent) {
            this.parent = parent;
        }

        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.unsubscribeAChild();
            }
        }

        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}