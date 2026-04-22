package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdLotteryCard.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003Ji\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0010HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00067"}, d2 = {"Lkntr/app/ad/common/model/AdResultPage;", RoomRecommendViewModel.EMPTY_CURSOR, "bgImage", RoomRecommendViewModel.EMPTY_CURSOR, "logImage", "themeColor", "contentImage", "guideTxt", "promptTxt", "tinyButton", "Lkntr/app/ad/common/model/AdTinyButton;", "extraInfo", "Lkntr/app/ad/common/model/AdExtraInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdTinyButton;Lkntr/app/ad/common/model/AdExtraInfo;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdTinyButton;Lkntr/app/ad/common/model/AdExtraInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBgImage", "()Ljava/lang/String;", "getLogImage", "getThemeColor", "getContentImage", "getGuideTxt", "getPromptTxt", "getTinyButton", "()Lkntr/app/ad/common/model/AdTinyButton;", "getExtraInfo", "()Lkntr/app/ad/common/model/AdExtraInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdResultPage {
    public static final Companion Companion = new Companion(null);
    private final String bgImage;
    private final String contentImage;
    private final AdExtraInfo extraInfo;
    private final String guideTxt;
    private final String logImage;
    private final String promptTxt;
    private final String themeColor;
    private final AdTinyButton tinyButton;

    public AdResultPage() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (AdTinyButton) null, (AdExtraInfo) null, 255, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.bgImage;
    }

    public final String component2() {
        return this.logImage;
    }

    public final String component3() {
        return this.themeColor;
    }

    public final String component4() {
        return this.contentImage;
    }

    public final String component5() {
        return this.guideTxt;
    }

    public final String component6() {
        return this.promptTxt;
    }

    public final AdTinyButton component7() {
        return this.tinyButton;
    }

    public final AdExtraInfo component8() {
        return this.extraInfo;
    }

    public final AdResultPage copy(String str, String str2, String str3, String str4, String str5, String str6, AdTinyButton adTinyButton, AdExtraInfo adExtraInfo) {
        return new AdResultPage(str, str2, str3, str4, str5, str6, adTinyButton, adExtraInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdResultPage) {
            AdResultPage adResultPage = (AdResultPage) obj;
            return Intrinsics.areEqual(this.bgImage, adResultPage.bgImage) && Intrinsics.areEqual(this.logImage, adResultPage.logImage) && Intrinsics.areEqual(this.themeColor, adResultPage.themeColor) && Intrinsics.areEqual(this.contentImage, adResultPage.contentImage) && Intrinsics.areEqual(this.guideTxt, adResultPage.guideTxt) && Intrinsics.areEqual(this.promptTxt, adResultPage.promptTxt) && Intrinsics.areEqual(this.tinyButton, adResultPage.tinyButton) && Intrinsics.areEqual(this.extraInfo, adResultPage.extraInfo);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.bgImage == null ? 0 : this.bgImage.hashCode()) * 31) + (this.logImage == null ? 0 : this.logImage.hashCode())) * 31) + (this.themeColor == null ? 0 : this.themeColor.hashCode())) * 31) + (this.contentImage == null ? 0 : this.contentImage.hashCode())) * 31) + (this.guideTxt == null ? 0 : this.guideTxt.hashCode())) * 31) + (this.promptTxt == null ? 0 : this.promptTxt.hashCode())) * 31) + (this.tinyButton == null ? 0 : this.tinyButton.hashCode())) * 31) + (this.extraInfo != null ? this.extraInfo.hashCode() : 0);
    }

    public String toString() {
        String str = this.bgImage;
        String str2 = this.logImage;
        String str3 = this.themeColor;
        String str4 = this.contentImage;
        String str5 = this.guideTxt;
        String str6 = this.promptTxt;
        AdTinyButton adTinyButton = this.tinyButton;
        return "AdResultPage(bgImage=" + str + ", logImage=" + str2 + ", themeColor=" + str3 + ", contentImage=" + str4 + ", guideTxt=" + str5 + ", promptTxt=" + str6 + ", tinyButton=" + adTinyButton + ", extraInfo=" + this.extraInfo + ")";
    }

    /* compiled from: AdLotteryCard.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdResultPage$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdResultPage;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdResultPage> serializer() {
            return AdResultPage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdResultPage(int seen0, String bgImage, String logImage, String themeColor, String contentImage, String guideTxt, String promptTxt, AdTinyButton tinyButton, AdExtraInfo extraInfo, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.bgImage = null;
        } else {
            this.bgImage = bgImage;
        }
        if ((seen0 & 2) == 0) {
            this.logImage = null;
        } else {
            this.logImage = logImage;
        }
        if ((seen0 & 4) == 0) {
            this.themeColor = null;
        } else {
            this.themeColor = themeColor;
        }
        if ((seen0 & 8) == 0) {
            this.contentImage = null;
        } else {
            this.contentImage = contentImage;
        }
        if ((seen0 & 16) == 0) {
            this.guideTxt = null;
        } else {
            this.guideTxt = guideTxt;
        }
        if ((seen0 & 32) == 0) {
            this.promptTxt = null;
        } else {
            this.promptTxt = promptTxt;
        }
        if ((seen0 & 64) == 0) {
            this.tinyButton = null;
        } else {
            this.tinyButton = tinyButton;
        }
        if ((seen0 & 128) == 0) {
            this.extraInfo = null;
        } else {
            this.extraInfo = extraInfo;
        }
    }

    public AdResultPage(String bgImage, String logImage, String themeColor, String contentImage, String guideTxt, String promptTxt, AdTinyButton tinyButton, AdExtraInfo extraInfo) {
        this.bgImage = bgImage;
        this.logImage = logImage;
        this.themeColor = themeColor;
        this.contentImage = contentImage;
        this.guideTxt = guideTxt;
        this.promptTxt = promptTxt;
        this.tinyButton = tinyButton;
        this.extraInfo = extraInfo;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdResultPage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bgImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.bgImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.logImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.logImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.themeColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.themeColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.contentImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.contentImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.guideTxt != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.guideTxt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.promptTxt != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.promptTxt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.tinyButton != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, AdTinyButton$$serializer.INSTANCE, self.tinyButton);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.extraInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, AdExtraInfo$$serializer.INSTANCE, self.extraInfo);
        }
    }

    public /* synthetic */ AdResultPage(String str, String str2, String str3, String str4, String str5, String str6, AdTinyButton adTinyButton, AdExtraInfo adExtraInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : adTinyButton, (i & 128) == 0 ? adExtraInfo : null);
    }

    public final String getBgImage() {
        return this.bgImage;
    }

    public final String getLogImage() {
        return this.logImage;
    }

    public final String getThemeColor() {
        return this.themeColor;
    }

    public final String getContentImage() {
        return this.contentImage;
    }

    public final String getGuideTxt() {
        return this.guideTxt;
    }

    public final String getPromptTxt() {
        return this.promptTxt;
    }

    public final AdTinyButton getTinyButton() {
        return this.tinyButton;
    }

    public final AdExtraInfo getExtraInfo() {
        return this.extraInfo;
    }
}