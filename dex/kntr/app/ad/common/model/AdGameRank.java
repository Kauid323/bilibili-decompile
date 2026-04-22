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

/* compiled from: AdGameRank.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fBk\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u00063"}, d2 = {"Lkntr/app/ad/common/model/AdGameRank;", RoomRecommendViewModel.EMPTY_CURSOR, "iconUrl", RoomRecommendViewModel.EMPTY_CURSOR, "iconNightUrl", "bkgDayColor", "bkgNightColor", "fontDayColor", "fontNightColor", "rankContent", "rankLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIconUrl", "()Ljava/lang/String;", "getIconNightUrl", "getBkgDayColor", "getBkgNightColor", "getFontDayColor", "getFontNightColor", "getRankContent", "getRankLink", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameRank {
    public static final Companion Companion = new Companion(null);
    private final String bkgDayColor;
    private final String bkgNightColor;
    private final String fontDayColor;
    private final String fontNightColor;
    private final String iconNightUrl;
    private final String iconUrl;
    private final String rankContent;
    private final String rankLink;

    public AdGameRank() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.iconNightUrl;
    }

    public final String component3() {
        return this.bkgDayColor;
    }

    public final String component4() {
        return this.bkgNightColor;
    }

    public final String component5() {
        return this.fontDayColor;
    }

    public final String component6() {
        return this.fontNightColor;
    }

    public final String component7() {
        return this.rankContent;
    }

    public final String component8() {
        return this.rankLink;
    }

    public final AdGameRank copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new AdGameRank(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameRank) {
            AdGameRank adGameRank = (AdGameRank) obj;
            return Intrinsics.areEqual(this.iconUrl, adGameRank.iconUrl) && Intrinsics.areEqual(this.iconNightUrl, adGameRank.iconNightUrl) && Intrinsics.areEqual(this.bkgDayColor, adGameRank.bkgDayColor) && Intrinsics.areEqual(this.bkgNightColor, adGameRank.bkgNightColor) && Intrinsics.areEqual(this.fontDayColor, adGameRank.fontDayColor) && Intrinsics.areEqual(this.fontNightColor, adGameRank.fontNightColor) && Intrinsics.areEqual(this.rankContent, adGameRank.rankContent) && Intrinsics.areEqual(this.rankLink, adGameRank.rankLink);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.iconUrl == null ? 0 : this.iconUrl.hashCode()) * 31) + (this.iconNightUrl == null ? 0 : this.iconNightUrl.hashCode())) * 31) + (this.bkgDayColor == null ? 0 : this.bkgDayColor.hashCode())) * 31) + (this.bkgNightColor == null ? 0 : this.bkgNightColor.hashCode())) * 31) + (this.fontDayColor == null ? 0 : this.fontDayColor.hashCode())) * 31) + (this.fontNightColor == null ? 0 : this.fontNightColor.hashCode())) * 31) + (this.rankContent == null ? 0 : this.rankContent.hashCode())) * 31) + (this.rankLink != null ? this.rankLink.hashCode() : 0);
    }

    public String toString() {
        String str = this.iconUrl;
        String str2 = this.iconNightUrl;
        String str3 = this.bkgDayColor;
        String str4 = this.bkgNightColor;
        String str5 = this.fontDayColor;
        String str6 = this.fontNightColor;
        String str7 = this.rankContent;
        return "AdGameRank(iconUrl=" + str + ", iconNightUrl=" + str2 + ", bkgDayColor=" + str3 + ", bkgNightColor=" + str4 + ", fontDayColor=" + str5 + ", fontNightColor=" + str6 + ", rankContent=" + str7 + ", rankLink=" + this.rankLink + ")";
    }

    /* compiled from: AdGameRank.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameRank$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameRank;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameRank> serializer() {
            return AdGameRank$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameRank(int seen0, String iconUrl, String iconNightUrl, String bkgDayColor, String bkgNightColor, String fontDayColor, String fontNightColor, String rankContent, String rankLink, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.iconUrl = null;
        } else {
            this.iconUrl = iconUrl;
        }
        if ((seen0 & 2) == 0) {
            this.iconNightUrl = null;
        } else {
            this.iconNightUrl = iconNightUrl;
        }
        if ((seen0 & 4) == 0) {
            this.bkgDayColor = null;
        } else {
            this.bkgDayColor = bkgDayColor;
        }
        if ((seen0 & 8) == 0) {
            this.bkgNightColor = null;
        } else {
            this.bkgNightColor = bkgNightColor;
        }
        if ((seen0 & 16) == 0) {
            this.fontDayColor = null;
        } else {
            this.fontDayColor = fontDayColor;
        }
        if ((seen0 & 32) == 0) {
            this.fontNightColor = null;
        } else {
            this.fontNightColor = fontNightColor;
        }
        if ((seen0 & 64) == 0) {
            this.rankContent = null;
        } else {
            this.rankContent = rankContent;
        }
        if ((seen0 & 128) == 0) {
            this.rankLink = null;
        } else {
            this.rankLink = rankLink;
        }
    }

    public AdGameRank(String iconUrl, String iconNightUrl, String bkgDayColor, String bkgNightColor, String fontDayColor, String fontNightColor, String rankContent, String rankLink) {
        this.iconUrl = iconUrl;
        this.iconNightUrl = iconNightUrl;
        this.bkgDayColor = bkgDayColor;
        this.bkgNightColor = bkgNightColor;
        this.fontDayColor = fontDayColor;
        this.fontNightColor = fontNightColor;
        this.rankContent = rankContent;
        this.rankLink = rankLink;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameRank self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.iconUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.iconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.iconNightUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.iconNightUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bkgDayColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.bkgDayColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.bkgNightColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.bkgNightColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fontDayColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.fontDayColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.fontNightColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.fontNightColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.rankContent != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.rankContent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.rankLink != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.rankLink);
        }
    }

    public /* synthetic */ AdGameRank(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) == 0 ? str8 : null);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconNightUrl() {
        return this.iconNightUrl;
    }

    public final String getBkgDayColor() {
        return this.bkgDayColor;
    }

    public final String getBkgNightColor() {
        return this.bkgNightColor;
    }

    public final String getFontDayColor() {
        return this.fontDayColor;
    }

    public final String getFontNightColor() {
        return this.fontNightColor;
    }

    public final String getRankContent() {
        return this.rankContent;
    }

    public final String getRankLink() {
        return this.rankLink;
    }
}