package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorDelay<T> implements Observable.Operator<T, T> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDelay(long delay, TimeUnit unit, Scheduler scheduler) {
        this.delay = delay;
        this.unit = unit;
        this.scheduler = scheduler;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        Scheduler.Worker worker = this.scheduler.createWorker();
        child.add(worker);
        return new AnonymousClass1(child, worker, child);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.OperatorDelay$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public class AnonymousClass1 extends Subscriber<T> {
        boolean done;
        final /* synthetic */ Subscriber val$child;
        final /* synthetic */ Scheduler.Worker val$worker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Subscriber subscriber, Scheduler.Worker worker, Subscriber subscriber2) {
            super(subscriber);
            this.val$worker = worker;
            this.val$child = subscriber2;
        }

        public void onCompleted() {
            this.val$worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorDelay.1.1
                public void call() {
                    if (!AnonymousClass1.this.done) {
                        AnonymousClass1.this.done = true;
                        AnonymousClass1.this.val$child.onCompleted();
                    }
                }
            }, OperatorDelay.this.delay, OperatorDelay.this.unit);
        }

        public void onError(final Throwable e) {
            this.val$worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorDelay.1.2
                public void call() {
                    if (!AnonymousClass1.this.done) {
                        AnonymousClass1.this.done = true;
                        AnonymousClass1.this.val$child.onError(e);
                        AnonymousClass1.this.val$worker.unsubscribe();
                    }
                }
            });
        }

        public void onNext(final T t) {
            this.val$worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorDelay.1.3
                public void call() {
                    if (!AnonymousClass1.this.done) {
                        AnonymousClass1.this.val$child.onNext(t);
                    }
                }
            }, OperatorDelay.this.delay, OperatorDelay.this.unit);
        }
    }
}