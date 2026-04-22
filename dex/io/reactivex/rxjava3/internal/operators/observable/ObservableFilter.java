package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    public ObservableFilter(ObservableSource<T> source, Predicate<? super T> predicate) {
        super(source);
        this.predicate = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new FilterObserver(observer, this.predicate));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        final Predicate<? super T> filter;

        FilterObserver(Observer<? super T> actual, Predicate<? super T> filter) {
            super(actual);
            this.filter = filter;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                try {
                    boolean b = this.filter.test(t);
                    if (b) {
                        this.downstream.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    fail(e);
                    return;
                }
            }
            this.downstream.onNext(null);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            T v;
            do {
                v = this.qd.poll();
                if (v == null) {
                    break;
                }
            } while (!this.filter.test(v));
            return v;
        }
    }
}