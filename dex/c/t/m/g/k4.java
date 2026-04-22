package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import java.lang.Thread;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: TML */
public class k4 {
    public static final byte[] a = new byte[0];
    public static final List<Thread> b = new CopyOnWriteArrayList();

    public static void a(Handler... handlerArr) {
        for (Handler handler : handlerArr) {
            Looper looper = handler.getLooper();
            if (looper != null) {
                a(looper);
            }
        }
    }

    public static void b(Thread... threadArr) {
        synchronized (a) {
            for (Thread thread : threadArr) {
                if (thread != null && b.contains(thread)) {
                    b.remove(thread);
                    w3.a("TxThreadMonitorUtil", "remove monitor thread: " + thread.getName() + "," + thread.getId());
                }
            }
        }
    }

    public static void a(Looper... looperArr) {
        for (Looper looper : looperArr) {
            Thread thread = looper.getThread();
            if (thread != null) {
                a(thread);
            }
        }
    }

    public static void a(Thread... threadArr) {
        synchronized (a) {
            for (Thread thread : threadArr) {
                if (thread != null && !b.contains(thread)) {
                    b.add(thread);
                    w3.a("TxThreadMonitorUtil", "add monitor thread: " + thread.getName() + "," + thread.getId());
                }
            }
        }
    }

    public static List<Thread> b() {
        return b;
    }

    public static void a() {
        synchronized (a) {
            b.clear();
        }
    }

    public static boolean a(Thread thread) {
        try {
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.TIMED_WAITING) {
                return false;
            }
            return state != Thread.State.TERMINATED;
        } catch (Throwable th) {
            w3.a("TxThreadMonitorUtil", "", th);
            return true;
        }
    }
}