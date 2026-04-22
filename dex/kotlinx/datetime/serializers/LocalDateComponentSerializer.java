package kotlinx.datetime.serializers;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.ShortSerializer;

/* compiled from: LocalDateSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/serializers/LocalDateComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/LocalDate;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocalDateComponentSerializer implements KSerializer<LocalDate> {
    public static final LocalDateComponentSerializer INSTANCE = new LocalDateComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.LocalDate", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.LocalDateComponentSerializer$descriptor$1
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
        }
    });

    private LocalDateComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalDate deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        Integer year = null;
        Short month = null;
        Short day = null;
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
                    LocalDate localDate = new LocalDate(year.intValue(), month.shortValue(), day.shortValue());
                    composite$iv.endStructure(descriptor$iv);
                    return localDate;
                case 0:
                    year = Integer.valueOf(composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 0));
                    break;
                case 1:
                    month = Short.valueOf(composite$iv.decodeShortElement(INSTANCE.getDescriptor(), 1));
                    break;
                case 2:
                    day = Short.valueOf(composite$iv.decodeShortElement(INSTANCE.getDescriptor(), 2));
                    break;
                default:
                    DateTimeUnitSerializersKt.throwUnknownIndexException(index);
                    throw new KotlinNothingValueException();
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalDate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 0, value.getYear());
        composite$iv.encodeShortElement(INSTANCE.getDescriptor(), 1, (short) value.getMonthNumber());
        composite$iv.encodeShortElement(INSTANCE.getDescriptor(), 2, (short) value.getDayOfMonth());
        composite$iv.endStructure(descriptor$iv);
    }
}