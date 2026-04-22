package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import j$.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

public final class MaybeMergeArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        T poll();

        int producerIndex();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        SimpleQueueWithConsumerIndex<Object> queue;
        MaybeSource<? extends T>[] maybes = this.sources;
        int n = maybes.length;
        if (n <= bufferSize()) {
            queue = new MpscFillOnceSimpleQueue<>(n);
        } else {
            queue = new ClqSimpleQueue<>();
        }
        MergeMaybeObserver<T> parent = new MergeMaybeObserver<>(s, n, queue);
        s.onSubscribe(parent);
        AtomicThrowable e = parent.errors;
        for (MaybeSource<? extends T> source : maybes) {
            if (parent.isCancelled() || e.get() != null) {
                return;
            }
            source.subscribe(parent);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;
        volatile boolean cancelled;
        long consumed;
        final Subscriber<? super T> downstream;
        boolean outputFused;
        final SimpleQueueWithConsumerIndex<Object> queue;
        final int sourceCount;
        final CompositeDisposable set = new CompositeDisposable();
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable errors = new AtomicThrowable();

        MergeMaybeObserver(Subscriber<? super T> actual, int sourceCount, SimpleQueueWithConsumerIndex<Object> queue) {
            this.downstream = actual;
            this.sourceCount = sourceCount;
            this.queue = queue;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            T t;
            do {
                t = (T) this.queue.poll();
            } while (t == NotificationLite.COMPLETE);
            return t;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.set.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.set.add(d);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            this.queue.offer(value);
            drain();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                this.set.dispose();
                this.queue.offer(NotificationLite.COMPLETE);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        void drainNormal() {
            int missed = 1;
            Subscriber<? super T> a = this.downstream;
            SimpleQueueWithConsumerIndex<Object> q = this.queue;
            long e = this.consumed;
            do {
                long r = this.requested.get();
                while (e != r) {
                    if (this.cancelled) {
                        q.clear();
                        return;
                    }
                    Throwable ex = this.errors.get();
                    if (ex != null) {
                        q.clear();
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    } else if (q.consumerIndex() == this.sourceCount) {
                        a.onComplete();
                        return;
                    } else {
                        Object v = q.poll();
                        if (v == null) {
                            break;
                        } else if (v != NotificationLite.COMPLETE) {
                            a.onNext(v);
                            e++;
                        }
                    }
                }
                if (e == r) {
                    Throwable ex2 = this.errors.get();
                    if (ex2 != null) {
                        q.clear();
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    while (q.peek() == NotificationLite.COMPLETE) {
                        q.drop();
                    }
                    if (q.consumerIndex() == this.sourceCount) {
                        a.onComplete();
                        return;
                    }
                }
                this.consumed = e;
                missed = addAndGet(-missed);
            } while (missed != 0);
        }

        void drainFused() {
            int missed = 1;
            Subscriber<? super T> a = this.downstream;
            SimpleQueueWithConsumerIndex<Object> q = this.queue;
            while (!this.cancelled) {
                Throwable ex = this.errors.get();
                if (ex != null) {
                    q.clear();
                    a.onError(ex);
                    return;
                }
                boolean d = q.producerIndex() == this.sourceCount;
                if (!q.isEmpty()) {
                    a.onNext((Object) null);
                }
                if (d) {
                    a.onComplete();
                    return;
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
            q.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        MpscFillOnceSimpleQueue(int length) {
            super(length);
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T value) {
            Objects.requireNonNull(value, "value is null");
            int idx = this.producerIndex.getAndIncrement();
            if (idx < length()) {
                lazySet(idx, value);
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T v1, T v2) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            int ci = this.consumerIndex;
            if (ci == length()) {
                return null;
            }
            AtomicInteger pi = this.producerIndex;
            do {
                T v = get(ci);
                if (v != null) {
                    this.consumerIndex = ci + 1;
                    lazySet(ci, null);
                    return v;
                }
            } while (pi.get() != ci);
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public T peek() {
            int ci = this.consumerIndex;
            if (ci == length()) {
                return null;
            }
            return get(ci);
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            int ci = this.consumerIndex;
            lazySet(ci, null);
            this.consumerIndex = ci + 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        ClqSimpleQueue() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T v1, T v2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T e) {
            this.producerIndex.getAndIncrement();
            return super.offer(e);
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            T v = (T) super.poll();
            if (v != null) {
                this.consumerIndex++;
            }
            return v;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            poll();
        }
    }
}