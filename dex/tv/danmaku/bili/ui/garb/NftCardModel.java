package tv.danmaku.bili.ui.garb;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;

/* compiled from: NftCardModel.kt */
@Bson
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bM\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u001a\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u000bHÆ\u0003J\u001d\u0010Q\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000fHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J%\u0010T\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0014HÆ\u0003J\t\u0010U\u001a\u00020\u0016HÆ\u0003J\t\u0010V\u001a\u00020\u0016HÆ\u0003J\t\u0010W\u001a\u00020\u0019HÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u000bHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u000bHÆ\u0003J\t\u0010]\u001a\u00020\u000bHÆ\u0003J\t\u0010^\u001a\u00020\u000bHÆ\u0003J\t\u0010_\u001a\u00020\u000bHÆ\u0003J\t\u0010`\u001a\u00020\u000bHÆ\u0003J©\u0002\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000b2$\b\u0002\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000bHÆ\u0001J\u0013\u0010b\u001a\u00020\u00162\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u0003HÖ\u0001J\t\u0010e\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R*\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u00103R\u0016\u0010\u0011\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R2\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0016\u0010\u001a\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u0016\u0010\u001b\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0016\u0010\u001c\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0016\u0010\u001e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0016\u0010\u001f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0016\u0010 \u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0016\u0010!\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0016\u0010\"\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R:\u0010E\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00106\"\u0004\bG\u0010H¨\u0006f"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardModel;", "", "type", "", "jumpId", "notOnSale", "roundId", "actId", "bookX", "bookY", InnerPushReceiverKt.KEY_EXTRA, "", "cardList", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/garb/NftCardDetailModel;", "Lkotlin/collections/ArrayList;", "drawCount", "animationDrawUrl", "animationResultUrl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "booked", "", "overtime", "mid", "", "fromWhere", "fromId", "fSource", "sourceType", "spaceBgSetUrl", "hCardLightUrl", "vCardLightUrl", "hCardShadowUrl", "vCardShadowUrl", "<init>", "(IIIIIIILjava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;Ljava/util/HashMap;ZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getJumpId", "getNotOnSale", "getRoundId", "getActId", "getBookX", "getBookY", NftCardJsBridgeCallHandler.GET_EXTRA, "()Ljava/lang/String;", "getCardList", "()Ljava/util/ArrayList;", "getDrawCount", "setDrawCount", "(I)V", "getAnimationDrawUrl", "getAnimationResultUrl", "()Ljava/util/HashMap;", "getBooked", "()Z", "getOvertime", "getMid", "()J", "getFromWhere", "getFromId", "getFSource", "getSourceType", "getSpaceBgSetUrl", "getHCardLightUrl", "getVCardLightUrl", "getHCardShadowUrl", "getVCardShadowUrl", "extraMap", "getExtraMap", "setExtraMap", "(Ljava/util/HashMap;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardModel {
    public static final int $stable = 8;
    @SerializedName("act_id")
    private final int actId;
    @SerializedName("animation_draw_url")
    private final String animationDrawUrl;
    @SerializedName("animation_result_url")
    private final HashMap<String, String> animationResultUrl;
    @SerializedName("book_x")
    private final int bookX;
    @SerializedName("book_y")
    private final int bookY;
    @SerializedName("is_booked")
    private final boolean booked;
    @SerializedName("card_list")
    private final ArrayList<NftCardDetailModel> cardList;
    @SerializedName("draw_count")
    private int drawCount;
    @SerializedName(InnerPushReceiverKt.KEY_EXTRA)
    private final String extra;
    private transient HashMap<String, String> extraMap;
    @SerializedName("f_source")
    private final String fSource;
    @SerializedName("from_id")
    private final String fromId;
    @SerializedName("from")
    private final String fromWhere;
    @SerializedName("horizontal_card_light_url")
    private final String hCardLightUrl;
    @SerializedName("horizontal_card_shadow_url")
    private final String hCardShadowUrl;
    @SerializedName("jump_id")
    private final int jumpId;
    @SerializedName("mid")
    private final long mid;
    @SerializedName("not_on_sale")
    private final int notOnSale;
    @SerializedName("is_overtime")
    private final boolean overtime;
    @SerializedName("round_id")
    private final int roundId;
    @SerializedName("source_type")
    private final int sourceType;
    @SerializedName("space_bg_set_url")
    private final String spaceBgSetUrl;
    @SerializedName("type")
    private final int type;
    @SerializedName("vertical_card_light_url")
    private final String vCardLightUrl;
    @SerializedName("vertical_card_shadow_url")
    private final String vCardShadowUrl;

    public final int component1() {
        return this.type;
    }

    public final int component10() {
        return this.drawCount;
    }

    public final String component11() {
        return this.animationDrawUrl;
    }

    public final HashMap<String, String> component12() {
        return this.animationResultUrl;
    }

    public final boolean component13() {
        return this.booked;
    }

    public final boolean component14() {
        return this.overtime;
    }

    public final long component15() {
        return this.mid;
    }

    public final String component16() {
        return this.fromWhere;
    }

    public final String component17() {
        return this.fromId;
    }

    public final String component18() {
        return this.fSource;
    }

    public final int component19() {
        return this.sourceType;
    }

    public final int component2() {
        return this.jumpId;
    }

    public final String component20() {
        return this.spaceBgSetUrl;
    }

    public final String component21() {
        return this.hCardLightUrl;
    }

    public final String component22() {
        return this.vCardLightUrl;
    }

    public final String component23() {
        return this.hCardShadowUrl;
    }

    public final String component24() {
        return this.vCardShadowUrl;
    }

    public final int component3() {
        return this.notOnSale;
    }

    public final int component4() {
        return this.roundId;
    }

    public final int component5() {
        return this.actId;
    }

    public final int component6() {
        return this.bookX;
    }

    public final int component7() {
        return this.bookY;
    }

    public final String component8() {
        return this.extra;
    }

    public final ArrayList<NftCardDetailModel> component9() {
        return this.cardList;
    }

    public final NftCardModel copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, ArrayList<NftCardDetailModel> arrayList, int i8, String str2, HashMap<String, String> hashMap, boolean z, boolean z2, long j, String str3, String str4, String str5, int i9, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, InnerPushReceiverKt.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(arrayList, "cardList");
        Intrinsics.checkNotNullParameter(str2, "animationDrawUrl");
        Intrinsics.checkNotNullParameter(hashMap, "animationResultUrl");
        Intrinsics.checkNotNullParameter(str3, "fromWhere");
        Intrinsics.checkNotNullParameter(str4, "fromId");
        Intrinsics.checkNotNullParameter(str5, "fSource");
        Intrinsics.checkNotNullParameter(str6, "spaceBgSetUrl");
        Intrinsics.checkNotNullParameter(str7, "hCardLightUrl");
        Intrinsics.checkNotNullParameter(str8, "vCardLightUrl");
        Intrinsics.checkNotNullParameter(str9, "hCardShadowUrl");
        Intrinsics.checkNotNullParameter(str10, "vCardShadowUrl");
        return new NftCardModel(i, i2, i3, i4, i5, i6, i7, str, arrayList, i8, str2, hashMap, z, z2, j, str3, str4, str5, i9, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NftCardModel) {
            NftCardModel nftCardModel = (NftCardModel) obj;
            return this.type == nftCardModel.type && this.jumpId == nftCardModel.jumpId && this.notOnSale == nftCardModel.notOnSale && this.roundId == nftCardModel.roundId && this.actId == nftCardModel.actId && this.bookX == nftCardModel.bookX && this.bookY == nftCardModel.bookY && Intrinsics.areEqual(this.extra, nftCardModel.extra) && Intrinsics.areEqual(this.cardList, nftCardModel.cardList) && this.drawCount == nftCardModel.drawCount && Intrinsics.areEqual(this.animationDrawUrl, nftCardModel.animationDrawUrl) && Intrinsics.areEqual(this.animationResultUrl, nftCardModel.animationResultUrl) && this.booked == nftCardModel.booked && this.overtime == nftCardModel.overtime && this.mid == nftCardModel.mid && Intrinsics.areEqual(this.fromWhere, nftCardModel.fromWhere) && Intrinsics.areEqual(this.fromId, nftCardModel.fromId) && Intrinsics.areEqual(this.fSource, nftCardModel.fSource) && this.sourceType == nftCardModel.sourceType && Intrinsics.areEqual(this.spaceBgSetUrl, nftCardModel.spaceBgSetUrl) && Intrinsics.areEqual(this.hCardLightUrl, nftCardModel.hCardLightUrl) && Intrinsics.areEqual(this.vCardLightUrl, nftCardModel.vCardLightUrl) && Intrinsics.areEqual(this.hCardShadowUrl, nftCardModel.hCardShadowUrl) && Intrinsics.areEqual(this.vCardShadowUrl, nftCardModel.vCardShadowUrl);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((this.type * 31) + this.jumpId) * 31) + this.notOnSale) * 31) + this.roundId) * 31) + this.actId) * 31) + this.bookX) * 31) + this.bookY) * 31) + this.extra.hashCode()) * 31) + this.cardList.hashCode()) * 31) + this.drawCount) * 31) + this.animationDrawUrl.hashCode()) * 31) + this.animationResultUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.booked)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.overtime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.fromWhere.hashCode()) * 31) + this.fromId.hashCode()) * 31) + this.fSource.hashCode()) * 31) + this.sourceType) * 31) + this.spaceBgSetUrl.hashCode()) * 31) + this.hCardLightUrl.hashCode()) * 31) + this.vCardLightUrl.hashCode()) * 31) + this.hCardShadowUrl.hashCode()) * 31) + this.vCardShadowUrl.hashCode();
    }

    public String toString() {
        int i = this.type;
        int i2 = this.jumpId;
        int i3 = this.notOnSale;
        int i4 = this.roundId;
        int i5 = this.actId;
        int i6 = this.bookX;
        int i7 = this.bookY;
        String str = this.extra;
        ArrayList<NftCardDetailModel> arrayList = this.cardList;
        int i8 = this.drawCount;
        String str2 = this.animationDrawUrl;
        HashMap<String, String> hashMap = this.animationResultUrl;
        boolean z = this.booked;
        boolean z2 = this.overtime;
        long j = this.mid;
        String str3 = this.fromWhere;
        String str4 = this.fromId;
        String str5 = this.fSource;
        int i9 = this.sourceType;
        String str6 = this.spaceBgSetUrl;
        String str7 = this.hCardLightUrl;
        String str8 = this.vCardLightUrl;
        String str9 = this.hCardShadowUrl;
        return "NftCardModel(type=" + i + ", jumpId=" + i2 + ", notOnSale=" + i3 + ", roundId=" + i4 + ", actId=" + i5 + ", bookX=" + i6 + ", bookY=" + i7 + ", extra=" + str + ", cardList=" + arrayList + ", drawCount=" + i8 + ", animationDrawUrl=" + str2 + ", animationResultUrl=" + hashMap + ", booked=" + z + ", overtime=" + z2 + ", mid=" + j + ", fromWhere=" + str3 + ", fromId=" + str4 + ", fSource=" + str5 + ", sourceType=" + i9 + ", spaceBgSetUrl=" + str6 + ", hCardLightUrl=" + str7 + ", vCardLightUrl=" + str8 + ", hCardShadowUrl=" + str9 + ", vCardShadowUrl=" + this.vCardShadowUrl + ")";
    }

    public NftCardModel(int type, int jumpId, int notOnSale, int roundId, int actId, int bookX, int bookY, String extra, ArrayList<NftCardDetailModel> arrayList, int drawCount, String animationDrawUrl, HashMap<String, String> hashMap, boolean booked, boolean overtime, long mid, String fromWhere, String fromId, String fSource, int sourceType, String spaceBgSetUrl, String hCardLightUrl, String vCardLightUrl, String hCardShadowUrl, String vCardShadowUrl) {
        Intrinsics.checkNotNullParameter(extra, InnerPushReceiverKt.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(arrayList, "cardList");
        Intrinsics.checkNotNullParameter(animationDrawUrl, "animationDrawUrl");
        Intrinsics.checkNotNullParameter(hashMap, "animationResultUrl");
        Intrinsics.checkNotNullParameter(fromWhere, "fromWhere");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        Intrinsics.checkNotNullParameter(spaceBgSetUrl, "spaceBgSetUrl");
        Intrinsics.checkNotNullParameter(hCardLightUrl, "hCardLightUrl");
        Intrinsics.checkNotNullParameter(vCardLightUrl, "vCardLightUrl");
        Intrinsics.checkNotNullParameter(hCardShadowUrl, "hCardShadowUrl");
        Intrinsics.checkNotNullParameter(vCardShadowUrl, "vCardShadowUrl");
        this.type = type;
        this.jumpId = jumpId;
        this.notOnSale = notOnSale;
        this.roundId = roundId;
        this.actId = actId;
        this.bookX = bookX;
        this.bookY = bookY;
        this.extra = extra;
        this.cardList = arrayList;
        this.drawCount = drawCount;
        this.animationDrawUrl = animationDrawUrl;
        this.animationResultUrl = hashMap;
        this.booked = booked;
        this.overtime = overtime;
        this.mid = mid;
        this.fromWhere = fromWhere;
        this.fromId = fromId;
        this.fSource = fSource;
        this.sourceType = sourceType;
        this.spaceBgSetUrl = spaceBgSetUrl;
        this.hCardLightUrl = hCardLightUrl;
        this.vCardLightUrl = vCardLightUrl;
        this.hCardShadowUrl = hCardShadowUrl;
        this.vCardShadowUrl = vCardShadowUrl;
        this.extraMap = new HashMap<>();
    }

    public final int getType() {
        return this.type;
    }

    public final int getJumpId() {
        return this.jumpId;
    }

    public final int getNotOnSale() {
        return this.notOnSale;
    }

    public final int getRoundId() {
        return this.roundId;
    }

    public final int getActId() {
        return this.actId;
    }

    public final int getBookX() {
        return this.bookX;
    }

    public final int getBookY() {
        return this.bookY;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final ArrayList<NftCardDetailModel> getCardList() {
        return this.cardList;
    }

    public final int getDrawCount() {
        return this.drawCount;
    }

    public final void setDrawCount(int i) {
        this.drawCount = i;
    }

    public final String getAnimationDrawUrl() {
        return this.animationDrawUrl;
    }

    public final HashMap<String, String> getAnimationResultUrl() {
        return this.animationResultUrl;
    }

    public final boolean getBooked() {
        return this.booked;
    }

    public final boolean getOvertime() {
        return this.overtime;
    }

    public final long getMid() {
        return this.mid;
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

    public final int getSourceType() {
        return this.sourceType;
    }

    public final String getSpaceBgSetUrl() {
        return this.spaceBgSetUrl;
    }

    public final String getHCardLightUrl() {
        return this.hCardLightUrl;
    }

    public final String getVCardLightUrl() {
        return this.vCardLightUrl;
    }

    public final String getHCardShadowUrl() {
        return this.hCardShadowUrl;
    }

    public final String getVCardShadowUrl() {
        return this.vCardShadowUrl;
    }

    public final HashMap<String, String> getExtraMap() {
        return this.extraMap;
    }

    public final void setExtraMap(HashMap<String, String> hashMap) {
        this.extraMap = hashMap;
    }
}