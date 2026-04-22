package tv.danmaku.bili.ui.garb.api;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bili.digital.common.CardNumberGradientColor;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003Jg\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0006\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u00063"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CardInfo;", "", "id", "", "cardNo", "", "hashCode", "cardRightShow", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "cardNumberGradientColor", "Lcom/bili/digital/common/CardNumberGradientColor;", "webCard", "Lcom/bilibili/digital/card/page/card/cardmodule/web/WebCard;", "cardRight", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "cardLockStatus", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "cardExtText", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/CardRightShow;Lcom/bili/digital/common/CardNumberGradientColor;Lcom/bilibili/digital/card/page/card/cardmodule/web/WebCard;Ltv/danmaku/bili/ui/garb/api/CardRight;Ltv/danmaku/bili/ui/garb/api/CardLockStatus;Ljava/lang/String;)V", "getId", "()J", "getCardNo", "()Ljava/lang/String;", "getHashCode", "getCardRightShow", "()Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "getCardNumberGradientColor", "()Lcom/bili/digital/common/CardNumberGradientColor;", "getWebCard", "()Lcom/bilibili/digital/card/page/card/cardmodule/web/WebCard;", "getCardRight", "()Ltv/danmaku/bili/ui/garb/api/CardRight;", "getCardLockStatus", "()Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "getCardExtText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CardInfo {
    public static final int $stable = 8;
    @SerializedName("card_ext_text")
    private final String cardExtText;
    @SerializedName("smelt_lock_status")
    private final CardLockStatus cardLockStatus;
    @SerializedName("card_no")
    private final String cardNo;
    @SerializedName("color_format")
    private final CardNumberGradientColor cardNumberGradientColor;
    @SerializedName("card_right")
    private final CardRight cardRight;
    @SerializedName("card_right_show")
    private final CardRightShow cardRightShow;
    @SerializedName("hash_code")
    private final String hashCode;
    @SerializedName("card_id")
    private final long id;
    @SerializedName("meta_info")
    private final com.bilibili.digital.card.page.card.cardmodule.web.WebCard webCard;

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.cardNo;
    }

    public final String component3() {
        return this.hashCode;
    }

    public final CardRightShow component4() {
        return this.cardRightShow;
    }

    public final CardNumberGradientColor component5() {
        return this.cardNumberGradientColor;
    }

    public final com.bilibili.digital.card.page.card.cardmodule.web.WebCard component6() {
        return this.webCard;
    }

    public final CardRight component7() {
        return this.cardRight;
    }

    public final CardLockStatus component8() {
        return this.cardLockStatus;
    }

    public final String component9() {
        return this.cardExtText;
    }

    public final CardInfo copy(long j, String str, String str2, CardRightShow cardRightShow, CardNumberGradientColor cardNumberGradientColor, com.bilibili.digital.card.page.card.cardmodule.web.WebCard webCard, CardRight cardRight, CardLockStatus cardLockStatus, String str3) {
        Intrinsics.checkNotNullParameter(str, "cardNo");
        Intrinsics.checkNotNullParameter(str2, "hashCode");
        Intrinsics.checkNotNullParameter(cardRightShow, "cardRightShow");
        Intrinsics.checkNotNullParameter(webCard, "webCard");
        Intrinsics.checkNotNullParameter(cardRight, "cardRight");
        Intrinsics.checkNotNullParameter(str3, "cardExtText");
        return new CardInfo(j, str, str2, cardRightShow, cardNumberGradientColor, webCard, cardRight, cardLockStatus, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardInfo) {
            CardInfo cardInfo = (CardInfo) obj;
            return this.id == cardInfo.id && Intrinsics.areEqual(this.cardNo, cardInfo.cardNo) && Intrinsics.areEqual(this.hashCode, cardInfo.hashCode) && Intrinsics.areEqual(this.cardRightShow, cardInfo.cardRightShow) && Intrinsics.areEqual(this.cardNumberGradientColor, cardInfo.cardNumberGradientColor) && Intrinsics.areEqual(this.webCard, cardInfo.webCard) && Intrinsics.areEqual(this.cardRight, cardInfo.cardRight) && this.cardLockStatus == cardInfo.cardLockStatus && Intrinsics.areEqual(this.cardExtText, cardInfo.cardExtText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.cardNo.hashCode()) * 31) + this.hashCode.hashCode()) * 31) + this.cardRightShow.hashCode()) * 31) + (this.cardNumberGradientColor == null ? 0 : this.cardNumberGradientColor.hashCode())) * 31) + this.webCard.hashCode()) * 31) + this.cardRight.hashCode()) * 31) + (this.cardLockStatus != null ? this.cardLockStatus.hashCode() : 0)) * 31) + this.cardExtText.hashCode();
    }

    public String toString() {
        long j = this.id;
        String str = this.cardNo;
        String str2 = this.hashCode;
        CardRightShow cardRightShow = this.cardRightShow;
        CardNumberGradientColor cardNumberGradientColor = this.cardNumberGradientColor;
        com.bilibili.digital.card.page.card.cardmodule.web.WebCard webCard = this.webCard;
        CardRight cardRight = this.cardRight;
        CardLockStatus cardLockStatus = this.cardLockStatus;
        return "CardInfo(id=" + j + ", cardNo=" + str + ", hashCode=" + str2 + ", cardRightShow=" + cardRightShow + ", cardNumberGradientColor=" + cardNumberGradientColor + ", webCard=" + webCard + ", cardRight=" + cardRight + ", cardLockStatus=" + cardLockStatus + ", cardExtText=" + this.cardExtText + ")";
    }

    public CardInfo(long id, String cardNo, String hashCode, CardRightShow cardRightShow, CardNumberGradientColor cardNumberGradientColor, com.bilibili.digital.card.page.card.cardmodule.web.WebCard webCard, CardRight cardRight, CardLockStatus cardLockStatus, String cardExtText) {
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        Intrinsics.checkNotNullParameter(hashCode, "hashCode");
        Intrinsics.checkNotNullParameter(cardRightShow, "cardRightShow");
        Intrinsics.checkNotNullParameter(webCard, "webCard");
        Intrinsics.checkNotNullParameter(cardRight, "cardRight");
        Intrinsics.checkNotNullParameter(cardExtText, "cardExtText");
        this.id = id;
        this.cardNo = cardNo;
        this.hashCode = hashCode;
        this.cardRightShow = cardRightShow;
        this.cardNumberGradientColor = cardNumberGradientColor;
        this.webCard = webCard;
        this.cardRight = cardRight;
        this.cardLockStatus = cardLockStatus;
        this.cardExtText = cardExtText;
    }

    public final long getId() {
        return this.id;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final String getHashCode() {
        return this.hashCode;
    }

    public final CardRightShow getCardRightShow() {
        return this.cardRightShow;
    }

    public final CardNumberGradientColor getCardNumberGradientColor() {
        return this.cardNumberGradientColor;
    }

    public final com.bilibili.digital.card.page.card.cardmodule.web.WebCard getWebCard() {
        return this.webCard;
    }

    public final CardRight getCardRight() {
        return this.cardRight;
    }

    public final CardLockStatus getCardLockStatus() {
        return this.cardLockStatus;
    }

    public final String getCardExtText() {
        return this.cardExtText;
    }
}