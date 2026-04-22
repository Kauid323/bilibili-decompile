package c.t.m.g;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: TML */
public class j4 {
    public static final AtomicLong a = new AtomicLong();
    public static final a b = new a("TxLocThreadPool");

    /* renamed from: c  reason: collision with root package name */
    public static final e3 f49c = new e3(10, 10, 30, TimeUnit.SECONDS, new PriorityBlockingQueue(), b);
    public static final e3 d = new e3(1, 1, 5, TimeUnit.MINUTES, new LinkedBlockingQueue(), b);

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class a implements ThreadFactory {
        public static final Set<Thread> b = new CopyOnWriteArraySet();
        public final String a;

        public a(String str) {
            this.a = str + "-Worker-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(null, runnable, this.a, 0L);
            thread.setName(this.a + thread.getId());
            b.add(thread);
            w3.c("ThreadPool", "newThread: " + thread.getName());
            return thread;
        }
    }

    public static void a(t3 t3Var) {
        if (t3Var == null) {
            return;
        }
        t3Var.a(a.getAndIncrement());
        t3Var.b(System.currentTimeMillis());
        f49c.execute(t3Var);
    }

    public static long b(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        return e3Var.a();
    }

    public static long c(int i) {
        int g = g(i);
        if (g <= 0) {
            return 0L;
        }
        long i2 = i(i);
        w3.c("ThreadPool", "sumTime:" + i2 + ", size: " + g);
        return i2 / g;
    }

    public static long d(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        return e3Var.getCompletedTaskCount();
    }

    public static long e(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        return e3Var.b();
    }

    public static long f(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        long j = 0;
        if (g(i) <= 0) {
            return 0L;
        }
        i(i);
        for (Runnable runnable : e3Var.getQueue()) {
            j = Math.max(((t3) runnable).b(), j);
        }
        return j;
    }

    public static int g(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        return e3Var.getQueue().size();
    }

    public static long h(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        return e3Var.getTaskCount();
    }

    public static long i(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        for (Runnable runnable : e3Var.getQueue()) {
            t3 t3Var = (t3) runnable;
            long a2 = currentTimeMillis - t3Var.a();
            t3Var.c(a2);
            j += a2;
        }
        return j;
    }

    public static int a() {
        for (Thread thread : a.b) {
            if (!thread.isAlive()) {
                a.b.remove(thread);
            }
        }
        return a.b.size();
    }

    public static int a(int i) {
        e3 e3Var = f49c;
        if (i == 102) {
            e3Var = d;
        }
        return e3Var.getActiveCount();
    }
}