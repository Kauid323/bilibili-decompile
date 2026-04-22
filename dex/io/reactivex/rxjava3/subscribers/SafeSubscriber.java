package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    boolean done;
    final Subscriber<? super T> downstream;
    Subscription upstream;

    public SafeSubscriber(Subscriber<? super T> downstream) {
        this.downstream = downstream;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.validate(this.upstream, s)) {
            this.upstream = s;
            try {
                this.downstream.onSubscribe(this);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.done = true;
                try {
                    s.cancel();
                    RxJavaPlugins.onError(e);
                } catch (Throwable e1) {
                    Exceptions.throwIfFatal(e1);
                    RxJavaPlugins.onError(new CompositeException(e, e1));
                }
            }
        }
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.upstream == null) {
            onNextNoSubscription();
        } else if (t == null) {
            Throwable ex = ExceptionHelper.createNullPointerException("onNext called with a null Throwable.");
            try {
                this.upstream.cancel();
                onError(ex);
            } catch (Throwable e1) {
                Exceptions.throwIfFatal(e1);
                onError(new CompositeException(ex, e1));
            }
        } else {
            try {
                this.downstream.onNext(t);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                try {
                    this.upstream.cancel();
                    onError(e);
                } catch (Throwable e12) {
                    Exceptions.throwIfFatal(e12);
                    onError(new CompositeException(e, e12));
                }
            }
        }
    }

    void onNextNoSubscription() {
        this.done = true;
        Throwable ex = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.downstream.onError(ex);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                RxJavaPlugins.onError(new CompositeException(ex, e));
            }
        } catch (Throwable e2) {
            Exceptions.throwIfFatal(e2);
            RxJavaPlugins.onError(new CompositeException(ex, e2));
        }
    }

    public void onError(Throwable t) {
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            Throwable npe = new NullPointerException("Subscription not set!");
            try {
                this.downstream.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.downstream.onError(new CompositeException(t, npe));
                    return;
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    RxJavaPlugins.onError(new CompositeException(t, npe, e));
                    return;
                }
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                RxJavaPlugins.onError(new CompositeException(t, npe, e2));
                return;
            }
        }
        if (t == null) {
            t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        try {
            this.downstream.onError(t);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            RxJavaPlugins.onError(new CompositeException(t, ex));
        }
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            onCompleteNoSubscription();
            return;
        }
        try {
            this.downstream.onComplete();
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            RxJavaPlugins.onError(e);
        }
    }

    void onCompleteNoSubscription() {
        Throwable ex = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.downstream.onError(ex);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                RxJavaPlugins.onError(new CompositeException(ex, e));
            }
        } catch (Throwable e2) {
            Exceptions.throwIfFatal(e2);
            RxJavaPlugins.onError(new CompositeException(ex, e2));
        }
    }

    public void request(long n) {
        try {
            this.upstream.request(n);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            try {
                this.upstream.cancel();
                RxJavaPlugins.onError(e);
            } catch (Throwable e1) {
                Exceptions.throwIfFatal(e1);
                RxJavaPlugins.onError(new CompositeException(e, e1));
            }
        }
    }

    public void cancel() {
        try {
            this.upstream.cancel();
        } catch (Throwable e1) {
            Exceptions.throwIfFatal(e1);
            RxJavaPlugins.onError(e1);
        }
    }
}