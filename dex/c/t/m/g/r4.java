package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;

/* compiled from: TML */
public class r4 {
    public static Location a(TencentLocation tencentLocation, boolean z) {
        if (tencentLocation == null) {
            return null;
        }
        String provider = tencentLocation.getProvider();
        Location location = new Location(provider);
        location.setLatitude(tencentLocation.getLatitude());
        location.setLongitude(tencentLocation.getLongitude());
        location.setAccuracy(tencentLocation.getAccuracy());
        location.setTime(tencentLocation.getTime());
        if (z && "gps".equals(provider)) {
            double[] dArr = new double[2];
            g7.a(location, dArr);
            location.setLatitude(dArr[0]);
            location.setLongitude(dArr[1]);
            ((p6) tencentLocation).b(location);
        }
        return location;
    }

    public static void a(Location location) {
        if (location.getAccuracy() > 500.0f) {
            location.setAccuracy(500.0f);
        }
    }
}