package nl.adaptivity.xmlutil.core.impl;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.XmlEvent;

/* compiled from: NamespaceHolder.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"nl/adaptivity/xmlutil/core/impl/NamespaceHolder$iterator$1", "", "Lnl/adaptivity/xmlutil/Namespace;", "idx", "", "hasNext", "", "next", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NamespaceHolder$iterator$1 implements Iterator<Namespace>, KMappedMarker {
    private int idx;
    final /* synthetic */ NamespaceHolder this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NamespaceHolder$iterator$1(NamespaceHolder $receiver) {
        this.this$0 = $receiver;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int[] iArr;
        int i = this.idx;
        iArr = this.this$0.namespaceCounts;
        return i < iArr[this.this$0.getDepth()];
    }

    @Override // java.util.Iterator
    public Namespace next() {
        String prefix;
        String namespace;
        prefix = this.this$0.getPrefix(this.idx);
        namespace = this.this$0.getNamespace(this.idx);
        XmlEvent.NamespaceImpl namespaceImpl = new XmlEvent.NamespaceImpl(prefix, namespace);
        this.idx++;
        return namespaceImpl;
    }
}