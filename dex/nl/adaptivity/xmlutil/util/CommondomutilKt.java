package nl.adaptivity.xmlutil.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nl.adaptivity.xmlutil.XMLConstants;
import nl.adaptivity.xmlutil.XmlUtil;
import nl.adaptivity.xmlutil.dom.Document_jvmKt;
import nl.adaptivity.xmlutil.dom.DomaliassesKt;
import nl.adaptivity.xmlutil.dom.Node_jvmCommonKt;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: commondomutil.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\b\u001a1\u0010\u0012\u001a\u00020\u0013*\u00060\u0014j\u0002`\u00152\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\u00130\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a$\u0010\u0012\u001a\u00020\u0013*\u00020\u001b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00130\u0017H\u0080\bø\u0001\u0000\u001a\u0015\u0010\u001d\u001a\u00020\u0013*\u00060\u000bj\u0002`\fH\u0000¢\u0006\u0002\u0010\u000e\u001a;\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u001f*\u00060\u0014j\u0002`\u00152\u0016\u0010 \u001a\u0012\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\n0\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010!\u001a*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001f*\u00020\u001b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n0\u0017H\u0080\bø\u0001\u0000\u001a\u001f\u0010\"\u001a\u0004\u0018\u00010#*\u00060\u000bj\u0002`\f2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0002\u0010%\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010#*\u00020&2\u0006\u0010$\u001a\u00020#H\u0000\u001a-\u0010'\u001a\u0004\u0018\u00010#*\u00060\u0001j\u0002`\u00022\u0006\u0010$\u001a\u00020#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0)H\u0002¢\u0006\u0002\u0010*\u001a$\u0010'\u001a\u0004\u0018\u00010#*\u00020+2\u0006\u0010$\u001a\u00020#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0)H\u0002\u001a\u001f\u0010,\u001a\u0004\u0018\u00010#*\u00060\u000bj\u0002`\f2\u0006\u0010-\u001a\u00020#H\u0000¢\u0006\u0002\u0010%\u001a\u0016\u0010,\u001a\u0004\u0018\u00010#*\u00020&2\u0006\u0010-\u001a\u00020#H\u0000\"\"\u0010\t\u001a\u00020\n*\u00060\u000bj\u0002`\f8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000f\"\"\u0010\u0010\u001a\u00020\n*\u00060\u000bj\u0002`\f8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2 = {"createElement", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/dom/Document;", "name", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "(Lorg/w3c/dom/Document;Ljavax/xml/namespace/QName;)Lorg/w3c/dom/Element;", "isElement", "", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "isElement$annotations", "(Lorg/w3c/dom/Node;)V", "(Lorg/w3c/dom/Node;)Z", "isText", "isText$annotations", "forEachAttr", "", "Lorg/w3c/dom/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom/NamedNodeMap;", "body", "Lkotlin/Function1;", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom/Attr;", "(Lorg/w3c/dom/NamedNodeMap;Lkotlin/jvm/functions/Function1;)V", "Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom2/Attr;", "removeElementChildren", "filterTyped", "", "predicate", "(Lorg/w3c/dom/NamedNodeMap;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "myLookupPrefix", "", "namespaceUri", "(Lorg/w3c/dom/Node;Ljava/lang/String;)Ljava/lang/String;", "Lnl/adaptivity/xmlutil/dom2/Node;", "myLookupPrefixImpl", "seenPrefixes", "", "(Lorg/w3c/dom/Element;Ljava/lang/String;Ljava/util/Set;)Ljava/lang/String;", "Lnl/adaptivity/xmlutil/dom2/Element;", "myLookupNamespaceURI", "prefix", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CommondomutilKt {
    public static /* synthetic */ void isElement$annotations(Node node) {
    }

    public static /* synthetic */ void isText$annotations(Node node) {
    }

    public static final Element createElement(Document $this$createElement, QName name) {
        Intrinsics.checkNotNullParameter($this$createElement, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return Document_jvmKt.createElementNS($this$createElement, name.getNamespaceURI(), XmlUtil.toCName(name));
    }

    public static final boolean isElement(Node $this$isElement) {
        Intrinsics.checkNotNullParameter($this$isElement, "<this>");
        return $this$isElement.getNodeType() == 1;
    }

    public static final boolean isText(Node $this$isText) {
        Intrinsics.checkNotNullParameter($this$isText, "<this>");
        short nodeType = $this$isText.getNodeType();
        if (nodeType == 1 || nodeType == 4) {
            return true;
        }
        return false;
    }

    public static final void forEachAttr(NamedNodeMap $this$forEachAttr, Function1<? super Attr, Unit> body) {
        Intrinsics.checkNotNullParameter($this$forEachAttr, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        int l = $this$forEachAttr.getLength();
        for (int idx = 0; idx < l; idx++) {
            Node item = $this$forEachAttr.item(idx);
            Intrinsics.checkNotNull(item);
            body.invoke(Node_jvmCommonKt.asAttr(item));
        }
    }

    public static final void forEachAttr(nl.adaptivity.xmlutil.dom2.NamedNodeMap $this$forEachAttr, Function1<? super nl.adaptivity.xmlutil.dom2.Attr, Unit> body) {
        Intrinsics.checkNotNullParameter($this$forEachAttr, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        int l = $this$forEachAttr.getLength();
        for (int idx = 0; idx < l; idx++) {
            nl.adaptivity.xmlutil.dom2.Attr item = $this$forEachAttr.item(idx);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Attr");
            body.invoke(item);
        }
    }

    public static final void removeElementChildren(Node $this$removeElementChildren) {
        Intrinsics.checkNotNullParameter($this$removeElementChildren, "<this>");
        Node cur = $this$removeElementChildren.getFirstChild();
        while (cur != null) {
            Node $this$getNextSibling$iv = cur;
            Node $this$getNextSibling$iv2 = $this$getNextSibling$iv.getNextSibling();
            if (isElement(cur)) {
                Node_jvmCommonKt.removeChild($this$removeElementChildren, cur);
            }
            cur = $this$getNextSibling$iv2;
        }
    }

    public static final List<Attr> filterTyped(NamedNodeMap $this$filterTyped, Function1<? super Attr, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterTyped, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List result = new ArrayList();
        int l$iv = $this$filterTyped.getLength();
        for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
            Node item = $this$filterTyped.item(idx$iv);
            Intrinsics.checkNotNull(item);
            Attr attr = Node_jvmCommonKt.asAttr(item);
            if (predicate.invoke(attr).booleanValue()) {
                result.add(attr);
            }
        }
        return result;
    }

    public static final List<nl.adaptivity.xmlutil.dom2.Attr> filterTyped(nl.adaptivity.xmlutil.dom2.NamedNodeMap $this$filterTyped, Function1<? super nl.adaptivity.xmlutil.dom2.Attr, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterTyped, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List result = new ArrayList();
        int l$iv = $this$filterTyped.getLength();
        for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
            nl.adaptivity.xmlutil.dom2.Attr attr = $this$filterTyped.item(idx$iv);
            Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Attr");
            if (predicate.invoke(attr).booleanValue()) {
                result.add(attr);
            }
        }
        return result;
    }

    public static final String myLookupPrefix(Node $this$myLookupPrefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter($this$myLookupPrefix, "<this>");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        if ($this$myLookupPrefix.getNodeType() != 1) {
            return null;
        }
        return myLookupPrefixImpl(Node_jvmCommonKt.asElement($this$myLookupPrefix), namespaceUri, new LinkedHashSet());
    }

    public static final String myLookupPrefix(nl.adaptivity.xmlutil.dom2.Node $this$myLookupPrefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter($this$myLookupPrefix, "<this>");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        nl.adaptivity.xmlutil.dom2.Element element = $this$myLookupPrefix instanceof nl.adaptivity.xmlutil.dom2.Element ? (nl.adaptivity.xmlutil.dom2.Element) $this$myLookupPrefix : null;
        if (element != null) {
            return myLookupPrefixImpl(element, namespaceUri, new LinkedHashSet());
        }
        return null;
    }

    private static final String myLookupPrefixImpl(Element $this$myLookupPrefixImpl, String namespaceUri, Set<String> set) {
        NamedNodeMap $this$forEachAttr$iv = DomaliassesKt.getAttributes($this$myLookupPrefixImpl);
        int l$iv = $this$forEachAttr$iv.getLength();
        int idx$iv = 0;
        while (true) {
            boolean z = false;
            if (idx$iv >= l$iv) {
                Node $this$getParentNode$iv = $this$myLookupPrefixImpl.getParentNode();
                Short valueOf = $this$getParentNode$iv != null ? Short.valueOf($this$getParentNode$iv.getNodeType()) : null;
                if (valueOf != null && valueOf.shortValue() == 1) {
                    z = true;
                }
                if (z) {
                    Node $this$getParentNode$iv2 = $this$myLookupPrefixImpl.getParentNode();
                    Intrinsics.checkNotNull($this$getParentNode$iv2);
                    return myLookupPrefixImpl(Node_jvmCommonKt.asElement($this$getParentNode$iv2), namespaceUri, set);
                }
                return null;
            }
            Node item = $this$forEachAttr$iv.item(idx$iv);
            Intrinsics.checkNotNull(item);
            Attr attr = Node_jvmCommonKt.asAttr(item);
            if (Intrinsics.areEqual(attr.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE)) {
                String value = attr.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                if (Intrinsics.areEqual(value, namespaceUri) && !CollectionsKt.contains(set, attr.getLocalName())) {
                    return attr.getLocalName();
                }
                String localName = attr.getLocalName();
                if (localName == null) {
                    String name = attr.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    localName = name;
                }
                set.add(localName);
            } else {
                String prefix = attr.getPrefix();
                if (prefix == null || StringsKt.isBlank(prefix)) {
                    z = true;
                }
                if (z && Intrinsics.areEqual(attr.getLocalName(), XMLConstants.XMLNS_ATTRIBUTE)) {
                    String value2 = attr.getValue();
                    Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
                    if (Intrinsics.areEqual(value2, namespaceUri) && !CollectionsKt.contains(set, attr.getLocalName())) {
                        return "";
                    }
                    set.add("");
                }
            }
            idx$iv++;
        }
    }

    private static final String myLookupPrefixImpl(nl.adaptivity.xmlutil.dom2.Element $this$myLookupPrefixImpl, String namespaceUri, Set<String> set) {
        nl.adaptivity.xmlutil.dom2.NamedNodeMap $this$forEachAttr$iv = $this$myLookupPrefixImpl.getAttributes();
        int l$iv = $this$forEachAttr$iv.getLength();
        for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
            nl.adaptivity.xmlutil.dom2.Attr attr = $this$forEachAttr$iv.item(idx$iv);
            Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Attr");
            if (Intrinsics.areEqual(attr.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE)) {
                if (Intrinsics.areEqual(attr.getValue(), namespaceUri) && !CollectionsKt.contains(set, attr.getLocalName())) {
                    return attr.getLocalName();
                }
                String localName = attr.getLocalName();
                if (localName == null) {
                    localName = attr.getName();
                }
                set.add(localName);
            } else {
                String prefix = attr.getPrefix();
                if ((prefix == null || StringsKt.isBlank(prefix)) && Intrinsics.areEqual(attr.getLocalName(), XMLConstants.XMLNS_ATTRIBUTE)) {
                    if (Intrinsics.areEqual(attr.getValue(), namespaceUri) && !CollectionsKt.contains(set, attr.getLocalName())) {
                        return "";
                    }
                    set.add("");
                }
            }
        }
        nl.adaptivity.xmlutil.dom2.Node parentNode = $this$myLookupPrefixImpl.getParentNode();
        nl.adaptivity.xmlutil.dom2.Element element = parentNode instanceof nl.adaptivity.xmlutil.dom2.Element ? (nl.adaptivity.xmlutil.dom2.Element) parentNode : null;
        if (element != null) {
            return myLookupPrefixImpl(element, namespaceUri, set);
        }
        return null;
    }

    public static final String myLookupNamespaceURI(Node $this$myLookupNamespaceURI, String prefix) {
        Intrinsics.checkNotNullParameter($this$myLookupNamespaceURI, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if ($this$myLookupNamespaceURI.getNodeType() != 1) {
            return null;
        }
        NamedNodeMap $this$filterTyped$iv = DomaliassesKt.getAttributes(Node_jvmCommonKt.asElement($this$myLookupNamespaceURI));
        List result$iv = new ArrayList();
        int l$iv$iv = $this$filterTyped$iv.getLength();
        for (int idx$iv$iv = 0; idx$iv$iv < l$iv$iv; idx$iv$iv++) {
            Node item = $this$filterTyped$iv.item(idx$iv$iv);
            Intrinsics.checkNotNull(item);
            Attr attr$iv = Node_jvmCommonKt.asAttr(item);
            if ((Intrinsics.areEqual(prefix, "") && Intrinsics.areEqual(attr$iv.getLocalName(), XMLConstants.XMLNS_ATTRIBUTE)) || (Intrinsics.areEqual(attr$iv.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE) && Intrinsics.areEqual(attr$iv.getLocalName(), prefix))) {
                result$iv.add(attr$iv);
            }
        }
        Attr $this$getValue$iv = (Attr) CollectionsKt.firstOrNull((List<? extends Object>) result$iv);
        if ($this$getValue$iv != null) {
            String value = $this$getValue$iv.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            if (value != null) {
                return value;
            }
        }
        Node $this$getParentNode$iv = $this$myLookupNamespaceURI.getParentNode();
        if ($this$getParentNode$iv != null) {
            return myLookupNamespaceURI($this$getParentNode$iv, prefix);
        }
        return null;
    }

    public static final String myLookupNamespaceURI(nl.adaptivity.xmlutil.dom2.Node $this$myLookupNamespaceURI, String prefix) {
        String value;
        Intrinsics.checkNotNullParameter($this$myLookupNamespaceURI, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if ($this$myLookupNamespaceURI instanceof nl.adaptivity.xmlutil.dom2.Element) {
            nl.adaptivity.xmlutil.dom2.NamedNodeMap $this$filterTyped$iv = ((nl.adaptivity.xmlutil.dom2.Element) $this$myLookupNamespaceURI).getAttributes();
            List result$iv = new ArrayList();
            int l$iv$iv = $this$filterTyped$iv.getLength();
            for (int idx$iv$iv = 0; idx$iv$iv < l$iv$iv; idx$iv$iv++) {
                nl.adaptivity.xmlutil.dom2.Attr attr$iv = $this$filterTyped$iv.item(idx$iv$iv);
                Intrinsics.checkNotNull(attr$iv, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Attr");
                if ((Intrinsics.areEqual(prefix, "") && Intrinsics.areEqual(attr$iv.getLocalName(), XMLConstants.XMLNS_ATTRIBUTE)) || (Intrinsics.areEqual(attr$iv.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE) && Intrinsics.areEqual(attr$iv.getLocalName(), prefix))) {
                    result$iv.add(attr$iv);
                }
            }
            nl.adaptivity.xmlutil.dom2.Attr attr = (nl.adaptivity.xmlutil.dom2.Attr) CollectionsKt.firstOrNull((List<? extends Object>) result$iv);
            if (attr == null || (value = attr.getValue()) == null) {
                nl.adaptivity.xmlutil.dom2.Node parentNode = $this$myLookupNamespaceURI.getParentNode();
                if (parentNode != null) {
                    return myLookupNamespaceURI(parentNode, prefix);
                }
                return null;
            }
            return value;
        }
        return null;
    }
}