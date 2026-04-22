package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XmlWriterUtil.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"writeChild", "", "Lnl/adaptivity/xmlutil/XmlWriter;", "node", "Lorg/w3c/dom/Node;", "serialize", "core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "nl/adaptivity/xmlutil/XmlWriterUtil")
public final /* synthetic */ class XmlWriterUtil__XmlWriterUtilKt {
    public static final void writeChild(XmlWriter $this$writeChild, Node node) {
        Intrinsics.checkNotNullParameter($this$writeChild, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        XmlWriterUtil.serialize($this$writeChild, node);
    }

    public static final void serialize(XmlWriter $this$serialize, Node node) {
        Intrinsics.checkNotNullParameter($this$serialize, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        XmlWriterUtil.serialize($this$serialize, XmlStreaming_jvmKt.newReader(XmlStreaming_jvmKt.getXmlStreaming(), node));
    }
}