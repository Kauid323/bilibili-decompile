package io.reactivex.rxjava3.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
public final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FutureDisposable(Future<?> run, boolean allowInterrupt) {
        super(run);
        this.allowInterrupt = allowInterrupt;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        Future<?> f = get();
        return f == null || f.isDone();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        Future<?> f = getAndSet(null);
        if (f != null) {
            f.cancel(this.allowInterrupt);
        }
    }
}