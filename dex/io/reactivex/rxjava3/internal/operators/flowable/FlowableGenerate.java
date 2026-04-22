package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Supplier<S> stateSupplier;

    public FlowableGenerate(Supplier<S> stateSupplier, BiFunction<S, Emitter<T>, S> generator, Consumer<? super S> disposeState) {
        this.stateSupplier = stateSupplier;
        this.generator = generator;
        this.disposeState = disposeState;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        try {
            S state = this.stateSupplier.get();
            s.onSubscribe(new GeneratorSubscription(s, this.generator, this.disposeState, state));
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            EmptySubscription.error(e, s);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final Subscriber<? super T> downstream;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(Subscriber<? super T> actual, BiFunction<S, ? super Emitter<T>, S> generator, Consumer<? super S> disposeState, S initialState) {
            this.downstream = actual;
            this.generator = generator;
            this.disposeState = disposeState;
            this.state = initialState;
        }

        public void request(long n) {
            if (!SubscriptionHelper.validate(n) || BackpressureHelper.add(this, n) != 0) {
                return;
            }
            long e = 0;
            S s = this.state;
            BiFunction<S, ? super Emitter<T>, S> f = this.generator;
            while (true) {
                if (e != n) {
                    if (this.cancelled) {
                        this.state = null;
                        dispose(s);
                        return;
                    }
                    this.hasNext = false;
                    try {
                        s = f.apply(s, this);
                        if (this.terminate) {
                            this.cancelled = true;
                            this.state = null;
                            dispose(s);
                            return;
                        }
                        e++;
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        this.cancelled = true;
                        this.state = null;
                        onError(ex);
                        dispose(s);
                        return;
                    }
                } else {
                    n = get();
                    if (e == n) {
                        this.state = s;
                        n = addAndGet(-e);
                        if (n != 0) {
                            e = 0;
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        private void dispose(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                RxJavaPlugins.onError(ex);
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (BackpressureHelper.add(this, 1L) == 0) {
                    S s = this.state;
                    this.state = null;
                    dispose(s);
                }
            }
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