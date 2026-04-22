package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IAttr;
import nl.adaptivity.xmlutil.core.impl.idom.IElement;
import nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap;
import nl.adaptivity.xmlutil.core.impl.idom.INodeList;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

/* compiled from: ElementImpl.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0014\u0010\u001d\u001a\u00020\u00152\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0016J\u001c\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\"\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0016J\u001a\u0010'\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010!\u001a\u00020\bH\u0016J\u001a\u0010*\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010+\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010,\u001a\u00020)H\u0016J\"\u0010-\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010,\u001a\u00020)H\u0016J \u0010.\u001a\u00020 2\u000e\u0010/\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010,\u001a\u00020)H\u0016¨\u00060"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/ElementImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "delegate", "<init>", "(Lorg/w3c/dom/Element;)V", "getLocalName", "", "getTagName", "getElementsByTagName", "Lnl/adaptivity/xmlutil/core/impl/idom/INodeList;", "qualifiedName", "getElementsByTagNameNS", "namespace", "localName", "getSchemaTypeInfo", "Lorg/w3c/dom/TypeInfo;", "getAttributes", "Lnl/adaptivity/xmlutil/core/impl/idom/INamedNodeMap;", "getAttributeNode", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "getAttributeNodeNS", "setAttributeNode", "attr", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom/Attr;", "Lnl/adaptivity/xmlutil/dom2/Attr;", "setAttributeNodeNS", "removeAttributeNode", "getAttribute", "setAttribute", "", "name", "value", "removeAttribute", "getAttributeNS", "setAttributeNS", "namespaceURI", "removeAttributeNS", "hasAttribute", "", "hasAttributeNS", "setIdAttribute", "isId", "setIdAttributeNS", "setIdAttributeNode", "idAttr", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ElementImpl extends NodeImpl<Element> implements IElement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementImpl(Element delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // nl.adaptivity.xmlutil.core.impl.dom.NodeImpl, org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Element
    public String getLocalName() {
        String localName = getDelegate().getLocalName();
        if (localName == null) {
            String tagName = getDelegate().getTagName();
            Intrinsics.checkNotNullExpressionValue(tagName, "getTagName(...)");
            return tagName;
        }
        return localName;
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public String getTagName() {
        String tagName = getDelegate().getTagName();
        Intrinsics.checkNotNullExpressionValue(tagName, "getTagName(...)");
        return tagName;
    }

    @Override // org.w3c.dom.Element
    public INodeList getElementsByTagName(String qualifiedName) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        NodeList elementsByTagName = getDelegate().getElementsByTagName(qualifiedName);
        Intrinsics.checkNotNullExpressionValue(elementsByTagName, "getElementsByTagName(...)");
        return new WrappingNodeList(elementsByTagName);
    }

    @Override // org.w3c.dom.Element
    public INodeList getElementsByTagNameNS(String namespace, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        NodeList elementsByTagNameNS = getDelegate().getElementsByTagNameNS(namespace, localName);
        Intrinsics.checkNotNullExpressionValue(elementsByTagNameNS, "getElementsByTagNameNS(...)");
        return new WrappingNodeList(elementsByTagNameNS);
    }

    @Override // org.w3c.dom.Element
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo schemaTypeInfo = getDelegate().getSchemaTypeInfo();
        Intrinsics.checkNotNullExpressionValue(schemaTypeInfo, "getSchemaTypeInfo(...)");
        return schemaTypeInfo;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.dom.NodeImpl, org.w3c.dom.Node
    public INamedNodeMap getAttributes() {
        NamedNodeMap attributes = getDelegate().getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        return new WrappingNamedNodeMap(attributes);
    }

    @Override // org.w3c.dom.Element
    public IAttr getAttributeNode(String qualifiedName) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Attr attributeNode = getDelegate().getAttributeNode(qualifiedName);
        if (attributeNode != null) {
            return AttrImplKt.wrapAttr(attributeNode);
        }
        return null;
    }

    @Override // org.w3c.dom.Element
    public IAttr getAttributeNodeNS(String namespace, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        Attr attributeNodeNS = getDelegate().getAttributeNodeNS(namespace, localName);
        if (attributeNodeNS != null) {
            return AttrImplKt.wrapAttr(attributeNodeNS);
        }
        return null;
    }

    @Override // org.w3c.dom.Element
    public IAttr setAttributeNode(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Attr attributeNode = getDelegate().setAttributeNode(NodeImplKt.unWrap(attr));
        if (attributeNode != null) {
            return NodeImplKt.wrap(attributeNode);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.dom2.Element
    public IAttr setAttributeNode(nl.adaptivity.xmlutil.dom2.Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Attr attributeNode = getDelegate().setAttributeNode(NodeImplKt.unWrap(attr));
        if (attributeNode != null) {
            return NodeImplKt.wrap(attributeNode);
        }
        return null;
    }

    @Override // org.w3c.dom.Element
    public IAttr setAttributeNodeNS(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Attr attributeNodeNS = getDelegate().setAttributeNodeNS(NodeImplKt.unWrap(attr));
        if (attributeNodeNS != null) {
            return NodeImplKt.wrap(attributeNodeNS);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.dom2.Element
    public IAttr setAttributeNodeNS(nl.adaptivity.xmlutil.dom2.Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Attr attributeNodeNS = getDelegate().setAttributeNodeNS(NodeImplKt.unWrap(attr));
        if (attributeNodeNS != null) {
            return NodeImplKt.wrap(attributeNodeNS);
        }
        return null;
    }

    @Override // org.w3c.dom.Element
    public IAttr removeAttributeNode(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Attr removeAttributeNode = getDelegate().removeAttributeNode(NodeImplKt.unWrap(attr));
        Intrinsics.checkNotNullExpressionValue(removeAttributeNode, "removeAttributeNode(...)");
        return NodeImplKt.wrap(removeAttributeNode);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Element
    public IAttr removeAttributeNode(nl.adaptivity.xmlutil.dom2.Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Attr removeAttributeNode = getDelegate().removeAttributeNode(NodeImplKt.unWrap(attr));
        Intrinsics.checkNotNullExpressionValue(removeAttributeNode, "removeAttributeNode(...)");
        return NodeImplKt.wrap(removeAttributeNode);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public String getAttribute(String qualifiedName) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        return getDelegate().getAttribute(qualifiedName);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public void setAttribute(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        getDelegate().setAttribute(name, value);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public void removeAttribute(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        getDelegate().removeAttribute(name);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public String getAttributeNS(String namespace, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        return getDelegate().getAttributeNS(namespace, localName);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public void setAttributeNS(String namespaceURI, String qualifiedName, String value) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Intrinsics.checkNotNullParameter(value, "value");
        getDelegate().setAttributeNS(namespaceURI, qualifiedName, value);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public void removeAttributeNS(String namespaceURI, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        getDelegate().removeAttributeNS(namespaceURI, localName);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public boolean hasAttribute(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getDelegate().hasAttribute(name);
    }

    @Override // org.w3c.dom.Element, nl.adaptivity.xmlutil.dom2.Element
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        return getDelegate().hasAttributeNS(namespaceURI, localName);
    }

    @Override // org.w3c.dom.Element
    public void setIdAttribute(String name, boolean isId) {
        Intrinsics.checkNotNullParameter(name, "name");
        getDelegate().setIdAttribute(name, isId);
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        getDelegate().setIdAttributeNS(namespaceURI, localName, isId);
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNode(Attr idAttr, boolean isId) {
        getDelegate().setIdAttributeNode(idAttr, isId);
    }
}