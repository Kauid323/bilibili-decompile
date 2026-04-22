package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashElementAnimation.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashElementAnimation;", "", "<init>", "()V", "animationList", "", "Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationElement;", "getAnimationList", "()Ljava/util/List;", "setAnimationList", "(Ljava/util/List;)V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashElementAnimation {
    public static final int $stable = 8;
    @JSONField(name = "animation_list")
    private List<BezierAnimationElement> animationList;

    public final List<BezierAnimationElement> getAnimationList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.animationList);
    }

    public final void setAnimationList(List<BezierAnimationElement> list) {
        this.animationList = list;
    }
}