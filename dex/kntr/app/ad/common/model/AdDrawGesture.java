package kntr.app.ad.common.model;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdEasterEggParams.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012Bw\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003Jy\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\bHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u001b\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001d¨\u0006?"}, d2 = {"Lkntr/app/ad/common/model/AdDrawGesture;", RoomRecommendViewModel.EMPTY_CURSOR, "guideImage", RoomRecommendViewModel.EMPTY_CURSOR, "imageWidth", RoomRecommendViewModel.EMPTY_CURSOR, "imageHeight", "positionX", RoomRecommendViewModel.EMPTY_CURSOR, "positionY", "activeTimes", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "duration", "drawLength", "startAngle", "endAngle", "<init>", "(Ljava/lang/String;FFIILjava/util/List;IIII)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;FFIILjava/util/List;IIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGuideImage", "()Ljava/lang/String;", "getImageWidth", "()F", "getImageHeight", "getPositionX", "()I", "getPositionY", "getActiveTimes", "()Ljava/util/List;", "getDuration", "getDrawLength", "getStartAngle", "getEndAngle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdDrawGesture {
    private final List<Long> activeTimes;
    private final int drawLength;
    private final int duration;
    private final int endAngle;
    private final String guideImage;
    private final float imageHeight;
    private final float imageWidth;
    private final int positionX;
    private final int positionY;
    private final int startAngle;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdDrawGesture$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdDrawGesture._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null};

    public AdDrawGesture() {
        this((String) null, 0.0f, 0.0f, 0, 0, (List) null, 0, 0, 0, 0, 1023, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.guideImage;
    }

    public final int component10() {
        return this.endAngle;
    }

    public final float component2() {
        return this.imageWidth;
    }

    public final float component3() {
        return this.imageHeight;
    }

    public final int component4() {
        return this.positionX;
    }

    public final int component5() {
        return this.positionY;
    }

    public final List<Long> component6() {
        return this.activeTimes;
    }

    public final int component7() {
        return this.duration;
    }

    public final int component8() {
        return this.drawLength;
    }

    public final int component9() {
        return this.startAngle;
    }

    public final AdDrawGesture copy(String str, float f, float f2, int i, int i2, List<Long> list, int i3, int i4, int i5, int i6) {
        return new AdDrawGesture(str, f, f2, i, i2, list, i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdDrawGesture) {
            AdDrawGesture adDrawGesture = (AdDrawGesture) obj;
            return Intrinsics.areEqual(this.guideImage, adDrawGesture.guideImage) && Float.compare(this.imageWidth, adDrawGesture.imageWidth) == 0 && Float.compare(this.imageHeight, adDrawGesture.imageHeight) == 0 && this.positionX == adDrawGesture.positionX && this.positionY == adDrawGesture.positionY && Intrinsics.areEqual(this.activeTimes, adDrawGesture.activeTimes) && this.duration == adDrawGesture.duration && this.drawLength == adDrawGesture.drawLength && this.startAngle == adDrawGesture.startAngle && this.endAngle == adDrawGesture.endAngle;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((this.guideImage == null ? 0 : this.guideImage.hashCode()) * 31) + Float.floatToIntBits(this.imageWidth)) * 31) + Float.floatToIntBits(this.imageHeight)) * 31) + this.positionX) * 31) + this.positionY) * 31) + (this.activeTimes != null ? this.activeTimes.hashCode() : 0)) * 31) + this.duration) * 31) + this.drawLength) * 31) + this.startAngle) * 31) + this.endAngle;
    }

    public String toString() {
        String str = this.guideImage;
        float f = this.imageWidth;
        float f2 = this.imageHeight;
        int i = this.positionX;
        int i2 = this.positionY;
        List<Long> list = this.activeTimes;
        int i3 = this.duration;
        int i4 = this.drawLength;
        int i5 = this.startAngle;
        return "AdDrawGesture(guideImage=" + str + ", imageWidth=" + f + ", imageHeight=" + f2 + ", positionX=" + i + ", positionY=" + i2 + ", activeTimes=" + list + ", duration=" + i3 + ", drawLength=" + i4 + ", startAngle=" + i5 + ", endAngle=" + this.endAngle + ")";
    }

    /* compiled from: AdEasterEggParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdDrawGesture$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdDrawGesture;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdDrawGesture> serializer() {
            return AdDrawGesture$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdDrawGesture(int seen0, String guideImage, float imageWidth, float imageHeight, int positionX, int positionY, List activeTimes, int duration, int drawLength, int startAngle, int endAngle, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.guideImage = null;
        } else {
            this.guideImage = guideImage;
        }
        if ((seen0 & 2) == 0) {
            this.imageWidth = 0.0f;
        } else {
            this.imageWidth = imageWidth;
        }
        if ((seen0 & 4) == 0) {
            this.imageHeight = 0.0f;
        } else {
            this.imageHeight = imageHeight;
        }
        if ((seen0 & 8) == 0) {
            this.positionX = 0;
        } else {
            this.positionX = positionX;
        }
        if ((seen0 & 16) == 0) {
            this.positionY = 0;
        } else {
            this.positionY = positionY;
        }
        if ((seen0 & 32) == 0) {
            this.activeTimes = null;
        } else {
            this.activeTimes = activeTimes;
        }
        if ((seen0 & 64) == 0) {
            this.duration = 0;
        } else {
            this.duration = duration;
        }
        if ((seen0 & 128) == 0) {
            this.drawLength = 0;
        } else {
            this.drawLength = drawLength;
        }
        if ((seen0 & 256) == 0) {
            this.startAngle = 0;
        } else {
            this.startAngle = startAngle;
        }
        if ((seen0 & 512) == 0) {
            this.endAngle = 0;
        } else {
            this.endAngle = endAngle;
        }
    }

    public AdDrawGesture(String guideImage, float imageWidth, float imageHeight, int positionX, int positionY, List<Long> list, int duration, int drawLength, int startAngle, int endAngle) {
        this.guideImage = guideImage;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.positionX = positionX;
        this.positionY = positionY;
        this.activeTimes = list;
        this.duration = duration;
        this.drawLength = drawLength;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdDrawGesture self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.guideImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.guideImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Float.compare(self.imageWidth, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 1, self.imageWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Float.compare(self.imageHeight, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 2, self.imageHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.positionX != 0) {
            output.encodeIntElement(serialDesc, 3, self.positionX);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.positionY != 0) {
            output.encodeIntElement(serialDesc, 4, self.positionY);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.activeTimes != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.activeTimes);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.duration != 0) {
            output.encodeIntElement(serialDesc, 6, self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.drawLength != 0) {
            output.encodeIntElement(serialDesc, 7, self.drawLength);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.startAngle != 0) {
            output.encodeIntElement(serialDesc, 8, self.startAngle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.endAngle != 0) {
            output.encodeIntElement(serialDesc, 9, self.endAngle);
        }
    }

    public /* synthetic */ AdDrawGesture(String str, float f, float f2, int i, int i2, List list, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? null : str, (i7 & 2) != 0 ? 0.0f : f, (i7 & 4) == 0 ? f2 : 0.0f, (i7 & 8) != 0 ? 0 : i, (i7 & 16) != 0 ? 0 : i2, (i7 & 32) == 0 ? list : null, (i7 & 64) != 0 ? 0 : i3, (i7 & 128) != 0 ? 0 : i4, (i7 & 256) != 0 ? 0 : i5, (i7 & 512) == 0 ? i6 : 0);
    }

    public final String getGuideImage() {
        return this.guideImage;
    }

    public final float getImageWidth() {
        return this.imageWidth;
    }

    public final float getImageHeight() {
        return this.imageHeight;
    }

    public final int getPositionX() {
        return this.positionX;
    }

    public final int getPositionY() {
        return this.positionY;
    }

    public final List<Long> getActiveTimes() {
        return this.activeTimes;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getDrawLength() {
        return this.drawLength;
    }

    public final int getStartAngle() {
        return this.startAngle;
    }

    public final int getEndAngle() {
        return this.endAngle;
    }
}