package io.reactivex.rxjava3.subjects;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    static final SingleDisposable[] EMPTY = new SingleDisposable[0];
    static final SingleDisposable[] TERMINATED = new SingleDisposable[0];
    Throwable error;
    T value;
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicReference<SingleDisposable<T>[]> observers = new AtomicReference<>(EMPTY);

    @CheckReturnValue
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    SingleSubject() {
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable d) {
        if (this.observers.get() == TERMINATED) {
            d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T value) {
        SingleDisposable<T>[] andSet;
        ExceptionHelper.nullCheck(value, "onSuccess called with a null value.");
        if (this.once.compareAndSet(false, true)) {
            this.value = value;
            for (SingleDisposable<T> md : this.observers.getAndSet(TERMINATED)) {
                md.downstream.onSuccess(value);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable e) {
        SingleDisposable<T>[] andSet;
        ExceptionHelper.nullCheck(e, "onError called with a null Throwable.");
        if (this.once.compareAndSet(false, true)) {
            this.error = e;
            for (SingleDisposable<T> md : this.observers.getAndSet(TERMINATED)) {
                md.downstream.onError(e);
            }
            return;
        }
        RxJavaPlugins.onError(e);
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super T> observer) {
        SingleDisposable<T> md = new SingleDisposable<>(observer, this);
        observer.onSubscribe(md);
        if (add(md)) {
            if (md.isDisposed()) {
                remove(md);
                return;
            }
            return;
        }
        Throwable ex = this.error;
        if (ex != null) {
            observer.onError(ex);
        } else {
            observer.onSuccess((T) this.value);
        }
    }

    boolean add(SingleDisposable<T> inner) {
        SingleDisposable<T>[] a;
        SingleDisposable<T>[] b;
        do {
            a = this.observers.get();
            if (a == TERMINATED) {
                return false;
            }
            int n = a.length;
            b = new SingleDisposable[n + 1];
            System.arraycopy(a, 0, b, 0, n);
            b[n] = inner;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, a, b));
        return true;
    }

    void remove(SingleDisposable<T> inner) {
        SingleDisposable<T>[] a;
        SingleDisposable<T>[] b;
        do {
            a = this.observers.get();
            int n = a.length;
            if (n == 0) {
                return;
            }
            int j2 = -1;
            int i = 0;
            while (true) {
                if (i >= n) {
                    break;
                } else if (a[i] != inner) {
                    i++;
                } else {
                    j2 = i;
                    break;
                }
            }
            if (j2 < 0) {
                return;
            }
            if (n == 1) {
                b = EMPTY;
            } else {
                SingleDisposable<T>[] b2 = new SingleDisposable[n - 1];
                System.arraycopy(a, 0, b2, 0, j2);
                System.arraycopy(a, j2 + 1, b2, j2, (n - j2) - 1);
                b = b2;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, a, b));
    }

    public T getValue() {
        if (this.observers.get() == TERMINATED) {
            return this.value;
        }
        return null;
    }

    public boolean hasValue() {
        return this.observers.get() == TERMINATED && this.value != null;
    }

    public Throwable getThrowable() {
        if (this.observers.get() == TERMINATED) {
            return this.error;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.observers.get() == TERMINATED && this.error != null;
    }

    public boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    int observerCount() {
        return this.observers.get().length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> downstream;

        SingleDisposable(SingleObserver<? super T> actual, SingleSubject<T> parent) {
            this.downstream = actual;
            lazySet(parent);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SingleSubject<T> parent = getAndSet(null);
            if (parent != null) {
                parent.remove(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }
}