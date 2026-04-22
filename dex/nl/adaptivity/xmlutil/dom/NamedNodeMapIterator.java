package nl.adaptivity.xmlutil.dom;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NamedNodeMap.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\rH\u0096\u0002J\u0012\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lnl/adaptivity/xmlutil/dom/NamedNodeMapIterator;", "", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom/Attr;", "map", "Lorg/w3c/dom/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom/NamedNodeMap;", "<init>", "(Lorg/w3c/dom/NamedNodeMap;)V", "Lorg/w3c/dom/NamedNodeMap;", "pos", "", "hasNext", "", "next", "()Lorg/w3c/dom/Attr;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NamedNodeMapIterator implements Iterator<Attr>, KMappedMarker {
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
        int i = this.pos;
        NamedNodeMap $this$getLength$iv = this.map;
        return i < $this$getLength$iv.getLength();
    }

    @Override // java.util.Iterator
    public Attr next() {
        NamedNodeMap namedNodeMap = this.map;
        int i = this.pos;
        this.pos = i + 1;
        Attr attr = NamedNodeMapKt.get(namedNodeMap, i);
        Intrinsics.checkNotNull(attr);
        return Node_jvmCommonKt.asAttr(attr);
    }
}