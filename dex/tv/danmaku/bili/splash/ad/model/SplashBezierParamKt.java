package tv.danmaku.bili.splash.ad.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashBezierParam.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toParam", "Lcom/bilibili/commonanim/elementanim/model/BezierParam;", "Ltv/danmaku/bili/splash/ad/model/BezierParam;", "getToParam", "(Ltv/danmaku/bili/splash/ad/model/BezierParam;)Lcom/bilibili/commonanim/elementanim/model/BezierParam;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashBezierParamKt {
    public static final com.bilibili.commonanim.elementanim.model.BezierParam getToParam(BezierParam $this$toParam) {
        Intrinsics.checkNotNullParameter($this$toParam, "<this>");
        return new com.bilibili.commonanim.elementanim.model.BezierParam(SplashBezierPointKt.getToPoint($this$toParam.getStart()), SplashBezierPointKt.getToPoint($this$toParam.getEnd()), SplashBezierPointKt.getToPoint($this$toParam.getControl1()), SplashBezierPointKt.getToPoint($this$toParam.getControl2()));
    }
}