package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public FlowableSkipLastTimed(Flowable<T> source, long time, TimeUnit unit, Scheduler scheduler, int bufferSize, boolean delayError) {
        super(source);
        this.time = time;
        this.unit = unit;
        this.scheduler = scheduler;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new SkipLastTimedSubscriber(s, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Subscription upstream;

        SkipLastTimedSubscriber(Subscriber<? super T> actual, long time, TimeUnit unit, Scheduler scheduler, int bufferSize, boolean delayError) {
            this.downstream = actual;
            this.time = time;
            this.unit = unit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
            this.delayError = delayError;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            long now = this.scheduler.now(this.unit);
            this.queue.offer(Long.valueOf(now), t);
            drain();
        }

        public void onError(Throwable t) {
            this.error = t;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            boolean delayError;
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super T> a = this.downstream;
            SpscLinkedArrayQueue<Object> q = this.queue;
            boolean delayError2 = this.delayError;
            TimeUnit unit = this.unit;
            Scheduler scheduler = this.scheduler;
            long time = this.time;
            while (true) {
                long r = this.requested.get();
                long e = 0;
                while (true) {
                    if (e == r) {
                        delayError = delayError2;
                        break;
                    }
                    boolean d = this.done;
                    Long ts = (Long) q.peek();
                    boolean empty = ts == null;
                    long now = scheduler.now(unit);
                    if (!empty && ts.longValue() > now - time) {
                        empty = true;
                    }
                    if (checkTerminated(d, empty, a, delayError2)) {
                        return;
                    }
                    if (empty) {
                        delayError = delayError2;
                        break;
                    }
                    q.poll();
                    a.onNext(q.poll());
                    e++;
                    delayError2 = delayError2;
                }
                if (e != 0) {
                    BackpressureHelper.produced(this.requested, e);
                }
                missed = addAndGet(-missed);
                if (missed != 0) {
                    delayError2 = delayError;
                } else {
                    return;
                }
            }
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<? super T> a, boolean delayError) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (d) {
                if (delayError) {
                    if (empty) {
                        Throwable e = this.error;
                        if (e != null) {
                            a.onError(e);
                        } else {
                            a.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable e2 = this.error;
                if (e2 != null) {
                    this.queue.clear();
                    a.onError(e2);
                    return true;
                } else if (empty) {
                    a.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}