package c.t.m.g;

import android.content.Context;

/* compiled from: TML */
public class l7 implements u4 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile l7 f61c;
    public boolean a = true;
    public p7 b;

    public l7(Context context) {
        this.b = new p7(context);
    }

    public static l7 a(Context context) {
        if (f61c == null) {
            synchronized (l7.class) {
                if (f61c == null) {
                    if (context != null) {
                        f61c = new l7(context);
                    } else {
                        throw new NullPointerException("context is null");
                    }
                }
            }
        }
        return f61c;
    }

    @Override // c.t.m.g.u4
    public double[] getPosition() {
        return this.b.b();
    }

    @Override // c.t.m.g.u4
    public boolean isSupport() {
        return this.b.d();
    }

    @Override // c.t.m.g.u4
    public int startDrEngine(int i) {
        if (this.a) {
            try {
                return this.b.a(i);
            } catch (Exception e) {
                return -999;
            }
        }
        return -7;
    }

    @Override // c.t.m.g.u4
    public void terminateDrEngine() {
        this.b.i();
    }

    @Override // c.t.m.g.u4
    public boolean a() {
        return this.b.c();
    }
}