package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCRespInfo.kt */
@Bson
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/DLCItem;", "", "itemType", "", "itemScarcity", "cardItem", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;", "display", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;", "<init>", "(IILtv/danmaku/bili/ui/garb/api/BiliDLCCardItem;Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;)V", "getItemType", "()I", "getItemScarcity", "getCardItem", "()Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;", "getDisplay", "()Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCItem {
    public static final int $stable = 8;
    @SerializedName("card_item")
    private final BiliDLCCardItem cardItem;
    private final BiliDLCCardDisplay display;
    @SerializedName("item_scarcity")
    private final int itemScarcity;
    @SerializedName("item_type")
    private final int itemType;

    public static /* synthetic */ DLCItem copy$default(DLCItem dLCItem, int i, int i2, BiliDLCCardItem biliDLCCardItem, BiliDLCCardDisplay biliDLCCardDisplay, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dLCItem.itemType;
        }
        if ((i3 & 2) != 0) {
            i2 = dLCItem.itemScarcity;
        }
        if ((i3 & 4) != 0) {
            biliDLCCardItem = dLCItem.cardItem;
        }
        if ((i3 & 8) != 0) {
            biliDLCCardDisplay = dLCItem.display;
        }
        return dLCItem.copy(i, i2, biliDLCCardItem, biliDLCCardDisplay);
    }

    public final int component1() {
        return this.itemType;
    }

    public final int component2() {
        return this.itemScarcity;
    }

    public final BiliDLCCardItem component3() {
        return this.cardItem;
    }

    public final BiliDLCCardDisplay component4() {
        return this.display;
    }

    public final DLCItem copy(int i, int i2, BiliDLCCardItem biliDLCCardItem, BiliDLCCardDisplay biliDLCCardDisplay) {
        Intrinsics.checkNotNullParameter(biliDLCCardItem, "cardItem");
        Intrinsics.checkNotNullParameter(biliDLCCardDisplay, "display");
        return new DLCItem(i, i2, biliDLCCardItem, biliDLCCardDisplay);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCItem) {
            DLCItem dLCItem = (DLCItem) obj;
            return this.itemType == dLCItem.itemType && this.itemScarcity == dLCItem.itemScarcity && Intrinsics.areEqual(this.cardItem, dLCItem.cardItem) && Intrinsics.areEqual(this.display, dLCItem.display);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.itemType * 31) + this.itemScarcity) * 31) + this.cardItem.hashCode()) * 31) + this.display.hashCode();
    }

    public String toString() {
        int i = this.itemType;
        int i2 = this.itemScarcity;
        BiliDLCCardItem biliDLCCardItem = this.cardItem;
        return "DLCItem(itemType=" + i + ", itemScarcity=" + i2 + ", cardItem=" + biliDLCCardItem + ", display=" + this.display + ")";
    }

    public DLCItem(int itemType, int itemScarcity, BiliDLCCardItem cardItem, BiliDLCCardDisplay display) {
        Intrinsics.checkNotNullParameter(cardItem, "cardItem");
        Intrinsics.checkNotNullParameter(display, "display");
        this.itemType = itemType;
        this.itemScarcity = itemScarcity;
        this.cardItem = cardItem;
        this.display = display;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final int getItemScarcity() {
        return this.itemScarcity;
    }

    public final BiliDLCCardItem getCardItem() {
        return this.cardItem;
    }

    public final BiliDLCCardDisplay getDisplay() {
        return this.display;
    }
}