package tv.danmaku.bili.splash.ad.core.model;

import BottomSheetItemData$;
import com.bilibili.adcommon.config.DDConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashShowStrategy;

/* compiled from: SplashSelectData.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003Js\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\rHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u0011\u0010-\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b.\u0010\"¨\u0006="}, d2 = {"Ltv/danmaku/bili/splash/ad/core/model/SplashSelectData;", "", "splashListResponse", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "trustedPegasusTopViewList", "", "", "localShowSplash", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "realShowSplash", "realShowJobSuccess", "", "realShowRequestId", "", "realShowStrategyList", "Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;", "realTimeSplash", "<init>", "(Ltv/danmaku/bili/splash/ad/model/SplashListResponse;Ljava/util/List;Ltv/danmaku/bili/splash/ad/model/SplashOrder;Ltv/danmaku/bili/splash/ad/model/SplashOrder;ZLjava/lang/String;Ljava/util/List;Ltv/danmaku/bili/splash/ad/model/SplashOrder;)V", "getSplashListResponse", "()Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "setSplashListResponse", "(Ltv/danmaku/bili/splash/ad/model/SplashListResponse;)V", "getTrustedPegasusTopViewList", "()Ljava/util/List;", "setTrustedPegasusTopViewList", "(Ljava/util/List;)V", "getLocalShowSplash", "()Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "setLocalShowSplash", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)V", "getRealShowSplash", "setRealShowSplash", "getRealShowJobSuccess", "()Z", "setRealShowJobSuccess", "(Z)V", "getRealShowRequestId", "()Ljava/lang/String;", "setRealShowRequestId", "(Ljava/lang/String;)V", "getRealShowStrategyList", "setRealShowStrategyList", "getRealTimeSplash", "setRealTimeSplash", "trustRealtimeShowTopView", "getTrustRealtimeShowTopView", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashSelectData {
    public static final int $stable = 8;
    private SplashOrder localShowSplash;
    private boolean realShowJobSuccess;
    private String realShowRequestId;
    private SplashOrder realShowSplash;
    private List<SplashShowStrategy> realShowStrategyList;
    private SplashOrder realTimeSplash;
    private SplashListResponse splashListResponse;
    private List<Long> trustedPegasusTopViewList;

    public SplashSelectData() {
        this(null, null, null, null, false, null, null, null, BR.hallCover, null);
    }

    public final SplashListResponse component1() {
        return this.splashListResponse;
    }

    public final List<Long> component2() {
        return this.trustedPegasusTopViewList;
    }

    public final SplashOrder component3() {
        return this.localShowSplash;
    }

    public final SplashOrder component4() {
        return this.realShowSplash;
    }

    public final boolean component5() {
        return this.realShowJobSuccess;
    }

    public final String component6() {
        return this.realShowRequestId;
    }

    public final List<SplashShowStrategy> component7() {
        return this.realShowStrategyList;
    }

    public final SplashOrder component8() {
        return this.realTimeSplash;
    }

    public final SplashSelectData copy(SplashListResponse splashListResponse, List<Long> list, SplashOrder splashOrder, SplashOrder splashOrder2, boolean z, String str, List<SplashShowStrategy> list2, SplashOrder splashOrder3) {
        return new SplashSelectData(splashListResponse, list, splashOrder, splashOrder2, z, str, list2, splashOrder3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashSelectData) {
            SplashSelectData splashSelectData = (SplashSelectData) obj;
            return Intrinsics.areEqual(this.splashListResponse, splashSelectData.splashListResponse) && Intrinsics.areEqual(this.trustedPegasusTopViewList, splashSelectData.trustedPegasusTopViewList) && Intrinsics.areEqual(this.localShowSplash, splashSelectData.localShowSplash) && Intrinsics.areEqual(this.realShowSplash, splashSelectData.realShowSplash) && this.realShowJobSuccess == splashSelectData.realShowJobSuccess && Intrinsics.areEqual(this.realShowRequestId, splashSelectData.realShowRequestId) && Intrinsics.areEqual(this.realShowStrategyList, splashSelectData.realShowStrategyList) && Intrinsics.areEqual(this.realTimeSplash, splashSelectData.realTimeSplash);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.splashListResponse == null ? 0 : this.splashListResponse.hashCode()) * 31) + (this.trustedPegasusTopViewList == null ? 0 : this.trustedPegasusTopViewList.hashCode())) * 31) + (this.localShowSplash == null ? 0 : this.localShowSplash.hashCode())) * 31) + (this.realShowSplash == null ? 0 : this.realShowSplash.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.realShowJobSuccess)) * 31) + (this.realShowRequestId == null ? 0 : this.realShowRequestId.hashCode())) * 31) + (this.realShowStrategyList == null ? 0 : this.realShowStrategyList.hashCode())) * 31) + (this.realTimeSplash != null ? this.realTimeSplash.hashCode() : 0);
    }

    public String toString() {
        SplashListResponse splashListResponse = this.splashListResponse;
        List<Long> list = this.trustedPegasusTopViewList;
        SplashOrder splashOrder = this.localShowSplash;
        SplashOrder splashOrder2 = this.realShowSplash;
        boolean z = this.realShowJobSuccess;
        String str = this.realShowRequestId;
        List<SplashShowStrategy> list2 = this.realShowStrategyList;
        return "SplashSelectData(splashListResponse=" + splashListResponse + ", trustedPegasusTopViewList=" + list + ", localShowSplash=" + splashOrder + ", realShowSplash=" + splashOrder2 + ", realShowJobSuccess=" + z + ", realShowRequestId=" + str + ", realShowStrategyList=" + list2 + ", realTimeSplash=" + this.realTimeSplash + ")";
    }

    public SplashSelectData(SplashListResponse splashListResponse, List<Long> list, SplashOrder localShowSplash, SplashOrder realShowSplash, boolean realShowJobSuccess, String realShowRequestId, List<SplashShowStrategy> list2, SplashOrder realTimeSplash) {
        this.splashListResponse = splashListResponse;
        this.trustedPegasusTopViewList = list;
        this.localShowSplash = localShowSplash;
        this.realShowSplash = realShowSplash;
        this.realShowJobSuccess = realShowJobSuccess;
        this.realShowRequestId = realShowRequestId;
        this.realShowStrategyList = list2;
        this.realTimeSplash = realTimeSplash;
    }

    public /* synthetic */ SplashSelectData(SplashListResponse splashListResponse, List list, SplashOrder splashOrder, SplashOrder splashOrder2, boolean z, String str, List list2, SplashOrder splashOrder3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : splashListResponse, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : splashOrder, (i & 8) != 0 ? null : splashOrder2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : list2, (i & BR.cover) == 0 ? splashOrder3 : null);
    }

    public final SplashListResponse getSplashListResponse() {
        return this.splashListResponse;
    }

    public final void setSplashListResponse(SplashListResponse splashListResponse) {
        this.splashListResponse = splashListResponse;
    }

    public final List<Long> getTrustedPegasusTopViewList() {
        return this.trustedPegasusTopViewList;
    }

    public final void setTrustedPegasusTopViewList(List<Long> list) {
        this.trustedPegasusTopViewList = list;
    }

    public final SplashOrder getLocalShowSplash() {
        return this.localShowSplash;
    }

    public final void setLocalShowSplash(SplashOrder splashOrder) {
        this.localShowSplash = splashOrder;
    }

    public final SplashOrder getRealShowSplash() {
        return this.realShowSplash;
    }

    public final void setRealShowSplash(SplashOrder splashOrder) {
        this.realShowSplash = splashOrder;
    }

    public final boolean getRealShowJobSuccess() {
        return this.realShowJobSuccess;
    }

    public final void setRealShowJobSuccess(boolean z) {
        this.realShowJobSuccess = z;
    }

    public final String getRealShowRequestId() {
        return this.realShowRequestId;
    }

    public final void setRealShowRequestId(String str) {
        this.realShowRequestId = str;
    }

    public final List<SplashShowStrategy> getRealShowStrategyList() {
        return this.realShowStrategyList;
    }

    public final void setRealShowStrategyList(List<SplashShowStrategy> list) {
        this.realShowStrategyList = list;
    }

    public final SplashOrder getRealTimeSplash() {
        return this.realTimeSplash;
    }

    public final void setRealTimeSplash(SplashOrder splashOrder) {
        this.realTimeSplash = splashOrder;
    }

    public final boolean getTrustRealtimeShowTopView() {
        List<Long> list = this.trustedPegasusTopViewList;
        return (list != null && (list.isEmpty() ^ true)) || DDConfig.INSTANCE.getSplashTopViewBannerMixinExp();
    }
}