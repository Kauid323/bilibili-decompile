package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

public final class FlowableRangeLong extends Flowable<Long> {
    final long end;
    final long start;

    public FlowableRangeLong(long start, long count) {
        this.start = start;
        this.end = start + count;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> s) {
        if (s instanceof ConditionalSubscriber) {
            s.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) s, this.start, this.end));
        } else {
            s.onSubscribe(new RangeSubscription(s, this.start, this.end));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        abstract void fastPath();

        abstract void slowPath(long r);

        BaseRangeSubscription(long index, long end) {
            this.index = index;
            this.end = end;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public final int requestFusion(int mode) {
            return mode & 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final Long poll() {
            long i = this.index;
            if (i == this.end) {
                return null;
            }
            this.index = 1 + i;
            return Long.valueOf(i);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.end;
        }

        public final void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.add(this, n) == 0) {
                if (n == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(n);
                }
            }
        }

        public final void cancel() {
            this.cancelled = true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Long> downstream;

        RangeSubscription(Subscriber<? super Long> actual, long index, long end) {
            super(index, end);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long f = this.end;
            Subscriber<? super Long> a = this.downstream;
            for (long i = this.index; i != f; i++) {
                if (this.cancelled) {
                    return;
                }
                a.onNext(Long.valueOf(i));
            }
            if (this.cancelled) {
                return;
            }
            a.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r) {
            long e = 0;
            long f = this.end;
            long i = this.index;
            Subscriber<? super Long> a = this.downstream;
            while (true) {
                if (e != r && i != f) {
                    if (this.cancelled) {
                        return;
                    }
                    a.onNext(Long.valueOf(i));
                    e++;
                    i++;
                } else if (i == f) {
                    if (!this.cancelled) {
                        a.onComplete();
                        return;
                    }
                    return;
                } else {
                    r = get();
                    if (e == r) {
                        this.index = i;
                        r = addAndGet(-e);
                        if (r == 0) {
                            return;
                        }
                        e = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Long> downstream;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> actual, long index, long end) {
            super(index, end);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long f = this.end;
            ConditionalSubscriber<? super Long> a = this.downstream;
            for (long i = this.index; i != f; i++) {
                if (this.cancelled) {
                    return;
                }
                a.tryOnNext(Long.valueOf(i));
            }
            if (this.cancelled) {
                return;
            }
            a.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r) {
            long e = 0;
            long f = this.end;
            long i = this.index;
            ConditionalSubscriber<? super Long> a = this.downstream;
            while (true) {
                if (e != r && i != f) {
                    if (this.cancelled) {
                        return;
                    }
                    if (a.tryOnNext(Long.valueOf(i))) {
                        e++;
                    }
                    i++;
                } else if (i == f) {
                    if (!this.cancelled) {
                        a.onComplete();
                        return;
                    }
                    return;
                } else {
                    r = get();
                    if (e == r) {
                        this.index = i;
                        r = addAndGet(-e);
                        if (r == 0) {
                            return;
                        }
                        e = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}