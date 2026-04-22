package c.t.m.g;

import android.os.HandlerThread;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: TML */
public class n3 {
    public static ConcurrentHashMap<String, HandlerThread> a = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static ConcurrentHashMap<String, Long> f70c = new ConcurrentHashMap<>();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends t3 {
        public final /* synthetic */ Runnable e;

        public a(Runnable runnable) {
            this.e = runnable;
        }

        @Override // c.t.m.g.t3
        public void c() {
            this.e.run();
        }
    }

    public static synchronized HandlerThread a(String str, int i) {
        HandlerThread handlerThread;
        synchronized (n3.class) {
            handlerThread = (HandlerThread) a.get(str);
            if (handlerThread == null) {
                handlerThread = new HandlerThread(str, i);
                handlerThread.start();
                a.put(str, handlerThread);
                b.put(str, 1);
            } else {
                ConcurrentHashMap<String, Integer> concurrentHashMap = b;
                concurrentHashMap.put(str, Integer.valueOf(((Integer) concurrentHashMap.get(str)).intValue() + 1));
            }
        }
        return handlerThread;
    }

    public static synchronized HandlerThread b(String str) {
        HandlerThread a2;
        synchronized (n3.class) {
            a2 = a(str, 0);
        }
        return a2;
    }

    public static void a(String str) {
        a(str, 0L);
    }

    public static synchronized void a(String str, long j) {
        synchronized (n3.class) {
            if (b.containsKey(str)) {
                int intValue = ((Integer) b.get(str)).intValue() - 1;
                if (intValue == 0) {
                    b.remove(str);
                    k4.b((Thread) a.get(str));
                    HandlerThread handlerThread = (HandlerThread) a.remove(str);
                    if (f70c.containsKey(str)) {
                        j = Math.max(j, ((Long) f70c.remove(str)).longValue() - System.currentTimeMillis());
                    }
                    o3.a(handlerThread, null, j, false);
                } else {
                    b.put(str, Integer.valueOf(intValue));
                    if (j != 0) {
                        f70c.put(str, Long.valueOf(Math.max(System.currentTimeMillis() + j, f70c.containsKey(str) ? ((Long) f70c.get(str)).longValue() : 0L)));
                    }
                }
            }
        }
    }

    @Deprecated
    public static synchronized void a(String str, Runnable runnable) {
        synchronized (n3.class) {
            j4.a(new a(runnable));
        }
    }
}