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

/* compiled from: XmlBoolean.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lnl/adaptivity/xmlutil/util/XmlOnlyBooleanSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializer;", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serializeXML", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "isValueChild", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Boolean;", "deserializeXML", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "(Lkotlinx/serialization/encoding/Decoder;Lnl/adaptivity/xmlutil/XmlReader;Ljava/lang/Boolean;Z)Ljava/lang/Boolean;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XmlOnlyBooleanSerializer implements XmlSerializer<Boolean> {
    public static final XmlOnlyBooleanSerializer INSTANCE = new XmlOnlyBooleanSerializer();
    private static final SerialDescriptor descriptor = XmlSerializerKt.xml$default(SerialDescriptorsKt.PrimitiveSerialDescriptor("xmlOnlyBoolean", PrimitiveKind.BOOLEAN.INSTANCE), SerialDescriptorsKt.PrimitiveSerialDescriptor("xmlBoolean", PrimitiveKind.STRING.INSTANCE), null, 2, null);

    private XmlOnlyBooleanSerializer() {
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object value) {
        serialize(encoder, ((Boolean) value).booleanValue());
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializationStrategy
    public /* bridge */ /* synthetic */ void serializeXML(Encoder encoder, XmlWriter output, Object value, boolean isValueChild) {
        serializeXML(encoder, output, ((Boolean) value).booleanValue(), isValueChild);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, boolean value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeBoolean(value);
    }

    public void serializeXML(Encoder encoder, XmlWriter output, boolean value, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        if (!value) {
            encoder.encodeString("false");
        } else {
            encoder.encodeString("true");
        }
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Boolean deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return Boolean.valueOf(decoder.decodeBoolean());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r0.equals("1") != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r0.equals("0") != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        return java.lang.Boolean.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r0.equals("false") != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r0.equals("true") != false) goto L11;
     */
    @Override // nl.adaptivity.xmlutil.XmlDeserializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean deserializeXML(Decoder decoder, XmlReader input, Boolean previousValue, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(input, "input");
        String s = decoder.decodeString();
        switch (s.hashCode()) {
            case 48:
                break;
            case 49:
                break;
            case 3569038:
                break;
            case 97196323:
                break;
        }
        throw new NumberFormatException("Invalid boolean value: " + s);
    }
}