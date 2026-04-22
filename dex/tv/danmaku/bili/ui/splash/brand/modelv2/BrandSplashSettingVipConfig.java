package tv.danmaku.bili.ui.splash.brand.modelv2;

import BottomSheetItemData$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingVipConfig.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingVipConfig;", "", "locked", "", "vipOrderPromotion", "vipForbidden", "<init>", "(ZZZ)V", "getLocked", "()Z", "setLocked", "(Z)V", "getVipOrderPromotion", "setVipOrderPromotion", "getVipForbidden", "setVipForbidden", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingVipConfig {
    public static final int $stable = 8;
    @SerializedName("locked")
    private boolean locked;
    @SerializedName("vip_forbidden")
    private boolean vipForbidden;
    @SerializedName("vip_order_promotion")
    private boolean vipOrderPromotion;

    public BrandSplashSettingVipConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ BrandSplashSettingVipConfig copy$default(BrandSplashSettingVipConfig brandSplashSettingVipConfig, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = brandSplashSettingVipConfig.locked;
        }
        if ((i & 2) != 0) {
            z2 = brandSplashSettingVipConfig.vipOrderPromotion;
        }
        if ((i & 4) != 0) {
            z3 = brandSplashSettingVipConfig.vipForbidden;
        }
        return brandSplashSettingVipConfig.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.locked;
    }

    public final boolean component2() {
        return this.vipOrderPromotion;
    }

    public final boolean component3() {
        return this.vipForbidden;
    }

    public final BrandSplashSettingVipConfig copy(boolean z, boolean z2, boolean z3) {
        return new BrandSplashSettingVipConfig(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSettingVipConfig) {
            BrandSplashSettingVipConfig brandSplashSettingVipConfig = (BrandSplashSettingVipConfig) obj;
            return this.locked == brandSplashSettingVipConfig.locked && this.vipOrderPromotion == brandSplashSettingVipConfig.vipOrderPromotion && this.vipForbidden == brandSplashSettingVipConfig.vipForbidden;
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.locked) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.vipOrderPromotion)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.vipForbidden);
    }

    public String toString() {
        boolean z = this.locked;
        boolean z2 = this.vipOrderPromotion;
        return "BrandSplashSettingVipConfig(locked=" + z + ", vipOrderPromotion=" + z2 + ", vipForbidden=" + this.vipForbidden + ")";
    }

    public BrandSplashSettingVipConfig(boolean locked, boolean vipOrderPromotion, boolean vipForbidden) {
        this.locked = locked;
        this.vipOrderPromotion = vipOrderPromotion;
        this.vipForbidden = vipForbidden;
    }

    public /* synthetic */ BrandSplashSettingVipConfig(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final void setLocked(boolean z) {
        this.locked = z;
    }

    public final boolean getVipOrderPromotion() {
        return this.vipOrderPromotion;
    }

    public final void setVipOrderPromotion(boolean z) {
        this.vipOrderPromotion = z;
    }

    public final boolean getVipForbidden() {
        return this.vipForbidden;
    }

    public final void setVipForbidden(boolean z) {
        this.vipForbidden = z;
    }
}