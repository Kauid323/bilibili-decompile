package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public CompositeSubscription() {
    }

    public CompositeSubscription(Subscription... subscriptions) {
        this.subscriptions = new HashSet(Arrays.asList(subscriptions));
    }

    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public void add(Subscription s) {
        if (s.isUnsubscribed()) {
            return;
        }
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(4);
                    }
                    this.subscriptions.add(s);
                    return;
                }
            }
        }
        s.unsubscribe();
    }

    public void addAll(Subscription... subscriptions) {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(subscriptions.length);
                    }
                    for (Subscription s : subscriptions) {
                        if (!s.isUnsubscribed()) {
                            this.subscriptions.add(s);
                        }
                    }
                    return;
                }
            }
        }
        for (Subscription s2 : subscriptions) {
            s2.unsubscribe();
        }
    }

    public void remove(Subscription s) {
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    try {
                        if (!this.unsubscribed && this.subscriptions != null) {
                            boolean unsubscribe = this.subscriptions.remove(s);
                            if (unsubscribe) {
                                s.unsubscribe();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
    }

    public void clear() {
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    try {
                        if (!this.unsubscribed && this.subscriptions != null) {
                            Collection<Subscription> unsubscribe = this.subscriptions;
                            this.subscriptions = null;
                            unsubscribeFromAll(unsubscribe);
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    try {
                        if (this.unsubscribed) {
                            return;
                        }
                        this.unsubscribed = true;
                        Collection<Subscription> unsubscribe = this.subscriptions;
                        this.subscriptions = null;
                        unsubscribeFromAll(unsubscribe);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    private static void unsubscribeFromAll(Collection<Subscription> subscriptions) {
        if (subscriptions == null) {
            return;
        }
        List<Throwable> es = null;
        for (Subscription s : subscriptions) {
            try {
                s.unsubscribe();
            } catch (Throwable e) {
                if (es == null) {
                    es = new ArrayList<>();
                }
                es.add(e);
            }
        }
        Exceptions.throwIfAny(es);
    }

    public boolean hasSubscriptions() {
        boolean z = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && this.subscriptions != null && !this.subscriptions.isEmpty()) {
                z = true;
            }
        }
        return z;
    }
}