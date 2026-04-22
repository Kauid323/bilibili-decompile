package tv.danmaku.bili.ui.player.notification;

import kotlin.Metadata;
import tv.danmaku.bili.ui.player.data.NotificationStyle;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MusicNotificationManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/MusicNotificationCallback;", "", "getNotificationStyle", "Ltv/danmaku/bili/ui/player/data/NotificationStyle;", "enableLike", "", "getLikeState", "getPlayMode", "", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface MusicNotificationCallback {
    boolean enableLike();

    boolean getLikeState();

    NotificationStyle getNotificationStyle();

    int getPlayMode();
}