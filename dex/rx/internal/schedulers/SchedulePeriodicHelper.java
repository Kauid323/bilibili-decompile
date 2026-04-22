package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.subscriptions.SequentialSubscription;

public final class SchedulePeriodicHelper {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface NowNanoSupplier {
        long nowNanos();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription schedulePeriodically(final Scheduler.Worker worker, final Action0 action, long initialDelay, long period, TimeUnit unit, final NowNanoSupplier nowNanoSupplier) {
        final long periodInNanos = unit.toNanos(period);
        final long firstNowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker.now());
        final long firstStartInNanos = firstNowNanos + unit.toNanos(initialDelay);
        SequentialSubscription first = new SequentialSubscription();
        final SequentialSubscription mas = new SequentialSubscription(first);
        Action0 recursiveAction = new Action0() { // from class: rx.internal.schedulers.SchedulePeriodicHelper.1
            long count;
            long lastNowNanos;
            long startInNanos;

            {
                this.lastNowNanos = firstNowNanos;
                this.startInNanos = firstStartInNanos;
            }

            public void call() {
                long nextTick;
                action.call();
                if (!mas.isUnsubscribed()) {
                    long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker.now());
                    if (SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS + nowNanos < this.lastNowNanos || nowNanos >= this.lastNowNanos + periodInNanos + SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS) {
                        nextTick = periodInNanos + nowNanos;
                        long j2 = periodInNanos;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.startInNanos = nextTick - (j2 * j3);
                    } else {
                        long j4 = this.startInNanos;
                        long j5 = this.count + 1;
                        this.count = j5;
                        nextTick = j4 + (j5 * periodInNanos);
                    }
                    this.lastNowNanos = nowNanos;
                    long delay = nextTick - nowNanos;
                    mas.replace(worker.schedule(this, delay, TimeUnit.NANOSECONDS));
                }
            }
        };
        first.replace(worker.schedule(recursiveAction, initialDelay, unit));
        return mas;
    }
}