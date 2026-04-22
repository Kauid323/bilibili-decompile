package c.t.m.g;

import java.util.Locale;

/* compiled from: TML */
public class b4 {
    public static int a(boolean z) {
        return z ? 1 : 0;
    }

    public static final String a(double d, int i) {
        return String.format(Locale.ENGLISH, "%." + i + "f", Double.valueOf(d));
    }

    public static final boolean a(double d, double d2) {
        return a(d, d2, 1.0E-8d);
    }

    public static final boolean a(double d, double d2, double d3) {
        return (Double.isNaN(d) || Double.isNaN(d2) || Math.abs(d - d2) >= d3) ? false : true;
    }

    public static final boolean a(float f, float f2) {
        return a(f, f2, 1.0E-8f);
    }

    public static final boolean a(float f, float f2, float f3) {
        return (Float.isNaN(f) || Float.isNaN(f2) || Math.abs(f - f2) >= f3) ? false : true;
    }
}