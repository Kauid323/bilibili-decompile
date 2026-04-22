package tv.danmaku.bili.ui.garb.nft.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: DLCCardDrawModel.kt */
@Bson
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\tHÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003Jù\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0005HÆ\u0001J\u0013\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020\u0005HÖ\u0001J\t\u0010c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010+R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0016\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 R\u0016\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R6\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030=j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003`>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR6\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030=j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003`>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010B¨\u0006d"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;", "", "callbackId", "", "screenType", "", "hasDrawCardAnimation", "hasCardAnimation", "actId", "", "activityStatus", "lotteryId", "lotteryNum", "bizInfo", "jumpUrl", "animDrawUrl", "animEntryUrl", "horizontalCardLightUrl", "verticalCardLightUrl", "horizontalCardShadowUrl", "verticalCardShadowUrl", "holderListUrl", "canDonate", "upChain", "shareType", "fromWhere", "fromId", "fSource", "pageType", "<init>", "(Ljava/lang/String;IIIJIJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getCallbackId", "()Ljava/lang/String;", "getScreenType", "()I", "getHasDrawCardAnimation", "getHasCardAnimation", "getActId", "()J", "getActivityStatus", "getLotteryId", "getLotteryNum", "setLotteryNum", "(I)V", "getBizInfo", "getJumpUrl", "getAnimDrawUrl", "getAnimEntryUrl", "getHorizontalCardLightUrl", "getVerticalCardLightUrl", "getHorizontalCardShadowUrl", "getVerticalCardShadowUrl", "getHolderListUrl", "getCanDonate", "getUpChain", "getShareType", "getFromWhere", "getFromId", "getFSource", "getPageType", "animDrawMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getAnimDrawMap", "()Ljava/util/HashMap;", "setAnimDrawMap", "(Ljava/util/HashMap;)V", "animEntryMap", "getAnimEntryMap", "setAnimEntryMap", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardDrawModel {
    public static final int $stable = 8;
    @SerializedName("act_id")
    private final long actId;
    @SerializedName("activity_status")
    private final int activityStatus;
    private transient HashMap<Integer, String> animDrawMap;
    @SerializedName("animation_draw_url")
    private final String animDrawUrl;
    private transient HashMap<Integer, String> animEntryMap;
    @SerializedName("animation_entry_url")
    private final String animEntryUrl;
    @SerializedName("biz_info")
    private final String bizInfo;
    @SerializedName(AuthResultCbHelper.ARGS_CALLBACK)
    private final String callbackId;
    @SerializedName("is_can_donate")
    private final int canDonate;
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
    @SerializedName("jump_url")
    private final String jumpUrl;
    @SerializedName("lottery_id")
    private final long lotteryId;
    @SerializedName("lottery_num")
    private int lotteryNum;
    @SerializedName("page_type")
    private final int pageType;
    @SerializedName("screen_type")
    private final int screenType;
    @SerializedName("share_type")
    private final int shareType;
    @SerializedName("is_up_chain")
    private final int upChain;
    @SerializedName("vertical_card_light_url")
    private final String verticalCardLightUrl;
    @SerializedName("vertical_card_shadow_url")
    private final String verticalCardShadowUrl;

    public final String component1() {
        return this.callbackId;
    }

    public final String component10() {
        return this.jumpUrl;
    }

    public final String component11() {
        return this.animDrawUrl;
    }

    public final String component12() {
        return this.animEntryUrl;
    }

    public final String component13() {
        return this.horizontalCardLightUrl;
    }

    public final String component14() {
        return this.verticalCardLightUrl;
    }

    public final String component15() {
        return this.horizontalCardShadowUrl;
    }

    public final String component16() {
        return this.verticalCardShadowUrl;
    }

    public final String component17() {
        return this.holderListUrl;
    }

    public final int component18() {
        return this.canDonate;
    }

    public final int component19() {
        return this.upChain;
    }

    public final int component2() {
        return this.screenType;
    }

    public final int component20() {
        return this.shareType;
    }

    public final String component21() {
        return this.fromWhere;
    }

    public final String component22() {
        return this.fromId;
    }

    public final String component23() {
        return this.fSource;
    }

    public final int component24() {
        return this.pageType;
    }

    public final int component3() {
        return this.hasDrawCardAnimation;
    }

    public final int component4() {
        return this.hasCardAnimation;
    }

    public final long component5() {
        return this.actId;
    }

    public final int component6() {
        return this.activityStatus;
    }

    public final long component7() {
        return this.lotteryId;
    }

    public final int component8() {
        return this.lotteryNum;
    }

    public final String component9() {
        return this.bizInfo;
    }

    public final DLCCardDrawModel copy(String str, int i, int i2, int i3, long j, int i4, long j2, int i5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i6, int i7, int i8, String str11, String str12, String str13, int i9) {
        Intrinsics.checkNotNullParameter(str, "callbackId");
        Intrinsics.checkNotNullParameter(str2, "bizInfo");
        Intrinsics.checkNotNullParameter(str3, "jumpUrl");
        Intrinsics.checkNotNullParameter(str4, "animDrawUrl");
        Intrinsics.checkNotNullParameter(str5, "animEntryUrl");
        Intrinsics.checkNotNullParameter(str6, "horizontalCardLightUrl");
        Intrinsics.checkNotNullParameter(str7, "verticalCardLightUrl");
        Intrinsics.checkNotNullParameter(str8, "horizontalCardShadowUrl");
        Intrinsics.checkNotNullParameter(str9, "verticalCardShadowUrl");
        Intrinsics.checkNotNullParameter(str10, "holderListUrl");
        Intrinsics.checkNotNullParameter(str11, "fromWhere");
        Intrinsics.checkNotNullParameter(str12, "fromId");
        Intrinsics.checkNotNullParameter(str13, "fSource");
        return new DLCCardDrawModel(str, i, i2, i3, j, i4, j2, i5, str2, str3, str4, str5, str6, str7, str8, str9, str10, i6, i7, i8, str11, str12, str13, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCCardDrawModel) {
            DLCCardDrawModel dLCCardDrawModel = (DLCCardDrawModel) obj;
            return Intrinsics.areEqual(this.callbackId, dLCCardDrawModel.callbackId) && this.screenType == dLCCardDrawModel.screenType && this.hasDrawCardAnimation == dLCCardDrawModel.hasDrawCardAnimation && this.hasCardAnimation == dLCCardDrawModel.hasCardAnimation && this.actId == dLCCardDrawModel.actId && this.activityStatus == dLCCardDrawModel.activityStatus && this.lotteryId == dLCCardDrawModel.lotteryId && this.lotteryNum == dLCCardDrawModel.lotteryNum && Intrinsics.areEqual(this.bizInfo, dLCCardDrawModel.bizInfo) && Intrinsics.areEqual(this.jumpUrl, dLCCardDrawModel.jumpUrl) && Intrinsics.areEqual(this.animDrawUrl, dLCCardDrawModel.animDrawUrl) && Intrinsics.areEqual(this.animEntryUrl, dLCCardDrawModel.animEntryUrl) && Intrinsics.areEqual(this.horizontalCardLightUrl, dLCCardDrawModel.horizontalCardLightUrl) && Intrinsics.areEqual(this.verticalCardLightUrl, dLCCardDrawModel.verticalCardLightUrl) && Intrinsics.areEqual(this.horizontalCardShadowUrl, dLCCardDrawModel.horizontalCardShadowUrl) && Intrinsics.areEqual(this.verticalCardShadowUrl, dLCCardDrawModel.verticalCardShadowUrl) && Intrinsics.areEqual(this.holderListUrl, dLCCardDrawModel.holderListUrl) && this.canDonate == dLCCardDrawModel.canDonate && this.upChain == dLCCardDrawModel.upChain && this.shareType == dLCCardDrawModel.shareType && Intrinsics.areEqual(this.fromWhere, dLCCardDrawModel.fromWhere) && Intrinsics.areEqual(this.fromId, dLCCardDrawModel.fromId) && Intrinsics.areEqual(this.fSource, dLCCardDrawModel.fSource) && this.pageType == dLCCardDrawModel.pageType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((this.callbackId.hashCode() * 31) + this.screenType) * 31) + this.hasDrawCardAnimation) * 31) + this.hasCardAnimation) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.actId)) * 31) + this.activityStatus) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lotteryId)) * 31) + this.lotteryNum) * 31) + this.bizInfo.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.animDrawUrl.hashCode()) * 31) + this.animEntryUrl.hashCode()) * 31) + this.horizontalCardLightUrl.hashCode()) * 31) + this.verticalCardLightUrl.hashCode()) * 31) + this.horizontalCardShadowUrl.hashCode()) * 31) + this.verticalCardShadowUrl.hashCode()) * 31) + this.holderListUrl.hashCode()) * 31) + this.canDonate) * 31) + this.upChain) * 31) + this.shareType) * 31) + this.fromWhere.hashCode()) * 31) + this.fromId.hashCode()) * 31) + this.fSource.hashCode()) * 31) + this.pageType;
    }

    public String toString() {
        String str = this.callbackId;
        int i = this.screenType;
        int i2 = this.hasDrawCardAnimation;
        int i3 = this.hasCardAnimation;
        long j = this.actId;
        int i4 = this.activityStatus;
        long j2 = this.lotteryId;
        int i5 = this.lotteryNum;
        String str2 = this.bizInfo;
        String str3 = this.jumpUrl;
        String str4 = this.animDrawUrl;
        String str5 = this.animEntryUrl;
        String str6 = this.horizontalCardLightUrl;
        String str7 = this.verticalCardLightUrl;
        String str8 = this.horizontalCardShadowUrl;
        String str9 = this.verticalCardShadowUrl;
        String str10 = this.holderListUrl;
        int i6 = this.canDonate;
        int i7 = this.upChain;
        int i8 = this.shareType;
        String str11 = this.fromWhere;
        String str12 = this.fromId;
        String str13 = this.fSource;
        return "DLCCardDrawModel(callbackId=" + str + ", screenType=" + i + ", hasDrawCardAnimation=" + i2 + ", hasCardAnimation=" + i3 + ", actId=" + j + ", activityStatus=" + i4 + ", lotteryId=" + j2 + ", lotteryNum=" + i5 + ", bizInfo=" + str2 + ", jumpUrl=" + str3 + ", animDrawUrl=" + str4 + ", animEntryUrl=" + str5 + ", horizontalCardLightUrl=" + str6 + ", verticalCardLightUrl=" + str7 + ", horizontalCardShadowUrl=" + str8 + ", verticalCardShadowUrl=" + str9 + ", holderListUrl=" + str10 + ", canDonate=" + i6 + ", upChain=" + i7 + ", shareType=" + i8 + ", fromWhere=" + str11 + ", fromId=" + str12 + ", fSource=" + str13 + ", pageType=" + this.pageType + ")";
    }

    public DLCCardDrawModel(String callbackId, int screenType, int hasDrawCardAnimation, int hasCardAnimation, long actId, int activityStatus, long lotteryId, int lotteryNum, String bizInfo, String jumpUrl, String animDrawUrl, String animEntryUrl, String horizontalCardLightUrl, String verticalCardLightUrl, String horizontalCardShadowUrl, String verticalCardShadowUrl, String holderListUrl, int canDonate, int upChain, int shareType, String fromWhere, String fromId, String fSource, int pageType) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(bizInfo, "bizInfo");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(animDrawUrl, "animDrawUrl");
        Intrinsics.checkNotNullParameter(animEntryUrl, "animEntryUrl");
        Intrinsics.checkNotNullParameter(horizontalCardLightUrl, "horizontalCardLightUrl");
        Intrinsics.checkNotNullParameter(verticalCardLightUrl, "verticalCardLightUrl");
        Intrinsics.checkNotNullParameter(horizontalCardShadowUrl, "horizontalCardShadowUrl");
        Intrinsics.checkNotNullParameter(verticalCardShadowUrl, "verticalCardShadowUrl");
        Intrinsics.checkNotNullParameter(holderListUrl, "holderListUrl");
        Intrinsics.checkNotNullParameter(fromWhere, "fromWhere");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        this.callbackId = callbackId;
        this.screenType = screenType;
        this.hasDrawCardAnimation = hasDrawCardAnimation;
        this.hasCardAnimation = hasCardAnimation;
        this.actId = actId;
        this.activityStatus = activityStatus;
        this.lotteryId = lotteryId;
        this.lotteryNum = lotteryNum;
        this.bizInfo = bizInfo;
        this.jumpUrl = jumpUrl;
        this.animDrawUrl = animDrawUrl;
        this.animEntryUrl = animEntryUrl;
        this.horizontalCardLightUrl = horizontalCardLightUrl;
        this.verticalCardLightUrl = verticalCardLightUrl;
        this.horizontalCardShadowUrl = horizontalCardShadowUrl;
        this.verticalCardShadowUrl = verticalCardShadowUrl;
        this.holderListUrl = holderListUrl;
        this.canDonate = canDonate;
        this.upChain = upChain;
        this.shareType = shareType;
        this.fromWhere = fromWhere;
        this.fromId = fromId;
        this.fSource = fSource;
        this.pageType = pageType;
        this.animDrawMap = new HashMap<>();
        this.animEntryMap = new HashMap<>();
    }

    public final String getCallbackId() {
        return this.callbackId;
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

    public final long getActId() {
        return this.actId;
    }

    public final int getActivityStatus() {
        return this.activityStatus;
    }

    public final long getLotteryId() {
        return this.lotteryId;
    }

    public final int getLotteryNum() {
        return this.lotteryNum;
    }

    public final void setLotteryNum(int i) {
        this.lotteryNum = i;
    }

    public final String getBizInfo() {
        return this.bizInfo;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getAnimDrawUrl() {
        return this.animDrawUrl;
    }

    public final String getAnimEntryUrl() {
        return this.animEntryUrl;
    }

    public final String getHorizontalCardLightUrl() {
        return this.horizontalCardLightUrl;
    }

    public final String getVerticalCardLightUrl() {
        return this.verticalCardLightUrl;
    }

    public final String getHorizontalCardShadowUrl() {
        return this.horizontalCardShadowUrl;
    }

    public final String getVerticalCardShadowUrl() {
        return this.verticalCardShadowUrl;
    }

    public final String getHolderListUrl() {
        return this.holderListUrl;
    }

    public final int getCanDonate() {
        return this.canDonate;
    }

    public final int getUpChain() {
        return this.upChain;
    }

    public final int getShareType() {
        return this.shareType;
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

    public final HashMap<Integer, String> getAnimDrawMap() {
        return this.animDrawMap;
    }

    public final void setAnimDrawMap(HashMap<Integer, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.animDrawMap = hashMap;
    }

    public final HashMap<Integer, String> getAnimEntryMap() {
        return this.animEntryMap;
    }

    public final void setAnimEntryMap(HashMap<Integer, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.animEntryMap = hashMap;
    }
}