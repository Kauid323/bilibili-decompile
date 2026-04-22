package nl.adaptivity.xmlutil.util.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XMLConstants;
import nl.adaptivity.xmlutil.dom.Node_jvmCommonKt;
import nl.adaptivity.xmlutil.util.CommondomutilKt;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* compiled from: javaDomutilImpl.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u000b\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f*\u00060\u000fj\u0002`\u0010H\u0000\u001a\u0018\u0010\u0011\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00060\rj\u0002`\u000eH\u0000\u001a\u0018\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014*\u00060\rj\u0002`\u000eH\u0000\u001a6\u0010\u0015\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f*\u00060\u0016j\u0002`\u00172\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u001a0\u0019H\u0080\bø\u0001\u0000\u001a8\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\f\"\u0004\b\u0000\u0010\u001c*\u00060\u0016j\u0002`\u00172\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u0002H\u001c0\u0019H\u0080\bø\u0001\u0000\u001a,\u0010\u001e\u001a\u00020\b*\u00060\u0016j\u0002`\u00172\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u001a0\u0019H\u0080\bø\u0001\u0000\u001a\u001a\u0010\u001f\u001a\u00020 *\u00060\rj\u0002`\u000e2\b\b\u0002\u0010!\u001a\u00020\"H\u0000\"$\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00060\u0003j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u00020\b*\u00060\u0003j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"firstElementChild", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/dom/Document;", "getFirstElementChild", "(Lorg/w3c/dom/Document;)Lorg/w3c/dom/Element;", "childElementCount", "", "getChildElementCount", "(Lorg/w3c/dom/Document;)I", "asList", "", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "Lorg/w3c/dom/NodeList;", "Lnl/adaptivity/xmlutil/dom/NodeList;", "asElement", "asText", "Lorg/w3c/dom/Text;", "Lnl/adaptivity/xmlutil/dom/Text;", "filter", "Lorg/w3c/dom/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom/NamedNodeMap;", "predicate", "Lkotlin/Function1;", "", "map", "R", "body", "count", "removeUnneededNamespaces", "", "knownNamespaces", "Lnl/adaptivity/xmlutil/util/impl/ExtendingNamespaceContext;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JavaDomutilImplKt {
    public static final Element getFirstElementChild(Document $this$firstElementChild) {
        Intrinsics.checkNotNullParameter($this$firstElementChild, "<this>");
        for (Node c = $this$firstElementChild.getFirstChild(); c != null; c = c.getNextSibling()) {
            if (c instanceof Element) {
                return (Element) c;
            }
        }
        return null;
    }

    public static final int getChildElementCount(Document $this$childElementCount) {
        Intrinsics.checkNotNullParameter($this$childElementCount, "<this>");
        int count = 0;
        for (Node c = $this$childElementCount.getFirstChild(); c != null; c = c.getNextSibling()) {
            if (c instanceof Element) {
                count++;
            }
        }
        return count;
    }

    public static final List<Node> asList(final NodeList $this$asList) {
        Intrinsics.checkNotNullParameter($this$asList, "<this>");
        return new AbstractList<Node>($this$asList) { // from class: nl.adaptivity.xmlutil.util.impl.JavaDomutilImplKt$asList$1
            private final NodeList delegate;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.delegate = $this$asList;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object element) {
                if (element instanceof Node) {
                    return contains((Node) element);
                }
                return false;
            }

            public /* bridge */ boolean contains(Node element) {
                return super.contains((Object) element);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object element) {
                if (element instanceof Node) {
                    return indexOf((Node) element);
                }
                return -1;
            }

            public /* bridge */ int indexOf(Node element) {
                return super.indexOf((Object) element);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object element) {
                if (element instanceof Node) {
                    return lastIndexOf((Node) element);
                }
                return -1;
            }

            public /* bridge */ int lastIndexOf(Node element) {
                return super.lastIndexOf((Object) element);
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.delegate.getLength();
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public Node get(int index) {
                Node item = this.delegate.item(index);
                Intrinsics.checkNotNullExpressionValue(item, "item(...)");
                return item;
            }
        };
    }

    public static final Element asElement(Node $this$asElement) {
        Intrinsics.checkNotNullParameter($this$asElement, "<this>");
        if (CommondomutilKt.isElement($this$asElement)) {
            return (Element) $this$asElement;
        }
        return null;
    }

    public static final Text asText(Node $this$asText) {
        Intrinsics.checkNotNullParameter($this$asText, "<this>");
        if (CommondomutilKt.isText($this$asText)) {
            return (Text) $this$asText;
        }
        return null;
    }

    public static final List<Node> filter(NamedNodeMap $this$filter, Function1<? super Node, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filter, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List result = new ArrayList();
        int l$iv = $this$filter.getLength();
        for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
            Node item = $this$filter.item(idx$iv);
            Intrinsics.checkNotNull(item);
            Attr attr = Node_jvmCommonKt.asAttr(item);
            if (predicate.invoke(attr).booleanValue()) {
                result.add(attr);
            }
        }
        return result;
    }

    public static final <R> List<R> map(NamedNodeMap $this$map, Function1<? super Node, ? extends R> body) {
        Intrinsics.checkNotNullParameter($this$map, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        List result = new ArrayList();
        int l$iv = $this$map.getLength();
        for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
            Node item = $this$map.item(idx$iv);
            Intrinsics.checkNotNull(item);
            Attr attr = Node_jvmCommonKt.asAttr(item);
            result.add(body.invoke(attr));
        }
        return result;
    }

    public static final int count(NamedNodeMap $this$count, Function1<? super Node, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$count, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int count = 0;
        int l$iv = $this$count.getLength();
        for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
            Node item = $this$count.item(idx$iv);
            Intrinsics.checkNotNull(item);
            Attr attr = Node_jvmCommonKt.asAttr(item);
            if (predicate.invoke(attr).booleanValue()) {
                count++;
            }
        }
        return count;
    }

    public static /* synthetic */ void removeUnneededNamespaces$default(Node node, ExtendingNamespaceContext extendingNamespaceContext, int i, Object obj) {
        if ((i & 1) != 0) {
            extendingNamespaceContext = new ExtendingNamespaceContext(null, 1, null);
        }
        removeUnneededNamespaces(node, extendingNamespaceContext);
    }

    public static final void removeUnneededNamespaces(Node $this$removeUnneededNamespaces, ExtendingNamespaceContext knownNamespaces) {
        Intrinsics.checkNotNullParameter($this$removeUnneededNamespaces, "<this>");
        Intrinsics.checkNotNullParameter(knownNamespaces, "knownNamespaces");
        if ($this$removeUnneededNamespaces.getNodeType() == 1) {
            Element elem = (Element) $this$removeUnneededNamespaces;
            List<Attr> toRemove = new ArrayList();
            NamedNodeMap $this$forEachAttr$iv = elem.getAttributes();
            Intrinsics.checkNotNullExpressionValue($this$forEachAttr$iv, "getAttributes(...)");
            int l$iv = $this$forEachAttr$iv.getLength();
            for (int idx$iv = 0; idx$iv < l$iv; idx$iv++) {
                Node item = $this$forEachAttr$iv.item(idx$iv);
                Intrinsics.checkNotNull(item);
                Attr attr = Node_jvmCommonKt.asAttr(item);
                if (Intrinsics.areEqual(attr.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE)) {
                    String knownUri = knownNamespaces.getParent().getNamespaceURI(attr.getLocalName());
                    if (Intrinsics.areEqual(attr.getValue(), knownUri)) {
                        toRemove.add(attr);
                    } else {
                        String localName = attr.getLocalName();
                        Intrinsics.checkNotNullExpressionValue(localName, "getLocalName(...)");
                        String value = attr.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                        knownNamespaces.addNamespace(localName, value);
                    }
                } else if (Intrinsics.areEqual(attr.getPrefix(), "") && Intrinsics.areEqual(attr.getLocalName(), XMLConstants.XMLNS_ATTRIBUTE)) {
                    String knownUri2 = knownNamespaces.getParent().getNamespaceURI("");
                    if (Intrinsics.areEqual(attr.getValue(), knownUri2)) {
                        toRemove.add(attr);
                    } else {
                        String value2 = attr.getValue();
                        Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
                        knownNamespaces.addNamespace("", value2);
                    }
                }
            }
            for (Attr attr2 : toRemove) {
                elem.removeAttributeNode(attr2);
            }
            NodeList childNodes = elem.getChildNodes();
            Intrinsics.checkNotNullExpressionValue(childNodes, "getChildNodes(...)");
            for (Node child : asList(childNodes)) {
                removeUnneededNamespaces(child, knownNamespaces.extend());
            }
        }
    }
}