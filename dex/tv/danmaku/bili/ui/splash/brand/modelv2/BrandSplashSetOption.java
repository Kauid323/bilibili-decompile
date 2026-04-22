package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.vip.JsBridgeCallHandlerVip;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;

/* compiled from: BrandSplashSetOption.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0085\u0001\u0010?\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0006HÖ\u0001J\t\u0010D\u001a\u00020\bHÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R \u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R \u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R \u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006E"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSetOption;", "", "config", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingConfig;", "maxSelected", "", "maxPrompt", "", "defaultPrompt", "selectedPrompt", "overflowToast", "emptyToast", "exitDialog", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashExitDialog;", "bottomSaveButton", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingButtonSaveButton;", "vipConfig", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingVipConfig;", "<init>", "(Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashExitDialog;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingButtonSaveButton;Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingVipConfig;)V", "getConfig", "()Ljava/util/List;", "setConfig", "(Ljava/util/List;)V", "getMaxSelected", "()I", "setMaxSelected", "(I)V", "getMaxPrompt", "()Ljava/lang/String;", "setMaxPrompt", "(Ljava/lang/String;)V", "getDefaultPrompt", "setDefaultPrompt", "getSelectedPrompt", "setSelectedPrompt", "getOverflowToast", "setOverflowToast", "getEmptyToast", "setEmptyToast", "getExitDialog", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashExitDialog;", "setExitDialog", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashExitDialog;)V", "getBottomSaveButton", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingButtonSaveButton;", "setBottomSaveButton", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingButtonSaveButton;)V", "getVipConfig", "()Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingVipConfig;", "setVipConfig", "(Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingVipConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSetOption {
    public static final int $stable = 8;
    @SerializedName("bottom_save_button")
    private BrandSplashSettingButtonSaveButton bottomSaveButton;
    @SerializedName("config")
    private List<BrandSplashSettingConfig> config;
    @SerializedName("default_prompt")
    private String defaultPrompt;
    @SerializedName("empty_toast")
    private String emptyToast;
    @SerializedName("exit_dialog")
    private BrandSplashExitDialog exitDialog;
    @SerializedName("max_prompt")
    private String maxPrompt;
    @SerializedName("max_selected")
    private int maxSelected;
    @SerializedName("overflow_toast")
    private String overflowToast;
    @SerializedName("selected_prompt")
    private String selectedPrompt;
    @SerializedName(JsBridgeCallHandlerVip.VIP_NAME_SPACE)
    private BrandSplashSettingVipConfig vipConfig;

    public BrandSplashSetOption() {
        this(null, 0, null, null, null, null, null, null, null, null, IjkMediaPlayerTracker.BLIJK_EV_BUFFERING_END, null);
    }

    public final List<BrandSplashSettingConfig> component1() {
        return this.config;
    }

    public final BrandSplashSettingVipConfig component10() {
        return this.vipConfig;
    }

    public final int component2() {
        return this.maxSelected;
    }

    public final String component3() {
        return this.maxPrompt;
    }

    public final String component4() {
        return this.defaultPrompt;
    }

    public final String component5() {
        return this.selectedPrompt;
    }

    public final String component6() {
        return this.overflowToast;
    }

    public final String component7() {
        return this.emptyToast;
    }

    public final BrandSplashExitDialog component8() {
        return this.exitDialog;
    }

    public final BrandSplashSettingButtonSaveButton component9() {
        return this.bottomSaveButton;
    }

    public final BrandSplashSetOption copy(List<BrandSplashSettingConfig> list, int i, String str, String str2, String str3, String str4, String str5, BrandSplashExitDialog brandSplashExitDialog, BrandSplashSettingButtonSaveButton brandSplashSettingButtonSaveButton, BrandSplashSettingVipConfig brandSplashSettingVipConfig) {
        return new BrandSplashSetOption(list, i, str, str2, str3, str4, str5, brandSplashExitDialog, brandSplashSettingButtonSaveButton, brandSplashSettingVipConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSetOption) {
            BrandSplashSetOption brandSplashSetOption = (BrandSplashSetOption) obj;
            return Intrinsics.areEqual(this.config, brandSplashSetOption.config) && this.maxSelected == brandSplashSetOption.maxSelected && Intrinsics.areEqual(this.maxPrompt, brandSplashSetOption.maxPrompt) && Intrinsics.areEqual(this.defaultPrompt, brandSplashSetOption.defaultPrompt) && Intrinsics.areEqual(this.selectedPrompt, brandSplashSetOption.selectedPrompt) && Intrinsics.areEqual(this.overflowToast, brandSplashSetOption.overflowToast) && Intrinsics.areEqual(this.emptyToast, brandSplashSetOption.emptyToast) && Intrinsics.areEqual(this.exitDialog, brandSplashSetOption.exitDialog) && Intrinsics.areEqual(this.bottomSaveButton, brandSplashSetOption.bottomSaveButton) && Intrinsics.areEqual(this.vipConfig, brandSplashSetOption.vipConfig);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((this.config == null ? 0 : this.config.hashCode()) * 31) + this.maxSelected) * 31) + (this.maxPrompt == null ? 0 : this.maxPrompt.hashCode())) * 31) + (this.defaultPrompt == null ? 0 : this.defaultPrompt.hashCode())) * 31) + (this.selectedPrompt == null ? 0 : this.selectedPrompt.hashCode())) * 31) + (this.overflowToast == null ? 0 : this.overflowToast.hashCode())) * 31) + (this.emptyToast == null ? 0 : this.emptyToast.hashCode())) * 31) + (this.exitDialog == null ? 0 : this.exitDialog.hashCode())) * 31) + (this.bottomSaveButton == null ? 0 : this.bottomSaveButton.hashCode())) * 31) + (this.vipConfig != null ? this.vipConfig.hashCode() : 0);
    }

    public String toString() {
        List<BrandSplashSettingConfig> list = this.config;
        int i = this.maxSelected;
        String str = this.maxPrompt;
        String str2 = this.defaultPrompt;
        String str3 = this.selectedPrompt;
        String str4 = this.overflowToast;
        String str5 = this.emptyToast;
        BrandSplashExitDialog brandSplashExitDialog = this.exitDialog;
        BrandSplashSettingButtonSaveButton brandSplashSettingButtonSaveButton = this.bottomSaveButton;
        return "BrandSplashSetOption(config=" + list + ", maxSelected=" + i + ", maxPrompt=" + str + ", defaultPrompt=" + str2 + ", selectedPrompt=" + str3 + ", overflowToast=" + str4 + ", emptyToast=" + str5 + ", exitDialog=" + brandSplashExitDialog + ", bottomSaveButton=" + brandSplashSettingButtonSaveButton + ", vipConfig=" + this.vipConfig + ")";
    }

    public BrandSplashSetOption(List<BrandSplashSettingConfig> list, int maxSelected, String maxPrompt, String defaultPrompt, String selectedPrompt, String overflowToast, String emptyToast, BrandSplashExitDialog exitDialog, BrandSplashSettingButtonSaveButton bottomSaveButton, BrandSplashSettingVipConfig vipConfig) {
        this.config = list;
        this.maxSelected = maxSelected;
        this.maxPrompt = maxPrompt;
        this.defaultPrompt = defaultPrompt;
        this.selectedPrompt = selectedPrompt;
        this.overflowToast = overflowToast;
        this.emptyToast = emptyToast;
        this.exitDialog = exitDialog;
        this.bottomSaveButton = bottomSaveButton;
        this.vipConfig = vipConfig;
    }

    public /* synthetic */ BrandSplashSetOption(List list, int i, String str, String str2, String str3, String str4, String str5, BrandSplashExitDialog brandSplashExitDialog, BrandSplashSettingButtonSaveButton brandSplashSettingButtonSaveButton, BrandSplashSettingVipConfig brandSplashSettingVipConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? 12 : i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : brandSplashExitDialog, (i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : brandSplashSettingButtonSaveButton, (i2 & 512) == 0 ? brandSplashSettingVipConfig : null);
    }

    public final List<BrandSplashSettingConfig> getConfig() {
        return this.config;
    }

    public final void setConfig(List<BrandSplashSettingConfig> list) {
        this.config = list;
    }

    public final int getMaxSelected() {
        return this.maxSelected;
    }

    public final void setMaxSelected(int i) {
        this.maxSelected = i;
    }

    public final String getMaxPrompt() {
        return this.maxPrompt;
    }

    public final void setMaxPrompt(String str) {
        this.maxPrompt = str;
    }

    public final String getDefaultPrompt() {
        return this.defaultPrompt;
    }

    public final void setDefaultPrompt(String str) {
        this.defaultPrompt = str;
    }

    public final String getSelectedPrompt() {
        return this.selectedPrompt;
    }

    public final void setSelectedPrompt(String str) {
        this.selectedPrompt = str;
    }

    public final String getOverflowToast() {
        return this.overflowToast;
    }

    public final void setOverflowToast(String str) {
        this.overflowToast = str;
    }

    public final String getEmptyToast() {
        return this.emptyToast;
    }

    public final void setEmptyToast(String str) {
        this.emptyToast = str;
    }

    public final BrandSplashExitDialog getExitDialog() {
        return this.exitDialog;
    }

    public final void setExitDialog(BrandSplashExitDialog brandSplashExitDialog) {
        this.exitDialog = brandSplashExitDialog;
    }

    public final BrandSplashSettingButtonSaveButton getBottomSaveButton() {
        return this.bottomSaveButton;
    }

    public final void setBottomSaveButton(BrandSplashSettingButtonSaveButton brandSplashSettingButtonSaveButton) {
        this.bottomSaveButton = brandSplashSettingButtonSaveButton;
    }

    public final BrandSplashSettingVipConfig getVipConfig() {
        return this.vipConfig;
    }

    public final void setVipConfig(BrandSplashSettingVipConfig brandSplashSettingVipConfig) {
        this.vipConfig = brandSplashSettingVipConfig;
    }
}