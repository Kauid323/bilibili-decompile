package nl.adaptivity.xmlutil;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlStreaming;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Writer;
import org.w3c.dom.Node;

/* compiled from: XmlStreaming.jvm.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0012\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001a*\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c\"\u0017\u0010\u0000\u001a\u00020\u00018F¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"xmlStreaming", "Lnl/adaptivity/xmlutil/IXmlStreaming;", "getXmlStreaming$annotations", "()V", "getXmlStreaming", "()Lnl/adaptivity/xmlutil/IXmlStreaming;", "_GenericFactory", "Lnl/adaptivity/xmlutil/XmlStreaming$GenericFactory;", "genericFactory", "getGenericFactory$annotations", "(Lnl/adaptivity/xmlutil/IXmlStreaming;)V", "getGenericFactory", "(Lnl/adaptivity/xmlutil/IXmlStreaming;)Lnl/adaptivity/xmlutil/XmlStreaming$GenericFactory;", "newReader", "Lnl/adaptivity/xmlutil/XmlReader;", "node", "Lorg/w3c/dom/Node;", "inputStream", "Ljava/io/InputStream;", "newGenericReader", "newWriter", "Lnl/adaptivity/xmlutil/XmlWriter;", "output", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "repairNamespaces", "", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "writer", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;", "Ljava/io/Writer;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XmlStreaming_jvmKt {
    private static final XmlStreaming.GenericFactory _GenericFactory = new XmlStreaming.GenericFactory();

    @ExperimentalXmlUtilApi
    public static /* synthetic */ void getGenericFactory$annotations(IXmlStreaming iXmlStreaming) {
    }

    public static /* synthetic */ void getXmlStreaming$annotations() {
    }

    public static final IXmlStreaming getXmlStreaming() {
        return XmlStreaming.INSTANCE;
    }

    public static final XmlStreaming.GenericFactory getGenericFactory(IXmlStreaming $this$genericFactory) {
        Intrinsics.checkNotNullParameter($this$genericFactory, "<this>");
        return _GenericFactory;
    }

    public static final XmlReader newReader(IXmlStreaming $this$newReader, Node node) {
        Intrinsics.checkNotNullParameter($this$newReader, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        return new DomReader(node);
    }

    public static final XmlReader newReader(IXmlStreaming $this$newReader, InputStream inputStream) {
        Intrinsics.checkNotNullParameter($this$newReader, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return XmlStreaming.INSTANCE.newReader$core(inputStream);
    }

    public static final XmlReader newGenericReader(IXmlStreaming $this$newGenericReader, InputStream inputStream) {
        Intrinsics.checkNotNullParameter($this$newGenericReader, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return XmlStreaming.newGenericReader$default(XmlStreaming.INSTANCE, inputStream, null, 2, null);
    }

    public static /* synthetic */ XmlWriter newWriter$default(IXmlStreaming iXmlStreaming, Appendable appendable, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return newWriter(iXmlStreaming, appendable, z, xmlDeclMode);
    }

    public static final XmlWriter newWriter(IXmlStreaming $this$newWriter, Appendable output, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter($this$newWriter, "<this>");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return XmlStreaming.INSTANCE.newWriter(output, repairNamespaces, xmlDeclMode);
    }

    public static /* synthetic */ XmlWriter newWriter$default(IXmlStreaming iXmlStreaming, Writer writer, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return newWriter(iXmlStreaming, writer, z, xmlDeclMode);
    }

    public static final XmlWriter newWriter(IXmlStreaming $this$newWriter, Writer writer, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter($this$newWriter, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return XmlStreaming.INSTANCE.newWriter(writer, repairNamespaces, xmlDeclMode);
    }

    public static /* synthetic */ XmlWriter newWriter$default(IXmlStreaming iXmlStreaming, java.io.Writer writer, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return newWriter(iXmlStreaming, writer, z, xmlDeclMode);
    }

    public static final XmlWriter newWriter(IXmlStreaming $this$newWriter, java.io.Writer writer, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter($this$newWriter, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return XmlStreaming.INSTANCE.newWriter(writer, repairNamespaces, xmlDeclMode);
    }
}