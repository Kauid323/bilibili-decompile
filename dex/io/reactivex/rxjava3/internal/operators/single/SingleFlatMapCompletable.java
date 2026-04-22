package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapCompletable<T> extends Completable {
    final Function<? super T, ? extends CompletableSource> mapper;
    final SingleSource<T> source;

    public SingleFlatMapCompletable(SingleSource<T> source, Function<? super T, ? extends CompletableSource> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        FlatMapCompletableObserver<T> parent = new FlatMapCompletableObserver<>(observer, this.mapper);
        observer.onSubscribe(parent);
        this.source.subscribe(parent);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;
        final CompletableObserver downstream;
        final Function<? super T, ? extends CompletableSource> mapper;

        FlatMapCompletableObserver(CompletableObserver actual, Function<? super T, ? extends CompletableSource> mapper) {
            this.downstream = actual;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.replace(this, d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                CompletableSource cs = (CompletableSource) Objects.requireNonNull(this.mapper.apply(value), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    cs.subscribe(this);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}