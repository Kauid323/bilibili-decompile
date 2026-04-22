package c.t.m.g;

/* compiled from: TML */
public class c4 {
    public static void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object is null.");
        }
    }

    public static <T> T a(T t, T t2) {
        a(t2);
        return t == null ? t2 : t;
    }
}