package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends Publisher<U>> debounceSelector;

    public FlowableDebounce(Flowable<T> source, Function<? super T, ? extends Publisher<U>> debounceSelector) {
        super(source);
        this.debounceSelector = debounceSelector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new DebounceSubscriber(new SerializedSubscriber(s), this.debounceSelector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        final Function<? super T, ? extends Publisher<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        final Subscriber<? super T> downstream;
        volatile long index;
        Subscription upstream;

        DebounceSubscriber(Subscriber<? super T> actual, Function<? super T, ? extends Publisher<U>> debounceSelector) {
            this.downstream = actual;
            this.debounceSelector = debounceSelector;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long idx = this.index + 1;
            this.index = idx;
            Disposable d = this.debouncer.get();
            if (d != null) {
                d.dispose();
            }
            try {
                Publisher<U> p = (Publisher) Objects.requireNonNull(this.debounceSelector.apply(t), "The publisher supplied is null");
                DebounceInnerSubscriber<T, U> dis = new DebounceInnerSubscriber<>(this, idx, t);
                if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.debouncer, d, dis)) {
                    p.subscribe(dis);
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                cancel();
                this.downstream.onError(e);
            }
        }

        public void onError(Throwable t) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable d = this.debouncer.get();
            if (!DisposableHelper.isDisposed(d)) {
                DebounceInnerSubscriber<T, U> dis = (DebounceInnerSubscriber) d;
                if (dis != null) {
                    dis.emit();
                }
                DisposableHelper.dispose(this.debouncer);
                this.downstream.onComplete();
            }
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this, n);
            }
        }

        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        void emit(long idx, T value) {
            if (idx == this.index) {
                long r = get();
                if (r != 0) {
                    this.downstream.onNext(value);
                    BackpressureHelper.produced(this, 1L);
                    return;
                }
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceSubscriber<T, U> parent;
            final T value;

            DebounceInnerSubscriber(DebounceSubscriber<T, U> parent, long index, T value) {
                this.parent = parent;
                this.index = index;
                this.value = value;
            }

            public void onNext(U t) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cancel();
                emit();
            }

            void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.parent.emit(this.index, this.value);
                }
            }

            public void onError(Throwable t) {
                if (this.done) {
                    RxJavaPlugins.onError(t);
                    return;
                }
                this.done = true;
                this.parent.onError(t);
            }

            public void onComplete() {
                if (this.done) {
                    return;
                }
                this.done = true;
                emit();
            }
        }
    }
}