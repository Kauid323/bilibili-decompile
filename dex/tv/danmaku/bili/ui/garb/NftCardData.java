package tv.danmaku.bili.ui.garb;

import com.bilibili.app.authorspace.api.BiliNftImage;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.common.gyroscope.model.NftGyroAttribute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.api.Animation;
import tv.danmaku.bili.ui.garb.api.BiliDrawCard;
import tv.danmaku.bili.ui.garb.api.BiliDrawCardKt;
import tv.danmaku.bili.ui.garb.api.CardInfo;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.CardTypeInfo;
import tv.danmaku.bili.ui.garb.api.Content;

/* compiled from: NftCardRecyclerView.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\b\u0007\u0018\u00002\u00020\u0001Bí\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020$\u0012\b\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0004\b!\u0010'B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020)¢\u0006\u0004\b!\u0010*R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\u0017\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010.R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\u001c\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u00108R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00108\"\u0004\bB\u0010:R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00108\"\u0004\bD\u0010:R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bH\u0010.R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010FR\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010FR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardData;", "", "cardTypeId", "", "cardId", "totalCount", "", "index", ChannelRoutes.CHANNEL_NAME, "ratio", "", "imgUrl", "hashCode", "status", "", "width", "height", "exchangeStatus", "type", "Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;", "needRequest", "", "hasGained", "isDragon", "videoList", "", "gyroscope", "Lcom/bilibili/app/common/gyroscope/model/NftGyroAttribute;", "silence", "cardRightShow", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "cardRight", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;ZZZLjava/util/List;Ljava/util/List;ZLtv/danmaku/bili/ui/garb/api/CardRightShow;Ltv/danmaku/bili/ui/garb/api/CardRight;)V", "cardDetail", "Ltv/danmaku/bili/ui/garb/NftCardDetailModel;", "card", "Ltv/danmaku/bili/ui/garb/NftCardDetailIdModel;", "(Ltv/danmaku/bili/ui/garb/NftCardDetailModel;Ltv/danmaku/bili/ui/garb/NftCardDetailIdModel;)V", "drawCard", "Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;", "(Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;)V", "getType", "()Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;", "getNeedRequest", "()Z", "getHasGained", "getVideoList", "()Ljava/util/List;", "getGyroscope", "getSilence", "getCardTypeId", "()J", "getCardId", "getTotalCount", "()Ljava/lang/String;", "setTotalCount", "(Ljava/lang/String;)V", "getIndex", "getName", "getRatio", "()F", "setRatio", "(F)V", "getImgUrl", "setImgUrl", "getHashCode", "setHashCode", "getStatus", "()I", "hasExchanged", "getHasExchanged", "getWidth", "getHeight", "getCardRightShow", "()Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "setCardRightShow", "(Ltv/danmaku/bili/ui/garb/api/CardRightShow;)V", "getCardRight", "()Ltv/danmaku/bili/ui/garb/api/CardRight;", "setCardRight", "(Ltv/danmaku/bili/ui/garb/api/CardRight;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardData {
    public static final int $stable = 8;
    private final long cardId;
    private CardRight cardRight;
    private CardRightShow cardRightShow;
    private final long cardTypeId;
    private final List<NftGyroAttribute> gyroscope;
    private final boolean hasExchanged;
    private final boolean hasGained;
    private String hashCode;
    private final int height;
    private String imgUrl;
    private final String index;
    private final boolean isDragon;
    private final String name;
    private final boolean needRequest;
    private float ratio;
    private final boolean silence;
    private final int status;
    private String totalCount;
    private final NftType type;
    private final List<String> videoList;
    private final int width;

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
        if (r24.intValue() == 1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NftCardData(Long cardTypeId, Long cardId, String totalCount, String index, String name, Float ratio, String imgUrl, String hashCode, Integer status, Integer width, Integer height, Integer exchangeStatus, NftType type, boolean needRequest, boolean hasGained, boolean isDragon, List<String> list, List<NftGyroAttribute> list2, boolean silence, CardRightShow cardRightShow, CardRight cardRight) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.needRequest = needRequest;
        this.hasGained = hasGained;
        this.isDragon = isDragon;
        this.videoList = list;
        this.gyroscope = list2;
        this.silence = silence;
        this.cardTypeId = cardTypeId != null ? cardTypeId.longValue() : 0L;
        this.cardId = cardId != null ? cardId.longValue() : 0L;
        this.totalCount = totalCount == null ? "" : totalCount;
        this.index = index == null ? "" : index;
        this.name = name == null ? "" : name;
        this.ratio = ratio != null ? ratio.floatValue() : 0.0f;
        this.imgUrl = imgUrl == null ? "" : imgUrl;
        this.hashCode = hashCode != null ? hashCode : "";
        this.status = status != null ? status.intValue() : 0;
        boolean z = exchangeStatus != null ? true : z;
        z = false;
        this.hasExchanged = z;
        this.width = width != null ? width.intValue() : 0;
        this.height = height != null ? height.intValue() : 0;
        this.cardRightShow = cardRightShow;
        this.cardRight = cardRight;
    }

    public /* synthetic */ NftCardData(Long l, Long l2, String str, String str2, String str3, Float f, String str4, String str5, Integer num, Integer num2, Integer num3, Integer num4, NftType nftType, boolean z, boolean z2, boolean z3, List list, List list2, boolean z4, CardRightShow cardRightShow, CardRight cardRight, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2, str, str2, str3, f, str4, str5, num, num2, num3, num4, (i & 4096) != 0 ? NftType.IMAGE : nftType, (i & 8192) != 0 ? false : z, (i & RingBuffer.CONSUME_SIZE) != 0 ? false : z2, (32768 & i) != 0 ? false : z3, (65536 & i) != 0 ? null : list, (131072 & i) != 0 ? null : list2, (262144 & i) != 0 ? false : z4, (524288 & i) != 0 ? null : cardRightShow, (i & 1048576) != 0 ? null : cardRight);
    }

    public final NftType getType() {
        return this.type;
    }

    public final boolean getNeedRequest() {
        return this.needRequest;
    }

    public final boolean getHasGained() {
        return this.hasGained;
    }

    public final boolean isDragon() {
        return this.isDragon;
    }

    public final List<String> getVideoList() {
        return this.videoList;
    }

    public final List<NftGyroAttribute> getGyroscope() {
        return this.gyroscope;
    }

    public final boolean getSilence() {
        return this.silence;
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final String getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalCount = str;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }

    public final float getRatio() {
        return this.ratio;
    }

    public final void setRatio(float f) {
        this.ratio = f;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final void setImgUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imgUrl = str;
    }

    public final String getHashCode() {
        return this.hashCode;
    }

    public final void setHashCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hashCode = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean getHasExchanged() {
        return this.hasExchanged;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final CardRightShow getCardRightShow() {
        return this.cardRightShow;
    }

    public final void setCardRightShow(CardRightShow cardRightShow) {
        this.cardRightShow = cardRightShow;
    }

    public final CardRight getCardRight() {
        return this.cardRight;
    }

    public final void setCardRight(CardRight cardRight) {
        this.cardRight = cardRight;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NftCardData(NftCardDetailModel cardDetail, NftCardDetailIdModel card) {
        this(Long.valueOf(cardDetail.getCardTypeId()), card != null ? Long.valueOf(card.getCardId()) : null, cardDetail.getTotalCntShow(), card != null ? card.getCardNo() : null, cardDetail.getCardName(), Float.valueOf(cardDetail.getRealChance() / 100.0f), cardDetail.getCardImg(), card != null ? card.getHashCode() : null, card != null ? Integer.valueOf(card.getStatus()) : null, Integer.valueOf(cardDetail.getWidth()), Integer.valueOf(cardDetail.getHeight()), card != null ? Integer.valueOf(card.getExchangeStatus()) : null, NftType.Companion.getType(cardDetail.getCardType()), cardDetail.getNeedRequest() == 1, card != null, false, cardDetail.getVideoList(), null, cardDetail.getSilence() == 1, card != null ? card.getCardRightShow() : null, card != null ? card.getCardRight() : null, 32768, null);
        Intrinsics.checkNotNullParameter(cardDetail, "cardDetail");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NftCardData(BiliDrawCard drawCard) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, 1, r13, r14, 0, r2, r17, true, false, r20, r21, r22, r23, r0 != null ? r0.getCardRight() : null, 32768, null);
        Content content;
        Animation animation;
        Content content2;
        BiliNftImage image;
        Content content3;
        Animation animation2;
        Intrinsics.checkNotNullParameter(drawCard, "drawCard");
        CardTypeInfo cardTypeInfo = drawCard.getCardTypeInfo();
        Long valueOf = cardTypeInfo != null ? Long.valueOf(cardTypeInfo.getId()) : null;
        CardInfo cardInfo = drawCard.getCardInfo();
        Long valueOf2 = cardInfo != null ? Long.valueOf(cardInfo.getId()) : null;
        String totalCountShow = drawCard.getTotalCountShow();
        CardInfo cardInfo2 = drawCard.getCardInfo();
        String cardNo = cardInfo2 != null ? cardInfo2.getCardNo() : null;
        CardTypeInfo cardTypeInfo2 = drawCard.getCardTypeInfo();
        String name = cardTypeInfo2 != null ? cardTypeInfo2.getName() : null;
        Float valueOf3 = Float.valueOf(drawCard.getCardChance());
        String imgUrlWithType = BiliDrawCardKt.getImgUrlWithType(drawCard);
        String str = imgUrlWithType == null ? "" : imgUrlWithType;
        CardInfo cardInfo3 = drawCard.getCardInfo();
        String hashCode = cardInfo3 != null ? cardInfo3.getHashCode() : null;
        CardTypeInfo cardTypeInfo3 = drawCard.getCardTypeInfo();
        Integer valueOf4 = cardTypeInfo3 != null ? Integer.valueOf(cardTypeInfo3.getWidth()) : null;
        CardTypeInfo cardTypeInfo4 = drawCard.getCardTypeInfo();
        Integer valueOf5 = cardTypeInfo4 != null ? Integer.valueOf(cardTypeInfo4.getHeight()) : null;
        NftType.Companion companion = NftType.Companion;
        CardTypeInfo cardTypeInfo5 = drawCard.getCardTypeInfo();
        NftType type = companion.getType(cardTypeInfo5 != null ? cardTypeInfo5.getMaterialType() : NftType.IMAGE.getType());
        boolean z = drawCard.getNeedRequest() == 1;
        CardTypeInfo cardTypeInfo6 = drawCard.getCardTypeInfo();
        List<String> animationVideoUrls = (cardTypeInfo6 == null || (content3 = cardTypeInfo6.getContent()) == null || (animation2 = content3.getAnimation()) == null) ? null : animation2.getAnimationVideoUrls();
        CardTypeInfo cardTypeInfo7 = drawCard.getCardTypeInfo();
        List gyroscope = (cardTypeInfo7 == null || (content2 = cardTypeInfo7.getContent()) == null || (image = content2.getImage()) == null) ? null : image.getGyroscope();
        CardTypeInfo cardTypeInfo8 = drawCard.getCardTypeInfo();
        boolean z2 = (cardTypeInfo8 == null || (content = cardTypeInfo8.getContent()) == null || (animation = content.getAnimation()) == null || !animation.getMute()) ? false : true;
        CardInfo cardInfo4 = drawCard.getCardInfo();
        CardRightShow cardRightShow = cardInfo4 != null ? cardInfo4.getCardRightShow() : null;
        CardInfo cardInfo5 = drawCard.getCardInfo();
    }
}