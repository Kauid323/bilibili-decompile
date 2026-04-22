package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import com.alipay.sdk.app.PayTask;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class j7 {
    public static boolean a = false;
    public static long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f51c = false;
    public static volatile boolean d = false;
    public static List<ScanResult> e;
    public static long f;
    public static final Comparator<ScanResult> g = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Comparator<ScanResult> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public static int a(WifiManager wifiManager) {
        if (wifiManager != null) {
            try {
                return wifiManager.getWifiState();
            } catch (Throwable th) {
            }
        }
        return 4;
    }

    public static boolean b(m4 m4Var) {
        try {
            WifiManager i = m4Var.i();
            if (i != null) {
                return i.isWifiEnabled();
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean c(m4 m4Var) {
        WifiManager i = m4Var.i();
        if (i != null) {
            try {
                if (Settings.Secure.getInt(m4Var.a.getContentResolver(), "location_mode") == 0) {
                    a7.c("wifis", "wifi not scannable due to location mode off");
                    return false;
                }
                boolean isWifiEnabled = i.isWifiEnabled();
                a7.c("wifis", "isWifiEnabled = " + isWifiEnabled);
                if (isWifiEnabled) {
                    return isWifiEnabled;
                }
                boolean isScanAlwaysAvailable = i.isScanAlwaysAvailable();
                a7.c("wifis", "isScanAlwaysAvailable = " + isScanAlwaysAvailable);
                return isScanAlwaysAvailable;
            } catch (Throwable th) {
                if (th instanceof SecurityException) {
                    a = true;
                }
                a7.a("wifis", "", th);
                return false;
            }
        }
        return false;
    }

    public static synchronized List<ScanResult> a(WifiManager wifiManager, boolean z) {
        List<ScanResult> list;
        synchronized (j7.class) {
            if (e5.b) {
                z = true;
            }
            a7.b("wifis", "getScanResultsQuietly, due to isWifichanged: " + z + ", isImproveNetLoc: " + e5.b);
            if (z) {
                list = null;
            } else {
                long currentTimeMillis = System.currentTimeMillis() - f;
                a7.b("wifis", "getScanResultsQuietly, cached wifi time: " + currentTimeMillis);
                if (currentTimeMillis >= 20000) {
                    list = null;
                } else {
                    list = e;
                }
                if (list != null) {
                    a7.b("wifis", "getScanResultsQuietly, cached wifi size: " + list.size());
                    return list;
                }
            }
            e = null;
            f = 0L;
            if (wifiManager != null) {
                try {
                    list = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getScanResults(wifiManager);
                    e = list;
                    f = System.currentTimeMillis();
                    a7.b("wifis", "getScanResults systemapi wifi size:" + list.size());
                    a = false;
                } catch (Exception e2) {
                    a = true;
                    x3.a("WIFI", "denied");
                }
            }
            if (list == null) {
                list = Collections.emptyList();
            }
            return list;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0080 -> B:27:0x0086). Please submit an issue!!! */
    public static synchronized boolean b(WifiManager wifiManager) {
        boolean z;
        synchronized (j7.class) {
            z = false;
            if (wifiManager != null) {
                try {
                    a7.c("wifis", "is Single request: " + d);
                    if (System.currentTimeMillis() - b > PayTask.j) {
                        z = wifiManager.startScan();
                        w6.a("wifi scan," + z);
                        f51c = z;
                        b = System.currentTimeMillis();
                        a7.b("wifis", "startScan systemapi " + (z ? "success" : com.alipay.sdk.m.q.g.j));
                    } else {
                        a7.b("wifis", "force scan reject");
                        z = f51c;
                    }
                } catch (Exception e2) {
                    a = true;
                }
            }
        }
        return z;
    }

    public static String a(m4 m4Var) {
        n1 a2;
        Context context = m4Var.a;
        if (context == null) {
            return "{}";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (wifiManager != null && connectivityManager != null && (a2 = l4.a()) != null) {
                String a3 = a2.a();
                if (l4.a(a3)) {
                    a7.b("Wifis", a3);
                    return "{}";
                }
                int b2 = a2.b();
                String replace = a2.c().replace("\"", "").replace("|", "");
                String replace2 = a3.replace(":", "");
                return "{\"mac\":\"" + replace2 + "\",\"rssi\":" + b2 + ",\"ssid\":\"" + replace + "\"}";
            }
            return "{}";
        } catch (Exception e2) {
            return "{}";
        }
    }

    @JvmStatic
    private static List<ScanResult> __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getScanResults(WifiManager wm) {
        Intrinsics.checkNotNullParameter(wm, "wm");
        Object defaultReturnValue$iv = CollectionsKt.emptyList();
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("wm_get_scan_result")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [wm_get_scan_result]", (Throwable) null, 4, (Object) null);
                Object scanResults = wm.getScanResults();
                defaultReturnValue$iv = scanResults instanceof List ? scanResults : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("wm_get_scan_result")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [wm_get_scan_result] defaultReturnValue = [" + defaultReturnValue$iv + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("wm_get_scan_result")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [wm_get_scan_result] defaultReturnValue = [" + defaultReturnValue$iv + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "wm_get_scan_result");
                if (it$iv == null) {
                    Object scanResults2 = wm.getScanResults();
                    if (!(scanResults2 instanceof List)) {
                        scanResults2 = null;
                    }
                    Object res$iv = scanResults2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put("wm_get_scan_result", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "wm_get_scan_result", defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: wm_get_scan_result", (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: wm_get_scan_result, message = " + t$iv.getMessage(), t$iv);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: wm_get_scan_result, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
        return (List) defaultReturnValue$iv;
    }
}