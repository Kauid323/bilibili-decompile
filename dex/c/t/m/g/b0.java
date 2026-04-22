package c.t.m.g;

import java.util.Arrays;

/* compiled from: TML */
public class b0 {
    public double[] a = {0.0d, 0.0d, 0.0d};
    public double[] b = {0.0d, 0.0d, 0.0d};

    public boolean a(double[][] dArr) {
        if (dArr == null || d4.a(dArr[3])) {
            return false;
        }
        int length = dArr[3].length;
        int i = length / 2;
        return a(dArr, 0, i) > 0.6d || a(dArr, i, length) > 0.6d || a(dArr, length / 4, (length * 3) / 4) > 0.6d;
    }

    public final double a(double[][] dArr, int i, int i2) {
        int i3;
        Arrays.fill(this.a, 0.0d);
        Arrays.fill(this.b, 0.0d);
        int i4 = (i + i2) / 2;
        int i5 = i4 - i;
        int i6 = i2 - i;
        while (true) {
            i3 = 0;
            if (i >= i2) {
                break;
            }
            while (i3 < 3) {
                if (i < i4) {
                    double[] dArr2 = this.a;
                    dArr2[i3] = dArr2[i3] + dArr[i3 + 0][i];
                }
                double[] dArr3 = this.b;
                dArr3[i3] = dArr3[i3] + dArr[i3 + 0][i];
                i3++;
            }
            i++;
        }
        while (i3 < 3) {
            double[] dArr4 = this.a;
            dArr4[i3] = dArr4[i3] / i5;
            double[] dArr5 = this.b;
            dArr5[i3] = dArr5[i3] / i6;
            i3++;
        }
        return Math.acos(y3.a(this.a, this.b) / (y3.c(this.a) * y3.c(this.b)));
    }
}