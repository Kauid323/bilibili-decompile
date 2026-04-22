package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Attr.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"(\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0004\"\u0004\b\r\u0010\u000e\"\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"namespaceURI", "", "Lnl/adaptivity/xmlutil/dom2/Attr;", "getNamespaceURI", "(Lnl/adaptivity/xmlutil/dom2/Attr;)Ljava/lang/String;", "prefix", "getPrefix", "localName", "getLocalName", "name", "getName", "value", "getValue", "setValue", "(Lnl/adaptivity/xmlutil/dom2/Attr;Ljava/lang/String;)V", "ownerElement", "Lnl/adaptivity/xmlutil/dom2/Element;", "getOwnerElement", "(Lnl/adaptivity/xmlutil/dom2/Attr;)Lnl/adaptivity/xmlutil/dom2/Element;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AttrKt {
    public static final String getNamespaceURI(Attr $this$namespaceURI) {
        Intrinsics.checkNotNullParameter($this$namespaceURI, "<this>");
        return $this$namespaceURI.getNamespaceURI();
    }

    public static final String getPrefix(Attr $this$prefix) {
        Intrinsics.checkNotNullParameter($this$prefix, "<this>");
        return $this$prefix.getPrefix();
    }

    public static final String getLocalName(Attr $this$localName) {
        Intrinsics.checkNotNullParameter($this$localName, "<this>");
        return $this$localName.getLocalName();
    }

    public static final String getName(Attr $this$name) {
        Intrinsics.checkNotNullParameter($this$name, "<this>");
        return $this$name.getName();
    }

    public static final String getValue(Attr $this$value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        return $this$value.getValue();
    }

    public static final void setValue(Attr $this$value, String value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$value.setValue(value);
    }

    public static final Element getOwnerElement(Attr $this$ownerElement) {
        Intrinsics.checkNotNullParameter($this$ownerElement, "<this>");
        return $this$ownerElement.getOwnerElement();
    }
}