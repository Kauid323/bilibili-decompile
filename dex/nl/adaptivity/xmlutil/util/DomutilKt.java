package nl.adaptivity.xmlutil.util;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.dom.NamedNodeMapKt;
import nl.adaptivity.xmlutil.dom.NodeListKt;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

/* compiled from: domutil.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001*\u00060\u0004j\u0002`\u0005H\u0087\u0002¢\u0006\u0002\u0010\u0006\u001a \u0010\u0000\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001*\u00060\u0007j\u0002`\bH\u0087\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"iterator", "", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "Lorg/w3c/dom/NodeList;", "Lnl/adaptivity/xmlutil/dom/NodeList;", "(Lorg/w3c/dom/NodeList;)Ljava/util/Iterator;", "Lorg/w3c/dom/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom/NamedNodeMap;", "(Lorg/w3c/dom/NamedNodeMap;)Ljava/util/Iterator;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DomutilKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the implementation in the dom package", replaceWith = @ReplaceWith(expression = "iterator", imports = {"nl.adaptivity.xmlutil.dom.iterator"}))
    public static final /* synthetic */ Iterator iterator(NodeList $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return NodeListKt.iterator($this$iterator);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the implementation in the dom package", replaceWith = @ReplaceWith(expression = "iterator", imports = {"nl.adaptivity.xmlutil.dom.iterator"}))
    public static final /* synthetic */ Iterator iterator(NamedNodeMap $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return NamedNodeMapKt.iterator($this$iterator);
    }
}