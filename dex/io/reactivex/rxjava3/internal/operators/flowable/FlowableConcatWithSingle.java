package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> other;

    public FlowableConcatWithSingle(Flowable<T> source, SingleSource<? extends T> other) {
        super(source);
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new ConcatWithSubscriber(s, this.other));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        SingleSource<? extends T> other;
        final AtomicReference<Disposable> otherDisposable;

        ConcatWithSubscriber(Subscriber<? super T> actual, SingleSource<? extends T> other) {
            super(actual);
            this.other = other;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this.otherDisposable, d);
        }

        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable t) {
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            complete(t);
        }

        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            SingleSource<? extends T> ss = this.other;
            this.other = null;
            ss.subscribe(this);
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }
    }
}