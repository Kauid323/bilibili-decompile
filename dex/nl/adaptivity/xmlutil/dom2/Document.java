package nl.adaptivity.xmlutil.dom2;

import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Document.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH&J\u001a\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\tH&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH&J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH&J\u0019\u0010\u0016\u001a\u00020\u00072\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\tH&J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\tH&J\u0010\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020\tH&J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006(À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/Document;", "Lnl/adaptivity/xmlutil/dom2/Node;", "getImplementation", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "getDoctype", "Lnl/adaptivity/xmlutil/dom2/DocumentType;", "getDocumentElement", "Lnl/adaptivity/xmlutil/dom2/Element;", "getInputEncoding", "", "importNode", "node", "deep", "", "adoptNode", "createAttribute", "Lnl/adaptivity/xmlutil/dom2/Attr;", "localName", "createAttributeNS", "namespace", "qualifiedName", "createElement", "createElementNS", "namespaceURI", "qName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "(Ljavax/xml/namespace/QName;)Lnl/adaptivity/xmlutil/dom2/Element;", "createDocumentFragment", "Lnl/adaptivity/xmlutil/dom2/DocumentFragment;", "createTextNode", "Lnl/adaptivity/xmlutil/dom2/Text;", "data", "createCDATASection", "Lnl/adaptivity/xmlutil/dom2/CDATASection;", "createComment", "Lnl/adaptivity/xmlutil/dom2/Comment;", "createProcessingInstruction", "Lnl/adaptivity/xmlutil/dom2/ProcessingInstruction;", "target", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Document extends Node {
    Node adoptNode(Node node);

    Attr createAttribute(String str);

    Attr createAttributeNS(String str, String str2);

    CDATASection createCDATASection(String str);

    Comment createComment(String str);

    DocumentFragment createDocumentFragment();

    Element createElement(String str);

    Element createElementNS(String str, String str2);

    Element createElementNS(QName qName);

    ProcessingInstruction createProcessingInstruction(String str, String str2);

    Text createTextNode(String str);

    DocumentType getDoctype();

    Element getDocumentElement();

    DOMImplementation getImplementation();

    String getInputEncoding();

    Node importNode(Node node, boolean z);

    /* compiled from: Document.kt */
    /* renamed from: nl.adaptivity.xmlutil.dom2.Document$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Node importNode$default(Document document, Node node, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return document.importNode(node, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: importNode");
        }

        public static Element $default$createElementNS(Document _this, QName qName) {
            Intrinsics.checkNotNullParameter(qName, "qName");
            return qName.getPrefix().length() == 0 ? _this.createElementNS(qName.getNamespaceURI(), qName.getLocalPart()) : _this.createElementNS(qName.getNamespaceURI(), qName.getPrefix() + AbstractJsonLexerKt.COLON + qName.getLocalPart());
        }
    }
}