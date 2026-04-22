package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: SplashVideoInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashVideoInfo;", "", "avid", "", "cid", "<init>", "(JJ)V", "getAvid", "()J", "getCid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashVideoInfo {
    public static final int $stable = 0;
    @SerializedName("avid")
    private final long avid;
    @SerializedName("cid")
    private final long cid;

    public SplashVideoInfo() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ SplashVideoInfo copy$default(SplashVideoInfo splashVideoInfo, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = splashVideoInfo.avid;
        }
        if ((i & 2) != 0) {
            j2 = splashVideoInfo.cid;
        }
        return splashVideoInfo.copy(j, j2);
    }

    public final long component1() {
        return this.avid;
    }

    public final long component2() {
        return this.cid;
    }

    public final SplashVideoInfo copy(long j, long j2) {
        return new SplashVideoInfo(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashVideoInfo) {
            SplashVideoInfo splashVideoInfo = (SplashVideoInfo) obj;
            return this.avid == splashVideoInfo.avid && this.cid == splashVideoInfo.cid;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid);
    }

    public String toString() {
        long j = this.avid;
        return "SplashVideoInfo(avid=" + j + ", cid=" + this.cid + ")";
    }

    public SplashVideoInfo(long avid, long cid) {
        this.avid = avid;
        this.cid = cid;
    }

    public /* synthetic */ SplashVideoInfo(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getAvid() {
        return this.avid;
    }

    public final long getCid() {
        return this.cid;
    }
}