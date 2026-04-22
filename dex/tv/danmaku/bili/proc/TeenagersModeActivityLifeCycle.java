package tv.danmaku.bili.proc;

import android.app.Activity;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;

public class TeenagersModeActivityLifeCycle implements ActivityCallBack.IPCActivityStateCallback {
    private static TeenagersModeActivityLifeCycle sInstance;

    private TeenagersModeActivityLifeCycle() {
    }

    public static TeenagersModeActivityLifeCycle getInstance() {
        if (sInstance == null) {
            sInstance = new TeenagersModeActivityLifeCycle();
        }
        return sInstance;
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
    public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
        if (currentVisibleCount > lastVisibleCount) {
            TeenagersModeActivityCallback.getInstance().onActivityStarted(activity);
        }
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
    public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
        if (currentForegroundCount > lastForegroundCount && (activity instanceof IntentHandlerActivity)) {
            TeenagersModeActivityCallback.getInstance().shouldIntercept(true);
        }
    }
}