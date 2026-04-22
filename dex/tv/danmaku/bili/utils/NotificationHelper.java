package tv.danmaku.bili.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import com.bilibili.notification.NotificationManagerHelper;
import tv.danmaku.android.log.BLog;

public class NotificationHelper {
    protected NotificationCompat.Builder mBuilder;
    protected Context mContext;
    private NotificationManager mNManager;

    protected NotificationHelper(Context context, NotificationCompat.Builder builder) {
        this.mBuilder = builder;
        this.mContext = context;
        this.mNManager = NotificationManagerHelper.getNotificationManager(context);
    }

    public void notify(int id, boolean autoCancel, boolean ongoing, String contentTitle, String contentText, int max, int progress, boolean indeterminate) {
        notify(id, autoCancel, ongoing, contentTitle, contentText, max, progress, indeterminate, null);
    }

    public void notify(int id, boolean autoCancel, boolean ongoing, String contentTitle, String contentText, int max, int progress, boolean indeterminate, PendingIntent intent) {
        this.mBuilder.setAutoCancel(autoCancel).setOngoing(ongoing).setContentTitle(contentTitle).setContentText(contentText).setTicker(contentTitle).setProgress(max, progress, indeterminate);
        if (intent != null) {
            this.mBuilder.setContentIntent(intent);
        }
        try {
            Notification notification = this.mBuilder.build();
            notify(id, notification);
        } catch (NullPointerException e) {
            BLog.w("Build notification error! \n contentText=" + contentText + ",contentTitle=" + contentTitle, e);
        }
    }

    public void notify(int id, Notification notification) {
        try {
            this.mNManager.notify(id, notification);
        } catch (RuntimeException e) {
            BLog.e("error for RemoteException", e);
        }
    }

    public void cancelNotify(int id) {
        this.mNManager.cancel(id);
    }

    public static NotificationHelper initHelper(Context context, Class<?> parentActivity, int id, int smallIcon, Intent intent) {
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context.getApplicationContext());
        if (parentActivity != null) {
            stackBuilder.addParentStack(parentActivity).addNextIntent(intent);
        } else {
            stackBuilder.addNextIntentWithParentStack(intent);
        }
        PendingIntent contentIntent = stackBuilder.getPendingIntent(0, 134217728);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).setContentIntent(contentIntent).setSmallIcon(smallIcon).setWhen(System.currentTimeMillis());
        return new NotificationHelper(context, builder);
    }
}