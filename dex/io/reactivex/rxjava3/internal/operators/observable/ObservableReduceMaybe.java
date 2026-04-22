package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;

public final class ObservableReduceMaybe<T> extends Maybe<T> {
    final BiFunction<T, T, T> reducer;
    final ObservableSource<T> source;

    public ObservableReduceMaybe(ObservableSource<T> source, BiFunction<T, T, T> reducer) {
        this.source = source;
        this.reducer = reducer;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new ReduceObserver(observer, this.reducer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ReduceObserver<T> implements Observer<T>, Disposable {
        boolean done;
        final MaybeObserver<? super T> downstream;
        final BiFunction<T, T, T> reducer;
        Disposable upstream;
        T value;

        ReduceObserver(MaybeObserver<? super T> observer, BiFunction<T, T, T> reducer) {
            this.downstream = observer;
            this.reducer = reducer;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T value) {
            if (!this.done) {
                T v = this.value;
                if (v == null) {
                    this.value = value;
                    return;
                }
                try {
                    this.value = (T) Objects.requireNonNull(this.reducer.apply(v, value), "The reducer returned a null value");
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    this.upstream.dispose();
                    onError(ex);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaPlugins.onError(e);
                return;
            }
            this.done = true;
            this.value = null;
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T v = this.value;
            this.value = null;
            if (v != null) {
                this.downstream.onSuccess(v);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}