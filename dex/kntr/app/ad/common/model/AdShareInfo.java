package kntr.app.ad.common.model;

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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdShareInfo.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006("}, d2 = {"Lkntr/app/ad/common/model/AdShareInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "shareTitle", RoomRecommendViewModel.EMPTY_CURSOR, "shareSubtitle", "shareImg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShareTitle$annotations", "()V", "getShareTitle", "()Ljava/lang/String;", "getShareSubtitle$annotations", "getShareSubtitle", "getShareImg$annotations", "getShareImg", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdShareInfo {
    public static final Companion Companion = new Companion(null);
    private final String shareImg;
    private final String shareSubtitle;
    private final String shareTitle;

    public AdShareInfo() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdShareInfo copy$default(AdShareInfo adShareInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adShareInfo.shareTitle;
        }
        if ((i & 2) != 0) {
            str2 = adShareInfo.shareSubtitle;
        }
        if ((i & 4) != 0) {
            str3 = adShareInfo.shareImg;
        }
        return adShareInfo.copy(str, str2, str3);
    }

    @SerialName("image_url")
    public static /* synthetic */ void getShareImg$annotations() {
    }

    @SerialName("subtitle")
    public static /* synthetic */ void getShareSubtitle$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getShareTitle$annotations() {
    }

    public final String component1() {
        return this.shareTitle;
    }

    public final String component2() {
        return this.shareSubtitle;
    }

    public final String component3() {
        return this.shareImg;
    }

    public final AdShareInfo copy(String str, String str2, String str3) {
        return new AdShareInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdShareInfo) {
            AdShareInfo adShareInfo = (AdShareInfo) obj;
            return Intrinsics.areEqual(this.shareTitle, adShareInfo.shareTitle) && Intrinsics.areEqual(this.shareSubtitle, adShareInfo.shareSubtitle) && Intrinsics.areEqual(this.shareImg, adShareInfo.shareImg);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.shareTitle == null ? 0 : this.shareTitle.hashCode()) * 31) + (this.shareSubtitle == null ? 0 : this.shareSubtitle.hashCode())) * 31) + (this.shareImg != null ? this.shareImg.hashCode() : 0);
    }

    public String toString() {
        String str = this.shareTitle;
        String str2 = this.shareSubtitle;
        return "AdShareInfo(shareTitle=" + str + ", shareSubtitle=" + str2 + ", shareImg=" + this.shareImg + ")";
    }

    /* compiled from: AdShareInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdShareInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdShareInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdShareInfo> serializer() {
            return AdShareInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdShareInfo(int seen0, String shareTitle, String shareSubtitle, String shareImg, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.shareTitle = null;
        } else {
            this.shareTitle = shareTitle;
        }
        if ((seen0 & 2) == 0) {
            this.shareSubtitle = null;
        } else {
            this.shareSubtitle = shareSubtitle;
        }
        if ((seen0 & 4) == 0) {
            this.shareImg = null;
        } else {
            this.shareImg = shareImg;
        }
    }

    public AdShareInfo(String shareTitle, String shareSubtitle, String shareImg) {
        this.shareTitle = shareTitle;
        this.shareSubtitle = shareSubtitle;
        this.shareImg = shareImg;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdShareInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.shareTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.shareTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shareSubtitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.shareSubtitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shareImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.shareImg);
        }
    }

    public /* synthetic */ AdShareInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getShareTitle() {
        return this.shareTitle;
    }

    public final String getShareSubtitle() {
        return this.shareSubtitle;
    }

    public final String getShareImg() {
        return this.shareImg;
    }
}