package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Element.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"namespaceURI", "", "Lnl/adaptivity/xmlutil/dom2/Element;", "getNamespaceURI", "(Lnl/adaptivity/xmlutil/dom2/Element;)Ljava/lang/String;", "prefix", "getPrefix", "localName", "getLocalName", "tagName", "getTagName", "attributes", "Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;", "getAttributes", "(Lnl/adaptivity/xmlutil/dom2/Element;)Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ElementKt {
    public static final String getNamespaceURI(Element $this$namespaceURI) {
        Intrinsics.checkNotNullParameter($this$namespaceURI, "<this>");
        return $this$namespaceURI.getNamespaceURI();
    }

    public static final String getPrefix(Element $this$prefix) {
        Intrinsics.checkNotNullParameter($this$prefix, "<this>");
        return $this$prefix.getPrefix();
    }

    public static final String getLocalName(Element $this$localName) {
        Intrinsics.checkNotNullParameter($this$localName, "<this>");
        return $this$localName.getLocalName();
    }

    public static final String getTagName(Element $this$tagName) {
        Intrinsics.checkNotNullParameter($this$tagName, "<this>");
        return $this$tagName.getTagName();
    }

    public static final NamedNodeMap getAttributes(Element $this$attributes) {
        Intrinsics.checkNotNullParameter($this$attributes, "<this>");
        return $this$attributes.getAttributes();
    }
}