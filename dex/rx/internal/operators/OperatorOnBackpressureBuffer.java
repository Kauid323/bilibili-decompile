package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.BackpressureOverflow;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;

public class OperatorOnBackpressureBuffer<T> implements Observable.Operator<T, T> {
    private final Long capacity;
    private final Action0 onOverflow;
    private final BackpressureOverflow.Strategy overflowStrategy;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Holder {
        static final OperatorOnBackpressureBuffer<?> INSTANCE = new OperatorOnBackpressureBuffer<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureBuffer<T> instance() {
        return (OperatorOnBackpressureBuffer<T>) Holder.INSTANCE;
    }

    OperatorOnBackpressureBuffer() {
        this.capacity = null;
        this.onOverflow = null;
        this.overflowStrategy = BackpressureOverflow.ON_OVERFLOW_DEFAULT;
    }

    public OperatorOnBackpressureBuffer(long capacity) {
        this(capacity, null, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long capacity, Action0 onOverflow) {
        this(capacity, onOverflow, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long capacity, Action0 onOverflow, BackpressureOverflow.Strategy overflowStrategy) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (overflowStrategy == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.capacity = Long.valueOf(capacity);
        this.onOverflow = onOverflow;
        this.overflowStrategy = overflowStrategy;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        BufferSubscriber<T> parent = new BufferSubscriber<>(child, this.capacity, this.onOverflow, this.overflowStrategy);
        child.add(parent);
        child.setProducer(parent.manager());
        return parent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BufferSubscriber<T> extends Subscriber<T> implements BackpressureDrainManager.BackpressureQueueCallback {
        private final AtomicLong capacity;
        private final Subscriber<? super T> child;
        private final BackpressureDrainManager manager;
        private final Action0 onOverflow;
        private final BackpressureOverflow.Strategy overflowStrategy;
        private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean saturated = new AtomicBoolean(false);

        public BufferSubscriber(Subscriber<? super T> child, Long capacity, Action0 onOverflow, BackpressureOverflow.Strategy overflowStrategy) {
            this.child = child;
            this.capacity = capacity != null ? new AtomicLong(capacity.longValue()) : null;
            this.onOverflow = onOverflow;
            this.manager = new BackpressureDrainManager(this);
            this.overflowStrategy = overflowStrategy;
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void onCompleted() {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain();
            }
        }

        public void onError(Throwable e) {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain(e);
            }
        }

        public void onNext(T t) {
            if (!assertCapacity()) {
                return;
            }
            this.queue.offer(NotificationLite.next(t));
            this.manager.drain();
        }

        public boolean accept(Object value) {
            return NotificationLite.accept(this.child, value);
        }

        public void complete(Throwable exception) {
            if (exception != null) {
                this.child.onError(exception);
            } else {
                this.child.onCompleted();
            }
        }

        public Object peek() {
            return this.queue.peek();
        }

        public Object poll() {
            Object value = this.queue.poll();
            if (this.capacity != null && value != null) {
                this.capacity.incrementAndGet();
            }
            return value;
        }

        private boolean assertCapacity() {
            long currCapacity;
            if (this.capacity == null) {
                return true;
            }
            do {
                currCapacity = this.capacity.get();
                if (currCapacity <= 0) {
                    boolean hasCapacity = false;
                    try {
                        hasCapacity = this.overflowStrategy.mayAttemptDrop() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.saturated.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                    }
                    if (this.onOverflow != null) {
                        try {
                            this.onOverflow.call();
                        } catch (Throwable e2) {
                            Exceptions.throwIfFatal(e2);
                            this.manager.terminateAndDrain(e2);
                            return false;
                        }
                    }
                    if (!hasCapacity) {
                        return false;
                    }
                }
            } while (!this.capacity.compareAndSet(currCapacity, currCapacity - 1));
            return true;
        }

        protected Producer manager() {
            return this.manager;
        }
    }
}