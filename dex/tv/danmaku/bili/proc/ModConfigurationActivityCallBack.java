package tv.danmaku.bili.proc;

import android.app.Activity;
import android.content.Context;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.biliweb.preload.BHManager;
import tv.danmaku.bili.proc.ActivityCallBack;

public class ModConfigurationActivityCallBack implements ActivityCallBack.IPCActivityStateCallback {
    private static ModConfigurationActivityCallBack instance;

    private ModConfigurationActivityCallBack() {
    }

    public static ModConfigurationActivityCallBack getInstance() {
        if (instance == null) {
            instance = new ModConfigurationActivityCallBack();
        }
        return instance;
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
    public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
        Context context = BiliContext.application();
        if (lastVisibleCount == 0 && context != null) {
            BHManager.INSTANCE.updateList();
        }
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
    public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
    }
}