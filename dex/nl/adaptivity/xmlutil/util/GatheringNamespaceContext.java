package nl.adaptivity.xmlutil.util;

import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.NamespaceContext;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XMLConstants;
import nl.adaptivity.xmlutil.XmlUtilInternal;

/* compiled from: GatheringNamespaceContext.kt */
@XmlUtilInternal
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B+\u0012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\r\u001a\u00020\u0006H\u0017R\u0018\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lnl/adaptivity/xmlutil/util/GatheringNamespaceContext;", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "parentContext", "resultMap", "", "", "<init>", "(Ljavax/xml/namespace/NamespaceContext;Ljava/util/Map;)V", "Ljavax/xml/namespace/NamespaceContext;", "getNamespaceURI", "prefix", "getPrefix", "namespaceURI", "getPrefixes", "", "getPrefixesCompat", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GatheringNamespaceContext implements NamespaceContext {
    private final NamespaceContext parentContext;
    private final Map<String, String> resultMap;

    public GatheringNamespaceContext(NamespaceContext parentContext, Map<String, String> resultMap) {
        Intrinsics.checkNotNullParameter(resultMap, "resultMap");
        this.parentContext = parentContext;
        this.resultMap = resultMap;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String prefix) {
        String $this$getNamespaceURI_u24lambda_u240;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        NamespaceContext namespaceContext = this.parentContext;
        if (namespaceContext == null || ($this$getNamespaceURI_u24lambda_u240 = namespaceContext.getNamespaceURI(prefix)) == null) {
            return null;
        }
        if (($this$getNamespaceURI_u24lambda_u240.length() == 0) || Intrinsics.areEqual(prefix, XMLConstants.XMLNS_ATTRIBUTE)) {
            return $this$getNamespaceURI_u24lambda_u240;
        }
        this.resultMap.put(prefix, $this$getNamespaceURI_u24lambda_u240);
        return $this$getNamespaceURI_u24lambda_u240;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String namespaceURI) {
        String $this$getPrefix_u24lambda_u241;
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        NamespaceContext namespaceContext = this.parentContext;
        if (namespaceContext == null || ($this$getPrefix_u24lambda_u241 = namespaceContext.getPrefix(namespaceURI)) == null) {
            return null;
        }
        if (Intrinsics.areEqual(namespaceURI, XMLConstants.XMLNS_ATTRIBUTE_NS_URI) || Intrinsics.areEqual(namespaceURI, XMLConstants.XML_NS_URI)) {
            return $this$getPrefix_u24lambda_u241;
        }
        this.resultMap.put($this$getPrefix_u24lambda_u241, namespaceURI);
        return $this$getPrefix_u24lambda_u241;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        if (this.parentContext == null) {
            return CollectionsKt.emptyList().iterator();
        }
        if (!Intrinsics.areEqual(namespaceURI, XMLConstants.XMLNS_ATTRIBUTE_NS_URI) && !Intrinsics.areEqual(namespaceURI, XMLConstants.XML_NS_URI)) {
            Iterator it = this.parentContext.getPrefixes(namespaceURI);
            while (it.hasNext()) {
                this.resultMap.put(it.next(), namespaceURI);
            }
        }
        return this.parentContext.getPrefixes(namespaceURI);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Just for compatibility", replaceWith = @ReplaceWith(expression = "getPrefixes(namespaceURI", imports = {}))
    public Iterator<String> getPrefixesCompat(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        return getPrefixes(namespaceURI);
    }
}