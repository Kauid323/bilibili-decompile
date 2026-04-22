package io.reactivex.rxjava3.subscribers;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription {
    private volatile boolean cancelled;
    private final Subscriber<? super T> downstream;
    private final AtomicLong missedRequested;
    private final AtomicReference<Subscription> upstream;

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public static <T> TestSubscriber<T> create(long initialRequested) {
        return new TestSubscriber<>(initialRequested);
    }

    public static <T> TestSubscriber<T> create(Subscriber<? super T> delegate) {
        return new TestSubscriber<>(delegate);
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public TestSubscriber(long initialRequest) {
        this(EmptySubscriber.INSTANCE, initialRequest);
    }

    public TestSubscriber(Subscriber<? super T> downstream) {
        this(downstream, Long.MAX_VALUE);
    }

    public TestSubscriber(Subscriber<? super T> actual, long initialRequest) {
        if (initialRequest < 0) {
            throw new IllegalArgumentException("Negative initial request not allowed");
        }
        this.downstream = actual;
        this.upstream = new AtomicReference<>();
        this.missedRequested = new AtomicLong(initialRequest);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        this.lastThread = Thread.currentThread();
        if (s == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, (Object) null, s)) {
            s.cancel();
            if (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + s));
            }
        } else {
            this.downstream.onSubscribe(s);
            long mr = this.missedRequested.getAndSet(0L);
            if (mr != 0) {
                s.request(mr);
            }
            onStart();
        }
    }

    protected void onStart() {
    }

    public void onNext(T t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        this.values.add(t);
        if (t == null) {
            this.errors.add(new NullPointerException("onNext received a null value"));
        }
        this.downstream.onNext(t);
    }

    public void onError(Throwable t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            if (t == null) {
                this.errors.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.errors.add(t);
            }
            this.downstream.onError(t);
        } finally {
            this.done.countDown();
        }
    }

    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.completions++;
            this.downstream.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    public final void request(long n) {
        SubscriptionHelper.deferredRequest(this.upstream, this.missedRequested, n);
    }

    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer, io.reactivex.rxjava3.disposables.Disposable
    protected final void dispose() {
        cancel();
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer, io.reactivex.rxjava3.disposables.Disposable
    protected final boolean isDisposed() {
        return this.cancelled;
    }

    public final boolean hasSubscription() {
        return this.upstream.get() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer
    public final TestSubscriber<T> assertSubscribed() {
        if (this.upstream.get() == null) {
            throw fail("Not subscribed!");
        }
        return this;
    }

    public final TestSubscriber<T> requestMore(long n) {
        request(n);
        return this;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
        }

        public void onNext(Object t) {
        }

        public void onError(Throwable t) {
        }

        public void onComplete() {
        }
    }
}