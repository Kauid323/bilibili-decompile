package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable<T> extends Completable {
    final ErrorMode errorMode;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    final Observable<T> source;

    public ObservableConcatMapCompletable(Observable<T> source, Function<? super T, ? extends CompletableSource> mapper, ErrorMode errorMode, int prefetch) {
        this.source = source;
        this.mapper = mapper;
        this.errorMode = errorMode;
        this.prefetch = prefetch;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        if (!ScalarXMapZHelper.tryAsCompletable(this.source, this.mapper, observer)) {
            this.source.subscribe(new ConcatMapCompletableObserver(observer, this.mapper, this.errorMode, this.prefetch));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final CompletableObserver downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        final Function<? super T, ? extends CompletableSource> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        Disposable upstream;

        ConcatMapCompletableObserver(CompletableObserver downstream, Function<? super T, ? extends CompletableSource> mapper, ErrorMode errorMode, int prefetch) {
            this.downstream = downstream;
            this.mapper = mapper;
            this.errorMode = errorMode;
            this.prefetch = prefetch;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                if (d instanceof QueueDisposable) {
                    QueueDisposable<T> qd = (QueueDisposable) d;
                    int m = qd.requestFusion(3);
                    if (m == 1) {
                        this.queue = qd;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (m == 2) {
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
        public void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.disposed = true;
                    this.inner.dispose();
                    this.errors.tryTerminateConsumer(this.downstream);
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                        return;
                    }
                    return;
                }
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
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            this.errors.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        void innerError(Throwable ex) {
            if (this.errors.tryAddThrowableOrReport(ex)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.disposed = true;
                    this.upstream.dispose();
                    this.errors.tryTerminateConsumer(this.downstream);
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                        return;
                    }
                    return;
                }
                this.active = false;
                drain();
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable errors = this.errors;
            ErrorMode errorMode = this.errorMode;
            while (!this.disposed) {
                if (!this.active) {
                    if (errorMode == ErrorMode.BOUNDARY && errors.get() != null) {
                        this.disposed = true;
                        this.queue.clear();
                        errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    boolean d = this.done;
                    boolean empty = true;
                    CompletableSource cs = null;
                    try {
                        T v = this.queue.poll();
                        if (v != null) {
                            cs = (CompletableSource) Objects.requireNonNull(this.mapper.apply(v), "The mapper returned a null CompletableSource");
                            empty = false;
                        }
                        if (d && empty) {
                            this.disposed = true;
                            errors.tryTerminateConsumer(this.downstream);
                            return;
                        } else if (!empty) {
                            this.active = true;
                            cs.subscribe(this.inner);
                        }
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        this.disposed = true;
                        this.queue.clear();
                        this.upstream.dispose();
                        errors.tryAddThrowableOrReport(ex);
                        errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.replace(this, d);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                this.parent.innerError(e);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}