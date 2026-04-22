package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;

public final class SingleDoOnTerminate<T> extends Single<T> {
    final Action onTerminate;
    final SingleSource<T> source;

    public SingleDoOnTerminate(SingleSource<T> source, Action onTerminate) {
        this.source = source;
        this.onTerminate = onTerminate;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super T> observer) {
        this.source.subscribe(new DoOnTerminate(observer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class DoOnTerminate implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;

        DoOnTerminate(SingleObserver<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.downstream.onSubscribe(d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                SingleDoOnTerminate.this.onTerminate.run();
                this.downstream.onSuccess(value);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            try {
                SingleDoOnTerminate.this.onTerminate.run();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                e = new CompositeException(e, ex);
            }
            this.downstream.onError(e);
        }
    }
}