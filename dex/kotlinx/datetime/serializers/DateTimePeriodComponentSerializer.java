package kotlinx.datetime.serializers;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimePeriod;
import kotlinx.datetime.DateTimePeriodKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;

/* compiled from: DateTimePeriodSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/serializers/DateTimePeriodComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimePeriod;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DateTimePeriodComponentSerializer implements KSerializer<DateTimePeriod> {
    public static final DateTimePeriodComponentSerializer INSTANCE = new DateTimePeriodComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.DateTimePeriod", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.DateTimePeriodComponentSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            List annotations$iv = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv = IntSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("years", descriptor$iv, annotations$iv, true);
            List annotations$iv2 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv2 = IntSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("months", descriptor$iv2, annotations$iv2, true);
            List annotations$iv3 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv3 = IntSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("days", descriptor$iv3, annotations$iv3, true);
            List annotations$iv4 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv4 = IntSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("hours", descriptor$iv4, annotations$iv4, true);
            List annotations$iv5 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv5 = IntSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("minutes", descriptor$iv5, annotations$iv5, true);
            List annotations$iv6 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv6 = IntSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("seconds", descriptor$iv6, annotations$iv6, true);
            List annotations$iv7 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv7 = LongSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("nanoseconds", descriptor$iv7, annotations$iv7, true);
        }
    });

    private DateTimePeriodComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DateTimePeriod deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        Decoder $this$decodeStructure$iv = decoder;
        CompositeDecoder composite$iv = $this$decodeStructure$iv.beginStructure(descriptor$iv);
        int years = 0;
        int months = 0;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        long nanoseconds = 0;
        while (true) {
            int index = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
            switch (index) {
                case -1:
                    DateTimePeriod DateTimePeriod = DateTimePeriodKt.DateTimePeriod(years, months, days, hours, minutes, seconds, nanoseconds);
                    composite$iv.endStructure(descriptor$iv);
                    return DateTimePeriod;
                case 0:
                    years = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 0);
                    $this$decodeStructure$iv = $this$decodeStructure$iv;
                    break;
                case 1:
                    months = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 1);
                    $this$decodeStructure$iv = $this$decodeStructure$iv;
                    break;
                case 2:
                    days = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 2);
                    $this$decodeStructure$iv = $this$decodeStructure$iv;
                    break;
                case 3:
                    hours = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 3);
                    $this$decodeStructure$iv = $this$decodeStructure$iv;
                    break;
                case 4:
                    minutes = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 4);
                    $this$decodeStructure$iv = $this$decodeStructure$iv;
                    break;
                case 5:
                    seconds = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 5);
                    $this$decodeStructure$iv = $this$decodeStructure$iv;
                    break;
                case 6:
                    nanoseconds = composite$iv.decodeLongElement(INSTANCE.getDescriptor(), 6);
                    $this$decodeStructure$iv = $this$decodeStructure$iv;
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + index);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DateTimePeriod value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        if (value.getYears() != 0) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 0, value.getYears());
        }
        if (value.getMonths() != 0) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 1, value.getMonths());
        }
        if (value.getDays() != 0) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 2, value.getDays());
        }
        if (value.getHours() != 0) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 3, value.getHours());
        }
        if (value.getMinutes() != 0) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 4, value.getMinutes());
        }
        if (value.getSeconds() != 0) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 5, value.getSeconds());
        }
        if (value.getNanoseconds() != 0) {
            composite$iv.encodeLongElement(INSTANCE.getDescriptor(), 6, value.getNanoseconds());
        }
        composite$iv.endStructure(descriptor$iv);
    }
}