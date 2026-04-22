package nl.adaptivity.xmlutil;

import javax.xml.namespace.NamespaceContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XmlDelegatingWriter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096\u0001J\t\u0010\u0010\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096\u0001J\t\u0010\u0013\u001a\u00020\bH\u0096\u0001J%\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096\u0001J\t\u0010\u0017\u001a\u00020\bH\u0096\u0001J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001dH\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001fH\u0097\u0001J\u0019\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0096\u0001J\u0019\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0096\u0001J\u0011\u0010 \u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096\u0001J\u0019\u0010#\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001fH\u0097\u0001J\u0019\u0010#\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0096\u0001J,\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0001¢\u0006\u0002\u0010)J%\u0010*\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010+\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R$\u0010/\u001a\u00020,2\u0006\u0010\r\u001a\u00020,8W@VX\u0096\u000f¢\u0006\f\u001a\u0004\b0\u0010.\"\u0004\b1\u00102R\u0018\u00103\u001a\u00020\nX\u0096\u000f¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u000609j\u0002`:X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"Lnl/adaptivity/xmlutil/XmlDelegatingWriter;", "Lnl/adaptivity/xmlutil/XmlWriter;", "delegate", "<init>", "(Lnl/adaptivity/xmlutil/XmlWriter;)V", "getDelegate", "()Lnl/adaptivity/xmlutil/XmlWriter;", "attribute", "", "namespace", "", "name", "prefix", "value", "cdsect", "text", "close", "comment", "docdecl", "endDocument", "endTag", "localName", "entityRef", "flush", "getNamespaceUri", "getPrefix", "namespaceUri", "ignorableWhitespace", "namespaceAttr", "Lnl/adaptivity/xmlutil/Namespace;", "namespacePrefix", "", "processingInstruction", "target", "data", "setPrefix", "startDocument", "version", "encoding", "standalone", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "startTag", "depth", "", "getDepth", "()I", "indent", "getIndent", "setIndent", "(I)V", "indentString", "getIndentString", "()Ljava/lang/String;", "setIndentString", "(Ljava/lang/String;)V", "namespaceContext", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "getNamespaceContext", "()Ljavax/xml/namespace/NamespaceContext;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class XmlDelegatingWriter implements XmlWriter {
    private final XmlWriter delegate;

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void attribute(String str, String name, String str2, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.attribute(str, name, str2, value);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void cdsect(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.delegate.cdsect(text);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void comment(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.delegate.comment(text);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void docdecl(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.delegate.docdecl(text);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endDocument() {
        this.delegate.endDocument();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endTag(String str, String localName, String str2) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        this.delegate.endTag(str, localName, str2);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void entityRef(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.delegate.entityRef(text);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void flush() {
        this.delegate.flush();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public int getDepth() {
        return this.delegate.getDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    @Deprecated(message = "Use indentString for better accuracy")
    public int getIndent() {
        return this.delegate.getIndent();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getIndentString() {
        return this.delegate.getIndentString();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public NamespaceContext getNamespaceContext() {
        return this.delegate.getNamespaceContext();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getNamespaceUri(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this.delegate.getNamespaceUri(prefix);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getPrefix(String str) {
        return this.delegate.getPrefix(str);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void ignorableWhitespace(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.delegate.ignorableWhitespace(text);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "namespaceAttr(namespacePrefix.toString(), namespaceUri.toString())", imports = {}))
    public void namespaceAttr(CharSequence namespacePrefix, CharSequence namespaceUri) {
        Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        this.delegate.namespaceAttr(namespacePrefix, namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void namespaceAttr(String namespacePrefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        this.delegate.namespaceAttr(namespacePrefix, namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void namespaceAttr(Namespace namespace) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        this.delegate.namespaceAttr(namespace);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.delegate.processingInstruction(text);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String target, String data) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(data, "data");
        this.delegate.processingInstruction(target, data);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setIndent(int i) {
        this.delegate.setIndent(i);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setIndentString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.delegate.setIndentString(str);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    @Deprecated(message = "Use the version that takes strings", replaceWith = @ReplaceWith(expression = "setPrefix(prefix.toString(), namespaceUri.toString())", imports = {}))
    public void setPrefix(CharSequence prefix, CharSequence namespaceUri) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        this.delegate.setPrefix(prefix, namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setPrefix(String prefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        this.delegate.setPrefix(prefix, namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startDocument(String str, String str2, Boolean bool) {
        this.delegate.startDocument(str, str2, bool);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startTag(String str, String localName, String str2) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        this.delegate.startTag(str, localName, str2);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void text(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.delegate.text(text);
    }

    public XmlDelegatingWriter(XmlWriter delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    protected final XmlWriter getDelegate() {
        return this.delegate;
    }
}