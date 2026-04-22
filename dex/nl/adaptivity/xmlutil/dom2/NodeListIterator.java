package nl.adaptivity.xmlutil.dom2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import nl.adaptivity.xmlutil.dom2.Node;
import nl.adaptivity.xmlutil.dom2.NodeList;

/* compiled from: NodeList.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\rH\u0096\u0002J\u000e\u0010\u000e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/NodeListIterator;", "L", "Lnl/adaptivity/xmlutil/dom2/NodeList;", "N", "Lnl/adaptivity/xmlutil/dom2/Node;", "", "nodeList", "<init>", "(Lnl/adaptivity/xmlutil/dom2/NodeList;)V", "Lnl/adaptivity/xmlutil/dom2/NodeList;", "pos", "", "hasNext", "", "next", "()Lnl/adaptivity/xmlutil/dom2/Node;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NodeListIterator<L extends NodeList, N extends Node> implements Iterator<N>, KMappedMarker {
    private final L nodeList;
    private int pos;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public NodeListIterator(L nodeList) {
        Intrinsics.checkNotNullParameter(nodeList, "nodeList");
        this.nodeList = nodeList;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.pos < this.nodeList.getLength();
    }

    @Override // java.util.Iterator
    public N next() {
        L l = this.nodeList;
        int i = this.pos;
        this.pos = i + 1;
        N n = (N) l.item(i);
        if (!(n instanceof Node)) {
            n = null;
        }
        if (n != null) {
            return n;
        }
        throw new NoSuchElementException("No item found in the iterator");
    }
}