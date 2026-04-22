package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource other;

    public FlowableMergeWithCompletable(Flowable<T> source, CompletableSource other) {
        super(source);
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithSubscriber<T> parent = new MergeWithSubscriber<>(subscriber);
        subscriber.onSubscribe(parent);
        this.source.subscribe((FlowableSubscriber) parent);
        this.other.subscribe(parent.otherObserver);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        final Subscriber<? super T> downstream;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
        final OtherObserver otherObserver = new OtherObserver(this);
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        MergeWithSubscriber(Subscriber<? super T> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, s);
        }

        public void onNext(T t) {
            HalfSerializer.onNext(this.downstream, t, this, this.errors);
        }

        public void onError(Throwable ex) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.onError(this.downstream, ex, this, this.errors);
        }

        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                HalfSerializer.onComplete(this.downstream, this, this.errors);
            }
        }

        public void request(long n) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, n);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
            this.errors.tryTerminateAndReport();
        }

        void otherError(Throwable ex) {
            SubscriptionHelper.cancel(this.mainSubscription);
            HalfSerializer.onError(this.downstream, ex, this, this.errors);
        }

        void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                HalfSerializer.onComplete(this.downstream, this, this.errors);
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithSubscriber<?> parent;

            OtherObserver(MergeWithSubscriber<?> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                this.parent.otherError(e);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}