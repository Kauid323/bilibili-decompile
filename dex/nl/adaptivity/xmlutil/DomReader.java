package nl.adaptivity.xmlutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.dom.Document_jvmKt;
import nl.adaptivity.xmlutil.dom2.Attr;
import nl.adaptivity.xmlutil.dom2.CharacterData;
import nl.adaptivity.xmlutil.dom2.Document;
import nl.adaptivity.xmlutil.dom2.Element;
import nl.adaptivity.xmlutil.dom2.NamedNodeMap;
import nl.adaptivity.xmlutil.dom2.Node;
import nl.adaptivity.xmlutil.dom2.NodeType;
import nl.adaptivity.xmlutil.dom2.ProcessingInstruction;
import nl.adaptivity.xmlutil.util.CommondomutilKt;
import nl.adaptivity.xmlutil.util.impl.CreateDocumentKt;

/* compiled from: DomReader.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0004\u0010\bJ\t\u0010N\u001a\u00020\u0015H\u0096\u0002J\t\u0010O\u001a\u00020(H\u0096\u0002J\u0015\u0010\t\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0007¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\u0019H\u0016J\u0010\u0010S\u001a\u00020\r2\u0006\u0010R\u001a\u00020\u0019H\u0016J\u0010\u0010T\u001a\u00020\r2\u0006\u0010R\u001a\u00020\u0019H\u0016J\u0010\u0010U\u001a\u00020\r2\u0006\u0010R\u001a\u00020\u0019H\u0016J\u001c\u0010U\u001a\u0004\u0018\u00010\r2\b\u0010V\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010W\u001a\u00020XH\u0016J\u0012\u0010Y\u001a\u0004\u0018\u00010\r2\u0006\u0010Z\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0019@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000fR\u001a\u0010!\u001a\u00020\r8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000fR\u0014\u0010%\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\r8VX\u0097\u0004¢\u0006\f\u0012\u0004\b6\u0010#\u001a\u0004\b7\u0010\u000fR\u0014\u00108\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\nR\u0014\u0010:\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u0004\u0018\u00010;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020E0,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u00100R\u0016\u0010G\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u000fR\u0016\u0010I\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u000f¨\u0006["}, d2 = {"Lnl/adaptivity/xmlutil/DomReader;", "Lnl/adaptivity/xmlutil/XmlReader;", "delegate", "Lnl/adaptivity/xmlutil/dom2/Node;", "<init>", "(Lnl/adaptivity/xmlutil/dom2/Node;)V", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "(Lorg/w3c/dom/Node;)V", "getDelegate", "()Lnl/adaptivity/xmlutil/dom2/Node;", "current", "namespaceURI", "", "getNamespaceURI", "()Ljava/lang/String;", "localName", "getLocalName", "prefix", "getPrefix", "value", "", "isStarted", "()Z", "atEndOfElement", "", "depth", "getDepth", "()I", "piTarget", "getPiTarget", "piData", "getPiData", "text", "getText$annotations", "()V", "getText", "attributeCount", "getAttributeCount", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "_namespaceAttrs", "", "Lnl/adaptivity/xmlutil/dom2/Attr;", "namespaceAttrs", "getNamespaceAttrs", "()Ljava/util/List;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getExtLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "locationInfo", "getLocationInfo$annotations", "getLocationInfo", "requireCurrent", "getRequireCurrent", "requireCurrentElem", "Lnl/adaptivity/xmlutil/dom2/Element;", "getRequireCurrentElem", "()Lnl/adaptivity/xmlutil/dom2/Element;", "currentElement", "getCurrentElement", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "namespaceDecls", "Lnl/adaptivity/xmlutil/Namespace;", "getNamespaceDecls", "encoding", "getEncoding", "standalone", "getStandalone", "()Ljava/lang/Boolean;", "version", "getVersion", "hasNext", "next", "()Lorg/w3c/dom/Node;", "getAttributeNamespace", "index", "getAttributePrefix", "getAttributeLocalName", "getAttributeValue", "nsUri", "close", "", "getNamespacePrefix", "namespaceUri", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(message = "Don't use directly. Instead create an instance through xmlStreaming", replaceWith = @ReplaceWith(expression = "xmlStreaming.newReader(delegate)", imports = {"nl.adaptivity.xmlutil.xmlStreaming"}))
@XmlUtilDeprecatedInternal
public final class DomReader implements XmlReader {
    private List<? extends Attr> _namespaceAttrs;
    private boolean atEndOfElement;
    private Node current;
    private final Node delegate;
    private int depth;
    private boolean isStarted;

    /* compiled from: DomReader.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NodeType.values().length];
            try {
                iArr[NodeType.DOCUMENT_NODE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NodeType.ELEMENT_NODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NodeType.TEXT_NODE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Use extLocationInfo as that allows more detailed information", replaceWith = @ReplaceWith(expression = "extLocationInfo?.toString()", imports = {}))
    public static /* synthetic */ void getLocationInfo$annotations() {
    }

    public static /* synthetic */ void getText$annotations() {
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ QName getAttributeName(int i) {
        return XmlReader.CC.$default$getAttributeName(this, i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ String getAttributeValue(QName qName) {
        return XmlReader.CC.$default$getAttributeValue(this, qName);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ QName getName() {
        return XmlReader.CC.$default$getName(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isCharacters() {
        return XmlReader.CC.$default$isCharacters(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isEndElement() {
        return XmlReader.CC.$default$isEndElement(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isStartElement() {
        return XmlReader.CC.$default$isStartElement(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isWhitespace() {
        return XmlReader.CC.$default$isWhitespace(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ EventType nextTag() {
        return XmlReader.CC.$default$nextTag(this);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ void require(EventType eventType, String str, String str2) {
        XmlReader.CC.$default$require(this, eventType, str, str2);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ void require(EventType eventType, QName qName) {
        XmlReader.CC.$default$require(this, eventType, qName);
    }

    public DomReader(Node delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final Node getDelegate() {
        return this.delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DomReader(org.w3c.dom.Node delegate) {
        this(r0 == null ? Document_jvmKt.adoptNode(CreateDocumentKt.createDocument(new QName("XX")), delegate) : r0);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Node node = delegate instanceof Node ? (Node) delegate : null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI() {
        Element $this$_get_namespaceURI__u24lambda_u240 = getCurrentElement();
        if ($this$_get_namespaceURI__u24lambda_u240 != null) {
            String namespaceURI = $this$_get_namespaceURI__u24lambda_u240.getNamespaceURI();
            if (namespaceURI == null) {
                namespaceURI = "";
            }
            if (namespaceURI != null) {
                return namespaceURI;
            }
        }
        throw new XmlException("Only elements have a namespace uri", null, 2, null);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocalName() {
        String localName;
        Element currentElement = getCurrentElement();
        if (currentElement == null || (localName = currentElement.getLocalName()) == null) {
            throw new XmlException("Only elements have a local name", null, 2, null);
        }
        return localName;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPrefix() {
        Element it = getCurrentElement();
        if (it != null) {
            String prefix = it.getPrefix();
            if (prefix == null) {
                prefix = "";
            }
            if (prefix != null) {
                return prefix;
            }
        }
        throw new XmlException("Only elements have a prefix", null, 2, null);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isStarted() {
        return this.isStarted;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getDepth() {
        return this.depth;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiTarget() {
        Node c = getRequireCurrent();
        if (!(c.getNodeType() == 7)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Intrinsics.checkNotNull(c, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.ProcessingInstruction");
        return ((ProcessingInstruction) c).getTarget();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiData() {
        Node c = getRequireCurrent();
        if (!(c.getNodeType() == 7)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Intrinsics.checkNotNull(c, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.ProcessingInstruction");
        return ((ProcessingInstruction) c).getData();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getText() {
        Short sh;
        Node $this$nodeType$iv = this.current;
        if ($this$nodeType$iv == null) {
            sh = null;
        } else {
            sh = Short.valueOf($this$nodeType$iv.getNodeType());
        }
        boolean z = true;
        if (!(sh != null && sh.shortValue() == 5)) {
            if (!(sh != null && sh.shortValue() == 8)) {
                if (!(sh != null && sh.shortValue() == 3)) {
                    if (!(sh != null && sh.shortValue() == 4)) {
                        if (sh == null || sh.shortValue() != 7) {
                            z = false;
                        }
                        if (z) {
                            Node node = this.current;
                            Intrinsics.checkNotNull(node, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.CharacterData");
                            CharacterData it = (CharacterData) node;
                            CharacterData $this$nodeName$iv = it;
                            return $this$nodeName$iv.getNodeName() + ' ' + it.getData();
                        }
                        throw new XmlException("Node is not a text node", null, 2, null);
                    }
                }
            }
        }
        Node node2 = this.current;
        Intrinsics.checkNotNull(node2, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.CharacterData");
        CharacterData $this$data$iv = (CharacterData) node2;
        return $this$data$iv.getData();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getAttributeCount() {
        NamedNodeMap attributes;
        Element element = (Element) this.current;
        if (element == null || (attributes = element.getAttributes()) == null) {
            return 0;
        }
        return attributes.getLength();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType getEventType() {
        EventType eventType;
        Node c = this.current;
        if (c == null) {
            return EventType.END_DOCUMENT;
        }
        eventType = DomReaderKt.toEventType(c, this.atEndOfElement);
        return eventType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r8.getLocalName(), nl.adaptivity.xmlutil.XMLConstants.XMLNS_ATTRIBUTE) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Attr> getNamespaceAttrs() {
        List list = this._namespaceAttrs;
        if (list != null) {
            return list;
        }
        NamedNodeMap $this$filterTyped$iv = getRequireCurrentElem().getAttributes();
        List result$iv = new ArrayList();
        int l$iv$iv = $this$filterTyped$iv.getLength();
        for (int idx$iv$iv = 0; idx$iv$iv < l$iv$iv; idx$iv$iv++) {
            Attr attr$iv = $this$filterTyped$iv.item(idx$iv$iv);
            Intrinsics.checkNotNull(attr$iv, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Attr");
            boolean z = false;
            if (attr$iv.getNamespaceURI() == null || Intrinsics.areEqual(attr$iv.getNamespaceURI(), XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                if (!Intrinsics.areEqual(attr$iv.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE)) {
                    String prefix = attr$iv.getPrefix();
                    if (prefix == null || prefix.length() == 0) {
                    }
                }
                if (!Intrinsics.areEqual(attr$iv.getValue(), XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                    z = true;
                }
            }
            if (z) {
                result$iv.add(attr$iv);
            }
        }
        this._namespaceAttrs = result$iv;
        return result$iv;
    }

    private static final <A extends Appendable> A _get_extLocationInfo_$helper(Node node, A a) {
        NodeType nodetype = node != null ? node.getNodetype() : null;
        switch (nodetype == null ? -1 : WhenMappings.$EnumSwitchMapping$0[nodetype.ordinal()]) {
            case -1:
            case 1:
                return a;
            case 0:
            default:
                Node $this$parentNode$iv = node.getParentNode();
                A a2 = (A) _get_extLocationInfo_$helper($this$parentNode$iv, a);
                a2.append("/.");
                return a2;
            case 2:
                Node $this$parentNode$iv2 = node.getParentNode();
                A a3 = (A) _get_extLocationInfo_$helper($this$parentNode$iv2, a);
                a3.append('/').append(node.getNodeName());
                return a3;
            case 3:
                Node $this$parentNode$iv3 = node.getParentNode();
                A a4 = (A) _get_extLocationInfo_$helper($this$parentNode$iv3, a);
                a4.append("/text()");
                return a4;
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public XmlReader.LocationInfo getExtLocationInfo() {
        String sb = ((StringBuilder) _get_extLocationInfo_$helper(this.current, new StringBuilder())).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return new XmlReader.StringLocationInfo(sb);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocationInfo() {
        return getExtLocationInfo().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Node getRequireCurrent() {
        Node node = this.current;
        if (node != null) {
            return node;
        }
        throw new IllegalStateException("No current element");
    }

    private final Element getRequireCurrentElem() {
        Element currentElement = getCurrentElement();
        if (currentElement != null) {
            return currentElement;
        }
        throw new IllegalStateException("No current element");
    }

    private final Element getCurrentElement() {
        Short sh;
        Node $this$nodeType$iv = this.current;
        if ($this$nodeType$iv == null) {
            sh = null;
        } else {
            sh = Short.valueOf($this$nodeType$iv.getNodeType());
        }
        boolean z = false;
        if (sh != null && sh.shortValue() == 1) {
            z = true;
        }
        if (z) {
            Node node = this.current;
            Intrinsics.checkNotNull(node, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Element");
            return (Element) node;
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public IterableNamespaceContext getNamespaceContext() {
        return new DomReader$namespaceContext$1(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public List<Namespace> getNamespaceDecls() {
        XmlEvent.NamespaceImpl namespaceImpl;
        Iterable $this$map$iv = getNamespaceAttrs();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Attr attr = (Attr) item$iv$iv;
            if (Intrinsics.areEqual(attr.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE)) {
                String localName = attr.getLocalName();
                Intrinsics.checkNotNull(localName);
                namespaceImpl = new XmlEvent.NamespaceImpl(localName, attr.getValue());
            } else {
                namespaceImpl = new XmlEvent.NamespaceImpl("", attr.getValue());
            }
            destination$iv$iv.add(namespaceImpl);
        }
        return (List) destination$iv$iv;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getEncoding() {
        Node d = this.delegate;
        if (d.getNodeType() == 9) {
            Intrinsics.checkNotNull(d, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Document");
            return ((Document) d).getInputEncoding();
        }
        Document $this$inputEncoding$iv = d.getOwnerDocument();
        Intrinsics.checkNotNull($this$inputEncoding$iv);
        return $this$inputEncoding$iv.getInputEncoding();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public Boolean getStandalone() {
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getVersion() {
        return "1.0";
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.util.Iterator
    public boolean hasNext() {
        Node $this$parentNode$iv;
        if (this.atEndOfElement) {
            Node $this$parentNode$iv2 = this.current;
            if ($this$parentNode$iv2 == null) {
                $this$parentNode$iv = null;
            } else {
                $this$parentNode$iv = $this$parentNode$iv2.getParentNode();
            }
            if ($this$parentNode$iv == null && Intrinsics.areEqual(this.current, this.delegate)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        r1 = nl.adaptivity.xmlutil.DomReaderKt.toEventType(r2, true);
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EventType next() {
        EventType it;
        EventType eventType;
        if (getEventType() == EventType.END_ELEMENT) {
            this.depth = getDepth() - 1;
            getDepth();
        }
        this._namespaceAttrs = null;
        Node c = this.current;
        if (c == null) {
            this.isStarted = true;
            this.current = this.delegate;
            return EventType.START_DOCUMENT;
        }
        if (this.atEndOfElement) {
            Node $this$nextSibling$iv = c.getNextSibling();
            if ($this$nextSibling$iv != null) {
                Node $this$nextSibling$iv2 = c.getNextSibling();
                this.current = $this$nextSibling$iv2;
                this.atEndOfElement = false;
            } else {
                Node $this$parentNode$iv = c.getParentNode();
                this.current = $this$parentNode$iv;
                Node node = this.current;
                return (node == null || eventType == null) ? EventType.END_DOCUMENT : eventType;
            }
        } else {
            Node $this$firstChild$iv = c.getFirstChild();
            if ($this$firstChild$iv == null) {
                this.atEndOfElement = true;
                return EventType.END_ELEMENT;
            }
            Node $this$firstChild$iv2 = c.getFirstChild();
            this.current = $this$firstChild$iv2;
        }
        Node c2 = getRequireCurrent();
        short nodeType = c2.getNodeType();
        if (nodeType != 1 && nodeType != 9) {
            this.atEndOfElement = true;
        }
        it = DomReaderKt.toEventType(c2, this.atEndOfElement);
        if (it == EventType.START_ELEMENT) {
            this.depth = getDepth() + 1;
            getDepth();
        }
        return it;
    }

    @Deprecated(message = "Provided for compatibility.")
    /* renamed from: getDelegate  reason: collision with other method in class */
    public final org.w3c.dom.Node m1572getDelegate() {
        Node node = this.delegate;
        if (node instanceof org.w3c.dom.Node) {
            return (org.w3c.dom.Node) node;
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeNamespace(int index) {
        Attr attr = getRequireCurrentElem().getAttributes().get(index);
        if (attr == null) {
            throw new IndexOutOfBoundsException();
        }
        String namespaceURI = attr.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributePrefix(int index) {
        Attr attr = getRequireCurrentElem().getAttributes().get(index);
        if (attr == null) {
            throw new IndexOutOfBoundsException();
        }
        String prefix = attr.getPrefix();
        return prefix == null ? "" : prefix;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeLocalName(int index) {
        Attr attr = getRequireCurrentElem().getAttributes().get(index);
        if (attr == null) {
            throw new IndexOutOfBoundsException();
        }
        String localName = attr.getLocalName();
        return localName == null ? attr.getName() : localName;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(int index) {
        Attr attr = getRequireCurrentElem().getAttributes().get(index);
        if (attr == null) {
            throw new IndexOutOfBoundsException();
        }
        return attr.getValue();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(String nsUri, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        return getRequireCurrentElem().getAttributeNS(nsUri, localName);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.current = null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespacePrefix(String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        return CommondomutilKt.myLookupPrefix(getRequireCurrent(), namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return CommondomutilKt.myLookupNamespaceURI(getRequireCurrent(), prefix);
    }
}