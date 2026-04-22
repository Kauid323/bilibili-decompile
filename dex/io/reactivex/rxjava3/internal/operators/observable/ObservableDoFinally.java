package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    final Action onFinally;

    public ObservableDoFinally(ObservableSource<T> source, Action onFinally) {
        super(source);
        this.onFinally = onFinally;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DoFinallyObserver(observer, this.onFinally));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Observer<? super T> downstream;
        final Action onFinally;
        QueueDisposable<T> qd;
        boolean syncFused;
        Disposable upstream;

        DoFinallyObserver(Observer<? super T> actual, Action onFinally) {
            this.downstream = actual;
            this.onFinally = onFinally;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                if (d instanceof QueueDisposable) {
                    this.qd = (QueueDisposable) d;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.downstream.onError(t);
            runFinally();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            QueueDisposable<T> qd = this.qd;
            boolean z = false;
            if (qd == null || (mode & 4) != 0) {
                return 0;
            }
            int m = qd.requestFusion(mode);
            if (m != 0) {
                if (m == 1) {
                    z = true;
                }
                this.syncFused = z;
            }
            return m;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.qd.clear();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            T v = this.qd.poll();
            if (v == null && this.syncFused) {
                runFinally();
            }
            return v;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    RxJavaPlugins.onError(ex);
                }
            }
        }
    }
}