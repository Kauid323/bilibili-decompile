package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: SplashListResponse.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0010HÆ\u0003Js\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "", "maxCount", "", "intervalForShow", "intervalForUpdate", "disperseInterval", "", "splashList", "", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "strategyList", "", "Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;", "keepIds", "splashRequestId", "", "<init>", "(IIIJLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getMaxCount", "()I", "getIntervalForShow", "getIntervalForUpdate", "getDisperseInterval", "()J", "getSplashList", "()Ljava/util/List;", "setSplashList", "(Ljava/util/List;)V", "getStrategyList", "getKeepIds", "getSplashRequestId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashListResponse {
    public static final int $stable = 8;
    @SerializedName("disperse_interval")
    private final long disperseInterval;
    @SerializedName("min_interval")
    private final int intervalForShow;
    @SerializedName("pull_interval")
    private final int intervalForUpdate;
    @SerializedName("keep_ids")
    private final List<Long> keepIds;
    @SerializedName("max_time")
    private final int maxCount;
    @SerializedName("list")
    private List<SplashOrder> splashList;
    @SerializedName("splash_request_id")
    private final String splashRequestId;
    @SerializedName(ReportEvent.EVENT_TYPE_SHOW)
    private final List<SplashShowStrategy> strategyList;

    public SplashListResponse() {
        this(0, 0, 0, 0L, null, null, null, null, BR.hallCover, null);
    }

    public final int component1() {
        return this.maxCount;
    }

    public final int component2() {
        return this.intervalForShow;
    }

    public final int component3() {
        return this.intervalForUpdate;
    }

    public final long component4() {
        return this.disperseInterval;
    }

    public final List<SplashOrder> component5() {
        return this.splashList;
    }

    public final List<SplashShowStrategy> component6() {
        return this.strategyList;
    }

    public final List<Long> component7() {
        return this.keepIds;
    }

    public final String component8() {
        return this.splashRequestId;
    }

    public final SplashListResponse copy(int i, int i2, int i3, long j, List<SplashOrder> list, List<SplashShowStrategy> list2, List<Long> list3, String str) {
        return new SplashListResponse(i, i2, i3, j, list, list2, list3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashListResponse) {
            SplashListResponse splashListResponse = (SplashListResponse) obj;
            return this.maxCount == splashListResponse.maxCount && this.intervalForShow == splashListResponse.intervalForShow && this.intervalForUpdate == splashListResponse.intervalForUpdate && this.disperseInterval == splashListResponse.disperseInterval && Intrinsics.areEqual(this.splashList, splashListResponse.splashList) && Intrinsics.areEqual(this.strategyList, splashListResponse.strategyList) && Intrinsics.areEqual(this.keepIds, splashListResponse.keepIds) && Intrinsics.areEqual(this.splashRequestId, splashListResponse.splashRequestId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.maxCount * 31) + this.intervalForShow) * 31) + this.intervalForUpdate) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.disperseInterval)) * 31) + (this.splashList == null ? 0 : this.splashList.hashCode())) * 31) + (this.strategyList == null ? 0 : this.strategyList.hashCode())) * 31) + (this.keepIds == null ? 0 : this.keepIds.hashCode())) * 31) + (this.splashRequestId != null ? this.splashRequestId.hashCode() : 0);
    }

    public String toString() {
        int i = this.maxCount;
        int i2 = this.intervalForShow;
        int i3 = this.intervalForUpdate;
        long j = this.disperseInterval;
        List<SplashOrder> list = this.splashList;
        List<SplashShowStrategy> list2 = this.strategyList;
        List<Long> list3 = this.keepIds;
        return "SplashListResponse(maxCount=" + i + ", intervalForShow=" + i2 + ", intervalForUpdate=" + i3 + ", disperseInterval=" + j + ", splashList=" + list + ", strategyList=" + list2 + ", keepIds=" + list3 + ", splashRequestId=" + this.splashRequestId + ")";
    }

    public SplashListResponse(int maxCount, int intervalForShow, int intervalForUpdate, long disperseInterval, List<SplashOrder> list, List<SplashShowStrategy> list2, List<Long> list3, String splashRequestId) {
        this.maxCount = maxCount;
        this.intervalForShow = intervalForShow;
        this.intervalForUpdate = intervalForUpdate;
        this.disperseInterval = disperseInterval;
        this.splashList = list;
        this.strategyList = list2;
        this.keepIds = list3;
        this.splashRequestId = splashRequestId;
    }

    public /* synthetic */ SplashListResponse(int i, int i2, int i3, long j, List list, List list2, List list3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? 0L : j, (i4 & 16) != 0 ? null : list, (i4 & 32) != 0 ? null : list2, (i4 & 64) != 0 ? null : list3, (i4 & BR.cover) == 0 ? str : null);
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final int getIntervalForShow() {
        return this.intervalForShow;
    }

    public final int getIntervalForUpdate() {
        return this.intervalForUpdate;
    }

    public final long getDisperseInterval() {
        return this.disperseInterval;
    }

    public final List<SplashOrder> getSplashList() {
        return this.splashList;
    }

    public final void setSplashList(List<SplashOrder> list) {
        this.splashList = list;
    }

    public final List<SplashShowStrategy> getStrategyList() {
        return this.strategyList;
    }

    public final List<Long> getKeepIds() {
        return this.keepIds;
    }

    public final String getSplashRequestId() {
        return this.splashRequestId;
    }
}