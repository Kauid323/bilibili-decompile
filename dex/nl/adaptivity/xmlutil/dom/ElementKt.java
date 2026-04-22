package nl.adaptivity.xmlutil.dom;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/* compiled from: Element.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"%\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"%\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007\"\"\u0010\u000b\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007\"\"\u0010\u000e\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"&\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0002j\u0002`\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"namespaceURI", "", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "getNamespaceURI$annotations", "(Lorg/w3c/dom/Element;)V", "getNamespaceURI", "(Lorg/w3c/dom/Element;)Ljava/lang/String;", "prefix", "getPrefix$annotations", "getPrefix", "localName", "getLocalName$annotations", "getLocalName", "tagName", "getTagName$annotations", "getTagName", "attributes", "Lorg/w3c/dom/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom/NamedNodeMap;", "getAttributes$annotations", "getAttributes", "(Lorg/w3c/dom/Element;)Lorg/w3c/dom/NamedNodeMap;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ElementKt {
    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getAttributes()", imports = {}))
    public static /* synthetic */ void getAttributes$annotations(Element element) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getLocalName() ?: getTagName()", imports = {}))
    public static /* synthetic */ void getLocalName$annotations(Element element) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getNamespaceURI()", imports = {}))
    public static /* synthetic */ void getNamespaceURI$annotations(Element element) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getPrefix()", imports = {}))
    public static /* synthetic */ void getPrefix$annotations(Element element) {
    }

    @Deprecated(message = "Use accessor method", replaceWith = @ReplaceWith(expression = "getTagName()", imports = {}))
    public static /* synthetic */ void getTagName$annotations(Element element) {
    }

    public static final String getNamespaceURI(Element $this$namespaceURI) {
        Intrinsics.checkNotNullParameter($this$namespaceURI, "<this>");
        return DomaliassesKt.getNamespaceURI($this$namespaceURI);
    }

    public static final String getPrefix(Element $this$prefix) {
        Intrinsics.checkNotNullParameter($this$prefix, "<this>");
        return DomaliassesKt.getPrefix($this$prefix);
    }

    public static final String getLocalName(Element $this$localName) {
        Intrinsics.checkNotNullParameter($this$localName, "<this>");
        String localName = DomaliassesKt.getLocalName($this$localName);
        return localName == null ? DomaliassesKt.getTagName($this$localName) : localName;
    }

    public static final String getTagName(Element $this$tagName) {
        Intrinsics.checkNotNullParameter($this$tagName, "<this>");
        return DomaliassesKt.getTagName($this$tagName);
    }

    public static final NamedNodeMap getAttributes(Element $this$attributes) {
        Intrinsics.checkNotNullParameter($this$attributes, "<this>");
        return DomaliassesKt.getAttributes($this$attributes);
    }
}