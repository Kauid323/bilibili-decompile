package nl.adaptivity.xmlutil.dom;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.util.CommondomutilKt;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: Node.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010,\u001a\n\u0018\u00010-j\u0004\u0018\u0001`.*\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010/\"#\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"#\u0010\b\u001a\u00020\t*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f\"'\u0010\r\u001a\u00060\u000ej\u0002`\u000f*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012\"+\u0010\u0013\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016\"%\u0010\u0017\u001a\u0004\u0018\u00010\t*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\f\"'\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001f\"+\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0016\"+\u0010#\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0016\"+\u0010&\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0016\"+\u0010)\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0016\"*\u00100\u001a\n\u0018\u00010-j\u0004\u0018\u0001`.*\u00060\u0002j\u0002`\u00038GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0005\u001a\u0004\b0\u0010/¨\u00062"}, d2 = {"nodeType", "", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "getNodeType$annotations", "(Lorg/w3c/dom/Node;)V", "getNodeType", "(Lorg/w3c/dom/Node;)S", "nodeName", "", "getNodeName$annotations", "getNodeName", "(Lorg/w3c/dom/Node;)Ljava/lang/String;", "ownerDocument", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/dom/Document;", "getOwnerDocument$annotations", "getOwnerDocument", "(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Document;", "parentNode", "getParentNode$annotations", "getParentNode", "(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;", "textContent", "getTextContent$annotations", "getTextContent", "childNodes", "Lorg/w3c/dom/NodeList;", "Lnl/adaptivity/xmlutil/dom/NodeList;", "getChildNodes$annotations", "getChildNodes", "(Lorg/w3c/dom/Node;)Lorg/w3c/dom/NodeList;", "firstChild", "getFirstChild$annotations", "getFirstChild", "lastChild", "getLastChild$annotations", "getLastChild", "previousSibling", "getPreviousSibling$annotations", "getPreviousSibling", "nextSibling", "getNextSibling$annotations", "getNextSibling", "getParentElement", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Element;", "parentElement", "parentElement$annotations", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NodeKt {
    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getChildNodes()", imports = {}))
    public static /* synthetic */ void getChildNodes$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getFirstChild()", imports = {}))
    public static /* synthetic */ void getFirstChild$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getLastChild()", imports = {}))
    public static /* synthetic */ void getLastChild$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getNextSibling()", imports = {}))
    public static /* synthetic */ void getNextSibling$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getNodeName()", imports = {}))
    public static /* synthetic */ void getNodeName$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getNodeType()", imports = {}))
    public static /* synthetic */ void getNodeType$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getOwnerDocument()", imports = {}))
    public static /* synthetic */ void getOwnerDocument$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getParentNode()", imports = {}))
    public static /* synthetic */ void getParentNode$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getPreviousSibling()", imports = {}))
    public static /* synthetic */ void getPreviousSibling$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getTextContent()", imports = {}))
    public static /* synthetic */ void getTextContent$annotations(Node node) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getParentElement()", imports = {}))
    public static /* synthetic */ void parentElement$annotations(Node node) {
    }

    public static final short getNodeType(Node $this$nodeType) {
        Intrinsics.checkNotNullParameter($this$nodeType, "<this>");
        return $this$nodeType.getNodeType();
    }

    public static final String getNodeName(Node $this$nodeName) {
        Intrinsics.checkNotNullParameter($this$nodeName, "<this>");
        String nodeName = $this$nodeName.getNodeName();
        Intrinsics.checkNotNullExpressionValue(nodeName, "getNodeName(...)");
        return nodeName;
    }

    public static final Document getOwnerDocument(Node $this$ownerDocument) {
        Intrinsics.checkNotNullParameter($this$ownerDocument, "<this>");
        Document ownerDocument = $this$ownerDocument.getOwnerDocument();
        Intrinsics.checkNotNullExpressionValue(ownerDocument, "getOwnerDocument(...)");
        return ownerDocument;
    }

    public static final Node getParentNode(Node $this$parentNode) {
        Intrinsics.checkNotNullParameter($this$parentNode, "<this>");
        Node $this$getParentNode$iv = $this$parentNode.getParentNode();
        return $this$getParentNode$iv;
    }

    public static final String getTextContent(Node $this$textContent) {
        Intrinsics.checkNotNullParameter($this$textContent, "<this>");
        return $this$textContent.getTextContent();
    }

    public static final NodeList getChildNodes(Node $this$childNodes) {
        Intrinsics.checkNotNullParameter($this$childNodes, "<this>");
        NodeList childNodes = $this$childNodes.getChildNodes();
        Intrinsics.checkNotNullExpressionValue(childNodes, "getChildNodes(...)");
        return childNodes;
    }

    public static final Node getFirstChild(Node $this$firstChild) {
        Intrinsics.checkNotNullParameter($this$firstChild, "<this>");
        Node $this$getFirstChild$iv = $this$firstChild.getFirstChild();
        return $this$getFirstChild$iv;
    }

    public static final Node getLastChild(Node $this$lastChild) {
        Intrinsics.checkNotNullParameter($this$lastChild, "<this>");
        Node $this$getLastChild$iv = $this$lastChild.getLastChild();
        return $this$getLastChild$iv;
    }

    public static final Node getPreviousSibling(Node $this$previousSibling) {
        Intrinsics.checkNotNullParameter($this$previousSibling, "<this>");
        Node $this$getPreviousSibling$iv = $this$previousSibling.getPreviousSibling();
        return $this$getPreviousSibling$iv;
    }

    public static final Node getNextSibling(Node $this$nextSibling) {
        Intrinsics.checkNotNullParameter($this$nextSibling, "<this>");
        Node $this$getNextSibling$iv = $this$nextSibling.getNextSibling();
        return $this$getNextSibling$iv;
    }

    public static final Element getParentElement(Node $this$getParentElement) {
        Intrinsics.checkNotNullParameter($this$getParentElement, "<this>");
        Node $this$getParentNode$iv = $this$getParentElement.getParentNode();
        if ($this$getParentNode$iv != null) {
            if (!CommondomutilKt.isElement($this$getParentNode$iv)) {
                $this$getParentNode$iv = null;
            }
            if ($this$getParentNode$iv != null) {
                return Node_jvmCommonKt.asElement($this$getParentNode$iv);
            }
            return null;
        }
        return null;
    }

    public static final Element parentElement(Node $this$parentElement) {
        Intrinsics.checkNotNullParameter($this$parentElement, "<this>");
        return getParentElement($this$parentElement);
    }
}