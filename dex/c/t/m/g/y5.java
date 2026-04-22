package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ashampoo.kim.format.jpeg.iptc.IptcConstants;
import com.ashampoo.xmp.XMPConst;
import com.ashampoo.xmp.internal.XMPErrorConst;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* compiled from: TML */
public class y5 {
    public static long f;
    public final e6 a;
    public final w5 b;

    /* renamed from: c  reason: collision with root package name */
    public final x5 f125c;
    public final List<v5> d;
    public final List<w5> e;

    public y5(e6 e6Var, w5 w5Var, x5 x5Var, List<v5> list, List<w5> list2) {
        this.a = e6Var;
        this.b = w5Var;
        this.f125c = x5Var;
        this.d = list;
        this.e = list2;
    }

    public e6 a() {
        return this.a;
    }

    public boolean b() {
        return this.f125c != null;
    }

    public String a(int i, int i2, String str, m4 m4Var, boolean z, boolean z2, boolean z3) {
        String str2;
        e6 e6Var;
        int b;
        int i3;
        String str3;
        if (m4Var == null) {
            return null;
        }
        try {
            boolean z4 = true;
            if (this.b != null) {
                if (f == this.b.f) {
                    z4 = false;
                }
                f = this.b.f;
            }
            boolean parseBoolean = Boolean.parseBoolean(f7.a().get("enable_wifi_native_sort"));
            if (this.a == null) {
                e6Var = null;
            } else {
                try {
                    e6Var = parseBoolean ? b(this.a) : a(this.a);
                } catch (Exception e) {
                    a7.a("TxHybridInfo", "wifi sort err", e);
                    e6Var = null;
                }
            }
            if (e6Var == null) {
                e6Var = this.a;
            }
            String a = g7.a(e6Var, parseBoolean);
            String a2 = g7.a(this.b, z4);
            String a3 = g7.a(this.f125c);
            String a4 = v5.a(this.d);
            String str4 = z2 ? "{}" : a3;
            StringBuilder sb = new StringBuilder();
            if (this.e != null) {
                for (w5 w5Var : this.e) {
                    if (!sb.toString().equals("")) {
                        sb.append(",");
                    }
                    sb.append(w5Var.j());
                }
            }
            n4 a5 = m4Var.a();
            if (a5 == null) {
                return null;
            }
            String f2 = a5.f();
            a7.c(com.alipay.sdk.m.l.e.p, f2);
            String a6 = a5.a();
            String e2 = a5.e();
            w6.a("pState," + u3.a().b(m4Var.a) + "," + i4.k());
            String a7 = j7.a(m4Var);
            if (a.equals(XMPConst.ARRAY_ITEM_NAME) && !a7.equals("{}")) {
                JSONObject jSONObject = new JSONObject(a7);
                if (parseBoolean) {
                    jSONObject.put("ts", 0);
                }
                jSONObject.remove("ssid");
                a = "[" + jSONObject.toString() + "]";
            }
            String c2 = a5.c();
            if (c2 != null) {
                c2 = c2.replace("\"", "");
            }
            if (c2 != null) {
                c2 = c2.replace("|", "");
            }
            String str5 = c2 + "_" + a5.r();
            if (z3 && e2 != null) {
                i3 = (Math.abs(e2.hashCode()) % 1000) + IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO;
            } else {
                i3 = XMPErrorConst.BADXMP;
            }
            try {
                String str6 = ("{\"version\":\"7.5.4.3.official_1\",\"address\":" + i) + ",\"source\":" + i3 + ",\"access_token\":\"" + a6 + "\",\"lID\":\"" + e7.a("limei_prefs", "limei", "") + "\",\"device_id\":\"" + e2 + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str5 + "\",\"bearing\":1";
                if (i2 >= 0) {
                    str6 = str6 + ",\"control\":" + i2;
                }
                if (!TextUtils.isEmpty(a5.p())) {
                    str6 = str6 + ",\"smallappname\":\"" + a5.p() + "\"";
                }
                if (z) {
                    str3 = str6 + ",\"detectgps\":1";
                } else {
                    str3 = str6 + ",\"detectgps\":0";
                }
                String str7 = ((str3 + ",\"pstat\":" + b) + ",\"wlan\":" + a7) + ",\"attribute\":" + f2 + ",\"location\":" + str4 + ",\"historycells\":[" + ((Object) sb) + "],\"cells\":" + a2 + ",\"wifis\":" + a + ",\"bles\":" + a4 + com.alipay.sdk.m.q.h.d;
                str2 = "TxHybridInfo";
                try {
                    a7.c(str2, "reqJson: " + str7);
                    return str7;
                } catch (Throwable th) {
                    th = th;
                    a7.b(str2, th.toString());
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = "TxHybridInfo";
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = "TxHybridInfo";
            a7.b(str2, th.toString());
            return null;
        }
    }

    public final e6 b(e6 e6Var) {
        List<ScanResult> b;
        a7.b("TxHybridInfo", "wifiSortNative start");
        if (e6Var == null || (b = e6Var.b()) == null || b.size() == 0) {
            return null;
        }
        int[] iArr = new int[b.size()];
        int[] iArr2 = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            iArr[i] = b.get(i).level;
            iArr2[i] = (int) ((SystemClock.elapsedRealtime() / 1000) - ((b.get(i).timestamp / 1000) / 1000));
        }
        int[] fun_s = SoUtils.fun_s(iArr, iArr2, b.size(), true);
        ArrayList arrayList = new ArrayList();
        for (int i2 : fun_s) {
            arrayList.add(b.get(i2));
        }
        return new e6(arrayList, e6Var.c(), e6Var.d());
    }

    public final e6 a(e6 e6Var) {
        ArrayList arrayList = new ArrayList(e6Var.b());
        Collections.sort(arrayList, j7.g);
        return new e6(arrayList, e6Var.c(), e6Var.d());
    }

    public String a(int i, String str, m4 m4Var, boolean z, boolean z2, boolean z3) {
        return a(i, 0, str, m4Var, z, z2, z3);
    }
}