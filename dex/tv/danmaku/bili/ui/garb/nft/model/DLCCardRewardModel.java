package tv.danmaku.bili.ui.garb.nft.model;

import BottomSheetItemData$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardItem;

/* compiled from: DLCCardRewardModel.kt */
@Bson
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b[\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030*\u0012\u0006\u0010+\u001a\u00020'\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0004\b.\u0010/J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0006HÆ\u0003J\t\u0010_\u001a\u00020\u0006HÆ\u0003J\t\u0010`\u001a\u00020\u0006HÆ\u0003J\t\u0010a\u001a\u00020\u0006HÆ\u0003J\t\u0010b\u001a\u00020\u0006HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0006HÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0006HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0006HÆ\u0003J\t\u0010n\u001a\u00020\u0006HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u001fHÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\u0006HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0002\u0010TJ\t\u0010~\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00030*HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020'HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\u0096\u0003\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u00062\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030*2\b\b\u0002\u0010+\u001a\u00020'2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-HÆ\u0001¢\u0006\u0003\u0010\u0083\u0001J\u0015\u0010\u0084\u0001\u001a\u00020'2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0006HÖ\u0001J\n\u0010\u0087\u0001\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00104R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00101R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00104R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00101R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00101R\u0016\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00101R\u0016\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00101R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00101R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00101R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00101R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00101R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00101R\u0016\u0010\u001e\u001a\u00020\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0016\u0010 \u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00101R\u0016\u0010!\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00101R\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00101R\u0016\u0010#\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u00101R\u0016\u0010$\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00101R\u0016\u0010%\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00104R\u0015\u0010&\u001a\u0004\u0018\u00010'¢\u0006\n\n\u0002\u0010U\u001a\u0004\b&\u0010TR\u0011\u0010(\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bV\u00104R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030*¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0011\u0010+\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b+\u0010YR\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[¨\u0006\u0088\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;", "", "activityId", "", "callbackId", "shareType", "", "screenType", "hasDrawCardAnimation", "hasCardAnimation", "collectId", "collectName", "endTime", "startTime", "hasRedeemedCount", "ownerItemAamount", "redeemItemId", "redeemItemImage", "redeemItemName", "redeemItemType", "redeemText", "requireItemAmount", "gained", "garbSuitUrl", "garbApplyUrl", "spaceBgSetUrl", "horizontalCardLightUrl", "verticalCardLightUrl", "horizontalCardShadowUrl", "verticalCardShadowUrl", "cardItem", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;", "fromWhere", "fromId", "rewardTag", "rewardTip", "fSource", "pageType", "isHighlight", "", "materialType", "videoList", "", "isMute", "collectProgressButton", "Ltv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;ILjava/util/List;ZLtv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;)V", "getActivityId", "()Ljava/lang/String;", "getCallbackId", "getShareType", "()I", "getScreenType", "getHasDrawCardAnimation", "getHasCardAnimation", "getCollectId", "getCollectName", "getEndTime", "getStartTime", "getHasRedeemedCount", "getOwnerItemAamount", "getRedeemItemId", "getRedeemItemImage", "getRedeemItemName", "getRedeemItemType", "getRedeemText", "getRequireItemAmount", "getGained", "getGarbSuitUrl", "getGarbApplyUrl", "getSpaceBgSetUrl", "getHorizontalCardLightUrl", "getVerticalCardLightUrl", "getHorizontalCardShadowUrl", "getVerticalCardShadowUrl", "getCardItem", "()Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;", "getFromWhere", "getFromId", "getRewardTag", "getRewardTip", "getFSource", "getPageType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaterialType", "getVideoList", "()Ljava/util/List;", "()Z", "getCollectProgressButton", "()Ltv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "(Ljava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;ILjava/util/List;ZLtv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;)Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardRewardModel {
    public static final int $stable = 8;
    @SerializedName("act_id")
    private final String activityId;
    @SerializedName("callbackId")
    private final String callbackId;
    @SerializedName("card_item")
    private final BiliDLCCardItem cardItem;
    @SerializedName("collect_id")
    private final int collectId;
    @SerializedName("collect_name")
    private final String collectName;
    private final CollectProgressButton collectProgressButton;
    @SerializedName("end_time")
    private final String endTime;
    @SerializedName("f_source")
    private final String fSource;
    @SerializedName("from_id")
    private final String fromId;
    @SerializedName("from")
    private final String fromWhere;
    @SerializedName("is_gained")
    private final int gained;
    @SerializedName("garb_apply_url")
    private final String garbApplyUrl;
    @SerializedName("garb_suit_url")
    private final String garbSuitUrl;
    @SerializedName("has_card_ani")
    private final int hasCardAnimation;
    @SerializedName("has_draw_ani")
    private final int hasDrawCardAnimation;
    @SerializedName("has_redeemed_cnt")
    private final int hasRedeemedCount;
    @SerializedName("horizontal_card_light_url")
    private final String horizontalCardLightUrl;
    @SerializedName("horizontal_card_shadow_url")
    private final String horizontalCardShadowUrl;
    private final Boolean isHighlight;
    private final boolean isMute;
    private final int materialType;
    @SerializedName("owner_item_amount")
    private final int ownerItemAamount;
    @SerializedName("page_type")
    private final int pageType;
    @SerializedName("redeem_item_id")
    private final String redeemItemId;
    @SerializedName("redeem_item_image")
    private final String redeemItemImage;
    @SerializedName("redeem_item_name")
    private final String redeemItemName;
    @SerializedName("redeem_item_type")
    private final int redeemItemType;
    @SerializedName("redeem_text")
    private final String redeemText;
    @SerializedName("require_item_amount")
    private final int requireItemAmount;
    @SerializedName("reward_tag")
    private final String rewardTag;
    @SerializedName("reward_tip")
    private final String rewardTip;
    @SerializedName("screen_type")
    private final int screenType;
    @SerializedName("share_type")
    private final int shareType;
    @SerializedName("space_bg_set_url")
    private final String spaceBgSetUrl;
    @SerializedName("start_time")
    private final String startTime;
    @SerializedName("vertical_card_light_url")
    private final String verticalCardLightUrl;
    @SerializedName("vertical_card_shadow_url")
    private final String verticalCardShadowUrl;
    private final List<String> videoList;

    public final String component1() {
        return this.activityId;
    }

    public final String component10() {
        return this.startTime;
    }

    public final int component11() {
        return this.hasRedeemedCount;
    }

    public final int component12() {
        return this.ownerItemAamount;
    }

    public final String component13() {
        return this.redeemItemId;
    }

    public final String component14() {
        return this.redeemItemImage;
    }

    public final String component15() {
        return this.redeemItemName;
    }

    public final int component16() {
        return this.redeemItemType;
    }

    public final String component17() {
        return this.redeemText;
    }

    public final int component18() {
        return this.requireItemAmount;
    }

    public final int component19() {
        return this.gained;
    }

    public final String component2() {
        return this.callbackId;
    }

    public final String component20() {
        return this.garbSuitUrl;
    }

    public final String component21() {
        return this.garbApplyUrl;
    }

    public final String component22() {
        return this.spaceBgSetUrl;
    }

    public final String component23() {
        return this.horizontalCardLightUrl;
    }

    public final String component24() {
        return this.verticalCardLightUrl;
    }

    public final String component25() {
        return this.horizontalCardShadowUrl;
    }

    public final String component26() {
        return this.verticalCardShadowUrl;
    }

    public final BiliDLCCardItem component27() {
        return this.cardItem;
    }

    public final String component28() {
        return this.fromWhere;
    }

    public final String component29() {
        return this.fromId;
    }

    public final int component3() {
        return this.shareType;
    }

    public final String component30() {
        return this.rewardTag;
    }

    public final String component31() {
        return this.rewardTip;
    }

    public final String component32() {
        return this.fSource;
    }

    public final int component33() {
        return this.pageType;
    }

    public final Boolean component34() {
        return this.isHighlight;
    }

    public final int component35() {
        return this.materialType;
    }

    public final List<String> component36() {
        return this.videoList;
    }

    public final boolean component37() {
        return this.isMute;
    }

    public final CollectProgressButton component38() {
        return this.collectProgressButton;
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
        return this.collectId;
    }

    public final String component8() {
        return this.collectName;
    }

    public final String component9() {
        return this.endTime;
    }

    public final DLCCardRewardModel copy(String str, String str2, int i, int i2, int i3, int i4, int i5, String str3, String str4, String str5, int i6, int i7, String str6, String str7, String str8, int i8, String str9, int i9, int i10, String str10, String str11, String str12, String str13, String str14, String str15, String str16, BiliDLCCardItem biliDLCCardItem, String str17, String str18, String str19, String str20, String str21, int i11, Boolean bool, int i12, List<String> list, boolean z, CollectProgressButton collectProgressButton) {
        Intrinsics.checkNotNullParameter(str, "activityId");
        Intrinsics.checkNotNullParameter(str2, "callbackId");
        Intrinsics.checkNotNullParameter(str3, "collectName");
        Intrinsics.checkNotNullParameter(str4, "endTime");
        Intrinsics.checkNotNullParameter(str5, "startTime");
        Intrinsics.checkNotNullParameter(str6, "redeemItemId");
        Intrinsics.checkNotNullParameter(str7, "redeemItemImage");
        Intrinsics.checkNotNullParameter(str8, "redeemItemName");
        Intrinsics.checkNotNullParameter(str9, "redeemText");
        Intrinsics.checkNotNullParameter(str10, "garbSuitUrl");
        Intrinsics.checkNotNullParameter(str11, "garbApplyUrl");
        Intrinsics.checkNotNullParameter(str12, "spaceBgSetUrl");
        Intrinsics.checkNotNullParameter(str13, "horizontalCardLightUrl");
        Intrinsics.checkNotNullParameter(str14, "verticalCardLightUrl");
        Intrinsics.checkNotNullParameter(str15, "horizontalCardShadowUrl");
        Intrinsics.checkNotNullParameter(str16, "verticalCardShadowUrl");
        Intrinsics.checkNotNullParameter(biliDLCCardItem, "cardItem");
        Intrinsics.checkNotNullParameter(str17, "fromWhere");
        Intrinsics.checkNotNullParameter(str18, "fromId");
        Intrinsics.checkNotNullParameter(str19, "rewardTag");
        Intrinsics.checkNotNullParameter(str20, "rewardTip");
        Intrinsics.checkNotNullParameter(str21, "fSource");
        Intrinsics.checkNotNullParameter(list, "videoList");
        return new DLCCardRewardModel(str, str2, i, i2, i3, i4, i5, str3, str4, str5, i6, i7, str6, str7, str8, i8, str9, i9, i10, str10, str11, str12, str13, str14, str15, str16, biliDLCCardItem, str17, str18, str19, str20, str21, i11, bool, i12, list, z, collectProgressButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCCardRewardModel) {
            DLCCardRewardModel dLCCardRewardModel = (DLCCardRewardModel) obj;
            return Intrinsics.areEqual(this.activityId, dLCCardRewardModel.activityId) && Intrinsics.areEqual(this.callbackId, dLCCardRewardModel.callbackId) && this.shareType == dLCCardRewardModel.shareType && this.screenType == dLCCardRewardModel.screenType && this.hasDrawCardAnimation == dLCCardRewardModel.hasDrawCardAnimation && this.hasCardAnimation == dLCCardRewardModel.hasCardAnimation && this.collectId == dLCCardRewardModel.collectId && Intrinsics.areEqual(this.collectName, dLCCardRewardModel.collectName) && Intrinsics.areEqual(this.endTime, dLCCardRewardModel.endTime) && Intrinsics.areEqual(this.startTime, dLCCardRewardModel.startTime) && this.hasRedeemedCount == dLCCardRewardModel.hasRedeemedCount && this.ownerItemAamount == dLCCardRewardModel.ownerItemAamount && Intrinsics.areEqual(this.redeemItemId, dLCCardRewardModel.redeemItemId) && Intrinsics.areEqual(this.redeemItemImage, dLCCardRewardModel.redeemItemImage) && Intrinsics.areEqual(this.redeemItemName, dLCCardRewardModel.redeemItemName) && this.redeemItemType == dLCCardRewardModel.redeemItemType && Intrinsics.areEqual(this.redeemText, dLCCardRewardModel.redeemText) && this.requireItemAmount == dLCCardRewardModel.requireItemAmount && this.gained == dLCCardRewardModel.gained && Intrinsics.areEqual(this.garbSuitUrl, dLCCardRewardModel.garbSuitUrl) && Intrinsics.areEqual(this.garbApplyUrl, dLCCardRewardModel.garbApplyUrl) && Intrinsics.areEqual(this.spaceBgSetUrl, dLCCardRewardModel.spaceBgSetUrl) && Intrinsics.areEqual(this.horizontalCardLightUrl, dLCCardRewardModel.horizontalCardLightUrl) && Intrinsics.areEqual(this.verticalCardLightUrl, dLCCardRewardModel.verticalCardLightUrl) && Intrinsics.areEqual(this.horizontalCardShadowUrl, dLCCardRewardModel.horizontalCardShadowUrl) && Intrinsics.areEqual(this.verticalCardShadowUrl, dLCCardRewardModel.verticalCardShadowUrl) && Intrinsics.areEqual(this.cardItem, dLCCardRewardModel.cardItem) && Intrinsics.areEqual(this.fromWhere, dLCCardRewardModel.fromWhere) && Intrinsics.areEqual(this.fromId, dLCCardRewardModel.fromId) && Intrinsics.areEqual(this.rewardTag, dLCCardRewardModel.rewardTag) && Intrinsics.areEqual(this.rewardTip, dLCCardRewardModel.rewardTip) && Intrinsics.areEqual(this.fSource, dLCCardRewardModel.fSource) && this.pageType == dLCCardRewardModel.pageType && Intrinsics.areEqual(this.isHighlight, dLCCardRewardModel.isHighlight) && this.materialType == dLCCardRewardModel.materialType && Intrinsics.areEqual(this.videoList, dLCCardRewardModel.videoList) && this.isMute == dLCCardRewardModel.isMute && Intrinsics.areEqual(this.collectProgressButton, dLCCardRewardModel.collectProgressButton);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.activityId.hashCode() * 31) + this.callbackId.hashCode()) * 31) + this.shareType) * 31) + this.screenType) * 31) + this.hasDrawCardAnimation) * 31) + this.hasCardAnimation) * 31) + this.collectId) * 31) + this.collectName.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.hasRedeemedCount) * 31) + this.ownerItemAamount) * 31) + this.redeemItemId.hashCode()) * 31) + this.redeemItemImage.hashCode()) * 31) + this.redeemItemName.hashCode()) * 31) + this.redeemItemType) * 31) + this.redeemText.hashCode()) * 31) + this.requireItemAmount) * 31) + this.gained) * 31) + this.garbSuitUrl.hashCode()) * 31) + this.garbApplyUrl.hashCode()) * 31) + this.spaceBgSetUrl.hashCode()) * 31) + this.horizontalCardLightUrl.hashCode()) * 31) + this.verticalCardLightUrl.hashCode()) * 31) + this.horizontalCardShadowUrl.hashCode()) * 31) + this.verticalCardShadowUrl.hashCode()) * 31) + this.cardItem.hashCode()) * 31) + this.fromWhere.hashCode()) * 31) + this.fromId.hashCode()) * 31) + this.rewardTag.hashCode()) * 31) + this.rewardTip.hashCode()) * 31) + this.fSource.hashCode()) * 31) + this.pageType) * 31) + (this.isHighlight == null ? 0 : this.isHighlight.hashCode())) * 31) + this.materialType) * 31) + this.videoList.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMute)) * 31) + (this.collectProgressButton != null ? this.collectProgressButton.hashCode() : 0);
    }

    public String toString() {
        String str = this.activityId;
        String str2 = this.callbackId;
        int i = this.shareType;
        int i2 = this.screenType;
        int i3 = this.hasDrawCardAnimation;
        int i4 = this.hasCardAnimation;
        int i5 = this.collectId;
        String str3 = this.collectName;
        String str4 = this.endTime;
        String str5 = this.startTime;
        int i6 = this.hasRedeemedCount;
        int i7 = this.ownerItemAamount;
        String str6 = this.redeemItemId;
        String str7 = this.redeemItemImage;
        String str8 = this.redeemItemName;
        int i8 = this.redeemItemType;
        String str9 = this.redeemText;
        int i9 = this.requireItemAmount;
        int i10 = this.gained;
        String str10 = this.garbSuitUrl;
        String str11 = this.garbApplyUrl;
        String str12 = this.spaceBgSetUrl;
        String str13 = this.horizontalCardLightUrl;
        String str14 = this.verticalCardLightUrl;
        String str15 = this.horizontalCardShadowUrl;
        String str16 = this.verticalCardShadowUrl;
        BiliDLCCardItem biliDLCCardItem = this.cardItem;
        String str17 = this.fromWhere;
        String str18 = this.fromId;
        String str19 = this.rewardTag;
        String str20 = this.rewardTip;
        String str21 = this.fSource;
        int i11 = this.pageType;
        Boolean bool = this.isHighlight;
        int i12 = this.materialType;
        List<String> list = this.videoList;
        boolean z = this.isMute;
        return "DLCCardRewardModel(activityId=" + str + ", callbackId=" + str2 + ", shareType=" + i + ", screenType=" + i2 + ", hasDrawCardAnimation=" + i3 + ", hasCardAnimation=" + i4 + ", collectId=" + i5 + ", collectName=" + str3 + ", endTime=" + str4 + ", startTime=" + str5 + ", hasRedeemedCount=" + i6 + ", ownerItemAamount=" + i7 + ", redeemItemId=" + str6 + ", redeemItemImage=" + str7 + ", redeemItemName=" + str8 + ", redeemItemType=" + i8 + ", redeemText=" + str9 + ", requireItemAmount=" + i9 + ", gained=" + i10 + ", garbSuitUrl=" + str10 + ", garbApplyUrl=" + str11 + ", spaceBgSetUrl=" + str12 + ", horizontalCardLightUrl=" + str13 + ", verticalCardLightUrl=" + str14 + ", horizontalCardShadowUrl=" + str15 + ", verticalCardShadowUrl=" + str16 + ", cardItem=" + biliDLCCardItem + ", fromWhere=" + str17 + ", fromId=" + str18 + ", rewardTag=" + str19 + ", rewardTip=" + str20 + ", fSource=" + str21 + ", pageType=" + i11 + ", isHighlight=" + bool + ", materialType=" + i12 + ", videoList=" + list + ", isMute=" + z + ", collectProgressButton=" + this.collectProgressButton + ")";
    }

    public DLCCardRewardModel(String activityId, String callbackId, int shareType, int screenType, int hasDrawCardAnimation, int hasCardAnimation, int collectId, String collectName, String endTime, String startTime, int hasRedeemedCount, int ownerItemAamount, String redeemItemId, String redeemItemImage, String redeemItemName, int redeemItemType, String redeemText, int requireItemAmount, int gained, String garbSuitUrl, String garbApplyUrl, String spaceBgSetUrl, String horizontalCardLightUrl, String verticalCardLightUrl, String horizontalCardShadowUrl, String verticalCardShadowUrl, BiliDLCCardItem cardItem, String fromWhere, String fromId, String rewardTag, String rewardTip, String fSource, int pageType, Boolean isHighlight, int materialType, List<String> list, boolean isMute, CollectProgressButton collectProgressButton) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(collectName, "collectName");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(redeemItemId, "redeemItemId");
        Intrinsics.checkNotNullParameter(redeemItemImage, "redeemItemImage");
        Intrinsics.checkNotNullParameter(redeemItemName, "redeemItemName");
        Intrinsics.checkNotNullParameter(redeemText, "redeemText");
        Intrinsics.checkNotNullParameter(garbSuitUrl, "garbSuitUrl");
        Intrinsics.checkNotNullParameter(garbApplyUrl, "garbApplyUrl");
        Intrinsics.checkNotNullParameter(spaceBgSetUrl, "spaceBgSetUrl");
        Intrinsics.checkNotNullParameter(horizontalCardLightUrl, "horizontalCardLightUrl");
        Intrinsics.checkNotNullParameter(verticalCardLightUrl, "verticalCardLightUrl");
        Intrinsics.checkNotNullParameter(horizontalCardShadowUrl, "horizontalCardShadowUrl");
        Intrinsics.checkNotNullParameter(verticalCardShadowUrl, "verticalCardShadowUrl");
        Intrinsics.checkNotNullParameter(cardItem, "cardItem");
        Intrinsics.checkNotNullParameter(fromWhere, "fromWhere");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(rewardTag, "rewardTag");
        Intrinsics.checkNotNullParameter(rewardTip, "rewardTip");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        Intrinsics.checkNotNullParameter(list, "videoList");
        this.activityId = activityId;
        this.callbackId = callbackId;
        this.shareType = shareType;
        this.screenType = screenType;
        this.hasDrawCardAnimation = hasDrawCardAnimation;
        this.hasCardAnimation = hasCardAnimation;
        this.collectId = collectId;
        this.collectName = collectName;
        this.endTime = endTime;
        this.startTime = startTime;
        this.hasRedeemedCount = hasRedeemedCount;
        this.ownerItemAamount = ownerItemAamount;
        this.redeemItemId = redeemItemId;
        this.redeemItemImage = redeemItemImage;
        this.redeemItemName = redeemItemName;
        this.redeemItemType = redeemItemType;
        this.redeemText = redeemText;
        this.requireItemAmount = requireItemAmount;
        this.gained = gained;
        this.garbSuitUrl = garbSuitUrl;
        this.garbApplyUrl = garbApplyUrl;
        this.spaceBgSetUrl = spaceBgSetUrl;
        this.horizontalCardLightUrl = horizontalCardLightUrl;
        this.verticalCardLightUrl = verticalCardLightUrl;
        this.horizontalCardShadowUrl = horizontalCardShadowUrl;
        this.verticalCardShadowUrl = verticalCardShadowUrl;
        this.cardItem = cardItem;
        this.fromWhere = fromWhere;
        this.fromId = fromId;
        this.rewardTag = rewardTag;
        this.rewardTip = rewardTip;
        this.fSource = fSource;
        this.pageType = pageType;
        this.isHighlight = isHighlight;
        this.materialType = materialType;
        this.videoList = list;
        this.isMute = isMute;
        this.collectProgressButton = collectProgressButton;
    }

    public /* synthetic */ DLCCardRewardModel(String str, String str2, int i, int i2, int i3, int i4, int i5, String str3, String str4, String str5, int i6, int i7, String str6, String str7, String str8, int i8, String str9, int i9, int i10, String str10, String str11, String str12, String str13, String str14, String str15, String str16, BiliDLCCardItem biliDLCCardItem, String str17, String str18, String str19, String str20, String str21, int i11, Boolean bool, int i12, List list, boolean z, CollectProgressButton collectProgressButton, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2, i3, i4, i5, str3, str4, str5, i6, i7, str6, str7, str8, i8, str9, i9, i10, str10, str11, str12, str13, str14, str15, str16, biliDLCCardItem, str17, str18, str19, str20, str21, i11, bool, (i14 & 4) != 0 ? 1 : i12, (i14 & 8) != 0 ? CollectionsKt.emptyList() : list, z, (i14 & 32) != 0 ? null : collectProgressButton);
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final int getShareType() {
        return this.shareType;
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

    public final int getCollectId() {
        return this.collectId;
    }

    public final String getCollectName() {
        return this.collectName;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final int getHasRedeemedCount() {
        return this.hasRedeemedCount;
    }

    public final int getOwnerItemAamount() {
        return this.ownerItemAamount;
    }

    public final String getRedeemItemId() {
        return this.redeemItemId;
    }

    public final String getRedeemItemImage() {
        return this.redeemItemImage;
    }

    public final String getRedeemItemName() {
        return this.redeemItemName;
    }

    public final int getRedeemItemType() {
        return this.redeemItemType;
    }

    public final String getRedeemText() {
        return this.redeemText;
    }

    public final int getRequireItemAmount() {
        return this.requireItemAmount;
    }

    public final int getGained() {
        return this.gained;
    }

    public final String getGarbSuitUrl() {
        return this.garbSuitUrl;
    }

    public final String getGarbApplyUrl() {
        return this.garbApplyUrl;
    }

    public final String getSpaceBgSetUrl() {
        return this.spaceBgSetUrl;
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

    public final BiliDLCCardItem getCardItem() {
        return this.cardItem;
    }

    public final String getFromWhere() {
        return this.fromWhere;
    }

    public final String getFromId() {
        return this.fromId;
    }

    public final String getRewardTag() {
        return this.rewardTag;
    }

    public final String getRewardTip() {
        return this.rewardTip;
    }

    public final String getFSource() {
        return this.fSource;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final Boolean isHighlight() {
        return this.isHighlight;
    }

    public final int getMaterialType() {
        return this.materialType;
    }

    public final List<String> getVideoList() {
        return this.videoList;
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public final CollectProgressButton getCollectProgressButton() {
        return this.collectProgressButton;
    }
}