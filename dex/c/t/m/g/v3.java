package c.t.m.g;

/* compiled from: TML */
public class v3 {
    public static double a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static double a(double d, double d2, double d3, double d4) {
        double a = a(d);
        double a2 = a(d3);
        return Math.round((((Math.asin(Math.sqrt(Math.pow(Math.sin((a - a2) / 2.0d), 2.0d) + ((Math.cos(a) * Math.cos(a2)) * Math.pow(Math.sin((a(d2) - a(d4)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 1000.0d) * 1000.0d) / 1000.0d;
    }
}