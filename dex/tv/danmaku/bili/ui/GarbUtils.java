package tv.danmaku.bili.ui;

import android.content.Context;
import android.util.Log;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.ui.garb.GarbManager;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.ui.theme.BiliTheme;

public class GarbUtils {
    public static void initGarb(Context app) {
        GarbManager.init(app, GarbManagerDelegate.INSTANCE);
        GarbGlobalObserver.INSTANCE.init();
    }

    public static void resetThemeWithFirstBoot(Context context) {
        Log.d("resetThemeWithFirstBoot", "isFirstStart" + EnvironmentManager.getInstance().isFirstStart());
        Log.d("resetThemeWithFirstBoot", "getCurrentTheme" + BiliTheme.getCurrentTheme(context));
        if (EnvironmentManager.getInstance().isFirstStart() && BiliTheme.getCurrentTheme(context) != 8) {
            BiliTheme.setCurrentTheme(context, 8);
            Log.d("resetThemeWithFirstBoot", "setCurrentTheme" + BiliTheme.getCurrentTheme(context));
        }
    }
}