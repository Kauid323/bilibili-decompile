package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T> extends Observable<T> {
    final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        CreateEmitter<T> parent = new CreateEmitter<>(observer);
        observer.onSubscribe(parent);
        try {
            this.source.subscribe(parent);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            parent.onError(ex);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;
        final Observer<? super T> observer;

        CreateEmitter(Observer<? super T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else if (!isDisposed()) {
                this.observer.onNext(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable t) {
            if (!tryOnError(t)) {
                RxJavaPlugins.onError(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public boolean tryOnError(Throwable t) {
            if (t == null) {
                t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (!isDisposed()) {
                try {
                    this.observer.onError(t);
                    dispose();
                    return true;
                } catch (Throwable th) {
                    dispose();
                    throw th;
                }
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.observer.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public void setDisposable(Disposable d) {
            DisposableHelper.set(this, d);
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public void setCancellable(Cancellable c) {
            setDisposable(new CancellableDisposable(c));
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter, io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SerializedEmitter<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final ObservableEmitter<T> emitter;
        final AtomicThrowable errors = new AtomicThrowable();
        final SpscLinkedArrayQueue<T> queue = new SpscLinkedArrayQueue<>(16);

        SerializedEmitter(ObservableEmitter<T> emitter) {
            this.emitter = emitter;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (this.done || this.emitter.isDisposed()) {
                return;
            }
            if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue<T> q = this.queue;
                synchronized (q) {
                    q.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable t) {
            if (!tryOnError(t)) {
                RxJavaPlugins.onError(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public boolean tryOnError(Throwable t) {
            if (this.done || this.emitter.isDisposed()) {
                return false;
            }
            if (t == null) {
                t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (this.errors.tryAddThrowable(t)) {
                this.done = true;
                drain();
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (this.done || this.emitter.isDisposed()) {
                return;
            }
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            ObservableEmitter<T> e = this.emitter;
            SpscLinkedArrayQueue<T> q = this.queue;
            AtomicThrowable errors = this.errors;
            int missed = 1;
            while (!e.isDisposed()) {
                if (errors.get() != null) {
                    q.clear();
                    errors.tryTerminateConsumer(e);
                    return;
                }
                boolean d = this.done;
                T v = q.poll();
                boolean empty = v == null;
                if (d && empty) {
                    e.onComplete();
                    return;
                } else if (!empty) {
                    e.onNext(v);
                } else {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            q.clear();
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public void setDisposable(Disposable d) {
            this.emitter.setDisposable(d);
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public void setCancellable(Cancellable c) {
            this.emitter.setCancellable(c);
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter, io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return this;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }
    }
}