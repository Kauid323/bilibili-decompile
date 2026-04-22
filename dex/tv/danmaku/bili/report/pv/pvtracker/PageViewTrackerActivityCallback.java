package tv.danmaku.bili.report.pv.pvtracker;

import android.app.Activity;
import com.bilibili.pvtracker.PageViewTracker;
import tv.danmaku.bili.proc.ActivityCallBack;

public class PageViewTrackerActivityCallback implements ActivityCallBack.IPCActivityStateCallback {
    private static PageViewTrackerActivityCallback sInstance;

    private PageViewTrackerActivityCallback() {
    }

    public static PageViewTrackerActivityCallback getInstance() {
        if (sInstance == null) {
            sInstance = new PageViewTrackerActivityCallback();
        }
        return sInstance;
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
    public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
        if (lastVisibleCount > currentVisibleCount && currentVisibleCount == 0) {
            PageViewTracker.getInstance().switchToBackground();
        }
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
    public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
    }
}