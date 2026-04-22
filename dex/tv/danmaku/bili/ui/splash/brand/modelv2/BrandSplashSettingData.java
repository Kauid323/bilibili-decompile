package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingData;", "", "tabs", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;", "setOption", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSetOption;", "<init>", "(Ljava/util/List;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSetOption;)V", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "getSetOption", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSetOption;", "setSetOption", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSetOption;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingData {
    public static final int $stable = 8;
    @SerializedName("set_option")
    private BrandSplashSetOption setOption;
    @SerializedName("tabs")
    private List<BrandSplashSettingTab> tabs;

    public BrandSplashSettingData() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandSplashSettingData copy$default(BrandSplashSettingData brandSplashSettingData, List list, BrandSplashSetOption brandSplashSetOption, int i, Object obj) {
        if ((i & 1) != 0) {
            list = brandSplashSettingData.tabs;
        }
        if ((i & 2) != 0) {
            brandSplashSetOption = brandSplashSettingData.setOption;
        }
        return brandSplashSettingData.copy(list, brandSplashSetOption);
    }

    public final List<BrandSplashSettingTab> component1() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.tabs);
    }

    public final BrandSplashSetOption component2() {
        return this.setOption;
    }

    public final BrandSplashSettingData copy(List<BrandSplashSettingTab> list, BrandSplashSetOption brandSplashSetOption) {
        List unmodifiable = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(unmodifiable, "tabs");
        return new BrandSplashSettingData(unmodifiable, brandSplashSetOption);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSettingData) {
            BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) obj;
            return Intrinsics.areEqual(this.tabs, brandSplashSettingData.tabs) && Intrinsics.areEqual(this.setOption, brandSplashSettingData.setOption);
        }
        return false;
    }

    public int hashCode() {
        return (this.tabs.hashCode() * 31) + (this.setOption == null ? 0 : this.setOption.hashCode());
    }

    public String toString() {
        List<BrandSplashSettingTab> list = this.tabs;
        return "BrandSplashSettingData(tabs=" + list + ", setOption=" + this.setOption + ")";
    }

    public BrandSplashSettingData(List<BrandSplashSettingTab> list, BrandSplashSetOption setOption) {
        List tabs = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        this.tabs = tabs;
        this.setOption = setOption;
    }

    public /* synthetic */ BrandSplashSettingData(List list, BrandSplashSetOption brandSplashSetOption, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : brandSplashSetOption);
    }

    public final List<BrandSplashSettingTab> getTabs() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.tabs);
    }

    public final void setTabs(List<BrandSplashSettingTab> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tabs = list;
    }

    public final BrandSplashSetOption getSetOption() {
        return this.setOption;
    }

    public final void setSetOption(BrandSplashSetOption brandSplashSetOption) {
        this.setOption = brandSplashSetOption;
    }
}