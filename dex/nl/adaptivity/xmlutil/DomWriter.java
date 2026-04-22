package nl.adaptivity.xmlutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.core.impl.PlatformXmlWriterBase;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Multiplatform_jvmKt;
import nl.adaptivity.xmlutil.dom.Document_jvmKt;
import nl.adaptivity.xmlutil.dom2.Attr;
import nl.adaptivity.xmlutil.dom2.CDATASection;
import nl.adaptivity.xmlutil.dom2.Comment;
import nl.adaptivity.xmlutil.dom2.Document;
import nl.adaptivity.xmlutil.dom2.DocumentType;
import nl.adaptivity.xmlutil.dom2.Element;
import nl.adaptivity.xmlutil.dom2.NamedNodeMap;
import nl.adaptivity.xmlutil.dom2.Node;
import nl.adaptivity.xmlutil.dom2.ProcessingInstruction;
import nl.adaptivity.xmlutil.dom2.Text;
import nl.adaptivity.xmlutil.util.CommondomutilKt;
import nl.adaptivity.xmlutil.util.impl.CreateDocumentKt;
import org.apache.commons.io.IOUtils;

/* compiled from: DomWriter.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b/\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB)\b\u0017\u0012\n\u0010\u0003\u001a\u00060\u000bj\u0002`\f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\rB\u0013\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000eJ\u0012\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020#H\u0002J\u001c\u0010&\u001a\u00020!2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!0 H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020-H\u0016J$\u0010;\u001a\u00020!2\b\u0010<\u001a\u0004\u0018\u00010-2\u0006\u0010=\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020-H\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010@\u001a\u00020-H\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010@\u001a\u00020-H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010@\u001a\u00020-H\u0016J\u0010\u0010C\u001a\u00020!2\u0006\u0010@\u001a\u00020-H\u0016J\u0018\u0010C\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020-2\u0006\u0010D\u001a\u00020-H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010@\u001a\u00020-H\u0016J,\u0010F\u001a\u00020!2\b\u0010<\u001a\u0004\u0018\u00010-2\u0006\u0010G\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010-2\u0006\u0010\u0019\u001a\u00020-H\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010@\u001a\u00020-H\u0016J+\u0010R\u001a\u00020!2\b\u0010S\u001a\u0004\u0018\u00010-2\b\u0010T\u001a\u0004\u0018\u00010-2\b\u0010U\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010VJ\b\u0010W\u001a\u00020!H\u0016J$\u0010X\u001a\u00020!2\b\u0010<\u001a\u0004\u0018\u00010-2\u0006\u0010=\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010Y\u001a\u0004\u0018\u00010-2\u0006\u0010>\u001a\u00020-H\u0016J\u0014\u0010Z\u001a\u0004\u0018\u00010-2\b\u0010:\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010[\u001a\u00020!2\u0006\u0010>\u001a\u00020-2\u0006\u0010:\u001a\u00020-H\u0016J\b\u0010\\\u001a\u00020!H\u0016J\b\u0010]\u001a\u00020!H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R \u0010.\u001a\u00060/j\u0002`0X\u0096\u0004¢\u0006\u0010\n\u0002\u00104\u0012\u0004\b1\u0010\u0016\u001a\u0004\b2\u00103R\u001e\u00105\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020#@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\"\u0010I\u001a\u0004\u0018\u00010-2\b\u0010\u0019\u001a\u0004\u0018\u00010-@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\"\u0010L\u001a\u0004\u0018\u00010-2\b\u0010\u0019\u001a\u0004\u0018\u00010-@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010KR$\u0010N\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010P¨\u0006_"}, d2 = {"Lnl/adaptivity/xmlutil/DomWriter;", "Lnl/adaptivity/xmlutil/core/impl/PlatformXmlWriterBase;", "Lnl/adaptivity/xmlutil/XmlWriter;", "current", "Lnl/adaptivity/xmlutil/dom2/Node;", "isAppend", "", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "<init>", "(Lnl/adaptivity/xmlutil/dom2/Node;ZLnl/adaptivity/xmlutil/XmlDeclMode;)V", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "(Lorg/w3c/dom/Node;ZLnl/adaptivity/xmlutil/XmlDeclMode;)V", "(Lnl/adaptivity/xmlutil/XmlDeclMode;)V", "()Z", "getXmlDeclMode", "()Lnl/adaptivity/xmlutil/XmlDeclMode;", "docDelegate", "Lnl/adaptivity/xmlutil/dom2/Document;", "target", "getTarget$annotations", "()V", "getTarget", "()Lnl/adaptivity/xmlutil/dom2/Document;", "value", "currentNode", "getCurrentNode$annotations", "getCurrentNode", "()Lnl/adaptivity/xmlutil/dom2/Node;", "pendingOperations", "", "Lkotlin/Function1;", "", "lastTagDepth", "", "writeIndent", "newDepth", "addToPending", "operation", "requireCurrent", "Lnl/adaptivity/xmlutil/dom2/Element;", "getRequireCurrent", "()Lnl/adaptivity/xmlutil/dom2/Element;", "error", "", "namespaceContext", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "getNamespaceContext$annotations", "getNamespaceContext", "()Ljavax/xml/namespace/NamespaceContext;", "Ljavax/xml/namespace/NamespaceContext;", "depth", "getDepth", "()I", "namespaceAttr", "namespacePrefix", "namespaceUri", "startTag", "namespace", "localName", "prefix", "comment", "text", "cdsect", "entityRef", "processingInstruction", "data", "ignorableWhitespace", "attribute", "name", "docdecl", "requestedVersion", "getRequestedVersion", "()Ljava/lang/String;", "requestedEncoding", "getRequestedEncoding", "requestedStandalone", "getRequestedStandalone", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "startDocument", "version", "encoding", "standalone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "endDocument", "endTag", "getNamespaceUri", "getPrefix", "setPrefix", "close", "flush", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DomWriter extends PlatformXmlWriterBase implements XmlWriter {
    private static final Companion Companion = new Companion(null);
    private static final int TAG_DEPTH_FORCE_INDENT_NEXT = Integer.MAX_VALUE;
    private static final int TAG_DEPTH_NOT_TAG = -1;
    private Node currentNode;
    private int depth;
    private Document docDelegate;
    private final boolean isAppend;
    private int lastTagDepth;
    private final NamespaceContext namespaceContext;
    private final List<Function1<Document, Unit>> pendingOperations;
    private String requestedEncoding;
    private Boolean requestedStandalone;
    private String requestedVersion;
    private final XmlDeclMode xmlDeclMode;

    @XmlUtilInternal
    public static /* synthetic */ void getCurrentNode$annotations() {
    }

    public static /* synthetic */ void getNamespaceContext$annotations() {
    }

    @XmlUtilInternal
    public static /* synthetic */ void getTarget$annotations() {
    }

    public /* synthetic */ DomWriter(Node node, boolean z, XmlDeclMode xmlDeclMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(node, (i & 2) != 0 ? false : z, (i & 4) != 0 ? XmlDeclMode.None : xmlDeclMode);
    }

    public final boolean isAppend() {
        return this.isAppend;
    }

    public final XmlDeclMode getXmlDeclMode() {
        return this.xmlDeclMode;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Don't use directly. Instead create an instance through xmlStreaming")
    public DomWriter(Node current, boolean isAppend, XmlDeclMode xmlDeclMode) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        this.isAppend = isAppend;
        this.xmlDeclMode = xmlDeclMode;
        this.docDelegate = current != null ? current instanceof Document ? (Document) current : current.getOwnerDocument() : null;
        this.currentNode = current;
        this.pendingOperations = new ArrayList();
        this.lastTagDepth = -1;
        this.namespaceContext = new NamespaceContext() { // from class: nl.adaptivity.xmlutil.DomWriter$namespaceContext$1
            @Override // javax.xml.namespace.NamespaceContext
            public String getNamespaceURI(String prefix) {
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                Node currentNode = DomWriter.this.getCurrentNode();
                if (currentNode != null) {
                    return currentNode.lookupNamespaceURI(prefix);
                }
                return null;
            }

            @Override // javax.xml.namespace.NamespaceContext
            public String getPrefix(String namespaceURI) {
                Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
                Node currentNode = DomWriter.this.getCurrentNode();
                if (currentNode != null) {
                    return currentNode.lookupPrefix(namespaceURI);
                }
                return null;
            }

            private final void collectDeclaredPrefixes(Element $this$collectDeclaredPrefixes, String namespaceUri, Set<String> set, Collection<String> collection) {
                String prefix;
                NamedNodeMap $this$forEachAttr$iv = $this$collectDeclaredPrefixes.getAttributes();
                int l$iv = $this$forEachAttr$iv.getLength();
                for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
                    Attr attr = $this$forEachAttr$iv.item(idx$iv);
                    Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Attr");
                    if (Intrinsics.areEqual(attr.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE)) {
                        prefix = attr.getLocalName();
                    } else {
                        String prefix2 = attr.getPrefix();
                        prefix = ((prefix2 == null || prefix2.length() == 0) && Intrinsics.areEqual(attr.getLocalName(), XMLConstants.XMLNS_ATTRIBUTE)) ? "" : null;
                    }
                    if (prefix != null && collection.contains(prefix)) {
                        if (Intrinsics.areEqual(attr.getValue(), namespaceUri)) {
                            set.add(prefix);
                        }
                        collection.add(prefix);
                    }
                }
                Element parentElement = $this$collectDeclaredPrefixes.getParentElement();
                if (parentElement != null) {
                    collectDeclaredPrefixes(parentElement, namespaceUri, set, collection);
                }
            }

            @Override // javax.xml.namespace.NamespaceContext
            @Deprecated(message = "Don't use as unsafe", replaceWith = @ReplaceWith(expression = "prefixesFor(namespaceURI)", imports = {"nl.adaptivity.xmlutil.prefixesFor"}))
            public Iterator<String> getPrefixes(String namespaceURI) {
                Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
                DomWriter domWriter = DomWriter.this;
                Set $this$getPrefixes_u24lambda_u241 = SetsKt.createSetBuilder();
                Element element = (Element) domWriter.getCurrentNode();
                if (element != null) {
                    collectDeclaredPrefixes(element, namespaceURI, $this$getPrefixes_u24lambda_u241, new ArrayList());
                }
                return CollectionsKt.toList(SetsKt.build($this$getPrefixes_u24lambda_u241)).iterator();
            }
        };
    }

    public /* synthetic */ DomWriter(org.w3c.dom.Node node, boolean z, XmlDeclMode xmlDeclMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(node, (i & 2) != 0 ? false : z, (i & 4) != 0 ? XmlDeclMode.None : xmlDeclMode);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated(message = "Compatibility constructor, create through xmlStreaming")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DomWriter(org.w3c.dom.Node current, boolean isAppend, XmlDeclMode xmlDeclMode) {
        this(r0 == null ? Document_jvmKt.adoptNode(CreateDocumentKt.createDocument(new QName("x")), current) : r0, isAppend, xmlDeclMode);
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        Node node = current instanceof Node ? (Node) current : null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DomWriter(XmlDeclMode xmlDeclMode) {
        this((Node) null, false, xmlDeclMode, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
    }

    public /* synthetic */ DomWriter(XmlDeclMode xmlDeclMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? XmlDeclMode.None : xmlDeclMode);
    }

    public final Document getTarget() {
        Document document = this.docDelegate;
        if (document != null) {
            return document;
        }
        throw new XmlException("Document not created yet", null, 2, null);
    }

    public final Node getCurrentNode() {
        return this.currentNode;
    }

    static /* synthetic */ void writeIndent$default(DomWriter domWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = domWriter.getDepth();
        }
        domWriter.writeIndent(i);
    }

    private final void writeIndent(int newDepth) {
        List indentSeq = getIndentSequence();
        if (this.lastTagDepth >= 0 && !indentSeq.isEmpty() && this.lastTagDepth != getDepth()) {
            ignorableWhitespace(IOUtils.LINE_SEPARATOR_UNIX);
            try {
                setIndentSequence(CollectionsKt.emptyList());
                int depth = getDepth();
                for (int i = 0; i < depth; i++) {
                    List $this$forEach$iv = indentSeq;
                    for (Object element$iv : $this$forEach$iv) {
                        XmlEvent.TextEvent it = (XmlEvent.TextEvent) element$iv;
                        it.writeTo(this);
                    }
                }
            } finally {
                setIndentSequence(indentSeq);
            }
        }
        this.lastTagDepth = newDepth;
    }

    private final void addToPending(Function1<? super Document, Unit> function1) {
        if (this.docDelegate == null) {
            List<Function1<Document, Unit>> list = this.pendingOperations;
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function1<nl.adaptivity.xmlutil.dom2.Document, kotlin.Unit>>");
            TypeIntrinsics.asMutableList(list).add(function1);
            return;
        }
        throw new IllegalStateException("Use of pending list when there is a document already");
    }

    private final Element getRequireCurrent() {
        Node node = this.currentNode;
        if (node != null) {
            return (Element) node;
        }
        throw new IllegalStateException("No current element");
    }

    private final Element requireCurrent(String error) {
        Node node = this.currentNode;
        Element element = node instanceof Element ? (Element) node : null;
        if (element != null) {
            return element;
        }
        throw new XmlException("The current node is not an element: " + error, null, 2, null);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public NamespaceContext getNamespaceContext() {
        return this.namespaceContext;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public int getDepth() {
        return this.depth;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void namespaceAttr(String namespacePrefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        Element cur = requireCurrent("Namespace attribute");
        if (namespacePrefix.length() == 0) {
            if (!(namespaceUri.length() == 0) || !Intrinsics.areEqual(cur.lookupNamespaceURI(""), "")) {
                cur.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, XMLConstants.XMLNS_ATTRIBUTE, namespaceUri);
                return;
            }
            return;
        }
        cur.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:" + namespacePrefix, namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startTag(String namespace, String localName, String prefix) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        writeIndent$default(this, 0, 1, null);
        this.depth = getDepth() + 1;
        if (this.currentNode == null && this.docDelegate == null) {
            Document doc = CreateDocumentKt.createDocument(XmlUtil.qname(namespace == null ? "" : namespace, localName, prefix));
            this.docDelegate = doc;
            this.currentNode = this.docDelegate;
            Element e = doc.getDocumentElement();
            Intrinsics.checkNotNull(e);
            doc.removeChild(e);
            for (Function1 pending : this.pendingOperations) {
                pending.invoke(doc);
            }
            doc.appendChild(e);
            List<Function1<Document, Unit>> list = this.pendingOperations;
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function1<nl.adaptivity.xmlutil.dom2.Document, kotlin.Unit>>");
            TypeIntrinsics.asMutableList(list).clear();
            this.lastTagDepth = 0;
            this.currentNode = doc.getDocumentElement();
            return;
        }
        if (this.currentNode == null && !this.isAppend) {
            Node $this$childNodes$iv = getTarget();
            Sequence $this$count$iv = SequencesKt.asSequence($this$childNodes$iv.getChildNodes().iterator());
            int count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                Node it = (Node) element$iv;
                Node it2 = it.getNodeType() == 1 ? 1 : null;
                if (it2 != null && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            if (count$iv > 0) {
                Node $this$childNodes$iv2 = getTarget();
                Iterable $this$filterIsInstance$iv = $this$childNodes$iv2.getChildNodes();
                Collection destination$iv$iv = new ArrayList();
                for (Node node : $this$filterIsInstance$iv) {
                    if (node instanceof Element) {
                        destination$iv$iv.add(node);
                    }
                }
                for (Element e2 : (List) destination$iv$iv) {
                    getTarget().removeChild(e2);
                }
            }
        }
        Element elem = getTarget().createElementNS(XmlUtil.qname(namespace, localName, prefix));
        Node node2 = this.currentNode;
        Intrinsics.checkNotNull(node2);
        node2.appendChild(elem);
        this.currentNode = elem;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void comment(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        writeIndent$default(this, 0, 1, null);
        Node ce = this.currentNode;
        if (ce == null) {
            addToPending(new Function1() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit comment$lambda$4;
                    comment$lambda$4 = DomWriter.comment$lambda$4(DomWriter.this, text, (Document) obj);
                    return comment$lambda$4;
                }
            });
            return;
        }
        Comment comment = getTarget().createComment(text);
        ce.appendChild(comment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comment$lambda$4(DomWriter this$0, String $text, Document it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.comment($text);
        return Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void text(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.lastTagDepth = -1;
        Node ce = this.currentNode;
        if (ce == null) {
            if (!StringsKt.isBlank(text)) {
                throw new XmlException("Not in an element -- text", null, 2, null);
            }
            addToPending(new Function1() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit text$lambda$6;
                    text$lambda$6 = DomWriter.text$lambda$6(DomWriter.this, text, (Document) obj);
                    return text$lambda$6;
                }
            });
            return;
        }
        Text textNode = getTarget().createTextNode(text);
        ce.appendChild(textNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit text$lambda$6(DomWriter this$0, String $text, Document it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.ignorableWhitespace($text);
        return Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void cdsect(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.lastTagDepth = -1;
        CDATASection cdataSection = getTarget().createCDATASection(text);
        Node node = this.currentNode;
        if (node == null || node.appendChild(cdataSection) == null) {
            throw new XmlException("Not in an element -- cdsect", null, 2, null);
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void entityRef(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.lastTagDepth = -1;
        throw new UnsupportedOperationException("Creating entity references is not supported (or incorrect) in most browsers");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0.getNodeType() == 1) goto L5;
     */
    @Override // nl.adaptivity.xmlutil.XmlWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processingInstruction(final String text) {
        int $i$f$getNodeType;
        Pair pair;
        Intrinsics.checkNotNullParameter(text, "text");
        writeIndent(Integer.MAX_VALUE);
        Node $this$nodeType$iv = this.currentNode;
        if ($this$nodeType$iv != null) {
            $i$f$getNodeType = 1;
        }
        $i$f$getNodeType = 0;
        if ($i$f$getNodeType == 0) {
            throw new XmlException("Document already started", null, 2, null);
        }
        if (this.docDelegate == null) {
            addToPending(new Function1() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit processingInstruction$lambda$9;
                    processingInstruction$lambda$9 = DomWriter.processingInstruction$lambda$9(DomWriter.this, text, (Document) obj);
                    return processingInstruction$lambda$9;
                }
            });
            return;
        }
        int split = StringsKt.indexOf$default((CharSequence) text, ' ', 0, false, 6, (Object) null);
        if (split < 0) {
            pair = TuplesKt.to(text, "");
        } else {
            String substring = text.substring(0, split);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = text.substring(split + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            pair = TuplesKt.to(substring, substring2);
        }
        String target = (String) pair.component1();
        String data = (String) pair.component2();
        ProcessingInstruction processInstr = getTarget().createProcessingInstruction(target, data);
        getTarget().appendChild(processInstr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processingInstruction$lambda$9(DomWriter this$0, String $text, Document it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.processingInstruction($text);
        return Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.PlatformXmlWriterBase, nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(final String target, final String data) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(data, "data");
        Node ce = this.currentNode;
        if (ce == null) {
            addToPending(new Function1() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit processingInstruction$lambda$11;
                    processingInstruction$lambda$11 = DomWriter.processingInstruction$lambda$11(DomWriter.this, target, data, (Document) obj);
                    return processingInstruction$lambda$11;
                }
            });
        } else {
            ProcessingInstruction processInstr = getTarget().createProcessingInstruction(target, data);
            ce.appendChild(processInstr);
        }
        this.lastTagDepth = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processingInstruction$lambda$11(DomWriter this$0, String $target, String $data, Document it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.processingInstruction($target, $data);
        return Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void ignorableWhitespace(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Node ce = this.currentNode;
        if (ce == null) {
            addToPending(new Function1() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ignorableWhitespace$lambda$12;
                    ignorableWhitespace$lambda$12 = DomWriter.ignorableWhitespace$lambda$12(DomWriter.this, text, (Document) obj);
                    return ignorableWhitespace$lambda$12;
                }
            });
        } else if (ce.getNodeType() != 9) {
            Text textNode = getTarget().createTextNode(text);
            ce.appendChild(textNode);
        }
        this.lastTagDepth = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ignorableWhitespace$lambda$12(DomWriter this$0, String $text, Document it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.ignorableWhitespace($text);
        return Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void attribute(String namespace, String name, String prefix, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Element cur = requireCurrent("attribute");
        String str = namespace;
        boolean z = false;
        if (str == null || str.length() == 0) {
            String str2 = prefix;
            if (str2 == null || str2.length() == 0) {
                cur.setAttribute(name, value);
                return;
            }
        }
        String str3 = prefix;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        if (!z) {
            cur.setAttributeNS(namespace == null ? "" : namespace, prefix + AbstractJsonLexerKt.COLON + name, value);
        } else {
            cur.setAttributeNS(namespace, name, value);
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void docdecl(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        writeIndent(Integer.MAX_VALUE);
        Document target = this.docDelegate;
        if (target == null) {
            addToPending(new Function1() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit docdecl$lambda$14;
                    docdecl$lambda$14 = DomWriter.docdecl$lambda$14(DomWriter.this, text, (Document) obj);
                    return docdecl$lambda$14;
                }
            });
            return;
        }
        List textElems = StringsKt.split$default((CharSequence) text, new String[]{" "}, false, 3, 2, (Object) null);
        String qualifiedName = (String) textElems.get(0);
        String publicId = textElems.size() > 1 ? (String) textElems.get(1) : "";
        String systemId = textElems.size() > 2 ? (String) textElems.get(2) : "";
        DocumentType docType = target.getImplementation().createDocumentType(qualifiedName, publicId, systemId);
        target.appendChild(docType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit docdecl$lambda$14(DomWriter this$0, String $text, Document it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.docdecl($text);
        return Unit.INSTANCE;
    }

    public final String getRequestedVersion() {
        return this.requestedVersion;
    }

    public final String getRequestedEncoding() {
        return this.requestedEncoding;
    }

    public final Boolean getRequestedStandalone() {
        return this.requestedStandalone;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startDocument(String version, String encoding, Boolean standalone) {
        writeIndent(Integer.MAX_VALUE);
        this.requestedVersion = version;
        this.requestedEncoding = encoding;
        this.requestedStandalone = standalone;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endDocument() {
        this.currentNode = null;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endTag(String namespace, String localName, String prefix) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        this.depth = getDepth() - 1;
        writeIndent(Integer.MAX_VALUE);
        Node $this$parentNode$iv = requireCurrent("No current element or no parent element");
        this.currentNode = $this$parentNode$iv.getParentNode();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getNamespaceUri(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Node node = this.currentNode;
        if (node != null) {
            return CommondomutilKt.myLookupNamespaceURI(node, prefix);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getPrefix(String namespaceUri) {
        Node node = this.currentNode;
        if (node != null) {
            return CommondomutilKt.myLookupPrefix(node, namespaceUri == null ? "" : namespaceUri);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setPrefix(final String prefix, final String namespaceUri) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        Document docDelegate = this.docDelegate;
        if (docDelegate == null) {
            addToPending(new Function1() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit prefix$lambda$16;
                    prefix$lambda$16 = DomWriter.setPrefix$lambda$16(DomWriter.this, prefix, namespaceUri, (Document) obj);
                    return prefix$lambda$16;
                }
            });
        } else if (!Intrinsics.areEqual(docDelegate.lookupNamespaceURI(prefix), namespaceUri)) {
            String qname = prefix.length() == 0 ? XMLConstants.XMLNS_ATTRIBUTE : "xmlns:" + prefix;
            Node node = this.currentNode;
            Element element = node instanceof Element ? (Element) node : null;
            if (element != null) {
                element.setAttribute(qname, namespaceUri);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setPrefix$lambda$16(DomWriter this$0, String $prefix, String $namespaceUri, Document it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.setPrefix($prefix, $namespaceUri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String close$lambda$17(DomWriter this$0) {
        return "Closing a dom writer but not all elements were closed (depth:" + this$0.getDepth() + ')';
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Multiplatform_jvmKt.m1631assert(getDepth() == 0, new Function0() { // from class: nl.adaptivity.xmlutil.DomWriter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String close$lambda$17;
                close$lambda$17 = DomWriter.close$lambda$17(DomWriter.this);
                return close$lambda$17;
            }
        });
        this.currentNode = null;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void flush() {
    }

    /* compiled from: DomWriter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lnl/adaptivity/xmlutil/DomWriter$Companion;", "", "<init>", "()V", "TAG_DEPTH_NOT_TAG", "", "TAG_DEPTH_FORCE_INDENT_NEXT", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}