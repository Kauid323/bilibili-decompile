package c.t.m.g;

import android.location.Location;

/* compiled from: TML */
public class x4 {
    public static x4 h;
    public static x4 i;
    public final double a;
    public final double b;

    /* renamed from: c  reason: collision with root package name */
    public final double f119c;
    public final float d;
    public final float e;
    public final float f;
    public final long g = System.currentTimeMillis();

    public x4(double d, double d2, double d3, float f, float f2, float f3) {
        this.a = d;
        this.b = d2;
        this.f119c = d3;
        this.d = f;
        this.e = f2;
        this.f = f3;
    }

    public Location a() {
        Location location = new Location("gps");
        location.setLatitude(this.a);
        location.setLongitude(this.b);
        location.setAltitude(this.f119c);
        location.setAccuracy(this.d);
        location.setBearing(this.e);
        location.setSpeed(this.f);
        return location;
    }

    public String toString() {
        return "GpsCach{" + this.a + "," + this.b + "," + this.g + "," + this.f119c + "," + this.d + "," + this.e + "," + this.f + com.alipay.sdk.m.q.h.d;
    }
}