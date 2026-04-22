package c.t.m.g;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: TML */
public class e2 implements Cloneable, Serializable {
    public double[][] a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f25c;

    public e2(int i, int i2) {
        this.b = i;
        this.f25c = i2;
        this.a = (double[][]) Array.newInstance(Double.TYPE, i, i2);
    }

    public e2 a() {
        e2 e2Var = new e2(this.b, this.f25c);
        double[][] b = e2Var.b();
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.f25c; i2++) {
                b[i][i2] = this.a[i][i2];
            }
        }
        return e2Var;
    }

    public double[][] b() {
        return this.a;
    }

    public int c() {
        return this.f25c;
    }

    public Object clone() {
        return a();
    }

    public int d() {
        return this.b;
    }

    public e2 b(double d) {
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.f25c; i2++) {
                double[][] dArr = this.a;
                dArr[i][i2] = dArr[i][i2] * d;
            }
        }
        return this;
    }

    public double a(int i, int i2) {
        return this.a[i][i2];
    }

    public void a(int i, int i2, double d) {
        this.a[i][i2] = d;
    }

    public void a(double d) {
        int i = 0;
        while (true) {
            double[][] dArr = this.a;
            if (i >= dArr.length) {
                return;
            }
            Arrays.fill(dArr[i], d);
            i++;
        }
    }
}