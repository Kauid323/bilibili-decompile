package tv.danmaku.bili.splash.ad.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashBezierParam.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/BezierParam;", "", "start", "Ltv/danmaku/bili/splash/ad/model/BezierPoint;", "end", "control1", "control2", "<init>", "(Ltv/danmaku/bili/splash/ad/model/BezierPoint;Ltv/danmaku/bili/splash/ad/model/BezierPoint;Ltv/danmaku/bili/splash/ad/model/BezierPoint;Ltv/danmaku/bili/splash/ad/model/BezierPoint;)V", "getStart", "()Ltv/danmaku/bili/splash/ad/model/BezierPoint;", "getEnd", "getControl1", "getControl2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BezierParam {
    public static final int $stable = 0;
    @SerializedName("control1")
    private final BezierPoint control1;
    @SerializedName("control2")
    private final BezierPoint control2;
    @SerializedName("end")
    private final BezierPoint end;
    @SerializedName("start")
    private final BezierPoint start;

    public BezierParam() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ BezierParam copy$default(BezierParam bezierParam, BezierPoint bezierPoint, BezierPoint bezierPoint2, BezierPoint bezierPoint3, BezierPoint bezierPoint4, int i, Object obj) {
        if ((i & 1) != 0) {
            bezierPoint = bezierParam.start;
        }
        if ((i & 2) != 0) {
            bezierPoint2 = bezierParam.end;
        }
        if ((i & 4) != 0) {
            bezierPoint3 = bezierParam.control1;
        }
        if ((i & 8) != 0) {
            bezierPoint4 = bezierParam.control2;
        }
        return bezierParam.copy(bezierPoint, bezierPoint2, bezierPoint3, bezierPoint4);
    }

    public final BezierPoint component1() {
        return this.start;
    }

    public final BezierPoint component2() {
        return this.end;
    }

    public final BezierPoint component3() {
        return this.control1;
    }

    public final BezierPoint component4() {
        return this.control2;
    }

    public final BezierParam copy(BezierPoint bezierPoint, BezierPoint bezierPoint2, BezierPoint bezierPoint3, BezierPoint bezierPoint4) {
        return new BezierParam(bezierPoint, bezierPoint2, bezierPoint3, bezierPoint4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BezierParam) {
            BezierParam bezierParam = (BezierParam) obj;
            return Intrinsics.areEqual(this.start, bezierParam.start) && Intrinsics.areEqual(this.end, bezierParam.end) && Intrinsics.areEqual(this.control1, bezierParam.control1) && Intrinsics.areEqual(this.control2, bezierParam.control2);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.start == null ? 0 : this.start.hashCode()) * 31) + (this.end == null ? 0 : this.end.hashCode())) * 31) + (this.control1 == null ? 0 : this.control1.hashCode())) * 31) + (this.control2 != null ? this.control2.hashCode() : 0);
    }

    public String toString() {
        BezierPoint bezierPoint = this.start;
        BezierPoint bezierPoint2 = this.end;
        BezierPoint bezierPoint3 = this.control1;
        return "BezierParam(start=" + bezierPoint + ", end=" + bezierPoint2 + ", control1=" + bezierPoint3 + ", control2=" + this.control2 + ")";
    }

    public BezierParam(BezierPoint start, BezierPoint end, BezierPoint control1, BezierPoint control2) {
        this.start = start;
        this.end = end;
        this.control1 = control1;
        this.control2 = control2;
    }

    public /* synthetic */ BezierParam(BezierPoint bezierPoint, BezierPoint bezierPoint2, BezierPoint bezierPoint3, BezierPoint bezierPoint4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bezierPoint, (i & 2) != 0 ? null : bezierPoint2, (i & 4) != 0 ? null : bezierPoint3, (i & 8) != 0 ? null : bezierPoint4);
    }

    public final BezierPoint getStart() {
        return this.start;
    }

    public final BezierPoint getEnd() {
        return this.end;
    }

    public final BezierPoint getControl1() {
        return this.control1;
    }

    public final BezierPoint getControl2() {
        return this.control2;
    }
}