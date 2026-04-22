package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {
    final Publisher<? extends T> source;

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.source = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(final Observer<? super T> o) {
        this.source.subscribe(new PublisherSubscriber(o));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final Observer<? super T> downstream;
        Subscription upstream;

        PublisherSubscriber(Observer<? super T> o) {
            this.downstream = o;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable t) {
            this.downstream.onError(t);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }
    }
}