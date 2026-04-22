package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableDetach(ObservableSource<T> source) {
        super(source);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DetachObserver(observer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DetachObserver<T> implements Observer<T>, Disposable {
        Observer<? super T> downstream;
        Disposable upstream;

        DetachObserver(Observer<? super T> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            Disposable d = this.upstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asObserver();
            d.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
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
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            Observer<? super T> a = this.downstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asObserver();
            a.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            Observer<? super T> a = this.downstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asObserver();
            a.onComplete();
        }
    }
}