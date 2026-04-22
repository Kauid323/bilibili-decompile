package tv.danmaku.bili.ui.garb.nft.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCDetailModel.kt */
@Bson
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bJ\b\u0087\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\f\u0012\u0006\u0010!\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\fHÆ\u0003J\t\u0010M\u001a\u00020\fHÆ\u0003J\t\u0010N\u001a\u00020\fHÆ\u0003J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\u0011HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0014HÆ\u0003J\t\u0010S\u001a\u00020\fHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\t\u0010U\u001a\u00020\fHÆ\u0003J\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\t\u0010W\u001a\u00020\u0014HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0014HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\fHÆ\u0003J\t\u0010\\\u001a\u00020\fHÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u009d\u0002\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\u0003HÆ\u0001J\u0013\u0010`\u001a\u00020\u00142\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020\u0003HÖ\u0001J\t\u0010c\u001a\u00020\fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0016\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0016\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010/R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0016\u0010\u001b\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00107R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0016\u0010\u001d\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00107R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0016\u0010\u001f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0016\u0010 \u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0016\u0010!\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010/R\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010&¨\u0006d"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCDetailModel;", "", "activityId", "", "callbackId", "type", "screenType", "hasDrawCardAnimation", "hasCardAnimation", "shareType", "jumpId", "horizontalCardLightUrl", "", "horizontalCardShadowUrl", "verticalCardLightUrl", "verticalCardShadowUrl", "mid", "", "totalCnt", "notOnSale", "", "holderListUrl", "actHomepageurl", "spaceBgSetUrl", "cardList", "", "Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailModel;", "isBooked", "canDonate", "canSaveImage", "upChain", "fromWhere", "fromId", "fSource", "pageType", "<init>", "(IIIIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZIZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getActivityId", "()I", "getCallbackId", "getType", "getScreenType", "getHasDrawCardAnimation", "getHasCardAnimation", "getShareType", "getJumpId", "getHorizontalCardLightUrl", "()Ljava/lang/String;", "getHorizontalCardShadowUrl", "getVerticalCardLightUrl", "getVerticalCardShadowUrl", "getMid", "()J", "getTotalCnt", "getNotOnSale", "()Z", "getHolderListUrl", "getActHomepageurl", "getSpaceBgSetUrl", "getCardList", "()Ljava/util/List;", "getCanDonate", "getCanSaveImage", "getUpChain", "getFromWhere", "getFromId", "getFSource", "getPageType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCDetailModel {
    public static final int $stable = 8;
    @SerializedName("homepage_url")
    private final String actHomepageurl;
    @SerializedName("act_id")
    private final int activityId;
    @SerializedName("callbackId")
    private final int callbackId;
    @SerializedName("is_can_donate")
    private final int canDonate;
    @SerializedName("save_image_right")
    private final boolean canSaveImage;
    @SerializedName("card_list")
    private final List<DigitalCardDetailModel> cardList;
    @SerializedName("f_source")
    private final String fSource;
    @SerializedName("from_id")
    private final String fromId;
    @SerializedName("from")
    private final String fromWhere;
    @SerializedName("has_card_ani")
    private final int hasCardAnimation;
    @SerializedName("has_draw_ani")
    private final int hasDrawCardAnimation;
    @SerializedName("holder_list_url")
    private final String holderListUrl;
    @SerializedName("horizontal_card_light_url")
    private final String horizontalCardLightUrl;
    @SerializedName("horizontal_card_shadow_url")
    private final String horizontalCardShadowUrl;
    @SerializedName("is_booked")
    private final boolean isBooked;
    @SerializedName("jump_id")
    private final int jumpId;
    @SerializedName("mid")
    private final long mid;
    @SerializedName("not_on_sale")
    private final boolean notOnSale;
    @SerializedName("page_type")
    private final int pageType;
    @SerializedName("screen_type")
    private final int screenType;
    @SerializedName("share_type")
    private final int shareType;
    @SerializedName("space_bg_set_url")
    private final String spaceBgSetUrl;
    @SerializedName("total_cnt")
    private final int totalCnt;
    @SerializedName("type")
    private final int type;
    @SerializedName("is_up_chain")
    private final int upChain;
    @SerializedName("vertical_card_light_url")
    private final String verticalCardLightUrl;
    @SerializedName("vertical_card_shadow_url")
    private final String verticalCardShadowUrl;

    public final int component1() {
        return this.activityId;
    }

    public final String component10() {
        return this.horizontalCardShadowUrl;
    }

    public final String component11() {
        return this.verticalCardLightUrl;
    }

    public final String component12() {
        return this.verticalCardShadowUrl;
    }

    public final long component13() {
        return this.mid;
    }

    public final int component14() {
        return this.totalCnt;
    }

    public final boolean component15() {
        return this.notOnSale;
    }

    public final String component16() {
        return this.holderListUrl;
    }

    public final String component17() {
        return this.actHomepageurl;
    }

    public final String component18() {
        return this.spaceBgSetUrl;
    }

    public final List<DigitalCardDetailModel> component19() {
        return this.cardList;
    }

    public final int component2() {
        return this.callbackId;
    }

    public final boolean component20() {
        return this.isBooked;
    }

    public final int component21() {
        return this.canDonate;
    }

    public final boolean component22() {
        return this.canSaveImage;
    }

    public final int component23() {
        return this.upChain;
    }

    public final String component24() {
        return this.fromWhere;
    }

    public final String component25() {
        return this.fromId;
    }

    public final String component26() {
        return this.fSource;
    }

    public final int component27() {
        return this.pageType;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.screenType;
    }

    public final int component5() {
        return this.hasDrawCardAnimation;
    }

    public final int component6() {
        return this.hasCardAnimation;
    }

    public final int component7() {
        return this.shareType;
    }

    public final int component8() {
        return this.jumpId;
    }

    public final String component9() {
        return this.horizontalCardLightUrl;
    }

    public final DLCDetailModel copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, String str4, long j, int i9, boolean z, String str5, String str6, String str7, List<DigitalCardDetailModel> list, boolean z2, int i10, boolean z3, int i11, String str8, String str9, String str10, int i12) {
        Intrinsics.checkNotNullParameter(str, "horizontalCardLightUrl");
        Intrinsics.checkNotNullParameter(str2, "horizontalCardShadowUrl");
        Intrinsics.checkNotNullParameter(str3, "verticalCardLightUrl");
        Intrinsics.checkNotNullParameter(str4, "verticalCardShadowUrl");
        Intrinsics.checkNotNullParameter(str5, "holderListUrl");
        Intrinsics.checkNotNullParameter(str6, "actHomepageurl");
        Intrinsics.checkNotNullParameter(str7, "spaceBgSetUrl");
        Intrinsics.checkNotNullParameter(list, "cardList");
        Intrinsics.checkNotNullParameter(str8, "fromWhere");
        Intrinsics.checkNotNullParameter(str9, "fromId");
        Intrinsics.checkNotNullParameter(str10, "fSource");
        return new DLCDetailModel(i, i2, i3, i4, i5, i6, i7, i8, str, str2, str3, str4, j, i9, z, str5, str6, str7, list, z2, i10, z3, i11, str8, str9, str10, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCDetailModel) {
            DLCDetailModel dLCDetailModel = (DLCDetailModel) obj;
            return this.activityId == dLCDetailModel.activityId && this.callbackId == dLCDetailModel.callbackId && this.type == dLCDetailModel.type && this.screenType == dLCDetailModel.screenType && this.hasDrawCardAnimation == dLCDetailModel.hasDrawCardAnimation && this.hasCardAnimation == dLCDetailModel.hasCardAnimation && this.shareType == dLCDetailModel.shareType && this.jumpId == dLCDetailModel.jumpId && Intrinsics.areEqual(this.horizontalCardLightUrl, dLCDetailModel.horizontalCardLightUrl) && Intrinsics.areEqual(this.horizontalCardShadowUrl, dLCDetailModel.horizontalCardShadowUrl) && Intrinsics.areEqual(this.verticalCardLightUrl, dLCDetailModel.verticalCardLightUrl) && Intrinsics.areEqual(this.verticalCardShadowUrl, dLCDetailModel.verticalCardShadowUrl) && this.mid == dLCDetailModel.mid && this.totalCnt == dLCDetailModel.totalCnt && this.notOnSale == dLCDetailModel.notOnSale && Intrinsics.areEqual(this.holderListUrl, dLCDetailModel.holderListUrl) && Intrinsics.areEqual(this.actHomepageurl, dLCDetailModel.actHomepageurl) && Intrinsics.areEqual(this.spaceBgSetUrl, dLCDetailModel.spaceBgSetUrl) && Intrinsics.areEqual(this.cardList, dLCDetailModel.cardList) && this.isBooked == dLCDetailModel.isBooked && this.canDonate == dLCDetailModel.canDonate && this.canSaveImage == dLCDetailModel.canSaveImage && this.upChain == dLCDetailModel.upChain && Intrinsics.areEqual(this.fromWhere, dLCDetailModel.fromWhere) && Intrinsics.areEqual(this.fromId, dLCDetailModel.fromId) && Intrinsics.areEqual(this.fSource, dLCDetailModel.fSource) && this.pageType == dLCDetailModel.pageType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((this.activityId * 31) + this.callbackId) * 31) + this.type) * 31) + this.screenType) * 31) + this.hasDrawCardAnimation) * 31) + this.hasCardAnimation) * 31) + this.shareType) * 31) + this.jumpId) * 31) + this.horizontalCardLightUrl.hashCode()) * 31) + this.horizontalCardShadowUrl.hashCode()) * 31) + this.verticalCardLightUrl.hashCode()) * 31) + this.verticalCardShadowUrl.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.totalCnt) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.notOnSale)) * 31) + this.holderListUrl.hashCode()) * 31) + this.actHomepageurl.hashCode()) * 31) + this.spaceBgSetUrl.hashCode()) * 31) + this.cardList.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isBooked)) * 31) + this.canDonate) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canSaveImage)) * 31) + this.upChain) * 31) + this.fromWhere.hashCode()) * 31) + this.fromId.hashCode()) * 31) + this.fSource.hashCode()) * 31) + this.pageType;
    }

    public String toString() {
        int i = this.activityId;
        int i2 = this.callbackId;
        int i3 = this.type;
        int i4 = this.screenType;
        int i5 = this.hasDrawCardAnimation;
        int i6 = this.hasCardAnimation;
        int i7 = this.shareType;
        int i8 = this.jumpId;
        String str = this.horizontalCardLightUrl;
        String str2 = this.horizontalCardShadowUrl;
        String str3 = this.verticalCardLightUrl;
        String str4 = this.verticalCardShadowUrl;
        long j = this.mid;
        int i9 = this.totalCnt;
        boolean z = this.notOnSale;
        String str5 = this.holderListUrl;
        String str6 = this.actHomepageurl;
        String str7 = this.spaceBgSetUrl;
        List<DigitalCardDetailModel> list = this.cardList;
        boolean z2 = this.isBooked;
        int i10 = this.canDonate;
        boolean z3 = this.canSaveImage;
        int i11 = this.upChain;
        String str8 = this.fromWhere;
        String str9 = this.fromId;
        String str10 = this.fSource;
        return "DLCDetailModel(activityId=" + i + ", callbackId=" + i2 + ", type=" + i3 + ", screenType=" + i4 + ", hasDrawCardAnimation=" + i5 + ", hasCardAnimation=" + i6 + ", shareType=" + i7 + ", jumpId=" + i8 + ", horizontalCardLightUrl=" + str + ", horizontalCardShadowUrl=" + str2 + ", verticalCardLightUrl=" + str3 + ", verticalCardShadowUrl=" + str4 + ", mid=" + j + ", totalCnt=" + i9 + ", notOnSale=" + z + ", holderListUrl=" + str5 + ", actHomepageurl=" + str6 + ", spaceBgSetUrl=" + str7 + ", cardList=" + list + ", isBooked=" + z2 + ", canDonate=" + i10 + ", canSaveImage=" + z3 + ", upChain=" + i11 + ", fromWhere=" + str8 + ", fromId=" + str9 + ", fSource=" + str10 + ", pageType=" + this.pageType + ")";
    }

    public DLCDetailModel(int activityId, int callbackId, int type, int screenType, int hasDrawCardAnimation, int hasCardAnimation, int shareType, int jumpId, String horizontalCardLightUrl, String horizontalCardShadowUrl, String verticalCardLightUrl, String verticalCardShadowUrl, long mid, int totalCnt, boolean notOnSale, String holderListUrl, String actHomepageurl, String spaceBgSetUrl, List<DigitalCardDetailModel> list, boolean isBooked, int canDonate, boolean canSaveImage, int upChain, String fromWhere, String fromId, String fSource, int pageType) {
        Intrinsics.checkNotNullParameter(horizontalCardLightUrl, "horizontalCardLightUrl");
        Intrinsics.checkNotNullParameter(horizontalCardShadowUrl, "horizontalCardShadowUrl");
        Intrinsics.checkNotNullParameter(verticalCardLightUrl, "verticalCardLightUrl");
        Intrinsics.checkNotNullParameter(verticalCardShadowUrl, "verticalCardShadowUrl");
        Intrinsics.checkNotNullParameter(holderListUrl, "holderListUrl");
        Intrinsics.checkNotNullParameter(actHomepageurl, "actHomepageurl");
        Intrinsics.checkNotNullParameter(spaceBgSetUrl, "spaceBgSetUrl");
        Intrinsics.checkNotNullParameter(list, "cardList");
        Intrinsics.checkNotNullParameter(fromWhere, "fromWhere");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        this.activityId = activityId;
        this.callbackId = callbackId;
        this.type = type;
        this.screenType = screenType;
        this.hasDrawCardAnimation = hasDrawCardAnimation;
        this.hasCardAnimation = hasCardAnimation;
        this.shareType = shareType;
        this.jumpId = jumpId;
        this.horizontalCardLightUrl = horizontalCardLightUrl;
        this.horizontalCardShadowUrl = horizontalCardShadowUrl;
        this.verticalCardLightUrl = verticalCardLightUrl;
        this.verticalCardShadowUrl = verticalCardShadowUrl;
        this.mid = mid;
        this.totalCnt = totalCnt;
        this.notOnSale = notOnSale;
        this.holderListUrl = holderListUrl;
        this.actHomepageurl = actHomepageurl;
        this.spaceBgSetUrl = spaceBgSetUrl;
        this.cardList = list;
        this.isBooked = isBooked;
        this.canDonate = canDonate;
        this.canSaveImage = canSaveImage;
        this.upChain = upChain;
        this.fromWhere = fromWhere;
        this.fromId = fromId;
        this.fSource = fSource;
        this.pageType = pageType;
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final int getCallbackId() {
        return this.callbackId;
    }

    public final int getType() {
        return this.type;
    }

    public final int getScreenType() {
        return this.screenType;
    }

    public final int getHasDrawCardAnimation() {
        return this.hasDrawCardAnimation;
    }

    public final int getHasCardAnimation() {
        return this.hasCardAnimation;
    }

    public final int getShareType() {
        return this.shareType;
    }

    public final int getJumpId() {
        return this.jumpId;
    }

    public final String getHorizontalCardLightUrl() {
        return this.horizontalCardLightUrl;
    }

    public final String getHorizontalCardShadowUrl() {
        return this.horizontalCardShadowUrl;
    }

    public final String getVerticalCardLightUrl() {
        return this.verticalCardLightUrl;
    }

    public final String getVerticalCardShadowUrl() {
        return this.verticalCardShadowUrl;
    }

    public final long getMid() {
        return this.mid;
    }

    public final int getTotalCnt() {
        return this.totalCnt;
    }

    public final boolean getNotOnSale() {
        return this.notOnSale;
    }

    public final String getHolderListUrl() {
        return this.holderListUrl;
    }

    public final String getActHomepageurl() {
        return this.actHomepageurl;
    }

    public final String getSpaceBgSetUrl() {
        return this.spaceBgSetUrl;
    }

    public final List<DigitalCardDetailModel> getCardList() {
        return this.cardList;
    }

    public final boolean isBooked() {
        return this.isBooked;
    }

    public final int getCanDonate() {
        return this.canDonate;
    }

    public final boolean getCanSaveImage() {
        return this.canSaveImage;
    }

    public final int getUpChain() {
        return this.upChain;
    }

    public final String getFromWhere() {
        return this.fromWhere;
    }

    public final String getFromId() {
        return this.fromId;
    }

    public final String getFSource() {
        return this.fSource;
    }

    public final int getPageType() {
        return this.pageType;
    }
}