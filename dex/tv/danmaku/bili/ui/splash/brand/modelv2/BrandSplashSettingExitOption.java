package tv.danmaku.bili.ui.splash.brand.modelv2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingExitOption.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingExitOption;", "", "text", "", "yes", "no", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getYes", "setYes", "getNo", "setNo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingExitOption {
    public static final int $stable = 8;
    @SerializedName("no")
    private String no;
    @SerializedName("text")
    private String text;
    @SerializedName("yes")
    private String yes;

    public BrandSplashSettingExitOption() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BrandSplashSettingExitOption copy$default(BrandSplashSettingExitOption brandSplashSettingExitOption, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandSplashSettingExitOption.text;
        }
        if ((i & 2) != 0) {
            str2 = brandSplashSettingExitOption.yes;
        }
        if ((i & 4) != 0) {
            str3 = brandSplashSettingExitOption.no;
        }
        return brandSplashSettingExitOption.copy(str, str2, str3);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.yes;
    }

    public final String component3() {
        return this.no;
    }

    public final BrandSplashSettingExitOption copy(String str, String str2, String str3) {
        return new BrandSplashSettingExitOption(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSettingExitOption) {
            BrandSplashSettingExitOption brandSplashSettingExitOption = (BrandSplashSettingExitOption) obj;
            return Intrinsics.areEqual(this.text, brandSplashSettingExitOption.text) && Intrinsics.areEqual(this.yes, brandSplashSettingExitOption.yes) && Intrinsics.areEqual(this.no, brandSplashSettingExitOption.no);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.text == null ? 0 : this.text.hashCode()) * 31) + (this.yes == null ? 0 : this.yes.hashCode())) * 31) + (this.no != null ? this.no.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        String str2 = this.yes;
        return "BrandSplashSettingExitOption(text=" + str + ", yes=" + str2 + ", no=" + this.no + ")";
    }

    public BrandSplashSettingExitOption(String text, String yes, String no) {
        this.text = text;
        this.yes = yes;
        this.no = no;
    }

    public /* synthetic */ BrandSplashSettingExitOption(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getYes() {
        return this.yes;
    }

    public final void setYes(String str) {
        this.yes = str;
    }

    public final String getNo() {
        return this.no;
    }

    public final void setNo(String str) {
        this.no = str;
    }
}