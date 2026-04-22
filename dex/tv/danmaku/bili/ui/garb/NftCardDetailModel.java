package tv.danmaku.bili.ui.garb;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: NftCardModel.kt */
@Bson
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\f\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\u0019\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\fHÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J«\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\f2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\bHÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\bHÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0016\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\u0014\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001d¨\u0006;"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardDetailModel;", "", "cardTypeId", "", "cardName", "", "cardImg", "cardType", "", "cardIdList", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/garb/NftCardDetailIdModel;", "Lkotlin/collections/ArrayList;", "totalCnt", "silence", "totalCntShow", "realChance", "videoList", "needRequest", "width", "height", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;IILjava/lang/String;ILjava/util/ArrayList;III)V", "getCardTypeId", "()J", "getCardName", "()Ljava/lang/String;", "getCardImg", "getCardType", "()I", "getCardIdList", "()Ljava/util/ArrayList;", "getTotalCnt", "getSilence", "getTotalCntShow", "getRealChance", "getVideoList", "getNeedRequest", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardDetailModel {
    public static final int $stable = 8;
    @SerializedName("card_id_list")
    private final ArrayList<NftCardDetailIdModel> cardIdList;
    @SerializedName("card_img")
    private final String cardImg;
    @SerializedName("card_name")
    private final String cardName;
    @SerializedName("card_type")
    private final int cardType;
    @SerializedName("card_type_id")
    private final long cardTypeId;
    @SerializedName("height")
    private final int height;
    @SerializedName("is_req_detail")
    private final int needRequest;
    @SerializedName("holding_rate")
    private final int realChance;
    @SerializedName("is_mute")
    private final int silence;
    @SerializedName("total_cnt")
    private final int totalCnt;
    @SerializedName("total_cnt_show")
    private final String totalCntShow;
    @SerializedName("video_list")
    private final ArrayList<String> videoList;
    @SerializedName("width")
    private final int width;

    public final long component1() {
        return this.cardTypeId;
    }

    public final ArrayList<String> component10() {
        return this.videoList;
    }

    public final int component11() {
        return this.needRequest;
    }

    public final int component12() {
        return this.width;
    }

    public final int component13() {
        return this.height;
    }

    public final String component2() {
        return this.cardName;
    }

    public final String component3() {
        return this.cardImg;
    }

    public final int component4() {
        return this.cardType;
    }

    public final ArrayList<NftCardDetailIdModel> component5() {
        return this.cardIdList;
    }

    public final int component6() {
        return this.totalCnt;
    }

    public final int component7() {
        return this.silence;
    }

    public final String component8() {
        return this.totalCntShow;
    }

    public final int component9() {
        return this.realChance;
    }

    public final NftCardDetailModel copy(long j, String str, String str2, int i, ArrayList<NftCardDetailIdModel> arrayList, int i2, int i3, String str3, int i4, ArrayList<String> arrayList2, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, "cardName");
        Intrinsics.checkNotNullParameter(str2, "cardImg");
        Intrinsics.checkNotNullParameter(arrayList, "cardIdList");
        Intrinsics.checkNotNullParameter(str3, "totalCntShow");
        Intrinsics.checkNotNullParameter(arrayList2, "videoList");
        return new NftCardDetailModel(j, str, str2, i, arrayList, i2, i3, str3, i4, arrayList2, i5, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NftCardDetailModel) {
            NftCardDetailModel nftCardDetailModel = (NftCardDetailModel) obj;
            return this.cardTypeId == nftCardDetailModel.cardTypeId && Intrinsics.areEqual(this.cardName, nftCardDetailModel.cardName) && Intrinsics.areEqual(this.cardImg, nftCardDetailModel.cardImg) && this.cardType == nftCardDetailModel.cardType && Intrinsics.areEqual(this.cardIdList, nftCardDetailModel.cardIdList) && this.totalCnt == nftCardDetailModel.totalCnt && this.silence == nftCardDetailModel.silence && Intrinsics.areEqual(this.totalCntShow, nftCardDetailModel.totalCntShow) && this.realChance == nftCardDetailModel.realChance && Intrinsics.areEqual(this.videoList, nftCardDetailModel.videoList) && this.needRequest == nftCardDetailModel.needRequest && this.width == nftCardDetailModel.width && this.height == nftCardDetailModel.height;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId) * 31) + this.cardName.hashCode()) * 31) + this.cardImg.hashCode()) * 31) + this.cardType) * 31) + this.cardIdList.hashCode()) * 31) + this.totalCnt) * 31) + this.silence) * 31) + this.totalCntShow.hashCode()) * 31) + this.realChance) * 31) + this.videoList.hashCode()) * 31) + this.needRequest) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        long j = this.cardTypeId;
        String str = this.cardName;
        String str2 = this.cardImg;
        int i = this.cardType;
        ArrayList<NftCardDetailIdModel> arrayList = this.cardIdList;
        int i2 = this.totalCnt;
        int i3 = this.silence;
        String str3 = this.totalCntShow;
        int i4 = this.realChance;
        ArrayList<String> arrayList2 = this.videoList;
        int i5 = this.needRequest;
        int i6 = this.width;
        return "NftCardDetailModel(cardTypeId=" + j + ", cardName=" + str + ", cardImg=" + str2 + ", cardType=" + i + ", cardIdList=" + arrayList + ", totalCnt=" + i2 + ", silence=" + i3 + ", totalCntShow=" + str3 + ", realChance=" + i4 + ", videoList=" + arrayList2 + ", needRequest=" + i5 + ", width=" + i6 + ", height=" + this.height + ")";
    }

    public NftCardDetailModel(long cardTypeId, String cardName, String cardImg, int cardType, ArrayList<NftCardDetailIdModel> arrayList, int totalCnt, int silence, String totalCntShow, int realChance, ArrayList<String> arrayList2, int needRequest, int width, int height) {
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(cardImg, "cardImg");
        Intrinsics.checkNotNullParameter(arrayList, "cardIdList");
        Intrinsics.checkNotNullParameter(totalCntShow, "totalCntShow");
        Intrinsics.checkNotNullParameter(arrayList2, "videoList");
        this.cardTypeId = cardTypeId;
        this.cardName = cardName;
        this.cardImg = cardImg;
        this.cardType = cardType;
        this.cardIdList = arrayList;
        this.totalCnt = totalCnt;
        this.silence = silence;
        this.totalCntShow = totalCntShow;
        this.realChance = realChance;
        this.videoList = arrayList2;
        this.needRequest = needRequest;
        this.width = width;
        this.height = height;
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getCardImg() {
        return this.cardImg;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final ArrayList<NftCardDetailIdModel> getCardIdList() {
        return this.cardIdList;
    }

    public final int getTotalCnt() {
        return this.totalCnt;
    }

    public final int getSilence() {
        return this.silence;
    }

    public final String getTotalCntShow() {
        return this.totalCntShow;
    }

    public final int getRealChance() {
        return this.realChance;
    }

    public final ArrayList<String> getVideoList() {
        return this.videoList;
    }

    public final int getNeedRequest() {
        return this.needRequest;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}