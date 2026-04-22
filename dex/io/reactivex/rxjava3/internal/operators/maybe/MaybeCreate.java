package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCreate<T> extends Maybe<T> {
    final MaybeOnSubscribe<T> source;

    public MaybeCreate(MaybeOnSubscribe<T> source) {
        this.source = source;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> observer) {
        Emitter<T> parent = new Emitter<>(observer);
        observer.onSubscribe(parent);
        try {
            this.source.subscribe(parent);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            parent.onError(ex);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Emitter<T> extends AtomicReference<Disposable> implements MaybeEmitter<T>, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        final MaybeObserver<? super T> downstream;

        Emitter(MaybeObserver<? super T> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.MaybeEmitter
        public void onSuccess(T value) {
            Disposable d;
            if (get() != DisposableHelper.DISPOSED && (d = getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                try {
                    if (value == null) {
                        this.downstream.onError(ExceptionHelper.createNullPointerException("onSuccess called with a null value."));
                    } else {
                        this.downstream.onSuccess(value);
                    }
                    if (d != null) {
                        d.dispose();
                    }
                } catch (Throwable th) {
                    if (d != null) {
                        d.dispose();
                    }
                    throw th;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeEmitter
        public void onError(Throwable t) {
            if (!tryOnError(t)) {
                RxJavaPlugins.onError(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeEmitter
        public boolean tryOnError(Throwable t) {
            Disposable d;
            if (t == null) {
                t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (get() != DisposableHelper.DISPOSED && (d = getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                try {
                    this.downstream.onError(t);
                } finally {
                    if (d != null) {
                        d.dispose();
                    }
                }
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.MaybeEmitter
        public void onComplete() {
            Disposable d;
            if (get() != DisposableHelper.DISPOSED && (d = getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                try {
                    this.downstream.onComplete();
                } finally {
                    if (d != null) {
                        d.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeEmitter
        public void setDisposable(Disposable d) {
            DisposableHelper.set(this, d);
        }

        @Override // io.reactivex.rxjava3.core.MaybeEmitter
        public void setCancellable(Cancellable c) {
            setDisposable(new CancellableDisposable(c));
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.MaybeEmitter, io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }
}