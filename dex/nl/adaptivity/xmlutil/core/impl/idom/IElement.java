package nl.adaptivity.xmlutil.core.impl.idom;

import kotlin.Metadata;
import nl.adaptivity.xmlutil.dom2.Attr;
import org.w3c.dom.Element;

/* compiled from: IElement.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH&J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0012H&J\u0014\u0010\u0014\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "Lnl/adaptivity/xmlutil/dom2/Element;", "getAttributes", "Lnl/adaptivity/xmlutil/core/impl/idom/INamedNodeMap;", "getAttributeNode", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "qualifiedName", "", "getAttributeNodeNS", "namespace", "localName", "setAttributeNode", "attr", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom/Attr;", "Lnl/adaptivity/xmlutil/dom2/Attr;", "setAttributeNodeNS", "removeAttributeNode", "getElementsByTagName", "Lnl/adaptivity/xmlutil/core/impl/idom/INodeList;", "getElementsByTagNameNS", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IElement extends INode, Element, nl.adaptivity.xmlutil.dom2.Element {
    IAttr getAttributeNode(String str);

    IAttr getAttributeNodeNS(String str, String str2);

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IElement, nl.adaptivity.xmlutil.dom2.Element
    INamedNodeMap getAttributes();

    INodeList getElementsByTagName(String str);

    INodeList getElementsByTagNameNS(String str, String str2);

    IAttr removeAttributeNode(Attr attr);

    IAttr removeAttributeNode(org.w3c.dom.Attr attr);

    IAttr setAttributeNode(Attr attr);

    IAttr setAttributeNode(org.w3c.dom.Attr attr);

    IAttr setAttributeNodeNS(Attr attr);

    IAttr setAttributeNodeNS(org.w3c.dom.Attr attr);
}