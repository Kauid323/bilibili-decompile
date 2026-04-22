package tv.danmaku.bili.splash.ad.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: SplashMiddlePageInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006$"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashMiddlePageInfo;", "", "logo", "", ReportUtilKt.POS_TITLE, "desc", "showLive", "", "btnText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getLogo", "()Ljava/lang/String;", "setLogo", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getDesc", "setDesc", "getShowLive", "()I", "setShowLive", "(I)V", "getBtnText", "setBtnText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashMiddlePageInfo {
    public static final int $stable = 8;
    @SerializedName("btn_text")
    private String btnText;
    @SerializedName("desc")
    private String desc;
    @SerializedName("logo")
    private String logo;
    @SerializedName("show_live")
    private int showLive;
    @SerializedName(ReportUtilKt.POS_TITLE)
    private String title;

    public SplashMiddlePageInfo() {
        this(null, null, null, 0, null, 31, null);
    }

    public static /* synthetic */ SplashMiddlePageInfo copy$default(SplashMiddlePageInfo splashMiddlePageInfo, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = splashMiddlePageInfo.logo;
        }
        if ((i2 & 2) != 0) {
            str2 = splashMiddlePageInfo.title;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = splashMiddlePageInfo.desc;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = splashMiddlePageInfo.showLive;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = splashMiddlePageInfo.btnText;
        }
        return splashMiddlePageInfo.copy(str, str5, str6, i3, str4);
    }

    public final String component1() {
        return this.logo;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.desc;
    }

    public final int component4() {
        return this.showLive;
    }

    public final String component5() {
        return this.btnText;
    }

    public final SplashMiddlePageInfo copy(String str, String str2, String str3, int i, String str4) {
        return new SplashMiddlePageInfo(str, str2, str3, i, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashMiddlePageInfo) {
            SplashMiddlePageInfo splashMiddlePageInfo = (SplashMiddlePageInfo) obj;
            return Intrinsics.areEqual(this.logo, splashMiddlePageInfo.logo) && Intrinsics.areEqual(this.title, splashMiddlePageInfo.title) && Intrinsics.areEqual(this.desc, splashMiddlePageInfo.desc) && this.showLive == splashMiddlePageInfo.showLive && Intrinsics.areEqual(this.btnText, splashMiddlePageInfo.btnText);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.logo == null ? 0 : this.logo.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + this.showLive) * 31) + (this.btnText != null ? this.btnText.hashCode() : 0);
    }

    public String toString() {
        String str = this.logo;
        String str2 = this.title;
        String str3 = this.desc;
        int i = this.showLive;
        return "SplashMiddlePageInfo(logo=" + str + ", title=" + str2 + ", desc=" + str3 + ", showLive=" + i + ", btnText=" + this.btnText + ")";
    }

    public SplashMiddlePageInfo(String logo, String title, String desc, int showLive, String btnText) {
        this.logo = logo;
        this.title = title;
        this.desc = desc;
        this.showLive = showLive;
        this.btnText = btnText;
    }

    public /* synthetic */ SplashMiddlePageInfo(String str, String str2, String str3, int i, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : str4);
    }

    public final String getLogo() {
        return this.logo;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final int getShowLive() {
        return this.showLive;
    }

    public final void setShowLive(int i) {
        this.showLive = i;
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final void setBtnText(String str) {
        this.btnText = str;
    }
}