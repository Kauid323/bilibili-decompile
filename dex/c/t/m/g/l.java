package c.t.m.g;

import java.util.HashMap;

/* compiled from: TML */
public class l {
    public static String a = "1.0.0";
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f57c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static volatile c l;
    public static final a m = new a();
    public static z1 n = z1.a;

    public static final String a(int i2) {
        if (f57c) {
            return (k ? "https://lstest.map.qq.com/nlpdr?sf" : g3.e + "?sf") + i2;
        }
        String str = k ? "https://testdatalbs.sparta.html5.qq.com/tr?sf" : g3.f34c + "?sf";
        if (i2 > 1) {
            return str + i2;
        }
        return i2 == 1 ? str : "";
    }

    public static final String b() {
        return "fc4.";
    }

    public static final int a(String str) {
        if (str.startsWith("fc4") || str.startsWith("dc4")) {
            return 4;
        }
        if (str.startsWith("fc3") || str.startsWith("dc3")) {
            return 3;
        }
        if (str.startsWith("fc2") || str.startsWith("dc2")) {
            return 2;
        }
        return (str.startsWith("fc1") || str.startsWith("fc") || str.startsWith("dc")) ? 1 : -1;
    }

    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("D_CH_ID", "fc_sdk");
        hashMap.put("D_FC_SRC", "209");
        hashMap.put("D_UP_INTERVAL", "1800000");
        hashMap.put("D_UP_USE_HTTPS", "true");
        hashMap.put("D_MAX_1F_SIZE", "102400");
        hashMap.put("D_NUM_UP", "1");
        hashMap.put("D_MAX_BUF_WF", "25600");
        hashMap.put("D_MAX_FOLDER_SIZE", "104857600");
        hashMap.put("D_MAX_DAY_RENAME", "3");
        hashMap.put("D_MAX_DAY_DELETE", "30");
        hashMap.put("D_MAX_SIZE_UP_1DAY", "10485760");
        hashMap.put("D_UP_NET", "w");
        hashMap.put("D_POS_COLL", "false");
        hashMap.put("D_WRITE_MAC", "false");
        hashMap.put("D_UP_WF_INFO", "true");
        hashMap.put("D_UP_U_TRACK_INFO", "false");
        hashMap.put("D_UP_GPS_FOR_NAVI", "false");
        return hashMap;
    }
}