package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableResumeNext extends Completable {
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    final CompletableSource source;

    public CompletableResumeNext(CompletableSource source, Function<? super Throwable, ? extends CompletableSource> errorMapper) {
        this.source = source;
        this.errorMapper = errorMapper;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(final CompletableObserver observer) {
        ResumeNextObserver parent = new ResumeNextObserver(observer, this.errorMapper);
        observer.onSubscribe(parent);
        this.source.subscribe(parent);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 5018523762564524046L;
        final CompletableObserver downstream;
        final Function<? super Throwable, ? extends CompletableSource> errorMapper;
        boolean once;

        ResumeNextObserver(CompletableObserver observer, Function<? super Throwable, ? extends CompletableSource> errorMapper) {
            this.downstream = observer;
            this.errorMapper = errorMapper;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.replace(this, d);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            if (this.once) {
                this.downstream.onError(e);
                return;
            }
            this.once = true;
            try {
                CompletableSource c = (CompletableSource) Objects.requireNonNull(this.errorMapper.apply(e), "The errorMapper returned a null CompletableSource");
                c.subscribe(this);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(new CompositeException(e, ex));
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}