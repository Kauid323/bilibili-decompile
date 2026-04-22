package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;

    public FlowableSwitchMap(Flowable<T> source, Function<? super T, ? extends Publisher<? extends R>> mapper, int bufferSize, boolean delayErrors) {
        super(source);
        this.mapper = mapper;
        this.bufferSize = bufferSize;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, s, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber) new SwitchMapSubscriber(s, this.mapper, this.bufferSize, this.delayErrors));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED = new SwitchMapInnerSubscriber<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        volatile long unique;
        Subscription upstream;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            CANCELLED.cancel();
        }

        SwitchMapSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends Publisher<? extends R>> mapper, int bufferSize, boolean delayErrors) {
            this.downstream = actual;
            this.mapper = mapper;
            this.bufferSize = bufferSize;
            this.delayErrors = delayErrors;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            SwitchMapInnerSubscriber<T, R> inner;
            if (this.done) {
                return;
            }
            long c = this.unique + 1;
            this.unique = c;
            SwitchMapInnerSubscriber<T, R> inner2 = this.active.get();
            if (inner2 != null) {
                inner2.cancel();
            }
            try {
                Publisher<? extends R> p = (Publisher) Objects.requireNonNull(this.mapper.apply(t), "The publisher returned is null");
                SwitchMapInnerSubscriber<T, R> nextInner = new SwitchMapInnerSubscriber<>(this, c, this.bufferSize);
                do {
                    inner = this.active.get();
                    if (inner == CANCELLED) {
                        return;
                    }
                } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.active, inner, nextInner));
                p.subscribe(nextInner);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.upstream.cancel();
                onError(e);
            }
        }

        public void onError(Throwable t) {
            if (!this.done && this.errors.tryAddThrowable(t)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(t);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                if (this.unique == 0) {
                    this.upstream.request(Long.MAX_VALUE);
                } else {
                    drain();
                }
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeInner();
                this.errors.tryTerminateAndReport();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapInnerSubscriber<T, R> a = this.active.getAndSet(CANCELLED);
            if (a != CANCELLED && a != null) {
                a.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:115:0x000a, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c1, code lost:
            if (r7 != r5) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00c5, code lost:
            if (r2.done == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00c9, code lost:
            if (r15.delayErrors != false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00cb, code lost:
            r10 = r15.errors.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00d3, code lost:
            if (r10 == null) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d5, code lost:
            disposeInner();
            r15.errors.tryTerminateConsumer(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00dd, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00e2, code lost:
            if (r4.isEmpty() == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00e4, code lost:
            androidx.compose.animation.core.MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(r15.active, r2, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x00f0, code lost:
            if (r4.isEmpty() == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00f2, code lost:
            androidx.compose.animation.core.MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(r15.active, r2, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00fd, code lost:
            if (r7 == 0) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0101, code lost:
            if (r15.cancelled != false) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x010a, code lost:
            if (r5 == Long.MAX_VALUE) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x010c, code lost:
            r15.requested.addAndGet(-r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0112, code lost:
            r2.request(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0115, code lost:
            if (r9 == false) goto L74;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            R v;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> a = this.downstream;
            int missing = 1;
            while (!this.cancelled) {
                if (this.done) {
                    if (this.delayErrors) {
                        if (this.active.get() == null) {
                            this.errors.tryTerminateConsumer(a);
                            return;
                        }
                    } else {
                        Throwable err = this.errors.get();
                        if (err != null) {
                            disposeInner();
                            this.errors.tryTerminateConsumer(a);
                            return;
                        } else if (this.active.get() == null) {
                            a.onComplete();
                            return;
                        }
                    }
                }
                SwitchMapInnerSubscriber<T, R> inner = this.active.get();
                SimpleQueue<R> q = inner != null ? inner.queue : null;
                if (q != null) {
                    long r = this.requested.get();
                    long e = 0;
                    boolean retry = false;
                    while (true) {
                        if (e == r) {
                            break;
                        } else if (this.cancelled) {
                            return;
                        } else {
                            boolean d = inner.done;
                            try {
                                v = q.poll();
                            } catch (Throwable ex) {
                                Exceptions.throwIfFatal(ex);
                                inner.cancel();
                                this.errors.tryAddThrowableOrReport(ex);
                                d = true;
                                v = null;
                            }
                            boolean empty = v == null;
                            if (inner != this.active.get()) {
                                retry = true;
                                break;
                            }
                            if (d) {
                                if (!this.delayErrors) {
                                    Throwable err2 = this.errors.get();
                                    if (err2 != null) {
                                        this.errors.tryTerminateConsumer(a);
                                        return;
                                    } else if (empty) {
                                        MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.active, inner, (Object) null);
                                        retry = true;
                                        break;
                                    }
                                } else if (empty) {
                                    MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.active, inner, (Object) null);
                                    retry = true;
                                    break;
                                }
                            }
                            if (empty) {
                                break;
                            }
                            a.onNext(v);
                            e++;
                        }
                    }
                }
                missing = addAndGet(-missing);
                if (missing == 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile SimpleQueue<R> queue;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> parent, long index, int bufferSize) {
            this.parent = parent;
            this.index = index;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription<R> qs = (QueueSubscription) s;
                    int m = qs.requestFusion(7);
                    if (m == 1) {
                        this.fusionMode = m;
                        this.queue = qs;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (m == 2) {
                        this.fusionMode = m;
                        this.queue = qs;
                        s.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                s.request(this.bufferSize);
            }
        }

        public void onNext(R t) {
            SwitchMapSubscriber<T, R> p = this.parent;
            if (this.index == p.unique) {
                if (this.fusionMode == 0 && !this.queue.offer(t)) {
                    onError(new MissingBackpressureException("Queue full?!"));
                } else {
                    p.drain();
                }
            }
        }

        public void onError(Throwable t) {
            SwitchMapSubscriber<T, R> p = this.parent;
            if (this.index == p.unique && p.errors.tryAddThrowable(t)) {
                if (!p.delayErrors) {
                    p.upstream.cancel();
                    p.done = true;
                }
                this.done = true;
                p.drain();
                return;
            }
            RxJavaPlugins.onError(t);
        }

        public void onComplete() {
            SwitchMapSubscriber<T, R> p = this.parent;
            if (this.index == p.unique) {
                this.done = true;
                p.drain();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void request(long n) {
            if (this.fusionMode != 1) {
                get().request(n);
            }
        }
    }
}