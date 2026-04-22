package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableFlatMapStream<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final Observable<T> source;

    public ObservableFlatMapStream(Observable<T> source, Function<? super T, ? extends Stream<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<? extends R> */
    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (this.source instanceof Supplier) {
            Stream stream = null;
            try {
                Object obj = ((Supplier) this.source).get();
                if (obj != null) {
                    stream = (Stream) Objects.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Stream");
                }
                if (stream != null) {
                    ObservableFromStream.subscribeStream(observer, stream);
                    return;
                } else {
                    EmptyDisposable.complete(observer);
                    return;
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                EmptyDisposable.error(ex, observer);
                return;
            }
        }
        this.source.subscribe(new FlatMapStreamObserver(observer, this.mapper));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FlatMapStreamObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean disposed;
        boolean done;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        Disposable upstream;

        FlatMapStreamObserver(Observer<? super R> downstream, Function<? super T, ? extends Stream<? extends R>> mapper) {
            this.downstream = downstream;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<? extends R> */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                Stream stream = (Stream) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Stream");
                Iterator<? extends R> it = stream.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (this.disposed) {
                        this.done = true;
                        break;
                    } else {
                        Object requireNonNull = Objects.requireNonNull(it.next(), "The Stream's Iterator.next returned a null value");
                        if (this.disposed) {
                            this.done = true;
                            break;
                        }
                        this.downstream.onNext(requireNonNull);
                        if (this.disposed) {
                            this.done = true;
                            break;
                        }
                    }
                }
                if (stream != null) {
                    stream.close();
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.dispose();
                onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaPlugins.onError(e);
                return;
            }
            this.done = true;
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}