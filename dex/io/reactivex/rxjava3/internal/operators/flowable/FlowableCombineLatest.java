package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    final Publisher<? extends T>[] array;
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayErrors;
    final Iterable<? extends Publisher<? extends T>> iterable;

    public FlowableCombineLatest(Publisher<? extends T>[] array, Function<? super Object[], ? extends R> combiner, int bufferSize, boolean delayErrors) {
        this.array = array;
        this.iterable = null;
        this.combiner = combiner;
        this.bufferSize = bufferSize;
        this.delayErrors = delayErrors;
    }

    public FlowableCombineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> combiner, int bufferSize, boolean delayErrors) {
        this.array = null;
        this.iterable = iterable;
        this.combiner = combiner;
        this.bufferSize = bufferSize;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> s) {
        int count;
        Publisher<? extends T>[] sources = this.array;
        if (sources == null) {
            int count2 = 0;
            sources = new Publisher[8];
            try {
                for (Publisher<? extends T> p : this.iterable) {
                    if (count2 == sources.length) {
                        Publisher<? extends T>[] b = new Publisher[(count2 >> 2) + count2];
                        System.arraycopy(sources, 0, b, 0, count2);
                        sources = b;
                    }
                    int count3 = count2 + 1;
                    try {
                        sources[count2] = (Publisher) Objects.requireNonNull(p, "The Iterator returned a null Publisher");
                        count2 = count3;
                    } catch (Throwable th) {
                        ex = th;
                        Exceptions.throwIfFatal(ex);
                        EmptySubscription.error(ex, s);
                        return;
                    }
                }
                count = count2;
            } catch (Throwable th2) {
                ex = th2;
            }
        } else {
            int count4 = sources.length;
            count = count4;
        }
        if (count == 0) {
            EmptySubscription.complete(s);
        } else if (count == 1) {
            sources[0].subscribe(new FlowableMap.MapSubscriber(s, new SingletonArrayFunc()));
        } else {
            CombineLatestCoordinator<T, R> coordinator = new CombineLatestCoordinator<>(s, this.combiner, count, this.bufferSize, this.delayErrors);
            s.onSubscribe(coordinator);
            coordinator.subscribe(sources, count);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicThrowable error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(Subscriber<? super R> actual, Function<? super Object[], ? extends R> combiner, int n, int bufferSize, boolean delayErrors) {
            this.downstream = actual;
            this.combiner = combiner;
            CombineLatestInnerSubscriber<T>[] a = new CombineLatestInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                a[i] = new CombineLatestInnerSubscriber<>(this, i, bufferSize);
            }
            this.subscribers = a;
            this.latest = new Object[n];
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
            this.delayErrors = delayErrors;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            cancelAll();
            drain();
        }

        void subscribe(Publisher<? extends T>[] sources, int n) {
            CombineLatestInnerSubscriber<T>[] a = this.subscribers;
            for (int i = 0; i < n && !this.done && !this.cancelled; i++) {
                sources[i].subscribe(a[i]);
            }
        }

        void innerValue(int index, T value) {
            boolean replenishInsteadOfDrain;
            synchronized (this) {
                Object[] os = this.latest;
                int localNonEmptySources = this.nonEmptySources;
                if (os[index] == null) {
                    localNonEmptySources++;
                    this.nonEmptySources = localNonEmptySources;
                }
                os[index] = value;
                if (os.length == localNonEmptySources) {
                    this.queue.offer(this.subscribers[index], os.clone());
                    replenishInsteadOfDrain = false;
                } else {
                    replenishInsteadOfDrain = true;
                }
            }
            if (replenishInsteadOfDrain) {
                this.subscribers[index].requestOne();
            } else {
                drain();
            }
        }

        void innerComplete(int index) {
            synchronized (this) {
                Object[] os = this.latest;
                if (os[index] != null) {
                    int localCompletedSources = this.completedSources + 1;
                    if (localCompletedSources == os.length) {
                        this.done = true;
                    } else {
                        this.completedSources = localCompletedSources;
                        return;
                    }
                } else {
                    this.done = true;
                }
                drain();
            }
        }

        void innerError(int index, Throwable e) {
            if (ExceptionHelper.addThrowable(this.error, e)) {
                if (!this.delayErrors) {
                    cancelAll();
                    this.done = true;
                    drain();
                    return;
                }
                innerComplete(index);
                return;
            }
            RxJavaPlugins.onError(e);
        }

        void drainOutput() {
            Subscriber<? super R> a = this.downstream;
            SpscLinkedArrayQueue<Object> q = this.queue;
            int missed = 1;
            while (!this.cancelled) {
                Throwable ex = this.error.get();
                if (ex != null) {
                    q.clear();
                    a.onError(ex);
                    return;
                }
                boolean d = this.done;
                boolean empty = q.isEmpty();
                if (!empty) {
                    a.onNext((Object) null);
                }
                if (d && empty) {
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

        void drainAsync() {
            Subscriber<? super R> a = this.downstream;
            SpscLinkedArrayQueue<Object> q = this.queue;
            int missed = 1;
            do {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    boolean d = this.done;
                    Object v = q.poll();
                    boolean empty = v == null;
                    if (checkTerminated(d, empty, a, q)) {
                        return;
                    }
                    if (empty) {
                        break;
                    }
                    try {
                        a.onNext(Objects.requireNonNull(this.combiner.apply((Object[]) q.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) v).requestOne();
                        e++;
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        cancelAll();
                        ExceptionHelper.addThrowable(this.error, ex);
                        a.onError(ExceptionHelper.terminate(this.error));
                        return;
                    }
                }
                if (e == r && checkTerminated(this.done, q.isEmpty(), a, q)) {
                    return;
                }
                if (e != 0 && r != Long.MAX_VALUE) {
                    this.requested.addAndGet(-e);
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
            }
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<?> a, SpscLinkedArrayQueue<?> q) {
            if (this.cancelled) {
                cancelAll();
                q.clear();
                this.error.tryTerminateAndReport();
                return true;
            } else if (d) {
                if (this.delayErrors) {
                    if (empty) {
                        cancelAll();
                        this.error.tryTerminateConsumer(a);
                        return true;
                    }
                    return false;
                }
                Throwable e = ExceptionHelper.terminate(this.error);
                if (e != null && e != ExceptionHelper.TERMINATED) {
                    cancelAll();
                    q.clear();
                    a.onError(e);
                    return true;
                } else if (empty) {
                    cancelAll();
                    a.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void cancelAll() {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr;
            for (CombineLatestInnerSubscriber<T> inner : this.subscribers) {
                inner.cancel();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int requestedMode) {
            if ((requestedMode & 4) != 0) {
                return 0;
            }
            int m = requestedMode & 2;
            this.outputFused = m != 0;
            return m;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() throws Throwable {
            Object e = this.queue.poll();
            if (e == null) {
                return null;
            }
            R r = (R) Objects.requireNonNull(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) e).requestOne();
            return r;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> parent, int index, int prefetch) {
            this.parent = parent;
            this.index = index;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, this.prefetch);
        }

        public void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        public void onError(Throwable t) {
            this.parent.innerError(this.index, t);
        }

        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void requestOne() {
            int p = this.produced + 1;
            if (p == this.limit) {
                this.produced = 0;
                get().request(p);
                return;
            }
            this.produced = p;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(T t) throws Throwable {
            return FlowableCombineLatest.this.combiner.apply(new Object[]{t});
        }
    }
}