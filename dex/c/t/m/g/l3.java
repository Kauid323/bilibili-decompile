package c.t.m.g;

/* compiled from: TML */
public final class l3 {
    public static double[] a;
    public static double[] b;

    public static void a(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        if (length == dArr2.length) {
            int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(length);
            if ((1 << numberOfLeadingZeros) == length) {
                double[] dArr3 = a;
                if (dArr3 == null || dArr3.length != length / 2) {
                    int i = length / 2;
                    b = new double[i];
                    a = new double[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        double d = (i2 * 6.283185307179586d) / length;
                        b[i2] = Math.cos(d);
                        a[i2] = Math.sin(d);
                    }
                }
                for (int i3 = 0; i3 < length; i3++) {
                    int reverse = Integer.reverse(i3) >>> (32 - numberOfLeadingZeros);
                    if (reverse > i3) {
                        double d2 = dArr[i3];
                        dArr[i3] = dArr[reverse];
                        dArr[reverse] = d2;
                        double d3 = dArr2[i3];
                        dArr2[i3] = dArr2[reverse];
                        dArr2[reverse] = d3;
                    }
                }
                for (int i4 = 2; i4 <= length; i4 *= 2) {
                    int i5 = i4 / 2;
                    int i6 = length / i4;
                    for (int i7 = 0; i7 < length; i7 += i4) {
                        int i8 = 0;
                        int i9 = i7;
                        while (i9 < i7 + i5) {
                            int i10 = i9 + i5;
                            double d4 = dArr[i10];
                            double[] dArr4 = b;
                            double d5 = d4 * dArr4[i8];
                            double d6 = dArr2[i10];
                            double[] dArr5 = a;
                            double d7 = d5 + (d6 * dArr5[i8]);
                            double d8 = ((-dArr[i10]) * dArr5[i8]) + (dArr2[i10] * dArr4[i8]);
                            dArr[i10] = dArr[i9] - d7;
                            dArr2[i10] = dArr2[i9] - d8;
                            dArr[i9] = dArr[i9] + d7;
                            dArr2[i9] = dArr2[i9] + d8;
                            i9++;
                            i8 += i6;
                        }
                    }
                    if (i4 == length) {
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Length is not a power of 2");
        }
        throw new IllegalArgumentException("Mismatched lengths");
    }
}