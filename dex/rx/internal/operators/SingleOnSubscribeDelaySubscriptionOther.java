package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class SingleOnSubscribeDelaySubscriptionOther<T> implements Single.OnSubscribe<T> {
    final Single<? extends T> main;
    final Observable<?> other;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleOnSubscribeDelaySubscriptionOther(Single<? extends T> main, Observable<?> other) {
        this.main = main;
        this.other = other;
    }

    public void call(final SingleSubscriber<? super T> subscriber) {
        final SingleSubscriber<T> child = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOnSubscribeDelaySubscriptionOther.1
            public void onSuccess(T value) {
                subscriber.onSuccess(value);
            }

            public void onError(Throwable error) {
                subscriber.onError(error);
            }
        };
        final SerialSubscription serial = new SerialSubscription();
        subscriber.add(serial);
        Subscriber<Object> otherSubscriber = new Subscriber<Object>() { // from class: rx.internal.operators.SingleOnSubscribeDelaySubscriptionOther.2
            boolean done;

            public void onNext(Object t) {
                onCompleted();
            }

            public void onError(Throwable e) {
                if (this.done) {
                    RxJavaHooks.onError(e);
                    return;
                }
                this.done = true;
                child.onError(e);
            }

            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                serial.set(child);
                SingleOnSubscribeDelaySubscriptionOther.this.main.subscribe(child);
            }
        };
        serial.set(otherSubscriber);
        this.other.subscribe(otherSubscriber);
    }
}