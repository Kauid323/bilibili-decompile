package rx.internal.operators;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;

public final class SingleObserveOn<T> implements Single.OnSubscribe<T> {
    final Scheduler scheduler;
    final Single.OnSubscribe<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleObserveOn(Single.OnSubscribe<T> source, Scheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    public void call(SingleSubscriber<? super T> t) {
        Scheduler.Worker w = this.scheduler.createWorker();
        ObserveOnSingleSubscriber<T> parent = new ObserveOnSingleSubscriber<>(t, w);
        t.add(w);
        t.add(parent);
        this.source.call(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        final SingleSubscriber<? super T> actual;
        Throwable error;
        T value;
        final Scheduler.Worker w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> actual, Scheduler.Worker w) {
            this.actual = actual;
            this.w = w;
        }

        public void onSuccess(T value) {
            this.value = value;
            this.w.schedule(this);
        }

        public void onError(Throwable error) {
            this.error = error;
            this.w.schedule(this);
        }

        public void call() {
            try {
                Throwable ex = this.error;
                if (ex != null) {
                    this.error = null;
                    this.actual.onError(ex);
                } else {
                    T v = this.value;
                    this.value = null;
                    this.actual.onSuccess(v);
                }
            } finally {
                this.w.unsubscribe();
            }
        }
    }
}