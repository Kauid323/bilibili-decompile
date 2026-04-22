package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashExitDialog.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashExitDialog;", "", "empty", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingExitOption;", "selected", "<init>", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingExitOption;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingExitOption;)V", "getEmpty", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingExitOption;", "setEmpty", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingExitOption;)V", "getSelected", "setSelected", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashExitDialog {
    public static final int $stable = 8;
    @SerializedName("empty")
    private BrandSplashSettingExitOption empty;
    @SerializedName("selected")
    private BrandSplashSettingExitOption selected;

    public BrandSplashExitDialog() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ BrandSplashExitDialog copy$default(BrandSplashExitDialog brandSplashExitDialog, BrandSplashSettingExitOption brandSplashSettingExitOption, BrandSplashSettingExitOption brandSplashSettingExitOption2, int i, Object obj) {
        if ((i & 1) != 0) {
            brandSplashSettingExitOption = brandSplashExitDialog.empty;
        }
        if ((i & 2) != 0) {
            brandSplashSettingExitOption2 = brandSplashExitDialog.selected;
        }
        return brandSplashExitDialog.copy(brandSplashSettingExitOption, brandSplashSettingExitOption2);
    }

    public final BrandSplashSettingExitOption component1() {
        return this.empty;
    }

    public final BrandSplashSettingExitOption component2() {
        return this.selected;
    }

    public final BrandSplashExitDialog copy(BrandSplashSettingExitOption brandSplashSettingExitOption, BrandSplashSettingExitOption brandSplashSettingExitOption2) {
        return new BrandSplashExitDialog(brandSplashSettingExitOption, brandSplashSettingExitOption2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashExitDialog) {
            BrandSplashExitDialog brandSplashExitDialog = (BrandSplashExitDialog) obj;
            return Intrinsics.areEqual(this.empty, brandSplashExitDialog.empty) && Intrinsics.areEqual(this.selected, brandSplashExitDialog.selected);
        }
        return false;
    }

    public int hashCode() {
        return ((this.empty == null ? 0 : this.empty.hashCode()) * 31) + (this.selected != null ? this.selected.hashCode() : 0);
    }

    public String toString() {
        BrandSplashSettingExitOption brandSplashSettingExitOption = this.empty;
        return "BrandSplashExitDialog(empty=" + brandSplashSettingExitOption + ", selected=" + this.selected + ")";
    }

    public BrandSplashExitDialog(BrandSplashSettingExitOption empty, BrandSplashSettingExitOption selected) {
        this.empty = empty;
        this.selected = selected;
    }

    public /* synthetic */ BrandSplashExitDialog(BrandSplashSettingExitOption brandSplashSettingExitOption, BrandSplashSettingExitOption brandSplashSettingExitOption2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : brandSplashSettingExitOption, (i & 2) != 0 ? null : brandSplashSettingExitOption2);
    }

    public final BrandSplashSettingExitOption getEmpty() {
        return this.empty;
    }

    public final void setEmpty(BrandSplashSettingExitOption brandSplashSettingExitOption) {
        this.empty = brandSplashSettingExitOption;
    }

    public final BrandSplashSettingExitOption getSelected() {
        return this.selected;
    }

    public final void setSelected(BrandSplashSettingExitOption brandSplashSettingExitOption) {
        this.selected = brandSplashSettingExitOption;
    }
}