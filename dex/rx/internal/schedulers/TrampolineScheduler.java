package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    public Scheduler.Worker createWorker() {
        return new InnerCurrentThreadScheduler();
    }

    private TrampolineScheduler() {
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class InnerCurrentThreadScheduler extends Scheduler.Worker implements Subscription {
        final AtomicInteger counter = new AtomicInteger();
        final PriorityBlockingQueue<TimedAction> queue = new PriorityBlockingQueue<>();
        private final BooleanSubscription innerSubscription = new BooleanSubscription();
        private final AtomicInteger wip = new AtomicInteger();

        InnerCurrentThreadScheduler() {
        }

        public Subscription schedule(Action0 action) {
            return enqueue(action, now());
        }

        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            long execTime = now() + unit.toMillis(delayTime);
            return enqueue(new SleepingAction(action, this, execTime), execTime);
        }

        private Subscription enqueue(Action0 action, long execTime) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final TimedAction timedAction = new TimedAction(action, Long.valueOf(execTime), this.counter.incrementAndGet());
            this.queue.add(timedAction);
            if (this.wip.getAndIncrement() == 0) {
                do {
                    TimedAction polled = this.queue.poll();
                    if (polled != null) {
                        polled.action.call();
                    }
                } while (this.wip.decrementAndGet() > 0);
                return Subscriptions.unsubscribed();
            }
            return Subscriptions.create(new Action0() { // from class: rx.internal.schedulers.TrampolineScheduler.InnerCurrentThreadScheduler.1
                public void call() {
                    InnerCurrentThreadScheduler.this.queue.remove(timedAction);
                }
            });
        }

        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TimedAction implements Comparable<TimedAction> {
        final Action0 action;
        final int count;
        final Long execTime;

        TimedAction(Action0 action, Long execTime, int count) {
            this.action = action;
            this.execTime = execTime;
            this.count = count;
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedAction that) {
            int result = this.execTime.compareTo(that.execTime);
            if (result == 0) {
                return TrampolineScheduler.compare(this.count, that.count);
            }
            return result;
        }
    }

    static int compare(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }
}