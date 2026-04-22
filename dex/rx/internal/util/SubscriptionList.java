package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class SubscriptionList implements Subscription {
    private List<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public SubscriptionList() {
    }

    public SubscriptionList(Subscription... subscriptions) {
        this.subscriptions = new LinkedList(Arrays.asList(subscriptions));
    }

    public SubscriptionList(Subscription s) {
        this.subscriptions = new LinkedList();
        this.subscriptions.add(s);
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
                    List<Subscription> subs = this.subscriptions;
                    if (subs == null) {
                        subs = new LinkedList();
                        this.subscriptions = subs;
                    }
                    subs.add(s);
                    return;
                }
            }
        }
        s.unsubscribe();
    }

    public void remove(Subscription s) {
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    try {
                        List<Subscription> subs = this.subscriptions;
                        if (!this.unsubscribed && subs != null) {
                            boolean unsubscribe = subs.remove(s);
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
                        List<Subscription> list = this.subscriptions;
                        this.subscriptions = null;
                        unsubscribeFromAll(list);
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

    public void clear() {
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    try {
                        List<Subscription> list = this.subscriptions;
                        this.subscriptions = null;
                        unsubscribeFromAll(list);
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