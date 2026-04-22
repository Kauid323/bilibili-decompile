package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import j$.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] array;

    public FlowableFromArray(T[] array) {
        this.array = array;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        if (s instanceof ConditionalSubscriber) {
            s.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) s, this.array));
        } else {
            s.onSubscribe(new ArraySubscription(s, this.array));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        abstract void fastPath();

        abstract void slowPath(long r);

        BaseArraySubscription(T[] array) {
            this.array = array;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public final int requestFusion(int mode) {
            return mode & 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final T poll() {
            int i = this.index;
            T[] arr = this.array;
            if (i == arr.length) {
                return null;
            }
            this.index = i + 1;
            return (T) Objects.requireNonNull(arr[i], "array element is null");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
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
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> downstream;

        ArraySubscription(Subscriber<? super T> actual, T[] array) {
            super(array);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] arr = this.array;
            int f = arr.length;
            Subscriber<? super T> a = this.downstream;
            for (int i = this.index; i != f; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = arr[i];
                if (t == null) {
                    a.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                a.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            a.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long r) {
            long e = 0;
            T[] arr = this.array;
            int f = arr.length;
            int i = this.index;
            Subscriber<? super T> a = this.downstream;
            while (true) {
                if (e != r && i != f) {
                    if (this.cancelled) {
                        return;
                    }
                    T t = arr[i];
                    if (t == null) {
                        a.onError(new NullPointerException("The element at index " + i + " is null"));
                        return;
                    }
                    a.onNext(t);
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
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> downstream;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> actual, T[] array) {
            super(array);
            this.downstream = actual;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] arr = this.array;
            int f = arr.length;
            ConditionalSubscriber<? super T> a = this.downstream;
            for (int i = this.index; i != f; i++) {
                if (this.cancelled) {
                    return;
                }
                T t = arr[i];
                if (t == null) {
                    a.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                a.tryOnNext(t);
            }
            if (this.cancelled) {
                return;
            }
            a.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long r) {
            long e = 0;
            T[] arr = this.array;
            int f = arr.length;
            int i = this.index;
            ConditionalSubscriber<? super T> a = this.downstream;
            while (true) {
                if (e != r && i != f) {
                    if (this.cancelled) {
                        return;
                    }
                    T t = arr[i];
                    if (t == null) {
                        a.onError(new NullPointerException("The element at index " + i + " is null"));
                        return;
                    }
                    if (a.tryOnNext(t)) {
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