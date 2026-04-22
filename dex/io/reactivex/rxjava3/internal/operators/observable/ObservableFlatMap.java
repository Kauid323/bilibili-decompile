package io.reactivex.rxjava3.internal.operators.observable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    final int maxConcurrency;

    public ObservableFlatMap(ObservableSource<T> source, Function<? super T, ? extends ObservableSource<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        super(source);
        this.mapper = mapper;
        this.delayErrors = delayErrors;
        this.maxConcurrency = maxConcurrency;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> t) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, t, this.mapper)) {
            return;
        }
        this.source.subscribe(new MergeObserver(t, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        final boolean delayErrors;
        volatile boolean disposed;
        volatile boolean done;
        final Observer<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        int lastIndex;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile SimplePlainQueue<U> queue;
        Queue<ObservableSource<? extends U>> sources;
        long uniqueId;
        Disposable upstream;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        MergeObserver(Observer<? super U> actual, Function<? super T, ? extends ObservableSource<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
            this.downstream = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
            this.maxConcurrency = maxConcurrency;
            this.bufferSize = bufferSize;
            if (maxConcurrency != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(maxConcurrency);
            }
            this.observers = new AtomicReference<>(EMPTY);
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
            if (this.done) {
                return;
            }
            try {
                ObservableSource<? extends U> p = (ObservableSource) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.wip == this.maxConcurrency) {
                            this.sources.offer(p);
                            return;
                        }
                        this.wip++;
                    }
                }
                subscribeInner(p);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.upstream.dispose();
                onError(e);
            }
        }

        void subscribeInner(ObservableSource<? extends U> p) {
            while (p instanceof Supplier) {
                if (tryEmitScalar((Supplier) p) && this.maxConcurrency != Integer.MAX_VALUE) {
                    boolean empty = false;
                    synchronized (this) {
                        p = this.sources.poll();
                        if (p == null) {
                            this.wip--;
                            empty = true;
                        }
                    }
                    if (empty) {
                        drain();
                        return;
                    }
                } else {
                    return;
                }
            }
            long j2 = this.uniqueId;
            this.uniqueId = 1 + j2;
            InnerObserver<T, U> inner = new InnerObserver<>(this, j2);
            if (addInner(inner)) {
                p.subscribe(inner);
            }
        }

        boolean addInner(InnerObserver<T, U> inner) {
            InnerObserver<?, ?>[] a;
            InnerObserver[] innerObserverArr;
            do {
                a = this.observers.get();
                if (a == CANCELLED) {
                    inner.dispose();
                    return false;
                }
                int n = a.length;
                innerObserverArr = new InnerObserver[n + 1];
                System.arraycopy(a, 0, innerObserverArr, 0, n);
                innerObserverArr[n] = inner;
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, a, innerObserverArr));
            return true;
        }

        void removeInner(InnerObserver<T, U> inner) {
            InnerObserver<?, ?>[] a;
            InnerObserver<?, ?>[] b;
            do {
                a = this.observers.get();
                int n = a.length;
                int j2 = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (a[i] != inner) {
                        i++;
                    } else {
                        j2 = i;
                        break;
                    }
                }
                if (j2 < 0) {
                    return;
                }
                if (n == 1) {
                    b = EMPTY;
                } else {
                    InnerObserver<?, ?>[] b2 = new InnerObserver[n - 1];
                    System.arraycopy(a, 0, b2, 0, j2);
                    System.arraycopy(a, j2 + 1, b2, j2, (n - j2) - 1);
                    b = b2;
                }
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, a, b));
        }

        boolean tryEmitScalar(Supplier<? extends U> value) {
            try {
                U u = value.get();
                if (u == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(u);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    SimplePlainQueue<U> q = this.queue;
                    if (q == null) {
                        if (this.maxConcurrency == Integer.MAX_VALUE) {
                            q = new SpscLinkedArrayQueue(this.bufferSize);
                        } else {
                            q = new SpscArrayQueue<>(this.maxConcurrency);
                        }
                        this.queue = q;
                    }
                    q.offer(u);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.errors.tryAddThrowableOrReport(ex);
                drain();
                return true;
            }
        }

        void tryEmit(U value, InnerObserver<T, U> inner) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(value);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue<U> q = inner.queue;
                if (q == null) {
                    q = new SpscLinkedArrayQueue(this.bufferSize);
                    inner.queue = q;
                }
                q.offer(value);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
            } else if (this.errors.tryAddThrowableOrReport(t)) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            if (disposeAll()) {
                this.errors.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            int j2;
            Observer<? super U> child = this.downstream;
            int missed = 1;
            while (!checkTerminate()) {
                int innerCompleted = 0;
                SimplePlainQueue<U> svq = this.queue;
                if (svq == null) {
                    j2 = 0;
                } else {
                    while (!checkTerminate()) {
                        Object obj = (U) svq.poll();
                        if (obj == null) {
                            j2 = innerCompleted;
                        } else {
                            child.onNext(obj);
                            innerCompleted++;
                        }
                    }
                    return;
                }
                if (j2 != 0) {
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        subscribeMore(j2);
                    }
                } else {
                    boolean d = this.done;
                    SimplePlainQueue<U> svq2 = this.queue;
                    InnerObserver<?, ?>[] inner = this.observers.get();
                    int n = inner.length;
                    int nSources = 0;
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            nSources = this.sources.size();
                        }
                    }
                    if (d && ((svq2 == null || svq2.isEmpty()) && n == 0 && nSources == 0)) {
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    if (n != 0) {
                        int j3 = Math.min(n - 1, this.lastIndex);
                        int innerCompleted2 = j2;
                        int j4 = j3;
                        for (int i = 0; i < n; i++) {
                            if (checkTerminate()) {
                                return;
                            }
                            InnerObserver<T, U> is = inner[j4];
                            SimpleQueue<U> q = is.queue;
                            if (q != null) {
                                while (true) {
                                    try {
                                        Object obj2 = (U) q.poll();
                                        if (obj2 == null) {
                                            break;
                                        }
                                        child.onNext(obj2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                    } catch (Throwable ex) {
                                        Exceptions.throwIfFatal(ex);
                                        is.dispose();
                                        this.errors.tryAddThrowableOrReport(ex);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(is);
                                        innerCompleted2++;
                                        j4++;
                                        if (j4 == n) {
                                            j4 = 0;
                                        }
                                    }
                                }
                            }
                            boolean innerDone = is.done;
                            SimpleQueue<U> innerQueue = is.queue;
                            if (innerDone && (innerQueue == null || innerQueue.isEmpty())) {
                                removeInner(is);
                                innerCompleted2++;
                            }
                            j4++;
                            if (j4 == n) {
                                j4 = 0;
                            }
                        }
                        this.lastIndex = j4;
                        j2 = innerCompleted2;
                    }
                    if (j2 != 0) {
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            subscribeMore(j2);
                        }
                    } else {
                        int innerCompleted3 = -missed;
                        missed = addAndGet(innerCompleted3);
                        if (missed == 0) {
                            return;
                        }
                    }
                }
            }
        }

        void subscribeMore(int innerCompleted) {
            while (true) {
                int innerCompleted2 = innerCompleted - 1;
                if (innerCompleted != 0) {
                    synchronized (this) {
                        ObservableSource<? extends U> p = this.sources.poll();
                        if (p == null) {
                            this.wip--;
                        } else {
                            subscribeInner(p);
                        }
                    }
                    innerCompleted = innerCompleted2;
                } else {
                    return;
                }
            }
        }

        boolean checkTerminate() {
            if (this.disposed) {
                return true;
            }
            Throwable e = this.errors.get();
            if (!this.delayErrors && e != null) {
                disposeAll();
                this.errors.tryTerminateConsumer(this.downstream);
                return true;
            }
            return false;
        }

        boolean disposeAll() {
            this.upstream.dispose();
            InnerObserver<?, ?>[] a = this.observers.getAndSet(CANCELLED);
            if (a != CANCELLED) {
                for (InnerObserver<?, ?> inner : a) {
                    inner.dispose();
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final MergeObserver<T, U> parent;
        volatile SimpleQueue<U> queue;

        InnerObserver(MergeObserver<T, U> parent, long id) {
            this.id = id;
            this.parent = parent;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d) && (d instanceof QueueDisposable)) {
                QueueDisposable<U> qd = (QueueDisposable) d;
                int m = qd.requestFusion(7);
                if (m == 1) {
                    this.fusionMode = m;
                    this.queue = qd;
                    this.done = true;
                    this.parent.drain();
                } else if (m == 2) {
                    this.fusionMode = m;
                    this.queue = qd;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(U t) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(t, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.parent.errors.tryAddThrowableOrReport(t)) {
                if (!this.parent.delayErrors) {
                    this.parent.disposeAll();
                }
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}