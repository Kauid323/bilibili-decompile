package kotlinx.datetime.serializers;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
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

/* compiled from: DateTimeUnitSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/serializers/MonthBasedDateTimeUnitSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimeUnit$MonthBased;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MonthBasedDateTimeUnitSerializer implements KSerializer<DateTimeUnit.MonthBased> {
    public static final MonthBasedDateTimeUnitSerializer INSTANCE = new MonthBasedDateTimeUnitSerializer();
    private static final Lazy descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>() { // from class: kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer$descriptor$2
        @Override // kotlin.jvm.functions.Function0
        public final SerialDescriptor invoke() {
            return SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.MonthBased", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer$descriptor$2.1
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
                    buildClassSerialDescriptor.element("months", descriptor$iv, annotations$iv, false);
                }
            });
        }
    });

    private MonthBasedDateTimeUnitSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DateTimeUnit.MonthBased value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 0, value.getMonths());
        composite$iv.endStructure(descriptor$iv);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DateTimeUnit.MonthBased deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        boolean seen = false;
        int months = 0;
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        if (composite$iv.decodeSequentially()) {
            months = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 0);
            seen = true;
        } else {
            while (true) {
                int elementIndex = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
                switch (elementIndex) {
                    case -1:
                        break;
                    case 0:
                        months = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 0);
                        seen = true;
                    default:
                        DateTimeUnitSerializersKt.throwUnknownIndexException(elementIndex);
                        throw new KotlinNothingValueException();
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        composite$iv.endStructure(descriptor$iv);
        if (!seen) {
            throw new MissingFieldException("months", getDescriptor().getSerialName());
        }
        return new DateTimeUnit.MonthBased(months);
    }
}