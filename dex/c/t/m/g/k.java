package c.t.m.g;

import c.t.m.g.d;

/* compiled from: TML */
public class k {
    public static int[] a = {0, 8, 10, 33, 65535, 50594049, 268435455, Integer.MAX_VALUE};

    public static boolean a(long j, int[] iArr) {
        for (int i : iArr) {
            if (j == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(int i, int i2, int i3, int i4, long j) {
        if (i2 < 0 || i3 < 0 || i4 < 0 || j <= 0 || i2 == 535 || i3 == 535 || i4 == 65535 || j == 65535) {
            return false;
        }
        if (a(i)) {
            return true;
        }
        return (i4 == 25840 || a(j, a)) ? false : true;
    }

    public static boolean a(int i) {
        return i == d.a.CDMA.ordinal();
    }
}