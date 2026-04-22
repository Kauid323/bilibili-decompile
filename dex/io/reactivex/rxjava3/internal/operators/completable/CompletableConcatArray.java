package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends Completable {
    final CompletableSource[] sources;

    public CompletableConcatArray(CompletableSource[] sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver observer) {
        ConcatInnerObserver inner = new ConcatInnerObserver(observer, this.sources);
        observer.onSubscribe(inner.sd);
        inner.next();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver downstream;
        int index;
        final SequentialDisposable sd = new SequentialDisposable();
        final CompletableSource[] sources;

        ConcatInnerObserver(CompletableObserver actual, CompletableSource[] sources) {
            this.downstream = actual;
            this.sources = sources;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.sd.replace(d);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            next();
        }

        void next() {
            if (this.sd.isDisposed() || getAndIncrement() != 0) {
                return;
            }
            CompletableSource[] a = this.sources;
            while (!this.sd.isDisposed()) {
                int idx = this.index;
                this.index = idx + 1;
                if (idx == a.length) {
                    this.downstream.onComplete();
                    return;
                }
                a[idx].subscribe(this);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}