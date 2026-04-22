package nl.adaptivity.xmlutil.core.impl;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.SimpleNamespaceContext;

/* compiled from: NamespaceHolder.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0001H\u0016J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"nl/adaptivity/xmlutil/core/impl/NamespaceHolder$namespaceContext$1", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceURI", "", "prefix", "getPrefix", "namespaceURI", "freeze", "iterator", "", "Lnl/adaptivity/xmlutil/Namespace;", "getPrefixes", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NamespaceHolder$namespaceContext$1 implements IterableNamespaceContext {
    final /* synthetic */ NamespaceHolder this$0;

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public /* synthetic */ IterableNamespaceContext plus(IterableNamespaceContext iterableNamespaceContext) {
        return IterableNamespaceContext.CC.$default$plus(this, iterableNamespaceContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NamespaceHolder$namespaceContext$1(NamespaceHolder $receiver) {
        this.this$0 = $receiver;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this.this$0.getNamespaceUri(prefix);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        return this.this$0.getPrefix(namespaceURI);
    }

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public IterableNamespaceContext freeze() {
        String[] strArr;
        strArr = this.this$0.nameSpaces;
        return new SimpleNamespaceContext((String[]) ArraysKt.copyOfRange(strArr, 0, this.this$0.getTotalNamespaceCount() * 2));
    }

    @Override // java.lang.Iterable
    public Iterator<Namespace> iterator() {
        return this.this$0.iterator();
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(final String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        Sequence asSequence = CollectionsKt.asSequence(RangesKt.downTo(this.this$0.getTotalNamespaceCount() - 1, 0));
        final NamespaceHolder namespaceHolder = this.this$0;
        Sequence filter = SequencesKt.filter(asSequence, new Function1() { // from class: nl.adaptivity.xmlutil.core.impl.NamespaceHolder$namespaceContext$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean prefixes$lambda$0;
                prefixes$lambda$0 = NamespaceHolder$namespaceContext$1.getPrefixes$lambda$0(NamespaceHolder.this, namespaceURI, ((Integer) obj).intValue());
                return Boolean.valueOf(prefixes$lambda$0);
            }
        });
        final NamespaceHolder namespaceHolder2 = this.this$0;
        return SequencesKt.map(filter, new Function1() { // from class: nl.adaptivity.xmlutil.core.impl.NamespaceHolder$namespaceContext$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String access$getPrefix;
                access$getPrefix = NamespaceHolder.access$getPrefix(NamespaceHolder.this, ((Integer) obj).intValue());
                return access$getPrefix;
            }
        }).iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getPrefixes$lambda$0(NamespaceHolder this$0, String $namespaceURI, int it) {
        String namespace;
        namespace = this$0.getNamespace(it);
        return Intrinsics.areEqual(namespace, $namespaceURI);
    }
}