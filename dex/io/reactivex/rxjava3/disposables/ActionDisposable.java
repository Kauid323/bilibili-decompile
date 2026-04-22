package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionDisposable(Action value) {
        super(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.rxjava3.disposables.ReferenceDisposable
    public void onDisposed(Action value) {
        try {
            value.run();
        } catch (Throwable ex) {
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "ActionDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}