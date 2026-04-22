package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;

/* compiled from: SplashShowStrategy.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003JK\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0019HÖ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;", "", "id", "", "stime", "etime", PeakTaskDefine.AD_CB, "", "splashContent", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "banner", "Lcom/google/gson/JsonObject;", "<init>", "(JJJLjava/lang/String;Ltv/danmaku/bili/splash/ad/model/SplashOrder;Lcom/google/gson/JsonObject;)V", "getId", "()J", "getStime", "getEtime", "getAdCb", "()Ljava/lang/String;", "getSplashContent", "()Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "getBanner", "()Lcom/google/gson/JsonObject;", "originIndex", "", "getOriginIndex", "()I", "setOriginIndex", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashShowStrategy {
    public static final int $stable = 8;
    @SerializedName("ad_cb")
    private final String adCb;
    @SerializedName("banner")
    private final JsonObject banner;
    @SerializedName("etime")
    private final long etime;
    @SerializedName("id")
    private final long id;
    private transient int originIndex;
    @SerializedName("splash_content")
    private final SplashOrder splashContent;
    @SerializedName("stime")
    private final long stime;

    public SplashShowStrategy() {
        this(0L, 0L, 0L, null, null, null, 63, null);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.stime;
    }

    public final long component3() {
        return this.etime;
    }

    public final String component4() {
        return this.adCb;
    }

    public final SplashOrder component5() {
        return this.splashContent;
    }

    public final JsonObject component6() {
        return this.banner;
    }

    public final SplashShowStrategy copy(long j, long j2, long j3, String str, SplashOrder splashOrder, JsonObject jsonObject) {
        return new SplashShowStrategy(j, j2, j3, str, splashOrder, jsonObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashShowStrategy) {
            SplashShowStrategy splashShowStrategy = (SplashShowStrategy) obj;
            return this.id == splashShowStrategy.id && this.stime == splashShowStrategy.stime && this.etime == splashShowStrategy.etime && Intrinsics.areEqual(this.adCb, splashShowStrategy.adCb) && Intrinsics.areEqual(this.splashContent, splashShowStrategy.splashContent) && Intrinsics.areEqual(this.banner, splashShowStrategy.banner);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.stime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.etime)) * 31) + (this.adCb == null ? 0 : this.adCb.hashCode())) * 31) + (this.splashContent == null ? 0 : this.splashContent.hashCode())) * 31) + (this.banner != null ? this.banner.hashCode() : 0);
    }

    public String toString() {
        long j = this.id;
        long j2 = this.stime;
        long j3 = this.etime;
        String str = this.adCb;
        SplashOrder splashOrder = this.splashContent;
        return "SplashShowStrategy(id=" + j + ", stime=" + j2 + ", etime=" + j3 + ", adCb=" + str + ", splashContent=" + splashOrder + ", banner=" + this.banner + ")";
    }

    public SplashShowStrategy(long id, long stime, long etime, String adCb, SplashOrder splashContent, JsonObject banner) {
        this.id = id;
        this.stime = stime;
        this.etime = etime;
        this.adCb = adCb;
        this.splashContent = splashContent;
        this.banner = banner;
        this.originIndex = FlowControlConfig.RETRY_MAX_TIMES;
    }

    public /* synthetic */ SplashShowStrategy(long j, long j2, long j3, String str, SplashOrder splashOrder, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) == 0 ? j3 : 0L, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : splashOrder, (i & 32) == 0 ? jsonObject : null);
    }

    public final long getId() {
        return this.id;
    }

    public final long getStime() {
        return this.stime;
    }

    public final long getEtime() {
        return this.etime;
    }

    public final String getAdCb() {
        return this.adCb;
    }

    public final SplashOrder getSplashContent() {
        return this.splashContent;
    }

    public final JsonObject getBanner() {
        return this.banner;
    }

    public final int getOriginIndex() {
        return this.originIndex;
    }

    public final void setOriginIndex(int i) {
        this.originIndex = i;
    }
}