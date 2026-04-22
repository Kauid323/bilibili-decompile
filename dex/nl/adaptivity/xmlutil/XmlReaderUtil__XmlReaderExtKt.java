package nl.adaptivity.xmlutil;

import java.io.CharArrayWriter;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XmlReaderExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toCharArrayWriter", "Ljava/io/CharArrayWriter;", "Lnl/adaptivity/xmlutil/XmlReader;", "core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "nl/adaptivity/xmlutil/XmlReaderUtil")
public final /* synthetic */ class XmlReaderUtil__XmlReaderExtKt {
    public static final CharArrayWriter toCharArrayWriter(XmlReader $this$toCharArrayWriter) {
        Intrinsics.checkNotNullParameter($this$toCharArrayWriter, "<this>");
        CharArrayWriter it = new CharArrayWriter();
        Closeable $this$use$iv = XmlStreaming.newWriter$default(XmlStreaming.INSTANCE, (Appendable) it, false, (XmlDeclMode) null, 6, (Object) null);
        try {
            XmlWriter out = (XmlWriter) $this$use$iv;
            while ($this$toCharArrayWriter.hasNext()) {
                $this$toCharArrayWriter.next();
                XmlReaderUtil.writeCurrent($this$toCharArrayWriter, out);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally($this$use$iv, null);
            return it;
        } finally {
        }
    }
}