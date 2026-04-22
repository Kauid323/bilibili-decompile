package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;

final class AutoCloseableDisposable extends ReferenceDisposable<AutoCloseable> {
    private static final long serialVersionUID = -6646144244598696847L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoCloseableDisposable(AutoCloseable value) {
        super(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.rxjava3.disposables.ReferenceDisposable
    public void onDisposed(AutoCloseable value) {
        try {
            value.close();
        } catch (Throwable ex) {
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "AutoCloseableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}