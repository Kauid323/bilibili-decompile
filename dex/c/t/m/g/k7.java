package c.t.m.g;

/* compiled from: TML */
public class k7 {
    public static final String j = "k7";
    public double a;
    public double b;

    /* renamed from: c  reason: collision with root package name */
    public double f56c;
    public double d;
    public double e;
    public double f;
    public long g;
    public double h;
    public String i;

    public k7(double[] dArr) {
        try {
            this.g = (long) dArr[0];
            this.a = dArr[1];
            this.b = dArr[2];
            this.f = dArr[3];
            this.h = dArr[4];
            this.e = dArr[5];
            this.d = dArr[6];
            double d = dArr[7];
            if (d == 1.0d) {
                this.i = "gps";
            } else if (d == 0.0d) {
                this.i = "fused";
            } else {
                this.i = "unknown";
            }
            double d2 = dArr[8];
            this.f56c = dArr[9];
        } catch (Exception e) {
            w3.b(j, "build dr loc obj err");
        }
    }

    public double a() {
        return this.d;
    }

    public double b() {
        return this.f56c;
    }

    public double c() {
        return this.f;
    }

    public double d() {
        return this.a;
    }

    public double e() {
        return this.b;
    }

    public double f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public double h() {
        return this.e;
    }

    public long i() {
        return this.g;
    }
}