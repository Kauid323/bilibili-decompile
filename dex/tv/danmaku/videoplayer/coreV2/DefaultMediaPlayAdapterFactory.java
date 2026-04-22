package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaPlayAdapter;

/* compiled from: DefaultMediaPlayAdapterFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/DefaultMediaPlayAdapterFactory;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayAdapterFactory;", "<init>", "()V", "create", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "params", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultMediaPlayAdapterFactory implements IMediaPlayAdapterFactory {
    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayAdapterFactory
    public IMediaPlayAdapter create(IMediaPlayParams params, MediaItem<?> mediaItem) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        if (mediaItem instanceof IjkMediaItem) {
            return new IjkMediaPlayAdapter();
        }
        throw new IllegalArgumentException("could not found a adapter for mediaItem: " + mediaItem);
    }
}