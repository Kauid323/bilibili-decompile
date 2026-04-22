package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorSubscribeOn<T> implements Observable.OnSubscribe<T> {
    final boolean requestOn;
    final Scheduler scheduler;
    final Observable<T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OperatorSubscribeOn(Observable<T> source, Scheduler scheduler, boolean requestOn) {
        this.scheduler = scheduler;
        this.source = source;
        this.requestOn = requestOn;
    }

    public void call(Subscriber<? super T> subscriber) {
        Scheduler.Worker inner = this.scheduler.createWorker();
        SubscribeOnSubscriber<T> parent = new SubscribeOnSubscriber<>(subscriber, this.requestOn, inner, this.source);
        subscriber.add(parent);
        subscriber.add(inner);
        inner.schedule(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SubscribeOnSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> actual;
        final boolean requestOn;
        Observable<T> source;
        Thread t;
        final Scheduler.Worker worker;

        SubscribeOnSubscriber(Subscriber<? super T> actual, boolean requestOn, Scheduler.Worker worker, Observable<T> source) {
            this.actual = actual;
            this.requestOn = requestOn;
            this.worker = worker;
            this.source = source;
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable e) {
            try {
                this.actual.onError(e);
            } finally {
                this.worker.unsubscribe();
            }
        }

        public void onCompleted() {
            try {
                this.actual.onCompleted();
            } finally {
                this.worker.unsubscribe();
            }
        }

        public void call() {
            Observable<T> src = this.source;
            this.source = null;
            this.t = Thread.currentThread();
            src.unsafeSubscribe(this);
        }

        public void setProducer(final Producer p) {
            this.actual.setProducer(new Producer() { // from class: rx.internal.operators.OperatorSubscribeOn.SubscribeOnSubscriber.1
                public void request(final long n) {
                    if (SubscribeOnSubscriber.this.t == Thread.currentThread() || !SubscribeOnSubscriber.this.requestOn) {
                        p.request(n);
                    } else {
                        SubscribeOnSubscriber.this.worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorSubscribeOn.SubscribeOnSubscriber.1.1
                            public void call() {
                                p.request(n);
                            }
                        });
                    }
                }
            });
        }
    }
}