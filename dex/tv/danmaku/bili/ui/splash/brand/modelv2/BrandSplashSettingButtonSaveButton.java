package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingButtonSaveButton.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingButtonSaveButton;", "", "text", "", "successToast", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getSuccessToast", "setSuccessToast", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingButtonSaveButton {
    public static final int $stable = 8;
    @SerializedName("success_toast")
    private String successToast;
    @SerializedName("text")
    private String text;

    public BrandSplashSettingButtonSaveButton() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ BrandSplashSettingButtonSaveButton copy$default(BrandSplashSettingButtonSaveButton brandSplashSettingButtonSaveButton, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandSplashSettingButtonSaveButton.text;
        }
        if ((i & 2) != 0) {
            str2 = brandSplashSettingButtonSaveButton.successToast;
        }
        return brandSplashSettingButtonSaveButton.copy(str, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.successToast;
    }

    public final BrandSplashSettingButtonSaveButton copy(String str, String str2) {
        return new BrandSplashSettingButtonSaveButton(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSettingButtonSaveButton) {
            BrandSplashSettingButtonSaveButton brandSplashSettingButtonSaveButton = (BrandSplashSettingButtonSaveButton) obj;
            return Intrinsics.areEqual(this.text, brandSplashSettingButtonSaveButton.text) && Intrinsics.areEqual(this.successToast, brandSplashSettingButtonSaveButton.successToast);
        }
        return false;
    }

    public int hashCode() {
        return ((this.text == null ? 0 : this.text.hashCode()) * 31) + (this.successToast != null ? this.successToast.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        return "BrandSplashSettingButtonSaveButton(text=" + str + ", successToast=" + this.successToast + ")";
    }

    public BrandSplashSettingButtonSaveButton(String text, String successToast) {
        this.text = text;
        this.successToast = successToast;
    }

    public /* synthetic */ BrandSplashSettingButtonSaveButton(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getSuccessToast() {
        return this.successToast;
    }

    public final void setSuccessToast(String str) {
        this.successToast = str;
    }
}