package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Supplier<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableBufferTimed(Flowable<T> source, long timespan, long timeskip, TimeUnit unit, Scheduler scheduler, Supplier<U> bufferSupplier, int maxSize, boolean restartTimerOnMaxSize) {
        super(source);
        this.timespan = timespan;
        this.timeskip = timeskip;
        this.unit = unit;
        this.scheduler = scheduler;
        this.bufferSupplier = bufferSupplier;
        this.maxSize = maxSize;
        this.restartTimerOnMaxSize = restartTimerOnMaxSize;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super U> s) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber) new BufferExactUnboundedSubscriber(new SerializedSubscriber(s), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker w = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe((FlowableSubscriber) new BufferExactBoundedSubscriber(new SerializedSubscriber(s), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, w));
        } else {
            this.source.subscribe((FlowableSubscriber) new BufferSkipBoundedSubscriber(new SerializedSubscriber(s), this.bufferSupplier, this.timespan, this.timeskip, this.unit, w));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Supplier<U> bufferSupplier;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber a, Object v) {
            return accept((Subscriber<? super Subscriber>) a, (Subscriber) ((Collection) v));
        }

        BufferExactUnboundedSubscriber(Subscriber<? super U> actual, Supplier<U> bufferSupplier, long timespan, TimeUnit unit, Scheduler scheduler) {
            super(actual, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.bufferSupplier = bufferSupplier;
            this.timespan = timespan;
            this.unit = unit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                try {
                    U b = (U) Objects.requireNonNull(this.bufferSupplier.get(), "The supplied buffer is null");
                    this.buffer = b;
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        s.request(Long.MAX_VALUE);
                        Disposable d = this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit);
                        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.timer, (Object) null, d)) {
                            d.dispose();
                        }
                    }
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    cancel();
                    EmptySubscription.error(e, this.downstream);
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                U b = this.buffer;
                if (b != null) {
                    b.add(t);
                }
            }
        }

        public void onError(Throwable t) {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(t);
        }

        public void onComplete() {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                U b = this.buffer;
                if (b == null) {
                    return;
                }
                this.buffer = null;
                this.queue.offer(b);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, null, this);
                }
            }
        }

        public void request(long n) {
            requested(n);
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            DisposableHelper.dispose(this.timer);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U next = (U) Objects.requireNonNull(this.bufferSupplier.get(), "The supplied buffer is null");
                synchronized (this) {
                    U current = this.buffer;
                    if (current == null) {
                        return;
                    }
                    this.buffer = next;
                    fastPathEmitMax(current, false, this);
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                cancel();
                this.downstream.onError(e);
            }
        }

        public boolean accept(Subscriber<? super U> a, U v) {
            this.downstream.onNext(v);
            return true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Supplier<U> bufferSupplier;
        final List<U> buffers;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber a, Object v) {
            return accept((Subscriber<? super Subscriber>) a, (Subscriber) ((Collection) v));
        }

        BufferSkipBoundedSubscriber(Subscriber<? super U> actual, Supplier<U> bufferSupplier, long timespan, long timeskip, TimeUnit unit, Scheduler.Worker w) {
            super(actual, new MpscLinkedQueue());
            this.bufferSupplier = bufferSupplier;
            this.timespan = timespan;
            this.timeskip = timeskip;
            this.unit = unit;
            this.w = w;
            this.buffers = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (!SubscriptionHelper.validate(this.upstream, s)) {
                return;
            }
            this.upstream = s;
            try {
                Collection collection = (Collection) Objects.requireNonNull(this.bufferSupplier.get(), "The supplied buffer is null");
                this.buffers.add(collection);
                this.downstream.onSubscribe(this);
                s.request(Long.MAX_VALUE);
                this.w.schedulePeriodically(this, this.timeskip, this.timeskip, this.unit);
                this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.w.dispose();
                s.cancel();
                EmptySubscription.error(e, this.downstream);
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                for (U b : this.buffers) {
                    b.add(t);
                }
            }
        }

        public void onError(Throwable t) {
            this.done = true;
            this.w.dispose();
            clear();
            this.downstream.onError(t);
        }

        public void onComplete() {
            List<U> bs;
            synchronized (this) {
                bs = new ArrayList<>(this.buffers);
                this.buffers.clear();
            }
            for (U b : bs) {
                this.queue.offer(b);
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.w, this);
            }
        }

        public void request(long n) {
            requested(n);
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.w.dispose();
            clear();
        }

        void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            try {
                Collection collection = (Collection) Objects.requireNonNull(this.bufferSupplier.get(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    this.buffers.add(collection);
                    this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                cancel();
                this.downstream.onError(e);
            }
        }

        public boolean accept(Subscriber<? super U> a, U v) {
            a.onNext(v);
            return true;
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            RemoveFromBuffer(U buffer) {
                this.buffer = buffer;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.buffers.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber.this.fastPathOrderedEmitMax(this.buffer, false, BufferSkipBoundedSubscriber.this.w);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Supplier<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber a, Object v) {
            return accept((Subscriber<? super Subscriber>) a, (Subscriber) ((Collection) v));
        }

        BufferExactBoundedSubscriber(Subscriber<? super U> actual, Supplier<U> bufferSupplier, long timespan, TimeUnit unit, int maxSize, boolean restartOnMaxSize, Scheduler.Worker w) {
            super(actual, new MpscLinkedQueue());
            this.bufferSupplier = bufferSupplier;
            this.timespan = timespan;
            this.unit = unit;
            this.maxSize = maxSize;
            this.restartTimerOnMaxSize = restartOnMaxSize;
            this.w = w;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (!SubscriptionHelper.validate(this.upstream, s)) {
                return;
            }
            this.upstream = s;
            try {
                U b = (U) Objects.requireNonNull(this.bufferSupplier.get(), "The supplied buffer is null");
                this.buffer = b;
                this.downstream.onSubscribe(this);
                this.timer = this.w.schedulePeriodically(this, this.timespan, this.timespan, this.unit);
                s.request(Long.MAX_VALUE);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.w.dispose();
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
                if (b.size() < this.maxSize) {
                    return;
                }
                this.buffer = null;
                this.producerIndex++;
                if (this.restartTimerOnMaxSize) {
                    this.timer.dispose();
                }
                fastPathOrderedEmitMax(b, false, this);
                try {
                    U b2 = (U) Objects.requireNonNull(this.bufferSupplier.get(), "The supplied buffer is null");
                    synchronized (this) {
                        this.buffer = b2;
                        this.consumerIndex++;
                    }
                    if (this.restartTimerOnMaxSize) {
                        this.timer = this.w.schedulePeriodically(this, this.timespan, this.timespan, this.unit);
                    }
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    cancel();
                    this.downstream.onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(t);
            this.w.dispose();
        }

        public void onComplete() {
            U b;
            synchronized (this) {
                b = this.buffer;
                this.buffer = null;
            }
            if (b != null) {
                this.queue.offer(b);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
                this.w.dispose();
            }
        }

        public boolean accept(Subscriber<? super U> a, U v) {
            a.onNext(v);
            return true;
        }

        public void request(long n) {
            requested(n);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.buffer = null;
            }
            this.upstream.cancel();
            this.w.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U next = (U) Objects.requireNonNull(this.bufferSupplier.get(), "The supplied buffer is null");
                synchronized (this) {
                    U current = this.buffer;
                    if (current != null && this.producerIndex == this.consumerIndex) {
                        this.buffer = next;
                        fastPathOrderedEmitMax(current, false, this);
                    }
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                cancel();
                this.downstream.onError(e);
            }
        }
    }
}