package tv.danmaku.bili.utils;

import android.content.Context;

public class AppInfoUtil {
    public static String getCurrentAppName(Context context) {
        return context.getResources().getString(context.getApplicationInfo().labelRes);
    }

    public static String replaceByCurrentAppName(Context context, int resId) {
        return context.getResources().getString(resId, getCurrentAppName(context));
    }
}