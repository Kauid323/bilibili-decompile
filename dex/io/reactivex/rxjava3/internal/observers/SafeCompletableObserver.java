package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeCompletableObserver implements CompletableObserver {
    final CompletableObserver downstream;
    boolean onSubscribeFailed;

    public SafeCompletableObserver(CompletableObserver downstream) {
        this.downstream = downstream;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable d) {
        try {
            this.downstream.onSubscribe(d);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            this.onSubscribeFailed = true;
            d.dispose();
            RxJavaPlugins.onError(ex);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable e) {
        if (this.onSubscribeFailed) {
            RxJavaPlugins.onError(e);
            return;
        }
        try {
            this.downstream.onError(e);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            RxJavaPlugins.onError(new CompositeException(e, ex));
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        if (!this.onSubscribeFailed) {
            try {
                this.downstream.onComplete();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                RxJavaPlugins.onError(ex);
            }
        }
    }
}