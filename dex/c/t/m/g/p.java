package c.t.m.g;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.HashMap;
import java.util.List;

/* compiled from: TML */
public class p {
    public static HashMap a = new HashMap();

    public static int a(Context context) {
        try {
            return a((WifiManager) context.getSystemService("wifi"));
        } catch (Throwable th) {
            return 4;
        }
    }

    public static int a(WifiManager wifiManager) {
        if (wifiManager == null) {
            return 4;
        }
        try {
            return wifiManager.getWifiState();
        } catch (Throwable th) {
            return 4;
        }
    }

    public static String a() {
        int b;
        try {
            n1 a2 = l4.a();
            if (a2 != null) {
                String a3 = a2.a();
                if (!l4.a(a3) && (b = a2.b()) >= -100 && b <= -20) {
                    String replace = a2.c().replace("\"", "").replace("|", "");
                    return "{\"mac\":\"" + a3 + "\",\"rssi\":" + b + ",\"ssid\":\"" + replace + "\"}";
                }
            }
            return "{}";
        } catch (Throwable th) {
            return "{}";
        }
    }

    public static boolean a(List<ScanResult> list) {
        if (list != null && list.size() > 1) {
            String str = list.get(0).BSSID;
            for (int i = 1; i < list.size(); i++) {
                if (!str.equals(list.get(i).BSSID)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004c A[Catch: all -> 0x006c, TryCatch #2 {, blocks: (B:14:0x0015, B:11:0x000d, B:21:0x0021, B:22:0x002a, B:24:0x0030, B:25:0x0042, B:26:0x0046, B:28:0x004c, B:30:0x005a), top: B:41:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(List<ScanResult> list, List<ScanResult> list2) {
        synchronized (p.class) {
            if (list == list2) {
                return true;
            }
            int size = list == null ? 0 : list.size();
            if (size != (list2 == null ? 0 : list2.size())) {
                return false;
            }
            if (size == 0) {
                return true;
            }
            HashMap hashMap = a;
            hashMap.clear();
            for (ScanResult scanResult : list) {
                hashMap.put(scanResult.BSSID, Integer.valueOf(scanResult.level));
            }
            for (ScanResult scanResult2 : list2) {
                if (!hashMap.containsKey(scanResult2.BSSID) || scanResult2.level != ((Integer) hashMap.get(scanResult2.BSSID)).intValue()) {
                    return false;
                }
                while (r6.hasNext()) {
                }
            }
            return true;
        }
    }
}