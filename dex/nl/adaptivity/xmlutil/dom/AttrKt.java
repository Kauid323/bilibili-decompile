package nl.adaptivity.xmlutil.dom;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/* compiled from: Attr.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"%\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"%\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007\"%\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007\"#\u0010\u000e\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"4\u0010\u0011\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0011\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0015\"+\u0010\u0016\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"namespaceURI", "", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom/Attr;", "getNamespaceURI$annotations", "(Lorg/w3c/dom/Attr;)V", "getNamespaceURI", "(Lorg/w3c/dom/Attr;)Ljava/lang/String;", "prefix", "getPrefix$annotations", "getPrefix", "localName", "getLocalName$annotations", "getLocalName", "name", "getName$annotations", "getName", "value", "getValue$annotations", "getValue", "setValue", "(Lorg/w3c/dom/Attr;Ljava/lang/String;)V", "ownerElement", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "getOwnerElement$annotations", "getOwnerElement", "(Lorg/w3c/dom/Attr;)Lorg/w3c/dom/Element;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AttrKt {
    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getLocalName()", imports = {}))
    public static /* synthetic */ void getLocalName$annotations(Attr attr) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getName()", imports = {}))
    public static /* synthetic */ void getName$annotations(Attr attr) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getNamespaceURI()", imports = {}))
    public static /* synthetic */ void getNamespaceURI$annotations(Attr attr) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getOwnerElement()", imports = {}))
    public static /* synthetic */ void getOwnerElement$annotations(Attr attr) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getPrefix()", imports = {}))
    public static /* synthetic */ void getPrefix$annotations(Attr attr) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility")
    public static /* synthetic */ void getValue$annotations(Attr attr) {
    }

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
        String name = $this$name.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    public static final String getValue(Attr $this$value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        String value = $this$value.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return value;
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