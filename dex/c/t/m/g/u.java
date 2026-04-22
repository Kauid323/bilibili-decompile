package c.t.m.g;

import android.hardware.SensorManager;
import com.alipay.sdk.app.PayTask;
import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: TML */
public class u {
    public static double[] l = new double[7];
    public v a;
    public boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public float[] f102c = new float[9];
    public int d = 0;
    public boolean e = false;
    public volatile long f = 0;
    public double[][] g = null;
    public double[][] h = null;
    public float[] i = {-10.0f, -10.0f, -10.0f};
    public float[] j = {1.0f, 1.0f, 1.0f};
    public float[] k = new float[3];

    public final void a(float[] fArr, float[] fArr2) {
        float f = t.d;
        if (fArr[0] == -10.0f) {
            System.arraycopy(fArr2, 0, fArr, 0, fArr.length);
            return;
        }
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = (fArr[i] * f) + ((1.0f - f) * fArr2[i]);
        }
    }

    public void b() {
        if (this.b) {
            a();
            this.a.b();
            this.b = false;
            w3.a("ArSdkCore", "stop.");
        }
    }

    public void a(int i, int i2, float f, double[][] dArr, double[][] dArr2, double[][] dArr3, double[] dArr4) {
        if (this.b) {
            return;
        }
        t.a = i;
        t.b = (i * (i - 1)) / 2;
        t.f97c = i2;
        t.d = f;
        t.e = dArr;
        t.f = dArr2;
        t.g = dArr3;
        t.h = dArr4;
        this.g = (double[][]) Array.newInstance(Double.TYPE, 10, 128);
        this.h = (double[][]) Array.newInstance(Double.TYPE, 10, 128);
        this.a = new v();
        this.b = true;
        w3.a("ArSdkCore", "start.");
    }

    public void a() {
        w3.a("ArSdkCore", "reset.");
        int i = 0;
        this.d = 0;
        this.e = false;
        this.f = 0L;
        while (true) {
            double[][] dArr = this.g;
            if (i < dArr.length) {
                Arrays.fill(dArr[i], 0.0d);
                i++;
            } else {
                Arrays.fill(this.i, -10.0f);
                this.a.d();
                return;
            }
        }
    }

    public void a(long j, float f) {
        this.a.a(j, f);
    }

    public void a(long j, float[] fArr, float[] fArr2) {
        a(this.i, fArr);
        Arrays.fill(this.f102c, 0.0f);
        SensorManager.getRotationMatrix(this.f102c, null, this.i, this.j);
        double[][] dArr = this.g;
        double[] dArr2 = dArr[0];
        int i = this.d;
        dArr2[i] = fArr[0];
        dArr[1][i] = fArr[1];
        dArr[2][i] = fArr[2];
        dArr[3][i] = Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
        this.g[4][this.d] = Math.sqrt((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1]) + (fArr2[2] * fArr2[2]));
        double d = Math.abs(this.g[3][this.d] - 0.0d) < 1.0E-5d ? 2.0d : fArr[2] / this.g[3][this.d];
        this.g[5][this.d] = Math.abs(d) <= 1.0d ? Math.acos(d) : 0.0d;
        a(this.k, this.f102c, fArr);
        double[] dArr3 = this.g[6];
        int i2 = this.d;
        float[] fArr3 = this.k;
        dArr3[i2] = Math.sqrt((fArr3[0] * fArr3[0]) + (fArr3[1] * fArr3[1]));
        double[] dArr4 = this.g[7];
        int i3 = this.d;
        float[] fArr4 = this.k;
        dArr4[i3] = fArr4[2];
        a(fArr4, this.f102c, fArr2);
        double[] dArr5 = this.g[8];
        int i4 = this.d;
        float[] fArr5 = this.k;
        dArr5[i4] = Math.sqrt((fArr5[0] * fArr5[0]) + (fArr5[1] * fArr5[1]));
        this.g[9][this.d] = this.k[2];
        this.f = j;
        int i5 = this.d + 1;
        this.d = i5;
        if (i5 == 128) {
            this.d = 0;
            if (this.e) {
                return;
            }
            this.e = true;
        }
    }

    public final void a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[1]) + (fArr2[2] * fArr3[2]);
        fArr[1] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[5] * fArr3[2]);
        fArr[2] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[1]) + (fArr2[8] * fArr3[2]);
    }

    public double[] a(long j) {
        if (!this.e || j - this.f >= PayTask.j) {
            return null;
        }
        int i = this.d;
        int i2 = 0;
        while (true) {
            double[][] dArr = this.g;
            if (i2 < dArr.length) {
                System.arraycopy(dArr[i2], i, this.h[i2], 0, dArr[i2].length - i);
                if (this.d != 0) {
                    double[][] dArr2 = this.g;
                    System.arraycopy(dArr2[i2], 0, this.h[i2], dArr2[i2].length - i, i);
                }
                i2++;
            } else {
                return this.a.a(j, this.h);
            }
        }
    }
}