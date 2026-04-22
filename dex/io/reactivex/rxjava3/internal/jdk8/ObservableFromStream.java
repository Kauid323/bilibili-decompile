package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Stream;
import java.util.Iterator;

public final class ObservableFromStream<T> extends Observable<T> {
    final Stream<T> stream;

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<T> */
    public ObservableFromStream(Stream<T> stream) {
        this.stream = stream;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        subscribeStream(observer, this.stream);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<T> */
    public static <T> void subscribeStream(Observer<? super T> observer, Stream<T> stream) {
        try {
            Iterator<T> iterator = stream.iterator();
            if (!iterator.hasNext()) {
                EmptyDisposable.complete(observer);
                closeSafely(stream);
                return;
            }
            StreamDisposable<T> disposable = new StreamDisposable<>(observer, iterator, stream);
            observer.onSubscribe(disposable);
            disposable.run();
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptyDisposable.error(ex, observer);
            closeSafely(stream);
        }
    }

    static void closeSafely(AutoCloseable c) {
        try {
            c.close();
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            RxJavaPlugins.onError(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class StreamDisposable<T> implements QueueDisposable<T> {
        AutoCloseable closeable;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        Iterator<T> iterator;
        boolean once;
        boolean outputFused;

        StreamDisposable(Observer<? super T> downstream, Iterator<T> iterator, AutoCloseable closeable) {
            this.downstream = downstream;
            this.iterator = iterator;
            this.closeable = closeable;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            run();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 1) != 0) {
                this.outputFused = true;
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T value) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T v1, T v2) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() {
            if (this.iterator == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!this.iterator.hasNext()) {
                clear();
                return null;
            }
            return (T) Objects.requireNonNull(this.iterator.next(), "The Stream's Iterator.next() returned a null value");
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<T> it = this.iterator;
            if (it != null) {
                if (!this.once || it.hasNext()) {
                    return false;
                }
                clear();
                return true;
            }
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.iterator = null;
            AutoCloseable c = this.closeable;
            this.closeable = null;
            if (c != null) {
                ObservableFromStream.closeSafely(c);
            }
        }

        public void run() {
            if (this.outputFused) {
                return;
            }
            Iterator<T> iterator = this.iterator;
            Observer<? super T> downstream = this.downstream;
            while (!this.disposed) {
                try {
                    Object obj = (Object) Objects.requireNonNull(iterator.next(), "The Stream's Iterator.next returned a null value");
                    if (!this.disposed) {
                        downstream.onNext(obj);
                        if (!this.disposed) {
                            try {
                                if (!iterator.hasNext()) {
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
            clear();
        }
    }
}