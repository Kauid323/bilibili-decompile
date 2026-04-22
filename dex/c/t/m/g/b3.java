package c.t.m.g;

import android.content.Context;

/* compiled from: TML */
public class b3 {
    public static volatile Context a;

    public static final synchronized void a(Context context) {
        synchronized (b3.class) {
            if (a == null || a.getApplicationContext() == null) {
                if (context != null && context.getApplicationContext() != null) {
                    a = context.getApplicationContext();
                } else {
                    throw new NullPointerException("context cannot be null.");
                }
            }
        }
    }

    public static final void a(boolean z) {
    }

    public static final synchronized Context a() {
        Context context;
        synchronized (b3.class) {
            if (a != null) {
                context = a;
            } else {
                throw new NullPointerException("u should init first.");
            }
        }
        return context;
    }
}