package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;

public final class CompletableToSingle<T> extends Single<T> {
    final T completionValue;
    final Supplier<? extends T> completionValueSupplier;
    final CompletableSource source;

    public CompletableToSingle(CompletableSource source, Supplier<? extends T> completionValueSupplier, T completionValue) {
        this.source = source;
        this.completionValue = completionValue;
        this.completionValueSupplier = completionValueSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super T> observer) {
        this.source.subscribe(new ToSingle(observer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;

        ToSingle(SingleObserver<? super T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            T v;
            if (CompletableToSingle.this.completionValueSupplier != null) {
                try {
                    v = CompletableToSingle.this.completionValueSupplier.get();
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    this.observer.onError(e);
                    return;
                }
            } else {
                v = CompletableToSingle.this.completionValue;
            }
            if (v == null) {
                this.observer.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.observer.onSuccess(v);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.observer.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.observer.onSubscribe(d);
        }
    }
}