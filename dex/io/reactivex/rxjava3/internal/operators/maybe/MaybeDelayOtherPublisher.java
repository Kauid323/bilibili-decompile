package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> other;

    public MaybeDelayOtherPublisher(MaybeSource<T> source, Publisher<U> other) {
        super(source);
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new DelayMaybeObserver(observer, this.other));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {
        final OtherSubscriber<T> other;
        final Publisher<U> otherSource;
        Disposable upstream;

        DelayMaybeObserver(MaybeObserver<? super T> actual, Publisher<U> otherSource) {
            this.other = new OtherSubscriber<>(actual);
            this.otherSource = otherSource;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.other);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.other.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.other.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            this.upstream = DisposableHelper.DISPOSED;
            this.other.value = value;
            subscribeNext();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.upstream = DisposableHelper.DISPOSED;
            this.other.error = e;
            subscribeNext();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            subscribeNext();
        }

        void subscribeNext() {
            this.otherSource.subscribe(this.other);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final MaybeObserver<? super T> downstream;
        Throwable error;
        T value;

        OtherSubscriber(MaybeObserver<? super T> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, Long.MAX_VALUE);
        }

        public void onNext(Object t) {
            Subscription s = get();
            if (s != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                s.cancel();
                onComplete();
            }
        }

        public void onError(Throwable t) {
            Throwable e = this.error;
            if (e == null) {
                this.downstream.onError(t);
            } else {
                this.downstream.onError(new CompositeException(e, t));
            }
        }

        public void onComplete() {
            Throwable e = this.error;
            if (e != null) {
                this.downstream.onError(e);
                return;
            }
            T v = this.value;
            if (v != null) {
                this.downstream.onSuccess(v);
            } else {
                this.downstream.onComplete();
            }
        }
    }
}