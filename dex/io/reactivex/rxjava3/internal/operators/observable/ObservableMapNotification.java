package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
    final Supplier<? extends ObservableSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;

    public ObservableMapNotification(ObservableSource<T> source, Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper, Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper, Supplier<? extends ObservableSource<? extends R>> onCompleteSupplier) {
        super(source);
        this.onNextMapper = onNextMapper;
        this.onErrorMapper = onErrorMapper;
        this.onCompleteSupplier = onCompleteSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super ObservableSource<? extends R>> t) {
        this.source.subscribe(new MapNotificationObserver(t, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super ObservableSource<? extends R>> downstream;
        final Supplier<? extends ObservableSource<? extends R>> onCompleteSupplier;
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;
        Disposable upstream;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> actual, Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper, Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper, Supplier<? extends ObservableSource<? extends R>> onCompleteSupplier) {
            this.downstream = actual;
            this.onNextMapper = onNextMapper;
            this.onErrorMapper = onErrorMapper;
            this.onCompleteSupplier = onCompleteSupplier;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
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

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            try {
                ObservableSource<? extends R> p = (ObservableSource) Objects.requireNonNull(this.onNextMapper.apply(t), "The onNext ObservableSource returned is null");
                this.downstream.onNext(p);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            try {
                ObservableSource<? extends R> p = (ObservableSource) Objects.requireNonNull(this.onErrorMapper.apply(t), "The onError ObservableSource returned is null");
                this.downstream.onNext(p);
                this.downstream.onComplete();
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            try {
                ObservableSource<? extends R> p = (ObservableSource) Objects.requireNonNull(this.onCompleteSupplier.get(), "The onComplete ObservableSource returned is null");
                this.downstream.onNext(p);
                this.downstream.onComplete();
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }
    }
}