package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;

/* compiled from: IMediaPlayAdapterFactory.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayAdapterFactory;", "", "create", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "params", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaPlayAdapterFactory {
    IMediaPlayAdapter create(IMediaPlayParams iMediaPlayParams, MediaItem<?> mediaItem);
}