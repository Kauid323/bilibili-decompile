package c.t.m.g;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.core.content.PermissionChecker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: TML */
public class u3 {
    public static u3 a = new u3();

    public static u3 a() {
        return a;
    }

    public final int a(int i) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 128;
            case 2:
                return 256;
            case 3:
                return 512;
            default:
                return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(Context context) {
        int i;
        boolean z;
        LocationManager locationManager;
        if (context == null) {
            return -1;
        }
        boolean d = d(context);
        boolean z2 = false;
        try {
            locationManager = (LocationManager) context.getSystemService("location");
        } catch (Exception e) {
            i = 0;
        }
        if (locationManager == null) {
            i = 0;
        } else {
            try {
                i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
            } catch (Throwable th) {
                i = 0;
            }
            try {
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                List<String> allProviders = locationManager.getAllProviders();
                if (allProviders == null) {
                    z = false;
                    z2 = isProviderEnabled;
                } else {
                    z = allProviders.contains("gps");
                    z2 = isProviderEnabled;
                }
            } catch (Exception e2) {
            }
            int a2 = a(context);
            if (!d) {
                a2++;
            }
            if (!z2) {
                a2 += 4;
            }
            if (!z) {
                a2 += 16;
            }
            return a2 + a(i);
        }
        z = false;
        int a22 = a(context);
        if (!d) {
        }
        if (!z2) {
        }
        if (!z) {
        }
        return a22 + a(i);
    }

    public String c(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.CHANGE_NETWORK_STATE");
            if (Build.VERSION.SDK_INT >= 29) {
                arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
            int i = context.getApplicationInfo().targetSdkVersion;
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    if (!a(context, (String) arrayList.get(i3), i)) {
                        i2 |= 1 << i3;
                    }
                } catch (Throwable th) {
                    i2 = -1;
                }
            }
            return Build.VERSION.SDK_INT + com.alipay.sdk.m.o.a.l + i + com.alipay.sdk.m.o.a.l + i2 + com.alipay.sdk.m.o.a.l + a().b(context);
        } catch (Throwable th2) {
            return "";
        }
    }

    public boolean d(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return i4.a(telephonyManager) == 5;
        } catch (Exception e) {
            return false;
        }
    }

    public final boolean a(Context context, String str, int i) {
        return i < 23 ? PermissionChecker.checkSelfPermission(context, str) == 0 : context.checkSelfPermission(str) == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Context context) {
        boolean z;
        boolean z2;
        boolean z3;
        WifiManager wifiManager;
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Throwable th) {
            z = false;
        }
        if (wifiManager == null) {
            z = false;
        } else {
            z = wifiManager.isWifiEnabled();
            try {
                z3 = true;
                z2 = wifiManager.isScanAlwaysAvailable();
            } catch (Throwable th2) {
            }
            int i = z ? 0 : 2;
            if (!z3) {
                i += 8;
            }
            return z2 ? i + 32 : i;
        }
        z2 = false;
        z3 = false;
        if (z) {
        }
        if (!z3) {
        }
        if (z2) {
        }
    }
}