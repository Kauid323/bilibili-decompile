package io.reactivex.rxjava3.processors;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class PublishProcessor<T> extends FlowableProcessor<T> {
    Throwable error;
    final AtomicReference<PublishSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    static final PublishSubscription[] TERMINATED = new PublishSubscription[0];
    static final PublishSubscription[] EMPTY = new PublishSubscription[0];

    @CheckReturnValue
    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor<>();
    }

    PublishProcessor() {
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> t) {
        PublishSubscription<T> ps = new PublishSubscription<>(t, this);
        t.onSubscribe(ps);
        if (add(ps)) {
            if (ps.isCancelled()) {
                remove(ps);
                return;
            }
            return;
        }
        Throwable ex = this.error;
        if (ex != null) {
            t.onError(ex);
        } else {
            t.onComplete();
        }
    }

    boolean add(PublishSubscription<T> ps) {
        PublishSubscription<T>[] a;
        PublishSubscription<T>[] b;
        do {
            a = this.subscribers.get();
            if (a == TERMINATED) {
                return false;
            }
            int n = a.length;
            b = new PublishSubscription[n + 1];
            System.arraycopy(a, 0, b, 0, n);
            b[n] = ps;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
        return true;
    }

    void remove(PublishSubscription<T> ps) {
        PublishSubscription<T>[] a;
        PublishSubscription<T>[] b;
        do {
            a = this.subscribers.get();
            if (a == TERMINATED || a == EMPTY) {
                return;
            }
            int n = a.length;
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
                PublishSubscription<T>[] b2 = new PublishSubscription[n - 1];
                System.arraycopy(a, 0, b2, 0, j2);
                System.arraycopy(a, j2 + 1, b2, j2, (n - j2) - 1);
                b = b2;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
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
        PublishSubscription<T>[] publishSubscriptionArr;
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        for (PublishSubscription<T> s : this.subscribers.get()) {
            s.onNext(t);
        }
    }

    public void onError(Throwable t) {
        PublishSubscription<T>[] andSet;
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.subscribers.get() == TERMINATED) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.error = t;
        for (PublishSubscription<T> s : this.subscribers.getAndSet(TERMINATED)) {
            s.onError(t);
        }
    }

    public void onComplete() {
        PublishSubscription<T>[] andSet;
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        for (PublishSubscription<T> s : this.subscribers.getAndSet(TERMINATED)) {
            s.onComplete();
        }
    }

    @CheckReturnValue
    public boolean offer(T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        PublishSubscription<T>[] array = this.subscribers.get();
        for (PublishSubscription<T> s : array) {
            if (s.isFull()) {
                return false;
            }
        }
        for (PublishSubscription<T> s2 : array) {
            s2.onNext(t);
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) {
            return this.error;
        }
        return null;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;
        final Subscriber<? super T> downstream;
        final PublishProcessor<T> parent;

        PublishSubscription(Subscriber<? super T> actual, PublishProcessor<T> parent) {
            this.downstream = actual;
            this.parent = parent;
        }

        public void onNext(T t) {
            long r = get();
            if (r == Long.MIN_VALUE) {
                return;
            }
            if (r != 0) {
                this.downstream.onNext(t);
                BackpressureHelper.producedCancel(this, 1L);
                return;
            }
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }

        public void onError(Throwable t) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(t);
            } else {
                RxJavaPlugins.onError(t);
            }
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.addCancel(this, n);
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        boolean isFull() {
            return get() == 0;
        }
    }
}