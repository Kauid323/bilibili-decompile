package rx.internal.operators;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.OpenHashSet;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

public final class OperatorReplay<T> extends ConnectableObservable<T> implements Subscription {
    static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0() { // from class: rx.internal.operators.OperatorReplay.1
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final Func0<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Observable<? extends T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static <T, U, R> Observable<R> multicastSelector(final Func0<? extends ConnectableObservable<U>> connectableFactory, final Func1<? super Observable<U>, ? extends Observable<R>> selector) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<R>() { // from class: rx.internal.operators.OperatorReplay.2
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(final Subscriber<? super R> child) {
                ConnectableObservable connectableObservable;
                try {
                    connectableObservable = (ConnectableObservable) connectableFactory.call();
                } catch (Throwable th) {
                    e = th;
                }
                try {
                    Observable<R> observable = (Observable) selector.call(connectableObservable);
                    observable.subscribe(child);
                    connectableObservable.connect(new Action1<Subscription>() { // from class: rx.internal.operators.OperatorReplay.2.1
                        public void call(Subscription t) {
                            child.add(t);
                        }
                    });
                } catch (Throwable th2) {
                    e = th2;
                    Exceptions.throwOrReport(e, child);
                }
            }
        });
    }

    public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable<T> co, Scheduler scheduler) {
        final Observable<T> observable = co.observeOn(scheduler);
        Observable.OnSubscribe<T> onSubscribe = new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorReplay.3
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(final Subscriber<? super T> child) {
                observable.unsafeSubscribe(new Subscriber<T>(child) { // from class: rx.internal.operators.OperatorReplay.3.1
                    public void onNext(T t) {
                        child.onNext(t);
                    }

                    public void onError(Throwable e) {
                        child.onError(e);
                    }

                    public void onCompleted() {
                        child.onCompleted();
                    }
                });
            }
        };
        return new ConnectableObservable<T>(onSubscribe) { // from class: rx.internal.operators.OperatorReplay.4
            public void connect(Action1<? super Subscription> connection) {
                co.connect(connection);
            }
        };
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source) {
        return create(source, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source, final int bufferSize) {
        if (bufferSize == Integer.MAX_VALUE) {
            return create(source);
        }
        return create(source, new Func0<ReplayBuffer<T>>() { // from class: rx.internal.operators.OperatorReplay.5
            public ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(bufferSize);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source, long maxAge, TimeUnit unit, Scheduler scheduler) {
        return create(source, maxAge, unit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source, long maxAge, TimeUnit unit, final Scheduler scheduler, final int bufferSize) {
        final long maxAgeInMillis = unit.toMillis(maxAge);
        return create(source, new Func0<ReplayBuffer<T>>() { // from class: rx.internal.operators.OperatorReplay.6
            public ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(bufferSize, maxAgeInMillis, scheduler);
            }
        });
    }

    static <T> ConnectableObservable<T> create(Observable<? extends T> source, final Func0<? extends ReplayBuffer<T>> bufferFactory) {
        final AtomicReference<ReplaySubscriber<T>> curr = new AtomicReference<>();
        Observable.OnSubscribe<T> onSubscribe = new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorReplay.7
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super T> child) {
                ReplaySubscriber<T> r;
                while (true) {
                    r = (ReplaySubscriber) curr.get();
                    if (r != null) {
                        break;
                    }
                    ReplaySubscriber<T> u = new ReplaySubscriber<>((ReplayBuffer) bufferFactory.call());
                    u.init();
                    if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(curr, r, u)) {
                        r = u;
                        break;
                    }
                }
                InnerProducer<T> inner = new InnerProducer<>(r, child);
                r.add(inner);
                child.add(inner);
                r.buffer.replay(inner);
                child.setProducer(inner);
            }
        };
        return new OperatorReplay(onSubscribe, source, curr, bufferFactory);
    }

    private OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> source, AtomicReference<ReplaySubscriber<T>> current, Func0<? extends ReplayBuffer<T>> bufferFactory) {
        super(onSubscribe);
        this.source = source;
        this.current = current;
        this.bufferFactory = bufferFactory;
    }

    public void unsubscribe() {
        this.current.lazySet(null);
    }

    public boolean isUnsubscribed() {
        ReplaySubscriber<T> ps = this.current.get();
        return ps == null || ps.isUnsubscribed();
    }

    public void connect(Action1<? super Subscription> connection) {
        ReplaySubscriber<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isUnsubscribed()) {
                break;
            }
            ReplaySubscriber<T> u = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
            u.init();
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, ps, u)) {
                ps = u;
                break;
            }
        }
        boolean z = false;
        if (!ps.shouldConnect.get() && ps.shouldConnect.compareAndSet(false, true)) {
            z = true;
        }
        boolean doConnect = z;
        connection.call(ps);
        if (doConnect) {
            this.source.unsafeSubscribe(ps);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplaySubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final ReplayBuffer<T> buffer;
        boolean coordinateAll;
        List<InnerProducer<T>> coordinationQueue;
        boolean done;
        boolean emitting;
        long maxChildRequested;
        long maxUpstreamRequested;
        boolean missed;
        volatile Producer producer;
        long producersCacheVersion;
        volatile long producersVersion;
        volatile boolean terminated;
        final OpenHashSet<InnerProducer<T>> producers = new OpenHashSet<>();
        InnerProducer<T>[] producersCache = EMPTY;
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplaySubscriber(ReplayBuffer<T> buffer) {
            this.buffer = buffer;
            request(0L);
        }

        void init() {
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorReplay.ReplaySubscriber.1
                public void call() {
                    if (!ReplaySubscriber.this.terminated) {
                        synchronized (ReplaySubscriber.this.producers) {
                            if (!ReplaySubscriber.this.terminated) {
                                ReplaySubscriber.this.producers.terminate();
                                ReplaySubscriber.this.producersVersion++;
                                ReplaySubscriber.this.terminated = true;
                            }
                        }
                    }
                }
            }));
        }

        boolean add(InnerProducer<T> producer) {
            if (producer == null) {
                throw new NullPointerException();
            }
            if (this.terminated) {
                return false;
            }
            synchronized (this.producers) {
                if (this.terminated) {
                    return false;
                }
                this.producers.add(producer);
                this.producersVersion++;
                return true;
            }
        }

        void remove(InnerProducer<T> producer) {
            if (this.terminated) {
                return;
            }
            synchronized (this.producers) {
                if (this.terminated) {
                    return;
                }
                this.producers.remove(producer);
                if (this.producers.isEmpty()) {
                    this.producersCache = EMPTY;
                }
                this.producersVersion++;
            }
        }

        public void setProducer(Producer p) {
            Producer p0 = this.producer;
            if (p0 != null) {
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
            this.producer = p;
            manageRequests(null);
            replay();
        }

        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        public void onError(Throwable e) {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.error(e);
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.complete();
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        void manageRequests(InnerProducer<T> innerProducer) {
            InnerProducer<T>[] copyProducers;
            long j2;
            List<InnerProducer<T>> list;
            boolean z;
            long j3;
            InnerProducer<T>[] copyProducers2;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.emitting) {
                    if (innerProducer != null) {
                        List list2 = this.coordinationQueue;
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.coordinationQueue = list2;
                        }
                        list2.add(innerProducer);
                    } else {
                        this.coordinateAll = true;
                    }
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                long j4 = this.maxChildRequested;
                if (innerProducer == null) {
                    long j5 = j4;
                    for (InnerProducer<T> innerProducer2 : copyProducers()) {
                        if (innerProducer2 != null) {
                            j5 = Math.max(j5, innerProducer2.totalRequested.get());
                        }
                    }
                    j2 = j5;
                } else {
                    j2 = Math.max(j4, innerProducer.totalRequested.get());
                }
                makeRequest(j2, j4);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.missed) {
                            this.emitting = false;
                            return;
                        }
                        this.missed = false;
                        list = this.coordinationQueue;
                        this.coordinationQueue = null;
                        z = this.coordinateAll;
                        this.coordinateAll = false;
                    }
                    long j6 = this.maxChildRequested;
                    if (list == null) {
                        j3 = j6;
                    } else {
                        j3 = j6;
                        for (InnerProducer<T> innerProducer3 : list) {
                            j3 = Math.max(j3, innerProducer3.totalRequested.get());
                        }
                    }
                    if (z) {
                        for (InnerProducer<T> innerProducer4 : copyProducers()) {
                            if (innerProducer4 != null) {
                                j3 = Math.max(j3, innerProducer4.totalRequested.get());
                            }
                        }
                    }
                    makeRequest(j3, j6);
                }
            }
        }

        InnerProducer<T>[] copyProducers() {
            InnerProducer<T>[] result;
            synchronized (this.producers) {
                Object[] a = this.producers.values();
                int n = a.length;
                result = new InnerProducer[n];
                System.arraycopy(a, 0, result, 0, n);
            }
            return result;
        }

        void makeRequest(long maxTotalRequests, long previousTotalRequests) {
            long ur = this.maxUpstreamRequested;
            Producer p = this.producer;
            long diff = maxTotalRequests - previousTotalRequests;
            if (diff != 0) {
                this.maxChildRequested = maxTotalRequests;
                if (p != null) {
                    if (ur != 0) {
                        this.maxUpstreamRequested = 0L;
                        p.request(ur + diff);
                        return;
                    }
                    p.request(diff);
                    return;
                }
                long u = ur + diff;
                if (u < 0) {
                    u = Long.MAX_VALUE;
                }
                this.maxUpstreamRequested = u;
            } else if (ur != 0 && p != null) {
                this.maxUpstreamRequested = 0L;
                p.request(ur);
            }
        }

        void replay() {
            InnerProducer<T>[] pc = this.producersCache;
            if (this.producersCacheVersion != this.producersVersion) {
                synchronized (this.producers) {
                    pc = this.producersCache;
                    Object[] a = this.producers.values();
                    int n = a.length;
                    if (pc.length != n) {
                        pc = new InnerProducer[n];
                        this.producersCache = pc;
                    }
                    System.arraycopy(a, 0, pc, 0, n);
                    this.producersCacheVersion = this.producersVersion;
                }
            }
            ReplayBuffer<T> b = this.buffer;
            InnerProducer<T>[] arr$ = pc;
            for (InnerProducer<T> rp : arr$) {
                if (rp != null) {
                    b.replay(rp);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(ReplaySubscriber<T> parent, Subscriber<? super T> child) {
            this.parent = parent;
            this.child = child;
        }

        public void request(long n) {
            long r;
            long u;
            if (n < 0) {
                return;
            }
            do {
                r = get();
                if (r == UNSUBSCRIBED) {
                    return;
                }
                if (r >= 0 && n == 0) {
                    return;
                }
                u = r + n;
                if (u < 0) {
                    u = Long.MAX_VALUE;
                }
            } while (!compareAndSet(r, u));
            addTotalRequested(n);
            this.parent.manageRequests(this);
            this.parent.buffer.replay(this);
        }

        void addTotalRequested(long n) {
            long r;
            long u;
            do {
                r = this.totalRequested.get();
                u = r + n;
                if (u < 0) {
                    u = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(r, u));
        }

        public long produced(long n) {
            long r;
            long u;
            if (n <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                r = get();
                if (r == UNSUBSCRIBED) {
                    return UNSUBSCRIBED;
                }
                u = r - n;
                if (u < 0) {
                    throw new IllegalStateException("More produced (" + n + ") than requested (" + r + ")");
                }
            } while (!compareAndSet(r, u));
            return u;
        }

        public boolean isUnsubscribed() {
            return get() == UNSUBSCRIBED;
        }

        public void unsubscribe() {
            long r = get();
            if (r != UNSUBSCRIBED) {
                long r2 = getAndSet(UNSUBSCRIBED);
                if (r2 != UNSUBSCRIBED) {
                    this.parent.remove(this);
                    this.parent.manageRequests(this);
                    this.child = null;
                }
            }
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int capacityHint) {
            super(capacityHint);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void next(T value) {
            add(NotificationLite.next(value));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void error(Throwable e) {
            add(NotificationLite.error(e));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.completed());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void replay(InnerProducer<T> output) {
            synchronized (output) {
                if (output.emitting) {
                    output.missed = true;
                    return;
                }
                output.emitting = true;
                while (!output.isUnsubscribed()) {
                    int sourceIndex = this.size;
                    Integer destinationIndexObject = (Integer) output.index();
                    int destinationIndex = destinationIndexObject != null ? destinationIndexObject.intValue() : 0;
                    Subscriber<? super T> child = output.child;
                    if (child == null) {
                        return;
                    }
                    long r = output.get();
                    long e = 0;
                    while (e != r && destinationIndex < sourceIndex) {
                        Object o = get(destinationIndex);
                        try {
                            if (NotificationLite.accept(child, o) || output.isUnsubscribed()) {
                                return;
                            }
                            destinationIndex++;
                            e++;
                        } catch (Throwable err) {
                            Exceptions.throwIfFatal(err);
                            output.unsubscribe();
                            if (!NotificationLite.isError(o) && !NotificationLite.isCompleted(o)) {
                                child.onError(OnErrorThrowable.addValueAsLastCause(err, NotificationLite.getValue(o)));
                                return;
                            }
                            return;
                        }
                    }
                    if (e != 0) {
                        output.index = Integer.valueOf(destinationIndex);
                        if (r != Long.MAX_VALUE) {
                            output.produced(e);
                        }
                    }
                    synchronized (output) {
                        if (!output.missed) {
                            output.emitting = false;
                            return;
                        }
                        output.missed = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object value, long index) {
            this.value = value;
            this.index = index;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        public BoundedReplayBuffer() {
            Node n = new Node(null, 0L);
            this.tail = n;
            set(n);
        }

        final void addLast(Node n) {
            this.tail.set(n);
            this.tail = n;
            this.size++;
        }

        final void removeFirst() {
            Node head = get();
            Node next = head.get();
            if (next == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(next);
        }

        final void removeSome(int n) {
            Node head = get();
            while (n > 0) {
                head = head.get();
                n--;
                this.size--;
            }
            setFirst(head);
        }

        final void setFirst(Node n) {
            set(n);
        }

        Node getInitialHead() {
            return get();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void next(T value) {
            Object o = enterTransform(NotificationLite.next(value));
            long j2 = this.index + 1;
            this.index = j2;
            Node n = new Node(o, j2);
            addLast(n);
            truncate();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void error(Throwable e) {
            Object o = enterTransform(NotificationLite.error(e));
            long j2 = this.index + 1;
            this.index = j2;
            Node n = new Node(o, j2);
            addLast(n);
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void complete() {
            Object o = enterTransform(NotificationLite.completed());
            long j2 = this.index + 1;
            this.index = j2;
            Node n = new Node(o, j2);
            addLast(n);
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void replay(InnerProducer<T> output) {
            Subscriber<? super T> child;
            Node v;
            synchronized (output) {
                if (output.emitting) {
                    output.missed = true;
                    return;
                }
                output.emitting = true;
                while (!output.isUnsubscribed()) {
                    Node node = (Node) output.index();
                    if (node == null) {
                        node = getInitialHead();
                        output.index = node;
                        output.addTotalRequested(node.index);
                    }
                    if (output.isUnsubscribed() || (child = output.child) == null) {
                        return;
                    }
                    long r = output.get();
                    long e = 0;
                    while (e != r && (v = node.get()) != null) {
                        Object o = leaveTransform(v.value);
                        try {
                            if (NotificationLite.accept(child, o)) {
                                output.index = null;
                                return;
                            }
                            e++;
                            node = v;
                            if (output.isUnsubscribed()) {
                                return;
                            }
                        } catch (Throwable err) {
                            output.index = null;
                            Exceptions.throwIfFatal(err);
                            output.unsubscribe();
                            if (!NotificationLite.isError(o) && !NotificationLite.isCompleted(o)) {
                                child.onError(OnErrorThrowable.addValueAsLastCause(err, NotificationLite.getValue(o)));
                                return;
                            }
                            return;
                        }
                    }
                    if (e != 0) {
                        output.index = node;
                        if (r != Long.MAX_VALUE) {
                            output.produced(e);
                        }
                    }
                    synchronized (output) {
                        if (!output.missed) {
                            output.emitting = false;
                            return;
                        }
                        output.missed = false;
                    }
                }
            }
        }

        Object enterTransform(Object value) {
            return value;
        }

        Object leaveTransform(Object value) {
            return value;
        }

        void truncate() {
        }

        void truncateFinal() {
        }

        final void collect(Collection<? super T> output) {
            Node n = getInitialHead();
            while (true) {
                Node next = n.get();
                if (next != null) {
                    Object o = next.value;
                    Object v = leaveTransform(o);
                    if (!NotificationLite.isCompleted(v) && !NotificationLite.isError(v)) {
                        output.add((Object) NotificationLite.getValue(v));
                        n = next;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isCompleted(leaveTransform(this.tail.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int limit) {
            this.limit = limit;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final Scheduler scheduler;

        public SizeAndTimeBoundReplayBuffer(int limit, long maxAgeInMillis, Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = limit;
            this.maxAgeInMillis = maxAgeInMillis;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object enterTransform(Object value) {
            return new Timestamped(this.scheduler.now(), value);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object leaveTransform(Object value) {
            return ((Timestamped) value).getValue();
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Node getInitialHead() {
            long timeLimit = this.scheduler.now() - this.maxAgeInMillis;
            Node prev = (Node) get();
            for (Node next = prev.get(); next != null; next = next.get()) {
                Object o = next.value;
                Object v = leaveTransform(o);
                if (NotificationLite.isCompleted(v) || NotificationLite.isError(v) || ((Timestamped) o).getTimestampMillis() > timeLimit) {
                    break;
                }
                prev = next;
            }
            return prev;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            long timeLimit = this.scheduler.now() - this.maxAgeInMillis;
            Node prev = (Node) get();
            Node next = prev.get();
            int e = 0;
            while (next != null) {
                if (this.size > this.limit) {
                    e++;
                    this.size--;
                    prev = next;
                    next = next.get();
                } else {
                    Timestamped<?> v = (Timestamped) next.value;
                    if (v.getTimestampMillis() > timeLimit) {
                        break;
                    }
                    e++;
                    this.size--;
                    prev = next;
                    next = next.get();
                }
            }
            if (e != 0) {
                setFirst(prev);
            }
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncateFinal() {
            long timeLimit = this.scheduler.now() - this.maxAgeInMillis;
            Node prev = (Node) get();
            int e = 0;
            for (Node next = prev.get(); next != null && this.size > 1; next = next.get()) {
                Timestamped<?> v = (Timestamped) next.value;
                if (v.getTimestampMillis() > timeLimit) {
                    break;
                }
                e++;
                this.size--;
                prev = next;
            }
            if (e != 0) {
                setFirst(prev);
            }
        }
    }
}