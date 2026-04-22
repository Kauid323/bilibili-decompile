package io.reactivex.rxjava3.disposables;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void onDisposed(T value);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceDisposable(T value) {
        super(Objects.requireNonNull(value, "value is null"));
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        T value;
        if (get() != null && (value = getAndSet(null)) != null) {
            onDisposed(value);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get() == null;
    }
}