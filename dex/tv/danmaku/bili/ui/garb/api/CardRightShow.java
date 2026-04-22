package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J}\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00060"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "", "isHeadPic", "", "isBannerBg", "headTagUrl", "", "bannerTagUrl", "headPicToast", "bannerBgToast", "headExpireFormat", "bannerExpireFormat", "useTagUrl", "useToast", "useMenus", "", "Ltv/danmaku/bili/ui/garb/api/UseMenu;", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "()I", "getHeadTagUrl", "()Ljava/lang/String;", "getBannerTagUrl", "getHeadPicToast", "getBannerBgToast", "getHeadExpireFormat", "getBannerExpireFormat", "getUseTagUrl", "getUseToast", "getUseMenus", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CardRightShow {
    public static final int $stable = 8;
    @SerializedName("banner_bg_toast")
    private final String bannerBgToast;
    @SerializedName("banner_expire_format")
    private final String bannerExpireFormat;
    @SerializedName("banner_tag_url")
    private final String bannerTagUrl;
    @SerializedName("head_expire_format")
    private final String headExpireFormat;
    @SerializedName("head_pic_toast")
    private final String headPicToast;
    @SerializedName("head_tag_url")
    private final String headTagUrl;
    @SerializedName("is_banner_bg")
    private final int isBannerBg;
    @SerializedName("is_head_pic")
    private final int isHeadPic;
    @SerializedName("number_menus")
    private final List<UseMenu> useMenus;
    @SerializedName("use_tag_url")
    private final String useTagUrl;
    @SerializedName("use_toast")
    private final String useToast;

    public final int component1() {
        return this.isHeadPic;
    }

    public final String component10() {
        return this.useToast;
    }

    public final List<UseMenu> component11() {
        return this.useMenus;
    }

    public final int component2() {
        return this.isBannerBg;
    }

    public final String component3() {
        return this.headTagUrl;
    }

    public final String component4() {
        return this.bannerTagUrl;
    }

    public final String component5() {
        return this.headPicToast;
    }

    public final String component6() {
        return this.bannerBgToast;
    }

    public final String component7() {
        return this.headExpireFormat;
    }

    public final String component8() {
        return this.bannerExpireFormat;
    }

    public final String component9() {
        return this.useTagUrl;
    }

    public final CardRightShow copy(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List<UseMenu> list) {
        Intrinsics.checkNotNullParameter(str, "headTagUrl");
        Intrinsics.checkNotNullParameter(str2, "bannerTagUrl");
        Intrinsics.checkNotNullParameter(str3, "headPicToast");
        Intrinsics.checkNotNullParameter(str4, "bannerBgToast");
        Intrinsics.checkNotNullParameter(str5, "headExpireFormat");
        Intrinsics.checkNotNullParameter(str6, "bannerExpireFormat");
        Intrinsics.checkNotNullParameter(str7, "useTagUrl");
        Intrinsics.checkNotNullParameter(str8, "useToast");
        Intrinsics.checkNotNullParameter(list, "useMenus");
        return new CardRightShow(i, i2, str, str2, str3, str4, str5, str6, str7, str8, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardRightShow) {
            CardRightShow cardRightShow = (CardRightShow) obj;
            return this.isHeadPic == cardRightShow.isHeadPic && this.isBannerBg == cardRightShow.isBannerBg && Intrinsics.areEqual(this.headTagUrl, cardRightShow.headTagUrl) && Intrinsics.areEqual(this.bannerTagUrl, cardRightShow.bannerTagUrl) && Intrinsics.areEqual(this.headPicToast, cardRightShow.headPicToast) && Intrinsics.areEqual(this.bannerBgToast, cardRightShow.bannerBgToast) && Intrinsics.areEqual(this.headExpireFormat, cardRightShow.headExpireFormat) && Intrinsics.areEqual(this.bannerExpireFormat, cardRightShow.bannerExpireFormat) && Intrinsics.areEqual(this.useTagUrl, cardRightShow.useTagUrl) && Intrinsics.areEqual(this.useToast, cardRightShow.useToast) && Intrinsics.areEqual(this.useMenus, cardRightShow.useMenus);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((this.isHeadPic * 31) + this.isBannerBg) * 31) + this.headTagUrl.hashCode()) * 31) + this.bannerTagUrl.hashCode()) * 31) + this.headPicToast.hashCode()) * 31) + this.bannerBgToast.hashCode()) * 31) + this.headExpireFormat.hashCode()) * 31) + this.bannerExpireFormat.hashCode()) * 31) + this.useTagUrl.hashCode()) * 31) + this.useToast.hashCode()) * 31) + this.useMenus.hashCode();
    }

    public String toString() {
        int i = this.isHeadPic;
        int i2 = this.isBannerBg;
        String str = this.headTagUrl;
        String str2 = this.bannerTagUrl;
        String str3 = this.headPicToast;
        String str4 = this.bannerBgToast;
        String str5 = this.headExpireFormat;
        String str6 = this.bannerExpireFormat;
        String str7 = this.useTagUrl;
        String str8 = this.useToast;
        return "CardRightShow(isHeadPic=" + i + ", isBannerBg=" + i2 + ", headTagUrl=" + str + ", bannerTagUrl=" + str2 + ", headPicToast=" + str3 + ", bannerBgToast=" + str4 + ", headExpireFormat=" + str5 + ", bannerExpireFormat=" + str6 + ", useTagUrl=" + str7 + ", useToast=" + str8 + ", useMenus=" + this.useMenus + ")";
    }

    public CardRightShow(int isHeadPic, int isBannerBg, String headTagUrl, String bannerTagUrl, String headPicToast, String bannerBgToast, String headExpireFormat, String bannerExpireFormat, String useTagUrl, String useToast, List<UseMenu> list) {
        Intrinsics.checkNotNullParameter(headTagUrl, "headTagUrl");
        Intrinsics.checkNotNullParameter(bannerTagUrl, "bannerTagUrl");
        Intrinsics.checkNotNullParameter(headPicToast, "headPicToast");
        Intrinsics.checkNotNullParameter(bannerBgToast, "bannerBgToast");
        Intrinsics.checkNotNullParameter(headExpireFormat, "headExpireFormat");
        Intrinsics.checkNotNullParameter(bannerExpireFormat, "bannerExpireFormat");
        Intrinsics.checkNotNullParameter(useTagUrl, "useTagUrl");
        Intrinsics.checkNotNullParameter(useToast, "useToast");
        Intrinsics.checkNotNullParameter(list, "useMenus");
        this.isHeadPic = isHeadPic;
        this.isBannerBg = isBannerBg;
        this.headTagUrl = headTagUrl;
        this.bannerTagUrl = bannerTagUrl;
        this.headPicToast = headPicToast;
        this.bannerBgToast = bannerBgToast;
        this.headExpireFormat = headExpireFormat;
        this.bannerExpireFormat = bannerExpireFormat;
        this.useTagUrl = useTagUrl;
        this.useToast = useToast;
        this.useMenus = list;
    }

    public final int isHeadPic() {
        return this.isHeadPic;
    }

    public final int isBannerBg() {
        return this.isBannerBg;
    }

    public final String getHeadTagUrl() {
        return this.headTagUrl;
    }

    public final String getBannerTagUrl() {
        return this.bannerTagUrl;
    }

    public final String getHeadPicToast() {
        return this.headPicToast;
    }

    public final String getBannerBgToast() {
        return this.bannerBgToast;
    }

    public final String getHeadExpireFormat() {
        return this.headExpireFormat;
    }

    public final String getBannerExpireFormat() {
        return this.bannerExpireFormat;
    }

    public final String getUseTagUrl() {
        return this.useTagUrl;
    }

    public final String getUseToast() {
        return this.useToast;
    }

    public final List<UseMenu> getUseMenus() {
        return this.useMenus;
    }
}