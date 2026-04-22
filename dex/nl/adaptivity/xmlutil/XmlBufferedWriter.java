package nl.adaptivity.xmlutil;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.NamespaceContext;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.core.impl.NamespaceHolder;
import nl.adaptivity.xmlutil.util.impl.CombiningNamespaceContext;

/* compiled from: XmlBufferedWriter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0002\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\u0015H\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010\u00152\b\u0010$\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010*\u001a\u0004\u0018\u00010\u00152\b\u0010#\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u0015H\u0002J\u001e\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0016J$\u0010.\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0016J+\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u00010\u00152\b\u00102\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0015H\u0016J\u0018\u00105\u001a\u00020\"2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H\u0016J\u0010\u00109\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0015H\u0016J,\u0010:\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010;\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010<\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0015H\u0016J\u0010\u0010=\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0015H\u0016J\u0010\u0010>\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0015H\u0016J\b\u0010@\u001a\u00020\"H\u0016J\b\u0010A\u001a\u00020\"H\u0016J\b\u0010B\u001a\u00020\"H\u0016J\u0006\u0010C\u001a\u00020DR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dX\u0096\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u0006E"}, d2 = {"Lnl/adaptivity/xmlutil/XmlBufferedWriter;", "Lnl/adaptivity/xmlutil/XmlWriter;", "buffer", "", "Lnl/adaptivity/xmlutil/XmlEvent;", "delegateNamespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "<init>", "(Ljava/util/List;Lnl/adaptivity/xmlutil/IterableNamespaceContext;)V", "(Ljava/util/List;)V", "_buffer", "", "getBuffer", "()Ljava/util/List;", "namespaceHolder", "Lnl/adaptivity/xmlutil/core/impl/NamespaceHolder;", "depth", "", "getDepth", "()I", "value", "", "indentString", "getIndentString", "()Ljava/lang/String;", "setIndentString", "(Ljava/lang/String;)V", "namespaceContext", "Ljavax/xml/namespace/NamespaceContext;", "Lnl/adaptivity/xmlutil/NamespaceContext;", "getNamespaceContext", "()Ljavax/xml/namespace/NamespaceContext;", "Ljavax/xml/namespace/NamespaceContext;", "setPrefix", "", "prefix", "namespaceUri", "getNamespaceUri", "getPrefix", "startTag", "namespace", "localName", "effectivePrefix", "effectiveNamespace", "namespaceAttr", "namespacePrefix", "endTag", "startDocument", "version", "encoding", "standalone", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "processingInstruction", "text", "target", "data", "docdecl", "attribute", "name", "comment", "cdsect", "entityRef", "ignorableWhitespace", "endDocument", "close", "flush", "reader", "Lnl/adaptivity/xmlutil/XmlBufferReader;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XmlBufferedWriter implements XmlWriter {
    private final List<XmlEvent> _buffer;
    private final NamespaceContext namespaceContext;
    private final NamespaceHolder namespaceHolder;

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ int getIndent() {
        return XmlWriter.CC.$default$getIndent(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void namespaceAttr(CharSequence charSequence, CharSequence charSequence2) {
        XmlWriter.CC.$default$namespaceAttr(this, charSequence, charSequence2);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void namespaceAttr(Namespace namespace) {
        XmlWriter.CC.$default$namespaceAttr(this, namespace);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void setIndent(int i) {
        XmlWriter.CC.$default$setIndent(this, i);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public /* synthetic */ void setPrefix(CharSequence charSequence, CharSequence charSequence2) {
        XmlWriter.CC.$default$setPrefix(this, charSequence, charSequence2);
    }

    private XmlBufferedWriter(List<XmlEvent> list, IterableNamespaceContext delegateNamespaceContext) {
        CombiningNamespaceContext combiningNamespaceContext;
        this._buffer = list;
        this.namespaceHolder = new NamespaceHolder();
        if (delegateNamespaceContext == null) {
            combiningNamespaceContext = this.namespaceHolder.getNamespaceContext();
        } else {
            combiningNamespaceContext = new CombiningNamespaceContext(this.namespaceHolder.getNamespaceContext(), delegateNamespaceContext);
        }
        this.namespaceContext = combiningNamespaceContext;
    }

    /* synthetic */ XmlBufferedWriter(ArrayList arrayList, IterableNamespaceContext iterableNamespaceContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, iterableNamespaceContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XmlBufferedWriter(List<XmlEvent> buffer) {
        this(buffer, null);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    public /* synthetic */ XmlBufferedWriter(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public final List<XmlEvent> getBuffer() {
        return this._buffer;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public int getDepth() {
        return this.namespaceHolder.getDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getIndentString() {
        return "";
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setIndentString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public NamespaceContext getNamespaceContext() {
        return this.namespaceContext;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void setPrefix(String prefix, String namespaceUri) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        this.namespaceHolder.addPrefixToContext(prefix, namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getNamespaceUri(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this.namespaceHolder.getNamespaceUri(prefix);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public String getPrefix(String namespaceUri) {
        if (namespaceUri != null) {
            String it = this.namespaceHolder.getPrefix(namespaceUri);
            return it;
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startTag(String namespace, String localName, String prefix) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        IterableNamespaceContext parentContext = this.namespaceHolder.getNamespaceContext().freeze();
        this.namespaceHolder.incDepth();
        String effNamespace = effectiveNamespace(namespace, prefix);
        String effPrefix = effectivePrefix(prefix, effNamespace);
        this._buffer.add(new XmlEvent.StartElementEvent((XmlReader.LocationInfo) null, effNamespace == null ? "" : effNamespace, localName, effPrefix == null ? "" : effPrefix, new XmlEvent.Attribute[0], parentContext, CollectionsKt.emptyList()));
    }

    private final String effectivePrefix(String prefix, String namespace) {
        if (prefix == null) {
            if (namespace != null) {
                String it = getNamespaceContext().getPrefix(namespace);
                return it;
            }
            return null;
        }
        return prefix;
    }

    private final String effectiveNamespace(String namespace, String prefix) {
        String str = namespace;
        if (str == null || str.length() == 0) {
            if (prefix != null) {
                String it = getNamespaceContext().getNamespaceURI(prefix);
                return it;
            }
            return null;
        }
        return namespace;
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void namespaceAttr(String namespacePrefix, String namespaceUri) {
        String localName;
        String prefix;
        Intrinsics.checkNotNullParameter(namespacePrefix, "namespacePrefix");
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        this.namespaceHolder.addPrefixToContext(namespacePrefix, namespaceUri);
        if (namespacePrefix.length() == 0) {
            localName = XMLConstants.XMLNS_ATTRIBUTE;
            prefix = "";
        } else {
            localName = namespacePrefix;
            prefix = XMLConstants.XMLNS_ATTRIBUTE;
        }
        this._buffer.add(new XmlEvent.Attribute((XmlReader.LocationInfo) null, XMLConstants.XMLNS_ATTRIBUTE_NS_URI, localName, prefix, namespaceUri));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endTag(String namespace, String localName, String prefix) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        String effNamespace = effectiveNamespace(namespace, prefix);
        String effectivePrefix = effectivePrefix(prefix, effNamespace);
        String effPrefix = effectivePrefix == null ? "" : effectivePrefix;
        this.namespaceHolder.decDepth();
        this._buffer.add(new XmlEvent.EndElementEvent((XmlReader.LocationInfo) null, effNamespace == null ? "" : effNamespace, localName, effPrefix, this.namespaceHolder.getNamespaceContext()));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void startDocument(String version, String encoding, Boolean standalone) {
        this._buffer.add(new XmlEvent.StartDocumentEvent((XmlReader.LocationInfo) null, encoding, version, standalone));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._buffer.add(new XmlEvent.ProcessingInstructionEvent((XmlReader.LocationInfo) null, text, ""));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String target, String data) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(data, "data");
        this._buffer.add(new XmlEvent.ProcessingInstructionEvent((XmlReader.LocationInfo) null, target, data));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void docdecl(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._buffer.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.DOCDECL, text));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void attribute(String namespace, String name, String prefix, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(namespace, XMLConstants.XMLNS_ATTRIBUTE_NS_URI) && !Intrinsics.areEqual(prefix, XMLConstants.XMLNS_ATTRIBUTE)) {
            String str = prefix;
            if (!(str == null || str.length() == 0) || !Intrinsics.areEqual(name, XMLConstants.XMLNS_ATTRIBUTE)) {
                String effNamespace = effectiveNamespace(namespace, prefix);
                String effPrefix = effectivePrefix(prefix, effNamespace);
                if (effPrefix == null) {
                    effPrefix = "";
                }
                this._buffer.add(new XmlEvent.Attribute((XmlReader.LocationInfo) null, effNamespace != null ? effNamespace : "", name, effPrefix, value));
                return;
            }
        }
        namespaceAttr(name, value);
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void comment(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._buffer.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.COMMENT, text));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void text(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._buffer.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.TEXT, text));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void cdsect(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._buffer.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.CDSECT, text));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void entityRef(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._buffer.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.ENTITY_REF, text));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void ignorableWhitespace(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._buffer.add(new XmlEvent.TextEvent((XmlReader.LocationInfo) null, EventType.IGNORABLE_WHITESPACE, text));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void endDocument() {
        this._buffer.add(new XmlEvent.EndDocumentEvent((XmlReader.LocationInfo) null));
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // nl.adaptivity.xmlutil.XmlWriter
    public void flush() {
    }

    public final XmlBufferReader reader() {
        return new XmlBufferReader(CollectionsKt.toList(getBuffer()));
    }
}