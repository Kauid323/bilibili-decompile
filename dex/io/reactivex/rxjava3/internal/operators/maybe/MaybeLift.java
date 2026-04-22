package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOperator;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import j$.util.Objects;

public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final MaybeOperator<? extends R, ? super T> operator;

    public MaybeLift(MaybeSource<T> source, MaybeOperator<? extends R, ? super T> operator) {
        super(source);
        this.operator = operator;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super R> observer) {
        try {
            MaybeObserver<? super T> lifted = (MaybeObserver) Objects.requireNonNull(this.operator.apply(observer), "The operator returned a null MaybeObserver");
            this.source.subscribe(lifted);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptyDisposable.error(ex, observer);
        }
    }
}