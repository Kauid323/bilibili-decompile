package io.reactivex.rxjava3.subjects;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject<T> extends Subject<T> {
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplayDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
    static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
    static final ReplayDisposable[] TERMINATED = new ReplayDisposable[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface ReplayBuffer<T> {
        void add(T value);

        void addFinal(Object notificationLite);

        boolean compareAndSet(Object expected, Object next);

        Object get();

        T getValue();

        T[] getValues(T[] array);

        void replay(ReplayDisposable<T> rs);

        int size();

        void trimHead();
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create(int capacityHint) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new ReplaySubject<>(new UnboundedReplayBuffer(capacityHint));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithSize(int maxSize) {
        ObjectHelper.verifyPositive(maxSize, "maxSize");
        return new ReplaySubject<>(new SizeBoundReplayBuffer(maxSize));
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTime(long maxAge, TimeUnit unit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, maxAge, unit, scheduler));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTimeAndSize(long maxAge, TimeUnit unit, Scheduler scheduler, int maxSize) {
        ObjectHelper.verifyPositive(maxSize, "maxSize");
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(maxSize, maxAge, unit, scheduler));
    }

    ReplaySubject(ReplayBuffer<T> buffer) {
        this.buffer = buffer;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> rs = new ReplayDisposable<>(observer, this);
        observer.onSubscribe(rs);
        if (add(rs) && rs.cancelled) {
            remove(rs);
        } else {
            this.buffer.replay(rs);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable d) {
        if (this.done) {
            d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ReplayDisposable<T>[] replayDisposableArr;
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.done) {
            return;
        }
        ReplayBuffer<T> b = this.buffer;
        b.add(t);
        for (ReplayDisposable<T> rs : this.observers.get()) {
            b.replay(rs);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        ReplayDisposable<T>[] terminate;
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.done = true;
        Object o = NotificationLite.error(t);
        ReplayBuffer<T> b = this.buffer;
        b.addFinal(o);
        for (ReplayDisposable<T> rs : terminate(o)) {
            b.replay(rs);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        ReplayDisposable<T>[] terminate;
        if (this.done) {
            return;
        }
        this.done = true;
        Object o = NotificationLite.complete();
        ReplayBuffer<T> b = this.buffer;
        b.addFinal(o);
        for (ReplayDisposable<T> rs : terminate(o)) {
            b.replay(rs);
        }
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    @CheckReturnValue
    int observerCount() {
        return this.observers.get().length;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public Throwable getThrowable() {
        Object o = this.buffer.get();
        if (NotificationLite.isError(o)) {
            return NotificationLite.getError(o);
        }
        return null;
    }

    @CheckReturnValue
    public T getValue() {
        return this.buffer.getValue();
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public Object[] getValues() {
        T[] b = getValues(EMPTY_ARRAY);
        if (b == EMPTY_ARRAY) {
            return new Object[0];
        }
        return b;
    }

    @CheckReturnValue
    public T[] getValues(T[] array) {
        return this.buffer.getValues(array);
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        Object o = this.buffer.get();
        return NotificationLite.isComplete(o);
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        Object o = this.buffer.get();
        return NotificationLite.isError(o);
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    @CheckReturnValue
    int size() {
        return this.buffer.size();
    }

    boolean add(ReplayDisposable<T> rs) {
        ReplayDisposable<T>[] a;
        ReplayDisposable<T>[] b;
        do {
            a = this.observers.get();
            if (a == TERMINATED) {
                return false;
            }
            int len = a.length;
            b = new ReplayDisposable[len + 1];
            System.arraycopy(a, 0, b, 0, len);
            b[len] = rs;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, a, b));
        return true;
    }

    void remove(ReplayDisposable<T> rs) {
        ReplayDisposable<T>[] a;
        ReplayDisposable<T>[] b;
        do {
            a = this.observers.get();
            if (a == TERMINATED || a == EMPTY) {
                return;
            }
            int len = a.length;
            int j2 = -1;
            int i = 0;
            while (true) {
                if (i >= len) {
                    break;
                } else if (a[i] != rs) {
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
                b = EMPTY;
            } else {
                ReplayDisposable<T>[] b2 = new ReplayDisposable[len - 1];
                System.arraycopy(a, 0, b2, 0, j2);
                System.arraycopy(a, j2 + 1, b2, j2, (len - j2) - 1);
                b = b2;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, a, b));
    }

    ReplayDisposable<T>[] terminate(Object terminalValue) {
        this.buffer.compareAndSet(null, terminalValue);
        return this.observers.getAndSet(TERMINATED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        Object index;
        final ReplaySubject<T> state;

        ReplayDisposable(Observer<? super T> actual, ReplaySubject<T> state) {
            this.downstream = actual;
            this.state = state;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        UnboundedReplayBuffer(int capacityHint) {
            this.buffer = new ArrayList(capacityHint);
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void add(T value) {
            this.buffer.add(value);
            this.size++;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object notificationLite) {
            this.buffer.add(notificationLite);
            trimHead();
            this.size++;
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public T getValue() {
            int s = this.size;
            if (s == 0) {
                return null;
            }
            List<Object> b = this.buffer;
            T t = (T) b.get(s - 1);
            if (NotificationLite.isComplete(t) || NotificationLite.isError(t)) {
                if (s == 1) {
                    return null;
                }
                return (T) b.get(s - 2);
            }
            return t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] array) {
            int s = this.size;
            if (s == 0) {
                if (array.length != 0) {
                    array[0] = null;
                }
                return array;
            }
            List<Object> b = this.buffer;
            Object o = b.get(s - 1);
            if ((NotificationLite.isComplete(o) || NotificationLite.isError(o)) && s - 1 == 0) {
                if (array.length != 0) {
                    array[0] = null;
                }
                return array;
            }
            if (array.length < s) {
                array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), s));
            }
            for (int i = 0; i < s; i++) {
                array[i] = b.get(i);
            }
            int i2 = array.length;
            if (i2 > s) {
                array[s] = null;
            }
            return array;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> rs) {
            int index;
            if (rs.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            List<Object> b = this.buffer;
            Observer<? super T> a = rs.downstream;
            Integer indexObject = (Integer) rs.index;
            if (indexObject != null) {
                index = indexObject.intValue();
            } else {
                index = 0;
                rs.index = 0;
            }
            while (!rs.cancelled) {
                int s = this.size;
                while (s != index) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    Object o = b.get(index);
                    if (this.done && index + 1 == s && index + 1 == (s = this.size)) {
                        if (NotificationLite.isComplete(o)) {
                            a.onComplete();
                        } else {
                            a.onError(NotificationLite.getError(o));
                        }
                        rs.index = null;
                        rs.cancelled = true;
                        return;
                    }
                    a.onNext(o);
                    index++;
                }
                if (index == this.size) {
                    rs.index = Integer.valueOf(index);
                    missed = rs.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            rs.index = null;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int s = this.size;
            if (s != 0) {
                Object o = this.buffer.get(s - 1);
                if (NotificationLite.isComplete(o) || NotificationLite.isError(o)) {
                    return s - 1;
                }
                return s;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T value) {
            this.value = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T value, long time) {
            this.value = value;
            this.time = time;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        SizeBoundReplayBuffer(int maxSize) {
            this.maxSize = maxSize;
            Node<Object> h = new Node<>(null);
            this.tail = h;
            this.head = h;
        }

        void trim() {
            if (this.size > this.maxSize) {
                this.size--;
                Node<Object> h = this.head;
                this.head = h.get();
            }
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void add(T value) {
            Node<Object> n = new Node<>(value);
            Node<Object> t = this.tail;
            this.tail = n;
            this.size++;
            t.set(n);
            trim();
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object notificationLite) {
            Node<Object> n = new Node<>(notificationLite);
            Node<Object> t = this.tail;
            this.tail = n;
            this.size++;
            t.lazySet(n);
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Node<Object> h = this.head;
            if (h.value != null) {
                Node<Object> n = new Node<>(null);
                n.lazySet(h.get());
                this.head = n;
            }
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public T getValue() {
            Node<Object> prev = null;
            Node<Object> h = this.head;
            while (true) {
                Node<Object> next = h.get();
                if (next == null) {
                    break;
                }
                prev = h;
                h = next;
            }
            T t = (T) h.value;
            if (t == null) {
                return null;
            }
            if (NotificationLite.isComplete(t) || NotificationLite.isError(t)) {
                return (T) prev.value;
            }
            return t;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] array) {
            Node<Object> h = this.head;
            int s = size();
            if (s == 0) {
                if (array.length != 0) {
                    array[0] = null;
                }
            } else {
                if (array.length < s) {
                    array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), s));
                }
                int i = 0;
                while (i != s) {
                    Node<Object> next = h.get();
                    array[i] = next.value;
                    i++;
                    h = next;
                }
                if (array.length > s) {
                    array[s] = null;
                }
            }
            return array;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> rs) {
            if (rs.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Observer<? super T> a = rs.downstream;
            Node<Object> index = (Node) rs.index;
            if (index == null) {
                index = this.head;
            }
            while (!rs.cancelled) {
                Node<Object> n = index.get();
                if (n != null) {
                    Object o = (T) n.value;
                    if (this.done && n.get() == null) {
                        if (NotificationLite.isComplete(o)) {
                            a.onComplete();
                        } else {
                            a.onError(NotificationLite.getError(o));
                        }
                        rs.index = null;
                        rs.cancelled = true;
                        return;
                    }
                    a.onNext(o);
                    index = n;
                } else if (index.get() != null) {
                    continue;
                } else {
                    rs.index = index;
                    missed = rs.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            rs.index = null;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int s = 0;
            Node<Object> h = this.head;
            while (s != Integer.MAX_VALUE) {
                Node<Object> next = h.get();
                if (next == null) {
                    Object o = h.value;
                    if (NotificationLite.isComplete(o) || NotificationLite.isError(o)) {
                        return s - 1;
                    }
                    return s;
                }
                s++;
                h = next;
            }
            return s;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int maxSize, long maxAge, TimeUnit unit, Scheduler scheduler) {
            this.maxSize = maxSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            TimedNode<Object> h = new TimedNode<>(null, 0L);
            this.tail = h;
            this.head = h;
        }

        void trim() {
            if (this.size > this.maxSize) {
                this.size--;
                TimedNode<Object> h = this.head;
                this.head = h.get();
            }
            long limit = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> h2 = this.head;
            while (this.size > 1) {
                TimedNode<Object> next = h2.get();
                if (next.time > limit) {
                    this.head = h2;
                    return;
                } else {
                    h2 = next;
                    this.size--;
                }
            }
            this.head = h2;
        }

        void trimFinal() {
            long limit = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> h = this.head;
            while (true) {
                TimedNode<Object> next = h.get();
                if (next.get() == null) {
                    if (h.value != null) {
                        TimedNode<Object> lasth = new TimedNode<>(null, 0L);
                        lasth.lazySet(h.get());
                        this.head = lasth;
                        return;
                    }
                    this.head = h;
                    return;
                } else if (next.time > limit) {
                    if (h.value != null) {
                        TimedNode<Object> lasth2 = new TimedNode<>(null, 0L);
                        lasth2.lazySet(h.get());
                        this.head = lasth2;
                        return;
                    }
                    this.head = h;
                    return;
                } else {
                    h = next;
                }
            }
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void add(T value) {
            TimedNode<Object> n = new TimedNode<>(value, this.scheduler.now(this.unit));
            TimedNode<Object> t = this.tail;
            this.tail = n;
            this.size++;
            t.set(n);
            trim();
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object notificationLite) {
            TimedNode<Object> n = new TimedNode<>(notificationLite, Long.MAX_VALUE);
            TimedNode<Object> t = this.tail;
            this.tail = n;
            this.size++;
            t.lazySet(n);
            trimFinal();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            TimedNode<Object> h = this.head;
            if (h.value != null) {
                TimedNode<Object> n = new TimedNode<>(null, 0L);
                n.lazySet(h.get());
                this.head = n;
            }
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public T getValue() {
            T t;
            TimedNode<Object> prev = null;
            TimedNode<Object> h = this.head;
            while (true) {
                TimedNode<Object> next = h.get();
                if (next == null) {
                    break;
                }
                prev = h;
                h = next;
            }
            long limit = this.scheduler.now(this.unit) - this.maxAge;
            if (h.time >= limit && (t = (T) h.value) != null) {
                if (NotificationLite.isComplete(t) || NotificationLite.isError(t)) {
                    return (T) prev.value;
                }
                return t;
            }
            return null;
        }

        TimedNode<Object> getHead() {
            TimedNode<Object> index = this.head;
            long limit = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> next = index.get();
            while (next != null) {
                long ts = next.time;
                if (ts > limit) {
                    break;
                }
                index = next;
                TimedNode<Object> next2 = index.get();
                next = next2;
            }
            return index;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] array) {
            TimedNode<Object> h = getHead();
            int s = size(h);
            if (s == 0) {
                if (array.length != 0) {
                    array[0] = null;
                }
            } else {
                if (array.length < s) {
                    array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), s));
                }
                int i = 0;
                while (i != s) {
                    TimedNode<Object> next = h.get();
                    array[i] = next.value;
                    i++;
                    h = next;
                }
                if (array.length > s) {
                    array[s] = null;
                }
            }
            return array;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> rs) {
            if (rs.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Observer<? super T> a = rs.downstream;
            TimedNode<Object> index = (TimedNode) rs.index;
            if (index == null) {
                index = getHead();
            }
            while (!rs.cancelled) {
                TimedNode<Object> n = index.get();
                if (n != null) {
                    Object o = (T) n.value;
                    if (this.done && n.get() == null) {
                        if (NotificationLite.isComplete(o)) {
                            a.onComplete();
                        } else {
                            a.onError(NotificationLite.getError(o));
                        }
                        rs.index = null;
                        rs.cancelled = true;
                        return;
                    }
                    a.onNext(o);
                    index = n;
                } else {
                    rs.index = index;
                    missed = rs.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            rs.index = null;
        }

        @Override // io.reactivex.rxjava3.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        int size(TimedNode<Object> h) {
            int s = 0;
            while (s != Integer.MAX_VALUE) {
                TimedNode<Object> next = h.get();
                if (next == null) {
                    Object o = h.value;
                    if (NotificationLite.isComplete(o) || NotificationLite.isError(o)) {
                        return s - 1;
                    }
                    return s;
                }
                s++;
                h = next;
            }
            return s;
        }
    }
}