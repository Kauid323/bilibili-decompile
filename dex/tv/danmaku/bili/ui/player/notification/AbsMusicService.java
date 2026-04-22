package tv.danmaku.bili.ui.player.notification;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.app.ServiceCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.spy.generated.android_app_Service;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.player.lock.MusicSystemLockScreenManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: AbsMusicService.kt */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\t\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/AbsMusicService;", "Landroid/app/Service;", "<init>", "()V", "sysLockManager", "Ltv/danmaku/bili/ui/player/lock/MusicSystemLockScreenManager;", "mMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mActivityStateCallback", "tv/danmaku/bili/ui/player/notification/AbsMusicService$mActivityStateCallback$1", "Ltv/danmaku/bili/ui/player/notification/AbsMusicService$mActivityStateCallback$1;", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onTaskRemoved", "rootIntent", "release", "onDestroy", "onTimeout", "fgsType", "getMediaSession", "Companion", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsMusicService extends android_app_Service {
    public static final String ACTION_STOP = "tv.danmaku.bili.ui.player.notification.AbsMusicService.STOP";
    public static final String ACTIVITY_CLASS = "activity.class";
    public static final Companion Companion = new Companion(null);
    public static final String INTENT_DATA = "intent.data";
    public static final String MAIN_ACTIVITY_CLASS = "activity.main.class";
    private final AbsMusicService$mActivityStateCallback$1 mActivityStateCallback = new BiliContext.AppActivityLifecycleListener() { // from class: tv.danmaku.bili.ui.player.notification.AbsMusicService$mActivityStateCallback$1
        public void onLastActivityDestroy() {
            PlayerLog.i(PlayerLogModule.BackgroundPlay, "last activity is destroyed, force to stop notification");
            ServiceCompat.stopForeground((Service) AbsMusicService.this, 1);
        }
    };
    protected MediaSessionCompat mMediaSession;
    protected MusicSystemLockScreenManager sysLockManager;

    public void onCreate() {
        super.onCreate();
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "music service onCreate() is called");
        if (this.sysLockManager == null) {
            this.sysLockManager = new MusicSystemLockScreenManager((Context) this, new AbsMusicService$onCreate$1(this));
            MusicSystemLockScreenManager musicSystemLockScreenManager = this.sysLockManager;
            if (musicSystemLockScreenManager != null) {
                musicSystemLockScreenManager.register();
            }
        }
        BiliContext.registerActivityStateCallback(this.mActivityStateCallback);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "music service onStartCommand() is called,intent =" + intent);
        if (TextUtils.equals(ACTION_STOP, intent != null ? intent.getAction() : null)) {
            PlayerLog.i(PlayerLogModule.BackgroundPlay, "Action of intent is ACTION_STOP,music service is will release");
            release();
            return 1;
        }
        return 1;
    }

    public void onTaskRemoved(Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        super.onTaskRemoved(rootIntent);
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "music service onTaskRemoved() is called");
        release();
    }

    public void release() {
        stopSelf();
    }

    public void onDestroy() {
        super.onDestroy();
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "music service onDestroy() is called");
        ServiceCompat.stopForeground((Service) this, 1);
        MusicSystemLockScreenManager musicSystemLockScreenManager = this.sysLockManager;
        if (musicSystemLockScreenManager != null) {
            musicSystemLockScreenManager.unRegister();
        }
        this.mMediaSession = null;
        BiliContext.unregisterActivityStateCallback(this.mActivityStateCallback);
    }

    public void onTimeout(int startId, int fgsType) {
        super.onTimeout(startId, fgsType);
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "service timeout, startId = " + startId + ", fgsType = " + fgsType + ", stop foreground");
        ServiceCompat.stopForeground((Service) this, 1);
    }

    public final MediaSessionCompat getMediaSession() {
        return this.mMediaSession;
    }

    /* compiled from: AbsMusicService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/AbsMusicService$Companion;", "", "<init>", "()V", "ACTION_STOP", "", "ACTIVITY_CLASS", "MAIN_ACTIVITY_CLASS", "INTENT_DATA", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}