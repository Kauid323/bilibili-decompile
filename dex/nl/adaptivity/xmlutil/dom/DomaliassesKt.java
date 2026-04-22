package nl.adaptivity.xmlutil.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;

/* compiled from: domaliasses.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u001a\u001a\u00020\u001b*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0011\u0010\u001d\u001a\u00020\u001e*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0015\u0010\u001f\u001a\u00060 j\u0002`!*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0019\u0010\"\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u001c*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0013\u0010#\u001a\u0004\u0018\u00010\u001e*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0015\u0010$\u001a\u00060\u0019j\u0002`%*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0019\u0010&\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u001c*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0019\u0010'\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u001c*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0019\u0010(\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u001c*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0019\u0010)\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u001c*\u00060\u0001j\u0002`\u001cH\u0086\b\u001a\u0013\u0010*\u001a\u0004\u0018\u00010\u001e*\u00060\u0003j\u0002`+H\u0086\b\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u001e*\u00060\u0003j\u0002`+H\u0086\b\u001a\u0013\u0010-\u001a\u0004\u0018\u00010\u001e*\u00060\u0003j\u0002`+H\u0086\b\u001a\u0011\u0010.\u001a\u00020\u001e*\u00060\u0003j\u0002`+H\u0086\b\u001a\u0011\u0010/\u001a\u00020\u001e*\u00060\u0003j\u0002`+H\u0086\b\u001a\u0019\u00100\u001a\u000201*\u00060\u0003j\u0002`+2\u0006\u00102\u001a\u00020\u001eH\u0086\b\u001a\u0019\u00103\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`4*\u00060\u0003j\u0002`+H\u0086\b\u001a\u0011\u00105\u001a\u00020\u001e*\u00060\u000bj\u0002`6H\u0086\b\u001a\u0019\u00107\u001a\u000201*\u00060\u000bj\u0002`62\u0006\u00102\u001a\u00020\u001eH\u0086\b\u001a\u0015\u00108\u001a\u00060\u0013j\u0002`9*\u00060 j\u0002`!H\u0086\b\u001a\u0019\u0010:\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`;*\u00060 j\u0002`!H\u0086\b\u001a\u0019\u0010<\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`4*\u00060 j\u0002`!H\u0086\b\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u001e*\u00060 j\u0002`!H\u0086\b\u001a\u0010\u0010*\u001a\u0004\u0018\u00010\u001e*\u00060\u0007j\u0002`4\u001a\u0010\u0010,\u001a\u0004\u0018\u00010\u001e*\u00060\u0007j\u0002`4\u001a\u0010\u0010-\u001a\u0004\u0018\u00010\u001e*\u00060\u0007j\u0002`4\u001a\u000e\u0010>\u001a\u00020\u001e*\u00060\u0007j\u0002`4\u001a\u0012\u0010?\u001a\u00060\u0017j\u0002`@*\u00060\u0007j\u0002`4\u001a\u0011\u0010A\u001a\u00020B*\u00060\u0017j\u0002`@H\u0086\b\u001a\u0011\u0010A\u001a\u00020B*\u00060\u0019j\u0002`%H\u0086\b\u001a\u0011\u0010C\u001a\u00020\u001e*\u00060\u0011j\u0002`DH\u0086\b\u001a\u0011\u00105\u001a\u00020\u001e*\u00060\u0011j\u0002`DH\u0086\b\u001a\u0019\u00107\u001a\u000201*\u00060\u0011j\u0002`D2\u0006\u0010E\u001a\u00020\u001eH\u0086\b\"\u0019\u0010F\u001a\u00020G*\u00060 j\u0002`!8F¢\u0006\u0006\u001a\u0004\bH\u0010I*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003*\n\u0010\u0004\"\u00020\u00052\u00020\u0005*\n\u0010\u0006\"\u00020\u00072\u00020\u0007*\n\u0010\b\"\u00020\t2\u00020\t*\n\u0010\n\"\u00020\u000b2\u00020\u000b*\n\u0010\f\"\u00020\r2\u00020\r*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f*\n\u0010\u0010\"\u00020\u00112\u00020\u0011*\n\u0010\u0012\"\u00020\u00132\u00020\u0013*\n\u0010\u0014\"\u00020\u00152\u00020\u0015*\n\u0010\u0016\"\u00020\u00172\u00020\u0017*\n\u0010\u0018\"\u00020\u00192\u00020\u0019¨\u0006J"}, d2 = {"Node", "Lorg/w3c/dom/Node;", "Attr", "Lorg/w3c/dom/Attr;", "DocumentFragment", "Lorg/w3c/dom/DocumentFragment;", "Element", "Lorg/w3c/dom/Element;", "Text", "Lorg/w3c/dom/Text;", "CharacterData", "Lorg/w3c/dom/CharacterData;", "CDATASection", "Lorg/w3c/dom/CDATASection;", "Comment", "Lorg/w3c/dom/Comment;", "ProcessingInstruction", "Lorg/w3c/dom/ProcessingInstruction;", "DOMImplementation", "Lorg/w3c/dom/DOMImplementation;", "DocumentType", "Lorg/w3c/dom/DocumentType;", "NamedNodeMap", "Lorg/w3c/dom/NamedNodeMap;", "NodeList", "Lorg/w3c/dom/NodeList;", "getNodeType", "", "Lnl/adaptivity/xmlutil/dom/Node;", "getNodeName", "", "getOwnerDocument", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/dom/Document;", "getParentNode", "getTextContent", "getChildNodes", "Lnl/adaptivity/xmlutil/dom/NodeList;", "getFirstChild", "getLastChild", "getPreviousSibling", "getNextSibling", "getNamespaceURI", "Lnl/adaptivity/xmlutil/dom/Attr;", "getPrefix", "getLocalName", "getName", "getValue", "setValue", "", "value", "getOwnerElement", "Lnl/adaptivity/xmlutil/dom/Element;", "getData", "Lnl/adaptivity/xmlutil/dom/CharacterData;", "setData", "getImplementation", "Lnl/adaptivity/xmlutil/dom/DOMImplementation;", "getDoctype", "Lnl/adaptivity/xmlutil/dom/DocumentType;", "getDocumentElement", "getInputEncoding", "getTagName", "getAttributes", "Lnl/adaptivity/xmlutil/dom/NamedNodeMap;", "getLength", "", "getTarget", "Lnl/adaptivity/xmlutil/dom/ProcessingInstruction;", "data", "supportsWhitespaceAtToplevel", "", "getSupportsWhitespaceAtToplevel", "(Lorg/w3c/dom/Document;)Z", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DomaliassesKt {
    public static final short getNodeType(Node $this$getNodeType) {
        Intrinsics.checkNotNullParameter($this$getNodeType, "<this>");
        return $this$getNodeType.getNodeType();
    }

    public static final String getNodeName(Node $this$getNodeName) {
        Intrinsics.checkNotNullParameter($this$getNodeName, "<this>");
        String nodeName = $this$getNodeName.getNodeName();
        Intrinsics.checkNotNullExpressionValue(nodeName, "getNodeName(...)");
        return nodeName;
    }

    public static final Document getOwnerDocument(Node $this$getOwnerDocument) {
        Intrinsics.checkNotNullParameter($this$getOwnerDocument, "<this>");
        Document ownerDocument = $this$getOwnerDocument.getOwnerDocument();
        Intrinsics.checkNotNullExpressionValue(ownerDocument, "getOwnerDocument(...)");
        return ownerDocument;
    }

    public static final Node getParentNode(Node $this$getParentNode) {
        Intrinsics.checkNotNullParameter($this$getParentNode, "<this>");
        return $this$getParentNode.getParentNode();
    }

    public static final String getTextContent(Node $this$getTextContent) {
        Intrinsics.checkNotNullParameter($this$getTextContent, "<this>");
        return $this$getTextContent.getTextContent();
    }

    public static final NodeList getChildNodes(Node $this$getChildNodes) {
        Intrinsics.checkNotNullParameter($this$getChildNodes, "<this>");
        NodeList childNodes = $this$getChildNodes.getChildNodes();
        Intrinsics.checkNotNullExpressionValue(childNodes, "getChildNodes(...)");
        return childNodes;
    }

    public static final Node getFirstChild(Node $this$getFirstChild) {
        Intrinsics.checkNotNullParameter($this$getFirstChild, "<this>");
        return $this$getFirstChild.getFirstChild();
    }

    public static final Node getLastChild(Node $this$getLastChild) {
        Intrinsics.checkNotNullParameter($this$getLastChild, "<this>");
        return $this$getLastChild.getLastChild();
    }

    public static final Node getPreviousSibling(Node $this$getPreviousSibling) {
        Intrinsics.checkNotNullParameter($this$getPreviousSibling, "<this>");
        return $this$getPreviousSibling.getPreviousSibling();
    }

    public static final Node getNextSibling(Node $this$getNextSibling) {
        Intrinsics.checkNotNullParameter($this$getNextSibling, "<this>");
        return $this$getNextSibling.getNextSibling();
    }

    public static final String getNamespaceURI(Attr $this$getNamespaceURI) {
        Intrinsics.checkNotNullParameter($this$getNamespaceURI, "<this>");
        return $this$getNamespaceURI.getNamespaceURI();
    }

    public static final String getPrefix(Attr $this$getPrefix) {
        Intrinsics.checkNotNullParameter($this$getPrefix, "<this>");
        return $this$getPrefix.getPrefix();
    }

    public static final String getLocalName(Attr $this$getLocalName) {
        Intrinsics.checkNotNullParameter($this$getLocalName, "<this>");
        return $this$getLocalName.getLocalName();
    }

    public static final String getName(Attr $this$getName) {
        Intrinsics.checkNotNullParameter($this$getName, "<this>");
        String name = $this$getName.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    public static final String getValue(Attr $this$getValue) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        String value = $this$getValue.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return value;
    }

    public static final void setValue(Attr $this$setValue, String value) {
        Intrinsics.checkNotNullParameter($this$setValue, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$setValue.setValue(value);
    }

    public static final Element getOwnerElement(Attr $this$getOwnerElement) {
        Intrinsics.checkNotNullParameter($this$getOwnerElement, "<this>");
        return $this$getOwnerElement.getOwnerElement();
    }

    public static final String getData(CharacterData $this$getData) {
        Intrinsics.checkNotNullParameter($this$getData, "<this>");
        String data = $this$getData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        return data;
    }

    public static final void setData(CharacterData $this$setData, String value) {
        Intrinsics.checkNotNullParameter($this$setData, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$setData.setData(value);
    }

    public static final DOMImplementation getImplementation(Document $this$getImplementation) {
        Intrinsics.checkNotNullParameter($this$getImplementation, "<this>");
        DOMImplementation implementation = $this$getImplementation.getImplementation();
        Intrinsics.checkNotNullExpressionValue(implementation, "getImplementation(...)");
        return implementation;
    }

    public static final DocumentType getDoctype(Document $this$getDoctype) {
        Intrinsics.checkNotNullParameter($this$getDoctype, "<this>");
        return $this$getDoctype.getDoctype();
    }

    public static final Element getDocumentElement(Document $this$getDocumentElement) {
        Intrinsics.checkNotNullParameter($this$getDocumentElement, "<this>");
        return $this$getDocumentElement.getDocumentElement();
    }

    public static final String getInputEncoding(Document $this$getInputEncoding) {
        Intrinsics.checkNotNullParameter($this$getInputEncoding, "<this>");
        return $this$getInputEncoding.getInputEncoding();
    }

    public static final String getNamespaceURI(Element $this$getNamespaceURI) {
        Intrinsics.checkNotNullParameter($this$getNamespaceURI, "<this>");
        return $this$getNamespaceURI.getNamespaceURI();
    }

    public static final String getPrefix(Element $this$getPrefix) {
        Intrinsics.checkNotNullParameter($this$getPrefix, "<this>");
        return $this$getPrefix.getPrefix();
    }

    public static final String getLocalName(Element $this$getLocalName) {
        Intrinsics.checkNotNullParameter($this$getLocalName, "<this>");
        return $this$getLocalName.getLocalName();
    }

    public static final String getTagName(Element $this$getTagName) {
        Intrinsics.checkNotNullParameter($this$getTagName, "<this>");
        String tagName = $this$getTagName.getTagName();
        Intrinsics.checkNotNullExpressionValue(tagName, "getTagName(...)");
        return tagName;
    }

    public static final NamedNodeMap getAttributes(Element $this$getAttributes) {
        Intrinsics.checkNotNullParameter($this$getAttributes, "<this>");
        NamedNodeMap attributes = $this$getAttributes.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        return attributes;
    }

    public static final int getLength(NamedNodeMap $this$getLength) {
        Intrinsics.checkNotNullParameter($this$getLength, "<this>");
        return $this$getLength.getLength();
    }

    public static final int getLength(NodeList $this$getLength) {
        Intrinsics.checkNotNullParameter($this$getLength, "<this>");
        return $this$getLength.getLength();
    }

    public static final String getTarget(ProcessingInstruction $this$getTarget) {
        Intrinsics.checkNotNullParameter($this$getTarget, "<this>");
        String target = $this$getTarget.getTarget();
        Intrinsics.checkNotNullExpressionValue(target, "getTarget(...)");
        return target;
    }

    public static final String getData(ProcessingInstruction $this$getData) {
        Intrinsics.checkNotNullParameter($this$getData, "<this>");
        String data = $this$getData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        return data;
    }

    public static final void setData(ProcessingInstruction $this$setData, String data) {
        Intrinsics.checkNotNullParameter($this$setData, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        $this$setData.setData(data);
    }

    public static final boolean getSupportsWhitespaceAtToplevel(Document $this$supportsWhitespaceAtToplevel) {
        Intrinsics.checkNotNullParameter($this$supportsWhitespaceAtToplevel, "<this>");
        return false;
    }
}