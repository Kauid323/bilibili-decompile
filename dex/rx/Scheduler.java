package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.SchedulePeriodicHelper;
import rx.internal.schedulers.SchedulerWhen;

public abstract class Scheduler {
    public abstract Worker createWorker();

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class Worker implements Subscription {
        public abstract Subscription schedule(Action0 action0);

        public abstract Subscription schedule(Action0 action0, long j, TimeUnit timeUnit);

        public Subscription schedulePeriodically(Action0 action, long initialDelay, long period, TimeUnit unit) {
            return SchedulePeriodicHelper.schedulePeriodically(this, action, initialDelay, period, unit, (SchedulePeriodicHelper.NowNanoSupplier) null);
        }

        public long now() {
            return System.currentTimeMillis();
        }
    }

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends Scheduler & Subscription> S when(Func1<Observable<Observable<Completable>>, Completable> combine) {
        return new SchedulerWhen(combine, this);
    }
}