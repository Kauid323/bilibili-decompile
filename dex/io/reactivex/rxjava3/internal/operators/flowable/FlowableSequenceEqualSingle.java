package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final Publisher<? extends T> first;
    final int prefetch;
    final Publisher<? extends T> second;

    public FlowableSequenceEqualSingle(Publisher<? extends T> first, Publisher<? extends T> second, BiPredicate<? super T, ? super T> comparer, int prefetch) {
        this.first = first;
        this.second = second;
        this.comparer = comparer;
        this.prefetch = prefetch;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> observer) {
        EqualCoordinator<T> parent = new EqualCoordinator<>(observer, this.prefetch, this.comparer);
        observer.onSubscribe(parent);
        parent.subscribe(this.first, this.second);
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.first, this.second, this.comparer, this.prefetch));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> comparer;
        final SingleObserver<? super Boolean> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final FlowableSequenceEqual.EqualSubscriber<T> first;
        final FlowableSequenceEqual.EqualSubscriber<T> second;
        T v1;
        T v2;

        EqualCoordinator(SingleObserver<? super Boolean> actual, int prefetch, BiPredicate<? super T, ? super T> comparer) {
            this.downstream = actual;
            this.comparer = comparer;
            this.first = new FlowableSequenceEqual.EqualSubscriber<>(this, prefetch);
            this.second = new FlowableSequenceEqual.EqualSubscriber<>(this, prefetch);
        }

        void subscribe(Publisher<? extends T> source1, Publisher<? extends T> source2) {
            source1.subscribe(this.first);
            source2.subscribe(this.second);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.first.cancel();
            this.second.cancel();
            this.errors.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.first.get() == SubscriptionHelper.CANCELLED;
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            do {
                SimpleQueue<T> q1 = this.first.queue;
                SimpleQueue<T> q2 = this.second.queue;
                if (q1 != null && q2 != null) {
                    while (!isDisposed()) {
                        Throwable ex = this.errors.get();
                        if (ex != null) {
                            cancelAndClear();
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                        boolean d1 = this.first.done;
                        T a = this.v1;
                        if (a == null) {
                            try {
                                a = q1.poll();
                                this.v1 = a;
                            } catch (Throwable exc) {
                                Exceptions.throwIfFatal(exc);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(exc);
                                this.errors.tryTerminateConsumer(this.downstream);
                                return;
                            }
                        }
                        boolean e1 = a == null;
                        boolean d2 = this.second.done;
                        T b = this.v2;
                        if (b == null) {
                            try {
                                b = q2.poll();
                                this.v2 = b;
                            } catch (Throwable exc2) {
                                Exceptions.throwIfFatal(exc2);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(exc2);
                                this.errors.tryTerminateConsumer(this.downstream);
                                return;
                            }
                        }
                        boolean e2 = b == null;
                        if (d1 && d2 && e1 && e2) {
                            this.downstream.onSuccess(true);
                            return;
                        } else if (d1 && d2 && e1 != e2) {
                            cancelAndClear();
                            this.downstream.onSuccess(false);
                            return;
                        } else if (!e1 && !e2) {
                            try {
                                boolean c = this.comparer.test(a, b);
                                if (!c) {
                                    cancelAndClear();
                                    this.downstream.onSuccess(false);
                                    return;
                                }
                                this.v1 = null;
                                this.v2 = null;
                                this.first.request();
                                this.second.request();
                            } catch (Throwable exc3) {
                                Exceptions.throwIfFatal(exc3);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(exc3);
                                this.errors.tryTerminateConsumer(this.downstream);
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else {
                    Throwable ex2 = this.errors.get();
                    if (ex2 != null) {
                        cancelAndClear();
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                drain();
            }
        }
    }
}