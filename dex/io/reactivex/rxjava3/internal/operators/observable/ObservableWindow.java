package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final long count;
    final long skip;

    public ObservableWindow(ObservableSource<T> source, long count, long skip, int capacityHint) {
        super(source);
        this.count = count;
        this.skip = skip;
        this.capacityHint = capacityHint;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> t) {
        if (this.count == this.skip) {
            this.source.subscribe(new WindowExactObserver(t, this.count, this.capacityHint));
        } else {
            this.source.subscribe(new WindowSkipObserver(t, this.count, this.skip, this.capacityHint));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final Observer<? super Observable<T>> downstream;
        long size;
        Disposable upstream;
        UnicastSubject<T> window;

        WindowExactObserver(Observer<? super Observable<T>> actual, long count, int capacityHint) {
            this.downstream = actual;
            this.count = count;
            this.capacityHint = capacityHint;
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
            UnicastSubject<T> w = this.window;
            ObservableWindowSubscribeIntercept<T> intercept = null;
            if (w == null && !this.cancelled) {
                w = UnicastSubject.create(this.capacityHint, this);
                this.window = w;
                intercept = new ObservableWindowSubscribeIntercept<>(w);
                this.downstream.onNext(intercept);
            }
            if (w != null) {
                w.onNext(t);
                long j2 = this.size + 1;
                this.size = j2;
                if (j2 >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    w.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
                if (intercept != null && intercept.tryAbandon()) {
                    w.onComplete();
                    this.window = null;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            UnicastSubject<T> w = this.window;
            if (w != null) {
                this.window = null;
                w.onError(t);
            }
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            UnicastSubject<T> w = this.window;
            if (w != null) {
                this.window = null;
                w.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final Observer<? super Observable<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        Disposable upstream;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

        WindowSkipObserver(Observer<? super Observable<T>> actual, long count, long skip, int capacityHint) {
            this.downstream = actual;
            this.count = count;
            this.skip = skip;
            this.capacityHint = capacityHint;
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
            ArrayDeque<UnicastSubject<T>> ws = this.windows;
            long i = this.index;
            long s = this.skip;
            ObservableWindowSubscribeIntercept<T> intercept = null;
            if (i % s == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject<T> w = UnicastSubject.create(this.capacityHint, this);
                intercept = new ObservableWindowSubscribeIntercept<>(w);
                ws.offer(w);
                this.downstream.onNext(intercept);
            }
            long c = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> it = ws.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (c >= this.count) {
                ws.poll().onComplete();
                if (ws.isEmpty() && this.cancelled) {
                    this.upstream.dispose();
                    return;
                }
                this.firstEmission = c - s;
            } else {
                this.firstEmission = c;
            }
            this.index = 1 + i;
            if (intercept != null && intercept.tryAbandon()) {
                intercept.window.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            ArrayDeque<UnicastSubject<T>> ws = this.windows;
            while (!ws.isEmpty()) {
                ws.poll().onError(t);
            }
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> ws = this.windows;
            while (!ws.isEmpty()) {
                ws.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }
}