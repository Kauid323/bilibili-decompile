package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003JO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;", "", "cardTypeInfo", "Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "cardChance", "", "cardInfo", "Ltv/danmaku/bili/ui/garb/api/CardInfo;", "cardTypeCnt", "", "cardTypeCntShow", "", "play", "Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", AppConfig.HOST_TAG, "Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "<init>", "(Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;FLtv/danmaku/bili/ui/garb/api/CardInfo;ILjava/lang/String;Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;)V", "getCardTypeInfo", "()Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "getCardChance", "()F", "getCardInfo", "()Ltv/danmaku/bili/ui/garb/api/CardInfo;", "getCardTypeCnt", "()I", "getCardTypeCntShow", "()Ljava/lang/String;", "getPlay", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", "getTag", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliDLCCardItem {
    public static final int $stable = 8;
    @SerializedName("card_chance")
    private final float cardChance;
    @SerializedName("card_info")
    private final CardInfo cardInfo;
    @SerializedName("card_type_cnt")
    private final int cardTypeCnt;
    @SerializedName("card_type_cnt_show")
    private final String cardTypeCntShow;
    @SerializedName("card_type_info")
    private final CardTypeInfo cardTypeInfo;
    @SerializedName("play")
    private final DLCPlayModel play;
    @SerializedName(AppConfig.HOST_TAG)
    private final DLCTagModel tag;

    public static /* synthetic */ BiliDLCCardItem copy$default(BiliDLCCardItem biliDLCCardItem, CardTypeInfo cardTypeInfo, float f, CardInfo cardInfo, int i, String str, DLCPlayModel dLCPlayModel, DLCTagModel dLCTagModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cardTypeInfo = biliDLCCardItem.cardTypeInfo;
        }
        if ((i2 & 2) != 0) {
            f = biliDLCCardItem.cardChance;
        }
        float f2 = f;
        if ((i2 & 4) != 0) {
            cardInfo = biliDLCCardItem.cardInfo;
        }
        CardInfo cardInfo2 = cardInfo;
        if ((i2 & 8) != 0) {
            i = biliDLCCardItem.cardTypeCnt;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str = biliDLCCardItem.cardTypeCntShow;
        }
        String str2 = str;
        if ((i2 & 32) != 0) {
            dLCPlayModel = biliDLCCardItem.play;
        }
        DLCPlayModel dLCPlayModel2 = dLCPlayModel;
        if ((i2 & 64) != 0) {
            dLCTagModel = biliDLCCardItem.tag;
        }
        return biliDLCCardItem.copy(cardTypeInfo, f2, cardInfo2, i3, str2, dLCPlayModel2, dLCTagModel);
    }

    public final CardTypeInfo component1() {
        return this.cardTypeInfo;
    }

    public final float component2() {
        return this.cardChance;
    }

    public final CardInfo component3() {
        return this.cardInfo;
    }

    public final int component4() {
        return this.cardTypeCnt;
    }

    public final String component5() {
        return this.cardTypeCntShow;
    }

    public final DLCPlayModel component6() {
        return this.play;
    }

    public final DLCTagModel component7() {
        return this.tag;
    }

    public final BiliDLCCardItem copy(CardTypeInfo cardTypeInfo, float f, CardInfo cardInfo, int i, String str, DLCPlayModel dLCPlayModel, DLCTagModel dLCTagModel) {
        Intrinsics.checkNotNullParameter(cardTypeInfo, "cardTypeInfo");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        Intrinsics.checkNotNullParameter(str, "cardTypeCntShow");
        Intrinsics.checkNotNullParameter(dLCPlayModel, "play");
        Intrinsics.checkNotNullParameter(dLCTagModel, AppConfig.HOST_TAG);
        return new BiliDLCCardItem(cardTypeInfo, f, cardInfo, i, str, dLCPlayModel, dLCTagModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliDLCCardItem) {
            BiliDLCCardItem biliDLCCardItem = (BiliDLCCardItem) obj;
            return Intrinsics.areEqual(this.cardTypeInfo, biliDLCCardItem.cardTypeInfo) && Float.compare(this.cardChance, biliDLCCardItem.cardChance) == 0 && Intrinsics.areEqual(this.cardInfo, biliDLCCardItem.cardInfo) && this.cardTypeCnt == biliDLCCardItem.cardTypeCnt && Intrinsics.areEqual(this.cardTypeCntShow, biliDLCCardItem.cardTypeCntShow) && Intrinsics.areEqual(this.play, biliDLCCardItem.play) && Intrinsics.areEqual(this.tag, biliDLCCardItem.tag);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.cardTypeInfo.hashCode() * 31) + Float.floatToIntBits(this.cardChance)) * 31) + this.cardInfo.hashCode()) * 31) + this.cardTypeCnt) * 31) + this.cardTypeCntShow.hashCode()) * 31) + this.play.hashCode()) * 31) + this.tag.hashCode();
    }

    public String toString() {
        CardTypeInfo cardTypeInfo = this.cardTypeInfo;
        float f = this.cardChance;
        CardInfo cardInfo = this.cardInfo;
        int i = this.cardTypeCnt;
        String str = this.cardTypeCntShow;
        DLCPlayModel dLCPlayModel = this.play;
        return "BiliDLCCardItem(cardTypeInfo=" + cardTypeInfo + ", cardChance=" + f + ", cardInfo=" + cardInfo + ", cardTypeCnt=" + i + ", cardTypeCntShow=" + str + ", play=" + dLCPlayModel + ", tag=" + this.tag + ")";
    }

    public BiliDLCCardItem(CardTypeInfo cardTypeInfo, float cardChance, CardInfo cardInfo, int cardTypeCnt, String cardTypeCntShow, DLCPlayModel play, DLCTagModel tag) {
        Intrinsics.checkNotNullParameter(cardTypeInfo, "cardTypeInfo");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        Intrinsics.checkNotNullParameter(cardTypeCntShow, "cardTypeCntShow");
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        this.cardTypeInfo = cardTypeInfo;
        this.cardChance = cardChance;
        this.cardInfo = cardInfo;
        this.cardTypeCnt = cardTypeCnt;
        this.cardTypeCntShow = cardTypeCntShow;
        this.play = play;
        this.tag = tag;
    }

    public final CardTypeInfo getCardTypeInfo() {
        return this.cardTypeInfo;
    }

    public final float getCardChance() {
        return this.cardChance;
    }

    public final CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final int getCardTypeCnt() {
        return this.cardTypeCnt;
    }

    public final String getCardTypeCntShow() {
        return this.cardTypeCntShow;
    }

    public final DLCPlayModel getPlay() {
        return this.play;
    }

    public final DLCTagModel getTag() {
        return this.tag;
    }
}