package tv.danmaku.bili.ui.player.notification;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.player.data.NotificationStyle;
import tv.danmaku.bili.ui.player.data.VideoData;
import tv.danmaku.bili.ui.player.tracer.BgmEventTracer;
import tv.danmaku.bili.ui.player.tracer.BgmEventTracerManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: BackgroundMusicService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService;", "Ltv/danmaku/bili/ui/player/notification/AbsMusicService;", "<init>", "()V", "mBinder", "Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService$MusicPlayerBinder;", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "onUnbind", "", "onDestroy", "", "release", "bindMediaSession", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "MusicPlayerBinder", "DataProvider", "Companion", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BackgroundMusicService extends AbsMusicService {
    public static final Companion Companion = new Companion(null);
    private static String METADATA_KEY_IS_LIKED = "is_liked";
    private static boolean isRunning;
    private static boolean isStarting;
    private MusicPlayerBinder mBinder = new MusicPlayerBinder(this);

    /* compiled from: BackgroundMusicService.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\u0016H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService$DataProvider;", "", "unBind", "", "getVideoData", "Ltv/danmaku/bili/ui/player/data/VideoData;", "getPlayingIndex", "", "getPagesCount", "getSubtitle", "", "getPlayMode", "enableLike", "", "getLikeState", "getDuration", "", "getCurrentPosition", "getCurrentSpeed", "", "getTrackId", "getNotificationStyle", "Ltv/danmaku/bili/ui/player/data/NotificationStyle;", "getTracer", "Ltv/danmaku/bili/ui/player/tracer/BgmEventTracer;", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DataProvider {
        boolean enableLike();

        long getCurrentPosition();

        float getCurrentSpeed();

        long getDuration();

        boolean getLikeState();

        NotificationStyle getNotificationStyle();

        int getPagesCount();

        int getPlayMode();

        int getPlayingIndex();

        String getSubtitle();

        BgmEventTracer getTracer();

        String getTrackId();

        VideoData getVideoData();

        void unBind();
    }

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    @Override // tv.danmaku.bili.ui.player.notification.AbsMusicService
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRunning = true;
        isStarting = false;
        if (intent == null) {
            PlayerLog.e(PlayerLogModule.BackgroundPlay, "music service start with null intent.");
            stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    /* compiled from: BackgroundMusicService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService$MusicPlayerBinder;", "Landroid/os/Binder;", "service", "Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService;", "<init>", "(Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService;)V", "weakService", "Ljava/lang/ref/WeakReference;", "getService", "()Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService;", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class MusicPlayerBinder extends Binder {
        private final WeakReference<BackgroundMusicService> weakService;

        public MusicPlayerBinder(BackgroundMusicService service) {
            Intrinsics.checkNotNullParameter(service, "service");
            this.weakService = new WeakReference<>(service);
        }

        public final BackgroundMusicService getService() {
            return this.weakService.get();
        }
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.mBinder;
    }

    public boolean onUnbind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return true;
    }

    @Override // tv.danmaku.bili.ui.player.notification.AbsMusicService
    public void onDestroy() {
        super.onDestroy();
        isStarting = false;
        isRunning = false;
        BgmEventTracerManager.getInstance().setEventTracer(null);
        this.mBinder = null;
    }

    @Override // tv.danmaku.bili.ui.player.notification.AbsMusicService
    public void release() {
        BgmEventTracerManager.getInstance().setEventTracer(null);
        super.release();
    }

    public final void bindMediaSession(MediaSessionCompat mediaSession) {
        this.mMediaSession = mediaSession;
        BgmEventTracerManager.getInstance().feedEvent((Context) this, "player_with_background_music");
    }

    /* compiled from: BackgroundMusicService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/BackgroundMusicService$Companion;", "", "<init>", "()V", "METADATA_KEY_IS_LIKED", "", "getMETADATA_KEY_IS_LIKED", "()Ljava/lang/String;", "setMETADATA_KEY_IS_LIKED", "(Ljava/lang/String;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "isStarting", "setStarting", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getMETADATA_KEY_IS_LIKED() {
            return BackgroundMusicService.METADATA_KEY_IS_LIKED;
        }

        public final void setMETADATA_KEY_IS_LIKED(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            BackgroundMusicService.METADATA_KEY_IS_LIKED = str;
        }

        public final boolean isRunning() {
            return BackgroundMusicService.isRunning;
        }

        public final void setRunning(boolean z) {
            BackgroundMusicService.isRunning = z;
        }

        public final boolean isStarting() {
            return BackgroundMusicService.isStarting;
        }

        public final void setStarting(boolean z) {
            BackgroundMusicService.isStarting = z;
        }
    }
}