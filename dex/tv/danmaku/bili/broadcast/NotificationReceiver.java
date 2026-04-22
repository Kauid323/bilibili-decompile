package tv.danmaku.bili.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.core.app.TaskStackBuilder;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import tv.danmaku.android.util.DebugLog;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadNotificationHelper;

public class NotificationReceiver extends BroadcastReceiver {
    public static final String EXTRAS_INTENT = "NotificationReceiver:intent";
    static final String TAG = "NotificationReceiver";

    public static String notifyAction(Context context) {
        return context.getPackageName() + ".broadcast.NotificationReceiver.ACTION.OPEN_NOTIFICATION";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent broadcastIntent) {
        String action = broadcastIntent.getAction();
        if (notifyAction(context).equals(action)) {
            DebugLog.i(TAG, "onReceive:open notification");
            Intent openIntent = (Intent) broadcastIntent.getParcelableExtra(EXTRAS_INTENT);
            if (openIntent != null) {
                DebugLog.i(TAG, "onReceive:extra intent->" + openIntent);
                ActivityInfo activity = openIntent.resolveActivityInfo(context.getPackageManager(), 0);
                if (activity != null && activity.enabled && activity.exported && activity.packageName.equals(context.getPackageName())) {
                    try {
                        if (BiliContext.isForeground()) {
                            openIntent.addFlags(268435456);
                            context.startActivity(openIntent);
                        } else {
                            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                            stackBuilder.addNextIntent(new Intent(context, MainActivityV2.class));
                            stackBuilder.addNextIntent(openIntent);
                            stackBuilder.startActivities();
                        }
                    } catch (Exception e) {
                        openIntent = new Intent(context, MainActivityV2.class);
                        openIntent.addFlags(268435456);
                        context.startActivity(openIntent);
                    }
                    int state = openIntent.getIntExtra(VideoDownloadNotificationHelper.DOWNLOAD_STATE, 0);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("save_id", String.valueOf(state));
                    Neurons.reportClick(false, "push.push-message.push-message.0.click", map);
                }
            }
        }
    }
}