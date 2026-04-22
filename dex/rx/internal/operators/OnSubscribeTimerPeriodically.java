package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

public final class OnSubscribeTimerPeriodically implements Observable.OnSubscribe<Long> {
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public OnSubscribeTimerPeriodically(long initialDelay, long period, TimeUnit unit, Scheduler scheduler) {
        this.initialDelay = initialDelay;
        this.period = period;
        this.unit = unit;
        this.scheduler = scheduler;
    }

    public void call(final Subscriber<? super Long> child) {
        final Scheduler.Worker worker = this.scheduler.createWorker();
        child.add(worker);
        worker.schedulePeriodically(new Action0() { // from class: rx.internal.operators.OnSubscribeTimerPeriodically.1
            long counter;

            public void call() {
                try {
                    Subscriber subscriber = child;
                    long j2 = this.counter;
                    this.counter = 1 + j2;
                    subscriber.onNext(Long.valueOf(j2));
                } catch (Throwable e) {
                    try {
                        worker.unsubscribe();
                    } finally {
                        Exceptions.throwOrReport(e, child);
                    }
                }
            }
        }, this.initialDelay, this.period, this.unit);
    }
}