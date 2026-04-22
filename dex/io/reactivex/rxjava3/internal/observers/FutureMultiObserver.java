package io.reactivex.rxjava3.internal.observers;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Future<T>, Disposable {
    Throwable error;
    final AtomicReference<Disposable> upstream;
    T value;

    public FutureMultiObserver() {
        super(1);
        this.upstream = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        Disposable a;
        do {
            a = this.upstream.get();
            if (a == this || a == DisposableHelper.DISPOSED) {
                return false;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, a, DisposableHelper.DISPOSED));
        if (a != null) {
            a.dispose();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.upstream.get());
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

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(Disposable d) {
        DisposableHelper.setOnce(this.upstream, d);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
        Disposable a = this.upstream.get();
        if (a == DisposableHelper.DISPOSED) {
            return;
        }
        this.value = t;
        MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, a, this);
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable t) {
        Disposable a;
        do {
            a = this.upstream.get();
            if (a == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.error = t;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, a, this));
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        Disposable a = this.upstream.get();
        if (a == DisposableHelper.DISPOSED) {
            return;
        }
        MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.upstream, a, this);
        countDown();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return isDone();
    }
}