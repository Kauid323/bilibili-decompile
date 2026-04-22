package c.t.m.g;

import android.os.Process;
import com.tencent.map.geolocation.TencentLocationLogListener;
import java.util.Date;

/* compiled from: TML */
public class w6 {
    public static TencentLocationLogListener a;

    public static void a(TencentLocationLogListener tencentLocationLogListener) {
        a = tencentLocationLogListener;
    }

    public static void a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("txLoc").append(",").append(f3.b("yyyyMMdd-HHmmss:SSS").format(new Date())).append(",").append(Process.myPid()).append(",").append(Thread.currentThread().getId()).append(",").append(str);
            TencentLocationLogListener tencentLocationLogListener = a;
            if (tencentLocationLogListener != null) {
                tencentLocationLogListener.onSDKRunningLogChanged(4, sb.toString());
            }
        } catch (Throwable th) {
        }
    }
}