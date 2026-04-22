package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = 4943102778943297569L;
    final BiConsumer<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> onCallback) {
        this.onCallback = onCallback;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable e) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(null, e);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            RxJavaPlugins.onError(new CompositeException(e, ex));
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable d) {
        DisposableHelper.setOnce(this, d);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T value) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(value, null);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            RxJavaPlugins.onError(ex);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}