package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {
    static final Scheduler HELPER = Schedulers.single();
    final Executor executor;
    final boolean fair;
    final boolean interruptibleWorker;

    public ExecutorScheduler(Executor executor, boolean interruptibleWorker, boolean fair) {
        this.executor = executor;
        this.interruptibleWorker = interruptibleWorker;
        this.fair = fair;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.executor, this.interruptibleWorker, this.fair);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable run) {
        Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
        try {
            if (this.executor instanceof ExecutorService) {
                ScheduledDirectTask task = new ScheduledDirectTask(decoratedRun);
                Future<?> f = ((ExecutorService) this.executor).submit(task);
                task.setFuture(f);
                return task;
            } else if (this.interruptibleWorker) {
                ExecutorWorker.InterruptibleRunnable interruptibleTask = new ExecutorWorker.InterruptibleRunnable(decoratedRun, null);
                this.executor.execute(interruptibleTask);
                return interruptibleTask;
            } else {
                ExecutorWorker.BooleanRunnable br = new ExecutorWorker.BooleanRunnable(decoratedRun);
                this.executor.execute(br);
                return br;
            }
        } catch (RejectedExecutionException ex) {
            RxJavaPlugins.onError(ex);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable run, final long delay, final TimeUnit unit) {
        Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
        if (this.executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask task = new ScheduledDirectTask(decoratedRun);
                Future<?> f = ((ScheduledExecutorService) this.executor).schedule(task, delay, unit);
                task.setFuture(f);
                return task;
            } catch (RejectedExecutionException ex) {
                RxJavaPlugins.onError(ex);
                return EmptyDisposable.INSTANCE;
            }
        }
        DelayedRunnable dr = new DelayedRunnable(decoratedRun);
        Disposable delayed = HELPER.scheduleDirect(new DelayedDispose(dr), delay, unit);
        dr.timed.replace(delayed);
        return dr;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable run, long initialDelay, long period, TimeUnit unit) {
        if (this.executor instanceof ScheduledExecutorService) {
            Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
            try {
                ScheduledDirectPeriodicTask task = new ScheduledDirectPeriodicTask(decoratedRun);
                Future<?> f = ((ScheduledExecutorService) this.executor).scheduleAtFixedRate(task, initialDelay, period, unit);
                task.setFuture(f);
                return task;
            } catch (RejectedExecutionException ex) {
                RxJavaPlugins.onError(ex);
                return EmptyDisposable.INSTANCE;
            }
        }
        return super.schedulePeriodicallyDirect(run, initialDelay, period, unit);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        volatile boolean disposed;
        final Executor executor;
        final boolean fair;
        final boolean interruptibleWorker;
        final AtomicInteger wip = new AtomicInteger();
        final CompositeDisposable tasks = new CompositeDisposable();
        final MpscLinkedQueue<Runnable> queue = new MpscLinkedQueue<>();

        public ExecutorWorker(Executor executor, boolean interruptibleWorker, boolean fair) {
            this.executor = executor;
            this.interruptibleWorker = interruptibleWorker;
            this.fair = fair;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable run) {
            Disposable disposable;
            Disposable disposable2;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
            if (this.interruptibleWorker) {
                disposable = new InterruptibleRunnable(decoratedRun, this.tasks);
                this.tasks.add(disposable);
                disposable2 = disposable;
            } else {
                disposable = new BooleanRunnable(decoratedRun);
                disposable2 = disposable;
            }
            this.queue.offer(disposable2);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException ex) {
                    this.disposed = true;
                    this.queue.clear();
                    RxJavaPlugins.onError(ex);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return disposable;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable run, long delay, TimeUnit unit) {
            if (delay <= 0) {
                return schedule(run);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable first = new SequentialDisposable();
            SequentialDisposable mar = new SequentialDisposable(first);
            Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
            ScheduledRunnable sr = new ScheduledRunnable(new SequentialDispose(mar, decoratedRun), this.tasks);
            this.tasks.add(sr);
            if (this.executor instanceof ScheduledExecutorService) {
                try {
                    Future<?> f = ((ScheduledExecutorService) this.executor).schedule((Callable) sr, delay, unit);
                    sr.setFuture(f);
                } catch (RejectedExecutionException ex) {
                    this.disposed = true;
                    RxJavaPlugins.onError(ex);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                Disposable d = ExecutorScheduler.HELPER.scheduleDirect(sr, delay, unit);
                sr.setFuture(new DisposeOnCancel(d));
            }
            first.replace(sr);
            return mar;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
                if (this.wip.getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fair) {
                runFair();
            } else {
                runEager();
            }
        }

        void runFair() {
            MpscLinkedQueue<Runnable> q = this.queue;
            if (this.disposed) {
                q.clear();
                return;
            }
            Runnable run = q.poll();
            run.run();
            if (this.disposed) {
                q.clear();
            } else if (this.wip.decrementAndGet() != 0) {
                this.executor.execute(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
            if (r4.disposed == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
            r1.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
            r0 = r4.wip.addAndGet(-r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r0 != 0) goto L2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void runEager() {
            int missed = 1;
            MpscLinkedQueue<Runnable> q = this.queue;
            while (!this.disposed) {
                while (true) {
                    Runnable run = q.poll();
                    if (run == null) {
                        break;
                    }
                    run.run();
                    if (this.disposed) {
                        q.clear();
                        return;
                    }
                }
            }
            q.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable actual) {
                this.actual = actual;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                }
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class SequentialDispose implements Runnable {
            private final Runnable decoratedRun;
            private final SequentialDisposable mar;

            SequentialDispose(SequentialDisposable mar, Runnable decoratedRun) {
                this.mar = mar;
                this.decoratedRun = decoratedRun;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mar.replace(ExecutorWorker.this.schedule(this.decoratedRun));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final DisposableContainer tasks;
            volatile Thread thread;

            InterruptibleRunnable(Runnable run, DisposableContainer tasks) {
                this.run = run;
                this.tasks = tasks;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.run.run();
                            this.thread = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                                return;
                            }
                            cleanup();
                            return;
                        } catch (Throwable ex) {
                            try {
                                RxJavaPlugins.onError(ex);
                                throw ex;
                            } catch (Throwable ex2) {
                                this.thread = null;
                                if (!compareAndSet(1, 2)) {
                                    while (get() == 3) {
                                        Thread.yield();
                                    }
                                    Thread.interrupted();
                                } else {
                                    cleanup();
                                }
                                throw ex2;
                            }
                        }
                    }
                    this.thread = null;
                }
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                while (true) {
                    int state = get();
                    if (state >= 2) {
                        return;
                    }
                    if (state == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread t = this.thread;
                        if (t != null) {
                            t.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            void cleanup() {
                if (this.tasks != null) {
                    this.tasks.delete(this);
                }
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get() >= 2;
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        DelayedRunnable(Runnable run) {
            super(run);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r = get();
            if (r != null) {
                try {
                    r.run();
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                } catch (Throwable ex) {
                    RxJavaPlugins.onError(ex);
                    throw ex;
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            Runnable r = get();
            return r != null ? r : Functions.EMPTY_RUNNABLE;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    final class DelayedDispose implements Runnable {
        private final DelayedRunnable dr;

        DelayedDispose(DelayedRunnable dr) {
            this.dr = dr;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dr.direct.replace(ExecutorScheduler.this.scheduleDirect(this.dr));
        }
    }
}