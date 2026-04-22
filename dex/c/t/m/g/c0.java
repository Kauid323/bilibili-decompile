package c.t.m.g;

import com.bilibili.datacenter.hakase.protobuf.AndroidDeviceInfo;
import java.util.Arrays;

/* compiled from: TML */
public class c0 {
    public static final c0 o = new c0();
    public double[] a = new double[141];
    public double[] b = new double[8];

    /* renamed from: c  reason: collision with root package name */
    public double[] f14c = new double[7];
    public double[] d = new double[36];
    public double[] e = new double[128];
    public double[] f = new double[128];
    public double[] g = new double[128];
    public double[] h = null;
    public double[] i = null;
    public double[] j = null;
    public double[] k = null;
    public double[] l = null;
    public double[] m = null;
    public double[] n = null;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public enum a {
        TIME,
        FFT
    }

    public static double[] b(double[][] dArr) {
        return o.a(dArr);
    }

    public final synchronized double[] a(double[][] dArr) {
        Arrays.fill(this.a, 0.0d);
        double[] dArr2 = dArr[3];
        double[] dArr3 = dArr[4];
        double[] dArr4 = dArr[5];
        for (int i = 0; i < dArr4.length; i++) {
            this.e[i] = dArr4[i] - dArr4[0];
        }
        double d = 1.0d / t.f97c;
        a(this.a, 0, a.TIME, dArr2, d);
        a(this.a, 8, a.FFT, dArr2, d);
        a(this.a, 15, a.TIME, dArr3, d);
        a(this.a, 23, a.FFT, dArr3, d);
        a(this.a, 30, a.TIME, this.e, d);
        a(this.a, 38, a.FFT, this.e, d);
        a(this.d, dArr2);
        double[] dArr5 = this.d;
        System.arraycopy(dArr5, 0, this.a, 45, dArr5.length);
        a(this.a, 81, a.TIME, dArr[6], d);
        a(this.a, 89, a.FFT, dArr[6], d);
        a(this.a, 96, a.TIME, dArr[7], d);
        a(this.a, 104, a.FFT, dArr[7], d);
        a(this.a, AndroidDeviceInfo.DeviceInfo.DRMID_FIELD_NUMBER, a.TIME, dArr[8], d);
        a(this.a, AndroidDeviceInfo.DeviceInfo.CPU_ABI_LIBC_FIELD_NUMBER, a.FFT, dArr[8], d);
        a(this.a, 126, a.TIME, dArr[9], d);
        a(this.a, 134, a.FFT, dArr[9], d);
        return this.a;
    }

    public final void b(double[] dArr, double[] dArr2) {
        a(dArr, dArr2, 0, dArr2.length);
    }

    public final void a(double[] dArr, int i, a aVar, double[] dArr2, double d) {
        if (aVar == a.TIME) {
            b(this.b, dArr2);
            double[] dArr3 = this.b;
            System.arraycopy(dArr3, 0, dArr, i, dArr3.length);
        } else if (aVar == a.FFT) {
            a(this.f14c, dArr2, d);
            double[] dArr4 = this.f14c;
            System.arraycopy(dArr4, 0, dArr, i, dArr4.length);
        }
    }

