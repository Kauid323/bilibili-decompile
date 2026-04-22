package c.t.m.g;

import android.os.Looper;

/* compiled from: TML */
public abstract class p2 extends e4 {
    public volatile boolean a = false;
    public byte[] b = new byte[0];

    public abstract int a(Looper looper);

    public abstract String a();

    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.a;
        }
        return z;
    }

    public abstract void c();
}