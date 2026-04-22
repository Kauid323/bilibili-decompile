package nl.adaptivity.xmlutil.core.impl.dom;

import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IAttr;
import nl.adaptivity.xmlutil.core.impl.idom.ICDATASection;
import nl.adaptivity.xmlutil.core.impl.idom.IComment;
import nl.adaptivity.xmlutil.core.impl.idom.IDOMImplementation;
import nl.adaptivity.xmlutil.core.impl.idom.IDocument;
import nl.adaptivity.xmlutil.core.impl.idom.IDocumentFragment;
import nl.adaptivity.xmlutil.core.impl.idom.IDocumentType;
import nl.adaptivity.xmlutil.core.impl.idom.IElement;
import nl.adaptivity.xmlutil.core.impl.idom.INode;
import nl.adaptivity.xmlutil.core.impl.idom.INodeList;
import nl.adaptivity.xmlutil.core.impl.idom.IProcessingInstruction;
import nl.adaptivity.xmlutil.core.impl.idom.IText;
import nl.adaptivity.xmlutil.dom2.Document;
import nl.adaptivity.xmlutil.dom2.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* compiled from: DocumentImpl.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0016J\u001a\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\bH\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u0002002\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020\bH\u0016J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\bH\u0016J\u001a\u00108\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\bH\u0016J\u0018\u0010;\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bH\u0016J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010?\u001a\u00020\u0013H\u0016J\"\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\b\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\bH\u0016J\u0010\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020A2\u0006\u0010E\u001a\u00020C2\u0006\u0010H\u001a\u00020\u0011H\u0016J\u0018\u0010G\u001a\u00020A2\u0006\u0010E\u001a\u00020F2\u0006\u0010H\u001a\u00020\u0011H\u0016¨\u0006I"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/DocumentImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocument;", "delegate", "<init>", "(Lorg/w3c/dom/Document;)V", "getInputEncoding", "", "getImplementation", "Lnl/adaptivity/xmlutil/core/impl/idom/IDOMImplementation;", "getDoctype", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentType;", "getDocumentElement", "Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "getXmlEncoding", "getXmlStandalone", "", "setXmlStandalone", "", "xmlStandalone", "getXmlVersion", "setXmlVersion", "xmlVersion", "getStrictErrorChecking", "setStrictErrorChecking", "strictErrorChecking", "getDocumentURI", "setDocumentURI", "documentURI", "getDomConfig", "Lorg/w3c/dom/DOMConfiguration;", "getElementsByTagName", "Lnl/adaptivity/xmlutil/core/impl/idom/INodeList;", "tagname", "getElementsByTagNameNS", "Lorg/w3c/dom/NodeList;", "namespaceURI", "localName", "getElementById", "elementId", "createElement", "createDocumentFragment", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentFragment;", "createTextNode", "Lnl/adaptivity/xmlutil/core/impl/idom/IText;", "data", "createCDATASection", "Lnl/adaptivity/xmlutil/core/impl/idom/ICDATASection;", "createComment", "Lnl/adaptivity/xmlutil/core/impl/idom/IComment;", "createProcessingInstruction", "Lnl/adaptivity/xmlutil/core/impl/idom/IProcessingInstruction;", "target", "createAttribute", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "createAttributeNS", "namespace", "qualifiedName", "createElementNS", "createEntityReference", "Lorg/w3c/dom/EntityReference;", "name", "normalizeDocument", "renameNode", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "n", "Lorg/w3c/dom/Node;", "adoptNode", "node", "Lnl/adaptivity/xmlutil/dom2/Node;", "importNode", "deep", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentImpl extends NodeImpl<Document> implements IDocument {
    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDocument
    public /* synthetic */ INode adoptNode(INode iNode) {
        return IDocument.CC.$default$adoptNode(this, iNode);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Document
    public /* synthetic */ Element createElementNS(QName qName) {
        return Document.CC.$default$createElementNS(this, qName);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDocument
    public /* synthetic */ INode importNode(INode iNode, boolean z) {
        return IDocument.CC.$default$importNode(this, iNode, z);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDocument
    public /* synthetic */ INode importNode(Node node) {
        return IDocument.CC.$default$importNode(this, node);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentImpl(org.w3c.dom.Document delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDocument, org.w3c.dom.Document, nl.adaptivity.xmlutil.dom2.Document
    public String getInputEncoding() {
        return getDelegate().getInputEncoding();
    }

    @Override // org.w3c.dom.Document
    public IDOMImplementation getImplementation() {
        return DOMImplementationImpl.INSTANCE;
    }

    @Override // org.w3c.dom.Document
    public IDocumentType getDoctype() {
        DocumentType p0 = getDelegate().getDoctype();
        return p0 != null ? new DocumentTypeImpl(p0) : null;
    }

    @Override // org.w3c.dom.Document
    public IElement getDocumentElement() {
        org.w3c.dom.Element documentElement = getDelegate().getDocumentElement();
        if (documentElement != null) {
            return NodeImplKt.wrap(documentElement);
        }
        return null;
    }

    @Override // org.w3c.dom.Document
    public String getXmlEncoding() {
        String xmlEncoding = getDelegate().getXmlEncoding();
        Intrinsics.checkNotNullExpressionValue(xmlEncoding, "getXmlEncoding(...)");
        return xmlEncoding;
    }

    @Override // org.w3c.dom.Document
    public boolean getXmlStandalone() {
        return getDelegate().getXmlStandalone();
    }

    @Override // org.w3c.dom.Document
    public void setXmlStandalone(boolean xmlStandalone) {
        getDelegate().setXmlStandalone(xmlStandalone);
    }

    @Override // org.w3c.dom.Document
    public String getXmlVersion() {
        String xmlVersion = getDelegate().getXmlVersion();
        Intrinsics.checkNotNullExpressionValue(xmlVersion, "getXmlVersion(...)");
        return xmlVersion;
    }

    @Override // org.w3c.dom.Document
    public void setXmlVersion(String xmlVersion) {
        getDelegate().setXmlVersion(xmlVersion);
    }

    @Override // org.w3c.dom.Document
    public boolean getStrictErrorChecking() {
        return getDelegate().getStrictErrorChecking();
    }

    @Override // org.w3c.dom.Document
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        getDelegate().setStrictErrorChecking(strictErrorChecking);
    }

    @Override // org.w3c.dom.Document
    public String getDocumentURI() {
        String documentURI = getDelegate().getDocumentURI();
        Intrinsics.checkNotNullExpressionValue(documentURI, "getDocumentURI(...)");
        return documentURI;
    }

    @Override // org.w3c.dom.Document
    public void setDocumentURI(String documentURI) {
        getDelegate().setDocumentURI(documentURI);
    }

    @Override // org.w3c.dom.Document
    public DOMConfiguration getDomConfig() {
        DOMConfiguration domConfig = getDelegate().getDomConfig();
        Intrinsics.checkNotNullExpressionValue(domConfig, "getDomConfig(...)");
        return domConfig;
    }

    @Override // org.w3c.dom.Document
    public INodeList getElementsByTagName(String tagname) {
        Intrinsics.checkNotNullParameter(tagname, "tagname");
        NodeList elementsByTagName = getDelegate().getElementsByTagName(tagname);
        Intrinsics.checkNotNullExpressionValue(elementsByTagName, "getElementsByTagName(...)");
        return new WrappingNodeList(elementsByTagName);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        NodeList elementsByTagNameNS = getDelegate().getElementsByTagNameNS(namespaceURI, localName);
        Intrinsics.checkNotNullExpressionValue(elementsByTagNameNS, "getElementsByTagNameNS(...)");
        return new WrappingNodeList(elementsByTagNameNS);
    }

    @Override // org.w3c.dom.Document
    public IElement getElementById(String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        org.w3c.dom.Element elementById = getDelegate().getElementById(elementId);
        Intrinsics.checkNotNullExpressionValue(elementById, "getElementById(...)");
        return NodeImplKt.wrap(elementById);
    }

    @Override // org.w3c.dom.Document
    public IElement createElement(String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        org.w3c.dom.Element createElement = getDelegate().createElement(localName);
        Intrinsics.checkNotNullExpressionValue(createElement, "createElement(...)");
        return new ElementImpl(createElement);
    }

    @Override // org.w3c.dom.Document
    public IDocumentFragment createDocumentFragment() {
        DocumentFragment createDocumentFragment = getDelegate().createDocumentFragment();
        Intrinsics.checkNotNullExpressionValue(createDocumentFragment, "createDocumentFragment(...)");
        return new DocumentFragmentImpl(createDocumentFragment);
    }

    @Override // org.w3c.dom.Document
    public IText createTextNode(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Text createTextNode = getDelegate().createTextNode(data);
        Intrinsics.checkNotNullExpressionValue(createTextNode, "createTextNode(...)");
        return new TextImpl(createTextNode);
    }

    @Override // org.w3c.dom.Document
    public ICDATASection createCDATASection(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        CDATASection createCDATASection = getDelegate().createCDATASection(data);
        Intrinsics.checkNotNullExpressionValue(createCDATASection, "createCDATASection(...)");
        return new CDATASectionImpl(createCDATASection);
    }

    @Override // org.w3c.dom.Document
    public IComment createComment(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Comment createComment = getDelegate().createComment(data);
        Intrinsics.checkNotNullExpressionValue(createComment, "createComment(...)");
        return new CommentImpl(createComment);
    }

    @Override // org.w3c.dom.Document
    public IProcessingInstruction createProcessingInstruction(String target, String data) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(data, "data");
        ProcessingInstruction createProcessingInstruction = getDelegate().createProcessingInstruction(target, data);
        Intrinsics.checkNotNullExpressionValue(createProcessingInstruction, "createProcessingInstruction(...)");
        return new ProcessingInstructionImpl(createProcessingInstruction);
    }

    @Override // org.w3c.dom.Document
    public IAttr createAttribute(String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        Attr createAttribute = getDelegate().createAttribute(localName);
        Intrinsics.checkNotNullExpressionValue(createAttribute, "createAttribute(...)");
        return new AttrImpl(createAttribute);
    }

    @Override // org.w3c.dom.Document
    public IAttr createAttributeNS(String namespace, String qualifiedName) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Attr createAttributeNS = getDelegate().createAttributeNS(namespace, qualifiedName);
        Intrinsics.checkNotNullExpressionValue(createAttributeNS, "createAttributeNS(...)");
        return new AttrImpl(createAttributeNS);
    }

    @Override // org.w3c.dom.Document
    public IElement createElementNS(String namespaceURI, String qualifiedName) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        org.w3c.dom.Element createElementNS = getDelegate().createElementNS(namespaceURI, qualifiedName);
        Intrinsics.checkNotNullExpressionValue(createElementNS, "createElementNS(...)");
        return new ElementImpl(createElementNS);
    }

    @Override // org.w3c.dom.Document
    public EntityReference createEntityReference(String name) {
        EntityReference createEntityReference = getDelegate().createEntityReference(name);
        Intrinsics.checkNotNullExpressionValue(createEntityReference, "createEntityReference(...)");
        return createEntityReference;
    }

    @Override // org.w3c.dom.Document
    public void normalizeDocument() {
        getDelegate().normalizeDocument();
    }

    @Override // org.w3c.dom.Document
    public INode renameNode(Node n, String namespaceURI, String qualifiedName) {
        Intrinsics.checkNotNullParameter(n, "n");
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Node renameNode = getDelegate().renameNode(NodeImplKt.unWrap(n), namespaceURI, qualifiedName);
        Intrinsics.checkNotNullExpressionValue(renameNode, "renameNode(...)");
        return NodeImplKt.wrap(renameNode);
    }

    @Override // org.w3c.dom.Document
    public INode adoptNode(Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        Node adoptNode = getDelegate().adoptNode(NodeImplKt.unWrap(node));
        Intrinsics.checkNotNullExpressionValue(adoptNode, "adoptNode(...)");
        return NodeImplKt.wrap(adoptNode);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Document
    public INode adoptNode(nl.adaptivity.xmlutil.dom2.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        Node adoptNode = getDelegate().adoptNode(NodeImplKt.unWrap(node));
        Intrinsics.checkNotNullExpressionValue(adoptNode, "adoptNode(...)");
        return NodeImplKt.wrap(adoptNode);
    }

    @Override // org.w3c.dom.Document
    public INode importNode(Node node, boolean deep) {
        Intrinsics.checkNotNullParameter(node, "node");
        Node importNode = getDelegate().importNode(NodeImplKt.unWrap(node), deep);
        Intrinsics.checkNotNullExpressionValue(importNode, "importNode(...)");
        return NodeImplKt.wrap(importNode);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Document
    public INode importNode(nl.adaptivity.xmlutil.dom2.Node node, boolean deep) {
        Intrinsics.checkNotNullParameter(node, "node");
        Node importNode = getDelegate().importNode(NodeImplKt.unWrap(node), deep);
        Intrinsics.checkNotNullExpressionValue(importNode, "importNode(...)");
        return NodeImplKt.wrap(importNode);
    }
}