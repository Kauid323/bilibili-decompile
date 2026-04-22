package kntr.app.digital.preview;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: CardNumberColorUtil.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 92\u00020\u0001:\u0003789BN\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u001f\b\u0002\u0010\u0005\u001a\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eBO\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u0010\u0010 \u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b!\u0010\u0017J\u0010\u0010\"\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b#\u0010\u0017J \u0010$\u001a\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n\u0018\u00010\u0006HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006HÆ\u0003JW\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001f\b\u0002\u0010\u0005\u001a\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n\u0018\u00010\u00062\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0010HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001e\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R3\u0010\u0005\u001a\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u001d¨\u0006:"}, d2 = {"Lkntr/app/digital/preview/CardNumberGradientColor;", RoomRecommendViewModel.EMPTY_CURSOR, "startPoint", "Landroidx/compose/ui/geometry/Offset;", "endPoint", "rgbaColors", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/graphics/Color;", "Lkotlinx/serialization/Serializable;", "with", "Lkntr/app/digital/preview/RgbaColorSerializer;", "positions", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JJLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILandroidx/compose/ui/geometry/Offset;Landroidx/compose/ui/geometry/Offset;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStartPoint-F1C5BW0$annotations", "()V", "getStartPoint-F1C5BW0", "()J", "J", "getEndPoint-F1C5BW0$annotations", "getEndPoint-F1C5BW0", "getRgbaColors$annotations", "getRgbaColors", "()Ljava/util/List;", "getPositions$annotations", "getPositions", "component1", "component1-F1C5BW0", "component2", "component2-F1C5BW0", "component3", "component4", "copy", "copy-jyLRC_s", "(JJLjava/util/List;Ljava/util/List;)Lkntr/app/digital/preview/CardNumberGradientColor;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "OffsetSerializer", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class CardNumberGradientColor {
    private final long endPoint;
    private final List<Float> positions;
    private final List<Color> rgbaColors;
    private final long startPoint;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.CardNumberGradientColor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = CardNumberGradientColor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.CardNumberGradientColor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = CardNumberGradientColor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public /* synthetic */ CardNumberGradientColor(int i, Offset offset, Offset offset2, List list, List list2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, offset, offset2, list, list2, serializationConstructorMarker);
    }

    public /* synthetic */ CardNumberGradientColor(long j2, long j3, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, list, list2);
    }

    /* renamed from: copy-jyLRC_s$default  reason: not valid java name */
    public static /* synthetic */ CardNumberGradientColor m857copyjyLRC_s$default(CardNumberGradientColor cardNumberGradientColor, long j2, long j3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = cardNumberGradientColor.startPoint;
        }
        long j4 = j2;
        if ((i & 2) != 0) {
            j3 = cardNumberGradientColor.endPoint;
        }
        long j5 = j3;
        List<Color> list3 = list;
        if ((i & 4) != 0) {
            list3 = cardNumberGradientColor.rgbaColors;
        }
        List list4 = list3;
        List<Float> list5 = list2;
        if ((i & 8) != 0) {
            list5 = cardNumberGradientColor.positions;
        }
        return cardNumberGradientColor.m862copyjyLRC_s(j4, j5, list4, list5);
    }

    @SerialName("end_point")
    @Serializable(with = OffsetSerializer.class)
    /* renamed from: getEndPoint-F1C5BW0$annotations  reason: not valid java name */
    public static /* synthetic */ void m858getEndPointF1C5BW0$annotations() {
    }

    @SerialName("gradients")
    public static /* synthetic */ void getPositions$annotations() {
    }

    @SerialName("colors")
    public static /* synthetic */ void getRgbaColors$annotations() {
    }

    @SerialName("start_point")
    @Serializable(with = OffsetSerializer.class)
    /* renamed from: getStartPoint-F1C5BW0$annotations  reason: not valid java name */
    public static /* synthetic */ void m859getStartPointF1C5BW0$annotations() {
    }

    /* renamed from: component1-F1C5BW0  reason: not valid java name */
    public final long m860component1F1C5BW0() {
        return this.startPoint;
    }

    /* renamed from: component2-F1C5BW0  reason: not valid java name */
    public final long m861component2F1C5BW0() {
        return this.endPoint;
    }

    public final List<Color> component3() {
        return this.rgbaColors;
    }

    public final List<Float> component4() {
        return this.positions;
    }

    /* renamed from: copy-jyLRC_s  reason: not valid java name */
    public final CardNumberGradientColor m862copyjyLRC_s(long j2, long j3, List<Color> list, List<Float> list2) {
        return new CardNumberGradientColor(j2, j3, list, list2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardNumberGradientColor) {
            CardNumberGradientColor cardNumberGradientColor = (CardNumberGradientColor) obj;
            return Offset.equals-impl0(this.startPoint, cardNumberGradientColor.startPoint) && Offset.equals-impl0(this.endPoint, cardNumberGradientColor.endPoint) && Intrinsics.areEqual(this.rgbaColors, cardNumberGradientColor.rgbaColors) && Intrinsics.areEqual(this.positions, cardNumberGradientColor.positions);
        }
        return false;
    }

    public int hashCode() {
        return (((((Offset.hashCode-impl(this.startPoint) * 31) + Offset.hashCode-impl(this.endPoint)) * 31) + (this.rgbaColors == null ? 0 : this.rgbaColors.hashCode())) * 31) + (this.positions != null ? this.positions.hashCode() : 0);
    }

    public String toString() {
        String str = Offset.toString-impl(this.startPoint);
        String str2 = Offset.toString-impl(this.endPoint);
        List<Color> list = this.rgbaColors;
        return "CardNumberGradientColor(startPoint=" + str + ", endPoint=" + str2 + ", rgbaColors=" + list + ", positions=" + this.positions + ")";
    }

    /* compiled from: CardNumberColorUtil.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/CardNumberGradientColor$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/CardNumberGradientColor;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CardNumberGradientColor> serializer() {
            return CardNumberGradientColor$$serializer.INSTANCE;
        }
    }

    private /* synthetic */ CardNumberGradientColor(int seen0, Offset startPoint, Offset endPoint, List rgbaColors, List positions, SerializationConstructorMarker serializationConstructorMarker) {
        this.startPoint = (seen0 & 1) == 0 ? Offset.Companion.getUnspecified-F1C5BW0() : startPoint.unbox-impl();
        this.endPoint = (seen0 & 2) == 0 ? Offset.Companion.getUnspecified-F1C5BW0() : endPoint.unbox-impl();
        if ((seen0 & 4) == 0) {
            this.rgbaColors = null;
        } else {
            this.rgbaColors = rgbaColors;
        }
        if ((seen0 & 8) == 0) {
            this.positions = null;
        } else {
            this.positions = positions;
        }
    }

    private CardNumberGradientColor(long startPoint, long endPoint, List<Color> list, List<Float> list2) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.rgbaColors = list;
        this.positions = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(RgbaColorSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(FloatSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(CardNumberGradientColor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Offset.equals-impl0(self.startPoint, Offset.Companion.getUnspecified-F1C5BW0())) {
            output.encodeSerializableElement(serialDesc, 0, OffsetSerializer.INSTANCE, Offset.box-impl(self.startPoint));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Offset.equals-impl0(self.endPoint, Offset.Companion.getUnspecified-F1C5BW0())) {
            output.encodeSerializableElement(serialDesc, 1, OffsetSerializer.INSTANCE, Offset.box-impl(self.endPoint));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rgbaColors != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.rgbaColors);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.positions != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.positions);
        }
    }

    public /* synthetic */ CardNumberGradientColor(long j2, long j3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Offset.Companion.getUnspecified-F1C5BW0() : j2, (i & 2) != 0 ? Offset.Companion.getUnspecified-F1C5BW0() : j3, (i & 4) != 0 ? null : list, (i & 8) == 0 ? list2 : null, null);
    }

    /* renamed from: getStartPoint-F1C5BW0  reason: not valid java name */
    public final long m864getStartPointF1C5BW0() {
        return this.startPoint;
    }

    /* renamed from: getEndPoint-F1C5BW0  reason: not valid java name */
    public final long m863getEndPointF1C5BW0() {
        return this.endPoint;
    }

    public final List<Color> getRgbaColors() {
        return this.rgbaColors;
    }

    public final List<Float> getPositions() {
        return this.positions;
    }

    /* compiled from: CardNumberColorUtil.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/preview/CardNumberGradientColor$OffsetSerializer;", "Lkotlinx/serialization/KSerializer;", "Landroidx/compose/ui/geometry/Offset;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-Uv8p0NA", "(Lkotlinx/serialization/encoding/Encoder;J)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-tuRUvjQ", "(Lkotlinx/serialization/encoding/Decoder;)J", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class OffsetSerializer implements KSerializer<Offset> {
        public static final OffsetSerializer INSTANCE = new OffsetSerializer();
        private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("PairIntInt", PrimitiveKind.STRING.INSTANCE);
        public static final int $stable = 8;

        private OffsetSerializer() {
        }

        public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
            return Offset.box-impl(m866deserializetuRUvjQ(decoder));
        }

        public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
            m867serializeUv8p0NA(encoder, ((Offset) value).unbox-impl());
        }

        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        /* renamed from: serialize-Uv8p0NA  reason: not valid java name */
        public void m867serializeUv8p0NA(Encoder encoder, long j2) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            int bits$iv$iv$iv = (int) (j2 >> 32);
            float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
            int bits$iv$iv$iv2 = (int) (4294967295L & j2);
            encoder.encodeString(intBitsToFloat + "," + Float.intBitsToFloat(bits$iv$iv$iv2));
        }

        /* renamed from: deserialize-tuRUvjQ  reason: not valid java name */
        public long m866deserializetuRUvjQ(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            String str = decoder.decodeString();
            Iterable $this$map$iv = StringsKt.split$default(str, new char[]{','}, false, 0, 6, (Object) null);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(StringsKt.trim(it).toString());
            }
            List parts = (List) destination$iv$iv;
            if (parts.size() < 2) {
                return Offset.Companion.getUnspecified-F1C5BW0();
            }
            float x$iv = Float.parseFloat((String) parts.get(0));
            float y$iv = Float.parseFloat((String) parts.get(1));
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
        }
    }
}