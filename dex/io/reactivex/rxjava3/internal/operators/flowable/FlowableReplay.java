package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final Supplier DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Supplier<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable e);

        void next(T value);

        void replay(InnerSubscription<T> output);
    }

    public static <U, R> Flowable<R> multicastSelector(final Supplier<? extends ConnectableFlowable<U>> connectableFactory, final Function<? super Flowable<U>, ? extends Publisher<R>> selector) {
        return new MulticastFlowable(connectableFactory, selector);
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> source) {
        return create(source, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, final int bufferSize, boolean eagerTruncate) {
        if (bufferSize == Integer.MAX_VALUE) {
            return createFrom(source);
        }
        return create(source, new ReplayBufferSupplier(bufferSize, eagerTruncate));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
        return create(source, maxAge, unit, scheduler, Integer.MAX_VALUE, eagerTruncate);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source, final long maxAge, final TimeUnit unit, final Scheduler scheduler, final int bufferSize, boolean eagerTruncate) {
        return create(source, new ScheduledReplayBufferSupplier(bufferSize, maxAge, unit, scheduler, eagerTruncate));
    }

    static <T> ConnectableFlowable<T> create(Flowable<T> source, final Supplier<? extends ReplayBuffer<T>> bufferFactory) {
        AtomicReference<ReplaySubscriber<T>> curr = new AtomicReference<>();
        Publisher<T> onSubscribe = new ReplayPublisher<>(curr, bufferFactory);
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(onSubscribe, source, curr, bufferFactory));
    }

    private FlowableReplay(Publisher<T> onSubscribe, Flowable<T> source, final AtomicReference<ReplaySubscriber<T>> current, final Supplier<? extends ReplayBuffer<T>> bufferFactory) {
        this.onSubscribe = onSubscribe;
        this.source = source;
        this.current = current;
        this.bufferFactory = bufferFactory;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.onSubscribe.subscribe(s);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        ReplaySubscriber<T> conn = this.current.get();
        if (conn != null && conn.isDisposed()) {
            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, conn, (Object) null);
        }
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> connection) {
        ReplaySubscriber<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isDisposed()) {
                break;
            }
            try {
                ReplayBuffer<T> buf = this.bufferFactory.get();
                ReplaySubscriber<T> u = new ReplaySubscriber<>(buf, this.current);
                if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, ps, u)) {
                    ps = u;
                    break;
                }
            } finally {
                Exceptions.throwIfFatal(ex);
                RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(ex);
            }
        }
        boolean doConnect = !ps.shouldConnect.get() && ps.shouldConnect.compareAndSet(false, true);
        try {
            connection.accept(ps);
            if (doConnect) {
                this.source.subscribe((FlowableSubscriber) ps);
            }
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            if (doConnect) {
                ps.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        final AtomicReference<ReplaySubscriber<T>> current;
        boolean done;
        long requestedFromUpstream;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplaySubscriber(ReplayBuffer<T> buffer, AtomicReference<ReplaySubscriber<T>> current) {
            this.buffer = buffer;
            this.current = current;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, this, (Object) null);
            SubscriptionHelper.cancel(this);
        }

        boolean add(InnerSubscription<T> producer) {
            InnerSubscription<T>[] c;
            InnerSubscription<T>[] u;
            do {
                c = this.subscribers.get();
                if (c == TERMINATED) {
                    return false;
                }
                int len = c.length;
                u = new InnerSubscription[len + 1];
                System.arraycopy(c, 0, u, 0, len);
                u[len] = producer;
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, c, u));
            return true;
        }

        void remove(InnerSubscription<T> p) {
            InnerSubscription<T>[] c;
            InnerSubscription<T>[] u;
            do {
                c = this.subscribers.get();
                int len = c.length;
                if (len == 0) {
                    return;
                }
                int j2 = -1;
                int i = 0;
                while (true) {
                    if (i >= len) {
                        break;
                    } else if (!c[i].equals(p)) {
                        i++;
                    } else {
                        j2 = i;
                        break;
                    }
                }
                if (j2 < 0) {
                    return;
                }
                if (len == 1) {
                    u = EMPTY;
                } else {
                    InnerSubscription<T>[] u2 = new InnerSubscription[len - 1];
                    System.arraycopy(c, 0, u2, 0, j2);
                    System.arraycopy(c, j2 + 1, u2, j2, (len - j2) - 1);
                    u = u2;
                }
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, c, u));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription p) {
            InnerSubscription<T>[] innerSubscriptionArr;
            if (SubscriptionHelper.setOnce(this, p)) {
                manageRequests();
                for (InnerSubscription<T> rp : this.subscribers.get()) {
                    this.buffer.replay(rp);
                }
            }
        }

        public void onNext(T t) {
            InnerSubscription<T>[] innerSubscriptionArr;
            if (!this.done) {
                this.buffer.next(t);
                for (InnerSubscription<T> rp : this.subscribers.get()) {
                    this.buffer.replay(rp);
                }
            }
        }

        public void onError(Throwable e) {
            InnerSubscription<T>[] andSet;
            if (!this.done) {
                this.done = true;
                this.buffer.error(e);
                for (InnerSubscription<T> rp : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(rp);
                }
                return;
            }
            RxJavaPlugins.onError(e);
        }

        public void onComplete() {
            InnerSubscription<T>[] andSet;
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                for (InnerSubscription<T> rp : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(rp);
                }
            }
        }

        void manageRequests() {
            InnerSubscription<T>[] innerSubscriptionArr;
            AtomicInteger m = this.management;
            if (m.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            while (!isDisposed()) {
                Subscription p = get();
                if (p != null) {
                    long alreadyRequested = this.requestedFromUpstream;
                    long downstreamMaxRequest = alreadyRequested;
                    for (InnerSubscription<T> rp : this.subscribers.get()) {
                        downstreamMaxRequest = Math.max(downstreamMaxRequest, rp.totalRequested.get());
                    }
                    long diff = downstreamMaxRequest - alreadyRequested;
                    if (diff != 0) {
                        this.requestedFromUpstream = downstreamMaxRequest;
                        p.request(diff);
                    }
                }
                missed = m.addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> parent, Subscriber<? super T> child) {
            this.parent = parent;
            this.child = child;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.addCancel(this, n) != CANCELLED) {
                BackpressureHelper.add(this.totalRequested, n);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }

        public long produced(long n) {
            return BackpressureHelper.producedCancel(this, n);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == CANCELLED;
        }

        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (getAndSet(CANCELLED) != CANCELLED) {
                this.parent.remove(this);
                this.parent.manageRequests();
                this.index = null;
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

        UnboundedReplayBuffer(int capacityHint) {
            super(capacityHint);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T value) {
            add(NotificationLite.next(value));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable e) {
            add(NotificationLite.error(e));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> output) {
            synchronized (output) {
                if (output.emitting) {
                    output.missed = true;
                    return;
                }
                output.emitting = true;
                Subscriber<? super T> child = output.child;
                while (!output.isDisposed()) {
                    int sourceIndex = this.size;
                    Integer destinationIndexObject = (Integer) output.index();
                    int destinationIndex = destinationIndexObject != null ? destinationIndexObject.intValue() : 0;
                    long r = output.get();
                    long e = 0;
                    while (r != 0 && destinationIndex < sourceIndex) {
                        Object o = get(destinationIndex);
                        try {
                            if (NotificationLite.accept(o, child) || output.isDisposed()) {
                                return;
                            }
                            destinationIndex++;
                            r--;
                            e++;
                        } catch (Throwable err) {
                            Exceptions.throwIfFatal(err);
                            output.dispose();
                            if (!NotificationLite.isError(o) && !NotificationLite.isComplete(o)) {
                                child.onError(err);
                                return;
                            } else {
                                RxJavaPlugins.onError(err);
                                return;
                            }
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

        Node(Object value, long index) {
            this.value = value;
            this.index = index;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        final boolean eagerTruncate;
        long index;
        int size;
        Node tail;

        abstract void truncate();

        BoundedReplayBuffer(boolean eagerTruncate) {
            this.eagerTruncate = eagerTruncate;
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
            Node head2 = get();
            Node head3 = head2;
            if (head3.get() == null) {
                this.tail = head3;
            }
        }

        final void setFirst(Node n) {
            if (this.eagerTruncate) {
                Node m = new Node(null, n.index);
                m.lazySet(n.get());
                n = m;
            }
            set(n);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T value) {
            Object o = enterTransform(NotificationLite.next(value), false);
            long j2 = this.index + 1;
            this.index = j2;
            Node n = new Node(o, j2);
            addLast(n);
            truncate();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable e) {
            Object o = enterTransform(NotificationLite.error(e), true);
            long j2 = this.index + 1;
            this.index = j2;
            Node n = new Node(o, j2);
            addLast(n);
            truncateFinal();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object o = enterTransform(NotificationLite.complete(), true);
            long j2 = this.index + 1;
            this.index = j2;
            Node n = new Node(o, j2);
            addLast(n);
            truncateFinal();
        }

        final void trimHead() {
            Node head = get();
            if (head.value != null) {
                Node n = new Node(null, 0L);
                n.lazySet(head.get());
                set(n);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> output) {
            synchronized (output) {
                if (output.emitting) {
                    output.missed = true;
                    return;
                }
                output.emitting = true;
                while (true) {
                    long r = output.get();
                    boolean unbounded = r == Long.MAX_VALUE;
                    long e = 0;
                    Node node = (Node) output.index();
                    if (node == null) {
                        node = getHead();
                        output.index = node;
                        BackpressureHelper.add(output.totalRequested, node.index);
                    }
                    while (r != 0) {
                        if (output.isDisposed()) {
                            output.index = null;
                            return;
                        }
                        Node v = node.get();
                        if (v == null) {
                            break;
                        }
                        Object o = leaveTransform(v.value);
                        try {
                            if (NotificationLite.accept(o, output.child)) {
                                output.index = null;
                                return;
                            }
                            e++;
                            r--;
                            node = v;
                        } catch (Throwable err) {
                            Exceptions.throwIfFatal(err);
                            output.index = null;
                            output.dispose();
                            if (!NotificationLite.isError(o) && !NotificationLite.isComplete(o)) {
                                output.child.onError(err);
                                return;
                            } else {
                                RxJavaPlugins.onError(err);
                                return;
                            }
                        }
                    }
                    if (r == 0 && output.isDisposed()) {
                        output.index = null;
                        return;
                    }
                    if (e != 0) {
                        output.index = node;
                        if (!unbounded) {
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

        Object enterTransform(Object value, boolean terminal) {
            return value;
        }

        Object leaveTransform(Object value) {
            return value;
        }

        void truncateFinal() {
            trimHead();
        }

        final void collect(Collection<? super T> output) {
            Node n = getHead();
            while (true) {
                Node next = n.get();
                if (next != null) {
                    Object o = next.value;
                    Object v = leaveTransform(o);
                    if (!NotificationLite.isComplete(v) && !NotificationLite.isError(v)) {
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
            return this.tail.value != null && NotificationLite.isComplete(leaveTransform(this.tail.value));
        }

        Node getHead() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int limit, boolean eagerTruncate) {
            super(eagerTruncate);
            this.limit = limit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
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
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int limit, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
            super(eagerTruncate);
            this.scheduler = scheduler;
            this.limit = limit;
            this.maxAge = maxAge;
            this.unit = unit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object enterTransform(Object value, boolean terminal) {
            return new Timed(value, terminal ? Long.MAX_VALUE : this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object leaveTransform(Object value) {
            return ((Timed) value).value();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            long timeLimit = this.scheduler.now(this.unit) - this.maxAge;
            Node prev = (Node) get();
            Node next = prev.get();
            int e = 0;
            while (this.size > 1) {
                if (this.size > this.limit) {
                    e++;
                    this.size--;
                    prev = next;
                    next = next.get();
                } else {
                    Timed<?> v = (Timed) next.value;
                    if (v.time() > timeLimit) {
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

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncateFinal() {
            long timeLimit = this.scheduler.now(this.unit) - this.maxAge;
            Node prev = (Node) get();
            Node next = prev.get();
            int e = 0;
            while (this.size > 1) {
                Timed<?> v = (Timed) next.value;
                if (v.time() > timeLimit) {
                    break;
                }
                e++;
                this.size--;
                prev = next;
                next = next.get();
            }
            if (e != 0) {
                setFirst(prev);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node getHead() {
            long timeLimit = this.scheduler.now(this.unit) - this.maxAge;
            Node prev = (Node) get();
            for (Node next = prev.get(); next != null; next = next.get()) {
                Timed<?> v = (Timed) next.value;
                if (NotificationLite.isComplete(v.value()) || NotificationLite.isError(v.value()) || v.time() > timeLimit) {
                    break;
                }
                prev = next;
            }
            return prev;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Supplier<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        MulticastFlowable(Supplier<? extends ConnectableFlowable<U>> connectableFactory, Function<? super Flowable<U>, ? extends Publisher<R>> selector) {
            this.connectableFactory = connectableFactory;
            this.selector = selector;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        protected void subscribeActual(Subscriber<? super R> child) {
            try {
                ConnectableFlowable<U> cf = (ConnectableFlowable) ExceptionHelper.nullCheck(this.connectableFactory.get(), "The connectableFactory returned a null ConnectableFlowable.");
                try {
                    Publisher<R> observable = (Publisher) ExceptionHelper.nullCheck(this.selector.apply(cf), "The selector returned a null Publisher.");
                    SubscriberResourceWrapper<R> srw = new SubscriberResourceWrapper<>(child);
                    observable.subscribe(srw);
                    cf.connect(new DisposableConsumer(srw));
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    EmptySubscription.error(e, child);
                }
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                EmptySubscription.error(e2, child);
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            DisposableConsumer(SubscriberResourceWrapper<R> srw) {
                this.srw = srw;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(Disposable r) {
                this.srw.setResource(r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        final int bufferSize;
        final boolean eagerTruncate;

        ReplayBufferSupplier(int bufferSize, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public ReplayBuffer<T> get() {
            return new SizeBoundReplayBuffer(this.bufferSize, this.eagerTruncate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ScheduledReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        private final int bufferSize;
        final boolean eagerTruncate;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplayBufferSupplier(int bufferSize, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public ReplayBuffer<T> get() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler, this.eagerTruncate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Supplier<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> curr, Supplier<? extends ReplayBuffer<T>> bufferFactory) {
            this.curr = curr;
            this.bufferFactory = bufferFactory;
        }

        public void subscribe(Subscriber<? super T> child) {
            ReplaySubscriber<T> r;
            while (true) {
                r = this.curr.get();
                if (r != null) {
                    break;
                }
                try {
                    ReplayBuffer<T> buf = this.bufferFactory.get();
                    ReplaySubscriber<T> u = new ReplaySubscriber<>(buf, this.curr);
                    if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.curr, (Object) null, u)) {
                        r = u;
                        break;
                    }
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    EmptySubscription.error(ex, child);
                    return;
                }
            }
            InnerSubscription<T> inner = new InnerSubscription<>(r, child);
            child.onSubscribe(inner);
            r.add(inner);
            if (inner.isDisposed()) {
                r.remove(inner);
                return;
            }
            r.manageRequests();
            r.buffer.replay(inner);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DefaultUnboundedFactory implements Supplier<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() {
            return new UnboundedReplayBuffer(16);
        }
    }
}