package nl.adaptivity.xmlutil.util.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.NamespaceContext;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.SimpleNamespaceContext;
import nl.adaptivity.xmlutil.XmlEvent;

/* compiled from: javaDomutilImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00112\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\u0000R\u0015\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lnl/adaptivity/xmlutil/util/impl/ExtendingNamespaceContext;", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "parent", "<init>", "(Ljavax/xml/namespace/NamespaceContext;)V", "getParent", "()Ljavax/xml/namespace/NamespaceContext;", "localNamespaces", "", "Lnl/adaptivity/xmlutil/Namespace;", "getNamespaceURI", "", "prefix", "getPrefix", "namespaceURI", "getPrefixes", "", "addNamespace", "", "extend", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtendingNamespaceContext implements NamespaceContext {
    private final List<Namespace> localNamespaces;
    private final NamespaceContext parent;

    public ExtendingNamespaceContext() {
        this(null, 1, null);
    }

    public ExtendingNamespaceContext(NamespaceContext parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
        this.localNamespaces = new ArrayList();
    }

    public /* synthetic */ ExtendingNamespaceContext(SimpleNamespaceContext simpleNamespaceContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SimpleNamespaceContext("", "") : simpleNamespaceContext);
    }

    public final NamespaceContext getParent() {
        return this.parent;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String prefix) {
        Object element$iv;
        String namespaceURI;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Iterable $this$firstOrNull$iv = this.localNamespaces;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Namespace it2 = (Namespace) element$iv;
                if (Intrinsics.areEqual(it2.getPrefix(), prefix)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Namespace namespace = (Namespace) element$iv;
        return (namespace == null || (namespaceURI = namespace.getNamespaceURI()) == null) ? this.parent.getNamespaceURI(prefix) : namespaceURI;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String namespaceURI) {
        Object element$iv;
        String prefix;
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        Iterable $this$firstOrNull$iv = this.localNamespaces;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Namespace it2 = (Namespace) element$iv;
                if (Intrinsics.areEqual(it2.getNamespaceURI(), namespaceURI)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Namespace namespace = (Namespace) element$iv;
        return (namespace == null || (prefix = namespace.getPrefix()) == null) ? this.parent.getPrefix(namespaceURI) : prefix;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(final String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        Set $this$getPrefixes_u24lambda_u245 = SetsKt.createSetBuilder();
        Sequence $this$mapTo$iv = SequencesKt.filter(CollectionsKt.asSequence(this.localNamespaces), new Function1() { // from class: nl.adaptivity.xmlutil.util.impl.ExtendingNamespaceContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean prefixes$lambda$5$lambda$2;
                prefixes$lambda$5$lambda$2 = ExtendingNamespaceContext.getPrefixes$lambda$5$lambda$2(namespaceURI, (Namespace) obj);
                return Boolean.valueOf(prefixes$lambda$5$lambda$2);
            }
        });
        for (Object item$iv : $this$mapTo$iv) {
            Namespace it = (Namespace) item$iv;
            $this$getPrefixes_u24lambda_u245.add(it.getPrefix());
        }
        Iterator $this$forEach$iv = this.parent.getPrefixes(namespaceURI);
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "getPrefixes(...)");
        while ($this$forEach$iv.hasNext()) {
            Object element$iv = $this$forEach$iv.next();
            String it2 = (String) element$iv;
            $this$getPrefixes_u24lambda_u245.add(it2);
        }
        return SetsKt.build($this$getPrefixes_u24lambda_u245).iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getPrefixes$lambda$5$lambda$2(String $namespaceURI, Namespace it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getNamespaceURI(), $namespaceURI);
    }

    public final void addNamespace(String prefix, String namespaceURI) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        this.localNamespaces.add(new XmlEvent.NamespaceImpl(prefix, namespaceURI));
    }

    public final ExtendingNamespaceContext extend() {
        return new ExtendingNamespaceContext(this);
    }
}