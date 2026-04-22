package io.reactivex.rxjava3.processors;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplaySubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
    static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable ex);

        Throwable getError();

        T getValue();

        T[] getValues(T[] array);

        boolean isDone();

        void next(T value);

        void replay(ReplaySubscription<T> rs);

        int size();

        void trimHead();
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create(int capacityHint) {
        ObjectHelper.verifyPositive(capacityHint, "capacityHint");
        return new ReplayProcessor<>(new UnboundedReplayBuffer(capacityHint));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithSize(int maxSize) {
        ObjectHelper.verifyPositive(maxSize, "maxSize");
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(maxSize));
    }

    @CheckReturnValue
    static <T> ReplayProcessor<T> createUnbounded() {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTime(long maxAge, TimeUnit unit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, maxAge, unit, scheduler));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long maxAge, TimeUnit unit, Scheduler scheduler, int maxSize) {
        ObjectHelper.verifyPositive(maxSize, "maxSize");
        ObjectHelper.verifyPositive(maxAge, "maxAge");
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(maxSize, maxAge, unit, scheduler));
    }

    ReplayProcessor(ReplayBuffer<T> buffer) {
        this.buffer = buffer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        ReplaySubscription<T> rs = new ReplaySubscription<>(s, this);
        s.onSubscribe(rs);
        if (add(rs) && rs.cancelled) {
            remove(rs);
        } else {
            this.buffer.replay(rs);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        if (this.done) {
            s.cancel();
        } else {
            s.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.done) {
            return;
        }
        ReplayBuffer<T> b = this.buffer;
        b.next(t);
        for (ReplaySubscription<T> rs : this.subscribers.get()) {
            b.replay(rs);
        }
    }

    public void onError(Throwable t) {
        ReplaySubscription<T>[] andSet;
        ExceptionHelper.nullCheck(t, "onError called with a null Throwable.");
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.done = true;
        ReplayBuffer<T> b = this.buffer;
        b.error(t);
        for (ReplaySubscription<T> rs : this.subscribers.getAndSet(TERMINATED)) {
            b.replay(rs);
        }
    }

    public void onComplete() {
        ReplaySubscription<T>[] andSet;
        if (this.done) {
            return;
        }
        this.done = true;
        ReplayBuffer<T> b = this.buffer;
        b.complete();
        for (ReplaySubscription<T> rs : this.subscribers.getAndSet(TERMINATED)) {
            b.replay(rs);
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @CheckReturnValue
    int subscriberCount() {
        return this.subscribers.get().length;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        ReplayBuffer<T> b = this.buffer;
        if (b.isDone()) {
            return b.getError();
        }
        return null;
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    @CheckReturnValue
    public T getValue() {
        return this.buffer.getValue();
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

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        ReplayBuffer<T> b = this.buffer;
        return b.isDone() && b.getError() == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        ReplayBuffer<T> b = this.buffer;
        return b.isDone() && b.getError() != null;
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    @CheckReturnValue
    int size() {
        return this.buffer.size();
    }

    boolean add(ReplaySubscription<T> rs) {
        ReplaySubscription<T>[] a;
        ReplaySubscription<T>[] b;
        do {
            a = this.subscribers.get();
            if (a == TERMINATED) {
                return false;
            }
            int len = a.length;
            b = new ReplaySubscription[len + 1];
            System.arraycopy(a, 0, b, 0, len);
            b[len] = rs;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
        return true;
    }

    void remove(ReplaySubscription<T> rs) {
        ReplaySubscription<T>[] a;
        ReplaySubscription<T>[] b;
        do {
            a = this.subscribers.get();
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
                ReplaySubscription<T>[] b2 = new ReplaySubscription[len - 1];
                System.arraycopy(a, 0, b2, 0, j2);
                System.arraycopy(a, j2 + 1, b2, j2, (len - j2) - 1);
                b = b2;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.subscribers, a, b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final ReplayProcessor<T> state;

        ReplaySubscription(Subscriber<? super T> actual, ReplayProcessor<T> state) {
            this.downstream = actual;
            this.state = state;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                this.state.buffer.replay(this);
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final List<T> buffer;
        volatile boolean done;
        Throwable error;
        volatile int size;

        UnboundedReplayBuffer(int capacityHint) {
            this.buffer = new ArrayList(capacityHint);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            this.buffer.add(value);
            this.size++;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            int s = this.size;
            if (s == 0) {
                return null;
            }
            return this.buffer.get(s - 1);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] array) {
            int s = this.size;
            if (s == 0) {
                if (array.length != 0) {
                    array[0] = null;
                }
                return array;
            }
            List<T> b = this.buffer;
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

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> rs) {
            int index;
            if (rs.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            List<T> b = this.buffer;
            Subscriber<? super T> a = rs.downstream;
            Integer indexObject = (Integer) rs.index;
            if (indexObject != null) {
                index = indexObject.intValue();
            } else {
                index = 0;
                rs.index = 0;
            }
            long e = rs.emitted;
            do {
                long r = rs.requested.get();
                while (e != r) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean d = this.done;
                    int s = this.size;
                    if (d && index == s) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable ex = this.error;
                        if (ex == null) {
                            a.onComplete();
                            return;
                        } else {
                            a.onError(ex);
                            return;
                        }
                    } else if (index == s) {
                        break;
                    } else {
                        a.onNext(b.get(index));
                        index++;
                        e++;
                    }
                }
                if (e == r) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean d2 = this.done;
                    int s2 = this.size;
                    if (d2 && index == s2) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable ex2 = this.error;
                        if (ex2 == null) {
                            a.onComplete();
                            return;
                        } else {
                            a.onError(ex2);
                            return;
                        }
                    }
                }
                rs.index = Integer.valueOf(index);
                rs.emitted = e;
                missed = rs.addAndGet(-missed);
            } while (missed != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
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
    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int maxSize;
        int size;
        Node<T> tail;

        SizeBoundReplayBuffer(int maxSize) {
            this.maxSize = maxSize;
            Node<T> h = new Node<>(null);
            this.tail = h;
            this.head = h;
        }

        void trim() {
            if (this.size > this.maxSize) {
                this.size--;
                Node<T> h = this.head;
                this.head = h.get();
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            Node<T> n = new Node<>(value);
            Node<T> t = this.tail;
            this.tail = n;
            this.size++;
            t.set(n);
            trim();
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value != null) {
                Node<T> n = new Node<>(null);
                n.lazySet(this.head.get());
                this.head = n;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            Node<T> h = this.head;
            while (true) {
                Node<T> n = h.get();
                if (n == null) {
                    return h.value;
                }
                h = n;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] array) {
            int s = 0;
            Node<T> h = this.head;
            Node<T> h0 = h;
            while (true) {
                Node<T> next = h0.get();
                if (next == null) {
                    break;
                }
                s++;
                h0 = next;
            }
            if (array.length < s) {
                array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), s));
            }
            for (int j2 = 0; j2 < s; j2++) {
                h = h.get();
                array[j2] = h.value;
            }
            int j3 = array.length;
            if (j3 > s) {
                array[s] = null;
            }
            return array;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> rs) {
            if (rs.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super T> a = rs.downstream;
            Node<T> index = (Node) rs.index;
            if (index == null) {
                index = this.head;
            }
            long e = rs.emitted;
            do {
                long r = rs.requested.get();
                while (e != r) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean d = this.done;
                    Node<T> next = index.get();
                    boolean empty = next == null;
                    if (d && empty) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable ex = this.error;
                        if (ex == null) {
                            a.onComplete();
                            return;
                        } else {
                            a.onError(ex);
                            return;
                        }
                    } else if (empty) {
                        break;
                    } else {
                        a.onNext(next.value);
                        e++;
                        index = next;
                    }
                }
                if (e == r) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean d2 = this.done;
                    if (d2 && index.get() == null) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable ex2 = this.error;
                        if (ex2 == null) {
                            a.onComplete();
                            return;
                        } else {
                            a.onError(ex2);
                            return;
                        }
                    }
                }
                rs.index = index;
                rs.emitted = e;
                missed = rs.addAndGet(-missed);
            } while (missed != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            Node<T> next;
            int s = 0;
            Node<T> h = this.head;
            while (s != Integer.MAX_VALUE && (next = h.get()) != null) {
                s++;
                h = next;
            }
            return s;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int maxSize, long maxAge, TimeUnit unit, Scheduler scheduler) {
            this.maxSize = maxSize;
            this.maxAge = maxAge;
            this.unit = unit;
            this.scheduler = scheduler;
            TimedNode<T> h = new TimedNode<>(null, 0L);
            this.tail = h;
            this.head = h;
        }

        void trim() {
            if (this.size > this.maxSize) {
                this.size--;
                TimedNode<T> h = this.head;
                this.head = h.get();
            }
            long limit = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> h2 = this.head;
            while (this.size > 1) {
                TimedNode<T> next = h2.get();
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
            TimedNode<T> h = this.head;
            while (true) {
                TimedNode<T> next = h.get();
                if (next == null) {
                    if (h.value != null) {
                        this.head = new TimedNode<>(null, 0L);
                        return;
                    } else {
                        this.head = h;
                        return;
                    }
                } else if (next.time > limit) {
                    if (h.value != null) {
                        TimedNode<T> n = new TimedNode<>(null, 0L);
                        n.lazySet(h.get());
                        this.head = n;
                        return;
                    }
                    this.head = h;
                    return;
                } else {
                    h = next;
                }
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value != null) {
                TimedNode<T> n = new TimedNode<>(null, 0L);
                n.lazySet(this.head.get());
                this.head = n;
            }
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void next(T value) {
            TimedNode<T> n = new TimedNode<>(value, this.scheduler.now(this.unit));
            TimedNode<T> t = this.tail;
            this.tail = n;
            this.size++;
            t.set(n);
            trim();
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable ex) {
            trimFinal();
            this.error = ex;
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimFinal();
            this.done = true;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            TimedNode<T> h = this.head;
            while (true) {
                TimedNode<T> next = h.get();
                if (next == null) {
                    break;
                }
                h = next;
            }
            long limit = this.scheduler.now(this.unit) - this.maxAge;
            if (h.time < limit) {
                return null;
            }
            return h.value;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] array) {
            TimedNode<T> h = getHead();
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
                    TimedNode<T> next = h.get();
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

        TimedNode<T> getHead() {
            TimedNode<T> index = this.head;
            long limit = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> next = index.get();
            while (next != null) {
                long ts = next.time;
                if (ts > limit) {
                    break;
                }
                index = next;
                TimedNode<T> next2 = index.get();
                next = next2;
            }
            return index;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> rs) {
            if (rs.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super T> a = rs.downstream;
            TimedNode<T> index = (TimedNode) rs.index;
            if (index == null) {
                index = getHead();
            }
            long e = rs.emitted;
            do {
                long r = rs.requested.get();
                while (e != r) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean d = this.done;
                    TimedNode<T> next = index.get();
                    boolean empty = next == null;
                    if (d && empty) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable ex = this.error;
                        if (ex == null) {
                            a.onComplete();
                            return;
                        } else {
                            a.onError(ex);
                            return;
                        }
                    } else if (empty) {
                        break;
                    } else {
                        a.onNext(next.value);
                        e++;
                        index = next;
                    }
                }
                if (e == r) {
                    if (rs.cancelled) {
                        rs.index = null;
                        return;
                    }
                    boolean d2 = this.done;
                    if (d2 && index.get() == null) {
                        rs.index = null;
                        rs.cancelled = true;
                        Throwable ex2 = this.error;
                        if (ex2 == null) {
                            a.onComplete();
                            return;
                        } else {
                            a.onError(ex2);
                            return;
                        }
                    }
                }
                rs.index = index;
                rs.emitted = e;
                missed = rs.addAndGet(-missed);
            } while (missed != 0);
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        int size(TimedNode<T> h) {
            TimedNode<T> next;
            int s = 0;
            while (s != Integer.MAX_VALUE && (next = h.get()) != null) {
                s++;
                h = next;
            }
            return s;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.rxjava3.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }
    }
}