package nl.adaptivity.xmlutil.dom2;

import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;
import nl.adaptivity.xmlutil.DomWriter;
import nl.adaptivity.xmlutil.EventType;
import nl.adaptivity.xmlutil.XmlDeclMode;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlSerializer;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.XmlWriterUtil;
import nl.adaptivity.xmlutil.util.impl.CreateDocumentKt;

/* compiled from: NodeSerializer.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J*\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0002H\u0016R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\nX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lnl/adaptivity/xmlutil/dom2/NodeSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializer;", "Lnl/adaptivity/xmlutil/dom2/Node;", "<init>", "()V", "attrSerializer", "Lkotlinx/serialization/KSerializer;", "", "", "elemDescr", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElemDescr$annotations", "descriptor", "getDescriptor$annotations", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserializeXML", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "isValueChild", "", "Lnl/adaptivity/xmlutil/dom2/Document2Decoder;", "serializeXML", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "serialize", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NodeSerializer implements XmlSerializer<Node> {
    public static final NodeSerializer INSTANCE = new NodeSerializer();
    private static final KSerializer<Map<String, String>> attrSerializer = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
    private static final SerialDescriptor elemDescr = SerialDescriptorsKt.buildSerialDescriptor("org.w3c.dom.Node", SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new Function1() { // from class: nl.adaptivity.xmlutil.dom2.NodeSerializer$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit elemDescr$lambda$1;
            elemDescr$lambda$1 = NodeSerializer.elemDescr$lambda$1((ClassSerialDescriptorBuilder) obj);
            return elemDescr$lambda$1;
        }
    });
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildSerialDescriptor("node", PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1() { // from class: nl.adaptivity.xmlutil.dom2.NodeSerializer$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$2;
            descriptor$lambda$2 = NodeSerializer.descriptor$lambda$2((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$2;
        }
    });

    /* compiled from: NodeSerializer.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    private static /* synthetic */ void getElemDescr$annotations() {
    }

    private NodeSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit elemDescr$lambda$1(ClassSerialDescriptorBuilder buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "text", StringSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "element", SerialDescriptorsKt.buildSerialDescriptor("element", SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new Function1() { // from class: nl.adaptivity.xmlutil.dom2.NodeSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit elemDescr$lambda$1$lambda$0;
                elemDescr$lambda$1$lambda$0 = NodeSerializer.elemDescr$lambda$1$lambda$0((ClassSerialDescriptorBuilder) obj);
                return elemDescr$lambda$1$lambda$0;
            }
        }), null, false, 12, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit elemDescr$lambda$1$lambda$0(ClassSerialDescriptorBuilder buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$2(ClassSerialDescriptorBuilder buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "type", StringSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "value", elemDescr, null, false, 12, null);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Node deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder instanceof Document2Decoder ? deserialize((Document2Decoder) decoder) : deserialize(new Document2Decoder(decoder));
    }

    @Override // nl.adaptivity.xmlutil.XmlDeserializationStrategy
    public Node deserializeXML(Decoder decoder, XmlReader input, Node previousValue, boolean isValueChild) {
        Document document;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(input, "input");
        if (previousValue == null || (document = previousValue.getOwnerDocument()) == null) {
            document = CreateDocumentKt.createDocument(new QName("DummyDoc"));
        }
        Node fragment = document.createDocumentFragment();
        DomWriter out = new DomWriter(fragment, false, (XmlDeclMode) null, 6, (DefaultConstructorMarker) null);
        if (WhenMappings.$EnumSwitchMapping$0[input.getEventType().ordinal()] == 1) {
            XmlWriterUtil.writeElement(out, null, input);
        } else {
            XmlWriterUtil.writeCurrentEvent(out, input);
        }
        Node $this$childNodes$iv = fragment;
        switch ($this$childNodes$iv.getChildNodes().getLength()) {
            case 0:
                throw new SerializationException("Expected node, but did not find it");
            case 1:
                Node $this$firstChild$iv = fragment.getFirstChild();
                Intrinsics.checkNotNull($this$firstChild$iv);
                return $this$firstChild$iv;
            default:
                return fragment;
        }
    }

    /* JADX WARN: Type inference failed for: r10v6, types: [T, nl.adaptivity.xmlutil.dom2.Attr] */
    /* JADX WARN: Type inference failed for: r9v22, types: [T, nl.adaptivity.xmlutil.dom2.Text] */
    /* JADX WARN: Type inference failed for: r9v27, types: [nl.adaptivity.xmlutil.dom2.Comment, T] */
    private final Node deserialize(Document2Decoder decoder) {
        Ref.ObjectRef result = new Ref.ObjectRef();
        Document2Decoder $this$decodeStructure$iv = decoder;
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = $this$decodeStructure$iv.beginStructure(descriptor$iv);
        String type = null;
        for (int nextValue = composite$iv.decodeElementIndex(INSTANCE.getDescriptor()); nextValue != -1; nextValue = composite$iv.decodeElementIndex(INSTANCE.getDescriptor())) {
            switch (nextValue) {
                case 0:
                    type = composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 0);
                    break;
                case 1:
                    if (type != null) {
                        switch (type.hashCode()) {
                            case -1662836996:
                                if (type.equals("element")) {
                                    INSTANCE.getDescriptor();
                                    ElementSerializer elementSerializer = ElementSerializer.INSTANCE;
                                    NodeSerializer$$ExternalSyntheticThrowNSME0.m();
                                    result.element = null;
                                    continue;
                                } else {
                                    throw new SerializationException("unsupported type: " + type);
                                }
                            case 3004913:
                                if (type.equals("attr")) {
                                    INSTANCE.getDescriptor();
                                    KSerializer kSerializer = attrSerializer;
                                    NodeSerializer$$ExternalSyntheticThrowNSME0.m();
                                    Map map = null;
                                    if (map.size() == 1) {
                                        ?? createAttribute = decoder.getDocument().createAttribute((String) CollectionsKt.single(map.keySet()));
                                        createAttribute.setValue((String) CollectionsKt.single(map.values()));
                                        result.element = createAttribute;
                                        continue;
                                    } else {
                                        throw new SerializationException("Only a single attribute pair expected");
                                    }
                                } else {
                                    throw new SerializationException("unsupported type: " + type);
                                }
                            case 3556653:
                                if (type.equals("text")) {
                                    result.element = decoder.getDocument().createTextNode(composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 1));
                                    continue;
                                } else {
                                    throw new SerializationException("unsupported type: " + type);
                                }
                            case 950398559:
                                if (type.equals("comment")) {
                                    result.element = decoder.getDocument().createComment(composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 1));
                                    continue;
                                } else {
                                    throw new SerializationException("unsupported type: " + type);
                                }
                            default:
                                throw new SerializationException("unsupported type: " + type);
                        }
                    } else {
                        throw new SerializationException("Missing type");
                    }
            }
        }
        Unit unit = Unit.INSTANCE;
        composite$iv.endStructure(descriptor$iv);
        Node node = (Node) result.element;
        if (node != null) {
            return node;
        }
        throw new SerializationException("Missing value");
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializationStrategy
    public void serializeXML(Encoder encoder, XmlWriter output, Node value, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(value, "value");
        ElementSerializerKt.writeTo(value, output);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Node value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        short nodeType = value.getNodeType();
        if (nodeType == 9 || nodeType == 11) {
            String type = value.getNodeType() == 11 ? "fragment" : "document";
            composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 0, type);
            List children = SequencesKt.toList(SequencesKt.asSequence(value.getChildNodes().iterator()));
            composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 1, BuiltinSerializersKt.ListSerializer(INSTANCE), children);
        } else if (nodeType != 1) {
            if (nodeType != 2) {
                if (nodeType != 3 && nodeType != 4) {
                    if (nodeType != 8) {
                        if (nodeType != 7) {
                            throw new SerializationException("Cannot serialize: " + value);
                        }
                        throw new SerializationException("Processing instructions can not be serialized");
                    }
                    composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 0, "comment");
                    SerialDescriptor descriptor2 = INSTANCE.getDescriptor();
                    String textContent = value.getTextContent();
                    composite$iv.encodeStringElement(descriptor2, 1, textContent != null ? textContent : "");
                } else {
                    composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 0, "text");
                    SerialDescriptor descriptor3 = INSTANCE.getDescriptor();
                    String textContent2 = value.getTextContent();
                    composite$iv.encodeStringElement(descriptor3, 1, textContent2 != null ? textContent2 : "");
                }
            } else {
                composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 0, "attr");
                composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 1, attrSerializer, MapsKt.mapOf(TuplesKt.to(((Attr) value).getName(), ((Attr) value).getValue())));
            }
        } else {
            composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 0, "element");
            composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 1, ElementSerializer.INSTANCE, (Element) value);
        }
        composite$iv.endStructure(descriptor$iv);
    }
}