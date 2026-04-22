package io.reactivex.rxjava3.internal.operators.parallel;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    public ParallelSortedJoin(ParallelFlowable<List<T>> source, Comparator<? super T> comparator) {
        this.source = source;
        this.comparator = comparator;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        SortedJoinSubscription<T> parent = new SortedJoinSubscription<>(s, this.source.parallelism(), this.comparator);
        s.onSubscribe(parent);
        this.source.subscribe(parent.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final Subscriber<? super T> downstream;
        final int[] indexes;
        final List<T>[] lists;
        final SortedJoinInnerSubscriber<T>[] subscribers;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        SortedJoinSubscription(Subscriber<? super T> actual, int n, Comparator<? super T> comparator) {
            this.downstream = actual;
            this.comparator = comparator;
            SortedJoinInnerSubscriber<T>[] s = new SortedJoinInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                s[i] = new SortedJoinInnerSubscriber<>(this, i);
            }
            this.subscribers = s;
            this.lists = new List[n];
            this.indexes = new int[n];
            this.remaining.lazySet(n);
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.lists, (Object) null);
                }
            }
        }

        void cancelAll() {
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr;
            for (SortedJoinInnerSubscriber<T> s : this.subscribers) {
                s.cancel();
            }
        }

        void innerNext(List<T> value, int index) {
            this.lists[index] = value;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        void innerError(Throwable e) {
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.error, (Object) null, e)) {
                drain();
            } else if (e != this.error.get()) {
                RxJavaPlugins.onError(e);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> a = this.downstream;
            List<T>[] lists = this.lists;
            int[] indexes = this.indexes;
            int n = indexes.length;
            int missed = 1;
            do {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    if (this.cancelled) {
                        Arrays.fill(lists, (Object) null);
                        return;
                    }
                    Throwable ex = this.error.get();
                    if (ex != null) {
                        cancelAll();
                        Arrays.fill(lists, (Object) null);
                        a.onError(ex);
                        return;
                    }
                    int i = 0;
                    int minIndex = -1;
                    T min = null;
                    while (i < n) {
                        List<T> list = lists[i];
                        long r2 = r;
                        int index = indexes[i];
                        if (list.size() != index) {
                            if (min == null) {
                                T min2 = list.get(index);
                                min = min2;
                                minIndex = i;
                            } else {
                                T b = list.get(index);
                                try {
                                    boolean smaller = this.comparator.compare(min, b) > 0;
                                    if (smaller) {
                                        min = b;
                                        minIndex = i;
                                    }
                                } catch (Throwable exc) {
                                    Exceptions.throwIfFatal(exc);
                                    cancelAll();
                                    Arrays.fill(lists, (Object) null);
                                    if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.error, (Object) null, exc)) {
                                        RxJavaPlugins.onError(exc);
                                    }
                                    a.onError(this.error.get());
                                    return;
                                }
                            }
                        }
                        i++;
                        r = r2;
                    }
                    long r3 = r;
                    if (min == null) {
                        Arrays.fill(lists, (Object) null);
                        a.onComplete();
                        return;
                    }
                    a.onNext(min);
                    indexes[minIndex] = indexes[minIndex] + 1;
                    e++;
                    r = r3;
                }
                if (this.cancelled) {
                    Arrays.fill(lists, (Object) null);
                    return;
                }
                Throwable ex2 = this.error.get();
                if (ex2 != null) {
                    cancelAll();
                    Arrays.fill(lists, (Object) null);
                    a.onError(ex2);
                    return;
                }
                boolean empty = true;
                int i2 = 0;
                while (true) {
                    if (i2 >= n) {
                        break;
                    } else if (indexes[i2] == lists[i2].size()) {
                        i2++;
                    } else {
                        empty = false;
                        break;
                    }
                }
                if (empty) {
                    Arrays.fill(lists, (Object) null);
                    a.onComplete();
                    return;
                }
                if (e != 0) {
                    BackpressureHelper.produced(this.requested, e);
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        public /* bridge */ /* synthetic */ void onNext(Object t) {
            onNext((List) ((List) t));
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> parent, int index) {
            this.parent = parent;
            this.index = index;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, Long.MAX_VALUE);
        }

        public void onNext(List<T> t) {
            this.parent.innerNext(t, this.index);
        }

        public void onError(Throwable t) {
            this.parent.innerError(t);
        }

        public void onComplete() {
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}