    public final void a(double[] dArr, double[] dArr2) {
        int length = dArr2.length;
        Arrays.fill(dArr, 0.0d);
        System.arraycopy(dArr2, 0, this.f, 0, dArr2.length);
        Arrays.sort(this.f);
        if (length % 2 == 0) {
            double[] dArr3 = this.f;
            int i = length / 2;
            dArr[0] = (dArr3[i - 1] + dArr3[i]) / 2.0d;
        } else {
            dArr[0] = this.f[(int) Math.floor((length + 0) / 2.0d)];
        }
        double[] dArr4 = this.f;
        int i2 = length - 1;
        dArr[1] = (dArr4[0] + dArr4[i2]) / 2.0d;
        double b = y3.b(dArr2);
        double d = 1.0d / t.f97c;
        Arrays.fill(this.g, 0.0d);
        double d2 = 0.0d;
        int i3 = 0;
        for (int i4 = 0; i4 < dArr2.length; i4++) {
            if (dArr2[i4] > b) {
                this.g[i3] = dArr2[i4];
                d2 += dArr2[i4];
                i3++;
            }
        }
        if (i3 != 0) {
            d2 /= i3;
        }
        a(this.g, i3, d2);
        double[] dArr5 = this.g;
        int length2 = (dArr5.length - i3) / 2;
        a(this.b, dArr5, length2, length2 + i3);
        dArr[2] = i3;
        double[] dArr6 = this.b;
        System.arraycopy(dArr6, 0, dArr, 3, dArr6.length);
        a(this.f14c, this.g, d);
        double[] dArr7 = this.f14c;
        System.arraycopy(dArr7, 0, dArr, 11, dArr7.length);
        Arrays.fill(this.g, 0.0d);
        double d3 = 0.0d;
        int i5 = 0;
        for (int i6 = 0; i6 < dArr2.length; i6++) {
            if (dArr2[i6] < b) {
                this.g[i5] = dArr2[i6];
                d3 += dArr2[i6];
                i5++;
            }
        }
        if (i5 != 0) {
            d3 /= i5;
        }
        a(this.g, i5, d3);
        double[] dArr8 = this.g;
        int length3 = (dArr8.length - i5) / 2;
        a(this.b, dArr8, length3, length3 + i5);
        dArr[18] = i5;
        double[] dArr9 = this.b;
        System.arraycopy(dArr9, 0, dArr, 19, dArr9.length);
        a(this.f14c, this.g, d);
        double[] dArr10 = this.f14c;
        System.arraycopy(dArr10, 0, dArr, 27, dArr10.length);
        double[] dArr11 = this.f;
        dArr[34] = dArr11[i2] - b;
        dArr[35] = b - dArr11[0];
    }

    public final void a(double[] dArr, int i, double d) {
        int length = (dArr.length - i) / 2;
        for (int length2 = dArr.length - 1; length2 >= 0; length2--) {
            if (length2 < i + length && length2 >= length) {
                dArr[length2] = dArr[length2 - length];
            } else {
                dArr[length2] = d;
            }
        }
    }

    public void a(double[] dArr, double[] dArr2, int i, int i2) {
        double d;
        double d2 = 0.0d;
        Arrays.fill(dArr, 0.0d);
        int i3 = i2 - i;
        double d3 = 0.0d;
        for (int i4 = i; i4 < i2; i4++) {
            d3 += dArr2[i4];
        }
        double d4 = i3;
        double d5 = d3 / d4;
        int i5 = Integer.MAX_VALUE;
        double d6 = -1.7976931348623157E308d;
        double d7 = Double.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        int i7 = i;
        double d8 = 0.0d;
        double d9 = 0.0d;
        int i8 = Integer.MAX_VALUE;
        int i9 = 0;
        while (i7 < i2) {
            d8 += (dArr2[i7] - d5) * (dArr2[i7] - d5);
            if (d6 < dArr2[i7]) {
                d6 = dArr2[i7];
            }
            if (d7 > dArr2[i7]) {
                d7 = dArr2[i7];
            }
            double signum = Math.signum(dArr2[i7] - d5);
            if (i7 <= i || signum == 0.0d || signum == d9) {
                i8 = i8;
                i9 = i9;
            } else {
                int i10 = i8;
                i8 = i10 == i5 ? i7 : i10;
                i9++;
                i6 = i7;
            }
            i7++;
            d9 = signum;
            i5 = Integer.MAX_VALUE;
        }
        int i11 = i9;
        int i12 = i8;
        double sqrt = Math.sqrt(d8 / d4);
        double d10 = sqrt != 0.0d ? d5 / sqrt : 0.0d;
        if (i11 > 1) {
            d = d6;
            d2 = (i6 - i12) / (i11 - 1.0d);
        } else {
            d = d6;
        }
        dArr[0] = d5;
        dArr[1] = sqrt;
        dArr[2] = d10;
        dArr[3] = d;
        dArr[4] = d7;
        dArr[5] = d - d7;
        dArr[6] = i11;
        dArr[7] = d2;
    }

