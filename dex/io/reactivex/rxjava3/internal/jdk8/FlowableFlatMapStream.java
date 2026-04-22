package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapStream<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableFlatMapStream(Flowable<T> source, Function<? super T, ? extends Stream<? extends R>> mapper, int prefetch) {
        this.source = source;
        this.mapper = mapper;
        this.prefetch = prefetch;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<? extends R> */
    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        if (this.source instanceof Supplier) {
            Stream stream = null;
            try {
                Object obj = ((Supplier) this.source).get();
                if (obj != null) {
                    stream = (Stream) Objects.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Stream");
                }
                if (stream != null) {
                    FlowableFromStream.subscribeStream(s, stream);
                    return;
                } else {
                    EmptySubscription.complete(s);
                    return;
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                EmptySubscription.error(ex, s);
                return;
            }
        }
        this.source.subscribe(subscribe(s, this.mapper, this.prefetch));
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper, int prefetch) {
        return new FlatMapStreamSubscriber(downstream, mapper, prefetch);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class FlatMapStreamSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean cancelled;
        int consumed;
        AutoCloseable currentCloseable;
        Iterator<? extends R> currentIterator;
        final Subscriber<? super R> downstream;
        long emitted;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        int sourceMode;
        Subscription upstream;
        volatile boolean upstreamDone;
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable error = new AtomicThrowable();

        FlatMapStreamSubscriber(Subscriber<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper, int prefetch) {
            this.downstream = downstream;
            this.mapper = mapper;
            this.prefetch = prefetch;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                if (s instanceof QueueSubscription) {
                    QueueSubscription<T> qs = (QueueSubscription) s;
                    int m = qs.requestFusion(7);
                    if (m == 1) {
                        this.sourceMode = m;
                        this.queue = qs;
                        this.upstreamDone = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (m == 2) {
                        this.sourceMode = m;
                        this.queue = qs;
                        this.downstream.onSubscribe(this);
                        s.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                s.request(this.prefetch);
            }
        }

        public void onNext(T t) {
            if (this.sourceMode != 2 && !this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            }
            drain();
        }

        public void onError(Throwable t) {
            if (this.error.compareAndSet(null, t)) {
                this.upstreamDone = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(t);
        }

        public void onComplete() {
            this.upstreamDone = true;
            drain();
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            drain();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:62|(2:64|(8:66|67|68|70|(1:72)(1:75)|73|74|34))|79|67|68|70|(0)(0)|73|74|34) */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
            trySignalError(r2, r0);
            r14 = r17;
            r13 = 1;
         */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<? extends R> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a2 A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #3 {all -> 0x00ac, blocks: (B:32:0x0089, B:34:0x00a2), top: B:73:0x0089 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r13v12 */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v4 */
        /* JADX WARN: Type inference failed for: r13v6 */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Type inference failed for: r13v8 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            long emitted;
            Object requireNonNull;
            T t;
            boolean isEmpty;
            long emitted2;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> downstream = this.downstream;
            SimpleQueue<T> queue = this.queue;
            AtomicThrowable error = this.error;
            Iterator<? extends R> iterator = this.currentIterator;
            long requested = this.requested.get();
            long emitted3 = this.emitted;
            int limit = this.prefetch - (this.prefetch >> 2);
            ?? r13 = 1;
            boolean canRequest = this.sourceMode != 1;
            long emitted4 = emitted3;
            long requested2 = requested;
            Iterator<? extends R> iterator2 = iterator;
            int missed = 1;
            while (true) {
                if (this.cancelled) {
                    queue.clear();
                    clearCurrentSuppressCloseError();
                    emitted = emitted4;
                } else {
                    boolean isDone = this.upstreamDone;
                    if (error.get() != null) {
                        downstream.onError(error.get());
                        this.cancelled = r13;
                        emitted = emitted4;
                    } else {
                        if (iterator2 != null) {
                            emitted = emitted4;
                        } else {
                            try {
                                t = queue.poll();
                                isEmpty = t == null ? r13 : false;
                            } catch (Throwable ex) {
                                emitted = emitted4;
                                Exceptions.throwIfFatal(ex);
                                trySignalError(downstream, ex);
                            }
                            if (isDone && isEmpty) {
                                downstream.onComplete();
                                this.cancelled = r13;
                                emitted = emitted4;
                            } else if (isEmpty) {
                                emitted = emitted4;
                            } else {
                                if (canRequest) {
                                    int i = this.consumed + r13;
                                    this.consumed = i;
                                    if (i == limit) {
                                        this.consumed = 0;
                                        emitted2 = emitted4;
                                        this.upstream.request(limit);
                                        Stream stream = (Stream) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Stream");
                                        iterator2 = stream.iterator();
                                        if (!iterator2.hasNext()) {
                                            this.currentIterator = iterator2;
                                            this.currentCloseable = stream;
                                        } else {
                                            iterator2 = null;
                                        }
                                        emitted4 = emitted2;
                                        r13 = 1;
                                    }
                                }
                                emitted2 = emitted4;
                                Stream stream2 = (Stream) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Stream");
                                iterator2 = stream2.iterator();
                                if (!iterator2.hasNext()) {
                                }
                                emitted4 = emitted2;
                                r13 = 1;
                            }
                        }
                        if (iterator2 != null && emitted != requested2) {
                            try {
                                requireNonNull = Objects.requireNonNull(iterator2.next(), "The Stream.Iterator returned a null value");
                            } catch (Throwable ex2) {
                                Exceptions.throwIfFatal(ex2);
                                trySignalError(downstream, ex2);
                            }
                            if (!this.cancelled) {
                                downstream.onNext(requireNonNull);
                                emitted4 = emitted + 1;
                                if (this.cancelled) {
                                    r13 = 1;
                                } else {
                                    try {
                                        if (!iterator2.hasNext()) {
                                            iterator2 = null;
                                            clearCurrentRethrowCloseError();
                                        }
                                    } catch (Throwable ex3) {
                                        Exceptions.throwIfFatal(ex3);
                                        trySignalError(downstream, ex3);
                                    }
                                    r13 = 1;
                                }
                            }
                        }
                    }
                    emitted4 = emitted;
                    r13 = 1;
                }
                emitted4 = emitted;
                this.emitted = emitted4;
                missed = addAndGet(-missed);
                if (missed != 0) {
                    requested2 = this.requested.get();
                    r13 = 1;
                } else {
                    return;
                }
            }
        }

        void clearCurrentRethrowCloseError() throws Throwable {
            this.currentIterator = null;
            AutoCloseable ac = this.currentCloseable;
            this.currentCloseable = null;
            if (ac != null) {
                ac.close();
            }
        }

        void clearCurrentSuppressCloseError() {
            try {
                clearCurrentRethrowCloseError();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                RxJavaPlugins.onError(ex);
            }
        }

        void trySignalError(Subscriber<?> downstream, Throwable ex) {
            if (this.error.compareAndSet(null, ex)) {
                this.upstream.cancel();
                this.cancelled = true;
                downstream.onError(ex);
                return;
            }
            RxJavaPlugins.onError(ex);
        }
    }
}