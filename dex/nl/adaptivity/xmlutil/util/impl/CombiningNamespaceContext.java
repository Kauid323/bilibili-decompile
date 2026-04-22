package nl.adaptivity.xmlutil.util.impl;

import java.util.HashSet;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.SimpleNamespaceContext;
import nl.adaptivity.xmlutil.XmlUtilInternal;

/* compiled from: CombiningNamespaceContext.kt */
@Deprecated(message = "This type is really only for internal use. It will be moved to a better location")
@XmlUtilInternal
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0096\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0011\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0096\u0002R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0016"}, d2 = {"Lnl/adaptivity/xmlutil/util/impl/CombiningNamespaceContext;", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "primary", "secondary", "<init>", "(Lnl/adaptivity/xmlutil/IterableNamespaceContext;Lnl/adaptivity/xmlutil/IterableNamespaceContext;)V", "getPrimary", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getSecondary", "getNamespaceURI", "", "prefix", "getPrefix", "namespaceURI", "freeze", "iterator", "", "Lnl/adaptivity/xmlutil/Namespace;", "getPrefixes", "plus", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CombiningNamespaceContext implements IterableNamespaceContext, NamespaceContext {
    private final IterableNamespaceContext primary;
    private final IterableNamespaceContext secondary;

    public CombiningNamespaceContext(IterableNamespaceContext primary, IterableNamespaceContext secondary) {
        Intrinsics.checkNotNullParameter(primary, "primary");
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        this.primary = primary;
        this.secondary = secondary;
    }

    public final IterableNamespaceContext getPrimary() {
        return this.primary;
    }

    public final IterableNamespaceContext getSecondary() {
        return this.secondary;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String namespaceURI = this.primary.getNamespaceURI(prefix);
        if (namespaceURI == null || Intrinsics.areEqual("", namespaceURI)) {
            return this.secondary.getNamespaceURI(prefix);
        }
        return namespaceURI;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        String prefix = this.primary.getPrefix(namespaceURI);
        if (prefix == null || (Intrinsics.areEqual("", namespaceURI) && Intrinsics.areEqual("", prefix))) {
            return this.secondary.getPrefix(namespaceURI);
        }
        return prefix;
    }

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public IterableNamespaceContext freeze() {
        IterableNamespaceContext combiningNamespaceContext;
        if ((this.primary instanceof SimpleNamespaceContext) && (this.secondary instanceof SimpleNamespaceContext)) {
            return this;
        }
        if (this.secondary.iterator().hasNext()) {
            if (this.primary.iterator().hasNext()) {
                IterableNamespaceContext frozenPrimary = this.primary.freeze();
                IterableNamespaceContext frozenSecondary = this.secondary.freeze();
                if (frozenPrimary == this.primary && Intrinsics.areEqual(frozenSecondary, this.secondary)) {
                    combiningNamespaceContext = this;
                } else {
                    combiningNamespaceContext = new CombiningNamespaceContext(this.primary.freeze(), this.secondary.freeze());
                }
                IterableNamespaceContext frozenPrimary2 = combiningNamespaceContext;
                return frozenPrimary2;
            }
            return this.secondary.freeze();
        }
        return this.primary.freeze();
    }

    @Override // java.lang.Iterable
    public Iterator<Namespace> iterator() {
        return SequencesKt.plus(CollectionsKt.asSequence(this.primary), CollectionsKt.asSequence(this.secondary)).iterator();
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        Iterator prefixes1 = this.primary.getPrefixes(namespaceURI);
        Iterator prefixes2 = this.secondary.getPrefixes(namespaceURI);
        HashSet prefixes = new HashSet();
        while (prefixes1.hasNext()) {
            prefixes.add(prefixes1.next());
        }
        while (prefixes2.hasNext()) {
            prefixes.add(prefixes2.next());
        }
        Iterator<String> it = prefixes.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        return it;
    }

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public IterableNamespaceContext plus(IterableNamespaceContext secondary) {
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        return new CombiningNamespaceContext(this, secondary);
    }
}