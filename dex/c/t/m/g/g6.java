package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;

/* compiled from: TML */
public class g6 {
    public static boolean a = true;

    public static TencentLocation a(TencentLocation tencentLocation, byte[] bArr) {
        return tencentLocation;
    }

    public static void a(TencentLocation tencentLocation, Location location) {
    }

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(int i) {
        return i == 0 || i == 1 || i == 3 || i == 4;
    }

    public static boolean a(TencentLocationRequest tencentLocationRequest) {
        return false;
    }

    public static boolean b(int i) {
        switch (i) {
            case 10:
            case 11:
            case 12:
                return true;
            default:
                return false;
        }
    }
}