package c.t.m.g;

import android.os.Looper;

/* compiled from: TML */
public abstract class n2 extends o2 {
    public int a(Looper looper) {
        synchronized (this.b) {
            if (this.a) {
                return -1;
            }
            this.a = true;
            if (w3.a()) {
                w3.a(a(), "startup()");
            }
            return b(looper);
        }
    }

    public abstract int b(Looper looper);

    public int e() {
        return a(Looper.myLooper());
    }
}