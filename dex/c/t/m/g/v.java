package c.t.m.g;

import java.util.Arrays;

/* compiled from: TML */
public class v {
    public e2 f;
    public e2 g;
    public e2 h;
    public e2 i;
    public e2 j;
    public e2 k;
    public double l;
    public volatile double d = -1.0d;
    public volatile long e = 0;
    public double[] m = new double[7];
    public boolean n = true;
    public boolean o = true;
    public double[] p = new double[3];
    public b0 b = new b0();
    public w a = new y();

    /* renamed from: c  reason: collision with root package name */
    public a0 f107c = new a0(15);

    public v() {
        int i = t.a;
        this.l = 1.0d / i;
        e2 e2Var = new e2(i, i);
        this.f = e2Var;
        f2.a(e2Var, t.e);
        this.g = new e2(t.a, 1);
        this.k = new e2(t.a, 1);
        this.h = new e2(t.a, 1);
        this.i = new e2(t.a, 1);
        this.j = new e2(t.a, 1);
        this.g.a(this.l);
        this.h.a(this.l);
        this.i.a(this.l);
        this.j.a(this.l);
        c();
    }

    public void a(long j, double d) {
        this.e = j;
        this.d = d;
        this.f107c.a(j, d);
    }

    public double[] b(long j, double[][] dArr) {
        boolean z;
        int i = 1;
        while (true) {
            try {
                if (i < dArr[3].length) {
                    if (dArr[3][i] != dArr[3][i - 1]) {
                        z = false;
                        break;
                    }
                    i++;
                } else {
                    z = true;
                    break;
                }
            } catch (Throwable th) {
                n0.a("ArStrategy", "classify error.", th);
                this.m[0] = 1.0d;
                u.l[0] = 1.0d;
                if (this.o) {
                    w3.d("ar", n0.a(th));
                    this.o = true;
                }
                return this.m;
            }
        }
        double b = y3.b(dArr[3]);
        if (!z && Math.abs(b) >= 1.0E-10d) {
            this.n = true;
            if (y3.a(dArr[3], b) < 0.06d) {
                n0.a("ArStrategy", "detect still.");
                e();
                this.h.a(0.0d);
                this.h.a(0, 0, 1.0d);
                return a();
            } else if (this.b.a(dArr)) {
                n0.a("ArStrategy", "detect tilting.");
                e();
                this.m[6] = 1.0d;
                u.l[6] = 1.0d;
                return this.m;
            } else {
                double[] a = this.a.a(dArr);
                n0.a("DATA_AR", "#DATA,AR," + System.currentTimeMillis() + ",FEA," + v2.a(a, 4, false));
                return a(a);
            }
        }
        this.m[0] = 1.0d;
        u.l[0] = 1.0d;
        if (this.n) {
            this.n = false;
            w3.d("ar", "acc exp");
        }
        return this.m;
    }

    public void c() {
        n0.a("ArStrategy", "init start[" + this.a.b() + ", f=" + t.f97c + ", t=" + String.format("%.2f", Float.valueOf(128.0f / t.f97c)) + ",size=128,numClass=" + t.a + ",SVM feaLen=141,LR feaLen=141]");
        this.a.c();
        n0.a("ArStrategy", "init finished.");
        this.f107c.c();
    }

    public void d() {
        n0.a("ArStrategy", "reset().");
        e();
        this.g.a(this.l);
    }

    public final void e() {
        n0.a("ArStrategy", "resetAlgo().");
        this.a.d();
    }

    public double[] a(long j, double[][] dArr) {
        Arrays.fill(this.m, 0.0d);
        Arrays.fill(u.l, 0.0d);
        if (!this.f107c.b()) {
            if (t.i) {
                long a = this.f107c.a();
                if (a != -1 && j - a > 60000) {
                    this.f107c.c();
                }
                double[] dArr2 = this.m;
                dArr2[0] = 1.0d;
                u.l[0] = 1.0d;
                return dArr2;
            }
            this.f107c.c();
        }
        double[] b = b(j, dArr);
        int a2 = y3.a(u.l);
        this.f107c.a(j, a2, u.l[a2]);
        return b;
    }

    public final double[] a(double[] dArr) {
        double[] a = this.a.a(dArr);
        for (int i = 0; i < a.length; i++) {
            this.h.a(i, 0, a[i]);
        }
        return a();
    }

    public final double[] a() {
        char c2 = 1;
        char c3 = 0;
        boolean z = System.currentTimeMillis() - this.e <= 5000 && this.d > 2.5d && this.d < 1000.0d;
        double d = this.d == 0.0d ? 1.0E-5d : this.d;
        a(this.f, this.l);
        a(this.g, this.l);
        a(this.h, this.l);
        a(this.i, this.l);
        a(this.j, this.l);
        Arrays.fill(this.p, this.l);
        a(this.h);
        f2.b(this.k, this.f, this.g);
        f2.a(this.g, this.k, this.h);
        a(this.g);
        f2.b(this.k, this.f, this.i);
        f2.a(this.i, this.k, this.h);
        a(this.i);
        a(u.l, this.g);
        if (z) {
            double log = Math.log(d);
            double sqrt = Math.sqrt(6.283185307179586d);
            int i = 0;
            while (i < 3) {
                double[][] dArr = t.f;
                double d2 = log - dArr[i][c2];
                this.p[i] = (((dArr[i][c3] * Math.exp(((-d2) * d2) / ((dArr[i][2] * 2.0d) * dArr[i][2]))) / t.f[i][2]) / sqrt) / d;
                i++;
                c2 = 1;
                c3 = 0;
            }
            double d3 = y3.d(this.p);
            for (int i2 = 0; i2 < 3; i2++) {
                double[] dArr2 = this.p;
                dArr2[i2] = dArr2[i2] / d3;
                this.j.a(i2, 0, dArr2[i2]);
            }
            e2 e2Var = this.i;
            f2.a(e2Var, e2Var, this.j);
            a(this.i);
        }
        a(this.m, this.i);
        return this.m;
    }

    public final void a(double[] dArr, e2 e2Var) {
        int i = 0;
        while (i < e2Var.d()) {
            int i2 = i + 1;
            dArr[i2] = e2Var.a(i, 0);
            i = i2;
        }
    }

    public final void a(e2 e2Var) {
        double d = 0.0d;
        for (int i = 0; i < e2Var.d(); i++) {
            d += e2Var.a(i, 0);
        }
        e2Var.b(1.0d / d);
    }

    public final void a(e2 e2Var, double d) {
        if (Double.isNaN(e2Var.a(0, 0)) || Double.isNaN(e2Var.a(e2Var.d() - 1, e2Var.c() - 1))) {
            e2Var.a(d);
        }
    }

    public void b() {
        n0.a("ArStrategy", "destroy().");
        this.a.a();
        this.f107c.c();
        this.e = 0L;
        this.d = -1.0d;
    }
}