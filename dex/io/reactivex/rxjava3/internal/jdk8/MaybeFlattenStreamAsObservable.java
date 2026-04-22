package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Stream;
import java.util.Iterator;

public final class MaybeFlattenStreamAsObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final Maybe<T> source;

    public MaybeFlattenStreamAsObservable(Maybe<T> source, Function<? super T, ? extends Stream<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> s) {
        this.source.subscribe(new FlattenStreamMultiObserver(s, this.mapper));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlattenStreamMultiObserver<T, R> extends BasicIntQueueDisposable<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long serialVersionUID = 7363336003027148283L;
        AutoCloseable close;
        volatile boolean disposed;
        final Observer<? super R> downstream;
        volatile Iterator<? extends R> iterator;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        boolean once;
        boolean outputFused;
        Disposable upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FlattenStreamMultiObserver(Observer<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper) {
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

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            if (!this.outputFused) {
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
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
            Observer<? super R> downstream = this.downstream;
            Iterator<? extends R> it = this.iterator;
            while (true) {
                if (this.disposed) {
                    clear();
                } else if (this.outputFused) {
                    downstream.onNext(null);
                    downstream.onComplete();
                } else {
                    try {
                        Object obj = (R) it.next();
                        if (!this.disposed) {
                            downstream.onNext(obj);
                            if (!this.disposed) {
                                try {
                                    boolean has = it.hasNext();
                                    if (!this.disposed && !has) {
                                        downstream.onComplete();
                                        this.disposed = true;
                                    }
                                } catch (Throwable ex) {
                                    Exceptions.throwIfFatal(ex);
                                    downstream.onError(ex);
                                    this.disposed = true;
                                }
                            }
                        }
                    } catch (Throwable ex2) {
                        Exceptions.throwIfFatal(ex2);
                        downstream.onError(ex2);
                        this.disposed = true;
                    }
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }
    }
}