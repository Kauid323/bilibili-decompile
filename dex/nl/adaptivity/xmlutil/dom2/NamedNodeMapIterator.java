package nl.adaptivity.xmlutil.dom2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: NamedNodeMap.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\t\u0010\u000b\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/NamedNodeMapIterator;", "", "Lnl/adaptivity/xmlutil/dom2/Attr;", "map", "Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;", "<init>", "(Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;)V", "pos", "", "hasNext", "", "next", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NamedNodeMapIterator implements Iterator<Attr>, KMappedMarker {
    private final NamedNodeMap map;
    private int pos;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public NamedNodeMapIterator(NamedNodeMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.pos < this.map.getLength();
    }

    @Override // java.util.Iterator
    public Attr next() {
        NamedNodeMap namedNodeMap = this.map;
        int i = this.pos;
        this.pos = i + 1;
        Attr attr = namedNodeMap.get(i);
        if (attr != null) {
            return attr;
        }
        throw new NoSuchElementException("Iterating beyond node map");
    }
}