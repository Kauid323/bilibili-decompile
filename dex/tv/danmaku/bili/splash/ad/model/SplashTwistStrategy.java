package tv.danmaku.bili.splash.ad.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: SplashTwistStrategy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashTwistStrategy;", "", "xType", "", "yType", "zType", "<init>", "(III)V", "getXType", "()I", "setXType", "(I)V", "getYType", "setYType", "getZType", "setZType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashTwistStrategy {
    public static final int $stable = 8;
    @SerializedName("twist_x_type")
    private int xType;
    @SerializedName("twist_y_type")
    private int yType;
    @SerializedName("twist_z_type")
    private int zType;

    public SplashTwistStrategy() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ SplashTwistStrategy copy$default(SplashTwistStrategy splashTwistStrategy, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = splashTwistStrategy.xType;
        }
        if ((i4 & 2) != 0) {
            i2 = splashTwistStrategy.yType;
        }
        if ((i4 & 4) != 0) {
            i3 = splashTwistStrategy.zType;
        }
        return splashTwistStrategy.copy(i, i2, i3);
    }

    public final int component1() {
        return this.xType;
    }

    public final int component2() {
        return this.yType;
    }

    public final int component3() {
        return this.zType;
    }

    public final SplashTwistStrategy copy(int i, int i2, int i3) {
        return new SplashTwistStrategy(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashTwistStrategy) {
            SplashTwistStrategy splashTwistStrategy = (SplashTwistStrategy) obj;
            return this.xType == splashTwistStrategy.xType && this.yType == splashTwistStrategy.yType && this.zType == splashTwistStrategy.zType;
        }
        return false;
    }

    public int hashCode() {
        return (((this.xType * 31) + this.yType) * 31) + this.zType;
    }

    public String toString() {
        int i = this.xType;
        int i2 = this.yType;
        return "SplashTwistStrategy(xType=" + i + ", yType=" + i2 + ", zType=" + this.zType + ")";
    }

    public SplashTwistStrategy(int xType, int yType, int zType) {
        this.xType = xType;
        this.yType = yType;
        this.zType = zType;
    }

    public /* synthetic */ SplashTwistStrategy(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getXType() {
        return this.xType;
    }

    public final void setXType(int i) {
        this.xType = i;
    }

    public final int getYType() {
        return this.yType;
    }

    public final void setYType(int i) {
        this.yType = i;
    }

    public final int getZType() {
        return this.zType;
    }

    public final void setZType(int i) {
        this.zType = i;
    }
}