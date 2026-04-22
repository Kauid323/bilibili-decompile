package tv.danmaku.bili.ui.splash.ad.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierAnimationItem.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toItem", "Lcom/bilibili/commonanim/elementanim/model/BezierAnimationItem;", "Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationItem;", "getToItem", "(Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationItem;)Lcom/bilibili/commonanim/elementanim/model/BezierAnimationItem;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierAnimationItemKt {
    public static final com.bilibili.commonanim.elementanim.model.BezierAnimationItem getToItem(BezierAnimationItem $this$toItem) {
        Intrinsics.checkNotNullParameter($this$toItem, "<this>");
        int type = $this$toItem.getType();
        long delay = $this$toItem.getDelay();
        long duration = $this$toItem.getDuration();
        BezierParam param = $this$toItem.getParam();
        return new com.bilibili.commonanim.elementanim.model.BezierAnimationItem(type, delay, duration, param != null ? BezierParamKt.getToParam(param) : null);
    }
}