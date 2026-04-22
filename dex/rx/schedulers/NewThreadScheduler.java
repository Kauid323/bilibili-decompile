package rx.schedulers;

import rx.Scheduler;

@Deprecated
public final class NewThreadScheduler extends Scheduler {
    private NewThreadScheduler() {
        throw new IllegalStateException("No instances!");
    }

    public Scheduler.Worker createWorker() {
        return null;
    }
}