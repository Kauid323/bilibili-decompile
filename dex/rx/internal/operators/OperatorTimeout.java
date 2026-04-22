package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.operators.OperatorTimeoutBase;

public final class OperatorTimeout<T> extends OperatorTimeoutBase<T> {
    @Override // rx.internal.operators.OperatorTimeoutBase
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber x0) {
        return super.call(x0);
    }

    public OperatorTimeout(final long timeout, final TimeUnit timeUnit, Observable<? extends T> other, Scheduler scheduler) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() { // from class: rx.internal.operators.OperatorTimeout.1
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1, Object x2) {
                return call((OperatorTimeoutBase.TimeoutSubscriber) ((OperatorTimeoutBase.TimeoutSubscriber) x0), (Long) x1, (Scheduler.Worker) x2);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long seqId, Scheduler.Worker inner) {
                return inner.schedule(new Action0() { // from class: rx.internal.operators.OperatorTimeout.1.1
                    public void call() {
                        timeoutSubscriber.onTimeout(seqId.longValue());
                    }
                }, timeout, timeUnit);
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() { // from class: rx.internal.operators.OperatorTimeout.2
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1, Object x2, Object x3) {
                return call((OperatorTimeoutBase.TimeoutSubscriber<Long>) x0, (Long) x1, (Long) x2, (Scheduler.Worker) x3);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long seqId, T value, Scheduler.Worker inner) {
                return inner.schedule(new Action0() { // from class: rx.internal.operators.OperatorTimeout.2.1
                    public void call() {
                        timeoutSubscriber.onTimeout(seqId.longValue());
                    }
                }, timeout, timeUnit);
            }
        }, other, scheduler);
    }
}