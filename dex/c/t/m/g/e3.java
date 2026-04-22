package c.t.m.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TML */
public class e3 extends ThreadPoolExecutor {
    public ConcurrentHashMap<Integer, Long> a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f26c;

    static {
        new PriorityBlockingQueue();
    }

    public e3(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.a = new ConcurrentHashMap<>();
        allowCoreThreadTimeOut(true);
    }

    public long a() {
        if (getCompletedTaskCount() > 0) {
            long j = this.f26c;
            if (j > 0) {
                return j / getCompletedTaskCount();
            }
        }
        return 0L;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (runnable == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - ((Long) this.a.remove(Integer.valueOf(runnable.hashCode()))).longValue();
        this.f26c += currentTimeMillis;
        this.b = Math.max(currentTimeMillis, this.b);
    }

    public long b() {
        return this.b;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable == null) {
            return;
        }
        this.a.put(Integer.valueOf(runnable.hashCode()), Long.valueOf(System.currentTimeMillis()));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        return super.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        super.shutdown();
        w3.c("ThreadPool", String.format("thread pool shutdown, AvgCostTime: %d, MaxCostTime: %d, TaskCount: %d, CompletedTaskCount: %d", Long.valueOf(a()), Long.valueOf(b()), Long.valueOf(getTaskCount()), Long.valueOf(getCompletedTaskCount())));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        w3.c("ThreadPool", String.format("thread pool shutdownNow, AvgCostTime: %d, MaxCostTime: %d, TaskCount: %d, CompletedTaskCount: %d", Long.valueOf(a()), Long.valueOf(b()), Long.valueOf(getTaskCount()), Long.valueOf(getCompletedTaskCount())));
        return super.shutdownNow();
    }
}