package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapBiSelector<T, U, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends U>> mapper;
    final BiFunction<? super T, ? super U, ? extends R> resultSelector;
    final SingleSource<T> source;

    public SingleFlatMapBiSelector(SingleSource<T> source, Function<? super T, ? extends SingleSource<? extends U>> mapper, BiFunction<? super T, ? super U, ? extends R> resultSelector) {
        this.source = source;
        this.mapper = mapper;
        this.resultSelector = resultSelector;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super R> observer) {
        this.source.subscribe(new FlatMapBiMainObserver(observer, this.mapper, this.resultSelector));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapBiMainObserver<T, U, R> implements SingleObserver<T>, Disposable {
        final InnerObserver<T, U, R> inner;
        final Function<? super T, ? extends SingleSource<? extends U>> mapper;

        FlatMapBiMainObserver(SingleObserver<? super R> actual, Function<? super T, ? extends SingleSource<? extends U>> mapper, BiFunction<? super T, ? super U, ? extends R> resultSelector) {
            this.inner = new InnerObserver<>(actual, resultSelector);
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.inner);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.inner.get());
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this.inner, d)) {
                this.inner.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                SingleSource<? extends U> next = (SingleSource) Objects.requireNonNull(this.mapper.apply(value), "The mapper returned a null MaybeSource");
                if (DisposableHelper.replace(this.inner, null)) {
                    this.inner.value = value;
                    next.subscribe(this.inner);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.inner.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.inner.downstream.onError(e);
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements SingleObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final SingleObserver<? super R> downstream;
            final BiFunction<? super T, ? super U, ? extends R> resultSelector;
            T value;

            InnerObserver(SingleObserver<? super R> actual, BiFunction<? super T, ? super U, ? extends R> resultSelector) {
                this.downstream = actual;
                this.resultSelector = resultSelector;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(U value) {
                T t = this.value;
                this.value = null;
                try {
                    this.downstream.onSuccess(Objects.requireNonNull(this.resultSelector.apply(t, value), "The resultSelector returned a null value"));
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    this.downstream.onError(ex);
                }
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                this.downstream.onError(e);
            }
        }
    }
}