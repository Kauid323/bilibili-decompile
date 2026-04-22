package tv.danmaku.bili.ui.garb.api;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDrawCard.kt */
@Bson
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003Jc\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00061"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;", "", "errCode", "", "errMessage", "", "cardTypeId", "", "leftChance", "cardTypeInfo", "Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "totalCountShow", "cardInfo", "Ltv/danmaku/bili/ui/garb/api/CardInfo;", "cardChance", "", "needRequest", "<init>", "(ILjava/lang/String;JILtv/danmaku/bili/ui/garb/api/CardTypeInfo;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/CardInfo;FI)V", "getErrCode", "()I", "getErrMessage", "()Ljava/lang/String;", "getCardTypeId", "()J", "getLeftChance", "getCardTypeInfo", "()Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "getTotalCountShow", "getCardInfo", "()Ltv/danmaku/bili/ui/garb/api/CardInfo;", "getCardChance", "()F", "getNeedRequest", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliDrawCard {
    public static final int $stable = 8;
    @SerializedName("card_chance")
    private final float cardChance;
    @SerializedName("card_info")
    private final CardInfo cardInfo;
    @SerializedName("card_type_id")
    private final long cardTypeId;
    @SerializedName("card_type_info")
    private final CardTypeInfo cardTypeInfo;
    @SerializedName("err_code")
    private final int errCode;
    @SerializedName("err_message")
    private final String errMessage;
    @SerializedName("left_chance")
    private final int leftChance;
    @SerializedName("is_req_detail")
    private final int needRequest;
    @SerializedName("card_type_cnt_show")
    private final String totalCountShow;

    public final int component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMessage;
    }

    public final long component3() {
        return this.cardTypeId;
    }

    public final int component4() {
        return this.leftChance;
    }

    public final CardTypeInfo component5() {
        return this.cardTypeInfo;
    }

    public final String component6() {
        return this.totalCountShow;
    }

    public final CardInfo component7() {
        return this.cardInfo;
    }

    public final float component8() {
        return this.cardChance;
    }

    public final int component9() {
        return this.needRequest;
    }

    public final BiliDrawCard copy(int i, String str, long j, int i2, CardTypeInfo cardTypeInfo, String str2, CardInfo cardInfo, float f, int i3) {
        Intrinsics.checkNotNullParameter(str, "errMessage");
        Intrinsics.checkNotNullParameter(cardTypeInfo, "cardTypeInfo");
        Intrinsics.checkNotNullParameter(str2, "totalCountShow");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        return new BiliDrawCard(i, str, j, i2, cardTypeInfo, str2, cardInfo, f, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliDrawCard) {
            BiliDrawCard biliDrawCard = (BiliDrawCard) obj;
            return this.errCode == biliDrawCard.errCode && Intrinsics.areEqual(this.errMessage, biliDrawCard.errMessage) && this.cardTypeId == biliDrawCard.cardTypeId && this.leftChance == biliDrawCard.leftChance && Intrinsics.areEqual(this.cardTypeInfo, biliDrawCard.cardTypeInfo) && Intrinsics.areEqual(this.totalCountShow, biliDrawCard.totalCountShow) && Intrinsics.areEqual(this.cardInfo, biliDrawCard.cardInfo) && Float.compare(this.cardChance, biliDrawCard.cardChance) == 0 && this.needRequest == biliDrawCard.needRequest;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.errCode * 31) + this.errMessage.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId)) * 31) + this.leftChance) * 31) + this.cardTypeInfo.hashCode()) * 31) + this.totalCountShow.hashCode()) * 31) + this.cardInfo.hashCode()) * 31) + Float.floatToIntBits(this.cardChance)) * 31) + this.needRequest;
    }

    public String toString() {
        int i = this.errCode;
        String str = this.errMessage;
        long j = this.cardTypeId;
        int i2 = this.leftChance;
        CardTypeInfo cardTypeInfo = this.cardTypeInfo;
        String str2 = this.totalCountShow;
        CardInfo cardInfo = this.cardInfo;
        float f = this.cardChance;
        return "BiliDrawCard(errCode=" + i + ", errMessage=" + str + ", cardTypeId=" + j + ", leftChance=" + i2 + ", cardTypeInfo=" + cardTypeInfo + ", totalCountShow=" + str2 + ", cardInfo=" + cardInfo + ", cardChance=" + f + ", needRequest=" + this.needRequest + ")";
    }

    public BiliDrawCard(int errCode, String errMessage, long cardTypeId, int leftChance, CardTypeInfo cardTypeInfo, String totalCountShow, CardInfo cardInfo, float cardChance, int needRequest) {
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        Intrinsics.checkNotNullParameter(cardTypeInfo, "cardTypeInfo");
        Intrinsics.checkNotNullParameter(totalCountShow, "totalCountShow");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.cardTypeId = cardTypeId;
        this.leftChance = leftChance;
        this.cardTypeInfo = cardTypeInfo;
        this.totalCountShow = totalCountShow;
        this.cardInfo = cardInfo;
        this.cardChance = cardChance;
        this.needRequest = needRequest;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMessage() {
        return this.errMessage;
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }

    public final int getLeftChance() {
        return this.leftChance;
    }

    public final CardTypeInfo getCardTypeInfo() {
        return this.cardTypeInfo;
    }

    public final String getTotalCountShow() {
        return this.totalCountShow;
    }

    public final CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final float getCardChance() {
        return this.cardChance;
    }

    public final int getNeedRequest() {
        return this.needRequest;
    }
}