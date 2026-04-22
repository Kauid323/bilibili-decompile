package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCCardShareModel.kt */
@Bson
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/CardShareInfo;", "", "imageUrl", "", "cardName", "cardTag", "cardId", "cardTypeId", "materialType", "tagImg", "frameImg", "smeltTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getCardName", "getCardTag", "getCardId", "getCardTypeId", "getMaterialType", "getTagImg", "getFrameImg", "getSmeltTag", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CardShareInfo {
    public static final int $stable = 0;
    @SerializedName("card_id")
    private final String cardId;
    @SerializedName("card_name")
    private final String cardName;
    @SerializedName("card_tag")
    private final String cardTag;
    @SerializedName("card_type_id")
    private final String cardTypeId;
    @SerializedName("frame_img")
    private final String frameImg;
    @SerializedName("image_url")
    private final String imageUrl;
    @SerializedName("material_type")
    private final String materialType;
    @SerializedName("smelt_tag")
    private final String smeltTag;
    @SerializedName("left_top_tag_img")
    private final String tagImg;

    public CardShareInfo(String imageUrl, String cardName, String cardTag, String cardId, String cardTypeId, String materialType, String tagImg, String frameImg, String smeltTag) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(cardTag, "cardTag");
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(cardTypeId, "cardTypeId");
        Intrinsics.checkNotNullParameter(materialType, "materialType");
        Intrinsics.checkNotNullParameter(tagImg, "tagImg");
        Intrinsics.checkNotNullParameter(frameImg, "frameImg");
        Intrinsics.checkNotNullParameter(smeltTag, "smeltTag");
        this.imageUrl = imageUrl;
        this.cardName = cardName;
        this.cardTag = cardTag;
        this.cardId = cardId;
        this.cardTypeId = cardTypeId;
        this.materialType = materialType;
        this.tagImg = tagImg;
        this.frameImg = frameImg;
        this.smeltTag = smeltTag;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CardShareInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, r10);
        String str10;
        if ((i & BR.hallEnterHotText) == 0) {
            str10 = str9;
        } else {
            str10 = "";
        }
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getCardTag() {
        return this.cardTag;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getCardTypeId() {
        return this.cardTypeId;
    }

    public final String getMaterialType() {
        return this.materialType;
    }

    public final String getTagImg() {
        return this.tagImg;
    }

    public final String getFrameImg() {
        return this.frameImg;
    }

    public final String getSmeltTag() {
        return this.smeltTag;
    }
}