package tv.danmaku.bili.ui.garb.api.collection;

import BottomSheetItemData$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliCollectionData.kt */
@Bson
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b>\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\fHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\fHÆ\u0003JÛ\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\fHÆ\u0001J\u0013\u0010H\u001a\u00020\f2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020KHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0016\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%¨\u0006M"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;", "", "topSettingJumpUrl", "", "allSettingJumpUrl", "skinJumpUrl", "emojiPackageJumpUrl", "spaceBackgroundJumpUrl", "pendantJumpUrl", "splashJumpUrl", "cardBackgroundJumpUrl", "cardBackgroundHasNew", "", "cardJumpUrl", "cardHasNew", "thumbUpJumpUrl", "loadingJumpUrl", "playIconJumpUrl", "garbAllJumpUrl", "garbMallJumpUrl", "widgetJumpUrl", "realGiftJumpUrl", "realGiftNewShowing", "nftJumpUrl", "nftHasNew", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "getTopSettingJumpUrl", "()Ljava/lang/String;", "getAllSettingJumpUrl", "getSkinJumpUrl", "getEmojiPackageJumpUrl", "getSpaceBackgroundJumpUrl", "getPendantJumpUrl", "getSplashJumpUrl", "getCardBackgroundJumpUrl", "getCardBackgroundHasNew", "()Z", "getCardJumpUrl", "getCardHasNew", "getThumbUpJumpUrl", "getLoadingJumpUrl", "getPlayIconJumpUrl", "getGarbAllJumpUrl", "getGarbMallJumpUrl", "getWidgetJumpUrl", "getRealGiftJumpUrl", "getRealGiftNewShowing", "getNftJumpUrl", "getNftHasNew", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliCollectionGlobalInfoSideBarData {
    public static final int $stable = 0;
    @SerializedName("all_setting_jump_url")
    private final String allSettingJumpUrl;
    @SerializedName("card_background_has_new")
    private final boolean cardBackgroundHasNew;
    @SerializedName("card_background_jump_url")
    private final String cardBackgroundJumpUrl;
    @SerializedName("card_has_new")
    private final boolean cardHasNew;
    @SerializedName("card_jump_url")
    private final String cardJumpUrl;
    @SerializedName("emoji_package_jump_url")
    private final String emojiPackageJumpUrl;
    @SerializedName("garb_all_jump_url")
    private final String garbAllJumpUrl;
    @SerializedName("garb_mall_jump_url")
    private final String garbMallJumpUrl;
    @SerializedName("loading_jump_url")
    private final String loadingJumpUrl;
    @SerializedName("nft_has_new")
    private final boolean nftHasNew;
    @SerializedName("nft_jump_url")
    private final String nftJumpUrl;
    @SerializedName("pendant_jump_url")
    private final String pendantJumpUrl;
    @SerializedName("play_icon_jump_url")
    private final String playIconJumpUrl;
    @SerializedName("real_gift_jump_url")
    private final String realGiftJumpUrl;
    @SerializedName("real_gift_has_new")
    private final boolean realGiftNewShowing;
    @SerializedName("skin_jump_url")
    private final String skinJumpUrl;
    @SerializedName("space_background_jump_url")
    private final String spaceBackgroundJumpUrl;
    @SerializedName("splash_jump_url")
    private final String splashJumpUrl;
    @SerializedName("thumb_up_jump_url")
    private final String thumbUpJumpUrl;
    @SerializedName("top_setting_jump_url")
    private final String topSettingJumpUrl;
    @SerializedName("widget_jump_url")
    private final String widgetJumpUrl;

    public final String component1() {
        return this.topSettingJumpUrl;
    }

    public final String component10() {
        return this.cardJumpUrl;
    }

    public final boolean component11() {
        return this.cardHasNew;
    }

    public final String component12() {
        return this.thumbUpJumpUrl;
    }

    public final String component13() {
        return this.loadingJumpUrl;
    }

    public final String component14() {
        return this.playIconJumpUrl;
    }

    public final String component15() {
        return this.garbAllJumpUrl;
    }

    public final String component16() {
        return this.garbMallJumpUrl;
    }

    public final String component17() {
        return this.widgetJumpUrl;
    }

    public final String component18() {
        return this.realGiftJumpUrl;
    }

    public final boolean component19() {
        return this.realGiftNewShowing;
    }

    public final String component2() {
        return this.allSettingJumpUrl;
    }

    public final String component20() {
        return this.nftJumpUrl;
    }

    public final boolean component21() {
        return this.nftHasNew;
    }

    public final String component3() {
        return this.skinJumpUrl;
    }

    public final String component4() {
        return this.emojiPackageJumpUrl;
    }

    public final String component5() {
        return this.spaceBackgroundJumpUrl;
    }

    public final String component6() {
        return this.pendantJumpUrl;
    }

    public final String component7() {
        return this.splashJumpUrl;
    }

    public final String component8() {
        return this.cardBackgroundJumpUrl;
    }

    public final boolean component9() {
        return this.cardBackgroundHasNew;
    }

    public final BiliCollectionGlobalInfoSideBarData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, boolean z2, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z3, String str17, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "topSettingJumpUrl");
        Intrinsics.checkNotNullParameter(str2, "allSettingJumpUrl");
        Intrinsics.checkNotNullParameter(str3, "skinJumpUrl");
        Intrinsics.checkNotNullParameter(str4, "emojiPackageJumpUrl");
        Intrinsics.checkNotNullParameter(str5, "spaceBackgroundJumpUrl");
        Intrinsics.checkNotNullParameter(str6, "pendantJumpUrl");
        Intrinsics.checkNotNullParameter(str7, "splashJumpUrl");
        Intrinsics.checkNotNullParameter(str8, "cardBackgroundJumpUrl");
        Intrinsics.checkNotNullParameter(str9, "cardJumpUrl");
        Intrinsics.checkNotNullParameter(str10, "thumbUpJumpUrl");
        Intrinsics.checkNotNullParameter(str11, "loadingJumpUrl");
        Intrinsics.checkNotNullParameter(str12, "playIconJumpUrl");
        Intrinsics.checkNotNullParameter(str13, "garbAllJumpUrl");
        Intrinsics.checkNotNullParameter(str14, "garbMallJumpUrl");
        Intrinsics.checkNotNullParameter(str15, "widgetJumpUrl");
        Intrinsics.checkNotNullParameter(str16, "realGiftJumpUrl");
        Intrinsics.checkNotNullParameter(str17, "nftJumpUrl");
        return new BiliCollectionGlobalInfoSideBarData(str, str2, str3, str4, str5, str6, str7, str8, z, str9, z2, str10, str11, str12, str13, str14, str15, str16, z3, str17, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCollectionGlobalInfoSideBarData) {
            BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = (BiliCollectionGlobalInfoSideBarData) obj;
            return Intrinsics.areEqual(this.topSettingJumpUrl, biliCollectionGlobalInfoSideBarData.topSettingJumpUrl) && Intrinsics.areEqual(this.allSettingJumpUrl, biliCollectionGlobalInfoSideBarData.allSettingJumpUrl) && Intrinsics.areEqual(this.skinJumpUrl, biliCollectionGlobalInfoSideBarData.skinJumpUrl) && Intrinsics.areEqual(this.emojiPackageJumpUrl, biliCollectionGlobalInfoSideBarData.emojiPackageJumpUrl) && Intrinsics.areEqual(this.spaceBackgroundJumpUrl, biliCollectionGlobalInfoSideBarData.spaceBackgroundJumpUrl) && Intrinsics.areEqual(this.pendantJumpUrl, biliCollectionGlobalInfoSideBarData.pendantJumpUrl) && Intrinsics.areEqual(this.splashJumpUrl, biliCollectionGlobalInfoSideBarData.splashJumpUrl) && Intrinsics.areEqual(this.cardBackgroundJumpUrl, biliCollectionGlobalInfoSideBarData.cardBackgroundJumpUrl) && this.cardBackgroundHasNew == biliCollectionGlobalInfoSideBarData.cardBackgroundHasNew && Intrinsics.areEqual(this.cardJumpUrl, biliCollectionGlobalInfoSideBarData.cardJumpUrl) && this.cardHasNew == biliCollectionGlobalInfoSideBarData.cardHasNew && Intrinsics.areEqual(this.thumbUpJumpUrl, biliCollectionGlobalInfoSideBarData.thumbUpJumpUrl) && Intrinsics.areEqual(this.loadingJumpUrl, biliCollectionGlobalInfoSideBarData.loadingJumpUrl) && Intrinsics.areEqual(this.playIconJumpUrl, biliCollectionGlobalInfoSideBarData.playIconJumpUrl) && Intrinsics.areEqual(this.garbAllJumpUrl, biliCollectionGlobalInfoSideBarData.garbAllJumpUrl) && Intrinsics.areEqual(this.garbMallJumpUrl, biliCollectionGlobalInfoSideBarData.garbMallJumpUrl) && Intrinsics.areEqual(this.widgetJumpUrl, biliCollectionGlobalInfoSideBarData.widgetJumpUrl) && Intrinsics.areEqual(this.realGiftJumpUrl, biliCollectionGlobalInfoSideBarData.realGiftJumpUrl) && this.realGiftNewShowing == biliCollectionGlobalInfoSideBarData.realGiftNewShowing && Intrinsics.areEqual(this.nftJumpUrl, biliCollectionGlobalInfoSideBarData.nftJumpUrl) && this.nftHasNew == biliCollectionGlobalInfoSideBarData.nftHasNew;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((this.topSettingJumpUrl.hashCode() * 31) + this.allSettingJumpUrl.hashCode()) * 31) + this.skinJumpUrl.hashCode()) * 31) + this.emojiPackageJumpUrl.hashCode()) * 31) + this.spaceBackgroundJumpUrl.hashCode()) * 31) + this.pendantJumpUrl.hashCode()) * 31) + this.splashJumpUrl.hashCode()) * 31) + this.cardBackgroundJumpUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.cardBackgroundHasNew)) * 31) + this.cardJumpUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.cardHasNew)) * 31) + this.thumbUpJumpUrl.hashCode()) * 31) + this.loadingJumpUrl.hashCode()) * 31) + this.playIconJumpUrl.hashCode()) * 31) + this.garbAllJumpUrl.hashCode()) * 31) + this.garbMallJumpUrl.hashCode()) * 31) + this.widgetJumpUrl.hashCode()) * 31) + this.realGiftJumpUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.realGiftNewShowing)) * 31) + this.nftJumpUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.nftHasNew);
    }

    public String toString() {
        String str = this.topSettingJumpUrl;
        String str2 = this.allSettingJumpUrl;
        String str3 = this.skinJumpUrl;
        String str4 = this.emojiPackageJumpUrl;
        String str5 = this.spaceBackgroundJumpUrl;
        String str6 = this.pendantJumpUrl;
        String str7 = this.splashJumpUrl;
        String str8 = this.cardBackgroundJumpUrl;
        boolean z = this.cardBackgroundHasNew;
        String str9 = this.cardJumpUrl;
        boolean z2 = this.cardHasNew;
        String str10 = this.thumbUpJumpUrl;
        String str11 = this.loadingJumpUrl;
        String str12 = this.playIconJumpUrl;
        String str13 = this.garbAllJumpUrl;
        String str14 = this.garbMallJumpUrl;
        String str15 = this.widgetJumpUrl;
        String str16 = this.realGiftJumpUrl;
        boolean z3 = this.realGiftNewShowing;
        String str17 = this.nftJumpUrl;
        return "BiliCollectionGlobalInfoSideBarData(topSettingJumpUrl=" + str + ", allSettingJumpUrl=" + str2 + ", skinJumpUrl=" + str3 + ", emojiPackageJumpUrl=" + str4 + ", spaceBackgroundJumpUrl=" + str5 + ", pendantJumpUrl=" + str6 + ", splashJumpUrl=" + str7 + ", cardBackgroundJumpUrl=" + str8 + ", cardBackgroundHasNew=" + z + ", cardJumpUrl=" + str9 + ", cardHasNew=" + z2 + ", thumbUpJumpUrl=" + str10 + ", loadingJumpUrl=" + str11 + ", playIconJumpUrl=" + str12 + ", garbAllJumpUrl=" + str13 + ", garbMallJumpUrl=" + str14 + ", widgetJumpUrl=" + str15 + ", realGiftJumpUrl=" + str16 + ", realGiftNewShowing=" + z3 + ", nftJumpUrl=" + str17 + ", nftHasNew=" + this.nftHasNew + ")";
    }

    public BiliCollectionGlobalInfoSideBarData(String topSettingJumpUrl, String allSettingJumpUrl, String skinJumpUrl, String emojiPackageJumpUrl, String spaceBackgroundJumpUrl, String pendantJumpUrl, String splashJumpUrl, String cardBackgroundJumpUrl, boolean cardBackgroundHasNew, String cardJumpUrl, boolean cardHasNew, String thumbUpJumpUrl, String loadingJumpUrl, String playIconJumpUrl, String garbAllJumpUrl, String garbMallJumpUrl, String widgetJumpUrl, String realGiftJumpUrl, boolean realGiftNewShowing, String nftJumpUrl, boolean nftHasNew) {
        Intrinsics.checkNotNullParameter(topSettingJumpUrl, "topSettingJumpUrl");
        Intrinsics.checkNotNullParameter(allSettingJumpUrl, "allSettingJumpUrl");
        Intrinsics.checkNotNullParameter(skinJumpUrl, "skinJumpUrl");
        Intrinsics.checkNotNullParameter(emojiPackageJumpUrl, "emojiPackageJumpUrl");
        Intrinsics.checkNotNullParameter(spaceBackgroundJumpUrl, "spaceBackgroundJumpUrl");
        Intrinsics.checkNotNullParameter(pendantJumpUrl, "pendantJumpUrl");
        Intrinsics.checkNotNullParameter(splashJumpUrl, "splashJumpUrl");
        Intrinsics.checkNotNullParameter(cardBackgroundJumpUrl, "cardBackgroundJumpUrl");
        Intrinsics.checkNotNullParameter(cardJumpUrl, "cardJumpUrl");
        Intrinsics.checkNotNullParameter(thumbUpJumpUrl, "thumbUpJumpUrl");
        Intrinsics.checkNotNullParameter(loadingJumpUrl, "loadingJumpUrl");
        Intrinsics.checkNotNullParameter(playIconJumpUrl, "playIconJumpUrl");
        Intrinsics.checkNotNullParameter(garbAllJumpUrl, "garbAllJumpUrl");
        Intrinsics.checkNotNullParameter(garbMallJumpUrl, "garbMallJumpUrl");
        Intrinsics.checkNotNullParameter(widgetJumpUrl, "widgetJumpUrl");
        Intrinsics.checkNotNullParameter(realGiftJumpUrl, "realGiftJumpUrl");
        Intrinsics.checkNotNullParameter(nftJumpUrl, "nftJumpUrl");
        this.topSettingJumpUrl = topSettingJumpUrl;
        this.allSettingJumpUrl = allSettingJumpUrl;
        this.skinJumpUrl = skinJumpUrl;
        this.emojiPackageJumpUrl = emojiPackageJumpUrl;
        this.spaceBackgroundJumpUrl = spaceBackgroundJumpUrl;
        this.pendantJumpUrl = pendantJumpUrl;
        this.splashJumpUrl = splashJumpUrl;
        this.cardBackgroundJumpUrl = cardBackgroundJumpUrl;
        this.cardBackgroundHasNew = cardBackgroundHasNew;
        this.cardJumpUrl = cardJumpUrl;
        this.cardHasNew = cardHasNew;
        this.thumbUpJumpUrl = thumbUpJumpUrl;
        this.loadingJumpUrl = loadingJumpUrl;
        this.playIconJumpUrl = playIconJumpUrl;
        this.garbAllJumpUrl = garbAllJumpUrl;
        this.garbMallJumpUrl = garbMallJumpUrl;
        this.widgetJumpUrl = widgetJumpUrl;
        this.realGiftJumpUrl = realGiftJumpUrl;
        this.realGiftNewShowing = realGiftNewShowing;
        this.nftJumpUrl = nftJumpUrl;
        this.nftHasNew = nftHasNew;
    }

    public final String getTopSettingJumpUrl() {
        return this.topSettingJumpUrl;
    }

    public final String getAllSettingJumpUrl() {
        return this.allSettingJumpUrl;
    }

    public final String getSkinJumpUrl() {
        return this.skinJumpUrl;
    }

    public final String getEmojiPackageJumpUrl() {
        return this.emojiPackageJumpUrl;
    }

    public final String getSpaceBackgroundJumpUrl() {
        return this.spaceBackgroundJumpUrl;
    }

    public final String getPendantJumpUrl() {
        return this.pendantJumpUrl;
    }

    public final String getSplashJumpUrl() {
        return this.splashJumpUrl;
    }

    public final String getCardBackgroundJumpUrl() {
        return this.cardBackgroundJumpUrl;
    }

    public final boolean getCardBackgroundHasNew() {
        return this.cardBackgroundHasNew;
    }

    public final String getCardJumpUrl() {
        return this.cardJumpUrl;
    }

    public final boolean getCardHasNew() {
        return this.cardHasNew;
    }

    public final String getThumbUpJumpUrl() {
        return this.thumbUpJumpUrl;
    }

    public final String getLoadingJumpUrl() {
        return this.loadingJumpUrl;
    }

    public final String getPlayIconJumpUrl() {
        return this.playIconJumpUrl;
    }

    public final String getGarbAllJumpUrl() {
        return this.garbAllJumpUrl;
    }

    public final String getGarbMallJumpUrl() {
        return this.garbMallJumpUrl;
    }

    public final String getWidgetJumpUrl() {
        return this.widgetJumpUrl;
    }

    public final String getRealGiftJumpUrl() {
        return this.realGiftJumpUrl;
    }

    public final boolean getRealGiftNewShowing() {
        return this.realGiftNewShowing;
    }

    public final String getNftJumpUrl() {
        return this.nftJumpUrl;
    }

    public final boolean getNftHasNew() {
        return this.nftHasNew;
    }
}