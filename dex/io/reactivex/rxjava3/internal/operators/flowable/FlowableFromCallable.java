package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableFromCallable<T> extends Flowable<T> implements Supplier<T> {
    final Callable<? extends T> callable;

    public FlowableFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(s);
        s.onSubscribe(deferredScalarSubscription);
        try {
            deferredScalarSubscription.complete(Objects.requireNonNull(this.callable.call(), "The callable returned a null value"));
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            if (deferredScalarSubscription.isCancelled()) {
                RxJavaPlugins.onError(ex);
            } else {
                s.onError(ex);
            }
        }
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        return (T) Objects.requireNonNull(this.callable.call(), "The callable returned a null value");
    }
}