    public void a(double[] dArr, double[] dArr2, double d) {
        double[] dArr3;
        double d2;
        int length = dArr2.length;
        int i = (length / 2) + 1;
        double[] dArr4 = this.h;
        double d3 = 2.0d;
        if (dArr4 == null || dArr4.length != length) {
            this.h = new double[length];
            this.i = new double[length];
            double[] dArr5 = new double[length];
            this.j = dArr5;
            this.k = new double[i];
            this.l = new double[i];
            this.m = new double[i];
            this.n = new double[i];
            a(dArr5);
            int i2 = 0;
            while (true) {
                double[] dArr6 = this.l;
                if (i2 >= dArr6.length) {
                    break;
                }
                dArr6[i2] = ((i2 * (1.0d / d)) / 2.0d) / (i - 1);
                i2++;
            }
        }
        Arrays.fill(dArr, 0.0d);
        System.arraycopy(dArr2, 0, this.h, 0, length);
        Arrays.fill(this.i, 0.0d);
        double b = y3.b(this.h);
        double[] dArr7 = this.h;
        y3.a(dArr7, dArr7, b);
        int i3 = 0;
        while (true) {
            dArr3 = this.h;
            if (i3 >= dArr3.length) {
                break;
            }
            dArr3[i3] = dArr3[i3] * this.j[i3];
            i3++;
        }
        l3.a(dArr3, this.i);
        Arrays.fill(this.m, 0.0d);
        double d4 = -1.7976931348623157E308d;
        int i4 = 0;
        double d5 = 0.0d;
        double d6 = 0.0d;
        while (i4 < i) {
            double[] dArr8 = this.k;
            double[] dArr9 = this.h;
            double[] dArr10 = this.i;
            dArr8[i4] = (Math.abs(Math.sqrt((dArr9[i4] * dArr9[i4]) + (dArr10[i4] * dArr10[i4]))) * d3) / i;
            double[] dArr11 = this.k;
            if (d4 <= dArr11[i4]) {
                d4 = dArr11[i4];
            }
            double[] dArr12 = this.k;
            d5 += dArr12[i4];
            double d7 = dArr12[i4] * dArr12[i4];
            double d8 = d7 * d7;
            d6 += d8;
            this.m[i4] = d8;
            i4++;
            d3 = 2.0d;
        }
        double length2 = d5 / this.k.length;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i5 = 0;
        while (i5 < i) {
            int i6 = i;
            double[] dArr13 = this.m;
            dArr13[i5] = d6 == 0.0d ? 0.0d : dArr13[i5] / d6;
            d9 += this.m[i5] * this.l[i5];
            if (d5 == 0.0d) {
                d2 = 0.0d;
            } else {
                d2 = this.k[i5] / d5;
            }
            if (d2 == 0.0d) {
                d2 = 1.0E-7d;
            }
            d10 -= d2 * Math.log(d2);
            i5++;
            i = i6;
        }
        y3.a(this.n, this.k, this.l);
        double b2 = y3.b(this.n);
        double a2 = y3.a(this.n, b2);
        double d11 = a2 == 0.0d ? 0.0d : b2 / a2;
        double a3 = y3.a(this.k, length2);
        dArr[0] = d9;
        dArr[1] = a3 != 0.0d ? length2 / a3 : 0.0d;
        dArr[2] = length2;
        dArr[3] = d4;
        dArr[4] = b2;
        dArr[5] = d11;
        dArr[6] = d10;
    }

    public final void a(double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr[i] = 0.5d - (Math.cos((i * 6.283185307179586d) / (length - 1)) * 0.5d);
        }
    }
}