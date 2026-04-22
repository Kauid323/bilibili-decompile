package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class IjkNetworkUtils {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum NetWorkType {
        NONE,
        WIFI,
        MOBILE,
        WIFI_METERED
    }

    public static NetWorkType getNetworkState(Context context) {
        if (context == null) {
            return NetWorkType.NONE;
        }
        if (isNetworkAvailable(context)) {
            if (isWifiValid(context)) {
                return NetWorkType.WIFI;
            }
            if (isMobileNetwork(context)) {
                return NetWorkType.MOBILE;
            }
            return NetWorkType.WIFI;
        }
        return NetWorkType.NONE;
    }

    private static boolean isNetworkAvailable(Context context) {
        NetworkInfo info;
        return (context == null || (info = getActiveNetworkInfo(context)) == null || !info.isConnected()) ? false : true;
    }

    private static boolean isWifiValid(Context context) {
        NetworkInfo info;
        return context != null && (info = getActiveNetworkInfo(context)) != null && 1 == info.getType() && info.isConnected();
    }

    private static boolean isMobileNetwork(Context context) {
        NetworkInfo info;
        return context != null && (info = getActiveNetworkInfo(context)) != null && info.getType() == 0 && info.isConnected();
    }

    private static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivity == null) {
            return null;
        }
        return connectivity.getActiveNetworkInfo();
    }
}