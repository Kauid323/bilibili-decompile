package tv.danmaku.bili.report.startup.v2;

import android.text.TextUtils;

public final class BootTagHolder {
    static final String ROOT_NODE_TAG = "StartUp";
    public static final String TAG_APP_INIT = "AppInit";
    public static final String TAG_START_SHOW = "StartShow";
    public static final String TAG_REAL_START_SHOW = "RealStartShow";
    public static final String TAG_SP_INIT = "SplashInit";
    public static final String TAG_SP_SHOW = "SplashShow";
    public static final String TAG_MAIN_INIT = "MainActivityInit";
    public static final String TAG_SP_DURATION = "SplashDuration";
    public static final String TAG_SP_REAL_DURATION = "SplashRealDuration";
    public static final String TAG_MAIN_FRAME_INIT = "MainFrameworkInit";
    private static String[] ARRAYS = {ROOT_NODE_TAG, TAG_APP_INIT, TAG_START_SHOW, TAG_REAL_START_SHOW, TAG_SP_INIT, TAG_SP_SHOW, TAG_MAIN_INIT, TAG_SP_DURATION, TAG_SP_REAL_DURATION, TAG_MAIN_FRAME_INIT};

    public static boolean checkExist(String target) {
        String[] strArr;
        if (TextUtils.isEmpty(target)) {
            return false;
        }
        for (String item : ARRAYS) {
            if (item.equalsIgnoreCase(target)) {
                return true;
            }
        }
        return false;
    }
}