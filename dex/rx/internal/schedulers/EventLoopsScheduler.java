package rx.internal.schedulers;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {
    static final String KEY_MAX_THREADS = "rx.scheduler.max-computation-threads";
    static final int MAX_THREADS;
    static final FixedSchedulerPool NONE;
    static final PoolWorker SHUTDOWN_WORKER;
    final AtomicReference<FixedSchedulerPool> pool = new AtomicReference<>(NONE);
    final ThreadFactory threadFactory;

    static {
        int max;
        int maxThreads = Integer.getInteger(KEY_MAX_THREADS, 0).intValue();
        int cpuCount = Runtime.getRuntime().availableProcessors();
        if (maxThreads <= 0 || maxThreads > cpuCount) {
            max = cpuCount;
        } else {
            max = maxThreads;
        }
        MAX_THREADS = max;
        SHUTDOWN_WORKER = new PoolWorker(RxThreadFactory.NONE);
        SHUTDOWN_WORKER.unsubscribe();
        NONE = new FixedSchedulerPool(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class FixedSchedulerPool {
        final int cores;
        final PoolWorker[] eventLoops;
        long n;

        FixedSchedulerPool(ThreadFactory threadFactory, int maxThreads) {
            this.cores = maxThreads;
            this.eventLoops = new PoolWorker[maxThreads];
            for (int i = 0; i < maxThreads; i++) {
                this.eventLoops[i] = new PoolWorker(threadFactory);
            }
        }

        public PoolWorker getEventLoop() {
            int c = this.cores;
            if (c == 0) {
                return EventLoopsScheduler.SHUTDOWN_WORKER;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j2 = this.n;
            this.n = 1 + j2;
            return poolWorkerArr[(int) (j2 % c)];
        }

        public void shutdown() {
            PoolWorker[] arr$ = this.eventLoops;
            for (PoolWorker w : arr$) {
                w.unsubscribe();
            }
        }
    }

    public EventLoopsScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        start();
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        FixedSchedulerPool update = new FixedSchedulerPool(this.threadFactory, MAX_THREADS);
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.pool, NONE, update)) {
            update.shutdown();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        FixedSchedulerPool curr;
        do {
            curr = this.pool.get();
            if (curr == NONE) {
                return;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.pool, curr, NONE));
        curr.shutdown();
    }

    public Subscription scheduleDirect(Action0 action) {
        PoolWorker pw = this.pool.get().getEventLoop();
        return pw.scheduleActual(action, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class EventLoopWorker extends Scheduler.Worker {
        private final PoolWorker poolWorker;
        private final SubscriptionList serial = new SubscriptionList();
        private final CompositeSubscription timed = new CompositeSubscription();
        private final SubscriptionList both = new SubscriptionList(new Subscription[]{this.serial, this.timed});

        EventLoopWorker(PoolWorker poolWorker) {
            this.poolWorker = poolWorker;
        }

        public void unsubscribe() {
            this.both.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.both.isUnsubscribed();
        }

        public Subscription schedule(final Action0 action) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(new Action0() { // from class: rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker.1
                public void call() {
                    if (EventLoopWorker.this.isUnsubscribed()) {
                        return;
                    }
                    action.call();
                }
            }, 0L, (TimeUnit) null, this.serial);
        }

        public Subscription schedule(final Action0 action, long delayTime, TimeUnit unit) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(new Action0() { // from class: rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker.2
                public void call() {
                    if (EventLoopWorker.this.isUnsubscribed()) {
                        return;
                    }
                    action.call();
                }
            }, delayTime, unit, this.timed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}