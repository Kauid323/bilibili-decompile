package tv.danmaku.bili.ui.garb.nft.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: DLCDetailModel.kt */
@Bson
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bB\b\u0087\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\r\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b$\u0010%J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u0019\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\u0019\u0010P\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\rHÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0007HÆ\u0003J\t\u0010U\u001a\u00020\u0007HÆ\u0003J\t\u0010V\u001a\u00020\u0019HÆ\u0003J\t\u0010W\u001a\u00020\u001bHÆ\u0003J\t\u0010X\u001a\u00020\u0007HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010CJ\u000b\u0010]\u001a\u0004\u0018\u00010\u0007HÆ\u0003J¬\u0002\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010_J\u0013\u0010`\u001a\u00020\"2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020\u0005HÖ\u0001J\t\u0010c\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0016\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0016\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0016\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0016\u0010\u001a\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0013\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010D\u001a\u0004\b!\u0010CR\u0013\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+¨\u0006d"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailModel;", "", "cardTypeId", "", "cardActivityType", "", "cardName", "", "cardImg", "cardType", "cardIdList", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailIdModel;", "Lkotlin/collections/ArrayList;", "totalCnt", "silence", "totalCntShow", "realChance", "videoList", "needRequest", "width", "height", "cardExtText", "subtitlesUrl", "play", "Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", AppConfig.HOST_TAG, "Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "cardImgDownload", "videoDownloadList", "", "leftTopTagImg", "frameImg", "isHighlight", "", "rewardTag", "<init>", "(JILjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;IILjava/lang/String;ILjava/util/ArrayList;IIILjava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCardTypeId", "()J", "getCardActivityType", "()I", "getCardName", "()Ljava/lang/String;", "getCardImg", "getCardType", "getCardIdList", "()Ljava/util/ArrayList;", "getTotalCnt", "getSilence", "getTotalCntShow", "getRealChance", "getVideoList", "getNeedRequest", "getWidth", "getHeight", "getCardExtText", "getSubtitlesUrl", "getPlay", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", "getTag", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "getCardImgDownload", "getVideoDownloadList", "()Ljava/util/List;", "getLeftTopTagImg", "getFrameImg", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRewardTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(JILjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;IILjava/lang/String;ILjava/util/ArrayList;IIILjava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailModel;", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailModel {
    public static final int $stable = 8;
    @SerializedName("card_activity_type")
    private final int cardActivityType;
    @SerializedName("card_ext_text")
    private final String cardExtText;
    @SerializedName("card_id_list")
    private final ArrayList<DigitalCardDetailIdModel> cardIdList;
    @SerializedName("card_img")
    private final String cardImg;
    @SerializedName("card_img_download")
    private final String cardImgDownload;
    @SerializedName("card_name")
    private final String cardName;
    @SerializedName("card_type")
    private final int cardType;
    @SerializedName("card_type_id")
    private final long cardTypeId;
    private final String frameImg;
    @SerializedName("height")
    private final int height;
    private final Boolean isHighlight;
    private final String leftTopTagImg;
    @SerializedName("is_physical_orientation")
    private final int needRequest;
    @SerializedName("play")
    private final DLCPlayModel play;
    @SerializedName("holding_rate")
    private final int realChance;
    private final String rewardTag;
    @SerializedName("is_mute")
    private final int silence;
    @SerializedName("subtitles_url")
    private final String subtitlesUrl;
    @SerializedName(AppConfig.HOST_TAG)
    private final DLCTagModel tag;
    @SerializedName("total_cnt")
    private final int totalCnt;
    @SerializedName("total_cnt_show")
    private final String totalCntShow;
    @SerializedName("video_list_download")
    private final List<String> videoDownloadList;
    @SerializedName("video_list")
    private final ArrayList<String> videoList;
    @SerializedName("width")
    private final int width;

    public final long component1() {
        return this.cardTypeId;
    }

    public final int component10() {
        return this.realChance;
    }

    public final ArrayList<String> component11() {
        return this.videoList;
    }

    public final int component12() {
        return this.needRequest;
    }

    public final int component13() {
        return this.width;
    }

    public final int component14() {
        return this.height;
    }

    public final String component15() {
        return this.cardExtText;
    }

    public final String component16() {
        return this.subtitlesUrl;
    }

    public final DLCPlayModel component17() {
        return this.play;
    }

    public final DLCTagModel component18() {
        return this.tag;
    }

    public final String component19() {
        return this.cardImgDownload;
    }

    public final int component2() {
        return this.cardActivityType;
    }

    public final List<String> component20() {
        return this.videoDownloadList;
    }

    public final String component21() {
        return this.leftTopTagImg;
    }

    public final String component22() {
        return this.frameImg;
    }

    public final Boolean component23() {
        return this.isHighlight;
    }

    public final String component24() {
        return this.rewardTag;
    }

    public final String component3() {
        return this.cardName;
    }

    public final String component4() {
        return this.cardImg;
    }

    public final int component5() {
        return this.cardType;
    }

    public final ArrayList<DigitalCardDetailIdModel> component6() {
        return this.cardIdList;
    }

    public final int component7() {
        return this.totalCnt;
    }

    public final int component8() {
        return this.silence;
    }

    public final String component9() {
        return this.totalCntShow;
    }

    public final DigitalCardDetailModel copy(long j, int i, String str, String str2, int i2, ArrayList<DigitalCardDetailIdModel> arrayList, int i3, int i4, String str3, int i5, ArrayList<String> arrayList2, int i6, int i7, int i8, String str4, String str5, DLCPlayModel dLCPlayModel, DLCTagModel dLCTagModel, String str6, List<String> list, String str7, String str8, Boolean bool, String str9) {
        Intrinsics.checkNotNullParameter(str, "cardName");
        Intrinsics.checkNotNullParameter(str2, "cardImg");
        Intrinsics.checkNotNullParameter(arrayList, "cardIdList");
        Intrinsics.checkNotNullParameter(str3, "totalCntShow");
        Intrinsics.checkNotNullParameter(arrayList2, "videoList");
        Intrinsics.checkNotNullParameter(str4, "cardExtText");
        Intrinsics.checkNotNullParameter(str5, "subtitlesUrl");
        Intrinsics.checkNotNullParameter(dLCPlayModel, "play");
        Intrinsics.checkNotNullParameter(dLCTagModel, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(str6, "cardImgDownload");
        Intrinsics.checkNotNullParameter(list, "videoDownloadList");
        return new DigitalCardDetailModel(j, i, str, str2, i2, arrayList, i3, i4, str3, i5, arrayList2, i6, i7, i8, str4, str5, dLCPlayModel, dLCTagModel, str6, list, str7, str8, bool, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DigitalCardDetailModel) {
            DigitalCardDetailModel digitalCardDetailModel = (DigitalCardDetailModel) obj;
            return this.cardTypeId == digitalCardDetailModel.cardTypeId && this.cardActivityType == digitalCardDetailModel.cardActivityType && Intrinsics.areEqual(this.cardName, digitalCardDetailModel.cardName) && Intrinsics.areEqual(this.cardImg, digitalCardDetailModel.cardImg) && this.cardType == digitalCardDetailModel.cardType && Intrinsics.areEqual(this.cardIdList, digitalCardDetailModel.cardIdList) && this.totalCnt == digitalCardDetailModel.totalCnt && this.silence == digitalCardDetailModel.silence && Intrinsics.areEqual(this.totalCntShow, digitalCardDetailModel.totalCntShow) && this.realChance == digitalCardDetailModel.realChance && Intrinsics.areEqual(this.videoList, digitalCardDetailModel.videoList) && this.needRequest == digitalCardDetailModel.needRequest && this.width == digitalCardDetailModel.width && this.height == digitalCardDetailModel.height && Intrinsics.areEqual(this.cardExtText, digitalCardDetailModel.cardExtText) && Intrinsics.areEqual(this.subtitlesUrl, digitalCardDetailModel.subtitlesUrl) && Intrinsics.areEqual(this.play, digitalCardDetailModel.play) && Intrinsics.areEqual(this.tag, digitalCardDetailModel.tag) && Intrinsics.areEqual(this.cardImgDownload, digitalCardDetailModel.cardImgDownload) && Intrinsics.areEqual(this.videoDownloadList, digitalCardDetailModel.videoDownloadList) && Intrinsics.areEqual(this.leftTopTagImg, digitalCardDetailModel.leftTopTagImg) && Intrinsics.areEqual(this.frameImg, digitalCardDetailModel.frameImg) && Intrinsics.areEqual(this.isHighlight, digitalCardDetailModel.isHighlight) && Intrinsics.areEqual(this.rewardTag, digitalCardDetailModel.rewardTag);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId) * 31) + this.cardActivityType) * 31) + this.cardName.hashCode()) * 31) + this.cardImg.hashCode()) * 31) + this.cardType) * 31) + this.cardIdList.hashCode()) * 31) + this.totalCnt) * 31) + this.silence) * 31) + this.totalCntShow.hashCode()) * 31) + this.realChance) * 31) + this.videoList.hashCode()) * 31) + this.needRequest) * 31) + this.width) * 31) + this.height) * 31) + this.cardExtText.hashCode()) * 31) + this.subtitlesUrl.hashCode()) * 31) + this.play.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.cardImgDownload.hashCode()) * 31) + this.videoDownloadList.hashCode()) * 31) + (this.leftTopTagImg == null ? 0 : this.leftTopTagImg.hashCode())) * 31) + (this.frameImg == null ? 0 : this.frameImg.hashCode())) * 31) + (this.isHighlight == null ? 0 : this.isHighlight.hashCode())) * 31) + (this.rewardTag != null ? this.rewardTag.hashCode() : 0);
    }

    public String toString() {
        long j = this.cardTypeId;
        int i = this.cardActivityType;
        String str = this.cardName;
        String str2 = this.cardImg;
        int i2 = this.cardType;
        ArrayList<DigitalCardDetailIdModel> arrayList = this.cardIdList;
        int i3 = this.totalCnt;
        int i4 = this.silence;
        String str3 = this.totalCntShow;
        int i5 = this.realChance;
        ArrayList<String> arrayList2 = this.videoList;
        int i6 = this.needRequest;
        int i7 = this.width;
        int i8 = this.height;
        String str4 = this.cardExtText;
        String str5 = this.subtitlesUrl;
        DLCPlayModel dLCPlayModel = this.play;
        DLCTagModel dLCTagModel = this.tag;
        String str6 = this.cardImgDownload;
        List<String> list = this.videoDownloadList;
        String str7 = this.leftTopTagImg;
        String str8 = this.frameImg;
        Boolean bool = this.isHighlight;
        return "DigitalCardDetailModel(cardTypeId=" + j + ", cardActivityType=" + i + ", cardName=" + str + ", cardImg=" + str2 + ", cardType=" + i2 + ", cardIdList=" + arrayList + ", totalCnt=" + i3 + ", silence=" + i4 + ", totalCntShow=" + str3 + ", realChance=" + i5 + ", videoList=" + arrayList2 + ", needRequest=" + i6 + ", width=" + i7 + ", height=" + i8 + ", cardExtText=" + str4 + ", subtitlesUrl=" + str5 + ", play=" + dLCPlayModel + ", tag=" + dLCTagModel + ", cardImgDownload=" + str6 + ", videoDownloadList=" + list + ", leftTopTagImg=" + str7 + ", frameImg=" + str8 + ", isHighlight=" + bool + ", rewardTag=" + this.rewardTag + ")";
    }

    public DigitalCardDetailModel(long cardTypeId, int cardActivityType, String cardName, String cardImg, int cardType, ArrayList<DigitalCardDetailIdModel> arrayList, int totalCnt, int silence, String totalCntShow, int realChance, ArrayList<String> arrayList2, int needRequest, int width, int height, String cardExtText, String subtitlesUrl, DLCPlayModel play, DLCTagModel tag, String cardImgDownload, List<String> list, String leftTopTagImg, String frameImg, Boolean isHighlight, String rewardTag) {
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(cardImg, "cardImg");
        Intrinsics.checkNotNullParameter(arrayList, "cardIdList");
        Intrinsics.checkNotNullParameter(totalCntShow, "totalCntShow");
        Intrinsics.checkNotNullParameter(arrayList2, "videoList");
        Intrinsics.checkNotNullParameter(cardExtText, "cardExtText");
        Intrinsics.checkNotNullParameter(subtitlesUrl, "subtitlesUrl");
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(cardImgDownload, "cardImgDownload");
        Intrinsics.checkNotNullParameter(list, "videoDownloadList");
        this.cardTypeId = cardTypeId;
        this.cardActivityType = cardActivityType;
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
        this.cardExtText = cardExtText;
        this.subtitlesUrl = subtitlesUrl;
        this.play = play;
        this.tag = tag;
        this.cardImgDownload = cardImgDownload;
        this.videoDownloadList = list;
        this.leftTopTagImg = leftTopTagImg;
        this.frameImg = frameImg;
        this.isHighlight = isHighlight;
        this.rewardTag = rewardTag;
    }

    public /* synthetic */ DigitalCardDetailModel(long j, int i, String str, String str2, int i2, ArrayList arrayList, int i3, int i4, String str3, int i5, ArrayList arrayList2, int i6, int i7, int i8, String str4, String str5, DLCPlayModel dLCPlayModel, DLCTagModel dLCTagModel, String str6, List list, String str7, String str8, Boolean bool, String str9, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, str, str2, i2, arrayList, i3, i4, str3, i5, arrayList2, i6, i7, i8, str4, str5, dLCPlayModel, dLCTagModel, str6, list, (i9 & 1048576) != 0 ? null : str7, (i9 & 2097152) != 0 ? null : str8, (i9 & 4194304) != 0 ? null : bool, (i9 & 8388608) != 0 ? null : str9);
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }

    public final int getCardActivityType() {
        return this.cardActivityType;
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

    public final ArrayList<DigitalCardDetailIdModel> getCardIdList() {
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

    public final String getCardExtText() {
        return this.cardExtText;
    }

    public final String getSubtitlesUrl() {
        return this.subtitlesUrl;
    }

    public final DLCPlayModel getPlay() {
        return this.play;
    }

    public final DLCTagModel getTag() {
        return this.tag;
    }

    public final String getCardImgDownload() {
        return this.cardImgDownload;
    }

    public final List<String> getVideoDownloadList() {
        return this.videoDownloadList;
    }

    public final String getLeftTopTagImg() {
        return this.leftTopTagImg;
    }

    public final String getFrameImg() {
        return this.frameImg;
    }

    public final Boolean isHighlight() {
        return this.isHighlight;
    }

    public final String getRewardTag() {
        return this.rewardTag;
    }
}