package c.t.m.g;

import java.io.Closeable;

/* compiled from: TML */
public class r3 {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }
}