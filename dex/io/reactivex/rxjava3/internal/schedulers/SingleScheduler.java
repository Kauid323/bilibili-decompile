package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx3.single-priority";
    static final ScheduledExecutorService SHUTDOWN = Executors.newScheduledThreadPool(0);
    static final RxThreadFactory SINGLE_THREAD_FACTORY;
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";
    final AtomicReference<ScheduledExecutorService> executor;
    final ThreadFactory threadFactory;

    static {
        SHUTDOWN.shutdown();
        int priority = Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5).intValue()));
        SINGLE_THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, priority, true);
    }

    public SingleScheduler() {
        this(SINGLE_THREAD_FACTORY);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        this.executor = new AtomicReference<>();
        this.threadFactory = threadFactory;
        this.executor.lazySet(createExecutor(threadFactory));
    }

    static ScheduledExecutorService createExecutor(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.create(threadFactory);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void start() {
        ScheduledExecutorService current;
        ScheduledExecutorService next = null;
        do {
            current = this.executor.get();
            if (current != SHUTDOWN) {
                if (next != null) {
                    next.shutdown();
                    return;
                }
                return;
            } else if (next == null) {
                next = createExecutor(this.threadFactory);
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.executor, current, next));
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        ScheduledExecutorService current = this.executor.getAndSet(SHUTDOWN);
        if (current != SHUTDOWN) {
            current.shutdownNow();
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.executor.get());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
        Future<?> f;
        ScheduledDirectTask task = new ScheduledDirectTask(RxJavaPlugins.onSchedule(run));
        try {
            if (delay <= 0) {
                f = this.executor.get().submit(task);
            } else {
                f = this.executor.get().schedule(task, delay, unit);
            }
            task.setFuture(f);
            return task;
        } catch (RejectedExecutionException ex) {
            RxJavaPlugins.onError(ex);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable run, long initialDelay, long period, TimeUnit unit) {
        Future<?> f;
        Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
        if (period <= 0) {
            ScheduledExecutorService exec = this.executor.get();
            InstantPeriodicTask periodicWrapper = new InstantPeriodicTask(decoratedRun, exec);
            try {
                if (initialDelay <= 0) {
                    f = exec.submit(periodicWrapper);
                } else {
                    f = exec.schedule(periodicWrapper, initialDelay, unit);
                }
                periodicWrapper.setFirst(f);
                return periodicWrapper;
            } catch (RejectedExecutionException ex) {
                RxJavaPlugins.onError(ex);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask task = new ScheduledDirectPeriodicTask(decoratedRun);
        try {
            Future<?> f2 = this.executor.get().scheduleAtFixedRate(task, initialDelay, period, unit);
            task.setFuture(f2);
            return task;
        } catch (RejectedExecutionException ex2) {
            RxJavaPlugins.onError(ex2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ScheduledWorker extends Scheduler.Worker {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final CompositeDisposable tasks = new CompositeDisposable();

        ScheduledWorker(ScheduledExecutorService executor) {
            this.executor = executor;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable run, long delay, TimeUnit unit) {
            Future<?> f;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
            ScheduledRunnable sr = new ScheduledRunnable(decoratedRun, this.tasks);
            this.tasks.add(sr);
            try {
                if (delay <= 0) {
                    f = this.executor.submit((Callable) sr);
                } else {
                    f = this.executor.schedule((Callable) sr, delay, unit);
                }
                sr.setFuture(f);
                return sr;
            } catch (RejectedExecutionException ex) {
                dispose();
                RxJavaPlugins.onError(ex);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}