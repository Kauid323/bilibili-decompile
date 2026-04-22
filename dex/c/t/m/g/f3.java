package c.t.m.g;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: TML */
public class f3 {
    public static HashMap<String, ThreadLocal<SimpleDateFormat>> a = new HashMap<>();

    public static String a(String str) {
        return a(str, System.currentTimeMillis());
    }

    public static synchronized SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat;
        synchronized (f3.class) {
            ThreadLocal<SimpleDateFormat> threadLocal = a.get(str);
            if (threadLocal == null) {
                threadLocal = new ThreadLocal<>();
                a.put(str, threadLocal);
            }
            simpleDateFormat = threadLocal.get();
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
                threadLocal.set(simpleDateFormat);
            }
        }
        return simpleDateFormat;
    }

    public static String a(String str, long j) {
        return b(str).format(new Date(j));
    }
}