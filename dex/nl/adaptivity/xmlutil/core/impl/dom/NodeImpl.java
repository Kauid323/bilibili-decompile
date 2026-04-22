package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IDocument;
import nl.adaptivity.xmlutil.core.impl.idom.IElement;
import nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap;
import nl.adaptivity.xmlutil.core.impl.idom.INode;
import nl.adaptivity.xmlutil.core.impl.idom.INodeList;
import nl.adaptivity.xmlutil.dom2.Element;
import nl.adaptivity.xmlutil.dom2.NodeType;
import org.apache.commons.cli.HelpFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/* compiled from: NodeImpl.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0014J\u0010\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u0014J\u001a\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0002J\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020\u001dJ\u001a\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010\u00142\b\u0010.\u001a\u0004\u0018\u00010\u0014J\b\u0010/\u001a\u0004\u0018\u00010\u0014J\b\u00100\u001a\u0004\u0018\u00010\u0014J\u0010\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u00010\u0014J\n\u00103\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u00104\u001a\u00020(J\u0006\u00105\u001a\u00020\u0014J\u000e\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u0002J\u0010\u00108\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0002J\u0010\u00109\u001a\u0004\u0018\u00010\u00142\u0006\u0010:\u001a\u00020\u0014J\u000e\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u0014J\u0010\u0010=\u001a\u0004\u0018\u00010\u00142\u0006\u00102\u001a\u00020\u0014J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0002J\u001a\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u0014J$\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010C\u001a\u00020\u00142\b\u0010D\u001a\u0004\u0018\u00010A2\b\u0010E\u001a\u0004\u0018\u00010FJ\u0010\u0010G\u001a\u0004\u0018\u00010A2\u0006\u0010C\u001a\u00020\u0014J\u000e\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003J\u000e\u0010H\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0002J\u0016\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003J\u0016\u0010J\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0002J\u000e\u0010L\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003J\u000e\u0010L\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u0002J\u0013\u0010M\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010AH\u0096\u0002J\b\u0010N\u001a\u00020OH\u0016R\u001c\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006P"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "N", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "delegate", "<init>", "(Lorg/w3c/dom/Node;)V", "getDelegate$annotations", "()V", "getDelegate", "()Lorg/w3c/dom/Node;", "Lorg/w3c/dom/Node;", "getOwnerDocument", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocument;", "getParentNode", "getFirstChild", "getLastChild", "getPreviousSibling", "getNextSibling", "getNodeName", "", "nodetype", "Lnl/adaptivity/xmlutil/dom2/NodeType;", "getNodetype", "()Lnl/adaptivity/xmlutil/dom2/NodeType;", "getNodeType", "", "getTextContent", "setTextContent", "", "textContent", "getChildNodes", "Lnl/adaptivity/xmlutil/core/impl/idom/INodeList;", "getNodeValue", "setNodeValue", "nodeValue", "insertBefore", "newChild", "refChild", "hasChildNodes", "", "cloneNode", "deep", "normalize", "isSupported", "feature", "version", "getNamespaceURI", "getPrefix", "setPrefix", "prefix", "getLocalName", "hasAttributes", "getBaseURI", "compareDocumentPosition", "other", "isSameNode", "lookupPrefix", "namespace", "isDefaultNamespace", "namespaceURI", "lookupNamespaceURI", "isEqualNode", HelpFormatter.DEFAULT_ARG_NAME, "getFeature", "", "setUserData", "key", "data", "handler", "Lorg/w3c/dom/UserDataHandler;", "getUserData", "appendChild", "node", "replaceChild", "oldChild", "removeChild", "equals", "hashCode", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NodeImpl<N extends Node> implements INode {
    private final N delegate;

    public static /* synthetic */ void getDelegate$annotations() {
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode, nl.adaptivity.xmlutil.dom2.Node
    public /* synthetic */ INode appendChild(nl.adaptivity.xmlutil.dom2.Node node) {
        return INode.CC.$default$appendChild((INode) this, node);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Node
    public /* bridge */ /* synthetic */ nl.adaptivity.xmlutil.dom2.Node appendChild(nl.adaptivity.xmlutil.dom2.Node node) {
        return INode.CC.m1625$default$appendChild((INode) this, node);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode, org.w3c.dom.Node, nl.adaptivity.xmlutil.core.impl.idom.IElement, nl.adaptivity.xmlutil.dom2.Element
    public /* synthetic */ INamedNodeMap getAttributes() {
        return INode.CC.$default$getAttributes((INode) this);
    }

    @Override // org.w3c.dom.Node
    public /* bridge */ /* synthetic */ NamedNodeMap getAttributes() {
        return INode.CC.m1626$default$getAttributes((INode) this);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode, nl.adaptivity.xmlutil.dom2.Node
    public /* synthetic */ IElement getParentElement() {
        return INode.CC.$default$getParentElement((INode) this);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Node
    public /* bridge */ /* synthetic */ Element getParentElement() {
        return INode.CC.m1627$default$getParentElement((INode) this);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode, nl.adaptivity.xmlutil.dom2.Node
    public /* synthetic */ INode removeChild(nl.adaptivity.xmlutil.dom2.Node node) {
        return INode.CC.$default$removeChild((INode) this, node);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Node
    public /* bridge */ /* synthetic */ nl.adaptivity.xmlutil.dom2.Node removeChild(nl.adaptivity.xmlutil.dom2.Node node) {
        return INode.CC.m1628$default$removeChild((INode) this, node);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode, nl.adaptivity.xmlutil.dom2.Node
    public /* synthetic */ INode replaceChild(nl.adaptivity.xmlutil.dom2.Node node, nl.adaptivity.xmlutil.dom2.Node node2) {
        return INode.CC.$default$replaceChild((INode) this, node, node2);
    }

    @Override // nl.adaptivity.xmlutil.dom2.Node
    public /* bridge */ /* synthetic */ nl.adaptivity.xmlutil.dom2.Node replaceChild(nl.adaptivity.xmlutil.dom2.Node node, nl.adaptivity.xmlutil.dom2.Node node2) {
        return INode.CC.m1629$default$replaceChild((INode) this, node, node2);
    }

    public NodeImpl(N delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        N n = (N) NodeImplKt.unWrap(delegate);
        Intrinsics.checkNotNull(n, "null cannot be cast to non-null type N of nl.adaptivity.xmlutil.core.impl.dom.NodeImpl");
        this.delegate = n;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode
    public N getDelegate() {
        return this.delegate;
    }

    @Override // org.w3c.dom.Node
    public final IDocument getOwnerDocument() {
        Document ownerDocument = getDelegate().getOwnerDocument();
        Intrinsics.checkNotNullExpressionValue(ownerDocument, "getOwnerDocument(...)");
        return NodeImplKt.wrap(ownerDocument);
    }

    @Override // org.w3c.dom.Node
    public final INode getParentNode() {
        Node parentNode = getDelegate().getParentNode();
        if (parentNode != null) {
            return NodeImplKt.wrap(parentNode);
        }
        return null;
    }

    @Override // org.w3c.dom.Node
    public final INode getFirstChild() {
        Node firstChild = getDelegate().getFirstChild();
        if (firstChild != null) {
            return NodeImplKt.wrap(firstChild);
        }
        return null;
    }

    @Override // org.w3c.dom.Node
    public final INode getLastChild() {
        Node lastChild = getDelegate().getLastChild();
        if (lastChild != null) {
            return NodeImplKt.wrap(lastChild);
        }
        return null;
    }

    @Override // org.w3c.dom.Node
    public final INode getPreviousSibling() {
        Node previousSibling = getDelegate().getPreviousSibling();
        if (previousSibling != null) {
            return NodeImplKt.wrap(previousSibling);
        }
        return null;
    }

    @Override // org.w3c.dom.Node
    public final INode getNextSibling() {
        Node nextSibling = getDelegate().getNextSibling();
        if (nextSibling != null) {
            return NodeImplKt.wrap(nextSibling);
        }
        return null;
    }

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    public final String getNodeName() {
        String nodeName = getDelegate().getNodeName();
        Intrinsics.checkNotNullExpressionValue(nodeName, "getNodeName(...)");
        return nodeName;
    }

    @Override // nl.adaptivity.xmlutil.dom2.Node
    public final NodeType getNodetype() {
        return NodeType.Companion.invoke(getDelegate().getNodeType());
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode, org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    public final short getNodeType() {
        return getDelegate().getNodeType();
    }

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    public final String getTextContent() {
        return getDelegate().getTextContent();
    }

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    public final void setTextContent(String textContent) {
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        getDelegate().setTextContent(textContent);
    }

    @Override // org.w3c.dom.Node
    public final INodeList getChildNodes() {
        NodeList childNodes = getDelegate().getChildNodes();
        Intrinsics.checkNotNullExpressionValue(childNodes, "getChildNodes(...)");
        return new WrappingNodeList(childNodes);
    }

    @Override // org.w3c.dom.Node
    public final String getNodeValue() {
        String nodeValue = getDelegate().getNodeValue();
        Intrinsics.checkNotNullExpressionValue(nodeValue, "getNodeValue(...)");
        return nodeValue;
    }

    @Override // org.w3c.dom.Node
    public final void setNodeValue(String nodeValue) {
        getDelegate().setNodeValue(nodeValue);
    }

    @Override // org.w3c.dom.Node
    public final INode insertBefore(Node newChild, Node refChild) {
        Node insertBefore = getDelegate().insertBefore(newChild != null ? NodeImplKt.unWrap(newChild) : null, refChild != null ? NodeImplKt.unWrap(refChild) : null);
        Intrinsics.checkNotNullExpressionValue(insertBefore, "insertBefore(...)");
        return NodeImplKt.wrap(insertBefore);
    }

    @Override // org.w3c.dom.Node
    public final boolean hasChildNodes() {
        return getDelegate().hasChildNodes();
    }

    @Override // org.w3c.dom.Node
    public final INode cloneNode(boolean deep) {
        Node cloneNode = getDelegate().cloneNode(deep);
        Intrinsics.checkNotNullExpressionValue(cloneNode, "cloneNode(...)");
        return NodeImplKt.wrap(cloneNode);
    }

    @Override // org.w3c.dom.Node
    public final void normalize() {
        getDelegate().normalize();
    }

    @Override // org.w3c.dom.Node
    public final boolean isSupported(String feature, String version) {
        return getDelegate().isSupported(feature, version);
    }

    @Override // org.w3c.dom.Node
    public final String getNamespaceURI() {
        return getDelegate().getNamespaceURI();
    }

    @Override // org.w3c.dom.Node
    public final String getPrefix() {
        return getDelegate().getPrefix();
    }

    @Override // org.w3c.dom.Node
    public final void setPrefix(String prefix) {
        getDelegate().setPrefix(prefix);
    }

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Element
    public String getLocalName() {
        return getDelegate().getLocalName();
    }

    @Override // org.w3c.dom.Node
    public final boolean hasAttributes() {
        return getDelegate().hasAttributes();
    }

    @Override // org.w3c.dom.Node
    public final String getBaseURI() {
        String baseURI = getDelegate().getBaseURI();
        Intrinsics.checkNotNullExpressionValue(baseURI, "getBaseURI(...)");
        return baseURI;
    }

    @Override // org.w3c.dom.Node
    public final short compareDocumentPosition(Node other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getDelegate().compareDocumentPosition(NodeImplKt.unWrap(other));
    }

    @Override // org.w3c.dom.Node
    public final boolean isSameNode(Node other) {
        return getDelegate().isSameNode(other != null ? NodeImplKt.unWrap(other) : null);
    }

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    public final String lookupPrefix(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        return getDelegate().lookupPrefix(namespace);
    }

    @Override // org.w3c.dom.Node
    public final boolean isDefaultNamespace(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        return getDelegate().isDefaultNamespace(namespaceURI);
    }

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    public final String lookupNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return getDelegate().lookupNamespaceURI(prefix);
    }

    @Override // org.w3c.dom.Node
    public final boolean isEqualNode(Node arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        return getDelegate().isEqualNode(NodeImplKt.unWrap(arg));
    }

    @Override // org.w3c.dom.Node
    public final Object getFeature(String feature, String version) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return getDelegate().getFeature(feature, version);
    }

    @Override // org.w3c.dom.Node
    public final Object setUserData(String key, Object data, UserDataHandler handler) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getDelegate().setUserData(key, data, handler);
    }

    @Override // org.w3c.dom.Node
    public final Object getUserData(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getDelegate().getUserData(key);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode
    public final INode appendChild(INode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        Node appendChild = getDelegate().appendChild(NodeImplKt.unWrap(node));
        Intrinsics.checkNotNullExpressionValue(appendChild, "appendChild(...)");
        return NodeImplKt.wrap(appendChild);
    }

    @Override // org.w3c.dom.Node
    public final INode appendChild(Node newChild) {
        Intrinsics.checkNotNullParameter(newChild, "newChild");
        Node appendChild = getDelegate().appendChild(NodeImplKt.unWrap(newChild));
        Intrinsics.checkNotNullExpressionValue(appendChild, "appendChild(...)");
        return NodeImplKt.wrap(appendChild);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode
    public final INode replaceChild(INode oldChild, INode newChild) {
        Intrinsics.checkNotNullParameter(oldChild, "oldChild");
        Intrinsics.checkNotNullParameter(newChild, "newChild");
        Node replaceChild = getDelegate().replaceChild(NodeImplKt.unWrap(oldChild), NodeImplKt.unWrap(newChild));
        Intrinsics.checkNotNullExpressionValue(replaceChild, "replaceChild(...)");
        return NodeImplKt.wrap(replaceChild);
    }

    @Override // org.w3c.dom.Node
    public final INode replaceChild(Node newChild, Node oldChild) {
        Intrinsics.checkNotNullParameter(newChild, "newChild");
        Intrinsics.checkNotNullParameter(oldChild, "oldChild");
        Node replaceChild = getDelegate().replaceChild(NodeImplKt.unWrap(oldChild), NodeImplKt.unWrap(newChild));
        Intrinsics.checkNotNullExpressionValue(replaceChild, "replaceChild(...)");
        return NodeImplKt.wrap(replaceChild);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INode
    public final INode removeChild(INode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        Node removeChild = getDelegate().removeChild(NodeImplKt.unWrap(node));
        Intrinsics.checkNotNullExpressionValue(removeChild, "removeChild(...)");
        return NodeImplKt.wrap(removeChild);
    }

    @Override // org.w3c.dom.Node
    public final INode removeChild(Node oldChild) {
        Intrinsics.checkNotNullParameter(oldChild, "oldChild");
        Node removeChild = getDelegate().removeChild(NodeImplKt.unWrap(oldChild));
        Intrinsics.checkNotNullExpressionValue(removeChild, "removeChild(...)");
        return NodeImplKt.wrap(removeChild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type nl.adaptivity.xmlutil.core.impl.dom.NodeImpl<*>");
            NodeImpl nodeImpl = (NodeImpl) other;
            return Intrinsics.areEqual(getDelegate(), ((NodeImpl) other).getDelegate());
        }
        return false;
    }

    public int hashCode() {
        return getDelegate().hashCode();
    }
}