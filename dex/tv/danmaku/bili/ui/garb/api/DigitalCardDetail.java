package tv.danmaku.bili.ui.garb.api;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bili.digital.common.CardNumberGradientColor;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;

/* compiled from: DigitalCardDetail.kt */
@Bson
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bQ\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+¢\u0006\u0004\b,\u0010-J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\tHÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0006HÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\u0019\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u0012HÆ\u0003J\t\u0010b\u001a\u00020\u0006HÆ\u0003J\t\u0010c\u001a\u00020\tHÆ\u0003J\t\u0010d\u001a\u00020\u0006HÆ\u0003J\t\u0010e\u001a\u00020\u0006HÆ\u0003J\t\u0010f\u001a\u00020\u0006HÆ\u0003J\t\u0010g\u001a\u00020\tHÆ\u0003J\t\u0010h\u001a\u00020\tHÆ\u0003J\t\u0010i\u001a\u00020\tHÆ\u0003J\t\u0010j\u001a\u00020\tHÆ\u0003J\t\u0010k\u001a\u00020\tHÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\t\u0010m\u001a\u00020\u0006HÆ\u0003J\t\u0010n\u001a\u00020\tHÆ\u0003J\t\u0010o\u001a\u00020\tHÆ\u0003J\t\u0010p\u001a\u00020\tHÆ\u0003J\t\u0010q\u001a\u00020\u0006HÆ\u0003J\t\u0010r\u001a\u00020\tHÆ\u0003J\t\u0010s\u001a\u00020%HÆ\u0003J\t\u0010t\u001a\u00020'HÆ\u0003J\t\u0010u\u001a\u00020)HÆ\u0003J\t\u0010v\u001a\u00020+HÆ\u0003Jã\u0002\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+HÆ\u0001J\u0013\u0010x\u001a\u00020%2\b\u0010y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010z\u001a\u00020\u0006HÖ\u0001J\t\u0010{\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00105R\u0016\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00105R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00102R\u0016\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00105R\u0016\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00102R\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00102R\u0016\u0010\u0018\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00105R\u0016\u0010\u0019\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u00105R\u0016\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00105R\u0016\u0010\u001b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00105R\u0016\u0010\u001c\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00105R\u0016\u0010\u001d\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00105R\u0016\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00102R\u0016\u0010\u001f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00105R\u0016\u0010 \u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0016\u0010!\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00105R\u0016\u0010\"\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00102R\u0016\u0010#\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00105R\u0016\u0010$\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010OR\u0016\u0010&\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0016\u0010(\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010U¨\u0006|"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/DigitalCardDetail;", "", "cardTypeId", "", "cardId", "cardType", "", "status", "cardName", "", "cardNo", "cardNoShow", "cardScarcity", "totalCnt", "totalCntShow", "cardImg", "videoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "silence", "realChance", "needRequest", "width", "height", "hCardLightUrl", "hCardShadowUrl", "vCardLightUrl", "vCardShadowUrl", "jumpDesc", "jumpLink", "actId", "activityDesc", "activityLink", "iconUrl", "overtime", "subtitlesUrl", "isTrialPlay", "", "play", "Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", AppConfig.HOST_TAG, "Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "cardNumberGradientColor", "Lcom/bili/digital/common/CardNumberGradientColor;", "<init>", "(JJIILjava/lang/String;JLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLtv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;Lcom/bili/digital/common/CardNumberGradientColor;)V", "getCardTypeId", "()J", "getCardId", "getCardType", "()I", "getStatus", "getCardName", "()Ljava/lang/String;", "getCardNo", "getCardNoShow", "getCardScarcity", "getTotalCnt", "getTotalCntShow", "getCardImg", "getVideoList", "()Ljava/util/ArrayList;", "getSilence", "getRealChance", "getNeedRequest", "getWidth", "getHeight", "getHCardLightUrl", "getHCardShadowUrl", "getVCardLightUrl", "getVCardShadowUrl", "getJumpDesc", "getJumpLink", "getActId", "getActivityDesc", "getActivityLink", "getIconUrl", "getOvertime", "getSubtitlesUrl", "()Z", "getPlay", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", "getTag", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "getCardNumberGradientColor", "()Lcom/bili/digital/common/CardNumberGradientColor;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetail {
    public static final int $stable = 8;
    @SerializedName("act_id")
    private final int actId;
    @SerializedName("activity_desc")
    private final String activityDesc;
    @SerializedName("activity_link")
    private final String activityLink;
    @SerializedName("card_id")
    private final long cardId;
    @SerializedName("card_img")
    private final String cardImg;
    @SerializedName("card_name")
    private final String cardName;
    @SerializedName("card_no")
    private final long cardNo;
    @SerializedName("card_no_show")
    private final String cardNoShow;
    @SerializedName("card_NumberGradientColor")
    private final CardNumberGradientColor cardNumberGradientColor;
    @SerializedName("card_scarcity")
    private final long cardScarcity;
    @SerializedName("card_type")
    private final int cardType;
    @SerializedName("card_type_id")
    private final long cardTypeId;
    @SerializedName("horizontal_card_light_url")
    private final String hCardLightUrl;
    @SerializedName("horizontal_card_shadow_url")
    private final String hCardShadowUrl;
    @SerializedName("height")
    private final int height;
    @SerializedName("icon_url")
    private final String iconUrl;
    @SerializedName("trial_play")
    private final boolean isTrialPlay;
    @SerializedName("jump_desc")
    private final String jumpDesc;
    @SerializedName("jump_link")
    private final String jumpLink;
    @SerializedName("is_req_detail")
    private final int needRequest;
    @SerializedName("is_overtime")
    private final int overtime;
    @SerializedName("play")
    private final DLCPlayModel play;
    @SerializedName("holding_rate")
    private final String realChance;
    @SerializedName("is_mute")
    private final int silence;
    @SerializedName("card_status")
    private final int status;
    @SerializedName("subtitles_url")
    private final String subtitlesUrl;
    @SerializedName(AppConfig.HOST_TAG)
    private final DLCTagModel tag;
    @SerializedName("card_cnt")
    private final int totalCnt;
    @SerializedName("total_cnt_show")
    private final String totalCntShow;
    @SerializedName("vertical_card_light_url")
    private final String vCardLightUrl;
    @SerializedName("vertical_card_shadow_url")
    private final String vCardShadowUrl;
    @SerializedName("video_list")
    private final ArrayList<String> videoList;
    @SerializedName("width")
    private final int width;

    public final long component1() {
        return this.cardTypeId;
    }

    public final String component10() {
        return this.totalCntShow;
    }

    public final String component11() {
        return this.cardImg;
    }

    public final ArrayList<String> component12() {
        return this.videoList;
    }

    public final int component13() {
        return this.silence;
    }

    public final String component14() {
        return this.realChance;
    }

    public final int component15() {
        return this.needRequest;
    }

    public final int component16() {
        return this.width;
    }

    public final int component17() {
        return this.height;
    }

    public final String component18() {
        return this.hCardLightUrl;
    }

    public final String component19() {
        return this.hCardShadowUrl;
    }

    public final long component2() {
        return this.cardId;
    }

    public final String component20() {
        return this.vCardLightUrl;
    }

    public final String component21() {
        return this.vCardShadowUrl;
    }

    public final String component22() {
        return this.jumpDesc;
    }

    public final String component23() {
        return this.jumpLink;
    }

    public final int component24() {
        return this.actId;
    }

    public final String component25() {
        return this.activityDesc;
    }

    public final String component26() {
        return this.activityLink;
    }

    public final String component27() {
        return this.iconUrl;
    }

    public final int component28() {
        return this.overtime;
    }

    public final String component29() {
        return this.subtitlesUrl;
    }

    public final int component3() {
        return this.cardType;
    }

    public final boolean component30() {
        return this.isTrialPlay;
    }

    public final DLCPlayModel component31() {
        return this.play;
    }

    public final DLCTagModel component32() {
        return this.tag;
    }

    public final CardNumberGradientColor component33() {
        return this.cardNumberGradientColor;
    }

    public final int component4() {
        return this.status;
    }

    public final String component5() {
        return this.cardName;
    }

    public final long component6() {
        return this.cardNo;
    }

    public final String component7() {
        return this.cardNoShow;
    }

    public final long component8() {
        return this.cardScarcity;
    }

    public final int component9() {
        return this.totalCnt;
    }

    public final DigitalCardDetail copy(long j, long j2, int i, int i2, String str, long j3, String str2, long j4, int i3, String str3, String str4, ArrayList<String> arrayList, int i4, String str5, int i5, int i6, int i7, String str6, String str7, String str8, String str9, String str10, String str11, int i8, String str12, String str13, String str14, int i9, String str15, boolean z, DLCPlayModel dLCPlayModel, DLCTagModel dLCTagModel, CardNumberGradientColor cardNumberGradientColor) {
        Intrinsics.checkNotNullParameter(str, "cardName");
        Intrinsics.checkNotNullParameter(str2, "cardNoShow");
        Intrinsics.checkNotNullParameter(str3, "totalCntShow");
        Intrinsics.checkNotNullParameter(str4, "cardImg");
        Intrinsics.checkNotNullParameter(arrayList, "videoList");
        Intrinsics.checkNotNullParameter(str5, "realChance");
        Intrinsics.checkNotNullParameter(str6, "hCardLightUrl");
        Intrinsics.checkNotNullParameter(str7, "hCardShadowUrl");
        Intrinsics.checkNotNullParameter(str8, "vCardLightUrl");
        Intrinsics.checkNotNullParameter(str9, "vCardShadowUrl");
        Intrinsics.checkNotNullParameter(str10, "jumpDesc");
        Intrinsics.checkNotNullParameter(str11, "jumpLink");
        Intrinsics.checkNotNullParameter(str12, "activityDesc");
        Intrinsics.checkNotNullParameter(str13, "activityLink");
        Intrinsics.checkNotNullParameter(str14, "iconUrl");
        Intrinsics.checkNotNullParameter(str15, "subtitlesUrl");
        Intrinsics.checkNotNullParameter(dLCPlayModel, "play");
        Intrinsics.checkNotNullParameter(dLCTagModel, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(cardNumberGradientColor, "cardNumberGradientColor");
        return new DigitalCardDetail(j, j2, i, i2, str, j3, str2, j4, i3, str3, str4, arrayList, i4, str5, i5, i6, i7, str6, str7, str8, str9, str10, str11, i8, str12, str13, str14, i9, str15, z, dLCPlayModel, dLCTagModel, cardNumberGradientColor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DigitalCardDetail) {
            DigitalCardDetail digitalCardDetail = (DigitalCardDetail) obj;
            return this.cardTypeId == digitalCardDetail.cardTypeId && this.cardId == digitalCardDetail.cardId && this.cardType == digitalCardDetail.cardType && this.status == digitalCardDetail.status && Intrinsics.areEqual(this.cardName, digitalCardDetail.cardName) && this.cardNo == digitalCardDetail.cardNo && Intrinsics.areEqual(this.cardNoShow, digitalCardDetail.cardNoShow) && this.cardScarcity == digitalCardDetail.cardScarcity && this.totalCnt == digitalCardDetail.totalCnt && Intrinsics.areEqual(this.totalCntShow, digitalCardDetail.totalCntShow) && Intrinsics.areEqual(this.cardImg, digitalCardDetail.cardImg) && Intrinsics.areEqual(this.videoList, digitalCardDetail.videoList) && this.silence == digitalCardDetail.silence && Intrinsics.areEqual(this.realChance, digitalCardDetail.realChance) && this.needRequest == digitalCardDetail.needRequest && this.width == digitalCardDetail.width && this.height == digitalCardDetail.height && Intrinsics.areEqual(this.hCardLightUrl, digitalCardDetail.hCardLightUrl) && Intrinsics.areEqual(this.hCardShadowUrl, digitalCardDetail.hCardShadowUrl) && Intrinsics.areEqual(this.vCardLightUrl, digitalCardDetail.vCardLightUrl) && Intrinsics.areEqual(this.vCardShadowUrl, digitalCardDetail.vCardShadowUrl) && Intrinsics.areEqual(this.jumpDesc, digitalCardDetail.jumpDesc) && Intrinsics.areEqual(this.jumpLink, digitalCardDetail.jumpLink) && this.actId == digitalCardDetail.actId && Intrinsics.areEqual(this.activityDesc, digitalCardDetail.activityDesc) && Intrinsics.areEqual(this.activityLink, digitalCardDetail.activityLink) && Intrinsics.areEqual(this.iconUrl, digitalCardDetail.iconUrl) && this.overtime == digitalCardDetail.overtime && Intrinsics.areEqual(this.subtitlesUrl, digitalCardDetail.subtitlesUrl) && this.isTrialPlay == digitalCardDetail.isTrialPlay && Intrinsics.areEqual(this.play, digitalCardDetail.play) && Intrinsics.areEqual(this.tag, digitalCardDetail.tag) && Intrinsics.areEqual(this.cardNumberGradientColor, digitalCardDetail.cardNumberGradientColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardId)) * 31) + this.cardType) * 31) + this.status) * 31) + this.cardName.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardNo)) * 31) + this.cardNoShow.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardScarcity)) * 31) + this.totalCnt) * 31) + this.totalCntShow.hashCode()) * 31) + this.cardImg.hashCode()) * 31) + this.videoList.hashCode()) * 31) + this.silence) * 31) + this.realChance.hashCode()) * 31) + this.needRequest) * 31) + this.width) * 31) + this.height) * 31) + this.hCardLightUrl.hashCode()) * 31) + this.hCardShadowUrl.hashCode()) * 31) + this.vCardLightUrl.hashCode()) * 31) + this.vCardShadowUrl.hashCode()) * 31) + this.jumpDesc.hashCode()) * 31) + this.jumpLink.hashCode()) * 31) + this.actId) * 31) + this.activityDesc.hashCode()) * 31) + this.activityLink.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.overtime) * 31) + this.subtitlesUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isTrialPlay)) * 31) + this.play.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.cardNumberGradientColor.hashCode();
    }

    public String toString() {
        long j = this.cardTypeId;
        long j2 = this.cardId;
        int i = this.cardType;
        int i2 = this.status;
        String str = this.cardName;
        long j3 = this.cardNo;
        String str2 = this.cardNoShow;
        long j4 = this.cardScarcity;
        int i3 = this.totalCnt;
        String str3 = this.totalCntShow;
        String str4 = this.cardImg;
        ArrayList<String> arrayList = this.videoList;
        int i4 = this.silence;
        String str5 = this.realChance;
        int i5 = this.needRequest;
        int i6 = this.width;
        int i7 = this.height;
        String str6 = this.hCardLightUrl;
        String str7 = this.hCardShadowUrl;
        String str8 = this.vCardLightUrl;
        String str9 = this.vCardShadowUrl;
        String str10 = this.jumpDesc;
        String str11 = this.jumpLink;
        int i8 = this.actId;
        String str12 = this.activityDesc;
        String str13 = this.activityLink;
        String str14 = this.iconUrl;
        int i9 = this.overtime;
        String str15 = this.subtitlesUrl;
        boolean z = this.isTrialPlay;
        DLCPlayModel dLCPlayModel = this.play;
        DLCTagModel dLCTagModel = this.tag;
        return "DigitalCardDetail(cardTypeId=" + j + ", cardId=" + j2 + ", cardType=" + i + ", status=" + i2 + ", cardName=" + str + ", cardNo=" + j3 + ", cardNoShow=" + str2 + ", cardScarcity=" + j4 + ", totalCnt=" + i3 + ", totalCntShow=" + str3 + ", cardImg=" + str4 + ", videoList=" + arrayList + ", silence=" + i4 + ", realChance=" + str5 + ", needRequest=" + i5 + ", width=" + i6 + ", height=" + i7 + ", hCardLightUrl=" + str6 + ", hCardShadowUrl=" + str7 + ", vCardLightUrl=" + str8 + ", vCardShadowUrl=" + str9 + ", jumpDesc=" + str10 + ", jumpLink=" + str11 + ", actId=" + i8 + ", activityDesc=" + str12 + ", activityLink=" + str13 + ", iconUrl=" + str14 + ", overtime=" + i9 + ", subtitlesUrl=" + str15 + ", isTrialPlay=" + z + ", play=" + dLCPlayModel + ", tag=" + dLCTagModel + ", cardNumberGradientColor=" + this.cardNumberGradientColor + ")";
    }

    public DigitalCardDetail(long cardTypeId, long cardId, int cardType, int status, String cardName, long cardNo, String cardNoShow, long cardScarcity, int totalCnt, String totalCntShow, String cardImg, ArrayList<String> arrayList, int silence, String realChance, int needRequest, int width, int height, String hCardLightUrl, String hCardShadowUrl, String vCardLightUrl, String vCardShadowUrl, String jumpDesc, String jumpLink, int actId, String activityDesc, String activityLink, String iconUrl, int overtime, String subtitlesUrl, boolean isTrialPlay, DLCPlayModel play, DLCTagModel tag, CardNumberGradientColor cardNumberGradientColor) {
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(cardNoShow, "cardNoShow");
        Intrinsics.checkNotNullParameter(totalCntShow, "totalCntShow");
        Intrinsics.checkNotNullParameter(cardImg, "cardImg");
        Intrinsics.checkNotNullParameter(arrayList, "videoList");
        Intrinsics.checkNotNullParameter(realChance, "realChance");
        Intrinsics.checkNotNullParameter(hCardLightUrl, "hCardLightUrl");
        Intrinsics.checkNotNullParameter(hCardShadowUrl, "hCardShadowUrl");
        Intrinsics.checkNotNullParameter(vCardLightUrl, "vCardLightUrl");
        Intrinsics.checkNotNullParameter(vCardShadowUrl, "vCardShadowUrl");
        Intrinsics.checkNotNullParameter(jumpDesc, "jumpDesc");
        Intrinsics.checkNotNullParameter(jumpLink, "jumpLink");
        Intrinsics.checkNotNullParameter(activityDesc, "activityDesc");
        Intrinsics.checkNotNullParameter(activityLink, "activityLink");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(subtitlesUrl, "subtitlesUrl");
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(cardNumberGradientColor, "cardNumberGradientColor");
        this.cardTypeId = cardTypeId;
        this.cardId = cardId;
        this.cardType = cardType;
        this.status = status;
        this.cardName = cardName;
        this.cardNo = cardNo;
        this.cardNoShow = cardNoShow;
        this.cardScarcity = cardScarcity;
        this.totalCnt = totalCnt;
        this.totalCntShow = totalCntShow;
        this.cardImg = cardImg;
        this.videoList = arrayList;
        this.silence = silence;
        this.realChance = realChance;
        this.needRequest = needRequest;
        this.width = width;
        this.height = height;
        this.hCardLightUrl = hCardLightUrl;
        this.hCardShadowUrl = hCardShadowUrl;
        this.vCardLightUrl = vCardLightUrl;
        this.vCardShadowUrl = vCardShadowUrl;
        this.jumpDesc = jumpDesc;
        this.jumpLink = jumpLink;
        this.actId = actId;
        this.activityDesc = activityDesc;
        this.activityLink = activityLink;
        this.iconUrl = iconUrl;
        this.overtime = overtime;
        this.subtitlesUrl = subtitlesUrl;
        this.isTrialPlay = isTrialPlay;
        this.play = play;
        this.tag = tag;
        this.cardNumberGradientColor = cardNumberGradientColor;
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final long getCardNo() {
        return this.cardNo;
    }

    public final String getCardNoShow() {
        return this.cardNoShow;
    }

    public final long getCardScarcity() {
        return this.cardScarcity;
    }

    public final int getTotalCnt() {
        return this.totalCnt;
    }

    public final String getTotalCntShow() {
        return this.totalCntShow;
    }

    public final String getCardImg() {
        return this.cardImg;
    }

    public final ArrayList<String> getVideoList() {
        return this.videoList;
    }

    public final int getSilence() {
        return this.silence;
    }

    public final String getRealChance() {
        return this.realChance;
    }

    public final int getNeedRequest() {
        return this.needRequest;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getHCardLightUrl() {
        return this.hCardLightUrl;
    }

    public final String getHCardShadowUrl() {
        return this.hCardShadowUrl;
    }

    public final String getVCardLightUrl() {
        return this.vCardLightUrl;
    }

    public final String getVCardShadowUrl() {
        return this.vCardShadowUrl;
    }

    public final String getJumpDesc() {
        return this.jumpDesc;
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }

    public final int getActId() {
        return this.actId;
    }

    public final String getActivityDesc() {
        return this.activityDesc;
    }

    public final String getActivityLink() {
        return this.activityLink;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getOvertime() {
        return this.overtime;
    }

    public final String getSubtitlesUrl() {
        return this.subtitlesUrl;
    }

    public final boolean isTrialPlay() {
        return this.isTrialPlay;
    }

    public final DLCPlayModel getPlay() {
        return this.play;
    }

    public final DLCTagModel getTag() {
        return this.tag;
    }

    public final CardNumberGradientColor getCardNumberGradientColor() {
        return this.cardNumberGradientColor;
    }
}