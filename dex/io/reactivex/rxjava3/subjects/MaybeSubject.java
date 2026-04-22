package io.reactivex.rxjava3.subjects;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {
    static final MaybeDisposable[] EMPTY = new MaybeDisposable[0];
    static final MaybeDisposable[] TERMINATED = new MaybeDisposable[0];
    Throwable error;
    T value;
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicReference<MaybeDisposable<T>[]> observers = new AtomicReference<>(EMPTY);

    @CheckReturnValue
    public static <T> MaybeSubject<T> create() {
        return new MaybeSubject<>();
    }

    MaybeSubject() {
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable d) {
        if (this.observers.get() == TERMINATED) {
            d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T value) {
        MaybeDisposable<T>[] andSet;
        ExceptionHelper.nullCheck(value, "onSuccess called with a null value.");
        if (this.once.compareAndSet(false, true)) {
            this.value = value;
            for (MaybeDisposable<T> md : this.observers.getAndSet(TERMINATED)) {
                md.downstream.onSuccess(value);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable e) {
        MaybeDisposable<T>[] andSet;
        ExceptionHelper.nullCheck(e, "onError called with a null Throwable.");
        if (this.once.compareAndSet(false, true)) {
            this.error = e;
            for (MaybeDisposable<T> md : this.observers.getAndSet(TERMINATED)) {
                md.downstream.onError(e);
            }
            return;
        }
        RxJavaPlugins.onError(e);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        MaybeDisposable<T>[] andSet;
        if (this.once.compareAndSet(false, true)) {
            for (MaybeDisposable<T> md : this.observers.getAndSet(TERMINATED)) {
                md.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        MaybeDisposable<T> md = new MaybeDisposable<>(observer, this);
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
            return;
        }
        Object obj = (T) this.value;
        if (obj == null) {
            observer.onComplete();
        } else {
            observer.onSuccess(obj);
        }
    }

    boolean add(MaybeDisposable<T> inner) {
        MaybeDisposable<T>[] a;
        MaybeDisposable<T>[] b;
        do {
            a = this.observers.get();
            if (a == TERMINATED) {
                return false;
            }
            int n = a.length;
            b = new MaybeDisposable[n + 1];
            System.arraycopy(a, 0, b, 0, n);
            b[n] = inner;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, a, b));
        return true;
    }

    void remove(MaybeDisposable<T> inner) {
        MaybeDisposable<T>[] a;
        MaybeDisposable<T>[] b;
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
                MaybeDisposable<T>[] b2 = new MaybeDisposable[n - 1];
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

    public boolean hasComplete() {
        return this.observers.get() == TERMINATED && this.value == null && this.error == null;
    }

    public boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    int observerCount() {
        return this.observers.get().length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final MaybeObserver<? super T> downstream;

        MaybeDisposable(MaybeObserver<? super T> actual, MaybeSubject<T> parent) {
            this.downstream = actual;
            lazySet(parent);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            MaybeSubject<T> parent = getAndSet(null);
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