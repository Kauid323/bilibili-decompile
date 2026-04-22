package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapNotification<T, R> extends Single<R> {
    final Function<? super Throwable, ? extends SingleSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends SingleSource<? extends R>> onSuccessMapper;
    final SingleSource<T> source;

    public SingleFlatMapNotification(SingleSource<T> source, Function<? super T, ? extends SingleSource<? extends R>> onSuccessMapper, Function<? super Throwable, ? extends SingleSource<? extends R>> onErrorMapper) {
        this.source = source;
        this.onSuccessMapper = onSuccessMapper;
        this.onErrorMapper = onErrorMapper;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super R> observer) {
        this.source.subscribe(new FlatMapSingleObserver(observer, this.onSuccessMapper, this.onErrorMapper));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final SingleObserver<? super R> downstream;
        final Function<? super Throwable, ? extends SingleSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends SingleSource<? extends R>> onSuccessMapper;
        Disposable upstream;

        FlatMapSingleObserver(SingleObserver<? super R> actual, Function<? super T, ? extends SingleSource<? extends R>> onSuccessMapper, Function<? super Throwable, ? extends SingleSource<? extends R>> onErrorMapper) {
            this.downstream = actual;
            this.onSuccessMapper = onSuccessMapper;
            this.onErrorMapper = onErrorMapper;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                SingleSource<? extends R> source = (SingleSource) Objects.requireNonNull(this.onSuccessMapper.apply(value), "The onSuccessMapper returned a null SingleSource");
                if (!isDisposed()) {
                    source.subscribe(new InnerObserver());
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            try {
                SingleSource<? extends R> source = (SingleSource) Objects.requireNonNull(this.onErrorMapper.apply(e), "The onErrorMapper returned a null SingleSource");
                if (!isDisposed()) {
                    source.subscribe(new InnerObserver());
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(new CompositeException(e, ex));
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class InnerObserver implements SingleObserver<R> {
            InnerObserver() {
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(FlatMapSingleObserver.this, d);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R value) {
                FlatMapSingleObserver.this.downstream.onSuccess(value);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                FlatMapSingleObserver.this.downstream.onError(e);
            }
        }
    }
}