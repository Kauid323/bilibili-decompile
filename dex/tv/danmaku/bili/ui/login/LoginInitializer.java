package tv.danmaku.bili.ui.login;

import android.app.Activity;
import android.content.Context;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;

public class LoginInitializer implements ActivityCallBack.ActivityStateCallback {
    public static final String TAG = "LoginInitializer";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class SingleInstanceHolder {
        public static LoginInitializer sInstance = new LoginInitializer();

        private SingleInstanceHolder() {
        }
    }

    public static LoginInitializer getInstance() {
        return SingleInstanceHolder.sInstance;
    }

    private LoginInitializer() {
    }

    public void init(Context context) {
        ActivityCallBack.removeActivityStateCallback(this);
        ActivityCallBack.addActivityStateCallback(this);
        LoginQuickManager.INSTANCE.initQuickLogin(context);
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
    public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
        if (lastVisibleCount == 0 && currentVisibleCount == 1) {
            BLog.i(TAG, "get login rule");
            LoginRuleProcessor.INSTANCE.getLoginType(null, false);
        }
    }

    @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
    public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
    }
}