package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.single.SingleMap;
import io.reactivex.rxjava3.internal.operators.single.SingleZipArray;
import j$.util.Objects;
import java.util.Arrays;
import java.util.NoSuchElementException;

public final class SingleZipIterable<T, R> extends Single<R> {
    final Iterable<? extends SingleSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> sources, Function<? super Object[], ? extends R> zipper) {
        this.sources = sources;
        this.zipper = zipper;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super R> observer) {
        SingleSource<? extends T>[] a = new SingleSource[8];
        int n = 0;
        try {
            for (SingleSource<? extends T> source : this.sources) {
                if (source == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                    return;
                }
                if (n == a.length) {
                    a = (SingleSource[]) Arrays.copyOf(a, (n >> 2) + n);
                }
                int n2 = n + 1;
                try {
                    a[n] = source;
                    n = n2;
                } catch (Throwable th) {
                    ex = th;
                    Exceptions.throwIfFatal(ex);
                    EmptyDisposable.error(ex, observer);
                    return;
                }
            }
            if (n == 0) {
                EmptyDisposable.error(new NoSuchElementException(), observer);
            } else if (n == 1) {
                a[0].subscribe(new SingleMap.MapSingleObserver<>(observer, new SingletonArrayFunc()));
            } else {
                SingleZipArray.ZipCoordinator<T, R> parent = new SingleZipArray.ZipCoordinator<>(observer, n, this.zipper);
                observer.onSubscribe(parent);
                for (int i = 0; i < n && !parent.isDisposed(); i++) {
                    a[i].subscribe(parent.observers[i]);
                }
            }
        } catch (Throwable th2) {
            ex = th2;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(T t) throws Throwable {
            return (R) Objects.requireNonNull(SingleZipIterable.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }
}