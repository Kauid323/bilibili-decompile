package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.NewThreadWorker;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import j$.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = computeClockDrift(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    public abstract Worker createWorker();

    static long computeClockDrift(long time, String timeUnit) {
        if ("seconds".equalsIgnoreCase(timeUnit)) {
            return TimeUnit.SECONDS.toNanos(time);
        }
        if ("milliseconds".equalsIgnoreCase(timeUnit)) {
            return TimeUnit.MILLISECONDS.toNanos(time);
        }
        return TimeUnit.MINUTES.toNanos(time);
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public long now(TimeUnit unit) {
        return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public void shutdown() {
    }

    public Disposable scheduleDirect(Runnable run) {
        return scheduleDirect(run, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
        Worker w = createWorker();
        Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
        DisposeTask task = new DisposeTask(decoratedRun, w);
        w.schedule(task, delay, unit);
        return task;
    }

    public Disposable schedulePeriodicallyDirect(Runnable run, long initialDelay, long period, TimeUnit unit) {
        Worker w = createWorker();
        Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
        PeriodicDirectTask periodicTask = new PeriodicDirectTask(decoratedRun, w);
        Disposable d = w.schedulePeriodically(periodicTask, initialDelay, period, unit);
        return d == EmptyDisposable.INSTANCE ? d : periodicTask;
    }

    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> combine) {
        Objects.requireNonNull(combine, "combine is null");
        return new SchedulerWhen(combine, this);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class Worker implements Disposable {
        public abstract Disposable schedule(Runnable run, long delay, TimeUnit unit);

        public Disposable schedule(Runnable run) {
            return schedule(run, 0L, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable run, final long initialDelay, final long period, final TimeUnit unit) {
            SequentialDisposable first = new SequentialDisposable();
            SequentialDisposable sd = new SequentialDisposable(first);
            Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
            long periodInNanoseconds = unit.toNanos(period);
            long firstNowNanoseconds = now(TimeUnit.NANOSECONDS);
            long firstStartInNanoseconds = firstNowNanoseconds + unit.toNanos(initialDelay);
            Disposable d = schedule(new PeriodicTask(firstStartInNanoseconds, decoratedRun, firstNowNanoseconds, sd, periodInNanoseconds), initialDelay, unit);
            if (d == EmptyDisposable.INSTANCE) {
                return d;
            }
            first.replace(d);
            return sd;
        }

        public long now(TimeUnit unit) {
            return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;
            final SequentialDisposable sd;
            long startInNanoseconds;

            PeriodicTask(long firstStartInNanoseconds, Runnable decoratedRun, long firstNowNanoseconds, SequentialDisposable sd, long periodInNanoseconds) {
                this.decoratedRun = decoratedRun;
                this.sd = sd;
                this.periodInNanoseconds = periodInNanoseconds;
                this.lastNowNanoseconds = firstNowNanoseconds;
                this.startInNanoseconds = firstStartInNanoseconds;
            }

            @Override // java.lang.Runnable
            public void run() {
                long nextTick;
                this.decoratedRun.run();
                if (!this.sd.isDisposed()) {
                    long nowNanoseconds = Worker.this.now(TimeUnit.NANOSECONDS);
                    if (Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS + nowNanoseconds < this.lastNowNanoseconds || nowNanoseconds >= this.lastNowNanoseconds + this.periodInNanoseconds + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS) {
                        nextTick = this.periodInNanoseconds + nowNanoseconds;
                        long j2 = this.periodInNanoseconds;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.startInNanoseconds = nextTick - (j2 * j3);
                    } else {
                        long j4 = this.startInNanoseconds;
                        long j5 = this.count + 1;
                        this.count = j5;
                        nextTick = j4 + (j5 * this.periodInNanoseconds);
                    }
                    this.lastNowNanoseconds = nowNanoseconds;
                    long delay = nextTick - nowNanoseconds;
                    this.sd.replace(Worker.this.schedule(this, delay, TimeUnit.NANOSECONDS));
                }
            }

            @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        PeriodicDirectTask(Runnable run, Worker worker) {
            this.run = run;
            this.worker = worker;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.run.run();
                } catch (Throwable ex) {
                    dispose();
                    RxJavaPlugins.onError(ex);
                    throw ex;
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.run;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        final Runnable decoratedRun;
        Thread runner;
        final Worker w;

        DisposeTask(Runnable decoratedRun, Worker w) {
            this.decoratedRun = decoratedRun;
            this.w = w;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.w instanceof NewThreadWorker)) {
                ((NewThreadWorker) this.w).shutdown();
            } else {
                this.w.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }
    }
}