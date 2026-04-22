package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import j$.util.Objects;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final SingleSource<T> source;

    public SingleFlatMapIterableFlowable(SingleSource<T> source, Function<? super T, ? extends Iterable<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe(new FlatMapIterableObserver(s, this.mapper));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final Subscriber<? super R> downstream;
        volatile Iterator<? extends R> it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        FlatMapIterableObserver(Subscriber<? super R> actual, Function<? super T, ? extends Iterable<? extends R>> mapper) {
            this.downstream = actual;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                Iterator<? extends R> iterator = this.mapper.apply(value).iterator();
                boolean has = iterator.hasNext();
                if (!has) {
                    this.downstream.onComplete();
                    return;
                }
                this.it = iterator;
                drain();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(e);
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> a = this.downstream;
            Iterator<? extends R> iterator = this.it;
            if (this.outputFused && iterator != null) {
                a.onNext((Object) null);
                a.onComplete();
                return;
            }
            int missed = 1;
            while (true) {
                if (iterator != null) {
                    long r = this.requested.get();
                    long e = 0;
                    if (r == Long.MAX_VALUE) {
                        fastPath(a, iterator);
                        return;
                    }
                    while (e != r) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            a.onNext(Objects.requireNonNull(iterator.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            e++;
                            try {
                                boolean b = iterator.hasNext();
                                if (!b) {
                                    a.onComplete();
                                    return;
                                }
                            } catch (Throwable ex) {
                                Exceptions.throwIfFatal(ex);
                                a.onError(ex);
                                return;
                            }
                        } catch (Throwable ex2) {
                            Exceptions.throwIfFatal(ex2);
                            a.onError(ex2);
                            return;
                        }
                    }
                    if (e != 0) {
                        BackpressureHelper.produced(this.requested, e);
                    }
                }
                missed = addAndGet(-missed);
                if (missed != 0) {
                    if (iterator == null) {
                        iterator = this.it;
                    }
                } else {
                    return;
                }
            }
        }

        void fastPath(Subscriber<? super R> a, Iterator<? extends R> iterator) {
            while (!this.cancelled) {
                try {
                    R v = iterator.next();
                    a.onNext(v);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        boolean b = iterator.hasNext();
                        if (!b) {
                            a.onComplete();
                            return;
                        }
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        a.onError(ex);
                        return;
                    }
                } catch (Throwable ex2) {
                    Exceptions.throwIfFatal(ex2);
                    a.onError(ex2);
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() {
            Iterator<? extends R> iterator = this.it;
            if (iterator == null) {
                return null;
            }
            R v = (R) Objects.requireNonNull(iterator.next(), "The iterator returned a null value");
            if (!iterator.hasNext()) {
                this.it = null;
            }
            return v;
        }
    }
}