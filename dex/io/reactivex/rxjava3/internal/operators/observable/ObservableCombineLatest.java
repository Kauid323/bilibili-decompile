package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public ObservableCombineLatest(ObservableSource<? extends T>[] sources, Iterable<? extends ObservableSource<? extends T>> sourcesIterable, Function<? super Object[], ? extends R> combiner, int bufferSize, boolean delayError) {
        this.sources = sources;
        this.sourcesIterable = sourcesIterable;
        this.combiner = combiner;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int count;
        ObservableSource<? extends T>[] sources = this.sources;
        int count2 = 0;
        if (sources == null) {
            sources = new ObservableSource[8];
            try {
                for (ObservableSource<? extends T> p : this.sourcesIterable) {
                    if (count2 == sources.length) {
                        ObservableSource<? extends T>[] b = new ObservableSource[(count2 >> 2) + count2];
                        System.arraycopy(sources, 0, b, 0, count2);
                        sources = b;
                    }
                    int count3 = count2 + 1;
                    try {
                        sources[count2] = (ObservableSource) Objects.requireNonNull(p, "The Iterator returned a null ObservableSource");
                        count2 = count3;
                    } catch (Throwable th) {
                        ex = th;
                        Exceptions.throwIfFatal(ex);
                        EmptyDisposable.error(ex, observer);
                        return;
                    }
                }
                count = count2;
            } catch (Throwable th2) {
                ex = th2;
            }
        } else {
            int count4 = sources.length;
            count = count4;
        }
        if (count == 0) {
            EmptyDisposable.complete(observer);
            return;
        }
        LatestCoordinator<T, R> lc = new LatestCoordinator<>(observer, this.combiner, count, this.bufferSize, this.delayError);
        lc.subscribe(sources);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final SpscLinkedArrayQueue<Object[]> queue;

        LatestCoordinator(Observer<? super R> actual, Function<? super Object[], ? extends R> combiner, int count, int bufferSize, boolean delayError) {
            this.downstream = actual;
            this.combiner = combiner;
            this.delayError = delayError;
            this.latest = new Object[count];
            CombinerObserver<T, R>[] as = new CombinerObserver[count];
            for (int i = 0; i < count; i++) {
                as[i] = new CombinerObserver<>(this, i);
            }
            this.observers = as;
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
        }

        public void subscribe(ObservableSource<? extends T>[] sources) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int len = combinerObserverArr.length;
            this.downstream.onSubscribe(this);
            for (int i = 0; i < len && !this.done && !this.cancelled; i++) {
                sources[i].subscribe(combinerObserverArr[i]);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelSources() {
            CombinerObserver<T, R>[] combinerObserverArr;
            for (CombinerObserver<T, R> observer : this.observers) {
                observer.dispose();
            }
        }

        void clear(SpscLinkedArrayQueue<?> q) {
            synchronized (this) {
                this.latest = null;
            }
            q.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object[]> q = this.queue;
            Observer<? super R> a = this.downstream;
            boolean delayError = this.delayError;
            int missed = 1;
            while (!this.cancelled) {
                if (!delayError && this.errors.get() != null) {
                    cancelSources();
                    clear(q);
                    this.errors.tryTerminateConsumer(a);
                    return;
                }
                boolean d = this.done;
                Object[] s = q.poll();
                boolean empty = s == null;
                if (d && empty) {
                    clear(q);
                    this.errors.tryTerminateConsumer(a);
                    return;
                } else if (!empty) {
                    try {
                        a.onNext((Object) Objects.requireNonNull(this.combiner.apply(s), "The combiner returned a null value"));
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        this.errors.tryAddThrowableOrReport(ex);
                        cancelSources();
                        clear(q);
                        this.errors.tryTerminateConsumer(a);
                        return;
                    }
                } else {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            clear(q);
            this.errors.tryTerminateAndReport();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void innerNext(int index, T item) {
            boolean shouldDrain = false;
            synchronized (this) {
                Object[] latest = this.latest;
                if (latest == null) {
                    return;
                }
                Object o = latest[index];
                int a = this.active;
                if (o == null) {
                    a++;
                    this.active = a;
                }
                latest[index] = item;
                if (a == latest.length) {
                    this.queue.offer(latest.clone());
                    shouldDrain = true;
                }
                if (shouldDrain) {
                    drain();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r2 == r1.length) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerError(int index, Throwable ex) {
            if (this.errors.tryAddThrowableOrReport(ex)) {
                boolean cancelOthers = true;
                if (this.delayError) {
                    synchronized (this) {
                        Object[] latest = this.latest;
                        if (latest == null) {
                            return;
                        }
                        cancelOthers = latest[index] == null;
                        if (!cancelOthers) {
                            int i = this.complete + 1;
                            this.complete = i;
                        }
                        this.done = true;
                    }
                }
                if (cancelOthers) {
                    cancelSources();
                }
                drain();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:
            if (r2 == r1.length) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerComplete(int index) {
            synchronized (this) {
                Object[] latest = this.latest;
                if (latest == null) {
                    return;
                }
                boolean cancelOthers = latest[index] == null;
                if (!cancelOthers) {
                    int i = this.complete + 1;
                    this.complete = i;
                }
                this.done = true;
                if (cancelOthers) {
                    cancelSources();
                }
                drain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        CombinerObserver(LatestCoordinator<T, R> parent, int index) {
            this.parent = parent;
            this.index = index;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this, d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.parent.innerError(this.index, t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}