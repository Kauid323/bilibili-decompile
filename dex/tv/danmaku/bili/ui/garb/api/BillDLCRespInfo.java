package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCRespInfo.kt */
@Bson
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "", "errCode", "", "errMessage", "", "leftChance", "itemList", "", "Ltv/danmaku/bili/ui/garb/api/DLCItem;", "<init>", "(ILjava/lang/String;ILjava/util/List;)V", "getErrCode", "()I", "getErrMessage", "()Ljava/lang/String;", "getLeftChance", "getItemList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BillDLCRespInfo {
    public static final int $stable = 8;
    @SerializedName("err_code")
    private final int errCode;
    @SerializedName("err_message")
    private final String errMessage;
    @SerializedName("item_list")
    private final List<DLCItem> itemList;
    @SerializedName("left_chance")
    private final int leftChance;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BillDLCRespInfo copy$default(BillDLCRespInfo billDLCRespInfo, int i, String str, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = billDLCRespInfo.errCode;
        }
        if ((i3 & 2) != 0) {
            str = billDLCRespInfo.errMessage;
        }
        if ((i3 & 4) != 0) {
            i2 = billDLCRespInfo.leftChance;
        }
        if ((i3 & 8) != 0) {
            list = billDLCRespInfo.itemList;
        }
        return billDLCRespInfo.copy(i, str, i2, list);
    }

    public final int component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMessage;
    }

    public final int component3() {
        return this.leftChance;
    }

    public final List<DLCItem> component4() {
        return this.itemList;
    }

    public final BillDLCRespInfo copy(int i, String str, int i2, List<DLCItem> list) {
        Intrinsics.checkNotNullParameter(str, "errMessage");
        Intrinsics.checkNotNullParameter(list, "itemList");
        return new BillDLCRespInfo(i, str, i2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BillDLCRespInfo) {
            BillDLCRespInfo billDLCRespInfo = (BillDLCRespInfo) obj;
            return this.errCode == billDLCRespInfo.errCode && Intrinsics.areEqual(this.errMessage, billDLCRespInfo.errMessage) && this.leftChance == billDLCRespInfo.leftChance && Intrinsics.areEqual(this.itemList, billDLCRespInfo.itemList);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.errCode * 31) + this.errMessage.hashCode()) * 31) + this.leftChance) * 31) + this.itemList.hashCode();
    }

    public String toString() {
        int i = this.errCode;
        String str = this.errMessage;
        int i2 = this.leftChance;
        return "BillDLCRespInfo(errCode=" + i + ", errMessage=" + str + ", leftChance=" + i2 + ", itemList=" + this.itemList + ")";
    }

    public BillDLCRespInfo(int errCode, String errMessage, int leftChance, List<DLCItem> list) {
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.leftChance = leftChance;
        this.itemList = list;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMessage() {
        return this.errMessage;
    }

    public final int getLeftChance() {
        return this.leftChance;
    }

    public final List<DLCItem> getItemList() {
        return this.itemList;
    }
}