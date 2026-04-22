package nl.adaptivity.xmlutil;

import java.util.NoSuchElementException;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: QName.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u0014J1\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lnl/adaptivity/xmlutil/QNameSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializer;", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserializeXML", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "isValueChild", "", "(Lkotlinx/serialization/encoding/Decoder;Lnl/adaptivity/xmlutil/XmlReader;Ljavax/xml/namespace/QName;Z)Ljavax/xml/namespace/QName;", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljavax/xml/namespace/QName;", "serializeXML", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "(Lkotlinx/serialization/encoding/Encoder;Lnl/adaptivity/xmlutil/XmlWriter;Ljavax/xml/namespace/QName;Z)V", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljavax/xml/namespace/QName;)V", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QNameSerializer implements XmlSerializer<QName> {
    public static final QNameSerializer INSTANCE = new QNameSerializer();
    private static final SerialDescriptor descriptor = XmlSerializerKt.xml(SerialDescriptorsKt.buildClassSerialDescriptor("javax.xml.namespace.QName", new SerialDescriptor[0], new Function1() { // from class: nl.adaptivity.xmlutil.QNameSerializer$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = QNameSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    }), SerialDescriptorsKt.PrimitiveSerialDescriptor("javax.xml.namespace.QName", PrimitiveKind.STRING.INSTANCE), new QName(XMLConstants.XSD_NS_URI, "QName", XMLConstants.XSD_PREFIX));

    private QNameSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        KSerializer stringSerializer = BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE);
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "namespace", stringSerializer.getDescriptor(), null, true, 4, null);
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "localPart", stringSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "prefix", stringSerializer.getDescriptor(), null, true, 4, null);
        return Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.XmlDeserializationStrategy
    public QName deserializeXML(Decoder decoder, XmlReader input, QName previousValue, boolean isValueChild) {
        String prefix;
        String localPart;
        String namespace;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(input, "input");
        IterableNamespaceContext namespaceContext = input.getNamespaceContext().freeze();
        String prefixedName = StringsKt.trim((CharSequence) decoder.decodeString()).toString();
        int cIndex = StringsKt.indexOf$default((CharSequence) prefixedName, (char) AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
        if (cIndex < 0) {
            prefix = "";
            localPart = prefixedName;
            String namespaceURI = namespaceContext.getNamespaceURI("");
            namespace = namespaceURI != null ? namespaceURI : "";
        } else {
            String substring = prefixedName.substring(0, cIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            prefix = substring;
            String substring2 = prefixedName.substring(cIndex + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            localPart = substring2;
            String namespaceURI2 = namespaceContext.getNamespaceURI(prefix);
            if (namespaceURI2 == null) {
                throw new SerializationException("Missing namespace for prefix " + prefix + " in QName value");
            }
            namespace = namespaceURI2;
        }
        return new QName(namespace, localPart, prefix);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public QName deserialize(Decoder decoder) {
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        String prefix = "";
        String namespace = "";
        String localPart = null;
        while (true) {
            switch (composite$iv.decodeElementIndex(INSTANCE.getDescriptor())) {
                case -1:
                    if (localPart == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("localPart");
                        str = null;
                    } else {
                        str = localPart;
                    }
                    QName qName = new QName(namespace, str, prefix);
                    composite$iv.endStructure(descriptor$iv);
                    return qName;
                case 0:
                    namespace = composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 0);
                    break;
                case 1:
                    localPart = composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 1);
                    break;
                case 2:
                    prefix = composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 2);
                    break;
            }
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializationStrategy
    public void serializeXML(Encoder encoder, XmlWriter output, QName value, boolean isValueChild) {
        String it;
        String str;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(value, "value");
        String effectivePrefix = Intrinsics.areEqual(value.getNamespaceURI(), output.getNamespaceUri(value.getPrefix())) ? value.getPrefix() : output.getPrefix(value.getNamespaceURI());
        if (effectivePrefix == null) {
            if (!(value.getPrefix().length() > 0) || output.getNamespaceUri(value.getPrefix()) != null) {
                Sequence $this$first$iv = SequencesKt.map(CollectionsKt.asSequence(new IntRange(1, Integer.MAX_VALUE)), new Function1() { // from class: nl.adaptivity.xmlutil.QNameSerializer$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        String serializeXML$lambda$2;
                        serializeXML$lambda$2 = QNameSerializer.serializeXML$lambda$2(((Integer) obj).intValue());
                        return serializeXML$lambda$2;
                    }
                });
                for (Object element$iv : $this$first$iv) {
                    String it2 = (String) element$iv;
                    if (output.getNamespaceUri(it2) == null) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        str = (String) element$iv;
                    }
                }
                throw new NoSuchElementException("Sequence contains no element matching the predicate.");
            }
            str = value.getPrefix();
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            effectivePrefix = str;
            output.namespaceAttr(effectivePrefix, value.getNamespaceURI());
        }
        encoder.encodeString(effectivePrefix + AbstractJsonLexerKt.COLON + value.getLocalPart());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String serializeXML$lambda$2(int it) {
        return "ns" + it;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, QName value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        String ns = value.getNamespaceURI();
        if ((ns.length() > 0) || composite$iv.shouldEncodeElementDefault(INSTANCE.getDescriptor(), 0)) {
            composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 0, ns);
        }
        composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 1, value.getLocalPart());
        String prefix = value.getPrefix();
        if ((prefix.length() > 0) || composite$iv.shouldEncodeElementDefault(INSTANCE.getDescriptor(), 2)) {
            composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 2, prefix);
        }
        composite$iv.endStructure(descriptor$iv);
    }
}