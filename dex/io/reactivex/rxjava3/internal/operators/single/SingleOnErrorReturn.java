package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {
    final SingleSource<? extends T> source;
    final T value;
    final Function<? super Throwable, ? extends T> valueSupplier;

    public SingleOnErrorReturn(SingleSource<? extends T> source, Function<? super Throwable, ? extends T> valueSupplier, T value) {
        this.source = source;
        this.valueSupplier = valueSupplier;
        this.value = value;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super T> observer) {
        this.source.subscribe(new OnErrorReturn(observer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> observer;

        OnErrorReturn(SingleObserver<? super T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            T v;
            if (SingleOnErrorReturn.this.valueSupplier != null) {
                try {
                    v = SingleOnErrorReturn.this.valueSupplier.apply(e);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    this.observer.onError(new CompositeException(e, ex));
                    return;
                }
            } else {
                v = SingleOnErrorReturn.this.value;
            }
            if (v == null) {
                NullPointerException npe = new NullPointerException("Value supplied was null");
                npe.initCause(e);
                this.observer.onError(npe);
                return;
            }
            this.observer.onSuccess(v);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.observer.onSubscribe(d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            this.observer.onSuccess(value);
        }
    }
}