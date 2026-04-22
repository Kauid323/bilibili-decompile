package io.reactivex.rxjava3.subjects;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicReference<Observer<? super T>> downstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();
    final BasicIntQueueDisposable<T> wip = new UnicastQueueDisposable();

    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(bufferSize(), null, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int capacityHint) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new UnicastSubject<>(capacityHint, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int capacityHint, Runnable onTerminate) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        Objects.requireNonNull(onTerminate, "onTerminate");
        return new UnicastSubject<>(capacityHint, onTerminate, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int capacityHint, Runnable onTerminate, boolean delayError) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        Objects.requireNonNull(onTerminate, "onTerminate");
        return new UnicastSubject<>(capacityHint, onTerminate, delayError);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(boolean delayError) {
        return new UnicastSubject<>(bufferSize(), null, delayError);
    }

    UnicastSubject(int capacityHint, Runnable onTerminate, boolean delayError) {
        this.queue = new SpscLinkedArrayQueue<>(capacityHint);
        this.onTerminate = new AtomicReference<>(onTerminate);
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            observer.onSubscribe(this.wip);
            this.downstream.lazySet(observer);
            if (this.disposed) {
                this.downstream.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }

    void doTerminate() {
        Runnable r = this.onTerminate.get();
        if (r != null && MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.onTerminate, r, (Object) null)) {
            r.run();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable d) {
        if (this.done || this.disposed) {
            d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.done || this.disposed) {
            return;
        }
        this.queue.offer(t);
        drain();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.done || this.disposed) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.error = t;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.done || this.disposed) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    void drainNormal(Observer<? super T> a) {
        int missed = 1;
        SimpleQueue<T> q = this.queue;
        boolean failFast = !this.delayError;
        boolean canBeError = true;
        while (!this.disposed) {
            boolean d = this.done;
            Object obj = (T) this.queue.poll();
            boolean empty = obj == null;
            if (d) {
                if (failFast && canBeError) {
                    if (failedFast(q, a)) {
                        return;
                    }
                    canBeError = false;
                }
                if (empty) {
                    errorOrComplete(a);
                    return;
                }
            }
            if (!empty) {
                a.onNext(obj);
            } else {
                missed = this.wip.addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }
        this.downstream.lazySet(null);
        q.clear();
    }

    void drainFused(Observer<? super T> a) {
        int missed = 1;
        SpscLinkedArrayQueue<T> q = this.queue;
        boolean failFast = !this.delayError;
        while (!this.disposed) {
            boolean d = this.done;
            if (failFast && d && failedFast(q, a)) {
                return;
            }
            a.onNext(null);
            if (d) {
                errorOrComplete(a);
                return;
            }
            missed = this.wip.addAndGet(-missed);
            if (missed == 0) {
                return;
            }
        }
        this.downstream.lazySet(null);
    }

    void errorOrComplete(Observer<? super T> a) {
        this.downstream.lazySet(null);
        Throwable ex = this.error;
        if (ex != null) {
            a.onError(ex);
        } else {
            a.onComplete();
        }
    }

    boolean failedFast(final SimpleQueue<T> q, Observer<? super T> a) {
        Throwable ex = this.error;
        if (ex != null) {
            this.downstream.lazySet(null);
            q.clear();
            a.onError(ex);
            return true;
        }
        return false;
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> a = this.downstream.get();
        int missed = 1;
        while (a == null) {
            missed = this.wip.addAndGet(-missed);
            if (missed != 0) {
                Observer<? super T> a2 = this.downstream.get();
                a = a2;
            } else {
                return;
            }
        }
        if (this.enableOperatorFusion) {
            drainFused(a);
        } else {
            drainNormal(a);
        }
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        return this.downstream.get() != null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 2) != 0) {
                UnicastSubject.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            return UnicastSubject.this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.queue.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!UnicastSubject.this.disposed) {
                UnicastSubject.this.disposed = true;
                UnicastSubject.this.doTerminate();
                UnicastSubject.this.downstream.lazySet(null);
                if (UnicastSubject.this.wip.getAndIncrement() == 0) {
                    UnicastSubject.this.downstream.lazySet(null);
                    if (!UnicastSubject.this.enableOperatorFusion) {
                        UnicastSubject.this.queue.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.disposed;
        }
    }
}