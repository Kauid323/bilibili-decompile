package tv.danmaku.bili.ui.garb.nft.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bili.digital.common.CardNumberGradientColor;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;

/* compiled from: DLCDetailModel.kt */
@Bson
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jq\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\bHÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailIdModel;", "", "cardId", "", "cardExtText", "", "cardNo", "status", "", "exchangeStatus", "hashCode", "cardRightShow", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "cardRight", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "cardNumberGradientColor", "Lcom/bili/digital/common/CardNumberGradientColor;", "cardLockStatus", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "<init>", "(JLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ltv/danmaku/bili/ui/garb/api/CardRightShow;Ltv/danmaku/bili/ui/garb/api/CardRight;Lcom/bili/digital/common/CardNumberGradientColor;Ltv/danmaku/bili/ui/garb/api/CardLockStatus;)V", "getCardId", "()J", "getCardExtText", "()Ljava/lang/String;", "getCardNo", "getStatus", "()I", "getExchangeStatus", "getHashCode", "getCardRightShow", "()Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "getCardRight", "()Ltv/danmaku/bili/ui/garb/api/CardRight;", "getCardNumberGradientColor", "()Lcom/bili/digital/common/CardNumberGradientColor;", "getCardLockStatus", "()Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailIdModel {
    public static final int $stable = 8;
    @SerializedName("card_ext_text")
    private final String cardExtText;
    @SerializedName("card_id")
    private final long cardId;
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
    @SerializedName("exchange_status")
    private final int exchangeStatus;
    @SerializedName("hash_code")
    private final String hashCode;
    @SerializedName("status")
    private final int status;

    public final long component1() {
        return this.cardId;
    }

    public final CardLockStatus component10() {
        return this.cardLockStatus;
    }

    public final String component2() {
        return this.cardExtText;
    }

    public final String component3() {
        return this.cardNo;
    }

    public final int component4() {
        return this.status;
    }

    public final int component5() {
        return this.exchangeStatus;
    }

    public final String component6() {
        return this.hashCode;
    }

    public final CardRightShow component7() {
        return this.cardRightShow;
    }

    public final CardRight component8() {
        return this.cardRight;
    }

    public final CardNumberGradientColor component9() {
        return this.cardNumberGradientColor;
    }

    public final DigitalCardDetailIdModel copy(long j, String str, String str2, int i, int i2, String str3, CardRightShow cardRightShow, CardRight cardRight, CardNumberGradientColor cardNumberGradientColor, CardLockStatus cardLockStatus) {
        Intrinsics.checkNotNullParameter(str, "cardExtText");
        Intrinsics.checkNotNullParameter(str2, "cardNo");
        Intrinsics.checkNotNullParameter(str3, "hashCode");
        Intrinsics.checkNotNullParameter(cardRightShow, "cardRightShow");
        Intrinsics.checkNotNullParameter(cardRight, "cardRight");
        return new DigitalCardDetailIdModel(j, str, str2, i, i2, str3, cardRightShow, cardRight, cardNumberGradientColor, cardLockStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DigitalCardDetailIdModel) {
            DigitalCardDetailIdModel digitalCardDetailIdModel = (DigitalCardDetailIdModel) obj;
            return this.cardId == digitalCardDetailIdModel.cardId && Intrinsics.areEqual(this.cardExtText, digitalCardDetailIdModel.cardExtText) && Intrinsics.areEqual(this.cardNo, digitalCardDetailIdModel.cardNo) && this.status == digitalCardDetailIdModel.status && this.exchangeStatus == digitalCardDetailIdModel.exchangeStatus && Intrinsics.areEqual(this.hashCode, digitalCardDetailIdModel.hashCode) && Intrinsics.areEqual(this.cardRightShow, digitalCardDetailIdModel.cardRightShow) && Intrinsics.areEqual(this.cardRight, digitalCardDetailIdModel.cardRight) && Intrinsics.areEqual(this.cardNumberGradientColor, digitalCardDetailIdModel.cardNumberGradientColor) && this.cardLockStatus == digitalCardDetailIdModel.cardLockStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardId) * 31) + this.cardExtText.hashCode()) * 31) + this.cardNo.hashCode()) * 31) + this.status) * 31) + this.exchangeStatus) * 31) + this.hashCode.hashCode()) * 31) + this.cardRightShow.hashCode()) * 31) + this.cardRight.hashCode()) * 31) + (this.cardNumberGradientColor == null ? 0 : this.cardNumberGradientColor.hashCode())) * 31) + (this.cardLockStatus != null ? this.cardLockStatus.hashCode() : 0);
    }

    public String toString() {
        long j = this.cardId;
        String str = this.cardExtText;
        String str2 = this.cardNo;
        int i = this.status;
        int i2 = this.exchangeStatus;
        String str3 = this.hashCode;
        CardRightShow cardRightShow = this.cardRightShow;
        CardRight cardRight = this.cardRight;
        CardNumberGradientColor cardNumberGradientColor = this.cardNumberGradientColor;
        return "DigitalCardDetailIdModel(cardId=" + j + ", cardExtText=" + str + ", cardNo=" + str2 + ", status=" + i + ", exchangeStatus=" + i2 + ", hashCode=" + str3 + ", cardRightShow=" + cardRightShow + ", cardRight=" + cardRight + ", cardNumberGradientColor=" + cardNumberGradientColor + ", cardLockStatus=" + this.cardLockStatus + ")";
    }

    public DigitalCardDetailIdModel(long cardId, String cardExtText, String cardNo, int status, int exchangeStatus, String hashCode, CardRightShow cardRightShow, CardRight cardRight, CardNumberGradientColor cardNumberGradientColor, CardLockStatus cardLockStatus) {
        Intrinsics.checkNotNullParameter(cardExtText, "cardExtText");
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        Intrinsics.checkNotNullParameter(hashCode, "hashCode");
        Intrinsics.checkNotNullParameter(cardRightShow, "cardRightShow");
        Intrinsics.checkNotNullParameter(cardRight, "cardRight");
        this.cardId = cardId;
        this.cardExtText = cardExtText;
        this.cardNo = cardNo;
        this.status = status;
        this.exchangeStatus = exchangeStatus;
        this.hashCode = hashCode;
        this.cardRightShow = cardRightShow;
        this.cardRight = cardRight;
        this.cardNumberGradientColor = cardNumberGradientColor;
        this.cardLockStatus = cardLockStatus;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final String getCardExtText() {
        return this.cardExtText;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getExchangeStatus() {
        return this.exchangeStatus;
    }

    public final String getHashCode() {
        return this.hashCode;
    }

    public final CardRightShow getCardRightShow() {
        return this.cardRightShow;
    }

    public final CardRight getCardRight() {
        return this.cardRight;
    }

    public final CardNumberGradientColor getCardNumberGradientColor() {
        return this.cardNumberGradientColor;
    }

    public final CardLockStatus getCardLockStatus() {
        return this.cardLockStatus;
    }
}