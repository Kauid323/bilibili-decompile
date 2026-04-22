package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ashampoo.xmp.XMPConst;
import com.tencent.map.geolocation.util.SoUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TML */
public class g7 {
    public static volatile long a;
    public static volatile long b;

    public static double a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static int a(char c2) {
        int i = (c2 < 'A' || c2 > 'Z') ? 256 : c2 - 'A';
        if (c2 >= 'a' && c2 <= 'z') {
            i = (c2 - 'a') + 64;
        }
        return (c2 < '0' || c2 > '9') ? i : (c2 + 128) - 48;
    }

    public static boolean a(ScanResult scanResult, int i) {
        return true;
    }

    public static byte[] a(byte[] bArr) {
        byte[] a2 = h7.a(bArr);
        byte[] b2 = a2 == null ? new byte[0] : b(a2);
        byte[] bArr2 = new byte[b2.length + 4];
        int length = b2.length;
        bArr2[0] = Integer.valueOf(length >> 8).byteValue();
        bArr2[1] = Integer.valueOf(length >> 24).byteValue();
        bArr2[2] = Integer.valueOf(length >> 16).byteValue();
        bArr2[3] = Integer.valueOf(length).byteValue();
        System.arraycopy(b2, 0, bArr2, 4, length);
        return bArr2;
    }

