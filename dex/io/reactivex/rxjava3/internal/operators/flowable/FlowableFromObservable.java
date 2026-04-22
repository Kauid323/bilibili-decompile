package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final ObservableSource<T> upstream;

    public FlowableFromObservable(ObservableSource<T> upstream) {
        this.upstream = upstream;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.upstream.subscribe(new SubscriberObserver(s));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SubscriberObserver<T> implements Observer<T>, Subscription {
        final Subscriber<? super T> downstream;
        Disposable upstream;

        SubscriberObserver(Subscriber<? super T> s) {
            this.downstream = s;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T value) {
            this.downstream.onNext(value);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            this.upstream = d;
            this.downstream.onSubscribe(this);
        }

        public void cancel() {
            this.upstream.dispose();
        }

        public void request(long n) {
        }
    }
}