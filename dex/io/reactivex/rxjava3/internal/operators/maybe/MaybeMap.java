package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;

public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends R> mapper;

    public MaybeMap(MaybeSource<T> source, Function<? super T, ? extends R> mapper) {
        super(source);
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super R> observer) {
        this.source.subscribe(new MapMaybeObserver(observer, this.mapper));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super R> downstream;
        final Function<? super T, ? extends R> mapper;
        Disposable upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapMaybeObserver(MaybeObserver<? super R> actual, Function<? super T, ? extends R> mapper) {
            this.downstream = actual;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            Disposable d = this.upstream;
            this.upstream = DisposableHelper.DISPOSED;
            d.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
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
                this.downstream.onSuccess(Objects.requireNonNull(this.mapper.apply(value), "The mapper returned a null item"));
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}