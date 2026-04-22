package kntr.app.digital.backpack.card;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\b\u0081\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J{\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00066"}, d2 = {"Lkntr/app/digital/backpack/card/CardModel;", RoomRecommendViewModel.EMPTY_CURSOR, "cardTypeId", RoomRecommendViewModel.EMPTY_CURSOR, "anchorId", RoomRecommendViewModel.EMPTY_CURSOR, "image", "title", "rarity", "count", RoomRecommendViewModel.EMPTY_CURSOR, "badge", "hasBorder", RoomRecommendViewModel.EMPTY_CURSOR, "hasGained", "duration", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;", "stockInfo", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;)V", "getCardTypeId", "()J", "getAnchorId", "()Ljava/lang/String;", "getImage", "getTitle", "getRarity", "getCount", "()I", "getBadge", "getHasBorder", "()Z", "getHasGained", "getDuration", "()Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;", "getStockInfo", "()Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardModel {
    public static final int $stable = 0;
    private final String anchorId;
    private final String badge;
    private final long cardTypeId;
    private final int count;
    private final BackpackAssetBagModel.Tag duration;
    private final boolean hasBorder;
    private final boolean hasGained;
    private final String image;
    private final String rarity;
    private final BackpackAssetBagModel.StockInfo stockInfo;
    private final String title;

    public final long component1() {
        return this.cardTypeId;
    }

    public final BackpackAssetBagModel.Tag component10() {
        return this.duration;
    }

    public final BackpackAssetBagModel.StockInfo component11() {
        return this.stockInfo;
    }

    public final String component2() {
        return this.anchorId;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.rarity;
    }

    public final int component6() {
        return this.count;
    }

    public final String component7() {
        return this.badge;
    }

    public final boolean component8() {
        return this.hasBorder;
    }

    public final boolean component9() {
        return this.hasGained;
    }

    public final CardModel copy(long j2, String str, String str2, String str3, String str4, int i, String str5, boolean z, boolean z2, BackpackAssetBagModel.Tag tag, BackpackAssetBagModel.StockInfo stockInfo) {
        Intrinsics.checkNotNullParameter(str, "anchorId");
        Intrinsics.checkNotNullParameter(str2, "image");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "rarity");
        Intrinsics.checkNotNullParameter(str5, "badge");
        return new CardModel(j2, str, str2, str3, str4, i, str5, z, z2, tag, stockInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardModel) {
            CardModel cardModel = (CardModel) obj;
            return this.cardTypeId == cardModel.cardTypeId && Intrinsics.areEqual(this.anchorId, cardModel.anchorId) && Intrinsics.areEqual(this.image, cardModel.image) && Intrinsics.areEqual(this.title, cardModel.title) && Intrinsics.areEqual(this.rarity, cardModel.rarity) && this.count == cardModel.count && Intrinsics.areEqual(this.badge, cardModel.badge) && this.hasBorder == cardModel.hasBorder && this.hasGained == cardModel.hasGained && Intrinsics.areEqual(this.duration, cardModel.duration) && Intrinsics.areEqual(this.stockInfo, cardModel.stockInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId) * 31) + this.anchorId.hashCode()) * 31) + this.image.hashCode()) * 31) + this.title.hashCode()) * 31) + this.rarity.hashCode()) * 31) + this.count) * 31) + this.badge.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasBorder)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasGained)) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.stockInfo != null ? this.stockInfo.hashCode() : 0);
    }

    public String toString() {
        long j2 = this.cardTypeId;
        String str = this.anchorId;
        String str2 = this.image;
        String str3 = this.title;
        String str4 = this.rarity;
        int i = this.count;
        String str5 = this.badge;
        boolean z = this.hasBorder;
        boolean z2 = this.hasGained;
        BackpackAssetBagModel.Tag tag = this.duration;
        return "CardModel(cardTypeId=" + j2 + ", anchorId=" + str + ", image=" + str2 + ", title=" + str3 + ", rarity=" + str4 + ", count=" + i + ", badge=" + str5 + ", hasBorder=" + z + ", hasGained=" + z2 + ", duration=" + tag + ", stockInfo=" + this.stockInfo + ")";
    }

    public CardModel(long cardTypeId, String anchorId, String image, String title, String rarity, int count, String badge, boolean hasBorder, boolean hasGained, BackpackAssetBagModel.Tag duration, BackpackAssetBagModel.StockInfo stockInfo) {
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(rarity, "rarity");
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.cardTypeId = cardTypeId;
        this.anchorId = anchorId;
        this.image = image;
        this.title = title;
        this.rarity = rarity;
        this.count = count;
        this.badge = badge;
        this.hasBorder = hasBorder;
        this.hasGained = hasGained;
        this.duration = duration;
        this.stockInfo = stockInfo;
    }

    public /* synthetic */ CardModel(long j2, String str, String str2, String str3, String str4, int i, String str5, boolean z, boolean z2, BackpackAssetBagModel.Tag tag, BackpackAssetBagModel.StockInfo stockInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, str, str2, str3, str4, i, str5, z, z2, (i2 & 512) != 0 ? null : tag, (i2 & 1024) != 0 ? null : stockInfo);
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getRarity() {
        return this.rarity;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final boolean getHasBorder() {
        return this.hasBorder;
    }

    public final boolean getHasGained() {
        return this.hasGained;
    }

    public final BackpackAssetBagModel.Tag getDuration() {
        return this.duration;
    }

    public final BackpackAssetBagModel.StockInfo getStockInfo() {
        return this.stockInfo;
    }
}