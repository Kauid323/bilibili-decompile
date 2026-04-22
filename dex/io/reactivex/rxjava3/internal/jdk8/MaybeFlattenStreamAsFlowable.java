package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class MaybeFlattenStreamAsFlowable<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final Maybe<T> source;

    public MaybeFlattenStreamAsFlowable(Maybe<T> source, Function<? super T, ? extends Stream<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe(new FlattenStreamMultiObserver(s, this.mapper));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlattenStreamMultiObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long serialVersionUID = 7363336003027148283L;
        volatile boolean cancelled;
        AutoCloseable close;
        final Subscriber<? super R> downstream;
        long emitted;
        volatile Iterator<? extends R> iterator;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        boolean once;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FlattenStreamMultiObserver(Subscriber<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper) {
            this.downstream = downstream;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<? extends R> */
        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            try {
                Stream stream = (Stream) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Stream");
                Iterator<? extends R> iterator = stream.iterator();
                if (!iterator.hasNext()) {
                    this.downstream.onComplete();
                    close(stream);
                    return;
                }
                this.iterator = iterator;
                this.close = stream;
                drain();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
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
            if (!this.outputFused) {
                drain();
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
        public R poll() throws Throwable {
            Iterator<? extends R> it = this.iterator;
            if (it == null) {
                return null;
            }
            if (this.once) {
                if (!it.hasNext()) {
                    clear();
                    return null;
                }
            } else {
                this.once = true;
            }
            return it.next();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<? extends R> it = this.iterator;
            if (it != null) {
                if (this.once && !it.hasNext()) {
                    clear();
                    return true;
                }
                return false;
            }
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.iterator = null;
            AutoCloseable close = this.close;
            this.close = null;
            close(close);
        }

        void close(AutoCloseable c) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    RxJavaPlugins.onError(ex);
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Subscriber<? super R> downstream = this.downstream;
            long emitted = this.emitted;
            long requested = this.requested.get();
            Iterator<? extends R> it = this.iterator;
            while (true) {
                if (this.cancelled) {
                    clear();
                } else if (this.outputFused) {
                    if (it != null) {
                        downstream.onNext((Object) null);
                        downstream.onComplete();
                    }
                } else if (it != null && emitted != requested) {
                    try {
                        R item = it.next();
                        if (!this.cancelled) {
                            downstream.onNext(item);
                            emitted++;
                            if (!this.cancelled) {
                                try {
                                    boolean has = it.hasNext();
                                    if (!this.cancelled && !has) {
                                        downstream.onComplete();
                                        this.cancelled = true;
                                    }
                                } catch (Throwable ex) {
                                    Exceptions.throwIfFatal(ex);
                                    downstream.onError(ex);
                                    this.cancelled = true;
                                }
                            }
                        }
                    } catch (Throwable ex2) {
                        Exceptions.throwIfFatal(ex2);
                        downstream.onError(ex2);
                        this.cancelled = true;
                    }
                }
                this.emitted = emitted;
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
                requested = this.requested.get();
                if (it == null) {
                    it = this.iterator;
                }
            }
        }
    }
}