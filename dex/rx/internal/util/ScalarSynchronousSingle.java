package rx.internal.util;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousSingle<T> extends Single<T> {
    final T value;

    public static <T> ScalarSynchronousSingle<T> create(T t) {
        return new ScalarSynchronousSingle<>(t);
    }

    protected ScalarSynchronousSingle(final T t) {
        super(new Single.OnSubscribe<T>() { // from class: rx.internal.util.ScalarSynchronousSingle.1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(SingleSubscriber<? super T> te) {
                te.onSuccess(t);
            }
        });
        this.value = t;
    }

    public T get() {
        return this.value;
    }

    public Single<T> scalarScheduleOn(Scheduler scheduler) {
        if (scheduler instanceof EventLoopsScheduler) {
            EventLoopsScheduler es = (EventLoopsScheduler) scheduler;
            return create((Single.OnSubscribe) new DirectScheduledEmission(es, this.value));
        }
        return create((Single.OnSubscribe) new NormalScheduledEmission(scheduler, this.value));
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class DirectScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final EventLoopsScheduler es;
        private final T value;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((SingleSubscriber) ((SingleSubscriber) x0));
        }

        DirectScheduledEmission(EventLoopsScheduler es, T value) {
            this.es = es;
            this.value = value;
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.add(this.es.scheduleDirect(new ScalarSynchronousSingleAction(singleSubscriber, this.value)));
        }
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class NormalScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final Scheduler scheduler;
        private final T value;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((SingleSubscriber) ((SingleSubscriber) x0));
        }

        NormalScheduledEmission(Scheduler scheduler, T value) {
            this.scheduler = scheduler;
            this.value = value;
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Scheduler.Worker worker = this.scheduler.createWorker();
            singleSubscriber.add(worker);
            worker.schedule(new ScalarSynchronousSingleAction(singleSubscriber, this.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ScalarSynchronousSingleAction<T> implements Action0 {
        private final SingleSubscriber<? super T> subscriber;
        private final T value;

        ScalarSynchronousSingleAction(SingleSubscriber<? super T> subscriber, T value) {
            this.subscriber = subscriber;
            this.value = value;
        }

        public void call() {
            try {
                this.subscriber.onSuccess(this.value);
            } catch (Throwable t) {
                this.subscriber.onError(t);
            }
        }
    }

    public <R> Single<R> scalarFlatMap(final Func1<? super T, ? extends Single<? extends R>> func) {
        return create((Single.OnSubscribe) new Single.OnSubscribe<R>() { // from class: rx.internal.util.ScalarSynchronousSingle.2
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(final SingleSubscriber<? super R> child) {
                Single<? extends R> o = (Single) func.call(ScalarSynchronousSingle.this.value);
                if (o instanceof ScalarSynchronousSingle) {
                    child.onSuccess(((ScalarSynchronousSingle) o).value);
                    return;
                }
                SingleSubscriber<R> subscriber = new SingleSubscriber<R>() { // from class: rx.internal.util.ScalarSynchronousSingle.2.1
                    public void onError(Throwable e) {
                        child.onError(e);
                    }

                    public void onSuccess(R r) {
                        child.onSuccess(r);
                    }
                };
                child.add(subscriber);
                o.subscribe(subscriber);
            }
        });
    }
}