package rx.internal.operators;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.atomic.MpscLinkedAtomicQueue;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class OnSubscribeFlatMapSingle<T, R> implements Observable.OnSubscribe<R> {
    final boolean delayErrors;
    final Func1<? super T, ? extends Single<? extends R>> mapper;
    final int maxConcurrency;
    final Observable<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeFlatMapSingle(Observable<T> source, Func1<? super T, ? extends Single<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
        if (mapper == null) {
            throw new NullPointerException("mapper is null");
        }
        if (maxConcurrency <= 0) {
            throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + maxConcurrency);
        }
        this.source = source;
        this.mapper = mapper;
        this.delayErrors = delayErrors;
        this.maxConcurrency = maxConcurrency;
    }

    public void call(Subscriber<? super R> child) {
        FlatMapSingleSubscriber<T, R> parent = new FlatMapSingleSubscriber<>(child, this.mapper, this.delayErrors, this.maxConcurrency);
        child.add(parent.set);
        child.add(parent.requested);
        child.setProducer(parent.requested);
        this.source.unsafeSubscribe(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class FlatMapSingleSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Func1<? super T, ? extends Single<? extends R>> mapper;
        final int maxConcurrency;
        final Queue<Object> queue;
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> errors = new AtomicReference<>();
        final FlatMapSingleSubscriber<T, R>.Requested requested = new Requested();
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger active = new AtomicInteger();

        FlatMapSingleSubscriber(Subscriber<? super R> actual, Func1<? super T, ? extends Single<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
            this.actual = actual;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
            this.maxConcurrency = maxConcurrency;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new MpscLinkedQueue();
            } else {
                this.queue = new MpscLinkedAtomicQueue();
            }
            request(maxConcurrency != Integer.MAX_VALUE ? maxConcurrency : Long.MAX_VALUE);
        }

        public void onNext(T t) {
            try {
                Single<? extends R> c = (Single) this.mapper.call(t);
                if (c == null) {
                    try {
                        throw new NullPointerException("The mapper returned a null Single");
                    } catch (Throwable th) {
                        ex = th;
                        Exceptions.throwIfFatal(ex);
                        unsubscribe();
                        onError(ex);
                        return;
                    }
                }
                FlatMapSingleSubscriber<T, R>.InnerSubscriber inner = new InnerSubscriber();
                this.set.add(inner);
                this.active.incrementAndGet();
                c.subscribe(inner);
            } catch (Throwable th2) {
                ex = th2;
            }
        }

        public void onError(Throwable e) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, e);
            } else {
                this.set.unsubscribe();
                if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.errors, (Object) null, e)) {
                    RxJavaHooks.onError(e);
                    return;
                }
            }
            this.done = true;
            drain();
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        void innerSuccess(FlatMapSingleSubscriber<T, R>.InnerSubscriber inner, R value) {
            this.queue.offer(NotificationLite.next(value));
            this.set.remove(inner);
            this.active.decrementAndGet();
            drain();
        }

        void innerError(FlatMapSingleSubscriber<T, R>.InnerSubscriber inner, Throwable e) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, e);
                this.set.remove(inner);
                if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                    request(1L);
                }
            } else {
                this.set.unsubscribe();
                unsubscribe();
                if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.errors, (Object) null, e)) {
                    RxJavaHooks.onError(e);
                    return;
                }
                this.done = true;
            }
            this.active.decrementAndGet();
            drain();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super R> a = this.actual;
            Queue<Object> q = this.queue;
            boolean delayError = this.delayErrors;
            AtomicInteger act = this.active;
            do {
                long r = this.requested.get();
                long e = 0;
                while (e != r) {
                    if (this.cancelled) {
                        q.clear();
                        return;
                    }
                    boolean d = this.done;
                    if (!delayError && d) {
                        Throwable ex = this.errors.get();
                        if (ex != null) {
                            q.clear();
                            a.onError(ExceptionsUtils.terminate(this.errors));
                            return;
                        }
                    }
                    Object o = q.poll();
                    boolean empty = o == null;
                    if (d && act.get() == 0 && empty) {
                        Throwable ex2 = this.errors.get();
                        if (ex2 != null) {
                            a.onError(ExceptionsUtils.terminate(this.errors));
                            return;
                        } else {
                            a.onCompleted();
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
                    if (this.cancelled) {
                        q.clear();
                        return;
                    } else if (this.done) {
                        if (delayError) {
                            if (act.get() == 0 && q.isEmpty()) {
                                Throwable ex3 = this.errors.get();
                                if (ex3 != null) {
                                    a.onError(ExceptionsUtils.terminate(this.errors));
                                    return;
                                } else {
                                    a.onCompleted();
                                    return;
                                }
                            }
                        } else {
                            Throwable ex4 = this.errors.get();
                            if (ex4 != null) {
                                q.clear();
                                a.onError(ExceptionsUtils.terminate(this.errors));
                                return;
                            } else if (act.get() == 0 && q.isEmpty()) {
                                a.onCompleted();
                                return;
                            }
                        }
                    }
                }
                if (e != 0) {
                    this.requested.produced(e);
                    if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                        request(e);
                    }
                }
                missed = this.wip.addAndGet(-missed);
            } while (missed != 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class Requested extends AtomicLong implements Producer, Subscription {
            private static final long serialVersionUID = -887187595446742742L;

            Requested() {
            }

            public void request(long n) {
                if (n > 0) {
                    BackpressureUtils.getAndAddRequest(this, n);
                    FlatMapSingleSubscriber.this.drain();
                }
            }

            void produced(long e) {
                BackpressureUtils.produced(this, e);
            }

            public void unsubscribe() {
                FlatMapSingleSubscriber.this.cancelled = true;
                FlatMapSingleSubscriber.this.unsubscribe();
                if (FlatMapSingleSubscriber.this.wip.getAndIncrement() == 0) {
                    FlatMapSingleSubscriber.this.queue.clear();
                }
            }

            public boolean isUnsubscribed() {
                return FlatMapSingleSubscriber.this.cancelled;
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class InnerSubscriber extends SingleSubscriber<R> {
            InnerSubscriber() {
            }

            public void onSuccess(R t) {
                FlatMapSingleSubscriber.this.innerSuccess(this, t);
            }

            public void onError(Throwable error) {
                FlatMapSingleSubscriber.this.innerError(this, error);
            }
        }
    }
}