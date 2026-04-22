package tv.danmaku.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.net.ConnectivityManagerCompat;
import com.bilibili.commons.StringUtils;
import java.util.Locale;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;

public class ConnectivityManagerHelper {
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_5_G = 4;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final String[] networkClassNames = {"", "2G", "3G", "4G", "5G"};

    public static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    @Deprecated
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager manager = getConnectivityManager(context);
        if (manager == null) {
            return null;
        }
        return manager.getActiveNetworkInfo();
    }

    @Deprecated
    public static boolean isConnectedOrConnecting(Context context) {
        NetworkInfo networkInfo = getActiveNetworkInfo(context);
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnectedOrConnecting();
    }

    @Deprecated
    public static boolean isConnected(Context context) {
        NetworkInfo networkInfo = getActiveNetworkInfo(context);
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    @Deprecated
    public static boolean isWifi(Context context) {
        String typeName;
        try {
            NetworkInfo info = getActiveNetworkInfo(context);
            typeName = info.getTypeName().toLowerCase(Locale.US);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(typeName)) {
            return false;
        }
        if (!typeName.equals(NetworkUtilsKt.NETWORK_TYPE_WIFI)) {
            return false;
        }
        return true;
    }

    public static boolean isActiveNetworkMetered(Context context) {
        ConnectivityManager manager = getConnectivityManager(context);
        if (manager == null) {
            return false;
        }
        return isActiveNetworkMetered(manager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        try {
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info == null) {
                return false;
            }
            int type = info.getType();
            switch (type) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return true;
                case 1:
                    if (isFlyme6()) {
                        return false;
                    }
                    break;
                case 7:
                case 9:
                    return false;
            }
            return ConnectivityManagerCompat.isActiveNetworkMetered(cm);
        } catch (Exception e) {
            BLog.w("Network", "Failed to retrieve active network info!", e);
            return false;
        }
    }

    private static boolean isFlyme6() {
        return StringUtils.equalsIgnoreCase(Build.MANUFACTURER, "meizu") && StringUtils.equalsIgnoreCase(Build.USER, "flyme") && StringUtils.startsWith(Build.DISPLAY, "Flyme 6.");
    }

    public static String getActiveNetworkName(Context context) {
        try {
            NetworkInfo info = getActiveNetworkInfo(context);
            String typeName = info.getTypeName().toLowerCase(Locale.US);
            if (TextUtils.isEmpty(typeName)) {
                return "";
            }
            if (typeName.equals(NetworkUtilsKt.NETWORK_TYPE_WIFI)) {
                return typeName;
            }
            String extraInfoName = info.getExtraInfo().toLowerCase(Locale.US);
            if (!TextUtils.isEmpty(extraInfoName)) {
                return extraInfoName;
            }
            return typeName;
        } catch (Exception e) {
            return null;
        }
    }

    public static int getNetworkClass(int networkType) {
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 2;
            case 13:
            case 18:
            case 19:
                return 3;
            case 20:
                return 4;
            default:
                return 0;
        }
    }

    public static String getNetworkClassName(NetworkInfo info) {
        try {
            String typeName = info.getTypeName().toLowerCase(Locale.US);
            if (TextUtils.isEmpty(typeName)) {
                return "";
            }
            if (typeName.equals(NetworkUtilsKt.NETWORK_TYPE_WIFI)) {
                return typeName;
            }
            int subtype = info.getSubtype();
            int networkClass = getNetworkClass(subtype);
            return (networkClass < 0 || networkClass >= networkClassNames.length) ? "" : networkClassNames[networkClass];
        } catch (Exception e) {
            return null;
        }
    }
}