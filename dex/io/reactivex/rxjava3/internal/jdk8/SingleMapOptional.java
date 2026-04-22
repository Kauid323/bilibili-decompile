package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;
import j$.util.Optional;

public final class SingleMapOptional<T, R> extends Maybe<R> {
    final Function<? super T, Optional<? extends R>> mapper;
    final Single<T> source;

    public SingleMapOptional(Single<T> source, Function<? super T, Optional<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super R> observer) {
        this.source.subscribe(new MapOptionalSingleObserver(observer, this.mapper));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapOptionalSingleObserver<T, R> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super R> downstream;
        final Function<? super T, Optional<? extends R>> mapper;
        Disposable upstream;

        MapOptionalSingleObserver(MaybeObserver<? super R> downstream, Function<? super T, Optional<? extends R>> mapper) {
            this.downstream = downstream;
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

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<? extends R> */
        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                Optional optional = (Optional) Objects.requireNonNull(this.mapper.apply(value), "The mapper returned a null item");
                if (optional.isPresent()) {
                    this.downstream.onSuccess((Object) optional.get());
                } else {
                    this.downstream.onComplete();
                }
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