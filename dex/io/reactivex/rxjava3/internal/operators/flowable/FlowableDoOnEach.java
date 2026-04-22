package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;

    public FlowableDoOnEach(Flowable<T> source, Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete, Action onAfterTerminate) {
        super(source);
        this.onNext = onNext;
        this.onError = onError;
        this.onComplete = onComplete;
        this.onAfterTerminate = onAfterTerminate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        if (s instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new DoOnEachConditionalSubscriber((ConditionalSubscriber) s, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
        } else {
            this.source.subscribe((FlowableSubscriber) new DoOnEachSubscriber(s, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Action onAfterTerminate;
        final Action onComplete;
        final Consumer<? super Throwable> onError;
        final Consumer<? super T> onNext;

        DoOnEachSubscriber(Subscriber<? super T> actual, Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete, Action onAfterTerminate) {
            super(actual);
            this.onNext = onNext;
            this.onError = onError;
            this.onComplete = onComplete;
            this.onAfterTerminate = onAfterTerminate;
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext((Object) null);
                return;
            }
            try {
                this.onNext.accept(t);
                this.downstream.onNext(t);
            } catch (Throwable e) {
                fail(e);
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            boolean relay = true;
            try {
                this.onError.accept(t);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
                relay = false;
            }
            if (relay) {
                this.downstream.onError(t);
            }
            try {
                this.onAfterTerminate.run();
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                RxJavaPlugins.onError(e2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            try {
                this.onComplete.run();
                this.done = true;
                this.downstream.onComplete();
                try {
                    this.onAfterTerminate.run();
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    RxJavaPlugins.onError(e);
                }
            } catch (Throwable e2) {
                fail(e2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            try {
                T v = this.qs.poll();
                if (v != null) {
                    try {
                        this.onNext.accept(v);
                    } catch (Throwable ex) {
                        try {
                            Exceptions.throwIfFatal(ex);
                            this.onError.accept(ex);
                            throw ExceptionHelper.throwIfThrowable(ex);
                        } finally {
                            this.onAfterTerminate.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                }
                return v;
            } catch (Throwable ex2) {
                Exceptions.throwIfFatal(ex2);
                try {
                    this.onError.accept(ex2);
                    throw ExceptionHelper.throwIfThrowable(ex2);
                } catch (Throwable exc) {
                    Exceptions.throwIfFatal(exc);
                    throw new CompositeException(ex2, exc);
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Action onAfterTerminate;
        final Action onComplete;
        final Consumer<? super Throwable> onError;
        final Consumer<? super T> onNext;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> actual, Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete, Action onAfterTerminate) {
            super(actual);
            this.onNext = onNext;
            this.onError = onError;
            this.onComplete = onComplete;
            this.onAfterTerminate = onAfterTerminate;
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return;
            }
            try {
                this.onNext.accept(t);
                this.downstream.onNext(t);
            } catch (Throwable e) {
                fail(e);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                this.onNext.accept(t);
                return this.downstream.tryOnNext(t);
            } catch (Throwable e) {
                fail(e);
                return false;
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            boolean relay = true;
            try {
                this.onError.accept(t);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
                relay = false;
            }
            if (relay) {
                this.downstream.onError(t);
            }
            try {
                this.onAfterTerminate.run();
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                RxJavaPlugins.onError(e2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            try {
                this.onComplete.run();
                this.done = true;
                this.downstream.onComplete();
                try {
                    this.onAfterTerminate.run();
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    RxJavaPlugins.onError(e);
                }
            } catch (Throwable e2) {
                fail(e2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            try {
                T v = this.qs.poll();
                if (v != null) {
                    try {
                        this.onNext.accept(v);
                    } catch (Throwable ex) {
                        try {
                            Exceptions.throwIfFatal(ex);
                            this.onError.accept(ex);
                            throw ExceptionHelper.throwIfThrowable(ex);
                        } finally {
                            this.onAfterTerminate.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                }
                return v;
            } catch (Throwable ex2) {
                Exceptions.throwIfFatal(ex2);
                try {
                    this.onError.accept(ex2);
                    throw ExceptionHelper.throwIfThrowable(ex2);
                } catch (Throwable exc) {
                    Exceptions.throwIfFatal(exc);
                    throw new CompositeException(ex2, exc);
                }
            }
        }
    }
}