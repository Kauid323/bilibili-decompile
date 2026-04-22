package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Supplier<? extends MaybeSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;

    public MaybeFlatMapNotification(MaybeSource<T> source, Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper, Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper, Supplier<? extends MaybeSource<? extends R>> onCompleteSupplier) {
        super(source);
        this.onSuccessMapper = onSuccessMapper;
        this.onErrorMapper = onErrorMapper;
        this.onCompleteSupplier = onCompleteSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super R> observer) {
        this.source.subscribe(new FlatMapMaybeObserver(observer, this.onSuccessMapper, this.onErrorMapper, this.onCompleteSupplier));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final MaybeObserver<? super R> downstream;
        final Supplier<? extends MaybeSource<? extends R>> onCompleteSupplier;
        final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
        Disposable upstream;

        FlatMapMaybeObserver(MaybeObserver<? super R> actual, Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper, Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper, Supplier<? extends MaybeSource<? extends R>> onCompleteSupplier) {
            this.downstream = actual;
            this.onSuccessMapper = onSuccessMapper;
            this.onErrorMapper = onErrorMapper;
            this.onCompleteSupplier = onCompleteSupplier;
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

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                MaybeSource<? extends R> source = (MaybeSource) Objects.requireNonNull(this.onSuccessMapper.apply(value), "The onSuccessMapper returned a null MaybeSource");
                if (!isDisposed()) {
                    source.subscribe(new InnerObserver());
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            try {
                MaybeSource<? extends R> source = (MaybeSource) Objects.requireNonNull(this.onErrorMapper.apply(e), "The onErrorMapper returned a null MaybeSource");
                if (!isDisposed()) {
                    source.subscribe(new InnerObserver());
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(new CompositeException(e, ex));
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            try {
                MaybeSource<? extends R> source = (MaybeSource) Objects.requireNonNull(this.onCompleteSupplier.get(), "The onCompleteSupplier returned a null MaybeSource");
                if (!isDisposed()) {
                    source.subscribe(new InnerObserver());
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class InnerObserver implements MaybeObserver<R> {
            InnerObserver() {
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, d);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R value) {
                FlatMapMaybeObserver.this.downstream.onSuccess(value);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                FlatMapMaybeObserver.this.downstream.onError(e);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }
        }
    }
}