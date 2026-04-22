package kotlinx.datetime.serializers;

import j$.time.Month;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: MonthSerializers.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003H\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/datetime/serializers/MonthSerializer;", "Lkotlinx/serialization/KSerializer;", "j$/time/Month", "Lkotlinx/datetime/Month;", "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lj$/time/Month;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lj$/time/Month;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MonthSerializer implements KSerializer<Month> {
    public static final MonthSerializer INSTANCE = new MonthSerializer();
    private final /* synthetic */ KSerializer<Month> $$delegate_0 = MonthSerializersKt.createEnumSerializer("kotlinx.datetime.Month", Month.values());

    @Override // kotlinx.serialization.DeserializationStrategy
    public Month deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return this.$$delegate_0.deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Month value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.$$delegate_0.serialize(encoder, value);
    }

    private MonthSerializer() {
    }
}