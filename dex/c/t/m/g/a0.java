package c.t.m.g;

import java.util.Locale;

/* compiled from: TML */
public class a0 {
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public double f2c;
    public t2 e;
    public s2 f;
    public s2 g;
    public boolean a = true;
    public long d = -1;

    public a0(int i) {
        try {
            this.e = new t2(i);
            this.f = new s2(i);
            this.g = new s2(i);
            c();
        } catch (Exception e) {
        }
    }

    public long a() {
        return this.d;
    }

    public boolean b() {
        return this.a;
    }

    public void c() {
        try {
            this.a = true;
            this.b = 0L;
            this.f2c = -1.0d;
            this.e.a();
            this.f.a();
            this.g.a();
            this.d = -1L;
        } catch (Exception e) {
        }
    }

    public void a(long j, double d) {
        this.b = j;
        this.f2c = d;
    }

    public void a(long j, int i, double d) {
        try {
            this.e.a(i);
            this.f.a(d);
            this.g.a(j - this.b < 2500 ? this.f2c : -1.0d);
            int b = this.e.b();
            for (int i2 = 0; i2 < this.e.c(); i2++) {
                int c2 = this.e.c(i2);
                double b2 = this.f.b(i2);
                double b3 = this.g.b(i2);
                if (b3 > 4.2d && b2 > 0.9d && (c2 == 1 || c2 == 2)) {
                    b--;
                }
                if (b3 >= 0.0d && b3 < 0.1d && b2 > 0.9d && c2 == 2) {
                    b--;
                }
            }
            boolean z = b > this.e.b() / 3;
            w3.a("ArAvailableChecker", String.format(Locale.ENGLISH, "checkArAvailable,%d,%d,%.4f,%d,%.2f,%d", Long.valueOf(j), Integer.valueOf(i), Double.valueOf(d), Long.valueOf(this.b), Double.valueOf(this.f2c), Integer.valueOf(b)));
            if (!z) {
                w3.d("AR", "available,false," + (this.e.b() - b));
                this.d = j;
            }
            if (this.a != z) {
                this.a = z;
            }
        } catch (Exception e) {
        }
    }
}