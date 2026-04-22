package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    private final AtomicReference<Subscription> upstream = new AtomicReference<>();
    private final ListCompositeDisposable resources = new ListCompositeDisposable();
    private final AtomicLong missedRequested = new AtomicLong();

    public final void add(Disposable resource) {
        Objects.requireNonNull(resource, "resource is null");
        this.resources.add(resource);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public final void onSubscribe(Subscription s) {
        if (EndConsumerHelper.setOnce(this.upstream, s, getClass())) {
            long r = this.missedRequested.getAndSet(0L);
            if (r != 0) {
                s.request(r);
            }
            onStart();
        }
    }

    protected void onStart() {
        request(Long.MAX_VALUE);
    }

    protected final void request(long n) {
        SubscriptionHelper.deferredRequest(this.upstream, this.missedRequested, n);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (SubscriptionHelper.cancel(this.upstream)) {
            this.resources.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }
}