package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import kotlin.jvm.JvmStatic;

/* compiled from: TML */
public class l4 {
    public static n1 a;

    public static n1 a() {
        return a(b3.a());
    }

    public static void b() {
        a = null;
    }

    @Deprecated
    public static n1 a(Context context) {
        ConnectivityManager connectivityManager;
        try {
            WifiManager wifiManager = (WifiManager) b3.a().getApplicationContext().getSystemService("wifi");
            if (context == null) {
                connectivityManager = null;
            } else {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            }
            if (wifiManager != null && connectivityManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (connectionInfo != null && networkInfo != null && networkInfo.isConnected()) {
                    n1 n1Var = a;
                    if (n1Var != null && System.currentTimeMillis() - n1Var.d() <= 10000) {
                        return a;
                    }
                    String __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getBSSID = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getBSSID(connectionInfo);
                    if (a(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getBSSID)) {
                        a = null;
                        return null;
                    }
                    n1 n1Var2 = new n1();
                    n1Var2.a(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getBSSID);
                    n1Var2.a(connectionInfo.getRssi());
                    n1Var2.b(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getSSID(connectionInfo));
                    n1Var2.a(System.currentTimeMillis());
                    a = n1Var2;
                    return n1Var2;
                }
                a = null;
                return null;
            }
            a = null;
            return null;
        } catch (Throwable th) {
            w3.a("WifiUtil", "WifiUtil", th);
            return null;
        }
    }

    public static boolean a(String str) {
        if (str == null) {
            return true;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '0') {
                i++;
            }
        }
        return i >= 10;
    }

    @JvmStatic
    private static String __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getSSID(WifiInfo obj) {
        Object defaultReturnValue$iv = "";
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("wifi_info_get_ssid")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [wifi_info_get_ssid]", (Throwable) null, 4, (Object) null);
                Object ssid = obj.getSSID();
                defaultReturnValue$iv = ssid instanceof String ? ssid : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("wifi_info_get_ssid")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [wifi_info_get_ssid] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("wifi_info_get_ssid")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [wifi_info_get_ssid] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "wifi_info_get_ssid");
                if (it$iv == null) {
                    Object ssid2 = obj.getSSID();
                    if (!(ssid2 instanceof String)) {
                        ssid2 = null;
                    }
                    Object res$iv = ssid2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put("wifi_info_get_ssid", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "wifi_info_get_ssid", defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: wifi_info_get_ssid", (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: wifi_info_get_ssid, message = " + t$iv.getMessage(), t$iv);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: wifi_info_get_ssid, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
        return (String) defaultReturnValue$iv;
    }

    @JvmStatic
    private static String __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getBSSID(WifiInfo obj) {
        Object defaultReturnValue$iv = "";
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("wifi_info_get_bssid")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [wifi_info_get_bssid]", (Throwable) null, 4, (Object) null);
                Object bssid = obj.getBSSID();
                defaultReturnValue$iv = bssid instanceof String ? bssid : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("wifi_info_get_bssid")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [wifi_info_get_bssid] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("wifi_info_get_bssid")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [wifi_info_get_bssid] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "wifi_info_get_bssid");
                if (it$iv == null) {
                    Object bssid2 = obj.getBSSID();
                    if (!(bssid2 instanceof String)) {
                        bssid2 = null;
                    }
                    Object res$iv = bssid2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put("wifi_info_get_bssid", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "wifi_info_get_bssid", defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: wifi_info_get_bssid", (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: wifi_info_get_bssid, message = " + t$iv.getMessage(), t$iv);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: wifi_info_get_bssid, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
        return (String) defaultReturnValue$iv;
    }
}