package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingMoreData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingMoreData;", "", "tab", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;", "<init>", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;)V", "getTab", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;", "setTab", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingMoreData {
    public static final int $stable = 8;
    @SerializedName("tab")
    private BrandSplashSettingTab tab;

    public BrandSplashSettingMoreData() {
        this(null, 1, null);
    }

    public static /* synthetic */ BrandSplashSettingMoreData copy$default(BrandSplashSettingMoreData brandSplashSettingMoreData, BrandSplashSettingTab brandSplashSettingTab, int i, Object obj) {
        if ((i & 1) != 0) {
            brandSplashSettingTab = brandSplashSettingMoreData.tab;
        }
        return brandSplashSettingMoreData.copy(brandSplashSettingTab);
    }

    public final BrandSplashSettingTab component1() {
        return this.tab;
    }

    public final BrandSplashSettingMoreData copy(BrandSplashSettingTab brandSplashSettingTab) {
        return new BrandSplashSettingMoreData(brandSplashSettingTab);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrandSplashSettingMoreData) && Intrinsics.areEqual(this.tab, ((BrandSplashSettingMoreData) obj).tab);
    }

    public int hashCode() {
        if (this.tab == null) {
            return 0;
        }
        return this.tab.hashCode();
    }

    public String toString() {
        return "BrandSplashSettingMoreData(tab=" + this.tab + ")";
    }

    public BrandSplashSettingMoreData(BrandSplashSettingTab tab) {
        this.tab = tab;
    }

    public /* synthetic */ BrandSplashSettingMoreData(BrandSplashSettingTab brandSplashSettingTab, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : brandSplashSettingTab);
    }

    public final BrandSplashSettingTab getTab() {
        return this.tab;
    }

    public final void setTab(BrandSplashSettingTab brandSplashSettingTab) {
        this.tab = brandSplashSettingTab;
    }
}