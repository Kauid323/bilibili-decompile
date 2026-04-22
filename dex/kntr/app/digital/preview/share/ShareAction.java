package kntr.app.digital.preview.share;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ShareActionModule.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 <2\u00020\u0001:\u0002;<BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rBi\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003JY\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015¨\u0006="}, d2 = {"Lkntr/app/digital/preview/share/ShareAction;", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueId", RoomRecommendViewModel.EMPTY_CURSOR, "shareUrl", "cardImage", "cardName", "uface", "badgeUrl", "cardScarcity", RoomRecommendViewModel.EMPTY_CURSOR, "shareDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUniqueId$annotations", "()V", "getUniqueId", "()Ljava/lang/String;", "getShareUrl$annotations", "getShareUrl", "getCardImage$annotations", "getCardImage", "getCardName$annotations", "getCardName", "getUface$annotations", "getUface", "getBadgeUrl$annotations", "getBadgeUrl", "getCardScarcity$annotations", "getCardScarcity", "()I", "getShareDesc$annotations", "getShareDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ShareAction {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String badgeUrl;
    private final String cardImage;
    private final String cardName;
    private final int cardScarcity;
    private final String shareDesc;
    private final String shareUrl;
    private final String uface;
    private final String uniqueId;

    public ShareAction() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("badge_url")
    public static /* synthetic */ void getBadgeUrl$annotations() {
    }

    @SerialName("card_img")
    public static /* synthetic */ void getCardImage$annotations() {
    }

    @SerialName("card_name")
    public static /* synthetic */ void getCardName$annotations() {
    }

    @SerialName("card_scarcity")
    public static /* synthetic */ void getCardScarcity$annotations() {
    }

    @SerialName("share_desc")
    public static /* synthetic */ void getShareDesc$annotations() {
    }

    @SerialName("share_url")
    public static /* synthetic */ void getShareUrl$annotations() {
    }

    @SerialName("uface")
    public static /* synthetic */ void getUface$annotations() {
    }

    @SerialName("unique_id")
    public static /* synthetic */ void getUniqueId$annotations() {
    }

    public final String component1() {
        return this.uniqueId;
    }

    public final String component2() {
        return this.shareUrl;
    }

    public final String component3() {
        return this.cardImage;
    }

    public final String component4() {
        return this.cardName;
    }

    public final String component5() {
        return this.uface;
    }

    public final String component6() {
        return this.badgeUrl;
    }

    public final int component7() {
        return this.cardScarcity;
    }

    public final String component8() {
        return this.shareDesc;
    }

    public final ShareAction copy(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        Intrinsics.checkNotNullParameter(str, "uniqueId");
        Intrinsics.checkNotNullParameter(str2, "shareUrl");
        Intrinsics.checkNotNullParameter(str3, "cardImage");
        Intrinsics.checkNotNullParameter(str4, "cardName");
        Intrinsics.checkNotNullParameter(str5, "uface");
        Intrinsics.checkNotNullParameter(str6, "badgeUrl");
        Intrinsics.checkNotNullParameter(str7, "shareDesc");
        return new ShareAction(str, str2, str3, str4, str5, str6, i, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareAction) {
            ShareAction shareAction = (ShareAction) obj;
            return Intrinsics.areEqual(this.uniqueId, shareAction.uniqueId) && Intrinsics.areEqual(this.shareUrl, shareAction.shareUrl) && Intrinsics.areEqual(this.cardImage, shareAction.cardImage) && Intrinsics.areEqual(this.cardName, shareAction.cardName) && Intrinsics.areEqual(this.uface, shareAction.uface) && Intrinsics.areEqual(this.badgeUrl, shareAction.badgeUrl) && this.cardScarcity == shareAction.cardScarcity && Intrinsics.areEqual(this.shareDesc, shareAction.shareDesc);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.uniqueId.hashCode() * 31) + this.shareUrl.hashCode()) * 31) + this.cardImage.hashCode()) * 31) + this.cardName.hashCode()) * 31) + this.uface.hashCode()) * 31) + this.badgeUrl.hashCode()) * 31) + this.cardScarcity) * 31) + this.shareDesc.hashCode();
    }

    public String toString() {
        String str = this.uniqueId;
        String str2 = this.shareUrl;
        String str3 = this.cardImage;
        String str4 = this.cardName;
        String str5 = this.uface;
        String str6 = this.badgeUrl;
        int i = this.cardScarcity;
        return "ShareAction(uniqueId=" + str + ", shareUrl=" + str2 + ", cardImage=" + str3 + ", cardName=" + str4 + ", uface=" + str5 + ", badgeUrl=" + str6 + ", cardScarcity=" + i + ", shareDesc=" + this.shareDesc + ")";
    }

    /* compiled from: ShareActionModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/share/ShareAction$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/share/ShareAction;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShareAction> serializer() {
            return ShareAction$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShareAction(int seen0, String uniqueId, String shareUrl, String cardImage, String cardName, String uface, String badgeUrl, int cardScarcity, String shareDesc, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.uniqueId = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.uniqueId = uniqueId;
        }
        if ((seen0 & 2) == 0) {
            this.shareUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.shareUrl = shareUrl;
        }
        if ((seen0 & 4) == 0) {
            this.cardImage = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.cardImage = cardImage;
        }
        if ((seen0 & 8) == 0) {
            this.cardName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.cardName = cardName;
        }
        if ((seen0 & 16) == 0) {
            this.uface = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.uface = uface;
        }
        if ((seen0 & 32) == 0) {
            this.badgeUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.badgeUrl = badgeUrl;
        }
        if ((seen0 & 64) == 0) {
            this.cardScarcity = 0;
        } else {
            this.cardScarcity = cardScarcity;
        }
        if ((seen0 & 128) == 0) {
            this.shareDesc = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.shareDesc = shareDesc;
        }
    }

    public ShareAction(String uniqueId, String shareUrl, String cardImage, String cardName, String uface, String badgeUrl, int cardScarcity, String shareDesc) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(cardImage, "cardImage");
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(uface, "uface");
        Intrinsics.checkNotNullParameter(badgeUrl, "badgeUrl");
        Intrinsics.checkNotNullParameter(shareDesc, "shareDesc");
        this.uniqueId = uniqueId;
        this.shareUrl = shareUrl;
        this.cardImage = cardImage;
        this.cardName = cardName;
        this.uface = uface;
        this.badgeUrl = badgeUrl;
        this.cardScarcity = cardScarcity;
        this.shareDesc = shareDesc;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(ShareAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.uniqueId, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.uniqueId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.shareUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.shareUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.cardImage, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.cardImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.cardName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.cardName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.uface, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.uface);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.badgeUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.badgeUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.cardScarcity != 0) {
            output.encodeIntElement(serialDesc, 6, self.cardScarcity);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.shareDesc, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 7, self.shareDesc);
        }
    }

    public /* synthetic */ ShareAction(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i2 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i2 & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str5, (i2 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str6, (i2 & 64) != 0 ? 0 : i, (i2 & 128) == 0 ? str7 : RoomRecommendViewModel.EMPTY_CURSOR);
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final String getCardImage() {
        return this.cardImage;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getUface() {
        return this.uface;
    }

    public final String getBadgeUrl() {
        return this.badgeUrl;
    }

    public final int getCardScarcity() {
        return this.cardScarcity;
    }

    public final String getShareDesc() {
        return this.shareDesc;
    }
}