package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Supplier<C> bufferSupplier;
    final int size;
    final int skip;

    public FlowableBuffer(Flowable<T> source, int size, int skip, Supplier<C> bufferSupplier) {
        super(source);
        this.size = size;
        this.skip = skip;
        this.bufferSupplier = bufferSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super C> s) {
        if (this.size == this.skip) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferExactSubscriber(s, this.size, this.bufferSupplier));
        } else if (this.skip > this.size) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferSkipSubscriber(s, this.size, this.skip, this.bufferSupplier));
        } else {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferOverlappingSubscriber(s, this.size, this.skip, this.bufferSupplier));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        C buffer;
        final Supplier<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        Subscription upstream;

        PublisherBufferExactSubscriber(Subscriber<? super C> actual, int size, Supplier<C> bufferSupplier) {
            this.downstream = actual;
            this.size = size;
            this.bufferSupplier = bufferSupplier;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                this.upstream.request(BackpressureHelper.multiplyCap(n, this.size));
            }
        }

        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.util.Collection] */
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C b = this.buffer;
            if (b == null) {
                try {
                    b = (Collection) Objects.requireNonNull(this.bufferSupplier.get(), "The bufferSupplier returned a null buffer");
                    this.buffer = b;
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    cancel();
                    onError(e);
                    return;
                }
            }
            b.add(t);
            int i = this.index + 1;
            if (i == this.size) {
                this.index = 0;
                this.buffer = null;
                this.downstream.onNext(b);
                return;
            }
            this.index = i;
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.buffer = null;
            this.done = true;
            this.downstream.onError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C b = this.buffer;
            this.buffer = null;
            if (b != null) {
                this.downstream.onNext(b);
            }
            this.downstream.onComplete();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final Supplier<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferSkipSubscriber(Subscriber<? super C> actual, int size, int skip, Supplier<C> bufferSupplier) {
            this.downstream = actual;
            this.size = size;
            this.skip = skip;
            this.bufferSupplier = bufferSupplier;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    long u = BackpressureHelper.multiplyCap(n, this.size);
                    long v = BackpressureHelper.multiplyCap(this.skip - this.size, n - 1);
                    this.upstream.request(BackpressureHelper.addCap(u, v));
                    return;
                }
                this.upstream.request(BackpressureHelper.multiplyCap(this.skip, n));
            }
        }

        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.util.Collection] */
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C b = this.buffer;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    b = (Collection) Objects.requireNonNull(this.bufferSupplier.get(), "The bufferSupplier returned a null buffer");
                    this.buffer = b;
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    cancel();
                    onError(e);
                    return;
                }
            }
            if (b != null) {
                b.add(t);
                if (b.size() == this.size) {
                    this.buffer = null;
                    this.downstream.onNext(b);
                }
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C b = this.buffer;
            this.buffer = null;
            if (b != null) {
                this.downstream.onNext(b);
            }
            this.downstream.onComplete();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final Supplier<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        long produced;
        final int size;
        final int skip;
        Subscription upstream;
        final AtomicBoolean once = new AtomicBoolean();
        final ArrayDeque<C> buffers = new ArrayDeque<>();

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> actual, int size, int skip, Supplier<C> bufferSupplier) {
            this.downstream = actual;
            this.size = size;
            this.skip = skip;
            this.bufferSupplier = bufferSupplier;
        }

        @Override // io.reactivex.rxjava3.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        public void request(long n) {
            if (!SubscriptionHelper.validate(n) || QueueDrainHelper.postCompleteRequest(n, this.downstream, this.buffers, this, this)) {
                return;
            }
            if (!this.once.get() && this.once.compareAndSet(false, true)) {
                long u = BackpressureHelper.multiplyCap(this.skip, n - 1);
                long r = BackpressureHelper.addCap(this.size, u);
                this.upstream.request(r);
                return;
            }
            long r2 = BackpressureHelper.multiplyCap(this.skip, n);
            this.upstream.request(r2);
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> bs = this.buffers;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    bs.offer((Collection) Objects.requireNonNull(this.bufferSupplier.get(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    cancel();
                    onError(e);
                    return;
                }
            }
            Collection collection = (Collection) bs.peek();
            if (collection.size() + 1 == this.size) {
                bs.poll();
                collection.add(t);
                this.produced++;
                this.downstream.onNext(collection);
            }
            Iterator it = bs.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long p = this.produced;
            if (p != 0) {
                BackpressureHelper.produced(this, p);
            }
            QueueDrainHelper.postComplete(this.downstream, this.buffers, this, this);
        }
    }
}