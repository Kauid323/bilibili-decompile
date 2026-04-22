package tv.danmaku.bili.ui.splash.ad.model;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierPoint.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toPoint", "Lcom/bilibili/commonanim/elementanim/model/BezierPoint;", "Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;", "getToPoint", "(Ltv/danmaku/bili/ui/splash/ad/model/BezierPoint;)Lcom/bilibili/commonanim/elementanim/model/BezierPoint;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierPointKt {
    public static final com.bilibili.commonanim.elementanim.model.BezierPoint getToPoint(BezierPoint $this$toPoint) {
        if ($this$toPoint == null) {
            return new com.bilibili.commonanim.elementanim.model.BezierPoint((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        return new com.bilibili.commonanim.elementanim.model.BezierPoint($this$toPoint.getX(), $this$toPoint.getY());
    }
}