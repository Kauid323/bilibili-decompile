package nl.adaptivity.xmlutil.util.impl;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.SimpleNamespaceContext;
import nl.adaptivity.xmlutil.XmlUtilDeprecatedInternal;

/* compiled from: FragmentNamespaceContext.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0096\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lnl/adaptivity/xmlutil/util/impl/FragmentNamespaceContext;", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "parent", "prefixes", "", "", "namespaces", "<init>", "(Lnl/adaptivity/xmlutil/util/impl/FragmentNamespaceContext;[Ljava/lang/String;[Ljava/lang/String;)V", "getParent", "()Lnl/adaptivity/xmlutil/util/impl/FragmentNamespaceContext;", "delegate", "Lnl/adaptivity/xmlutil/SimpleNamespaceContext;", "getNamespaceURI", "prefix", "getPrefix", "namespaceURI", "iterator", "", "Lnl/adaptivity/xmlutil/Namespace;", "getPrefixes", "getLocalNamespaceUri", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@XmlUtilDeprecatedInternal
public final class FragmentNamespaceContext implements IterableNamespaceContext {
    private final SimpleNamespaceContext delegate;
    private final FragmentNamespaceContext parent;

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public /* synthetic */ IterableNamespaceContext freeze() {
        return IterableNamespaceContext.CC.$default$freeze(this);
    }

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public /* synthetic */ IterableNamespaceContext plus(IterableNamespaceContext iterableNamespaceContext) {
        return IterableNamespaceContext.CC.$default$plus(this, iterableNamespaceContext);
    }

    public FragmentNamespaceContext(FragmentNamespaceContext parent, String[] prefixes, String[] namespaces) {
        Intrinsics.checkNotNullParameter(prefixes, "prefixes");
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        this.parent = parent;
        this.delegate = new SimpleNamespaceContext(prefixes, namespaces);
    }

    public final FragmentNamespaceContext getParent() {
        return this.parent;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String prefix) {
        String uri;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String uri2 = this.delegate.getNamespaceURI(prefix);
        if (Intrinsics.areEqual(uri2, "")) {
            FragmentNamespaceContext fragmentNamespaceContext = this.parent;
            return (fragmentNamespaceContext == null || (uri = fragmentNamespaceContext.getNamespaceURI(prefix)) == null) ? "" : uri;
        }
        return uri2;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        String prefix = this.delegate.getPrefix(namespaceURI);
        if (prefix == null) {
            FragmentNamespaceContext fragmentNamespaceContext = this.parent;
            String prefix2 = fragmentNamespaceContext != null ? fragmentNamespaceContext.getPrefix(namespaceURI) : null;
            return prefix2 == null ? "" : prefix2;
        }
        return prefix;
    }

    @Override // java.lang.Iterable
    public Iterator<Namespace> iterator() {
        if (this.parent == null || !this.parent.iterator().hasNext()) {
            return this.delegate.iterator();
        }
        return this.delegate.size() == 0 ? this.parent.iterator() : SequencesKt.plus(SequencesKt.asSequence(this.parent.iterator()), SequencesKt.asSequence(this.delegate.iterator())).iterator();
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        if (this.parent == null) {
            return this.delegate.getPrefixes(namespaceURI);
        }
        HashSet prefixes = new HashSet();
        Iterator $this$forEach$iv = this.delegate.getPrefixes(namespaceURI);
        while ($this$forEach$iv.hasNext()) {
            Object element$iv = $this$forEach$iv.next();
            String it = (String) element$iv;
            prefixes.add(it);
        }
        for (Object element$iv2 : SequencesKt.filter(SequencesKt.asSequence(this.parent.getPrefixes(namespaceURI)), new Function1() { // from class: nl.adaptivity.xmlutil.util.impl.FragmentNamespaceContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean prefixes$lambda$1;
                prefixes$lambda$1 = FragmentNamespaceContext.getPrefixes$lambda$1(FragmentNamespaceContext.this, (String) obj);
                return Boolean.valueOf(prefixes$lambda$1);
            }
        })) {
            String it2 = (String) element$iv2;
            prefixes.add(it2);
        }
        Iterator<String> it3 = prefixes.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        return it3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getPrefixes$lambda$1(FragmentNamespaceContext this$0, String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this$0.getLocalNamespaceUri(prefix) == null;
    }

    private final String getLocalNamespaceUri(String prefix) {
        Iterable $this$lastOrNull$iv = this.delegate.getIndices();
        Object last$iv = null;
        for (Object obj : $this$lastOrNull$iv) {
            int it = ((Number) obj).intValue();
            if (Intrinsics.areEqual(prefix, this.delegate.getPrefix(it))) {
                last$iv = obj;
            }
        }
        Integer num = (Integer) last$iv;
        if (num != null) {
            int it2 = num.intValue();
            return this.delegate.getNamespaceURI(it2);
        }
        return null;
    }
}