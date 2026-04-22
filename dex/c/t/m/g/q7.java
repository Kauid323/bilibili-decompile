package c.t.m.g;

import com.tencent.map.geolocation.walkBikeDr.dr.TencentDrJni;

/* compiled from: TML */
public class q7 {
    public static volatile q7 a;

    public static q7 b() {
        if (a == null) {
            synchronized (q7.class) {
                if (a == null) {
                    a = new q7();
                }
            }
        }
        return a;
    }

    public void a(double[][] dArr, int i) {
        TencentDrJni.sr(dArr, i);
    }

    public double[] c() {
        return TencentDrJni.gp();
    }

    public void d() {
        TencentDrJni.s();
    }

    public void a(long j, float f, float f2, float f3, long j2, float f4, float f5, float f6, long j3, float f7, float f8, float f9, long j4, float f10, float f11, float f12) {
        TencentDrJni.a(j, f, f2, f3, j2, f4, f5, f6, j3, f7, f8, f9, j4, f10, f11, f12);
    }

    public void a(int i, double d) {
        TencentDrJni.ss(i, d);
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        TencentDrJni.sg(d, d2, d3, d4, d5, d6, d7, d8);
    }

    public void a() {
        TencentDrJni.e();
    }
}