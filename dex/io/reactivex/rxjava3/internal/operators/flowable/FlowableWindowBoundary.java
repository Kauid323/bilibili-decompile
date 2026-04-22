package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int capacityHint;
    final Publisher<B> other;

    public FlowableWindowBoundary(Flowable<T> source, Publisher<B> other, int capacityHint) {
        super(source);
        this.other = other;
        this.capacityHint = capacityHint;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        WindowBoundaryMainSubscriber<T, B> parent = new WindowBoundaryMainSubscriber<>(subscriber, this.capacityHint);
        subscriber.onSubscribe(parent);
        parent.innerNext();
        this.other.subscribe(parent.boundarySubscriber);
        this.source.subscribe((FlowableSubscriber) parent);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        long emitted;
        UnicastProcessor<T> window;
        final WindowBoundaryInnerSubscriber<T, B> boundarySubscriber = new WindowBoundaryInnerSubscriber<>(this);
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> downstream, int capacityHint) {
            this.downstream = downstream;
            this.capacityHint = capacityHint;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this.upstream, s, Long.MAX_VALUE);
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable e) {
            this.boundarySubscriber.dispose();
            if (this.errors.tryAddThrowableOrReport(e)) {
                this.done = true;
                drain();
            }
        }

        public void onComplete() {
            this.boundarySubscriber.dispose();
            this.done = true;
            drain();
        }

        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundarySubscriber.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.upstream);
                }
            }
        }

        public void request(long n) {
            BackpressureHelper.add(this.requested, n);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.upstream);
            }
        }

        void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        void innerError(Throwable e) {
            SubscriptionHelper.cancel(this.upstream);
            if (this.errors.tryAddThrowableOrReport(e)) {
                this.done = true;
                drain();
            }
        }

        void innerComplete() {
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super Flowable<T>> downstream = this.downstream;
            MpscLinkedQueue<Object> queue = this.queue;
            AtomicThrowable errors = this.errors;
            long emitted = this.emitted;
            while (this.windows.get() != 0) {
                UnicastProcessor<T> w = this.window;
                boolean d = this.done;
                if (d && errors.get() != null) {
                    queue.clear();
                    Throwable ex = errors.terminate();
                    if (w != 0) {
                        this.window = null;
                        w.onError(ex);
                    }
                    downstream.onError(ex);
                    return;
                }
                Object v = queue.poll();
                boolean empty = v == null;
                if (d && empty) {
                    Throwable ex2 = errors.terminate();
                    if (ex2 == null) {
                        if (w != 0) {
                            this.window = null;
                            w.onComplete();
                        }
                        downstream.onComplete();
                        return;
                    }
                    if (w != 0) {
                        this.window = null;
                        w.onError(ex2);
                    }
                    downstream.onError(ex2);
                    return;
                } else if (!empty) {
                    if (v != NEXT_WINDOW) {
                        w.onNext(v);
                    } else {
                        if (w != 0) {
                            this.window = null;
                            w.onComplete();
                        }
                        if (!this.stopWindows.get()) {
                            UnicastProcessor<T> w2 = UnicastProcessor.create(this.capacityHint, this);
                            this.window = w2;
                            this.windows.getAndIncrement();
                            if (emitted != this.requested.get()) {
                                emitted++;
                                FlowableWindowSubscribeIntercept<T> intercept = new FlowableWindowSubscribeIntercept<>(w2);
                                downstream.onNext(intercept);
                                if (intercept.tryAbandon()) {
                                    w2.onComplete();
                                }
                            } else {
                                SubscriptionHelper.cancel(this.upstream);
                                this.boundarySubscriber.dispose();
                                errors.tryAddThrowableOrReport(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                this.done = true;
                            }
                        }
                    }
                } else {
                    this.emitted = emitted;
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            queue.clear();
            this.window = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B> parent;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> parent) {
            this.parent = parent;
        }

        public void onNext(B t) {
            if (this.done) {
                return;
            }
            this.parent.innerNext();
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.parent.innerError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete();
        }
    }
}