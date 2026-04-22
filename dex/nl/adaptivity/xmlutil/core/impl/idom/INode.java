package nl.adaptivity.xmlutil.core.impl.idom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Node;

/* compiled from: INode.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0000H&J\b\u0010\u000f\u001a\u00020\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H&J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H&J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H&R\u0012\u0010\u0003\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom2/Node;", "delegate", "getDelegate", "()Lorg/w3c/dom/Node;", "getOwnerDocument", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocument;", "getParentNode", "getParentElement", "Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "getFirstChild", "getLastChild", "getPreviousSibling", "getNextSibling", "getNodeType", "", "getAttributes", "Lnl/adaptivity/xmlutil/core/impl/idom/INamedNodeMap;", "getChildNodes", "Lnl/adaptivity/xmlutil/core/impl/idom/INodeList;", "appendChild", "node", "replaceChild", "oldChild", "newChild", "removeChild", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INode extends Node, nl.adaptivity.xmlutil.dom2.Node {
    INode appendChild(INode iNode);

    INode appendChild(nl.adaptivity.xmlutil.dom2.Node node);

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.core.impl.idom.IElement, nl.adaptivity.xmlutil.dom2.Element
    INamedNodeMap getAttributes();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    INodeList getChildNodes();

    Node getDelegate();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    INode getFirstChild();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    INode getLastChild();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    INode getNextSibling();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    short getNodeType();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    IDocument getOwnerDocument();

    IElement getParentElement();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    INode getParentNode();

    @Override // org.w3c.dom.Node, nl.adaptivity.xmlutil.dom2.Node
    INode getPreviousSibling();

    INode removeChild(INode iNode);

    INode removeChild(nl.adaptivity.xmlutil.dom2.Node node);

    INode replaceChild(INode iNode, INode iNode2);

    INode replaceChild(nl.adaptivity.xmlutil.dom2.Node node, nl.adaptivity.xmlutil.dom2.Node node2);

    /* compiled from: INode.kt */
    /* renamed from: nl.adaptivity.xmlutil.core.impl.idom.INode$-CC */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static IElement $default$getParentElement(INode _this) {
            INode parentNode = _this.getParentNode();
            if (parentNode instanceof IElement) {
                return (IElement) parentNode;
            }
            return null;
        }

        public static INamedNodeMap $default$getAttributes(INode _this) {
            return null;
        }

        public static INode $default$appendChild(INode _this, nl.adaptivity.xmlutil.dom2.Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return _this.appendChild((INode) node);
        }

        public static INode $default$replaceChild(INode _this, nl.adaptivity.xmlutil.dom2.Node oldChild, nl.adaptivity.xmlutil.dom2.Node newChild) {
            Intrinsics.checkNotNullParameter(oldChild, "oldChild");
            Intrinsics.checkNotNullParameter(newChild, "newChild");
            return _this.replaceChild((INode) oldChild, (INode) newChild);
        }

        public static INode $default$removeChild(INode _this, nl.adaptivity.xmlutil.dom2.Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return _this.removeChild((INode) node);
        }
    }
}