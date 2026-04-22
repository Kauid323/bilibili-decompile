package io.reactivex.rxjava3.internal.jdk8;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Collector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollector<T, A, R> extends Flowable<R> {
    final Collector<T, A, R> collector;
    final ParallelFlowable<? extends T> source;

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<T, A, R> */
    public ParallelCollector(ParallelFlowable<? extends T> source, Collector<T, A, R> collector) {
        this.source = source;
        this.collector = collector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        try {
            ParallelCollectorSubscriber<T, A, R> parent = new ParallelCollectorSubscriber<>(s, this.source.parallelism(), this.collector);
            s.onSubscribe(parent);
            this.source.subscribe(parent.subscribers);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptySubscription.error(ex, s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ParallelCollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<SlotPair<A>> current;
        final AtomicThrowable error;
        final Function<A, R> finisher;
        final AtomicInteger remaining;
        final ParallelCollectorInnerSubscriber<T, A, R>[] subscribers;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<T, A, R> */
        ParallelCollectorSubscriber(Subscriber<? super R> subscriber, int n, Collector<T, A, R> collector) {
            super(subscriber);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicThrowable();
            this.finisher = collector.finisher();
            ParallelCollectorInnerSubscriber<T, A, R>[] a = new ParallelCollectorInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                a[i] = new ParallelCollectorInnerSubscriber<>(this, collector.supplier().get(), collector.accumulator(), collector.combiner());
            }
            this.subscribers = a;
            this.remaining.lazySet(n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        SlotPair<A> addValue(A value) {
            SlotPair<A> curr;
            int c;
            while (true) {
                curr = this.current.get();
                if (curr == null) {
                    curr = new SlotPair<>();
                    if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, (Object) null, curr)) {
                        continue;
                    }
                }
                c = curr.tryAcquireSlot();
                if (c >= 0) {
                    break;
                }
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, curr, (Object) null);
            }
            if (c == 0) {
                curr.first = value;
            } else {
                curr.second = value;
            }
            if (curr.releaseSlot()) {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, curr, (Object) null);
                return curr;
            }
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription
        public void cancel() {
            ParallelCollectorInnerSubscriber<T, A, R>[] parallelCollectorInnerSubscriberArr;
            for (ParallelCollectorInnerSubscriber<T, A, R> inner : this.subscribers) {
                inner.cancel();
            }
        }

        void innerError(Throwable ex) {
            if (this.error.compareAndSet(null, ex)) {
                cancel();
                this.downstream.onError(ex);
            } else if (ex != this.error.get()) {
                RxJavaPlugins.onError(ex);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void innerComplete(A value, BinaryOperator<A> combiner) {
            while (true) {
                SlotPair<A> sp = addValue(value);
                if (sp == null) {
                    break;
                }
                try {
                    value = combiner.apply(sp.first, sp.second);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    innerError(ex);
                    return;
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                SlotPair<A> sp2 = this.current.get();
                this.current.lazySet(null);
                try {
                    complete(Objects.requireNonNull(this.finisher.apply(sp2.first), "The finisher returned a null value"));
                } catch (Throwable ex2) {
                    Exceptions.throwIfFatal(ex2);
                    innerError(ex2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ParallelCollectorInnerSubscriber<T, A, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        final BiConsumer<A, T> accumulator;
        final BinaryOperator<A> combiner;
        A container;
        boolean done;
        final ParallelCollectorSubscriber<T, A, R> parent;

        ParallelCollectorInnerSubscriber(ParallelCollectorSubscriber<T, A, R> parent, A container, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner) {
            this.parent = parent;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.container = container;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, Long.MAX_VALUE);
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.accumulator.accept(this.container, t);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    get().cancel();
                    onError(ex);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.container = null;
            this.done = true;
            this.parent.innerError(t);
        }

        public void onComplete() {
            if (!this.done) {
                A v = this.container;
                this.container = null;
                this.done = true;
                this.parent.innerComplete(v, this.combiner);
            }
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        SlotPair() {
        }

        int tryAcquireSlot() {
            int acquired;
            do {
                acquired = get();
                if (acquired >= 2) {
                    return -1;
                }
            } while (!compareAndSet(acquired, acquired + 1));
            return acquired;
        }

        boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }
    }
}