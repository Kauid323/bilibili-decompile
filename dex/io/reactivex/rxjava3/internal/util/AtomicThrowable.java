package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean tryAddThrowable(Throwable t) {
        return ExceptionHelper.addThrowable(this, t);
    }

    public boolean tryAddThrowableOrReport(Throwable t) {
        if (tryAddThrowable(t)) {
            return true;
        }
        RxJavaPlugins.onError(t);
        return false;
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }

    public boolean isTerminated() {
        return get() == ExceptionHelper.TERMINATED;
    }

    public void tryTerminateAndReport() {
        Throwable ex = terminate();
        if (ex != null && ex != ExceptionHelper.TERMINATED) {
            RxJavaPlugins.onError(ex);
        }
    }

    public void tryTerminateConsumer(Subscriber<?> consumer) {
        Throwable ex = terminate();
        if (ex == null) {
            consumer.onComplete();
        } else if (ex != ExceptionHelper.TERMINATED) {
            consumer.onError(ex);
        }
    }

    public void tryTerminateConsumer(Observer<?> consumer) {
        Throwable ex = terminate();
        if (ex == null) {
            consumer.onComplete();
        } else if (ex != ExceptionHelper.TERMINATED) {
            consumer.onError(ex);
        }
    }

    public void tryTerminateConsumer(MaybeObserver<?> consumer) {
        Throwable ex = terminate();
        if (ex == null) {
            consumer.onComplete();
        } else if (ex != ExceptionHelper.TERMINATED) {
            consumer.onError(ex);
        }
    }

    public void tryTerminateConsumer(SingleObserver<?> consumer) {
        Throwable ex = terminate();
        if (ex != null && ex != ExceptionHelper.TERMINATED) {
            consumer.onError(ex);
        }
    }

    public void tryTerminateConsumer(CompletableObserver consumer) {
        Throwable ex = terminate();
        if (ex == null) {
            consumer.onComplete();
        } else if (ex != ExceptionHelper.TERMINATED) {
            consumer.onError(ex);
        }
    }

    public void tryTerminateConsumer(Emitter<?> consumer) {
        Throwable ex = terminate();
        if (ex == null) {
            consumer.onComplete();
        } else if (ex != ExceptionHelper.TERMINATED) {
            consumer.onError(ex);
        }
    }
}