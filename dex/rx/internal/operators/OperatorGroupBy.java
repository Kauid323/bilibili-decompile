package rx.internal.operators;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.UtilityFunctions;
import rx.observables.GroupedObservable;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.Subscriptions;

public final class OperatorGroupBy<T, K, V> implements Observable.Operator<GroupedObservable<K, V>, T> {
    final int bufferSize;
    final boolean delayError;
    final Func1<? super T, ? extends K> keySelector;
    final Func1<Action1<K>, Map<K, Object>> mapFactory;
    final Func1<? super T, ? extends V> valueSelector;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector) {
        this(keySelector, UtilityFunctions.identity(), RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector) {
        this(keySelector, valueSelector, RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector, Func1<Action1<K>, Map<K, Object>> mapFactory) {
        this(keySelector, valueSelector, RxRingBuffer.SIZE, false, mapFactory);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError, Func1<Action1<K>, Map<K, Object>> mapFactory) {
        this.keySelector = keySelector;
        this.valueSelector = valueSelector;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
        this.mapFactory = mapFactory;
    }

    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> child) {
        try {
            final GroupBySubscriber<T, K, V> parent = new GroupBySubscriber<>(child, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, this.mapFactory);
            child.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorGroupBy.1
                public void call() {
                    parent.cancel();
                }
            }));
            child.setProducer(parent.producer);
            return parent;
        } catch (Throwable ex) {
            Exceptions.throwOrReport(ex, child);
            Subscriber<? super T> parent2 = Subscribers.empty();
            parent2.unsubscribe();
            return parent2;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class GroupByProducer implements Producer {
        final GroupBySubscriber<?, ?, ?> parent;

        public GroupByProducer(GroupBySubscriber<?, ?, ?> parent) {
            this.parent = parent;
        }

        public void request(long n) {
            this.parent.requestMore(n);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class GroupBySubscriber<T, K, V> extends Subscriber<T> {
        static final Object NULL_KEY = new Object();
        final Subscriber<? super GroupedObservable<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Queue<K> evictedKeys;
        final AtomicInteger groupCount;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Func1<? super T, ? extends K> keySelector;
        final GroupByProducer producer;
        final AtomicLong requested;
        final Func1<? super T, ? extends V> valueSelector;
        final AtomicInteger wip;
        final Queue<GroupedObservable<K, V>> queue = new ConcurrentLinkedQueue();
        final ProducerArbiter s = new ProducerArbiter();

        public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> actual, Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError, Func1<Action1<K>, Map<K, Object>> mapFactory) {
            this.actual = actual;
            this.keySelector = keySelector;
            this.valueSelector = valueSelector;
            this.bufferSize = bufferSize;
            this.delayError = delayError;
            this.s.request(bufferSize);
            this.producer = new GroupByProducer(this);
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.wip = new AtomicInteger();
            if (mapFactory == null) {
                this.groups = new ConcurrentHashMap();
                this.evictedKeys = null;
                return;
            }
            this.evictedKeys = new ConcurrentLinkedQueue();
            this.groups = createMap(mapFactory, new EvictionAction(this.evictedKeys));
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        static class EvictionAction<K> implements Action1<K> {
            final Queue<K> evictedKeys;

            EvictionAction(Queue<K> evictedKeys) {
                this.evictedKeys = evictedKeys;
            }

            public void call(K key) {
                this.evictedKeys.offer(key);
            }
        }

        private Map<Object, GroupedUnicast<K, V>> createMap(Func1<Action1<K>, Map<K, Object>> mapFactory, Action1<K> evictionAction) {
            return (Map) mapFactory.call(evictionAction);
        }

        public void setProducer(Producer s) {
            this.s.setProducer(s);
        }

        /* JADX WARN: Type inference failed for: r6v3, types: [rx.internal.operators.OperatorGroupBy$GroupedUnicast, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            Queue<?> queue = this.queue;
            Subscriber<? super GroupedObservable<K, V>> a = this.actual;
            try {
                Object call = this.keySelector.call(t);
                boolean newGroup = false;
                Object mapKey = call != null ? call : NULL_KEY;
                GroupedUnicast<K, V> group = this.groups.get(mapKey);
                ?? r6 = group;
                if (group == null) {
                    if (!this.cancelled.get()) {
                        GroupedUnicast<K, V> group2 = GroupedUnicast.createWith(call, this.bufferSize, this, this.delayError);
                        this.groups.put(mapKey, group2);
                        this.groupCount.getAndIncrement();
                        newGroup = true;
                        r6 = group2;
                    } else {
                        return;
                    }
                }
                try {
                    r6.onNext(this.valueSelector.call(t));
                    if (this.evictedKeys != null) {
                        while (true) {
                            K evictedKey = this.evictedKeys.poll();
                            if (evictedKey == null) {
                                break;
                            }
                            GroupedUnicast<K, V> g = this.groups.get(evictedKey);
                            if (g != null) {
                                g.onComplete();
                            }
                        }
                    }
                    if (newGroup) {
                        queue.offer(r6);
                        drain();
                    }
                } catch (Throwable ex) {
                    unsubscribe();
                    errorAll(a, queue, ex);
                }
            } catch (Throwable ex2) {
                unsubscribe();
                errorAll(a, queue, ex2);
            }
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaHooks.onError(t);
                return;
            }
            this.error = t;
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        public void onCompleted() {
            if (this.done) {
                return;
            }
            for (GroupedUnicast<K, V> e : this.groups.values()) {
                e.onComplete();
            }
            this.groups.clear();
            if (this.evictedKeys != null) {
                this.evictedKeys.clear();
            }
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        public void requestMore(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + n);
            }
            BackpressureUtils.getAndAddRequest(this.requested, n);
            drain();
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public void cancel(K key) {
            Object mapKey = key != null ? key : NULL_KEY;
            if (this.groups.remove(mapKey) != null && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Queue<GroupedObservable<K, V>> q = this.queue;
            Subscriber<? super GroupedObservable<K, V>> a = this.actual;
            while (!checkTerminated(this.done, q.isEmpty(), a, q)) {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    boolean d = this.done;
                    GroupedObservable<K, V> t = q.poll();
                    boolean empty = t == null;
                    if (checkTerminated(d, empty, a, q)) {
                        return;
                    }
                    if (empty) {
                        break;
                    }
                    a.onNext(t);
                    e++;
                }
                if (e != 0) {
                    if (r != Long.MAX_VALUE) {
                        BackpressureUtils.produced(this.requested, e);
                    }
                    this.s.request(e);
                }
                missed = this.wip.addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }

        void errorAll(Subscriber<? super GroupedObservable<K, V>> a, Queue<?> q, Throwable ex) {
            q.clear();
            List<GroupedUnicast<K, V>> list = new ArrayList<>((Collection<? extends GroupedUnicast<K, V>>) this.groups.values());
            this.groups.clear();
            if (this.evictedKeys != null) {
                this.evictedKeys.clear();
            }
            for (GroupedUnicast<K, V> e : list) {
                e.onError(ex);
            }
            a.onError(ex);
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<? super GroupedObservable<K, V>> a, Queue<?> q) {
            if (d) {
                Throwable err = this.error;
                if (err != null) {
                    errorAll(a, q, err);
                    return true;
                } else if (empty) {
                    this.actual.onCompleted();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K key, int bufferSize, GroupBySubscriber<?, K, T> parent, boolean delayError) {
            State<T, K> state = new State<>(bufferSize, parent, key, delayError);
            return new GroupedUnicast<>(key, state);
        }

        protected GroupedUnicast(K key, State<T, K> state) {
            super(key, state);
            this.state = state;
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable e) {
            this.state.onError(e);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class State<T, K> extends AtomicInteger implements Producer, Subscription, Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupBySubscriber<?, K, T> parent;
        final Queue<Object> queue = new ConcurrentLinkedQueue();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public State(int bufferSize, GroupBySubscriber<?, K, T> parent, K key, boolean delayError) {
            this.parent = parent;
            this.key = key;
            this.delayError = delayError;
        }

        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= required but it was " + n);
            }
            if (n != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                drain();
            }
        }

        public boolean isUnsubscribed() {
            return this.cancelled.get();
        }

        public void unsubscribe() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.parent.cancel(this.key);
            }
        }

        public void call(Subscriber<? super T> s) {
            if (this.once.compareAndSet(false, true)) {
                s.add(this);
                s.setProducer(this);
                this.actual.lazySet(s);
                drain();
                return;
            }
            s.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }

        public void onNext(T t) {
            if (t == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.next(t));
            }
            drain();
        }

        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Queue<Object> q = this.queue;
            boolean delayError = this.delayError;
            Subscriber<? super T> a = this.actual.get();
            while (true) {
                if (a != null) {
                    if (checkTerminated(this.done, q.isEmpty(), a, delayError)) {
                        return;
                    }
                    long r = this.requested.get();
                    long e = 0;
                    while (e != r) {
                        boolean d = this.done;
                        Object v = q.poll();
                        boolean empty = v == null;
                        if (checkTerminated(d, empty, a, delayError)) {
                            return;
                        }
                        if (empty) {
                            break;
                        }
                        a.onNext(NotificationLite.getValue(v));
                        e++;
                    }
                    if (e != 0) {
                        if (r != Long.MAX_VALUE) {
                            BackpressureUtils.produced(this.requested, e);
                        }
                        this.parent.s.request(e);
                    }
                }
                missed = addAndGet(-missed);
                if (missed != 0) {
                    if (a == null) {
                        Subscriber<? super T> a2 = this.actual.get();
                        a = a2;
                    }
                } else {
                    return;
                }
            }
        }

        boolean checkTerminated(boolean d, boolean empty, Subscriber<? super T> a, boolean delayError) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                return true;
            } else if (d) {
                if (delayError) {
                    if (empty) {
                        Throwable e = this.error;
                        if (e != null) {
                            a.onError(e);
                        } else {
                            a.onCompleted();
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
                    a.onCompleted();
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