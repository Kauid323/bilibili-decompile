package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class ReplaySubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    final ReplayState<T> state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void drain(ReplayProducer<T> replayProducer);

        Throwable error();

        void error(Throwable th);

        boolean isComplete();

        boolean isEmpty();

        T last();

        void next(T t);

        int size();

        T[] toArray(T[] tArr);
    }

    public static <T> ReplaySubject<T> create() {
        return create(16);
    }

    public static <T> ReplaySubject<T> create(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity > 0 required but it was " + capacity);
        }
        ReplayBuffer<T> buffer = new ReplayUnboundedBuffer<>(capacity);
        ReplayState<T> state = new ReplayState<>(buffer);
        return new ReplaySubject<>(state);
    }

    static <T> ReplaySubject<T> createUnbounded() {
        ReplayBuffer<T> buffer = new ReplaySizeBoundBuffer<>(FlowControlConfig.RETRY_MAX_TIMES);
        ReplayState<T> state = new ReplayState<>(buffer);
        return new ReplaySubject<>(state);
    }

    static <T> ReplaySubject<T> createUnboundedTime() {
        ReplayBuffer<T> buffer = new ReplaySizeAndTimeBoundBuffer<>(FlowControlConfig.RETRY_MAX_TIMES, Long.MAX_VALUE, Schedulers.immediate());
        ReplayState<T> state = new ReplayState<>(buffer);
        return new ReplaySubject<>(state);
    }

    public static <T> ReplaySubject<T> createWithSize(int size) {
        ReplayBuffer<T> buffer = new ReplaySizeBoundBuffer<>(size);
        ReplayState<T> state = new ReplayState<>(buffer);
        return new ReplaySubject<>(state);
    }

    public static <T> ReplaySubject<T> createWithTime(long time, TimeUnit unit, Scheduler scheduler) {
        return createWithTimeAndSize(time, unit, FlowControlConfig.RETRY_MAX_TIMES, scheduler);
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long time, TimeUnit unit, int size, Scheduler scheduler) {
        ReplayBuffer<T> buffer = new ReplaySizeAndTimeBoundBuffer<>(size, unit.toMillis(time), scheduler);
        ReplayState<T> state = new ReplayState<>(buffer);
        return new ReplaySubject<>(state);
    }

    ReplaySubject(ReplayState<T> state) {
        super(state);
        this.state = state;
    }

    public void onNext(T t) {
        this.state.onNext(t);
    }

    public void onError(Throwable e) {
        this.state.onError(e);
    }

    public void onCompleted() {
        this.state.onCompleted();
    }

    int subscriberCount() {
        return this.state.get().length;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.state.isTerminated() && this.state.buffer.error() != null;
    }

    public boolean hasCompleted() {
        return this.state.isTerminated() && this.state.buffer.error() == null;
    }

    public Throwable getThrowable() {
        if (this.state.isTerminated()) {
            return this.state.buffer.error();
        }
        return null;
    }

    public int size() {
        return this.state.buffer.size();
    }

    public boolean hasAnyValue() {
        return !this.state.buffer.isEmpty();
    }

    public boolean hasValue() {
        return hasAnyValue();
    }

    public T[] getValues(T[] a) {
        return this.state.buffer.toArray(a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        T[] r = getValues(EMPTY_ARRAY);
        if (r == EMPTY_ARRAY) {
            return new Object[0];
        }
        return r;
    }

    public T getValue() {
        return this.state.buffer.last();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReplayState<T> extends AtomicReference<ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        static final ReplayProducer[] EMPTY = new ReplayProducer[0];
        static final ReplayProducer[] TERMINATED = new ReplayProducer[0];
        private static final long serialVersionUID = 5952362471246910544L;
        final ReplayBuffer<T> buffer;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public ReplayState(ReplayBuffer<T> buffer) {
            this.buffer = buffer;
            lazySet(EMPTY);
        }

        public void call(Subscriber<? super T> t) {
            ReplayProducer<T> rp = new ReplayProducer<>(t, this);
            t.add(rp);
            t.setProducer(rp);
            if (add(rp) && rp.isUnsubscribed()) {
                remove(rp);
            } else {
                this.buffer.drain(rp);
            }
        }

        boolean add(ReplayProducer<T> rp) {
            ReplayProducer<T>[] a;
            ReplayProducer<T>[] b;
            do {
                a = get();
                if (a == TERMINATED) {
                    return false;
                }
                int n = a.length;
                b = new ReplayProducer[n + 1];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = rp;
            } while (!compareAndSet(a, b));
            return true;
        }

        void remove(ReplayProducer<T> rp) {
            ReplayProducer<T>[] a;
            ReplayProducer<T>[] b;
            do {
                a = get();
                if (a == TERMINATED || a == EMPTY) {
                    return;
                }
                int n = a.length;
                int j = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (a[i] != rp) {
                        i++;
                    } else {
                        j = i;
                        break;
                    }
                }
                if (j < 0) {
                    return;
                }
                if (n == 1) {
                    b = EMPTY;
                } else {
                    ReplayProducer<T>[] b2 = new ReplayProducer[n - 1];
                    System.arraycopy(a, 0, b2, 0, j);
                    System.arraycopy(a, j + 1, b2, j, (n - j) - 1);
                    b = b2;
                }
            } while (!compareAndSet(a, b));
        }

        public void onNext(T t) {
            ReplayBuffer<T> b = this.buffer;
            b.next(t);
            ReplayProducer<T>[] arr$ = get();
            for (ReplayProducer<T> rp : arr$) {
                b.drain(rp);
            }
        }

        public void onError(Throwable e) {
            ReplayBuffer<T> b = this.buffer;
            b.error(e);
            List<Throwable> errors = null;
            ReplayProducer<T>[] arr$ = getAndSet(TERMINATED);
            for (ReplayProducer<T> rp : arr$) {
                try {
                    b.drain(rp);
                } catch (Throwable ex) {
                    if (errors == null) {
                        errors = new ArrayList<>();
                    }
                    errors.add(ex);
                }
            }
            Exceptions.throwIfAny(errors);
        }

        public void onCompleted() {
            ReplayBuffer<T> b = this.buffer;
            b.complete();
            ReplayProducer<T>[] arr$ = getAndSet(TERMINATED);
            for (ReplayProducer<T> rp : arr$) {
                b.drain(rp);
            }
        }

        boolean isTerminated() {
            return get() == TERMINATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReplayUnboundedBuffer<T> implements ReplayBuffer<T> {
        final int capacity;
        volatile boolean done;
        Throwable error;
        final Object[] head;
        volatile int size;
        Object[] tail;
        int tailIndex;

        public ReplayUnboundedBuffer(int capacity) {
            this.capacity = capacity;
            Object[] objArr = new Object[capacity + 1];
            this.head = objArr;
            this.tail = objArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            if (this.done) {
                return;
            }
            int i = this.tailIndex;
            Object[] a = this.tail;
            if (i == a.length - 1) {
                Object[] b = new Object[a.length];
                b[0] = t;
                this.tailIndex = 1;
                a[i] = b;
                this.tail = b;
            } else {
                a[i] = t;
                this.tailIndex = i + 1;
            }
            this.size++;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable e) {
            if (this.done) {
                RxJavaHooks.onError(e);
                return;
            }
            this.error = e;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> rp) {
            if (rp.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super T> a = rp.actual;
            int n = this.capacity;
            do {
                long r = rp.requested.get();
                long e = 0;
                Object[] node = (Object[]) rp.node;
                if (node == null) {
                    node = this.head;
                }
                int tailIndex = rp.tailIndex;
                int index = rp.index;
                while (e != r) {
                    if (a.isUnsubscribed()) {
                        rp.node = null;
                        return;
                    }
                    boolean d = this.done;
                    boolean empty = index == this.size;
                    if (d && empty) {
                        rp.node = null;
                        Throwable ex = this.error;
                        if (ex != null) {
                            a.onError(ex);
                            return;
                        } else {
                            a.onCompleted();
                            return;
                        }
                    } else if (empty) {
                        break;
                    } else {
                        if (tailIndex == n) {
                            node = (Object[]) node[tailIndex];
                            tailIndex = 0;
                        }
                        a.onNext(node[tailIndex]);
                        e++;
                        tailIndex++;
                        index++;
                    }
                }
                if (e == r) {
                    if (a.isUnsubscribed()) {
                        rp.node = null;
                        return;
                    }
                    boolean d2 = this.done;
                    boolean empty2 = index == this.size;
                    if (d2 && empty2) {
                        rp.node = null;
                        Throwable ex2 = this.error;
                        if (ex2 != null) {
                            a.onError(ex2);
                            return;
                        } else {
                            a.onCompleted();
                            return;
                        }
                    }
                }
                if (e != 0 && r != Long.MAX_VALUE) {
                    BackpressureUtils.produced(rp.requested, e);
                }
                rp.index = index;
                rp.tailIndex = tailIndex;
                rp.node = node;
                missed = rp.addAndGet(-missed);
            } while (missed != 0);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            int s = this.size;
            if (s == 0) {
                return null;
            }
            Object[] h = this.head;
            int n = this.capacity;
            while (s >= n) {
                h = (Object[]) h[n];
                s -= n;
            }
            return (T) h[s - 1];
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] a) {
            int s = this.size;
            if (a.length < s) {
                a = (T[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), s));
            }
            Object[] h = this.head;
            int n = this.capacity;
            int j = 0;
            while (j + n < s) {
                System.arraycopy(h, 0, a, j, n);
                j += n;
                h = (Object[]) h[n];
            }
            System.arraycopy(h, 0, a, j, s - j);
            if (a.length > s) {
                a[s] = null;
            }
            return a;
        }
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class ReplaySizeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int limit;
        int size;
        Node<T> tail;

        public ReplaySizeBoundBuffer(int limit) {
            this.limit = limit;
            Node<T> n = new Node<>(null);
            this.tail = n;
            this.head = n;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T value) {
            Node<T> n = new Node<>(value);
            this.tail.set(n);
            this.tail = n;
            int s = this.size;
            if (s == this.limit) {
                this.head = this.head.get();
            } else {
                this.size = s + 1;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> rp) {
            if (rp.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> a = rp.actual;
            int missed = 1;
            do {
                long r = rp.requested.get();
                long e = 0;
                Node<T> node = (Node) rp.node;
                if (node == null) {
                    node = this.head;
                }
                while (true) {
                    if (e == r) {
                        break;
                    } else if (a.isUnsubscribed()) {
                        rp.node = null;
                        return;
                    } else {
                        boolean d = this.done;
                        Node<T> next = node.get();
                        boolean empty = next == null;
                        if (d && empty) {
                            rp.node = null;
                            Throwable ex = this.error;
                            if (ex != null) {
                                a.onError(ex);
                                return;
                            } else {
                                a.onCompleted();
                                return;
                            }
                        } else if (empty) {
                            break;
                        } else {
                            a.onNext(next.value);
                            e++;
                            node = next;
                        }
                    }
                }
                if (e == r) {
                    if (a.isUnsubscribed()) {
                        rp.node = null;
                        return;
                    }
                    boolean d2 = this.done;
                    boolean empty2 = node.get() == null;
                    if (d2 && empty2) {
                        rp.node = null;
                        Throwable ex2 = this.error;
                        if (ex2 != null) {
                            a.onError(ex2);
                            return;
                        } else {
                            a.onCompleted();
                            return;
                        }
                    }
                }
                if (e != 0 && r != Long.MAX_VALUE) {
                    BackpressureUtils.produced(rp.requested, e);
                }
                rp.node = node;
                missed = rp.addAndGet(-missed);
            } while (missed != 0);
        }

        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final T value;

            public Node(T value) {
                this.value = value;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            Node<T> h = this.head;
            while (true) {
                Node<T> n = h.get();
                if (n != null) {
                    h = n;
                } else {
                    return h.value;
                }
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int s = 0;
            Node<T> n = this.head.get();
            while (n != null && s != Integer.MAX_VALUE) {
                n = n.get();
                s++;
            }
            return s;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.head.get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] a) {
            List<T> list = new ArrayList<>();
            for (Node<T> n = this.head.get(); n != null; n = n.get()) {
                list.add(n.value);
            }
            return (T[]) list.toArray(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReplaySizeAndTimeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final int limit;
        final long maxAgeMillis;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;

        public ReplaySizeAndTimeBoundBuffer(int limit, long maxAgeMillis, Scheduler scheduler) {
            this.limit = limit;
            TimedNode<T> n = new TimedNode<>(null, 0L);
            this.tail = n;
            this.head = n;
            this.maxAgeMillis = maxAgeMillis;
            this.scheduler = scheduler;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T value) {
            long now = this.scheduler.now();
            TimedNode<T> n = new TimedNode<>(value, now);
            this.tail.set(n);
            this.tail = n;
            long now2 = now - this.maxAgeMillis;
            int s = this.size;
            TimedNode<T> h0 = this.head;
            TimedNode<T> h = h0;
            if (s == this.limit) {
                h = h.get();
            } else {
                s++;
            }
            while (true) {
                TimedNode<T> n2 = h.get();
                if (n2 == null || n2.timestamp > now2) {
                    break;
                }
                h = n2;
                s--;
            }
            this.size = s;
            if (h != h0) {
                this.head = h;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable ex) {
            evictFinal();
            this.error = ex;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            evictFinal();
            this.done = true;
        }

        void evictFinal() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> h0 = this.head;
            TimedNode<T> h = h0;
            while (true) {
                TimedNode<T> n = h.get();
                if (n == null || n.timestamp > now) {
                    break;
                }
                h = n;
            }
            if (h0 != h) {
                this.head = h;
            }
        }

        TimedNode<T> latestHead() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> h = this.head;
            while (true) {
                TimedNode<T> n = h.get();
                if (n == null || n.timestamp > now) {
                    break;
                }
                h = n;
            }
            return h;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
            if (r4 != r2) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
            if (r0.isUnsubscribed() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
            r14.node = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
            r7 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
            if (r6.get() != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
            if (r7 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
            if (r8 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
            r14.node = null;
            r9 = r13.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
            if (r9 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
            r0.onError(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
            r0.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0080, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
            if (r4 == 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x008e, code lost:
            if (r2 == Long.MAX_VALUE) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
            rx.internal.operators.BackpressureUtils.produced(r14.requested, r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
            r14.node = r6;
            r1 = r14.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
            return;
         */
        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain(ReplayProducer<T> rp) {
            if (rp.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> a = rp.actual;
            int missed = 1;
            do {
                long r = rp.requested.get();
                long e = 0;
                TimedNode<T> node = (TimedNode) rp.node;
                if (node == null) {
                    node = latestHead();
                }
                while (true) {
                    boolean empty = true;
                    if (e == r) {
                        break;
                    } else if (a.isUnsubscribed()) {
                        rp.node = null;
                        return;
                    } else {
                        boolean d = this.done;
                        TimedNode<T> next = node.get();
                        boolean empty2 = next == null;
                        if (d && empty2) {
                            rp.node = null;
                            Throwable ex = this.error;
                            if (ex != null) {
                                a.onError(ex);
                                return;
                            } else {
                                a.onCompleted();
                                return;
                            }
                        } else if (empty2) {
                            break;
                        } else {
                            a.onNext(next.value);
                            e++;
                            node = next;
                        }
                    }
                }
            } while (missed != 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final long timestamp;
            final T value;

            public TimedNode(T value, long timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            TimedNode<T> h = latestHead();
            while (true) {
                TimedNode<T> n = h.get();
                if (n != null) {
                    h = n;
                } else {
                    return h.value;
                }
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int s = 0;
            TimedNode<T> n = latestHead().get();
            while (n != null && s != Integer.MAX_VALUE) {
                n = n.get();
                s++;
            }
            return s;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return latestHead().get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] a) {
            List<T> list = new ArrayList<>();
            for (TimedNode<T> n = latestHead().get(); n != null; n = n.get()) {
                list.add(n.value);
            }
            return (T[]) list.toArray(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        final Subscriber<? super T> actual;
        int index;
        Object node;
        final AtomicLong requested = new AtomicLong();
        final ReplayState<T> state;
        int tailIndex;

        public ReplayProducer(Subscriber<? super T> actual, ReplayState<T> state) {
            this.actual = actual;
            this.state = state;
        }

        public void unsubscribe() {
            this.state.remove(this);
        }

        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        public void request(long n) {
            if (n > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                this.state.buffer.drain(this);
            } else if (n < 0) {
                throw new IllegalArgumentException("n >= required but it was " + n);
            }
        }
    }
}