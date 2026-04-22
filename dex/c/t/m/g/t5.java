package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: TML */
public class t5 {
    public static final List<String> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("mobile");
        a.add("16wifi");
        a.add("cmcc");
        a.add("360wifi");
        a.add("androidap");
        a.add("htcphone");
        a.add("xiaomi");
        a.add("lenovo");
        a.add("macbook");
    }

    public static void a(List<ScanResult> list) {
        HashSet hashSet = new HashSet();
        Iterator<ScanResult> it = list.iterator();
        while (it.hasNext()) {
            ScanResult next = it.next();
            if (next != null) {
                String str = next.BSSID;
                if (str != null && !str.equals("000000000000") && !str.equals("00-00-00-00-00-00") && !str.equals(com.alipay.sdk.m.q.b.b) && !str.equals("02:00:00:00:00:00")) {
                    if (hashSet.contains(str)) {
                        it.remove();
                    } else {
                        hashSet.add(str);
                    }
                } else {
                    it.remove();
                }
            }
        }
    }
}