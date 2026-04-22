package nl.adaptivity.xmlutil.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* compiled from: Node.jvmCommon.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0014\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0003j\u0002`\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0003j\u0002`\u0004H\u0000\u001a!\u0010\b\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004H\u0086\b\u001a*\u0010\n\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\n\u0010\u000b\u001a\u00060\u0003j\u0002`\u00042\n\u0010\f\u001a\u00060\u0003j\u0002`\u0004\u001a\u001e\u0010\r\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004¨\u0006\u000e"}, d2 = {"asAttr", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom/Attr;", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "asElement", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "appendChild", "node", "replaceChild", "oldChild", "newChild", "removeChild", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Node_jvmCommonKt {
    public static final Attr asAttr(Node $this$asAttr) {
        Intrinsics.checkNotNullParameter($this$asAttr, "<this>");
        return (Attr) $this$asAttr;
    }

    public static final Element asElement(Node $this$asElement) {
        Intrinsics.checkNotNullParameter($this$asElement, "<this>");
        return (Element) $this$asElement;
    }

    public static final Node appendChild(Node $this$appendChild, Node node) {
        Intrinsics.checkNotNullParameter($this$appendChild, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Node appendChild = $this$appendChild.appendChild(node);
        Intrinsics.checkNotNullExpressionValue(appendChild, "appendChild(...)");
        return appendChild;
    }

    public static final Node replaceChild(Node $this$replaceChild, Node oldChild, Node newChild) {
        Intrinsics.checkNotNullParameter($this$replaceChild, "<this>");
        Intrinsics.checkNotNullParameter(oldChild, "oldChild");
        Intrinsics.checkNotNullParameter(newChild, "newChild");
        Node replaceChild = $this$replaceChild.replaceChild(oldChild, newChild);
        Intrinsics.checkNotNullExpressionValue(replaceChild, "replaceChild(...)");
        return replaceChild;
    }

    public static final Node removeChild(Node $this$removeChild, Node node) {
        Intrinsics.checkNotNullParameter($this$removeChild, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Node removeChild = $this$removeChild.removeChild(node);
        Intrinsics.checkNotNullExpressionValue(removeChild, "removeChild(...)");
        return removeChild;
    }
}