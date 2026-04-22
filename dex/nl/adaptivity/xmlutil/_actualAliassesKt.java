package nl.adaptivity.xmlutil;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NamespaceContext.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"prefixesFor", "", "", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "namespaceURI", "(Ljavax/xml/namespace/NamespaceContext;Ljava/lang/String;)Ljava/util/Iterator;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class _actualAliassesKt {
    @Deprecated(message = "No longer needed using JDK>8", replaceWith = @ReplaceWith(expression = "getPrefixes(namespaceURI)", imports = {}))
    public static final Iterator<String> prefixesFor(NamespaceContext $this$prefixesFor, String namespaceURI) {
        Intrinsics.checkNotNullParameter($this$prefixesFor, "<this>");
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        return $this$prefixesFor.getPrefixes(namespaceURI);
    }
}