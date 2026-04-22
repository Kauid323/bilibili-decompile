package nl.adaptivity.xmlutil.dom2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
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

/* compiled from: ElementSerializer.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/ElementSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializer;", "Lnl/adaptivity/xmlutil/dom2/Element;", "<init>", "()V", "attrSerializer", "Lkotlinx/serialization/KSerializer;", "", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserializeXML", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "isValueChild", "", "Lnl/adaptivity/xmlutil/dom2/Document2Decoder;", "serializeXML", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "serialize", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ElementSerializer implements XmlSerializer<Element> {
    public static final ElementSerializer INSTANCE = new ElementSerializer();
    private static final KSerializer<Map<String, String>> attrSerializer = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("element", new SerialDescriptor[0], new Function1() { // from class: nl.adaptivity.xmlutil.dom2.ElementSerializer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = ElementSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    });

    private ElementSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "namespace", StringSerializer.INSTANCE.getDescriptor(), null, true, 4, null);
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "localname", StringSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "attributes", attrSerializer.getDescriptor(), null, true, 4, null);
        ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "content", BuiltinSerializersKt.ListSerializer(NodeSerializer.INSTANCE).getDescriptor(), null, true, 4, null);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Element deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder instanceof Document2Decoder ? deserialize((Document2Decoder) decoder) : deserialize(new Document2Decoder(decoder));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r0 == null) goto L21;
     */
    @Override // nl.adaptivity.xmlutil.XmlDeserializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Element deserializeXML(Decoder decoder, XmlReader input, Element previousValue, boolean isValueChild) {
        Document document;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(input, "input");
        if (!(input.getEventType() == EventType.START_ELEMENT)) {
            throw new IllegalArgumentException((input.getEventType() + " can not be deserialized as XML element").toString());
        }
        if (previousValue != null) {
            Element $this$ownerDocument$iv = previousValue;
            document = $this$ownerDocument$iv.getOwnerDocument();
        }
        document = CreateDocumentKt.createDocument(input.getName());
        Node fragment = document.createDocumentFragment();
        DomWriter out = new DomWriter(fragment, false, (XmlDeclMode) null, 6, (DefaultConstructorMarker) null);
        XmlWriterUtil.writeElement(out, null, input);
        Node $this$firstChild$iv = fragment;
        Node e = $this$firstChild$iv.getFirstChild();
        while (e != null) {
            Node $this$nodeType$iv = e;
            if ($this$nodeType$iv.getNodeType() == 1) {
                break;
            }
            Node $this$nextSibling$iv = e;
            e = $this$nextSibling$iv.getNextSibling();
        }
        Element element = (Element) e;
        if (element != null) {
            return element;
        }
        throw new SerializationException("Expected element, but did not find it");
    }

    private final Element deserialize(Document2Decoder decoder) {
        Document2Decoder $this$decodeStructure$iv = decoder;
        SerialDescriptor descriptor$iv = getDescriptor();
        boolean z = false;
        CompositeDecoder composite$iv = $this$decodeStructure$iv.beginStructure(descriptor$iv);
        KSerializer contentSerializer = BuiltinSerializersKt.ListSerializer(NodeSerializer.INSTANCE);
        int idx = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
        String nameSpace = null;
        String localName = null;
        Object attributes = null;
        Object content = null;
        while (true) {
            boolean z2 = true;
            if (idx != -1) {
                switch (idx) {
                    case -3:
                        throw new SerializationException("Found unexpected child at index: " + idx);
                    case -2:
                    case -1:
                    default:
                        throw new IllegalStateException("Received an unexpected decoder value: " + idx);
                    case 0:
                        nameSpace = composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 0);
                        break;
                    case 1:
                        localName = composite$iv.decodeStringElement(INSTANCE.getDescriptor(), 1);
                        break;
                    case 2:
                        attributes = attrSerializer.deserialize(decoder);
                        break;
                    case 3:
                        content = contentSerializer.deserialize(decoder);
                        break;
                }
                idx = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
            } else if (localName != null) {
                if (attributes == null) {
                    attributes = MapsKt.emptyMap();
                }
                if (content == null) {
                    content = CollectionsKt.emptyList();
                }
                Document doc = decoder.getDocument();
                String str = nameSpace;
                if (str != null && str.length() != 0) {
                    z2 = false;
                }
                Element createElement = z2 ? doc.createElement(localName) : doc.createElementNS(nameSpace, localName);
                Element $this$deserialize_u24lambda_u243_u24lambda_u242 = createElement;
                for (Map.Entry entry : ((Map) attributes).entrySet()) {
                    Decoder $this$decodeStructure$iv2 = $this$decodeStructure$iv;
                    String name = (String) entry.getKey();
                    boolean z3 = z;
                    String value = (String) entry.getValue();
                    $this$deserialize_u24lambda_u243_u24lambda_u242.setAttribute(name, value);
                    z = z3;
                    $this$decodeStructure$iv = $this$decodeStructure$iv2;
                }
                for (Iterator it = ((List) content).iterator(); it.hasNext(); it = it) {
                    Node node = (Node) it.next();
                    $this$deserialize_u24lambda_u243_u24lambda_u242.appendChild(doc.adoptNode(node));
                }
                Element element = createElement;
                composite$iv.endStructure(descriptor$iv);
                return element;
            } else {
                throw new SerializationException("Missing localName");
            }
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializationStrategy
    public void serializeXML(Encoder encoder, XmlWriter output, Element value, boolean isValueChild) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(value, "value");
        ElementSerializerKt.writeElem(output, value);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Element value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        Encoder $this$encodeStructure$iv = encoder;
        CompositeEncoder composite$iv = $this$encodeStructure$iv.beginStructure(descriptor$iv);
        String namespaceURI = value.getNamespaceURI();
        String str = namespaceURI;
        if (!(str == null || str.length() == 0)) {
            composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 0, namespaceURI);
        }
        composite$iv.encodeStringElement(INSTANCE.getDescriptor(), 1, value.getLocalName());
        if (value.getAttributes().getLength() > 0) {
            Iterator attrIterator = value.getAttributes().iterator();
            Sequence $this$associate$iv = SequencesKt.asSequence(attrIterator);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object element$iv$iv : $this$associate$iv) {
                Attr it = (Attr) element$iv$iv;
                Attr $this$nodeName$iv = it;
                Pair pair = TuplesKt.to($this$nodeName$iv.getNodeName(), it.getValue());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                $this$encodeStructure$iv = $this$encodeStructure$iv;
            }
            composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 2, attrSerializer, linkedHashMap);
        }
        Element $this$childNodes$iv = value;
        if ($this$childNodes$iv.getChildNodes().getLength() > 0) {
            Element $this$childNodes$iv2 = value;
            List n = SequencesKt.toList(SequencesKt.asSequence($this$childNodes$iv2.getChildNodes().iterator()));
            composite$iv.encodeSerializableElement(INSTANCE.getDescriptor(), 3, BuiltinSerializersKt.ListSerializer(NodeSerializer.INSTANCE), n);
        }
        composite$iv.endStructure(descriptor$iv);
    }
}