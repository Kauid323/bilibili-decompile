package nl.adaptivity.xmlutil;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XmlBufferedReader.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0015J\b\u0010\u0011\u001a\u00020\bH\u0015J\b\u0010\u0012\u001a\u00020\bH\u0015J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0015J\u0016\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0015J\b\u0010\u001a\u001a\u00020\u0014H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\n8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lnl/adaptivity/xmlutil/XmlBufferedReader;", "Lnl/adaptivity/xmlutil/XmlBufferedReaderBase;", "delegate", "Lnl/adaptivity/xmlutil/XmlReader;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader;)V", "peekBuffer", "Lkotlin/collections/ArrayDeque;", "Lnl/adaptivity/xmlutil/XmlEvent;", "hasPeekItems", "", "getHasPeekItems$annotations", "()V", "getHasPeekItems", "()Z", "peekFirst", "peekLast", "bufferRemoveLast", "bufferRemoveFirst", "pushBackCurrent", "", "add", "event", "addAll", "events", "", "close", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class XmlBufferedReader extends XmlBufferedReaderBase {
    private final ArrayDeque<XmlEvent> peekBuffer;

    /* compiled from: XmlBufferedReader.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @XmlUtilInternal
    public static /* synthetic */ void getHasPeekItems$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlBufferedReader(XmlReader delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.peekBuffer = new ArrayDeque<>();
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase, nl.adaptivity.xmlutil.XmlPeekingReader
    public boolean getHasPeekItems() {
        return !this.peekBuffer.isEmpty();
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase
    protected XmlEvent peekFirst() {
        return this.peekBuffer.firstOrNull();
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase
    @XmlUtilInternal
    protected XmlEvent peekLast() {
        return this.peekBuffer.lastOrNull();
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase
    @XmlUtilInternal
    protected XmlEvent bufferRemoveLast() {
        return this.peekBuffer.removeLast();
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase
    @XmlUtilInternal
    protected XmlEvent bufferRemoveFirst() {
        return this.peekBuffer.removeFirst();
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase, nl.adaptivity.xmlutil.XmlPeekingReader
    public void pushBackCurrent() {
        XmlEvent c = getCurrent();
        if (c == null) {
            throw new XmlException("Push back fails due to missing current element", null, 2, null);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[c.getEventType().ordinal()]) {
            case 1:
                decDepth();
                break;
            case 2:
                incDepth();
                break;
        }
        this.peekBuffer.addFirst(c);
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase
    @XmlUtilInternal
    protected void add(XmlEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.peekBuffer.addLast(event);
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase
    @XmlUtilInternal
    protected void addAll(Collection<? extends XmlEvent> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.peekBuffer.addAll(events);
    }

    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase, nl.adaptivity.xmlutil.XmlReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.peekBuffer.clear();
    }
}