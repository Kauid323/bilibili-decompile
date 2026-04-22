package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class TestScheduler extends Scheduler {
    long counter;
    final Queue<TimedRunnable> queue = new PriorityBlockingQueue(11);
    volatile long time;

    public TestScheduler() {
    }

    public TestScheduler(long delayTime, TimeUnit unit) {
        this.time = unit.toNanos(delayTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long count;
        final Runnable run;
        final TestWorker scheduler;
        final long time;

        TimedRunnable(TestWorker scheduler, long time, Runnable run, long count) {
            this.time = time;
            this.run = run;
            this.scheduler = scheduler;
            this.count = count;
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.time), this.run.toString());
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable o) {
            if (this.time == o.time) {
                return Long.compare(this.count, o.count);
            }
            return Long.compare(this.time, o.time);
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public long now(TimeUnit unit) {
        return unit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public void advanceTimeBy(long delayTime, TimeUnit unit) {
        advanceTimeTo(this.time + unit.toNanos(delayTime), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long delayTime, TimeUnit unit) {
        long targetTime = unit.toNanos(delayTime);
        triggerActions(targetTime);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long targetTimeInNanoseconds) {
        while (true) {
            TimedRunnable current = this.queue.peek();
            if (current == null || current.time > targetTimeInNanoseconds) {
                break;
            }
            this.time = current.time == 0 ? this.time : current.time;
            this.queue.remove(current);
            if (!current.scheduler.disposed) {
                current.run.run();
            }
        }
        this.time = targetTimeInNanoseconds;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class TestWorker extends Scheduler.Worker {
        volatile boolean disposed;

        TestWorker() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable run, long delayTime, TimeUnit unit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = unit.toNanos(delayTime) + TestScheduler.this.time;
            TestScheduler testScheduler = TestScheduler.this;
            long j2 = testScheduler.counter;
            testScheduler.counter = 1 + j2;
            TimedRunnable timedAction = new TimedRunnable(this, nanos, run, j2);
            TestScheduler.this.queue.add(timedAction);
            return Disposable.CC.fromRunnable(new QueueRemove(timedAction));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable run) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j2 = testScheduler.counter;
            testScheduler.counter = 1 + j2;
            TimedRunnable timedAction = new TimedRunnable(this, 0L, run, j2);
            TestScheduler.this.queue.add(timedAction);
            return Disposable.CC.fromRunnable(new QueueRemove(timedAction));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public long now(TimeUnit unit) {
            return TestScheduler.this.now(unit);
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class QueueRemove implements Runnable {
            final TimedRunnable timedAction;

            QueueRemove(TimedRunnable timedAction) {
                this.timedAction = timedAction;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestScheduler.this.queue.remove(this.timedAction);
            }
        }
    }
}