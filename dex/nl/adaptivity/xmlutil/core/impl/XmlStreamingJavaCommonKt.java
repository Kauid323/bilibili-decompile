package nl.adaptivity.xmlutil.core.impl;

import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.IXmlStreaming;
import nl.adaptivity.xmlutil.XmlDeclMode;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlStreaming;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Writer;

/* compiled from: XmlStreamingJavaCommon.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u001a\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0015"}, d2 = {"newWriter", "Lnl/adaptivity/xmlutil/XmlWriter;", "Lnl/adaptivity/xmlutil/IXmlStreaming;", "result", "Ljavax/xml/transform/Result;", "repairNamespaces", "", "outputStream", "Ljava/io/OutputStream;", "encoding", "", "writer", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "newReader", "Lnl/adaptivity/xmlutil/XmlReader;", "inputStream", "Ljava/io/InputStream;", "source", "Ljavax/xml/transform/Source;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XmlStreamingJavaCommonKt {
    public static /* synthetic */ XmlWriter newWriter$default(IXmlStreaming iXmlStreaming, Result result, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return newWriter(iXmlStreaming, result, z);
    }

    public static final XmlWriter newWriter(IXmlStreaming $this$newWriter, Result result, boolean repairNamespaces) {
        Intrinsics.checkNotNullParameter($this$newWriter, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        return ((XmlStreamingJavaCommon) $this$newWriter).newWriter(result, repairNamespaces);
    }

    public static /* synthetic */ XmlWriter newWriter$default(IXmlStreaming iXmlStreaming, OutputStream outputStream, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return newWriter(iXmlStreaming, outputStream, str, z);
    }

    public static final XmlWriter newWriter(IXmlStreaming $this$newWriter, OutputStream outputStream, String encoding, boolean repairNamespaces) {
        Intrinsics.checkNotNullParameter($this$newWriter, "<this>");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return ((XmlStreaming) $this$newWriter).newWriter(outputStream, encoding, repairNamespaces);
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
        return ((XmlStreaming) $this$newWriter).newWriter(writer, repairNamespaces, xmlDeclMode);
    }

    public static final XmlReader newReader(IXmlStreaming $this$newReader, InputStream inputStream, String encoding) {
        Intrinsics.checkNotNullParameter($this$newReader, "<this>");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return ((XmlStreaming) $this$newReader).newReader(inputStream, encoding);
    }

    public static final XmlReader newReader(IXmlStreaming $this$newReader, Source source) {
        Intrinsics.checkNotNullParameter($this$newReader, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return ((XmlStreamingJavaCommon) $this$newReader).newReader(source);
    }
}