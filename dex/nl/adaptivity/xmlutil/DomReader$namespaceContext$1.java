package nl.adaptivity.xmlutil;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.dom2.Element;
import nl.adaptivity.xmlutil.dom2.Node;
import nl.adaptivity.xmlutil.util.CommondomutilKt;

/* compiled from: DomReader.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0001H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"nl/adaptivity/xmlutil/DomReader$namespaceContext$1", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "currentElement", "Lnl/adaptivity/xmlutil/dom2/Element;", "getNamespaceURI", "", "prefix", "getPrefix", "namespaceURI", "freeze", "iterator", "", "Lnl/adaptivity/xmlutil/Namespace;", "getPrefixes", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DomReader$namespaceContext$1 implements IterableNamespaceContext {
    private final Element currentElement;

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public /* synthetic */ IterableNamespaceContext plus(IterableNamespaceContext iterableNamespaceContext) {
        return IterableNamespaceContext.CC.$default$plus(this, iterableNamespaceContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DomReader$namespaceContext$1(DomReader $receiver) {
        Node requireCurrent;
        Node $this$parentNode$iv;
        requireCurrent = $receiver.getRequireCurrent();
        Element element = null;
        Element element2 = requireCurrent instanceof Element ? (Element) requireCurrent : null;
        if (element2 == null) {
            $this$parentNode$iv = $receiver.getRequireCurrent();
            Node $this$parentNode$iv2 = $this$parentNode$iv.getParentNode();
            if ($this$parentNode$iv2 instanceof Element) {
                element = (Element) $this$parentNode$iv2;
            }
        } else {
            element = element2;
        }
        this.currentElement = element;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Element element = this.currentElement;
        if (element != null) {
            return CommondomutilKt.myLookupNamespaceURI(element, prefix);
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        Element element = this.currentElement;
        if (element != null) {
            return CommondomutilKt.myLookupPrefix(element, namespaceURI);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public IterableNamespaceContext freeze() {
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<Namespace> iterator() {
        return SequencesKt.sequence(new DomReader$namespaceContext$1$iterator$1(this, null)).iterator();
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        return CollectionsKt.listOfNotNull(getPrefix(namespaceURI)).iterator();
    }
}