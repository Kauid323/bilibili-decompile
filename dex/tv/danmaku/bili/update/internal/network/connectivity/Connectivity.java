package tv.danmaku.bili.update.internal.network.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class Connectivity {
    private static final String TAG = "Connectivity";
    private static final int[] s_WifiSecondaryTypes = new int[0];
    private static final int[] s_MobileSecondaryTypes = {2, 3, 4, 5};
    private static final TelephonyTypeDefine[] s_TelephonyTypeDefines = {new TelephonyTypeDefine(0, false, "Unknown", 4), new TelephonyTypeDefine(1, false, "0 ~ 100 kbps", 22), new TelephonyTypeDefine(2, false, "0 ~ 50-100 kbps", 22), new TelephonyTypeDefine(3, true, "0 ~ 400-7000 kbps", 32), new TelephonyTypeDefine(4, false, "0 ~ 14-64 kbps", 22), new TelephonyTypeDefine(5, true, "0 ~ 400-1000 kbps", 32), new TelephonyTypeDefine(6, true, "0 ~ 600-1400 kbps", 32), new TelephonyTypeDefine(7, false, "0 ~ 50 - 100 kbps", 22), new TelephonyTypeDefine(8, true, "0 ~ 2-14 Mbps", 32), new TelephonyTypeDefine(9, true, "0 ~ 1-23 Mbps", 32), new TelephonyTypeDefine(10, true, "0 ~ 700-1700 kbps", 32), new TelephonyTypeDefine(11, false, "0 ~ 25 kbps", 22), new TelephonyTypeDefine(12, true, "0 ~ 5 Mbps", 32), new TelephonyTypeDefine(13, true, "0 ~ 10+ Mbps", 42), new TelephonyTypeDefine(14, true, "0 ~ 1-2 Mbps", 32), new TelephonyTypeDefine(15, true, "0 ~ 10-20 Mbps", 32), new TelephonyTypeDefine(20, true, "0 ~ 10-20 Gbps", 52)};

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum SIMCARD_OPERATE {
        OPERATE_MOBILE,
        OPERATE_UNICOM,
        OPERATE_TELECOM,
        OPERATE_UNKNOWN
    }

    public static NetworkInfo getNetworkInfos(Context context, int networkType) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService("connectivity");
        if (cm != null) {
            try {
                return cm.getNetworkInfo(networkType);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static NetworkInfo getEthernetNetworkInfo(Context context) {
        return getNetworkInfos(context, 9);
    }

    public static NetworkInfo getWifiNetworkInfo(Context context) {
        return getNetworkInfoFromList(context, 1, s_WifiSecondaryTypes);
    }

    public static NetworkInfo getMobileNetworkInfo(Context context) {
        return getNetworkInfoFromList(context, 0, s_MobileSecondaryTypes);
    }

    public static boolean isConnected(NetworkInfo info) {
        return info != null && info.isConnected();
    }

    public static boolean isConnectedOrConnecting(NetworkInfo info) {
        return info != null && info.isConnectedOrConnecting();
    }

    public static boolean isConnectedEthernet(NetworkInfo info) {
        return info != null && info.isConnected() && 9 == info.getType();
    }

    public static boolean isConnectedWifi(NetworkInfo info) {
        return info != null && info.isConnected() && isNetworkTypeWifi(info.getType());
    }

    public static boolean isConnectedMobile(NetworkInfo info) {
        return info != null && info.isConnected() && isNetworkTypeMobile(info.getType());
    }

    public static boolean isConnectedFast(NetworkInfo info) {
        return info != null && info.isConnected() && isConnectedFast(info.getType(), info.getSubtype());
    }

    public static boolean isConnectedFast(int type, int subtype) {
        TelephonyTypeDefine[] telephonyTypeDefineArr;
        switch (type) {
            case 1:
            case 9:
                return true;
            default:
                if (type != 0) {
                    return false;
                }
                for (TelephonyTypeDefine typeDef : s_TelephonyTypeDefines) {
                    if (typeDef.networkType == subtype) {
                        return typeDef.fast;
                    }
                }
                return false;
        }
    }

    public static boolean isNetworkRoaming(Context context, NetworkInfo activeNetworkInfo) {
        boolean isMobile;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivity == null) {
            return false;
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            isMobile = false;
        } else {
            isMobile = true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || !isMobile || !telephonyManager.isNetworkRoaming()) {
            return false;
        }
        return true;
    }

    public static String getNetworkSpeed(int type, int subtype) {
        TelephonyTypeDefine[] telephonyTypeDefineArr;
        switch (type) {
            case 1:
            case 9:
                return "Fast";
            default:
                if (type != 0) {
                    return "Unknown";
                }
                for (TelephonyTypeDefine typeDef : s_TelephonyTypeDefines) {
                    if (typeDef.networkType == subtype) {
                        return typeDef.speedDesc;
                    }
                }
                return "Unknown";
        }
    }

    public static int getNetworkDetail(int type, int subtype) {
        TelephonyTypeDefine[] telephonyTypeDefineArr;
        switch (type) {
            case 1:
                return 1;
            case 9:
                return 5;
            default:
                if (type != 0) {
                    return 4;
                }
                for (TelephonyTypeDefine typeDef : s_TelephonyTypeDefines) {
                    if (typeDef.networkType == subtype) {
                        return typeDef.networkTypeDetail;
                    }
                }
                return 4;
        }
    }

    private static boolean isNetworkTypeMobile(int networkType) {
        switch (networkType) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            case 1:
            default:
                return false;
        }
    }

    private static boolean isNetworkTypeWifi(int networkType) {
        switch (networkType) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    private static NetworkInfo getNetworkInfoFromList(Context context, int mainType, int[] secondaryTypes) {
        NetworkInfo mainInfo = getNetworkInfos(context, mainType);
        if (isConnected(mainInfo)) {
            return mainInfo;
        }
        for (int secondaryType : secondaryTypes) {
            NetworkInfo secondaryInfo = getNetworkInfos(context, secondaryType);
            if (isConnected(secondaryInfo)) {
                return secondaryInfo;
            }
        }
        return mainInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class TelephonyTypeDefine {
        final boolean fast;
        final int networkType;
        final int networkTypeDetail;
        final String speedDesc;

        TelephonyTypeDefine(int networkType, boolean fast, String speedDesc, int networkTypeDetail) {
            this.networkType = networkType;
            this.fast = fast;
            this.speedDesc = speedDesc;
            this.networkTypeDetail = networkTypeDetail;
        }
    }
}