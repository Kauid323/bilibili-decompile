package kotlinx.datetime.serializers;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* compiled from: DateTimeUnitSerializers.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0017R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lkotlinx/datetime/serializers/DateTimeUnitSerializer;", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "Lkotlinx/datetime/DateTimeUnit;", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "impl", "Lkotlinx/serialization/SealedClassSerializer;", "getImpl", "()Lkotlinx/serialization/SealedClassSerializer;", "impl$delegate", "Lkotlin/Lazy;", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DateTimeUnitSerializer extends AbstractPolymorphicSerializer<DateTimeUnit> {
    public static final DateTimeUnitSerializer INSTANCE = new DateTimeUnitSerializer();
    private static final Lazy impl$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<SealedClassSerializer<DateTimeUnit>>() { // from class: kotlinx.datetime.serializers.DateTimeUnitSerializer$impl$2
        @Override // kotlin.jvm.functions.Function0
        public final SealedClassSerializer<DateTimeUnit> invoke() {
            return new SealedClassSerializer<>("kotlinx.datetime.DateTimeUnit", Reflection.getOrCreateKotlinClass(DateTimeUnit.class), new KClass[]{Reflection.getOrCreateKotlinClass(DateTimeUnit.DayBased.class), Reflection.getOrCreateKotlinClass(DateTimeUnit.MonthBased.class), Reflection.getOrCreateKotlinClass(DateTimeUnit.TimeBased.class)}, new KSerializer[]{DayBasedDateTimeUnitSerializer.INSTANCE, MonthBasedDateTimeUnitSerializer.INSTANCE, TimeBasedDateTimeUnitSerializer.INSTANCE});
        }
    });

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    private DateTimeUnitSerializer() {
    }

    private final SealedClassSerializer<DateTimeUnit> getImpl() {
        return (SealedClassSerializer) impl$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    @InternalSerializationApi
    public DeserializationStrategy<DateTimeUnit> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String klassName) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return getImpl().findPolymorphicSerializerOrNull(decoder, klassName);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    @InternalSerializationApi
    public SerializationStrategy<DateTimeUnit> findPolymorphicSerializerOrNull(Encoder encoder, DateTimeUnit value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return getImpl().findPolymorphicSerializerOrNull(encoder, (Encoder) value);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass<DateTimeUnit> getBaseClass() {
        return Reflection.getOrCreateKotlinClass(DateTimeUnit.class);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return getImpl().getDescriptor();
    }
}