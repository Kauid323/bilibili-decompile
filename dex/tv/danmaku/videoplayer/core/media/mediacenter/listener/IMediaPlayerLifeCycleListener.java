package tv.danmaku.videoplayer.core.media.mediacenter.listener;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: IMediaPlayerLifeCycleListener.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/listener/IMediaPlayerLifeCycleListener;", "", "onMediaPlayerDidPrepareToPlay", "", "mediaPlayer", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "onMediaPlayerWillShutDownByOthers", "onMediaPlayerWillResignActive", "onMediaPlayerDidBecomeActive", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaPlayerLifeCycleListener {
    void onMediaPlayerDidBecomeActive(IMediaPlayer iMediaPlayer);

    void onMediaPlayerDidPrepareToPlay(IMediaPlayer iMediaPlayer);

    void onMediaPlayerWillResignActive(IMediaPlayer iMediaPlayer);

    void onMediaPlayerWillShutDownByOthers(IMediaPlayer iMediaPlayer);
}