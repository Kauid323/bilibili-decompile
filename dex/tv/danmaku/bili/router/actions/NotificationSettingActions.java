package tv.danmaku.bili.router.actions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import bili.resource.homepage.R;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.NotificationSettingHelper;
import com.bilibili.droid.RomUtils;
import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.xpref.Xpref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

public class NotificationSettingActions {
    private static final String PREF_NOTIFICATION_DIALOG_LAST_SHOW_TIME = "pref_notification_dialog_last_show_time";
    private static final String TAG = "NotificationSettingActions";
    private static final long TIME_INTERVAL = 5184000000L;

    @Deprecated
    public static void showSettingDialog(final Context context, String showFrom, String message) {
        long now = ServerClock.now();
        if (now <= 0) {
            now = System.currentTimeMillis();
        }
        Xpref.getDefaultSharedPreferences(context).edit().putLong(PREF_NOTIFICATION_DIALOG_LAST_SHOW_TIME, now).apply();
        if (!TextUtils.isEmpty(showFrom)) {
            InfoEyesManager.getInstance().report2(false, "000225", new String[]{"push_pop_show", ReportEvent.EVENT_TYPE_SHOW, showFrom});
        }
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(R.string.homepage_global_string_344).setMessage(message).setNegativeButton(bili.resource.common.R.string.common_global_string_238, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.router.actions.NotificationSettingActions$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                InfoEyesManager.getInstance().report2(false, "000225", new String[]{"push_pop_click", "click", "2"});
            }
        }).setPositiveButton(bili.resource.common.R.string.common_global_string_64, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.router.actions.NotificationSettingActions$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NotificationSettingActions.lambda$showSettingDialog$1(context, dialogInterface, i);
            }
        }).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            if (context.getResources().getConfiguration().orientation == 2) {
                layoutParams.width = (int) (WindowManagerHelper.getDisplayHeight(context) * 0.9d);
            } else {
                layoutParams.width = (int) (WindowManagerHelper.getDisplayWidth(context) * 0.9d);
            }
            window.setAttributes(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showSettingDialog$1(Context context, DialogInterface dialog, int which) {
        NotificationSettingHelper.openSystemNotificationSetting(ContextUtilKt.requireActivity(context));
        InfoEyesManager.getInstance().report2(false, "000225", new String[]{"push_pop_click", "click", "1"});
    }

    @Deprecated
    public static boolean canShowDialogV1(Activity activity) {
        if (!shouldShowDialogWithParams()) {
            BLog.d(TAG, "online param is disable");
            return false;
        } else if (NotificationSettingHelper.isNotificationEnable(activity)) {
            BLog.d(TAG, "notification is enable");
            return false;
        } else {
            long lastShowDialogTime = Xpref.getDefaultSharedPreferences(activity).getLong(PREF_NOTIFICATION_DIALOG_LAST_SHOW_TIME, 0L);
            long now = ServerClock.now();
            if (now <= 0) {
                now = System.currentTimeMillis();
            }
            if (now - lastShowDialogTime < TIME_INTERVAL) {
                BLog.d(TAG, "time interval limit");
                return false;
            }
            return true;
        }
    }

    private static boolean shouldShowDialogWithParams() {
        String json = OnlineParamsHelper.getConfigString("enable_notification_setting_guide_for_push", null);
        GuideInfo info = null;
        try {
            info = (GuideInfo) JSONObject.parseObject(json, GuideInfo.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (info == null) {
            info = new GuideInfo();
        }
        return RomUtils.isOppoRom() ? info.oppo == 1 : RomUtils.isVivoRom() ? info.vivo == 1 : RomUtils.isHuaweiRom() ? info.huawei == 1 : RomUtils.isMiuiRom() ? info.xiaomi == 1 : info.other == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class GuideInfo {
        public int huawei;
        public int oppo;
        public int other;
        public int vivo;
        public int xiaomi;

        private GuideInfo() {
            this.oppo = 0;
            this.vivo = 0;
            this.huawei = 0;
            this.xiaomi = 0;
            this.other = 0;
        }
    }
}