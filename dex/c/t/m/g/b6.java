package c.t.m.g;

/* compiled from: TML */
public class b6 {
    public String a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12c;
    public w5 d;
    public long e;

    public boolean a() {
        return System.currentTimeMillis() - this.b > 30000;
    }

    public boolean b() {
        return this.d != null && System.currentTimeMillis() - this.e < 10000;
    }

    public void c() {
        this.b = 0L;
        this.f12c = false;
        this.d = null;
        this.e = 0L;
    }
}