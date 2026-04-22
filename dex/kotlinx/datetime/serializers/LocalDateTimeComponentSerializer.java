package kotlinx.datetime.serializers;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.ShortSerializer;

/* compiled from: LocalDateTimeSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/serializers/LocalDateTimeComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/LocalDateTime;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocalDateTimeComponentSerializer implements KSerializer<LocalDateTime> {
    public static final LocalDateTimeComponentSerializer INSTANCE = new LocalDateTimeComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.LocalDateTime", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.LocalDateTimeComponentSerializer$descriptor$1
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
            buildClassSerialDescriptor.element("year", descriptor$iv, annotations$iv, false);
            List annotations$iv2 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv2 = ShortSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("month", descriptor$iv2, annotations$iv2, false);
            List annotations$iv3 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv3 = ShortSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("day", descriptor$iv3, annotations$iv3, false);
            List annotations$iv4 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv4 = ShortSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("hour", descriptor$iv4, annotations$iv4, false);
            List annotations$iv5 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv5 = ShortSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("minute", descriptor$iv5, annotations$iv5, false);
            List annotations$iv6 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv6 = ShortSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("second", descriptor$iv6, annotations$iv6, true);
            List annotations$iv7 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv7 = IntSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("nanosecond", descriptor$iv7, annotations$iv7, true);
        }
    });

    private LocalDateTimeComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalDateTime deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        Integer year = null;
        Short month = null;
        Short day = null;
        Short hour = null;
        Short minute = null;
        short second = 0;
        int nanosecond = 0;
        while (true) {
            int index = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
            switch (index) {
                case -1:
                    if (year == null) {
                        throw new MissingFieldException("year", INSTANCE.getDescriptor().getSerialName());
                    }
                    if (month == null) {
                        throw new MissingFieldException("month", INSTANCE.getDescriptor().getSerialName());
                    }
                    if (day == null) {
                        throw new MissingFieldException("day", INSTANCE.getDescriptor().getSerialName());
                    }
                    if (hour == null) {
                        throw new MissingFieldException("hour", INSTANCE.getDescriptor().getSerialName());
                    }
                    if (minute == null) {
                        throw new MissingFieldException("minute", INSTANCE.getDescriptor().getSerialName());
                    }
                    LocalDateTime localDateTime = new LocalDateTime(year.intValue(), month.shortValue(), day.shortValue(), hour.shortValue(), minute.shortValue(), second, nanosecond);
                    composite$iv.endStructure(descriptor$iv);
                    return localDateTime;
                case 0:
                    year = Integer.valueOf(composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 0));
                    break;
                case 1:
                    month = Short.valueOf(composite$iv.decodeShortElement(INSTANCE.getDescriptor(), 1));
                    break;
                case 2:
                    day = Short.valueOf(composite$iv.decodeShortElement(INSTANCE.getDescriptor(), 2));
                    break;
                case 3:
                    hour = Short.valueOf(composite$iv.decodeShortElement(INSTANCE.getDescriptor(), 3));
                    break;
                case 4:
                    minute = Short.valueOf(composite$iv.decodeShortElement(INSTANCE.getDescriptor(), 4));
                    break;
                case 5:
                    second = composite$iv.decodeShortElement(INSTANCE.getDescriptor(), 5);
                    break;
                case 6:
                    nanosecond = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 6);
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + index);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalDateTime value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 0, value.getYear());
        composite$iv.encodeShortElement(INSTANCE.getDescriptor(), 1, (short) value.getMonthNumber());
        composite$iv.encodeShortElement(INSTANCE.getDescriptor(), 2, (short) value.getDayOfMonth());
        composite$iv.encodeShortElement(INSTANCE.getDescriptor(), 3, (short) value.getHour());
        composite$iv.encodeShortElement(INSTANCE.getDescriptor(), 4, (short) value.getMinute());
        if (value.getSecond() != 0 || value.getNanosecond() != 0) {
            composite$iv.encodeShortElement(INSTANCE.getDescriptor(), 5, (short) value.getSecond());
            if (value.getNanosecond() != 0) {
                composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 6, value.getNanosecond());
            }
        }
        composite$iv.endStructure(descriptor$iv);
    }
}