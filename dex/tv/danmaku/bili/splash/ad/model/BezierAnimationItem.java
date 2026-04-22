package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashBezierAnimationItem.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/BezierAnimationItem;", "", "type", "", "delay", "", "duration", "param", "Ltv/danmaku/bili/splash/ad/model/BezierParam;", "<init>", "(IJJLtv/danmaku/bili/splash/ad/model/BezierParam;)V", "getType", "()I", "getDelay", "()J", "getDuration", "getParam", "()Ltv/danmaku/bili/splash/ad/model/BezierParam;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BezierAnimationItem {
    public static final int $stable = 0;
    @SerializedName("delay")
    private final long delay;
    @SerializedName("duration")
    private final long duration;
    @SerializedName("param")
    private final BezierParam param;
    @SerializedName("type")
    private final int type;

    public BezierAnimationItem() {
        this(0, 0L, 0L, null, 15, null);
    }

    public static /* synthetic */ BezierAnimationItem copy$default(BezierAnimationItem bezierAnimationItem, int i, long j, long j2, BezierParam bezierParam, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bezierAnimationItem.type;
        }
        if ((i2 & 2) != 0) {
            j = bezierAnimationItem.delay;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = bezierAnimationItem.duration;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            bezierParam = bezierAnimationItem.param;
        }
        return bezierAnimationItem.copy(i, j3, j4, bezierParam);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.delay;
    }

    public final long component3() {
        return this.duration;
    }

    public final BezierParam component4() {
        return this.param;
    }

    public final BezierAnimationItem copy(int i, long j, long j2, BezierParam bezierParam) {
        return new BezierAnimationItem(i, j, j2, bezierParam);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BezierAnimationItem) {
            BezierAnimationItem bezierAnimationItem = (BezierAnimationItem) obj;
            return this.type == bezierAnimationItem.type && this.delay == bezierAnimationItem.delay && this.duration == bezierAnimationItem.duration && Intrinsics.areEqual(this.param, bezierAnimationItem.param);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.type * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.delay)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + (this.param == null ? 0 : this.param.hashCode());
    }

    public String toString() {
        int i = this.type;
        long j = this.delay;
        long j2 = this.duration;
        return "BezierAnimationItem(type=" + i + ", delay=" + j + ", duration=" + j2 + ", param=" + this.param + ")";
    }

    public BezierAnimationItem(int type, long delay, long duration, BezierParam param) {
        this.type = type;
        this.delay = delay;
        this.duration = duration;
        this.param = param;
    }

    public /* synthetic */ BezierAnimationItem(int i, long j, long j2, BezierParam bezierParam, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) == 0 ? j2 : 0L, (i2 & 8) != 0 ? null : bezierParam);
    }

    public final int getType() {
        return this.type;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final BezierParam getParam() {
        return this.param;
    }
}