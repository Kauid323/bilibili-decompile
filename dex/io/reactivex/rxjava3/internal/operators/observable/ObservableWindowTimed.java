package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public ObservableWindowTimed(Observable<T> source, long timespan, long timeskip, TimeUnit unit, Scheduler scheduler, long maxSize, int bufferSize, boolean restartTimerOnMaxSize) {
        super(source);
        this.timespan = timespan;
        this.timeskip = timeskip;
        this.unit = unit;
        this.scheduler = scheduler;
        this.maxSize = maxSize;
        this.bufferSize = bufferSize;
        this.restartTimerOnMaxSize = restartTimerOnMaxSize;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super Observable<T>> downstream) {
        if (this.timespan == this.timeskip) {
            if (this.maxSize == Long.MAX_VALUE) {
                this.source.subscribe(new WindowExactUnboundedObserver(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize));
                return;
            } else {
                this.source.subscribe(new WindowExactBoundedObserver(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
                return;
            }
        }
        this.source.subscribe(new WindowSkipObserver(downstream, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class AbstractWindowObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final Observer<? super Observable<T>> downstream;
        long emitted;
        Throwable error;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        volatile boolean upstreamCancelled;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final AtomicBoolean downstreamCancelled = new AtomicBoolean();
        final AtomicInteger windowCount = new AtomicInteger(1);

        abstract void cleanupResources();

        abstract void createFirstWindow();

        abstract void drain();

        AbstractWindowObserver(Observer<? super Observable<T>> downstream, long timespan, TimeUnit unit, int bufferSize) {
            this.downstream = downstream;
            this.timespan = timespan;
            this.unit = unit;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onError(Throwable t) {
            this.error = t;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final void dispose() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final boolean isDisposed() {
            return this.downstreamCancelled.get();
        }

        final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.dispose();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowExactUnboundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastSubject<T> window;
        final Runnable windowRunnable;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.scheduler = scheduler;
            this.timer = new SequentialDisposable();
            this.windowRunnable = new WindowRunnable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.windowCount.getAndIncrement();
                this.window = UnicastSubject.create(this.bufferSize, this.windowRunnable);
                this.emitted = 1L;
                ObservableWindowSubscribeIntercept<T> intercept = new ObservableWindowSubscribeIntercept<>(this.window);
                this.downstream.onNext(intercept);
                this.timer.replace(this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit));
                if (intercept.tryAbandon()) {
                    this.window.onComplete();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> queue = this.queue;
            Observer<? super Observable<T>> downstream = this.downstream;
            UnicastSubject<T> unicastSubject = this.window;
            int missed = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    queue.clear();
                    UnicastSubject<T> window = null;
                    unicastSubject = window;
                    this.window = null;
                } else {
                    boolean isDone = this.done;
                    Object o = queue.poll();
                    boolean isEmpty = o == null;
                    if (isDone && isEmpty) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            if (unicastSubject != null) {
                                UnicastSubject<T> window2 = unicastSubject;
                                window2.onError(ex);
                            }
                            downstream.onError(ex);
                        } else {
                            if (unicastSubject != null) {
                                UnicastSubject<T> window3 = unicastSubject;
                                window3.onComplete();
                            }
                            downstream.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!isEmpty) {
                        if (o == NEXT_WINDOW) {
                            if (unicastSubject != null) {
                                UnicastSubject<T> window4 = unicastSubject;
                                window4.onComplete();
                                UnicastSubject<T> window5 = null;
                                unicastSubject = window5;
                                this.window = null;
                            }
                            if (this.downstreamCancelled.get()) {
                                this.timer.dispose();
                            } else {
                                this.emitted++;
                                this.windowCount.getAndIncrement();
                                UnicastSubject<T> window6 = UnicastSubject.create(this.bufferSize, this.windowRunnable);
                                unicastSubject = window6;
                                this.window = unicastSubject;
                                ObservableWindowSubscribeIntercept<T> intercept = new ObservableWindowSubscribeIntercept<>(unicastSubject);
                                downstream.onNext(intercept);
                                if (intercept.tryAbandon()) {
                                    unicastSubject.onComplete();
                                }
                            }
                        } else if (unicastSubject != null) {
                            UnicastSubject<T> window7 = unicastSubject;
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

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void cleanupResources() {
            this.timer.dispose();
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class WindowRunnable implements Runnable {
            WindowRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactUnboundedObserver.this.windowDone();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowExactBoundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastSubject<T> window;
        final Scheduler.Worker worker;

        WindowExactBoundedObserver(Observer<? super Observable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize, long maxSize, boolean restartTimerOnMaxSize) {
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

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.emitted = 1L;
                this.windowCount.getAndIncrement();
                this.window = UnicastSubject.create(this.bufferSize, this);
                ObservableWindowSubscribeIntercept<T> intercept = new ObservableWindowSubscribeIntercept<>(this.window);
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
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            windowDone();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
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
        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            SimplePlainQueue<Object> queue = this.queue;
            Observer<? super Observable<T>> downstream = this.downstream;
            UnicastSubject<T> window = this.window;
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

        UnicastSubject<T> createNewWindow(UnicastSubject<T> window) {
            if (window != null) {
                window.onComplete();
                window = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long emitted = 1 + this.emitted;
                this.emitted = emitted;
                this.windowCount.getAndIncrement();
                window = UnicastSubject.create(this.bufferSize, this);
                this.window = window;
                ObservableWindowSubscribeIntercept<T> intercept = new ObservableWindowSubscribeIntercept<>(window);
                this.downstream.onNext(intercept);
                if (this.restartTimerOnMaxSize) {
                    this.timer.update(this.worker.schedulePeriodically(new WindowBoundaryRunnable(this, emitted), this.timespan, this.timespan, this.unit));
                }
                if (intercept.tryAbandon()) {
                    window.onComplete();
                }
            }
            return window;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class WindowBoundaryRunnable implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            WindowBoundaryRunnable(WindowExactBoundedObserver<?> parent, long index) {
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
    static final class WindowSkipObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<UnicastSubject<T>> windows;
        final Scheduler.Worker worker;
        static final Object WINDOW_OPEN = new Object();
        static final Object WINDOW_CLOSE = new Object();

        WindowSkipObserver(Observer<? super Observable<T>> actual, long timespan, long timeskip, TimeUnit unit, Scheduler.Worker worker, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.timeskip = timeskip;
            this.worker = worker;
            this.windows = new LinkedList();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.emitted = 1L;
                this.windowCount.getAndIncrement();
                UnicastSubject<T> window = UnicastSubject.create(this.bufferSize, this);
                this.windows.add(window);
                ObservableWindowSubscribeIntercept<T> intercept = new ObservableWindowSubscribeIntercept<>(window);
                this.downstream.onNext(intercept);
                this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                this.worker.schedulePeriodically(new WindowBoundaryRunnable(this, true), this.timeskip, this.timeskip, this.unit);
                if (intercept.tryAbandon()) {
                    window.onComplete();
                    this.windows.remove(window);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void cleanupResources() {
            this.worker.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void drain() {
            SimplePlainQueue<Object> queue;
            Observer<? super Observable<T>> downstream;
            SimplePlainQueue<Object> queue2;
            Observer<? super Observable<T>> downstream2;
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            SimplePlainQueue<Object> queue3 = this.queue;
            Observer<? super Observable<T>> downstream3 = this.downstream;
            List<UnicastSubject<T>> windows = this.windows;
            while (true) {
                if (this.upstreamCancelled) {
                    queue3.clear();
                    windows.clear();
                    queue = queue3;
                    downstream = downstream3;
                } else {
                    boolean isDone = this.done;
                    Object o = queue3.poll();
                    boolean isEmpty = o == null;
                    if (isDone && isEmpty) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            for (UnicastSubject<T> window : windows) {
                                window.onError(ex);
                            }
                            downstream3.onError(ex);
                        } else {
                            for (UnicastSubject<T> window2 : windows) {
                                window2.onComplete();
                            }
                            downstream3.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                        queue2 = queue3;
                        downstream2 = downstream3;
                    } else if (isEmpty) {
                        queue = queue3;
                        downstream = downstream3;
                    } else if (o == WINDOW_OPEN) {
                        if (this.downstreamCancelled.get()) {
                            queue2 = queue3;
                            downstream2 = downstream3;
                        } else {
                            long emitted = this.emitted;
                            this.emitted = 1 + emitted;
                            this.windowCount.getAndIncrement();
                            UnicastSubject<T> window3 = UnicastSubject.create(this.bufferSize, this);
                            windows.add(window3);
                            ObservableWindowSubscribeIntercept<T> intercept = new ObservableWindowSubscribeIntercept<>(window3);
                            downstream3.onNext(intercept);
                            queue2 = queue3;
                            downstream2 = downstream3;
                            this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                            if (intercept.tryAbandon()) {
                                window3.onComplete();
                            }
                        }
                    } else {
                        queue2 = queue3;
                        downstream2 = downstream3;
                        if (o == WINDOW_CLOSE) {
                            if (!windows.isEmpty()) {
                                windows.remove(0).onComplete();
                            }
                        } else {
                            for (UnicastSubject<T> window4 : windows) {
                                window4.onNext(o);
                            }
                        }
                    }
                    queue3 = queue2;
                    downstream3 = downstream2;
                }
                missed = addAndGet(-missed);
                if (missed != 0) {
                    queue3 = queue;
                    downstream3 = downstream;
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
            final WindowSkipObserver<?> parent;

            WindowBoundaryRunnable(WindowSkipObserver<?> parent, boolean isOpen) {
                this.parent = parent;
                this.isOpen = isOpen;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this.isOpen);
            }
        }
    }
}