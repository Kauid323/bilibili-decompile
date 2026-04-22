package rx;

import kotlin.jvm.internal.LongCompanionObject;
import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    /* JADX INFO: Access modifiers changed from: protected */
    public Subscriber() {
        this(null, false);
    }

    protected Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    protected Subscriber(Subscriber<?> subscriber, boolean shareSubscriptions) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber;
        this.subscriptions = (!shareSubscriptions || subscriber == null) ? new SubscriptionList() : subscriber.subscriptions;
    }

    public final void add(Subscription s) {
        this.subscriptions.add(s);
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    protected final void request(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + n);
        }
        synchronized (this) {
            try {
                try {
                    if (this.producer != null) {
                        Producer producerToRequestFrom = this.producer;
                        producerToRequestFrom.request(n);
                        return;
                    }
                    addToRequested(n);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private void addToRequested(long n) {
        if (this.requested == Long.MIN_VALUE) {
            this.requested = n;
            return;
        }
        long total = this.requested + n;
        if (total < 0) {
            this.requested = LongCompanionObject.MAX_VALUE;
        } else {
            this.requested = total;
        }
    }

    public void setProducer(Producer p) {
        boolean passToSubscriber = false;
        synchronized (this) {
            try {
                try {
                    long toRequest = this.requested;
                    this.producer = p;
                    if (this.subscriber != null && toRequest == Long.MIN_VALUE) {
                        passToSubscriber = true;
                    }
                    if (passToSubscriber) {
                        this.subscriber.setProducer(this.producer);
                    } else if (toRequest == Long.MIN_VALUE) {
                        this.producer.request(LongCompanionObject.MAX_VALUE);
                    } else {
                        this.producer.request(toRequest);
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