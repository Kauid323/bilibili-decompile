package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableOnErrorComplete<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super Throwable> predicate;

    public ObservableOnErrorComplete(ObservableSource<T> source, Predicate<? super Throwable> predicate) {
        super(source);
        this.predicate = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new OnErrorCompleteObserver(observer, this.predicate));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OnErrorCompleteObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> downstream;
        final Predicate<? super Throwable> predicate;
        Disposable upstream;

        public OnErrorCompleteObserver(Observer<? super T> actual, Predicate<? super Throwable> predicate) {
            this.downstream = actual;
            this.predicate = predicate;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T value) {
            this.downstream.onNext(value);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            try {
                boolean b = this.predicate.test(e);
                if (b) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(e);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(new CompositeException(e, ex));
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}