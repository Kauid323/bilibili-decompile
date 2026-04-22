package tv.danmaku.bili.ui.garb.nft.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DLCPurchaseModel.kt */
@Bson
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCPurchaseModel;", "", "lotteryId", "", "lotteryNum", "", "<init>", "(JI)V", "getLotteryId", "()J", "getLotteryNum", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCPurchaseModel {
    public static final int $stable = 0;
    @SerializedName("lottery_id")
    private final long lotteryId;
    @SerializedName("lottery_num")
    private final int lotteryNum;

    public static /* synthetic */ DLCPurchaseModel copy$default(DLCPurchaseModel dLCPurchaseModel, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dLCPurchaseModel.lotteryId;
        }
        if ((i2 & 2) != 0) {
            i = dLCPurchaseModel.lotteryNum;
        }
        return dLCPurchaseModel.copy(j, i);
    }

    public final long component1() {
        return this.lotteryId;
    }

    public final int component2() {
        return this.lotteryNum;
    }

    public final DLCPurchaseModel copy(long j, int i) {
        return new DLCPurchaseModel(j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCPurchaseModel) {
            DLCPurchaseModel dLCPurchaseModel = (DLCPurchaseModel) obj;
            return this.lotteryId == dLCPurchaseModel.lotteryId && this.lotteryNum == dLCPurchaseModel.lotteryNum;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lotteryId) * 31) + this.lotteryNum;
    }

    public String toString() {
        long j = this.lotteryId;
        return "DLCPurchaseModel(lotteryId=" + j + ", lotteryNum=" + this.lotteryNum + ")";
    }

    public DLCPurchaseModel(long lotteryId, int lotteryNum) {
        this.lotteryId = lotteryId;
        this.lotteryNum = lotteryNum;
    }

    public final long getLotteryId() {
        return this.lotteryId;
    }

    public final int getLotteryNum() {
        return this.lotteryNum;
    }
}