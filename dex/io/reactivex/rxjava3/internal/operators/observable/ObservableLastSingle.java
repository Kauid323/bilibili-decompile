package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {
    final T defaultItem;
    final ObservableSource<T> source;

    public ObservableLastSingle(ObservableSource<T> source, T defaultItem) {
        this.source = source;
        this.defaultItem = defaultItem;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super T> observer) {
        this.source.subscribe(new LastObserver(observer, this.defaultItem));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class LastObserver<T> implements Observer<T>, Disposable {
        final T defaultItem;
        final SingleObserver<? super T> downstream;
        T item;
        Disposable upstream;

        LastObserver(SingleObserver<? super T> actual, T defaultItem) {
            this.downstream = actual;
            this.defaultItem = defaultItem;
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

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.item = t;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.upstream = DisposableHelper.DISPOSED;
            this.item = null;
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            T v = this.item;
            if (v != null) {
                this.item = null;
                this.downstream.onSuccess(v);
                return;
            }
            T v2 = this.defaultItem;
            if (v2 != null) {
                this.downstream.onSuccess(v2);
            } else {
                this.downstream.onError(new NoSuchElementException());
            }
        }
    }
}