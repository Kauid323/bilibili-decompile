package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IAttr;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/* compiled from: AttrImpl.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"wrapAttr", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "Lorg/w3c/dom/Node;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AttrImplKt {
    public static final IAttr wrapAttr(Node $this$wrapAttr) {
        Intrinsics.checkNotNullParameter($this$wrapAttr, "<this>");
        return NodeImplKt.wrap((Attr) $this$wrapAttr);
    }
}