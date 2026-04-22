package io.reactivex.rxjava3.processors;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class AsyncProcessor<T> extends FlowableProcessor<T> {
    static final AsyncSubscription[] EMPTY = new AsyncSubscription[0];
    static final AsyncSubscription[] TERMINATED = new AsyncSubscription[0];
    Throwable error;
    final AtomicReference<AsyncSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    T value;

    @CheckReturnValue
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<>();
    }

    AsyncProcessor() {
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        if (this.subscribers.get() == TERMINATED) {
            s.cancel();
        } else {
            s.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        this.value = t;
    }

    public void onError(Throwable t) {
        AsyncSubscription<T>[] andSet;
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.subscribers.get() == TERMINATED) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.value = null;
        this.error = t;
        for (AsyncSubscription<T> as : this.subscribers.getAndSet(TERMINATED)) {
            as.onError(t);
        }
    }

    public void onComplete() {
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        T v = this.value;
        AsyncSubscription<T>[] array = this.subscribers.getAndSet(TERMINATED);
        int i = 0;
        if (v == null) {
            int length = array.length;
            while (i < length) {
                AsyncSubscription<T> as = array[i];
                as.onComplete();
                i++;
            }
            return;
        }
        int length2 = array.length;
        while (i < length2) {
            AsyncSubscription<T> as2 = array[i];
            as2.complete(v);
            i++;
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.subscribers.get() == TERMINATED && this.error != null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return this.subscribers.get() == TERMINATED && this.error == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        AsyncSubscription<T> as = new AsyncSubscription<>(s, this);
        s.onSubscribe(as);
        if (add(as)) {
            if (as.isCancelled()) {
                remove(as);
                return;
            }
            return;
        }
        Throwable ex = this.error;
        if (ex != null) {
            s.onError(ex);
            return;
        }
        T v = this.value;
        if (v != null) {
            as.complete(v);
        } else {
            as.onComplete();
        }
    }

    boolean add(AsyncSubscription<T> ps) {
        AsyncSubscription<T>[] a;
        AsyncSubscription<T>[] b;
        do {
            a = this.subscribers.get();
            if (a == TERMINATED) {
                return false;
            }
            int n = a.length;
            b = new AsyncSubscription[n + 1];
            System.arraycopy(a, 0, b, 0, n);
            b[n] = ps;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
        return true;
    }

    void remove(AsyncSubscription<T> ps) {
        AsyncSubscription<T>[] a;
        AsyncSubscription<T>[] b;
        do {
            a = this.subscribers.get();
            int n = a.length;
            if (n == 0) {
                return;
            }
            int j2 = -1;
            int i = 0;
            while (true) {
                if (i >= n) {
                    break;
                } else if (a[i] != ps) {
                    i++;
                } else {
                    j2 = i;
                    break;
                }
            }
            if (j2 < 0) {
                return;
            }
            if (n == 1) {
                b = EMPTY;
            } else {
                AsyncSubscription<T>[] b2 = new AsyncSubscription[n - 1];
                System.arraycopy(a, 0, b2, 0, j2);
                System.arraycopy(a, j2 + 1, b2, j2, (n - j2) - 1);
                b = b2;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.subscribers.get() == TERMINATED && this.value != null;
    }

    @CheckReturnValue
    public T getValue() {
        if (this.subscribers.get() == TERMINATED) {
            return this.value;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> actual, AsyncProcessor<T> parent) {
            super(actual);
            this.parent = parent;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.remove(this);
            }
        }

        void onComplete() {
            if (!isCancelled()) {
                this.downstream.onComplete();
            }
        }

        void onError(Throwable t) {
            if (isCancelled()) {
                RxJavaPlugins.onError(t);
            } else {
                this.downstream.onError(t);
            }
        }
    }
}