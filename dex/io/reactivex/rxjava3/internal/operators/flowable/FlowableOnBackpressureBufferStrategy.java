package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final long bufferSize;
    final Action onOverflow;
    final BackpressureOverflowStrategy strategy;

    public FlowableOnBackpressureBufferStrategy(Flowable<T> source, long bufferSize, Action onOverflow, BackpressureOverflowStrategy strategy) {
        super(source);
        this.bufferSize = bufferSize;
        this.onOverflow = onOverflow;
        this.strategy = strategy;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new OnBackpressureBufferStrategySubscriber(s, this.onOverflow, this.strategy, this.bufferSize));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        final long bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final Action onOverflow;
        final BackpressureOverflowStrategy strategy;
        Subscription upstream;
        final AtomicLong requested = new AtomicLong();
        final Deque<T> deque = new ArrayDeque();

        OnBackpressureBufferStrategySubscriber(Subscriber<? super T> actual, Action onOverflow, BackpressureOverflowStrategy strategy, long bufferSize) {
            this.downstream = actual;
            this.onOverflow = onOverflow;
            this.strategy = strategy;
            this.bufferSize = bufferSize;
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
            if (this.done) {
                return;
            }
            boolean callOnOverflow = false;
            boolean callError = false;
            Deque<T> dq = this.deque;
            synchronized (dq) {
                if (dq.size() == this.bufferSize) {
                    switch (this.strategy) {
                        case DROP_LATEST:
                            dq.pollLast();
                            dq.offer(t);
                            callOnOverflow = true;
                            break;
                        case DROP_OLDEST:
                            dq.poll();
                            dq.offer(t);
                            callOnOverflow = true;
                            break;
                        default:
                            callError = true;
                            break;
                    }
                } else {
                    dq.offer(t);
                }
            }
            if (callOnOverflow) {
                if (this.onOverflow != null) {
                    try {
                        this.onOverflow.run();
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        this.upstream.cancel();
                        onError(ex);
                    }
                }
            } else if (callError) {
                this.upstream.cancel();
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
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
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        void clear(Deque<T> dq) {
            synchronized (dq) {
                dq.clear();
            }
        }

        void drain() {
            boolean empty;
            T v;
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Deque<T> dq = this.deque;
            Subscriber<? super T> a = this.downstream;
            do {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    if (this.cancelled) {
                        clear(dq);
                        return;
                    }
                    boolean d = this.done;
                    synchronized (dq) {
                        v = dq.poll();
                    }
                    boolean empty2 = v == null;
                    if (d) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            clear(dq);
                            a.onError(ex);
                            return;
                        } else if (empty2) {
                            a.onComplete();
                            return;
                        }
                    }
                    if (empty2) {
                        break;
                    }
                    a.onNext(v);
                    e++;
                }
                if (e == r) {
                    if (this.cancelled) {
                        clear(dq);
                        return;
                    }
                    boolean d2 = this.done;
                    synchronized (dq) {
                        empty = dq.isEmpty();
                    }
                    if (d2) {
                        Throwable ex2 = this.error;
                        if (ex2 != null) {
                            clear(dq);
                            a.onError(ex2);
                            return;
                        } else if (empty) {
                            a.onComplete();
                            return;
                        }
                    }
                }
                if (e != 0) {
                    BackpressureHelper.produced(this.requested, e);
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }
    }
}