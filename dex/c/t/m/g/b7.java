package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: TML */
public class b7 {
    public static int a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (c7.a(connectivityManager)) {
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public static String b(Context context) {
        int a = a(context);
        if (a != -1) {
            if (a == 0) {
                return "mobile";
            }
            if (a == 1) {
                return "wifi";
            }
        }
        return "none";
    }

    public static boolean c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (c7.a(connectivityManager)) {
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 != null) {
                boolean isConnected = networkInfo2.isConnected();
                return (isConnected || networkInfo == null) ? isConnected : networkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}