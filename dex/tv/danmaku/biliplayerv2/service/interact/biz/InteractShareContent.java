package tv.danmaku.biliplayerv2.service.interact.biz;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.share.SharableObject;

/* compiled from: InteractLayerService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/InteractShareContent;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "<init>", "()V", "danmakuParams", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "getDanmakuParams", "()Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "setDanmakuParams", "(Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;)V", "sharedSubtitle", "Ltv/danmaku/biliplayerv2/service/interact/biz/SharedSubtitle;", "getSharedSubtitle", "()Ltv/danmaku/biliplayerv2/service/interact/biz/SharedSubtitle;", "setSharedSubtitle", "(Ltv/danmaku/biliplayerv2/service/interact/biz/SharedSubtitle;)V", "danmakuSwitch", "", "getDanmakuSwitch", "()Ljava/lang/Boolean;", "setDanmakuSwitch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "danmakuExposureSpmid", "", "getDanmakuExposureSpmid", "()Ljava/lang/String;", "setDanmakuExposureSpmid", "(Ljava/lang/String;)V", "chronosSwitch", "getChronosSwitch", "()Z", "setChronosSwitch", "(Z)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InteractShareContent extends SharableObject {
    private boolean chronosSwitch;
    private String danmakuExposureSpmid;
    private DanmakuParams danmakuParams;
    private Boolean danmakuSwitch;
    private SharedSubtitle sharedSubtitle;

    public final DanmakuParams getDanmakuParams() {
        return this.danmakuParams;
    }

    public final void setDanmakuParams(DanmakuParams danmakuParams) {
        this.danmakuParams = danmakuParams;
    }

    public final SharedSubtitle getSharedSubtitle() {
        return this.sharedSubtitle;
    }

    public final void setSharedSubtitle(SharedSubtitle sharedSubtitle) {
        this.sharedSubtitle = sharedSubtitle;
    }

    public final Boolean getDanmakuSwitch() {
        return this.danmakuSwitch;
    }

    public final void setDanmakuSwitch(Boolean bool) {
        this.danmakuSwitch = bool;
    }

    public final String getDanmakuExposureSpmid() {
        return this.danmakuExposureSpmid;
    }

    public final void setDanmakuExposureSpmid(String str) {
        this.danmakuExposureSpmid = str;
    }

    public final boolean getChronosSwitch() {
        return this.chronosSwitch;
    }

    public final void setChronosSwitch(boolean z) {
        this.chronosSwitch = z;
    }
}