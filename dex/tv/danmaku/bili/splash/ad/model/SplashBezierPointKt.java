package tv.danmaku.bili.splash.ad.model;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SplashBezierPoint.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toPoint", "Lcom/bilibili/commonanim/elementanim/model/BezierPoint;", "Ltv/danmaku/bili/splash/ad/model/BezierPoint;", "getToPoint", "(Ltv/danmaku/bili/splash/ad/model/BezierPoint;)Lcom/bilibili/commonanim/elementanim/model/BezierPoint;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashBezierPointKt {
    public static final com.bilibili.commonanim.elementanim.model.BezierPoint getToPoint(BezierPoint $this$toPoint) {
        if ($this$toPoint == null) {
            return new com.bilibili.commonanim.elementanim.model.BezierPoint(0.0f, 0.0f);
        }
        return new com.bilibili.commonanim.elementanim.model.BezierPoint($this$toPoint.getX(), $this$toPoint.getY());
    }
}