package tv.danmaku.ijk.media.player;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import tv.danmaku.android.log.BLog;

public class IjkMediaScreenInfo {
    private static final String TAG = "IjkScreenInfo";
    private static boolean hasInit = false;
    private static IjkMediaScreenInfo mScreenInfo = new IjkMediaScreenInfo();
    public int screenWidth = 0;
    public int screenHeight = 0;
    public int screenDensityDpi = 0;
    public int screenWideColorGamut = 0;
    public int screenRefreshRate = 0;

    public static synchronized IjkMediaScreenInfo getScreenInfo(WindowManager windowManager) {
        IjkMediaScreenInfo ijkMediaScreenInfo;
        synchronized (IjkMediaScreenInfo.class) {
            if (!hasInit) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Display display = windowManager.getDefaultDisplay();
                display.getRealMetrics(displayMetrics);
                mScreenInfo.screenWidth = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
                mScreenInfo.screenHeight = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
                mScreenInfo.screenDensityDpi = displayMetrics.densityDpi;
                if (Build.VERSION.SDK_INT >= 26) {
                    mScreenInfo.screenWideColorGamut = display.isWideColorGamut() ? 1 : 0;
                    mScreenInfo.screenRefreshRate = (int) display.getMode().getRefreshRate();
                }
                BLog.i(TAG, "ScreenInfo: resolution[" + mScreenInfo.screenWidth + "*" + mScreenInfo.screenHeight + "," + mScreenInfo.screenDensityDpi + "], wideColorGamut[" + mScreenInfo.screenWideColorGamut + "], refreshRate[" + mScreenInfo.screenRefreshRate + "]");
            }
            ijkMediaScreenInfo = mScreenInfo;
        }
        return ijkMediaScreenInfo;
    }
}