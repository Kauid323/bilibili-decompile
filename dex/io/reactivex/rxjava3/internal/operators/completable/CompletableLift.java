package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOperator;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableLift extends Completable {
    final CompletableOperator onLift;
    final CompletableSource source;

    public CompletableLift(CompletableSource source, CompletableOperator onLift) {
        this.source = source;
        this.onLift = onLift;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        try {
            CompletableObserver sw = this.onLift.apply(observer);
            this.source.subscribe(sw);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            Exceptions.throwIfFatal(ex2);
            RxJavaPlugins.onError(ex2);
        }
    }
}