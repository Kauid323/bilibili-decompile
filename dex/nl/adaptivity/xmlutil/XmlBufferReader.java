package nl.adaptivity.xmlutil;

import java.util.List;
import java.util.NoSuchElementException;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.core.impl.NamespaceHolder;

/* compiled from: XmlBufferReader.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001f\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\tB\u001f\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0006\u0010A\u001a\u00020BJ\t\u0010C\u001a\u00020\u001fH\u0096\u0002J\t\u0010D\u001a\u00020\u0010H\u0096\u0002J\u0010\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u000eH\u0016J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u000eH\u0016J\u0010\u0010H\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u000eH\u0016J\u0010\u0010I\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u000eH\u0016J\u001c\u0010I\u001a\u0004\u0018\u00010\u00172\b\u0010J\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010\u00172\u0006\u0010L\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010M\u001a\u00020BH\u0016J\u001a\u0010N\u001a\u0002HO\"\n\b\u0000\u0010O\u0018\u0001*\u00020\u0004H\u0082\b¢\u0006\u0002\u0010PR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R\u0014\u0010!\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0019R\u0014\u0010%\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0015R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u00178VX\u0097\u0004¢\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0019R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\"\u00109\u001a\u0004\u0018\u00010\u00172\b\u00108\u001a\u0004\u0018\u00010\u0017@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0019R$\u0010;\u001a\u0004\u0018\u00010\u001f2\b\u00108\u001a\u0004\u0018\u00010\u001f@RX\u0096\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\"\u0010?\u001a\u0004\u0018\u00010\u00172\b\u00108\u001a\u0004\u0018\u00010\u0017@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0019¨\u0006Q"}, d2 = {"Lnl/adaptivity/xmlutil/XmlBufferReader;", "Lnl/adaptivity/xmlutil/XmlReader;", "buffer", "", "Lnl/adaptivity/xmlutil/XmlEvent;", "namespaceHolder", "Lnl/adaptivity/xmlutil/core/impl/NamespaceHolder;", "<init>", "(Ljava/util/List;Lnl/adaptivity/xmlutil/core/impl/NamespaceHolder;)V", "(Ljava/util/List;)V", "initialContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "(Ljava/util/List;Lnl/adaptivity/xmlutil/IterableNamespaceContext;)V", "currentPos", "", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "depth", "getDepth", "()I", "namespaceURI", "", "getNamespaceURI", "()Ljava/lang/String;", "localName", "getLocalName", "prefix", "getPrefix", "isStarted", "", "()Z", "text", "getText", "piTarget", "getPiTarget", "piData", "getPiData", "attributeCount", "getAttributeCount", "namespaceDecls", "Lnl/adaptivity/xmlutil/Namespace;", "getNamespaceDecls", "()Ljava/util/List;", "locationInfo", "getLocationInfo$annotations", "()V", "getLocationInfo", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getExtLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "namespaceContext", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "value", "encoding", "getEncoding", "standalone", "getStandalone", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "version", "getVersion", "reset", "", "hasNext", "next", "getAttributeNamespace", "index", "getAttributePrefix", "getAttributeLocalName", "getAttributeValue", "nsUri", "getNamespacePrefix", "namespaceUri", "close", "current", "T", "()Lnl/adaptivity/xmlutil/XmlEvent;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XmlBufferReader implements XmlReader {
    private final List<XmlEvent> buffer;
    private int currentPos;
    private String encoding;
    private final NamespaceHolder namespaceHolder;
    private Boolean standalone;
    private String version;

    @Deprecated(message = "Use extLocationInfo as that allows more detailed information", replaceWith = @ReplaceWith(expression = "extLocationInfo?.toString()", imports = {}))
    public static /* synthetic */ void getLocationInfo$annotations() {
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ QName getAttributeName(int i) {
        return XmlReader.CC.$default$getAttributeName(this, i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ String getAttributeValue(QName qName) {
        return XmlReader.CC.$default$getAttributeValue(this, qName);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ QName getName() {
        return XmlReader.CC.$default$getName(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isCharacters() {
        return XmlReader.CC.$default$isCharacters(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isEndElement() {
        return XmlReader.CC.$default$isEndElement(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isStartElement() {
        return XmlReader.CC.$default$isStartElement(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ boolean isWhitespace() {
        return XmlReader.CC.$default$isWhitespace(this);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ EventType nextTag() {
        return XmlReader.CC.$default$nextTag(this);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ void require(EventType eventType, String str, String str2) {
        XmlReader.CC.$default$require(this, eventType, str, str2);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ void require(EventType eventType, QName qName) {
        XmlReader.CC.$default$require(this, eventType, qName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private XmlBufferReader(List<? extends XmlEvent> list, NamespaceHolder namespaceHolder) {
        this.buffer = list;
        this.namespaceHolder = namespaceHolder;
        this.currentPos = -1;
        int p = 0;
        while (p < this.buffer.size() && this.buffer.get(p).getEventType() == EventType.IGNORABLE_WHITESPACE) {
            p++;
        }
        if (p >= this.buffer.size() || this.buffer.get(p).getEventType() != EventType.START_DOCUMENT) {
            return;
        }
        XmlEvent xmlEvent = this.buffer.get(p);
        Intrinsics.checkNotNull(xmlEvent, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartDocumentEvent");
        XmlEvent.StartDocumentEvent d = (XmlEvent.StartDocumentEvent) xmlEvent;
        this.encoding = d.getEncoding();
        this.version = d.getVersion();
        this.standalone = d.getStandalone();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XmlBufferReader(List<? extends XmlEvent> buffer) {
        this(buffer, new NamespaceHolder());
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XmlBufferReader(List<? extends XmlEvent> buffer, IterableNamespaceContext initialContext) {
        this(buffer, it);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(initialContext, "initialContext");
        NamespaceHolder it = new NamespaceHolder();
        it.addPrefixesToContext(initialContext);
        Unit unit = Unit.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType getEventType() {
        return this.buffer.get(this.currentPos).getEventType();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getDepth() {
        return this.namespaceHolder.getDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.NamedEvent) xmlEvent).getNamespaceUri();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.NamedEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocalName() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.NamedEvent) xmlEvent).getLocalName();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.NamedEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPrefix() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.NamedEvent) xmlEvent).getPrefix();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.NamedEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isStarted() {
        return this.currentPos >= 0;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getText() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.TextEvent) xmlEvent).getText();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.TextEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiTarget() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.ProcessingInstructionEvent) xmlEvent).getTarget();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.ProcessingInstructionEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiData() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.ProcessingInstructionEvent) xmlEvent).getData();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.ProcessingInstructionEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getAttributeCount() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.StartElementEvent) xmlEvent).getAttributes().length;
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public List<Namespace> getNamespaceDecls() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            Iterable it = ((XmlEvent.StartElementEvent) xmlEvent).getNamespaceDecls();
            List<Namespace> list = it instanceof List ? (List) it : null;
            return list == null ? CollectionsKt.toList(it) : list;
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocationInfo() {
        XmlReader.LocationInfo extLocationInfo = getExtLocationInfo();
        if (extLocationInfo != null) {
            return extLocationInfo.toString();
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public XmlReader.LocationInfo getExtLocationInfo() {
        return this.buffer.get(this.currentPos).getExtLocationInfo();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public IterableNamespaceContext getNamespaceContext() {
        return this.namespaceHolder.getNamespaceContext();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getEncoding() {
        return this.encoding;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public Boolean getStandalone() {
        return this.standalone;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getVersion() {
        return this.version;
    }

    public final void reset() {
        this.currentPos = -1;
        this.namespaceHolder.clear();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.util.Iterator
    public boolean hasNext() {
        return this.currentPos + 1 < this.buffer.size();
    }

    @Override // java.util.Iterator
    public EventType next() {
        List buffer = this.buffer;
        int cp = this.currentPos;
        if (cp >= 0 && (buffer.get(cp) instanceof XmlEvent.EndElementEvent)) {
            this.namespaceHolder.decDepth();
        }
        int cp2 = cp + 1;
        this.currentPos = cp2;
        if (cp2 >= buffer.size()) {
            throw new NoSuchElementException("Reading beyond the end of the reader");
        }
        XmlEvent current = buffer.get(cp2);
        if (current instanceof XmlEvent.StartElementEvent) {
            this.namespaceHolder.incDepth();
            this.namespaceHolder.addPrefixesToContext(((XmlEvent.StartElementEvent) current).getNamespaceDecls());
        }
        return current.getEventType();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeNamespace(int index) {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.StartElementEvent) xmlEvent).getAttributes()[index].getNamespaceUri();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributePrefix(int index) {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.StartElementEvent) xmlEvent).getAttributes()[index].getPrefix();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeLocalName(int index) {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.StartElementEvent) xmlEvent).getAttributes()[index].getLocalName();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(int index) {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            return ((XmlEvent.StartElementEvent) xmlEvent).getAttributes()[index].getValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(String nsUri, String localName) {
        XmlEvent.Attribute attribute;
        Intrinsics.checkNotNullParameter(localName, "localName");
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        if (xmlEvent != null) {
            XmlEvent.Attribute[] attributes = ((XmlEvent.StartElementEvent) xmlEvent).getAttributes();
            int length = attributes.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    attribute = null;
                    break;
                }
                attribute = attributes[i];
                boolean z = true;
                if (!(nsUri != null ? Intrinsics.areEqual(nsUri, attribute.getNamespaceUri()) : true) || !Intrinsics.areEqual(localName, attribute.getLocalName())) {
                    z = false;
                }
                if (z) {
                    break;
                }
                i++;
            }
            if (attribute != null) {
                return attribute.getValue();
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespacePrefix(String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        return this.namespaceHolder.getPrefix(namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return this.namespaceHolder.getNamespaceUri(prefix);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.currentPos = this.buffer.size();
    }

    private final /* synthetic */ <T extends XmlEvent> T current() {
        XmlEvent xmlEvent = this.buffer.get(this.currentPos);
        Intrinsics.reifiedOperationMarker(1, "T");
        return (T) xmlEvent;
    }
}