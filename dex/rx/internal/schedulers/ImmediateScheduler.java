package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class ImmediateScheduler extends Scheduler {
    public static final ImmediateScheduler INSTANCE = new ImmediateScheduler();

    private ImmediateScheduler() {
    }

    public Scheduler.Worker createWorker() {
        return new InnerImmediateScheduler();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class InnerImmediateScheduler extends Scheduler.Worker implements Subscription {
        final BooleanSubscription innerSubscription = new BooleanSubscription();

        InnerImmediateScheduler() {
        }

        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            long execTime = ImmediateScheduler.this.now() + unit.toMillis(delayTime);
            return schedule(new SleepingAction(action, this, execTime));
        }

        public Subscription schedule(Action0 action) {
            action.call();
            return Subscriptions.unsubscribed();
        }

        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }
    }
}