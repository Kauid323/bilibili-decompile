package nl.adaptivity.xmlutil.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlSerializer;
import nl.adaptivity.xmlutil.XmlSerializerKt;
import nl.adaptivity.xmlutil.XmlWriter;

/* compiled from: XmlDouble.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J/\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lnl/adaptivity/xmlutil/util/XmlOnlyDoubleSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializer;", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serializeXML", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "isValueChild", "", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Double;", "deserializeXML", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "(Lkotlinx/serialization/encoding/Decoder;Lnl/adaptivity/xmlutil/XmlReader;Ljava/lang/Double;Z)Ljava/lang/Double;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XmlOnlyDoubleSerializer implements XmlSerializer<Double> {
    public static final XmlOnlyDoubleSerializer INSTANCE = new XmlOnlyDoubleSerializer();
    private static final SerialDescriptor descriptor = XmlSerializerKt.xml$default(SerialDescriptorsKt.PrimitiveSerialDescriptor("xmlOnlyDouble", PrimitiveKind.DOUBLE.INSTANCE), SerialDescriptorsKt.PrimitiveSerialDescriptor("xmlDouble", PrimitiveKind.STRING.INSTANCE), null, 2, null);

    private XmlOnlyDoubleSerializer() {
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
        serialize(encoder, ((Number) value).doubleValue());
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializationStrategy
    public /* bridge */ /* synthetic */ void serializeXML(Encoder encoder, XmlWriter output, Object value, boolean isValueChild) {
        serializeXML(encoder, output, ((Number) value).doubleValue(), isValueChild);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, double value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeDouble(value);
    }

    public void serializeXML(Encoder encoder, XmlWriter output, double value, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        if (!Double.isNaN(value)) {
            if (value <= Double.MAX_VALUE) {
                if (value >= Double.MIN_VALUE) {
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

    @Override // kotlinx.serialization.DeserializationStrategy
    public Double deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return Double.valueOf(decoder.decodeDouble());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // nl.adaptivity.xmlutil.XmlDeserializationStrategy
    public Double deserializeXML(Decoder decoder, XmlReader input, Double previousValue, boolean isValueChild) {
        double parseDouble;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(input, "input");
        String s = decoder.decodeString();
        switch (s.hashCode()) {
            case 72641:
                if (s.equals("INF")) {
                    parseDouble = Double.POSITIVE_INFINITY;
                    break;
                }
                parseDouble = Double.parseDouble(s);
                break;
            case 78043:
                if (s.equals("NaN")) {
                    parseDouble = Double.NaN;
                    break;
                }
                parseDouble = Double.parseDouble(s);
                break;
            case 1413236:
                if (s.equals("-INF")) {
                    parseDouble = Double.NEGATIVE_INFINITY;
                    break;
                }
                parseDouble = Double.parseDouble(s);
                break;
            default:
                parseDouble = Double.parseDouble(s);
                break;
        }
        return Double.valueOf(parseDouble);
    }
}