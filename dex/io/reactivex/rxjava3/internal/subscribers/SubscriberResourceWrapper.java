package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(Subscriber<? super T> downstream) {
        this.downstream = downstream;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.setOnce(this.upstream, s)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onError(Throwable t) {
        DisposableHelper.dispose(this);
        this.downstream.onError(t);
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public void request(long n) {
        if (SubscriptionHelper.validate(n)) {
            this.upstream.get().request(n);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    public void cancel() {
        dispose();
    }

    public void setResource(Disposable resource) {
        DisposableHelper.set(this, resource);
    }
}