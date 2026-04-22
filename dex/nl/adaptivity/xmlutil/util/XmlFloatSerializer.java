package nl.adaptivity.xmlutil.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: XmlFloat.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lnl/adaptivity/xmlutil/util/XmlFloatSerializer;", "Lkotlinx/serialization/KSerializer;", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Float;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XmlFloatSerializer implements KSerializer<Float> {
    public static final XmlFloatSerializer INSTANCE = new XmlFloatSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("xmlFloat", PrimitiveKind.STRING.INSTANCE);

    private XmlFloatSerializer() {
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
        serialize(encoder, ((Number) value).floatValue());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, float value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        if (!Float.isNaN(value)) {
            if (value <= Float.MAX_VALUE) {
                if (value >= Float.MIN_VALUE) {
                    encoder.encodeString(String.valueOf(value));
                    return;
                } else {
                    encoder.encodeString("INF");
                    return;
                }
            }
            encoder.encodeString("INF");
            return;
        }
        encoder.encodeString("NaN");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // kotlinx.serialization.DeserializationStrategy
    public Float deserialize(Decoder decoder) {
        float parseFloat;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String s = decoder.decodeString();
        switch (s.hashCode()) {
            case 72641:
                if (s.equals("INF")) {
                    parseFloat = Float.POSITIVE_INFINITY;
                    break;
                }
                parseFloat = Float.parseFloat(s);
                break;
            case 78043:
                if (s.equals("NaN")) {
                    parseFloat = Float.NaN;
                    break;
                }
                parseFloat = Float.parseFloat(s);
                break;
            case 1413236:
                if (s.equals("-INF")) {
                    parseFloat = Float.NEGATIVE_INFINITY;
                    break;
                }
                parseFloat = Float.parseFloat(s);
                break;
            default:
                parseFloat = Float.parseFloat(s);
                break;
        }
        return Float.valueOf(parseFloat);
    }
}