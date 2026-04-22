package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.KtXmlWriter;
import nl.adaptivity.xmlutil.core.XmlVersion;

/* compiled from: XmlStreaming.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"newGenericWriter", "Lnl/adaptivity/xmlutil/core/KtXmlWriter;", "Lnl/adaptivity/xmlutil/IXmlStreaming;", "output", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "isRepairNamespaces", "", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XmlStreamingKt {
    public static /* synthetic */ KtXmlWriter newGenericWriter$default(IXmlStreaming iXmlStreaming, Appendable appendable, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return newGenericWriter(iXmlStreaming, appendable, z, xmlDeclMode);
    }

    public static final KtXmlWriter newGenericWriter(IXmlStreaming $this$newGenericWriter, Appendable output, boolean isRepairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter($this$newGenericWriter, "<this>");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return new KtXmlWriter(output, isRepairNamespaces, xmlDeclMode, (XmlVersion) null, 8, (DefaultConstructorMarker) null);
    }
}