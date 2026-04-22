package c.t.m.g;

import java.util.HashMap;

/* compiled from: TML */
public class d3 {
    public static final HashMap<String, Object> a = new HashMap<>();

    public static synchronized <T> T a(String str, T t) {
        synchronized (d3.class) {
            Object obj = a.get(str);
            if (obj != null) {
                t = obj;
            }
        }
        return t;
    }

    public static synchronized <T> void b(String str, T t) {
        synchronized (d3.class) {
            a.put(str, t);
        }
    }
}