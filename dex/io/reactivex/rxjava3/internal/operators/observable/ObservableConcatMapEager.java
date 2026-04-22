package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserver;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j$.util.Objects;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    public ObservableConcatMapEager(ObservableSource<T> source, Function<? super T, ? extends ObservableSource<? extends R>> mapper, ErrorMode errorMode, int maxConcurrency, int prefetch) {
        super(source);
        this.mapper = mapper;
        this.errorMode = errorMode;
        this.maxConcurrency = maxConcurrency;
        this.prefetch = prefetch;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new ConcatMapEagerMainObserver(observer, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;
        volatile boolean done;
        final Observer<? super R> downstream;
        final ErrorMode errorMode;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        SimpleQueue<T> queue;
        int sourceMode;
        Disposable upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        ConcatMapEagerMainObserver(Observer<? super R> actual, Function<? super T, ? extends ObservableSource<? extends R>> mapper, int maxConcurrency, int prefetch, ErrorMode errorMode) {
            this.downstream = actual;
            this.mapper = mapper;
            this.maxConcurrency = maxConcurrency;
            this.prefetch = prefetch;
            this.errorMode = errorMode;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                if (d instanceof QueueDisposable) {
                    QueueDisposable<T> qd = (QueueDisposable) d;
                    int m = qd.requestFusion(3);
                    if (m == 1) {
                        this.sourceMode = m;
                        this.queue = qd;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (m == 2) {
                        this.sourceMode = m;
                        this.queue = qd;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T value) {
            if (this.sourceMode == 0) {
                this.queue.offer(value);
            }
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            this.errors.tryTerminateAndReport();
            drainAndDispose();
        }

        void drainAndDispose() {
            if (getAndIncrement() == 0) {
                do {
                    this.queue.clear();
                    disposeAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void disposeAll() {
            InnerQueuedObserver<R> inner = this.current;
            if (inner != null) {
                inner.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> inner2 = this.observers.poll();
                if (inner2 == null) {
                    return;
                }
                inner2.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
        public void innerNext(InnerQueuedObserver<R> inner, R value) {
            inner.queue().offer(value);
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
        public void innerError(InnerQueuedObserver<R> inner, Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.upstream.dispose();
                }
                inner.setDone();
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
        public void innerComplete(InnerQueuedObserver<R> inner) {
            inner.setDone();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
        public void drain() {
            R w;
            boolean empty;
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            SimpleQueue<T> q = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> observers = this.observers;
            Observer<? super R> a = this.downstream;
            ErrorMode errorMode = this.errorMode;
            while (true) {
                int ac = this.activeCount;
                while (ac != this.maxConcurrency) {
                    if (this.cancelled) {
                        q.clear();
                        disposeAll();
                        return;
                    } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                        q.clear();
                        disposeAll();
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    } else {
                        try {
                            T v = q.poll();
                            if (v == null) {
                                break;
                            }
                            ObservableSource<? extends R> source = (ObservableSource) Objects.requireNonNull(this.mapper.apply(v), "The mapper returned a null ObservableSource");
                            InnerQueuedObserver<R> inner = new InnerQueuedObserver<>(this, this.prefetch);
                            observers.offer(inner);
                            source.subscribe(inner);
                            ac++;
                        } catch (Throwable ex) {
                            Exceptions.throwIfFatal(ex);
                            this.upstream.dispose();
                            q.clear();
                            disposeAll();
                            this.errors.tryAddThrowableOrReport(ex);
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                    }
                }
                this.activeCount = ac;
                if (this.cancelled) {
                    q.clear();
                    disposeAll();
                    return;
                } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                    q.clear();
                    disposeAll();
                    this.errors.tryTerminateConsumer(this.downstream);
                    return;
                } else {
                    InnerQueuedObserver<R> active = this.current;
                    if (active == null) {
                        if (errorMode == ErrorMode.BOUNDARY && this.errors.get() != null) {
                            q.clear();
                            disposeAll();
                            this.errors.tryTerminateConsumer(a);
                            return;
                        }
                        boolean d = this.done;
                        active = observers.poll();
                        boolean empty2 = active == null;
                        if (d && empty2) {
                            if (this.errors.get() != null) {
                                q.clear();
                                disposeAll();
                                this.errors.tryTerminateConsumer(a);
                                return;
                            }
                            a.onComplete();
                            return;
                        } else if (!empty2) {
                            this.current = active;
                        }
                    }
                    if (active != null) {
                        SimpleQueue<R> aq = active.queue();
                        while (!this.cancelled) {
                            boolean d2 = active.isDone();
                            if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                                q.clear();
                                disposeAll();
                                this.errors.tryTerminateConsumer(a);
                                return;
                            }
                            try {
                                w = aq.poll();
                                empty = w == null;
                            } catch (Throwable ex2) {
                                Exceptions.throwIfFatal(ex2);
                                this.errors.tryAddThrowableOrReport(ex2);
                                this.current = null;
                                this.activeCount--;
                            }
                            if (d2 && empty) {
                                this.current = null;
                                this.activeCount--;
                            } else if (!empty) {
                                a.onNext(w);
                            }
                        }
                        q.clear();
                        disposeAll();
                        return;
                    }
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }
}