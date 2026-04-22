package c.t.m.g;

import android.os.Build;

/* compiled from: TML */
public class o {
    public static volatile String a = "";

    public static String a() {
        if (e()) {
            return a;
        }
        return i4.h();
    }

    public static String b() {
        return e() ? "" : i4.j();
    }

    public static String c() {
        return (!e() && Build.VERSION.SDK_INT < 29) ? i4.l() : "";
    }

    public static String d() {
        if (e()) {
            return a;
        }
        return i4.n();
    }

    public static boolean e() {
        return false;
    }
}