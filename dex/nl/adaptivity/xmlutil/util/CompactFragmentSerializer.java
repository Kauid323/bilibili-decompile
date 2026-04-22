package nl.adaptivity.xmlutil.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlReaderUtil;
import nl.adaptivity.xmlutil.XmlSerializer;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.dom2.NodeSerializer$$ExternalSyntheticThrowNSME0;

/* compiled from: CompactFragmentSerializer.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0017H\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J-\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b!J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u001d\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020 H\u0000¢\u0006\u0002\b$J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020 H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006'"}, d2 = {"Lnl/adaptivity/xmlutil/util/CompactFragmentSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializer;", "Lnl/adaptivity/xmlutil/util/CompactFragment;", "<init>", "()V", "namespacesSerializer", "Lkotlinx/serialization/KSerializer;", "", "Lnl/adaptivity/xmlutil/Namespace;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserializeXML", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "isValueChild", "", "deserialize", "readCompactFragmentContent", "Lkotlinx/serialization/encoding/CompositeDecoder;", "serializeXML", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "serializeXMLImpl", "Lnl/adaptivity/xmlutil/util/ICompactFragment;", "serializeXMLImpl$core", "serialize", "serializeImpl", "serializeImpl$core", "writeCompactFragmentContent", "writer", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompactFragmentSerializer implements XmlSerializer<CompactFragment> {
    public static final CompactFragmentSerializer INSTANCE = new CompactFragmentSerializer();
    private static final KSerializer<List<Namespace>> namespacesSerializer = BuiltinSerializersKt.ListSerializer(Namespace.Companion);
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("nl.adaptivity.xmlutil.util.compactFragment", new SerialDescriptor[0], new Function1() { // from class: nl.adaptivity.xmlutil.util.CompactFragmentSerializer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = CompactFragmentSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    });

    private CompactFragmentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "namespaces", namespacesSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "content", StringSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.XmlDeserializationStrategy
    public CompactFragment deserializeXML(Decoder decoder, XmlReader input, CompactFragment previousValue, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(input, "input");
        if (isValueChild) {
            return XmlReaderUtil.siblingsToFragment(input);
        }
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        input.next();
        CompactFragment siblingsToFragment = XmlReaderUtil.siblingsToFragment(input);
        composite$iv.endStructure(descriptor$iv);
        return siblingsToFragment;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CompactFragment deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        CompactFragment readCompactFragmentContent = INSTANCE.readCompactFragmentContent(composite$iv);
        composite$iv.endStructure(descriptor$iv);
        return readCompactFragmentContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CompactFragment readCompactFragmentContent(CompositeDecoder input) {
        List namespaces = new ArrayList();
        String content = "";
        int index = input.decodeElementIndex(getDescriptor());
        while (index >= 0) {
            switch (index) {
                case 0:
                    getDescriptor();
                    KSerializer<List<Namespace>> kSerializer = namespacesSerializer;
                    NodeSerializer$$ExternalSyntheticThrowNSME0.m();
                    namespaces = null;
                    break;
                case 1:
                    content = input.decodeStringElement(getDescriptor(), index);
                    break;
            }
            index = input.decodeElementIndex(getDescriptor());
        }
        return new CompactFragment(namespaces, content);
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializationStrategy
    public void serializeXML(Encoder encoder, XmlWriter output, CompactFragment value, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(value, "value");
        serializeXMLImpl$core(encoder, output, value, isValueChild);
    }

    public final void serializeXMLImpl$core(Encoder encoder, XmlWriter output, ICompactFragment value, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!isValueChild) {
            SerialDescriptor descriptor$iv = getDescriptor();
            CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
            INSTANCE.writeCompactFragmentContent(output, value);
            composite$iv.endStructure(descriptor$iv);
            return;
        }
        writeCompactFragmentContent(output, value);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CompactFragment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        serializeImpl$core(encoder, value);
    }

    public final void serializeImpl$core(Encoder encoder, ICompactFragment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 0, namespacesSerializer, CollectionsKt.toList(value.getNamespaces()));
        composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 1, value.getContentString());
        composite$iv.endStructure(descriptor$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeCompactFragmentContent(XmlWriter writer, ICompactFragment value) {
        for (Namespace namespace : value.getNamespaces()) {
            if (writer.getPrefix(namespace.getNamespaceURI()) == null) {
                writer.namespaceAttr(namespace);
            }
        }
        value.serialize(writer);
    }
}