package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicReference<Subscriber<? super T>> downstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();
    final BasicIntQueueSubscription<T> wip = new UnicastQueueSubscription();
    final AtomicLong requested = new AtomicLong();

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(bufferSize(), null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new UnicastProcessor<>(capacityHint, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean delayError) {
        return new UnicastProcessor<>(bufferSize(), null, delayError);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint, Runnable onTerminate) {
        return create(capacityHint, onTerminate, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint, Runnable onTerminate, boolean delayError) {
        Objects.requireNonNull(onTerminate, "onTerminate");
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new UnicastProcessor<>(capacityHint, onTerminate, delayError);
    }

    UnicastProcessor(int capacityHint, Runnable onTerminate, boolean delayError) {
        this.queue = new SpscLinkedArrayQueue<>(capacityHint);
        this.onTerminate = new AtomicReference<>(onTerminate);
        this.delayError = delayError;
    }

    void doTerminate() {
        Runnable r = this.onTerminate.getAndSet(null);
        if (r != null) {
            r.run();
        }
    }

    void drainRegular(Subscriber<? super T> a) {
        SpscLinkedArrayQueue<T> q = this.queue;
        boolean failFast = !this.delayError;
        int missed = 1;
        do {
            long r = this.requested.get();
            long e = 0;
            while (r != e) {
                boolean d = this.done;
                T t = q.poll();
                boolean empty = t == null;
                if (checkTerminated(failFast, d, empty, a, q)) {
                    return;
                }
                if (empty) {
                    break;
                }
                a.onNext(t);
                e++;
            }
            if (r == e && checkTerminated(failFast, this.done, q.isEmpty(), a, q)) {
                return;
            }
            if (e != 0 && r != Long.MAX_VALUE) {
                this.requested.addAndGet(-e);
            }
            missed = this.wip.addAndGet(-missed);
        } while (missed != 0);
    }

    void drainFused(Subscriber<? super T> a) {
        int missed = 1;
        SpscLinkedArrayQueue<T> q = this.queue;
        boolean failFast = !this.delayError;
        while (!this.cancelled) {
            boolean d = this.done;
            if (failFast && d && this.error != null) {
                q.clear();
                this.downstream.lazySet(null);
                a.onError(this.error);
                return;
            }
            a.onNext((Object) null);
            if (d) {
                this.downstream.lazySet(null);
                Throwable ex = this.error;
                if (ex != null) {
                    a.onError(ex);
                    return;
                } else {
                    a.onComplete();
                    return;
                }
            }
            missed = this.wip.addAndGet(-missed);
            if (missed == 0) {
                return;
            }
        }
        this.downstream.lazySet(null);
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        int missed = 1;
        Subscriber<? super T> a = this.downstream.get();
        while (a == null) {
            missed = this.wip.addAndGet(-missed);
            if (missed != 0) {
                Subscriber<? super T> a2 = this.downstream.get();
                a = a2;
            } else {
                return;
            }
        }
        if (this.enableOperatorFusion) {
            drainFused(a);
        } else {
            drainRegular(a);
        }
    }

    boolean checkTerminated(boolean failFast, boolean d, boolean empty, Subscriber<? super T> a, SpscLinkedArrayQueue<T> q) {
        if (this.cancelled) {
            q.clear();
            this.downstream.lazySet(null);
            return true;
        } else if (d) {
            if (failFast && this.error != null) {
                q.clear();
                this.downstream.lazySet(null);
                a.onError(this.error);
                return true;
            } else if (empty) {
                Throwable e = this.error;
                this.downstream.lazySet(null);
                if (e != null) {
                    a.onError(e);
                } else {
                    a.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        if (this.done || this.cancelled) {
            s.cancel();
        } else {
            s.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.done || this.cancelled) {
            return;
        }
        this.queue.offer(t);
        drain();
    }

    public void onError(Throwable t) {
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.done || this.cancelled) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.error = t;
        this.done = true;
        doTerminate();
        drain();
    }

    public void onComplete() {
        if (this.done || this.cancelled) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            s.onSubscribe(this.wip);
            this.downstream.set(s);
            if (this.cancelled) {
                this.downstream.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), s);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int requestedMode) {
            if ((requestedMode & 2) != 0) {
                UnicastProcessor.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, n);
                UnicastProcessor.this.drain();
            }
        }

        public void cancel() {
            if (UnicastProcessor.this.cancelled) {
                return;
            }
            UnicastProcessor.this.cancelled = true;
            UnicastProcessor.this.doTerminate();
            UnicastProcessor.this.downstream.lazySet(null);
            if (UnicastProcessor.this.wip.getAndIncrement() == 0) {
                UnicastProcessor.this.downstream.lazySet(null);
                if (!UnicastProcessor.this.enableOperatorFusion) {
                    UnicastProcessor.this.queue.clear();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.downstream.get() != null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }
}