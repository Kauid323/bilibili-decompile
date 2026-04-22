package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    static final int QUEUE_LINK_SIZE = 4;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Subscription upstream;

    public SerializedSubscriber(Subscriber<? super T> downstream) {
        this(downstream, false);
    }

    public SerializedSubscriber(Subscriber<? super T> actual, boolean delayError) {
        this.downstream = actual;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.validate(this.upstream, s)) {
            this.upstream = s;
            this.downstream.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (t == null) {
            this.upstream.cancel();
            onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> q = this.queue;
                if (q == null) {
                    q = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = q;
                }
                q.add(NotificationLite.next(t));
                return;
            }
            this.emitting = true;
            this.downstream.onNext(t);
            emitLoop();
        }
    }

    public void onError(Throwable t) {
        boolean reportError;
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        synchronized (this) {
            if (this.done) {
                reportError = true;
            } else {
                boolean reportError2 = this.emitting;
                if (reportError2) {
                    this.done = true;
                    AppendOnlyLinkedArrayList<Object> q = this.queue;
                    if (q == null) {
                        q = new AppendOnlyLinkedArrayList<>(4);
                        this.queue = q;
                    }
                    Object err = NotificationLite.error(t);
                    if (this.delayError) {
                        q.add(err);
                    } else {
                        q.setFirst(err);
                    }
                    return;
                }
                this.done = true;
                this.emitting = true;
                reportError = false;
            }
            if (reportError) {
                RxJavaPlugins.onError(t);
            } else {
                this.downstream.onError(t);
            }
        }
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> q = this.queue;
                if (q == null) {
                    q = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = q;
                }
                q.add(NotificationLite.complete());
                return;
            }
            this.done = true;
            this.emitting = true;
            this.downstream.onComplete();
        }
    }

    void emitLoop() {
        AppendOnlyLinkedArrayList<Object> q;
        do {
            synchronized (this) {
                q = this.queue;
                if (q == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
        } while (!q.accept((Subscriber<? super T>) this.downstream));
    }

    public void request(long n) {
        this.upstream.request(n);
    }

    public void cancel() {
        this.upstream.cancel();
    }
}