package io.reactivex.rxjava3.internal.operators.observable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    static final BufferSupplier DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
    final BufferSupplier<T> bufferFactory;
    final AtomicReference<ReplayObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable e);

        void next(T value);

        void replay(InnerDisposable<T> output);
    }

    public static <U, R> Observable<R> multicastSelector(final Supplier<? extends ConnectableObservable<U>> connectableFactory, final Function<? super Observable<U>, ? extends ObservableSource<R>> selector) {
        return RxJavaPlugins.onAssembly(new MulticastReplay(connectableFactory, selector));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> source) {
        return create(source, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> source, final int bufferSize, boolean eagerTruncate) {
        if (bufferSize == Integer.MAX_VALUE) {
            return createFrom(source);
        }
        return create(source, new ReplayBufferSupplier(bufferSize, eagerTruncate));
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> source, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
        return create(source, maxAge, unit, scheduler, Integer.MAX_VALUE, eagerTruncate);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> source, final long maxAge, final TimeUnit unit, final Scheduler scheduler, final int bufferSize, boolean eagerTruncate) {
        return create(source, new ScheduledReplaySupplier(bufferSize, maxAge, unit, scheduler, eagerTruncate));
    }

    static <T> ConnectableObservable<T> create(ObservableSource<T> source, final BufferSupplier<T> bufferFactory) {
        AtomicReference<ReplayObserver<T>> curr = new AtomicReference<>();
        ObservableSource<T> onSubscribe = new ReplaySource<>(curr, bufferFactory);
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservableReplay(onSubscribe, source, curr, bufferFactory));
    }

    private ObservableReplay(ObservableSource<T> onSubscribe, ObservableSource<T> source, final AtomicReference<ReplayObserver<T>> current, final BufferSupplier<T> bufferFactory) {
        this.onSubscribe = onSubscribe;
        this.source = source;
        this.current = current;
        this.bufferFactory = bufferFactory;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void reset() {
        ReplayObserver<T> conn = this.current.get();
        if (conn != null && conn.isDisposed()) {
            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, conn, (Object) null);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> connection) {
        ReplayObserver<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isDisposed()) {
                break;
            }
            ReplayBuffer<T> buf = this.bufferFactory.call();
            ReplayObserver<T> u = new ReplayObserver<>(buf, this.current);
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, ps, u)) {
                ps = u;
                break;
            }
        }
        boolean doConnect = !ps.shouldConnect.get() && ps.shouldConnect.compareAndSet(false, true);
        try {
            connection.accept(ps);
            if (doConnect) {
                this.source.subscribe(ps);
            }
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            if (doConnect) {
                ps.shouldConnect.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal(ex);
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        final ReplayBuffer<T> buffer;
        final AtomicReference<ReplayObserver<T>> current;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplayObserver(ReplayBuffer<T> buffer, AtomicReference<ReplayObserver<T>> current) {
            this.buffer = buffer;
            this.current = current;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.observers.set(TERMINATED);
            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, this, (Object) null);
            DisposableHelper.dispose(this);
        }

        boolean add(InnerDisposable<T> producer) {
            InnerDisposable[] c;
            InnerDisposable[] u;
            do {
                c = this.observers.get();
                if (c == TERMINATED) {
                    return false;
                }
                int len = c.length;
                u = new InnerDisposable[len + 1];
                System.arraycopy(c, 0, u, 0, len);
                u[len] = producer;
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, c, u));
            return true;
        }

        void remove(InnerDisposable<T> producer) {
            InnerDisposable[] c;
            InnerDisposable[] u;
            do {
                c = this.observers.get();
                int len = c.length;
                if (len == 0) {
                    return;
                }
                int j2 = -1;
                int i = 0;
                while (true) {
                    if (i >= len) {
                        break;
                    } else if (!c[i].equals(producer)) {
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
                    InnerDisposable[] u2 = new InnerDisposable[len - 1];
                    System.arraycopy(c, 0, u2, 0, j2);
                    System.arraycopy(c, j2 + 1, u2, j2, (len - j2) - 1);
                    u = u2;
                }
            } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, c, u));
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable p) {
            if (DisposableHelper.setOnce(this, p)) {
                replay();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(e);
                replayFinal();
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                replayFinal();
            }
        }

        void replay() {
            InnerDisposable<T>[] a = this.observers.get();
            for (InnerDisposable<T> rp : a) {
                this.buffer.replay(rp);
            }
        }

        void replayFinal() {
            InnerDisposable<T>[] a = this.observers.getAndSet(TERMINATED);
            for (InnerDisposable<T> rp : a) {
                this.buffer.replay(rp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final Observer<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        InnerDisposable(ReplayObserver<T> parent, Observer<? super T> child) {
            this.parent = parent;
            this.child = child;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.remove(this);
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

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void next(T value) {
            add(NotificationLite.next(value));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void error(Throwable e) {
            add(NotificationLite.error(e));
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void replay(InnerDisposable<T> output) {
            if (output.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> child = output.child;
            int missed = 1;
            while (!output.isDisposed()) {
                int sourceIndex = this.size;
                Integer destinationIndexObject = (Integer) output.index();
                int destinationIndex = destinationIndexObject != null ? destinationIndexObject.intValue() : 0;
                while (destinationIndex < sourceIndex) {
                    Object o = get(destinationIndex);
                    if (NotificationLite.accept(o, child) || output.isDisposed()) {
                        return;
                    }
                    destinationIndex++;
                }
                output.index = Integer.valueOf(destinationIndex);
                missed = output.addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        Node(Object value) {
            this.value = value;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        final boolean eagerTruncate;
        int size;
        Node tail;

        abstract void truncate();

        BoundedReplayBuffer(boolean eagerTruncate) {
            this.eagerTruncate = eagerTruncate;
            Node n = new Node(null);
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
            this.size--;
            setFirst(next);
        }

        final void trimHead() {
            Node head = get();
            if (head.value != null) {
                Node n = new Node(null);
                n.lazySet(head.get());
                set(n);
            }
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
                Node m = new Node(null);
                m.lazySet(n.get());
                n = m;
            }
            set(n);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T value) {
            Object o = enterTransform(NotificationLite.next(value));
            Node n = new Node(o);
            addLast(n);
            truncate();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable e) {
            Object o = enterTransform(NotificationLite.error(e));
            Node n = new Node(o);
            addLast(n);
            truncateFinal();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            Object o = enterTransform(NotificationLite.complete());
            Node n = new Node(o);
            addLast(n);
            truncateFinal();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> output) {
            if (output.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            do {
                Node node = (Node) output.index();
                if (node == null) {
                    node = getHead();
                    output.index = node;
                }
                while (!output.isDisposed()) {
                    Node v = node.get();
                    if (v != null) {
                        Object o = leaveTransform(v.value);
                        if (NotificationLite.accept(o, output.child)) {
                            output.index = null;
                            return;
                        }
                        node = v;
                    } else {
                        output.index = node;
                        missed = output.addAndGet(-missed);
                    }
                }
                output.index = null;
                return;
            } while (missed != 0);
        }

        Object enterTransform(Object value) {
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

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int limit, boolean eagerTruncate) {
            super(eagerTruncate);
            this.limit = limit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
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

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object enterTransform(Object value) {
            return new Timed(value, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object leaveTransform(Object value) {
            return ((Timed) value).value();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DisposeConsumer<R> implements Consumer<Disposable> {
        private final ObserverResourceWrapper<R> srw;

        DisposeConsumer(ObserverResourceWrapper<R> srw) {
            this.srw = srw;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable r) {
            this.srw.setResource(r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        final int bufferSize;
        final boolean eagerTruncate;

        ReplayBufferSupplier(int bufferSize, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize, this.eagerTruncate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        private final int bufferSize;
        final boolean eagerTruncate;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplaySupplier(int bufferSize, long maxAge, TimeUnit unit, Scheduler scheduler, boolean eagerTruncate) {
            this.bufferSize = bufferSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            this.eagerTruncate = eagerTruncate;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler, this.eagerTruncate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplaySource<T> implements ObservableSource<T> {
        private final BufferSupplier<T> bufferFactory;
        private final AtomicReference<ReplayObserver<T>> curr;

        ReplaySource(AtomicReference<ReplayObserver<T>> curr, BufferSupplier<T> bufferFactory) {
            this.curr = curr;
            this.bufferFactory = bufferFactory;
        }

        @Override // io.reactivex.rxjava3.core.ObservableSource
        public void subscribe(Observer<? super T> child) {
            ReplayObserver<T> r;
            while (true) {
                r = this.curr.get();
                if (r != null) {
                    break;
                }
                ReplayBuffer<T> buf = this.bufferFactory.call();
                ReplayObserver<T> u = new ReplayObserver<>(buf, this.curr);
                if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.curr, (Object) null, u)) {
                    r = u;
                    break;
                }
            }
            InnerDisposable<T> inner = new InnerDisposable<>(r, child);
            child.onSubscribe(inner);
            r.add(inner);
            if (inner.isDisposed()) {
                r.remove(inner);
            } else {
                r.buffer.replay(inner);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MulticastReplay<R, U> extends Observable<R> {
        private final Supplier<? extends ConnectableObservable<U>> connectableFactory;
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

        MulticastReplay(Supplier<? extends ConnectableObservable<U>> connectableFactory, Function<? super Observable<U>, ? extends ObservableSource<R>> selector) {
            this.connectableFactory = connectableFactory;
            this.selector = selector;
        }

        @Override // io.reactivex.rxjava3.core.Observable
        protected void subscribeActual(Observer<? super R> child) {
            try {
                ConnectableObservable<U> co = (ConnectableObservable) Objects.requireNonNull(this.connectableFactory.get(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource<R> observable = (ObservableSource) Objects.requireNonNull(this.selector.apply(co), "The selector returned a null ObservableSource");
                ObserverResourceWrapper<R> srw = new ObserverResourceWrapper<>(child);
                observable.subscribe(srw);
                co.connect(new DisposeConsumer<>(srw));
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                EmptyDisposable.error(e, child);
            }
        }
    }
}