package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

    public MaybeOnErrorNext(MaybeSource<T> source, Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction) {
        super(source);
        this.resumeFunction = resumeFunction;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        this.source.subscribe(new OnErrorNextMaybeObserver(observer, this.resumeFunction));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 2026620218879969836L;
        final MaybeObserver<? super T> downstream;
        final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

        OnErrorNextMaybeObserver(MaybeObserver<? super T> actual, Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction) {
            this.downstream = actual;
            this.resumeFunction = resumeFunction;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            this.downstream.onSuccess(value);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            try {
                MaybeSource<? extends T> m = (MaybeSource) Objects.requireNonNull(this.resumeFunction.apply(e), "The resumeFunction returned a null MaybeSource");
                DisposableHelper.replace(this, null);
                m.subscribe(new NextMaybeObserver<>(this.downstream, this));
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(new CompositeException(e, ex));
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        static final class NextMaybeObserver<T> implements MaybeObserver<T> {
            final MaybeObserver<? super T> downstream;
            final AtomicReference<Disposable> upstream;

            NextMaybeObserver(MaybeObserver<? super T> actual, AtomicReference<Disposable> d) {
                this.downstream = actual;
                this.upstream = d;
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this.upstream, d);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(T value) {
                this.downstream.onSuccess(value);
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
}