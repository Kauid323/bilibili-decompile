package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/OnTrackInfoObserver;", "", "onTrackInfo", "", "trackInfo", "", "Ltv/danmaku/ijk/media/player/misc/IjkTrackInfo;", "([Ltv/danmaku/ijk/media/player/misc/IjkTrackInfo;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OnTrackInfoObserver {
    void onTrackInfo(IjkTrackInfo[] ijkTrackInfoArr);
}