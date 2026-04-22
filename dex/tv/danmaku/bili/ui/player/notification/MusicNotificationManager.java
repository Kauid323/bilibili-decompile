package tv.danmaku.bili.ui.player.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: MusicNotificationManager.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\u0012\u0010 \u001a\u00020\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\"\u001a\u00020\u0010J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H\u0016J,\u0010&\u001a\u00020\u00102\f\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e2\f\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/MusicNotificationManager;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "session", "Landroid/support/v4/media/session/MediaSessionCompat;", "callback", "Ltv/danmaku/bili/ui/player/notification/MusicNotificationCallback;", "startForeground", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "Landroid/app/Notification;", "notification", "", "<init>", "(Landroid/content/Context;Landroid/support/v4/media/session/MediaSessionCompat;Ltv/danmaku/bili/ui/player/notification/MusicNotificationCallback;Lkotlin/jvm/functions/Function2;)V", "mNotificationManager", "Landroid/app/NotificationManager;", "notificationBuildHelper", "Ltv/danmaku/bili/ui/player/notification/BgmscNotificatioBuilderHelper;", "mNotificationStarted", "", "isRegisterReceiver", "register", "unRegister", "logNotificationEnable", "mBindedActivityClass", "Ljava/lang/Class;", "mMainActivityClass", "startOrUpdateNotification", "newNotification", "stopNotification", "onReceive", "intent", "Landroid/content/Intent;", "bindData", "clazz", "mainActivityClass", "Companion", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MusicNotificationManager extends BroadcastReceiver {
    public static final String ACTION_DELETE = "com.bilibili.player.music.notification.delete";
    public static final String ACTION_FAST_FORWARD = "com.bilibili.player.music.notification.fast_forward";
    public static final String ACTION_LIKE = "com.bilibili.player.music.notification.like";
    public static final String ACTION_NEXT = "com.bilibili.player.music.notification.next";
    public static final String ACTION_PAUSE = "com.bilibili.player.music.notification.pause";
    public static final String ACTION_PLACEHOLDER = "com.bilibili.player.music.notification.placeholder";
    public static final String ACTION_PLAY = "com.bilibili.player.music.notification.play";
    public static final String ACTION_PLAY_PAUSE = "com.bilibili.player.music.notification.play.pause";
    public static final String ACTION_PREV = "com.bilibili.player.music.notification.prev";
    public static final String ACTION_REWIND = "com.bilibili.player.music.notification.rewind";
    public static final String ACTION_STOP = "com.bilibili.player.music.notification.stop";
    public static final String ACTION_TOGGLE_MODE = "com.bilibili.player.music.notification.toggle_mode";
    public static final String ACTION_UNLIKE = "com.bilibili.player.music.notification.unlike";
    public static final Companion Companion = new Companion(null);
    public static final int NOTIFICATION_ID = 2333;
    public static final int REQUEST_CODE = 6666;
    public static final String TAG = "MusicNotificationManager";
    private final Context context;
    private boolean isRegisterReceiver;
    private Class<?> mBindedActivityClass;
    private Class<?> mMainActivityClass;
    private NotificationManager mNotificationManager;
    private boolean mNotificationStarted;
    private BgmscNotificatioBuilderHelper notificationBuildHelper;
    private final MediaSessionCompat session;
    private final Function2<Integer, Notification, Unit> startForeground;

    /* JADX WARN: Multi-variable type inference failed */
    public MusicNotificationManager(Context context, MediaSessionCompat session, MusicNotificationCallback callback, Function2<? super Integer, ? super Notification, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(function2, "startForeground");
        this.context = context;
        this.session = session;
        this.startForeground = function2;
        this.notificationBuildHelper = new BgmscNotificatioBuilderHelper(this.context, this.session, callback, this);
        try {
            Object systemService = this.context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            this.mNotificationManager = (NotificationManager) systemService;
            NotificationManager notificationManager = this.mNotificationManager;
            if (notificationManager != null) {
                notificationManager.cancel(2333);
                Unit unit = Unit.INSTANCE;
            }
        } catch (SecurityException e) {
            PlayerLog.e(PlayerLogModule.BackgroundPlay, e);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void register() {
        if (this.isRegisterReceiver) {
            return;
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_NEXT);
        filter.addAction(ACTION_PAUSE);
        filter.addAction(ACTION_PLAY);
        filter.addAction(ACTION_PREV);
        filter.addAction(ACTION_STOP);
        filter.addAction(ACTION_TOGGLE_MODE);
        filter.addAction(ACTION_FAST_FORWARD);
        filter.addAction(ACTION_REWIND);
        filter.addAction(ACTION_LIKE);
        filter.addAction(ACTION_UNLIKE);
        filter.addAction(ACTION_DELETE);
        ContextCompat.registerReceiver(this.context, this, filter, 4);
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "MusicNotificationManager register receiver");
        this.isRegisterReceiver = true;
    }

    public final void unRegister() {
        if (this.isRegisterReceiver) {
            PlayerLog.i(PlayerLogModule.BackgroundPlay, "MusicNotificationManager unRegister receiver");
            this.context.unregisterReceiver(this);
            this.isRegisterReceiver = false;
        }
    }

    public final void logNotificationEnable() {
        try {
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this.context);
            boolean isNotificationsEnabled = notificationManagerCompat.areNotificationsEnabled();
            PlayerLog.i(PlayerLogModule.BackgroundPlay, "notification permissions enabled=" + isNotificationsEnabled);
            if (Build.VERSION.SDK_INT >= 26) {
                String channelId = BgmscNotificatioBuilderHelper.Companion.getChannelId$music_service_debug(this.context);
                NotificationChannel notificationChannel = notificationManagerCompat.getNotificationChannel(channelId);
                if (notificationChannel == null) {
                    PlayerLog.i(PlayerLogModule.BackgroundPlay, "notificationChannel is null");
                    return;
                }
                boolean isShowLockScreen = true;
                boolean isChannelEnable = notificationChannel.getImportance() != 0;
                if (notificationChannel.getLockscreenVisibility() == -1) {
                    isShowLockScreen = false;
                }
                PlayerLog.i(PlayerLogModule.BackgroundPlay, "notification channel permissions enabled=" + isChannelEnable);
                PlayerLog.i(PlayerLogModule.BackgroundPlay, "notification channel permissions lock screen enabled=" + isShowLockScreen);
            }
        } catch (Exception e) {
            PlayerLog.e(PlayerLogModule.BackgroundPlay, "logNotificationEnable has a err message=" + e);
        }
    }

    public static /* synthetic */ void startOrUpdateNotification$default(MusicNotificationManager musicNotificationManager, Notification notification, int i, Object obj) {
        if ((i & 1) != 0) {
            notification = null;
        }
        musicNotificationManager.startOrUpdateNotification(notification);
    }

    public final void startOrUpdateNotification(Notification newNotification) {
        Notification notification;
        if (newNotification != null) {
            notification = newNotification;
        } else {
            try {
                notification = this.notificationBuildHelper.buildNotification();
                if (notification == null) {
                    return;
                }
            } catch (Exception e) {
                PlayerLog.e(PlayerLogModule.BackgroundPlay, "startNotification has err=" + e);
                return;
            }
        }
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "startOrUpdateNotification: notify notification to update");
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.notify(2333, notification);
        }
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "startOrUpdateNotification: start foreground");
        this.startForeground.invoke(2333, notification);
        this.mNotificationStarted = true;
    }

    public final void stopNotification() {
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "stopNotification() is called");
        try {
            NotificationManager notificationManager = this.mNotificationManager;
            if (notificationManager != null) {
                notificationManager.cancel(2333);
            }
        } catch (RuntimeException ex) {
            PlayerLog.e(PlayerLogModule.BackgroundPlay, "stopNotification() failed", ex);
        }
        this.mNotificationStarted = false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        MediaControllerCompat controller = this.session.getController();
        MediaControllerCompat.TransportControls transportControls = controller != null ? controller.getTransportControls() : null;
        if (transportControls == null) {
            PlayerLog.w(PlayerLogModule.BackgroundPlay, "TransportControls is null");
            return;
        }
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "background player action:" + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -2018219939:
                    if (action.equals(ACTION_LIKE)) {
                        transportControls.sendCustomAction(ACTION_LIKE, new Bundle());
                        return;
                    }
                    return;
                case -2018163783:
                    if (action.equals(ACTION_NEXT)) {
                        transportControls.skipToNext();
                        return;
                    }
                    return;
                case -2018098182:
                    if (action.equals(ACTION_PLAY)) {
                        transportControls.play();
                        return;
                    }
                    return;
                case -2018092295:
                    if (action.equals(ACTION_PREV)) {
                        transportControls.skipToPrevious();
                        return;
                    }
                    return;
                case -2018000696:
                    if (action.equals(ACTION_STOP)) {
                        transportControls.stop();
                        return;
                    }
                    return;
                case 517638312:
                    if (action.equals(ACTION_FAST_FORWARD)) {
                        transportControls.fastForward();
                        return;
                    }
                    return;
                case 1061890088:
                    if (action.equals(ACTION_TOGGLE_MODE)) {
                        transportControls.sendCustomAction(ACTION_TOGGLE_MODE, new Bundle());
                        return;
                    }
                    return;
                case 1583162609:
                    if (action.equals(ACTION_DELETE)) {
                        transportControls.sendCustomAction(ACTION_DELETE, new Bundle());
                        return;
                    }
                    return;
                case 1863157232:
                    if (action.equals(ACTION_PAUSE)) {
                        transportControls.pause();
                        return;
                    }
                    return;
                case 1984302081:
                    if (action.equals(ACTION_REWIND)) {
                        transportControls.rewind();
                        return;
                    }
                    return;
                case 2078173430:
                    if (action.equals(ACTION_UNLIKE)) {
                        transportControls.sendCustomAction(ACTION_LIKE, new Bundle());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void bindData(Class<?> cls, Class<?> cls2, Intent intent) {
        this.mBindedActivityClass = cls;
        this.mMainActivityClass = cls2;
        this.notificationBuildHelper.bindData(cls, cls2, intent);
        if (cls != null && this.mNotificationStarted) {
            startOrUpdateNotification$default(this, null, 1, null);
        }
    }

    /* compiled from: MusicNotificationManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/MusicNotificationManager$Companion;", "", "<init>", "()V", "TAG", "", "NOTIFICATION_ID", "", "REQUEST_CODE", "ACTION_PLAY", "ACTION_PAUSE", "ACTION_PLAY_PAUSE", "ACTION_PREV", "ACTION_NEXT", "ACTION_STOP", "ACTION_TOGGLE_MODE", "ACTION_FAST_FORWARD", "ACTION_REWIND", "ACTION_LIKE", "ACTION_UNLIKE", "ACTION_DELETE", "ACTION_PLACEHOLDER", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}