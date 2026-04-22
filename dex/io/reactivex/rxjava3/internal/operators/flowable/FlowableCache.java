package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {
    static final CacheSubscription[] EMPTY = new CacheSubscription[0];
    static final CacheSubscription[] TERMINATED = new CacheSubscription[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicBoolean once;
    volatile long size;
    final AtomicReference<CacheSubscription<T>[]> subscribers;
    Node<T> tail;
    int tailOffset;

    public FlowableCache(Flowable<T> source, int capacityHint) {
        super(source);
        this.capacityHint = capacityHint;
        this.once = new AtomicBoolean();
        Node<T> n = new Node<>(capacityHint);
        this.head = n;
        this.tail = n;
        this.subscribers = new AtomicReference<>(EMPTY);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> t) {
        CacheSubscription<T> consumer = new CacheSubscription<>(t, this);
        t.onSubscribe(consumer);
        add(consumer);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.source.subscribe((FlowableSubscriber) this);
        } else {
            replay(consumer);
        }
    }

    boolean isConnected() {
        return this.once.get();
    }

    boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    long cachedEventCount() {
        return this.size;
    }

    void add(CacheSubscription<T> consumer) {
        CacheSubscription<T>[] current;
        CacheSubscription<T>[] next;
        do {
            current = this.subscribers.get();
            if (current == TERMINATED) {
                return;
            }
            int n = current.length;
            next = new CacheSubscription[n + 1];
            System.arraycopy(current, 0, next, 0, n);
            next[n] = consumer;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, current, next));
    }

    void remove(CacheSubscription<T> consumer) {
        CacheSubscription<T>[] current;
        CacheSubscription<T>[] next;
        do {
            current = this.subscribers.get();
            int n = current.length;
            if (n == 0) {
                return;
            }
            int j2 = -1;
            int i = 0;
            while (true) {
                if (i >= n) {
                    break;
                } else if (current[i] != consumer) {
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
                next = EMPTY;
            } else {
                CacheSubscription<T>[] next2 = new CacheSubscription[n - 1];
                System.arraycopy(current, 0, next2, 0, j2);
                System.arraycopy(current, j2 + 1, next2, j2, (n - j2) - 1);
                next = next2;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, current, next));
    }

    void replay(CacheSubscription<T> consumer) {
        if (consumer.getAndIncrement() != 0) {
            return;
        }
        int missed = 1;
        long index = consumer.index;
        int offset = consumer.offset;
        Node<T> node = consumer.node;
        AtomicLong requested = consumer.requested;
        Subscriber<? super T> downstream = consumer.downstream;
        int capacity = this.capacityHint;
        while (true) {
            boolean sourceDone = this.done;
            boolean empty = this.size == index;
            if (sourceDone && empty) {
                consumer.node = null;
                Throwable ex = this.error;
                if (ex != null) {
                    downstream.onError(ex);
                    return;
                } else {
                    downstream.onComplete();
                    return;
                }
            }
            if (!empty) {
                long consumerRequested = requested.get();
                if (consumerRequested == Long.MIN_VALUE) {
                    consumer.node = null;
                    return;
                } else if (consumerRequested != index) {
                    if (offset == capacity) {
                        node = node.next;
                        offset = 0;
                    }
                    downstream.onNext(node.values[offset]);
                    offset++;
                    index++;
                }
            }
            consumer.index = index;
            consumer.offset = offset;
            consumer.node = node;
            missed = consumer.addAndGet(-missed);
            if (missed == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    public void onNext(T t) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        int tailOffset = this.tailOffset;
        if (tailOffset == this.capacityHint) {
            Node<T> n = new Node<>(tailOffset);
            n.values[0] = t;
            this.tailOffset = 1;
            this.tail.next = n;
            this.tail = n;
        } else {
            this.tail.values[tailOffset] = t;
            this.tailOffset = tailOffset + 1;
        }
        this.size++;
        for (CacheSubscription<T> consumer : this.subscribers.get()) {
            replay(consumer);
        }
    }

    public void onError(Throwable t) {
        CacheSubscription<T>[] andSet;
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.error = t;
        this.done = true;
        for (CacheSubscription<T> consumer : this.subscribers.getAndSet(TERMINATED)) {
            replay(consumer);
        }
    }

    public void onComplete() {
        CacheSubscription<T>[] andSet;
        this.done = true;
        for (CacheSubscription<T> consumer : this.subscribers.getAndSet(TERMINATED)) {
            replay(consumer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested = new AtomicLong();

        CacheSubscription(Subscriber<? super T> downstream, FlowableCache<T> parent) {
            this.downstream = downstream;
            this.parent = parent;
            this.node = parent.head;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.addCancel(this.requested, n);
                this.parent.replay(this);
            }
        }

        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int capacityHint) {
            this.values = (T[]) new Object[capacityHint];
        }
    }
}