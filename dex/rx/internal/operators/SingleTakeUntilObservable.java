package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class SingleTakeUntilObservable<T, U> implements Single.OnSubscribe<T> {
    final Observable<? extends U> other;
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleTakeUntilObservable(Single.OnSubscribe<T> source, Observable<? extends U> other) {
        this.source = source;
        this.other = other;
    }

    public void call(SingleSubscriber<? super T> t) {
        TakeUntilSourceSubscriber<T, U> parent = new TakeUntilSourceSubscriber<>(t);
        t.add(parent);
        this.other.subscribe(parent.other);
        this.source.call(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TakeUntilSourceSubscriber<T, U> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final Subscriber<U> other = new OtherSubscriber();

        TakeUntilSourceSubscriber(SingleSubscriber<? super T> actual) {
            this.actual = actual;
            add(this.other);
        }

        public void onSuccess(T value) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onSuccess(value);
            }
        }

        public void onError(Throwable error) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onError(error);
                return;
            }
            RxJavaHooks.onError(error);
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class OtherSubscriber extends Subscriber<U> {
            OtherSubscriber() {
            }

            public void onNext(U value) {
                onCompleted();
            }

            public void onError(Throwable error) {
                TakeUntilSourceSubscriber.this.onError(error);
            }

            public void onCompleted() {
                onError(new CancellationException("Single::takeUntil(Observable) - Stream was canceled before emitting a terminal event."));
            }
        }
    }
}