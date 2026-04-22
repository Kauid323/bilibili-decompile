package nl.adaptivity.xmlutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.core.impl.NamespaceHolder;

/* compiled from: XmlBufferedReaderBase.kt */
@XmlUtilInternal
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u001e\n\u0002\b\r\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010'\u001a\u00020(H\u0004J\b\u0010)\u001a\u00020(H\u0004J\u0006\u0010N\u001a\u00020\u0012J\b\u0010O\u001a\u00020\u0012H\u0002J\b\u0010P\u001a\u0004\u0018\u00010\u0012J\n\u0010Q\u001a\u0004\u0018\u000104H\u0016J\b\u0010R\u001a\u00020(H&J\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00120CH\u0015J\t\u0010T\u001a\u00020\rH\u0086\u0002J\b\u0010U\u001a\u00020(H\u0005J\n\u0010V\u001a\u0004\u0018\u00010\u0012H$J\n\u0010W\u001a\u0004\u0018\u00010\u0012H%J\b\u0010X\u001a\u00020\u0012H%J\b\u0010Y\u001a\u00020\u0012H%J\u0010\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u0012H%J\u0016\u0010\\\u001a\u00020(2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00120^H%J\b\u0010_\u001a\u00020(H\u0016J\b\u0010`\u001a\u000204H\u0016J\u0006\u0010a\u001a\u00020\u0012J\t\u0010b\u001a\u000204H\u0096\u0002J\u0010\u0010c\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020$H\u0016J\u0010\u0010e\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020$H\u0016J\u0010\u0010f\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020$H\u0016J\u0010\u0010g\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020$H\u0016J\u001c\u0010g\u001a\u0004\u0018\u00010\u001c2\b\u0010h\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0012\u0010i\u001a\u0004\u0018\u00010\u001c2\u0006\u0010j\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\u001cH\u0016R\u001c\u0010\u0003\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0004@BX\u0085\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u001eR\u0014\u0010,\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u0014\u0010.\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001eR\u0014\u00100\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010&R\u0014\u00102\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0010R\u0014\u00103\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0007\u001a\u0004\b9\u0010\u001eR\u0016\u0010:\u001a\u0004\u0018\u00010;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010G\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u001eR\u0016\u0010I\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0016\u0010L\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u001e¨\u0006k"}, d2 = {"Lnl/adaptivity/xmlutil/XmlBufferedReaderBase;", "Lnl/adaptivity/xmlutil/XmlReader;", "Lnl/adaptivity/xmlutil/XmlPeekingReader;", "delegate", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader;)V", "getDelegate$core$annotations", "()V", "getDelegate$core", "()Lnl/adaptivity/xmlutil/XmlReader;", "namespaceHolder", "Lnl/adaptivity/xmlutil/core/impl/NamespaceHolder;", "hasPeekItems", "", "getHasPeekItems$annotations", "getHasPeekItems", "()Z", "value", "Lnl/adaptivity/xmlutil/XmlEvent;", "current", "getCurrent$annotations", "getCurrent", "()Lnl/adaptivity/xmlutil/XmlEvent;", "currentElement", "Lnl/adaptivity/xmlutil/XmlEvent$StartElementEvent;", "getCurrentElement", "()Lnl/adaptivity/xmlutil/XmlEvent$StartElementEvent;", "namespaceURI", "", "getNamespaceURI", "()Ljava/lang/String;", "localName", "getLocalName", "prefix", "getPrefix", "depth", "", "getDepth", "()I", "incDepth", "", "decDepth", "piTarget", "getPiTarget", "piData", "getPiData", "text", "getText", "attributeCount", "getAttributeCount", "isStarted", "eventType", "Lnl/adaptivity/xmlutil/EventType;", "getEventType", "()Lnl/adaptivity/xmlutil/EventType;", "locationInfo", "getLocationInfo$annotations", "getLocationInfo", "extLocationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "getExtLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "namespaceDecls", "", "Lnl/adaptivity/xmlutil/Namespace;", "getNamespaceDecls", "()Ljava/util/List;", "encoding", "getEncoding", "standalone", "getStandalone", "()Ljava/lang/Boolean;", "version", "getVersion", "nextEvent", "removeFirstToCurrent", "peek", "peekNextEvent", "pushBackCurrent", "doPeek", "hasNext", "stripWhiteSpaceFromPeekBuffer", "peekFirst", "peekLast", "bufferRemoveLast", "bufferRemoveFirst", "add", "event", "addAll", "events", "", "close", "nextTag", "nextTagEvent", "next", "getAttributeNamespace", "index", "getAttributePrefix", "getAttributeLocalName", "getAttributeValue", "nsUri", "getNamespacePrefix", "namespaceUri", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class XmlBufferedReaderBase implements XmlReader, XmlPeekingReader {
    private XmlEvent current;
    private final XmlReader delegate;
    private final NamespaceHolder namespaceHolder;

    /* compiled from: XmlBufferedReaderBase.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.ATTRIBUTE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.END_ELEMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.ENTITY_REF.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EventType.TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EventType.START_DOCUMENT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EventType.COMMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EventType.IGNORABLE_WHITESPACE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EventType.PROCESSING_INSTRUCTION.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @XmlUtilInternal
    protected static /* synthetic */ void getCurrent$annotations() {
    }

    @XmlUtilInternal
    public static /* synthetic */ void getDelegate$core$annotations() {
    }

    @XmlUtilInternal
    public static /* synthetic */ void getHasPeekItems$annotations() {
    }

    @Deprecated(message = "Use extLocationInfo as that allows more detailed information", replaceWith = @ReplaceWith(expression = "extLocationInfo?.toString()", imports = {}))
    public static /* synthetic */ void getLocationInfo$annotations() {
    }

    @XmlUtilInternal
    protected abstract void add(XmlEvent xmlEvent);

    @XmlUtilInternal
    protected abstract void addAll(Collection<? extends XmlEvent> collection);

    @XmlUtilInternal
    protected abstract XmlEvent bufferRemoveFirst();

    @XmlUtilInternal
    protected abstract XmlEvent bufferRemoveLast();

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ QName getAttributeName(int i) {
        return XmlReader.CC.$default$getAttributeName(this, i);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public /* synthetic */ String getAttributeValue(QName qName) {
        return XmlReader.CC.$default$getAttributeValue(this, qName);
    }

    public abstract boolean getHasPeekItems();

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

    protected abstract XmlEvent peekFirst();

    @XmlUtilInternal
    protected abstract XmlEvent peekLast();

    public abstract void pushBackCurrent();

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

    public XmlBufferedReaderBase(XmlReader delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.namespaceHolder = new NamespaceHolder();
        if (this.delegate.isStarted()) {
            this.namespaceHolder.addPrefixesToContext(this.delegate.getNamespaceContext());
        }
        if (this.delegate.isStarted()) {
            this.current = XmlEvent.Companion.from(this.delegate);
            if (this.current instanceof XmlEvent.StartElementEvent) {
                incDepth();
                return;
            }
            return;
        }
        this.current = null;
    }

    public final XmlReader getDelegate$core() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final XmlEvent getCurrent() {
        return this.current;
    }

    private final XmlEvent.StartElementEvent getCurrentElement() {
        XmlEvent xmlEvent = this.current;
        XmlEvent.StartElementEvent startElementEvent = xmlEvent instanceof XmlEvent.StartElementEvent ? (XmlEvent.StartElementEvent) xmlEvent : null;
        if (startElementEvent != null) {
            return startElementEvent;
        }
        throw new XmlException("Expected a start element, but did not find it.", null, 2, null);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI() {
        XmlEvent xmlEvent = this.current;
        EventType eventType = xmlEvent != null ? xmlEvent.getEventType() : null;
        switch (eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                XmlEvent xmlEvent2 = this.current;
                Intrinsics.checkNotNull(xmlEvent2, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.Attribute");
                return ((XmlEvent.Attribute) xmlEvent2).getNamespaceUri();
            case 2:
                XmlEvent xmlEvent3 = this.current;
                Intrinsics.checkNotNull(xmlEvent3, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
                return ((XmlEvent.StartElementEvent) xmlEvent3).getNamespaceUri();
            case 3:
                XmlEvent xmlEvent4 = this.current;
                Intrinsics.checkNotNull(xmlEvent4, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.EndElementEvent");
                return ((XmlEvent.EndElementEvent) xmlEvent4).getNamespaceUri();
            default:
                StringBuilder append = new StringBuilder().append("Attribute not defined here: namespaceUri (current event: ");
                XmlEvent xmlEvent5 = this.current;
                throw new XmlException(append.append(xmlEvent5 != null ? xmlEvent5.getEventType() : null).append(')').toString(), null, 2, null);
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getLocalName() {
        XmlEvent xmlEvent = this.current;
        EventType eventType = xmlEvent != null ? xmlEvent.getEventType() : null;
        switch (eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                XmlEvent xmlEvent2 = this.current;
                Intrinsics.checkNotNull(xmlEvent2, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.Attribute");
                return ((XmlEvent.Attribute) xmlEvent2).getLocalName();
            case 2:
                XmlEvent xmlEvent3 = this.current;
                Intrinsics.checkNotNull(xmlEvent3, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
                return ((XmlEvent.StartElementEvent) xmlEvent3).getLocalName();
            case 3:
                XmlEvent xmlEvent4 = this.current;
                Intrinsics.checkNotNull(xmlEvent4, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.EndElementEvent");
                return ((XmlEvent.EndElementEvent) xmlEvent4).getLocalName();
            case 4:
                XmlEvent xmlEvent5 = this.current;
                Intrinsics.checkNotNull(xmlEvent5, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.EntityRefEvent");
                return ((XmlEvent.EntityRefEvent) xmlEvent5).getLocalName();
            default:
                throw new XmlException("Attribute not defined here: localName", null, 2, null);
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPrefix() {
        XmlEvent xmlEvent = this.current;
        EventType eventType = xmlEvent != null ? xmlEvent.getEventType() : null;
        switch (eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                XmlEvent xmlEvent2 = this.current;
                Intrinsics.checkNotNull(xmlEvent2, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.Attribute");
                return ((XmlEvent.Attribute) xmlEvent2).getPrefix();
            case 2:
                XmlEvent xmlEvent3 = this.current;
                Intrinsics.checkNotNull(xmlEvent3, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
                return ((XmlEvent.StartElementEvent) xmlEvent3).getPrefix();
            case 3:
                XmlEvent xmlEvent4 = this.current;
                Intrinsics.checkNotNull(xmlEvent4, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.EndElementEvent");
                return ((XmlEvent.EndElementEvent) xmlEvent4).getPrefix();
            default:
                throw new XmlException("Attribute not defined here: prefix", null, 2, null);
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getDepth() {
        return this.namespaceHolder.getDepth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void incDepth() {
        this.namespaceHolder.incDepth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void decDepth() {
        this.namespaceHolder.decDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiTarget() {
        XmlEvent xmlEvent = this.current;
        Intrinsics.checkNotNull(xmlEvent, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.ProcessingInstructionEvent");
        return ((XmlEvent.ProcessingInstructionEvent) xmlEvent).getTarget();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getPiData() {
        XmlEvent xmlEvent = this.current;
        Intrinsics.checkNotNull(xmlEvent, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.ProcessingInstructionEvent");
        return ((XmlEvent.ProcessingInstructionEvent) xmlEvent).getData();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getText() {
        XmlEvent xmlEvent = this.current;
        Intrinsics.checkNotNull(xmlEvent);
        if (xmlEvent.getEventType() == EventType.ATTRIBUTE) {
            XmlEvent xmlEvent2 = this.current;
            Intrinsics.checkNotNull(xmlEvent2, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.Attribute");
            return ((XmlEvent.Attribute) xmlEvent2).getValue();
        }
        XmlEvent xmlEvent3 = this.current;
        Intrinsics.checkNotNull(xmlEvent3, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.TextEvent");
        return ((XmlEvent.TextEvent) xmlEvent3).getText();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public int getAttributeCount() {
        return getCurrentElement().getAttributes().length;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public boolean isStarted() {
        return this.current != null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType getEventType() {
        EventType eventType;
        XmlEvent xmlEvent = this.current;
        if (xmlEvent == null || (eventType = xmlEvent.getEventType()) == null) {
            if (hasNext()) {
                throw new XmlException("Attempting to get the event type before getting an event.", null, 2, null);
            }
            throw new XmlException("Attempting to read beyond the end of the stream", null, 2, null);
        }
        return eventType;
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
        XmlReader.LocationInfo extLocationInfo;
        XmlEvent xmlEvent = this.current;
        return (xmlEvent == null || (extLocationInfo = xmlEvent.getExtLocationInfo()) == null) ? this.delegate.getExtLocationInfo() : extLocationInfo;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public IterableNamespaceContext getNamespaceContext() {
        XmlEvent c = this.current;
        return c instanceof XmlEvent.StartElementEvent ? ((XmlEvent.StartElementEvent) c).getNamespaceContext() : c instanceof XmlEvent.EndElementEvent ? ((XmlEvent.EndElementEvent) c).getNamespaceContext() : this.namespaceHolder.getNamespaceContext();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public List<Namespace> getNamespaceDecls() {
        XmlEvent c = this.current;
        return c instanceof XmlEvent.StartElementEvent ? CollectionsKt.toList(((XmlEvent.StartElementEvent) c).getNamespaceDecls()) : this.namespaceHolder.getNamespacesAtCurrentDepth();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getEncoding() {
        String encoding;
        XmlEvent xmlEvent = this.current;
        XmlEvent.StartDocumentEvent startDocumentEvent = xmlEvent instanceof XmlEvent.StartDocumentEvent ? (XmlEvent.StartDocumentEvent) xmlEvent : null;
        return (startDocumentEvent == null || (encoding = startDocumentEvent.getEncoding()) == null) ? this.delegate.getEncoding() : encoding;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public Boolean getStandalone() {
        Boolean standalone;
        XmlEvent xmlEvent = this.current;
        XmlEvent.StartDocumentEvent startDocumentEvent = xmlEvent instanceof XmlEvent.StartDocumentEvent ? (XmlEvent.StartDocumentEvent) xmlEvent : null;
        return (startDocumentEvent == null || (standalone = startDocumentEvent.getStandalone()) == null) ? this.delegate.getStandalone() : standalone;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getVersion() {
        String version;
        XmlEvent xmlEvent = this.current;
        XmlEvent.StartDocumentEvent startDocumentEvent = xmlEvent instanceof XmlEvent.StartDocumentEvent ? (XmlEvent.StartDocumentEvent) xmlEvent : null;
        return (startDocumentEvent == null || (version = startDocumentEvent.getVersion()) == null) ? this.delegate.getVersion() : version;
    }

    public final XmlEvent nextEvent() {
        if (getHasPeekItems()) {
            return removeFirstToCurrent();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        peek();
        return removeFirstToCurrent();
    }

    private final XmlEvent removeFirstToCurrent() {
        XmlEvent event = bufferRemoveFirst();
        this.current = event;
        switch (WhenMappings.$EnumSwitchMapping$0[event.getEventType().ordinal()]) {
            case 2:
                this.namespaceHolder.incDepth();
                Intrinsics.checkNotNull(event, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.StartElementEvent");
                XmlEvent.StartElementEvent start = (XmlEvent.StartElementEvent) event;
                this.namespaceHolder.addPrefixesToContext(start.getNamespaceDecls());
                break;
            case 3:
                this.namespaceHolder.decDepth();
                break;
        }
        return event;
    }

    public final XmlEvent peek() {
        if (!getHasPeekItems()) {
            addAll(doPeek());
        }
        return peekFirst();
    }

    @Override // nl.adaptivity.xmlutil.XmlPeekingReader
    public EventType peekNextEvent() {
        XmlEvent peek = peek();
        if (peek != null) {
            return peek.getEventType();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @XmlUtilInternal
    public List<XmlEvent> doPeek() {
        if (this.delegate.hasNext()) {
            this.delegate.next();
            XmlEvent event = XmlEvent.Companion.from(this.delegate);
            ArrayList result = new ArrayList(1);
            result.add(event);
            return result;
        }
        return CollectionsKt.emptyList();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.util.Iterator
    public final boolean hasNext() {
        return getHasPeekItems() || peek() != null;
    }

    @XmlUtilInternal
    protected final void stripWhiteSpaceFromPeekBuffer() {
        while (getHasPeekItems()) {
            XmlEvent peekLast = peekLast();
            if ((peekLast instanceof XmlEvent.TextEvent) && XmlUtil.isXmlWhitespace(((XmlEvent.TextEvent) peekLast).getText())) {
                bufferRemoveLast();
            } else {
                return;
            }
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public EventType nextTag() {
        return nextTagEvent().getEventType();
    }

    public final XmlEvent nextTagEvent() {
        XmlEvent current = nextEvent();
        switch (WhenMappings.$EnumSwitchMapping$0[current.getEventType().ordinal()]) {
            case 2:
            case 3:
                return current;
            case 4:
            default:
                throw new XmlException("Unexpected element found when looking for tags: " + current, null, 2, null);
            case 5:
                Intrinsics.checkNotNull(current, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlEvent.TextEvent");
                if (XmlUtil.isXmlWhitespace(((XmlEvent.TextEvent) current).getText())) {
                    return nextTagEvent();
                }
                throw new XmlException("Unexpected element found when looking for tags: " + current, null, 2, null);
            case 6:
            case 7:
            case 8:
            case 9:
                return nextTagEvent();
        }
    }

    @Override // java.util.Iterator
    public EventType next() {
        return nextEvent().getEventType();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeNamespace(int index) {
        return getCurrentElement().getAttributes()[index].getNamespaceUri();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributePrefix(int index) {
        return getCurrentElement().getAttributes()[index].getPrefix();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeLocalName(int index) {
        return getCurrentElement().getAttributes()[index].getLocalName();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(int index) {
        return getCurrentElement().getAttributes()[index].getValue();
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getAttributeValue(String nsUri, String localName) {
        XmlEvent.Attribute attribute;
        Intrinsics.checkNotNullParameter(localName, "localName");
        XmlEvent.Attribute[] attributes = getCurrentElement().getAttributes();
        int length = attributes.length;
        int i = 0;
        while (true) {
            if (i < length) {
                attribute = attributes[i];
                if ((nsUri == null || Intrinsics.areEqual(nsUri, attribute.getNamespaceUri())) && Intrinsics.areEqual(localName, attribute.getLocalName())) {
                    break;
                }
                i++;
            } else {
                attribute = null;
                break;
            }
        }
        if (attribute != null) {
            return attribute.getValue();
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespacePrefix(String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        return getCurrentElement().getPrefix$core(namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return getCurrentElement().getNamespaceURI$core(prefix);
    }
}