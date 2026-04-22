package leakcanary.internal;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.LeakCanary;
import leakcanary.internal.InternalLeakCanary;
import shark.SharkLog;

/* compiled from: Notifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lleakcanary/internal/Notifications;", "", "()V", "canShowNotification", "", "getCanShowNotification", "()Z", "notificationPermissionRequested", "buildNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "builder", "Landroid/app/Notification$Builder;", "type", "Lleakcanary/internal/NotificationType;", "showNotification", "", "contentTitle", "", "contentText", "pendingIntent", "Landroid/app/PendingIntent;", "notificationId", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class Notifications {
    public static final Notifications INSTANCE = new Notifications();
    private static boolean notificationPermissionRequested;

    private Notifications() {
    }

    public final boolean getCanShowNotification() {
        if (InternalLeakCanary.INSTANCE.getFormFactor() == InternalLeakCanary.FormFactor.MOBILE && !InternalLeakCanary.INSTANCE.isInstantApp() && InternalLeakCanary.INSTANCE.getApplicationVisible() && LeakCanary.getConfig().getShowNotifications()) {
            if (Build.VERSION.SDK_INT >= 33) {
                Application application = InternalLeakCanary.INSTANCE.getApplication();
                if (application.getApplicationInfo().targetSdkVersion >= 33) {
                    Object systemService = application.getSystemService("notification");
                    if (systemService == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
                    }
                    NotificationManager notificationManager = (NotificationManager) systemService;
                    if (!notificationManager.areNotificationsEnabled()) {
                        if (notificationPermissionRequested) {
                            SharkLog this_$iv = SharkLog.INSTANCE;
                            SharkLog.Logger logger$iv = this_$iv.getLogger();
                            if (logger$iv != null) {
                                logger$iv.d("Not showing notification: already requested missing POST_NOTIFICATIONS permission.");
                            }
                        } else {
                            SharkLog this_$iv2 = SharkLog.INSTANCE;
                            SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
                            if (logger$iv2 != null) {
                                logger$iv2.d("Not showing notification: requesting missing POST_NOTIFICATIONS permission.");
                            }
                            application.startActivity(RequestPermissionActivity.Companion.createIntent(application, "android.permission.POST_NOTIFICATIONS"));
                            notificationPermissionRequested = true;
                        }
                        return false;
                    } else if (notificationManager.areNotificationsPaused()) {
                        SharkLog this_$iv3 = SharkLog.INSTANCE;
                        SharkLog.Logger logger$iv3 = this_$iv3.getLogger();
                        if (logger$iv3 != null) {
                            logger$iv3.d("Not showing notification, notifications are paused.");
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void showNotification(Context context, CharSequence contentTitle, CharSequence contentText, PendingIntent pendingIntent, int notificationId, NotificationType type) {
        Notification.Builder builder;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(contentTitle, "contentTitle");
        Intrinsics.checkParameterIsNotNull(contentText, "contentText");
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (!getCanShowNotification()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, type.name());
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setContentText(contentText).setContentTitle(contentTitle).setAutoCancel(true).setContentIntent(pendingIntent);
        Notification notification = buildNotification(context, builder, type);
        Object systemService = context.getSystemService("notification");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.notify(notificationId, notification);
    }

    public final Notification buildNotification(Context context, Notification.Builder builder, NotificationType type) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Intrinsics.checkParameterIsNotNull(type, "type");
        builder.setSmallIcon(R.drawable.leak_canary_leak).setWhen(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService("notification");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
            }
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(type.name());
            if (notificationChannel == null) {
                String channelName = context.getString(type.getNameResId());
                Intrinsics.checkExpressionValueIsNotNull(channelName, "context.getString(type.nameResId)");
                NotificationChannel notificationChannel2 = new NotificationChannel(type.name(), channelName, type.getImportance());
                notificationManager.createNotificationChannel(notificationChannel2);
            }
            builder.setChannelId(type.name());
            builder.setGroup(type.name());
        }
        Notification build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
        return build;
    }
}