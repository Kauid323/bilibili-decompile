package tv.danmaku.videoplayer.core.share;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;

/* compiled from: MediaPlayerShareParam.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/videoplayer/core/share/MediaPlayerShareParam;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "mediaPlayAdapter", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "<init>", "(Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;)V", "getMediaPlayAdapter", "()Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaPlayerShareParam extends SharableObject {
    private final IMediaPlayAdapter mediaPlayAdapter;

    public MediaPlayerShareParam(IMediaPlayAdapter mediaPlayAdapter) {
        Intrinsics.checkNotNullParameter(mediaPlayAdapter, "mediaPlayAdapter");
        this.mediaPlayAdapter = mediaPlayAdapter;
    }

    public final IMediaPlayAdapter getMediaPlayAdapter() {
        return this.mediaPlayAdapter;
    }
}