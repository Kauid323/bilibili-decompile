package io.reactivex.rxjava3.internal.disposables;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper implements Disposable {
    DISPOSED;

    public static boolean isDisposed(Disposable d) {
        return d == DISPOSED;
    }

    public static boolean set(AtomicReference<Disposable> field, Disposable d) {
        Disposable current;
        do {
            current = field.get();
            if (current == DISPOSED) {
                if (d != null) {
                    d.dispose();
                    return false;
                }
                return false;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(field, current, d));
        if (current != null) {
            current.dispose();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Disposable> field, Disposable d) {
        Objects.requireNonNull(d, "d is null");
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(field, (Object) null, d)) {
            d.dispose();
            if (field.get() != DISPOSED) {
                reportDisposableSet();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean replace(AtomicReference<Disposable> field, Disposable d) {
        Disposable current;
        do {
            current = field.get();
            if (current == DISPOSED) {
                if (d != null) {
                    d.dispose();
                    return false;
                }
                return false;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(field, current, d));
        return true;
    }

    public static boolean dispose(AtomicReference<Disposable> field) {
        Disposable current = field.get();
        Disposable d = DISPOSED;
        if (current != d) {
            Disposable current2 = field.getAndSet(d);
            Disposable current3 = current2;
            if (current3 != d) {
                if (current3 != null) {
                    current3.dispose();
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean validate(Disposable current, Disposable next) {
        if (next == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        } else if (current != null) {
            next.dispose();
            reportDisposableSet();
            return false;
        } else {
            return true;
        }
    }

    public static void reportDisposableSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<Disposable> field, Disposable d) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(field, (Object) null, d)) {
            if (field.get() == DISPOSED) {
                d.dispose();
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }
}