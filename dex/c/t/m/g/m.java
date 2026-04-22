package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: TML */
public class m {
    public static volatile String a = "209";
    public static volatile String b = "fc_sdk";

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator<Object> f62c = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            ScanResult scanResult = (ScanResult) obj;
            ScanResult scanResult2 = (ScanResult) obj2;
            int i = (int) (((scanResult2.timestamp / 1000) / 1000) - ((scanResult.timestamp / 1000) / 1000));
            return i == 0 ? scanResult2.level - scanResult.level : i;
        }
    }

    public static String a(c cVar, Location location, List<ScanResult> list, List<d> list2, boolean z) {
        int size;
        long j;
        int i;
        if (list != null) {
            try {
                size = list.size();
            } catch (Throwable th) {
                w3.a("DCUtils", "get write string error!", th);
            }
        } else {
            size = 0;
        }
        int size2 = list2 != null ? list2.size() : 0;
        if (cVar != null && location != null && (size != 0 || size2 != 0)) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            sb.append(0).append(",").append(String.format(Locale.ENGLISH, "%.6f", Double.valueOf(location.getLatitude()))).append(",").append(String.format(Locale.ENGLISH, "%.6f", Double.valueOf(location.getLongitude()))).append(",").append((int) location.getAltitude()).append(",").append((int) location.getAccuracy()).append(",").append((int) location.getBearing()).append(",").append(String.format(Locale.ENGLISH, "%.1f", Float.valueOf(location.getSpeed()))).append(",").append(location.getTime());
            if (!d4.a((Collection) list2)) {
                int i2 = 0;
                while (i2 < list2.size()) {
                    d dVar = list2.get(i2);
                    sb2.append(i2 == 0 ? "" : com.alipay.sdk.m.q.h.b).append(dVar.a).append(",").append(dVar.b).append(",").append(dVar.f17c).append(",").append(dVar.e).append(",").append(dVar.d).append(",").append(i2 == 0 ? b4.a(z) : -1).append(",").append(dVar.f);
                    i2++;
                }
            }
            if (list != null && list.size() > 0) {
                Object[] array = list.toArray();
                Arrays.sort(array, f62c);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                int i3 = 0;
                while (i3 < array.length) {
                    ScanResult scanResult = (ScanResult) array[i3];
                    sb3.append(i3 == 0 ? "" : com.alipay.sdk.m.o.a.l).append(scanResult.BSSID.replaceAll(":", "").toLowerCase()).append(com.alipay.sdk.m.o.a.l).append(scanResult.level);
                    if (scanResult.timestamp <= 0) {
                        j = 1000;
                        i = -1;
                    } else {
                        j = 1000;
                        i = (int) (elapsedRealtime - ((scanResult.timestamp / 1000) / 1000));
                    }
                    sb4.append(i3 == 0 ? "" : com.alipay.sdk.m.o.a.l).append(i);
                    i3++;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            String a2 = p.a();
            if (a2 != null && a2.length() > 5) {
                JSONObject jSONObject = new JSONObject(a2);
                sb5.append(jSONObject.optString("mac").replaceAll(":", "").toLowerCase()).append(com.alipay.sdk.m.o.a.l).append(jSONObject.optString("ssid")).append(com.alipay.sdk.m.o.a.l).append(jSONObject.optString("rssi"));
                if (sb5.length() < 5) {
                    sb5.setLength(0);
                }
            }
            String str = cVar.b().replaceAll("[| _]", "") + "_" + cVar.c();
            String str2 = cVar.d().replaceAll("[| _]", "") + "_" + cVar.e().replaceAll("[| _]", "");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("[").append(f3.b("yyyy-MM-dd HH:mm:ss").format(new Date())).append("]:").append(cVar.f()).append("|").append(a).append("|").append(cVar.a()).append("|").append(l.f ? o.a() : "").append("|").append(l.f ? o.b() : "").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append((CharSequence) sb).append("|").append("").append("|").append((CharSequence) sb2).append("|").append((CharSequence) sb3).append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append(b).append("|").append("").append("|").append("").append("|").append("").append("|").append((CharSequence) sb5).append("|").append("").append("|").append(l.f ? o.c().replaceAll(":", "").toLowerCase() : "").append("|").append(str).append("|").append("").append("|").append("").append("|").append(str2).append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append("").append("|").append(sb4.toString()).append("|").append("");
            return sb6.toString();
        }
        return "";
    }

    public static void b(String str) {
        a = str;
    }

    public static void a(String str) {
        b = str;
    }
}