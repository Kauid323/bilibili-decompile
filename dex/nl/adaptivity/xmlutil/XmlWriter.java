package nl.adaptivity.xmlutil;

import java.io.Closeable;
import javax.xml.namespace.NamespaceContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nl.adaptivity.xmlutil.core.internal.StringUtilKt;

/* compiled from: XmlWriter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0017J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH&J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0017J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH&J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0013H&J\b\u0010\u001c\u001a\u00020\u0013H&J$\u0010\u001d\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH&J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH&J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH&J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH&J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH&J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH&J,\u0010'\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010(\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\bH&J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH&J1\u0010*\u001a\u00020\u00132\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H&¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u0013H&J$\u00101\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH&J\u0012\u00107\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\bH&J\u0014\u00108\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00048W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011R\u0016\u00102\u001a\u000603j\u0002`4X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00069À\u0006\u0003"}, d2 = {"Lnl/adaptivity/xmlutil/XmlWriter;", "Ljava/io/Closeable;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Closeable;", "depth", "", "getDepth", "()I", "indentString", "", "getIndentString", "()Ljava/lang/String;", "setIndentString", "(Ljava/lang/String;)V", "value", "indent", "getIndent", "setIndent", "(I)V", "setPrefix", "", "prefix", "", "namespaceUri", "namespaceAttr", "namespacePrefix", "namespace", "Lnl/adaptivity/xmlutil/Namespace;", "close", "flush", "startTag", "localName", "comment", "text", "cdsect", "entityRef", "processingInstruction", "target", "data", "ignorableWhitespace", "attribute", "name", "docdecl", "startDocument", "version", "encoding", "standalone", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "endDocument", "endTag", "namespaceContext", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "getNamespaceContext", "()Ljavax/xml/namespace/NamespaceContext;", "getNamespaceUri", "getPrefix", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlWriter extends Closeable {
    void attribute(String str, String str2, String str3, String str4);

    void cdsect(String str);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void comment(String str);

    void docdecl(String str);

    void endDocument();

    void endTag(String str, String str2, String str3);

    void entityRef(String str);

    void flush();

    int getDepth();

    @Deprecated(message = "Use indentString for better accuracy")
    int getIndent();

    String getIndentString();

    NamespaceContext getNamespaceContext();

    String getNamespaceUri(String str);

    String getPrefix(String str);

    void ignorableWhitespace(String str);

    @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "namespaceAttr(namespacePrefix.toString(), namespaceUri.toString())", imports = {}))
    void namespaceAttr(CharSequence charSequence, CharSequence charSequence2);

    void namespaceAttr(String str, String str2);

    void namespaceAttr(Namespace namespace);

    void processingInstruction(String str);

    void processingInstruction(String str, String str2);

    void setIndent(int i);

    void setIndentString(String str);

    @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "setPrefix(prefix.toString(), namespaceUri.toString())", imports = {}))
    void setPrefix(CharSequence charSequence, CharSequence charSequence2);

    void setPrefix(String str, String str2);

    void startDocument(String str, String str2, Boolean bool);

    void startTag(String str, String str2, String str3);

    void text(String str);

    /* compiled from: XmlWriter.kt */
    /* renamed from: nl.adaptivity.xmlutil.XmlWriter$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        @Deprecated(message = "Use indentString for better accuracy")
        public static int $default$getIndent(XmlWriter _this) {
            return StringUtilKt.countIndentedLength(_this.getIndentString());
        }

        public static void $default$setIndent(XmlWriter _this, int value) {
            _this.setIndentString(StringsKt.repeat(" ", value));
        }

        @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "setPrefix(prefix.toString(), namespaceUri.toString())", imports = {}))
        public static void $default$setPrefix(XmlWriter _this, CharSequence prefix, CharSequence namespaceUri) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            _this.setPrefix(prefix.toString(), namespaceUri.toString());
        }

        @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "namespaceAttr(namespacePrefix.toString(), namespaceUri.toString())", imports = {}))
        public static void $default$namespaceAttr(XmlWriter _this, CharSequence namespacePrefix, CharSequence namespaceUri) {
            Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            _this.namespaceAttr(namespacePrefix.toString(), namespaceUri.toString());
        }

        public static void $default$namespaceAttr(XmlWriter _this, Namespace namespace) {
            Intrinsics.checkNotNullParameter(namespace, "namespace");
            _this.namespaceAttr(namespace.getPrefix(), namespace.getNamespaceURI());
        }

        public static void $default$processingInstruction(XmlWriter _this, String target, String data) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(data, "data");
            _this.processingInstruction(target + ' ' + data);
        }

        public static /* synthetic */ void startDocument$default(XmlWriter xmlWriter, String str, String str2, Boolean bool, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDocument");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                bool = null;
            }
            xmlWriter.startDocument(str, str2, bool);
        }
    }

    /* compiled from: XmlWriter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        @Deprecated(message = "Use indentString for better accuracy")
        @Deprecated
        public static int getIndent(XmlWriter $this) {
            return CC.$default$getIndent($this);
        }

        @Deprecated
        public static void setIndent(XmlWriter $this, int value) {
            CC.$default$setIndent($this, value);
        }

        @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "setPrefix(prefix.toString(), namespaceUri.toString())", imports = {}))
        @Deprecated
        public static void setPrefix(XmlWriter $this, CharSequence prefix, CharSequence namespaceUri) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            CC.$default$setPrefix($this, prefix, namespaceUri);
        }

        @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "namespaceAttr(namespacePrefix.toString(), namespaceUri.toString())", imports = {}))
        @Deprecated
        public static void namespaceAttr(XmlWriter $this, CharSequence namespacePrefix, CharSequence namespaceUri) {
            Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
            Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
            CC.$default$namespaceAttr($this, namespacePrefix, namespaceUri);
        }

        @Deprecated
        public static void namespaceAttr(XmlWriter $this, Namespace namespace) {
            Intrinsics.checkNotNullParameter(namespace, "namespace");
            CC.$default$namespaceAttr($this, namespace);
        }

        @Deprecated
        public static void processingInstruction(XmlWriter $this, String target, String data) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(data, "data");
            CC.$default$processingInstruction($this, target, data);
        }
    }
}