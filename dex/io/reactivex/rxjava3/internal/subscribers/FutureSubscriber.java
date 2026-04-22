package io.reactivex.rxjava3.internal.subscribers;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    Throwable error;
    final AtomicReference<Subscription> upstream;
    T value;

    public FutureSubscriber() {
        super(1);
        this.upstream = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        Subscription a;
        do {
            a = this.upstream.get();
            if (a == this || a == SubscriptionHelper.CANCELLED) {
                return false;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, a, SubscriptionHelper.CANCELLED));
        if (a != null) {
            a.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable ex = this.error;
        if (ex != null) {
            throw new ExecutionException(ex);
        }
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(timeout, unit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(timeout, unit));
            }
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable ex = this.error;
        if (ex != null) {
            throw new ExecutionException(ex);
        }
        return this.value;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        SubscriptionHelper.setOnce(this.upstream, s, Long.MAX_VALUE);
    }

    public void onNext(T t) {
        if (this.value != null) {
            this.upstream.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onError(Throwable t) {
        Subscription a;
        if (this.error == null && (a = this.upstream.get()) != this && a != SubscriptionHelper.CANCELLED && MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, a, this)) {
            this.error = t;
            countDown();
            return;
        }
        RxJavaPlugins.onError(t);
    }

    public void onComplete() {
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        Subscription a = this.upstream.get();
        if (a != this && a != SubscriptionHelper.CANCELLED && MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, a, this)) {
            countDown();
        }
    }

    public void cancel() {
    }

    public void request(long n) {
    }
}