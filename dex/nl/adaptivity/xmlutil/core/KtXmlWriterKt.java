package nl.adaptivity.xmlutil.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.EventType;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlReader;

/* compiled from: KtXmlWriter.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\bH\u0000¨\u0006\t"}, d2 = {"joinRepeated", "", "Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "", "repeats", "", "asCodePoints", "Lkotlin/UInt;", "", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KtXmlWriterKt {
    private static final List<XmlEvent.TextEvent> joinRepeated(Iterable<? extends XmlEvent.TextEvent> iterable, int repeats) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            List result = new ArrayList();
            XmlEvent.TextEvent pending = null;
            for (int i = 0; i < repeats; i++) {
                for (XmlEvent.TextEvent ev : iterable) {
                    if (pending == null) {
                        pending = ev;
                    } else if (pending.getEventType() == EventType.COMMENT || pending.getEventType() != ev.getEventType()) {
                        result.add(pending);
                        pending = ev;
                    } else if (ev.getEventType() == pending.getEventType()) {
                        pending = new XmlEvent.TextEvent((XmlReader.LocationInfo) null, pending.getEventType(), pending.getText() + ev.getText());
                    }
                }
            }
            if (pending != null) {
                result.add(pending);
            }
            return result;
        }
        return CollectionsKt.emptyList();
    }

    public static final Iterable<UInt> asCodePoints(CharSequence $this$asCodePoints) {
        Intrinsics.checkNotNullParameter($this$asCodePoints, "<this>");
        return new KtXmlWriterKt$asCodePoints$1($this$asCodePoints);
    }
}