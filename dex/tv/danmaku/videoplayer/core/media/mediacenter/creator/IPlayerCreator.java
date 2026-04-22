package tv.danmaku.videoplayer.core.media.mediacenter.creator;

import android.content.Context;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.videoplayer.core.media.resource.PlayerConfig;

public interface IPlayerCreator {
    IMediaPlayer createMediaPlayer(Context context, PlayerConfig playerConfig, Object... objArr);

    void releasePlayer(IMediaPlayer iMediaPlayer);
}