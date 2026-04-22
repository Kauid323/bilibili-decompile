package c.t.m.g;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: TML */
public class j0 extends i0 implements q {
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public double f47c;
    public int d;
    public double e;
    public double[] f = new double[7];
    public Bundle g = new Bundle();

    public j0() {
        h();
    }

    public static final String a(int i) {
        if (i != 100) {
            if (i != 200) {
                if (i != 300) {
                    if (i != 400) {
                        switch (i) {
                            case 0:
                                return "unknown";
                            case 1:
                                return "still";
                            case 2:
                                return "walking";
                            case 3:
                                return "in_vehicle";
                            case 4:
                                return "on_bicycle";
                            case 5:
                                return "running";
                            case 6:
                                return "tilting";
                            default:
                                return "not_support_type";
                        }
                    }
                    return "tilting";
                }
                return "vehicle";
            }
            return "on_foot";
        }
        return "still";
    }

    @Override // c.t.m.g.q
    public int a() {
        return this.d;
    }

    @Override // c.t.m.g.q
    public double b() {
        return this.d == 0 ? 1.0d - this.e : this.e;
    }

    public void c(double[] dArr) {
        int i;
        boolean b = b(dArr);
        if (b) {
            r1 = (this.f[0] == 1.0d || b) ? 0 : 0;
            this.b = r1;
            this.f47c = r1 == 0 ? 0.0d : 1.0d;
            r2 = (this.f[0] == 1.0d || b) ? 0 : 0;
            this.d = r2;
            this.e = r2 != 0 ? 1.0d : 0.0d;
            return;
        }
        double[] dArr2 = this.f;
        System.arraycopy(dArr, 0, dArr2, 0, dArr2.length);
        double[] dArr3 = this.f;
        if (dArr3[0] != 1.0d && dArr3[6] != 1.0d) {
            int i2 = 1;
            double d = dArr3[1];
            double d2 = dArr3[3] + dArr3[4];
            double d3 = dArr3[2] + dArr3[5];
            if (d2 > d) {
                i = 300;
                d = d2;
            } else {
                i = 100;
            }
            if (d3 > d) {
                i = 200;
            } else {
                d3 = d;
            }
            this.f47c = d3;
            if (d3 < 0.4d) {
                i = 0;
            }
            this.b = i;
            for (int i3 = 2; i3 <= 5; i3++) {
                double[] dArr4 = this.f;
                if (dArr4[i3] > dArr4[i2]) {
                    i2 = i3;
                }
            }
            double d4 = this.f[i2];
            this.e = d4;
            this.d = d4 >= 0.4d ? i2 : 0;
            return;
        }
        r1 = this.f[0] == 1.0d ? 0 : 400;
        this.b = r1;
        this.f47c = r1 == 0 ? 0.0d : 1.0d;
        r2 = this.f[0] == 1.0d ? 0 : 6;
        this.d = r2;
        this.e = r2 != 0 ? 1.0d : 0.0d;
    }

    @Deprecated
    public double d() {
        return this.b == 0 ? 1.0d - this.f47c : this.f47c;
    }

    @Deprecated
    public String e() {
        return r.a(this.b);
    }

    @Deprecated
    public int f() {
        return this.b;
    }

    public String g() {
        return r.a(this.d);
    }

    public void h() {
        a(System.currentTimeMillis());
        Arrays.fill(this.f, 0.0d);
        c(this.f);
        this.g.clear();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "TLBSArEvent{time=%d, type=%d, conf=%.4f, desc=%s, subType=%d, subConf=%.4f, subDesc=%s}", Long.valueOf(c()), Integer.valueOf(f()), Double.valueOf(d()), e(), Integer.valueOf(a()), Double.valueOf(b()), g());
    }

    public void a(double[] dArr) {
        if (dArr == null) {
            dArr = new double[7];
            Arrays.fill(dArr, 0.0d);
            dArr[0] = 1.0d;
        }
        if (b(dArr)) {
            Arrays.fill(dArr, 0.0d);
            dArr[0] = 1.0d;
            return;
        }
        dArr[0] = dArr[0];
        dArr[1] = Math.max(dArr[1], dArr[2]);
        dArr[2] = dArr[3];
        dArr[3] = dArr[4];
        dArr[4] = dArr[5];
        dArr[5] = 0.0d;
        dArr[6] = dArr[6];
    }

    public final boolean b(double[] dArr) {
        for (double d : dArr) {
            if (Double.isNaN(d)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (r1 == 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
        r2 = 0.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r1 == 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(double[] dArr) {
        int i;
        if (dArr == null) {
            return;
        }
        double d = 1.0d;
        int i2 = 0;
        if (b(dArr)) {
            i = dArr[0] == 1.0d ? 0 : 6;
        } else if (dArr[0] != 1.0d && dArr[6] != 1.0d) {
            int i3 = 1;
            for (int i4 = 2; i4 <= 5; i4++) {
                if (dArr[i4] > dArr[i3]) {
                    i3 = i4;
                }
            }
            d = dArr[i3];
            if (d >= 0.4d) {
                i2 = i3;
            }
        } else {
            i = dArr[0] == 1.0d ? 0 : 6;
        }
        this.g.putInt("ar_no_gps_type", i2);
        this.g.putDouble("ar_no_gps_conf", d);
        this.g.putDoubleArray("ar_no_gps_conf_arr", dArr);
    }
}