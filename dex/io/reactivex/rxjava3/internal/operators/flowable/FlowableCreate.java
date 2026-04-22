package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T> extends Flowable<T> {
    final BackpressureStrategy backpressure;
    final FlowableOnSubscribe<T> source;

    public FlowableCreate(FlowableOnSubscribe<T> source, BackpressureStrategy backpressure) {
        this.source = source;
        this.backpressure = backpressure;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> t) {
        BaseEmitter<T> emitter;
        switch (this.backpressure) {
            case MISSING:
                emitter = new MissingEmitter<>(t);
                break;
            case ERROR:
                emitter = new ErrorAsyncEmitter<>(t);
                break;
            case DROP:
                emitter = new DropAsyncEmitter<>(t);
                break;
            case LATEST:
                emitter = new LatestAsyncEmitter<>(t);
                break;
            default:
                emitter = new BufferAsyncEmitter<>(t, bufferSize());
                break;
        }
        t.onSubscribe(emitter);
        try {
            this.source.subscribe(emitter);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            emitter.onError(ex);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable errors = new AtomicThrowable();
        final SimplePlainQueue<T> queue = new SpscLinkedArrayQueue(16);

        SerializedEmitter(BaseEmitter<T> emitter) {
            this.emitter = emitter;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> q = this.queue;
                synchronized (q) {
                    q.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable t) {
            if (!tryOnError(t)) {
                RxJavaPlugins.onError(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public boolean tryOnError(Throwable t) {
            if (this.emitter.isCancelled() || this.done) {
                return false;
            }
            if (t == null) {
                t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (this.errors.tryAddThrowable(t)) {
                this.done = true;
                drain();
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            BaseEmitter<T> e = this.emitter;
            SimplePlainQueue<T> q = this.queue;
            AtomicThrowable errors = this.errors;
            int missed = 1;
            while (!e.isCancelled()) {
                if (errors.get() != null) {
                    q.clear();
                    errors.tryTerminateConsumer(e);
                    return;
                }
                boolean d = this.done;
                T v = q.poll();
                boolean empty = v == null;
                if (d && empty) {
                    e.onComplete();
                    return;
                } else if (!empty) {
                    e.onNext(v);
                } else {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
            q.clear();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public void setDisposable(Disposable d) {
            this.emitter.setDisposable(d);
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public void setCancellable(Cancellable c) {
            this.emitter.setCancellable(c);
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public long requested() {
            return this.emitter.requested();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public FlowableEmitter<T> serialize() {
            return this;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> downstream;
        final SequentialDisposable serial = new SequentialDisposable();

        BaseEmitter(Subscriber<? super T> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            completeDownstream();
        }

        protected void completeDownstream() {
            if (isCancelled()) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public final void onError(Throwable e) {
            if (e == null) {
                e = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (!signalError(e)) {
                RxJavaPlugins.onError(e);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final boolean tryOnError(Throwable e) {
            if (e == null) {
                e = ExceptionHelper.createNullPointerException("tryOnError called with a null Throwable.");
            }
            return signalError(e);
        }

        public boolean signalError(Throwable e) {
            return errorDownstream(e);
        }

        protected boolean errorDownstream(Throwable e) {
            if (isCancelled()) {
                return false;
            }
            try {
                this.downstream.onError(e);
                this.serial.dispose();
                return true;
            } catch (Throwable th) {
                this.serial.dispose();
                throw th;
            }
        }

        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        void onUnsubscribed() {
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        public final void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this, n);
                onRequested();
            }
        }

        void onRequested() {
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final void setDisposable(Disposable d) {
            this.serial.update(d);
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final void setCancellable(Cancellable c) {
            setDisposable(new CancellableDisposable(c));
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final long requested() {
            return get();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(Subscriber<? super T> downstream) {
            super(downstream);
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            long r;
            if (isCancelled()) {
                return;
            }
            if (t != null) {
                this.downstream.onNext(t);
                do {
                    r = get();
                    if (r == 0) {
                        return;
                    }
                } while (!compareAndSet(r, r - 1));
                return;
            }
            onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> downstream) {
            super(downstream);
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public final void onNext(T t) {
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else if (get() != 0) {
                this.downstream.onNext(t);
                BackpressureHelper.produced(this, 1L);
            } else {
                onOverflow();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(Subscriber<? super T> downstream) {
            super(downstream);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(Subscriber<? super T> downstream) {
            super(downstream);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicInteger wip;

        BufferAsyncEmitter(Subscriber<? super T> actual, int capacityHint) {
            super(actual);
            this.queue = new SpscLinkedArrayQueue<>(capacityHint);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean signalError(Throwable e) {
            if (this.done || isCancelled()) {
                return false;
            }
            this.error = e;
            this.done = true;
            drain();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter
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
            Subscriber<? super T> a = this.downstream;
            SpscLinkedArrayQueue<T> q = this.queue;
            do {
                long r = get();
                long e = 0;
                while (e != r) {
                    if (isCancelled()) {
                        q.clear();
                        return;
                    }
                    boolean d = this.done;
                    T o = q.poll();
                    boolean empty = o == null;
                    if (d && empty) {
                        Throwable ex = this.error;
                        if (ex != null) {
                            errorDownstream(ex);
                            return;
                        } else {
                            completeDownstream();
                            return;
                        }
                    } else if (empty) {
                        break;
                    } else {
                        a.onNext(o);
                        e++;
                    }
                }
                if (e == r) {
                    if (isCancelled()) {
                        q.clear();
                        return;
                    }
                    boolean d2 = this.done;
                    boolean empty2 = q.isEmpty();
                    if (d2 && empty2) {
                        Throwable ex2 = this.error;
                        if (ex2 != null) {
                            errorDownstream(ex2);
                            return;
                        } else {
                            completeDownstream();
                            return;
                        }
                    }
                }
                if (e != 0) {
                    BackpressureHelper.produced(this, e);
                }
                missed = this.wip.addAndGet(-missed);
            } while (missed != 0);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        LatestAsyncEmitter(Subscriber<? super T> downstream) {
            super(downstream);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            this.queue.set(t);
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean signalError(Throwable e) {
            if (this.done || isCancelled()) {
                return false;
            }
            this.error = e;
            this.done = true;
            drain();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r5 != r3) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
            if (isCancelled() == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
            r7 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
            if (r2.get() != null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
            if (r7 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0064, code lost:
            if (r8 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0066, code lost:
            r9 = r13.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
            if (r9 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x006a, code lost:
            errorDownstream(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x006e, code lost:
            completeDownstream();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0071, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
            if (r5 == 0) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0078, code lost:
            io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r13, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x007b, code lost:
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
            Subscriber<? super T> a = this.downstream;
            AtomicReference<T> q = this.queue;
            do {
                long r = get();
                long e = 0;
                while (true) {
                    boolean empty = true;
                    if (e == r) {
                        break;
                    } else if (isCancelled()) {
                        q.lazySet(null);
                        return;
                    } else {
                        boolean d = this.done;
                        T o = q.getAndSet(null);
                        boolean empty2 = o == null;
                        if (d && empty2) {
                            Throwable ex = this.error;
                            if (ex != null) {
                                errorDownstream(ex);
                                return;
                            } else {
                                completeDownstream();
                                return;
                            }
                        } else if (empty2) {
                            break;
                        } else {
                            a.onNext(o);
                            e++;
                        }
                    }
                }
            } while (missed != 0);
        }
    }
}