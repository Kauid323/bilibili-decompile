package c.t.m.g;

import java.util.Arrays;

/* compiled from: TML */
public class s2 {
    public int a;
    public double[] b;

    /* renamed from: c  reason: collision with root package name */
    public double f92c;
    public int d;
    public int e;

    public s2(int i) {
        if (i > 0) {
            this.a = i;
            this.b = new double[i];
            a();
            return;
        }
        throw new IllegalArgumentException("cacheSize max > 0.");
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f92c = 0.0d;
        Arrays.fill(this.b, 0.0d);
    }

    public int b() {
        int i = this.e;
        int i2 = this.a;
        return i < i2 ? i : i2;
    }

    public double b(int i) {
        if (i >= 0 && i < b()) {
            return this.b[a(i)];
        }
        throw new ArrayIndexOutOfBoundsException("cache max size is " + this.a + ",current size is " + b() + ",index is " + i);
    }

    public void a(double d) {
        double d2 = this.f92c;
        double[] dArr = this.b;
        int i = this.d;
        double d3 = d2 - dArr[i];
        this.f92c = d3;
        this.f92c = d3 + d;
        dArr[i] = d;
        int i2 = i + 1;
        this.d = i2;
        if (i2 == this.a) {
            this.d = 0;
        }
        int i3 = this.e;
        if (i3 < Integer.MAX_VALUE) {
            this.e = i3 + 1;
        }
    }

    public final int a(int i) {
        int i2 = this.e;
        int i3 = this.a;
        return i2 < i3 ? i : ((this.d + i) + i3) % i3;
    }
}