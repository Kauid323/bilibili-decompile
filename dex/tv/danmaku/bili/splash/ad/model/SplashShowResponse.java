package tv.danmaku.bili.splash.ad.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: SplashShowResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashShowResponse;", "", "strategyList", "", "Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;", "splashRequestId", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getStrategyList", "()Ljava/util/List;", "getSplashRequestId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashShowResponse {
    public static final int $stable = 8;
    @SerializedName("splash_request_id")
    private final String splashRequestId;
    @SerializedName(ReportEvent.EVENT_TYPE_SHOW)
    private final List<SplashShowStrategy> strategyList;

    public SplashShowResponse() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashShowResponse copy$default(SplashShowResponse splashShowResponse, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = splashShowResponse.strategyList;
        }
        if ((i & 2) != 0) {
            str = splashShowResponse.splashRequestId;
        }
        return splashShowResponse.copy(list, str);
    }

    public final List<SplashShowStrategy> component1() {
        return this.strategyList;
    }

    public final String component2() {
        return this.splashRequestId;
    }

    public final SplashShowResponse copy(List<SplashShowStrategy> list, String str) {
        return new SplashShowResponse(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashShowResponse) {
            SplashShowResponse splashShowResponse = (SplashShowResponse) obj;
            return Intrinsics.areEqual(this.strategyList, splashShowResponse.strategyList) && Intrinsics.areEqual(this.splashRequestId, splashShowResponse.splashRequestId);
        }
        return false;
    }

    public int hashCode() {
        return ((this.strategyList == null ? 0 : this.strategyList.hashCode()) * 31) + (this.splashRequestId != null ? this.splashRequestId.hashCode() : 0);
    }

    public String toString() {
        List<SplashShowStrategy> list = this.strategyList;
        return "SplashShowResponse(strategyList=" + list + ", splashRequestId=" + this.splashRequestId + ")";
    }

    public SplashShowResponse(List<SplashShowStrategy> list, String splashRequestId) {
        this.strategyList = list;
        this.splashRequestId = splashRequestId;
    }

    public /* synthetic */ SplashShowResponse(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
    }

    public final List<SplashShowStrategy> getStrategyList() {
        return this.strategyList;
    }

    public final String getSplashRequestId() {
        return this.splashRequestId;
    }
}