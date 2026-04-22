package tv.danmaku.bili.ui.splash.brand.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.common.search.QueryItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: BrandSplashData.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b.\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\t\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\u0013\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u0013\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\tHÆ\u0003J\u0013\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\tHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003J\t\u00109\u001a\u00020\u0012HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008b\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\t2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0012HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R(\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001d¨\u0006@"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/model/BrandSplashData;", "", "pullInterval", "", "rule", "", "forcibly", "", "showList", "", "Ltv/danmaku/bili/ui/splash/brand/model/NormalBrandShow;", "brandList", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "preloadList", "Ltv/danmaku/bili/ui/splash/brand/model/PreloadBrandData;", "queryList", "Ltv/danmaku/bili/ui/splash/common/search/QueryItem;", "forceShowTimes", "", "forceShowHash", "<init>", "(JLjava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "getPullInterval", "()J", "setPullInterval", "(J)V", "getRule", "()Ljava/lang/String;", "setRule", "(Ljava/lang/String;)V", "getForcibly", "()Z", "setForcibly", "(Z)V", "getShowList", "()Ljava/util/List;", "setShowList", "(Ljava/util/List;)V", "getBrandList", "setBrandList", "getPreloadList", "setPreloadList", "getQueryList", "setQueryList", "getForceShowTimes", "()I", "setForceShowTimes", "(I)V", "getForceShowHash", "setForceShowHash", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashData {
    public static final int $stable = 8;
    @SerializedName("list")
    private List<BrandSplash> brandList;
    @SerializedName("show_hash")
    private String forceShowHash;
    @SerializedName("force_show_times")
    private int forceShowTimes;
    @SerializedName("forcibly")
    private boolean forcibly;
    @SerializedName("preload")
    private List<PreloadBrandData> preloadList;
    @SerializedName("pull_interval")
    private long pullInterval;
    @SerializedName("query_list")
    private List<QueryItem> queryList;
    @SerializedName("rule")
    private String rule;
    @SerializedName("show")
    private List<NormalBrandShow> showList;

    public BrandSplashData() {
        this(0L, null, false, null, null, null, null, 0, null, 511, null);
    }

    public final long component1() {
        return this.pullInterval;
    }

    public final String component2() {
        return this.rule;
    }

    public final boolean component3() {
        return this.forcibly;
    }

    public final List<NormalBrandShow> component4() {
        return this.showList;
    }

    public final List<BrandSplash> component5() {
        return this.brandList;
    }

    public final List<PreloadBrandData> component6() {
        return this.preloadList;
    }

    public final List<QueryItem> component7() {
        return this.queryList;
    }

    public final int component8() {
        return this.forceShowTimes;
    }

    public final String component9() {
        return this.forceShowHash;
    }

    public final BrandSplashData copy(long j, String str, boolean z, List<NormalBrandShow> list, List<BrandSplash> list2, List<PreloadBrandData> list3, List<QueryItem> list4, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "rule");
        return new BrandSplashData(j, str, z, list, list2, list3, list4, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashData) {
            BrandSplashData brandSplashData = (BrandSplashData) obj;
            return this.pullInterval == brandSplashData.pullInterval && Intrinsics.areEqual(this.rule, brandSplashData.rule) && this.forcibly == brandSplashData.forcibly && Intrinsics.areEqual(this.showList, brandSplashData.showList) && Intrinsics.areEqual(this.brandList, brandSplashData.brandList) && Intrinsics.areEqual(this.preloadList, brandSplashData.preloadList) && Intrinsics.areEqual(this.queryList, brandSplashData.queryList) && this.forceShowTimes == brandSplashData.forceShowTimes && Intrinsics.areEqual(this.forceShowHash, brandSplashData.forceShowHash);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.pullInterval) * 31) + this.rule.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forcibly)) * 31) + (this.showList == null ? 0 : this.showList.hashCode())) * 31) + (this.brandList == null ? 0 : this.brandList.hashCode())) * 31) + (this.preloadList == null ? 0 : this.preloadList.hashCode())) * 31) + (this.queryList == null ? 0 : this.queryList.hashCode())) * 31) + this.forceShowTimes) * 31) + (this.forceShowHash != null ? this.forceShowHash.hashCode() : 0);
    }

    public String toString() {
        long j = this.pullInterval;
        String str = this.rule;
        boolean z = this.forcibly;
        List<NormalBrandShow> list = this.showList;
        List<BrandSplash> list2 = this.brandList;
        List<PreloadBrandData> list3 = this.preloadList;
        List<QueryItem> list4 = this.queryList;
        int i = this.forceShowTimes;
        return "BrandSplashData(pullInterval=" + j + ", rule=" + str + ", forcibly=" + z + ", showList=" + list + ", brandList=" + list2 + ", preloadList=" + list3 + ", queryList=" + list4 + ", forceShowTimes=" + i + ", forceShowHash=" + this.forceShowHash + ")";
    }

    public BrandSplashData(long pullInterval, String rule, boolean forcibly, List<NormalBrandShow> list, List<BrandSplash> list2, List<PreloadBrandData> list3, List<QueryItem> list4, int forceShowTimes, String forceShowHash) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        this.pullInterval = pullInterval;
        this.rule = rule;
        this.forcibly = forcibly;
        this.showList = list;
        this.brandList = list2;
        this.preloadList = list3;
        this.queryList = list4;
        this.forceShowTimes = forceShowTimes;
        this.forceShowHash = forceShowHash;
    }

    public /* synthetic */ BrandSplashData(long j, String str, boolean z, List list, List list2, List list3, List list4, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? BrandSplashDataKt.ORDER_RULE : str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : list2, (i2 & 32) != 0 ? null : list3, (i2 & 64) != 0 ? null : list4, (i2 & 128) == 0 ? i : 0, (i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0 ? str2 : null);
    }

    public final long getPullInterval() {
        return this.pullInterval;
    }

    public final void setPullInterval(long j) {
        this.pullInterval = j;
    }

    public final String getRule() {
        return this.rule;
    }

    public final void setRule(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rule = str;
    }

    public final boolean getForcibly() {
        return this.forcibly;
    }

    public final void setForcibly(boolean z) {
        this.forcibly = z;
    }

    public final List<NormalBrandShow> getShowList() {
        return this.showList;
    }

    public final void setShowList(List<NormalBrandShow> list) {
        this.showList = list;
    }

    public final List<BrandSplash> getBrandList() {
        return this.brandList;
    }

    public final void setBrandList(List<BrandSplash> list) {
        this.brandList = list;
    }

    public final List<PreloadBrandData> getPreloadList() {
        return this.preloadList;
    }

    public final void setPreloadList(List<PreloadBrandData> list) {
        this.preloadList = list;
    }

    public final List<QueryItem> getQueryList() {
        return this.queryList;
    }

    public final void setQueryList(List<QueryItem> list) {
        this.queryList = list;
    }

    public final int getForceShowTimes() {
        return this.forceShowTimes;
    }

    public final void setForceShowTimes(int i) {
        this.forceShowTimes = i;
    }

    public final String getForceShowHash() {
        return this.forceShowHash;
    }

    public final void setForceShowHash(String str) {
        this.forceShowHash = str;
    }
}