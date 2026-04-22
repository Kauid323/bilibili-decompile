package c.t.m.g;

/* compiled from: TML */
public class f2 {
    public static void a(e2 e2Var, e2 e2Var2, e2 e2Var3) {
        int i = e2Var.b;
        int i2 = e2Var2.b;
        if (i == i2) {
            int i3 = e2Var.f25c;
            int i4 = e2Var2.f25c;
            if (i3 == i4 && i2 == e2Var3.b && i4 == e2Var3.f25c) {
                for (int i5 = 0; i5 < e2Var.b; i5++) {
                    for (int i6 = 0; i6 < e2Var.f25c; i6++) {
                        e2Var.a[i5][i6] = e2Var2.a[i5][i6] * e2Var3.a[i5][i6];
                    }
                }
                return;
            }
        }
        a();
        throw null;
    }

    public static void b(e2 e2Var, e2 e2Var2, e2 e2Var3) {
        if (e2Var != e2Var2 && e2Var != e2Var3) {
            if (e2Var.b == e2Var2.b && e2Var.f25c == e2Var3.f25c && e2Var2.f25c == e2Var3.b) {
                for (int i = 0; i < e2Var.b; i++) {
                    for (int i2 = 0; i2 < e2Var.f25c; i2++) {
                        double d = 0.0d;
                        for (int i3 = 0; i3 < e2Var2.f25c; i3++) {
                            d += e2Var2.a[i][i3] * e2Var3.a[i3][i2];
                        }
                        e2Var.a[i][i2] = d;
                    }
                }
                return;
            }
            a();
            throw null;
        }
        throw new IllegalArgumentException("resMatrix cannot be mA,mB.");
    }

    public static void a(e2 e2Var, double[][] dArr) {
        a(e2Var.a, dArr);
    }

    public static void a(double[][] dArr, double[][] dArr2) {
        if (dArr.length == dArr2.length && (dArr.length == 0 || dArr[0].length == dArr2[0].length)) {
            for (int i = 0; i < dArr.length; i++) {
                System.arraycopy(dArr2[i], 0, dArr[i], 0, dArr2[i].length);
            }
            return;
        }
        a();
        throw null;
    }

    public static void a() {
        throw new IllegalArgumentException("Illegal matrix dimensions.");
    }
}