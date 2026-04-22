package kotlinx.datetime.serializers;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
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
import kotlinx.serialization.internal.LongSerializer;

/* compiled from: InstantSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/serializers/InstantComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/Instant;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InstantComponentSerializer implements KSerializer<Instant> {
    public static final InstantComponentSerializer INSTANCE = new InstantComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.Instant", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.InstantComponentSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            List annotations$iv = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv = LongSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("epochSeconds", descriptor$iv, annotations$iv, false);
            List annotations$iv2 = CollectionsKt.emptyList();
            SerialDescriptor descriptor$iv2 = LongSerializer.INSTANCE.getDescriptor();
            buildClassSerialDescriptor.element("nanosecondsOfSecond", descriptor$iv2, annotations$iv2, true);
        }
    });

    private InstantComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Instant deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        Long epochSeconds = null;
        int nanosecondsOfSecond = 0;
        while (true) {
            int index = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
            switch (index) {
                case -1:
                    if (epochSeconds == null) {
                        throw new MissingFieldException("epochSeconds", INSTANCE.getDescriptor().getSerialName());
                    }
                    Instant fromEpochSeconds = Instant.Companion.fromEpochSeconds(epochSeconds.longValue(), nanosecondsOfSecond);
                    composite$iv.endStructure(descriptor$iv);
                    return fromEpochSeconds;
                case 0:
                    epochSeconds = Long.valueOf(composite$iv.decodeLongElement(INSTANCE.getDescriptor(), 0));
                    break;
                case 1:
                    nanosecondsOfSecond = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 1);
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + index);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Instant value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeLongElement(INSTANCE.getDescriptor(), 0, value.getEpochSeconds());
        if (value.getNanosecondsOfSecond() != 0) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 1, value.getNanosecondsOfSecond());
        }
        composite$iv.endStructure(descriptor$iv);
    }
}