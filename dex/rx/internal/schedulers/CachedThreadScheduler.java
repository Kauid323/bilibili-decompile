package rx.internal.schedulers;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class CachedThreadScheduler extends Scheduler implements SchedulerLifecycle {
    private static final long KEEP_ALIVE_TIME;
    static final CachedWorkerPool NONE;
    final AtomicReference<CachedWorkerPool> pool = new AtomicReference<>(NONE);
    final ThreadFactory threadFactory;
    private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    static final ThreadWorker SHUTDOWN_THREADWORKER = new ThreadWorker(RxThreadFactory.NONE);

    static {
        SHUTDOWN_THREADWORKER.unsubscribe();
        NONE = new CachedWorkerPool(null, 0L, null);
        NONE.shutdown();
        KEEP_ALIVE_TIME = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CachedWorkerPool {
        private final CompositeSubscription allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(final ThreadFactory threadFactory, long keepAliveTime, TimeUnit unit) {
            this.threadFactory = threadFactory;
            this.keepAliveTime = unit != null ? unit.toNanos(keepAliveTime) : 0L;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeSubscription();
            ScheduledExecutorService evictor = null;
            Future<?> task = null;
            if (unit != null) {
                evictor = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable r) {
                        Thread thread = threadFactory.newThread(r);
                        thread.setName(thread.getName() + " (Evictor)");
                        return thread;
                    }
                });
                NewThreadWorker.tryEnableCancelPolicy(evictor);
                task = evictor.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CachedWorkerPool.this.evictExpiredWorkers();
                    }
                }, this.keepAliveTime, this.keepAliveTime, TimeUnit.NANOSECONDS);
            }
            this.evictorService = evictor;
            this.evictorTask = task;
        }

        ThreadWorker get() {
            if (this.allWorkers.isUnsubscribed()) {
                return CachedThreadScheduler.SHUTDOWN_THREADWORKER;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker threadWorker = this.expiringWorkerQueue.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            ThreadWorker w = new ThreadWorker(this.threadFactory);
            this.allWorkers.add(w);
            return w;
        }

        void release(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        void evictExpiredWorkers() {
            if (!this.expiringWorkerQueue.isEmpty()) {
                long currentTimestamp = now();
                Iterator i$ = this.expiringWorkerQueue.iterator();
                while (i$.hasNext()) {
                    ThreadWorker threadWorker = i$.next();
                    if (threadWorker.getExpirationTime() <= currentTimestamp) {
                        if (this.expiringWorkerQueue.remove(threadWorker)) {
                            this.allWorkers.remove(threadWorker);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        long now() {
            return System.nanoTime();
        }

        void shutdown() {
            try {
                if (this.evictorTask != null) {
                    this.evictorTask.cancel(true);
                }
                if (this.evictorService != null) {
                    this.evictorService.shutdownNow();
                }
            } finally {
                this.allWorkers.unsubscribe();
            }
        }
    }

    public CachedThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        CachedWorkerPool update = new CachedWorkerPool(this.threadFactory, KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT);
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.pool, NONE, update)) {
            update.shutdown();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        CachedWorkerPool curr;
        do {
            curr = this.pool.get();
            if (curr == NONE) {
                return;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.pool, curr, NONE));
        curr.shutdown();
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class EventLoopWorker extends Scheduler.Worker implements Action0 {
        private final CompositeSubscription innerSubscription = new CompositeSubscription();
        final AtomicBoolean once = new AtomicBoolean();
        private final CachedWorkerPool pool;
        private final ThreadWorker threadWorker;

        EventLoopWorker(CachedWorkerPool pool) {
            this.pool = pool;
            this.threadWorker = pool.get();
        }

        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.threadWorker.schedule(this);
            }
            this.innerSubscription.unsubscribe();
        }

        public void call() {
            this.pool.release(this.threadWorker);
        }

        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        public Subscription schedule(Action0 action) {
            return schedule(action, 0L, null);
        }

        public Subscription schedule(final Action0 action, long delayTime, TimeUnit unit) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            ScheduledAction s = this.threadWorker.scheduleActual(new Action0() { // from class: rx.internal.schedulers.CachedThreadScheduler.EventLoopWorker.1
                public void call() {
                    if (EventLoopWorker.this.isUnsubscribed()) {
                        return;
                    }
                    action.call();
                }
            }, delayTime, unit);
            this.innerSubscription.add(s);
            s.addParent(this.innerSubscription);
            return s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.expirationTime = 0L;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long expirationTime) {
            this.expirationTime = expirationTime;
        }
    }
}