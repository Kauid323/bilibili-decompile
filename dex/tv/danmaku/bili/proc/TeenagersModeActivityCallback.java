package tv.danmaku.bili.proc;

import android.app.Activity;
import android.content.Context;
import com.bilibili.app.preferences.storage.NoTeenagersView;
import com.bilibili.base.BiliContext;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.teenagersmode.TeenagersModeManager;
import java.lang.ref.WeakReference;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivity;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivityKt;

public class TeenagersModeActivityCallback implements IPCAppStateManager.IPCActivityStateCallback {
    private static TeenagersModeActivityCallback sInstance;
    private boolean mIsBackground = false;
    private TeenagersModeManager mManager = TeenagersModeManager.getInstance();
    private boolean mShouldIntercept;
    private WeakReference<Activity> mStartedActivity;

    private TeenagersModeActivityCallback() {
    }

    public static TeenagersModeActivityCallback getInstance() {
        if (sInstance == null) {
            sInstance = new TeenagersModeActivityCallback();
        }
        return sInstance;
    }

    public void onVisibleCountChanged(int lastVisibleCount, int currentVisibleCount) {
        Context context = null;
        if (this.mStartedActivity != null && this.mStartedActivity.get() != null) {
            context = this.mStartedActivity.get();
        }
        if (context == null) {
            context = BiliContext.application();
        }
        IDrawerHost findActivityOrNull = ContextUtilKt.findActivityOrNull(context);
        boolean isSplash = (findActivityOrNull instanceof HotSplashActivity) || ((findActivityOrNull instanceof IDrawerHost) && findActivityOrNull.isSplashShowing()) || HotSplashActivityKt.isHotSplashShowing || tv.danmaku.bili.splash.ad.page.HotSplashActivityKt.isHotSplashShowing || (findActivityOrNull instanceof NoTeenagersView);
        if (isSplash) {
            return;
        }
        if (currentVisibleCount > lastVisibleCount) {
            if (findActivityOrNull instanceof IntentHandlerActivity) {
                this.mShouldIntercept = true;
                return;
            }
            this.mManager.onActivityVisible(findActivityOrNull);
        }
        if (lastVisibleCount > currentVisibleCount && currentVisibleCount == 0) {
            this.mManager.onSwitchToBackground(findActivityOrNull);
            this.mIsBackground = true;
        } else if ((lastVisibleCount == 0 || (lastVisibleCount == 1 && this.mShouldIntercept)) && currentVisibleCount > lastVisibleCount && this.mIsBackground) {
            this.mManager.onSwitchToForeground(findActivityOrNull);
            this.mIsBackground = false;
            if (this.mShouldIntercept) {
                this.mShouldIntercept = false;
            }
        }
    }

    public void onForegroundActivitiesChanged(int lastForegroundCount, int currentForegroundCount) {
    }

    public void onActivityStarted(Activity activity) {
        this.mStartedActivity = new WeakReference<>(activity);
    }

    public void shouldIntercept(boolean intercept) {
        this.mShouldIntercept = intercept;
    }

    public void onHotSplashDismiss() {
        Context context = BiliContext.application();
        if (this.mManager != null && context != null) {
            this.mManager.onSwitchToForeground(context);
        }
    }
}