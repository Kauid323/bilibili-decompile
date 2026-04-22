package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public final class SingleTakeUntilCompletable<T> implements Single.OnSubscribe<T> {
    final Completable other;
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleTakeUntilCompletable(Single.OnSubscribe<T> source, Completable other) {
        this.source = source;
        this.other = other;
    }

    public void call(SingleSubscriber<? super T> t) {
        TakeUntilSourceSubscriber<T> parent = new TakeUntilSourceSubscriber<>(t);
        t.add(parent);
        this.other.subscribe(parent);
        this.source.call(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TakeUntilSourceSubscriber<T> extends SingleSubscriber<T> implements CompletableSubscriber {
        final SingleSubscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();

        TakeUntilSourceSubscriber(SingleSubscriber<? super T> actual) {
            this.actual = actual;
        }

        public void onSubscribe(Subscription d) {
            add(d);
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

        public void onCompleted() {
            onError(new CancellationException("Single::takeUntil(Completable) - Stream was canceled before emitting a terminal event."));
        }
    }
}