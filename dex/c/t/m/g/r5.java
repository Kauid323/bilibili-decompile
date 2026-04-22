package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.Iterator;
import java.util.List;

/* compiled from: TML */
public class r5 {
    public static boolean a(List<ScanResult> list, List<ScanResult> list2) {
        boolean z = false;
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size == 0 && size2 == 0) {
                return true;
            }
            if (size != 0 && size2 != 0) {
                if (list.size() > list2.size()) {
                    list2 = list;
                    list = list2;
                }
                int i = 0;
                for (ScanResult scanResult : list) {
                    Iterator<ScanResult> it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().BSSID.equals(scanResult.BSSID)) {
                                i++;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                int i2 = size2 + size;
                z = (i * 2 < i2 * 0.85d || i < 13) ? true : true;
                a7.c("TxWifiChange", "isDiffrent:c=" + size + ",k=" + i + ",f=" + i2 + ",fun_r=0.85,s=" + z);
            }
        }
        return z;
    }
}