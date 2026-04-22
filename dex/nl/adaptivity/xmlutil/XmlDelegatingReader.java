package nl.adaptivity.xmlutil;

import java.util.List;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlReader;

/* compiled from: XmlDelegatingReader.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u001a\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\u0010\u0016\u001a\u00060\u0010j\u0002`\u0011H\u0096\u0001¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\fH\u0096\u0001J\u0013\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\fH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u0096\u0003J\t\u0010 \u001a\u00020\u001fH\u0096\u0001J\t\u0010!\u001a\u00020\u001fH\u0096\u0001J\t\u0010\"\u001a\u00020\u001fH\u0096\u0001J\t\u0010#\u001a\u00020\u001fH\u0096\u0001J\t\u0010$\u001a\u00020\bH\u0096\u0003J&\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0096\u0001¢\u0006\u0002\u0010'J%\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0096\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010)\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0014\u0010.\u001a\u0004\u0018\u00010\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0012\u00101\u001a\u00020\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u0001058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u00108\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u0012\u0010\u0019\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u00100R\u0016\u0010;\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b<\u00100R\u0018\u0010\u0016\u001a\u00060\u0010j\u0002`\u00118VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0012\u0010?\u001a\u00020@X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0018\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0012\u0010H\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u00100R\u0012\u0010I\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u00100R\u0012\u0010K\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u00100R\u0012\u0010\u001d\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u00100R\u0014\u0010N\u001a\u0004\u0018\u00010\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0012\u0010Q\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\bR\u00100R\u0014\u0010S\u001a\u0004\u0018\u00010\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u00100¨\u0006U"}, d2 = {"Lnl/adaptivity/xmlutil/XmlDelegatingReader;", "Lnl/adaptivity/xmlutil/XmlReader;", "delegate", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader;)V", "getDelegate", "()Lnl/adaptivity/xmlutil/XmlReader;", "nextTag", "Lnl/adaptivity/xmlutil/EventType;", "close", "", "getAttributeLocalName", "", "index", "", "getAttributeName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "(I)Ljavax/xml/namespace/QName;", "getAttributeNamespace", "getAttributePrefix", "getAttributeValue", "name", "(Ljavax/xml/namespace/QName;)Ljava/lang/String;", "nsUri", "localName", "getNamespacePrefix", "namespaceUri", "getNamespaceURI", "prefix", "hasNext", "", "isCharacters", "isEndElement", "isStartElement", "isWhitespace", "next", "require", "type", "(Lnl/adaptivity/xmlutil/EventType;Ljavax/xml/namespace/QName;)V", "namespace", "attributeCount", "getAttributeCount", "()I", "depth", "getDepth", "encoding", "getEncoding", "()Ljava/lang/String;", "eventType", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getExtLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "isStarted", "()Z", "getLocalName", "locationInfo", "getLocationInfo", "getName", "()Ljavax/xml/namespace/QName;", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "namespaceDecls", "", "Lnl/adaptivity/xmlutil/Namespace;", "getNamespaceDecls", "()Ljava/util/List;", "namespaceURI", "piData", "getPiData", "piTarget", "getPiTarget", "getPrefix", "standalone", "getStandalone", "()Ljava/lang/Boolean;", "text", "getText", "version", "getVersion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class XmlDelegatingReader implements XmlReader {
    private final XmlReader delegate;

    @Override // nl.adaptivity.xmlutil.XmlReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getAttributeCount() {
        return this.delegate.getAttributeCount();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeLocalName(int i) {
        return this.delegate.getAttributeLocalName(i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public QName getAttributeName(int i) {
        return this.delegate.getAttributeName(i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeNamespace(int i) {
        return this.delegate.getAttributeNamespace(i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributePrefix(int i) {
        return this.delegate.getAttributePrefix(i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(int i) {
        return this.delegate.getAttributeValue(i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(String str, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        return this.delegate.getAttributeValue(str, localName);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(QName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.delegate.getAttributeValue(name);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getDepth() {
        return this.delegate.getDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getEncoding() {
        return this.delegate.getEncoding();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType getEventType() {
        return this.delegate.getEventType();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public XmlReader.LocationInfo getExtLocationInfo() {
        return this.delegate.getExtLocationInfo();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocalName() {
        return this.delegate.getLocalName();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocationInfo() {
        return this.delegate.getLocationInfo();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public QName getName() {
        return this.delegate.getName();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public IterableNamespaceContext getNamespaceContext() {
        return this.delegate.getNamespaceContext();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public List<Namespace> getNamespaceDecls() {
        return this.delegate.getNamespaceDecls();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespacePrefix(String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        return this.delegate.getNamespacePrefix(namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI() {
        return this.delegate.getNamespaceURI();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this.delegate.getNamespaceURI(prefix);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiData() {
        return this.delegate.getPiData();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiTarget() {
        return this.delegate.getPiTarget();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPrefix() {
        return this.delegate.getPrefix();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public Boolean getStandalone() {
        return this.delegate.getStandalone();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getText() {
        return this.delegate.getText();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getVersion() {
        return this.delegate.getVersion();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.util.Iterator
    public boolean hasNext() {
        return this.delegate.hasNext();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isCharacters() {
        return this.delegate.isCharacters();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isEndElement() {
        return this.delegate.isEndElement();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isStartElement() {
        return this.delegate.isStartElement();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isStarted() {
        return this.delegate.isStarted();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isWhitespace() {
        return this.delegate.isWhitespace();
    }

    @Override // java.util.Iterator
    public EventType next() {
        return this.delegate.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public void require(EventType type, String str, String str2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.delegate.require(type, str, str2);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public void require(EventType type, QName qName) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.delegate.require(type, qName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public XmlDelegatingReader(XmlReader delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public XmlReader getDelegate() {
        return this.delegate;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType nextTag() {
        EventType eventType = next();
        while (true) {
            if ((eventType != EventType.TEXT || !isWhitespace()) && ((eventType != EventType.CDSECT || !isWhitespace()) && eventType != EventType.IGNORABLE_WHITESPACE && eventType != EventType.PROCESSING_INSTRUCTION && eventType != EventType.COMMENT)) {
                break;
            }
            eventType = next();
        }
        if (eventType != EventType.START_ELEMENT && eventType != EventType.END_ELEMENT) {
            throw new XmlException("expected start or end tag", null, 2, null);
        }
        return eventType;
    }
}