package tv.danmaku.biliplayerv2.service.interact.biz.model;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.IRenderLayer;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SavedState.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/SavedState;", "", "<init>", "()V", "danmakuResolveParams", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "getDanmakuResolveParams", "()Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "setDanmakuResolveParams", "(Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;)V", "danmakuRenderLayer", "Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;", "getDanmakuRenderLayer", "()Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;", "setDanmakuRenderLayer", "(Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SavedState {
    private IRenderLayer.Type danmakuRenderLayer;
    private Video.DanmakuResolveParams danmakuResolveParams;

    public final Video.DanmakuResolveParams getDanmakuResolveParams() {
        return this.danmakuResolveParams;
    }

    public final void setDanmakuResolveParams(Video.DanmakuResolveParams danmakuResolveParams) {
        this.danmakuResolveParams = danmakuResolveParams;
    }

    public final IRenderLayer.Type getDanmakuRenderLayer() {
        return this.danmakuRenderLayer;
    }

    public final void setDanmakuRenderLayer(IRenderLayer.Type type) {
        this.danmakuRenderLayer = type;
    }
}