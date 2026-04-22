package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Node.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u0004\u0018\u00010\u0002*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\b\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0002*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000f\"\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0002*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000f\"\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u0002*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000f\"\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u0002*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"nodeType", "", "Lnl/adaptivity/xmlutil/dom2/Node;", "getNodeType", "(Lnl/adaptivity/xmlutil/dom2/Node;)S", "nodeName", "", "getNodeName", "(Lnl/adaptivity/xmlutil/dom2/Node;)Ljava/lang/String;", "ownerDocument", "Lnl/adaptivity/xmlutil/dom2/Document;", "getOwnerDocument", "(Lnl/adaptivity/xmlutil/dom2/Node;)Lnl/adaptivity/xmlutil/dom2/Document;", "parentNode", "getParentNode", "(Lnl/adaptivity/xmlutil/dom2/Node;)Lnl/adaptivity/xmlutil/dom2/Node;", "textContent", "getTextContent", "childNodes", "Lnl/adaptivity/xmlutil/dom2/NodeList;", "getChildNodes", "(Lnl/adaptivity/xmlutil/dom2/Node;)Lnl/adaptivity/xmlutil/dom2/NodeList;", "firstChild", "getFirstChild", "lastChild", "getLastChild", "previousSibling", "getPreviousSibling", "nextSibling", "getNextSibling", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NodeKt {
    public static final short getNodeType(Node $this$nodeType) {
        Intrinsics.checkNotNullParameter($this$nodeType, "<this>");
        return $this$nodeType.getNodeType();
    }

    public static final String getNodeName(Node $this$nodeName) {
        Intrinsics.checkNotNullParameter($this$nodeName, "<this>");
        return $this$nodeName.getNodeName();
    }

    public static final Document getOwnerDocument(Node $this$ownerDocument) {
        Intrinsics.checkNotNullParameter($this$ownerDocument, "<this>");
        return $this$ownerDocument.getOwnerDocument();
    }

    public static final Node getParentNode(Node $this$parentNode) {
        Intrinsics.checkNotNullParameter($this$parentNode, "<this>");
        return $this$parentNode.getParentNode();
    }

    public static final String getTextContent(Node $this$textContent) {
        Intrinsics.checkNotNullParameter($this$textContent, "<this>");
        return $this$textContent.getTextContent();
    }

    public static final NodeList getChildNodes(Node $this$childNodes) {
        Intrinsics.checkNotNullParameter($this$childNodes, "<this>");
        return $this$childNodes.getChildNodes();
    }

    public static final Node getFirstChild(Node $this$firstChild) {
        Intrinsics.checkNotNullParameter($this$firstChild, "<this>");
        return $this$firstChild.getFirstChild();
    }

    public static final Node getLastChild(Node $this$lastChild) {
        Intrinsics.checkNotNullParameter($this$lastChild, "<this>");
        return $this$lastChild.getLastChild();
    }

    public static final Node getPreviousSibling(Node $this$previousSibling) {
        Intrinsics.checkNotNullParameter($this$previousSibling, "<this>");
        return $this$previousSibling.getPreviousSibling();
    }

    public static final Node getNextSibling(Node $this$nextSibling) {
        Intrinsics.checkNotNullParameter($this$nextSibling, "<this>");
        return $this$nextSibling.getNextSibling();
    }
}