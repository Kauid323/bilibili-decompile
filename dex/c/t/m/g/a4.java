package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: TML */
public class a4 {

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public enum a {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public static String a() {
        return a(b3.a());
    }

    public static a b() {
        return b(b3.a());
    }

    @Deprecated
    public static String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) i4.b("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getTypeName().toUpperCase() + "[" + activeNetworkInfo.getSubtypeName() + "]";
            }
        } catch (Throwable th) {
        }
        return "UNKNOWN";
    }

    @Deprecated
    public static a b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) i4.b("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return connectivityManager.isActiveNetworkMetered() ? a.NETWORK_MOBILE : a.NETWORK_WIFI;
            }
            return a.NETWORK_NONE;
        } catch (Throwable th) {
            return a.NETWORK_NONE;
        }
    }
}