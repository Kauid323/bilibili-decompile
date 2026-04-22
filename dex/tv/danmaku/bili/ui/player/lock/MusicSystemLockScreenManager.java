package tv.danmaku.bili.ui.player.lock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import bili.resource.playerbaseres.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.player.tracer.BgmEventTracerManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MusicSystemLockScreenManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/player/lock/MusicSystemLockScreenManager;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "getMediaSession", "Lkotlin/Function0;", "Landroid/support/v4/media/session/MediaSessionCompat;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "isRegisterReceiver", "", "register", "", "unRegister", "onReceive", "intent", "Landroid/content/Intent;", "feedEvent", "eventId", "", "value", "Companion", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MusicSystemLockScreenManager extends BroadcastReceiver {
    public static final String ACTION_SYSTEM_LOCK_NEXT = "com.bilibili.player.music.system.lockScreen.next";
    public static final String ACTION_SYSTEM_LOCK_PAUSE = "com.bilibili.player.music.system.lockScreen.pause";
    public static final String ACTION_SYSTEM_LOCK_PLAY = "com.bilibili.player.music.system.lockScreen.play";
    public static final String ACTION_SYSTEM_LOCK_PLAY_PAUSE = "com.bilibili.player.music.system.lockScreen.play.pause";
    public static final String ACTION_SYSTEM_LOCK_PREV = "com.bilibili.player.music.system.lockScreen.prev";
    public static final String ACTION_SYSTEM_LOCK_STOP = "com.bilibili.player.music.system.lockScreen.stop";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MusicSystemLockScreenManager";
    private final Context context;
    private final Function0<MediaSessionCompat> getMediaSession;
    private boolean isRegisterReceiver;

    public MusicSystemLockScreenManager(Context context, Function0<? extends MediaSessionCompat> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "getMediaSession");
        this.context = context;
        this.getMediaSession = function0;
    }

    public final void register() {
        if (this.isRegisterReceiver) {
            return;
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_SYSTEM_LOCK_PLAY);
        filter.addAction(ACTION_SYSTEM_LOCK_PAUSE);
        filter.addAction(ACTION_SYSTEM_LOCK_PLAY_PAUSE);
        filter.addAction(ACTION_SYSTEM_LOCK_PREV);
        filter.addAction(ACTION_SYSTEM_LOCK_NEXT);
        filter.addAction(ACTION_SYSTEM_LOCK_STOP);
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this, filter);
        this.isRegisterReceiver = true;
    }

    public final void unRegister() {
        if (this.isRegisterReceiver) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this);
            this.isRegisterReceiver = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        MediaSessionCompat mediaSessionCompat = (MediaSessionCompat) this.getMediaSession.invoke();
        MediaControllerCompat controller = mediaSessionCompat != null ? mediaSessionCompat.getController() : null;
        MediaControllerCompat.TransportControls transportControls = controller != null ? controller.getTransportControls() : null;
        if (transportControls == null) {
            BLog.w(TAG, "TransportControls is null");
            return;
        }
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1167311983:
                    if (action.equals(ACTION_SYSTEM_LOCK_PLAY_PAUSE)) {
                        boolean isPlaying = controller.getPlaybackState().getState() == 3;
                        if (isPlaying) {
                            transportControls.pause();
                            String string = context.getString(R.string.playerbaseres_global_string_1134);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            feedEvent(context, "player_lockscreen_background_btn_click", string);
                            return;
                        }
                        transportControls.play();
                        String string2 = context.getString(bili.resource.common.R.string.common_global_string_182);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        feedEvent(context, "player_lockscreen_background_btn_click", string2);
                        return;
                    }
                    return;
                case -166666239:
                    if (action.equals(ACTION_SYSTEM_LOCK_PAUSE)) {
                        transportControls.pause();
                        String string3 = context.getString(R.string.playerbaseres_global_string_1134);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        feedEvent(context, "player_lockscreen_background_btn_click", string3);
                        return;
                    }
                    return;
                case 1657136008:
                    if (action.equals(ACTION_SYSTEM_LOCK_NEXT)) {
                        transportControls.skipToNext();
                        String string4 = context.getString(R.string.playerbaseres_global_string_1082);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        feedEvent(context, "player_lockscreen_background_btn_click", string4);
                        return;
                    }
                    return;
                case 1657201609:
                    if (action.equals(ACTION_SYSTEM_LOCK_PLAY)) {
                        transportControls.play();
                        String string5 = context.getString(bili.resource.common.R.string.common_global_string_182);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        feedEvent(context, "player_lockscreen_background_btn_click", string5);
                        return;
                    }
                    return;
                case 1657207496:
                    if (action.equals(ACTION_SYSTEM_LOCK_PREV)) {
                        transportControls.skipToPrevious();
                        String string6 = context.getString(R.string.playerbaseres_global_string_995);
                        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                        feedEvent(context, "player_lockscreen_background_btn_click", string6);
                        return;
                    }
                    return;
                case 1657299095:
                    if (action.equals(ACTION_SYSTEM_LOCK_STOP)) {
                        transportControls.stop();
                        String string7 = context.getString(bili.resource.common.R.string.common_global_string_46);
                        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                        feedEvent(context, "player_lockscreen_background_btn_click", string7);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void feedEvent(Context context, String eventId, String value) {
        BgmEventTracerManager.getInstance().feedEvent(context, eventId, value);
    }

    /* compiled from: MusicSystemLockScreenManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/player/lock/MusicSystemLockScreenManager$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_SYSTEM_LOCK_PLAY", "ACTION_SYSTEM_LOCK_PAUSE", "ACTION_SYSTEM_LOCK_PLAY_PAUSE", "ACTION_SYSTEM_LOCK_PREV", "ACTION_SYSTEM_LOCK_NEXT", "ACTION_SYSTEM_LOCK_STOP", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}