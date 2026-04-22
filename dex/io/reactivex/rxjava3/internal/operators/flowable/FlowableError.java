package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import org.reactivestreams.Subscriber;

public final class FlowableError<T> extends Flowable<T> {
    final Supplier<? extends Throwable> errorSupplier;

    public FlowableError(Supplier<? extends Throwable> errorSupplier) {
        this.errorSupplier = errorSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        try {
            t = (Throwable) ExceptionHelper.nullCheck(this.errorSupplier.get(), "Callable returned a null Throwable.");
        } catch (Throwable th) {
            t = th;
            Exceptions.throwIfFatal(t);
        }
        EmptySubscription.error(t, s);
    }
}