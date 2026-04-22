package tv.danmaku.bili.ui.garb.nft.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCCardShareModel.kt */
@Bson
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "", "lotteryId", "", "shareType", "", "cardList", "", "Ltv/danmaku/bili/ui/garb/nft/model/CardShareInfo;", "<init>", "(JILjava/util/List;)V", "getLotteryId", "()J", "getShareType", "()I", "getCardList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardShareModel {
    public static final int $stable = 8;
    @SerializedName("card_list")
    private final List<CardShareInfo> cardList;
    @SerializedName("lottery_id")
    private final long lotteryId;
    @SerializedName("share_type")
    private final int shareType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DLCCardShareModel copy$default(DLCCardShareModel dLCCardShareModel, long j, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dLCCardShareModel.lotteryId;
        }
        if ((i2 & 2) != 0) {
            i = dLCCardShareModel.shareType;
        }
        if ((i2 & 4) != 0) {
            list = dLCCardShareModel.cardList;
        }
        return dLCCardShareModel.copy(j, i, list);
    }

    public final long component1() {
        return this.lotteryId;
    }

    public final int component2() {
        return this.shareType;
    }

    public final List<CardShareInfo> component3() {
        return this.cardList;
    }

    public final DLCCardShareModel copy(long j, int i, List<CardShareInfo> list) {
        Intrinsics.checkNotNullParameter(list, "cardList");
        return new DLCCardShareModel(j, i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCCardShareModel) {
            DLCCardShareModel dLCCardShareModel = (DLCCardShareModel) obj;
            return this.lotteryId == dLCCardShareModel.lotteryId && this.shareType == dLCCardShareModel.shareType && Intrinsics.areEqual(this.cardList, dLCCardShareModel.cardList);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lotteryId) * 31) + this.shareType) * 31) + this.cardList.hashCode();
    }

    public String toString() {
        long j = this.lotteryId;
        int i = this.shareType;
        return "DLCCardShareModel(lotteryId=" + j + ", shareType=" + i + ", cardList=" + this.cardList + ")";
    }

    public DLCCardShareModel(long lotteryId, int shareType, List<CardShareInfo> list) {
        Intrinsics.checkNotNullParameter(list, "cardList");
        this.lotteryId = lotteryId;
        this.shareType = shareType;
        this.cardList = list;
    }

    public final long getLotteryId() {
        return this.lotteryId;
    }

    public final int getShareType() {
        return this.shareType;
    }

    public final List<CardShareInfo> getCardList() {
        return this.cardList;
    }
}