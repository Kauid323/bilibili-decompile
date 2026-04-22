package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliCardDetail.kt */
@Bson
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliCardDetail;", "", "cardTypeInfo", "Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "cardIdList", "", "Ltv/danmaku/bili/ui/garb/api/CardId;", "<init>", "(Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;Ljava/util/List;)V", "getCardTypeInfo", "()Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "getCardIdList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliCardDetail {
    public static final int $stable = 8;
    @SerializedName("card_id_list")
    private final List<CardId> cardIdList;
    @SerializedName("card_type_info")
    private final CardTypeInfo cardTypeInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BiliCardDetail copy$default(BiliCardDetail biliCardDetail, CardTypeInfo cardTypeInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            cardTypeInfo = biliCardDetail.cardTypeInfo;
        }
        if ((i & 2) != 0) {
            list = biliCardDetail.cardIdList;
        }
        return biliCardDetail.copy(cardTypeInfo, list);
    }

    public final CardTypeInfo component1() {
        return this.cardTypeInfo;
    }

    public final List<CardId> component2() {
        return this.cardIdList;
    }

    public final BiliCardDetail copy(CardTypeInfo cardTypeInfo, List<CardId> list) {
        Intrinsics.checkNotNullParameter(cardTypeInfo, "cardTypeInfo");
        Intrinsics.checkNotNullParameter(list, "cardIdList");
        return new BiliCardDetail(cardTypeInfo, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCardDetail) {
            BiliCardDetail biliCardDetail = (BiliCardDetail) obj;
            return Intrinsics.areEqual(this.cardTypeInfo, biliCardDetail.cardTypeInfo) && Intrinsics.areEqual(this.cardIdList, biliCardDetail.cardIdList);
        }
        return false;
    }

    public int hashCode() {
        return (this.cardTypeInfo.hashCode() * 31) + this.cardIdList.hashCode();
    }

    public String toString() {
        CardTypeInfo cardTypeInfo = this.cardTypeInfo;
        return "BiliCardDetail(cardTypeInfo=" + cardTypeInfo + ", cardIdList=" + this.cardIdList + ")";
    }

    public BiliCardDetail(CardTypeInfo cardTypeInfo, List<CardId> list) {
        Intrinsics.checkNotNullParameter(cardTypeInfo, "cardTypeInfo");
        Intrinsics.checkNotNullParameter(list, "cardIdList");
        this.cardTypeInfo = cardTypeInfo;
        this.cardIdList = list;
    }

    public final CardTypeInfo getCardTypeInfo() {
        return this.cardTypeInfo;
    }

    public final List<CardId> getCardIdList() {
        return this.cardIdList;
    }
}