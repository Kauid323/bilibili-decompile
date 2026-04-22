package nl.adaptivity.xmlutil;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.AppendableWriter;
import nl.adaptivity.xmlutil.core.impl.CharsequenceReaderKt;

/* compiled from: _XmlStreamingFactory.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH&J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0017J&\u0010\u0002\u001a\u00020\u00032\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017J(\u0010\u0002\u001a\u00020\u00032\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlStreamingFactory;", "", "newWriter", "Lnl/adaptivity/xmlutil/XmlWriter;", "writer", "Ljava/io/Writer;", "repairNamespaces", "", "omitXmlDecl", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "outputStream", "Ljava/io/OutputStream;", "encoding", "", "result", "Ljavax/xml/transform/Result;", "output", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "newReader", "Lnl/adaptivity/xmlutil/XmlReader;", "source", "Ljavax/xml/transform/Source;", "reader", "Ljava/io/Reader;", "inputStream", "Ljava/io/InputStream;", "input", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlStreamingFactory {
    XmlReader newReader(InputStream inputStream);

    XmlReader newReader(InputStream inputStream, String str);

    XmlReader newReader(Reader reader);

    XmlReader newReader(CharSequence charSequence);

    XmlReader newReader(String str);

    @Deprecated(message = "Sources are deprecated (only partially supported)")
    XmlReader newReader(Source source);

    XmlWriter newWriter(OutputStream outputStream, String str, boolean z, XmlDeclMode xmlDeclMode);

    @Deprecated(message = "Use version with xmlDeclMode")
    XmlWriter newWriter(OutputStream outputStream, String str, boolean z, boolean z2);

    XmlWriter newWriter(Writer writer, boolean z, XmlDeclMode xmlDeclMode);

    @Deprecated(message = "Use version with xmlDeclMode")
    XmlWriter newWriter(Writer writer, boolean z, boolean z2);

    XmlWriter newWriter(Appendable appendable, boolean z, XmlDeclMode xmlDeclMode);

    @Deprecated(message = "Use version with xmlDeclMode")
    XmlWriter newWriter(Appendable appendable, boolean z, boolean z2);

    @Deprecated(message = "Usage of results only works on the JVM")
    XmlWriter newWriter(Result result, boolean z, XmlDeclMode xmlDeclMode);

    @Deprecated(message = "Usage of results only works on the JVM")
    XmlWriter newWriter(Result result, boolean z, boolean z2);

    /* compiled from: _XmlStreamingFactory.kt */
    /* renamed from: nl.adaptivity.xmlutil.XmlStreamingFactory$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, Writer writer, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return xmlStreamingFactory.newWriter(writer, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        @Deprecated(message = "Use version with xmlDeclMode")
        public static XmlWriter $default$newWriter(XmlStreamingFactory _this, Writer writer, boolean repairNamespaces, boolean omitXmlDecl) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            return _this.newWriter(writer, repairNamespaces, XmlDeclMode.Companion.from(omitXmlDecl));
        }

        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, Writer writer, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    xmlDeclMode = XmlDeclMode.None;
                }
                return xmlStreamingFactory.newWriter(writer, z, xmlDeclMode);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, OutputStream outputStream, String str, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return xmlStreamingFactory.newWriter(outputStream, str, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        @Deprecated(message = "Use version with xmlDeclMode")
        public static XmlWriter $default$newWriter(XmlStreamingFactory _this, OutputStream outputStream, String encoding, boolean repairNamespaces, boolean omitXmlDecl) {
            Intrinsics.checkNotNullParameter(outputStream, "outputStream");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            return _this.newWriter(outputStream, encoding, repairNamespaces, XmlDeclMode.Companion.from(omitXmlDecl));
        }

        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, OutputStream outputStream, String str, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                if ((i & 8) != 0) {
                    xmlDeclMode = XmlDeclMode.None;
                }
                return xmlStreamingFactory.newWriter(outputStream, str, z, xmlDeclMode);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, Result result, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return xmlStreamingFactory.newWriter(result, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        @Deprecated(message = "Usage of results only works on the JVM")
        public static XmlWriter $default$newWriter(XmlStreamingFactory _this, Result result, boolean repairNamespaces, boolean omitXmlDecl) {
            Intrinsics.checkNotNullParameter(result, "result");
            return _this.newWriter(result, repairNamespaces, XmlDeclMode.Companion.from(omitXmlDecl));
        }

        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, Result result, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    xmlDeclMode = XmlDeclMode.None;
                }
                return xmlStreamingFactory.newWriter(result, z, xmlDeclMode);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        @Deprecated(message = "Usage of results only works on the JVM")
        public static XmlWriter $default$newWriter(XmlStreamingFactory _this, Result result, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
            throw new UnsupportedOperationException("Results are not supported by this factory");
        }

        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, Appendable appendable, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return xmlStreamingFactory.newWriter(appendable, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        @Deprecated(message = "Use version with xmlDeclMode")
        public static XmlWriter $default$newWriter(XmlStreamingFactory _this, Appendable output, boolean repairNamespaces, boolean omitXmlDecl) {
            Intrinsics.checkNotNullParameter(output, "output");
            return _this.newWriter((Writer) new AppendableWriter(output), repairNamespaces, XmlDeclMode.Companion.from(omitXmlDecl));
        }

        public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingFactory xmlStreamingFactory, Appendable appendable, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    xmlDeclMode = XmlDeclMode.None;
                }
                return xmlStreamingFactory.newWriter(appendable, z, xmlDeclMode);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
        }

        public static XmlWriter $default$newWriter(XmlStreamingFactory _this, Appendable output, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
            return _this.newWriter((Writer) new AppendableWriter(output), repairNamespaces, xmlDeclMode);
        }

        @Deprecated(message = "Sources are deprecated (only partially supported)")
        public static XmlReader $default$newReader(XmlStreamingFactory _this, Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            throw new UnsupportedOperationException("Sources are not supported by this factory");
        }

        public static XmlReader $default$newReader(XmlStreamingFactory _this, InputStream inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            return _this.newReader(inputStream, "UTF-8");
        }

        public static /* synthetic */ XmlReader newReader$default(XmlStreamingFactory xmlStreamingFactory, InputStream inputStream, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "UTF-8";
                }
                return xmlStreamingFactory.newReader(inputStream, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newReader");
        }

        public static XmlReader $default$newReader(XmlStreamingFactory _this, CharSequence input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return _this.newReader(CharsequenceReaderKt.CharsequenceReader(input));
        }

        public static XmlReader $default$newReader(XmlStreamingFactory _this, String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return _this.newReader(new StringReader(input));
        }
    }
}