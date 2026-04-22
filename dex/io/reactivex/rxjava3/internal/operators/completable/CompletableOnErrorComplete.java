package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;

public final class CompletableOnErrorComplete extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    public CompletableOnErrorComplete(CompletableSource source, Predicate<? super Throwable> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(final CompletableObserver observer) {
        this.source.subscribe(new OnError(observer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class OnError implements CompletableObserver {
        private final CompletableObserver downstream;

        OnError(CompletableObserver observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            try {
                boolean b = CompletableOnErrorComplete.this.predicate.test(e);
                if (b) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(e);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(new CompositeException(e, ex));
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.downstream.onSubscribe(d);
        }
    }
}