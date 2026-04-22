package tv.danmaku.video.bilicardplayer.player;

import com.bilibili.player.history.IMediaHistoryKeyParams;
import com.bilibili.player.history.MediaHistoryEntry;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IBiliCardPlayer.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/IMediaHistoryReader;", "", "read", "Lcom/bilibili/player/history/MediaHistoryEntry;", "mediaHistoryKeyParams", "Lcom/bilibili/player/history/IMediaHistoryKeyParams;", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaHistoryReader {
    MediaHistoryEntry read(IMediaHistoryKeyParams iMediaHistoryKeyParams);
}