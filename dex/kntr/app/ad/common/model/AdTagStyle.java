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

/* compiled from: AdTagStyle.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010B\u0083\u0001\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0087\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u0006="}, d2 = {"Lkntr/app/ad/common/model/AdTagStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "bgColor", "borderColor", "textColor", "bgColorNight", "borderColorNight", "textColorNight", "imgUrl", "imgHeight", "imgWidth", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()I", "getText", "()Ljava/lang/String;", "getBgColor", "getBorderColor", "getTextColor", "getBgColorNight", "getBorderColorNight", "getTextColorNight", "getImgUrl", "getImgHeight", "getImgWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdTagStyle {
    public static final Companion Companion = new Companion(null);
    private final String bgColor;
    private final String bgColorNight;
    private final String borderColor;
    private final String borderColorNight;
    private final int imgHeight;
    private final String imgUrl;
    private final int imgWidth;
    private final String text;
    private final String textColor;
    private final String textColorNight;
    private final int type;

    public AdTagStyle() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, 2047, (DefaultConstructorMarker) null);
    }

    public final int component1() {
        return this.type;
    }

    public final int component10() {
        return this.imgHeight;
    }

    public final int component11() {
        return this.imgWidth;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.bgColor;
    }

    public final String component4() {
        return this.borderColor;
    }

    public final String component5() {
        return this.textColor;
    }

    public final String component6() {
        return this.bgColorNight;
    }

    public final String component7() {
        return this.borderColorNight;
    }

    public final String component8() {
        return this.textColorNight;
    }

    public final String component9() {
        return this.imgUrl;
    }

    public final AdTagStyle copy(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, int i3) {
        return new AdTagStyle(i, str, str2, str3, str4, str5, str6, str7, str8, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTagStyle) {
            AdTagStyle adTagStyle = (AdTagStyle) obj;
            return this.type == adTagStyle.type && Intrinsics.areEqual(this.text, adTagStyle.text) && Intrinsics.areEqual(this.bgColor, adTagStyle.bgColor) && Intrinsics.areEqual(this.borderColor, adTagStyle.borderColor) && Intrinsics.areEqual(this.textColor, adTagStyle.textColor) && Intrinsics.areEqual(this.bgColorNight, adTagStyle.bgColorNight) && Intrinsics.areEqual(this.borderColorNight, adTagStyle.borderColorNight) && Intrinsics.areEqual(this.textColorNight, adTagStyle.textColorNight) && Intrinsics.areEqual(this.imgUrl, adTagStyle.imgUrl) && this.imgHeight == adTagStyle.imgHeight && this.imgWidth == adTagStyle.imgWidth;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((this.type * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.bgColor == null ? 0 : this.bgColor.hashCode())) * 31) + (this.borderColor == null ? 0 : this.borderColor.hashCode())) * 31) + (this.textColor == null ? 0 : this.textColor.hashCode())) * 31) + (this.bgColorNight == null ? 0 : this.bgColorNight.hashCode())) * 31) + (this.borderColorNight == null ? 0 : this.borderColorNight.hashCode())) * 31) + (this.textColorNight == null ? 0 : this.textColorNight.hashCode())) * 31) + (this.imgUrl != null ? this.imgUrl.hashCode() : 0)) * 31) + this.imgHeight) * 31) + this.imgWidth;
    }

    public String toString() {
        int i = this.type;
        String str = this.text;
        String str2 = this.bgColor;
        String str3 = this.borderColor;
        String str4 = this.textColor;
        String str5 = this.bgColorNight;
        String str6 = this.borderColorNight;
        String str7 = this.textColorNight;
        String str8 = this.imgUrl;
        int i2 = this.imgHeight;
        return "AdTagStyle(type=" + i + ", text=" + str + ", bgColor=" + str2 + ", borderColor=" + str3 + ", textColor=" + str4 + ", bgColorNight=" + str5 + ", borderColorNight=" + str6 + ", textColorNight=" + str7 + ", imgUrl=" + str8 + ", imgHeight=" + i2 + ", imgWidth=" + this.imgWidth + ")";
    }

    /* compiled from: AdTagStyle.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdTagStyle$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdTagStyle;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdTagStyle> serializer() {
            return AdTagStyle$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdTagStyle(int seen0, int type, String text, String bgColor, String borderColor, String textColor, String bgColorNight, String borderColorNight, String textColorNight, String imgUrl, int imgHeight, int imgWidth, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
        if ((seen0 & 2) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 4) == 0) {
            this.bgColor = null;
        } else {
            this.bgColor = bgColor;
        }
        if ((seen0 & 8) == 0) {
            this.borderColor = null;
        } else {
            this.borderColor = borderColor;
        }
        if ((seen0 & 16) == 0) {
            this.textColor = null;
        } else {
            this.textColor = textColor;
        }
        if ((seen0 & 32) == 0) {
            this.bgColorNight = null;
        } else {
            this.bgColorNight = bgColorNight;
        }
        if ((seen0 & 64) == 0) {
            this.borderColorNight = null;
        } else {
            this.borderColorNight = borderColorNight;
        }
        if ((seen0 & 128) == 0) {
            this.textColorNight = null;
        } else {
            this.textColorNight = textColorNight;
        }
        if ((seen0 & 256) == 0) {
            this.imgUrl = null;
        } else {
            this.imgUrl = imgUrl;
        }
        if ((seen0 & 512) == 0) {
            this.imgHeight = 0;
        } else {
            this.imgHeight = imgHeight;
        }
        if ((seen0 & 1024) == 0) {
            this.imgWidth = 0;
        } else {
            this.imgWidth = imgWidth;
        }
    }

    public AdTagStyle(int type, String text, String bgColor, String borderColor, String textColor, String bgColorNight, String borderColorNight, String textColorNight, String imgUrl, int imgHeight, int imgWidth) {
        this.type = type;
        this.text = text;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        this.textColor = textColor;
        this.bgColorNight = bgColorNight;
        this.borderColorNight = borderColorNight;
        this.textColorNight = textColorNight;
        this.imgUrl = imgUrl;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdTagStyle self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != 0) {
            output.encodeIntElement(serialDesc, 0, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bgColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.bgColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.borderColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.borderColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.textColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.textColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.bgColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.bgColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.borderColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.borderColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.textColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.textColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.imgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.imgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.imgHeight != 0) {
            output.encodeIntElement(serialDesc, 9, self.imgHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.imgWidth != 0) {
            output.encodeIntElement(serialDesc, 10, self.imgWidth);
        }
    }

    public /* synthetic */ AdTagStyle(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? null : str4, (i4 & 32) != 0 ? null : str5, (i4 & 64) != 0 ? null : str6, (i4 & 128) != 0 ? null : str7, (i4 & 256) == 0 ? str8 : null, (i4 & 512) != 0 ? 0 : i2, (i4 & 1024) == 0 ? i3 : 0);
    }

    public final int getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getBgColorNight() {
        return this.bgColorNight;
    }

    public final String getBorderColorNight() {
        return this.borderColorNight;
    }

    public final String getTextColorNight() {
        return this.textColorNight;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final int getImgHeight() {
        return this.imgHeight;
    }

    public final int getImgWidth() {
        return this.imgWidth;
    }
}