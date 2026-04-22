package c.t.m.g;

import android.os.Build;
import com.tencent.tencentmap.lbssdk.service.ar;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

/* compiled from: TML */
public class d0 {
    public static byte[] d = new byte[0];
    public static d0 e;
    public int a = -1;
    public a0 b;

    /* renamed from: c  reason: collision with root package name */
    public u f19c;

    public d0() {
        if (m0.b) {
            this.f19c = new u();
        }
    }

    public static d0 c() {
        d0 d0Var;
        synchronized (d) {
            d0Var = e;
        }
        return d0Var;
    }

    public synchronized void a(int i, int i2, float f, double[][] dArr, double[][] dArr2, double[][] dArr3, double[] dArr4, int i3) {
        File a;
        w3.a("ArCoreProxy", "start() 1, hardsupport: " + i3);
        synchronized (d) {
            e = this;
        }
        this.a = i3;
        if (m0.a) {
            n0.a("ArCoreProxy", "ar so version:" + ar.h() + ",debug:" + m0.f63c);
            if (m0.f63c && (a = m3.a(b3.a(), "sensor_ar2")) != null) {
                ar.i(a.getAbsolutePath() + File.separator + "log_arnative_" + f3.b("yyyyMMdd_HHmmss").format(new Date()) + "_" + Build.MODEL.replaceAll("[ _]", "") + "_" + i4.h(), m0.f63c);
            }
            this.b = new a0(15);
            ar.a(i, i2, f, dArr, dArr2, dArr3, dArr4);
        }
        if (m0.b && this.a == 0) {
            this.f19c.a(i, i2, f, dArr, dArr2, dArr3, dArr4);
        }
        w3.a("ArCoreProxy", "start() 2");
    }

    public synchronized double[] b(long j) {
        double[] dArr;
        if (w3.a()) {
            w3.a("ArCoreProxy", "getArClassifyResultFromNative(" + j + ")");
        }
        if (!m0.a) {
            dArr = null;
        } else {
            dArr = ar.g(j);
        }
        if (w3.a()) {
            w3.a("ArCoreProxy", "getArClassifyResultFromNative(" + j + "),resArr=" + v2.a(dArr, 4, true));
        }
        return dArr;
    }

    public synchronized void d() {
        if (m0.a) {
            ar.c();
        }
        if (m0.b && this.a == 0) {
            this.f19c.a();
        }
    }

    public synchronized void e() {
        w3.a("ArCoreProxy", "stop() 1");
        if (m0.a) {
            ar.b();
            a0 a0Var = this.b;
            if (a0Var != null) {
                a0Var.c();
            }
        }
        if (m0.b && this.a == 0) {
            this.f19c.b();
        }
        synchronized (d) {
            e = null;
        }
        w3.a("ArCoreProxy", "stop() 2");
    }

    public synchronized double[] b() {
        if (w3.a()) {
            w3.a("ArCoreProxy", "getArClassifyResultWithNoGpsFromNative()");
        }
        if (m0.a) {
            return ar.g2();
        }
        return null;
    }

    public synchronized void a(long j, float f) {
        if (w3.a()) {
            w3.a("ArCoreProxy", "setGps(" + j + "," + f + ")");
        }
        if (m0.a) {
            ar.e(j, f);
            a0 a0Var = this.b;
            if (a0Var != null) {
                a0Var.a(j, f);
            }
        }
        if (m0.b && this.a == 0) {
            this.f19c.a(j, f);
        }
    }

    public void a(long j, double[] dArr, double[] dArr2) {
        a0 a0Var;
        if (dArr == null || dArr2 == null || (a0Var = this.b) == null) {
            return;
        }
        if (!a0Var.b()) {
            if (t.i) {
                Arrays.fill(dArr, 0.0d);
                Arrays.fill(dArr2, 0.0d);
                dArr[0] = 1.0d;
                dArr2[0] = 1.0d;
            } else {
                this.b.c();
            }
        }
        int a = y3.a(dArr2);
        this.b.a(j, a, dArr2[a]);
    }

    public synchronized void a(long j, float[] fArr, float[] fArr2, int i) {
        if (m0.a) {
            if (fArr2 == null) {
                ar.f(j, fArr[0], fArr[1], fArr[2], 0.0f, 0.0f, 0.0f, i);
            } else {
                ar.f(j, fArr[0], fArr[1], fArr[2], fArr2[0], fArr2[1], fArr2[2], i);
            }
        }
        if (m0.b && this.a == 0 && fArr2 != null) {
            this.f19c.a(j, fArr, fArr2);
        }
    }

    public synchronized double[] a(long j) {
        double[] dArr;
        if (w3.a()) {
            w3.a("ArCoreProxy", "getArClassifyResultFromJava(" + j + ")");
        }
        if (m0.b && this.a == 0) {
            dArr = this.f19c.a(j);
        } else {
            dArr = null;
        }
        if (w3.a()) {
            w3.a("ArCoreProxy", "getArClassifyResultFromJava(" + j + "),resArr=" + v2.a(dArr, 4, true));
        }
        return dArr;
    }

    public synchronized double[] a() {
        if (w3.a()) {
            w3.a("ArCoreProxy", "getArClassifyResultWithNoGpsFromJava()");
        }
        if (m0.b && this.a == 0) {
            return u.l;
        }
        return null;
    }
}