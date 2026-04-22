package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import j$.util.Objects;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatIterable extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public CompletableConcatIterable(Iterable<? extends CompletableSource> sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver observer) {
        try {
            Iterator<? extends CompletableSource> it = (Iterator) Objects.requireNonNull(this.sources.iterator(), "The iterator returned is null");
            ConcatInnerObserver inner = new ConcatInnerObserver(observer, it);
            observer.onSubscribe(inner.sd);
            inner.next();
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            EmptyDisposable.error(e, observer);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver downstream;
        final SequentialDisposable sd = new SequentialDisposable();
        final Iterator<? extends CompletableSource> sources;

        ConcatInnerObserver(CompletableObserver actual, Iterator<? extends CompletableSource> sources) {
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
            Iterator<? extends CompletableSource> a = this.sources;
            while (!this.sd.isDisposed()) {
                try {
                    boolean b = a.hasNext();
                    if (!b) {
                        this.downstream.onComplete();
                        return;
                    }
                    try {
                        CompletableSource c = (CompletableSource) Objects.requireNonNull(a.next(), "The CompletableSource returned is null");
                        c.subscribe(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        this.downstream.onError(ex);
                        return;
                    }
                } catch (Throwable ex2) {
                    Exceptions.throwIfFatal(ex2);
                    this.downstream.onError(ex2);
                    return;
                }
            }
        }
    }
}