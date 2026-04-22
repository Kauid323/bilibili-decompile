package kntr.base.localization;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkntr/base/localization/ThresholdSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/localization/Threshold;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ThresholdSerializer implements KSerializer<Threshold> {
    public static final ThresholdSerializer INSTANCE = new ThresholdSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("SerializableThreshold", new SerialDescriptor[0], new Function1() { // from class: kntr.base.localization.ThresholdSerializer$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = ThresholdSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    });

    private ThresholdSerializer() {
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        List annotations$iv = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv = LongSerializer.INSTANCE.getDescriptor();
        $this$buildClassSerialDescriptor.element("unit", descriptor$iv, annotations$iv, false);
        List annotations$iv2 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv2 = LongSerializer.INSTANCE.getDescriptor();
        $this$buildClassSerialDescriptor.element("limit", descriptor$iv2, annotations$iv2, false);
        List annotations$iv3 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv3 = StringSerializer.INSTANCE.getDescriptor();
        $this$buildClassSerialDescriptor.element("suffix", descriptor$iv3, annotations$iv3, false);
        return Unit.INSTANCE;
    }

    public void serialize(Encoder encoder, Threshold value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeLongElement(INSTANCE.getDescriptor(), 0, value.getUnits().getValue());
        composite$iv.encodeLongElement(INSTANCE.getDescriptor(), 1, value.getLimit());
        composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 2, value.getSuffix());
        composite$iv.endStructure(descriptor$iv);
    }

    public Threshold deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        long unitValue = 0;
        Long limit = null;
        String suffix = null;
        while (true) {
            int index = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
            switch (index) {
                case -1:
                    Units units = Units.Companion.fromValue(unitValue);
                    long longValue = limit != null ? limit.longValue() : unitValue;
                    if (suffix != null) {
                        Threshold threshold = new Threshold(units, longValue, suffix);
                        composite$iv.endStructure(descriptor$iv);
                        return threshold;
                    }
                    throw new IllegalArgumentException("Missing suffix");
                case 0:
                    unitValue = composite$iv.decodeLongElement(INSTANCE.getDescriptor(), 0);
                    break;
                case 1:
                    limit = Long.valueOf(composite$iv.decodeLongElement(INSTANCE.getDescriptor(), 1));
                    break;
                case 2:
                    suffix = composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 2);
                    break;
                default:
                    throw new IllegalStateException(("Unexpected index: " + index).toString());
            }
        }
    }
}