package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableWindowTimed(Flowable<T> source, long timespan, long timeskip, TimeUnit unit, Scheduler scheduler, long maxSize, int bufferSize, boolean restartTimerOnMaxSize) {
        super(source);
        this.timespan = timespan;
        this.timeskip = timeskip;
        this.unit = unit;
        this.scheduler = scheduler;
        this.maxSize = maxSize;
        this.bufferSize = bufferSize;
        this.restartTimerOnMaxSize = restartTimerOnMaxSize;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> downstream) {
        if (this.timespan == this.timeskip) {
            if (this.maxSize == Long.MAX_VALUE) {
                this.source.subscribe((FlowableSubscriber) new WindowExactUnboundedSubscriber(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize));
                return;
            } else {
                this.source.subscribe((FlowableSubscriber) new WindowExactBoundedSubscriber(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
                return;
            }
        }
        this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(downstream, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class AbstractWindowSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        long emitted;
        Throwable error;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        volatile boolean upstreamCancelled;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean downstreamCancelled = new AtomicBoolean();
        final AtomicInteger windowCount = new AtomicInteger(1);

        abstract void cleanupResources();

        abstract void createFirstWindow();

        abstract void drain();

        AbstractWindowSubscriber(Subscriber<? super Flowable<T>> downstream, long timespan, TimeUnit unit, int bufferSize) {
            this.downstream = downstream;
            this.timespan = timespan;
            this.unit = unit;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public final void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable t) {
            this.error = t;
            this.done = true;
            drain();
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
            }
        }

        public final void cancel() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.cancel();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowExactUnboundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastProcessor<T> window;
        final Runnable windowRunnable;

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.scheduler = scheduler;
            this.timer = new SequentialDisposable();
            this.windowRunnable = new WindowRunnable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                if (this.requested.get() != 0) {
                    this.windowCount.getAndIncrement();
                    this.window = UnicastProcessor.create(this.bufferSize, this.windowRunnable);
                    this.emitted = 1L;
                    FlowableWindowSubscribeIntercept<T> intercept = new FlowableWindowSubscribeIntercept<>(this.window);
                    this.downstream.onNext(intercept);
                    this.timer.replace(this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit));
                    if (intercept.tryAbandon()) {
                        this.window.onComplete();
                    }
                    this.upstream.request(Long.MAX_VALUE);
                    return;
                }
                this.upstream.cancel();
                this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
                cleanupResources();
                this.upstreamCancelled = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> queue = this.queue;
            Subscriber<? super Flowable<T>> downstream = this.downstream;
            UnicastProcessor<T> unicastProcessor = this.window;
            int missed = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    queue.clear();
                    UnicastProcessor<T> window = null;
                    unicastProcessor = window;
                    this.window = null;
                } else {
                    boolean isDone = this.done;
                    Object o = queue.poll();
                    boolean isEmpty = o == null;
                    if (isDone && isEmpty) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            if (unicastProcessor != null) {
                                UnicastProcessor<T> window2 = unicastProcessor;
                                window2.onError(ex);
                            }
                            downstream.onError(ex);
                        } else {
                            if (unicastProcessor != null) {
                                UnicastProcessor<T> window3 = unicastProcessor;
                                window3.onComplete();
                            }
                            downstream.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!isEmpty) {
                        if (o == NEXT_WINDOW) {
                            if (unicastProcessor != null) {
                                UnicastProcessor<T> window4 = unicastProcessor;
                                window4.onComplete();
                                UnicastProcessor<T> window5 = null;
                                unicastProcessor = window5;
                                this.window = null;
                            }
                            if (this.downstreamCancelled.get()) {
                                this.timer.dispose();
                            } else if (this.requested.get() == this.emitted) {
                                this.upstream.cancel();
                                cleanupResources();
                                this.upstreamCancelled = true;
                                downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
                            } else {
                                this.emitted++;
                                this.windowCount.getAndIncrement();
                                UnicastProcessor<T> window6 = UnicastProcessor.create(this.bufferSize, this.windowRunnable);
                                unicastProcessor = window6;
                                this.window = unicastProcessor;
                                FlowableWindowSubscribeIntercept<T> intercept = new FlowableWindowSubscribeIntercept<>(unicastProcessor);
                                downstream.onNext(intercept);
                                if (intercept.tryAbandon()) {
                                    unicastProcessor.onComplete();
                                }
                            }
                        } else if (unicastProcessor != null) {
                            UnicastProcessor<T> window7 = unicastProcessor;
                            window7.onNext(o);
                        }
                    }
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void cleanupResources() {
            this.timer.dispose();
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class WindowRunnable implements Runnable {
            WindowRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactUnboundedSubscriber.this.windowDone();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowExactBoundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastProcessor<T> window;
        final Scheduler.Worker worker;

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize, long maxSize, boolean restartTimerOnMaxSize) {
            super(actual, timespan, unit, bufferSize);
            this.scheduler = scheduler;
            this.maxSize = maxSize;
            this.restartTimerOnMaxSize = restartTimerOnMaxSize;
            if (restartTimerOnMaxSize) {
                this.worker = scheduler.createWorker();
            } else {
                this.worker = null;
            }
            this.timer = new SequentialDisposable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                if (this.requested.get() != 0) {
                    this.emitted = 1L;
                    this.windowCount.getAndIncrement();
                    this.window = UnicastProcessor.create(this.bufferSize, this);
                    FlowableWindowSubscribeIntercept<T> intercept = new FlowableWindowSubscribeIntercept<>(this.window);
                    this.downstream.onNext(intercept);
                    Runnable boundaryTask = new WindowBoundaryRunnable(this, 1L);
                    if (this.restartTimerOnMaxSize) {
                        this.timer.replace(this.worker.schedulePeriodically(boundaryTask, this.timespan, this.timespan, this.unit));
                    } else {
                        this.timer.replace(this.scheduler.schedulePeriodicallyDirect(boundaryTask, this.timespan, this.timespan, this.unit));
                    }
                    if (intercept.tryAbandon()) {
                        this.window.onComplete();
                    }
                    this.upstream.request(Long.MAX_VALUE);
                    return;
                }
                this.upstream.cancel();
                this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
                cleanupResources();
                this.upstreamCancelled = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            windowDone();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void cleanupResources() {
            this.timer.dispose();
            Scheduler.Worker w = this.worker;
            if (w != null) {
                w.dispose();
            }
        }

        void boundary(WindowBoundaryRunnable sender) {
            this.queue.offer(sender);
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            SimplePlainQueue<Object> queue = this.queue;
            Subscriber<? super Flowable<T>> downstream = this.downstream;
            UnicastProcessor<T> window = this.window;
            while (true) {
                if (this.upstreamCancelled) {
                    queue.clear();
                    window = 0;
                    this.window = null;
                } else {
                    boolean isDone = this.done;
                    Object o = queue.poll();
                    boolean isEmpty = o == null;
                    if (isDone && isEmpty) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            if (window != 0) {
                                window.onError(ex);
                            }
                            downstream.onError(ex);
                        } else {
                            if (window != 0) {
                                window.onComplete();
                            }
                            downstream.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!isEmpty) {
                        if (o instanceof WindowBoundaryRunnable) {
                            WindowBoundaryRunnable boundary = (WindowBoundaryRunnable) o;
                            if (boundary.index == this.emitted || !this.restartTimerOnMaxSize) {
                                this.count = 0L;
                                window = createNewWindow(window);
                            }
                        } else if (window != null) {
                            window.onNext(o);
                            long count = this.count + 1;
                            if (count == this.maxSize) {
                                this.count = 0L;
                                window = createNewWindow(window);
                            } else {
                                this.count = count;
                            }
                        }
                    }
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }

        UnicastProcessor<T> createNewWindow(UnicastProcessor<T> window) {
            if (window != null) {
                window.onComplete();
                window = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long emitted = this.emitted;
                if (this.requested.get() == emitted) {
                    this.upstream.cancel();
                    cleanupResources();
                    this.upstreamCancelled = true;
                    this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(emitted)));
                } else {
                    long emitted2 = 1 + emitted;
                    this.emitted = emitted2;
                    this.windowCount.getAndIncrement();
                    window = UnicastProcessor.create(this.bufferSize, this);
                    this.window = window;
                    FlowableWindowSubscribeIntercept<T> intercept = new FlowableWindowSubscribeIntercept<>(window);
                    this.downstream.onNext(intercept);
                    if (this.restartTimerOnMaxSize) {
                        this.timer.update(this.worker.schedulePeriodically(new WindowBoundaryRunnable(this, emitted2), this.timespan, this.timespan, this.unit));
                    }
                    if (intercept.tryAbandon()) {
                        window.onComplete();
                    }
                }
            }
            return window;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class WindowBoundaryRunnable implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            WindowBoundaryRunnable(WindowExactBoundedSubscriber<?> parent, long index) {
                this.parent = parent;
                this.index = index;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowSkipSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<UnicastProcessor<T>> windows;
        final Scheduler.Worker worker;
        static final Object WINDOW_OPEN = new Object();
        static final Object WINDOW_CLOSE = new Object();

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> actual, long timespan, long timeskip, TimeUnit unit, Scheduler.Worker worker, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.timeskip = timeskip;
            this.worker = worker;
            this.windows = new LinkedList();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                if (this.requested.get() != 0) {
                    this.emitted = 1L;
                    this.windowCount.getAndIncrement();
                    UnicastProcessor<T> window = UnicastProcessor.create(this.bufferSize, this);
                    this.windows.add(window);
                    FlowableWindowSubscribeIntercept<T> intercept = new FlowableWindowSubscribeIntercept<>(window);
                    this.downstream.onNext(intercept);
                    this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                    this.worker.schedulePeriodically(new WindowBoundaryRunnable(this, true), this.timeskip, this.timeskip, this.unit);
                    if (intercept.tryAbandon()) {
                        window.onComplete();
                        this.windows.remove(window);
                    }
                    this.upstream.request(Long.MAX_VALUE);
                    return;
                }
                this.upstream.cancel();
                this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
                cleanupResources();
                this.upstreamCancelled = true;
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void cleanupResources() {
            this.worker.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void drain() {
            SimplePlainQueue<Object> queue;
            SimplePlainQueue<Object> queue2;
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            SimplePlainQueue<Object> queue3 = this.queue;
            Subscriber<? super Flowable<T>> downstream = this.downstream;
            List<UnicastProcessor<T>> windows = this.windows;
            while (true) {
                if (this.upstreamCancelled) {
                    queue3.clear();
                    windows.clear();
                    queue = queue3;
                } else {
                    boolean isDone = this.done;
                    Object o = queue3.poll();
                    boolean isEmpty = o == null;
                    if (isDone && isEmpty) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            for (UnicastProcessor<T> window : windows) {
                                window.onError(ex);
                            }
                            downstream.onError(ex);
                        } else {
                            for (UnicastProcessor<T> window2 : windows) {
                                window2.onComplete();
                            }
                            downstream.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                        queue2 = queue3;
                    } else if (isEmpty) {
                        queue = queue3;
                    } else if (o == WINDOW_OPEN) {
                        if (this.downstreamCancelled.get()) {
                            queue2 = queue3;
                        } else {
                            long emitted = this.emitted;
                            if (this.requested.get() != emitted) {
                                this.emitted = 1 + emitted;
                                this.windowCount.getAndIncrement();
                                UnicastProcessor<T> window3 = UnicastProcessor.create(this.bufferSize, this);
                                windows.add(window3);
                                FlowableWindowSubscribeIntercept<T> intercept = new FlowableWindowSubscribeIntercept<>(window3);
                                downstream.onNext(intercept);
                                queue2 = queue3;
                                this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                                if (intercept.tryAbandon()) {
                                    window3.onComplete();
                                }
                            } else {
                                queue2 = queue3;
                                this.upstream.cancel();
                                Throwable ex2 = new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(emitted));
                                for (UnicastProcessor<T> window4 : windows) {
                                    window4.onError(ex2);
                                }
                                downstream.onError(ex2);
                                cleanupResources();
                                this.upstreamCancelled = true;
                            }
                        }
                    } else {
                        queue2 = queue3;
                        if (o == WINDOW_CLOSE) {
                            if (!windows.isEmpty()) {
                                windows.remove(0).onComplete();
                            }
                        } else {
                            for (UnicastProcessor<T> window5 : windows) {
                                window5.onNext(o);
                            }
                        }
                    }
                    queue3 = queue2;
                }
                missed = addAndGet(-missed);
                if (missed != 0) {
                    queue3 = queue;
                } else {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            windowDone();
        }

        void boundary(boolean isOpen) {
            this.queue.offer(isOpen ? WINDOW_OPEN : WINDOW_CLOSE);
            drain();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class WindowBoundaryRunnable implements Runnable {
            final boolean isOpen;
            final WindowSkipSubscriber<?> parent;

            WindowBoundaryRunnable(WindowSkipSubscriber<?> parent, boolean isOpen) {
                this.parent = parent;
                this.isOpen = isOpen;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this.isOpen);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String missingBackpressureMessage(long index) {
        return "Unable to emit the next window (#" + index + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }
}