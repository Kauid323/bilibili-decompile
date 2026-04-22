package tv.danmaku.bili.report;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bilibili.lib.foundation.Foundation;

public class InfoEyesUtils {
    private static String CHANNEL;

    public static String getAppVersion(Context context) {
        return Foundation.instance().getApps().getVersionName();
    }

    public static String getTelephonyProvider(Context context) throws IllegalStateException {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        int simState = telephonyManager == null ? 0 : telephonyManager.getSimState();
        if (simState != 5) {
            return "";
        }
        String simOperator = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(simOperator) || simOperator.length() < 5) {
            return "";
        }
        return simOperator;
    }
}