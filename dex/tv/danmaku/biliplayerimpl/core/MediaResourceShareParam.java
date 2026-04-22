package tv.danmaku.biliplayerimpl.core;

import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.share.SharableObject;

/* compiled from: PlayerCoreServiceV2.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/MediaResourceShareParam;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "mediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "<init>", "(Lcom/bilibili/lib/media/resource/MediaResource;)V", "getMediaResource", "()Lcom/bilibili/lib/media/resource/MediaResource;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaResourceShareParam extends SharableObject {
    private final MediaResource mediaResource;

    public MediaResourceShareParam(MediaResource mediaResource) {
        this.mediaResource = mediaResource;
    }

    public final MediaResource getMediaResource() {
        return this.mediaResource;
    }
}