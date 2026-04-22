package tv.danmaku.videoplayer.core.media.mediacenter.factory;

import android.content.Context;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.mediacenter.config.MediaPlayerConfig;

/* compiled from: IPlayerFactory.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/factory/IPlayerFactory;", "", "create", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "context", "Landroid/content/Context;", "config", "Ltv/danmaku/videoplayer/core/media/mediacenter/config/MediaPlayerConfig;", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerFactory {
    IjkMediaPlayer create(Context context, MediaPlayerConfig mediaPlayerConfig);
}