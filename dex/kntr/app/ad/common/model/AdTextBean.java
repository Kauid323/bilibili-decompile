package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
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

/* compiled from: AdTextBean.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010Bk\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003Jk\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\tHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001e¨\u0006;"}, d2 = {"Lkntr/app/ad/common/model/AdTextBean;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "dayColor", "nightColor", "fontSize", RoomRecommendViewModel.EMPTY_CURSOR, "textDecoration", RoomRecommendViewModel.EMPTY_CURSOR, "leftMargin", RoomRecommendViewModel.EMPTY_CURSOR, "img", "imgWidth", "imgHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIFLjava/lang/String;FF)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIFLjava/lang/String;FFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getDayColor", "getNightColor", "getFontSize", "()J", "getTextDecoration", "()I", "getLeftMargin", "()F", "getImg", "getImgWidth", "getImgHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdTextBean {
    public static final Companion Companion = new Companion(null);
    private final String dayColor;
    private final long fontSize;
    private final String img;
    private final float imgHeight;
    private final float imgWidth;
    private final float leftMargin;
    private final String nightColor;
    private final String text;
    private final int textDecoration;

    public AdTextBean() {
        this((String) null, (String) null, (String) null, 0L, 0, 0.0f, (String) null, 0.0f, 0.0f, 511, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.dayColor;
    }

    public final String component3() {
        return this.nightColor;
    }

    public final long component4() {
        return this.fontSize;
    }

    public final int component5() {
        return this.textDecoration;
    }

    public final float component6() {
        return this.leftMargin;
    }

    public final String component7() {
        return this.img;
    }

    public final float component8() {
        return this.imgWidth;
    }

    public final float component9() {
        return this.imgHeight;
    }

    public final AdTextBean copy(String str, String str2, String str3, long j2, int i, float f, String str4, float f2, float f3) {
        return new AdTextBean(str, str2, str3, j2, i, f, str4, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTextBean) {
            AdTextBean adTextBean = (AdTextBean) obj;
            return Intrinsics.areEqual(this.text, adTextBean.text) && Intrinsics.areEqual(this.dayColor, adTextBean.dayColor) && Intrinsics.areEqual(this.nightColor, adTextBean.nightColor) && this.fontSize == adTextBean.fontSize && this.textDecoration == adTextBean.textDecoration && Float.compare(this.leftMargin, adTextBean.leftMargin) == 0 && Intrinsics.areEqual(this.img, adTextBean.img) && Float.compare(this.imgWidth, adTextBean.imgWidth) == 0 && Float.compare(this.imgHeight, adTextBean.imgHeight) == 0;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.text == null ? 0 : this.text.hashCode()) * 31) + (this.dayColor == null ? 0 : this.dayColor.hashCode())) * 31) + (this.nightColor == null ? 0 : this.nightColor.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.fontSize)) * 31) + this.textDecoration) * 31) + Float.floatToIntBits(this.leftMargin)) * 31) + (this.img != null ? this.img.hashCode() : 0)) * 31) + Float.floatToIntBits(this.imgWidth)) * 31) + Float.floatToIntBits(this.imgHeight);
    }

    public String toString() {
        String str = this.text;
        String str2 = this.dayColor;
        String str3 = this.nightColor;
        long j2 = this.fontSize;
        int i = this.textDecoration;
        float f = this.leftMargin;
        String str4 = this.img;
        float f2 = this.imgWidth;
        return "AdTextBean(text=" + str + ", dayColor=" + str2 + ", nightColor=" + str3 + ", fontSize=" + j2 + ", textDecoration=" + i + ", leftMargin=" + f + ", img=" + str4 + ", imgWidth=" + f2 + ", imgHeight=" + this.imgHeight + ")";
    }

    /* compiled from: AdTextBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdTextBean$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdTextBean;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdTextBean> serializer() {
            return AdTextBean$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdTextBean(int seen0, String text, String dayColor, String nightColor, long fontSize, int textDecoration, float leftMargin, String img, float imgWidth, float imgHeight, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 2) == 0) {
            this.dayColor = null;
        } else {
            this.dayColor = dayColor;
        }
        if ((seen0 & 4) == 0) {
            this.nightColor = null;
        } else {
            this.nightColor = nightColor;
        }
        if ((seen0 & 8) == 0) {
            this.fontSize = 0L;
        } else {
            this.fontSize = fontSize;
        }
        if ((seen0 & 16) == 0) {
            this.textDecoration = 0;
        } else {
            this.textDecoration = textDecoration;
        }
        if ((seen0 & 32) == 0) {
            this.leftMargin = 0.0f;
        } else {
            this.leftMargin = leftMargin;
        }
        if ((seen0 & 64) == 0) {
            this.img = null;
        } else {
            this.img = img;
        }
        if ((seen0 & 128) == 0) {
            this.imgWidth = 0.0f;
        } else {
            this.imgWidth = imgWidth;
        }
        if ((seen0 & 256) == 0) {
            this.imgHeight = 0.0f;
        } else {
            this.imgHeight = imgHeight;
        }
    }

    public AdTextBean(String text, String dayColor, String nightColor, long fontSize, int textDecoration, float leftMargin, String img, float imgWidth, float imgHeight) {
        this.text = text;
        this.dayColor = dayColor;
        this.nightColor = nightColor;
        this.fontSize = fontSize;
        this.textDecoration = textDecoration;
        this.leftMargin = leftMargin;
        this.img = img;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdTextBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.dayColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.dayColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.nightColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.nightColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fontSize != 0) {
            output.encodeLongElement(serialDesc, 3, self.fontSize);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.textDecoration != 0) {
            output.encodeIntElement(serialDesc, 4, self.textDecoration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Float.compare(self.leftMargin, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 5, self.leftMargin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.img != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.img);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Float.compare(self.imgWidth, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 7, self.imgWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || Float.compare(self.imgHeight, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 8, self.imgHeight);
        }
    }

    public /* synthetic */ AdTextBean(String str, String str2, String str3, long j2, int i, float f, String str4, float f2, float f3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? 0L : j2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? 0.0f : f, (i2 & 64) == 0 ? str4 : null, (i2 & 128) != 0 ? 0.0f : f2, (i2 & 256) == 0 ? f3 : 0.0f);
    }

    public final String getText() {
        return this.text;
    }

    public final String getDayColor() {
        return this.dayColor;
    }

    public final String getNightColor() {
        return this.nightColor;
    }

    public final long getFontSize() {
        return this.fontSize;
    }

    public final int getTextDecoration() {
        return this.textDecoration;
    }

    public final float getLeftMargin() {
        return this.leftMargin;
    }

    public final String getImg() {
        return this.img;
    }

    public final float getImgWidth() {
        return this.imgWidth;
    }

    public final float getImgHeight() {
        return this.imgHeight;
    }
}