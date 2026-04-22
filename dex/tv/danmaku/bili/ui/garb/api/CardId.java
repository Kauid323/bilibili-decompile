package tv.danmaku.bili.ui.garb.api;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: BiliCardDetail.kt */
@Bson
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CardId;", "", "cardId", "", "status", "", "exchangeStatus", "<init>", "(JII)V", "getCardId", "()J", "getStatus", "()I", "getExchangeStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CardId {
    public static final int $stable = 0;
    @SerializedName("card_id")
    private final long cardId;
    @SerializedName("exchange_status")
    private final int exchangeStatus;
    @SerializedName("status")
    private final int status;

    public static /* synthetic */ CardId copy$default(CardId cardId, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = cardId.cardId;
        }
        if ((i3 & 2) != 0) {
            i = cardId.status;
        }
        if ((i3 & 4) != 0) {
            i2 = cardId.exchangeStatus;
        }
        return cardId.copy(j, i, i2);
    }

    public final long component1() {
        return this.cardId;
    }

    public final int component2() {
        return this.status;
    }

    public final int component3() {
        return this.exchangeStatus;
    }

    public final CardId copy(long j, int i, int i2) {
        return new CardId(j, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardId) {
            CardId cardId = (CardId) obj;
            return this.cardId == cardId.cardId && this.status == cardId.status && this.exchangeStatus == cardId.exchangeStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardId) * 31) + this.status) * 31) + this.exchangeStatus;
    }

    public String toString() {
        long j = this.cardId;
        int i = this.status;
        return "CardId(cardId=" + j + ", status=" + i + ", exchangeStatus=" + this.exchangeStatus + ")";
    }

    public CardId(long cardId, int status, int exchangeStatus) {
        this.cardId = cardId;
        this.status = status;
        this.exchangeStatus = exchangeStatus;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getExchangeStatus() {
        return this.exchangeStatus;
    }
}