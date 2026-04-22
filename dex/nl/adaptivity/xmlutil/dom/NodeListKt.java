package nl.adaptivity.xmlutil.dom;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: NodeList.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\u001a&\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n*\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0002\u0010\f\u001a \u0010\r\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\u000e*\u00060\u0002j\u0002`\u0003H\u0086\u0002¢\u0006\u0002\u0010\u000f\"#\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"length", "", "Lorg/w3c/dom/NodeList;", "Lnl/adaptivity/xmlutil/dom/NodeList;", "getLength$annotations", "(Lorg/w3c/dom/NodeList;)V", "getLength", "(Lorg/w3c/dom/NodeList;)I", "get", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "index", "(Lorg/w3c/dom/NodeList;I)Lorg/w3c/dom/Node;", "iterator", "", "(Lorg/w3c/dom/NodeList;)Ljava/util/Iterator;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NodeListKt {
    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getLength()", imports = {}))
    public static /* synthetic */ void getLength$annotations(NodeList nodeList) {
    }

    public static final int getLength(NodeList $this$length) {
        Intrinsics.checkNotNullParameter($this$length, "<this>");
        return $this$length.getLength();
    }

    public static final Node get(NodeList $this$get, int index) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        return $this$get.item(index);
    }

    public static final Iterator<Node> iterator(NodeList $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return new NodeListIterator($this$iterator);
    }
}