package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    public ObservableElementAt(ObservableSource<T> source, long index, T defaultValue, boolean errorOnFewer) {
        super(source);
        this.index = index;
        this.defaultValue = defaultValue;
        this.errorOnFewer = errorOnFewer;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> t) {
        this.source.subscribe(new ElementAtObserver(t, this.index, this.defaultValue, this.errorOnFewer));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        long count;
        final T defaultValue;
        boolean done;
        final Observer<? super T> downstream;
        final boolean errorOnFewer;
        final long index;
        Disposable upstream;

        ElementAtObserver(Observer<? super T> actual, long index, T defaultValue, boolean errorOnFewer) {
            this.downstream = actual;
            this.index = index;
            this.defaultValue = defaultValue;
            this.errorOnFewer = errorOnFewer;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long c = this.count;
            if (c == this.index) {
                this.done = true;
                this.upstream.dispose();
                this.downstream.onNext(t);
                this.downstream.onComplete();
                return;
            }
            this.count = 1 + c;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T v = this.defaultValue;
                if (v == null && this.errorOnFewer) {
                    this.downstream.onError(new NoSuchElementException());
                    return;
                }
                if (v != null) {
                    this.downstream.onNext(v);
                }
                this.downstream.onComplete();
            }
        }
    }
}