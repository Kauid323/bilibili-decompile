package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends ObservableSource<V>> closingIndicator;
    final ObservableSource<B> open;

    public ObservableWindowBoundarySelector(ObservableSource<T> source, ObservableSource<B> open, Function<? super B, ? extends ObservableSource<V>> closingIndicator, int bufferSize) {
        super(source);
        this.open = open;
        this.closingIndicator = closingIndicator;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> t) {
        this.source.subscribe(new WindowBoundaryMainObserver(t, this.open, this.closingIndicator, this.bufferSize));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;
        final int bufferSize;
        final Function<? super B, ? extends ObservableSource<V>> closingIndicator;
        final Observer<? super Observable<T>> downstream;
        long emitted;
        final ObservableSource<B> open;
        volatile boolean openDone;
        Disposable upstream;
        volatile boolean upstreamCanceled;
        volatile boolean upstreamDone;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final CompositeDisposable resources = new CompositeDisposable();
        final List<UnicastSubject<T>> windows = new ArrayList();
        final AtomicLong windowCount = new AtomicLong(1);
        final AtomicBoolean downstreamDisposed = new AtomicBoolean();
        final AtomicThrowable error = new AtomicThrowable();
        final WindowStartObserver<B> startObserver = new WindowStartObserver<>(this);
        final AtomicLong requested = new AtomicLong();

        WindowBoundaryMainObserver(Observer<? super Observable<T>> downstream, ObservableSource<B> open, Function<? super B, ? extends ObservableSource<V>> closingIndicator, int bufferSize) {
            this.downstream = downstream;
            this.open = open;
            this.closingIndicator = closingIndicator;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
                this.open.subscribe(this.startObserver);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.startObserver.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(t)) {
                this.upstreamDone = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.startObserver.dispose();
            this.resources.dispose();
            this.upstreamDone = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.downstreamDisposed.compareAndSet(false, true)) {
                if (this.windowCount.decrementAndGet() == 0) {
                    this.upstream.dispose();
                    this.startObserver.dispose();
                    this.resources.dispose();
                    this.error.tryTerminateAndReport();
                    this.upstreamCanceled = true;
                    drain();
                    return;
                }
                this.startObserver.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.downstreamDisposed.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.dispose();
                this.startObserver.dispose();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
            }
        }

        void open(B startValue) {
            this.queue.offer(new WindowStartItem(startValue));
            drain();
        }

        void openError(Throwable t) {
            this.upstream.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(t)) {
                this.upstreamDone = true;
                drain();
            }
        }

        void openComplete() {
            this.openDone = true;
            drain();
        }

        void close(WindowEndObserverIntercept<T, V> what) {
            this.queue.offer(what);
            drain();
        }

        void closeError(Throwable t) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(t)) {
                this.upstreamDone = true;
                drain();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Observer<? super Observable<T>> downstream = this.downstream;
            SimplePlainQueue<Object> queue = this.queue;
            List<UnicastSubject<T>> windows = this.windows;
            while (true) {
                if (this.upstreamCanceled) {
                    queue.clear();
                    windows.clear();
                } else {
                    boolean isDone = this.upstreamDone;
                    Object o = queue.poll();
                    boolean isEmpty = o == null;
                    if (isDone && (isEmpty || this.error.get() != null)) {
                        terminateDownstream(downstream);
                        this.upstreamCanceled = true;
                    } else if (!isEmpty) {
                        if (o instanceof WindowStartItem) {
                            if (!this.downstreamDisposed.get()) {
                                B startItem = ((WindowStartItem) o).item;
                                try {
                                    ObservableSource<V> endSource = (ObservableSource) Objects.requireNonNull(this.closingIndicator.apply(startItem), "The closingIndicator returned a null ObservableSource");
                                    this.windowCount.getAndIncrement();
                                    UnicastSubject<T> newWindow = UnicastSubject.create(this.bufferSize, this);
                                    WindowEndObserverIntercept<T, V> endObserver = new WindowEndObserverIntercept<>(this, newWindow);
                                    downstream.onNext(endObserver);
                                    if (endObserver.tryAbandon()) {
                                        newWindow.onComplete();
                                    } else {
                                        windows.add(newWindow);
                                        this.resources.add(endObserver);
                                        endSource.subscribe(endObserver);
                                    }
                                } catch (Throwable ex) {
                                    Exceptions.throwIfFatal(ex);
                                    this.upstream.dispose();
                                    this.startObserver.dispose();
                                    this.resources.dispose();
                                    Exceptions.throwIfFatal(ex);
                                    this.error.tryAddThrowableOrReport(ex);
                                    this.upstreamDone = true;
                                }
                            }
                        } else if (o instanceof WindowEndObserverIntercept) {
                            UnicastSubject<T> w = ((WindowEndObserverIntercept) o).window;
                            windows.remove(w);
                            this.resources.delete((Disposable) o);
                            w.onComplete();
                        } else {
                            for (UnicastSubject<T> w2 : windows) {
                                w2.onNext(o);
                            }
                        }
                    } else if (this.openDone && windows.size() == 0) {
                        this.upstream.dispose();
                        this.startObserver.dispose();
                        this.resources.dispose();
                        terminateDownstream(downstream);
                        this.upstreamCanceled = true;
                    }
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }

        void terminateDownstream(Observer<?> downstream) {
            Throwable ex = this.error.terminate();
            if (ex == null) {
                for (UnicastSubject<T> w : this.windows) {
                    w.onComplete();
                }
                downstream.onComplete();
            } else if (ex != ExceptionHelper.TERMINATED) {
                for (UnicastSubject<T> w2 : this.windows) {
                    w2.onError(ex);
                }
                downstream.onError(ex);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class WindowStartItem<B> {
            final B item;

            WindowStartItem(B item) {
                this.item = item;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class WindowStartObserver<B> extends AtomicReference<Disposable> implements Observer<B> {
            private static final long serialVersionUID = -3326496781427702834L;
            final WindowBoundaryMainObserver<?, B, ?> parent;

            WindowStartObserver(WindowBoundaryMainObserver<?, B, ?> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(B t) {
                this.parent.open(t);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable t) {
                this.parent.openError(t);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                this.parent.openComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class WindowEndObserverIntercept<T, V> extends Observable<T> implements Observer<V>, Disposable {
            final WindowBoundaryMainObserver<T, ?, V> parent;
            final UnicastSubject<T> window;
            final AtomicReference<Disposable> upstream = new AtomicReference<>();
            final AtomicBoolean once = new AtomicBoolean();

            WindowEndObserverIntercept(WindowBoundaryMainObserver<T, ?, V> parent, UnicastSubject<T> window) {
                this.parent = parent;
                this.window = window;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this.upstream, d);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(V t) {
                if (DisposableHelper.dispose(this.upstream)) {
                    this.parent.close(this);
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable t) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(t);
                } else {
                    this.parent.closeError(t);
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                this.parent.close(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this.upstream);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return this.upstream.get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.rxjava3.core.Observable
            protected void subscribeActual(Observer<? super T> o) {
                this.window.subscribe(o);
                this.once.set(true);
            }

            boolean tryAbandon() {
                return !this.once.get() && this.once.compareAndSet(false, true);
            }
        }
    }
}