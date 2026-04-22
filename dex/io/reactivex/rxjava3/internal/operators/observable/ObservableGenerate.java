package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableGenerate<T, S> extends Observable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Supplier<S> stateSupplier;

    public ObservableGenerate(Supplier<S> stateSupplier, BiFunction<S, Emitter<T>, S> generator, Consumer<? super S> disposeState) {
        this.stateSupplier = stateSupplier;
        this.generator = generator;
        this.disposeState = disposeState;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            S state = this.stateSupplier.get();
            GeneratorDisposable<T, S> gd = new GeneratorDisposable<>(observer, this.generator, this.disposeState, state);
            observer.onSubscribe(gd);
            gd.run();
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            EmptyDisposable.error(e, observer);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final Observer<? super T> downstream;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorDisposable(Observer<? super T> actual, BiFunction<S, ? super Emitter<T>, S> generator, Consumer<? super S> disposeState, S initialState) {
            this.downstream = actual;
            this.generator = generator;
            this.disposeState = disposeState;
            this.state = initialState;
        }

        public void run() {
            S s = this.state;
            if (this.cancelled) {
                this.state = null;
                dispose(s);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> f = this.generator;
            while (!this.cancelled) {
                this.hasNext = false;
                try {
                    s = f.apply(s, this);
                    if (this.terminate) {
                        this.cancelled = true;
                        this.state = null;
                        dispose(s);
                        return;
                    }
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    this.state = null;
                    this.cancelled = true;
                    onError(ex);
                    dispose(s);
                    return;
                }
            }
            this.state = null;
            dispose(s);
        }

        private void dispose(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                RxJavaPlugins.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (!this.terminate) {
                if (this.hasNext) {
                    onError(new IllegalStateException("onNext already called in this generate turn"));
                } else if (t == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                } else {
                    this.hasNext = true;
                    this.downstream.onNext(t);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable t) {
            if (this.terminate) {
                RxJavaPlugins.onError(t);
                return;
            }
            if (t == null) {
                t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            this.terminate = true;
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (!this.terminate) {
                this.terminate = true;
                this.downstream.onComplete();
            }
        }
    }
}