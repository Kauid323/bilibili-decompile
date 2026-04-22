package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeCreate<T> implements Observable.OnSubscribe<T> {
    final Action1<Emitter<T>> Emitter;
    final Emitter.BackpressureMode backpressure;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeCreate(Action1<Emitter<T>> Emitter, Emitter.BackpressureMode backpressure) {
        this.Emitter = Emitter;
        this.backpressure = backpressure;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.OnSubscribeCreate$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$rx$Emitter$BackpressureMode = new int[Emitter.BackpressureMode.values().length];

        static {
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void call(Subscriber<? super T> t) {
        BaseEmitter<T> emitter;
        switch (AnonymousClass1.$SwitchMap$rx$Emitter$BackpressureMode[this.backpressure.ordinal()]) {
            case 1:
                emitter = new NoneEmitter<>(t);
                break;
            case 2:
                emitter = new ErrorEmitter<>(t);
                break;
            case 3:
                emitter = new DropEmitter<>(t);
                break;
            case 4:
                emitter = new LatestEmitter<>(t);
                break;
            default:
                emitter = new BufferEmitter<>(t, RxRingBuffer.SIZE);
                break;
        }
        t.add(emitter);
        t.setProducer(emitter);
        this.Emitter.call(emitter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> actual;
        final SerialSubscription serial = new SerialSubscription();

        public BaseEmitter(Subscriber<? super T> actual) {
            this.actual = actual;
        }

        public void onCompleted() {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onCompleted();
            } finally {
                this.serial.unsubscribe();
            }
        }

        public void onError(Throwable e) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onError(e);
            } finally {
                this.serial.unsubscribe();
            }
        }

        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }

        void onUnsubscribed() {
        }

        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        public final void request(long n) {
            if (BackpressureUtils.validate(n)) {
                BackpressureUtils.getAndAddRequest(this, n);
                onRequested();
            }
        }

        void onRequested() {
        }

        public final void setSubscription(Subscription s) {
            this.serial.set(s);
        }

        public final void setCancellation(Cancellable c) {
            setSubscription(new CancellableSubscription(c));
        }

        public final long requested() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NoneEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        public void onNext(T t) {
            long r;
            if (this.actual.isUnsubscribed()) {
                return;
            }
            this.actual.onNext(t);
            do {
                r = get();
                if (r == 0) {
                    return;
                }
            } while (!compareAndSet(r, r - 1));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static abstract class NoOverflowBaseEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        public NoOverflowBaseEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        public void onNext(T t) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            if (get() != 0) {
                this.actual.onNext(t);
                BackpressureUtils.produced(this, 1L);
                return;
            }
            onOverflow();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DropEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        @Override // rx.internal.operators.OnSubscribeCreate.NoOverflowBaseEmitter
        void onOverflow() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ErrorEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public ErrorEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        @Override // rx.internal.operators.OnSubscribeCreate.NoOverflowBaseEmitter
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            super.onNext(t);
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            super.onCompleted();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaHooks.onError(e);
                return;
            }
            this.done = true;
            super.onError(e);
        }

        @Override // rx.internal.operators.OnSubscribeCreate.NoOverflowBaseEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BufferEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final Queue<Object> queue;
        final AtomicInteger wip;

        public BufferEmitter(Subscriber<? super T> actual, int capacityHint) {
            super(actual);
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue(capacityHint) : new SpscUnboundedAtomicArrayQueue(capacityHint);
            this.wip = new AtomicInteger();
        }

        public void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super T> a = this.actual;
            Queue<Object> q = this.queue;
            do {
                long r = get();
                long e = 0;
                while (e != r) {
                    if (a.isUnsubscribed()) {
                        q.clear();
                        return;
                    }
                    boolean d = this.done;
                    Object o = q.poll();
                    boolean empty = o == null;
                    if (d && empty) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            super.onError(ex);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    } else if (empty) {
                        break;
                    } else {
                        a.onNext(NotificationLite.getValue(o));
                        e++;
                    }
                }
                if (e == r) {
                    if (a.isUnsubscribed()) {
                        q.clear();
                        return;
                    }
                    boolean d2 = this.done;
                    boolean empty2 = q.isEmpty();
                    if (d2 && empty2) {
                        Throwable ex2 = this.error;
                        if (ex2 != null) {
                            super.onError(ex2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (e != 0) {
                    BackpressureUtils.produced(this, e);
                }
                missed = this.wip.addAndGet(-missed);
            } while (missed != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LatestEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<Object> queue;
        final AtomicInteger wip;

        public LatestEmitter(Subscriber<? super T> actual) {
            super(actual);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        public void onNext(T t) {
            this.queue.set(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
            if (r5 != r3) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
            if (r1.isUnsubscribed() == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
            r7 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
            if (r2.get() != null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0066, code lost:
            if (r7 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0068, code lost:
            if (r8 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
            r9 = r13.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006c, code lost:
            if (r9 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x006e, code lost:
            super.onError(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0072, code lost:
            super.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
            if (r5 == 0) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x007c, code lost:
            rx.internal.operators.BackpressureUtils.produced(r13, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x007f, code lost:
            r0 = r13.wip.addAndGet(-r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super T> a = this.actual;
            AtomicReference<Object> q = this.queue;
            do {
                long r = get();
                long e = 0;
                while (true) {
                    boolean empty = true;
                    if (e == r) {
                        break;
                    } else if (a.isUnsubscribed()) {
                        q.lazySet(null);
                        return;
                    } else {
                        boolean d = this.done;
                        Object o = q.getAndSet(null);
                        boolean empty2 = o == null;
                        if (d && empty2) {
                            Throwable ex = this.error;
                            if (ex != null) {
                                super.onError(ex);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (empty2) {
                            break;
                        } else {
                            a.onNext(NotificationLite.getValue(o));
                            e++;
                        }
                    }
                }
            } while (missed != 0);
        }
    }
}