package nl.adaptivity.xmlutil.dom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: NodeList.kt */
@Deprecated(message = "No longer supported, use dom2 instead", replaceWith = @ReplaceWith(expression = "nl.adaptivity.xmlutil.dom2.NodeListIterator", imports = {"nl.adaptivity.xmlutil.dom2"}))
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\rH\u0096\u0002J\u0012\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lnl/adaptivity/xmlutil/dom/NodeListIterator;", "", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "nodeList", "Lorg/w3c/dom/NodeList;", "Lnl/adaptivity/xmlutil/dom/NodeList;", "<init>", "(Lorg/w3c/dom/NodeList;)V", "Lorg/w3c/dom/NodeList;", "pos", "", "hasNext", "", "next", "()Lorg/w3c/dom/Node;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NodeListIterator implements Iterator<Node>, KMappedMarker {
    private final NodeList nodeList;
    private int pos;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public NodeListIterator(NodeList nodeList) {
        Intrinsics.checkNotNullParameter(nodeList, "nodeList");
        this.nodeList = nodeList;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.pos;
        NodeList $this$getLength$iv = this.nodeList;
        return i < $this$getLength$iv.getLength();
    }

    @Override // java.util.Iterator
    public Node next() {
        NodeList nodeList = this.nodeList;
        int i = this.pos;
        this.pos = i + 1;
        Node item = nodeList.item(i);
        if (item != null) {
            return item;
        }
        throw new NoSuchElementException("No item found in the iterator");
    }
}