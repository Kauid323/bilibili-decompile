package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableFromAction extends Completable {
    final Action run;

    public CompletableFromAction(Action run) {
        this.run = run;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        Disposable d = Disposable.CC.empty();
        observer.onSubscribe(d);
        if (!d.isDisposed()) {
            try {
                this.run.run();
                if (!d.isDisposed()) {
                    observer.onComplete();
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                if (!d.isDisposed()) {
                    observer.onError(e);
                } else {
                    RxJavaPlugins.onError(e);
                }
            }
        }
    }
}