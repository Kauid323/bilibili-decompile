package tv.danmaku.bili.ui.splash.brand.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadBrandData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001d¨\u0006+"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/model/PreloadBrandData;", "", "forcibly", "", "rule", "", "showList", "", "Ltv/danmaku/bili/ui/splash/brand/model/NormalBrandShow;", "beginTime", "", "endTime", "<init>", "(ZLjava/lang/String;Ljava/util/List;JJ)V", "getForcibly", "()Z", "setForcibly", "(Z)V", "getRule", "()Ljava/lang/String;", "setRule", "(Ljava/lang/String;)V", "getShowList", "()Ljava/util/List;", "setShowList", "(Ljava/util/List;)V", "getBeginTime", "()J", "setBeginTime", "(J)V", "getEndTime", "setEndTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadBrandData {
    public static final int $stable = 8;
    @SerializedName("begin_time")
    private long beginTime;
    @SerializedName(ChronosDanmakuSender.KEY_CMTIME_END)
    private long endTime;
    @SerializedName("forcibly")
    private boolean forcibly;
    @SerializedName("rule")
    private String rule;
    @SerializedName("show")
    private List<NormalBrandShow> showList;

    public PreloadBrandData() {
        this(false, null, null, 0L, 0L, 31, null);
    }

    public static /* synthetic */ PreloadBrandData copy$default(PreloadBrandData preloadBrandData, boolean z, String str, List list, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = preloadBrandData.forcibly;
        }
        if ((i & 2) != 0) {
            str = preloadBrandData.rule;
        }
        String str2 = str;
        List<NormalBrandShow> list2 = list;
        if ((i & 4) != 0) {
            list2 = preloadBrandData.showList;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            j = preloadBrandData.beginTime;
        }
        long j3 = j;
        if ((i & 16) != 0) {
            j2 = preloadBrandData.endTime;
        }
        return preloadBrandData.copy(z, str2, list3, j3, j2);
    }

    public final boolean component1() {
        return this.forcibly;
    }

    public final String component2() {
        return this.rule;
    }

    public final List<NormalBrandShow> component3() {
        return this.showList;
    }

    public final long component4() {
        return this.beginTime;
    }

    public final long component5() {
        return this.endTime;
    }

    public final PreloadBrandData copy(boolean z, String str, List<NormalBrandShow> list, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "rule");
        return new PreloadBrandData(z, str, list, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreloadBrandData) {
            PreloadBrandData preloadBrandData = (PreloadBrandData) obj;
            return this.forcibly == preloadBrandData.forcibly && Intrinsics.areEqual(this.rule, preloadBrandData.rule) && Intrinsics.areEqual(this.showList, preloadBrandData.showList) && this.beginTime == preloadBrandData.beginTime && this.endTime == preloadBrandData.endTime;
        }
        return false;
    }

    public int hashCode() {
        return (((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forcibly) * 31) + this.rule.hashCode()) * 31) + (this.showList == null ? 0 : this.showList.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.beginTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.endTime);
    }

    public String toString() {
        boolean z = this.forcibly;
        String str = this.rule;
        List<NormalBrandShow> list = this.showList;
        long j = this.beginTime;
        return "PreloadBrandData(forcibly=" + z + ", rule=" + str + ", showList=" + list + ", beginTime=" + j + ", endTime=" + this.endTime + ")";
    }

    public PreloadBrandData(boolean forcibly, String rule, List<NormalBrandShow> list, long beginTime, long endTime) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        this.forcibly = forcibly;
        this.rule = rule;
        this.showList = list;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public /* synthetic */ PreloadBrandData(boolean z, String str, List list, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? BrandSplashDataKt.ORDER_RULE : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? 0L : j, (i & 16) == 0 ? j2 : 0L);
    }

    public final boolean getForcibly() {
        return this.forcibly;
    }

    public final void setForcibly(boolean z) {
        this.forcibly = z;
    }

    public final String getRule() {
        return this.rule;
    }

    public final void setRule(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rule = str;
    }

    public final List<NormalBrandShow> getShowList() {
        return this.showList;
    }

    public final void setShowList(List<NormalBrandShow> list) {
        this.showList = list;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final void setBeginTime(long j) {
        this.beginTime = j;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }
}