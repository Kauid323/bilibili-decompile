package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {
    private static final String KEY_NEWTHREAD_PRIORITY = "rx3.newthread-priority";
    private static final RxThreadFactory THREAD_FACTORY;
    private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler";
    final ThreadFactory threadFactory;

    static {
        int priority = Math.max(1, Math.min(10, Integer.getInteger(KEY_NEWTHREAD_PRIORITY, 5).intValue()));
        THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, priority);
    }

    public NewThreadScheduler() {
        this(THREAD_FACTORY);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}