package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {
    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> source, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> mapper) {
        if (source instanceof Supplier) {
            try {
                Object obj = (Object) ((Supplier) source).get();
                if (obj == 0) {
                    EmptyDisposable.complete(observer);
                    return true;
                }
                try {
                    ObservableSource<? extends R> r = (ObservableSource) Objects.requireNonNull(mapper.apply(obj), "The mapper returned a null ObservableSource");
                    if (r instanceof Supplier) {
                        try {
                            Object obj2 = ((Supplier) r).get();
                            if (obj2 == null) {
                                EmptyDisposable.complete(observer);
                                return true;
                            }
                            ScalarDisposable<R> sd = new ScalarDisposable<>(observer, obj2);
                            observer.onSubscribe(sd);
                            sd.run();
                        } catch (Throwable ex) {
                            Exceptions.throwIfFatal(ex);
                            EmptyDisposable.error(ex, observer);
                            return true;
                        }
                    } else {
                        r.subscribe(observer);
                    }
                    return true;
                } catch (Throwable ex2) {
                    Exceptions.throwIfFatal(ex2);
                    EmptyDisposable.error(ex2, observer);
                    return true;
                }
            } catch (Throwable ex3) {
                Exceptions.throwIfFatal(ex3);
                EmptyDisposable.error(ex3, observer);
                return true;
            }
        }
        return false;
    }

    public static <T, U> Observable<U> scalarXMap(T value, Function<? super T, ? extends ObservableSource<? extends U>> mapper) {
        return RxJavaPlugins.onAssembly(new ScalarXMapObservable(value, mapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ScalarXMapObservable<T, R> extends Observable<R> {
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final T value;

        ScalarXMapObservable(T value, Function<? super T, ? extends ObservableSource<? extends R>> mapper) {
            this.value = value;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.Observable
        public void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource<? extends R> other = (ObservableSource) Objects.requireNonNull(this.mapper.apply((T) this.value), "The mapper returned a null ObservableSource");
                if (other instanceof Supplier) {
                    try {
                        Object obj = ((Supplier) other).get();
                        if (obj == null) {
                            EmptyDisposable.complete(observer);
                            return;
                        }
                        ScalarDisposable<R> sd = new ScalarDisposable<>(observer, obj);
                        observer.onSubscribe(sd);
                        sd.run();
                        return;
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        EmptyDisposable.error(ex, observer);
                        return;
                    }
                }
                other.subscribe(observer);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                EmptyDisposable.error(e, observer);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final Observer<? super T> observer;
        final T value;

        public ScalarDisposable(Observer<? super T> observer, T value) {
            this.observer = observer;
            this.value = value;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T value) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T v1, T v2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            if (get() == 1) {
                lazySet(3);
                return this.value;
            }
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext((T) this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }
}