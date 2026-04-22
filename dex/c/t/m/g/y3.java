package c.t.m.g;

/* compiled from: TML */
public class y3 {
    public static int a(double[] dArr) {
        int i = 0;
        for (int i2 = 1; i2 < dArr.length; i2++) {
            if (dArr[i2] > dArr[i]) {
                i = i2;
            }
        }
        return i;
    }

    public static double b(double[] dArr, int i, int i2) {
        double d = 0.0d;
        while (i < i2) {
            d += dArr[i];
            i++;
        }
        return d;
    }

    public static double c(double... dArr) {
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2 * d2;
        }
        return Math.sqrt(d);
    }

    public static double d(double[] dArr) {
        return b(dArr, 0, dArr.length);
    }

    public static double b(double[] dArr) {
        return a(dArr, 0, dArr.length);
    }

    public static void a(double[] dArr, double[] dArr2, double d) {
        for (int i = 0; i < dArr2.length; i++) {
            dArr[i] = dArr2[i] - d;
        }
    }

    public static double b(double[] dArr, double d) {
        return a(dArr, d, 0, dArr.length);
    }

    public static double a(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            d += dArr[i] * dArr2[i];
        }
        return d;
    }

    public static double a(double[] dArr, int i, int i2) {
        return b(dArr, i, i2) / (i2 - i);
    }

    public static double a(double[] dArr, double d, int i, int i2) {
        double d2 = 0.0d;
        for (int i3 = i; i3 < i2; i3++) {
            d2 += (dArr[i3] - d) * (dArr[i3] - d);
        }
        return d2 / (i2 - i);
    }

    public static double a(double[] dArr, double d) {
        return Math.sqrt(b(dArr, d));
    }

    public static void a(double[] dArr, double[] dArr2, double[] dArr3) {
        for (int i = 0; i < dArr2.length; i++) {
            dArr[i] = dArr2[i] * dArr3[i];
        }
    }
}