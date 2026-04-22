package c.t.m.g;

import java.util.Collection;

/* compiled from: TML */
public class d4 {
    @Deprecated
    public static int a(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(Object... objArr) {
        return !b(objArr);
    }

    public static boolean b(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean a(double[] dArr) {
        return dArr == null || dArr.length == 0;
    }

    public static boolean a(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}