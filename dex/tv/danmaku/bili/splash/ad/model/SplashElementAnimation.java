package tv.danmaku.bili.splash.ad.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashElementAnimation.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashElementAnimation;", "", "animationList", "", "Ltv/danmaku/bili/splash/ad/model/BezierAnimationElement;", "<init>", "(Ljava/util/List;)V", "getAnimationList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashElementAnimation {
    public static final int $stable = 8;
    @SerializedName("animation_list")
    private final List<BezierAnimationElement> animationList;

    public SplashElementAnimation() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashElementAnimation copy$default(SplashElementAnimation splashElementAnimation, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = splashElementAnimation.animationList;
        }
        return splashElementAnimation.copy(list);
    }

    public final List<BezierAnimationElement> component1() {
        return this.animationList;
    }

    public final SplashElementAnimation copy(List<BezierAnimationElement> list) {
        return new SplashElementAnimation(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SplashElementAnimation) && Intrinsics.areEqual(this.animationList, ((SplashElementAnimation) obj).animationList);
    }

    public int hashCode() {
        if (this.animationList == null) {
            return 0;
        }
        return this.animationList.hashCode();
    }

    public String toString() {
        return "SplashElementAnimation(animationList=" + this.animationList + ")";
    }

    public SplashElementAnimation(List<BezierAnimationElement> list) {
        this.animationList = list;
    }

    public /* synthetic */ SplashElementAnimation(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<BezierAnimationElement> getAnimationList() {
        return this.animationList;
    }
}