package c.t.m.g;

/* compiled from: TML */
public class u2 {
    public static a a = a.UNKNOWN;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public enum a {
        UNKNOWN,
        FOREGROUND,
        BACKGROUND
    }

    public static synchronized void a(a aVar) {
        synchronized (u2.class) {
            a = aVar;
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (u2.class) {
            aVar = a;
        }
        return aVar;
    }
}