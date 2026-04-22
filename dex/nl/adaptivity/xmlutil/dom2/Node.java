package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Node.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u0000 #2\u00020\u0001:\u0001#J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\r\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\tH&J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H&J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H&J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/Node;", "", "nodetype", "Lnl/adaptivity/xmlutil/dom2/NodeType;", "getNodetype", "()Lnl/adaptivity/xmlutil/dom2/NodeType;", "getNodeType", "", "getNodeName", "", "getOwnerDocument", "Lnl/adaptivity/xmlutil/dom2/Document;", "getParentNode", "getTextContent", "setTextContent", "", "value", "getChildNodes", "Lnl/adaptivity/xmlutil/dom2/NodeList;", "getFirstChild", "getLastChild", "getPreviousSibling", "getNextSibling", "getParentElement", "Lnl/adaptivity/xmlutil/dom2/Element;", "lookupPrefix", "namespace", "lookupNamespaceURI", "prefix", "appendChild", "node", "replaceChild", "oldChild", "newChild", "removeChild", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = NodeSerializer.class)
public interface Node {
    public static final Companion Companion = Companion.$$INSTANCE;

    Node appendChild(Node node);

    NodeList getChildNodes();

    Node getFirstChild();

    Node getLastChild();

    Node getNextSibling();

    String getNodeName();

    short getNodeType();

    NodeType getNodetype();

    Document getOwnerDocument();

    Element getParentElement();

    Node getParentNode();

    Node getPreviousSibling();

    String getTextContent();

    String lookupNamespaceURI(String str);

    String lookupPrefix(String str);

    Node removeChild(Node node);

    Node replaceChild(Node node, Node node2);

    void setTextContent(String str);

    /* compiled from: Node.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/Node$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnl/adaptivity/xmlutil/dom2/Node;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<Node> serializer() {
            return NodeSerializer.INSTANCE;
        }
    }

    /* compiled from: Node.kt */
    /* renamed from: nl.adaptivity.xmlutil.dom2.Node$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static Element $default$getParentElement(Node _this) {
            Node $this$parentNode$iv = _this.getParentNode();
            if ($this$parentNode$iv instanceof Element) {
                return (Element) $this$parentNode$iv;
            }
            return null;
        }
    }
}