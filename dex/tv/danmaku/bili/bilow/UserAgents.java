package tv.danmaku.bili.bilow;

import android.os.Build;
import com.bilibili.api.BiliConfig;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.foundation.Foundation;
import okio.Buffer;
import tv.danmaku.app.AppConfig;

public class UserAgents {
    public static String defaultFullUa() {
        return defaultUa() + common();
    }

    public static String defaultUa() {
        return toHumanReadableAscii(AppConfig.SYSTEM_HTTP_UA + " " + version());
    }

    private static String toHumanReadableAscii(String s) {
        int i = 0;
        int length = s.length();
        while (i < length) {
            int c = s.codePointAt(i);
            if (c > 31 && c < 127) {
                i += Character.charCount(c);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(s, 0, i);
                buffer.writeUtf8CodePoint(63);
                int j = Character.charCount(c) + i;
                while (j < length) {
                    int c2 = s.codePointAt(j);
                    buffer.writeUtf8CodePoint((c2 <= 31 || c2 >= 127) ? 63 : c2);
                    j += Character.charCount(c2);
                }
                return buffer.readUtf8();
            }
        }
        return s;
    }

    public static String common() {
        return " os/android model/" + Build.MODEL + " mobi_app/" + BiliConfig.getMobiApp() + " build/" + versionCode() + " channel/" + BiliConfig.getChannel() + " innerVer/" + Foundation.instance().getApps().getInternalVersionCode() + " osVer/" + Build.VERSION.RELEASE + " network/" + getNet();
    }

    private static int getNet() {
        ConnectivityMonitor monitor = ConnectivityMonitor.getInstance();
        int networkStatus = monitor.getNetwork();
        if (networkStatus == 1) {
            return 2;
        }
        if (networkStatus != 2) {
            return 0;
        }
        return 1;
    }

    public static String version() {
        return Foundation.instance().getApps().getVersionName();
    }

    public static String versionCode() {
        return String.valueOf(Foundation.instance().getApps().getVersionCode());
    }
}