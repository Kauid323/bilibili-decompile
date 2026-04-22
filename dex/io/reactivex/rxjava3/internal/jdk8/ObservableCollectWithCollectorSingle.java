package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import j$.util.stream.Collector;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final class ObservableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToObservable<R> {
    final Collector<T, A, R> collector;
    final Observable<T> source;

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<T, A, R> */
    public ObservableCollectWithCollectorSingle(Observable<T> source, Collector<T, A, R> collector) {
        this.source = source;
        this.collector = collector;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<R> fuseToObservable() {
        return new ObservableCollectWithCollector(this.source, this.collector);
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super R> observer) {
        try {
            Object obj = this.collector.supplier().get();
            BiConsumer<A, T> accumulator = this.collector.accumulator();
            Function<A, R> finisher = this.collector.finisher();
            this.source.subscribe(new CollectorSingleObserver(observer, obj, accumulator, finisher));
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptyDisposable.error(ex, observer);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class CollectorSingleObserver<T, A, R> implements Observer<T>, Disposable {
        final BiConsumer<A, T> accumulator;
        A container;
        boolean done;
        final SingleObserver<? super R> downstream;
        final Function<A, R> finisher;
        Disposable upstream;

        CollectorSingleObserver(SingleObserver<? super R> downstream, A container, BiConsumer<A, T> accumulator, Function<A, R> finisher) {
            this.downstream = downstream;
            this.container = container;
            this.accumulator = accumulator;
            this.finisher = finisher;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator.accept(this.container, t);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.dispose();
                onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.upstream = DisposableHelper.DISPOSED;
            this.container = null;
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.upstream = DisposableHelper.DISPOSED;
            A container = this.container;
            this.container = null;
            try {
                this.downstream.onSuccess(Objects.requireNonNull(this.finisher.apply(container), "The finisher returned a null value"));
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream == DisposableHelper.DISPOSED;
        }
    }
}