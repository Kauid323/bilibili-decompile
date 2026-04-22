package c.t.m.g;

import java.lang.reflect.Array;

/* compiled from: TML */
public class z extends w {
    public static double[][] d = (double[][]) Array.newInstance(Double.TYPE, 3, 141);
    public static double[] e = new double[3];
    public int a;
    public double[][] b;

    /* renamed from: c  reason: collision with root package name */
    public double[] f126c;

    public z() {
        int i = t.a;
        this.a = i;
        this.b = (double[][]) Array.newInstance(Double.TYPE, i, i);
        this.f126c = new double[i];
    }

    @Override // c.t.m.g.w
    public void a() {
    }

    @Override // c.t.m.g.w
    public double[] a(double[] dArr) {
        int i;
        int i2 = 0;
        while (i2 < this.a - 1) {
            int i3 = i2 + 1;
            int i4 = i3;
            while (true) {
                int i5 = this.a;
                if (i4 < i5) {
                    int i6 = ((i5 * i2) + i4) - (((i2 + 2) * i3) / 2);
                    double a = y3.a(dArr, d[i6]) + e[i6];
                    if (a > 100.0d) {
                        a = 100.0d;
                    }
                    if (a < -100.0d) {
                        a = -100.0d;
                    }
                    double d2 = -a;
                    this.b[i2][i4] = 1.0d / (Math.exp(d2 / 1.0d) + 1.0d);
                    this.b[i4][i2] = 1.0d / (Math.exp((-d2) / 1.0d) + 1.0d);
                    i4++;
                }
            }
            i2 = i3;
        }
        double d3 = 0.0d;
        for (int i7 = 0; i7 < this.a; i7++) {
            this.f126c[i7] = 0.0d;
            int i8 = 0;
            while (true) {
                i = this.a;
                if (i8 < i) {
                    if (i7 != i8) {
                        double[] dArr2 = this.f126c;
                        dArr2[i7] = dArr2[i7] + (1.0d / this.b[i7][i8]);
                    }
                    i8++;
                }
            }
            double[] dArr3 = this.f126c;
            dArr3[i7] = 1.0d / (dArr3[i7] - (i - 2.0d));
            d3 += dArr3[i7];
        }
        for (int i9 = 0; i9 < this.a; i9++) {
            double[] dArr4 = this.f126c;
            dArr4[i9] = dArr4[i9] / d3;
        }
        return this.f126c;
    }

    @Override // c.t.m.g.w
    public String b() {
        return "SVM";
    }

    @Override // c.t.m.g.w
    public void c() {
    }

    @Override // c.t.m.g.w
    public void d() {
    }

    @Override // c.t.m.g.w
    public double[] a(double[][] dArr) {
        return c0.b(dArr);
    }
}