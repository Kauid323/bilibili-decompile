package io.reactivex.rxjava3.processors;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
    static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    volatile SimpleQueue<T> queue;
    final boolean refcount;
    final AtomicInteger wip = new AtomicInteger();
    final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(bufferSize(), false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean refCount) {
        return new MulticastProcessor<>(bufferSize(), refCount);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize) {
        ObjectHelper.verifyPositive(bufferSize, "bufferSize");
        return new MulticastProcessor<>(bufferSize, false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize, boolean refCount) {
        ObjectHelper.verifyPositive(bufferSize, "bufferSize");
        return new MulticastProcessor<>(bufferSize, refCount);
    }

    MulticastProcessor(int bufferSize, boolean refCount) {
        this.bufferSize = bufferSize;
        this.limit = bufferSize - (bufferSize >> 2);
        this.refcount = refCount;
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscArrayQueue(this.bufferSize);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.setOnce(this.upstream, s)) {
            if (s instanceof QueueSubscription) {
                QueueSubscription<T> qs = (QueueSubscription) s;
                int m = qs.requestFusion(3);
                if (m == 1) {
                    this.fusionMode = m;
                    this.queue = qs;
                    this.done = true;
                    drain();
                    return;
                } else if (m == 2) {
                    this.fusionMode = m;
                    this.queue = qs;
                    s.request(this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            s.request(this.bufferSize);
        }
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0) {
            ExceptionHelper.nullCheck(t, "onNext called with a null value.");
            if (!this.queue.offer(t)) {
                SubscriptionHelper.cancel(this.upstream);
                onError(new MissingBackpressureException());
                return;
            }
        }
        drain();
    }

    @CheckReturnValue
    public boolean offer(T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        if (this.done) {
            return false;
        }
        if (this.fusionMode == 0) {
            if (this.queue.offer(t)) {
                drain();
                return true;
            }
            return false;
        }
        throw new IllegalStateException("offer() should not be called in fusion mode!");
    }

    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (!this.done) {
            this.error = t;
            this.done = true;
            drain();
            return;
        }
        RxJavaPlugins.onError(t);
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        Throwable ex;
        MulticastSubscription<T> ms = new MulticastSubscription<>(s, this);
        s.onSubscribe(ms);
        if (add(ms)) {
            if (ms.get() == Long.MIN_VALUE) {
                remove(ms);
            } else {
                drain();
            }
        } else if (this.done && (ex = this.error) != null) {
            s.onError(ex);
        } else {
            s.onComplete();
        }
    }

    boolean add(MulticastSubscription<T> inner) {
        MulticastSubscription<T>[] a;
        MulticastSubscription<T>[] b;
        do {
            a = this.subscribers.get();
            if (a == TERMINATED) {
                return false;
            }
            int n = a.length;
            b = new MulticastSubscription[n + 1];
            System.arraycopy(a, 0, b, 0, n);
            b[n] = inner;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
        return true;
    }

    void remove(MulticastSubscription<T> inner) {
        while (true) {
            MulticastSubscription<T>[] a = this.subscribers.get();
            int n = a.length;
            if (n == 0) {
                return;
            }
            int j2 = -1;
            int i = 0;
            while (true) {
                if (i >= n) {
                    break;
                } else if (a[i] != inner) {
                    i++;
                } else {
                    j2 = i;
                    break;
                }
            }
            if (j2 >= 0) {
                if (n == 1) {
                    if (this.refcount) {
                        if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, TERMINATED)) {
                            SubscriptionHelper.cancel(this.upstream);
                            this.done = true;
                            return;
                        }
                    } else if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, EMPTY)) {
                        return;
                    }
                } else {
                    MulticastSubscription<T>[] b = new MulticastSubscription[n - 1];
                    System.arraycopy(a, 0, b, 0, j2);
                    System.arraycopy(a, j2 + 1, b, j2, (n - j2) - 1);
                    if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b)) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x0052 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void drain() {
        MulticastSubscription<T>[] as;
        int n;
        long j2;
        MulticastSubscription<T>[] andSet;
        MulticastSubscription<T>[] andSet2;
        T v;
        MulticastSubscription<T>[] andSet3;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<MulticastSubscription<T>[]> subs = this.subscribers;
        int c = this.consumed;
        int lim = this.limit;
        int fm = this.fusionMode;
        int missed = 1;
        int missed2 = c;
        while (true) {
            SimpleQueue<T> q = this.queue;
            if (q != null && (n = (as = subs.get()).length) != 0) {
                long r = -1;
                int length = as.length;
                int i = 0;
                while (true) {
                    j2 = 0;
                    if (i >= length) {
                        break;
                    }
                    MulticastSubscription<T> a = as[i];
                    long ra = a.get();
                    if (ra >= 0) {
                        if (r == -1) {
                            r = ra - a.emitted;
                        } else {
                            r = Math.min(r, ra - a.emitted);
                        }
                    }
                    i++;
                }
                long r2 = r;
                int c2 = missed2;
                while (c > 0) {
                    MulticastSubscription<T>[] bs = subs.get();
                    if (bs == TERMINATED) {
                        q.clear();
                        return;
                    } else if (as != bs) {
                        break;
                    } else {
                        boolean d = this.done;
                        try {
                            v = q.poll();
                        } catch (Throwable ex) {
                            Exceptions.throwIfFatal(ex);
                            SubscriptionHelper.cancel(this.upstream);
                            d = true;
                            this.error = ex;
                            this.done = true;
                            v = null;
                        }
                        boolean empty = v == null;
                        if (!d || !empty) {
                            int n2 = n;
                            if (empty) {
                                break;
                            }
                            for (MulticastSubscription<T> inner : as) {
                                inner.onNext(v);
                            }
                            r2--;
                            if (fm != 1 && (c2 = c2 + 1) == lim) {
                                c2 = 0;
                                this.upstream.get().request(lim);
                            }
                            n = n2;
                            j2 = 0;
                        } else {
                            Throwable ex2 = this.error;
                            if (ex2 != null) {
                                MulticastSubscription<T>[] andSet4 = subs.getAndSet(TERMINATED);
                                int length2 = andSet4.length;
                                int i2 = 0;
                                while (i2 < length2) {
                                    int i3 = length2;
                                    MulticastSubscription<T> inner2 = andSet4[i2];
                                    inner2.onError(ex2);
                                    i2++;
                                    length2 = i3;
                                }
                                return;
                            }
                            for (MulticastSubscription<T> inner3 : subs.getAndSet(TERMINATED)) {
                                inner3.onComplete();
                            }
                            return;
                        }
                    }
                }
                if (r2 == 0) {
                    MulticastSubscription<T>[] bs2 = subs.get();
                    if (bs2 == TERMINATED) {
                        q.clear();
                        return;
                    } else if (as != bs2) {
                        missed2 = c2;
                    } else if (this.done && q.isEmpty()) {
                        Throwable ex3 = this.error;
                        if (ex3 != null) {
                            for (MulticastSubscription<T> inner4 : subs.getAndSet(TERMINATED)) {
                                inner4.onError(ex3);
                            }
                            return;
                        }
                        for (MulticastSubscription<T> inner5 : subs.getAndSet(TERMINATED)) {
                            inner5.onComplete();
                        }
                        return;
                    }
                }
                missed2 = c2;
            }
            this.consumed = missed2;
            missed = this.wip.addAndGet(-missed);
            if (missed == 0) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> actual, MulticastProcessor<T> parent) {
            this.downstream = actual;
            this.parent = parent;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                long r = BackpressureHelper.addCancel(this, n);
                if (r != Long.MIN_VALUE && r != Long.MAX_VALUE) {
                    this.parent.drain();
                }
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        void onError(Throwable t) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(t);
            }
        }

        void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}