package tv.danmaku.bili.ui.garb;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;

/* compiled from: NftCardModel.kt */
@Bson
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardDetailIdModel;", "", "cardId", "", "cardNo", "", "status", "", "exchangeStatus", "hashCode", "cardRightShow", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "cardRight", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "<init>", "(JLjava/lang/String;IILjava/lang/String;Ltv/danmaku/bili/ui/garb/api/CardRightShow;Ltv/danmaku/bili/ui/garb/api/CardRight;)V", "getCardId", "()J", "getCardNo", "()Ljava/lang/String;", "getStatus", "()I", "getExchangeStatus", "getHashCode", "getCardRightShow", "()Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "getCardRight", "()Ltv/danmaku/bili/ui/garb/api/CardRight;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardDetailIdModel {
    public static final int $stable = 8;
    @SerializedName("card_id")
    private final long cardId;
    @SerializedName("card_no")
    private final String cardNo;
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

    public NftCardDetailIdModel(long cardId, String cardNo, int status, int exchangeStatus, String hashCode, CardRightShow cardRightShow, CardRight cardRight) {
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        Intrinsics.checkNotNullParameter(hashCode, "hashCode");
        Intrinsics.checkNotNullParameter(cardRightShow, "cardRightShow");
        Intrinsics.checkNotNullParameter(cardRight, "cardRight");
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.status = status;
        this.exchangeStatus = exchangeStatus;
        this.hashCode = hashCode;
        this.cardRightShow = cardRightShow;
        this.cardRight = cardRight;
    }

    public final long getCardId() {
        return this.cardId;
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
}