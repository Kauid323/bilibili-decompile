package io.reactivex.rxjava3.internal.operators.observable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    public ObservableFlatMapSingle(ObservableSource<T> source, Function<? super T, ? extends SingleSource<? extends R>> mapper, boolean delayError) {
        super(source);
        this.mapper = mapper;
        this.delayErrors = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlatMapSingleObserver(observer, this.mapper, this.delayErrors));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        Disposable upstream;
        final CompositeDisposable set = new CompositeDisposable();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<SpscLinkedArrayQueue<R>> queue = new AtomicReference<>();

        FlatMapSingleObserver(Observer<? super R> actual, Function<? super T, ? extends SingleSource<? extends R>> mapper, boolean delayErrors) {
            this.downstream = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            try {
                SingleSource<? extends R> ms = (SingleSource) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                FlatMapSingleObserver<T, R>.InnerObserver inner = new InnerObserver();
                if (!this.cancelled && this.set.add(inner)) {
                    ms.subscribe(inner);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.dispose();
                onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.active.decrementAndGet();
            if (this.errors.tryAddThrowableOrReport(t)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
            this.errors.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerSuccess(FlatMapSingleObserver<T, R>.InnerObserver inner, R value) {
            this.set.delete(inner);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.downstream.onNext(value);
                    boolean d = this.active.decrementAndGet() == 0;
                    SpscLinkedArrayQueue<R> q = this.queue.get();
                    if (d && (q == null || q.isEmpty())) {
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
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
            SpscLinkedArrayQueue<R> current2 = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            return MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.queue, (Object) null, current2) ? current2 : this.queue.get();
        }

        void innerError(FlatMapSingleObserver<T, R>.InnerObserver inner, Throwable e) {
            this.set.delete(inner);
            if (this.errors.tryAddThrowableOrReport(e)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                drain();
            }
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
            int missed = 1;
            Observer<? super R> a = this.downstream;
            AtomicInteger n = this.active;
            AtomicReference<SpscLinkedArrayQueue<R>> qr = this.queue;
            while (!this.cancelled) {
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
                R poll = q != null ? q.poll() : (Object) null;
                boolean empty = poll == null;
                if (d && empty) {
                    this.errors.tryTerminateConsumer(this.downstream);
                    return;
                } else if (!empty) {
                    a.onNext(poll);
                } else {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            clear();
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R value) {
                FlatMapSingleObserver.this.innerSuccess(this, value);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                FlatMapSingleObserver.this.innerError(this, e);
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