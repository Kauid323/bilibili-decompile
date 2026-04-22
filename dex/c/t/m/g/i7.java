package c.t.m.g;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: TML */
public class i7 {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}