    public static byte[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i = (length % 5) + 7;
        int i2 = 0;
        while (true) {
            int i3 = (i << 1) + i2;
            if (i3 >= length) {
                return bArr2;
            }
            byte byteValue = Integer.valueOf(i2).byteValue();
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i2 + i4;
                byte b2 = bArr2[i5];
                int i6 = i2 + i + i4;
                bArr2[i5] = (byte) (bArr2[i6] ^ byteValue);
                bArr2[i6] = (byte) (b2 ^ byteValue);
            }
            i2 = i3;
        }
    }

    public static boolean a(Location location, double[] dArr) {
        int latitude = (int) (location.getLatitude() * 1000000.0d);
        int longitude = (int) (location.getLongitude() * 1000000.0d);
        String a2 = h7.a("tencent_loc_lib");
        int i = 0;
        for (int i2 = 0; i2 < a2.length(); i2++) {
            i += a(a2.charAt(i2));
        }
        double[] dArr2 = new double[2];
        a7.c("SosoLocUtils", "defelect gps:" + latitude + "," + longitude + "," + i);
        try {
            a7.c("hh", "LocalGPSAid fun_b");
            SoUtils.fun_b(latitude ^ i, longitude ^ i, dArr2);
        } catch (UnsatisfiedLinkError e) {
            a7.a("SosoLocUtils", "deflect", e);
        }
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        a7.b("SosoLocUtils", "defelect:" + dArr[0] + "," + dArr[1] + ",pos:" + dArr2[0] + "," + dArr2[1]);
        return true;
    }

    public static double a(double d, int i) {
        try {
            if (Double.isNaN(d)) {
                return 0.0d;
            }
            return BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static String a(x5 x5Var) {
        if (x5Var == null) {
            return "{}";
        }
        Location location = x5Var.a;
        StringBuilder sb = new StringBuilder();
        double a2 = a(location.getLatitude(), 6);
        double a3 = a(location.getLongitude(), 6);
        double a4 = a(location.getAltitude(), 1);
        double a5 = a(location.getAccuracy(), 1);
        double a6 = a(location.getBearing(), 1);
        double a7 = a(location.getSpeed(), 1);
        sb.append("{");
        sb.append("\"latitude\":");
        sb.append(a2);
        sb.append(",\"longitude\":");
        sb.append(a3);
        sb.append(",\"additional\":");
        sb.append("\"" + a4 + "," + a5 + "," + a6 + "," + a7 + "," + x5Var.b + "\"");
        sb.append(",\"source\":");
        sb.append(x5Var.f.ordinal());
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    public static String a(w5 w5Var, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (w5Var == null) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        int i = w5Var.b;
        int i2 = w5Var.f114c;
        int ordinal = w5Var.a.ordinal();
        ArrayList arrayList3 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (u6.a(w5Var)) {
            long e = (currentTimeMillis - w5Var.e()) / 1000;
            String a2 = a(i, i2, w5Var.d, w5Var.f, w5Var.e, w5Var.m, w5Var.n, w5Var.j, w5Var.g, w5Var.h, w5Var.i, w5Var.k, w5Var.l, z ? 1 : 0, ordinal, e, w5Var.o);
            arrayList = arrayList3;
            arrayList.add(a2);
        } else {
            arrayList = arrayList3;
            a("illeagal main cell! ", i, i2, ordinal, w5Var.d, w5Var.f);
        }
        try {
            Iterator<w5> it = w5Var.d().iterator();
            while (it.hasNext()) {
                w5 next = it.next();
                long e2 = (currentTimeMillis - next.e()) / 1000;
                Iterator<w5> it2 = it;
                ArrayList arrayList4 = arrayList;
                try {
                    String a3 = a(next.b, next.f114c, next.d, next.f, next.e, next.m, next.n, next.j, next.g, next.h, next.i, next.k, next.l, -1, next.a.ordinal(), e2, next.o);
                    arrayList2 = arrayList4;
                    try {
                        arrayList2.add(a3);
                        it = it2;
                        arrayList = arrayList2;
                    } catch (Throwable th) {
                        th = th;
                        w3.a("SosoLocUtils", "add neighbor error.", th);
                        return "[" + z6.b(",").a(arrayList2) + "]";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    arrayList2 = arrayList4;
                }
            }
            arrayList2 = arrayList;
        } catch (Throwable th3) {
            th = th3;
            arrayList2 = arrayList;
        }
        return "[" + z6.b(",").a(arrayList2) + "]";
    }

    public static void a(String str, int i, int i2, int i3, int i4, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCellInfoWithJsonFormat: ");
        sb.append(str);
        sb.append("isGsm=").append(i3 == 1);
        sb.append(", mcc,mnc=").append(i).append(",").append(i2);
        sb.append(", lac,cid=").append(i4).append(",").append(j);
    }

    public static String a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j2, int i15) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"mcc\":");
        sb.append(i);
        sb.append(",\"mnc\":");
        sb.append(i2);
        sb.append(",\"lac\":");
        sb.append(i3);
        sb.append(",\"cellid\":");
        sb.append(j);
        sb.append(",\"pci\":");
        sb.append(i7);
        sb.append(",\"csisinr\":");
        sb.append(i8);
        sb.append(",\"ssrsrp\":");
        sb.append(i9);
        sb.append(",\"csirsrp\":");
        sb.append(i10);
        sb.append(",\"earfcn\":");
        sb.append(i11);
        sb.append(",\"rsrq\":");
        sb.append(i12);
        sb.append(",\"rss\":");
        sb.append(i4);
        if (i13 == 1 || i13 == 0) {
            sb.append(",\"seed\":");
            sb.append(i13);
        }
        sb.append(",\"networktype\":");
        sb.append(i14);
        if (i5 != Integer.MAX_VALUE && i6 != Integer.MAX_VALUE) {
            sb.append(",\"stationLat\":");
            sb.append(String.format("%.6f", Float.valueOf(i5 / 14400.0f)));
            sb.append(",\"stationLng\":");
            sb.append(String.format("%.6f", Float.valueOf(i6 / 14400.0f)));
        }
        sb.append(",\"ts\":");
        sb.append(j2);
        sb.append(",\"src\":");
        sb.append(i15);
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    public static String a(e6 e6Var, boolean z) {
        long j;
        List<ScanResult> b2 = e6Var == null ? null : e6Var.b();
        if (b2 == null) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (b2.size() <= 0) {
            sb.append("]");
            return sb.toString();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime / 1000;
        Iterator<ScanResult> it = b2.iterator();
        int i = 0;
        long j3 = Long.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ScanResult next = it.next();
            if (a(next, b2.size())) {
                if (i > 0) {
                    sb.append(",");
                }
                List<ScanResult> list = b2;
                sb.append("{\"mac\":\"").append(next.BSSID.replace(":", "")).append("\",");
                sb.append("\"rssi\":").append(next.level);
                if (!z) {
                    j = 1000;
                } else {
                    long j4 = next.timestamp;
                    int i2 = j4 > 0 ? (int) (j2 - ((j4 / 1000) / 1000)) : -1;
                    StringBuilder append = sb.append(",").append("\"ts\":");
                    if (i2 >= 1000) {
                        i2 = 1000;
                    }
                    append.append(i2);
                    j = 1000;
                    long j5 = elapsedRealtime - (next.timestamp / 1000);
                    if (j5 < j3) {
                        j3 = j5;
                    }
                }
                sb.append(com.alipay.sdk.m.q.h.d);
                i++;
                b2 = list;
            }
        }
        sb.append("]");
        a = j3 != Long.MAX_VALUE ? System.currentTimeMillis() - j3 : 0L;
        return sb.toString();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean contains = str.contains("latitude");
            JSONArray optJSONArray = jSONObject.optJSONArray("cells");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("wifis");
            int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
            x3.a("LOC", "req gwc:" + (contains ? "1" : "0") + "," + length2 + "," + length);
            return contains || length > 0 || length2 > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static double a(double d, double d2, double d3, double d4) {
        double a2 = a(d);
        double a3 = a(d3);
        return (Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((a2 - a3) / 2.0d), 2.0d) + ((Math.cos(a2) * Math.cos(a3)) * Math.pow(Math.sin((a(d2) - a(d4)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d) * 1000.0d;
    }
}