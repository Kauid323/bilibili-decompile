package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class FlowableFromStream<T> extends Flowable<T> {
    final Stream<T> stream;

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<T> */
    public FlowableFromStream(Stream<T> stream) {
        this.stream = stream;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        subscribeStream(s, this.stream);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<T> */
    public static <T> void subscribeStream(Subscriber<? super T> s, Stream<T> stream) {
        try {
            Iterator<T> iterator = stream.iterator();
            if (!iterator.hasNext()) {
                EmptySubscription.complete(s);
                closeSafely(stream);
            } else if (s instanceof ConditionalSubscriber) {
                s.onSubscribe(new StreamConditionalSubscription((ConditionalSubscriber) s, iterator, stream));
            } else {
                s.onSubscribe(new StreamSubscription(s, iterator, stream));
            }
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptySubscription.error(ex, s);
            closeSafely(stream);
        }
    }

    static void closeSafely(AutoCloseable c) {
        try {
            c.close();
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            RxJavaPlugins.onError(ex);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static abstract class AbstractStreamSubscription<T> extends AtomicLong implements QueueSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        volatile boolean cancelled;
        AutoCloseable closeable;
        Iterator<T> iterator;
        boolean once;

        abstract void run(long n);

        AbstractStreamSubscription(Iterator<T> iterator, AutoCloseable closeable) {
            this.iterator = iterator;
            this.closeable = closeable;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.add(this, n) == 0) {
                run(n);
            }
        }

        public void cancel() {
            this.cancelled = true;
            request(1L);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 1) != 0) {
                lazySet(Long.MAX_VALUE);
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T value) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T v1, T v2) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            if (this.iterator == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!this.iterator.hasNext()) {
                clear();
                return null;
            }
            return (T) Objects.requireNonNull(this.iterator.next(), "The Stream's Iterator.next() returned a null value");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<T> it = this.iterator;
            if (it != null) {
                if (!this.once || it.hasNext()) {
                    return false;
                }
                clear();
                return true;
            }
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.iterator = null;
            AutoCloseable c = this.closeable;
            this.closeable = null;
            if (c != null) {
                FlowableFromStream.closeSafely(c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class StreamSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        final Subscriber<? super T> downstream;

        StreamSubscription(Subscriber<? super T> downstream, Iterator<T> iterator, AutoCloseable closeable) {
            super(iterator, closeable);
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.internal.jdk8.FlowableFromStream.AbstractStreamSubscription
        public void run(long n) {
            long emitted = 0;
            Iterator<T> iterator = this.iterator;
            Subscriber<? super T> downstream = this.downstream;
            while (!this.cancelled) {
                try {
                    downstream.onNext(Objects.requireNonNull(iterator.next(), "The Stream's Iterator returned a null value"));
                    if (this.cancelled) {
                        continue;
                    } else {
                        try {
                            if (!iterator.hasNext()) {
                                downstream.onComplete();
                                this.cancelled = true;
                            } else {
                                long j2 = 1 + emitted;
                                emitted = j2;
                                if (j2 != n) {
                                    continue;
                                } else {
                                    n = get();
                                    if (emitted != n) {
                                        continue;
                                    } else if (!compareAndSet(n, 0L)) {
                                        n = get();
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable ex) {
                            Exceptions.throwIfFatal(ex);
                            downstream.onError(ex);
                            this.cancelled = true;
                        }
                    }
                } catch (Throwable ex2) {
                    Exceptions.throwIfFatal(ex2);
                    downstream.onError(ex2);
                    this.cancelled = true;
                }
            }
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class StreamConditionalSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        final ConditionalSubscriber<? super T> downstream;

        StreamConditionalSubscription(ConditionalSubscriber<? super T> downstream, Iterator<T> iterator, AutoCloseable closeable) {
            super(iterator, closeable);
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.internal.jdk8.FlowableFromStream.AbstractStreamSubscription
        public void run(long n) {
            long emitted = 0;
            Iterator<T> iterator = this.iterator;
            ConditionalSubscriber<? super T> downstream = this.downstream;
            while (!this.cancelled) {
                try {
                    if (downstream.tryOnNext((Object) Objects.requireNonNull(iterator.next(), "The Stream's Iterator returned a null value"))) {
                        emitted++;
                    }
                    if (this.cancelled) {
                        continue;
                    } else {
                        try {
                            if (!iterator.hasNext()) {
                                downstream.onComplete();
                                this.cancelled = true;
                            } else if (emitted != n) {
                                continue;
                            } else {
                                n = get();
                                if (emitted != n) {
                                    continue;
                                } else if (!compareAndSet(n, 0L)) {
                                    n = get();
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable ex) {
                            Exceptions.throwIfFatal(ex);
                            downstream.onError(ex);
                            this.cancelled = true;
                        }
                    }
                } catch (Throwable ex2) {
                    Exceptions.throwIfFatal(ex2);
                    downstream.onError(ex2);
                    this.cancelled = true;
                }
            }
            clear();
        }
    }
}