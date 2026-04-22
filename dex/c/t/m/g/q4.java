package c.t.m.g;

import android.app.PendingIntent;
import android.location.Location;
import com.tencent.map.geolocation.TencentGeofence;
import java.util.List;
import java.util.Locale;

/* compiled from: TML */
public class q4 {
    public final TencentGeofence a;

    /* renamed from: c  reason: collision with root package name */
    public final long f86c;
    public final PendingIntent d;
    public final int e;
    public Object h;
    public int f = 0;
    public double g = Double.MAX_VALUE;
    public final Location b = new Location("");

    public q4(TencentGeofence tencentGeofence, long j, String str, PendingIntent pendingIntent) {
        double d;
        double d2;
        this.a = tencentGeofence;
        this.e = tencentGeofence.getType();
        this.f86c = j;
        this.d = pendingIntent;
        if (this.e == 0) {
            d2 = tencentGeofence.getCircleFence().getLatitude();
            d = tencentGeofence.getCircleFence().getLongitude();
        } else {
            List<TencentGeofence.FencePoint> pointList = this.a.getPolygonFence().getPointList();
            int size = pointList.size();
            double d3 = 0.0d;
            double d4 = 0.0d;
            for (TencentGeofence.FencePoint fencePoint : pointList) {
                d4 += fencePoint.getLatitude();
                d3 += fencePoint.getLongitude();
            }
            double d5 = size;
            d = d3 / d5;
            d2 = d4 / d5;
        }
        this.b.setLatitude(d2);
        this.b.setLongitude(d);
        this.b.setTime(0L);
        this.b.setSpeed(-0.001f);
    }

    public int a(Location location) {
        boolean z;
        if (location == this.h) {
            return 0;
        }
        this.h = location;
        double a = g7.a(location.getLatitude(), location.getLongitude(), this.b.getLatitude(), this.b.getLongitude());
        this.g = a;
        if (this.e == 0) {
            z = a <= ((double) this.a.getCircleFence().getRadius());
        } else {
            boolean a2 = s4.a(new TencentGeofence.FencePoint(location.getLatitude(), location.getLongitude()), this.a.getPolygonFence().getPointList());
            if (b()) {
                a7.c("GeofenceState", this.a.getTag() + ", self:" + location.getLatitude() + "," + location.getLongitude() + ", edge:" + this.a.getPolygonFence().getPointList());
                a7.c("GeofenceState", this.a.getTag() + " is polygon? " + a2);
            }
            z = a2;
        }
        if (b()) {
            a7.c("GeofenceState", this.a.getTag() + " is in? " + z);
        }
        int i = this.f;
        if (z) {
            this.f = 1;
            if (i != 1) {
                return 1;
            }
        } else {
            this.f = 2;
            if (i == 1) {
                return 2;
            }
        }
        return 0;
    }

    public final boolean b() {
        return false;
    }

    public String toString() {
        int i = this.f;
        String str = i != 1 ? i != 2 ? "?" : "OUT" : "IN";
        if (this.e == 0) {
            return String.format(Locale.US, "%s dist=%5gm speed=%.2fm/s state=%s", this.a.toString(), Double.valueOf(this.g), Float.valueOf(a()), str);
        }
        return String.format(Locale.US, "%s state=%s", this.a.toString(), str);
    }

    public float a() {
        float speed = this.b.getSpeed();
        if (speed <= -0.001f) {
            return -0.001f;
        }
        if (speed > 25.0f) {
            return 25.0f;
        }
        if (speed < 1.0f) {
            return 1.0f;
        }
        return speed;
    }
}