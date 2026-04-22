package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final ObservableSource<? extends U> other;

    public ObservableWithLatestFrom(ObservableSource<T> source, BiFunction<? super T, ? super U, ? extends R> combiner, ObservableSource<? extends U> other) {
        super(source);
        this.combiner = combiner;
        this.other = other;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> t) {
        SerializedObserver<R> serial = new SerializedObserver<>(t);
        WithLatestFromObserver<T, U, R> wlf = new WithLatestFromObserver<>(serial, this.combiner);
        serial.onSubscribe(wlf);
        this.other.subscribe(new WithLatestFromOtherObserver(wlf));
        this.source.subscribe(wlf);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final Observer<? super R> downstream;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();
        final AtomicReference<Disposable> other = new AtomicReference<>();

        WithLatestFromObserver(Observer<? super R> actual, BiFunction<? super T, ? super U, ? extends R> combiner) {
            this.downstream = actual;
            this.combiner = combiner;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this.upstream, d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.downstream.onNext(Objects.requireNonNull(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    dispose();
                    this.downstream.onError(e);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public boolean setOther(Disposable o) {
            return DisposableHelper.setOnce(this.other, o);
        }

        public void otherError(Throwable e) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(e);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class WithLatestFromOtherObserver implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> parent;

        WithLatestFromOtherObserver(WithLatestFromObserver<T, U, R> parent) {
            this.parent = parent;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            this.parent.setOther(d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(U t) {
            this.parent.lazySet(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.parent.otherError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
        }
    }
}