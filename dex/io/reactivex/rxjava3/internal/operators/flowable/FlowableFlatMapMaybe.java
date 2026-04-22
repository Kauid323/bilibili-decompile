package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int maxConcurrency;

    public FlowableFlatMapMaybe(Flowable<T> source, Function<? super T, ? extends MaybeSource<? extends R>> mapper, boolean delayError, int maxConcurrency) {
        super(source);
        this.mapper = mapper;
        this.delayErrors = delayError;
        this.maxConcurrency = maxConcurrency;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new FlatMapMaybeSubscriber(s, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final int maxConcurrency;
        Subscription upstream;
        final AtomicLong requested = new AtomicLong();
        final CompositeDisposable set = new CompositeDisposable();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<SpscLinkedArrayQueue<R>> queue = new AtomicReference<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        public FlatMapMaybeSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends MaybeSource<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
            this.downstream = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
            this.maxConcurrency = maxConcurrency;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                int m = this.maxConcurrency;
                if (m == Integer.MAX_VALUE) {
                    s.request(Long.MAX_VALUE);
                } else {
                    s.request(this.maxConcurrency);
                }
            }
        }

        public void onNext(T t) {
            try {
                MaybeSource<? extends R> ms = (MaybeSource) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                FlatMapMaybeSubscriber<T, R>.InnerObserver inner = new InnerObserver();
                if (!this.cancelled && this.set.add(inner)) {
                    ms.subscribe(inner);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.cancel();
                onError(ex);
            }
        }

        public void onError(Throwable t) {
            this.active.decrementAndGet();
            if (this.errors.tryAddThrowableOrReport(t)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
            }
        }

        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
            this.errors.tryTerminateAndReport();
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        void innerSuccess(FlatMapMaybeSubscriber<T, R>.InnerObserver inner, R value) {
            this.set.delete(inner);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean d = this.active.decrementAndGet() == 0;
                    if (this.requested.get() != 0) {
                        this.downstream.onNext(value);
                        if (checkTerminate(d, this.queue.get())) {
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                        BackpressureHelper.produced(this.requested, 1L);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(1L);
                        }
                    } else {
                        SpscLinkedArrayQueue<R> q = getOrCreateQueue();
                        synchronized (q) {
                            q.offer(value);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
            }
            SpscLinkedArrayQueue<R> q2 = getOrCreateQueue();
            synchronized (q2) {
                q2.offer(value);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        SpscLinkedArrayQueue<R> getOrCreateQueue() {
            SpscLinkedArrayQueue<R> current = this.queue.get();
            if (current != null) {
                return current;
            }
            SpscLinkedArrayQueue<R> current2 = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            return MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.queue, (Object) null, current2) ? current2 : this.queue.get();
        }

        void innerError(FlatMapMaybeSubscriber<T, R>.InnerObserver inner, Throwable e) {
            this.set.delete(inner);
            if (this.errors.tryAddThrowableOrReport(e)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1L);
                }
                this.active.decrementAndGet();
                drain();
            }
        }

        void innerComplete(FlatMapMaybeSubscriber<T, R>.InnerObserver inner) {
            this.set.delete(inner);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean d = this.active.decrementAndGet() == 0;
                    SpscLinkedArrayQueue<R> q = this.queue.get();
                    if (checkTerminate(d, q)) {
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            drain();
        }

        static boolean checkTerminate(boolean d, SpscLinkedArrayQueue<?> q) {
            return d && (q == null || q.isEmpty());
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void clear() {
            SpscLinkedArrayQueue<R> q = this.queue.get();
            if (q != null) {
                q.clear();
            }
        }

        void drainLoop() {
            boolean empty;
            int missed = 1;
            Subscriber<? super R> a = this.downstream;
            AtomicInteger n = this.active;
            AtomicReference<SpscLinkedArrayQueue<R>> qr = this.queue;
            do {
                long r = this.requested.get();
                long e = 0;
                while (true) {
                    empty = true;
                    if (e == r) {
                        break;
                    } else if (this.cancelled) {
                        clear();
                        return;
                    } else {
                        if (!this.delayErrors) {
                            Throwable ex = this.errors.get();
                            if (ex != null) {
                                clear();
                                this.errors.tryTerminateConsumer(a);
                                return;
                            }
                        }
                        boolean d = n.get() == 0;
                        SpscLinkedArrayQueue<R> q = qr.get();
                        R v = q != null ? q.poll() : null;
                        boolean empty2 = v == null;
                        if (d && empty2) {
                            this.errors.tryTerminateConsumer(a);
                            return;
                        } else if (empty2) {
                            break;
                        } else {
                            a.onNext(v);
                            e++;
                        }
                    }
                }
                if (e == r) {
                    if (this.cancelled) {
                        clear();
                        return;
                    }
                    if (!this.delayErrors) {
                        Throwable ex2 = this.errors.get();
                        if (ex2 != null) {
                            clear();
                            this.errors.tryTerminateConsumer(a);
                            return;
                        }
                    }
                    boolean d2 = n.get() == 0;
                    SpscLinkedArrayQueue<R> q2 = qr.get();
                    if (q2 != null && !q2.isEmpty()) {
                        empty = false;
                    }
                    if (d2 && empty) {
                        this.errors.tryTerminateConsumer(a);
                        return;
                    }
                }
                if (e != 0) {
                    BackpressureHelper.produced(this.requested, e);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(e);
                    }
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R value) {
                FlatMapMaybeSubscriber.this.innerSuccess(this, value);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                FlatMapMaybeSubscriber.this.innerError(this, e);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                FlatMapMaybeSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}