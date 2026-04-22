package tv.danmaku.bili.splash.ad.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: SplashBezierPoint.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/BezierPoint;", "", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BezierPoint {
    public static final int $stable = 0;
    @SerializedName("x")
    private final float x;
    @SerializedName("y")
    private final float y;

    public BezierPoint() {
        this(0.0f, 0.0f, 3, null);
    }

    public static /* synthetic */ BezierPoint copy$default(BezierPoint bezierPoint, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = bezierPoint.x;
        }
        if ((i & 2) != 0) {
            f2 = bezierPoint.y;
        }
        return bezierPoint.copy(f, f2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final BezierPoint copy(float f, float f2) {
        return new BezierPoint(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BezierPoint) {
            BezierPoint bezierPoint = (BezierPoint) obj;
            return Float.compare(this.x, bezierPoint.x) == 0 && Float.compare(this.y, bezierPoint.y) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    public String toString() {
        float f = this.x;
        return "BezierPoint(x=" + f + ", y=" + this.y + ")";
    }

    public BezierPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public /* synthetic */ BezierPoint(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }
}