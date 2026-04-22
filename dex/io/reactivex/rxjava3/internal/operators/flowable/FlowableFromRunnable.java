package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableFromRunnable<T> extends Flowable<T> implements Supplier<T> {
    final Runnable run;

    public FlowableFromRunnable(Runnable run) {
        this.run = run;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        CancellableQueueFuseable<T> qs = new CancellableQueueFuseable<>();
        subscriber.onSubscribe(qs);
        if (!qs.isDisposed()) {
            try {
                this.run.run();
                if (!qs.isDisposed()) {
                    subscriber.onComplete();
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                if (!qs.isDisposed()) {
                    subscriber.onError(ex);
                } else {
                    RxJavaPlugins.onError(ex);
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        this.run.run();
        return null;
    }
}