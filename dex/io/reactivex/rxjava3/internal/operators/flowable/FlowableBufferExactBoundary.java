package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import j$.util.Objects;
import java.util.Collection;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<B> boundary;
    final Supplier<U> bufferSupplier;

    public FlowableBufferExactBoundary(Flowable<T> source, Publisher<B> boundary, Supplier<U> bufferSupplier) {
        super(source);
        this.boundary = boundary;
        this.bufferSupplier = bufferSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super U> s) {
        this.source.subscribe((FlowableSubscriber) new BufferExactBoundarySubscriber(new SerializedSubscriber(s), this.bufferSupplier, this.boundary));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        final Publisher<B> boundary;
        U buffer;
        final Supplier<U> bufferSupplier;
        Disposable other;
        Subscription upstream;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber a, Object v) {
            return accept((Subscriber<? super Subscriber>) a, (Subscriber) ((Collection) v));
        }

        BufferExactBoundarySubscriber(Subscriber<? super U> actual, Supplier<U> bufferSupplier, Publisher<B> boundary) {
            super(actual, new MpscLinkedQueue());
            this.bufferSupplier = bufferSupplier;
            this.boundary = boundary;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (!SubscriptionHelper.validate(this.upstream, s)) {
                return;
            }
            this.upstream = s;
            try {
                U b = (U) Objects.requireNonNull(this.bufferSupplier.get(), "The buffer supplied is null");
                this.buffer = b;
                BufferBoundarySubscriber<T, U, B> bs = new BufferBoundarySubscriber<>(this);
                this.other = bs;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    s.request(Long.MAX_VALUE);
                    this.boundary.subscribe(bs);
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.cancelled = true;
                s.cancel();
                EmptySubscription.error(e, this.downstream);
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                U b = this.buffer;
                if (b == null) {
                    return;
                }
                b.add(t);
            }
        }

        public void onError(Throwable t) {
            cancel();
            this.downstream.onError(t);
        }

        public void onComplete() {
            synchronized (this) {
                U b = this.buffer;
                if (b == null) {
                    return;
                }
                this.buffer = null;
                this.queue.offer(b);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
            }
        }

        public void request(long n) {
            requested(n);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.other.dispose();
                this.upstream.cancel();
                if (enter()) {
                    this.queue.clear();
                }
            }
        }

        void next() {
            try {
                U next = (U) Objects.requireNonNull(this.bufferSupplier.get(), "The buffer supplied is null");
                synchronized (this) {
                    U b = this.buffer;
                    if (b == null) {
                        return;
                    }
                    this.buffer = next;
                    fastPathEmitMax(b, false, this);
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                cancel();
                this.downstream.onError(e);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public boolean accept(Subscriber<? super U> a, U v) {
            this.downstream.onNext(v);
            return true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferExactBoundarySubscriber<T, U, B> parent;

        BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> parent) {
            this.parent = parent;
        }

        public void onNext(B t) {
            this.parent.next();
        }

        public void onError(Throwable t) {
            this.parent.onError(t);
        }

        public void onComplete() {
            this.parent.onComplete();
        }
    }
}